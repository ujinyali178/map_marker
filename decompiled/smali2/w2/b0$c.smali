.class final Lw2/b0$c;
.super Lkotlin/jvm/internal/l;
.source "SourceFile"

# interfaces
.implements Lp2/p;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lw2/b0;->c(Li2/g;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/l;",
        "Lp2/p<",
        "Ljava/lang/Boolean;",
        "Li2/g$b;",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:Lw2/b0$c;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/b0$c;

    invoke-direct {v0}, Lw2/b0$c;-><init>()V

    sput-object v0, Lw2/b0$c;->c:Lw2/b0$c;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/l;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final a(ZLi2/g$b;)Ljava/lang/Boolean;
    .registers 3

    if-nez p1, :cond_9

    instance-of p1, p2, Lw2/a0;

    if-eqz p1, :cond_7

    goto :goto_9

    :cond_7
    const/4 p1, 0x0

    goto :goto_a

    :cond_9
    :goto_9
    const/4 p1, 0x1

    :goto_a
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    check-cast p2, Li2/g$b;

    invoke-virtual {p0, p1, p2}, Lw2/b0$c;->a(ZLi2/g$b;)Ljava/lang/Boolean;

    move-result-object p1

    return-object p1
.end method
