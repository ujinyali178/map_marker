.class public Lorg/mapsforge/map/android/util/ExternalRenderThemeUsingJarResources;
.super Lorg/mapsforge/map/rendertheme/ExternalRenderTheme;
.source "SourceFile"


# direct methods
.method public constructor <init>(Ljava/io/File;)V
    .registers 2

    invoke-direct {p0, p1}, Lorg/mapsforge/map/rendertheme/ExternalRenderTheme;-><init>(Ljava/io/File;)V

    return-void
.end method


# virtual methods
.method public getRelativePathPrefix()Ljava/lang/String;
    .registers 2

    const-string v0, "/assets/"

    return-object v0
.end method
