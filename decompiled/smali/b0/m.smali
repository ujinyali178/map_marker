.class public final Lb0/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lm1/a;
.implements Ln1/a;


# instance fields
.field private c:Lb0/u;

.field private d:Lu1/l;

.field private f:Lu1/n$c;

.field private g:Ln1/c;

.field private h:Lb0/l;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a()V
    .registers 3

    iget-object v0, p0, Lb0/m;->g:Ln1/c;

    if-eqz v0, :cond_10

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    invoke-interface {v0, v1}, Ln1/c;->d(Lu1/n$a;)V

    iget-object v0, p0, Lb0/m;->g:Ln1/c;

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    invoke-interface {v0, v1}, Ln1/c;->c(Lu1/n$d;)V

    :cond_10
    return-void
.end method

.method private c()V
    .registers 3

    iget-object v0, p0, Lb0/m;->f:Lu1/n$c;

    if-eqz v0, :cond_11

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    invoke-interface {v0, v1}, Lu1/n$c;->a(Lu1/n$a;)Lu1/n$c;

    iget-object v0, p0, Lb0/m;->f:Lu1/n$c;

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    invoke-interface {v0, v1}, Lu1/n$c;->b(Lu1/n$d;)Lu1/n$c;

    goto :goto_21

    :cond_11
    iget-object v0, p0, Lb0/m;->g:Ln1/c;

    if-eqz v0, :cond_21

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    invoke-interface {v0, v1}, Ln1/c;->a(Lu1/n$a;)V

    iget-object v0, p0, Lb0/m;->g:Ln1/c;

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    invoke-interface {v0, v1}, Ln1/c;->b(Lu1/n$d;)V

    :cond_21
    :goto_21
    return-void
.end method

.method private f(Landroid/content/Context;Lu1/d;)V
    .registers 6

    new-instance v0, Lu1/l;

    const-string v1, "flutter.baseflow.com/permissions/methods"

    invoke-direct {v0, p2, v1}, Lu1/l;-><init>(Lu1/d;Ljava/lang/String;)V

    iput-object v0, p0, Lb0/m;->d:Lu1/l;

    new-instance p2, Lb0/l;

    new-instance v0, Lb0/a;

    invoke-direct {v0}, Lb0/a;-><init>()V

    iget-object v1, p0, Lb0/m;->c:Lb0/u;

    new-instance v2, Lb0/y;

    invoke-direct {v2}, Lb0/y;-><init>()V

    invoke-direct {p2, p1, v0, v1, v2}, Lb0/l;-><init>(Landroid/content/Context;Lb0/a;Lb0/u;Lb0/y;)V

    iput-object p2, p0, Lb0/m;->h:Lb0/l;

    iget-object p1, p0, Lb0/m;->d:Lu1/l;

    invoke-virtual {p1, p2}, Lu1/l;->e(Lu1/l$c;)V

    return-void
.end method

.method private g(Landroid/app/Activity;)V
    .registers 3

    iget-object v0, p0, Lb0/m;->c:Lb0/u;

    if-eqz v0, :cond_7

    invoke-virtual {v0, p1}, Lb0/u;->i(Landroid/app/Activity;)V

    :cond_7
    return-void
.end method

.method private k()V
    .registers 3

    iget-object v0, p0, Lb0/m;->d:Lu1/l;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lu1/l;->e(Lu1/l$c;)V

    iput-object v1, p0, Lb0/m;->d:Lu1/l;

    iput-object v1, p0, Lb0/m;->h:Lb0/l;

    return-void
.end method

.method private l()V
    .registers 3

    iget-object v0, p0, Lb0/m;->c:Lb0/u;

    if-eqz v0, :cond_8

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lb0/u;->i(Landroid/app/Activity;)V

    :cond_8
    return-void
.end method


# virtual methods
.method public b(Lm1/a$b;)V
    .registers 4

    new-instance v0, Lb0/u;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lb0/u;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lb0/m;->c:Lb0/u;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object p1

    invoke-direct {p0, v0, p1}, Lb0/m;->f(Landroid/content/Context;Lu1/d;)V

    return-void
.end method

.method public d(Ln1/c;)V
    .registers 2

    invoke-virtual {p0, p1}, Lb0/m;->j(Ln1/c;)V

    return-void
.end method

.method public e(Lm1/a$b;)V
    .registers 2

    invoke-direct {p0}, Lb0/m;->k()V

    return-void
.end method

.method public h()V
    .registers 1

    invoke-virtual {p0}, Lb0/m;->i()V

    return-void
.end method

.method public i()V
    .registers 2

    invoke-direct {p0}, Lb0/m;->l()V

    invoke-direct {p0}, Lb0/m;->a()V

    const/4 v0, 0x0

    iput-object v0, p0, Lb0/m;->g:Ln1/c;

    return-void
.end method

.method public j(Ln1/c;)V
    .registers 3

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, v0}, Lb0/m;->g(Landroid/app/Activity;)V

    iput-object p1, p0, Lb0/m;->g:Ln1/c;

    invoke-direct {p0}, Lb0/m;->c()V

    return-void
.end method
