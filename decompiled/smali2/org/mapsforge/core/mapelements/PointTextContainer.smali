.class public abstract Lorg/mapsforge/core/mapelements/PointTextContainer;
.super Lorg/mapsforge/core/mapelements/MapElementContainer;
.source "SourceFile"


# instance fields
.field public final isVisible:Z

.field public final maxTextWidth:I

.field public final paintBack:Lorg/mapsforge/core/graphics/Paint;

.field public final paintFront:Lorg/mapsforge/core/graphics/Paint;

.field public final position:Lorg/mapsforge/core/graphics/Position;

.field public final symbolContainer:Lorg/mapsforge/core/mapelements/SymbolContainer;

.field public final text:Ljava/lang/String;

.field public final textHeight:I

.field public final textWidth:I


# direct methods
.method protected constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;ILjava/lang/String;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/graphics/Paint;Lorg/mapsforge/core/mapelements/SymbolContainer;Lorg/mapsforge/core/graphics/Position;I)V
    .registers 10

    invoke-direct {p0, p1, p2, p3}, Lorg/mapsforge/core/mapelements/MapElementContainer;-><init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;I)V

    iput p9, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->maxTextWidth:I

    iput-object p4, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iput-object p7, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->symbolContainer:Lorg/mapsforge/core/mapelements/SymbolContainer;

    iput-object p5, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintFront:Lorg/mapsforge/core/graphics/Paint;

    iput-object p6, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->paintBack:Lorg/mapsforge/core/graphics/Paint;

    iput-object p8, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->position:Lorg/mapsforge/core/graphics/Position;

    if-eqz p6, :cond_1c

    invoke-interface {p6, p4}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textWidth:I

    invoke-interface {p6, p4}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result p1

    goto :goto_26

    :cond_1c
    invoke-interface {p5, p4}, Lorg/mapsforge/core/graphics/Paint;->getTextWidth(Ljava/lang/String;)I

    move-result p1

    iput p1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textWidth:I

    invoke-interface {p5, p4}, Lorg/mapsforge/core/graphics/Paint;->getTextHeight(Ljava/lang/String;)I

    move-result p1

    :goto_26
    iput p1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->textHeight:I

    invoke-interface {p5}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result p1

    if-eqz p1, :cond_39

    if-eqz p6, :cond_37

    invoke-interface {p6}, Lorg/mapsforge/core/graphics/Paint;->isTransparent()Z

    move-result p1

    if-nez p1, :cond_37

    goto :goto_39

    :cond_37
    const/4 p1, 0x0

    goto :goto_3a

    :cond_39
    :goto_39
    const/4 p1, 0x1

    :goto_3a
    iput-boolean p1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->isVisible:Z

    return-void
.end method


# virtual methods
.method public clashesWith(Lorg/mapsforge/core/mapelements/MapElementContainer;)Z
    .registers 9

    invoke-super {p0, p1}, Lorg/mapsforge/core/mapelements/MapElementContainer;->clashesWith(Lorg/mapsforge/core/mapelements/MapElementContainer;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    instance-of v0, p1, Lorg/mapsforge/core/mapelements/PointTextContainer;

    const/4 v2, 0x0

    if-nez v0, :cond_e

    return v2

    :cond_e
    check-cast p1, Lorg/mapsforge/core/mapelements/PointTextContainer;

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iget-object v3, p1, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_29

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    iget-object p1, p1, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/model/Point;->distance(Lorg/mapsforge/core/model/Point;)D

    move-result-wide v3

    const-wide/high16 v5, 0x4069000000000000L    # 200.0

    cmpg-double p1, v3, v5

    if-gez p1, :cond_29

    return v1

    :cond_29
    return v2
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 4

    invoke-super {p0, p1}, Lorg/mapsforge/core/mapelements/MapElementContainer;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return v1

    :cond_8
    instance-of v0, p1, Lorg/mapsforge/core/mapelements/PointTextContainer;

    if-nez v0, :cond_d

    return v1

    :cond_d
    check-cast p1, Lorg/mapsforge/core/mapelements/PointTextContainer;

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    iget-object p1, p1, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1a

    return v1

    :cond_1a
    const/4 p1, 0x1

    return p1
.end method

.method public hashCode()I
    .registers 3

    invoke-super {p0}, Lorg/mapsforge/core/mapelements/MapElementContainer;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
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

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/PointTextContainer;->text:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
