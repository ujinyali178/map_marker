.class public Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final categories:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final defaultLanguage:Ljava/lang/String;

.field private final enabled:Z

.field private final id:Ljava/lang/String;

.field private final overlays:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;",
            ">;"
        }
    .end annotation
.end field

.field private final titles:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final visible:Z


# direct methods
.method constructor <init>(Ljava/lang/String;ZZLjava/lang/String;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->id:Ljava/lang/String;

    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->titles:Ljava/util/Map;

    new-instance p1, Ljava/util/LinkedHashSet;

    invoke-direct {p1}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->categories:Ljava/util/Set;

    iput-boolean p2, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->visible:Z

    iput-object p4, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->defaultLanguage:Ljava/lang/String;

    iput-boolean p3, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->enabled:Z

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->overlays:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public addCategory(Ljava/lang/String;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->categories:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addOverlay(Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->overlays:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addTranslation(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->titles:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public getCategories()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->categories:Ljava/util/Set;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getOverlays()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->overlays:Ljava/util/List;

    return-object v0
.end method

.method public getTitle(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->titles:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    if-nez p1, :cond_14

    iget-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->titles:Ljava/util/Map;

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->defaultLanguage:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    :cond_14
    return-object p1
.end method

.method public getTitles()Ljava/util/Map;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->titles:Ljava/util/Map;

    return-object v0
.end method

.method public isEnabled()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->enabled:Z

    return v0
.end method

.method public isVisible()Z
    .registers 2

    iget-boolean v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;->visible:Z

    return v0
.end method
