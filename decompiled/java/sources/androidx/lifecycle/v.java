package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class v implements a.c {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.savedstate.a f1328a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1329b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f1330c;

    /* renamed from: d, reason: collision with root package name */
    private final g2.e f1331d;

    static final class a extends kotlin.jvm.internal.l implements p2.a<w> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e0 f1332c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0 e0Var) {
            super(0);
            this.f1332c = e0Var;
        }

        @Override // p2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w invoke() {
            return u.e(this.f1332c);
        }
    }

    public v(androidx.savedstate.a savedStateRegistry, e0 viewModelStoreOwner) {
        g2.e a4;
        kotlin.jvm.internal.k.e(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.k.e(viewModelStoreOwner, "viewModelStoreOwner");
        this.f1328a = savedStateRegistry;
        a4 = g2.g.a(new a(viewModelStoreOwner));
        this.f1331d = a4;
    }

    private final w c() {
        return (w) this.f1331d.getValue();
    }

    @Override // androidx.savedstate.a.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1330c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, t> entry : c().f().entrySet()) {
            String key = entry.getKey();
            Bundle a4 = entry.getValue().c().a();
            if (!kotlin.jvm.internal.k.a(a4, Bundle.EMPTY)) {
                bundle.putBundle(key, a4);
            }
        }
        this.f1329b = false;
        return bundle;
    }

    public final Bundle b(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        d();
        Bundle bundle = this.f1330c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1330c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1330c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f1330c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.f1329b) {
            return;
        }
        this.f1330c = this.f1328a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f1329b = true;
        c();
    }
}
