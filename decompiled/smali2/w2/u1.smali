.class final Lw2/u1;
.super Lw2/a2;
.source "SourceFile"


# instance fields
.field private final f:Li2/d;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Li2/d<",
            "Lg2/q;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Li2/g;Lp2/p;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g;",
            "Lp2/p<",
            "-",
            "Lw2/g0;",
            "-",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;+",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lw2/a2;-><init>(Li2/g;Z)V

    invoke-static {p2, p0, p0}, Lj2/b;->a(Lp2/p;Ljava/lang/Object;Li2/d;)Li2/d;

    move-result-object p1

    iput-object p1, p0, Lw2/u1;->f:Li2/d;

    return-void
.end method


# virtual methods
.method protected j0()V
    .registers 2

    iget-object v0, p0, Lw2/u1;->f:Li2/d;

    invoke-static {v0, p0}, Lb3/a;->b(Li2/d;Li2/d;)V

    return-void
.end method
