.class public abstract Lorg/mapsforge/map/android/util/MapViewerTemplate;
.super Landroid/app/Activity;
.source "SourceFile"


# instance fields
.field protected mapView:Lorg/mapsforge/map/android/view/MapView;

.field protected preferencesFacade:Lorg/mapsforge/map/model/common/PreferencesFacade;

.field protected renderThemeStyleMenu:Lorg/mapsforge/map/rendertheme/XmlRenderThemeStyleMenu;

.field protected tileCaches:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lorg/mapsforge/map/layer/cache/TileCache;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->tileCaches:Ljava/util/List;

    return-void
.end method


# virtual methods
.method protected checkPermissionsAndCreateLayersAndControls()V
    .registers 1

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->createLayers()V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->createControls()V

    return-void
.end method

.method protected createControls()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v0, v0, Lorg/mapsforge/map/model/Model;->mapViewPosition:Lorg/mapsforge/map/model/IMapViewPosition;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->initializePosition(Lorg/mapsforge/map/model/IMapViewPosition;)Lorg/mapsforge/map/model/IMapViewPosition;

    return-void
.end method

.method protected abstract createLayers()V
.end method

.method protected createMapViews()V
    .registers 3

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getMapView()Lorg/mapsforge/map/android/view/MapView;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->preferencesFacade:Lorg/mapsforge/map/model/common/PreferencesFacade;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/model/Model;->init(Lorg/mapsforge/map/model/common/PreferencesFacade;)V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getMapScaleBar()Lorg/mapsforge/map/scalebar/MapScaleBar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/scalebar/MapScaleBar;->setVisible(Z)V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->hasZoomControls()Z

    move-result v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/android/view/MapView;->setBuiltInZoomControls(Z)V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getMapZoomControls()Lorg/mapsforge/map/android/input/MapZoomControls;

    move-result-object v0

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->isZoomControlsAutoHide()Z

    move-result v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setAutoHide(Z)V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getMapZoomControls()Lorg/mapsforge/map/android/input/MapZoomControls;

    move-result-object v0

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getZoomLevelMin()B

    move-result v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomLevelMin(B)V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getMapZoomControls()Lorg/mapsforge/map/android/input/MapZoomControls;

    move-result-object v0

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getZoomLevelMax()B

    move-result v1

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/android/input/MapZoomControls;->setZoomLevelMax(B)V

    return-void
.end method

.method protected createSharedPreferences()V
    .registers 4

    new-instance v0, Lorg/mapsforge/map/android/util/AndroidPreferences;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getPersistableId()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/mapsforge/map/android/util/AndroidPreferences;-><init>(Landroid/content/SharedPreferences;)V

    iput-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->preferencesFacade:Lorg/mapsforge/map/model/common/PreferencesFacade;

    return-void
.end method

.method protected abstract createTileCaches()V
.end method

.method protected getDefaultInitialPosition()Lorg/mapsforge/core/model/MapPosition;
    .registers 5

    new-instance v0, Lorg/mapsforge/core/model/MapPosition;

    new-instance v1, Lorg/mapsforge/core/model/LatLong;

    const-wide/16 v2, 0x0

    invoke-direct {v1, v2, v3, v2, v3}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getZoomLevelDefault()B

    move-result v2

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/model/MapPosition;-><init>(Lorg/mapsforge/core/model/LatLong;B)V

    return-object v0
.end method

.method protected getHillsRenderConfig()Lorg/mapsforge/map/layer/hills/HillsRenderConfig;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method protected getInitialPosition()Lorg/mapsforge/core/model/MapPosition;
    .registers 4

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getMapFile()Lorg/mapsforge/map/datastore/MapDataStore;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->startPosition()Lorg/mapsforge/core/model/LatLong;

    move-result-object v1

    if-eqz v1, :cond_25

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->startZoomLevel()Ljava/lang/Byte;

    move-result-object v1

    if-nez v1, :cond_17

    new-instance v1, Ljava/lang/Byte;

    const/16 v2, 0xc

    invoke-direct {v1, v2}, Ljava/lang/Byte;-><init>(B)V

    :cond_17
    new-instance v2, Lorg/mapsforge/core/model/MapPosition;

    invoke-virtual {v0}, Lorg/mapsforge/map/datastore/MapDataStore;->startPosition()Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    invoke-virtual {v1}, Ljava/lang/Byte;->byteValue()B

    move-result v1

    invoke-direct {v2, v0, v1}, Lorg/mapsforge/core/model/MapPosition;-><init>(Lorg/mapsforge/core/model/LatLong;B)V

    return-object v2

    :cond_25
    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getDefaultInitialPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getLayoutId()I
.end method

.method protected getMapFile()Lorg/mapsforge/map/datastore/MapDataStore;
    .registers 5

    new-instance v0, Lorg/mapsforge/map/reader/MapFile;

    new-instance v1, Ljava/io/File;

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getMapFileDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getMapFileName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lorg/mapsforge/map/reader/MapFile;-><init>(Ljava/io/File;)V

    return-object v0
.end method

.method protected getMapFileDirectory()Ljava/io/File;
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getMapFileName()Ljava/lang/String;
.end method

.method protected getMapView()Lorg/mapsforge/map/android/view/MapView;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getLayoutId()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/app/Activity;->setContentView(I)V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getMapViewId()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/android/view/MapView;

    return-object v0
.end method

.method protected abstract getMapViewId()I
.end method

.method protected getMaxTextWidthFactor()F
    .registers 2

    const v0, 0x3f333333    # 0.7f

    return v0
.end method

.method protected getPersistableId()Ljava/lang/String;
    .registers 2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getRenderTheme()Lorg/mapsforge/map/rendertheme/XmlRenderTheme;
.end method

.method protected getScreenRatio()F
    .registers 2

    const/high16 v0, 0x3f800000    # 1.0f

    return v0
.end method

.method protected getZoomLevelDefault()B
    .registers 2

    const/16 v0, 0xc

    return v0
.end method

.method protected getZoomLevelMax()B
    .registers 2

    const/16 v0, 0x18

    return v0
.end method

.method protected getZoomLevelMin()B
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method protected hasZoomControls()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method protected initializePosition(Lorg/mapsforge/map/model/IMapViewPosition;)Lorg/mapsforge/map/model/IMapViewPosition;
    .registers 6

    invoke-interface {p1}, Lorg/mapsforge/map/model/IMapViewPosition;->getCenter()Lorg/mapsforge/core/model/LatLong;

    move-result-object v0

    new-instance v1, Lorg/mapsforge/core/model/LatLong;

    const-wide/16 v2, 0x0

    invoke-direct {v1, v2, v3, v2, v3}, Lorg/mapsforge/core/model/LatLong;-><init>(DD)V

    invoke-virtual {v0, v1}, Lorg/mapsforge/core/model/LatLong;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_18

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getInitialPosition()Lorg/mapsforge/core/model/MapPosition;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->setMapPosition(Lorg/mapsforge/core/model/MapPosition;)V

    :cond_18
    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getZoomLevelMax()B

    move-result v0

    invoke-interface {p1, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->setZoomLevelMax(B)V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->getZoomLevelMin()B

    move-result v0

    invoke-interface {p1, v0}, Lorg/mapsforge/map/model/IMapViewPosition;->setZoomLevelMin(B)V

    return-object p1
.end method

.method protected isZoomControlsAutoHide()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 2

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->createSharedPreferences()V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->createMapViews()V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->createTileCaches()V

    invoke-virtual {p0}, Lorg/mapsforge/map/android/util/MapViewerTemplate;->checkPermissionsAndCreateLayersAndControls()V

    return-void
.end method

.method protected onDestroy()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->destroyAll()V

    invoke-static {}, Lorg/mapsforge/map/android/graphics/AndroidGraphicFactory;->clearResourceMemoryCache()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->tileCaches:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    return-void
.end method

.method protected onPause()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getModel()Lorg/mapsforge/map/model/Model;

    move-result-object v0

    iget-object v1, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->preferencesFacade:Lorg/mapsforge/map/model/common/PreferencesFacade;

    invoke-virtual {v0, v1}, Lorg/mapsforge/map/model/Model;->save(Lorg/mapsforge/map/model/common/PreferencesFacade;)V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->preferencesFacade:Lorg/mapsforge/map/model/common/PreferencesFacade;

    invoke-interface {v0}, Lorg/mapsforge/map/model/common/PreferencesFacade;->save()V

    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    return-void
.end method

.method protected purgeTileCaches()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->tileCaches:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/layer/cache/TileCache;

    invoke-interface {v1}, Lorg/mapsforge/map/layer/cache/TileCache;->purge()V

    goto :goto_6

    :cond_16
    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->tileCaches:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method protected redrawLayers()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {v0}, Lorg/mapsforge/map/android/view/MapView;->getLayerManager()Lorg/mapsforge/map/layer/LayerManager;

    move-result-object v0

    invoke-virtual {v0}, Lorg/mapsforge/map/layer/LayerManager;->redrawLayers()V

    return-void
.end method

.method protected setContentView()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/util/MapViewerTemplate;->mapView:Lorg/mapsforge/map/android/view/MapView;

    invoke-virtual {p0, v0}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    return-void
.end method
