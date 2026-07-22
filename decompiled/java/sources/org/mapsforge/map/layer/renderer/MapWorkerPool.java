package org.mapsforge.map.layer.renderer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.util.Parameters;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.queue.JobQueue;

/* loaded from: /root/release/classes2.dex */
public class MapWorkerPool implements Runnable {
    private final DatabaseRenderer databaseRenderer;
    private final JobQueue<RendererJob> jobQueue;
    private final Layer layer;
    private ExecutorService self;
    private final TileCache tileCache;
    private ExecutorService workers;
    private static final Logger LOGGER = Logger.getLogger(MapWorkerPool.class.getName());
    public static boolean DEBUG_TIMING = false;
    private final AtomicInteger concurrentJobs = new AtomicInteger();
    private final AtomicLong totalExecutions = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();
    private boolean inShutdown = false;
    private boolean isRunning = false;

    class MapWorker implements Runnable {
        private final RendererJob rendererJob;

        MapWorker(RendererJob rendererJob) {
            this.rendererJob = rendererJob;
            rendererJob.renderThemeFuture.incrementRefCount();
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            TileBitmap tileBitmap = null;
            try {
                if (MapWorkerPool.this.inShutdown) {
                    this.rendererJob.renderThemeFuture.decrementRefCount();
                    MapWorkerPool.this.jobQueue.remove(this.rendererJob);
                    return;
                }
                if (MapWorkerPool.DEBUG_TIMING) {
                    j3 = System.currentTimeMillis();
                    MapWorkerPool.LOGGER.info("ConcurrentJobs " + MapWorkerPool.this.concurrentJobs.incrementAndGet());
                } else {
                    j3 = 0;
                }
                tileBitmap = MapWorkerPool.this.databaseRenderer.executeJob(this.rendererJob);
                if (MapWorkerPool.this.inShutdown) {
                    if (tileBitmap != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (!this.rendererJob.labelsOnly && tileBitmap != null) {
                    MapWorkerPool.this.tileCache.put(this.rendererJob, tileBitmap);
                    MapWorkerPool.this.databaseRenderer.removeTileInProgress(this.rendererJob.tile);
                }
                MapWorkerPool.this.layer.requestRedraw();
                if (MapWorkerPool.DEBUG_TIMING) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long incrementAndGet = MapWorkerPool.this.totalExecutions.incrementAndGet();
                    long addAndGet = MapWorkerPool.this.totalTime.addAndGet(currentTimeMillis - j3);
                    if (incrementAndGet % 10 == 0) {
                        MapWorkerPool.LOGGER.info("TIMING " + Long.toString(incrementAndGet) + " " + Double.toString(addAndGet / incrementAndGet));
                    }
                    MapWorkerPool.this.concurrentJobs.decrementAndGet();
                }
                this.rendererJob.renderThemeFuture.decrementRefCount();
                MapWorkerPool.this.jobQueue.remove(this.rendererJob);
                if (tileBitmap != null) {
                    tileBitmap.decrementRefCount();
                }
            } finally {
                this.rendererJob.renderThemeFuture.decrementRefCount();
                MapWorkerPool.this.jobQueue.remove(this.rendererJob);
                if (tileBitmap != null) {
                    tileBitmap.decrementRefCount();
                }
            }
        }
    }

    public MapWorkerPool(TileCache tileCache, JobQueue<RendererJob> jobQueue, DatabaseRenderer databaseRenderer, Layer layer) {
        this.tileCache = tileCache;
        this.jobQueue = jobQueue;
        this.databaseRenderer = databaseRenderer;
        this.layer = layer;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger logger;
        Level level;
        String str;
        while (!this.inShutdown) {
            try {
                RendererJob rendererJob = this.jobQueue.get(Parameters.NUMBER_OF_THREADS);
                if (rendererJob != null) {
                    if (this.tileCache.containsKey(rendererJob) && !rendererJob.labelsOnly) {
                        this.jobQueue.remove(rendererJob);
                    }
                    this.workers.execute(new MapWorker(rendererJob));
                }
            } catch (InterruptedException e3) {
                e = e3;
                logger = LOGGER;
                level = Level.SEVERE;
                str = "MapWorkerPool interrupted";
                logger.log(level, str, e);
                return;
            } catch (RejectedExecutionException e4) {
                e = e4;
                logger = LOGGER;
                level = Level.SEVERE;
                str = "MapWorkerPool rejected";
                logger.log(level, str, e);
                return;
            }
        }
    }

    public synchronized void start() {
        if (this.isRunning) {
            return;
        }
        this.inShutdown = false;
        this.self = Executors.newSingleThreadExecutor();
        this.workers = Executors.newFixedThreadPool(Parameters.NUMBER_OF_THREADS);
        this.self.execute(this);
        this.isRunning = true;
    }

    public synchronized void stop() {
        if (this.isRunning) {
            this.inShutdown = true;
            this.jobQueue.interrupt();
            this.self.shutdown();
            this.workers.shutdown();
            try {
                ExecutorService executorService = this.self;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!executorService.awaitTermination(100L, timeUnit)) {
                    this.self.shutdownNow();
                    if (!this.self.awaitTermination(100L, timeUnit)) {
                        LOGGER.fine("Shutdown self executor failed");
                    }
                }
            } catch (InterruptedException e3) {
                LOGGER.log(Level.SEVERE, "Shutdown self executor interrupted", (Throwable) e3);
            }
            try {
                ExecutorService executorService2 = this.workers;
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                if (!executorService2.awaitTermination(100L, timeUnit2)) {
                    this.workers.shutdownNow();
                    if (!this.workers.awaitTermination(100L, timeUnit2)) {
                        LOGGER.fine("Shutdown workers executor failed");
                    }
                }
            } catch (InterruptedException e4) {
                LOGGER.log(Level.SEVERE, "Shutdown workers executor interrupted", (Throwable) e4);
            }
            this.isRunning = false;
        }
    }
}
