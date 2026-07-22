.class Lorg/mapsforge/map/layer/cache/BitmapLRUCache;
.super Lorg/mapsforge/core/util/WorkingSetCache;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/core/util/WorkingSetCache<",
        "Lorg/mapsforge/map/layer/queue/Job;",
        "Lorg/mapsforge/core/graphics/TileBitmap;",
        ">;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>(I)V
    .registers 2

    invoke-direct {p0, p1}, Lorg/mapsforge/core/util/WorkingSetCache;-><init>(I)V

    return-void
.end method


# virtual methods
.method protected removeEldestEntry(Ljava/util/Map$Entry;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry<",
            "Lorg/mapsforge/map/layer/queue/Job;",
            "Lorg/mapsforge/core/graphics/TileBitmap;",
            ">;)Z"
        }
    .end annotation

    invoke-virtual {p0}, Ljava/util/AbstractMap;->size()I

    move-result v0

    iget v1, p0, Lorg/mapsforge/core/util/LRUCache;->capacity:I

    if-le v0, v1, :cond_15

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/graphics/TileBitmap;

    if-eqz p1, :cond_13

    invoke-interface {p1}, Lorg/mapsforge/core/graphics/Bitmap;->decrementRefCount()V

    :cond_13
    const/4 p1, 0x1

    return p1

    :cond_15
    const/4 p1, 0x0

    return p1
.end method
