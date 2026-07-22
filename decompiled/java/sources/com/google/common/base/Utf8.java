package com.google.common.base;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 < length) {
                char charAt = charSequence.charAt(i3);
                if (charAt >= 2048) {
                    i4 += encodedLengthGeneral(charSequence, i3);
                    break;
                }
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                break;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i4 + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
            } else {
                i4 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) == charAt) {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i3));
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i4;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i3, int i4) {
        int i5 = i4 + i3;
        Preconditions.checkPositionIndexes(i3, i5, bArr.length);
        while (i3 < i5) {
            if (bArr[i3] < 0) {
                return isWellFormedSlowPath(bArr, i3, i5);
            }
            i3++;
        }
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i3, int i4) {
        byte b4;
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b5 = bArr[i3];
            if (b5 < 0) {
                if (b5 < -32) {
                    if (i5 != i4 && b5 >= -62) {
                        i3 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return false;
                }
                if (b5 < -16) {
                    int i6 = i5 + 1;
                    if (i6 < i4 && (b4 = bArr[i5]) <= -65 && ((b5 != -32 || b4 >= -96) && (b5 != -19 || -96 > b4))) {
                        i3 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return false;
                }
                if (i5 + 2 >= i4) {
                    return false;
                }
                int i7 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 <= -65 && (((b5 << Ascii.FS) + (b6 + 112)) >> 30) == 0) {
                    int i8 = i7 + 1;
                    if (bArr[i7] <= -65) {
                        i5 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                }
                return false;
            }
            i3 = i5;
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i3) {
        return "Unpaired surrogate at index " + i3;
    }
}
