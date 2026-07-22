.class Landroidx/fragment/app/FragmentManager$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Landroidx/fragment/app/b0;

.field final synthetic f:Landroidx/lifecycle/e;

.field final synthetic g:Landroidx/fragment/app/w;


# virtual methods
.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 5

    sget-object p1, Landroidx/lifecycle/e$a;->ON_START:Landroidx/lifecycle/e$a;

    if-ne p2, p1, :cond_22

    iget-object p1, p0, Landroidx/fragment/app/FragmentManager$6;->g:Landroidx/fragment/app/w;

    invoke-static {p1}, Landroidx/fragment/app/w;->f(Landroidx/fragment/app/w;)Ljava/util/Map;

    move-result-object p1

    iget-object v0, p0, Landroidx/fragment/app/FragmentManager$6;->c:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/os/Bundle;

    if-eqz p1, :cond_22

    iget-object v0, p0, Landroidx/fragment/app/FragmentManager$6;->d:Landroidx/fragment/app/b0;

    iget-object v1, p0, Landroidx/fragment/app/FragmentManager$6;->c:Ljava/lang/String;

    invoke-interface {v0, v1, p1}, Landroidx/fragment/app/b0;->a(Ljava/lang/String;Landroid/os/Bundle;)V

    iget-object p1, p0, Landroidx/fragment/app/FragmentManager$6;->g:Landroidx/fragment/app/w;

    iget-object v0, p0, Landroidx/fragment/app/FragmentManager$6;->c:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroidx/fragment/app/w;->u(Ljava/lang/String;)V

    :cond_22
    sget-object p1, Landroidx/lifecycle/e$a;->ON_DESTROY:Landroidx/lifecycle/e$a;

    if-ne p2, p1, :cond_36

    iget-object p1, p0, Landroidx/fragment/app/FragmentManager$6;->f:Landroidx/lifecycle/e;

    invoke-virtual {p1, p0}, Landroidx/lifecycle/e;->c(Landroidx/lifecycle/h;)V

    iget-object p1, p0, Landroidx/fragment/app/FragmentManager$6;->g:Landroidx/fragment/app/w;

    invoke-static {p1}, Landroidx/fragment/app/w;->g(Landroidx/fragment/app/w;)Ljava/util/Map;

    move-result-object p1

    iget-object p2, p0, Landroidx/fragment/app/FragmentManager$6;->c:Ljava/lang/String;

    invoke-interface {p1, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_36
    return-void
.end method
