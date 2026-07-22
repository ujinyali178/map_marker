package com.google.gson.stream;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.maps.android.BuildConfig;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.io.FilenameUtils;

/* loaded from: /root/release/classes.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[UserVerificationMethods.USER_VERIFY_ALL];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 0 + 1;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) {
                int i3;
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i4 = jsonReader.peeked;
                if (i4 == 0) {
                    i4 = jsonReader.doPeek();
                }
                if (i4 == 13) {
                    i3 = 9;
                } else if (i4 == 12) {
                    i3 = 8;
                } else {
                    if (i4 != 14) {
                        throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                    }
                    i3 = 10;
                }
                jsonReader.peeked = i3;
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private void checkLenient() {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() {
        nextNonWhitespace(true);
        int i3 = this.pos - 1;
        this.pos = i3;
        if (i3 + 5 <= this.limit || fillBuffer(5)) {
            char[] cArr = this.buffer;
            if (cArr[i3] == ')' && cArr[i3 + 1] == ']' && cArr[i3 + 2] == '}' && cArr[i3 + 3] == '\'' && cArr[i3 + 4] == '\n') {
                this.pos += 5;
            }
        }
    }

    private boolean fillBuffer(int i3) {
        int i4;
        int i5;
        char[] cArr = this.buffer;
        int i6 = this.lineStart;
        int i7 = this.pos;
        this.lineStart = i6 - i7;
        int i8 = this.limit;
        if (i8 != i7) {
            int i9 = i8 - i7;
            this.limit = i9;
            System.arraycopy(cArr, i7, cArr, 0, i9);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i10 = this.limit;
            int read = reader.read(cArr, i10, cArr.length - i10);
            if (read == -1) {
                return false;
            }
            i4 = this.limit + read;
            this.limit = i4;
            if (this.lineNumber == 0 && (i5 = this.lineStart) == 0 && i4 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i5 + 1;
                i3++;
            }
        } while (i4 < i3);
        return true;
    }

    private boolean isLiteral(char c3) {
        if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
            return false;
        }
        if (c3 != '#') {
            if (c3 == ',') {
                return false;
            }
            if (c3 != '/' && c3 != '=') {
                if (c3 == '{' || c3 == '}' || c3 == ':') {
                    return false;
                }
                if (c3 != ';') {
                    switch (c3) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        if (r1 != '/') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        if (r4 != r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r7.pos = r4 - 1;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r2 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
    
        checkLenient();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        if (r3 == '*') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
    
        if (skipTo("*\/") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
    
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        if (r3 == '/') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0078, code lost:
    
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0077, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0098, code lost:
    
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
    
        if (r1 != '#') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009e, code lost:
    
        checkLenient();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a2, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int nextNonWhitespace(boolean r8) {
        /*
            r7 = this;
            char[] r0 = r7.buffer
        L2:
            int r1 = r7.pos
        L4:
            int r2 = r7.limit
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r7.pos = r1
            boolean r1 = r7.fillBuffer(r3)
            if (r1 != 0) goto L30
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r7.locationString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L30:
            int r1 = r7.pos
            int r2 = r7.limit
        L34:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L44
            int r1 = r7.lineNumber
            int r1 = r1 + r3
            r7.lineNumber = r1
            r7.lineStart = r4
            goto La3
        L44:
            r5 = 32
            if (r1 == r5) goto La3
            r5 = 13
            if (r1 == r5) goto La3
            r5 = 9
            if (r1 != r5) goto L51
            goto La3
        L51:
            r5 = 47
            if (r1 != r5) goto L98
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L6a
            int r4 = r4 + (-1)
            r7.pos = r4
            boolean r2 = r7.fillBuffer(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L6a
            return r1
        L6a:
            r7.checkLenient()
            int r2 = r7.pos
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L80
            if (r3 == r5) goto L78
            return r1
        L78:
            int r2 = r2 + 1
            r7.pos = r2
        L7c:
            r7.skipToEndOfLine()
            goto L2
        L80:
            int r2 = r2 + 1
            r7.pos = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.skipTo(r1)
            if (r1 == 0) goto L91
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L4
        L91:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.syntaxError(r8)
            throw r8
        L98:
            r2 = 35
            r7.pos = r4
            if (r1 != r2) goto La2
            r7.checkLenient()
            goto L7c
        La2:
            return r1
        La3:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(char c3) {
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        while (true) {
            int i3 = this.pos;
            int i4 = this.limit;
            while (true) {
                if (i3 < i4) {
                    int i5 = i3 + 1;
                    char c4 = cArr[i3];
                    if (c4 == c3) {
                        this.pos = i5;
                        int i6 = (i5 - i3) - 1;
                        if (sb == null) {
                            return new String(cArr, i3, i6);
                        }
                        sb.append(cArr, i3, i6);
                        return sb.toString();
                    }
                    if (c4 == '\\') {
                        this.pos = i5;
                        int i7 = (i5 - i3) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i3, i7);
                        sb.append(readEscapeCharacter());
                    } else {
                        if (c4 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i5;
                        }
                        i3 = i5;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i3 - i3) * 2, 16));
                    }
                    sb.append(cArr, i3, i3 - i3);
                    this.pos = i3;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        checkLenient();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String nextUnquotedValue() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L4e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.checkLenient()
            goto L5c
        L4e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r1.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() {
        int i3;
        String str;
        String str2;
        char c3 = this.buffer[this.pos];
        if (c3 == 't' || c3 == 'T') {
            i3 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c3 == 'f' || c3 == 'F') {
            i3 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (c3 != 'n' && c3 != 'N') {
                return 0;
            }
            i3 = 7;
            str = BuildConfig.TRAVIS;
            str2 = "NULL";
        }
        int length = str.length();
        for (int i4 = 1; i4 < length; i4++) {
            if (this.pos + i4 >= this.limit && !fillBuffer(i4 + 1)) {
                return 0;
            }
            char c4 = this.buffer[this.pos + i4];
            if (c4 != str.charAt(i4) && c4 != str2.charAt(i4)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0097, code lost:
    
        if (r9 != 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0099, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009f, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a1, code lost:
    
        if (r13 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        if (r13 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ae, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00af, code lost:
    
        r18.peekedLong = r11;
        r18.pos += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b8, code lost:
    
        r18.peeked = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
    
        if (r9 == 2) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
    
        if (r9 == 4) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c1, code lost:
    
        if (r9 != 7) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c4, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        r18.peekedNumberLength = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0095, code lost:
    
        if (isLiteral(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00cb, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int peekNumber() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.peekNumber():int");
    }

    private void push(int i3) {
        int i4 = this.stackSize;
        int[] iArr = this.stack;
        if (i4 == iArr.length) {
            int i5 = i4 * 2;
            this.stack = Arrays.copyOf(iArr, i5);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i5);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i5);
        }
        int[] iArr2 = this.stack;
        int i6 = this.stackSize;
        this.stackSize = i6 + 1;
        iArr2[i6] = i3;
    }

    private char readEscapeCharacter() {
        int i3;
        int i4;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i5 = this.pos;
        int i6 = i5 + 1;
        this.pos = i6;
        char c3 = cArr[i5];
        if (c3 == '\n') {
            this.lineNumber++;
            this.lineStart = i6;
        } else if (c3 != '\"' && c3 != '\'' && c3 != '/' && c3 != '\\') {
            if (c3 == 'b') {
                return '\b';
            }
            if (c3 == 'f') {
                return '\f';
            }
            if (c3 == 'n') {
                return '\n';
            }
            if (c3 == 'r') {
                return '\r';
            }
            if (c3 == 't') {
                return '\t';
            }
            if (c3 != 'u') {
                throw syntaxError("Invalid escape sequence");
            }
            if (i6 + 4 > this.limit && !fillBuffer(4)) {
                throw syntaxError("Unterminated escape sequence");
            }
            char c4 = 0;
            int i7 = this.pos;
            int i8 = i7 + 4;
            while (i7 < i8) {
                char c5 = this.buffer[i7];
                char c6 = (char) (c4 << 4);
                if (c5 < '0' || c5 > '9') {
                    if (c5 >= 'a' && c5 <= 'f') {
                        i3 = c5 - 'a';
                    } else {
                        if (c5 < 'A' || c5 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                        }
                        i3 = c5 - 'A';
                    }
                    i4 = i3 + 10;
                } else {
                    i4 = c5 - '0';
                }
                c4 = (char) (c6 + i4);
                i7++;
            }
            this.pos += 4;
            return c4;
        }
        return c3;
    }

    private void skipQuotedValue(char c3) {
        char[] cArr = this.buffer;
        while (true) {
            int i3 = this.pos;
            int i4 = this.limit;
            while (true) {
                if (i3 < i4) {
                    int i5 = i3 + 1;
                    char c4 = cArr[i3];
                    if (c4 == c3) {
                        this.pos = i5;
                        return;
                    }
                    if (c4 == '\\') {
                        this.pos = i5;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c4 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i5;
                        }
                        i3 = i5;
                    }
                } else {
                    this.pos = i3;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i3 = this.pos;
            if (cArr[i3] != '\n') {
                for (int i4 = 0; i4 < length; i4++) {
                    if (this.buffer[this.pos + i4] != str.charAt(i4)) {
                        break;
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i3 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() {
        char c3;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 + 1;
            this.pos = i4;
            c3 = cArr[i3];
            if (c3 == '\n') {
                this.lineNumber++;
                this.lineStart = i4;
                return;
            }
        } while (c3 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void skipUnquotedValue() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L51
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.checkLenient()
        L4b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L51:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 1) {
            push(3);
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    int doPeek() {
        int i3;
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i4 = this.stackSize;
        int i5 = iArr[i4 - 1];
        if (i5 == 1) {
            iArr[i4 - 1] = 2;
        } else {
            if (i5 != 2) {
                if (i5 == 3 || i5 == 5) {
                    iArr[i4 - 1] = 4;
                    if (i5 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                        if (nextNonWhitespace != 59) {
                            if (nextNonWhitespace != 125) {
                                throw syntaxError("Unterminated object");
                            }
                            this.peeked = 2;
                            return 2;
                        }
                        checkLenient();
                    }
                    int nextNonWhitespace2 = nextNonWhitespace(true);
                    if (nextNonWhitespace2 == 34) {
                        i3 = 13;
                    } else if (nextNonWhitespace2 == 39) {
                        checkLenient();
                        i3 = 12;
                    } else {
                        if (nextNonWhitespace2 == 125) {
                            if (i5 == 5) {
                                throw syntaxError("Expected name");
                            }
                            this.peeked = 2;
                            return 2;
                        }
                        checkLenient();
                        this.pos--;
                        if (!isLiteral((char) nextNonWhitespace2)) {
                            throw syntaxError("Expected name");
                        }
                        i3 = 14;
                    }
                } else if (i5 == 4) {
                    iArr[i4 - 1] = 5;
                    int nextNonWhitespace3 = nextNonWhitespace(true);
                    if (nextNonWhitespace3 != 58) {
                        if (nextNonWhitespace3 != 61) {
                            throw syntaxError("Expected ':'");
                        }
                        checkLenient();
                        if (this.pos < this.limit || fillBuffer(1)) {
                            char[] cArr = this.buffer;
                            int i6 = this.pos;
                            if (cArr[i6] == '>') {
                                this.pos = i6 + 1;
                            }
                        }
                    }
                } else if (i5 == 6) {
                    if (this.lenient) {
                        consumeNonExecutePrefix();
                    }
                    this.stack[this.stackSize - 1] = 7;
                } else if (i5 == 7) {
                    if (nextNonWhitespace(false) == -1) {
                        i3 = 17;
                    } else {
                        checkLenient();
                        this.pos--;
                    }
                } else if (i5 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.peeked = i3;
                return i3;
            }
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 44) {
                if (nextNonWhitespace4 != 59) {
                    if (nextNonWhitespace4 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 != 34) {
            if (nextNonWhitespace5 == 39) {
                checkLenient();
                this.peeked = 8;
                return 8;
            }
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                }
                if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 == 123) {
                        this.peeked = 1;
                        return 1;
                    }
                    this.pos--;
                    int peekKeyword = peekKeyword();
                    if (peekKeyword != 0) {
                        return peekKeyword;
                    }
                    int peekNumber = peekNumber();
                    if (peekNumber != 0) {
                        return peekNumber;
                    }
                    if (!isLiteral(this.buffer[this.pos])) {
                        throw syntaxError("Expected value");
                    }
                    checkLenient();
                    i3 = 10;
                } else if (i5 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i5 != 1 && i5 != 2) {
                throw syntaxError("Unexpected value");
            }
            checkLenient();
            this.pos--;
            this.peeked = 7;
            return 7;
        }
        i3 = 9;
        this.peeked = i3;
        return i3;
    }

    public void endArray() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
        int i4 = this.stackSize - 1;
        this.stackSize = i4;
        int[] iArr = this.pathIndices;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.peeked = 0;
    }

    public void endObject() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
        int i4 = this.stackSize - 1;
        this.stackSize = i4;
        this.pathNames[i4] = null;
        int[] iArr = this.pathIndices;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.peeked = 0;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = this.stackSize;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.stack[i4];
            if (i5 == 1 || i5 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i4]);
                sb.append(']');
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                String str = this.pathNames[i4];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        return (i3 == 2 || i3 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr[i4] = iArr[i4] + 1;
            return true;
        }
        if (i3 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() {
        String nextQuotedValue;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.peekedLong;
        }
        if (i3 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i3 == 8 || i3 == 9) {
                nextQuotedValue = nextQuotedValue(i3 == 8 ? '\'' : '\"');
            } else if (i3 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else if (i3 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peekedString = nextQuotedValue;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i5 = this.stackSize - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return parseDouble;
    }

    public int nextInt() {
        String nextQuotedValue;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 15) {
            long j3 = this.peekedLong;
            int i4 = (int) j3;
            if (j3 == i4) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i5 = this.stackSize - 1;
                iArr[i5] = iArr[i5] + 1;
                return i4;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i3 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            }
            if (i3 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i3 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i6 = this.stackSize - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i7 = (int) parseDouble;
        if (i7 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i8 = this.stackSize - 1;
        iArr3[i8] = iArr3[i8] + 1;
        return i7;
    }

    public long nextLong() {
        String nextQuotedValue;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.peekedLong;
        }
        if (i3 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            }
            if (i3 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i3 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i5 = this.stackSize - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j3 = (long) parseDouble;
        if (j3 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return j3;
    }

    public String nextName() {
        char c3;
        String nextQuotedValue;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else {
            if (i3 == 12) {
                c3 = '\'';
            } else {
                if (i3 != 13) {
                    throw new IllegalStateException("Expected a name but was " + peek() + locationString());
                }
                c3 = '\"';
            }
            nextQuotedValue = nextQuotedValue(c3);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr[i4] = iArr[i4] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() {
        String str;
        char c3;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 10) {
            str = nextUnquotedValue();
        } else {
            if (i3 == 8) {
                c3 = '\'';
            } else if (i3 == 9) {
                c3 = '\"';
            } else if (i3 == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i3 == 15) {
                str = Long.toString(this.peekedLong);
            } else {
                if (i3 != 16) {
                    throw new IllegalStateException("Expected a string but was " + peek() + locationString());
                }
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            }
            str = nextQuotedValue(c3);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i4 = this.stackSize - 1;
        iArr[i4] = iArr[i4] + 1;
        return str;
    }

    public JsonToken peek() {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        switch (i3) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z3) {
        this.lenient = z3;
    }

    public void skipValue() {
        char c3;
        int i3 = 0;
        do {
            int i4 = this.peeked;
            if (i4 == 0) {
                i4 = doPeek();
            }
            if (i4 == 3) {
                push(1);
            } else if (i4 == 1) {
                push(3);
            } else {
                if (i4 == 4 || i4 == 2) {
                    this.stackSize--;
                    i3--;
                } else if (i4 == 14 || i4 == 10) {
                    skipUnquotedValue();
                } else {
                    if (i4 == 8 || i4 == 12) {
                        c3 = '\'';
                    } else if (i4 == 9 || i4 == 13) {
                        c3 = '\"';
                    } else if (i4 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    skipQuotedValue(c3);
                }
                this.peeked = 0;
            }
            i3++;
            this.peeked = 0;
        } while (i3 != 0);
        int[] iArr = this.pathIndices;
        int i5 = this.stackSize;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.pathNames[i5 - 1] = BuildConfig.TRAVIS;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
