.class public abstract Lorg/mapsforge/core/mapelements/MapElementContainer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lorg/mapsforge/core/mapelements/MapElementContainer;",
        ">;"
    }
.end annotation


# instance fields
.field protected boundary:Lorg/mapsforge/core/model/Rectangle;

.field protected boundaryAbsolute:Lorg/mapsforge/core/model/Rectangle;

.field protected display:Lorg/mapsforge/core/graphics/Display;

.field protected final priority:I

.field protected final xy:Lorg/mapsforge/core/model/Point;


# direct methods
.method protected constructor <init>(Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Display;I)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    iput-object p2, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->display:Lorg/mapsforge/core/graphics/Display;

    iput p3, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    return-void
.end method


# virtual methods
.method public clashesWith(Lorg/mapsforge/core/mapelements/MapElementContainer;)Z
    .registers 4

    sget-object v0, Lorg/mapsforge/core/graphics/Display;->ALWAYS:Lorg/mapsforge/core/graphics/Display;

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->display:Lorg/mapsforge/core/graphics/Display;

    if-eq v0, v1, :cond_18

    iget-object v1, p1, Lorg/mapsforge/core/mapelements/MapElementContainer;->display:Lorg/mapsforge/core/graphics/Display;

    if-ne v0, v1, :cond_b

    goto :goto_18

    :cond_b
    invoke-virtual {p0}, Lorg/mapsforge/core/mapelements/MapElementContainer;->getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;

    move-result-object v0

    invoke-virtual {p1}, Lorg/mapsforge/core/mapelements/MapElementContainer;->getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;

    move-result-object p1

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/model/Rectangle;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result p1

    return p1

    :cond_18
    :goto_18
    const/4 p1, 0x0

    return p1
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 2

    check-cast p1, Lorg/mapsforge/core/mapelements/MapElementContainer;

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/mapelements/MapElementContainer;->compareTo(Lorg/mapsforge/core/mapelements/MapElementContainer;)I

    move-result p1

    return p1
.end method

.method public compareTo(Lorg/mapsforge/core/mapelements/MapElementContainer;)I
    .registers 3

    iget v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    iget p1, p1, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    if-ge v0, p1, :cond_8

    const/4 p1, -0x1

    return p1

    :cond_8
    if-le v0, p1, :cond_c

    const/4 p1, 0x1

    return p1

    :cond_c
    const/4 p1, 0x0

    return p1
.end method

.method public abstract draw(Lorg/mapsforge/core/graphics/Canvas;Lorg/mapsforge/core/model/Point;Lorg/mapsforge/core/graphics/Matrix;Lorg/mapsforge/core/graphics/Filter;)V
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/mapelements/MapElementContainer;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/mapelements/MapElementContainer;

    iget v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    iget v3, p1, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget-object v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    iget-object p1, p1, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v1, p1}, Lorg/mapsforge/core/model/Point;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1e

    return v2

    :cond_1e
    return v0
.end method

.method protected getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundaryAbsolute:Lorg/mapsforge/core/model/Rectangle;

    if-nez v0, :cond_e

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundary:Lorg/mapsforge/core/model/Rectangle;

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0, v1}, Lorg/mapsforge/core/model/Rectangle;->shift(Lorg/mapsforge/core/model/Point;)Lorg/mapsforge/core/model/Rectangle;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundaryAbsolute:Lorg/mapsforge/core/model/Rectangle;

    :cond_e
    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->boundaryAbsolute:Lorg/mapsforge/core/model/Rectangle;

    return-object v0
.end method

.method public getPoint()Lorg/mapsforge/core/model/Point;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    return-object v0
.end method

.method public getPriority()I
    .registers 2

    iget v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    return v0
.end method

.method public hashCode()I
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0}, Lorg/mapsforge/core/model/Point;->hashCode()I

    move-result v0

    const/16 v1, 0xd9

    add-int/2addr v1, v0

    mul-int/lit8 v1, v1, 0x1f

    iget v0, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    add-int/2addr v1, v0

    return v1
.end method

.method public intersects(Lorg/mapsforge/core/model/Rectangle;)Z
    .registers 3

    invoke-virtual {p0}, Lorg/mapsforge/core/mapelements/MapElementContainer;->getBoundaryAbsolute()Lorg/mapsforge/core/model/Rectangle;

    move-result-object v0

    invoke-virtual {v0, p1}, Lorg/mapsforge/core/model/Rectangle;->intersects(Lorg/mapsforge/core/model/Rectangle;)Z

    move-result p1

    return p1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "xy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->xy:Lorg/mapsforge/core/model/Point;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", priority="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lorg/mapsforge/core/mapelements/MapElementContainer;->priority:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
