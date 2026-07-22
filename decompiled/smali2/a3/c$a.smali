.class final La3/c$a;
.super Lkotlin/jvm/internal/l;
.source "SourceFile"

# interfaces
.implements Lp2/p;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La3/c;-><init>(Lz2/c;Li2/g;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/l;",
        "Lp2/p<",
        "Ljava/lang/Integer;",
        "Li2/g$b;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:La3/c$a;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, La3/c$a;

    invoke-direct {v0}, La3/c$a;-><init>()V

    sput-object v0, La3/c$a;->c:La3/c$a;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/l;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final a(ILi2/g$b;)Ljava/lang/Integer;
    .registers 3

    add-int/lit8 p1, p1, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    check-cast p2, Li2/g$b;

    invoke-virtual {p0, p1, p2}, La3/c$a;->a(ILi2/g$b;)Ljava/lang/Integer;

    move-result-object p1

    return-object p1
.end method
