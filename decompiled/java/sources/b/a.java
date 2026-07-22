package b;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public abstract class a<I, O> {

    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static final class C0038a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f1516a;

        public C0038a(T t3) {
            this.f1516a = t3;
        }

        public final T a() {
            return this.f1516a;
        }
    }

    public abstract Intent a(Context context, I i3);

    public C0038a<O> b(Context context, I i3) {
        k.e(context, "context");
        return null;
    }

    public abstract O c(int i3, Intent intent);
}
