.class public final Ly2/i;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ly2/i$c;,
        Ly2/i$a;,
        Ly2/i$b;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field public static final a:Ly2/i$b;

.field private static final b:Ly2/i$c;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Ly2/i$b;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ly2/i$b;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Ly2/i;->a:Ly2/i$b;

    new-instance v0, Ly2/i$c;

    invoke-direct {v0}, Ly2/i$c;-><init>()V

    sput-object v0, Ly2/i;->b:Ly2/i$c;

    return-void
.end method

.method public static final synthetic a()Ly2/i$c;
    .registers 1

    sget-object v0, Ly2/i;->b:Ly2/i$c;

    return-object v0
.end method

.method public static b(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    return-object p0
.end method
