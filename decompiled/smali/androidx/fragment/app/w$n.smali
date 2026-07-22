.class Landroidx/fragment/app/w$n;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/fragment/app/w$m;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/w;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "n"
.end annotation


# instance fields
.field final a:Ljava/lang/String;

.field final b:I

.field final c:I

.field final synthetic d:Landroidx/fragment/app/w;


# direct methods
.method constructor <init>(Landroidx/fragment/app/w;Ljava/lang/String;II)V
    .registers 5

    iput-object p1, p0, Landroidx/fragment/app/w$n;->d:Landroidx/fragment/app/w;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Landroidx/fragment/app/w$n;->a:Ljava/lang/String;

    iput p3, p0, Landroidx/fragment/app/w$n;->b:I

    iput p4, p0, Landroidx/fragment/app/w$n;->c:I

    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroidx/fragment/app/a;",
            ">;",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    iget-object v0, p0, Landroidx/fragment/app/w$n;->d:Landroidx/fragment/app/w;

    iget-object v0, v0, Landroidx/fragment/app/w;->y:Landroidx/fragment/app/Fragment;

    if-eqz v0, :cond_1a

    iget v1, p0, Landroidx/fragment/app/w$n;->b:I

    if-gez v1, :cond_1a

    iget-object v1, p0, Landroidx/fragment/app/w$n;->a:Ljava/lang/String;

    if-nez v1, :cond_1a

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getChildFragmentManager()Landroidx/fragment/app/w;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/w;->d1()Z

    move-result v0

    if-eqz v0, :cond_1a

    const/4 p1, 0x0

    return p1

    :cond_1a
    iget-object v0, p0, Landroidx/fragment/app/w$n;->d:Landroidx/fragment/app/w;

    iget-object v3, p0, Landroidx/fragment/app/w$n;->a:Ljava/lang/String;

    iget v4, p0, Landroidx/fragment/app/w$n;->b:I

    iget v5, p0, Landroidx/fragment/app/w$n;->c:I

    move-object v1, p1

    move-object v2, p2

    invoke-virtual/range {v0 .. v5}, Landroidx/fragment/app/w;->g1(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;II)Z

    move-result p1

    return p1
.end method
