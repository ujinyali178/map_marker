.class public Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field private final a:Lu1/e$b;

.field private b:Ly/i0;


# direct methods
.method public constructor <init>(Lu1/e$b;)V
    .registers 2

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    iput-object p1, p0, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;->a:Lu1/e$b;

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 4

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p2

    const-string v0, "android.location.PROVIDERS_CHANGED"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_49

    const-string p2, "location"

    invoke-virtual {p1, p2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/location/LocationManager;

    const-string p2, "gps"

    invoke-virtual {p1, p2}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result p2

    const-string v0, "network"

    invoke-virtual {p1, v0}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result p1

    if-nez p2, :cond_30

    if-eqz p1, :cond_25

    goto :goto_30

    :cond_25
    iget-object p1, p0, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;->b:Ly/i0;

    if-eqz p1, :cond_2d

    sget-object p2, Ly/i0;->d:Ly/i0;

    if-ne p1, p2, :cond_49

    :cond_2d
    sget-object p1, Ly/i0;->c:Ly/i0;

    goto :goto_3a

    :cond_30
    :goto_30
    iget-object p1, p0, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;->b:Ly/i0;

    if-eqz p1, :cond_38

    sget-object p2, Ly/i0;->c:Ly/i0;

    if-ne p1, p2, :cond_49

    :cond_38
    sget-object p1, Ly/i0;->d:Ly/i0;

    :goto_3a
    iput-object p1, p0, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;->b:Ly/i0;

    iget-object p2, p0, Lcom/baseflow/geolocator/location/LocationServiceStatusReceiver;->a:Lu1/e$b;

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {p2, p1}, Lu1/e$b;->a(Ljava/lang/Object;)V

    :cond_49
    return-void
.end method
