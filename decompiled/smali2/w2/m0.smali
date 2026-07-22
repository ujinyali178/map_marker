.class public final Lw2/m0;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Z

.field private static final b:Lw2/n0;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const-string v0, "kotlinx.coroutines.main.delay"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lkotlinx/coroutines/internal/c0;->e(Ljava/lang/String;Z)Z

    move-result v0

    sput-boolean v0, Lw2/m0;->a:Z

    invoke-static {}, Lw2/m0;->b()Lw2/n0;

    move-result-object v0

    sput-object v0, Lw2/m0;->b:Lw2/n0;

    return-void
.end method

.method public static final a()Lw2/n0;
    .registers 1

    sget-object v0, Lw2/m0;->b:Lw2/n0;

    return-object v0
.end method

.method private static final b()Lw2/n0;
    .registers 2

    sget-boolean v0, Lw2/m0;->a:Z

    if-nez v0, :cond_7

    sget-object v0, Lw2/l0;->k:Lw2/l0;

    return-object v0

    :cond_7
    invoke-static {}, Lw2/t0;->c()Lw2/v1;

    move-result-object v0

    invoke-static {v0}, Lkotlinx/coroutines/internal/t;->c(Lw2/v1;)Z

    move-result v1

    if-nez v1, :cond_19

    instance-of v1, v0, Lw2/n0;

    if-nez v1, :cond_16

    goto :goto_19

    :cond_16
    check-cast v0, Lw2/n0;

    goto :goto_1b

    :cond_19
    :goto_19
    sget-object v0, Lw2/l0;->k:Lw2/l0;

    :goto_1b
    return-object v0
.end method
