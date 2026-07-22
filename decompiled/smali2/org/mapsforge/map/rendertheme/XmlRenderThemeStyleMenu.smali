.class public Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final defaultLanguage:Ljava/lang/String;

.field private final defaultValue:Ljava/lang/String;

.field private final id:Ljava/lang/String;

.field private final layers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->defaultLanguage:Ljava/lang/String;

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->defaultValue:Ljava/lang/String;

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->id:Ljava/lang/String;

    new-instance p1, Ljava/util/LinkedHashMap;

    invoke-direct {p1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->layers:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public createLayer(Ljava/lang/String;ZZ)Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;
    .registers 6

    new-instance v0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->defaultLanguage:Ljava/lang/String;

    invoke-direct {v0, p1, p2, p3, v1}, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;-><init>(Ljava/lang/String;ZZLjava/lang/String;)V

    iget-object p2, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->layers:Ljava/util/Map;

    invoke-interface {p2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v0
.end method

.method public getDefaultLanguage()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->defaultLanguage:Ljava/lang/String;

    return-object v0
.end method

.method public getDefaultValue()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->defaultValue:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLayer(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->layers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;

    return-object p1
.end method

.method public getLayers()Ljava/util/Map;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleLayer;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;->layers:Ljava/util/Map;

    return-object v0
.end method
