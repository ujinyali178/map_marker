package io.flutter.plugins.googlemaps;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class g implements k {

    /* renamed from: k, reason: collision with root package name */
    private Object f3296k;

    /* renamed from: l, reason: collision with root package name */
    private Object f3297l;

    /* renamed from: m, reason: collision with root package name */
    private Object f3298m;

    /* renamed from: n, reason: collision with root package name */
    private Object f3299n;

    /* renamed from: o, reason: collision with root package name */
    private Object f3300o;

    /* renamed from: p, reason: collision with root package name */
    private List<Map<String, ?>> f3301p;

    /* renamed from: r, reason: collision with root package name */
    private String f3303r;

    /* renamed from: c, reason: collision with root package name */
    private final GoogleMapOptions f3289c = new GoogleMapOptions();

    /* renamed from: d, reason: collision with root package name */
    private boolean f3290d = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3291f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3292g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3293h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3294i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3295j = true;

    /* renamed from: q, reason: collision with root package name */
    private Rect f3302q = new Rect(0, 0, 0, 0);

    g() {
    }

    GoogleMapController a(int i3, Context context, u1.d dVar, m mVar) {
        GoogleMapController googleMapController = new GoogleMapController(i3, context, dVar, mVar, this.f3289c);
        googleMapController.B();
        googleMapController.setMyLocationEnabled(this.f3291f);
        googleMapController.setMyLocationButtonEnabled(this.f3292g);
        googleMapController.setIndoorEnabled(this.f3293h);
        googleMapController.setTrafficEnabled(this.f3294i);
        googleMapController.setBuildingsEnabled(this.f3295j);
        googleMapController.g(this.f3290d);
        googleMapController.K(this.f3297l);
        googleMapController.L(this.f3296k);
        googleMapController.N(this.f3298m);
        googleMapController.O(this.f3299n);
        googleMapController.J(this.f3300o);
        Rect rect = this.f3302q;
        googleMapController.l(rect.top, rect.left, rect.bottom, rect.right);
        googleMapController.P(this.f3301p);
        googleMapController.t(this.f3303r);
        return googleMapController;
    }

    void b(CameraPosition cameraPosition) {
        this.f3289c.camera(cameraPosition);
    }

    public void c(Object obj) {
        this.f3300o = obj;
    }

    public void d(Object obj) {
        this.f3297l = obj;
    }

    public void e(Object obj) {
        this.f3296k = obj;
    }

    public void f(Object obj) {
        this.f3298m = obj;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void g(boolean z3) {
        this.f3290d = z3;
    }

    public void h(Object obj) {
        this.f3299n = obj;
    }

    public void i(List<Map<String, ?>> list) {
        this.f3301p = list;
    }

    public void j(String str) {
        this.f3289c.mapId(str);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void k(Float f3, Float f4) {
        if (f3 != null) {
            this.f3289c.minZoomPreference(f3.floatValue());
        }
        if (f4 != null) {
            this.f3289c.maxZoomPreference(f4.floatValue());
        }
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void l(float f3, float f4, float f5, float f6) {
        this.f3302q = new Rect((int) f4, (int) f3, (int) f6, (int) f5);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void p(boolean z3) {
        this.f3289c.liteMode(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void r(LatLngBounds latLngBounds) {
        this.f3289c.latLngBoundsForCameraTarget(latLngBounds);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setBuildingsEnabled(boolean z3) {
        this.f3295j = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setCompassEnabled(boolean z3) {
        this.f3289c.compassEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setIndoorEnabled(boolean z3) {
        this.f3293h = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMapToolbarEnabled(boolean z3) {
        this.f3289c.mapToolbarEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMapType(int i3) {
        this.f3289c.mapType(i3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMyLocationButtonEnabled(boolean z3) {
        this.f3292g = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMyLocationEnabled(boolean z3) {
        this.f3291f = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setRotateGesturesEnabled(boolean z3) {
        this.f3289c.rotateGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setScrollGesturesEnabled(boolean z3) {
        this.f3289c.scrollGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setTiltGesturesEnabled(boolean z3) {
        this.f3289c.tiltGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setTrafficEnabled(boolean z3) {
        this.f3294i = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setZoomControlsEnabled(boolean z3) {
        this.f3289c.zoomControlsEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setZoomGesturesEnabled(boolean z3) {
        this.f3289c.zoomGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void t(String str) {
        this.f3303r = str;
    }
}
