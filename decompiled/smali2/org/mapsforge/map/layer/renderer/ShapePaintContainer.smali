.class public Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final dy:F

.field final paint:Lorg/mapsforge/core/graphics/Paint;

.field final shapeContainer:Lorg/mapsforge/map/layer/renderer/ShapeContainer;


# direct methods
.method public constructor <init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;-><init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;F)V

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/layer/renderer/ShapeContainer;Lorg/mapsforge/core/graphics/Paint;F)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->shapeContainer:Lorg/mapsforge/map/layer/renderer/ShapeContainer;

    iput-object p2, p0, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->paint:Lorg/mapsforge/core/graphics/Paint;

    iput p3, p0, Lorg/mapsforge/map/layer/renderer/ShapePaintContainer;->dy:F

    return-void
.end method
