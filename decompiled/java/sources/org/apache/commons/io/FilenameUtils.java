package org.apache.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: /root/release/classes2.dex */
public class FilenameUtils {
    private static final int NOT_FOUND = -1;
    private static final char OTHER_SEPARATOR;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    public static final char EXTENSION_SEPARATOR = '.';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString(EXTENSION_SEPARATOR);
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    static {
        OTHER_SEPARATOR = isSystemWindows() ? '/' : '\\';
    }

    public static String concat(String str, String str2) {
        StringBuilder sb;
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            sb = new StringBuilder();
            sb.append(str);
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append('/');
        }
        sb.append(str2);
        return normalize(sb.toString());
    }

    public static boolean directoryContains(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (str2 == null) {
            return false;
        }
        IOCase iOCase = IOCase.SYSTEM;
        if (iOCase.checkEquals(str, str2)) {
            return false;
        }
        return iOCase.checkStartsWith(str2, str);
    }

    private static String doGetFullPath(String str, boolean z3) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            return z3 ? getPrefix(str) : str;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        if (indexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i3 = indexOfLastSeparator + (z3 ? 1 : 0);
        if (i3 == 0) {
            i3++;
        }
        return str.substring(0, i3);
    }

    private static String doGetPath(String str, int i3) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        int i4 = i3 + indexOfLastSeparator;
        if (prefixLength >= str.length() || indexOfLastSeparator < 0 || prefixLength >= i4) {
            return "";
        }
        String substring = str.substring(prefixLength, i4);
        failIfNullBytePresent(substring);
        return substring;
    }

    private static String doNormalize(String str, char c3, boolean z3) {
        boolean z4;
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        int i3 = length + 2;
        char[] cArr = new char[i3];
        str.getChars(0, str.length(), cArr, 0);
        char c4 = SYSTEM_SEPARATOR;
        if (c3 == c4) {
            c4 = OTHER_SEPARATOR;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (cArr[i4] == c4) {
                cArr[i4] = c3;
            }
        }
        if (cArr[length - 1] != c3) {
            cArr[length] = c3;
            length++;
            z4 = false;
        } else {
            z4 = true;
        }
        int i5 = prefixLength + 1;
        int i6 = i5;
        while (i6 < length) {
            if (cArr[i6] == c3) {
                int i7 = i6 - 1;
                if (cArr[i7] == c3) {
                    System.arraycopy(cArr, i6, cArr, i7, length - i6);
                    length--;
                    i6--;
                }
            }
            i6++;
        }
        int i8 = i5;
        while (i8 < length) {
            if (cArr[i8] == c3) {
                int i9 = i8 - 1;
                if (cArr[i9] == '.' && (i8 == i5 || cArr[i8 - 2] == c3)) {
                    if (i8 == length - 1) {
                        z4 = true;
                    }
                    System.arraycopy(cArr, i8 + 1, cArr, i9, length - i8);
                    length -= 2;
                    i8--;
                }
            }
            i8++;
        }
        int i10 = prefixLength + 2;
        int i11 = i10;
        while (i11 < length) {
            if (cArr[i11] == c3 && cArr[i11 - 1] == '.' && cArr[i11 - 2] == '.' && (i11 == i10 || cArr[i11 - 3] == c3)) {
                if (i11 == i10) {
                    return null;
                }
                if (i11 == length - 1) {
                    z4 = true;
                }
                int i12 = i11 - 4;
                while (true) {
                    if (i12 < prefixLength) {
                        int i13 = i11 + 1;
                        System.arraycopy(cArr, i13, cArr, prefixLength, length - i11);
                        length -= i13 - prefixLength;
                        i11 = i5;
                        break;
                    }
                    if (cArr[i12] == c3) {
                        int i14 = i12 + 1;
                        System.arraycopy(cArr, i11 + 1, cArr, i14, length - i11);
                        length -= i11 - i12;
                        i11 = i14;
                        break;
                    }
                    i12--;
                }
            }
            i11++;
        }
        return length <= 0 ? "" : length <= prefixLength ? new String(cArr, 0, length) : (z4 && z3) ? new String(cArr, 0, length) : new String(cArr, 0, length - 1);
    }

    public static boolean equals(String str, String str2) {
        return equals(str, str2, false, IOCase.SENSITIVE);
    }

    public static boolean equals(String str, String str2, boolean z3, IOCase iOCase) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z3) {
            str = normalize(str);
            str2 = normalize(str2);
            if (str == null || str2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        return iOCase.checkEquals(str, str2);
    }

    public static boolean equalsNormalized(String str, String str2) {
        return equals(str, str2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String str, String str2) {
        return equals(str, str2, true, IOCase.SYSTEM);
    }

    public static boolean equalsOnSystem(String str, String str2) {
        return equals(str, str2, false, IOCase.SYSTEM);
    }

    private static void failIfNullBytePresent(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String getBaseName(String str) {
        return removeExtension(getName(str));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension == -1 ? "" : str.substring(indexOfExtension + 1);
    }

    public static String getFullPath(String str) {
        return doGetFullPath(str, true);
    }

    public static String getFullPathNoEndSeparator(String str) {
        return doGetFullPath(str, false);
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    public static String getPath(String str) {
        return doGetPath(str, 1);
    }

    public static String getPathNoEndSeparator(String str) {
        return doGetPath(str, 0);
    }

    public static String getPrefix(String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength <= str.length()) {
            String substring = str.substring(0, prefixLength);
            failIfNullBytePresent(substring);
            return substring;
        }
        failIfNullBytePresent(str + '/');
        return str + '/';
    }

    public static int getPrefixLength(String str) {
        int min;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            return isSeparator(charAt) ? 1 : 0;
        }
        if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            min = Math.min(indexOf, indexOf2);
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = Character.toUpperCase(charAt);
                return (upperCase < 'A' || upperCase > 'Z') ? upperCase == '/' ? 1 : -1 : (length == 2 || !isSeparator(str.charAt(2))) ? 2 : 3;
            }
            if (!isSeparator(charAt) || !isSeparator(charAt2)) {
                return isSeparator(charAt) ? 1 : 0;
            }
            int indexOf3 = str.indexOf(47, 2);
            int indexOf4 = str.indexOf(92, 2);
            if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                return -1;
            }
            if (indexOf3 == -1) {
                indexOf3 = indexOf4;
            }
            if (indexOf4 == -1) {
                indexOf4 = indexOf3;
            }
            min = Math.min(indexOf3, indexOf4);
        }
        return min + 1;
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isExtension(String str, String str2) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        return (str2 == null || str2.isEmpty()) ? indexOfExtension(str) == -1 : getExtension(str).equals(str2);
    }

    public static boolean isExtension(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (collection == null || collection.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (extension.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(String str, String[] strArr) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (strArr == null || strArr.length == 0) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        for (String str2 : strArr) {
            if (extension.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSeparator(char c3) {
        return c3 == '/' || c3 == '\\';
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static String normalize(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, true);
    }

    public static String normalize(String str, boolean z3) {
        return doNormalize(str, z3 ? '/' : '\\', true);
    }

    public static String normalizeNoEndSeparator(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, false);
    }

    public static String normalizeNoEndSeparator(String str, boolean z3) {
        return doNormalize(str, z3 ? '/' : '\\', false);
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension == -1 ? str : str.substring(0, indexOfExtension);
    }

    public static String separatorsToSystem(String str) {
        if (str == null) {
            return null;
        }
        return isSystemWindows() ? separatorsToWindows(str) : separatorsToUnix(str);
    }

    public static String separatorsToUnix(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace('\\', '/');
    }

    public static String separatorsToWindows(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace('/', '\\');
    }

    static String[] splitOnTokens(String str) {
        String str2;
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i3 = 0;
        char c3 = 0;
        while (i3 < length) {
            char c4 = charArray[i3];
            if (c4 == '?' || c4 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c4 == '?') {
                    str2 = "?";
                } else if (c3 != '*') {
                    str2 = "*";
                }
                arrayList.add(str2);
            } else {
                sb.append(c4);
            }
            i3++;
            c3 = c4;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean wildcardMatch(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (iOCase == null) {
                iOCase = IOCase.SENSITIVE;
            }
            String[] splitOnTokens = splitOnTokens(str2);
            Stack stack = new Stack();
            boolean z3 = false;
            int i3 = 0;
            int i4 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i4 = iArr[0];
                    i3 = iArr[1];
                    z3 = true;
                }
                while (i4 < splitOnTokens.length) {
                    if (splitOnTokens[i4].equals("?")) {
                        i3++;
                        if (i3 > str.length()) {
                            break;
                        }
                        z3 = false;
                        i4++;
                    } else if (splitOnTokens[i4].equals("*")) {
                        if (i4 == splitOnTokens.length - 1) {
                            i3 = str.length();
                        }
                        z3 = true;
                        i4++;
                    } else {
                        if (z3) {
                            i3 = iOCase.checkIndexOf(str, i3, splitOnTokens[i4]);
                            if (i3 == -1) {
                                break;
                            }
                            int checkIndexOf = iOCase.checkIndexOf(str, i3 + 1, splitOnTokens[i4]);
                            if (checkIndexOf >= 0) {
                                stack.push(new int[]{i4, checkIndexOf});
                            }
                            i3 += splitOnTokens[i4].length();
                            z3 = false;
                        } else {
                            if (!iOCase.checkRegionMatches(str, i3, splitOnTokens[i4])) {
                                break;
                            }
                            i3 += splitOnTokens[i4].length();
                            z3 = false;
                        }
                        i4++;
                    }
                }
                if (i4 == splitOnTokens.length && i3 == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }

    public static boolean wildcardMatchOnSystem(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SYSTEM);
    }
}
