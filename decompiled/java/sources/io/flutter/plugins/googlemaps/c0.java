package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a0> f3263a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final u1.l f3264b;

    /* renamed from: c, reason: collision with root package name */
    private GoogleMap f3265c;

    c0(u1.l lVar) {
        this.f3264b = lVar;
    }

    private void a(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        z zVar = new z();
        String m3 = f.m(map, zVar);
        zVar.e(new e0(this.f3264b, m3));
        this.f3263a.put(m3, new a0(this.f3265c.addTileOverlay(zVar.d())));
    }

    private void c(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        a0 a0Var = this.f3263a.get(f(map));
        if (a0Var != null) {
            f.m(map, a0Var);
        }
    }

    private static String f(Map<String, ?> map) {
        return (String) map.get("tileOverlayId");
    }

    private void h(String str) {
        a0 a0Var = this.f3263a.get(str);
        if (a0Var != null) {
            a0Var.f();
            this.f3263a.remove(str);
        }
    }

    void b(List<Map<String, ?>> list) {
        if (list == null) {
            return;
        }
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    void d(List<Map<String, ?>> list) {
        if (list == null) {
            return;
        }
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    void e(String str) {
        a0 a0Var;
        if (str == null || (a0Var = this.f3263a.get(str)) == null) {
            return;
        }
        a0Var.d();
    }

    Map<String, Object> g(String str) {
        a0 a0Var;
        if (str == null || (a0Var = this.f3263a.get(str)) == null) {
            return null;
        }
        return a0Var.e();
    }

    void i(List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (str != null) {
                h(str);
            }
        }
    }

    void j(GoogleMap googleMap) {
        this.f3265c = googleMap;
    }
}
