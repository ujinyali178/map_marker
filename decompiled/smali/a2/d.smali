.class public La2/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lm1/a;
.implements Ln1/a;


# instance fields
.field private c:La2/g0;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Lu1/d;Landroid/content/Context;)V
    .registers 7

    new-instance v0, La2/e$d;

    invoke-direct {v0, p1}, La2/e$d;-><init>(Lu1/d;)V

    new-instance v1, La2/g0;

    new-instance v2, La2/c;

    invoke-direct {v2}, La2/c;-><init>()V

    const/4 v3, 0x0

    invoke-direct {v1, v3, p2, v0, v2}, La2/g0;-><init>(Landroid/app/Activity;Landroid/content/Context;La2/e$d;La2/a;)V

    iput-object v1, p0, La2/d;->c:La2/g0;

    invoke-static {p1, v1}, La2/t;->p(Lu1/d;La2/e$b;)V

    return-void
.end method

.method private c(Lu1/d;)V
    .registers 3

    const/4 v0, 0x0

    invoke-static {p1, v0}, La2/t;->p(Lu1/d;La2/e$b;)V

    iput-object v0, p0, La2/d;->c:La2/g0;

    return-void
.end method


# virtual methods
.method public b(Lm1/a$b;)V
    .registers 3

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object v0

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object p1

    invoke-direct {p0, v0, p1}, La2/d;->a(Lu1/d;Landroid/content/Context;)V

    return-void
.end method

.method public d(Ln1/c;)V
    .registers 2

    invoke-virtual {p0, p1}, La2/d;->j(Ln1/c;)V

    return-void
.end method

.method public e(Lm1/a$b;)V
    .registers 2

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object p1

    invoke-direct {p0, p1}, La2/d;->c(Lu1/d;)V

    return-void
.end method

.method public h()V
    .registers 3

    iget-object v0, p0, La2/d;->c:La2/g0;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La2/g0;->I(Landroid/app/Activity;)V

    return-void
.end method

.method public i()V
    .registers 3

    iget-object v0, p0, La2/d;->c:La2/g0;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La2/g0;->I(Landroid/app/Activity;)V

    iget-object v0, p0, La2/d;->c:La2/g0;

    invoke-virtual {v0}, La2/g0;->H()V

    return-void
.end method

.method public j(Ln1/c;)V
    .registers 5

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "PROXY_PACKAGE"

    const-string v2, "io.flutter.plugins.inapppurchase"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v0, p0, La2/d;->c:La2/g0;

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object p1

    invoke-virtual {v0, p1}, La2/g0;->I(Landroid/app/Activity;)V

    return-void
.end method
