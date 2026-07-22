.class public interface abstract Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/IInterface;


# virtual methods
.method public abstract addCircle(Lcom/google/android/gms/maps/model/CircleOptions;)Lcom/google/android/gms/internal/maps/zzl;
.end method

.method public abstract addGroundOverlay(Lcom/google/android/gms/maps/model/GroundOverlayOptions;)Lcom/google/android/gms/internal/maps/zzr;
.end method

.method public abstract addMarker(Lcom/google/android/gms/maps/model/MarkerOptions;)Lcom/google/android/gms/internal/maps/zzad;
.end method

.method public abstract addOnMapCapabilitiesChangedListener(Lcom/google/android/gms/maps/internal/zzal;)V
.end method

.method public abstract addPolygon(Lcom/google/android/gms/maps/model/PolygonOptions;)Lcom/google/android/gms/internal/maps/zzag;
.end method

.method public abstract addPolyline(Lcom/google/android/gms/maps/model/PolylineOptions;)Lcom/google/android/gms/internal/maps/zzaj;
.end method

.method public abstract addTileOverlay(Lcom/google/android/gms/maps/model/TileOverlayOptions;)Lcom/google/android/gms/internal/maps/zzam;
.end method

.method public abstract animateCamera(Lcom/google/android/gms/dynamic/IObjectWrapper;)V
.end method

.method public abstract animateCameraWithCallback(Lcom/google/android/gms/dynamic/IObjectWrapper;Lcom/google/android/gms/maps/internal/zzd;)V
    .param p2    # Lcom/google/android/gms/maps/internal/zzd;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract animateCameraWithDurationAndCallback(Lcom/google/android/gms/dynamic/IObjectWrapper;ILcom/google/android/gms/maps/internal/zzd;)V
    .param p3    # Lcom/google/android/gms/maps/internal/zzd;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract clear()V
.end method

.method public abstract getCameraPosition()Lcom/google/android/gms/maps/model/CameraPosition;
.end method

.method public abstract getFeatureLayer(Lcom/google/android/gms/maps/model/zzd;)Lcom/google/android/gms/internal/maps/zzo;
.end method

.method public abstract getFocusedBuilding()Lcom/google/android/gms/internal/maps/zzu;
.end method

.method public abstract getMapAsync(Lcom/google/android/gms/maps/internal/zzat;)V
.end method

.method public abstract getMapCapabilities()Lcom/google/android/gms/internal/maps/zzaa;
.end method

.method public abstract getMapType()I
.end method

.method public abstract getMaxZoomLevel()F
.end method

.method public abstract getMinZoomLevel()F
.end method

.method public abstract getMyLocation()Landroid/location/Location;
.end method

.method public abstract getProjection()Lcom/google/android/gms/maps/internal/IProjectionDelegate;
.end method

.method public abstract getUiSettings()Lcom/google/android/gms/maps/internal/IUiSettingsDelegate;
.end method

.method public abstract isBuildingsEnabled()Z
.end method

.method public abstract isIndoorEnabled()Z
.end method

.method public abstract isMyLocationEnabled()Z
.end method

.method public abstract isTrafficEnabled()Z
.end method

.method public abstract moveCamera(Lcom/google/android/gms/dynamic/IObjectWrapper;)V
.end method

.method public abstract onCreate(Landroid/os/Bundle;)V
.end method

.method public abstract onDestroy()V
.end method

.method public abstract onEnterAmbient(Landroid/os/Bundle;)V
.end method

.method public abstract onExitAmbient()V
.end method

.method public abstract onLowMemory()V
.end method

.method public abstract onPause()V
.end method

.method public abstract onResume()V
.end method

.method public abstract onSaveInstanceState(Landroid/os/Bundle;)V
.end method

.method public abstract onStart()V
.end method

.method public abstract onStop()V
.end method

.method public abstract removeOnMapCapabilitiesChangedListener(Lcom/google/android/gms/maps/internal/zzal;)V
.end method

.method public abstract resetMinMaxZoomPreference()V
.end method

.method public abstract setBuildingsEnabled(Z)V
.end method

.method public abstract setContentDescription(Ljava/lang/String;)V
    .param p1    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setIndoorEnabled(Z)Z
.end method

.method public abstract setInfoWindowAdapter(Lcom/google/android/gms/maps/internal/zzi;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzi;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setLatLngBoundsForCameraTarget(Lcom/google/android/gms/maps/model/LatLngBounds;)V
    .param p1    # Lcom/google/android/gms/maps/model/LatLngBounds;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setLocationSource(Lcom/google/android/gms/maps/internal/ILocationSourceDelegate;)V
    .param p1    # Lcom/google/android/gms/maps/internal/ILocationSourceDelegate;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setMapStyle(Lcom/google/android/gms/maps/model/MapStyleOptions;)Z
    .param p1    # Lcom/google/android/gms/maps/model/MapStyleOptions;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setMapType(I)V
.end method

.method public abstract setMaxZoomPreference(F)V
.end method

.method public abstract setMinZoomPreference(F)V
.end method

.method public abstract setMyLocationEnabled(Z)V
.end method

.method public abstract setOnCameraChangeListener(Lcom/google/android/gms/maps/internal/zzn;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzn;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnCameraIdleListener(Lcom/google/android/gms/maps/internal/zzp;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzp;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnCameraMoveCanceledListener(Lcom/google/android/gms/maps/internal/zzr;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzr;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnCameraMoveListener(Lcom/google/android/gms/maps/internal/zzt;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzt;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnCameraMoveStartedListener(Lcom/google/android/gms/maps/internal/zzv;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzv;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnCircleClickListener(Lcom/google/android/gms/maps/internal/zzx;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzx;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnGroundOverlayClickListener(Lcom/google/android/gms/maps/internal/zzz;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzz;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnIndoorStateChangeListener(Lcom/google/android/gms/maps/internal/zzab;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzab;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnInfoWindowClickListener(Lcom/google/android/gms/maps/internal/zzad;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzad;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnInfoWindowCloseListener(Lcom/google/android/gms/maps/internal/zzaf;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzaf;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnInfoWindowLongClickListener(Lcom/google/android/gms/maps/internal/zzah;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzah;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMapClickListener(Lcom/google/android/gms/maps/internal/zzan;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzan;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMapLoadedCallback(Lcom/google/android/gms/maps/internal/zzap;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMapLongClickListener(Lcom/google/android/gms/maps/internal/zzar;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzar;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMarkerClickListener(Lcom/google/android/gms/maps/internal/zzav;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzav;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMarkerDragListener(Lcom/google/android/gms/maps/internal/zzax;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzax;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMyLocationButtonClickListener(Lcom/google/android/gms/maps/internal/zzaz;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzaz;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMyLocationChangeListener(Lcom/google/android/gms/maps/internal/zzbb;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzbb;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnMyLocationClickListener(Lcom/google/android/gms/maps/internal/zzbd;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzbd;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnPoiClickListener(Lcom/google/android/gms/maps/internal/zzbf;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzbf;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnPolygonClickListener(Lcom/google/android/gms/maps/internal/zzbh;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzbh;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setOnPolylineClickListener(Lcom/google/android/gms/maps/internal/zzbj;)V
    .param p1    # Lcom/google/android/gms/maps/internal/zzbj;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract setPadding(IIII)V
.end method

.method public abstract setTrafficEnabled(Z)V
.end method

.method public abstract setWatermarkEnabled(Z)V
.end method

.method public abstract snapshot(Lcom/google/android/gms/maps/internal/zzbw;Lcom/google/android/gms/dynamic/IObjectWrapper;)V
    .param p2    # Lcom/google/android/gms/dynamic/IObjectWrapper;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method public abstract snapshotForTest(Lcom/google/android/gms/maps/internal/zzbw;)V
.end method

.method public abstract stopAnimation()V
.end method

.method public abstract useViewLifecycleWhenInFragment()Z
.end method
