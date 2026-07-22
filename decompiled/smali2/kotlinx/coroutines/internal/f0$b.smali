.class final Lkotlinx/coroutines/internal/f0$b;
.super Lkotlin/jvm/internal/l;
.source "SourceFile"

# interfaces
.implements Lp2/p;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lkotlinx/coroutines/internal/f0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/l;",
        "Lp2/p<",
        "Lw2/b2<",
        "*>;",
        "Li2/g$b;",
        "Lw2/b2<",
        "*>;>;"
    }
.end annotation


# static fields
.field public static final c:Lkotlinx/coroutines/internal/f0$b;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lkotlinx/coroutines/internal/f0$b;

    invoke-direct {v0}, Lkotlinx/coroutines/internal/f0$b;-><init>()V

    sput-object v0, Lkotlinx/coroutines/internal/f0$b;->c:Lkotlinx/coroutines/internal/f0$b;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/l;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final a(Lw2/b2;Li2/g$b;)Lw2/b2;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lw2/b2<",
            "*>;",
            "Li2/g$b;",
            ")",
            "Lw2/b2<",
            "*>;"
        }
    .end annotation

    if-eqz p1, :cond_3

    return-object p1

    :cond_3
    instance-of p1, p2, Lw2/b2;

    if-eqz p1, :cond_a

    check-cast p2, Lw2/b2;

    goto :goto_b

    :cond_a
    const/4 p2, 0x0

    :goto_b
    return-object p2
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    check-cast p1, Lw2/b2;

    check-cast p2, Li2/g$b;

    invoke-virtual {p0, p1, p2}, Lkotlinx/coroutines/internal/f0$b;->a(Lw2/b2;Li2/g$b;)Lw2/b2;

    move-result-object p1

    return-object p1
.end method
