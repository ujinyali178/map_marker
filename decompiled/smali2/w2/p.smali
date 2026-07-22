.class public final Lw2/p;
.super Lw2/n1;
.source "SourceFile"


# instance fields
.field public final h:Lw2/l;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lw2/l<",
            "*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lw2/l;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lw2/l<",
            "*>;)V"
        }
    .end annotation

    invoke-direct {p0}, Lw2/n1;-><init>()V

    iput-object p1, p0, Lw2/p;->h:Lw2/l;

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lw2/p;->x(Ljava/lang/Throwable;)V

    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1
.end method

.method public x(Ljava/lang/Throwable;)V
    .registers 3

    iget-object p1, p0, Lw2/p;->h:Lw2/l;

    invoke-virtual {p0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    invoke-virtual {p1, v0}, Lw2/l;->u(Lw2/l1;)Ljava/lang/Throwable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lw2/l;->E(Ljava/lang/Throwable;)V

    return-void
.end method
