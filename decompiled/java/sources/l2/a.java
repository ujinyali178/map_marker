package l2;

import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public class a extends k2.a {

    /* renamed from: l2.a$a, reason: collision with other inner class name */
    private static final class C0096a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0096a f3921a = new C0096a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f3922b;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        static {
            /*
                l2.a$a r0 = new l2.a$a
                r0.<init>()
                l2.a.C0096a.f3921a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L20
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L21
            L1f:
            L20:
                r1 = r0
            L21:
                if (r1 == 0) goto L2f
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2b
                r2 = 1
                goto L2c
            L2b:
                r2 = 0
            L2c:
                if (r2 == 0) goto L2f
                r0 = r1
            L2f:
                l2.a.C0096a.f3922b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.a.C0096a.<clinit>():void");
        }

        private C0096a() {
        }
    }

    private final boolean c(int i3) {
        Integer num = C0096a.f3922b;
        return num == null || num.intValue() >= i3;
    }

    @Override // k2.a
    public void a(Throwable cause, Throwable exception) {
        k.e(cause, "cause");
        k.e(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
