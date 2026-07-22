.class public Lorg/mapsforge/map/datastore/MapReadResult;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public isWater:Z

.field public pointOfInterests:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/PointOfInterest;",
            ">;"
        }
    .end annotation
.end field

.field public ways:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/Way;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public add(Lorg/mapsforge/map/datastore/MapReadResult;Z)V
    .registers 5

    if-eqz p2, :cond_42

    iget-object p2, p1, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :cond_8
    :goto_8
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_22

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/datastore/PointOfInterest;

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_8

    iget-object v1, p0, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_8

    :cond_22
    iget-object p1, p1, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_28
    :goto_28
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_50

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lorg/mapsforge/map/datastore/Way;

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_28

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_28

    :cond_42
    iget-object p2, p0, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    iget-object v0, p1, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    invoke-interface {p2, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iget-object p2, p0, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    iget-object p1, p1, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    invoke-interface {p2, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :cond_50
    return-void
.end method

.method public add(Lorg/mapsforge/map/datastore/PoiWayBundle;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MapReadResult;->pointOfInterests:Ljava/util/List;

    iget-object v1, p1, Lorg/mapsforge/map/datastore/PoiWayBundle;->pois:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iget-object v0, p0, Lorg/mapsforge/map/datastore/MapReadResult;->ways:Ljava/util/List;

    iget-object p1, p1, Lorg/mapsforge/map/datastore/PoiWayBundle;->ways:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    return-void
.end method
