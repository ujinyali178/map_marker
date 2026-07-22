package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import u1.l;

/* loaded from: /root/release/classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, n> f3321a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, o> f3322b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, String> f3323c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final u1.l f3324d;

    /* renamed from: e, reason: collision with root package name */
    private MarkerManager.Collection f3325e;

    /* renamed from: f, reason: collision with root package name */
    private final e f3326f;

    q(u1.l lVar, e eVar) {
        this.f3324d = lVar;
        this.f3326f = eVar;
    }

    private void a(n nVar) {
        if (nVar == null) {
            return;
        }
        String n3 = nVar.n();
        this.f3321a.put(n3, nVar);
        if (nVar.l() == null) {
            d(n3, nVar);
        } else {
            c(nVar);
        }
    }

    private void b(Object obj) {
        if (obj == null) {
            return;
        }
        String j3 = j(obj);
        if (j3 == null) {
            throw new IllegalArgumentException("markerId was null");
        }
        n nVar = new n(j3, i(obj));
        f.i(obj, nVar);
        a(nVar);
    }

    private void c(n nVar) {
        this.f3326f.c(nVar);
    }

    private void d(String str, n nVar) {
        h(str, this.f3325e.addMarker(nVar.k()), nVar.m());
    }

    private void f(Object obj) {
        String j3;
        n nVar;
        if (obj == null || (nVar = this.f3321a.get((j3 = j(obj)))) == null) {
            return;
        }
        if (!Objects.equals(i(obj), nVar.l())) {
            t(j3);
            b(obj);
            return;
        }
        f.i(obj, nVar);
        o oVar = this.f3322b.get(j3);
        if (oVar != null) {
            f.i(obj, oVar);
        }
    }

    private void h(String str, Marker marker, boolean z3) {
        this.f3322b.put(str, new o(marker, z3));
        this.f3323c.put(marker.getId(), str);
    }

    private static String i(Object obj) {
        return (String) ((Map) obj).get("clusterManagerId");
    }

    private static String j(Object obj) {
        return (String) ((Map) obj).get("markerId");
    }

    private void t(String str) {
        MarkerManager.Collection collection;
        n remove = this.f3321a.remove(str);
        if (remove == null) {
            return;
        }
        o remove2 = this.f3322b.remove(str);
        if (remove.l() != null) {
            this.f3326f.l(remove);
        } else if (remove2 != null && (collection = this.f3325e) != null) {
            remove2.o(collection);
        }
        if (remove2 != null) {
            this.f3323c.remove(remove2.l());
        }
    }

    void e(List<Object> list) {
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }

    void g(List<Object> list) {
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
        }
    }

    void k(String str, l.d dVar) {
        o oVar = this.f3322b.get(str);
        if (oVar == null) {
            dVar.b("Invalid markerId", "hideInfoWindow called with invalid markerId", null);
        } else {
            oVar.m();
            dVar.a(null);
        }
    }

    void l(String str, l.d dVar) {
        o oVar = this.f3322b.get(str);
        if (oVar != null) {
            dVar.a(Boolean.valueOf(oVar.n()));
        } else {
            dVar.b("Invalid markerId", "isInfoWindowShown called with invalid markerId", null);
        }
    }

    public void m(n nVar, Marker marker) {
        if (this.f3321a.get(nVar.n()) == nVar) {
            h(nVar.n(), marker, nVar.m());
        }
    }

    void n(String str) {
        String str2 = this.f3323c.get(str);
        if (str2 == null) {
            return;
        }
        this.f3324d.c("infoWindow#onTap", f.p(str2));
    }

    boolean o(String str) {
        String str2 = this.f3323c.get(str);
        if (str2 == null) {
            return false;
        }
        return s(str2);
    }

    void p(String str, LatLng latLng) {
        String str2 = this.f3323c.get(str);
        if (str2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("markerId", str2);
        hashMap.put("position", f.o(latLng));
        this.f3324d.c("marker#onDrag", hashMap);
    }

    void q(String str, LatLng latLng) {
        String str2 = this.f3323c.get(str);
        if (str2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("markerId", str2);
        hashMap.put("position", f.o(latLng));
        this.f3324d.c("marker#onDragEnd", hashMap);
    }

    void r(String str, LatLng latLng) {
        String str2 = this.f3323c.get(str);
        if (str2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("markerId", str2);
        hashMap.put("position", f.o(latLng));
        this.f3324d.c("marker#onDragStart", hashMap);
    }

    boolean s(String str) {
        this.f3324d.c("marker#onTap", f.p(str));
        o oVar = this.f3322b.get(str);
        if (oVar != null) {
            return oVar.k();
        }
        return false;
    }

    void u(List<Object> list) {
        if (list == null) {
            return;
        }
        for (Object obj : list) {
            if (obj != null) {
                t((String) obj);
            }
        }
    }

    void v(MarkerManager.Collection collection) {
        this.f3325e = collection;
    }

    void w(String str, l.d dVar) {
        o oVar = this.f3322b.get(str);
        if (oVar == null) {
            dVar.b("Invalid markerId", "showInfoWindow called with invalid markerId", null);
        } else {
            oVar.p();
            dVar.a(null);
        }
    }
}
