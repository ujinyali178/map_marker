.class public final La3/d;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Lp2/q;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lp2/q<",
            "Lz2/c<",
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
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    sget-object v0, La3/d$a;->c:La3/d$a;

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->a(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lp2/q;

    sput-object v0, La3/d;->a:Lp2/q;

    return-void
.end method

.method public static final synthetic a()Lp2/q;
    .registers 1

    sget-object v0, La3/d;->a:Lp2/q;

    return-object v0
.end method
