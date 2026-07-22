.class public Landroidx/loader/content/b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/loader/content/b$a;,
        Landroidx/loader/content/b$b;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mAbandoned:Z

.field private mContentChanged:Z

.field private mContext:Landroid/content/Context;

.field private mId:I

.field private mListener:Landroidx/loader/content/b$b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/loader/content/b$b<",
            "TD;>;"
        }
    .end annotation
.end field

.field private mOnLoadCanceledListener:Landroidx/loader/content/b$a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/loader/content/b$a<",
            "TD;>;"
        }
    .end annotation
.end field

.field private mProcessingChange:Z

.field private mReset:Z

.field private mStarted:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/loader/content/b;->mStarted:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mAbandoned:Z

    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/loader/content/b;->mReset:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mContentChanged:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Landroidx/loader/content/b;->mContext:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method public abandon()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/loader/content/b;->mAbandoned:Z

    invoke-virtual {p0}, Landroidx/loader/content/b;->onAbandon()V

    return-void
.end method

.method public cancelLoad()Z
    .registers 2

    invoke-virtual {p0}, Landroidx/loader/content/b;->onCancelLoad()Z

    move-result v0

    return v0
.end method

.method public commitContentChanged()V
    .registers 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    return-void
.end method

.method public dataToString(Ljava/lang/Object;)Ljava/lang/String;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)",
            "Ljava/lang/String;"
        }
    .end annotation

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    if-nez p1, :cond_c

    const-string p1, "null"

    goto :goto_29

    :cond_c
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "}"

    :goto_29
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public deliverCancellation()V
    .registers 2

    iget-object v0, p0, Landroidx/loader/content/b;->mOnLoadCanceledListener:Landroidx/loader/content/b$a;

    if-eqz v0, :cond_7

    invoke-interface {v0, p0}, Landroidx/loader/content/b$a;->a(Landroidx/loader/content/b;)V

    :cond_7
    return-void
.end method

.method public deliverResult(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/b;->mListener:Landroidx/loader/content/b$b;

    if-eqz v0, :cond_7

    invoke-interface {v0, p0, p1}, Landroidx/loader/content/b$b;->a(Landroidx/loader/content/b;Ljava/lang/Object;)V

    :cond_7
    return-void
.end method

.method public dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 5
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p2, "mId="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget p2, p0, Landroidx/loader/content/b;->mId:I

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(I)V

    const-string p2, " mListener="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object p2, p0, Landroidx/loader/content/b;->mListener:Landroidx/loader/content/b$b;

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    iget-boolean p2, p0, Landroidx/loader/content/b;->mStarted:Z

    if-nez p2, :cond_23

    iget-boolean p2, p0, Landroidx/loader/content/b;->mContentChanged:Z

    if-nez p2, :cond_23

    iget-boolean p2, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    if-eqz p2, :cond_44

    :cond_23
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p2, "mStarted="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean p2, p0, Landroidx/loader/content/b;->mStarted:Z

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Z)V

    const-string p2, " mContentChanged="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean p2, p0, Landroidx/loader/content/b;->mContentChanged:Z

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Z)V

    const-string p2, " mProcessingChange="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean p2, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->println(Z)V

    :cond_44
    iget-boolean p2, p0, Landroidx/loader/content/b;->mAbandoned:Z

    if-nez p2, :cond_4c

    iget-boolean p2, p0, Landroidx/loader/content/b;->mReset:Z

    if-eqz p2, :cond_63

    :cond_4c
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p1, "mAbandoned="

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean p1, p0, Landroidx/loader/content/b;->mAbandoned:Z

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Z)V

    const-string p1, " mReset="

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean p1, p0, Landroidx/loader/content/b;->mReset:Z

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->println(Z)V

    :cond_63
    return-void
.end method

.method public forceLoad()V
    .registers 1

    invoke-virtual {p0}, Landroidx/loader/content/b;->onForceLoad()V

    return-void
.end method

.method public getContext()Landroid/content/Context;
    .registers 2

    iget-object v0, p0, Landroidx/loader/content/b;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getId()I
    .registers 2

    iget v0, p0, Landroidx/loader/content/b;->mId:I

    return v0
.end method

.method public isAbandoned()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/loader/content/b;->mAbandoned:Z

    return v0
.end method

.method public isReset()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/loader/content/b;->mReset:Z

    return v0
.end method

.method public isStarted()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/loader/content/b;->mStarted:Z

    return v0
.end method

.method protected onAbandon()V
    .registers 1

    return-void
.end method

.method protected onCancelLoad()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public onContentChanged()V
    .registers 2

    iget-boolean v0, p0, Landroidx/loader/content/b;->mStarted:Z

    if-eqz v0, :cond_8

    invoke-virtual {p0}, Landroidx/loader/content/b;->forceLoad()V

    goto :goto_b

    :cond_8
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/loader/content/b;->mContentChanged:Z

    :goto_b
    return-void
.end method

.method protected onForceLoad()V
    .registers 1

    return-void
.end method

.method protected onReset()V
    .registers 1

    return-void
.end method

.method protected onStartLoading()V
    .registers 1

    return-void
.end method

.method protected onStopLoading()V
    .registers 1

    return-void
.end method

.method public registerListener(ILandroidx/loader/content/b$b;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/loader/content/b$b<",
            "TD;>;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/b;->mListener:Landroidx/loader/content/b$b;

    if-nez v0, :cond_9

    iput-object p2, p0, Landroidx/loader/content/b;->mListener:Landroidx/loader/content/b$b;

    iput p1, p0, Landroidx/loader/content/b;->mId:I

    return-void

    :cond_9
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "There is already a listener registered"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public registerOnLoadCanceledListener(Landroidx/loader/content/b$a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/b$a<",
            "TD;>;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/b;->mOnLoadCanceledListener:Landroidx/loader/content/b$a;

    if-nez v0, :cond_7

    iput-object p1, p0, Landroidx/loader/content/b;->mOnLoadCanceledListener:Landroidx/loader/content/b$a;

    return-void

    :cond_7
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "There is already a listener registered"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public reset()V
    .registers 2

    invoke-virtual {p0}, Landroidx/loader/content/b;->onReset()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/loader/content/b;->mReset:Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/loader/content/b;->mStarted:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mAbandoned:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mContentChanged:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    return-void
.end method

.method public rollbackContentChanged()V
    .registers 2

    iget-boolean v0, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    if-eqz v0, :cond_7

    invoke-virtual {p0}, Landroidx/loader/content/b;->onContentChanged()V

    :cond_7
    return-void
.end method

.method public final startLoading()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/loader/content/b;->mStarted:Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/loader/content/b;->mReset:Z

    iput-boolean v0, p0, Landroidx/loader/content/b;->mAbandoned:Z

    invoke-virtual {p0}, Landroidx/loader/content/b;->onStartLoading()V

    return-void
.end method

.method public stopLoading()V
    .registers 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/loader/content/b;->mStarted:Z

    invoke-virtual {p0}, Landroidx/loader/content/b;->onStopLoading()V

    return-void
.end method

.method public takeContentChanged()Z
    .registers 3

    iget-boolean v0, p0, Landroidx/loader/content/b;->mContentChanged:Z

    const/4 v1, 0x0

    iput-boolean v1, p0, Landroidx/loader/content/b;->mContentChanged:Z

    iget-boolean v1, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    or-int/2addr v1, v0

    iput-boolean v1, p0, Landroidx/loader/content/b;->mProcessingChange:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "{"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroidx/loader/content/b;->mId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unregisterListener(Landroidx/loader/content/b$b;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/b$b<",
            "TD;>;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/b;->mListener:Landroidx/loader/content/b$b;

    if-eqz v0, :cond_12

    if-ne v0, p1, :cond_a

    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/loader/content/b;->mListener:Landroidx/loader/content/b$b;

    return-void

    :cond_a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Attempting to unregister the wrong listener"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_12
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "No listener register"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public unregisterOnLoadCanceledListener(Landroidx/loader/content/b$a;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/b$a<",
            "TD;>;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/b;->mOnLoadCanceledListener:Landroidx/loader/content/b$a;

    if-eqz v0, :cond_12

    if-ne v0, p1, :cond_a

    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/loader/content/b;->mOnLoadCanceledListener:Landroidx/loader/content/b$a;

    return-void

    :cond_a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Attempting to unregister the wrong listener"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_12
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "No listener register"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
