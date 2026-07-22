package e2;

/* loaded from: /root/release/classes.dex */
public final class c {
    public static <T> T a(T t3) {
        t3.getClass();
        return t3;
    }

    public static void b(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
