package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* loaded from: /root/release/classes.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', '\"'};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaf = {'\n'};
    private static final zai zag = new zaa();
    private static final zai zah = new zab();
    private static final zai zai = new zac();
    private static final zai zaj = new zad();
    private static final zai zak = new zae();
    private static final zai zal = new zaf();
    private static final zai zam = new zag();
    private static final zai zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[UserVerificationMethods.USER_VERIFY_ALL];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(UserVerificationMethods.USER_VERIFY_ALL);
    private final Stack zat = new Stack();

    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        throw new com.google.android.gms.common.server.response.FastParser.ParseException("Unexpected control character while reading string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String zaA(java.io.BufferedReader r8, char[] r9, java.lang.StringBuilder r10, char[] r11) {
        /*
            r0 = 0
            r10.setLength(r0)
            int r1 = r9.length
            r8.mark(r1)
            r1 = 0
            r2 = 0
        La:
            int r3 = r8.read(r9)
            r4 = -1
            if (r3 == r4) goto L63
            r4 = 0
        L12:
            if (r4 >= r3) goto L5b
            char r5 = r9[r4]
            boolean r6 = java.lang.Character.isISOControl(r5)
            if (r6 == 0) goto L31
            if (r11 == 0) goto L29
            r6 = 0
        L1f:
            if (r6 > 0) goto L29
            char r7 = r11[r6]
            if (r7 != r5) goto L26
            goto L31
        L26:
            int r6 = r6 + 1
            goto L1f
        L29:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected control character while reading string"
            r8.<init>(r9)
            throw r8
        L31:
            r6 = 34
            r7 = 1
            if (r5 != r6) goto L4e
            if (r2 != 0) goto L57
            r10.append(r9, r0, r4)
            r8.reset()
            int r4 = r4 + r7
            long r2 = (long) r4
            r8.skip(r2)
            java.lang.String r8 = r10.toString()
            if (r1 == 0) goto L4d
            java.lang.String r8 = com.google.android.gms.common.util.JsonUtils.unescapeString(r8)
        L4d:
            return r8
        L4e:
            r6 = 92
            if (r5 != r6) goto L57
            r1 = r2 ^ 1
            r2 = r1
            r1 = 1
            goto L58
        L57:
            r2 = 0
        L58:
            int r4 = r4 + 1
            goto L12
        L5b:
            r10.append(r9, r0, r3)
            int r3 = r9.length
            r8.mark(r3)
            goto La
        L63:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected EOF while parsing string"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaA(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    private final char zai(BufferedReader bufferedReader) {
        if (bufferedReader.read(this.zao) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return (char) 0;
            }
        }
        return this.zao[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        return zam2 == 0 ? BitmapDescriptorFactory.HUE_RED : Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) {
        int i3;
        int i4;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c3 = cArr[0];
        int i5 = c3 == '-' ? Integer.MIN_VALUE : -2147483647;
        int i6 = c3 == '-' ? 1 : 0;
        if (i6 < zam2) {
            i3 = i6 + 1;
            int digit = Character.digit(cArr[i6], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i4 = -digit;
        } else {
            i3 = i6;
            i4 = 0;
        }
        while (i3 < zam2) {
            int i7 = i3 + 1;
            int digit2 = Character.digit(cArr[i3], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i4 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i8 = i4 * 10;
            if (i8 < i5 + digit2) {
                throw new ParseException("Number too large");
            }
            i4 = i8 - digit2;
            i3 = i7;
        }
        if (i6 == 0) {
            return -i4;
        }
        if (i3 > 1) {
            return i4;
        }
        throw new ParseException("No digits to parse");
    }

    private final int zam(BufferedReader bufferedReader, char[] cArr) {
        int i3;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        }
        bufferedReader.mark(UserVerificationMethods.USER_VERIFY_ALL);
        if (zai2 == '\"') {
            i3 = 0;
            boolean z3 = false;
            while (i3 < 1024 && bufferedReader.read(cArr, i3, 1) != -1) {
                char c3 = cArr[i3];
                if (Character.isISOControl(c3)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
                if (c3 == '\"') {
                    if (!z3) {
                        bufferedReader.reset();
                        bufferedReader.skip(i3 + 1);
                        return i3;
                    }
                } else if (c3 == '\\') {
                    z3 = !z3;
                    i3++;
                }
                z3 = false;
                i3++;
            }
        } else {
            cArr[0] = zai2;
            i3 = 1;
            while (i3 < 1024 && bufferedReader.read(cArr, i3, 1) != -1) {
                char c4 = cArr[i3];
                if (c4 == '}' || c4 == ',' || Character.isWhitespace(c4) || cArr[i3] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i3 - 1);
                    cArr[i3] = 0;
                    return i3;
                }
                i3++;
            }
        }
        if (i3 == 1024) {
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) {
        long j3;
        int i3;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0L;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c3 = cArr[0];
        long j4 = c3 == '-' ? Long.MIN_VALUE : -9223372036854775807L;
        int i4 = c3 == '-' ? 1 : 0;
        if (i4 < zam2) {
            i3 = i4 + 1;
            int digit = Character.digit(cArr[i4], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j3 = -digit;
        } else {
            j3 = 0;
            i3 = i4;
        }
        while (i3 < zam2) {
            int i5 = i3 + 1;
            int digit2 = Character.digit(cArr[i3], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j3 < -922337203685477580L) {
                throw new ParseException("Number too large");
            }
            long j5 = j3 * 10;
            long j6 = digit2;
            if (j5 < j4 + j6) {
                throw new ParseException("Number too large");
            }
            j3 = j5 - j6;
            i3 = i5;
        }
        if (i4 == 0) {
            return -j3;
        }
        if (i3 > 1) {
            return j3;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zao(BufferedReader bufferedReader) {
        return zap(bufferedReader, this.zap, this.zar, null);
    }

    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb, cArr2);
        }
        if (zai2 != 'n') {
            throw new ParseException("Expected string");
        }
        zax(bufferedReader, zaa);
        return null;
    }

    private final String zaq(BufferedReader bufferedReader) {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        }
        if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        }
        if (zai2 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    private final String zar(BufferedReader bufferedReader) {
        bufferedReader.mark(UserVerificationMethods.USER_VERIFY_ALL);
        char zai2 = zai(bufferedReader);
        int i3 = 1;
        if (zai2 == '\"') {
            if (bufferedReader.read(this.zao) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c3 = this.zao[0];
            boolean z3 = false;
            do {
                if (c3 == '\"') {
                    if (z3) {
                        c3 = '\"';
                        z3 = true;
                    }
                }
                z3 = c3 == '\\' ? !z3 : false;
                if (bufferedReader.read(this.zao) == -1) {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                c3 = this.zao[0];
            } while (!Character.isISOControl(c3));
            throw new ParseException("Unexpected control character while reading string");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == '[') {
            this.zat.push(5);
            bufferedReader.mark(32);
            if (zai(bufferedReader) != ']') {
                bufferedReader.reset();
                boolean z4 = false;
                loop1: while (true) {
                    boolean z5 = false;
                    while (i3 > 0) {
                        char zai3 = zai(bufferedReader);
                        if (zai3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(zai3)) {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                        if (zai3 == '\"') {
                            if (!z5) {
                                z4 = !z4;
                            }
                            zai3 = '\"';
                        }
                        if (zai3 == '[') {
                            if (!z4) {
                                i3++;
                            }
                            zai3 = '[';
                        }
                        if (zai3 == ']' && !z4) {
                            i3--;
                        }
                        if (zai3 == '\\' && z4) {
                            z5 = !z5;
                        }
                    }
                    break loop1;
                }
            }
            zaw(5);
        } else if (zai2 != '{') {
            bufferedReader.reset();
            zam(bufferedReader, this.zaq);
        } else {
            this.zat.push(1);
            bufferedReader.mark(32);
            char zai4 = zai(bufferedReader);
            if (zai4 != '}') {
                if (zai4 != '\"') {
                    throw new ParseException("Unexpected token " + zai4);
                }
                bufferedReader.reset();
                zaq(bufferedReader);
                while (zar(bufferedReader) != null) {
                }
            }
            zaw(1);
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        }
        if (zai5 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token " + zai5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal zas(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger zat(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    private final ArrayList zau(BufferedReader bufferedReader, zai zaiVar) {
        char zai2 = zai(bufferedReader);
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        if (zai2 != '[') {
            throw new ParseException("Expected start of array");
        }
        this.zat.push(5);
        ArrayList arrayList = new ArrayList();
        while (true) {
            bufferedReader.mark(UserVerificationMethods.USER_VERIFY_ALL);
            char zai3 = zai(bufferedReader);
            if (zai3 == 0) {
                throw new ParseException("Unexpected EOF");
            }
            if (zai3 != ',') {
                if (zai3 == ']') {
                    zaw(5);
                    return arrayList;
                }
                bufferedReader.reset();
                arrayList.add(zaiVar.zaa(this, bufferedReader));
            }
        }
    }

    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) {
        ArrayList arrayList = new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        }
        if (zai2 != '{') {
            throw new ParseException("Unexpected token: " + zai2);
        }
        Stack stack = this.zat;
        while (true) {
            stack.push(1);
            try {
                FastJsonResponse zad2 = field.zad();
                if (!zaz(bufferedReader, zad2)) {
                    return arrayList;
                }
                arrayList.add(zad2);
                char zai3 = zai(bufferedReader);
                if (zai3 != ',') {
                    if (zai3 == ']') {
                        zaw(5);
                        return arrayList;
                    }
                    throw new ParseException("Unexpected token: " + zai3);
                }
                if (zai(bufferedReader) != '{') {
                    throw new ParseException("Expected start of next object in array");
                }
                stack = this.zat;
            } catch (IllegalAccessException e3) {
                throw new ParseException("Error instantiating inner object", e3);
            } catch (InstantiationException e4) {
                throw new ParseException("Error instantiating inner object", e4);
            }
        }
    }

    private final void zaw(int i3) {
        if (this.zat.isEmpty()) {
            throw new ParseException("Expected state " + i3 + " but had empty stack");
        }
        int intValue = ((Integer) this.zat.pop()).intValue();
        if (intValue == i3) {
            return;
        }
        throw new ParseException("Expected state " + i3 + " but had " + intValue);
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) {
        int i3 = 0;
        while (true) {
            int length = cArr.length;
            if (i3 >= length) {
                return;
            }
            int read = bufferedReader.read(this.zap, 0, length - i3);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i4 = 0; i4 < read; i4++) {
                if (cArr[i4 + i3] != this.zap[i4]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i3 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z3) {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            if (z3) {
                throw new ParseException("No boolean value found in string");
            }
            return zay(bufferedReader, true);
        }
        if (zai2 == 'f') {
            zax(bufferedReader, z3 ? zae : zad);
            return false;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return false;
        }
        if (zai2 == 't') {
            zax(bufferedReader, z3 ? zac : zab);
            return true;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq = zaq(bufferedReader);
        if (zaq == null) {
            zaw(1);
            return false;
        }
        while (zaq != null) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaq);
            if (field == null) {
                zaq = zar(bufferedReader);
            } else {
                this.zat.push(4);
                int i3 = field.zaa;
                switch (i3) {
                    case 0:
                        if (!field.zab) {
                            fastJsonResponse.zau(field, zal(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zav(field, zau(bufferedReader, zag));
                            break;
                        }
                    case 1:
                        if (!field.zab) {
                            fastJsonResponse.zae(field, zat(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zag(field, zau(bufferedReader, zam));
                            break;
                        }
                    case 2:
                        if (!field.zab) {
                            fastJsonResponse.zax(field, zan(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zay(field, zau(bufferedReader, zah));
                            break;
                        }
                    case 3:
                        if (!field.zab) {
                            fastJsonResponse.zaq(field, zak(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zas(field, zau(bufferedReader, zai));
                            break;
                        }
                    case 4:
                        if (!field.zab) {
                            fastJsonResponse.zam(field, zaj(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zao(field, zau(bufferedReader, zaj));
                            break;
                        }
                    case 5:
                        if (!field.zab) {
                            fastJsonResponse.zaa(field, zas(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zac(field, zau(bufferedReader, zan));
                            break;
                        }
                    case 6:
                        if (!field.zab) {
                            fastJsonResponse.zai(field, zay(bufferedReader, false));
                            break;
                        } else {
                            fastJsonResponse.zaj(field, zau(bufferedReader, zak));
                            break;
                        }
                    case 7:
                        if (!field.zab) {
                            fastJsonResponse.zaA(field, zao(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zaC(field, zau(bufferedReader, zal));
                            break;
                        }
                    case 8:
                        fastJsonResponse.zal(field, Base64Utils.decode(zap(bufferedReader, this.zaq, this.zas, zaf)));
                        break;
                    case 9:
                        fastJsonResponse.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader, this.zaq, this.zas, zaf)));
                        break;
                    case 10:
                        char zai2 = zai(bufferedReader);
                        if (zai2 == 'n') {
                            zax(bufferedReader, zaa);
                            hashMap = null;
                        } else {
                            if (zai2 != '{') {
                                throw new ParseException("Expected start of a map object");
                            }
                            this.zat.push(1);
                            hashMap = new HashMap();
                            while (true) {
                                char zai3 = zai(bufferedReader);
                                if (zai3 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                }
                                if (zai3 == '\"') {
                                    String zaA = zaA(bufferedReader, this.zap, this.zar, null);
                                    if (zai(bufferedReader) != ':') {
                                        throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                    }
                                    if (zai(bufferedReader) != '\"') {
                                        throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                    }
                                    hashMap.put(zaA, zaA(bufferedReader, this.zap, this.zar, null));
                                    char zai4 = zai(bufferedReader);
                                    if (zai4 != ',') {
                                        if (zai4 != '}') {
                                            throw new ParseException("Unexpected character while parsing string map: " + zai4);
                                        }
                                    }
                                } else if (zai3 != '}') {
                                }
                            }
                            zaw(1);
                        }
                        fastJsonResponse.zaB(field, hashMap);
                        break;
                    case 11:
                        if (field.zab) {
                            char zai5 = zai(bufferedReader);
                            if (zai5 == 'n') {
                                zax(bufferedReader, zaa);
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                break;
                            } else {
                                this.zat.push(5);
                                if (zai5 != '[') {
                                    throw new ParseException("Expected array start");
                                }
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                break;
                            }
                        } else {
                            char zai6 = zai(bufferedReader);
                            if (zai6 == 'n') {
                                zax(bufferedReader, zaa);
                                fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                break;
                            } else {
                                this.zat.push(1);
                                if (zai6 != '{') {
                                    throw new ParseException("Expected start of object");
                                }
                                try {
                                    FastJsonResponse zad2 = field.zad();
                                    zaz(bufferedReader, zad2);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, zad2);
                                    break;
                                } catch (IllegalAccessException e3) {
                                    throw new ParseException("Error instantiating inner object", e3);
                                } catch (InstantiationException e4) {
                                    throw new ParseException("Error instantiating inner object", e4);
                                }
                            }
                        }
                    default:
                        throw new ParseException("Invalid field type " + i3);
                }
                zaw(4);
                zaw(2);
                char zai7 = zai(bufferedReader);
                if (zai7 == ',') {
                    zaq = zaq(bufferedReader);
                } else {
                    if (zai7 != '}') {
                        throw new ParseException("Expected end of object or field separator, but found: " + zai7);
                    }
                    zaq = null;
                }
            }
        }
        zaw(1);
        return true;
    }

    public void parse(InputStream inputStream, T t3) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), UserVerificationMethods.USER_VERIFY_ALL);
        try {
            try {
                this.zat.push(0);
                char zai2 = zai(bufferedReader);
                if (zai2 == 0) {
                    throw new ParseException("No data to parse");
                }
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t3.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t3.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                } else {
                    if (zai2 != '{') {
                        throw new ParseException("Unexpected token: " + zai2);
                    }
                    this.zat.push(1);
                    zaz(bufferedReader, t3);
                }
                zaw(0);
            } catch (IOException e3) {
                throw new ParseException(e3);
            }
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
        }
    }
}
