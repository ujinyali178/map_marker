.class final Lorg/mapsforge/map/layer/queue/QueueItemComparator;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator<",
        "Lorg/mapsforge/map/layer/queue/QueueItem<",
        "*>;>;",
        "Ljava/io/Serializable;"
    }
.end annotation


# static fields
.field static final INSTANCE:Lorg/mapsforge/map/layer/queue/QueueItemComparator;

.field private static final serialVersionUID:J = 0x1L


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/layer/queue/QueueItemComparator;

    invoke-direct {v0}, Lorg/mapsforge/map/layer/queue/QueueItemComparator;-><init>()V

    sput-object v0, Lorg/mapsforge/map/layer/queue/QueueItemComparator;->INSTANCE:Lorg/mapsforge/map/layer/queue/QueueItemComparator;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .registers 3

    check-cast p1, Lorg/mapsforge/map/layer/queue/QueueItem;

    check-cast p2, Lorg/mapsforge/map/layer/queue/QueueItem;

    invoke-virtual {p0, p1, p2}, Lorg/mapsforge/map/layer/queue/QueueItemComparator;->compare(Lorg/mapsforge/map/layer/queue/QueueItem;Lorg/mapsforge/map/layer/queue/QueueItem;)I

    move-result p1

    return p1
.end method

.method public compare(Lorg/mapsforge/map/layer/queue/QueueItem;Lorg/mapsforge/map/layer/queue/QueueItem;)I
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/layer/queue/QueueItem<",
            "*>;",
            "Lorg/mapsforge/map/layer/queue/QueueItem<",
            "*>;)I"
        }
    .end annotation

    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/QueueItem;->getPriority()D

    move-result-wide v0

    invoke-virtual {p2}, Lorg/mapsforge/map/layer/queue/QueueItem;->getPriority()D

    move-result-wide v2

    cmpg-double v4, v0, v2

    if-gez v4, :cond_e

    const/4 p1, -0x1

    return p1

    :cond_e
    invoke-virtual {p1}, Lorg/mapsforge/map/layer/queue/QueueItem;->getPriority()D

    move-result-wide v0

    invoke-virtual {p2}, Lorg/mapsforge/map/layer/queue/QueueItem;->getPriority()D

    move-result-wide p1

    cmpl-double v2, v0, p1

    if-lez v2, :cond_1c

    const/4 p1, 0x1

    return p1

    :cond_1c
    const/4 p1, 0x0

    return p1
.end method
