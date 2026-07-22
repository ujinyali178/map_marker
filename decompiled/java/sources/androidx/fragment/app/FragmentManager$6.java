package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.e;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class FragmentManager$6 implements androidx.lifecycle.g {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f955c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b0 f956d;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ androidx.lifecycle.e f957f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ w f958g;

    @Override // androidx.lifecycle.g
    public void e(androidx.lifecycle.i iVar, e.a aVar) {
        Map map;
        Map map2;
        if (aVar == e.a.ON_START) {
            map2 = this.f958g.f1187k;
            Bundle bundle = (Bundle) map2.get(this.f955c);
            if (bundle != null) {
                this.f956d.a(this.f955c, bundle);
                this.f958g.u(this.f955c);
            }
        }
        if (aVar == e.a.ON_DESTROY) {
            this.f957f.c(this);
            map = this.f958g.f1188l;
            map.remove(this.f955c);
        }
    }
}
