.class public final Landroidx/lifecycle/c0;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static final a(Landroidx/lifecycle/e0;)Lp/a;
    .registers 2

    const-string v0, "owner"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    instance-of v0, p0, Landroidx/lifecycle/d;

    if-eqz v0, :cond_10

    check-cast p0, Landroidx/lifecycle/d;

    invoke-interface {p0}, Landroidx/lifecycle/d;->getDefaultViewModelCreationExtras()Lp/a;

    move-result-object p0

    goto :goto_12

    :cond_10
    sget-object p0, Lp/a$a;->b:Lp/a$a;

    :goto_12
    return-object p0
.end method
