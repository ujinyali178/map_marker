.class Lcom/baseflow/geolocator/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/e$d;


# instance fields
.field private final c:Lz/b;

.field private final d:Ljava/lang/String;

.field private f:Lu1/e;

.field private g:Landroid/content/Context;

.field private h:Landroid/app/Activity;

.field private i:Lcom/baseflow/geolocator/GeolocatorLocationService;

.field private j:Ly/k;

.field private k:Ly/p;


# direct methods
.method public constructor <init>(Lz/b;Ly/k;Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/baseflow/geolocator/m;->c:Lz/b;

    iput-object p2, p0, Lcom/baseflow/geolocator/m;->j:Ly/k;

    iput-object p3, p0, Lcom/baseflow/geolocator/m;->d:Ljava/lang/String;

    return-void
.end method

.method public static synthetic b(Lu1/e$b;Lx/b;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/m;->g(Lu1/e$b;Lx/b;)V

    return-void
.end method

.method public static synthetic d(Lu1/e$b;Landroid/location/Location;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/m;->f(Lu1/e$b;Landroid/location/Location;)V

    return-void
.end method

.method private e(Z)V
    .registers 4

    const-string v0, "FlutterGeolocator"

    const-string v1, "Geolocator position updates stopped"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v1, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    if-eqz v1, :cond_1c

    invoke-virtual {v1, p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->c(Z)Z

    move-result p1

    if-eqz p1, :cond_1c

    iget-object p1, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    invoke-virtual {p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->q()V

    iget-object p1, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    invoke-virtual {p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->e()V

    goto :goto_21

    :cond_1c
    const-string p1, "There is still another flutter engine connected, not stopping location service"

    invoke-static {v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_21
    iget-object p1, p0, Lcom/baseflow/geolocator/m;->k:Ly/p;

    if-eqz p1, :cond_2f

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->j:Ly/k;

    if-eqz v0, :cond_2f

    invoke-virtual {v0, p1}, Ly/k;->g(Ly/p;)V

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/baseflow/geolocator/m;->k:Ly/p;

    :cond_2f
    return-void
.end method

.method private static synthetic f(Lu1/e$b;Landroid/location/Location;)V
    .registers 2

    invoke-static {p1}, Ly/y;->b(Landroid/location/Location;)Ljava/util/Map;

    move-result-object p1

    invoke-interface {p0, p1}, Lu1/e$b;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic g(Lu1/e$b;Lx/b;)V
    .registers 4

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    const/4 v1, 0x0

    invoke-interface {p0, v0, p1, v1}, Lu1/e$b;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)V
    .registers 2

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lcom/baseflow/geolocator/m;->e(Z)V

    return-void
.end method

.method public c(Ljava/lang/Object;Lu1/e$b;)V
    .registers 7

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/baseflow/geolocator/m;->c:Lz/b;

    iget-object v2, p0, Lcom/baseflow/geolocator/m;->g:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lz/b;->d(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_19

    sget-object p1, Lx/b;->h:Lx/b;

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v1, p1, v0}, Lu1/e$b;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_18
    .catch Lx/c; {:try_start_1 .. :try_end_18} :catch_8b

    return-void

    :cond_19
    check-cast p1, Ljava/util/Map;

    const/4 v1, 0x0

    if-eqz p1, :cond_30

    const-string v2, "forceLocationManager"

    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_30

    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    :cond_30
    invoke-static {p1}, Ly/z;->e(Ljava/util/Map;)Ly/z;

    move-result-object v2

    if-eqz p1, :cond_42

    const-string v0, "foregroundNotificationConfig"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/Map;

    invoke-static {p1}, Ly/d;->i(Ljava/util/Map;)Ly/d;

    move-result-object v0

    :cond_42
    const-string p1, "FlutterGeolocator"

    if-eqz v0, :cond_60

    iget-object v3, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    if-nez v3, :cond_50

    const-string p2, "Location background service has not started correctly"

    invoke-static {p1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_50
    const-string v3, "Geolocator position updates started using Android foreground service"

    invoke-static {p1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-object p1, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    invoke-virtual {p1, v1, v2, p2}, Lcom/baseflow/geolocator/GeolocatorLocationService;->p(ZLy/z;Lu1/e$b;)V

    iget-object p1, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    invoke-virtual {p1, v0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->f(Ly/d;)V

    goto :goto_8a

    :cond_60
    const-string v0, "Geolocator position updates started"

    invoke-static {p1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-object p1, p0, Lcom/baseflow/geolocator/m;->j:Ly/k;

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->g:Landroid/content/Context;

    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v1

    invoke-virtual {p1, v0, v1, v2}, Ly/k;->b(Landroid/content/Context;ZLy/z;)Ly/p;

    move-result-object p1

    iput-object p1, p0, Lcom/baseflow/geolocator/m;->k:Ly/p;

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->j:Ly/k;

    iget-object v1, p0, Lcom/baseflow/geolocator/m;->h:Landroid/app/Activity;

    new-instance v2, Lcom/baseflow/geolocator/k;

    invoke-direct {v2, p2}, Lcom/baseflow/geolocator/k;-><init>(Lu1/e$b;)V

    new-instance v3, Lcom/baseflow/geolocator/l;

    invoke-direct {v3, p2}, Lcom/baseflow/geolocator/l;-><init>(Lu1/e$b;)V

    invoke-virtual {v0, p1, v1, v2, v3}, Ly/k;->f(Ly/p;Landroid/app/Activity;Ly/h0;Lx/a;)V

    :goto_8a
    return-void

    :catch_8b
    sget-object p1, Lx/b;->g:Lx/b;

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v1, p1, v0}, Lu1/e$b;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method public h(Landroid/app/Activity;)V
    .registers 3

    if-nez p1, :cond_d

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->k:Ly/p;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->f:Lu1/e;

    if-eqz v0, :cond_d

    invoke-virtual {p0}, Lcom/baseflow/geolocator/m;->k()V

    :cond_d
    iput-object p1, p0, Lcom/baseflow/geolocator/m;->h:Landroid/app/Activity;

    return-void
.end method

.method public i(Lcom/baseflow/geolocator/GeolocatorLocationService;)V
    .registers 2

    iput-object p1, p0, Lcom/baseflow/geolocator/m;->i:Lcom/baseflow/geolocator/GeolocatorLocationService;

    return-void
.end method

.method j(Landroid/content/Context;Lu1/d;)V
    .registers 5

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->f:Lu1/e;

    if-eqz v0, :cond_e

    const-string v0, "FlutterGeolocator"

    const-string v1, "Setting a event call handler before the last was disposed."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Lcom/baseflow/geolocator/m;->k()V

    :cond_e
    new-instance v0, Lu1/e;

    iget-object v1, p0, Lcom/baseflow/geolocator/m;->d:Ljava/lang/String;

    invoke-direct {v0, p2, v1}, Lu1/e;-><init>(Lu1/d;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/m;->f:Lu1/e;

    invoke-virtual {v0, p0}, Lu1/e;->d(Lu1/e$d;)V

    iput-object p1, p0, Lcom/baseflow/geolocator/m;->g:Landroid/content/Context;

    return-void
.end method

.method k()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->f:Lu1/e;

    if-nez v0, :cond_c

    const-string v0, "FlutterGeolocator"

    const-string v1, "Tried to stop listening when no MethodChannel had been initialized."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_c
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/baseflow/geolocator/m;->e(Z)V

    iget-object v0, p0, Lcom/baseflow/geolocator/m;->f:Lu1/e;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lu1/e;->d(Lu1/e$d;)V

    iput-object v1, p0, Lcom/baseflow/geolocator/m;->f:Lu1/e;

    return-void
.end method
