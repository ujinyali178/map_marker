package kotlinx.coroutines.internal;

/* loaded from: /root/release/classes2.dex */
public final class l {
    public static final void a(int i3) {
        if (i3 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i3).toString());
    }
}
