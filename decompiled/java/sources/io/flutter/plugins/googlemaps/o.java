package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;
import java.lang.ref.WeakReference;

/* loaded from: /root/release/classes.dex */
class o implements p {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Marker> f3318a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3319b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3320c;

    o(Marker marker, boolean z3) {
        this.f3318a = new WeakReference<>(marker);
        this.f3320c = z3;
        this.f3319b = marker.getId();
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void a(float f3) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setZIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void b(boolean z3) {
        if (this.f3318a.get() == null) {
            return;
        }
        this.f3320c = z3;
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void c(boolean z3) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setDraggable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void d(boolean z3) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setFlat(z3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void e(float f3, float f4) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setInfoWindowAnchor(f3, f4);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void f(float f3, float f4) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setAnchor(f3, f4);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void g(BitmapDescriptor bitmapDescriptor) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setIcon(bitmapDescriptor);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void h(String str, String str2) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setTitle(str);
        marker.setSnippet(str2);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void i(float f3) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setAlpha(f3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void j(float f3) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setRotation(f3);
    }

    boolean k() {
        return this.f3320c;
    }

    String l() {
        return this.f3319b;
    }

    public void m() {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.hideInfoWindow();
    }

    public boolean n() {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return false;
        }
        return marker.isInfoWindowShown();
    }

    void o(MarkerManager.Collection collection) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        collection.remove(marker);
    }

    public void p() {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.showInfoWindow();
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void setPosition(LatLng latLng) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void setVisible(boolean z3) {
        Marker marker = this.f3318a.get();
        if (marker == null) {
            return;
        }
        marker.setVisible(z3);
    }
}
