package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class r implements t {

    /* renamed from: a, reason: collision with root package name */
    private final PolygonOptions f3327a = new PolygonOptions();

    /* renamed from: b, reason: collision with root package name */
    private final float f3328b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3329c;

    r(float f3) {
        this.f3328b = f3;
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void a(float f3) {
        this.f3327a.zIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void b(boolean z3) {
        this.f3329c = z3;
        this.f3327a.clickable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void c(int i3) {
        this.f3327a.strokeColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void d(boolean z3) {
        this.f3327a.geodesic(z3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void e(List<LatLng> list) {
        this.f3327a.addAll(list);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void f(int i3) {
        this.f3327a.fillColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void g(List<List<LatLng>> list) {
        Iterator<List<LatLng>> it = list.iterator();
        while (it.hasNext()) {
            this.f3327a.addHole(it.next());
        }
    }

    PolygonOptions h() {
        return this.f3327a;
    }

    boolean i() {
        return this.f3329c;
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void setStrokeWidth(float f3) {
        this.f3327a.strokeWidth(f3 * this.f3328b);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void setVisible(boolean z3) {
        this.f3327a.visible(z3);
    }
}
