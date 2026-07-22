.class Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RenderThemeCallable"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable<",
        "Lorg/mapsforge/map/rendertheme/rule/RenderTheme;",
        ">;"
    }
.end annotation


# instance fields
.field private final displayModel:Lorg/mapsforge/map/model/DisplayModel;

.field private final graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;


# direct methods
.method public constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;Lorg/mapsforge/map/model/DisplayModel;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->call()Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    move-result-object v0

    return-object v0
.end method

.method public call()Lorg/mapsforge/map/rendertheme/rule/RenderTheme;
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->xmlRenderTheme:Lorg/mapsforge/map/rendertheme/XmlRenderTheme;

    if-eqz v0, :cond_22

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->displayModel:Lorg/mapsforge/map/model/DisplayModel;

    if-nez v1, :cond_9

    goto :goto_22

    :cond_9
    :try_start_9
    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeFuture$RenderThemeCallable;->graphicFactory:Lorg/mapsforge/core/graphics/GraphicFactory;

    invoke-static {v2, v1, v0}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;->getRenderTheme(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/model/DisplayModel;Lorg/mapsforge/map/rendertheme/XmlRenderTheme;)Lorg/mapsforge/map/rendertheme/rule/RenderTheme;

    move-result-object v0
    :try_end_f
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_9 .. :try_end_f} :catch_19
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_f} :catch_10

    return-object v0

    :catch_10
    move-exception v0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "File error for XML rendertheme"

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    :catch_19
    move-exception v0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parse error for XML rendertheme"

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    :cond_22
    :goto_22
    const/4 v0, 0x0

    return-object v0
.end method
