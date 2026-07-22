package org.mapsforge.map.layer.download;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.queue.JobQueue;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.util.PausableThread;

/* loaded from: /root/release/classes2.dex */
class TileDownloadThread extends PausableThread {
    private static final Logger LOGGER = Logger.getLogger(TileDownloadThread.class.getName());
    private final DisplayModel displayModel;
    private final GraphicFactory graphicFactory;
    private JobQueue<DownloadJob> jobQueue;
    private final Layer layer;
    private final TileCache tileCache;

    TileDownloadThread(TileCache tileCache, JobQueue<DownloadJob> jobQueue, Layer layer, GraphicFactory graphicFactory, DisplayModel displayModel) {
        this.tileCache = tileCache;
        this.jobQueue = jobQueue;
        this.layer = layer;
        this.graphicFactory = graphicFactory;
        this.displayModel = displayModel;
    }

    private void downloadTile(DownloadJob downloadJob) {
        TileBitmap downloadImage = new TileDownloader(downloadJob, this.graphicFactory).downloadImage();
        if (isInterrupted() || downloadImage == null) {
            return;
        }
        downloadImage.scaleTo(this.displayModel.getTileSize(), this.displayModel.getTileSize());
        this.tileCache.put(downloadJob, downloadImage);
        this.layer.requestRedraw();
    }

    @Override // org.mapsforge.map.util.PausableThread
    protected void doWork() {
        DownloadJob downloadJob = this.jobQueue.get();
        try {
            try {
                if (!this.tileCache.containsKey(downloadJob)) {
                    downloadTile(downloadJob);
                }
            } catch (IOException e3) {
                LOGGER.log(Level.SEVERE, e3.getMessage(), (Throwable) e3);
            }
        } finally {
            this.jobQueue.remove(downloadJob);
        }
    }

    @Override // org.mapsforge.map.util.PausableThread
    protected PausableThread.ThreadPriority getThreadPriority() {
        return PausableThread.ThreadPriority.BELOW_NORMAL;
    }

    @Override // org.mapsforge.map.util.PausableThread
    protected boolean hasWork() {
        return true;
    }

    public void setJobQueue(JobQueue<DownloadJob> jobQueue) {
        this.jobQueue = jobQueue;
    }
}
