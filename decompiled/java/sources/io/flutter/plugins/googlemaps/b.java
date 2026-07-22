package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: /root/release/classes.dex */
class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Circle f3259a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3260b;

    /* renamed from: c, reason: collision with root package name */
    private final float f3261c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3262d;

    b(Circle circle, boolean z3, float f3) {
        this.f3259a = circle;
        this.f3262d = z3;
        this.f3261c = f3;
        this.f3260b = circle.getId();
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void a(float f3) {
        this.f3259a.setZIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void b(boolean z3) {
        this.f3262d = z3;
        this.f3259a.setClickable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void c(int i3) {
        this.f3259a.setStrokeColor(i3);
    }

    boolean d() {
        return this.f3262d;
    }

    String e() {
        return this.f3260b;
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void f(int i3) {
        this.f3259a.setFillColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void g(double d3) {
        this.f3259a.setRadius(d3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void h(LatLng latLng) {
        this.f3259a.setCenter(latLng);
    }

    void i() {
        this.f3259a.remove();
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void setStrokeWidth(float f3) {
        this.f3259a.setStrokeWidth(f3 * this.f3261c);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void setVisible(boolean z3) {
        this.f3259a.setVisible(z3);
    }
}
