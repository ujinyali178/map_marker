.class final synthetic La3/d$a;
.super Lkotlin/jvm/internal/j;
.source "SourceFile"

# interfaces
.implements Lp2/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La3/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1000
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/j;",
        "Lp2/q<",
        "Lz2/c<",
        "-",
        "Ljava/lang/Object;",
        ">;",
        "Ljava/lang/Object;",
        "Li2/d<",
        "-",
        "Lg2/q;",
        ">;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:La3/d$a;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, La3/d$a;

    invoke-direct {v0}, La3/d$a;-><init>()V

    sput-object v0, La3/d$a;->c:La3/d$a;

    return-void
.end method

.method constructor <init>()V
    .registers 7

    const-class v2, Lz2/c;

    const/4 v1, 0x3

    const-string v3, "emit"

    const-string v4, "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"

    const/4 v5, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lkotlin/jvm/internal/j;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V

    return-void
.end method


# virtual methods
.method public final b(Lz2/c;Ljava/lang/Object;Li2/d;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lz2/c<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Object;",
            "Li2/d<",
            "-",
            "Lg2/q;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-interface {p1, p2, p3}, Lz2/c;->emit(Ljava/lang/Object;Li2/d;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic c(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4

    check-cast p1, Lz2/c;

    check-cast p3, Li2/d;

    invoke-virtual {p0, p1, p2, p3}, La3/d$a;->b(Lz2/c;Ljava/lang/Object;Li2/d;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
