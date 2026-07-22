.class public abstract Lorg/mapsforge/map/scalebar/MapScaleBar;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;,
        Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;
    }
.end annotation


# static fields
.field private static final DEFAULT_SCALE_BAR_POSITION:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field private static final LATITUDE_REDRAW_THRESHOLD:D = 0.2


# instance fields
.field protected final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field protected distanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

.field protected final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field protected final mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

.field protected final mapScaleCanvas:Lorg/mapsforge/core/graphics/Canvas;

.field private final mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

.field private final mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

.field private marginHorizontal:I

.field private marginVertical:I

.field protected prevMapPosition:Lorg/mapsforge/core/model/MapPosition;

.field protected redrawNeeded:Z

.field protected final scale:F

.field protected scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field private visible:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->BOTTOM_LEFT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    sput-object v0, Lorg/mapsforge/map/scalebar/MapScaleBar;->DEFAULT_SCALE_BAR_POSITION:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    return-void
.end method

.method public constructor <init>(Lorg/mapsforge/map/model/IMapViewPosition;Lorg/mapsforge/map/model/MapViewDimension;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/core/graphics/GraphicFactory;IIF)V
    .registers 8

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    iput-object p2, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    iput-object p3, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    iput-object p4, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-interface {p4, p5, p6}, Lorg/mapsforge/core/graphics/GraphicFactory;->createBitmap(II)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    iput p7, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    sget-object p2, Lorg/mapsforge/map/scalebar/MapScaleBar;->DEFAULT_SCALE_BAR_POSITION:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    iput-object p2, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-interface {p4}, Lorg/mapsforge/core/graphics/GraphicFactory;->createCanvas()Lorg/mapsforge/core/graphics/Canvas;

    move-result-object p2

    iput-object p2, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {p2, p1}, Lorg/mapsforge/core/graphics/Canvas;->setBitmap(Lorg/mapsforge/core/graphics/Bitmap;)V

    sget-object p1, Lorg/mapsforge/map/scalebar/MetricUnitAdapter;->INSTANCE:Lorg/mapsforge/map/scalebar/MetricUnitAdapter;

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->distanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->visible:Z

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    return-void
.end method

.method private calculatePositionLeft(III)I
    .registers 6

    sget-object v0, Lorg/mapsforge/map/scalebar/MapScaleBar$1;->$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition:[I

    iget-object v1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_34

    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "unknown horizontal position: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p3, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_26
    sub-int/2addr p2, p1

    sub-int/2addr p2, p3

    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginHorizontal:I

    sub-int/2addr p2, p1

    return p2

    :pswitch_2c
    sub-int/2addr p2, p1

    sub-int/2addr p2, p3

    div-int/lit8 p2, p2, 0x2

    return p2

    :pswitch_31
    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginHorizontal:I

    return p1

    :pswitch_data_34
    .packed-switch 0x1
        :pswitch_31
        :pswitch_31
        :pswitch_2c
        :pswitch_2c
        :pswitch_26
        :pswitch_26
    .end packed-switch
.end method

.method private calculatePositionTop(III)I
    .registers 6

    sget-object v0, Lorg/mapsforge/map/scalebar/MapScaleBar$1;->$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition:[I

    iget-object v1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_30

    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "unknown vertical position: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p3, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_26
    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginVertical:I

    return p1

    :pswitch_29
    sub-int/2addr p2, p1

    sub-int/2addr p2, p3

    iget p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginVertical:I

    sub-int/2addr p2, p1

    return p2

    nop

    :pswitch_data_30
    .packed-switch 0x1
        :pswitch_29
        :pswitch_26
        :pswitch_29
        :pswitch_26
        :pswitch_29
        :pswitch_26
    .end packed-switch
.end method


# virtual methods
.method protected calculateScaleBarLengthAndValue()Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->distanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->calculateScaleBarLengthAndValue(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;

    move-result-object v0

    return-object v0
.end method

.method protected calculateScaleBarLengthAndValue(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;
    .registers 12

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->prevMapPosition:Lorg/mapsforge/core/model/MapPosition;

    iget-object v1, v0, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v1, v1, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-byte v0, v0, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    iget-object v3, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    invoke-virtual {v3}, Lorg/mapsforge/map/model/DisplayModel;->getTileSize()I

    move-result v3

    invoke-static {v0, v3}, Lorg/mapsforge/core/util/MercatorProjection;->getMapSize(BI)J

    move-result-wide v3

    invoke-static {v1, v2, v3, v4}, Lorg/mapsforge/core/util/MercatorProjection;->calculateGroundResolution(DJ)D

    move-result-wide v0

    invoke-interface {p1}, Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;->getMeterRatio()D

    move-result-wide v2

    div-double/2addr v0, v2

    invoke-interface {p1}, Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;->getScaleBarValues()[I

    move-result-object p1

    array-length v2, p1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_29
    if-ge v3, v2, :cond_47

    aget v5, p1, v3

    int-to-double v6, v5

    div-double/2addr v6, v0

    double-to-int v4, v6

    int-to-float v6, v4

    iget-object v7, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v7}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v7

    int-to-float v7, v7

    const/high16 v8, 0x41200000    # 10.0f

    iget v9, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scale:F

    mul-float v9, v9, v8

    sub-float/2addr v7, v9

    cmpg-float v6, v6, v7

    if-gez v6, :cond_44

    goto :goto_47

    :cond_44
    add-int/lit8 v3, v3, 0x1

    goto :goto_29

    :cond_47
    :goto_47
    new-instance p1, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;

    invoke-direct {p1, v4, v5}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarLengthAndValue;-><init>(II)V

    return-object p1
.end method

.method public destroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-interface {v0}, Lorg/mapsforge/core/graphics/Canvas;->destroy()V

    return-void
.end method

.method public draw(Lorg/mapsforge/core/graphics/GraphicContext;)V
    .registers 6

    iget-boolean v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->visible:Z

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/MapViewDimension;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v0

    if-nez v0, :cond_e

    return-void

    :cond_e
    invoke-virtual {p0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->isRedrawNecessary()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_1c

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->redraw(Lorg/mapsforge/core/graphics/Canvas;)V

    iput-boolean v1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    :cond_1c
    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v0}, Lorg/mapsforge/map/model/MapViewDimension;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v0

    iget v0, v0, Lorg/mapsforge/core/model/Dimension;->width:I

    iget-object v2, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v2}, Lorg/mapsforge/core/graphics/Bitmap;->getWidth()I

    move-result v2

    invoke-direct {p0, v1, v0, v2}, Lorg/mapsforge/map/scalebar/MapScaleBar;->calculatePositionLeft(III)I

    move-result v0

    iget-object v2, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewDimension:Lorg/mapsforge/map/model/MapViewDimension;

    invoke-virtual {v2}, Lorg/mapsforge/map/model/MapViewDimension;->getDimension()Lorg/mapsforge/core/model/Dimension;

    move-result-object v2

    iget v2, v2, Lorg/mapsforge/core/model/Dimension;->height:I

    iget-object v3, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {v3}, Lorg/mapsforge/core/graphics/Bitmap;->getHeight()I

    move-result v3

    invoke-direct {p0, v1, v2, v3}, Lorg/mapsforge/map/scalebar/MapScaleBar;->calculatePositionTop(III)I

    move-result v1

    iget-object v2, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleBitmap:Lorg/mapsforge/core/graphics/Bitmap;

    invoke-interface {p1, v2, v0, v1}, Lorg/mapsforge/core/graphics/GraphicContext;->drawBitmap(Lorg/mapsforge/core/graphics/Bitmap;II)V

    return-void
.end method

.method public drawScaleBar()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapScaleCanvas:Lorg/mapsforge/core/graphics/Canvas;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/scalebar/MapScaleBar;->draw(Lorg/mapsforge/core/graphics/GraphicContext;)V

    return-void
.end method

.method public getDistanceUnitAdapter()Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->distanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    return-object v0
.end method

.method public getMarginHorizontal()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginHorizontal:I

    return v0
.end method

.method public getMarginVertical()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginVertical:I

    return v0
.end method

.method public getScaleBarPosition()Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    return-object v0
.end method

.method protected isRedrawNecessary()Z
    .registers 7

    iget-boolean v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    const/4 v1, 0x1

    if-nez v0, :cond_31

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->prevMapPosition:Lorg/mapsforge/core/model/MapPosition;

    if-nez v0, :cond_a

    goto :goto_31

    :cond_a
    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-interface {v0}, Lorg/mapsforge/map/model/IMapViewPosition;->getMapPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v0

    iget-byte v2, v0, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    iget-object v3, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->prevMapPosition:Lorg/mapsforge/core/model/MapPosition;

    iget-byte v4, v3, Lorg/mapsforge/core/model/MapPosition;->zoomLevel:B

    if-eq v2, v4, :cond_19

    return v1

    :cond_19
    iget-object v0, v0, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v4, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    iget-object v0, v3, Lorg/mapsforge/core/model/MapPosition;->latLong:Lorg/mapsforge/core/model/LatLong;

    iget-wide v2, v0, Lorg/mapsforge/core/model/LatLong;->latitude:D

    sub-double/2addr v4, v2

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(D)D

    move-result-wide v2

    const-wide v4, 0x3fc999999999999aL    # 0.2

    cmpl-double v0, v2, v4

    if-lez v0, :cond_30

    goto :goto_31

    :cond_30
    const/4 v1, 0x0

    :cond_31
    :goto_31
    return v1
.end method

.method public isVisible()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->visible:Z

    return v0
.end method

.method protected abstract redraw(Lorg/mapsforge/core/graphics/Canvas;)V
.end method

.method public redrawScaleBar()V
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    return-void
.end method

.method public setDistanceUnitAdapter(Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;)V
    .registers 3

    if-eqz p1, :cond_8

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->distanceUnitAdapter:Lorg/mapsforge/map/scalebar/DistanceUnitAdapter;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    return-void

    :cond_8
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "adapter must not be null"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setMarginHorizontal(I)V
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginHorizontal:I

    if-eq v0, p1, :cond_9

    iput p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginHorizontal:I

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    :cond_9
    return-void
.end method

.method public setMarginVertical(I)V
    .registers 3

    iget v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginVertical:I

    if-eq v0, p1, :cond_9

    iput p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->marginVertical:I

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    :cond_9
    return-void
.end method

.method public setScaleBarPosition(Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    if-eq v0, p1, :cond_9

    iput-object p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->scaleBarPosition:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->redrawNeeded:Z

    :cond_9
    return-void
.end method

.method public setVisible(Z)V
    .registers 2

    iput-boolean p1, p0, Lorg/mapsforge/map/scalebar/MapScaleBar;->visible:Z

    return-void
.end method
