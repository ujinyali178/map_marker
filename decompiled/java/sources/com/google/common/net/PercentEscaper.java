package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z3) {
        Preconditions.checkNotNull(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (z3 && str2.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.plusForSpace = z3;
        this.safeOctets = createSafeOctets(str2);
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int i3 = -1;
        for (char c3 : charArray) {
            i3 = Math.max((int) c3, i3);
        }
        boolean[] zArr = new boolean[i3 + 1];
        for (char c4 : charArray) {
            zArr[c4] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i3);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    protected char[] escape(int i3) {
        boolean[] zArr = this.safeOctets;
        if (i3 < zArr.length && zArr[i3]) {
            return null;
        }
        if (i3 == 32 && this.plusForSpace) {
            return PLUS_SIGN;
        }
        if (i3 <= 127) {
            char[] cArr = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr[i3 >>> 4], cArr[i3 & 15]};
        }
        if (i3 <= 2047) {
            char[] cArr2 = UPPER_HEX_DIGITS;
            char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i3 & 15]};
            int i4 = i3 >>> 4;
            int i5 = i4 >>> 2;
            return cArr3;
        }
        if (i3 <= 65535) {
            char[] cArr4 = UPPER_HEX_DIGITS;
            char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i3 & 15]};
            int i6 = i3 >>> 4;
            int i7 = i6 >>> 2;
            int i8 = i7 >>> 4;
            return cArr5;
        }
        if (i3 > 1114111) {
            throw new IllegalArgumentException("Invalid unicode character value " + i3);
        }
        char[] cArr6 = UPPER_HEX_DIGITS;
        char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i3 & 15]};
        int i9 = i3 >>> 4;
        int i10 = i9 >>> 2;
        int i11 = i10 >>> 4;
        int i12 = i11 >>> 2;
        int i13 = i12 >>> 4;
        return cArr7;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected int nextEscapeIndex(CharSequence charSequence, int i3, int i4) {
        Preconditions.checkNotNull(charSequence);
        while (i3 < i4) {
            char charAt = charSequence.charAt(i3);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i3++;
        }
        return i3;
    }
}
