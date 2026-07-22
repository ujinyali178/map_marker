.class Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;
.super Lorg/mapsforge/map/layer/hills/LazyFuture;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/layer/hills/HgtCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LoadUnmergedFuture"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/map/layer/hills/LazyFuture<",
        "Lorg/mapsforge/core/graphics/HillshadingBitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private final hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

.field final synthetic this$0:Lorg/mapsforge/map/layer/hills/HgtCache;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/hills/HgtCache;Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;)V
    .registers 3

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LazyFuture;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    return-void
.end method


# virtual methods
.method public bridge synthetic calculate()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->calculate()Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object v0

    return-object v0
.end method

.method public calculate()Lorg/mapsforge/core/graphics/HillshadingBitmap;
    .registers 9

    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    iget-object v1, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->algorithm:Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    iget-boolean v0, v0, Lorg/mapsforge/map/layer/hills/HgtCache;->interpolatorOverlap:Z

    invoke-interface {v1, v2, v0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;->transformToByteBuffer(Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;I)Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->fillPadding()V

    iget-object v1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->graphicsFactory:Lorg/mapsforge/core/graphics/GraphicFactory;
    invoke-static {v1}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$100(Lorg/mapsforge/map/layer/hills/HgtCache;)Lorg/mapsforge/core/graphics/GraphicFactory;

    move-result-object v2

    iget v3, v0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->width:I

    iget v4, v0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->height:I

    iget-object v5, v0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->bytes:[B

    iget v6, v0, Lorg/mapsforge/map/layer/hills/ShadingAlgorithm$RawShadingResult;->padding:I

    iget-object v7, p0, Lorg/mapsforge/map/layer/hills/HgtCache$LoadUnmergedFuture;->hgtFileInfo:Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    invoke-interface/range {v2 .. v7}, Lorg/mapsforge/core/graphics/GraphicFactory;->createMonoBitmap(II[BILorg/mapsforge/core/model/BoundingBox;)Lorg/mapsforge/core/graphics/HillshadingBitmap;

    move-result-object v0

    return-object v0
.end method
