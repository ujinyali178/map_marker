.class public final Lw2/x0$b;
.super Lkotlinx/coroutines/internal/g0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw2/x0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlinx/coroutines/internal/g0<",
        "Lw2/x0$a;",
        ">;"
    }
.end annotation


# instance fields
.field public b:J


# direct methods
.method public constructor <init>(J)V
    .registers 3

    invoke-direct {p0}, Lkotlinx/coroutines/internal/g0;-><init>()V

    iput-wide p1, p0, Lw2/x0$b;->b:J

    return-void
.end method
