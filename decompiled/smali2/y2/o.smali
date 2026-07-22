.class public abstract Ly2/o;
.super Lkotlinx/coroutines/internal/o;
.source "SourceFile"

# interfaces
.implements Ly2/q;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Lkotlinx/coroutines/internal/o;",
        "Ly2/q<",
        "TE;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lkotlinx/coroutines/internal/o;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic b()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Ly2/o;->x()Lkotlinx/coroutines/internal/b0;

    move-result-object v0

    return-object v0
.end method

.method public x()Lkotlinx/coroutines/internal/b0;
    .registers 2

    sget-object v0, Ly2/b;->b:Lkotlinx/coroutines/internal/b0;

    return-object v0
.end method

.method public abstract y(Ly2/j;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ly2/j<",
            "*>;)V"
        }
    .end annotation
.end method
