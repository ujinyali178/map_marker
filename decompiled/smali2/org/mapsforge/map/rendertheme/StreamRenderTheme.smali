.class public Lorg/mapsforge/map/rendertheme/StreamRenderTheme;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/rendertheme/XmlRenderTheme;


# instance fields
.field private final inputStream:Ljava/io/InputStream;

.field private menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

.field private final relativePathPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/io/InputStream;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;-><init>(Ljava/lang/String;Ljava/io/InputStream;Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/io/InputStream;Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->relativePathPrefix:Ljava/lang/String;

    iput-object p2, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->inputStream:Ljava/io/InputStream;

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->inputStream:Ljava/io/InputStream;

    iget-object v3, p1, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->inputStream:Ljava/io/InputStream;

    if-eq v1, v3, :cond_13

    return v2

    :cond_13
    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->relativePathPrefix:Ljava/lang/String;

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->relativePathPrefix:Ljava/lang/String;

    invoke-static {v1, p1}, Lorg/mapsforge/core/util/Utils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1e

    return v2

    :cond_1e
    return v0
.end method

.method public getMenuCallback()Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    return-object v0
.end method

.method public getRelativePathPrefix()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->relativePathPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public getRenderThemeAsStream()Ljava/io/InputStream;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->inputStream:Ljava/io/InputStream;

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->inputStream:Ljava/io/InputStream;

    const/4 v1, 0x0

    if-nez v0, :cond_7

    const/4 v0, 0x0

    goto :goto_b

    :cond_7
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_b
    const/16 v2, 0x1f

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->relativePathPrefix:Ljava/lang/String;

    if-nez v2, :cond_15

    goto :goto_19

    :cond_15
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_19
    add-int/2addr v0, v1

    return v0
.end method

.method public setMenuCallback(Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/StreamRenderTheme;->menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    return-void
.end method
