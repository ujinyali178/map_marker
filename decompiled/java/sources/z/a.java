package z;

/* loaded from: /root/release/classes.dex */
public enum a {
    denied,
    deniedForever,
    whileInUse,
    always;

    /* renamed from: z.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0114a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4717a;

        static {
            int[] iArr = new int[a.values().length];
            f4717a = iArr;
            try {
                iArr[a.denied.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4717a[a.deniedForever.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4717a[a.whileInUse.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4717a[a.always.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public int b() {
        int i3 = C0114a.f4717a[ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        if (i3 == 4) {
            return 3;
        }
        throw new IndexOutOfBoundsException();
    }
}
