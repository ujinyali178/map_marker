package org.kxml2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: /root/release/classes2.dex */
public class KXmlSerializer implements XmlSerializer {
    private int auto;
    private int depth;
    private String encoding;
    private boolean pending;
    private boolean unicode;
    private Writer writer;
    private String[] elementStack = new String[12];
    private int[] nspCounts = new int[4];
    private String[] nspStack = new String[8];
    private boolean[] indent = new boolean[4];

    private final void check(boolean z3) {
        if (!this.pending) {
            return;
        }
        int i3 = this.depth + 1;
        this.depth = i3;
        this.pending = false;
        boolean[] zArr = this.indent;
        if (zArr.length <= i3) {
            boolean[] zArr2 = new boolean[i3 + 4];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            this.indent = zArr2;
        }
        boolean[] zArr3 = this.indent;
        int i4 = this.depth;
        zArr3[i4] = zArr3[i4 - 1];
        int i5 = this.nspCounts[i4 - 1];
        while (true) {
            int[] iArr = this.nspCounts;
            int i6 = this.depth;
            if (i5 >= iArr[i6]) {
                if (iArr.length <= i6 + 1) {
                    int[] iArr2 = new int[i6 + 8];
                    System.arraycopy(iArr, 0, iArr2, 0, i6 + 1);
                    this.nspCounts = iArr2;
                }
                int[] iArr3 = this.nspCounts;
                int i7 = this.depth;
                iArr3[i7 + 1] = iArr3[i7];
                this.writer.write(z3 ? " />" : ">");
                return;
            }
            this.writer.write(32);
            this.writer.write("xmlns");
            int i8 = i5 * 2;
            if (!"".equals(this.nspStack[i8])) {
                this.writer.write(58);
                this.writer.write(this.nspStack[i8]);
            } else if ("".equals(getNamespace()) && !"".equals(this.nspStack[i8 + 1])) {
                throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
            }
            this.writer.write("=\"");
            writeEscaped(this.nspStack[i8 + 1], 34);
            this.writer.write(34);
            i5++;
        }
    }

    private final String getPrefix(String str, boolean z3, boolean z4) {
        int i3 = this.nspCounts[this.depth + 1] * 2;
        while (true) {
            i3 -= 2;
            String str2 = null;
            String str3 = "";
            if (i3 < 0) {
                if (!z4) {
                    return null;
                }
                if (!"".equals(str)) {
                    do {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("n");
                        int i4 = this.auto;
                        this.auto = i4 + 1;
                        stringBuffer.append(i4);
                        String stringBuffer2 = stringBuffer.toString();
                        int i5 = (this.nspCounts[this.depth + 1] * 2) - 2;
                        while (true) {
                            if (i5 < 0) {
                                str3 = stringBuffer2;
                                break;
                            }
                            if (stringBuffer2.equals(this.nspStack[i5])) {
                                str3 = null;
                                break;
                            }
                            i5 -= 2;
                        }
                    } while (str3 == null);
                }
                boolean z5 = this.pending;
                this.pending = false;
                setPrefix(str3, str);
                this.pending = z5;
                return str3;
            }
            if (this.nspStack[i3 + 1].equals(str) && (z3 || !this.nspStack[i3].equals(""))) {
                String str4 = this.nspStack[i3];
                int i6 = i3 + 2;
                while (true) {
                    if (i6 >= this.nspCounts[this.depth + 1] * 2) {
                        str2 = str4;
                        break;
                    }
                    if (this.nspStack[i6].equals(str4)) {
                        break;
                    }
                    i6++;
                }
                if (str2 != null) {
                    return str2;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        if (r1 != '\'') goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void writeEscaped(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r6.length()
            if (r0 >= r1) goto L9a
            char r1 = r6.charAt(r0)
            r2 = 9
            java.lang.String r3 = "&#"
            if (r1 == r2) goto L7a
            r2 = 10
            if (r1 == r2) goto L7a
            r2 = 13
            if (r1 == r2) goto L7a
            r2 = 34
            if (r1 == r2) goto L40
            r4 = 60
            if (r1 == r4) goto L3b
            r4 = 62
            if (r1 == r4) goto L36
            r4 = 38
            if (r1 == r4) goto L2e
            r4 = 39
            if (r1 == r4) goto L40
            goto L4f
        L2e:
            java.io.Writer r1 = r5.writer
            java.lang.String r2 = "&amp;"
        L32:
            r1.write(r2)
            goto L96
        L36:
            java.io.Writer r1 = r5.writer
            java.lang.String r2 = "&gt;"
            goto L32
        L3b:
            java.io.Writer r1 = r5.writer
            java.lang.String r2 = "&lt;"
            goto L32
        L40:
            if (r1 != r7) goto L4f
            java.io.Writer r3 = r5.writer
            if (r1 != r2) goto L49
            java.lang.String r1 = "&quot;"
            goto L4b
        L49:
            java.lang.String r1 = "&apos;"
        L4b:
            r3.write(r1)
            goto L96
        L4f:
            r2 = 32
            if (r1 < r2) goto L60
            r2 = 64
            if (r1 == r2) goto L60
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 < r2) goto L7d
            boolean r2 = r5.unicode
            if (r2 == 0) goto L60
            goto L7d
        L60:
            java.io.Writer r2 = r5.writer
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = ";"
            r4.append(r1)
        L72:
            java.lang.String r1 = r4.toString()
            r2.write(r1)
            goto L96
        L7a:
            r2 = -1
            if (r7 != r2) goto L83
        L7d:
            java.io.Writer r2 = r5.writer
            r2.write(r1)
            goto L96
        L83:
            java.io.Writer r2 = r5.writer
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r4.append(r3)
            r4.append(r1)
            r1 = 59
            r4.append(r1)
            goto L72
        L96:
            int r0 = r0 + 1
            goto L1
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlSerializer.writeEscaped(java.lang.String, int):void");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) {
        if (!this.pending) {
            throw new IllegalStateException("illegal position for attribute");
        }
        if (str == null) {
            str = "";
        }
        String prefix = "".equals(str) ? "" : getPrefix(str, false, true);
        this.writer.write(32);
        if (!"".equals(prefix)) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(str2);
        this.writer.write(61);
        int i3 = str3.indexOf(34) != -1 ? 39 : 34;
        this.writer.write(i3);
        writeEscaped(str3, i3);
        this.writer.write(i3);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) {
        check(false);
        this.writer.write("<![CDATA[");
        this.writer.write(str);
        this.writer.write("]]>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) {
        check(false);
        this.writer.write("<!--");
        this.writer.write(str);
        this.writer.write("-->");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) {
        this.writer.write("<!DOCTYPE");
        this.writer.write(str);
        this.writer.write(">");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() {
        while (true) {
            if (this.depth <= 0) {
                flush();
                return;
            } else {
                String[] strArr = this.elementStack;
                endTag(strArr[(r0 * 3) - 3], strArr[(r0 * 3) - 1]);
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) {
        if (!this.pending) {
            this.depth--;
        }
        if ((str == null && this.elementStack[this.depth * 3] != null) || ((str != null && !str.equals(this.elementStack[this.depth * 3])) || !this.elementStack[(this.depth * 3) + 2].equals(str2))) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("</{");
            stringBuffer.append(str);
            stringBuffer.append("}");
            stringBuffer.append(str2);
            stringBuffer.append("> does not match start");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (this.pending) {
            check(true);
            this.depth--;
        } else {
            if (this.indent[this.depth + 1]) {
                this.writer.write(IOUtils.LINE_SEPARATOR_WINDOWS);
                for (int i3 = 0; i3 < this.depth; i3++) {
                    this.writer.write("  ");
                }
            }
            this.writer.write("</");
            String str3 = this.elementStack[(this.depth * 3) + 1];
            if (!"".equals(str3)) {
                this.writer.write(str3);
                this.writer.write(58);
            }
            this.writer.write(str2);
            this.writer.write(62);
        }
        int[] iArr = this.nspCounts;
        int i4 = this.depth;
        iArr[i4 + 1] = iArr[i4];
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) {
        check(false);
        this.writer.write(38);
        this.writer.write(str);
        this.writer.write(59);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() {
        check(false);
        this.writer.flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        return this.pending ? this.depth + 1 : this.depth;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            return this.indent[this.depth];
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 1];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 3];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z3) {
        try {
            return getPrefix(str, false, z3);
        } catch (IOException e3) {
            throw new RuntimeException(e3.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new RuntimeException("Unsupported property");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) {
        text(str);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) {
        check(false);
        this.writer.write("<?");
        this.writer.write(str);
        this.writer.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z3) {
        if (!"http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            throw new RuntimeException("Unsupported Feature");
        }
        this.indent[this.depth] = z3;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        setOutput(str == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, str));
        this.encoding = str;
        if (str == null || !str.toLowerCase().startsWith("utf")) {
            return;
        }
        this.unicode = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        this.writer = writer;
        int[] iArr = this.nspCounts;
        iArr[0] = 2;
        iArr[1] = 2;
        String[] strArr = this.nspStack;
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "xml";
        strArr[3] = "http://www.w3.org/XML/1998/namespace";
        this.pending = false;
        this.auto = 0;
        this.depth = 0;
        this.unicode = false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        check(false);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.equals(getPrefix(str2, true, false))) {
            return;
        }
        int[] iArr = this.nspCounts;
        int i3 = this.depth + 1;
        int i4 = iArr[i3];
        iArr[i3] = i4 + 1;
        int i5 = i4 << 1;
        String[] strArr = this.nspStack;
        int i6 = i5 + 1;
        if (strArr.length < i6) {
            String[] strArr2 = new String[strArr.length + 16];
            System.arraycopy(strArr, 0, strArr2, 0, i5);
            this.nspStack = strArr2;
        }
        String[] strArr3 = this.nspStack;
        strArr3[i5] = str;
        strArr3[i6] = str2;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unsupported Property:");
        stringBuffer.append(obj);
        throw new RuntimeException(stringBuffer.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) {
        this.writer.write("<?xml version='1.0' ");
        if (str != null) {
            this.encoding = str;
            if (str.toLowerCase().startsWith("utf")) {
                this.unicode = true;
            }
        }
        if (this.encoding != null) {
            this.writer.write("encoding='");
            this.writer.write(this.encoding);
            this.writer.write("' ");
        }
        if (bool != null) {
            this.writer.write("standalone='");
            this.writer.write(bool.booleanValue() ? "yes" : "no");
            this.writer.write("' ");
        }
        this.writer.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) {
        check(false);
        if (this.indent[this.depth]) {
            this.writer.write(IOUtils.LINE_SEPARATOR_WINDOWS);
            for (int i3 = 0; i3 < this.depth; i3++) {
                this.writer.write("  ");
            }
        }
        int i4 = this.depth * 3;
        String[] strArr = this.elementStack;
        if (strArr.length < i4 + 3) {
            String[] strArr2 = new String[strArr.length + 12];
            System.arraycopy(strArr, 0, strArr2, 0, i4);
            this.elementStack = strArr2;
        }
        String prefix = str == null ? "" : getPrefix(str, true, true);
        if ("".equals(str)) {
            for (int i5 = this.nspCounts[this.depth]; i5 < this.nspCounts[this.depth + 1]; i5++) {
                int i6 = i5 * 2;
                if ("".equals(this.nspStack[i6]) && !"".equals(this.nspStack[i6 + 1])) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        String[] strArr3 = this.elementStack;
        int i7 = i4 + 1;
        strArr3[i4] = str;
        strArr3[i7] = prefix;
        strArr3[i7 + 1] = str2;
        this.writer.write(60);
        if (!"".equals(prefix)) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(str2);
        this.pending = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) {
        check(false);
        this.indent[this.depth] = false;
        writeEscaped(str, -1);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i3, int i4) {
        text(new String(cArr, i3, i4));
        return this;
    }
}
