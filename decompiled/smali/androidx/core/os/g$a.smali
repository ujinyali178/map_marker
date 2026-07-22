.class Landroidx/core/os/g$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/os/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation


# direct methods
.method static a(Landroid/content/res/Configuration;Landroidx/core/os/k;)V
    .registers 3

    invoke-virtual {p1}, Landroidx/core/os/k;->f()Z

    move-result v0

    if-nez v0, :cond_e

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroidx/core/os/k;->d(I)Ljava/util/Locale;

    move-result-object p1

    invoke-virtual {p0, p1}, Landroid/content/res/Configuration;->setLocale(Ljava/util/Locale;)V

    :cond_e
    return-void
.end method
