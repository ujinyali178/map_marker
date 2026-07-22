package org.mapsforge.map.layer.download;

import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.TileLayer;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.download.tilesource.TileSource;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.IMapViewPosition;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public class TileDownloadLayer extends TileLayer<DownloadJob> implements Observer {
    private static final int DOWNLOAD_THREADS_MAX = 8;
    private long cacheTimeToLive;
    private final GraphicFactory graphicFactory;
    private boolean started;
    private final TileCache tileCache;
    private TileDownloadThread[] tileDownloadThreads;
    private final TileSource tileSource;

    public TileDownloadLayer(TileCache tileCache, IMapViewPosition iMapViewPosition, TileSource tileSource, GraphicFactory graphicFactory) {
        super(tileCache, iMapViewPosition, graphicFactory.createMatrix(), tileSource.hasAlpha());
        this.cacheTimeToLive = 0L;
        this.tileCache = tileCache;
        this.tileSource = tileSource;
        this.cacheTimeToLive = tileSource.getDefaultTimeToLive();
        this.graphicFactory = graphicFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.mapsforge.map.layer.TileLayer
    public DownloadJob createJob(Tile tile) {
        return new DownloadJob(tile, this.tileSource);
    }

    @Override // org.mapsforge.map.layer.TileLayer, org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        if (b4 < this.tileSource.getZoomLevelMin() || b4 > this.tileSource.getZoomLevelMax()) {
            return;
        }
        super.draw(boundingBox, b4, canvas, point);
    }

    public long getCacheTimeToLive() {
        return this.cacheTimeToLive;
    }

    @Override // org.mapsforge.map.layer.TileLayer
    protected boolean isTileStale(Tile tile, TileBitmap tileBitmap) {
        if (tileBitmap.isExpired()) {
            return true;
        }
        return this.cacheTimeToLive != 0 && tileBitmap.getTimestamp() + this.cacheTimeToLive < System.currentTimeMillis();
    }

    @Override // org.mapsforge.map.layer.Layer
    protected void onAdd() {
        TileCache tileCache = this.tileCache;
        if (tileCache != null) {
            tileCache.addObserver(this);
        }
        super.onAdd();
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        requestRedraw();
    }

    @Override // org.mapsforge.map.layer.Layer
    public void onDestroy() {
        for (TileDownloadThread tileDownloadThread : this.tileDownloadThreads) {
            tileDownloadThread.finish();
        }
        super.onDestroy();
    }

    public void onPause() {
        for (TileDownloadThread tileDownloadThread : this.tileDownloadThreads) {
            tileDownloadThread.pause();
        }
    }

    @Override // org.mapsforge.map.layer.Layer
    protected void onRemove() {
        TileCache tileCache = this.tileCache;
        if (tileCache != null) {
            tileCache.removeObserver(this);
        }
        super.onRemove();
    }

    public void onResume() {
        if (!this.started) {
            start();
        }
        for (TileDownloadThread tileDownloadThread : this.tileDownloadThreads) {
            tileDownloadThread.proceed();
        }
    }

    public void setCacheTimeToLive(long j3) {
        this.cacheTimeToLive = j3;
    }

    @Override // org.mapsforge.map.layer.TileLayer, org.mapsforge.map.layer.Layer
    public synchronized void setDisplayModel(DisplayModel displayModel) {
        super.setDisplayModel(displayModel);
        int min = Math.min(this.tileSource.getParallelRequestsLimit(), 8);
        int i3 = 0;
        if (this.displayModel != null) {
            this.tileDownloadThreads = new TileDownloadThread[min];
            while (i3 < min) {
                this.tileDownloadThreads[i3] = new TileDownloadThread(this.tileCache, this.jobQueue, this, this.graphicFactory, this.displayModel);
                i3++;
            }
        } else {
            TileDownloadThread[] tileDownloadThreadArr = this.tileDownloadThreads;
            if (tileDownloadThreadArr != null) {
                int length = tileDownloadThreadArr.length;
                while (i3 < length) {
                    tileDownloadThreadArr[i3].finish();
                    i3++;
                }
            }
        }
    }

    public void start() {
        for (TileDownloadThread tileDownloadThread : this.tileDownloadThreads) {
            tileDownloadThread.start();
        }
        this.started = true;
    }
}
