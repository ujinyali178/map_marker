.class Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;
.super Lorg/mapsforge/map/layer/hills/LazyFuture;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/hills/HgtCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MergeOverlapFuture"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/map/layer/hills/LazyFuture<",
        "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

.field final loadFuture:Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

.field final synthetic this$0:Lorg/mapsforge/map/layer/hills/HgtCache;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)V
    .registers 4

    new-instance v0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    invoke-direct {v0, p1, p2}, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)V

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;)V

    return-void
.end method

.method constructor <init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;)V
    .registers 4

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LazyFuture;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    iput-object p3, p0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->loadFuture:Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    return-void
.end method

.method private mergePaddingOnBitmap(Lorg/mapsforge/core/graphics/HillshadingBitmap;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V
    .registers 6

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/HillshadingBitmap;->getPadding()I

    move-result v0

    const/4 v1, 0x1

    if-ge v0, v1, :cond_8

    return-void

    :cond_8
    if-eqz p2, :cond_2a

    # invokes: Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getUnmergedAsMergePartner()Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;
    invoke-static {p2}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->access$300(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    move-result-object p2

    if-eqz p2, :cond_2a

    :try_start_10
    invoke-interface {p2}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/core/graphics/HillshadingBitmap;

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$100(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/core/graphics/GraphicFactory;

    move-result-object v1

    invoke-interface {v1}, Lorg/mapsforge/core/graphics/GraphicFactory;->createCanvas()Lorg/mapsforge/core/graphics/Canvas;

    move-result-object v1

    invoke-static {p1, p2, p3, v0, v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->mergeSameSized(Lorg/mapsforge/core/graphics/HillshadingBitmap;Lorg/mapsforge/core/graphics/HillshadingBitmap;Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;ILorg/mapsforge/core/graphics/Canvas;)V
    :try_end_23
    .catch Ljava/lang/InterruptedException; {:try_start_10 .. :try_end_23} :catch_26
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_10 .. :try_end_23} :catch_24

    goto :goto_2a

    :catch_24
    move-exception p1

    goto :goto_27

    :catch_26
    move-exception p1

    :goto_27
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_2a
    :goto_2a
    return-void
.end method


# virtual methods
.method public bridge synthetic calculate()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->calculate()Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object v0

    return-object v0
.end method

.method public calculate()Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->loadFuture:Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/graphics/HillshadingBitmap;

    invoke-static {}, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->values()[Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    move-result-object v1

    array-length v2, v1

    const/4 v3, 0x0

    :goto_e
    if-ge v3, v2, :cond_1e

    aget-object v4, v1, v3

    iget-object v5, p0, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    # invokes: Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getNeighbor(Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;
    invoke-static {v5, v4}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->access$200(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    move-result-object v5

    invoke-direct {p0, v0, v5, v4}, Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;->mergePaddingOnBitmap(Lorg/mapsforge/core/graphics/HillshadingBitmap;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_e

    :cond_1e
    return-object v0
.end method
