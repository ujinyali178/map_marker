package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, z> f1289a = new LinkedHashMap();

    public final void a() {
        Iterator<z> it = this.f1289a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f1289a.clear();
    }

    public final z b(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        return this.f1289a.get(key);
    }

    public final Set<String> c() {
        return new HashSet(this.f1289a.keySet());
    }

    public final void d(String key, z viewModel) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(viewModel, "viewModel");
        z put = this.f1289a.put(key, viewModel);
        if (put != null) {
            put.d();
        }
    }
}
