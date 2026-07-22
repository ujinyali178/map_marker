.class Landroidx/core/app/w$j;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/w;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "j"
.end annotation


# direct methods
.method static a(Landroid/app/Notification$Builder;Z)Landroid/app/Notification$Builder;
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/m0;->a(Landroid/app/Notification$Builder;Z)Landroid/app/Notification$Builder;

    move-result-object p0

    return-object p0
.end method

.method static b(Landroid/app/Notification$Builder;Landroid/app/Notification$BubbleMetadata;)Landroid/app/Notification$Builder;
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/k0;->a(Landroid/app/Notification$Builder;Landroid/app/Notification$BubbleMetadata;)Landroid/app/Notification$Builder;

    move-result-object p0

    return-object p0
.end method

.method static c(Landroid/app/Notification$Action$Builder;Z)Landroid/app/Notification$Action$Builder;
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/l0;->a(Landroid/app/Notification$Action$Builder;Z)Landroid/app/Notification$Action$Builder;

    move-result-object p0

    return-object p0
.end method

.method static d(Landroid/app/Notification$Builder;Ljava/lang/Object;)Landroid/app/Notification$Builder;
    .registers 2

    check-cast p1, Landroid/content/LocusId;

    invoke-static {p0, p1}, Landroidx/core/app/n0;->a(Landroid/app/Notification$Builder;Landroid/content/LocusId;)Landroid/app/Notification$Builder;

    move-result-object p0

    return-object p0
.end method
