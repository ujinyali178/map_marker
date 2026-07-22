.class Lc0/b$s;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "s"
.end annotation


# instance fields
.field a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lc0/b$t;",
            ">;"
        }
    .end annotation
.end field

.field b:I


# direct methods
.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    const/4 v0, 0x0

    iput v0, p0, Lc0/b$s;->b:I

    return-void
.end method

.method synthetic constructor <init>(Lc0/b$a;)V
    .registers 2

    invoke-direct {p0}, Lc0/b$s;-><init>()V

    return-void
.end method


# virtual methods
.method a(Lc0/b$t;)V
    .registers 3

    iget-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    :cond_b
    iget-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method b()V
    .registers 2

    iget v0, p0, Lc0/b$s;->b:I

    add-int/lit16 v0, v0, 0x3e8

    iput v0, p0, Lc0/b$s;->b:I

    return-void
.end method

.method c()V
    .registers 2

    iget v0, p0, Lc0/b$s;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lc0/b$s;->b:I

    return-void
.end method

.method d()V
    .registers 3

    iget v0, p0, Lc0/b$s;->b:I

    const v1, 0xf4240

    add-int/2addr v0, v1

    iput v0, p0, Lc0/b$s;->b:I

    return-void
.end method

.method e(I)Lc0/b$t;
    .registers 3

    iget-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lc0/b$t;

    return-object p1
.end method

.method f()Z
    .registers 2

    iget-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    if-eqz v0, :cond_d

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_b

    goto :goto_d

    :cond_b
    const/4 v0, 0x0

    goto :goto_e

    :cond_d
    :goto_d
    const/4 v0, 0x1

    :goto_e
    return v0
.end method

.method g()I
    .registers 2

    iget-object v0, p0, Lc0/b$s;->a:Ljava/util/List;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_a
    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lc0/b$s;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_20

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lc0/b$t;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const/16 v2, 0x20

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_b

    :cond_20
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget v1, p0, Lc0/b$s;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
