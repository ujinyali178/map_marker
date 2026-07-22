.class public final Lw2/c1$a;
.super Li2/b;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw2/c1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Li2/b<",
        "Lw2/c0;",
        "Lw2/c1;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 3

    sget-object v0, Lw2/c0;->d:Lw2/c0$a;

    sget-object v1, Lw2/c1$a$a;->c:Lw2/c1$a$a;

    invoke-direct {p0, v0, v1}, Li2/b;-><init>(Li2/g$c;Lp2/l;)V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/g;)V
    .registers 2

    invoke-direct {p0}, Lw2/c1$a;-><init>()V

    return-void
.end method
