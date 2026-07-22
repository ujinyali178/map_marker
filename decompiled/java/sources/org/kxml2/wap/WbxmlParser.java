package org.kxml2.wap;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /root/release/classes2.dex */
public class WbxmlParser implements XmlPullParser {
    static final String HEX_DIGITS = "0123456789abcdef";
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    public static final int WAP_EXTENSION = 64;
    private String[] attrStartTable;
    private String[] attrValueTable;
    private int attributeCount;
    private boolean degenerated;
    private int depth;
    private String encoding;
    private InputStream in;
    private boolean isWhitespace;
    private String name;
    private String namespace;
    private String prefix;
    private boolean processNsp;
    private int publicIdentifierId;
    private byte[] stringTable;
    private String[] tagTable;
    private String text;
    private int type;
    private int version;
    private int wapCode;
    private Object wapExtensionData;
    private int TAG_TABLE = 0;
    private int ATTR_START_TABLE = 1;
    private int ATTR_VALUE_TABLE = 2;
    private Hashtable cacheStringTable = null;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private String[] attributes = new String[16];
    private int nextId = -2;
    private Vector tables = new Vector();

    private final boolean adjustNsp() {
        int i3;
        String str;
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            i3 = this.attributeCount;
            if (i4 >= (i3 << 2)) {
                break;
            }
            String str2 = this.attributes[i4 + 2];
            int indexOf = str2.indexOf(58);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                str = str2.substring(indexOf + 1);
                str2 = substring;
            } else if (str2.equals("xmlns")) {
                str = null;
            } else {
                i4 += 4;
            }
            if (str2.equals("xmlns")) {
                int[] iArr = this.nspCounts;
                int i5 = this.depth;
                int i6 = iArr[i5];
                iArr[i5] = i6 + 1;
                int i7 = i6 << 1;
                String[] ensureCapacity = ensureCapacity(this.nspStack, i7 + 2);
                this.nspStack = ensureCapacity;
                ensureCapacity[i7] = str;
                String[] strArr = this.attributes;
                int i8 = i4 + 3;
                ensureCapacity[i7 + 1] = strArr[i8];
                if (str != null && strArr[i8].equals("")) {
                    exception("illegal empty namespace");
                }
                String[] strArr2 = this.attributes;
                int i9 = this.attributeCount - 1;
                this.attributeCount = i9;
                System.arraycopy(strArr2, i4 + 4, strArr2, i4, (i9 << 2) - i4);
                i4 -= 4;
            } else {
                z3 = true;
            }
            i4 += 4;
        }
        if (z3) {
            for (int i10 = (i3 << 2) - 4; i10 >= 0; i10 -= 4) {
                int i11 = i10 + 2;
                String str3 = this.attributes[i11];
                int indexOf2 = str3.indexOf(58);
                if (indexOf2 == 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal attribute name: ");
                    stringBuffer.append(str3);
                    stringBuffer.append(" at ");
                    stringBuffer.append(this);
                    throw new RuntimeException(stringBuffer.toString());
                }
                if (indexOf2 != -1) {
                    String substring2 = str3.substring(0, indexOf2);
                    String substring3 = str3.substring(indexOf2 + 1);
                    String namespace = getNamespace(substring2);
                    if (namespace == null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Undefined Prefix: ");
                        stringBuffer2.append(substring2);
                        stringBuffer2.append(" in ");
                        stringBuffer2.append(this);
                        throw new RuntimeException(stringBuffer2.toString());
                    }
                    String[] strArr3 = this.attributes;
                    strArr3[i10] = namespace;
                    strArr3[i10 + 1] = substring2;
                    strArr3[i11] = substring3;
                    for (int i12 = (this.attributeCount << 2) - 4; i12 > i10; i12 -= 4) {
                        if (substring3.equals(this.attributes[i12 + 2]) && namespace.equals(this.attributes[i12])) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("Duplicate Attribute: {");
                            stringBuffer3.append(namespace);
                            stringBuffer3.append("}");
                            stringBuffer3.append(substring3);
                            exception(stringBuffer3.toString());
                        }
                    }
                }
            }
        }
        int indexOf3 = this.name.indexOf(58);
        if (indexOf3 == 0) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("illegal tag name: ");
            stringBuffer4.append(this.name);
            exception(stringBuffer4.toString());
        } else if (indexOf3 != -1) {
            this.prefix = this.name.substring(0, indexOf3);
            this.name = this.name.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("undefined prefix: ");
                stringBuffer5.append(this.prefix);
                exception(stringBuffer5.toString());
            }
            this.namespace = "";
        }
        return z3;
    }

    private final String[] ensureCapacity(String[] strArr, int i3) {
        if (strArr.length >= i3) {
            return strArr;
        }
        String[] strArr2 = new String[i3 + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void exception(String str) {
        throw new XmlPullParserException(str, this, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void nextImpl() {
        /*
            r4 = this;
            int r0 = r4.type
            r1 = 3
            r2 = 1
            if (r0 != r1) goto Lb
            int r0 = r4.depth
            int r0 = r0 - r2
            r4.depth = r0
        Lb:
            boolean r0 = r4.degenerated
            if (r0 == 0) goto L15
            r4.type = r1
            r0 = 0
            r4.degenerated = r0
            return
        L15:
            r0 = 0
            r4.text = r0
            r4.prefix = r0
            r4.name = r0
        L1c:
            int r0 = r4.peekId()
            r3 = -2
            r4.nextId = r3
            if (r0 != 0) goto L2d
            int r0 = r4.readByte()
            r4.selectPage(r0, r2)
            goto L1c
        L2d:
            r3 = -1
            if (r0 == r3) goto Laf
            r3 = 2
            if (r0 == r2) goto L97
            if (r0 == r3) goto L6a
            r2 = 4
            if (r0 == r1) goto L61
            switch(r0) {
                case 64: goto L54;
                case 65: goto L54;
                case 66: goto L54;
                case 67: goto L4c;
                default: goto L3b;
            }
        L3b:
            switch(r0) {
                case 128: goto L54;
                case 129: goto L54;
                case 130: goto L54;
                case 131: goto L45;
                default: goto L3e;
            }
        L3e:
            switch(r0) {
                case 192: goto L54;
                case 193: goto L54;
                case 194: goto L54;
                case 195: goto L54;
                default: goto L41;
            }
        L41:
            r4.parseElement(r0)
            goto Lb1
        L45:
            r4.type = r2
            java.lang.String r0 = r4.readStrT()
            goto L67
        L4c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "PI curr. not supp."
            r0.<init>(r1)
            throw r0
        L54:
            r1 = 64
            r4.type = r1
            r4.wapCode = r0
            java.lang.Object r0 = r4.parseWapExtension(r0)
            r4.wapExtensionData = r0
            goto Lb1
        L61:
            r4.type = r2
            java.lang.String r0 = r4.readStrI()
        L67:
            r4.text = r0
            goto Lb1
        L6a:
            r0 = 6
            r4.type = r0
            int r0 = r4.readInt()
            char r0 = (char) r0
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r4.text = r1
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "#"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto Lac
        L97:
            int r0 = r4.depth
            int r0 = r0 - r2
            int r0 = r0 << r3
            r4.type = r1
            java.lang.String[] r1 = r4.elementStack
            r2 = r1[r0]
            r4.namespace = r2
            int r2 = r0 + 1
            r2 = r1[r2]
            r4.prefix = r2
            int r0 = r0 + r3
            r0 = r1[r0]
        Lac:
            r4.name = r0
            goto Lb1
        Laf:
            r4.type = r2
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.wap.WbxmlParser.nextImpl():void");
    }

    private int peekId() {
        if (this.nextId == -2) {
            this.nextId = this.in.read();
        }
        return this.nextId;
    }

    private void selectPage(int i3, boolean z3) {
        if (this.tables.size() == 0 && i3 == 0) {
            return;
        }
        int i4 = i3 * 3;
        if (i4 > this.tables.size()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Code Page ");
            stringBuffer.append(i3);
            stringBuffer.append(" undefined!");
            exception(stringBuffer.toString());
        }
        Vector vector = this.tables;
        if (z3) {
            this.tagTable = (String[]) vector.elementAt(i4 + this.TAG_TABLE);
        } else {
            this.attrStartTable = (String[]) vector.elementAt(this.ATTR_START_TABLE + i4);
            this.attrValueTable = (String[]) this.tables.elementAt(i4 + this.ATTR_VALUE_TABLE);
        }
    }

    private final void setTable(int i3, int i4, String[] strArr) {
        if (this.stringTable != null) {
            throw new RuntimeException("setXxxTable must be called before setInput!");
        }
        while (true) {
            int i5 = i3 * 3;
            if (this.tables.size() >= i5 + 3) {
                this.tables.setElementAt(strArr, i5 + i4);
                return;
            }
            this.tables.addElement(null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        return this.attributeCount;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i3) {
        if (i3 < this.attributeCount) {
            return this.attributes[(i3 << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i3) {
        if (i3 < this.attributeCount) {
            return this.attributes[i3 << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i3) {
        if (i3 < this.attributeCount) {
            return this.attributes[(i3 << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i3) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i3) {
        if (i3 < this.attributeCount) {
            return this.attributes[(i3 << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        for (int i3 = (this.attributeCount << 2) - 4; i3 >= 0; i3 -= 4) {
            if (this.attributes[i3 + 2].equals(str2) && (str == null || this.attributes[i3].equals(str))) {
                return this.attributes[i3 + 3];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNsp;
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        return this.name;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.depth) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            String[] strArr = this.nspStack;
            if (str == null) {
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(strArr[namespaceCount])) {
                return this.nspStack[namespaceCount + 1];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i3) {
        if (i3 <= this.depth) {
            return this.nspCounts[i3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i3) {
        return this.nspStack[i3 << 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i3) {
        return this.nspStack[(i3 << 1) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        String text;
        int i3 = this.type;
        String[] strArr = XmlPullParser.TYPES;
        StringBuffer stringBuffer = new StringBuffer(i3 < strArr.length ? strArr[i3] : "unknown");
        stringBuffer.append(' ');
        int i4 = this.type;
        if (i4 == 2 || i4 == 3) {
            if (this.degenerated) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.type == 3) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
            }
            if (this.prefix != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("{");
                stringBuffer2.append(this.namespace);
                stringBuffer2.append("}");
                stringBuffer2.append(this.prefix);
                stringBuffer2.append(":");
                stringBuffer.append(stringBuffer2.toString());
            }
            stringBuffer.append(this.name);
            int i5 = this.attributeCount << 2;
            for (int i6 = 0; i6 < i5; i6 += 4) {
                stringBuffer.append(' ');
                int i7 = i6 + 1;
                if (this.attributes[i7] != null) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("{");
                    stringBuffer3.append(this.attributes[i6]);
                    stringBuffer3.append("}");
                    stringBuffer3.append(this.attributes[i7]);
                    stringBuffer3.append(":");
                    stringBuffer.append(stringBuffer3.toString());
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.attributes[i6 + 2]);
                stringBuffer4.append("='");
                stringBuffer4.append(this.attributes[i6 + 3]);
                stringBuffer4.append("'");
                stringBuffer.append(stringBuffer4.toString());
            }
            stringBuffer.append('>');
        } else if (i4 != 7) {
            if (i4 != 4) {
                text = getText();
            } else if (this.isWhitespace) {
                text = "(whitespace)";
            } else {
                text = getText();
                if (text.length() > 16) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(text.substring(0, 16));
                    stringBuffer5.append("...");
                    text = stringBuffer5.toString();
                }
            }
            stringBuffer.append(text);
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        return this.text;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        if (this.type < 4) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        }
        iArr[0] = 0;
        iArr[1] = this.text.length();
        char[] cArr = new char[this.text.length()];
        String str = this.text;
        str.getChars(0, str.length(), cArr, 0);
        return cArr;
    }

    public int getWapCode() {
        return this.wapCode;
    }

    public Object getWapExtensionData() {
        return this.wapExtensionData;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i3) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() {
        if (this.type != 2) {
            exception(ILLEGAL_TYPE);
        }
        return this.degenerated;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() {
        int i3 = this.type;
        if (i3 != 4 && i3 != 7 && i3 != 5) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() {
        this.isWhitespace = true;
        int i3 = 9999;
        while (true) {
            String str = this.text;
            nextImpl();
            int i4 = this.type;
            if (i4 < i3) {
                i3 = i4;
            }
            if (i3 <= 5) {
                if (i3 >= 4) {
                    if (str != null) {
                        if (this.text != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(this.text);
                            str = stringBuffer.toString();
                        }
                        this.text = str;
                    }
                    int peekId = peekId();
                    if (peekId != 2 && peekId != 3 && peekId != 4 && peekId != 68 && peekId != 196 && peekId != 131 && peekId != 132) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.type = i3;
        if (i3 > 4) {
            this.type = 4;
        }
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        int i3 = this.type;
        if (i3 != 3 && i3 != 2) {
            exception("unexpected type");
        }
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() {
        String str;
        if (this.type != 2) {
            exception("precondition: START_TAG");
        }
        next();
        if (this.type == 4) {
            str = getText();
            next();
        } else {
            str = "";
        }
        if (this.type != 3) {
            exception("END_TAG expected");
        }
        return str;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() {
        this.isWhitespace = true;
        nextImpl();
        return this.type;
    }

    void parseElement(int i3) {
        this.type = 2;
        this.name = resolveId(this.tagTable, i3 & 63);
        this.attributeCount = 0;
        if ((i3 & 128) != 0) {
            readAttr();
        }
        this.degenerated = (i3 & 64) == 0;
        int i4 = this.depth;
        this.depth = i4 + 1;
        int i5 = i4 << 2;
        String[] ensureCapacity = ensureCapacity(this.elementStack, i5 + 4);
        this.elementStack = ensureCapacity;
        ensureCapacity[i5 + 3] = this.name;
        int i6 = this.depth;
        int[] iArr = this.nspCounts;
        if (i6 >= iArr.length) {
            int[] iArr2 = new int[i6 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.nspCounts = iArr2;
        }
        int[] iArr3 = this.nspCounts;
        int i7 = this.depth;
        iArr3[i7] = iArr3[i7 - 1];
        for (int i8 = this.attributeCount - 1; i8 > 0; i8--) {
            for (int i9 = 0; i9 < i8; i9++) {
                if (getAttributeName(i8).equals(getAttributeName(i9))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Duplicate Attribute: ");
                    stringBuffer.append(getAttributeName(i8));
                    exception(stringBuffer.toString());
                }
            }
        }
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[i5] = this.namespace;
        strArr[i5 + 1] = this.prefix;
        strArr[i5 + 2] = this.name;
    }

    public Object parseWapExtension(int i3) {
        switch (i3) {
            case 64:
            case 65:
            case Wbxml.EXT_I_2 /* 66 */:
                return readStrI();
            default:
                switch (i3) {
                    case 128:
                    case Wbxml.EXT_T_1 /* 129 */:
                    case Wbxml.EXT_T_2 /* 130 */:
                        return new Integer(readInt());
                    default:
                        byte[] bArr = null;
                        switch (i3) {
                            case Wbxml.OPAQUE /* 195 */:
                                int readInt = readInt();
                                bArr = new byte[readInt];
                                int i4 = readInt;
                                while (i4 > 0) {
                                    i4 -= this.in.read(bArr, readInt - i4, i4);
                                }
                            case Wbxml.EXT_0 /* 192 */:
                            case Wbxml.EXT_1 /* 193 */:
                            case Wbxml.EXT_2 /* 194 */:
                                return bArr;
                            default:
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("illegal id: ");
                                stringBuffer.append(i3);
                                exception(stringBuffer.toString());
                                return null;
                        }
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void readAttr() {
        StringBuffer stringBuffer;
        int readByte;
        String readStrI;
        int readByte2 = readByte();
        int i3 = 0;
        while (readByte2 != 1) {
            while (readByte2 == 0) {
                selectPage(readByte(), false);
                readByte2 = readByte();
            }
            String resolveId = resolveId(this.attrStartTable, readByte2);
            int indexOf = resolveId.indexOf(61);
            if (indexOf == -1) {
                stringBuffer = new StringBuffer();
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(resolveId.substring(indexOf + 1));
                resolveId = resolveId.substring(0, indexOf);
                stringBuffer = stringBuffer2;
            }
            while (true) {
                readByte = readByte();
                if (readByte > 128 || readByte == 0 || readByte == 2 || readByte == 3 || readByte == 131 || ((readByte >= 64 && readByte <= 66) || (readByte >= 128 && readByte <= 130))) {
                    if (readByte == 0) {
                        selectPage(readByte(), false);
                    } else if (readByte != 2) {
                        if (readByte != 3) {
                            switch (readByte) {
                                default:
                                    switch (readByte) {
                                        case 128:
                                        case Wbxml.EXT_T_1 /* 129 */:
                                        case Wbxml.EXT_T_2 /* 130 */:
                                            break;
                                        case Wbxml.STR_T /* 131 */:
                                            readStrI = readStrT();
                                            break;
                                        default:
                                            switch (readByte) {
                                                case Wbxml.EXT_0 /* 192 */:
                                                case Wbxml.EXT_1 /* 193 */:
                                                case Wbxml.EXT_2 /* 194 */:
                                                case Wbxml.OPAQUE /* 195 */:
                                                    break;
                                                default:
                                                    readStrI = resolveId(this.attrValueTable, readByte);
                                                    break;
                                            }
                                    }
                                case 64:
                                case 65:
                                case Wbxml.EXT_I_2 /* 66 */:
                                    readStrI = resolveWapExtension(readByte, parseWapExtension(readByte));
                                    break;
                            }
                        } else {
                            readStrI = readStrI();
                        }
                        stringBuffer.append(readStrI);
                    } else {
                        stringBuffer.append((char) readInt());
                    }
                }
            }
            String[] ensureCapacity = ensureCapacity(this.attributes, i3 + 4);
            this.attributes = ensureCapacity;
            int i4 = i3 + 1;
            ensureCapacity[i3] = "";
            int i5 = i4 + 1;
            ensureCapacity[i4] = null;
            int i6 = i5 + 1;
            ensureCapacity[i5] = resolveId;
            i3 = i6 + 1;
            ensureCapacity[i6] = stringBuffer.toString();
            this.attributeCount++;
            readByte2 = readByte;
        }
    }

    int readByte() {
        int read = this.in.read();
        if (read != -1) {
            return read;
        }
        throw new IOException(UNEXPECTED_EOF);
    }

    int readInt() {
        int readByte;
        int i3 = 0;
        do {
            readByte = readByte();
            i3 = (i3 << 7) | (readByte & 127);
        } while ((readByte & 128) != 0);
        return i3;
    }

    String readStrI() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z3 = true;
        while (true) {
            int read = this.in.read();
            if (read == 0) {
                this.isWhitespace = z3;
                String str = new String(byteArrayOutputStream.toByteArray(), this.encoding);
                byteArrayOutputStream.close();
                return str;
            }
            if (read == -1) {
                throw new IOException(UNEXPECTED_EOF);
            }
            if (read > 32) {
                z3 = false;
            }
            byteArrayOutputStream.write(read);
        }
    }

    String readStrT() {
        byte[] bArr;
        int readInt = readInt();
        if (this.cacheStringTable == null) {
            this.cacheStringTable = new Hashtable();
        }
        String str = (String) this.cacheStringTable.get(new Integer(readInt));
        if (str != null) {
            return str;
        }
        int i3 = readInt;
        while (true) {
            bArr = this.stringTable;
            if (i3 >= bArr.length || bArr[i3] == 0) {
                break;
            }
            i3++;
        }
        String str2 = new String(bArr, readInt, i3 - readInt, this.encoding);
        this.cacheStringTable.put(new Integer(readInt), str2);
        return str2;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i3, String str, String str2) {
        String stringBuffer;
        if (i3 == this.type && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("expected: ");
        if (i3 == 64) {
            stringBuffer = "WAP Ext.";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(XmlPullParser.TYPES[i3]);
            stringBuffer3.append(" {");
            stringBuffer3.append(str);
            stringBuffer3.append("}");
            stringBuffer3.append(str2);
            stringBuffer = stringBuffer3.toString();
        }
        stringBuffer2.append(stringBuffer);
        exception(stringBuffer2.toString());
    }

    String resolveId(String[] strArr, int i3) {
        String str;
        int i4 = (i3 & 127) - 5;
        if (i4 == -1) {
            this.wapCode = -1;
            return readStrT();
        }
        if (i4 >= 0 && strArr != null && i4 < strArr.length && (str = strArr[i4]) != null) {
            this.wapCode = i4 + 5;
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id ");
        stringBuffer.append(i3);
        stringBuffer.append(" undef.");
        throw new IOException(stringBuffer.toString());
    }

    protected String resolveWapExtension(int i3, Object obj) {
        if (!(obj instanceof byte[])) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("$(");
            stringBuffer.append(obj);
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        byte[] bArr = (byte[]) obj;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            stringBuffer2.append(HEX_DIGITS.charAt((bArr[i4] >> 4) & 15));
            stringBuffer2.append(HEX_DIGITS.charAt(bArr[i4] & Ascii.SI));
        }
        return stringBuffer2.toString();
    }

    public void setAttrStartTable(int i3, String[] strArr) {
        setTable(i3, this.ATTR_START_TABLE, strArr);
    }

    public void setAttrValueTable(int i3, String[] strArr) {
        setTable(i3, this.ATTR_VALUE_TABLE, strArr);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z3) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z3;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported feature: ");
        stringBuffer.append(str);
        exception(stringBuffer.toString());
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        this.in = inputStream;
        try {
            this.version = readByte();
            int readInt = readInt();
            this.publicIdentifierId = readInt;
            if (readInt == 0) {
                readInt();
            }
            int readInt2 = readInt();
            if (str == null) {
                if (readInt2 == 4) {
                    str = "ISO-8859-1";
                } else {
                    if (readInt2 != 106) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("");
                        stringBuffer.append(readInt2);
                        throw new UnsupportedEncodingException(stringBuffer.toString());
                    }
                    str = "UTF-8";
                }
            }
            this.encoding = str;
            int readInt3 = readInt();
            this.stringTable = new byte[readInt3];
            int i3 = 0;
            while (i3 < readInt3) {
                int read = inputStream.read(this.stringTable, i3, readInt3 - i3);
                if (read <= 0) {
                    break;
                } else {
                    i3 += read;
                }
            }
            selectPage(0, true);
            selectPage(0, false);
        } catch (IOException unused) {
            exception("Illegal input format");
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) {
        exception("InputStream required");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported property: ");
        stringBuffer.append(str);
        throw new XmlPullParserException(stringBuffer.toString());
    }

    public void setTagTable(int i3, String[] strArr) {
        setTable(i3, this.TAG_TABLE, strArr);
    }
}
