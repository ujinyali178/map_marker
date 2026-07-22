.class Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/view/FrameBufferBitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Lock"
.end annotation


# instance fields
.field private enabled:Z


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enabled:Z

    return-void
.end method


# virtual methods
.method declared-synchronized disable()V
    .registers 2

    monitor-enter p0

    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enabled:Z

    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_9

    monitor-exit p0

    return-void

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized enable()V
    .registers 2

    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    iput-boolean v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enabled:Z
    :try_end_4
    .catchall {:try_start_2 .. :try_end_4} :catchall_6

    monitor-exit p0

    return-void

    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method isEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enabled:Z

    return v0
.end method

.method declared-synchronized waitDisabled()V
    .registers 3

    monitor-enter p0

    :goto_1
    :try_start_1
    iget-boolean v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$Lock;->enabled:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_8
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_8} :catch_b
    .catchall {:try_start_1 .. :try_end_8} :catchall_9

    goto :goto_1

    :catchall_9
    move-exception v0

    goto :goto_16

    :catch_b
    :try_start_b
    # getter for: Lorg/mapsforge/map/view/FrameBufferBitmap;->LOGGER:Ljava/util/logging/Logger;
    invoke-static {}, Lorg/mapsforge/map/view/FrameBufferBitmap;->access$000()Ljava/util/logging/Logger;

    move-result-object v0

    const-string v1, "Frame buffer interrupted"

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->fine(Ljava/lang/String;)V
    :try_end_14
    .catchall {:try_start_b .. :try_end_14} :catchall_9

    :cond_14
    monitor-exit p0

    return-void

    :goto_16
    monitor-exit p0

    throw v0
.end method
