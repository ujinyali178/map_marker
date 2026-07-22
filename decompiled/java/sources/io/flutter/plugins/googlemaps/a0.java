package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileOverlay;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class a0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final TileOverlay f3258a;

    a0(TileOverlay tileOverlay) {
        this.f3258a = tileOverlay;
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void a(float f3) {
        this.f3258a.setZIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void b(boolean z3) {
        this.f3258a.setFadeIn(z3);
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void c(float f3) {
        this.f3258a.setTransparency(f3);
    }

    void d() {
        this.f3258a.clearTileCache();
    }

    Map<String, Object> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("fadeIn", Boolean.valueOf(this.f3258a.getFadeIn()));
        hashMap.put("transparency", Float.valueOf(this.f3258a.getTransparency()));
        hashMap.put("id", this.f3258a.getId());
        hashMap.put("zIndex", Float.valueOf(this.f3258a.getZIndex()));
        hashMap.put("visible", Boolean.valueOf(this.f3258a.isVisible()));
        return hashMap;
    }

    void f() {
        this.f3258a.remove();
    }

    @Override // io.flutter.plugins.googlemaps.b0
    public void setVisible(boolean z3) {
        this.f3258a.setVisible(z3);
    }
}
