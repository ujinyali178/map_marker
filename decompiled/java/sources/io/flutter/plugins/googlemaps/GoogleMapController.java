package io.flutter.plugins.googlemaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PinConfig;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.collections.MarkerManager;
import io.flutter.plugins.googlemaps.e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import n1.c;
import u1.l;

/* loaded from: /root/release/classes.dex */
class GoogleMapController implements DefaultLifecycleObserver, c.a, k, l.c, OnMapReadyCallback, j, ClusterManager.OnClusterItemClickListener<n>, e.b<n>, io.flutter.plugin.platform.k {
    private MarkerManager A;
    private MarkerManager.Collection B;
    private List<Object> C;
    private List<Object> D;
    private List<Object> E;
    private List<Object> F;
    private List<Object> G;
    private List<Map<String, ?>> H;
    private String I;
    private String J;
    List<Float> K;

    /* renamed from: c, reason: collision with root package name */
    private final int f3227c;

    /* renamed from: d, reason: collision with root package name */
    private final u1.l f3228d;

    /* renamed from: f, reason: collision with root package name */
    private final GoogleMapOptions f3229f;

    /* renamed from: g, reason: collision with root package name */
    private MapView f3230g;

    /* renamed from: h, reason: collision with root package name */
    private GoogleMap f3231h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3232i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3233j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3234k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3235l = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3236m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3237n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3238o = true;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3239p = false;

    /* renamed from: q, reason: collision with root package name */
    final float f3240q;

    /* renamed from: r, reason: collision with root package name */
    private l.d f3241r;

    /* renamed from: s, reason: collision with root package name */
    private final Context f3242s;

    /* renamed from: t, reason: collision with root package name */
    private final m f3243t;

    /* renamed from: u, reason: collision with root package name */
    private final q f3244u;

    /* renamed from: v, reason: collision with root package name */
    private final e f3245v;

    /* renamed from: w, reason: collision with root package name */
    private final u f3246w;

    /* renamed from: x, reason: collision with root package name */
    private final y f3247x;

    /* renamed from: y, reason: collision with root package name */
    private final d f3248y;

    /* renamed from: z, reason: collision with root package name */
    private final c0 f3249z;

    class a implements TextureView.SurfaceTextureListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextureView.SurfaceTextureListener f3250a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapView f3251b;

        a(TextureView.SurfaceTextureListener surfaceTextureListener, MapView mapView) {
            this.f3250a = surfaceTextureListener;
            this.f3251b = mapView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.f3250a;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i3, i4);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.f3250a;
            if (surfaceTextureListener != null) {
                return surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.f3250a;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i3, i4);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.f3250a;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
            }
            this.f3251b.invalidate();
        }
    }

    class b implements GoogleMap.SnapshotReadyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.d f3253a;

        b(l.d dVar) {
            this.f3253a = dVar;
        }

        @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
        public void onSnapshotReady(Bitmap bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            this.f3253a.a(byteArray);
        }
    }

    GoogleMapController(int i3, Context context, u1.d dVar, m mVar, GoogleMapOptions googleMapOptions) {
        this.f3227c = i3;
        this.f3242s = context;
        this.f3229f = googleMapOptions;
        this.f3230g = new MapView(context, googleMapOptions);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f3240q = f3;
        u1.l lVar = new u1.l(dVar, "plugins.flutter.dev/google_maps_android_" + i3);
        this.f3228d = lVar;
        lVar.e(this);
        this.f3243t = mVar;
        e eVar = new e(lVar, context);
        this.f3245v = eVar;
        this.f3244u = new q(lVar, eVar);
        this.f3246w = new u(lVar, f3);
        this.f3247x = new y(lVar, f3);
        this.f3248y = new d(lVar, f3);
        this.f3249z = new c0(lVar);
    }

    private boolean A() {
        return w("android.permission.ACCESS_FINE_LOCATION") == 0 || w("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private void C() {
        MapView mapView = this.f3230g;
        if (mapView == null) {
            return;
        }
        TextureView y3 = y(mapView);
        if (y3 == null) {
            Log.i("GoogleMapController", "No TextureView found. Likely using the LEGACY renderer.");
        } else {
            Log.i("GoogleMapController", "Installing custom TextureView driven invalidator.");
            y3.setSurfaceTextureListener(new a(y3.getSurfaceTextureListener(), this.f3230g));
        }
    }

    private void D(CameraUpdate cameraUpdate) {
        this.f3231h.moveCamera(cameraUpdate);
    }

    private void I(j jVar) {
        GoogleMap googleMap = this.f3231h;
        if (googleMap == null) {
            Log.v("GoogleMapController", "Controller was disposed before GoogleMap was ready.");
            return;
        }
        googleMap.setOnCameraMoveStartedListener(jVar);
        this.f3231h.setOnCameraMoveListener(jVar);
        this.f3231h.setOnCameraIdleListener(jVar);
        this.f3231h.setOnPolygonClickListener(jVar);
        this.f3231h.setOnPolylineClickListener(jVar);
        this.f3231h.setOnCircleClickListener(jVar);
        this.f3231h.setOnMapClickListener(jVar);
        this.f3231h.setOnMapLongClickListener(jVar);
    }

    private void R() {
        this.f3248y.c(this.G);
    }

    private void S() {
        List<Object> list = this.D;
        if (list != null) {
            this.f3245v.b(list);
        }
    }

    private void T() {
        this.f3244u.e(this.C);
    }

    private void U() {
        this.f3246w.c(this.E);
    }

    private void V() {
        this.f3247x.c(this.F);
    }

    private void W() {
        this.f3249z.b(this.H);
    }

    private boolean X(String str) {
        MapStyleOptions mapStyleOptions = (str == null || str.isEmpty()) ? null : new MapStyleOptions(str);
        GoogleMap googleMap = this.f3231h;
        Objects.requireNonNull(googleMap);
        boolean mapStyle = googleMap.setMapStyle(mapStyleOptions);
        this.J = mapStyle ? null : "Unable to set the map style. Please check console logs for errors.";
        return mapStyle;
    }

    private void Y() {
        if (!A()) {
            Log.e("GoogleMapController", "Cannot enable MyLocation layer as location permissions are not granted");
        } else {
            this.f3231h.setMyLocationEnabled(this.f3233j);
            this.f3231h.getUiSettings().setMyLocationButtonEnabled(this.f3234k);
        }
    }

    private void v(CameraUpdate cameraUpdate) {
        this.f3231h.animateCamera(cameraUpdate);
    }

    private int w(String str) {
        if (str != null) {
            return this.f3242s.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    private void x() {
        MapView mapView = this.f3230g;
        if (mapView == null) {
            return;
        }
        mapView.onDestroy();
        this.f3230g = null;
    }

    private static TextureView y(ViewGroup viewGroup) {
        TextureView y3;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof TextureView) {
                return (TextureView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (y3 = y((ViewGroup) childAt)) != null) {
                return y3;
            }
        }
        return null;
    }

    private CameraPosition z() {
        if (this.f3232i) {
            return this.f3231h.getCameraPosition();
        }
        return null;
    }

    void B() {
        this.f3243t.getLifecycle().a(this);
        this.f3230g.getMapAsync(this);
    }

    @Override // com.google.maps.android.clustering.ClusterManager.OnClusterItemClickListener
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public boolean onClusterItemClick(n nVar) {
        return this.f3244u.s(nVar.n());
    }

    @Override // io.flutter.plugins.googlemaps.e.b
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void u(n nVar, Marker marker) {
        this.f3244u.m(nVar, marker);
    }

    public void G(ClusterManager.OnClusterItemClickListener<n> onClusterItemClickListener) {
        if (this.f3231h == null) {
            Log.v("GoogleMapController", "Controller was disposed before GoogleMap was ready.");
        } else {
            this.f3245v.m(onClusterItemClickListener);
        }
    }

    public void H(e.b<n> bVar) {
        if (this.f3231h == null) {
            Log.v("GoogleMapController", "Controller was disposed before GoogleMap was ready.");
        } else {
            this.f3245v.n(bVar);
        }
    }

    public void J(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        this.G = arrayList != null ? new ArrayList(arrayList) : null;
        if (this.f3231h != null) {
            R();
        }
    }

    public void K(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        this.D = arrayList != null ? new ArrayList(arrayList) : null;
        if (this.f3231h != null) {
            S();
        }
    }

    public void L(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        this.C = arrayList != null ? new ArrayList(arrayList) : null;
        if (this.f3231h != null) {
            T();
        }
    }

    void M(float f3, float f4, float f5, float f6) {
        List<Float> list = this.K;
        if (list == null) {
            this.K = new ArrayList();
        } else {
            list.clear();
        }
        this.K.add(Float.valueOf(f3));
        this.K.add(Float.valueOf(f4));
        this.K.add(Float.valueOf(f5));
        this.K.add(Float.valueOf(f6));
    }

    public void N(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        this.E = arrayList != null ? new ArrayList(arrayList) : null;
        if (this.f3231h != null) {
            U();
        }
    }

    public void O(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        this.F = arrayList != null ? new ArrayList(arrayList) : null;
        if (this.f3231h != null) {
            V();
        }
    }

    public void P(List<Map<String, ?>> list) {
        this.H = list;
        if (this.f3231h != null) {
            W();
        }
    }

    public void Q(j jVar) {
        if (this.f3231h == null) {
            Log.v("GoogleMapController", "Controller was disposed before GoogleMap was ready.");
            return;
        }
        this.B.setOnMarkerClickListener(jVar);
        this.B.setOnMarkerDragListener(jVar);
        this.B.setOnInfoWindowClickListener(jVar);
    }

    @Override // io.flutter.plugin.platform.k
    public void a() {
        if (this.f3239p) {
            return;
        }
        this.f3239p = true;
        this.f3228d.e(null);
        I(null);
        Q(null);
        G(null);
        H(null);
        x();
        androidx.lifecycle.e lifecycle = this.f3243t.getLifecycle();
        if (lifecycle != null) {
            lifecycle.c(this);
        }
    }

    @Override // n1.c.a
    public void b(Bundle bundle) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onCreate(bundle);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void c(androidx.lifecycle.i iVar) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onResume();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void d(androidx.lifecycle.i iVar) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onCreate(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void f(androidx.lifecycle.i iVar) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onResume();
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void g(boolean z3) {
        this.f3232i = z3;
    }

    @Override // io.flutter.plugin.platform.k
    public View getView() {
        return this.f3230g;
    }

    @Override // io.flutter.plugin.platform.k
    public /* synthetic */ void h(View view) {
        io.flutter.plugin.platform.j.a(this, view);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void i(androidx.lifecycle.i iVar) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onStop();
    }

    @Override // io.flutter.plugin.platform.k
    public /* synthetic */ void j() {
        io.flutter.plugin.platform.j.c(this);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void k(Float f3, Float f4) {
        this.f3231h.resetMinMaxZoomPreference();
        if (f3 != null) {
            this.f3231h.setMinZoomPreference(f3.floatValue());
        }
        if (f4 != null) {
            this.f3231h.setMaxZoomPreference(f4.floatValue());
        }
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void l(float f3, float f4, float f5, float f6) {
        GoogleMap googleMap = this.f3231h;
        if (googleMap == null) {
            M(f3, f4, f5, f6);
        } else {
            float f7 = this.f3240q;
            googleMap.setPadding((int) (f4 * f7), (int) (f3 * f7), (int) (f6 * f7), (int) (f5 * f7));
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void m(androidx.lifecycle.i iVar) {
        iVar.getLifecycle().c(this);
        if (this.f3239p) {
            return;
        }
        x();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // u1.l.c
    public void n(u1.k kVar, l.d dVar) {
        String str;
        boolean isScrollGesturesEnabled;
        Object obj;
        String str2 = kVar.f4372a;
        str2.hashCode();
        char c3 = 65535;
        switch (str2.hashCode()) {
            case -2068530537:
                if (str2.equals("map#getVisibleRegion")) {
                    c3 = 0;
                    break;
                }
                break;
            case -1753225255:
                if (str2.equals("map#isScrollGesturesEnabled")) {
                    c3 = 1;
                    break;
                }
                break;
            case -1675017333:
                if (str2.equals("map#isRotateGesturesEnabled")) {
                    c3 = 2;
                    break;
                }
                break;
            case -1389285936:
                if (str2.equals("map#update")) {
                    c3 = 3;
                    break;
                }
                break;
            case -1366519597:
                if (str2.equals("map#getScreenCoordinate")) {
                    c3 = 4;
                    break;
                }
                break;
            case -1264573565:
                if (str2.equals("camera#animate")) {
                    c3 = 5;
                    break;
                }
                break;
            case -1255039905:
                if (str2.equals("markers#isInfoWindowShown")) {
                    c3 = 6;
                    break;
                }
                break;
            case -1253612063:
                if (str2.equals("map#getTileOverlayInfo")) {
                    c3 = 7;
                    break;
                }
                break;
            case -1102318061:
                if (str2.equals("polygons#update")) {
                    c3 = '\b';
                    break;
                }
                break;
            case -689870081:
                if (str2.equals("clusterManager#getClusters")) {
                    c3 = '\t';
                    break;
                }
                break;
            case -596474455:
                if (str2.equals("map#isTiltGesturesEnabled")) {
                    c3 = '\n';
                    break;
                }
                break;
            case -577075523:
                if (str2.equals("map#isMyLocationButtonEnabled")) {
                    c3 = 11;
                    break;
                }
                break;
            case -508357782:
                if (str2.equals("markers#hideInfoWindow")) {
                    c3 = '\f';
                    break;
                }
                break;
            case -451921790:
                if (str2.equals("map#getZoomLevel")) {
                    c3 = '\r';
                    break;
                }
                break;
            case -191840212:
                if (str2.equals("clusterManagers#update")) {
                    c3 = 14;
                    break;
                }
                break;
            case -149616666:
                if (str2.equals("map#getStyleError")) {
                    c3 = 15;
                    break;
                }
                break;
            case 262112323:
                if (str2.equals("map#getMinMaxZoomLevels")) {
                    c3 = 16;
                    break;
                }
                break;
            case 282895827:
                if (str2.equals("map#isZoomGesturesEnabled")) {
                    c3 = 17;
                    break;
                }
                break;
            case 295004975:
                if (str2.equals("map#waitForMap")) {
                    c3 = 18;
                    break;
                }
                break;
            case 390939153:
                if (str2.equals("map#isMapToolbarEnabled")) {
                    c3 = 19;
                    break;
                }
                break;
            case 434031410:
                if (str2.equals("map#takeSnapshot")) {
                    c3 = 20;
                    break;
                }
                break;
            case 622947733:
                if (str2.equals("map#getLatLng")) {
                    c3 = 21;
                    break;
                }
                break;
            case 643972249:
                if (str2.equals("polylines#update")) {
                    c3 = 22;
                    break;
                }
                break;
            case 712945078:
                if (str2.equals("map#setStyle")) {
                    c3 = 23;
                    break;
                }
                break;
            case 972868051:
                if (str2.equals("map#isBuildingsEnabled")) {
                    c3 = 24;
                    break;
                }
                break;
            case 1098288608:
                if (str2.equals("map#isCompassEnabled")) {
                    c3 = 25;
                    break;
                }
                break;
            case 1172199911:
                if (str2.equals("map#isZoomControlsEnabled")) {
                    c3 = 26;
                    break;
                }
                break;
            case 1322988819:
                if (str2.equals("markers#update")) {
                    c3 = 27;
                    break;
                }
                break;
            case 1546082965:
                if (str2.equals("map#isTrafficEnabled")) {
                    c3 = 28;
                    break;
                }
                break;
            case 1564959387:
                if (str2.equals("tileOverlays#update")) {
                    c3 = 29;
                    break;
                }
                break;
            case 1708609913:
                if (str2.equals("tileOverlays#clearTileCache")) {
                    c3 = 30;
                    break;
                }
                break;
            case 1873569705:
                if (str2.equals("circles#update")) {
                    c3 = 31;
                    break;
                }
                break;
            case 1915657375:
                if (str2.equals("map#isLiteModeEnabled")) {
                    c3 = ' ';
                    break;
                }
                break;
            case 1953391461:
                if (str2.equals("markers#showInfoWindow")) {
                    c3 = '!';
                    break;
                }
                break;
            case 2003557999:
                if (str2.equals("camera#move")) {
                    c3 = '\"';
                    break;
                }
                break;
        }
        switch (c3) {
            case 0:
                GoogleMap googleMap = this.f3231h;
                if (googleMap == null) {
                    str = "getVisibleRegion called prior to map initialization";
                    dVar.b("GoogleMap uninitialized", str, null);
                    break;
                } else {
                    obj = f.n(googleMap.getProjection().getVisibleRegion().latLngBounds);
                    dVar.a(obj);
                    break;
                }
            case 1:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isScrollGesturesEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 2:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isRotateGesturesEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 3:
                f.g(kVar.a("options"), this);
                obj = f.a(z());
                dVar.a(obj);
                break;
            case 4:
                if (this.f3231h == null) {
                    str = "getScreenCoordinate called prior to map initialization";
                    dVar.b("GoogleMap uninitialized", str, null);
                    break;
                } else {
                    obj = f.q(this.f3231h.getProjection().toScreenLocation(f.G(kVar.f4373b)));
                    dVar.a(obj);
                    break;
                }
            case 5:
                v(f.y(kVar.a("cameraUpdate"), this.f3240q));
                dVar.a(null);
                break;
            case 6:
                this.f3244u.l((String) kVar.a("markerId"), dVar);
                break;
            case 7:
                obj = this.f3249z.g((String) kVar.a("tileOverlayId"));
                dVar.a(obj);
                break;
            case '\b':
                this.f3246w.c((List) kVar.a("polygonsToAdd"));
                this.f3246w.e((List) kVar.a("polygonsToChange"));
                this.f3246w.h((List) kVar.a("polygonIdsToRemove"));
                dVar.a(null);
                break;
            case '\t':
                this.f3245v.e((String) kVar.a("clusterManagerId"), dVar);
                break;
            case '\n':
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isTiltGesturesEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 11:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isMyLocationButtonEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case '\f':
                this.f3244u.k((String) kVar.a("markerId"), dVar);
                break;
            case '\r':
                obj = Float.valueOf(this.f3231h.getCameraPosition().zoom);
                dVar.a(obj);
                break;
            case 14:
                List<Object> list = (List) kVar.a("clusterManagersToAdd");
                if (list != null) {
                    this.f3245v.b(list);
                }
                List<Object> list2 = (List) kVar.a("clusterManagerIdsToRemove");
                if (list2 != null) {
                    this.f3245v.k(list2);
                }
                dVar.a(null);
                break;
            case 15:
                obj = this.J;
                dVar.a(obj);
                break;
            case 16:
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(Float.valueOf(this.f3231h.getMinZoomLevel()));
                arrayList.add(Float.valueOf(this.f3231h.getMaxZoomLevel()));
                obj = arrayList;
                dVar.a(obj);
                break;
            case 17:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isZoomGesturesEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 18:
                if (this.f3231h == null) {
                    this.f3241r = dVar;
                    break;
                } else {
                    dVar.a(null);
                    break;
                }
            case 19:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isMapToolbarEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 20:
                GoogleMap googleMap2 = this.f3231h;
                if (googleMap2 == null) {
                    str = "takeSnapshot";
                    dVar.b("GoogleMap uninitialized", str, null);
                    break;
                } else {
                    googleMap2.snapshot(new b(dVar));
                    break;
                }
            case 21:
                if (this.f3231h == null) {
                    str = "getLatLng called prior to map initialization";
                    dVar.b("GoogleMap uninitialized", str, null);
                    break;
                } else {
                    obj = f.o(this.f3231h.getProjection().fromScreenLocation(f.N(kVar.f4373b)));
                    dVar.a(obj);
                    break;
                }
            case 22:
                this.f3247x.c((List) kVar.a("polylinesToAdd"));
                this.f3247x.e((List) kVar.a("polylinesToChange"));
                this.f3247x.h((List) kVar.a("polylineIdsToRemove"));
                dVar.a(null);
                break;
            case 23:
                Object obj2 = kVar.f4373b;
                boolean X = X(obj2 instanceof String ? (String) obj2 : null);
                ArrayList arrayList2 = new ArrayList(2);
                arrayList2.add(Boolean.valueOf(X));
                if (!X) {
                    arrayList2.add(this.J);
                }
                dVar.a(arrayList2);
                break;
            case 24:
                isScrollGesturesEnabled = this.f3231h.isBuildingsEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isCompassEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                isScrollGesturesEnabled = this.f3231h.getUiSettings().isZoomControlsEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 27:
                this.f3244u.e((List) kVar.a("markersToAdd"));
                this.f3244u.g((List) kVar.a("markersToChange"));
                this.f3244u.u((List) kVar.a("markerIdsToRemove"));
                dVar.a(null);
                break;
            case 28:
                isScrollGesturesEnabled = this.f3231h.isTrafficEnabled();
                obj = Boolean.valueOf(isScrollGesturesEnabled);
                dVar.a(obj);
                break;
            case 29:
                this.f3249z.b((List) kVar.a("tileOverlaysToAdd"));
                this.f3249z.d((List) kVar.a("tileOverlaysToChange"));
                this.f3249z.i((List) kVar.a("tileOverlayIdsToRemove"));
                dVar.a(null);
                break;
            case 30:
                this.f3249z.e((String) kVar.a("tileOverlayId"));
                dVar.a(null);
                break;
            case 31:
                this.f3248y.c((List) kVar.a("circlesToAdd"));
                this.f3248y.e((List) kVar.a("circlesToChange"));
                this.f3248y.h((List) kVar.a("circleIdsToRemove"));
                dVar.a(null);
                break;
            case ' ':
                obj = this.f3229f.getLiteMode();
                dVar.a(obj);
                break;
            case '!':
                this.f3244u.w((String) kVar.a("markerId"), dVar);
                break;
            case '\"':
                D(f.y(kVar.a("cameraUpdate"), this.f3240q));
                dVar.a(null);
                break;
            default:
                dVar.c();
                break;
        }
    }

    @Override // io.flutter.plugin.platform.k
    public /* synthetic */ void o() {
        io.flutter.plugin.platform.j.d(this);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public void onCameraIdle() {
        this.f3245v.onCameraIdle();
        this.f3228d.c("camera#onIdle", Collections.singletonMap("map", Integer.valueOf(this.f3227c)));
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
    public void onCameraMove() {
        if (this.f3232i) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("position", f.a(this.f3231h.getCameraPosition()));
            this.f3228d.c("camera#onMove", hashMap);
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
    public void onCameraMoveStarted(int i3) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("isGesture", Boolean.valueOf(i3 == 1));
        this.f3228d.c("camera#onMoveStarted", hashMap);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCircleClickListener
    public void onCircleClick(Circle circle) {
        this.f3248y.g(circle.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        this.f3244u.n(marker.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("position", f.o(latLng));
        this.f3228d.c("map#onTap", hashMap);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
    public void onMapLongClick(LatLng latLng) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("position", f.o(latLng));
        this.f3228d.c("map#onLongPress", hashMap);
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.f3231h = googleMap;
        googleMap.setIndoorEnabled(this.f3236m);
        this.f3231h.setTrafficEnabled(this.f3237n);
        this.f3231h.setBuildingsEnabled(this.f3238o);
        C();
        l.d dVar = this.f3241r;
        if (dVar != null) {
            dVar.a(null);
            this.f3241r = null;
        }
        I(this);
        MarkerManager markerManager = new MarkerManager(googleMap);
        this.A = markerManager;
        this.B = markerManager.newCollection();
        Y();
        this.f3244u.v(this.B);
        this.f3245v.f(googleMap, this.A);
        this.f3246w.i(googleMap);
        this.f3247x.i(googleMap);
        this.f3248y.i(googleMap);
        this.f3249z.j(googleMap);
        Q(this);
        G(this);
        H(this);
        S();
        T();
        U();
        V();
        R();
        W();
        List<Float> list = this.K;
        if (list != null && list.size() == 4) {
            l(this.K.get(0).floatValue(), this.K.get(1).floatValue(), this.K.get(2).floatValue(), this.K.get(3).floatValue());
        }
        String str = this.I;
        if (str != null) {
            X(str);
            this.I = null;
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        return this.f3244u.o(marker.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        this.f3244u.p(marker.getId(), marker.getPosition());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        this.f3244u.q(marker.getId(), marker.getPosition());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        this.f3244u.r(marker.getId(), marker.getPosition());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
    public void onPolygonClick(Polygon polygon) {
        this.f3246w.g(polygon.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
    public void onPolylineClick(Polyline polyline) {
        this.f3247x.g(polyline.getId());
    }

    @Override // n1.c.a
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onSaveInstanceState(bundle);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void p(boolean z3) {
        this.f3229f.liteMode(z3);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void q(androidx.lifecycle.i iVar) {
        if (this.f3239p) {
            return;
        }
        this.f3230g.onStart();
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void r(LatLngBounds latLngBounds) {
        this.f3231h.setLatLngBoundsForCameraTarget(latLngBounds);
    }

    @Override // io.flutter.plugin.platform.k
    public /* synthetic */ void s() {
        io.flutter.plugin.platform.j.b(this);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setBuildingsEnabled(boolean z3) {
        this.f3238o = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setCompassEnabled(boolean z3) {
        this.f3231h.getUiSettings().setCompassEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setIndoorEnabled(boolean z3) {
        this.f3236m = z3;
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMapToolbarEnabled(boolean z3) {
        this.f3231h.getUiSettings().setMapToolbarEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMapType(int i3) {
        this.f3231h.setMapType(i3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMyLocationButtonEnabled(boolean z3) {
        if (this.f3234k == z3) {
            return;
        }
        this.f3234k = z3;
        if (this.f3231h != null) {
            Y();
        }
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setMyLocationEnabled(boolean z3) {
        if (this.f3233j == z3) {
            return;
        }
        this.f3233j = z3;
        if (this.f3231h != null) {
            Y();
        }
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setRotateGesturesEnabled(boolean z3) {
        this.f3231h.getUiSettings().setRotateGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setScrollGesturesEnabled(boolean z3) {
        this.f3231h.getUiSettings().setScrollGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setTiltGesturesEnabled(boolean z3) {
        this.f3231h.getUiSettings().setTiltGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setTrafficEnabled(boolean z3) {
        this.f3237n = z3;
        GoogleMap googleMap = this.f3231h;
        if (googleMap == null) {
            return;
        }
        googleMap.setTrafficEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setZoomControlsEnabled(boolean z3) {
        if (this.f3235l == z3) {
            return;
        }
        this.f3235l = z3;
        GoogleMap googleMap = this.f3231h;
        if (googleMap != null) {
            googleMap.getUiSettings().setZoomControlsEnabled(z3);
        }
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void setZoomGesturesEnabled(boolean z3) {
        this.f3231h.getUiSettings().setZoomGesturesEnabled(z3);
    }

    @Override // io.flutter.plugins.googlemaps.k
    public void t(String str) {
        if (this.f3231h == null) {
            this.I = str;
        } else {
            X(str);
        }
    }
}
