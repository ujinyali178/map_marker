.class public abstract Lw2/c0;
.super Li2/a;
.source "SourceFile"

# interfaces
.implements Li2/e;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lw2/c0$a;
    }
.end annotation


# static fields
.field public static final d:Lw2/c0$a;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lw2/c0$a;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lw2/c0$a;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Lw2/c0;->d:Lw2/c0$a;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    sget-object v0, Li2/e;->a:Li2/e$b;

    invoke-direct {p0, v0}, Li2/a;-><init>(Li2/g$c;)V

    return-void
.end method


# virtual methods
.method public a(Li2/g$c;)Li2/g$b;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E::",
            "Li2/g$b;",
            ">(",
            "Li2/g$c<",
            "TE;>;)TE;"
        }
    .end annotation

    invoke-static {p0, p1}, Li2/e$a;->a(Li2/e;Li2/g$c;)Li2/g$b;

    move-result-object p1

    return-object p1
.end method

.method public final c(Li2/d;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/d<",
            "*>;)V"
        }
    .end annotation

    check-cast p1, Lkotlinx/coroutines/internal/f;

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/f;->q()V

    return-void
.end method

.method public abstract g(Li2/g;Ljava/lang/Runnable;)V
.end method

.method public final i(Li2/d;)Li2/d;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Li2/d<",
            "-TT;>;)",
            "Li2/d<",
            "TT;>;"
        }
    .end annotation

    new-instance v0, Lkotlinx/coroutines/internal/f;

    invoke-direct {v0, p0, p1}, Lkotlinx/coroutines/internal/f;-><init>(Lw2/c0;Li2/d;)V

    return-object v0
.end method

.method public k(Li2/g$c;)Li2/g;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Li2/g$c<",
            "*>;)",
            "Li2/g;"
        }
    .end annotation

    invoke-static {p0, p1}, Li2/e$a;->b(Li2/e;Li2/g$c;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public m(Li2/g;)Z
    .registers 2

    const/4 p1, 0x1

    return p1
.end method

.method public n(I)Lw2/c0;
    .registers 3

    invoke-static {p1}, Lkotlinx/coroutines/internal/l;->a(I)V

    new-instance v0, Lkotlinx/coroutines/internal/k;

    invoke-direct {v0, p0, p1}, Lkotlinx/coroutines/internal/k;-><init>(Lw2/c0;I)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lw2/k0;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-static {p0}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
