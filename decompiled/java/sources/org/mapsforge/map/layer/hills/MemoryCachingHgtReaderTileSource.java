package org.mapsforge.map.layer.hills;

import java.io.File;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.HillshadingBitmap;

/* loaded from: /root/release/classes2.dex */
public class MemoryCachingHgtReaderTileSource implements ShadeTileSource {
    private ShadingAlgorithm algorithm;
    private boolean configurationChangePending;
    private HgtCache currentCache;
    private File demFolder;
    private boolean enableInterpolationOverlap;
    private final GraphicFactory graphicsFactory;
    private int mainCacheSize;
    private int neighborCacheSize;

    public MemoryCachingHgtReaderTileSource(File file, ShadingAlgorithm shadingAlgorithm, GraphicFactory graphicFactory) {
        this(graphicFactory);
        this.demFolder = file;
        this.algorithm = shadingAlgorithm;
    }

    public MemoryCachingHgtReaderTileSource(GraphicFactory graphicFactory) {
        this.mainCacheSize = 4;
        this.neighborCacheSize = 4;
        this.enableInterpolationOverlap = true;
        this.configurationChangePending = true;
        this.graphicsFactory = graphicFactory;
    }

    private HgtCache latestCache() {
        HgtCache hgtCache = this.currentCache;
        if (hgtCache != null && !this.configurationChangePending) {
            return hgtCache;
        }
        File file = this.demFolder;
        if (file == null || this.algorithm == null) {
            this.currentCache = null;
            return null;
        }
        if (hgtCache != null && this.enableInterpolationOverlap == hgtCache.interpolatorOverlap && this.mainCacheSize == hgtCache.mainCacheSize && this.neighborCacheSize == hgtCache.neighborCacheSize && file.equals(hgtCache.demFolder) && this.algorithm.equals(this.currentCache.algorithm)) {
            return hgtCache;
        }
        HgtCache hgtCache2 = new HgtCache(this.demFolder, this.enableInterpolationOverlap, this.graphicsFactory, this.algorithm, this.mainCacheSize, this.neighborCacheSize);
        this.currentCache = hgtCache2;
        return hgtCache2;
    }

    @Override // org.mapsforge.map.layer.hills.ShadeTileSource
    public void applyConfiguration(boolean z3) {
        HgtCache hgtCache = this.currentCache;
        HgtCache latestCache = latestCache();
        if (!z3 || latestCache == null || latestCache == hgtCache) {
            return;
        }
        latestCache.indexOnThread();
    }

    public ShadingAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public File getDemFolder() {
        return this.demFolder;
    }

    @Override // org.mapsforge.map.layer.hills.ShadeTileSource
    public HillshadingBitmap getHillshadingBitmap(int i3, int i4, double d3, double d4) {
        if (latestCache() == null) {
            return null;
        }
        return this.currentCache.getHillshadingBitmap(i3, i4, d3, d4);
    }

    public int getMainCacheSize() {
        return this.mainCacheSize;
    }

    public int getNeighborCacheSize() {
        return this.neighborCacheSize;
    }

    public boolean isEnableInterpolationOverlap() {
        return this.enableInterpolationOverlap;
    }

    @Override // org.mapsforge.map.layer.hills.ShadeTileSource
    public void prepareOnThread() {
        HgtCache hgtCache = this.currentCache;
        if (hgtCache != null) {
            hgtCache.indexOnThread();
        }
    }

    @Override // org.mapsforge.map.layer.hills.ShadeTileSource
    public void setDemFolder(File file) {
        this.demFolder = file;
    }

    public void setEnableInterpolationOverlap(boolean z3) {
        this.enableInterpolationOverlap = z3;
    }

    public void setMainCacheSize(int i3) {
        this.mainCacheSize = i3;
    }

    public void setNeighborCacheSize(int i3) {
        this.neighborCacheSize = i3;
    }

    @Override // org.mapsforge.map.layer.hills.ShadeTileSource
    public void setShadingAlgorithm(ShadingAlgorithm shadingAlgorithm) {
        this.algorithm = shadingAlgorithm;
    }
}
