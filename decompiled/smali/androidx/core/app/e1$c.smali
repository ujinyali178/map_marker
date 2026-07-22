.class Landroidx/core/app/e1$c;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/e1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "c"
.end annotation


# direct methods
.method static a(Ljava/lang/Object;)I
    .registers 1

    check-cast p0, Landroid/app/RemoteInput;

    invoke-static {p0}, Landroidx/core/app/k1;->a(Landroid/app/RemoteInput;)I

    move-result p0

    return p0
.end method

.method static b(Landroid/app/RemoteInput$Builder;I)Landroid/app/RemoteInput$Builder;
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/j1;->a(Landroid/app/RemoteInput$Builder;I)Landroid/app/RemoteInput$Builder;

    move-result-object p0

    return-object p0
.end method
