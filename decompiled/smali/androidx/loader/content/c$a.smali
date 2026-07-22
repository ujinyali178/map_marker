.class Landroidx/loader/content/c$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/loader/content/c;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable<",
        "TResult;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Landroidx/loader/content/c;


# direct methods
.method constructor <init>(Landroidx/loader/content/c;)V
    .registers 2

    iput-object p1, p0, Landroidx/loader/content/c$a;->a:Landroidx/loader/content/c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TResult;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/c$a;->a:Landroidx/loader/content/c;

    iget-object v0, v0, Landroidx/loader/content/c;->g:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    const/16 v0, 0xa

    const/4 v2, 0x0

    :try_start_b
    invoke-static {v0}, Landroid/os/Process;->setThreadPriority(I)V

    iget-object v0, p0, Landroidx/loader/content/c$a;->a:Landroidx/loader/content/c;

    invoke-virtual {v0}, Landroidx/loader/content/c;->b()Ljava/lang/Object;

    move-result-object v2

    invoke-static {}, Landroid/os/Binder;->flushPendingCommands()V
    :try_end_17
    .catchall {:try_start_b .. :try_end_17} :catchall_1d

    iget-object v0, p0, Landroidx/loader/content/c$a;->a:Landroidx/loader/content/c;

    invoke-virtual {v0, v2}, Landroidx/loader/content/c;->i(Ljava/lang/Object;)V

    return-object v2

    :catchall_1d
    move-exception v0

    :try_start_1e
    iget-object v3, p0, Landroidx/loader/content/c$a;->a:Landroidx/loader/content/c;

    iget-object v3, v3, Landroidx/loader/content/c;->f:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v3, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    throw v0
    :try_end_26
    .catchall {:try_start_1e .. :try_end_26} :catchall_26

    :catchall_26
    move-exception v0

    iget-object v1, p0, Landroidx/loader/content/c$a;->a:Landroidx/loader/content/c;

    invoke-virtual {v1, v2}, Landroidx/loader/content/c;->i(Ljava/lang/Object;)V

    throw v0
.end method
