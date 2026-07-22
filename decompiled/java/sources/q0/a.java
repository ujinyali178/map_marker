package q0;

import android.util.SparseArray;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4092a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final SparseArray<r0.a> f4093b = new SparseArray<>();

    private a() {
    }

    public final r0.a a(int i3) {
        return f4093b.get(i3);
    }

    public final void b(r0.a handler) {
        k.e(handler, "handler");
        f4093b.append(handler.a(), handler);
    }
}
