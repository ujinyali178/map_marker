package com.google.common.base;

import com.google.maps.android.BuildConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Strings {
    private Strings() {
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i3 = 0;
        while (i3 < min && charSequence.charAt(i3) == charSequence2.charAt(i3)) {
            i3++;
        }
        int i4 = i3 - 1;
        if (validSurrogatePairAt(charSequence, i4) || validSurrogatePairAt(charSequence2, i4)) {
            i3--;
        }
        return charSequence.subSequence(0, i3).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i3 = 0;
        while (i3 < min && charSequence.charAt((charSequence.length() - i3) - 1) == charSequence2.charAt((charSequence2.length() - i3) - 1)) {
            i3++;
        }
        if (validSurrogatePairAt(charSequence, (charSequence.length() - i3) - 1) || validSurrogatePairAt(charSequence2, (charSequence2.length() - i3) - 1)) {
            i3--;
        }
        return charSequence.subSequence(charSequence.length() - i3, charSequence.length()).toString();
    }

    @CheckForNull
    public static String emptyToNull(@CheckForNull String str) {
        return Platform.emptyToNull(str);
    }

    public static boolean isNullOrEmpty(@CheckForNull String str) {
        return Platform.stringIsNullOrEmpty(str);
    }

    public static String lenientFormat(@CheckForNull String str, @CheckForNull Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i3 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i4 = 0; i4 < objArr.length; i4++) {
                objArr[i4] = lenientToString(objArr[i4]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i5 = 0;
        while (i3 < objArr.length && (indexOf = valueOf.indexOf("%s", i5)) != -1) {
            sb.append((CharSequence) valueOf, i5, indexOf);
            sb.append(objArr[i3]);
            i5 = indexOf + 2;
            i3++;
        }
        sb.append((CharSequence) valueOf, i5, valueOf.length());
        if (i3 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i3]);
            for (int i6 = i3 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String lenientToString(@CheckForNull Object obj) {
        if (obj == null) {
            return BuildConfig.TRAVIS;
        }
        try {
            return obj.toString();
        } catch (Exception e3) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e3);
            return "<" + str + " threw " + e3.getClass().getName() + ">";
        }
    }

    public static String nullToEmpty(@CheckForNull String str) {
        return Platform.nullToEmpty(str);
    }

    public static String padEnd(String str, int i3, char c3) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i3) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i3);
        sb.append(str);
        for (int length = str.length(); length < i3; length++) {
            sb.append(c3);
        }
        return sb.toString();
    }

    public static String padStart(String str, int i3, char c3) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i3) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i3);
        for (int length = str.length(); length < i3; length++) {
            sb.append(c3);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String repeat(String str, int i3) {
        Preconditions.checkNotNull(str);
        if (i3 <= 1) {
            Preconditions.checkArgument(i3 >= 0, "invalid count: %s", i3);
            return i3 == 0 ? "" : str;
        }
        int length = str.length();
        long j3 = length * i3;
        int i4 = (int) j3;
        if (i4 != j3) {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j3);
        }
        char[] cArr = new char[i4];
        str.getChars(0, length, cArr, 0);
        while (true) {
            int i5 = i4 - length;
            if (length >= i5) {
                System.arraycopy(cArr, 0, cArr, length, i5);
                return new String(cArr);
            }
            System.arraycopy(cArr, 0, cArr, length, length);
            length <<= 1;
        }
    }

    static boolean validSurrogatePairAt(CharSequence charSequence, int i3) {
        return i3 >= 0 && i3 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i3)) && Character.isLowSurrogate(charSequence.charAt(i3 + 1));
    }
}
