.class public Landroidx/core/view/e0;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/view/e0$k;,
        Landroidx/core/view/e0$l;,
        Landroidx/core/view/e0$j;,
        Landroidx/core/view/e0$i;,
        Landroidx/core/view/e0$h;,
        Landroidx/core/view/e0$g;,
        Landroidx/core/view/e0$m;,
        Landroidx/core/view/e0$b;,
        Landroidx/core/view/e0$a;,
        Landroidx/core/view/e0$n;,
        Landroidx/core/view/e0$e;,
        Landroidx/core/view/e0$d;,
        Landroidx/core/view/e0$c;,
        Landroidx/core/view/e0$f;
    }
.end annotation


# static fields
.field public static final b:Landroidx/core/view/e0;


# instance fields
.field private final a:Landroidx/core/view/e0$l;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt v0, v1, :cond_9

    sget-object v0, Landroidx/core/view/e0$k;->q:Landroidx/core/view/e0;

    goto :goto_b

    :cond_9
    sget-object v0, Landroidx/core/view/e0$l;->b:Landroidx/core/view/e0;

    :goto_b
    sput-object v0, Landroidx/core/view/e0;->b:Landroidx/core/view/e0;

    return-void
.end method

.method private constructor <init>(Landroid/view/WindowInsets;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt v0, v1, :cond_11

    new-instance v0, Landroidx/core/view/e0$k;

    invoke-direct {v0, p0, p1}, Landroidx/core/view/e0$k;-><init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V

    :goto_e
    iput-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    goto :goto_2b

    :cond_11
    const/16 v1, 0x1d

    if-lt v0, v1, :cond_1b

    new-instance v0, Landroidx/core/view/e0$j;

    invoke-direct {v0, p0, p1}, Landroidx/core/view/e0$j;-><init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V

    goto :goto_e

    :cond_1b
    const/16 v1, 0x1c

    if-lt v0, v1, :cond_25

    new-instance v0, Landroidx/core/view/e0$i;

    invoke-direct {v0, p0, p1}, Landroidx/core/view/e0$i;-><init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V

    goto :goto_e

    :cond_25
    new-instance v0, Landroidx/core/view/e0$h;

    invoke-direct {v0, p0, p1}, Landroidx/core/view/e0$h;-><init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V

    goto :goto_e

    :goto_2b
    return-void
.end method

.method public constructor <init>(Landroidx/core/view/e0;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_62

    iget-object p1, p1, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt v0, v1, :cond_1c

    instance-of v1, p1, Landroidx/core/view/e0$k;

    if-eqz v1, :cond_1c

    new-instance v0, Landroidx/core/view/e0$k;

    move-object v1, p1

    check-cast v1, Landroidx/core/view/e0$k;

    invoke-direct {v0, p0, v1}, Landroidx/core/view/e0$k;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$k;)V

    :goto_19
    iput-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    goto :goto_5e

    :cond_1c
    const/16 v1, 0x1d

    if-lt v0, v1, :cond_2d

    instance-of v1, p1, Landroidx/core/view/e0$j;

    if-eqz v1, :cond_2d

    new-instance v0, Landroidx/core/view/e0$j;

    move-object v1, p1

    check-cast v1, Landroidx/core/view/e0$j;

    invoke-direct {v0, p0, v1}, Landroidx/core/view/e0$j;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$j;)V

    goto :goto_19

    :cond_2d
    const/16 v1, 0x1c

    if-lt v0, v1, :cond_3e

    instance-of v0, p1, Landroidx/core/view/e0$i;

    if-eqz v0, :cond_3e

    new-instance v0, Landroidx/core/view/e0$i;

    move-object v1, p1

    check-cast v1, Landroidx/core/view/e0$i;

    invoke-direct {v0, p0, v1}, Landroidx/core/view/e0$i;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$i;)V

    goto :goto_19

    :cond_3e
    instance-of v0, p1, Landroidx/core/view/e0$h;

    if-eqz v0, :cond_4b

    new-instance v0, Landroidx/core/view/e0$h;

    move-object v1, p1

    check-cast v1, Landroidx/core/view/e0$h;

    invoke-direct {v0, p0, v1}, Landroidx/core/view/e0$h;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$h;)V

    goto :goto_19

    :cond_4b
    instance-of v0, p1, Landroidx/core/view/e0$g;

    if-eqz v0, :cond_58

    new-instance v0, Landroidx/core/view/e0$g;

    move-object v1, p1

    check-cast v1, Landroidx/core/view/e0$g;

    invoke-direct {v0, p0, v1}, Landroidx/core/view/e0$g;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$g;)V

    goto :goto_19

    :cond_58
    new-instance v0, Landroidx/core/view/e0$l;

    invoke-direct {v0, p0}, Landroidx/core/view/e0$l;-><init>(Landroidx/core/view/e0;)V

    goto :goto_19

    :goto_5e
    invoke-virtual {p1, p0}, Landroidx/core/view/e0$l;->e(Landroidx/core/view/e0;)V

    goto :goto_69

    :cond_62
    new-instance p1, Landroidx/core/view/e0$l;

    invoke-direct {p1, p0}, Landroidx/core/view/e0$l;-><init>(Landroidx/core/view/e0;)V

    iput-object p1, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    :goto_69
    return-void
.end method

.method public static n(Landroid/view/WindowInsets;)Landroidx/core/view/e0;
    .registers 2

    const/4 v0, 0x0

    invoke-static {p0, v0}, Landroidx/core/view/e0;->o(Landroid/view/WindowInsets;Landroid/view/View;)Landroidx/core/view/e0;

    move-result-object p0

    return-object p0
.end method

.method public static o(Landroid/view/WindowInsets;Landroid/view/View;)Landroidx/core/view/e0;
    .registers 3

    new-instance v0, Landroidx/core/view/e0;

    invoke-static {p0}, Landroidx/core/util/d;->e(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroid/view/WindowInsets;

    invoke-direct {v0, p0}, Landroidx/core/view/e0;-><init>(Landroid/view/WindowInsets;)V

    if-eqz p1, :cond_21

    invoke-static {p1}, Landroidx/core/view/n;->i(Landroid/view/View;)Z

    move-result p0

    if-eqz p0, :cond_21

    invoke-static {p1}, Landroidx/core/view/n;->g(Landroid/view/View;)Landroidx/core/view/e0;

    move-result-object p0

    invoke-virtual {v0, p0}, Landroidx/core/view/e0;->k(Landroidx/core/view/e0;)V

    invoke-virtual {p1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object p0

    invoke-virtual {v0, p0}, Landroidx/core/view/e0;->d(Landroid/view/View;)V

    :cond_21
    return-object v0
.end method


# virtual methods
.method public a()Landroidx/core/view/e0;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0}, Landroidx/core/view/e0$l;->a()Landroidx/core/view/e0;

    move-result-object v0

    return-object v0
.end method

.method public b()Landroidx/core/view/e0;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0}, Landroidx/core/view/e0$l;->b()Landroidx/core/view/e0;

    move-result-object v0

    return-object v0
.end method

.method public c()Landroidx/core/view/e0;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0}, Landroidx/core/view/e0$l;->c()Landroidx/core/view/e0;

    move-result-object v0

    return-object v0
.end method

.method d(Landroid/view/View;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0, p1}, Landroidx/core/view/e0$l;->d(Landroid/view/View;)V

    return-void
.end method

.method public e()Landroidx/core/view/a;
    .registers 2

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0}, Landroidx/core/view/e0$l;->f()Landroidx/core/view/a;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 3

    if-ne p0, p1, :cond_4

    const/4 p1, 0x1

    return p1

    :cond_4
    instance-of v0, p1, Landroidx/core/view/e0;

    if-nez v0, :cond_a

    const/4 p1, 0x0

    return p1

    :cond_a
    check-cast p1, Landroidx/core/view/e0;

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    iget-object p1, p1, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-static {v0, p1}, Landroidx/core/util/b;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public f(I)Landroidx/core/graphics/b;
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0, p1}, Landroidx/core/view/e0$l;->g(I)Landroidx/core/graphics/b;

    move-result-object p1

    return-object p1
.end method

.method public g()Landroidx/core/graphics/b;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0}, Landroidx/core/view/e0$l;->i()Landroidx/core/graphics/b;

    move-result-object v0

    return-object v0
.end method

.method public h()Z
    .registers 2

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0}, Landroidx/core/view/e0$l;->m()Z

    move-result v0

    return v0
.end method

.method public hashCode()I
    .registers 2

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Landroidx/core/view/e0$l;->hashCode()I

    move-result v0

    :goto_a
    return v0
.end method

.method i([Landroidx/core/graphics/b;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0, p1}, Landroidx/core/view/e0$l;->o([Landroidx/core/graphics/b;)V

    return-void
.end method

.method j(Landroidx/core/graphics/b;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0, p1}, Landroidx/core/view/e0$l;->p(Landroidx/core/graphics/b;)V

    return-void
.end method

.method k(Landroidx/core/view/e0;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0, p1}, Landroidx/core/view/e0$l;->q(Landroidx/core/view/e0;)V

    return-void
.end method

.method l(Landroidx/core/graphics/b;)V
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    invoke-virtual {v0, p1}, Landroidx/core/view/e0$l;->r(Landroidx/core/graphics/b;)V

    return-void
.end method

.method public m()Landroid/view/WindowInsets;
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0;->a:Landroidx/core/view/e0$l;

    instance-of v1, v0, Landroidx/core/view/e0$g;

    if-eqz v1, :cond_b

    check-cast v0, Landroidx/core/view/e0$g;

    iget-object v0, v0, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return-object v0
.end method
