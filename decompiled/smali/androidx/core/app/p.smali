.class public final Landroidx/core/app/p;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/p$a;
    }
.end annotation


# direct methods
.method public static a(Landroid/content/Context;)Landroidx/core/os/k;
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    if-lt v0, v1, :cond_1a

    invoke-static {p0}, Landroidx/core/app/p;->b(Landroid/content/Context;)Ljava/lang/Object;

    move-result-object p0

    if-eqz p0, :cond_15

    invoke-static {p0}, Landroidx/core/app/p$a;->a(Ljava/lang/Object;)Landroid/os/LocaleList;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/os/k;->h(Landroid/os/LocaleList;)Landroidx/core/os/k;

    move-result-object p0

    return-object p0

    :cond_15
    invoke-static {}, Landroidx/core/os/k;->e()Landroidx/core/os/k;

    move-result-object p0

    return-object p0

    :cond_1a
    invoke-static {p0}, Landroidx/core/app/f;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/os/k;->c(Ljava/lang/String;)Landroidx/core/os/k;

    move-result-object p0

    return-object p0
.end method

.method private static b(Landroid/content/Context;)Ljava/lang/Object;
    .registers 2

    const-string v0, "locale"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method
