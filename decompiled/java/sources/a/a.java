package a;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f0a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f1b;

    public final void a(b listener) {
        k.e(listener, "listener");
        Context context = this.f1b;
        if (context != null) {
            listener.a(context);
        }
        this.f0a.add(listener);
    }

    public final void b() {
        this.f1b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f1b = context;
        Iterator<b> it = this.f0a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    public final Context d() {
        return this.f1b;
    }

    public final void e(b listener) {
        k.e(listener, "listener");
        this.f0a.remove(listener);
    }
}
