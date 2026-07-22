.class public Lcom/baseflow/geolocator/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/e$d;


# instance fields
.field private c:Lu1/e;

.field private d:Landroid/content/Context;

.field private f:Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private b()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/b;->d:Landroid/content/Context;

    if-eqz v0, :cond_b

    iget-object v1, p0, Lcom/baseflow/geolocator/b;->f:Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;

    if-eqz v1, :cond_b

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    :cond_b
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)V
    .registers 2

    invoke-direct {p0}, Lcom/baseflow/geolocator/b;->b()V

    return-void
.end method

.method public c(Ljava/lang/Object;Lu1/e$b;)V
    .registers 5

    iget-object p1, p0, Lcom/baseflow/geolocator/b;->d:Landroid/content/Context;

    if-nez p1, :cond_5

    return-void

    :cond_5
    new-instance p1, Landroid/content/IntentFilter;

    const-string v0, "android.location.PROVIDERS_CHANGED"

    invoke-direct {p1, v0}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    const-string v0, "android.intent.action.PROVIDER_CHANGED"

    invoke-virtual {p1, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    new-instance v0, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;

    invoke-direct {v0, p2}, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;-><init>(Lu1/e$b;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/b;->f:Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;

    iget-object p2, p0, Lcom/baseflow/geolocator/b;->d:Landroid/content/Context;

    const/4 v1, 0x2

    invoke-static {p2, v0, p1, v1}, Landroidx/core/content/a;->registerReceiver(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;I)Landroid/content/Intent;

    return-void
.end method

.method d(Landroid/content/Context;)V
    .registers 2

    iput-object p1, p0, Lcom/baseflow/geolocator/b;->d:Landroid/content/Context;

    return-void
.end method

.method e(Landroid/content/Context;Lu1/d;)V
    .registers 5

    iget-object v0, p0, Lcom/baseflow/geolocator/b;->c:Lu1/e;

    if-eqz v0, :cond_e

    const-string v0, "LocationServiceHandler"

    const-string v1, "Setting a event call handler before the last was disposed."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Lcom/baseflow/geolocator/b;->f()V

    :cond_e
    new-instance v0, Lu1/e;

    const-string v1, "flutter.baseflow.com/geolocator_service_updates_android"

    invoke-direct {v0, p2, v1}, Lu1/e;-><init>(Lu1/d;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/b;->c:Lu1/e;

    invoke-virtual {v0, p0}, Lu1/e;->d(Lu1/e$d;)V

    iput-object p1, p0, Lcom/baseflow/geolocator/b;->d:Landroid/content/Context;

    return-void
.end method

.method f()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/b;->c:Lu1/e;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-direct {p0}, Lcom/baseflow/geolocator/b;->b()V

    iget-object v0, p0, Lcom/baseflow/geolocator/b;->c:Lu1/e;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lu1/e;->d(Lu1/e$d;)V

    iput-object v1, p0, Lcom/baseflow/geolocator/b;->c:Lu1/e;

    return-void
.end method
