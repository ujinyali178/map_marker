.class public Landroidx/fragment/app/m;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Landroidx/fragment/app/o;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/fragment/app/o<",
            "*>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroidx/fragment/app/o;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/o<",
            "*>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    return-void
.end method

.method public static b(Landroidx/fragment/app/o;)Landroidx/fragment/app/m;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/o<",
            "*>;)",
            "Landroidx/fragment/app/m;"
        }
    .end annotation

    new-instance v0, Landroidx/fragment/app/m;

    const-string v1, "callbacks == null"

    invoke-static {p0, v1}, Landroidx/core/util/d;->f(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroidx/fragment/app/o;

    invoke-direct {v0, p0}, Landroidx/fragment/app/m;-><init>(Landroidx/fragment/app/o;)V

    return-object v0
.end method


# virtual methods
.method public a(Landroidx/fragment/app/Fragment;)V
    .registers 4

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v1, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v1, v0, v0, p1}, Landroidx/fragment/app/w;->n(Landroidx/fragment/app/o;Landroidx/fragment/app/k;Landroidx/fragment/app/Fragment;)V

    return-void
.end method

.method public c()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->z()V

    return-void
.end method

.method public d(Landroid/view/MenuItem;)Z
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0, p1}, Landroidx/fragment/app/w;->C(Landroid/view/MenuItem;)Z

    move-result p1

    return p1
.end method

.method public e()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->D()V

    return-void
.end method

.method public f()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->F()V

    return-void
.end method

.method public g()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->O()V

    return-void
.end method

.method public h()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->S()V

    return-void
.end method

.method public i()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->T()V

    return-void
.end method

.method public j()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->V()V

    return-void
.end method

.method public k()Z
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroidx/fragment/app/w;->c0(Z)Z

    move-result v0

    return v0
.end method

.method public l()Landroidx/fragment/app/w;
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    return-object v0
.end method

.method public m()V
    .registers 2

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->Z0()V

    return-void
.end method

.method public n(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 6

    iget-object v0, p0, Landroidx/fragment/app/m;->a:Landroidx/fragment/app/o;

    iget-object v0, v0, Landroidx/fragment/app/o;->h:Landroidx/fragment/app/w;

    invoke-virtual {v0}, Landroidx/fragment/app/w;->w0()Landroid/view/LayoutInflater$Factory2;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3, p4}, Landroid/view/LayoutInflater$Factory2;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method
