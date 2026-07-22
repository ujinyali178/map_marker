package w2;

/* loaded from: /root/release/classes2.dex */
public enum i0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4472a;

        static {
            int[] iArr = new int[i0.values().length];
            iArr[i0.DEFAULT.ordinal()] = 1;
            iArr[i0.ATOMIC.ordinal()] = 2;
            iArr[i0.UNDISPATCHED.ordinal()] = 3;
            iArr[i0.LAZY.ordinal()] = 4;
            f4472a = iArr;
        }
    }

    public final <R, T> void b(p2.p<? super R, ? super i2.d<? super T>, ? extends Object> pVar, R r3, i2.d<? super T> dVar) {
        int i3 = a.f4472a[ordinal()];
        if (i3 == 1) {
            b3.a.d(pVar, r3, dVar, null, 4, null);
            return;
        }
        if (i3 == 2) {
            i2.f.a(pVar, r3, dVar);
        } else if (i3 == 3) {
            b3.b.a(pVar, r3, dVar);
        } else if (i3 != 4) {
            throw new g2.i();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
