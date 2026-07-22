.class public final Lw2/t1;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Lkotlinx/coroutines/internal/b0;

.field public static final b:Lkotlinx/coroutines/internal/b0;

.field private static final c:Lkotlinx/coroutines/internal/b0;

.field private static final d:Lkotlinx/coroutines/internal/b0;

.field private static final e:Lkotlinx/coroutines/internal/b0;

.field private static final f:Lw2/v0;

.field private static final g:Lw2/v0;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "COMPLETING_ALREADY"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lw2/t1;->a:Lkotlinx/coroutines/internal/b0;

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "COMPLETING_WAITING_CHILDREN"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lw2/t1;->b:Lkotlinx/coroutines/internal/b0;

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "COMPLETING_RETRY"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lw2/t1;->c:Lkotlinx/coroutines/internal/b0;

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "TOO_LATE_TO_CANCEL"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lw2/t1;->d:Lkotlinx/coroutines/internal/b0;

    new-instance v0, Lkotlinx/coroutines/internal/b0;

    const-string v1, "SEALED"

    invoke-direct {v0, v1}, Lkotlinx/coroutines/internal/b0;-><init>(Ljava/lang/String;)V

    sput-object v0, Lw2/t1;->e:Lkotlinx/coroutines/internal/b0;

    new-instance v0, Lw2/v0;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lw2/v0;-><init>(Z)V

    sput-object v0, Lw2/t1;->f:Lw2/v0;

    new-instance v0, Lw2/v0;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lw2/v0;-><init>(Z)V

    sput-object v0, Lw2/t1;->g:Lw2/v0;

    return-void
.end method

.method public static final synthetic a()Lkotlinx/coroutines/internal/b0;
    .registers 1

    sget-object v0, Lw2/t1;->a:Lkotlinx/coroutines/internal/b0;

    return-object v0
.end method

.method public static final synthetic b()Lkotlinx/coroutines/internal/b0;
    .registers 1

    sget-object v0, Lw2/t1;->c:Lkotlinx/coroutines/internal/b0;

    return-object v0
.end method

.method public static final synthetic c()Lw2/v0;
    .registers 1

    sget-object v0, Lw2/t1;->g:Lw2/v0;

    return-object v0
.end method

.method public static final synthetic d()Lw2/v0;
    .registers 1

    sget-object v0, Lw2/t1;->f:Lw2/v0;

    return-object v0
.end method

.method public static final synthetic e()Lkotlinx/coroutines/internal/b0;
    .registers 1

    sget-object v0, Lw2/t1;->e:Lkotlinx/coroutines/internal/b0;

    return-object v0
.end method

.method public static final synthetic f()Lkotlinx/coroutines/internal/b0;
    .registers 1

    sget-object v0, Lw2/t1;->d:Lkotlinx/coroutines/internal/b0;

    return-object v0
.end method

.method public static final g(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    instance-of v0, p0, Lw2/g1;

    if-eqz v0, :cond_c

    new-instance v0, Lw2/h1;

    check-cast p0, Lw2/g1;

    invoke-direct {v0, p0}, Lw2/h1;-><init>(Lw2/g1;)V

    move-object p0, v0

    :cond_c
    return-object p0
.end method

.method public static final h(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    instance-of v0, p0, Lw2/h1;

    if-eqz v0, :cond_8

    move-object v0, p0

    check-cast v0, Lw2/h1;

    goto :goto_9

    :cond_8
    const/4 v0, 0x0

    :goto_9
    if-eqz v0, :cond_11

    iget-object v0, v0, Lw2/h1;->a:Lw2/g1;

    if-nez v0, :cond_10

    goto :goto_11

    :cond_10
    move-object p0, v0

    :cond_11
    :goto_11
    return-object p0
.end method
