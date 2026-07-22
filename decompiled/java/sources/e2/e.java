package e2;

/* loaded from: /root/release/classes.dex */
public final class e implements AutoCloseable {
    private e(String str) {
        a(str);
    }

    public static void a(String str) {
        s.b.c(c(str));
    }

    public static void b(String str, int i3) {
        s.b.a(c(str), i3);
    }

    private static String c(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void d() {
        s.b.f();
    }

    public static void e(String str, int i3) {
        s.b.d(c(str), i3);
    }

    public static e f(String str) {
        return new e(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        d();
    }
}
