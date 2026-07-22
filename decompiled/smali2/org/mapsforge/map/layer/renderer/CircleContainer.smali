.class Lorg/mapsforge/map/layer/renderer/CircleContainer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/layer/renderer/ShapeContainer;


# instance fields
.field final point:Lorg/mapsforge/core/model/Point;

.field final radius:F


# direct methods
.method constructor <init>(Lorg/mapsforge/core/model/Point;F)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/layer/renderer/CircleContainer;->point:Lorg/mapsforge/core/model/Point;

    iput p2, p0, Lorg/mapsforge/map/layer/renderer/CircleContainer;->radius:F

    return-void
.end method


# virtual methods
.method public getShapeType()Lorg/mapsforge/map/layer/renderer/ShapeType;
    .registers 2

    sget-object v0, Lorg/mapsforge/map/layer/renderer/ShapeType;->CIRCLE:Lorg/mapsforge/map/layer/renderer/ShapeType;

    return-object v0
.end method
