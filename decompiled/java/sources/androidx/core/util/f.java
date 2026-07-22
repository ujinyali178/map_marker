package androidx.core.util;

/* loaded from: /root/release/classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f763a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static char[] f764b = new char[24];

    private static int a(int i3, int i4, boolean z3, int i5) {
        if (i3 > 99 || (z3 && i5 >= 3)) {
            return i4 + 3;
        }
        if (i3 > 9 || (z3 && i5 >= 2)) {
            return i4 + 2;
        }
        if (z3 || i3 > 0) {
            return i4 + 1;
        }
        return 0;
    }

    public static void b(long j3, StringBuilder sb) {
        synchronized (f763a) {
            sb.append(f764b, 0, c(j3, 0));
        }
    }

    private static int c(long j3, int i3) {
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j4 = j3;
        if (f764b.length < i3) {
            f764b = new char[i3];
        }
        char[] cArr = f764b;
        if (j4 == 0) {
            int i9 = i3 - 1;
            while (i9 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j4 > 0) {
            c3 = '+';
        } else {
            c3 = '-';
            j4 = -j4;
        }
        int i10 = (int) (j4 % 1000);
        int floor = (int) Math.floor(j4 / 1000);
        if (floor > 86400) {
            i4 = floor / 86400;
            floor -= 86400 * i4;
        } else {
            i4 = 0;
        }
        if (floor > 3600) {
            i5 = floor / 3600;
            floor -= i5 * 3600;
        } else {
            i5 = 0;
        }
        if (floor > 60) {
            int i11 = floor / 60;
            i6 = floor - (i11 * 60);
            i7 = i11;
        } else {
            i6 = floor;
            i7 = 0;
        }
        if (i3 != 0) {
            int a4 = a(i4, 1, false, 0);
            int a5 = a4 + a(i5, 1, a4 > 0, 2);
            int a6 = a5 + a(i7, 1, a5 > 0, 2);
            int a7 = a6 + a(i6, 1, a6 > 0, 2);
            i8 = 0;
            for (int a8 = a7 + a(i10, 2, true, a7 > 0 ? 3 : 0) + 1; a8 < i3; a8++) {
                cArr[i8] = ' ';
                i8++;
            }
        } else {
            i8 = 0;
        }
        cArr[i8] = c3;
        int i12 = i8 + 1;
        boolean z3 = i3 != 0;
        int d3 = d(cArr, i4, 'd', i12, false, 0);
        int d4 = d(cArr, i5, 'h', d3, d3 != i12, z3 ? 2 : 0);
        int d5 = d(cArr, i7, 'm', d4, d4 != i12, z3 ? 2 : 0);
        int d6 = d(cArr, i6, 's', d5, d5 != i12, z3 ? 2 : 0);
        int d7 = d(cArr, i10, 'm', d6, true, (!z3 || d6 == i12) ? 0 : 3);
        cArr[d7] = 's';
        return d7 + 1;
    }

    private static int d(char[] cArr, int i3, char c3, int i4, boolean z3, int i5) {
        int i6;
        if (!z3 && i3 <= 0) {
            return i4;
        }
        if ((!z3 || i5 < 3) && i3 <= 99) {
            i6 = i4;
        } else {
            int i7 = i3 / 100;
            cArr[i4] = (char) (i7 + 48);
            i6 = i4 + 1;
            i3 -= i7 * 100;
        }
        if ((z3 && i5 >= 2) || i3 > 9 || i4 != i6) {
            int i8 = i3 / 10;
            cArr[i6] = (char) (i8 + 48);
            i6++;
            i3 -= i8 * 10;
        }
        cArr[i6] = (char) (i3 + 48);
        int i9 = i6 + 1;
        cArr[i9] = c3;
        return i9 + 1;
    }
}
