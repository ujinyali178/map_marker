.class public Lcom/baseflow/geolocator/GeolocatorLocationService;
.super Landroid/app/Service;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/baseflow/geolocator/GeolocatorLocationService$a;
    }
.end annotation


# instance fields
.field private final c:Ljava/lang/String;

.field private final d:Ljava/lang/String;

.field private final f:Lcom/baseflow/geolocator/GeolocatorLocationService$a;

.field private g:Z

.field private h:I

.field private i:I

.field private j:Landroid/app/Activity;

.field private k:Ly/k;

.field private l:Ly/p;

.field private m:Landroid/os/PowerManager$WakeLock;

.field private n:Landroid/net/wifi/WifiManager$WifiLock;

.field private o:Ly/b;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    const-string v0, "GeolocatorLocationService:Wakelock"

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->c:Ljava/lang/String;

    const-string v0, "GeolocatorLocationService:WifiLock"

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->d:Ljava/lang/String;

    new-instance v0, Lcom/baseflow/geolocator/GeolocatorLocationService$a;

    invoke-direct {v0, p0, p0}, Lcom/baseflow/geolocator/GeolocatorLocationService$a;-><init>(Lcom/baseflow/geolocator/GeolocatorLocationService;Lcom/baseflow/geolocator/GeolocatorLocationService;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->f:Lcom/baseflow/geolocator/GeolocatorLocationService$a;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->g:Z

    iput v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    iput v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->i:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->j:Landroid/app/Activity;

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->k:Ly/k;

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->m:Landroid/os/PowerManager$WakeLock;

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->n:Landroid/net/wifi/WifiManager$WifiLock;

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    return-void
.end method

.method public static synthetic a(Lu1/e$b;Landroid/location/Location;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->j(Lu1/e$b;Landroid/location/Location;)V

    return-void
.end method

.method public static synthetic b(Lu1/e$b;Lx/b;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->k(Lu1/e$b;Lx/b;)V

    return-void
.end method

.method private i()I
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1d

    if-ge v0, v1, :cond_8

    const/4 v0, 0x3

    return v0

    :cond_8
    const/4 v0, 0x4

    return v0
.end method

.method private static synthetic j(Lu1/e$b;Landroid/location/Location;)V
    .registers 2

    invoke-static {p1}, Ly/y;->b(Landroid/location/Location;)Ljava/util/Map;

    move-result-object p1

    invoke-interface {p0, p1}, Lu1/e$b;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic k(Lu1/e$b;Lx/b;)V
    .registers 4

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    const/4 v1, 0x0

    invoke-interface {p0, v0, p1, v1}, Lu1/e$b;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private l(Ly/d;)V
    .registers 6

    invoke-direct {p0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->m()V

    invoke-virtual {p1}, Ly/d;->f()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_29

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v2, "power"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    if-eqz v0, :cond_29

    const/4 v2, 0x1

    const-string v3, "GeolocatorLocationService:Wakelock"

    invoke-virtual {v0, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->m:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0, v1}, Landroid/os/PowerManager$WakeLock;->setReferenceCounted(Z)V

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->m:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    :cond_29
    invoke-virtual {p1}, Ly/d;->g()Z

    move-result p1

    if-eqz p1, :cond_51

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    const-string v0, "wifi"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/net/wifi/WifiManager;

    if-eqz p1, :cond_51

    invoke-direct {p0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->i()I

    move-result v0

    const-string v2, "GeolocatorLocationService:WifiLock"

    invoke-virtual {p1, v0, v2}, Landroid/net/wifi/WifiManager;->createWifiLock(ILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;

    move-result-object p1

    iput-object p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->n:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {p1, v1}, Landroid/net/wifi/WifiManager$WifiLock;->setReferenceCounted(Z)V

    iget-object p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->n:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {p1}, Landroid/net/wifi/WifiManager$WifiLock;->acquire()V

    :cond_51
    return-void
.end method

.method private m()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->m:Landroid/os/PowerManager$WakeLock;

    const/4 v1, 0x0

    if-eqz v0, :cond_12

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_12

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->m:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    iput-object v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->m:Landroid/os/PowerManager$WakeLock;

    :cond_12
    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->n:Landroid/net/wifi/WifiManager$WifiLock;

    if-eqz v0, :cond_23

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager$WifiLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_23

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->n:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager$WifiLock;->release()V

    iput-object v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->n:Landroid/net/wifi/WifiManager$WifiLock;

    :cond_23
    return-void
.end method


# virtual methods
.method public c(Z)Z
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eqz p1, :cond_a

    iget p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->i:I

    if-ne p1, v1, :cond_9

    const/4 v0, 0x1

    :cond_9
    return v0

    :cond_a
    iget p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    if-nez p1, :cond_f

    const/4 v0, 0x1

    :cond_f
    return v0
.end method

.method public d(Ly/d;)V
    .registers 4

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    if-eqz v0, :cond_c

    iget-boolean v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->g:Z

    invoke-virtual {v0, p1, v1}, Ly/b;->f(Ly/d;Z)V

    invoke-direct {p0, p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->l(Ly/d;)V

    :cond_c
    return-void
.end method

.method public e()V
    .registers 4

    iget-boolean v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->g:Z

    if-eqz v0, :cond_22

    const-string v0, "FlutterGeolocator"

    const-string v1, "Stop service in foreground."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    const/4 v2, 0x1

    if-lt v0, v1, :cond_16

    invoke-virtual {p0, v2}, Landroid/app/Service;->stopForeground(I)V

    goto :goto_19

    :cond_16
    invoke-virtual {p0, v2}, Landroid/app/Service;->stopForeground(Z)V

    :goto_19
    invoke-direct {p0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->m()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->g:Z

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    :cond_22
    return-void
.end method

.method public f(Ly/d;)V
    .registers 7

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    const-string v1, "FlutterGeolocator"

    if-eqz v0, :cond_f

    const-string v0, "Service already in foreground mode."

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0, p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->d(Ly/d;)V

    goto :goto_3b

    :cond_f
    const-string v0, "Start service in foreground mode."

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Ly/b;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x12697

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const-string v4, "geolocator_channel_01"

    invoke-direct {v0, v1, v4, v3, p1}, Ly/b;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ly/d;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    invoke-virtual {p1}, Ly/d;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ly/b;->d(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    invoke-virtual {v0}, Ly/b;->a()Landroid/app/Notification;

    move-result-object v0

    invoke-virtual {p0, v2, v0}, Landroid/app/Service;->startForeground(ILandroid/app/Notification;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->g:Z

    :goto_3b
    invoke-direct {p0, p1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->l(Ly/d;)V

    return-void
.end method

.method public g()V
    .registers 3

    iget v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Flutter engine connected. Connected engine count "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "FlutterGeolocator"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public h()V
    .registers 3

    iget v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Flutter engine disconnected. Connected engine count "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->h:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "FlutterGeolocator"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public n(Landroid/app/Activity;)V
    .registers 2

    iput-object p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->j:Landroid/app/Activity;

    return-void
.end method

.method public o(Ly/k;)V
    .registers 2

    iput-object p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->k:Ly/k;

    return-void
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 3

    const-string p1, "FlutterGeolocator"

    const-string v0, "Binding to location service."

    invoke-static {p1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->f:Lcom/baseflow/geolocator/GeolocatorLocationService$a;

    return-object p1
.end method

.method public onCreate()V
    .registers 3

    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    const-string v0, "FlutterGeolocator"

    const-string v1, "Creating service."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public onDestroy()V
    .registers 3

    const-string v0, "FlutterGeolocator"

    const-string v1, "Destroying location service."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->q()V

    invoke-virtual {p0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->e()V

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->k:Ly/k;

    iput-object v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->o:Ly/b;

    const-string v1, "Destroyed location service."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .registers 4

    const/4 p1, 0x1

    return p1
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .registers 4

    const-string v0, "FlutterGeolocator"

    const-string v1, "Unbinding from location service."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-super {p0, p1}, Landroid/app/Service;->onUnbind(Landroid/content/Intent;)Z

    move-result p1

    return p1
.end method

.method public p(ZLy/z;Lu1/e$b;)V
    .registers 7

    iget v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->i:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->i:I

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->k:Ly/k;

    if-eqz v0, :cond_2f

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    invoke-virtual {v2, p1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result p1

    invoke-virtual {v0, v1, p1, p2}, Ly/k;->b(Landroid/content/Context;ZLy/z;)Ly/p;

    move-result-object p1

    iput-object p1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->l:Ly/p;

    iget-object p2, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->k:Ly/k;

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->j:Landroid/app/Activity;

    new-instance v1, Lw/a;

    invoke-direct {v1, p3}, Lw/a;-><init>(Lu1/e$b;)V

    new-instance v2, Lw/b;

    invoke-direct {v2, p3}, Lw/b;-><init>(Lu1/e$b;)V

    invoke-virtual {p2, p1, v0, v1, v2}, Ly/k;->f(Ly/p;Landroid/app/Activity;Ly/h0;Lx/a;)V

    :cond_2f
    return-void
.end method

.method public q()V
    .registers 3

    iget v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->i:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->i:I

    const-string v0, "FlutterGeolocator"

    const-string v1, "Stopping location service."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->l:Ly/p;

    if-eqz v0, :cond_18

    iget-object v1, p0, Lcom/baseflow/geolocator/GeolocatorLocationService;->k:Ly/k;

    if-eqz v1, :cond_18

    invoke-virtual {v1, v0}, Ly/k;->g(Ly/p;)V

    :cond_18
    return-void
.end method
