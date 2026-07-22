package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class s implements t {

    /* renamed from: a, reason: collision with root package name */
    private final Polygon f3330a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3331b;

    /* renamed from: c, reason: collision with root package name */
    private final float f3332c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3333d;

    s(Polygon polygon, boolean z3, float f3) {
        this.f3330a = polygon;
        this.f3332c = f3;
        this.f3333d = z3;
        this.f3331b = polygon.getId();
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void a(float f3) {
        this.f3330a.setZIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void b(boolean z3) {
        this.f3333d = z3;
        this.f3330a.setClickable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void c(int i3) {
        this.f3330a.setStrokeColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void d(boolean z3) {
        this.f3330a.setGeodesic(z3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void e(List<LatLng> list) {
        this.f3330a.setPoints(list);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void f(int i3) {
        this.f3330a.setFillColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void g(List<List<LatLng>> list) {
        this.f3330a.setHoles(list);
    }

    boolean h() {
        return this.f3333d;
    }

    String i() {
        return this.f3331b;
    }

    void j() {
        this.f3330a.remove();
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void setStrokeWidth(float f3) {
        this.f3330a.setStrokeWidth(f3 * this.f3332c);
    }

    @Override // io.flutter.plugins.googlemaps.t
    public void setVisible(boolean z3) {
        this.f3330a.setVisible(z3);
    }
}
