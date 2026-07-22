.class Landroidx/core/app/s0$b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/s0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "b"
.end annotation


# direct methods
.method static a(Landroid/app/NotificationManager;Landroid/app/NotificationChannel;)V
    .registers 2

    invoke-static {p0, p1}, Lg/b;->a(Landroid/app/NotificationManager;Landroid/app/NotificationChannel;)V

    return-void
.end method

.method static b(Landroid/app/NotificationManager;Landroid/app/NotificationChannelGroup;)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/y0;->a(Landroid/app/NotificationManager;Landroid/app/NotificationChannelGroup;)V

    return-void
.end method

.method static c(Landroid/app/NotificationManager;Ljava/util/List;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/NotificationManager;",
            "Ljava/util/List<",
            "Landroid/app/NotificationChannelGroup;",
            ">;)V"
        }
    .end annotation

    invoke-static {p0, p1}, Landroidx/core/app/x0;->a(Landroid/app/NotificationManager;Ljava/util/List;)V

    return-void
.end method

.method static d(Landroid/app/NotificationManager;Ljava/util/List;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/NotificationManager;",
            "Ljava/util/List<",
            "Landroid/app/NotificationChannel;",
            ">;)V"
        }
    .end annotation

    invoke-static {p0, p1}, Landroidx/core/app/z0;->a(Landroid/app/NotificationManager;Ljava/util/List;)V

    return-void
.end method

.method static e(Landroid/app/NotificationManager;Ljava/lang/String;)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/t0;->a(Landroid/app/NotificationManager;Ljava/lang/String;)V

    return-void
.end method

.method static f(Landroid/app/NotificationManager;Ljava/lang/String;)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/w0;->a(Landroid/app/NotificationManager;Ljava/lang/String;)V

    return-void
.end method

.method static g(Landroid/app/NotificationChannel;)Ljava/lang/String;
    .registers 1

    invoke-virtual {p0}, Landroid/app/NotificationChannel;->getId()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static h(Landroid/app/NotificationChannelGroup;)Ljava/lang/String;
    .registers 1

    invoke-virtual {p0}, Landroid/app/NotificationChannelGroup;->getId()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static i(Landroid/app/NotificationManager;Ljava/lang/String;)Landroid/app/NotificationChannel;
    .registers 2

    invoke-static {p0, p1}, Lg/c;->a(Landroid/app/NotificationManager;Ljava/lang/String;)Landroid/app/NotificationChannel;

    move-result-object p0

    return-object p0
.end method

.method static j(Landroid/app/NotificationManager;)Ljava/util/List;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/NotificationManager;",
            ")",
            "Ljava/util/List<",
            "Landroid/app/NotificationChannelGroup;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Landroidx/core/app/v0;->a(Landroid/app/NotificationManager;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method static k(Landroid/app/NotificationManager;)Ljava/util/List;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/NotificationManager;",
            ")",
            "Ljava/util/List<",
            "Landroid/app/NotificationChannel;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Landroidx/core/app/u0;->a(Landroid/app/NotificationManager;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method
