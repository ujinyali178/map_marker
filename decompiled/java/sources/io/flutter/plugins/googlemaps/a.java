package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: /root/release/classes.dex */
class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final CircleOptions f3255a = new CircleOptions();

    /* renamed from: b, reason: collision with root package name */
    private final float f3256b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3257c;

    a(float f3) {
        this.f3256b = f3;
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void a(float f3) {
        this.f3255a.zIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void b(boolean z3) {
        this.f3257c = z3;
        this.f3255a.clickable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void c(int i3) {
        this.f3255a.strokeColor(i3);
    }

    CircleOptions d() {
        return this.f3255a;
    }

    boolean e() {
        return this.f3257c;
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void f(int i3) {
        this.f3255a.fillColor(i3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void g(double d3) {
        this.f3255a.radius(d3);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void h(LatLng latLng) {
        this.f3255a.center(latLng);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void setStrokeWidth(float f3) {
        this.f3255a.strokeWidth(f3 * this.f3256b);
    }

    @Override // io.flutter.plugins.googlemaps.c
    public void setVisible(boolean z3) {
        this.f3255a.visible(z3);
    }
}
