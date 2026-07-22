.class Lorg/mapsforge/map/model/MapViewPosition$Animator;
.super Lorg/mapsforge/map/util/PausableThread;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/model/MapViewPosition;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Animator"
.end annotation


# static fields
.field private static final DEFAULT_DURATION:I = 0xfa

.field private static final DEFAULT_MOVE_STEPS:I = 0x19

.field private static final FRAME_LENGTH_IN_MS:I = 0xf


# instance fields
.field private mapSize:J

.field private moveSteps:I

.field private scaleDifference:D

.field private startScaleFactor:D

.field private targetPixelX:D

.field private targetPixelY:D

.field final synthetic this$0:Lorg/mapsforge/map/model/MapViewPosition;

.field private timeEnd:J

.field private timeStart:J

.field private zoomAnimation:Z


# direct methods
.method private constructor <init>(Lorg/mapsforge/map/model/MapViewPosition;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    invoke-direct {p0}, Lorg/mapsforge/map/util/PausableThread;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/mapsforge/map/model/MapViewPosition;Lorg/mapsforge/map/model/MapViewPosition$1;)V
    .registers 3

    invoke-direct {p0, p1}, Lorg/mapsforge/map/model/MapViewPosition$Animator;-><init>(Lorg/mapsforge/map/model/MapViewPosition;)V

    return-void
.end method

.method private calculateScaleFactor(F)D
    .registers 8

    iget-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->startScaleFactor:D

    iget-wide v2, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->scaleDifference:D

    float-to-double v4, p1

    mul-double v2, v2, v4

    add-double/2addr v0, v2

    return-wide v0
.end method

.method private doWorkMove()V
    .registers 11

    iget v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    # getter for: Lorg/mapsforge/map/model/MapViewPosition;->longitude:D
    invoke-static {v0}, Lorg/mapsforge/map/model/MapViewPosition;->access$000(Lorg/mapsforge/map/model/MapViewPosition;)D

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->mapSize:J

    invoke-static {v0, v1, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v0

    iget-object v2, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    # getter for: Lorg/mapsforge/map/model/MapViewPosition;->latitude:D
    invoke-static {v2}, Lorg/mapsforge/map/model/MapViewPosition;->access$100(Lorg/mapsforge/map/model/MapViewPosition;)D

    move-result-wide v2

    iget-wide v4, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->mapSize:J

    invoke-static {v2, v3, v4, v5}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v2

    iget-wide v4, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->targetPixelX:D

    sub-double/2addr v4, v0

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(D)D

    move-result-wide v4

    iget v6, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    int-to-double v6, v6

    div-double/2addr v4, v6

    iget-wide v6, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->targetPixelY:D

    sub-double/2addr v6, v2

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(D)D

    move-result-wide v6

    iget v8, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    int-to-double v8, v8

    div-double/2addr v6, v8

    iget-wide v8, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->targetPixelX:D

    sub-double/2addr v0, v8

    invoke-static {v0, v1}, Ljava/lang/Math;->signum(D)D

    move-result-wide v0

    iget-wide v8, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->targetPixelY:D

    sub-double/2addr v2, v8

    invoke-static {v2, v3}, Ljava/lang/Math;->signum(D)D

    move-result-wide v2

    iget v8, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    add-int/lit8 v8, v8, -0x1

    iput v8, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    iget-object v8, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    mul-double v4, v4, v0

    mul-double v6, v6, v2

    invoke-virtual {v8, v4, v5, v6, v7}, Lorg/mapsforge/map/model/MapViewPosition;->moveCenter(DD)V

    return-void
.end method

.method private doWorkZoom()V
    .registers 6

    iget-boolean v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->zoomAnimation:Z

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->timeEnd:J

    cmp-long v4, v0, v2

    if-ltz v4, :cond_24

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->zoomAnimation:Z

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-direct {p0, v1}, Lorg/mapsforge/map/model/MapViewPosition$Animator;->calculateScaleFactor(F)D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lorg/mapsforge/map/model/MapViewPosition;->setScaleFactor(D)V

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/model/MapViewPosition;->setPivot(Lorg/mapsforge/core/model/LatLong;)V

    goto :goto_38

    :cond_24
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->timeStart:J

    sub-long/2addr v0, v2

    long-to-float v0, v0

    const/high16 v1, 0x437a0000    # 250.0f

    div-float/2addr v0, v1

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    invoke-direct {p0, v0}, Lorg/mapsforge/map/model/MapViewPosition$Animator;->calculateScaleFactor(F)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lorg/mapsforge/map/model/MapViewPosition;->setScaleFactor(D)V

    :goto_38
    return-void
.end method


# virtual methods
.method protected doWork()V
    .registers 3

    invoke-direct {p0}, Lorg/mapsforge/map/model/MapViewPosition$Animator;->doWorkMove()V

    invoke-direct {p0}, Lorg/mapsforge/map/model/MapViewPosition$Animator;->doWorkZoom()V

    const-wide/16 v0, 0xf

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V

    return-void
.end method

.method protected getThreadPriority()Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
    .registers 2

    sget-object v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->ABOVE_NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    return-object v0
.end method

.method protected hasWork()Z
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    if-gtz v0, :cond_b

    iget-boolean v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->zoomAnimation:Z

    if-eqz v0, :cond_9

    goto :goto_b

    :cond_9
    const/4 v0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 v0, 0x1

    :goto_c
    return v0
.end method

.method startAnimationMove(Lorg/mapsforge/core/model/LatLong;)V
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    # getter for: Lorg/mapsforge/map/model/MapViewPosition;->zoomLevel:B
    invoke-static {v0}, Lorg/mapsforge/map/model/MapViewPosition;->access$200(Lorg/mapsforge/map/model/MapViewPosition;)B

    move-result v0

    iget-object v1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->this$0:Lorg/mapsforge/map/model/MapViewPosition;

    # getter for: Lorg/mapsforge/map/model/MapViewPosition;->displayModel:Lorg/mapsforge/map/model/DisplayModel;
    invoke-static {v1}, Lorg/mapsforge/map/model/MapViewPosition;->access$300(Lorg/mapsforge/map/model/MapViewPosition;)Lorg/mapsforge/map/model/DisplayModel;

    move-result-object v1

    invoke-virtual {v1}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v1

    invoke-static {v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->mapSize:J

    iget-wide v2, p1, Lorg/mapsforge/core/model/LatLong;->longitude:D

    invoke-static {v2, v3, v0, v1}, Lorg/mapsforge/core/util/MercatorProjection;->longitudeToPixelX(DJ)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->targetPixelX:D

    iget-wide v0, p1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-wide v2, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->mapSize:J

    invoke-static {v0, v1, v2, v3}, Lorg/mapsforge/core/util/MercatorProjection;->latitudeToPixelY(DJ)D

    move-result-wide v0

    iput-wide v0, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->targetPixelY:D

    const/16 p1, 0x19

    iput p1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->moveSteps:I

    monitor-enter p0

    :try_start_2d
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    monitor-exit p0

    return-void

    :catchall_32
    move-exception p1

    monitor-exit p0
    :try_end_34
    .catchall {:try_start_2d .. :try_end_34} :catchall_32

    throw p1
.end method

.method startAnimationZoom(DD)V
    .registers 5

    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->startScaleFactor:D

    sub-double/2addr p3, p1

    iput-wide p3, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->scaleDifference:D

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->zoomAnimation:Z

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p1

    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->timeStart:J

    const-wide/16 p3, 0xfa

    add-long/2addr p1, p3

    iput-wide p1, p0, Lorg/mapsforge/map/model/MapViewPosition$Animator;->timeEnd:J

    monitor-enter p0

    :try_start_14
    invoke-virtual {p0}, Ljava/lang/Object;->notify()V

    monitor-exit p0

    return-void

    :catchall_19
    move-exception p1

    monitor-exit p0
    :try_end_1b
    .catchall {:try_start_14 .. :try_end_1b} :catchall_19

    throw p1
.end method
