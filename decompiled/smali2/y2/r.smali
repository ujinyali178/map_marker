.class public Ly2/r;
.super Ly2/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ly2/a<",
        "TE;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lp2/l;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lp2/l<",
            "-TE;",
            "Lg2/q;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Ly2/a;-><init>(Lp2/l;)V

    return-void
.end method


# virtual methods
.method protected final r()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method protected final s()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method
