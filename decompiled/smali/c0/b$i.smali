.class Lc0/b$i;
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
    name = "i"
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lc0/b$a;)V
    .registers 2

    invoke-direct {p0}, Lc0/b$i;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lc0/b$q;Lc0/g$l0;)Z
    .registers 4

    instance-of p1, p2, Lc0/g$j0;

    const/4 v0, 0x1

    if-eqz p1, :cond_13

    check-cast p2, Lc0/g$j0;

    invoke-interface {p2}, Lc0/g$j0;->a()Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p1

    if-nez p1, :cond_12

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :cond_13
    :goto_13
    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    const-string v0, "empty"

    return-object v0
.end method
