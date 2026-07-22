.class public final Lw2/t0;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:Lw2/t0;

.field private static final b:Lw2/c0;

.field private static final c:Lw2/c0;

.field private static final d:Lw2/c0;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/t0;

    invoke-direct {v0}, Lw2/t0;-><init>()V

    sput-object v0, Lw2/t0;->a:Lw2/t0;

    sget-object v0, Lkotlinx/coroutines/scheduling/c;->l:Lkotlinx/coroutines/scheduling/c;

    sput-object v0, Lw2/t0;->b:Lw2/c0;

    sget-object v0, Lw2/d2;->f:Lw2/d2;

    sput-object v0, Lw2/t0;->c:Lw2/c0;

    sget-object v0, Lkotlinx/coroutines/scheduling/b;->g:Lkotlinx/coroutines/scheduling/b;

    sput-object v0, Lw2/t0;->d:Lw2/c0;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final a()Lw2/c0;
    .registers 1

    sget-object v0, Lw2/t0;->b:Lw2/c0;

    return-object v0
.end method

.method public static final b()Lw2/c0;
    .registers 1

    sget-object v0, Lw2/t0;->d:Lw2/c0;

    return-object v0
.end method

.method public static final c()Lw2/v1;
    .registers 1

    sget-object v0, Lkotlinx/coroutines/internal/s;->c:Lw2/v1;

    return-object v0
.end method
