.class public abstract Landroidx/loader/content/a;
.super Landroidx/loader/content/b;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/loader/content/a$a;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Ljava/lang/Object;",
        ">",
        "Landroidx/loader/content/b<",
        "TD;>;"
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field private static final TAG:Ljava/lang/String; = "AsyncTaskLoader"


# instance fields
.field private volatile mCancellingTask:Landroidx/loader/content/a$a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/loader/content/a<",
            "TD;>.a;"
        }
    .end annotation
.end field

.field private mExecutor:Ljava/util/concurrent/Executor;

.field private mHandler:Landroid/os/Handler;

.field private mLastLoadCompleteTime:J

.field private volatile mTask:Landroidx/loader/content/a$a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/loader/content/a<",
            "TD;>.a;"
        }
    .end annotation
.end field

.field private mUpdateThrottle:J


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 4

    invoke-direct {p0, p1}, Landroidx/loader/content/b;-><init>(Landroid/content/Context;)V

    const-wide/16 v0, -0x2710

    iput-wide v0, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    return-void
.end method


# virtual methods
.method public cancelLoadInBackground()V
    .registers 1

    return-void
.end method

.method dispatchOnCancelled(Landroidx/loader/content/a$a;Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/a<",
            "TD;>.a;TD;)V"
        }
    .end annotation

    invoke-virtual {p0, p2}, Landroidx/loader/content/a;->onCanceled(Ljava/lang/Object;)V

    iget-object p2, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    if-ne p2, p1, :cond_19

    invoke-virtual {p0}, Landroidx/loader/content/b;->rollbackContentChanged()V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide p1

    iput-wide p1, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    invoke-virtual {p0}, Landroidx/loader/content/b;->deliverCancellation()V

    invoke-virtual {p0}, Landroidx/loader/content/a;->executePendingTask()V

    :cond_19
    return-void
.end method

.method dispatchOnLoadComplete(Landroidx/loader/content/a$a;Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/a<",
            "TD;>.a;TD;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    if-eq v0, p1, :cond_8

    invoke-virtual {p0, p1, p2}, Landroidx/loader/content/a;->dispatchOnCancelled(Landroidx/loader/content/a$a;Ljava/lang/Object;)V

    goto :goto_21

    :cond_8
    invoke-virtual {p0}, Landroidx/loader/content/b;->isAbandoned()Z

    move-result p1

    if-eqz p1, :cond_12

    invoke-virtual {p0, p2}, Landroidx/loader/content/a;->onCanceled(Ljava/lang/Object;)V

    goto :goto_21

    :cond_12
    invoke-virtual {p0}, Landroidx/loader/content/b;->commitContentChanged()V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {p0, p2}, Landroidx/loader/content/b;->deliverResult(Ljava/lang/Object;)V

    :goto_21
    return-void
.end method

.method public dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 9
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-super {p0, p1, p2, p3, p4}, Landroidx/loader/content/b;->dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    iget-object p2, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    const-string p4, " waiting="

    if-eqz p2, :cond_20

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p2, "mTask="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object p2, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/Object;)V

    invoke-virtual {p3, p4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object p2, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iget-boolean p2, p2, Landroidx/loader/content/a$a;->i:Z

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->println(Z)V

    :cond_20
    iget-object p2, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    if-eqz p2, :cond_3b

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p2, "mCancellingTask="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object p2, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/Object;)V

    invoke-virtual {p3, p4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object p2, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    iget-boolean p2, p2, Landroidx/loader/content/a$a;->i:Z

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->println(Z)V

    :cond_3b
    iget-wide v0, p0, Landroidx/loader/content/a;->mUpdateThrottle:J

    const-wide/16 v2, 0x0

    cmp-long p2, v0, v2

    if-eqz p2, :cond_90

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p1, "mUpdateThrottle="

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    sget-object p1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    iget-wide v0, p0, Landroidx/loader/content/a;->mUpdateThrottle:J

    invoke-virtual {p1, v0, v1}, Ljava/util/concurrent/TimeUnit;->toSeconds(J)J

    move-result-wide v0

    invoke-static {v0, v1}, Landroid/text/format/DateUtils;->formatElapsedTime(J)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p2, " mLastLoadCompleteTime="

    invoke-virtual {p3, p2}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v0, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    const-wide/16 v2, -0x2710

    cmp-long p2, v0, v2

    if-nez p2, :cond_6a

    const-string p1, "--"

    goto :goto_8a

    :cond_6a
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p4, "-"

    invoke-virtual {p2, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    sub-long/2addr v0, v2

    invoke-virtual {p1, v0, v1}, Ljava/util/concurrent/TimeUnit;->toSeconds(J)J

    move-result-wide v0

    invoke-static {v0, v1}, Landroid/text/format/DateUtils;->formatElapsedTime(J)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :goto_8a
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p3}, Ljava/io/PrintWriter;->println()V

    :cond_90
    return-void
.end method

.method executePendingTask()V
    .registers 7

    iget-object v0, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    if-nez v0, :cond_52

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    if-eqz v0, :cond_52

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iget-boolean v0, v0, Landroidx/loader/content/a$a;->i:Z

    if-eqz v0, :cond_1a

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    const/4 v1, 0x0

    iput-boolean v1, v0, Landroidx/loader/content/a$a;->i:Z

    iget-object v0, p0, Landroidx/loader/content/a;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    :cond_1a
    iget-wide v0, p0, Landroidx/loader/content/a;->mUpdateThrottle:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-lez v4, :cond_41

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    iget-wide v4, p0, Landroidx/loader/content/a;->mUpdateThrottle:J

    add-long/2addr v2, v4

    cmp-long v4, v0, v2

    if-gez v4, :cond_41

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    const/4 v1, 0x1

    iput-boolean v1, v0, Landroidx/loader/content/a$a;->i:Z

    iget-object v0, p0, Landroidx/loader/content/a;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iget-wide v2, p0, Landroidx/loader/content/a;->mLastLoadCompleteTime:J

    iget-wide v4, p0, Landroidx/loader/content/a;->mUpdateThrottle:J

    add-long/2addr v2, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postAtTime(Ljava/lang/Runnable;J)Z

    return-void

    :cond_41
    iget-object v0, p0, Landroidx/loader/content/a;->mExecutor:Ljava/util/concurrent/Executor;

    if-nez v0, :cond_4b

    invoke-virtual {p0}, Landroidx/loader/content/a;->getExecutor()Ljava/util/concurrent/Executor;

    move-result-object v0

    iput-object v0, p0, Landroidx/loader/content/a;->mExecutor:Ljava/util/concurrent/Executor;

    :cond_4b
    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iget-object v1, p0, Landroidx/loader/content/a;->mExecutor:Ljava/util/concurrent/Executor;

    invoke-virtual {v0, v1}, Landroidx/loader/content/c;->c(Ljava/util/concurrent/Executor;)V

    :cond_52
    return-void
.end method

.method protected getExecutor()Ljava/util/concurrent/Executor;
    .registers 2

    sget-object v0, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public isLoadInBackgroundCanceled()Z
    .registers 2

    iget-object v0, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method public abstract loadInBackground()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TD;"
        }
    .end annotation
.end method

.method protected onCancelLoad()Z
    .registers 5

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    const/4 v1, 0x0

    if-eqz v0, :cond_4d

    invoke-virtual {p0}, Landroidx/loader/content/b;->isStarted()Z

    move-result v0

    if-nez v0, :cond_e

    invoke-virtual {p0}, Landroidx/loader/content/b;->onContentChanged()V

    :cond_e
    iget-object v0, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    const/4 v2, 0x0

    if-eqz v0, :cond_27

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iget-boolean v0, v0, Landroidx/loader/content/a$a;->i:Z

    if-eqz v0, :cond_24

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iput-boolean v1, v0, Landroidx/loader/content/a$a;->i:Z

    iget-object v0, p0, Landroidx/loader/content/a;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    :cond_24
    iput-object v2, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    return v1

    :cond_27
    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iget-boolean v0, v0, Landroidx/loader/content/a$a;->i:Z

    if-eqz v0, :cond_3b

    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iput-boolean v1, v0, Landroidx/loader/content/a$a;->i:Z

    iget-object v0, p0, Landroidx/loader/content/a;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    iput-object v2, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    return v1

    :cond_3b
    iget-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {v0, v1}, Landroidx/loader/content/c;->a(Z)Z

    move-result v0

    if-eqz v0, :cond_4a

    iget-object v1, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    iput-object v1, p0, Landroidx/loader/content/a;->mCancellingTask:Landroidx/loader/content/a$a;

    invoke-virtual {p0}, Landroidx/loader/content/a;->cancelLoadInBackground()V

    :cond_4a
    iput-object v2, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    return v0

    :cond_4d
    return v1
.end method

.method public onCanceled(Ljava/lang/Object;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    return-void
.end method

.method protected onForceLoad()V
    .registers 2

    invoke-super {p0}, Landroidx/loader/content/b;->onForceLoad()V

    invoke-virtual {p0}, Landroidx/loader/content/b;->cancelLoad()Z

    new-instance v0, Landroidx/loader/content/a$a;

    invoke-direct {v0, p0}, Landroidx/loader/content/a$a;-><init>(Landroidx/loader/content/a;)V

    iput-object v0, p0, Landroidx/loader/content/a;->mTask:Landroidx/loader/content/a$a;

    invoke-virtual {p0}, Landroidx/loader/content/a;->executePendingTask()V

    return-void
.end method

.method protected onLoadInBackground()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TD;"
        }
    .end annotation

    invoke-virtual {p0}, Landroidx/loader/content/a;->loadInBackground()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public setUpdateThrottle(J)V
    .registers 6

    iput-wide p1, p0, Landroidx/loader/content/a;->mUpdateThrottle:J

    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    if-eqz v2, :cond_f

    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Landroidx/loader/content/a;->mHandler:Landroid/os/Handler;

    :cond_f
    return-void
.end method
