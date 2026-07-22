.class public final Lc1/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lm1/a;
.implements Ln1/a;


# instance fields
.field private final c:Lc1/b;

.field private final d:Lc1/c;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lc1/b;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1}, Lc1/b;-><init>(Landroid/app/Activity;Landroid/content/Context;)V

    iput-object v0, p0, Lc1/a;->c:Lc1/b;

    new-instance v1, Lc1/c;

    invoke-direct {v1, v0}, Lc1/c;-><init>(Lc1/b;)V

    iput-object v1, p0, Lc1/a;->d:Lc1/c;

    return-void
.end method


# virtual methods
.method public b(Lm1/a$b;)V
    .registers 4

    iget-object v0, p0, Lc1/a;->c:Lc1/b;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lc1/b;->g(Landroid/content/Context;)V

    iget-object v0, p0, Lc1/a;->c:Lc1/b;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lc1/b;->f(Landroid/app/Activity;)V

    iget-object v0, p0, Lc1/a;->d:Lc1/c;

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object p1

    invoke-virtual {v0, p1}, Lc1/c;->f(Lu1/d;)V

    return-void
.end method

.method public d(Ln1/c;)V
    .registers 2

    invoke-virtual {p0, p1}, Lc1/a;->j(Ln1/c;)V

    return-void
.end method

.method public e(Lm1/a$b;)V
    .registers 3

    iget-object p1, p0, Lc1/a;->c:Lc1/b;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lc1/b;->g(Landroid/content/Context;)V

    iget-object p1, p0, Lc1/a;->c:Lc1/b;

    invoke-virtual {p1, v0}, Lc1/b;->f(Landroid/app/Activity;)V

    iget-object p1, p0, Lc1/a;->d:Lc1/c;

    invoke-virtual {p1}, Lc1/c;->g()V

    return-void
.end method

.method public h()V
    .registers 1

    invoke-virtual {p0}, Lc1/a;->i()V

    return-void
.end method

.method public i()V
    .registers 3

    iget-object v0, p0, Lc1/a;->c:Lc1/b;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lc1/b;->f(Landroid/app/Activity;)V

    return-void
.end method

.method public j(Ln1/c;)V
    .registers 3

    iget-object v0, p0, Lc1/a;->c:Lc1/b;

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object p1

    invoke-virtual {v0, p1}, Lc1/b;->f(Landroid/app/Activity;)V

    return-void
.end method
