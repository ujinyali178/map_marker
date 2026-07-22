.class final Lw2/k1;
.super Lw2/r1;
.source "SourceFile"


# instance fields
.field private final h:Lp2/l;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lp2/l<",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lp2/l;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lw2/r1;-><init>()V

    iput-object p1, p0, Lw2/k1;->h:Lp2/l;

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lw2/k1;->x(Ljava/lang/Throwable;)V

    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1
.end method

.method public x(Ljava/lang/Throwable;)V
    .registers 3

    iget-object v0, p0, Lw2/k1;->h:Lp2/l;

    invoke-interface {v0, p1}, Lp2/l;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
