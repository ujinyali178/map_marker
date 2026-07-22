package kotlinx.coroutines.internal;

/* loaded from: /root/release/classes2.dex */
final /* synthetic */ class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3781a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f3781a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
