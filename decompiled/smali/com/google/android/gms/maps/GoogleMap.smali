.class public Lcom/google/android/gms/maps/GoogleMap;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;,
        Lcom/google/android/gms/maps/GoogleMap$OnIndoorStateChangeListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnCameraChangeListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveStartedListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveCanceledListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnCameraIdleListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMapClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMapLongClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMarkerDragListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowLongClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowCloseListener;,
        Lcom/google/android/gms/maps/GoogleMap$InfoWindowAdapter;,
        Lcom/google/android/gms/maps/GoogleMap$OnMyLocationChangeListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMapLoadedCallback;,
        Lcom/google/android/gms/maps/GoogleMap$OnGroundOverlayClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnCircleClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnPolygonClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnPolylineClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$SnapshotReadyCallback;,
        Lcom/google/android/gms/maps/GoogleMap$OnPoiClickListener;,
        Lcom/google/android/gms/maps/GoogleMap$OnMapCapabilitiesChangedListener;
    }
.end annotation


# static fields
.field public static final DEMO_MAP_ID:Ljava/lang/String; = "demo_map_id"

.field public static final MAP_TYPE_HYBRID:I = 0x4

.field public static final MAP_TYPE_NONE:I = 0x0

.field public static final MAP_TYPE_NORMAL:I = 0x1

.field public static final MAP_TYPE_SATELLITE:I = 0x2

.field public static final MAP_TYPE_TERRAIN:I = 0x3


# instance fields
.field private final zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

.field private zzb:Lcom/google/android/gms/maps/model/MapCapabilities;

.field private final zzc:Ljava/util/Map;

.field private final zzd:Ljava/util/Map;

.field private zze:Lcom/google/android/gms/maps/UiSettings;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzc:Ljava/util/Map;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzd:Ljava/util/Map;

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    iput-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    return-void
.end method


# virtual methods
.method public final addCircle(Lcom/google/android/gms/maps/model/CircleOptions;)Lcom/google/android/gms/maps/model/Circle;
    .registers 4

    :try_start_0
    const-string v0, "CircleOptions must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lcom/google/android/gms/maps/model/Circle;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v1, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addCircle(Lcom/google/android/gms/maps/model/CircleOptions;)Lcom/google/android/gms/internal/maps/zzl;

    move-result-object p1

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/Circle;-><init>(Lcom/google/android/gms/internal/maps/zzl;)V
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_10} :catch_11

    return-object v0

    :catch_11
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final addGroundOverlay(Lcom/google/android/gms/maps/model/GroundOverlayOptions;)Lcom/google/android/gms/maps/model/GroundOverlay;
    .registers 3

    :try_start_0
    const-string v0, "GroundOverlayOptions must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addGroundOverlay(Lcom/google/android/gms/maps/model/GroundOverlayOptions;)Lcom/google/android/gms/internal/maps/zzr;

    move-result-object p1

    if-eqz p1, :cond_13

    new-instance v0, Lcom/google/android/gms/maps/model/GroundOverlay;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/GroundOverlay;-><init>(Lcom/google/android/gms/internal/maps/zzr;)V
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_12} :catch_15

    return-object v0

    :cond_13
    const/4 p1, 0x0

    return-object p1

    :catch_15
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final addMarker(Lcom/google/android/gms/maps/model/MarkerOptions;)Lcom/google/android/gms/maps/model/Marker;
    .registers 4

    instance-of v0, p1, Lcom/google/android/gms/maps/model/AdvancedMarkerOptions;

    const/4 v1, 0x1

    if-eqz v0, :cond_8

    invoke-virtual {p1, v1}, Lcom/google/android/gms/maps/model/MarkerOptions;->zzf(I)Lcom/google/android/gms/maps/model/MarkerOptions;

    :cond_8
    :try_start_8
    const-string v0, "MarkerOptions must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addMarker(Lcom/google/android/gms/maps/model/MarkerOptions;)Lcom/google/android/gms/internal/maps/zzad;

    move-result-object v0

    if-eqz v0, :cond_27

    invoke-virtual {p1}, Lcom/google/android/gms/maps/model/MarkerOptions;->zzb()I

    move-result p1

    if-ne p1, v1, :cond_21

    new-instance p1, Lcom/google/android/gms/maps/model/AdvancedMarker;

    invoke-direct {p1, v0}, Lcom/google/android/gms/maps/model/AdvancedMarker;-><init>(Lcom/google/android/gms/internal/maps/zzad;)V

    goto :goto_26

    :cond_21
    new-instance p1, Lcom/google/android/gms/maps/model/Marker;

    invoke-direct {p1, v0}, Lcom/google/android/gms/maps/model/Marker;-><init>(Lcom/google/android/gms/internal/maps/zzad;)V
    :try_end_26
    .catch Landroid/os/RemoteException; {:try_start_8 .. :try_end_26} :catch_29

    :goto_26
    return-object p1

    :cond_27
    const/4 p1, 0x0

    return-object p1

    :catch_29
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final addOnMapCapabilitiesChangedListener(Lcom/google/android/gms/maps/GoogleMap$OnMapCapabilitiesChangedListener;)V
    .registers 4

    :try_start_0
    new-instance v0, Lcom/google/android/gms/maps/zzs;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/maps/zzs;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMapCapabilitiesChangedListener;)V

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zzc:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addOnMapCapabilitiesChangedListener(Lcom/google/android/gms/maps/internal/zzal;)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_f} :catch_10

    return-void

    :catch_10
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final addPolygon(Lcom/google/android/gms/maps/model/PolygonOptions;)Lcom/google/android/gms/maps/model/Polygon;
    .registers 4

    :try_start_0
    const-string v0, "PolygonOptions must not be null"

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lcom/google/android/gms/maps/model/Polygon;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v1, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addPolygon(Lcom/google/android/gms/maps/model/PolygonOptions;)Lcom/google/android/gms/internal/maps/zzag;

    move-result-object p1

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/Polygon;-><init>(Lcom/google/android/gms/internal/maps/zzag;)V
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_10} :catch_11

    return-object v0

    :catch_11
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final addPolyline(Lcom/google/android/gms/maps/model/PolylineOptions;)Lcom/google/android/gms/maps/model/Polyline;
    .registers 4

    :try_start_0
    const-string v0, "PolylineOptions must not be null"

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lcom/google/android/gms/maps/model/Polyline;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v1, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addPolyline(Lcom/google/android/gms/maps/model/PolylineOptions;)Lcom/google/android/gms/internal/maps/zzaj;

    move-result-object p1

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/Polyline;-><init>(Lcom/google/android/gms/internal/maps/zzaj;)V
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_10} :catch_11

    return-object v0

    :catch_11
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final addTileOverlay(Lcom/google/android/gms/maps/model/TileOverlayOptions;)Lcom/google/android/gms/maps/model/TileOverlay;
    .registers 3

    :try_start_0
    const-string v0, "TileOverlayOptions must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->addTileOverlay(Lcom/google/android/gms/maps/model/TileOverlayOptions;)Lcom/google/android/gms/internal/maps/zzam;

    move-result-object p1

    if-eqz p1, :cond_13

    new-instance v0, Lcom/google/android/gms/maps/model/TileOverlay;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/TileOverlay;-><init>(Lcom/google/android/gms/internal/maps/zzam;)V
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_12} :catch_15

    return-object v0

    :cond_13
    const/4 p1, 0x0

    return-object p1

    :catch_15
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final animateCamera(Lcom/google/android/gms/maps/CameraUpdate;)V
    .registers 3

    :try_start_0
    const-string v0, "CameraUpdate must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-virtual {p1}, Lcom/google/android/gms/maps/CameraUpdate;->zza()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->animateCamera(Lcom/google/android/gms/dynamic/IObjectWrapper;)V
    :try_end_e
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_e} :catch_f

    return-void

    :catch_f
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final animateCamera(Lcom/google/android/gms/maps/CameraUpdate;ILcom/google/android/gms/maps/GoogleMap$CancelableCallback;)V
    .registers 6

    :try_start_0
    const-string v0, "CameraUpdate must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-virtual {p1}, Lcom/google/android/gms/maps/CameraUpdate;->zza()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    if-nez p3, :cond_f

    const/4 p3, 0x0

    goto :goto_15

    :cond_f
    new-instance v1, Lcom/google/android/gms/maps/zzab;

    invoke-direct {v1, p3}, Lcom/google/android/gms/maps/zzab;-><init>(Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;)V

    move-object p3, v1

    :goto_15
    invoke-interface {v0, p1, p2, p3}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->animateCameraWithDurationAndCallback(Lcom/google/android/gms/dynamic/IObjectWrapper;ILcom/google/android/gms/maps/internal/zzd;)V
    :try_end_18
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_18} :catch_19

    return-void

    :catch_19
    move-exception p1

    new-instance p2, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {p2, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw p2
.end method

.method public final animateCamera(Lcom/google/android/gms/maps/CameraUpdate;Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;)V
    .registers 5

    :try_start_0
    const-string v0, "CameraUpdate must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-virtual {p1}, Lcom/google/android/gms/maps/CameraUpdate;->zza()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    if-nez p2, :cond_f

    const/4 p2, 0x0

    goto :goto_15

    :cond_f
    new-instance v1, Lcom/google/android/gms/maps/zzab;

    invoke-direct {v1, p2}, Lcom/google/android/gms/maps/zzab;-><init>(Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;)V

    move-object p2, v1

    :goto_15
    invoke-interface {v0, p1, p2}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->animateCameraWithCallback(Lcom/google/android/gms/dynamic/IObjectWrapper;Lcom/google/android/gms/maps/internal/zzd;)V
    :try_end_18
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_18} :catch_19

    return-void

    :catch_19
    move-exception p1

    new-instance p2, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {p2, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw p2
.end method

.method public final clear()V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->clear()V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final getCameraPosition()Lcom/google/android/gms/maps/model/CameraPosition;
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getCameraPosition()Lcom/google/android/gms/maps/model/CameraPosition;

    move-result-object v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return-object v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public getFocusedBuilding()Lcom/google/android/gms/maps/model/IndoorBuilding;
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getFocusedBuilding()Lcom/google/android/gms/internal/maps/zzu;

    move-result-object v0

    if-eqz v0, :cond_e

    new-instance v1, Lcom/google/android/gms/maps/model/IndoorBuilding;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/IndoorBuilding;-><init>(Lcom/google/android/gms/internal/maps/zzu;)V
    :try_end_d
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_d} :catch_10

    return-object v1

    :cond_e
    const/4 v0, 0x0

    return-object v0

    :catch_10
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public getMapCapabilities()Lcom/google/android/gms/maps/model/MapCapabilities;
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzb:Lcom/google/android/gms/maps/model/MapCapabilities;

    if-nez v0, :cond_19

    :try_start_4
    new-instance v0, Lcom/google/android/gms/maps/model/MapCapabilities;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getMapCapabilities()Lcom/google/android/gms/internal/maps/zzaa;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/maps/model/MapCapabilities;-><init>(Lcom/google/android/gms/internal/maps/zzaa;)V

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzb:Lcom/google/android/gms/maps/model/MapCapabilities;
    :try_end_11
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_11} :catch_12

    goto :goto_19

    :catch_12
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1

    :cond_19
    :goto_19
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzb:Lcom/google/android/gms/maps/model/MapCapabilities;

    return-object v0
.end method

.method public final getMapType()I
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getMapType()I

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final getMaxZoomLevel()F
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getMaxZoomLevel()F

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final getMinZoomLevel()F
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getMinZoomLevel()F

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final getMyLocation()Landroid/location/Location;
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getMyLocation()Landroid/location/Location;

    move-result-object v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return-object v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final getProjection()Lcom/google/android/gms/maps/Projection;
    .registers 3

    :try_start_0
    new-instance v0, Lcom/google/android/gms/maps/Projection;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getProjection()Lcom/google/android/gms/maps/internal/IProjectionDelegate;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/maps/Projection;-><init>(Lcom/google/android/gms/maps/internal/IProjectionDelegate;)V
    :try_end_b
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_b} :catch_c

    return-object v0

    :catch_c
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final getUiSettings()Lcom/google/android/gms/maps/UiSettings;
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zze:Lcom/google/android/gms/maps/UiSettings;

    if-nez v0, :cond_11

    new-instance v0, Lcom/google/android/gms/maps/UiSettings;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->getUiSettings()Lcom/google/android/gms/maps/internal/IUiSettingsDelegate;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/maps/UiSettings;-><init>(Lcom/google/android/gms/maps/internal/IUiSettingsDelegate;)V

    iput-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zze:Lcom/google/android/gms/maps/UiSettings;

    :cond_11
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zze:Lcom/google/android/gms/maps/UiSettings;
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_13} :catch_14

    return-object v0

    :catch_14
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final isBuildingsEnabled()Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->isBuildingsEnabled()Z

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final isIndoorEnabled()Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->isIndoorEnabled()Z

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final isMyLocationEnabled()Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->isMyLocationEnabled()Z

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final isTrafficEnabled()Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->isTrafficEnabled()Z

    move-result v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final moveCamera(Lcom/google/android/gms/maps/CameraUpdate;)V
    .registers 3

    :try_start_0
    const-string v0, "CameraUpdate must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-virtual {p1}, Lcom/google/android/gms/maps/CameraUpdate;->zza()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->moveCamera(Lcom/google/android/gms/dynamic/IObjectWrapper;)V
    :try_end_e
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_e} :catch_f

    return-void

    :catch_f
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final removeOnMapCapabilitiesChangedListener(Lcom/google/android/gms/maps/GoogleMap$OnMapCapabilitiesChangedListener;)V
    .registers 4

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzc:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    iget-object v1, p0, Lcom/google/android/gms/maps/GoogleMap;->zzc:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/maps/internal/zzal;

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->removeOnMapCapabilitiesChangedListener(Lcom/google/android/gms/maps/internal/zzal;)V

    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zzc:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1a
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_1a} :catch_1b

    :cond_1a
    return-void

    :catch_1b
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public resetMinMaxZoomPreference()V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->resetMinMaxZoomPreference()V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final setBuildingsEnabled(Z)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setBuildingsEnabled(Z)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setContentDescription(Ljava/lang/String;)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setContentDescription(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setIndoorEnabled(Z)Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setIndoorEnabled(Z)Z

    move-result p1
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return p1

    :catch_7
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setInfoWindowAdapter(Lcom/google/android/gms/maps/GoogleMap$InfoWindowAdapter;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setInfoWindowAdapter(Lcom/google/android/gms/maps/internal/zzi;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzf;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzf;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$InfoWindowAdapter;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setInfoWindowAdapter(Lcom/google/android/gms/maps/internal/zzi;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public setLatLngBoundsForCameraTarget(Lcom/google/android/gms/maps/model/LatLngBounds;)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setLatLngBoundsForCameraTarget(Lcom/google/android/gms/maps/model/LatLngBounds;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setLocationSource(Lcom/google/android/gms/maps/LocationSource;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setLocationSource(Lcom/google/android/gms/maps/internal/ILocationSourceDelegate;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzt;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzt;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/LocationSource;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setLocationSource(Lcom/google/android/gms/maps/internal/ILocationSourceDelegate;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public setMapStyle(Lcom/google/android/gms/maps/model/MapStyleOptions;)Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setMapStyle(Lcom/google/android/gms/maps/model/MapStyleOptions;)Z

    move-result p1
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_6} :catch_7

    return p1

    :catch_7
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setMapType(I)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setMapType(I)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public setMaxZoomPreference(F)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setMaxZoomPreference(F)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public setMinZoomPreference(F)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setMinZoomPreference(F)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setMyLocationEnabled(Z)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setMyLocationEnabled(Z)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnCameraChangeListener(Lcom/google/android/gms/maps/GoogleMap$OnCameraChangeListener;)V
    .registers 4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraChangeListener(Lcom/google/android/gms/maps/internal/zzn;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzu;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzu;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnCameraChangeListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraChangeListener(Lcom/google/android/gms/maps/internal/zzn;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnCameraIdleListener(Lcom/google/android/gms/maps/GoogleMap$OnCameraIdleListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraIdleListener(Lcom/google/android/gms/maps/internal/zzp;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzy;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzy;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnCameraIdleListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraIdleListener(Lcom/google/android/gms/maps/internal/zzp;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnCameraMoveCanceledListener(Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveCanceledListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraMoveCanceledListener(Lcom/google/android/gms/maps/internal/zzr;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzx;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzx;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveCanceledListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraMoveCanceledListener(Lcom/google/android/gms/maps/internal/zzr;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnCameraMoveListener(Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraMoveListener(Lcom/google/android/gms/maps/internal/zzt;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzw;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzw;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraMoveListener(Lcom/google/android/gms/maps/internal/zzt;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnCameraMoveStartedListener(Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveStartedListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraMoveStartedListener(Lcom/google/android/gms/maps/internal/zzv;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzv;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzv;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnCameraMoveStartedListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCameraMoveStartedListener(Lcom/google/android/gms/maps/internal/zzv;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnCircleClickListener(Lcom/google/android/gms/maps/GoogleMap$OnCircleClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCircleClickListener(Lcom/google/android/gms/maps/internal/zzx;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzn;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzn;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnCircleClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnCircleClickListener(Lcom/google/android/gms/maps/internal/zzx;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnGroundOverlayClickListener(Lcom/google/android/gms/maps/GoogleMap$OnGroundOverlayClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnGroundOverlayClickListener(Lcom/google/android/gms/maps/internal/zzz;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzm;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzm;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnGroundOverlayClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnGroundOverlayClickListener(Lcom/google/android/gms/maps/internal/zzz;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnIndoorStateChangeListener(Lcom/google/android/gms/maps/GoogleMap$OnIndoorStateChangeListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnIndoorStateChangeListener(Lcom/google/android/gms/maps/internal/zzab;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzk;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzk;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnIndoorStateChangeListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnIndoorStateChangeListener(Lcom/google/android/gms/maps/internal/zzab;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnInfoWindowClickListener(Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnInfoWindowClickListener(Lcom/google/android/gms/maps/internal/zzad;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzc;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzc;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnInfoWindowClickListener(Lcom/google/android/gms/maps/internal/zzad;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnInfoWindowCloseListener(Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowCloseListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnInfoWindowCloseListener(Lcom/google/android/gms/maps/internal/zzaf;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zze;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zze;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowCloseListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnInfoWindowCloseListener(Lcom/google/android/gms/maps/internal/zzaf;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnInfoWindowLongClickListener(Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowLongClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnInfoWindowLongClickListener(Lcom/google/android/gms/maps/internal/zzah;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzd;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzd;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowLongClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnInfoWindowLongClickListener(Lcom/google/android/gms/maps/internal/zzah;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMapClickListener(Lcom/google/android/gms/maps/GoogleMap$OnMapClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMapClickListener(Lcom/google/android/gms/maps/internal/zzan;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzz;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzz;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMapClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMapClickListener(Lcom/google/android/gms/maps/internal/zzan;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public setOnMapLoadedCallback(Lcom/google/android/gms/maps/GoogleMap$OnMapLoadedCallback;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMapLoadedCallback(Lcom/google/android/gms/maps/internal/zzap;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzj;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzj;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMapLoadedCallback;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMapLoadedCallback(Lcom/google/android/gms/maps/internal/zzap;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMapLongClickListener(Lcom/google/android/gms/maps/GoogleMap$OnMapLongClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMapLongClickListener(Lcom/google/android/gms/maps/internal/zzar;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzaa;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzaa;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMapLongClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMapLongClickListener(Lcom/google/android/gms/maps/internal/zzar;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMarkerClickListener(Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMarkerClickListener(Lcom/google/android/gms/maps/internal/zzav;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zza;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zza;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMarkerClickListener(Lcom/google/android/gms/maps/internal/zzav;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMarkerDragListener(Lcom/google/android/gms/maps/GoogleMap$OnMarkerDragListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMarkerDragListener(Lcom/google/android/gms/maps/internal/zzax;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzb;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzb;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMarkerDragListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMarkerDragListener(Lcom/google/android/gms/maps/internal/zzax;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMyLocationButtonClickListener(Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMyLocationButtonClickListener(Lcom/google/android/gms/maps/internal/zzaz;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzh;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzh;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMyLocationButtonClickListener(Lcom/google/android/gms/maps/internal/zzaz;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMyLocationChangeListener(Lcom/google/android/gms/maps/GoogleMap$OnMyLocationChangeListener;)V
    .registers 4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMyLocationChangeListener(Lcom/google/android/gms/maps/internal/zzbb;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzg;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzg;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMyLocationChangeListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMyLocationChangeListener(Lcom/google/android/gms/maps/internal/zzbb;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnMyLocationClickListener(Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMyLocationClickListener(Lcom/google/android/gms/maps/internal/zzbd;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzi;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzi;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnMyLocationClickListener(Lcom/google/android/gms/maps/internal/zzbd;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnPoiClickListener(Lcom/google/android/gms/maps/GoogleMap$OnPoiClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnPoiClickListener(Lcom/google/android/gms/maps/internal/zzbf;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzr;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzr;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnPoiClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnPoiClickListener(Lcom/google/android/gms/maps/internal/zzbf;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnPolygonClickListener(Lcom/google/android/gms/maps/GoogleMap$OnPolygonClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnPolygonClickListener(Lcom/google/android/gms/maps/internal/zzbh;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzo;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzo;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnPolygonClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnPolygonClickListener(Lcom/google/android/gms/maps/internal/zzbh;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setOnPolylineClickListener(Lcom/google/android/gms/maps/GoogleMap$OnPolylineClickListener;)V
    .registers 4

    if-nez p1, :cond_9

    :try_start_2
    iget-object p1, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnPolylineClickListener(Lcom/google/android/gms/maps/internal/zzbj;)V

    return-void

    :cond_9
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzp;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzp;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$OnPolylineClickListener;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setOnPolylineClickListener(Lcom/google/android/gms/maps/internal/zzbj;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_13} :catch_14

    return-void

    :catch_14
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final setPadding(IIII)V
    .registers 6

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setPadding(IIII)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance p2, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {p2, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw p2
.end method

.method public final setTrafficEnabled(Z)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0, p1}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->setTrafficEnabled(Z)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v0, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v0
.end method

.method public final snapshot(Lcom/google/android/gms/maps/GoogleMap$SnapshotReadyCallback;)V
    .registers 3

    const-string v0, "Callback must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/maps/GoogleMap;->snapshot(Lcom/google/android/gms/maps/GoogleMap$SnapshotReadyCallback;Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public final snapshot(Lcom/google/android/gms/maps/GoogleMap$SnapshotReadyCallback;Landroid/graphics/Bitmap;)V
    .registers 5

    const-string v0, "Callback must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-eqz p2, :cond_c

    invoke-static {p2}, Lcom/google/android/gms/dynamic/ObjectWrapper;->wrap(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p2

    goto :goto_d

    :cond_c
    const/4 p2, 0x0

    :goto_d
    check-cast p2, Lcom/google/android/gms/dynamic/ObjectWrapper;

    :try_start_f
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    new-instance v1, Lcom/google/android/gms/maps/zzq;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/maps/zzq;-><init>(Lcom/google/android/gms/maps/GoogleMap;Lcom/google/android/gms/maps/GoogleMap$SnapshotReadyCallback;)V

    invoke-interface {v0, v1, p2}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->snapshot(Lcom/google/android/gms/maps/internal/zzbw;Lcom/google/android/gms/dynamic/IObjectWrapper;)V
    :try_end_19
    .catch Landroid/os/RemoteException; {:try_start_f .. :try_end_19} :catch_1a

    return-void

    :catch_1a
    move-exception p1

    new-instance p2, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {p2, p1}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw p2
.end method

.method public final stopAnimation()V
    .registers 3

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/maps/GoogleMap;->zza:Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;

    invoke-interface {v0}, Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;->stopAnimation()V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception v0

    new-instance v1, Lcom/google/android/gms/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/google/android/gms/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method
