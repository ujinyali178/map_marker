package io.flutter.plugins.googlemaps;

import android.content.Context;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class h extends io.flutter.plugin.platform.l {

    /* renamed from: b, reason: collision with root package name */
    private final u1.d f3304b;

    /* renamed from: c, reason: collision with root package name */
    private final m f3305c;

    /* renamed from: d, reason: collision with root package name */
    private final i f3306d;

    h(u1.d dVar, Context context, m mVar) {
        super(u1.o.f4384a);
        this.f3304b = dVar;
        this.f3305c = mVar;
        this.f3306d = new i(context, dVar);
    }

    @Override // io.flutter.plugin.platform.l
    public io.flutter.plugin.platform.k a(Context context, int i3, Object obj) {
        Map map = (Map) obj;
        g gVar = new g();
        Object obj2 = map.get("options");
        f.g(obj2, gVar);
        if (map.containsKey("initialCameraPosition")) {
            gVar.b(f.x(map.get("initialCameraPosition")));
        }
        if (map.containsKey("clusterManagersToAdd")) {
            gVar.d(map.get("clusterManagersToAdd"));
        }
        if (map.containsKey("markersToAdd")) {
            gVar.e(map.get("markersToAdd"));
        }
        if (map.containsKey("polygonsToAdd")) {
            gVar.f(map.get("polygonsToAdd"));
        }
        if (map.containsKey("polylinesToAdd")) {
            gVar.h(map.get("polylinesToAdd"));
        }
        if (map.containsKey("circlesToAdd")) {
            gVar.c(map.get("circlesToAdd"));
        }
        if (map.containsKey("tileOverlaysToAdd")) {
            gVar.i((List) map.get("tileOverlaysToAdd"));
        }
        Object obj3 = ((Map) obj2).get("cloudMapId");
        if (obj3 != null) {
            gVar.j((String) obj3);
        }
        return gVar.a(i3, context, this.f3304b, this.f3305c);
    }
}
