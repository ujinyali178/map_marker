.class public final Lw2/r;
.super Lw2/n1;
.source "SourceFile"

# interfaces
.implements Lw2/q;


# instance fields
.field public final h:Lw2/s;


# direct methods
.method public constructor <init>(Lw2/s;)V
    .registers 2

    invoke-direct {p0}, Lw2/n1;-><init>()V

    iput-object p1, p0, Lw2/r;->h:Lw2/s;

    return-void
.end method


# virtual methods
.method public d(Ljava/lang/Throwable;)Z
    .registers 3

    invoke-virtual {p0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    invoke-virtual {v0, p1}, Lw2/s1;->I(Ljava/lang/Throwable;)Z

    move-result p1

    return p1
.end method

.method public getParent()Lw2/l1;
    .registers 2

    invoke-virtual {p0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lw2/r;->x(Ljava/lang/Throwable;)V

    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1
.end method

.method public x(Ljava/lang/Throwable;)V
    .registers 3

    iget-object p1, p0, Lw2/r;->h:Lw2/s;

    invoke-virtual {p0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    invoke-interface {p1, v0}, Lw2/s;->v(Lw2/z1;)V

    return-void
.end method
