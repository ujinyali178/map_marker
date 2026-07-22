.class Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;
.super Lorg/mapsforge/core/model/BoundingBox;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawHillTileSource;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/hills/HgtCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "HgtFileInfo"
.end annotation


# instance fields
.field final file:Ljava/io/File;

.field final size:J

.field final synthetic this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

.field weakRef:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/hills/HgtCache;Ljava/io/File;DDDD)V
    .registers 21

    move-object v9, p0

    move-object v0, p1

    iput-object v0, v9, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    move-object v0, p0

    move-wide v1, p3

    move-wide v3, p5

    move-wide/from16 v5, p7

    move-wide/from16 v7, p9

    invoke-direct/range {v0 .. v8}, Lorg/mapsforge/core/model/BoundingBox;-><init>(DDDD)V

    const/4 v0, 0x0

    iput-object v0, v9, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    move-object v0, p2

    iput-object v0, v9, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->file:Ljava/io/File;

    invoke-virtual {p2}, Ljava/io/File;->length()J

    move-result-wide v0

    iput-wide v0, v9, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->size:J

    return-void
.end method

.method static synthetic access$200(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;
    .registers 2

    invoke-direct {p0, p1}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getNeighbor(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$300(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;
    .registers 1

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getUnmergedAsMergePartner()Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    move-result-object p0

    return-object p0
.end method

.method private getForHires()Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_c

    :cond_6
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Future;

    :goto_c
    instance-of v1, v0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    if-eqz v1, :cond_13

    check-cast v0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    goto :goto_40

    :cond_13
    instance-of v1, v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    if-eqz v1, :cond_32

    check-cast v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    new-instance v1, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {v1, v2, p0, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;)V

    new-instance v2, Ljava/lang/ref/WeakReference;

    invoke-direct {v2, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v2}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$400(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v2

    invoke-virtual {v2, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->evict(Ljava/util/concurrent/Future;)V

    move-object v0, v1

    goto :goto_40

    :cond_32
    new-instance v0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {v0, v1, p0}, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)V

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    :goto_40
    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->mainLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$500(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v1

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;

    return-object v0
.end method

.method private getForLores()Ljava/util/concurrent/Future;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_c

    :cond_6
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Future;

    :goto_c
    if-nez v0, :cond_1c

    new-instance v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {v0, v1, p0}, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)V

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    :cond_1c
    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->mainLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$500(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v1

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v2}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$400(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v2

    if-eqz v2, :cond_37

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v2}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$400(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v2

    invoke-virtual {v2, v1}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;

    :cond_37
    return-object v0
.end method

.method private getNeighbor(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->hgtFiles:Lorg/mapsforge/map/layer/hills/LazyFuture;
    invoke-static {v0}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$600(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/LazyFuture;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    sget-object v1, Lorg/mapsforge/map/layer/hills/HgtCache$2;->$SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p1

    aget p1, v1, p1

    const/4 v1, 0x1

    if-eq p1, v1, :cond_4f

    const/4 v2, 0x2

    if-eq p1, v2, :cond_42

    const/4 v2, 0x3

    if-eq p1, v2, :cond_35

    const/4 v2, 0x4

    if-eq p1, v2, :cond_22

    const/4 p1, 0x0

    return-object p1

    :cond_22
    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    double-to-int v2, v2

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    double-to-int v3, v3

    sub-int/2addr v3, v1

    invoke-direct {p1, v2, v3}, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;-><init>(II)V

    :goto_2e
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    return-object p1

    :cond_35
    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    double-to-int v2, v2

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    double-to-int v3, v3

    add-int/2addr v3, v1

    invoke-direct {p1, v2, v3}, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;-><init>(II)V

    goto :goto_2e

    :cond_42
    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    double-to-int v2, v2

    sub-int/2addr v2, v1

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    double-to-int v1, v3

    invoke-direct {p1, v2, v1}, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;-><init>(II)V

    goto :goto_2e

    :cond_4f
    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    double-to-int v2, v2

    add-int/2addr v2, v1

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    double-to-int v1, v3

    invoke-direct {p1, v2, v1}, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;-><init>(II)V

    goto :goto_2e
.end method

.method private getUnmergedAsMergePartner()Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_c

    :cond_6
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Future;

    :goto_c
    instance-of v1, v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    if-eqz v1, :cond_1c

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$400(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v1

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;

    check-cast v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    goto :goto_45

    :cond_1c
    instance-of v1, v0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    if-eqz v1, :cond_2e

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->mainLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$500(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v1

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;

    check-cast v0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    iget-object v0, v0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->loadFuture:Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    goto :goto_45

    :cond_2e
    new-instance v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {v0, v1, p0}, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)V

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$400(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    move-result-object v1

    invoke-virtual {v1, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;->markUsed(Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;

    :goto_45
    return-object v0
.end method


# virtual methods
.method public eastLng()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    return-wide v0
.end method

.method getBitmapFuture(DD)Ljava/util/concurrent/Future;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(DD)",
            "Ljava/util/concurrent/Future<",
            "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    iget-boolean v1, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->interpolatorOverlap:Z

    if-eqz v1, :cond_20

    iget-object v0, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    invoke-interface {v0, p0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;->getAxisLenght(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)I

    move-result v0

    int-to-double v0, v0

    cmpl-double v2, p1, v0

    if-gtz v2, :cond_1b

    cmpl-double p1, p3, v0

    if-lez p1, :cond_16

    goto :goto_1b

    :cond_16
    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getForLores()Ljava/util/concurrent/Future;

    move-result-object p1

    return-object p1

    :cond_1b
    :goto_1b
    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getForHires()Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;

    move-result-object p1

    return-object p1

    :cond_20
    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getForLores()Ljava/util/concurrent/Future;

    move-result-object p1

    return-object p1
.end method

.method public getFile()Ljava/io/File;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->file:Ljava/io/File;

    return-object v0
.end method

.method public getFinishedConverted()Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_1f

    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Future;

    if-eqz v0, :cond_1f

    invoke-interface {v0}, Ljava/util/concurrent/Future;->isDone()Z

    move-result v1

    if-eqz v1, :cond_1f

    :try_start_12
    invoke-interface {v0}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/graphics/HillshadingBitmap;
    :try_end_18
    .catch Ljava/lang/InterruptedException; {:try_start_12 .. :try_end_18} :catch_1b
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_12 .. :try_end_18} :catch_19

    return-object v0

    :catch_19
    move-exception v0

    goto :goto_1c

    :catch_1b
    move-exception v0

    :goto_1c
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_1f
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSize()J
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->size:J

    return-wide v0
.end method

.method public northLat()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    return-wide v0
.end method

.method public southLat()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    return-wide v0
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->weakRef:Ljava/lang/ref/WeakReference;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_c

    :cond_6
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Future;

    :goto_c
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[lt:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->minLatitude:D

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLatitude:D

    invoke-virtual {v1, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v3, " ln:"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v3, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    invoke-virtual {v1, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v2, p0, Lorg/mapsforge/core/model/BoundingBox;->maxLongitude:D

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    if-nez v0, :cond_3c

    const-string v0, ""

    goto :goto_47

    :cond_3c
    invoke-interface {v0}, Ljava/util/concurrent/Future;->isDone()Z

    move-result v0

    if-eqz v0, :cond_45

    const-string v0, "done"

    goto :goto_47

    :cond_45
    const-string v0, "wip"

    :goto_47
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "]"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public westLng()D
    .registers 3

    iget-wide v0, p0, Lorg/mapsforge/core/model/BoundingBox;->minLongitude:D

    return-wide v0
.end method
