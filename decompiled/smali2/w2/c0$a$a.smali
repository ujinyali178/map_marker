.class final Lw2/c0$a$a;
.super Lkotlin/jvm/internal/l;
.source "SourceFile"

# interfaces
.implements Lp2/l;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lw2/c0$a;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/l;",
        "Lp2/l<",
        "Li2/g$b;",
        "Lw2/c0;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:Lw2/c0$a$a;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/c0$a$a;

    invoke-direct {v0}, Lw2/c0$a$a;-><init>()V

    sput-object v0, Lw2/c0$a$a;->c:Lw2/c0$a$a;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/l;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final a(Li2/g$b;)Lw2/c0;
    .registers 3

    instance-of v0, p1, Lw2/c0;

    if-eqz v0, :cond_7

    check-cast p1, Lw2/c0;

    goto :goto_8

    :cond_7
    const/4 p1, 0x0

    :goto_8
    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    check-cast p1, Li2/g$b;

    invoke-virtual {p0, p1}, Lw2/c0$a$a;->a(Li2/g$b;)Lw2/c0;

    move-result-object p1

    return-object p1
.end method
