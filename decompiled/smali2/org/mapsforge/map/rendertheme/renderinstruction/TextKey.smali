.class final Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TEXT_KEYS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final key:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->TEXT_KEYS:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->key:Ljava/lang/String;

    return-void
.end method

.method static getInstance(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;
    .registers 3

    sget-object v0, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->TEXT_KEYS:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    if-nez v1, :cond_12

    new-instance v1, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;

    invoke-direct {v1, p0}, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_12
    return-object v1
.end method


# virtual methods
.method getValue(Ljava/util/List;)Ljava/lang/String;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_23

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/renderinstruction/TextKey;->key:Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/core/model/Tag;

    iget-object v3, v3, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_20

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/core/model/Tag;

    iget-object p1, p1, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    return-object p1

    :cond_20
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_23
    const/4 p1, 0x0

    return-object p1
.end method
