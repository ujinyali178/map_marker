.class public final Lw2/d2;
.super Lw2/c0;
.source "SourceFile"


# static fields
.field public static final f:Lw2/d2;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/d2;

    invoke-direct {v0}, Lw2/d2;-><init>()V

    sput-object v0, Lw2/d2;->f:Lw2/d2;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lw2/c0;-><init>()V

    return-void
.end method


# virtual methods
.method public g(Li2/g;Ljava/lang/Runnable;)V
    .registers 3

    sget-object p2, Lw2/g2;->f:Lw2/g2$a;

    invoke-interface {p1, p2}, Li2/g;->a(Li2/g$c;)Li2/g$b;

    move-result-object p1

    check-cast p1, Lw2/g2;

    if-eqz p1, :cond_e

    const/4 p2, 0x1

    iput-boolean p2, p1, Lw2/g2;->d:Z

    return-void

    :cond_e
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string p2, "Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls."

    invoke-direct {p1, p2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public m(Li2/g;)Z
    .registers 2

    const/4 p1, 0x0

    return p1
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    const-string v0, "Dispatchers.Unconfined"

    return-object v0
.end method
