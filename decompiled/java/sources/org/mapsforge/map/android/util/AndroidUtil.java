package org.mapsforge.map.android.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.logging.Logger;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.view.MapView;
import org.mapsforge.map.controller.FrameBufferController;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.cache.FileSystemTileCache;
import org.mapsforge.map.layer.cache.InMemoryTileCache;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.cache.TwoLevelTileCache;
import org.mapsforge.map.layer.hills.HillsRenderConfig;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.model.IMapViewPosition;
import org.mapsforge.map.rendertheme.XmlRenderTheme;
import org.mapsforge.map.scalebar.DefaultMapScaleBar;
import org.mapsforge.map.scalebar.DistanceUnitAdapter;
import org.mapsforge.map.scalebar.MapScaleBar;

/* loaded from: /root/release/classes2.dex */
public final class AndroidUtil {
    private static final Logger LOGGER = Logger.getLogger(AndroidUtil.class.getName());

    private AndroidUtil() {
    }

    public static TileCache createExternalStorageTileCache(Context context, String str, int i3, int i4) {
        return createExternalStorageTileCache(context, str, i3, i4, false);
    }

    public static TileCache createExternalStorageTileCache(Context context, String str, int i3, int i4, boolean z3) {
        return createExternalStorageTileCache(context.getExternalCacheDir(), str, i3, i4, z3);
    }

    public static TileCache createExternalStorageTileCache(File file, String str, int i3, int i4, boolean z3) {
        Logger logger = LOGGER;
        logger.info("TILECACHE INMEMORY SIZE: " + Integer.toString(i3));
        InMemoryTileCache inMemoryTileCache = new InMemoryTileCache(i3);
        if (file != null) {
            String str2 = file.getAbsolutePath() + File.separator + str;
            File file2 = new File(str2);
            if (file2.exists() || file2.mkdirs()) {
                int estimateSizeOfFileSystemCache = estimateSizeOfFileSystemCache(str2, i3, i4);
                if (file2.canWrite() && estimateSizeOfFileSystemCache > 0) {
                    try {
                        logger.info("TILECACHE FILE SIZE: " + Integer.toString(estimateSizeOfFileSystemCache));
                        return new TwoLevelTileCache(inMemoryTileCache, new FileSystemTileCache(estimateSizeOfFileSystemCache, file2, AndroidGraphicFactory.INSTANCE, z3));
                    } catch (IllegalArgumentException e3) {
                        LOGGER.warning(e3.getMessage());
                    }
                }
            }
        }
        return inMemoryTileCache;
    }

    public static TileCache createTileCache(Context context, File file, String str, int i3, float f3, double d3, boolean z3) {
        return createExternalStorageTileCache(file, str, getMinimumCacheSize(context, i3, d3, f3), i3, z3);
    }

    public static TileCache createTileCache(Context context, String str, int i3, float f3, double d3) {
        return createTileCache(context, str, i3, f3, d3, false);
    }

    public static TileCache createTileCache(Context context, String str, int i3, float f3, double d3, boolean z3) {
        return createExternalStorageTileCache(context, str, getMinimumCacheSize(context, i3, d3, f3), i3, z3);
    }

    public static TileCache createTileCache(Context context, String str, int i3, int i4, int i5, double d3) {
        return createTileCache(context, str, i3, i4, i5, d3, false);
    }

    public static TileCache createTileCache(Context context, String str, int i3, int i4, int i5, double d3, boolean z3) {
        return createExternalStorageTileCache(context, str, getMinimumCacheSize(i3, d3, i4, i5), i3, z3);
    }

    public static TileCache createTileCache(File file, String str, int i3, int i4, int i5, double d3, boolean z3) {
        return createExternalStorageTileCache(file, str, getMinimumCacheSize(i3, d3, i4, i5), i3, z3);
    }

    public static TileRendererLayer createTileRendererLayer(TileCache tileCache, IMapViewPosition iMapViewPosition, MapDataStore mapDataStore, XmlRenderTheme xmlRenderTheme) {
        TileRendererLayer tileRendererLayer = new TileRendererLayer(tileCache, mapDataStore, iMapViewPosition, AndroidGraphicFactory.INSTANCE);
        tileRendererLayer.setXmlRenderTheme(xmlRenderTheme);
        return tileRendererLayer;
    }

    public static TileRendererLayer createTileRendererLayer(TileCache tileCache, IMapViewPosition iMapViewPosition, MapDataStore mapDataStore, XmlRenderTheme xmlRenderTheme, boolean z3, boolean z4, boolean z5) {
        TileRendererLayer tileRendererLayer = new TileRendererLayer(tileCache, mapDataStore, iMapViewPosition, z3, z4, z5, AndroidGraphicFactory.INSTANCE);
        tileRendererLayer.setXmlRenderTheme(xmlRenderTheme);
        return tileRendererLayer;
    }

    public static TileRendererLayer createTileRendererLayer(TileCache tileCache, IMapViewPosition iMapViewPosition, MapDataStore mapDataStore, XmlRenderTheme xmlRenderTheme, boolean z3, boolean z4, boolean z5, HillsRenderConfig hillsRenderConfig) {
        TileRendererLayer tileRendererLayer = new TileRendererLayer(tileCache, mapDataStore, iMapViewPosition, z3, z4, z5, AndroidGraphicFactory.INSTANCE, hillsRenderConfig);
        tileRendererLayer.setXmlRenderTheme(xmlRenderTheme);
        return tileRendererLayer;
    }

    public static boolean currentThreadIsUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static int estimateSizeOfFileSystemCache(String str, int i3, int i4) {
        int min = (int) Math.min(2000L, getAvailableCacheSlots(str, i4 * 4 * i4));
        if (i3 > min) {
            return 0;
        }
        return min;
    }

    public static long getAvailableCacheSlots(String str, int i3) {
        return new StatFs(str).getAvailableBytes() / i3;
    }

    public static int getMinimumCacheSize(int i3, double d3, int i4, int i5) {
        Dimension calculateFrameBufferDimension = FrameBufferController.calculateFrameBufferDimension(new Dimension(i4, i5), d3);
        return Math.max(4, ((calculateFrameBufferDimension.height / i3) + 2) * ((calculateFrameBufferDimension.width / i3) + 2));
    }

    public static int getMinimumCacheSize(Context context, int i3, double d3, float f3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Dimension calculateFrameBufferDimension = FrameBufferController.calculateFrameBufferDimension(new Dimension(point.x, point.y), d3);
        return (int) Math.max(4.0f, f3 * ((calculateFrameBufferDimension.height / i3) + 2) * ((calculateFrameBufferDimension.width / i3) + 2));
    }

    public static void restartActivity(Activity activity) {
        activity.recreate();
    }

    public static void setMapScaleBar(MapView mapView, DistanceUnitAdapter distanceUnitAdapter, DistanceUnitAdapter distanceUnitAdapter2) {
        if (distanceUnitAdapter == null && distanceUnitAdapter2 == null) {
            mapView.setMapScaleBar(null);
            return;
        }
        MapScaleBar mapScaleBar = mapView.getMapScaleBar();
        if (mapScaleBar == null) {
            mapScaleBar = new DefaultMapScaleBar(mapView.getModel().mapViewPosition, mapView.getModel().mapViewDimension, AndroidGraphicFactory.INSTANCE, mapView.getModel().displayModel);
            mapView.setMapScaleBar(mapScaleBar);
        }
        if (mapScaleBar instanceof DefaultMapScaleBar) {
            DefaultMapScaleBar defaultMapScaleBar = (DefaultMapScaleBar) mapScaleBar;
            if (distanceUnitAdapter2 != null) {
                defaultMapScaleBar.setScaleBarMode(DefaultMapScaleBar.ScaleBarMode.BOTH);
                defaultMapScaleBar.setSecondaryDistanceUnitAdapter(distanceUnitAdapter2);
            } else {
                defaultMapScaleBar.setScaleBarMode(DefaultMapScaleBar.ScaleBarMode.SINGLE);
            }
        }
        mapScaleBar.setDistanceUnitAdapter(distanceUnitAdapter);
    }
}
