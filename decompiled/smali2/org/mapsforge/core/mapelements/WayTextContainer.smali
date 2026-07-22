.class public Lorg/mapsforge/core/mapelements/WayTextContainer;
.super Lorg/mapsforge/core/mapelements/MapElementContainer;
.source "SourceFile"


# instance fields
.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final lineString:Lorg/mapsforge/core/model/LineString;

.field private final paintBack:Lorg/mapsforge/core/graphics/Paint;

.field private final paintFront:Lorg/mapsforge/core/graphics/Paint;

.field private final text:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/LineString;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;D)V
    .registers 13

    iget-object v1, p2, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/model/LineSegment;

    iget-object v1, v1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    invoke-direct {p0, v1, p3, p4}, Lorg/mapsforge/core/mapelements/MapElementContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;I)V

    iput-object p1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p2, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iput-object p5, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->text:Ljava/lang/String;

    iput-object p6, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    iput-object p7, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    const/4 v1, 0x0

    iput-object v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    invoke-virtual {p2}, Lorg/mapsforge/core/model/LineString;->getBounds()Lorg/mapsforge/core/model/Rectangle;

    move-result-object v0

    const-wide/high16 v1, 0x4000000000000000L    # 2.0

    div-double v1, p8, v1

    move-object p1, v0

    move-wide p2, v1

    move-wide p4, v1

    move-wide p6, v1

    move-wide p8, v1

    invoke-virtual/range {p1 .. p9}, Lorg/mapsforge/core/model/Rectangle;->enlarge(DDDD)Lorg/mapsforge/core/model/Rectangle;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundaryAbsolute:Lorg/mapsforge/core/model/Rectangle;

    return-void
.end method

.method private generatePath(Lorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/graphics/Path;
    .registers 10

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/model/LineSegment;

    iget-object v2, v0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v2, v2, Lorg/mapsforge/core/model/Point;->x:D

    iget-object v4, v0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v4, v4, Lorg/mapsforge/core/model/Point;->x:D

    const/4 v6, 0x1

    cmpg-double v7, v2, v4

    if-gtz v7, :cond_1a

    const/4 v2, 0x1

    goto :goto_1b

    :cond_1a
    const/4 v2, 0x0

    :goto_1b
    iget-object v3, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {v3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createPath()Lorg/mapsforge/core/graphics/Path;

    move-result-object v3

    if-nez v2, :cond_64

    iget-object v0, v0, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v4, p1, Lorg/mapsforge/core/model/Point;->x:D

    neg-double v4, v4

    iget-wide v6, p1, Lorg/mapsforge/core/model/Point;->y:D

    neg-double v6, v6

    invoke-virtual {v0, v4, v5, v6, v7}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->x:D

    double-to-float v2, v4

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->y:D

    double-to-float v0, v4

    invoke-interface {v3, v2, v0}, Lorg/mapsforge/core/graphics/Path;->moveTo(FF)V

    :goto_38
    iget-object v0, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_b5

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/model/LineSegment;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v4, p1, Lorg/mapsforge/core/model/Point;->x:D

    neg-double v4, v4

    iget-wide v6, p1, Lorg/mapsforge/core/model/Point;->y:D

    neg-double v6, v6

    invoke-virtual {v0, v4, v5, v6, v7}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->x:D

    double-to-float v2, v4

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->y:D

    double-to-float v0, v4

    invoke-interface {v3, v2, v0}, Lorg/mapsforge/core/graphics/Path;->lineTo(FF)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_38

    :cond_64
    iget-object v0, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    sub-int/2addr v1, v6

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/core/model/LineSegment;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineSegment;->end:Lorg/mapsforge/core/model/Point;

    iget-wide v1, p1, Lorg/mapsforge/core/model/Point;->x:D

    neg-double v1, v1

    iget-wide v4, p1, Lorg/mapsforge/core/model/Point;->y:D

    neg-double v4, v4

    invoke-virtual {v0, v1, v2, v4, v5}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v0

    iget-wide v1, v0, Lorg/mapsforge/core/model/Point;->x:D

    double-to-float v1, v1

    iget-wide v4, v0, Lorg/mapsforge/core/model/Point;->y:D

    double-to-float v0, v4

    invoke-interface {v3, v1, v0}, Lorg/mapsforge/core/graphics/Path;->moveTo(FF)V

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iget-object v0, v0, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    sub-int/2addr v0, v6

    :goto_91
    if-ltz v0, :cond_b5

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->lineString:Lorg/mapsforge/core/model/LineString;

    iget-object v1, v1, Lorg/mapsforge/core/model/LineString;->segments:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/core/model/LineSegment;

    iget-object v1, v1, Lorg/mapsforge/core/model/LineSegment;->start:Lorg/mapsforge/core/model/Point;

    iget-wide v4, p1, Lorg/mapsforge/core/model/Point;->x:D

    neg-double v4, v4

    iget-wide v6, p1, Lorg/mapsforge/core/model/Point;->y:D

    neg-double v6, v6

    invoke-virtual {v1, v4, v5, v6, v7}, Lorg/mapsforge/core/model/Point;->offset(DD)Lorg/mapsforge/core/model/Point;

    move-result-object v1

    iget-wide v4, v1, Lorg/mapsforge/core/model/Point;->x:D

    double-to-float v2, v4

    iget-wide v4, v1, Lorg/mapsforge/core/model/Point;->y:D

    double-to-float v1, v4

    invoke-interface {v3, v2, v1}, Lorg/mapsforge/core/graphics/Path;->lineTo(FF)V

    add-int/lit8 v0, v0, -0x1

    goto :goto_91

    :cond_b5
    return-object v3
.end method


# virtual methods
.method public draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Matrix;Lorg/mapsforge/core/graphics/Filter;)V
    .registers 8

    invoke-direct {p0, p2}, Lorg/mapsforge/core/mapelements/WayTextContainer;->generatePath(Lorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/graphics/Path;

    move-result-object p2

    iget-object p3, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    if-eqz p3, :cond_27

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/Paint;->getColor()I

    move-result p3

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, v0, :cond_19

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p3, p4}, Lorg/mapsforge/core/graphics/GraphicUtils;->filterColor(ILorg/mapsforge/core/graphics/Filter;)I

    move-result v2

    invoke-interface {v1, v2}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_19
    iget-object v1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->text:Ljava/lang/String;

    iget-object v2, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v1, p2, v2}, Lorg/mapsforge/core/graphics/GraphicContext;->drawPathText(Ljava/lang/String;Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V

    if-eq p4, v0, :cond_27

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {v0, p3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_27
    iget-object p3, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p3}, Lorg/mapsforge/core/graphics/Paint;->getColor()I

    move-result p3

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    if-eq p4, v0, :cond_3a

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-static {p3, p4}, Lorg/mapsforge/core/graphics/GraphicUtils;->filterColor(ILorg/mapsforge/core/graphics/Filter;)I

    move-result v2

    invoke-interface {v1, v2}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_3a
    iget-object v1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->text:Ljava/lang/String;

    iget-object v2, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, v1, p2, v2}, Lorg/mapsforge/core/graphics/GraphicContext;->drawPathText(Ljava/lang/String;Lorg/mapsforge/core/graphics/Path;Lorg/mapsforge/core/graphics/Paint;)V

    if-eq p4, v0, :cond_48

    iget-object p1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    invoke-interface {p1, p3}, Lorg/mapsforge/core/graphics/Paint;->setColor(I)V

    :cond_48
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Lorg/mapsforge/core/mapelements/MapElementContainer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", text="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/WayTextContainer;->text:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
