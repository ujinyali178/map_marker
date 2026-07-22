.class Landroidx/core/location/c$b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/location/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation


# direct methods
.method static a(Landroid/location/LocationManager;Ljava/lang/String;)Z
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/location/f;->a(Landroid/location/LocationManager;Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method static b(Landroid/location/LocationManager;Ljava/util/concurrent/Executor;Landroid/location/GnssMeasurementsEvent$Callback;)Z
    .registers 3

    invoke-static {p0, p1, p2}, Landroidx/core/location/d;->a(Landroid/location/LocationManager;Ljava/util/concurrent/Executor;Landroid/location/GnssMeasurementsEvent$Callback;)Z

    move-result p0

    return p0
.end method

.method static c(Landroid/location/LocationManager;Ljava/lang/String;Landroid/location/LocationRequest;Ljava/util/concurrent/Executor;Landroid/location/LocationListener;)V
    .registers 5

    invoke-static {p0, p1, p2, p3, p4}, Landroidx/core/location/e;->a(Landroid/location/LocationManager;Ljava/lang/String;Landroid/location/LocationRequest;Ljava/util/concurrent/Executor;Landroid/location/LocationListener;)V

    return-void
.end method
