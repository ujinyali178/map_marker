.class Lw2/a2;
.super Lw2/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lw2/a<",
        "Lg2/q;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Li2/g;Z)V
    .registers 4

    const/4 v0, 0x1

    invoke-direct {p0, p1, v0, p2}, Lw2/a;-><init>(Li2/g;ZZ)V

    return-void
.end method


# virtual methods
.method protected V(Ljava/lang/Throwable;)Z
    .registers 3

    invoke-virtual {p0}, Lw2/a;->getContext()Li2/g;

    move-result-object v0

    invoke-static {v0, p1}, Lw2/f0;->a(Li2/g;Ljava/lang/Throwable;)V

    const/4 p1, 0x1

    return p1
.end method
