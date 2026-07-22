package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, w> f3346a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f3347b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final u1.l f3348c;

    /* renamed from: d, reason: collision with root package name */
    private GoogleMap f3349d;

    /* renamed from: e, reason: collision with root package name */
    private final float f3350e;

    y(u1.l lVar, float f3) {
        this.f3348c = lVar;
        this.f3350e = f3;
    }

    private void a(Object obj) {
        if (obj == null) {
            return;
        }
        v vVar = new v(this.f3350e);
        b(f.k(obj, vVar), vVar.j(), vVar.k());
    }

    private void b(String str, PolylineOptions polylineOptions, boolean z3) {
        Polyline addPolyline = this.f3349d.addPolyline(polylineOptions);
        this.f3346a.put(str, new w(addPolyline, z3, this.f3350e));
        this.f3347b.put(addPolyline.getId(), str);
    }

    private void d(Object obj) {
        if (obj == null) {
            return;
        }
        w wVar = this.f3346a.get(f(obj));
        if (wVar != null) {
            f.k(obj, wVar);
        }
    }

    private static String f(Object obj) {
        return (String) ((Map) obj).get("polylineId");
    }

    void c(List<Object> list) {
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    void e(List<Object> list) {
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    boolean g(String str) {
        String str2 = this.f3347b.get(str);
        if (str2 == null) {
            return false;
        }
        this.f3348c.c("polyline#onTap", f.s(str2));
        w wVar = this.f3346a.get(str2);
        if (wVar != null) {
            return wVar.j();
        }
        return false;
    }

    void h(List<Object> list) {
        if (list == null) {
            return;
        }
        for (Object obj : list) {
            if (obj != null) {
                w remove = this.f3346a.remove((String) obj);
                if (remove != null) {
                    remove.l();
                    this.f3347b.remove(remove.k());
                }
            }
        }
    }

    void i(GoogleMap googleMap) {
        this.f3349d = googleMap;
    }
}
