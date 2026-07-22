.class public Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/rendertheme/XmlRenderTheme;


# instance fields
.field private final assetName:Ljava/lang/String;

.field private final inputStream:Ljava/io/InputStream;

.field private menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

.field private final relativePathPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;)V
    .registers 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p3, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->assetName:Ljava/lang/String;

    iput-object p2, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->relativePathPrefix:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object p1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_18

    const-string p2, ""

    :cond_18
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object p1

    iput-object p1, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->inputStream:Ljava/io/InputStream;

    iput-object p4, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;

    iget-object v1, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->assetName:Ljava/lang/String;

    iget-object v3, p1, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->assetName:Ljava/lang/String;

    invoke-static {v1, v3}, Lorg/mapsforge/core/util/Utils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_17

    return v2

    :cond_17
    iget-object v1, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->relativePathPrefix:Ljava/lang/String;

    iget-object p1, p1, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->relativePathPrefix:Ljava/lang/String;

    invoke-static {v1, p1}, Lorg/mapsforge/core/util/Utils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_22

    return v2

    :cond_22
    return v0
.end method

.method public getMenuCallback()Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    return-object v0
.end method

.method public getRelativePathPrefix()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->relativePathPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public getRenderThemeAsStream()Ljava/io/InputStream;
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->inputStream:Ljava/io/InputStream;

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->assetName:Ljava/lang/String;

    const/4 v1, 0x0

    if-nez v0, :cond_7

    const/4 v0, 0x0

    goto :goto_b

    :cond_7
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_b
    const/16 v2, 0x1f

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->relativePathPrefix:Ljava/lang/String;

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

    iput-object p1, p0, Lorg/mapsforge/map/android/rendertheme/AssetsRenderTheme;->menuCallback:Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;

    return-void
.end method
