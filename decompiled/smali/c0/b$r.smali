.class Lc0/b$r;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "r"
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lc0/b$p;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    return-void
.end method


# virtual methods
.method a(Lc0/b$p;)V
    .registers 5

    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    :cond_b
    const/4 v0, 0x0

    :goto_c
    iget-object v1, p0, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_2f

    iget-object v1, p0, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lc0/b$p;

    iget-object v1, v1, Lc0/b$p;->a:Lc0/b$s;

    iget v1, v1, Lc0/b$s;->b:I

    iget-object v2, p1, Lc0/b$p;->a:Lc0/b$s;

    iget v2, v2, Lc0/b$s;->b:I

    if-le v1, v2, :cond_2c

    iget-object v1, p0, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {v1, v0, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    return-void

    :cond_2c
    add-int/lit8 v0, v0, 0x1

    goto :goto_c

    :cond_2f
    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method b(Lc0/b$r;)V
    .registers 4

    iget-object v0, p1, Lc0/b$r;->a:Ljava/util/List;

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    if-nez v0, :cond_16

    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p1, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    :cond_16
    iget-object p1, p1, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1c
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2c

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lc0/b$p;

    invoke-virtual {p0, v0}, Lc0/b$r;->a(Lc0/b$p;)V

    goto :goto_1c

    :cond_2c
    return-void
.end method

.method c()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lc0/b$p;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    return-object v0
.end method

.method d()Z
    .registers 2

    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

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

.method e(Lc0/b$u;)V
    .registers 4

    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_9
    :goto_9
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lc0/b$p;

    iget-object v1, v1, Lc0/b$p;->c:Lc0/b$u;

    if-ne v1, p1, :cond_9

    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_9

    :cond_1d
    return-void
.end method

.method f()I
    .registers 2

    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    if-eqz v0, :cond_9

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    iget-object v0, p0, Lc0/b$r;->a:Ljava/util/List;

    if-nez v0, :cond_7

    const-string v0, ""

    return-object v0

    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lc0/b$r;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_12
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lc0/b$p;

    invoke-virtual {v2}, Lc0/b$p;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_12

    :cond_2b
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
