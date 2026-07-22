package org.kxml2.wap;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: /root/release/classes2.dex */
public class WbxmlSerializer implements XmlSerializer {
    private int attrPage;
    int depth;
    private String encoding;
    String name;
    String namespace;
    OutputStream out;
    String pending;
    private int tagPage;
    Hashtable stringTable = new Hashtable();
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    ByteArrayOutputStream stringTableBuf = new ByteArrayOutputStream();
    Vector attributes = new Vector();
    Hashtable attrStartTable = new Hashtable();
    Hashtable attrValueTable = new Hashtable();
    Hashtable tagTable = new Hashtable();

    static void writeInt(OutputStream outputStream, int i3) {
        int i4;
        byte[] bArr = new byte[5];
        int i5 = 0;
        while (true) {
            i4 = i5 + 1;
            bArr[i5] = (byte) (i3 & 127);
            i3 >>= 7;
            if (i3 == 0) {
                break;
            } else {
                i5 = i4;
            }
        }
        while (i4 > 1) {
            i4--;
            outputStream.write(bArr[i4] | UnsignedBytes.MAX_POWER_OF_TWO);
        }
        outputStream.write(bArr[0]);
    }

    private void writeStr(String str) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            while (i3 < length && str.charAt(i3) < 'A') {
                i3++;
            }
            int i5 = i3;
            while (i5 < length && str.charAt(i5) >= 'A') {
                i5++;
            }
            if (i5 - i3 > 10) {
                if (i3 > i4 && str.charAt(i3 - 1) == ' ' && this.stringTable.get(str.substring(i3, i5)) == null) {
                    this.buf.write(Wbxml.STR_T);
                    writeStrT(str.substring(i4, i5), false);
                } else {
                    if (i3 > i4 && str.charAt(i3 - 1) == ' ') {
                        i3--;
                    }
                    if (i3 > i4) {
                        this.buf.write(Wbxml.STR_T);
                        writeStrT(str.substring(i4, i3), false);
                    }
                    this.buf.write(Wbxml.STR_T);
                    writeStrT(str.substring(i3, i5), true);
                }
                i4 = i5;
            }
            i3 = i5;
        }
        if (i4 < length) {
            this.buf.write(Wbxml.STR_T);
            writeStrT(str.substring(i4, length), false);
        }
    }

    private final void writeStrT(String str, boolean z3) {
        Integer num = (Integer) this.stringTable.get(str);
        if (num != null) {
            writeInt(this.buf, num.intValue());
            return;
        }
        int size = this.stringTableBuf.size();
        if (str.charAt(0) < '0' || !z3) {
            writeInt(this.buf, size);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(' ');
            stringBuffer.append(str);
            str = stringBuffer.toString();
            writeInt(this.buf, size + 1);
        }
        this.stringTable.put(str, new Integer(size));
        if (str.charAt(0) == ' ') {
            this.stringTable.put(str.substring(1), new Integer(size + 1));
        }
        int lastIndexOf = str.lastIndexOf(32);
        if (lastIndexOf > 1) {
            int i3 = size + lastIndexOf;
            this.stringTable.put(str.substring(lastIndexOf), new Integer(i3));
            this.stringTable.put(str.substring(lastIndexOf + 1), new Integer(i3 + 1));
        }
        writeStrI(this.stringTableBuf, str);
        this.stringTableBuf.flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) {
        this.attributes.addElement(str2);
        this.attributes.addElement(str3);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) {
        text(str);
    }

    public void checkPending(boolean z3) {
        if (this.pending == null) {
            return;
        }
        int size = this.attributes.size();
        int[] iArr = (int[]) this.tagTable.get(this.pending);
        if (iArr == null) {
            this.buf.write(size == 0 ? z3 ? 4 : 68 : z3 ? Wbxml.LITERAL_A : Wbxml.LITERAL_AC);
            writeStrT(this.pending, false);
        } else {
            int i3 = iArr[0];
            if (i3 != this.tagPage) {
                this.tagPage = i3;
                this.buf.write(0);
                this.buf.write(this.tagPage);
            }
            this.buf.write(size == 0 ? z3 ? iArr[1] : iArr[1] | 64 : z3 ? iArr[1] | 128 : iArr[1] | Wbxml.EXT_0);
        }
        int i4 = 0;
        while (i4 < size) {
            int[] iArr2 = (int[]) this.attrStartTable.get(this.attributes.elementAt(i4));
            if (iArr2 == null) {
                this.buf.write(4);
                writeStrT((String) this.attributes.elementAt(i4), false);
            } else {
                int i5 = iArr2[0];
                if (i5 != this.attrPage) {
                    this.attrPage = i5;
                    this.buf.write(0);
                    this.buf.write(this.attrPage);
                }
                this.buf.write(iArr2[1]);
            }
            int i6 = i4 + 1;
            int[] iArr3 = (int[]) this.attrValueTable.get(this.attributes.elementAt(i6));
            if (iArr3 == null) {
                writeStr((String) this.attributes.elementAt(i6));
            } else {
                int i7 = iArr3[0];
                if (i7 != this.attrPage) {
                    this.attrPage = i7;
                    this.buf.write(0);
                    this.buf.write(this.attrPage);
                }
                this.buf.write(iArr3[1]);
            }
            i4 = i6 + 1;
        }
        if (size > 0) {
            this.buf.write(1);
        }
        this.pending = null;
        this.attributes.removeAllElements();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) {
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) {
        throw new RuntimeException("Cannot write docdecl for WBXML");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() {
        writeInt(this.out, this.stringTableBuf.size());
        this.out.write(this.stringTableBuf.toByteArray());
        this.out.write(this.buf.toByteArray());
        this.out.flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) {
        if (this.pending != null) {
            checkPending(true);
        } else {
            this.buf.write(1);
        }
        this.depth--;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) {
        throw new RuntimeException("EntityReference not supported for WBXML");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() {
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new RuntimeException("NYI");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new RuntimeException("NYI");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z3) {
        throw new RuntimeException("NYI");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        return null;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) {
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) {
        throw new RuntimeException("PI NYI");
    }

    public void setAttrStartTable(int i3, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                this.attrStartTable.put(str, new int[]{i3, i4 + 5});
            }
        }
    }

    public void setAttrValueTable(int i3, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                this.attrValueTable.put(str, new int[]{i3, i4 + 133});
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unknown feature ");
        stringBuffer.append(str);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        if (str == null) {
            str = "UTF-8";
        }
        this.encoding = str;
        this.out = outputStream;
        this.buf = new ByteArrayOutputStream();
        this.stringTableBuf = new ByteArrayOutputStream();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        throw new RuntimeException("Wbxml requires an OutputStream!");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        throw new RuntimeException("NYI");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unknown property ");
        stringBuffer.append(str);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public void setTagTable(int i3, String[] strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                this.tagTable.put(str, new int[]{i3, i4 + 5});
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) {
        OutputStream outputStream;
        int i3;
        this.out.write(3);
        this.out.write(1);
        if (str != null) {
            this.encoding = str;
        }
        if (this.encoding.toUpperCase().equals("UTF-8")) {
            outputStream = this.out;
            i3 = 106;
        } else {
            if (!this.encoding.toUpperCase().equals("ISO-8859-1")) {
                throw new UnsupportedEncodingException(str);
            }
            outputStream = this.out;
            i3 = 4;
        }
        outputStream.write(i3);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) {
        if (str != null && !"".equals(str)) {
            throw new RuntimeException("NSP NYI");
        }
        checkPending(false);
        this.pending = str2;
        this.depth++;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) {
        checkPending(false);
        writeStr(str);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i3, int i4) {
        checkPending(false);
        writeStr(new String(cArr, i3, i4));
        return this;
    }

    void writeStrI(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(this.encoding));
        outputStream.write(0);
    }

    public void writeWapExtension(int i3, Object obj) {
        checkPending(false);
        this.buf.write(i3);
        switch (i3) {
            case 64:
            case 65:
            case Wbxml.EXT_I_2 /* 66 */:
                writeStrI(this.buf, (String) obj);
                return;
            default:
                switch (i3) {
                    case 128:
                    case Wbxml.EXT_T_1 /* 129 */:
                    case Wbxml.EXT_T_2 /* 130 */:
                        writeStrT((String) obj, false);
                        return;
                    default:
                        switch (i3) {
                            case Wbxml.EXT_0 /* 192 */:
                            case Wbxml.EXT_1 /* 193 */:
                            case Wbxml.EXT_2 /* 194 */:
                                return;
                            case Wbxml.OPAQUE /* 195 */:
                                byte[] bArr = (byte[]) obj;
                                writeInt(this.buf, bArr.length);
                                this.buf.write(bArr);
                                return;
                            default:
                                throw new IllegalArgumentException();
                        }
                }
        }
    }
}
