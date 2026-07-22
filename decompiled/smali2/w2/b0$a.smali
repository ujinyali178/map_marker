.class final Lw2/b0$a;
.super Lkotlin/jvm/internal/l;
.source "SourceFile"

# interfaces
.implements Lp2/p;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lw2/b0;->a(Li2/g;Li2/g;Z)Li2/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/l;",
        "Lp2/p<",
        "Li2/g;",
        "Li2/g$b;",
        "Li2/g;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:Lw2/b0$a;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/b0$a;

    invoke-direct {v0}, Lw2/b0$a;-><init>()V

    sput-object v0, Lw2/b0$a;->c:Lw2/b0$a;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/l;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final a(Li2/g;Li2/g$b;)Li2/g;
    .registers 4

    instance-of v0, p2, Lw2/a0;

    if-eqz v0, :cond_f

    check-cast p2, Lw2/a0;

    invoke-interface {p2}, Lw2/a0;->q()Lw2/a0;

    move-result-object p2

    invoke-interface {p1, p2}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    return-object p1

    :cond_f
    invoke-interface {p1, p2}, Li2/g;->f(Li2/g;)Li2/g;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    check-cast p1, Li2/g;

    check-cast p2, Li2/g$b;

    invoke-virtual {p0, p1, p2}, Lw2/b0$a;->a(Li2/g;Li2/g$b;)Li2/g;

    move-result-object p1

    return-object p1
.end method
