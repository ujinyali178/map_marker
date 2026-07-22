package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes2.dex */
public final /* synthetic */ class e0 {
    public static final int a(String str, int i3, int i4, int i5) {
        return (int) c0.c(str, i3, i4, i5);
    }

    public static final long b(String str, long j3, long j4, long j5) {
        Long f3;
        String d3 = c0.d(str);
        if (d3 == null) {
            return j3;
        }
        f3 = v2.l.f(d3);
        if (f3 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d3 + '\'').toString());
        }
        long longValue = f3.longValue();
        boolean z3 = false;
        if (j4 <= longValue && longValue <= j5) {
            z3 = true;
        }
        if (z3) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j4 + ".." + j5 + ", but is '" + longValue + '\'').toString());
    }

    public static final boolean c(String str, boolean z3) {
        String d3 = c0.d(str);
        return d3 != null ? Boolean.parseBoolean(d3) : z3;
    }

    public static /* synthetic */ int d(String str, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i4 = 1;
        }
        if ((i6 & 8) != 0) {
            i5 = Integer.MAX_VALUE;
        }
        return c0.b(str, i3, i4, i5);
    }

    public static /* synthetic */ long e(String str, long j3, long j4, long j5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j4 = 1;
        }
        long j6 = j4;
        if ((i3 & 8) != 0) {
            j5 = Long.MAX_VALUE;
        }
        return c0.c(str, j3, j6, j5);
    }
}
