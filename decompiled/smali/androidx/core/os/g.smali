.class public final Landroidx/core/os/g;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/os/g$b;,
        Landroidx/core/os/g$a;
    }
.end annotation


# direct methods
.method public static a(Landroid/content/res/Configuration;)Landroidx/core/os/k;
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_f

    invoke-static {p0}, Landroidx/core/os/g$b;->a(Landroid/content/res/Configuration;)Landroid/os/LocaleList;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/os/k;->h(Landroid/os/LocaleList;)Landroidx/core/os/k;

    move-result-object p0

    return-object p0

    :cond_f
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/util/Locale;

    const/4 v1, 0x0

    iget-object p0, p0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    aput-object p0, v0, v1

    invoke-static {v0}, Landroidx/core/os/k;->a([Ljava/util/Locale;)Landroidx/core/os/k;

    move-result-object p0

    return-object p0
.end method

.method public static b(Landroid/content/res/Configuration;Landroidx/core/os/k;)V
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_a

    invoke-static {p0, p1}, Landroidx/core/os/g$b;->b(Landroid/content/res/Configuration;Landroidx/core/os/k;)V

    goto :goto_d

    :cond_a
    invoke-static {p0, p1}, Landroidx/core/os/g$a;->a(Landroid/content/res/Configuration;Landroidx/core/os/k;)V

    :goto_d
    return-void
.end method
