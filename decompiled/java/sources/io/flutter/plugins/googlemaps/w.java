package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class w implements x {

    /* renamed from: a, reason: collision with root package name */
    private final Polyline f3342a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3343b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3344c;

    /* renamed from: d, reason: collision with root package name */
    private final float f3345d;

    w(Polyline polyline, boolean z3, float f3) {
        this.f3342a = polyline;
        this.f3344c = z3;
        this.f3345d = f3;
        this.f3343b = polyline.getId();
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void a(float f3) {
        this.f3342a.setZIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void b(boolean z3) {
        this.f3344c = z3;
        this.f3342a.setClickable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void c(List<PatternItem> list) {
        this.f3342a.setPattern(list);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void d(boolean z3) {
        this.f3342a.setGeodesic(z3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void e(List<LatLng> list) {
        this.f3342a.setPoints(list);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void f(Cap cap) {
        this.f3342a.setEndCap(cap);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void g(int i3) {
        this.f3342a.setJointType(i3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void h(float f3) {
        this.f3342a.setWidth(f3 * this.f3345d);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void i(Cap cap) {
        this.f3342a.setStartCap(cap);
    }

    boolean j() {
        return this.f3344c;
    }

    String k() {
        return this.f3343b;
    }

    void l() {
        this.f3342a.remove();
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void setColor(int i3) {
        this.f3342a.setColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.x
    public void setVisible(boolean z3) {
        this.f3342a.setVisible(z3);
    }
}
