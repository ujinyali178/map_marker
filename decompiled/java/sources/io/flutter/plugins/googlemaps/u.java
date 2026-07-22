package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class u {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, s> f3334a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f3335b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final u1.l f3336c;

    /* renamed from: d, reason: collision with root package name */
    private final float f3337d;

    /* renamed from: e, reason: collision with root package name */
    private GoogleMap f3338e;

    u(u1.l lVar, float f3) {
        this.f3336c = lVar;
        this.f3337d = f3;
    }

    private void a(Object obj) {
        if (obj == null) {
            return;
        }
        r rVar = new r(this.f3337d);
        b(f.j(obj, rVar), rVar.h(), rVar.i());
    }

    private void b(String str, PolygonOptions polygonOptions, boolean z3) {
        Polygon addPolygon = this.f3338e.addPolygon(polygonOptions);
        this.f3334a.put(str, new s(addPolygon, z3, this.f3337d));
        this.f3335b.put(addPolygon.getId(), str);
    }

    private void d(Object obj) {
        if (obj == null) {
            return;
        }
        s sVar = this.f3334a.get(f(obj));
        if (sVar != null) {
            f.j(obj, sVar);
        }
    }

    private static String f(Object obj) {
        return (String) ((Map) obj).get("polygonId");
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
        String str2 = this.f3335b.get(str);
        if (str2 == null) {
            return false;
        }
        this.f3336c.c("polygon#onTap", f.r(str2));
        s sVar = this.f3334a.get(str2);
        if (sVar != null) {
            return sVar.h();
        }
        return false;
    }

    void h(List<Object> list) {
        if (list == null) {
            return;
        }
        for (Object obj : list) {
            if (obj != null) {
                s remove = this.f3334a.remove((String) obj);
                if (remove != null) {
                    remove.j();
                    this.f3335b.remove(remove.i());
                }
            }
        }
    }

    void i(GoogleMap googleMap) {
        this.f3338e = googleMap;
    }
}
