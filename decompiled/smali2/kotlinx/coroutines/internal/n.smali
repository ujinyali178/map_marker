.class public final Lkotlinx/coroutines/internal/n;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/Object;

.field private static final b:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "CONDITION_FALSE"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkotlinx/coroutines/internal/n;->a:Ljava/lang/Object;

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "LIST_EMPTY"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkotlinx/coroutines/internal/n;->b:Ljava/lang/Object;

    return-void
.end method

.method public static final a()Ljava/lang/Object;
    .registers 1

    sget-object v0, Lkotlinx/coroutines/internal/n;->a:Ljava/lang/Object;

    return-object v0
.end method

.method public static final b(Ljava/lang/Object;)Lkotlinx/coroutines/internal/o;
    .registers 2

    instance-of v0, p0, Lkotlinx/coroutines/internal/x;

    if-eqz v0, :cond_8

    move-object v0, p0

    check-cast v0, Lkotlinx/coroutines/internal/x;

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    if-eqz v0, :cond_f

    iget-object v0, v0, Lkotlinx/coroutines/internal/x;->a:Lkotlinx/coroutines/internal/o;

    if-nez v0, :cond_12

    :cond_f
    move-object v0, p0

    check-cast v0, Lkotlinx/coroutines/internal/o;

    :cond_12
    return-object v0
.end method
