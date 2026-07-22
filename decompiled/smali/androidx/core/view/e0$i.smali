.class Landroidx/core/view/e0$i;
.super Landroidx/core/view/e0$h;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/e0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "i"
.end annotation


# direct methods
.method constructor <init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Landroidx/core/view/e0$h;-><init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V

    return-void
.end method

.method constructor <init>(Landroidx/core/view/e0;Landroidx/core/view/e0$i;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Landroidx/core/view/e0$h;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$h;)V

    return-void
.end method


# virtual methods
.method a()Landroidx/core/view/e0;
    .registers 2

    iget-object v0, p0, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    invoke-static {v0}, Landroidx/core/view/g0;->a(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/view/e0;->n(Landroid/view/WindowInsets;)Landroidx/core/view/e0;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Landroidx/core/view/e0$i;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Landroidx/core/view/e0$i;

    iget-object v1, p0, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    iget-object v3, p1, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    invoke-static {v1, v3}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_21

    iget-object v1, p0, Landroidx/core/view/e0$g;->g:Landroidx/core/graphics/b;

    iget-object p1, p1, Landroidx/core/view/e0$g;->g:Landroidx/core/graphics/b;

    invoke-static {v1, p1}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_21

    goto :goto_22

    :cond_21
    const/4 v0, 0x0

    :goto_22
    return v0
.end method

.method f()Landroidx/core/view/a;
    .registers 2

    iget-object v0, p0, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    invoke-static {v0}, Landroidx/core/view/f0;->a(Landroid/view/WindowInsets;)Landroid/view/DisplayCutout;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/view/a;->e(Landroid/view/DisplayCutout;)Landroidx/core/view/a;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    iget-object v0, p0, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    invoke-virtual {v0}, Landroid/view/WindowInsets;->hashCode()I

    move-result v0

    return v0
.end method
