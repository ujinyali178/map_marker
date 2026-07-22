package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

/* loaded from: /root/release/classes.dex */
class z implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final TileOverlayOptions f3351a = new TileOverlayOptions();

    z() {
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void a(float f3) {
        this.f3351a.zIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void b(boolean z3) {
        this.f3351a.fadeIn(z3);
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void c(float f3) {
        this.f3351a.transparency(f3);
    }

    TileOverlayOptions d() {
        return this.f3351a;
    }

    public void e(TileProvider tileProvider) {
        this.f3351a.tileProvider(tileProvider);
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void setVisible(boolean z3) {
        this.f3351a.visible(z3);
    }
}
