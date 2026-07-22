.class Lc0/b$n;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lc0/b$g;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "n"
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lc0/b$a;)V
    .registers 2

    invoke-direct {p0}, Lc0/b$n;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lc0/b$q;Lc0/g$l0;)Z
    .registers 3

    iget-object p1, p2, Lc0/g$n0;->b:Lc0/g$j0;

    if-nez p1, :cond_6

    const/4 p1, 0x1

    goto :goto_7

    :cond_6
    const/4 p1, 0x0

    :goto_7
    return p1
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    const-string v0, "root"

    return-object v0
.end method
