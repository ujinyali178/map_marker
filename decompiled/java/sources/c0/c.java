package c0;

/* loaded from: /root/release/classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private int f1676a;

    /* renamed from: b, reason: collision with root package name */
    private long f1677b;

    c(long j3, int i3) {
        this.f1677b = j3;
        this.f1676a = i3;
    }

    static c b(String str, int i3, int i4) {
        long j3;
        int i5;
        if (i3 >= i4) {
            return null;
        }
        long j4 = 0;
        int i6 = i3;
        while (i6 < i4) {
            char charAt = str.charAt(i6);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j3 = j4 * 16;
                    i5 = charAt - 'A';
                } else {
                    if (charAt < 'a' || charAt > 'f') {
                        break;
                    }
                    j3 = j4 * 16;
                    i5 = charAt - 'a';
                }
                j4 = j3 + i5 + 10;
            } else {
                j4 = (j4 * 16) + (charAt - '0');
            }
            if (j4 > 4294967295L) {
                return null;
            }
            i6++;
        }
        if (i6 == i3) {
            return null;
        }
        return new c(j4, i6);
    }

    static c c(String str, int i3, int i4, boolean z3) {
        if (i3 >= i4) {
            return null;
        }
        if (z3) {
            char charAt = str.charAt(i3);
            if (charAt != '+') {
                r1 = charAt == '-';
            }
            i3++;
        }
        long j3 = 0;
        int i5 = i3;
        while (i5 < i4) {
            char charAt2 = str.charAt(i5);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            long j4 = j3 * 10;
            long j5 = charAt2 - '0';
            if (r1) {
                j3 = j4 - j5;
                if (j3 < -2147483648L) {
                    return null;
                }
            } else {
                j3 = j4 + j5;
                if (j3 > 2147483647L) {
                    return null;
                }
            }
            i5++;
        }
        if (i5 == i3) {
            return null;
        }
        return new c(j3, i5);
    }

    int a() {
        return this.f1676a;
    }

    public int d() {
        return (int) this.f1677b;
    }
}
