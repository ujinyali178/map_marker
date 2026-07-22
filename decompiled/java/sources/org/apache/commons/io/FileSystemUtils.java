package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

@Deprecated
/* loaded from: /root/release/classes2.dex */
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        int i3;
        String property;
        String str = "df";
        try {
            property = System.getProperty("os.name");
        } catch (Exception unused) {
            i3 = -1;
        }
        if (property == null) {
            throw new IOException("os.name not found");
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
        i3 = 3;
        if (lowerCase.contains("windows")) {
            i3 = 1;
        } else {
            if (!lowerCase.contains("linux") && !lowerCase.contains("mpe/ix") && !lowerCase.contains("freebsd") && !lowerCase.contains("openbsd") && !lowerCase.contains("irix") && !lowerCase.contains("digital unix") && !lowerCase.contains("unix") && !lowerCase.contains("mac os x")) {
                if (!lowerCase.contains("sun os") && !lowerCase.contains("sunos") && !lowerCase.contains("solaris")) {
                    if (!lowerCase.contains("hp-ux") && !lowerCase.contains("aix")) {
                        i3 = 0;
                    }
                }
                str = "/usr/xpg4/bin/df";
            }
            i3 = 2;
        }
        OS = i3;
        DF = str;
    }

    @Deprecated
    public static long freeSpace(String str) {
        return INSTANCE.freeSpaceOS(str, OS, false, -1L);
    }

    @Deprecated
    public static long freeSpaceKb() {
        return freeSpaceKb(-1L);
    }

    @Deprecated
    public static long freeSpaceKb(long j3) {
        return freeSpaceKb(new File(".").getAbsolutePath(), j3);
    }

    @Deprecated
    public static long freeSpaceKb(String str) {
        return freeSpaceKb(str, -1L);
    }

    @Deprecated
    public static long freeSpaceKb(String str, long j3) {
        return INSTANCE.freeSpaceOS(str, OS, true, j3);
    }

    long freeSpaceOS(String str, int i3, boolean z3, long j3) {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be null");
        }
        if (i3 == 0) {
            throw new IllegalStateException("Unsupported operating system");
        }
        if (i3 == 1) {
            long freeSpaceWindows = freeSpaceWindows(str, j3);
            return z3 ? freeSpaceWindows / FileUtils.ONE_KB : freeSpaceWindows;
        }
        if (i3 == 2) {
            return freeSpaceUnix(str, z3, false, j3);
        }
        if (i3 == 3) {
            return freeSpaceUnix(str, z3, true, j3);
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    long freeSpaceUnix(String str, boolean z3, boolean z4, long j3) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String str2 = "-";
        if (z3) {
            str2 = "-k";
        }
        if (z4) {
            str2 = str2 + "P";
        }
        List<String> performCommand = performCommand(str2.length() > 1 ? new String[]{DF, str2, str} : new String[]{DF, str}, 3, j3);
        if (performCommand.size() < 2) {
            throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + str + "'- response was " + performCommand);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(performCommand.get(1), " ");
        if (stringTokenizer.countTokens() >= 4) {
            stringTokenizer.nextToken();
        } else {
            if (stringTokenizer.countTokens() != 1 || performCommand.size() < 3) {
                throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + str + "'- check path is valid");
            }
            stringTokenizer = new StringTokenizer(performCommand.get(2), " ");
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return parseBytes(stringTokenizer.nextToken(), str);
    }

    long freeSpaceWindows(String str, long j3) {
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize == null) {
            throw new IllegalArgumentException(str);
        }
        if (normalize.length() > 0 && normalize.charAt(0) != '\"') {
            normalize = "\"" + normalize + "\"";
        }
        List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /a /-c " + normalize}, Integer.MAX_VALUE, j3);
        for (int size = performCommand.size() - 1; size >= 0; size--) {
            String str2 = performCommand.get(size);
            if (str2.length() > 0) {
                return parseDir(str2, normalize);
            }
        }
        throw new IOException("Command line 'dir /-c' did not return any info for path '" + normalize + "'");
    }

    Process openProcess(String[] strArr) {
        return Runtime.getRuntime().exec(strArr);
    }

    long parseBytes(String str, String str2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e3) {
            throw new IOException("Command line '" + DF + "' did not return numeric data as expected for path '" + str2 + "'- check path is valid", e3);
        }
    }

    long parseDir(String str, String str2) {
        int i3;
        int i4;
        int i5;
        int length = str.length();
        while (true) {
            length--;
            i3 = 0;
            if (length < 0) {
                i4 = 0;
                break;
            }
            if (Character.isDigit(str.charAt(length))) {
                i4 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i5 = 0;
                break;
            }
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i5 = length + 1;
                break;
            }
            length--;
        }
        if (length < 0) {
            throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
        }
        StringBuilder sb = new StringBuilder(str.substring(i5, i4));
        while (i3 < sb.length()) {
            if (sb.charAt(i3) == ',' || sb.charAt(i3) == '.') {
                sb.deleteCharAt(i3);
                i3--;
            }
            i3++;
        }
        return parseBytes(sb.toString(), str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0127  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.List<java.lang.String> performCommand(java.lang.String[] r11, int r12, long r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileSystemUtils.performCommand(java.lang.String[], int, long):java.util.List");
    }
}
