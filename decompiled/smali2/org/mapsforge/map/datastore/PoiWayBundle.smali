.class public Lorg/mapsforge/map/datastore/PoiWayBundle;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final pois:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/PointOfInterest;",
            ">;"
        }
    .end annotation
.end field

.field final ways:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/Way;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/util/List;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/PointOfInterest;",
            ">;",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/datastore/Way;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/datastore/PoiWayBundle;->pois:Ljava/util/List;

    iput-object p2, p0, Lorg/mapsforge/map/datastore/PoiWayBundle;->ways:Ljava/util/List;

    return-void
.end method
