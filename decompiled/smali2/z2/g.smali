.class final Lz2/g;
.super Lz2/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lz2/a<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final c:Lp2/p;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lp2/p<",
            "Lz2/c<",
            "-TT;>;",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lp2/p;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/p<",
            "-",
            "Lz2/c<",
            "-TT;>;-",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;+",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lz2/a;-><init>()V

    iput-object p1, p0, Lz2/g;->c:Lp2/p;

    return-void
.end method


# virtual methods
.method public b(Lz2/c;Li2/d;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lz2/c<",
            "-TT;>;",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    iget-object v0, p0, Lz2/g;->c:Lp2/p;

    invoke-interface {v0, p1, p2}, Lp2/p;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-static {}, Lj2/b;->c()Ljava/lang/Object;

    move-result-object p2

    if-ne p1, p2, :cond_d

    return-object p1

    :cond_d
    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1
.end method
