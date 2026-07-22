.class final Lw2/f2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Li2/g$b;
.implements Li2/g$c;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Li2/g$b;",
        "Li2/g$c<",
        "Lw2/f2;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:Lw2/f2;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/f2;

    invoke-direct {v0}, Lw2/f2;-><init>()V

    sput-object v0, Lw2/f2;->c:Lw2/f2;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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

    invoke-static {p0, p1}, Li2/g$b$a;->b(Li2/g$b;Li2/g$c;)Li2/g$b;

    move-result-object p1

    return-object p1
.end method

.method public f(Li2/g;)Li2/g;
    .registers 2

    invoke-static {p0, p1}, Li2/g$b$a;->d(Li2/g$b;Li2/g;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public getKey()Li2/g$c;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Li2/g$c<",
            "*>;"
        }
    .end annotation

    return-object p0
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

    invoke-static {p0, p1}, Li2/g$b$a;->c(Li2/g$b;Li2/g$c;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public x(Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(TR;",
            "Lp2/p<",
            "-TR;-",
            "Li2/g$b;",
            "+TR;>;)TR;"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Li2/g$b$a;->a(Li2/g$b;Ljava/lang/Object;Lp2/p;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
