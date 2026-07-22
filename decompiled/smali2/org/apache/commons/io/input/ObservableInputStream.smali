.class public Lorg/apache/commons/io/input/ObservableInputStream;
.super Lorg/apache/commons/io/input/ProxyInputStream;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/apache/commons/io/input/ObservableInputStream$Observer;
    }
.end annotation


# instance fields
.field private final observers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/apache/commons/io/input/ObservableInputStream$Observer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .registers 2

    invoke-direct {p0, p1}, Lorg/apache/commons/io/input/ProxyInputStream;-><init>(Ljava/io/InputStream;)V

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lorg/apache/commons/io/input/ObservableInputStream;->observers:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public add(Lorg/apache/commons/io/input/ObservableInputStream$Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/apache/commons/io/input/ObservableInputStream;->observers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public close()V
    .registers 2

    :try_start_0
    invoke-super {p0}, Lorg/apache/commons/io/input/ProxyInputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_3} :catch_5

    const/4 v0, 0x0

    goto :goto_6

    :catch_5
    move-exception v0

    :goto_6
    if-nez v0, :cond_c

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteClosed()V

    goto :goto_f

    :cond_c
    invoke-virtual {p0, v0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteError(Ljava/io/IOException;)V

    :goto_f
    return-void
.end method

.method public consume()V
    .registers 4

    const/16 v0, 0x2000

    new-array v0, v0, [B

    :cond_4
    invoke-virtual {p0, v0}, Lorg/apache/commons/io/input/ObservableInputStream;->read([B)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_4

    return-void
.end method

.method protected getObservers()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lorg/apache/commons/io/input/ObservableInputStream$Observer;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/apache/commons/io/input/ObservableInputStream;->observers:Ljava/util/List;

    return-object v0
.end method

.method protected noteClosed()V
    .registers 3

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->getObservers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/input/ObservableInputStream$Observer;

    invoke-virtual {v1}, Lorg/apache/commons/io/input/ObservableInputStream$Observer;->closed()V

    goto :goto_8

    :cond_18
    return-void
.end method

.method protected noteDataByte(I)V
    .registers 4

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->getObservers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/input/ObservableInputStream$Observer;

    invoke-virtual {v1, p1}, Lorg/apache/commons/io/input/ObservableInputStream$Observer;->data(I)V

    goto :goto_8

    :cond_18
    return-void
.end method

.method protected noteDataBytes([BII)V
    .registers 6

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->getObservers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/input/ObservableInputStream$Observer;

    invoke-virtual {v1, p1, p2, p3}, Lorg/apache/commons/io/input/ObservableInputStream$Observer;->data([BII)V

    goto :goto_8

    :cond_18
    return-void
.end method

.method protected noteError(Ljava/io/IOException;)V
    .registers 4

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->getObservers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/input/ObservableInputStream$Observer;

    invoke-virtual {v1, p1}, Lorg/apache/commons/io/input/ObservableInputStream$Observer;->error(Ljava/io/IOException;)V

    goto :goto_8

    :cond_18
    return-void
.end method

.method protected noteFinished()V
    .registers 3

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->getObservers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/commons/io/input/ObservableInputStream$Observer;

    invoke-virtual {v1}, Lorg/apache/commons/io/input/ObservableInputStream$Observer;->finished()V

    goto :goto_8

    :cond_18
    return-void
.end method

.method public read()I
    .registers 3

    :try_start_0
    invoke-super {p0}, Lorg/apache/commons/io/input/ProxyInputStream;->read()I

    move-result v0
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_4} :catch_6

    const/4 v1, 0x0

    goto :goto_8

    :catch_6
    move-exception v1

    const/4 v0, 0x0

    :goto_8
    if-eqz v1, :cond_e

    invoke-virtual {p0, v1}, Lorg/apache/commons/io/input/ObservableInputStream;->noteError(Ljava/io/IOException;)V

    goto :goto_18

    :cond_e
    const/4 v1, -0x1

    if-ne v0, v1, :cond_15

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteFinished()V

    goto :goto_18

    :cond_15
    invoke-virtual {p0, v0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteDataByte(I)V

    :goto_18
    return v0
.end method

.method public read([B)I
    .registers 5

    const/4 v0, 0x0

    :try_start_1
    invoke-super {p0, p1}, Lorg/apache/commons/io/input/ProxyInputStream;->read([B)I

    move-result v1
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_5} :catch_7

    const/4 v2, 0x0

    goto :goto_9

    :catch_7
    move-exception v2

    const/4 v1, 0x0

    :goto_9
    if-eqz v2, :cond_f

    invoke-virtual {p0, v2}, Lorg/apache/commons/io/input/ObservableInputStream;->noteError(Ljava/io/IOException;)V

    goto :goto_1b

    :cond_f
    const/4 v2, -0x1

    if-ne v1, v2, :cond_16

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteFinished()V

    goto :goto_1b

    :cond_16
    if-lez v1, :cond_1b

    invoke-virtual {p0, p1, v0, v1}, Lorg/apache/commons/io/input/ObservableInputStream;->noteDataBytes([BII)V

    :cond_1b
    :goto_1b
    return v1
.end method

.method public read([BII)I
    .registers 5

    :try_start_0
    invoke-super {p0, p1, p2, p3}, Lorg/apache/commons/io/input/ProxyInputStream;->read([BII)I

    move-result p3
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_4} :catch_6

    const/4 v0, 0x0

    goto :goto_8

    :catch_6
    move-exception v0

    const/4 p3, 0x0

    :goto_8
    if-eqz v0, :cond_e

    invoke-virtual {p0, v0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteError(Ljava/io/IOException;)V

    goto :goto_1a

    :cond_e
    const/4 v0, -0x1

    if-ne p3, v0, :cond_15

    invoke-virtual {p0}, Lorg/apache/commons/io/input/ObservableInputStream;->noteFinished()V

    goto :goto_1a

    :cond_15
    if-lez p3, :cond_1a

    invoke-virtual {p0, p1, p2, p3}, Lorg/apache/commons/io/input/ObservableInputStream;->noteDataBytes([BII)V

    :cond_1a
    :goto_1a
    return p3
.end method

.method public remove(Lorg/apache/commons/io/input/ObservableInputStream$Observer;)V
    .registers 3

    iget-object v0, p0, Lorg/apache/commons/io/input/ObservableInputStream;->observers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public removeAllObservers()V
    .registers 2

    iget-object v0, p0, Lorg/apache/commons/io/input/ObservableInputStream;->observers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method
