package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, b> f3266a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f3267b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final u1.l f3268c;

    /* renamed from: d, reason: collision with root package name */
    private final float f3269d;

    /* renamed from: e, reason: collision with root package name */
    private GoogleMap f3270e;

    d(u1.l lVar, float f3) {
        this.f3268c = lVar;
        this.f3269d = f3;
    }

    private void a(Object obj) {
        if (obj == null) {
            return;
        }
        a aVar = new a(this.f3269d);
        b(f.f(obj, aVar), aVar.d(), aVar.e());
    }

    private void b(String str, CircleOptions circleOptions, boolean z3) {
        Circle addCircle = this.f3270e.addCircle(circleOptions);
        this.f3266a.put(str, new b(addCircle, z3, this.f3269d));
        this.f3267b.put(addCircle.getId(), str);
    }

    private void d(Object obj) {
        if (obj == null) {
            return;
        }
        b bVar = this.f3266a.get(f(obj));
        if (bVar != null) {
            f.f(obj, bVar);
        }
    }

    private static String f(Object obj) {
        return (String) ((Map) obj).get("circleId");
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
        String str2 = this.f3267b.get(str);
        if (str2 == null) {
            return false;
        }
        this.f3268c.c("circle#onTap", f.b(str2));
        b bVar = this.f3266a.get(str2);
        if (bVar != null) {
            return bVar.d();
        }
        return false;
    }

    void h(List<Object> list) {
        if (list == null) {
            return;
        }
        for (Object obj : list) {
            if (obj != null) {
                b remove = this.f3266a.remove((String) obj);
                if (remove != null) {
                    remove.i();
                    this.f3267b.remove(remove.e());
                }
            }
        }
    }

    void i(GoogleMap googleMap) {
        this.f3270e = googleMap;
    }
}
