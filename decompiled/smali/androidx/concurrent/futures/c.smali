.class public final Landroidx/concurrent/futures/c;
.super Landroidx/concurrent/futures/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Landroidx/concurrent/futures/a<",
        "TV;>;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroidx/concurrent/futures/a;-><init>()V

    return-void
.end method

.method public static q()Landroidx/concurrent/futures/c;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<V:",
            "Ljava/lang/Object;",
            ">()",
            "Landroidx/concurrent/futures/c<",
            "TV;>;"
        }
    .end annotation

    new-instance v0, Landroidx/concurrent/futures/c;

    invoke-direct {v0}, Landroidx/concurrent/futures/c;-><init>()V

    return-object v0
.end method


# virtual methods
.method public o(Ljava/lang/Object;)Z
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;)Z"
        }
    .end annotation

    invoke-super {p0, p1}, Landroidx/concurrent/futures/a;->o(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method
