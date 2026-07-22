.class Landroidx/core/os/g$b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/os/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "b"
.end annotation


# direct methods
.method static a(Landroid/content/res/Configuration;)Landroid/os/LocaleList;
    .registers 1

    invoke-static {p0}, Landroidx/core/os/h;->a(Landroid/content/res/Configuration;)Landroid/os/LocaleList;

    move-result-object p0

    return-object p0
.end method

.method static b(Landroid/content/res/Configuration;Landroidx/core/os/k;)V
    .registers 2

    invoke-virtual {p1}, Landroidx/core/os/k;->g()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/os/LocaleList;

    invoke-static {p0, p1}, Landroidx/core/os/i;->a(Landroid/content/res/Configuration;Landroid/os/LocaleList;)V

    return-void
.end method
