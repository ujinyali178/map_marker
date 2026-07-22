.class Lorg/mapsforge/map/layer/hills/HgtCache;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;,
        Lorg/mapsforge/map/layer/hills/HgtCache$MergeOverlapFuture;,
        Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;,
        Lorg/mapsforge/map/layer/hills/HgtCache$Lru;,
        Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;
    }
.end annotation


# instance fields
.field final algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

.field final demFolder:Ljava/io/File;

.field private final graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private hgtFiles:Lorg/mapsforge/map/layer/hills/LazyFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/mapsforge/map/layer/hills/LazyFuture<",
            "Ljava/util/Map<",
            "Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;",
            "Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;",
            ">;>;"
        }
    .end annotation
.end field

.field final interpolatorOverlap:Z

.field final mainCacheSize:I

.field private final mainLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

.field final neighborCacheSize:I

.field private problems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;


# direct methods
.method constructor <init>(Ljava/io/File;ZLorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;II)V
    .registers 8

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->problems:Ljava/util/List;

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->demFolder:Ljava/io/File;

    iput-boolean p2, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->interpolatorOverlap:Z

    iput-object p3, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p4, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    iput p5, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->mainCacheSize:I

    iput p6, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->neighborCacheSize:I

    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    invoke-direct {p1, p5}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->mainLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    if-eqz p2, :cond_25

    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    invoke-direct {p1, p6}, Lorg/mapsforge/map/layer/hills/HgtCache$Lru;-><init>(I)V

    goto :goto_26

    :cond_25
    const/4 p1, 0x0

    :goto_26
    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    new-instance p1, Lorg/mapsforge/map/layer/hills/HgtCache$1;

    invoke-direct {p1, p0}, Lorg/mapsforge/map/layer/hills/HgtCache$1;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;)V

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->hgtFiles:Lorg/mapsforge/map/layer/hills/LazyFuture;

    return-void
.end method

.method static synthetic access$000(Lorg/mapsforge/map/layer/hills/HgtCache;)Ljava/util/List;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->problems:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$100(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/core/graphics/GraphicFactory;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    return-object p0
.end method

.method static synthetic access$400(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->secondaryLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    return-object p0
.end method

.method static synthetic access$500(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/HgtCache$Lru;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->mainLru:Lorg/mapsforge/map/layer/hills/HgtCache$Lru;

    return-object p0
.end method

.method static synthetic access$600(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/map/layer/hills/LazyFuture;
    .registers 1

    iget-object p0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->hgtFiles:Lorg/mapsforge/map/layer/hills/LazyFuture;

    return-object p0
.end method

.method static mergeSameSized(Lorg/mapsforge/core/graphics/HillshadingBitmap;Lorg/mapsforge/core/graphics/HillshadingBitmap;Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;ILorg/mapsforge/core/graphics/Canvas;)V
    .registers 13

    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->EAST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    const/4 v1, 0x0

    if-ne p2, v0, :cond_27

    invoke-interface {p4, p0}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result p2

    sub-int v3, p2, p3

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result p0

    mul-int/lit8 p2, p3, 0x2

    sub-int v6, p0, p2

    const/4 v7, 0x1

    move-object v2, p4

    move v4, p3

    move v5, p3

    invoke-interface/range {v2 .. v7}, Lorg/mapsforge/core/graphics/GraphicContext;->setClip(IIIIZ)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result p0

    sub-int/2addr p0, p2

    invoke-interface {p4, p1, p0, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V

    goto/16 :goto_8b

    :cond_27
    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->WEST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    if-ne p2, v0, :cond_47

    invoke-interface {p4, p0}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    const/4 v3, 0x0

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result p0

    mul-int/lit8 p2, p3, 0x2

    sub-int v6, p0, p2

    const/4 v7, 0x1

    move-object v2, p4

    move v4, p3

    move v5, p3

    invoke-interface/range {v2 .. v7}, Lorg/mapsforge/core/graphics/GraphicContext;->setClip(IIIIZ)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result p0

    sub-int/2addr p2, p0

    invoke-interface {p4, p1, p2, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V

    goto :goto_8b

    :cond_47
    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->NORTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    if-ne p2, v0, :cond_67

    invoke-interface {p4, p0}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    const/4 v4, 0x0

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result p0

    mul-int/lit8 p2, p3, 0x2

    sub-int v5, p0, p2

    const/4 v7, 0x1

    move-object v2, p4

    move v3, p3

    move v6, p3

    invoke-interface/range {v2 .. v7}, Lorg/mapsforge/core/graphics/GraphicContext;->setClip(IIIIZ)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result p0

    sub-int/2addr p2, p0

    invoke-interface {p4, p1, v1, p2}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V

    goto :goto_8b

    :cond_67
    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->SOUTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    if-ne p2, v0, :cond_8b

    invoke-interface {p4, p0}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result p2

    sub-int v4, p2, p3

    invoke-interface {p0}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result p0

    mul-int/lit8 p2, p3, 0x2

    sub-int v5, p0, p2

    const/4 v7, 0x1

    move-object v2, p4

    move v3, p3

    move v6, p3

    invoke-interface/range {v2 .. v7}, Lorg/mapsforge/core/graphics/GraphicContext;->setClip(IIIIZ)V

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result p0

    sub-int/2addr p0, p2

    invoke-interface {p4, p1, v1, p0}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V

    :cond_8b
    :goto_8b
    return-void
.end method


# virtual methods
.method getHillshadingBitmap(IIDD)Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->hgtFiles:Lorg/mapsforge/map/layer/hills/LazyFuture;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    new-instance v1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    invoke-direct {v1, p1, p2}, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;-><init>(II)V

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    if-nez p1, :cond_17

    const/4 p1, 0x0

    return-object p1

    :cond_17
    invoke-virtual {p1, p3, p4, p5, p6}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->getBitmapFuture(DD)Ljava/util/concurrent/Future;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/HillshadingBitmap;

    return-object p1
.end method

.method indexOnThread()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache;->hgtFiles:Lorg/mapsforge/map/layer/hills/LazyFuture;

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->withRunningThread()Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;

    return-void
.end method
