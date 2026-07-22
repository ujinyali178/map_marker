package org.kxml2.io;

import java.io.Reader;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.mapsforge.core.model.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /root/release/classes2.dex */
public class KXmlParser implements XmlPullParser {
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final int LEGACY = 999;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private static final int XML_DECL = 998;
    private int attributeCount;
    private int column;
    private boolean degenerated;
    private int depth;
    private String encoding;
    private Hashtable entityMap;
    private String error;
    private boolean isWhitespace;
    private int line;
    private Object location;
    private String name;
    private String namespace;
    private int peekCount;
    private String prefix;
    private boolean processNsp;
    private Reader reader;
    private boolean relaxed;
    private char[] srcBuf;
    private int srcCount;
    private int srcPos;
    private Boolean standalone;
    private boolean token;
    private int txtPos;
    private int type;
    private boolean unresolved;
    private String version;
    private boolean wasCR;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private char[] txtBuf = new char[128];
    private String[] attributes = new String[16];
    private int stackMismatch = 0;
    private int[] peek = new int[2];

    public KXmlParser() {
        this.srcBuf = new char[Runtime.getRuntime().freeMemory() >= FileUtils.ONE_MB ? 8192 : 128];
    }

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
                    error("illegal empty namespace");
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
                if (indexOf2 == 0 && !this.relaxed) {
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
                    if (namespace == null && !this.relaxed) {
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
                }
            }
        }
        int indexOf3 = this.name.indexOf(58);
        if (indexOf3 == 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("illegal tag name: ");
            stringBuffer3.append(this.name);
            error(stringBuffer3.toString());
        }
        if (indexOf3 != -1) {
            this.prefix = this.name.substring(0, indexOf3);
            this.name = this.name.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("undefined prefix: ");
                stringBuffer4.append(this.prefix);
                error(stringBuffer4.toString());
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

    private final void error(String str) {
        if (!this.relaxed) {
            exception(str);
        } else if (this.error == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ERR: ");
            stringBuffer.append(str);
            this.error = stringBuffer.toString();
        }
    }

    private final void exception(String str) {
        if (str.length() >= 100) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 100));
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
            str = stringBuffer.toString();
        }
        throw new XmlPullParserException(str, this, null);
    }

    private final String get(int i3) {
        return new String(this.txtBuf, i3, this.txtPos - i3);
    }

    private final boolean isProp(String str, boolean z3, String str2) {
        if (str.startsWith("http://xmlpull.org/v1/doc/")) {
            return str.substring(z3 ? 42 : 40).equals(str2);
        }
        return false;
    }

    private final void nextImpl() {
        int parseLegacy;
        if (this.reader == null) {
            exception("No Input specified");
        }
        if (this.type == 3) {
            this.depth--;
        }
        do {
            this.attributeCount = -1;
            if (this.degenerated) {
                this.degenerated = false;
                this.type = 3;
                return;
            }
            if (this.error != null) {
                for (int i3 = 0; i3 < this.error.length(); i3++) {
                    push(this.error.charAt(i3));
                }
                this.error = null;
                this.type = 9;
                return;
            }
            if (this.relaxed && (this.stackMismatch > 0 || (peek(0) == -1 && this.depth > 0))) {
                int i4 = (this.depth - 1) << 2;
                this.type = 3;
                String[] strArr = this.elementStack;
                this.namespace = strArr[i4];
                this.prefix = strArr[i4 + 1];
                this.name = strArr[i4 + 2];
                if (this.stackMismatch != 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("missing end tag /");
                    stringBuffer.append(this.name);
                    stringBuffer.append(" inserted");
                    this.error = stringBuffer.toString();
                }
                int i5 = this.stackMismatch;
                if (i5 > 0) {
                    this.stackMismatch = i5 - 1;
                    return;
                }
                return;
            }
            this.prefix = null;
            this.name = null;
            this.namespace = null;
            int peekType = peekType();
            this.type = peekType;
            if (peekType == 1) {
                return;
            }
            if (peekType == 2) {
                parseStartTag(false);
                return;
            }
            if (peekType == 3) {
                parseEndTag();
                return;
            }
            if (peekType == 4) {
                pushText(60, !this.token);
                if (this.depth == 0 && this.isWhitespace) {
                    this.type = 7;
                    return;
                }
                return;
            }
            if (peekType == 6) {
                pushEntity();
                return;
            } else {
                parseLegacy = parseLegacy(this.token);
                this.type = parseLegacy;
            }
        } while (parseLegacy == XML_DECL);
    }

    private final void parseDoctype(boolean z3) {
        int i3 = 1;
        boolean z4 = false;
        while (true) {
            int read = read();
            if (read == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            if (read == 39) {
                z4 = !z4;
            } else if (read != 60) {
                if (read == 62 && !z4 && i3 - 1 == 0) {
                    return;
                }
            } else if (!z4) {
                i3++;
            }
            if (z3) {
                push(read);
            }
        }
    }

    private final void parseEndTag() {
        read();
        read();
        this.name = readName();
        skip();
        read('>');
        int i3 = this.depth;
        int i4 = (i3 - 1) << 2;
        if (i3 == 0) {
            error("element stack empty");
            this.type = 9;
            return;
        }
        int i5 = i4 + 3;
        if (!this.name.equals(this.elementStack[i5])) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: /");
            stringBuffer.append(this.elementStack[i5]);
            stringBuffer.append(" read: ");
            stringBuffer.append(this.name);
            error(stringBuffer.toString());
            int i6 = i4;
            while (i6 >= 0 && !this.name.toLowerCase().equals(this.elementStack[i6 + 3].toLowerCase())) {
                this.stackMismatch++;
                i6 -= 4;
            }
            if (i6 < 0) {
                this.stackMismatch = 0;
                this.type = 9;
                return;
            }
        }
        String[] strArr = this.elementStack;
        this.namespace = strArr[i4];
        this.prefix = strArr[i4 + 1];
        this.name = strArr[i4 + 2];
    }

    private final int parseLegacy(boolean z3) {
        String stringBuffer;
        String str;
        int i3;
        int i4;
        Boolean bool;
        read();
        int read = read();
        if (read == 63) {
            if ((peek(0) == 120 || peek(0) == 88) && (peek(1) == 109 || peek(1) == 77)) {
                if (z3) {
                    push(peek(0));
                    push(peek(1));
                }
                read();
                read();
                if ((peek(0) == 108 || peek(0) == 76) && peek(1) <= 32) {
                    if (this.line != 1 || this.column > 4) {
                        error("PI must not start with xml");
                    }
                    parseStartTag(true);
                    int i5 = 2;
                    if (this.attributeCount < 1 || !"version".equals(this.attributes[2])) {
                        error("version expected");
                    }
                    String[] strArr = this.attributes;
                    this.version = strArr[3];
                    if (1 >= this.attributeCount || !"encoding".equals(strArr[6])) {
                        i5 = 1;
                    } else {
                        this.encoding = this.attributes[7];
                    }
                    if (i5 < this.attributeCount) {
                        int i6 = i5 * 4;
                        if ("standalone".equals(this.attributes[i6 + 2])) {
                            String str2 = this.attributes[i6 + 3];
                            if ("yes".equals(str2)) {
                                bool = new Boolean(true);
                            } else if ("no".equals(str2)) {
                                bool = new Boolean(false);
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("illegal standalone value: ");
                                stringBuffer2.append(str2);
                                error(stringBuffer2.toString());
                                i5++;
                            }
                            this.standalone = bool;
                            i5++;
                        }
                    }
                    if (i5 != this.attributeCount) {
                        error("illegal xmldecl");
                    }
                    this.isWhitespace = true;
                    this.txtPos = 0;
                    return XML_DECL;
                }
            }
            str = "";
            i3 = 63;
            i4 = 8;
        } else {
            if (read != 33) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("illegal: <");
                stringBuffer3.append(read);
                stringBuffer = stringBuffer3.toString();
                error(stringBuffer);
                return 9;
            }
            if (peek(0) == 45) {
                str = "--";
                i3 = 45;
                i4 = 9;
            } else if (peek(0) == 91) {
                str = "[CDATA[";
                z3 = true;
                i3 = 93;
                i4 = 5;
            } else {
                str = "DOCTYPE";
                i3 = -1;
                i4 = 10;
            }
        }
        for (int i7 = 0; i7 < str.length(); i7++) {
            read(str.charAt(i7));
        }
        if (i4 != 10) {
            int i8 = 0;
            while (true) {
                int read2 = read();
                if (read2 == -1) {
                    stringBuffer = UNEXPECTED_EOF;
                    break;
                }
                if (z3) {
                    push(read2);
                }
                if ((i3 == 63 || read2 == i3) && peek(0) == i3 && peek(1) == 62) {
                    if (i3 == 45 && i8 == 45) {
                        error("illegal comment delimiter: --->");
                    }
                    read();
                    read();
                    if (z3 && i3 != 63) {
                        this.txtPos--;
                    }
                } else {
                    i8 = read2;
                }
            }
            error(stringBuffer);
            return 9;
        }
        parseDoctype(z3);
        return i4;
    }

    private final void parseStartTag(boolean z3) {
        if (!z3) {
            read();
        }
        this.name = readName();
        this.attributeCount = 0;
        while (true) {
            skip();
            int peek = peek(0);
            if (!z3) {
                if (peek != 47) {
                    if (peek == 62 && !z3) {
                        read();
                        break;
                    }
                } else {
                    this.degenerated = true;
                    read();
                    skip();
                    read('>');
                    break;
                }
            } else if (peek == 63) {
                read();
                read('>');
                return;
            }
            if (peek == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            String readName = readName();
            if (readName.length() == 0) {
                error("attr name expected");
                break;
            }
            int i3 = this.attributeCount;
            this.attributeCount = i3 + 1;
            int i4 = i3 << 2;
            String[] ensureCapacity = ensureCapacity(this.attributes, i4 + 4);
            this.attributes = ensureCapacity;
            int i5 = i4 + 1;
            ensureCapacity[i4] = "";
            int i6 = i5 + 1;
            ensureCapacity[i5] = null;
            int i7 = i6 + 1;
            ensureCapacity[i6] = readName;
            skip();
            if (peek(0) != 61) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Attr.value missing f. ");
                stringBuffer.append(readName);
                error(stringBuffer.toString());
                this.attributes[i7] = "1";
            } else {
                read(Tag.KEY_VALUE_SEPARATOR);
                skip();
                int peek2 = peek(0);
                if (peek2 == 39 || peek2 == 34) {
                    read();
                } else {
                    error("attr value delimiter missing!");
                    peek2 = 32;
                }
                int i8 = this.txtPos;
                pushText(peek2, true);
                this.attributes[i7] = get(i8);
                this.txtPos = i8;
                if (peek2 != 32) {
                    read();
                }
            }
        }
        int i9 = this.depth;
        this.depth = i9 + 1;
        int i10 = i9 << 2;
        String[] ensureCapacity2 = ensureCapacity(this.elementStack, i10 + 4);
        this.elementStack = ensureCapacity2;
        ensureCapacity2[i10 + 3] = this.name;
        int i11 = this.depth;
        int[] iArr = this.nspCounts;
        if (i11 >= iArr.length) {
            int[] iArr2 = new int[i11 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.nspCounts = iArr2;
        }
        int[] iArr3 = this.nspCounts;
        int i12 = this.depth;
        iArr3[i12] = iArr3[i12 - 1];
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[i10] = this.namespace;
        strArr[i10 + 1] = this.prefix;
        strArr[i10 + 2] = this.name;
    }

    private final int peek(int i3) {
        int i4;
        while (i3 >= this.peekCount) {
            char[] cArr = this.srcBuf;
            if (cArr.length <= 1) {
                i4 = this.reader.read();
            } else {
                int i5 = this.srcPos;
                if (i5 < this.srcCount) {
                    this.srcPos = i5 + 1;
                    i4 = cArr[i5];
                } else {
                    int read = this.reader.read(cArr, 0, cArr.length);
                    this.srcCount = read;
                    int i6 = read <= 0 ? -1 : this.srcBuf[0];
                    this.srcPos = 1;
                    i4 = i6;
                }
            }
            if (i4 == 13) {
                this.wasCR = true;
                int[] iArr = this.peek;
                int i7 = this.peekCount;
                this.peekCount = i7 + 1;
                iArr[i7] = 10;
            } else {
                if (i4 != 10) {
                    int[] iArr2 = this.peek;
                    int i8 = this.peekCount;
                    this.peekCount = i8 + 1;
                    iArr2[i8] = i4;
                } else if (!this.wasCR) {
                    int[] iArr3 = this.peek;
                    int i9 = this.peekCount;
                    this.peekCount = i9 + 1;
                    iArr3[i9] = 10;
                }
                this.wasCR = false;
            }
        }
        return this.peek[i3];
    }

    private final int peekType() {
        int peek = peek(0);
        if (peek == -1) {
            return 1;
        }
        if (peek == 38) {
            return 6;
        }
        if (peek != 60) {
            return 4;
        }
        int peek2 = peek(1);
        if (peek2 == 33) {
            return LEGACY;
        }
        if (peek2 == 47) {
            return 3;
        }
        if (peek2 != 63) {
            return 2;
        }
        return LEGACY;
    }

    private final void push(int i3) {
        this.isWhitespace &= i3 <= 32;
        int i4 = this.txtPos;
        char[] cArr = this.txtBuf;
        if (i4 == cArr.length) {
            char[] cArr2 = new char[((i4 * 4) / 3) + 4];
            System.arraycopy(cArr, 0, cArr2, 0, i4);
            this.txtBuf = cArr2;
        }
        char[] cArr3 = this.txtBuf;
        int i5 = this.txtPos;
        this.txtPos = i5 + 1;
        cArr3[i5] = (char) i3;
    }

    private final void pushEntity() {
        push(read());
        int i3 = this.txtPos;
        while (true) {
            int read = read();
            if (read == 59) {
                String str = get(i3);
                this.txtPos = i3 - 1;
                if (this.token && this.type == 6) {
                    this.name = str;
                }
                if (str.charAt(0) == '#') {
                    push(str.charAt(1) == 'x' ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str.substring(1)));
                    return;
                }
                String str2 = (String) this.entityMap.get(str);
                boolean z3 = str2 == null;
                this.unresolved = z3;
                if (!z3) {
                    for (int i4 = 0; i4 < str2.length(); i4++) {
                        push(str2.charAt(i4));
                    }
                    return;
                } else {
                    if (this.token) {
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("unresolved: &");
                    stringBuffer.append(str);
                    stringBuffer.append(";");
                    error(stringBuffer.toString());
                    return;
                }
            }
            if (read < 128 && ((read < 48 || read > 57) && ((read < 97 || read > 122) && ((read < 65 || read > 90) && read != 95 && read != 45 && read != 35)))) {
                if (!this.relaxed) {
                    error("unterminated entity ref");
                }
                if (read != -1) {
                    push(read);
                    return;
                }
                return;
            }
            push(read);
        }
    }

    private final void pushText(int i3, boolean z3) {
        int peek = peek(0);
        int i4 = 0;
        while (peek != -1 && peek != i3) {
            int i5 = 32;
            if (i3 == 32 && (peek <= 32 || peek == 62)) {
                return;
            }
            if (peek != 38) {
                if (peek == 10 && this.type == 2) {
                    read();
                } else {
                    i5 = read();
                }
                push(i5);
            } else if (!z3) {
                return;
            } else {
                pushEntity();
            }
            if (peek == 62 && i4 >= 2 && i3 != 93) {
                error("Illegal: ]]>");
            }
            i4 = peek == 93 ? i4 + 1 : 0;
            peek = peek(0);
        }
    }

    private final int read() {
        int i3;
        if (this.peekCount == 0) {
            i3 = peek(0);
        } else {
            int[] iArr = this.peek;
            int i4 = iArr[0];
            iArr[0] = iArr[1];
            i3 = i4;
        }
        this.peekCount--;
        this.column++;
        if (i3 == 10) {
            this.line++;
            this.column = 1;
        }
        return i3;
    }

    private final void read(char c3) {
        int read = read();
        if (read != c3) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: '");
            stringBuffer.append(c3);
            stringBuffer.append("' actual: '");
            stringBuffer.append((char) read);
            stringBuffer.append("'");
            error(stringBuffer.toString());
        }
    }

    private final String readName() {
        int i3 = this.txtPos;
        int peek = peek(0);
        if ((peek < 97 || peek > 122) && ((peek < 65 || peek > 90) && peek != 95 && peek != 58 && peek < 192 && !this.relaxed)) {
            error("name expected");
        }
        while (true) {
            push(read());
            int peek2 = peek(0);
            if (peek2 < 97 || peek2 > 122) {
                if (peek2 < 65 || peek2 > 90) {
                    if (peek2 < 48 || peek2 > 57) {
                        if (peek2 != 95 && peek2 != 45 && peek2 != 58 && peek2 != 46 && peek2 < 183) {
                            String str = get(i3);
                            this.txtPos = i3;
                            return str;
                        }
                    }
                }
            }
        }
    }

    private final void skip() {
        while (true) {
            int peek = peek(0);
            if (peek > 32 || peek == -1) {
                return;
            } else {
                read();
            }
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        Hashtable hashtable = this.entityMap;
        if (hashtable == null) {
            throw new RuntimeException("entity replacement text must be defined after setInput!");
        }
        hashtable.put(str, str2);
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
        return this.column;
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
        if (isProp(str, false, "relaxed")) {
            return this.relaxed;
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.line;
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
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("@");
        stringBuffer6.append(this.line);
        stringBuffer6.append(":");
        stringBuffer6.append(this.column);
        stringBuffer.append(stringBuffer6.toString());
        if (this.location != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.location);
        } else if (this.reader != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.reader.toString());
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        if (isProp(str, true, "xmldecl-version")) {
            return this.version;
        }
        if (isProp(str, true, "xmldecl-standalone")) {
            return this.standalone;
        }
        if (!isProp(str, true, "location")) {
            return null;
        }
        Object obj = this.location;
        return obj != null ? obj : this.reader.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        int i3 = this.type;
        if (i3 < 4 || (i3 == 6 && this.unresolved)) {
            return null;
        }
        return get(0);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        int i3 = this.type;
        if (i3 < 4) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        }
        if (i3 == 6) {
            iArr[0] = 0;
            iArr[1] = this.name.length();
            return this.name.toCharArray();
        }
        iArr[0] = 0;
        iArr[1] = this.txtPos;
        return this.txtBuf;
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
        this.txtPos = 0;
        this.isWhitespace = true;
        this.token = false;
        int i3 = 9999;
        while (true) {
            nextImpl();
            int i4 = this.type;
            if (i4 < i3) {
                i3 = i4;
            }
            if (i3 > 6 || (i3 >= 4 && peekType() >= 4)) {
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
        this.txtPos = 0;
        this.token = true;
        nextImpl();
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i3, String str, String str2) {
        if (i3 == this.type && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("expected: ");
        stringBuffer.append(XmlPullParser.TYPES[i3]);
        stringBuffer.append(" {");
        stringBuffer.append(str);
        stringBuffer.append("}");
        stringBuffer.append(str2);
        exception(stringBuffer.toString());
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z3) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z3;
            return;
        }
        if (isProp(str, false, "relaxed")) {
            this.relaxed = z3;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported feature: ");
        stringBuffer.append(str);
        exception(stringBuffer.toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7 A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:7:0x0014, B:9:0x001a, B:11:0x0021, B:14:0x0030, B:17:0x003a, B:20:0x00af, B:22:0x00b7, B:26:0x00f1, B:33:0x00ca, B:34:0x00d9, B:36:0x00e0, B:38:0x003f, B:40:0x0047, B:43:0x0056, B:45:0x0063, B:47:0x006b, B:49:0x0073, B:51:0x0076, B:56:0x0085, B:57:0x008f, B:59:0x0096, B:60:0x00a0, B:61:0x00a3, B:62:0x00aa), top: B:6:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    @Override // org.xmlpull.v1.XmlPullParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setInput(java.io.InputStream r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlParser.setInput(java.io.InputStream, java.lang.String):void");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) {
        this.reader = reader;
        this.line = 1;
        this.column = 0;
        this.type = 0;
        this.name = null;
        this.namespace = null;
        this.degenerated = false;
        this.attributeCount = -1;
        this.encoding = null;
        this.version = null;
        this.standalone = null;
        if (reader == null) {
            return;
        }
        this.srcPos = 0;
        this.srcCount = 0;
        this.peekCount = 0;
        this.depth = 0;
        Hashtable hashtable = new Hashtable();
        this.entityMap = hashtable;
        hashtable.put("amp", "&");
        this.entityMap.put("apos", "'");
        this.entityMap.put("gt", ">");
        this.entityMap.put("lt", "<");
        this.entityMap.put("quot", "\"");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        if (isProp(str, true, "location")) {
            this.location = obj;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported property: ");
        stringBuffer.append(str);
        throw new XmlPullParserException(stringBuffer.toString());
    }

    public void skipSubTree() {
        require(2, null, null);
        int i3 = 1;
        while (i3 > 0) {
            int next = next();
            if (next == 3) {
                i3--;
            } else if (next == 2) {
                i3++;
            }
        }
    }
}
