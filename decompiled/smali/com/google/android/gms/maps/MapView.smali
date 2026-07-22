.class public Lcom/google/android/gms/maps/MapView;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field private final zza:Lcom/google/android/gms/maps/zzai;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 4

    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    new-instance v0, Lcom/google/android/gms/maps/zzai;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/google/android/gms/maps/zzai;-><init>(Landroid/view/ViewGroup;Landroid/content/Context;Lcom/google/android/gms/maps/GoogleMapOptions;)V

    iput-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    const/4 p1, 0x1

    invoke-virtual {p0, p1}, Landroid/view/View;->setClickable(Z)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4

    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    new-instance v0, Lcom/google/android/gms/maps/zzai;

    invoke-static {p1, p2}, Lcom/google/android/gms/maps/GoogleMapOptions;->createFromAttributes(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/GoogleMapOptions;

    move-result-object p2

    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gms/maps/zzai;-><init>(Landroid/view/ViewGroup;Landroid/content/Context;Lcom/google/android/gms/maps/GoogleMapOptions;)V

    iput-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    const/4 p1, 0x1

    invoke-virtual {p0, p1}, Landroid/view/View;->setClickable(Z)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance p3, Lcom/google/android/gms/maps/zzai;

    invoke-static {p1, p2}, Lcom/google/android/gms/maps/GoogleMapOptions;->createFromAttributes(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/google/android/gms/maps/GoogleMapOptions;

    move-result-object p2

    invoke-direct {p3, p0, p1, p2}, Lcom/google/android/gms/maps/zzai;-><init>(Landroid/view/ViewGroup;Landroid/content/Context;Lcom/google/android/gms/maps/GoogleMapOptions;)V

    iput-object p3, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    const/4 p1, 0x1

    invoke-virtual {p0, p1}, Landroid/view/View;->setClickable(Z)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/maps/GoogleMapOptions;)V
    .registers 4

    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    new-instance v0, Lcom/google/android/gms/maps/zzai;

    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gms/maps/zzai;-><init>(Landroid/view/ViewGroup;Landroid/content/Context;Lcom/google/android/gms/maps/GoogleMapOptions;)V

    iput-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    const/4 p1, 0x1

    invoke-virtual {p0, p1}, Landroid/view/View;->setClickable(Z)V

    return-void
.end method


# virtual methods
.method public getMapAsync(Lcom/google/android/gms/maps/OnMapReadyCallback;)V
    .registers 3

    const-string v0, "getMapAsync() must be called on the main thread"

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkMainThread(Ljava/lang/String;)V

    const-string v0, "callback must not be null."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/maps/zzai;->zza(Lcom/google/android/gms/maps/OnMapReadyCallback;)V

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .registers 4

    invoke-static {}, Landroid/os/StrictMode;->getThreadPolicy()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v0

    new-instance v1, Landroid/os/StrictMode$ThreadPolicy$Builder;

    invoke-direct {v1, v0}, Landroid/os/StrictMode$ThreadPolicy$Builder;-><init>(Landroid/os/StrictMode$ThreadPolicy;)V

    invoke-virtual {v1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->permitAll()Landroid/os/StrictMode$ThreadPolicy$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->build()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v1

    invoke-static {v1}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    :try_start_14
    iget-object v1, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v1, p1}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onCreate(Landroid/os/Bundle;)V

    iget-object p1, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {p1}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->getDelegate()Lcom/google/android/gms/dynamic/LifecycleDelegate;

    move-result-object p1

    if-nez p1, :cond_24

    invoke-static {p0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->showGooglePlayUnavailableMessage(Landroid/widget/FrameLayout;)V
    :try_end_24
    .catchall {:try_start_14 .. :try_end_24} :catchall_28

    :cond_24
    invoke-static {v0}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    return-void

    :catchall_28
    move-exception p1

    invoke-static {v0}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    throw p1
.end method

.method public onDestroy()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onDestroy()V

    return-void
.end method

.method public onEnterAmbient(Landroid/os/Bundle;)V
    .registers 4

    const-string v0, "onEnterAmbient() must be called on the main thread"

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkMainThread(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->getDelegate()Lcom/google/android/gms/dynamic/LifecycleDelegate;

    move-result-object v1

    if-eqz v1, :cond_16

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->getDelegate()Lcom/google/android/gms/dynamic/LifecycleDelegate;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/maps/zzah;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/maps/zzah;->zza(Landroid/os/Bundle;)V

    :cond_16
    return-void
.end method

.method public onExitAmbient()V
    .registers 3

    const-string v0, "onExitAmbient() must be called on the main thread"

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkMainThread(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->getDelegate()Lcom/google/android/gms/dynamic/LifecycleDelegate;

    move-result-object v1

    if-eqz v1, :cond_16

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->getDelegate()Lcom/google/android/gms/dynamic/LifecycleDelegate;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/maps/zzah;

    invoke-virtual {v0}, Lcom/google/android/gms/maps/zzah;->zzb()V

    :cond_16
    return-void
.end method

.method public onLowMemory()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onLowMemory()V

    return-void
.end method

.method public onPause()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onPause()V

    return-void
.end method

.method public onResume()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onResume()V

    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    return-void
.end method

.method public onStart()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onStart()V

    return-void
.end method

.method public onStop()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/maps/MapView;->zza:Lcom/google/android/gms/maps/zzai;

    invoke-virtual {v0}, Lcom/google/android/gms/dynamic/DeferredLifecycleHelper;->onStop()V

    return-void
.end method
