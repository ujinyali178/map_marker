package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class v implements x {

    /* renamed from: a, reason: collision with root package name */
    private final PolylineOptions f3339a = new PolylineOptions();

    /* renamed from: b, reason: collision with root package name */
    private boolean f3340b;

    /* renamed from: c, reason: collision with root package name */
    private final float f3341c;

    v(float f3) {
        this.f3341c = f3;
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void a(float f3) {
        this.f3339a.zIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void b(boolean z3) {
        this.f3340b = z3;
        this.f3339a.clickable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void c(List<PatternItem> list) {
        this.f3339a.pattern(list);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void d(boolean z3) {
        this.f3339a.geodesic(z3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void e(List<LatLng> list) {
        this.f3339a.addAll(list);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void f(Cap cap) {
        this.f3339a.endCap(cap);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void g(int i3) {
        this.f3339a.jointType(i3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void h(float f3) {
        this.f3339a.width(f3 * this.f3341c);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void i(Cap cap) {
        this.f3339a.startCap(cap);
    }

    PolylineOptions j() {
        return this.f3339a;
    }

    boolean k() {
        return this.f3340b;
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void setColor(int i3) {
        this.f3339a.color(i3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void setVisible(boolean z3) {
        this.f3339a.visible(z3);
    }
}
