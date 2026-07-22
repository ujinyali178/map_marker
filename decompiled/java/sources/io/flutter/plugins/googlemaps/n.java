package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterItem;

/* loaded from: /root/release/classes.dex */
class n implements p, ClusterItem {

    /* renamed from: a, reason: collision with root package name */
    private final MarkerOptions f3314a = new MarkerOptions();

    /* renamed from: b, reason: collision with root package name */
    private String f3315b;

    /* renamed from: c, reason: collision with root package name */
    private String f3316c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3317d;

    n(String str, String str2) {
        this.f3316c = str;
        this.f3315b = str2;
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void a(float f3) {
        this.f3314a.zIndex(f3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void b(boolean z3) {
        this.f3317d = z3;
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void c(boolean z3) {
        this.f3314a.draggable(z3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void d(boolean z3) {
        this.f3314a.flat(z3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void e(float f3, float f4) {
        this.f3314a.infoWindowAnchor(f3, f4);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void f(float f3, float f4) {
        this.f3314a.anchor(f3, f4);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void g(BitmapDescriptor bitmapDescriptor) {
        this.f3314a.icon(bitmapDescriptor);
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public LatLng getPosition() {
        return this.f3314a.getPosition();
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public String getSnippet() {
        return this.f3314a.getSnippet();
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public String getTitle() {
        return this.f3314a.getTitle();
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public Float getZIndex() {
        return Float.valueOf(this.f3314a.getZIndex());
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void h(String str, String str2) {
        this.f3314a.title(str);
        this.f3314a.snippet(str2);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void i(float f3) {
        this.f3314a.alpha(f3);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void j(float f3) {
        this.f3314a.rotation(f3);
    }

    MarkerOptions k() {
        return this.f3314a;
    }

    String l() {
        return this.f3315b;
    }

    boolean m() {
        return this.f3317d;
    }

    String n() {
        return this.f3316c;
    }

    void o(MarkerOptions markerOptions) {
        markerOptions.alpha(this.f3314a.getAlpha());
        markerOptions.anchor(this.f3314a.getAnchorU(), this.f3314a.getAnchorV());
        markerOptions.draggable(this.f3314a.isDraggable());
        markerOptions.flat(this.f3314a.isFlat());
        markerOptions.icon(this.f3314a.getIcon());
        markerOptions.infoWindowAnchor(this.f3314a.getInfoWindowAnchorU(), this.f3314a.getInfoWindowAnchorV());
        markerOptions.title(this.f3314a.getTitle());
        markerOptions.snippet(this.f3314a.getSnippet());
        markerOptions.position(this.f3314a.getPosition());
        markerOptions.rotation(this.f3314a.getRotation());
        markerOptions.visible(this.f3314a.isVisible());
        markerOptions.zIndex(this.f3314a.getZIndex());
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void setPosition(LatLng latLng) {
        this.f3314a.position(latLng);
    }

    @Override // io.flutter.plugins.googlemaps.p
    public void setVisible(boolean z3) {
        this.f3314a.visible(z3);
    }
}
