package org.mapsforge.map.layer.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.CorruptedInputStreamException;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.util.IOUtils;
import org.mapsforge.map.layer.queue.Job;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public class TileStore implements TileCache {
    private static final Logger LOGGER = Logger.getLogger(TileStore.class.getName());
    private final GraphicFactory graphicFactory;
    private final File rootDirectory;
    private final String suffix;

    public TileStore(File file, String str, GraphicFactory graphicFactory) {
        this.rootDirectory = file;
        this.graphicFactory = graphicFactory;
        this.suffix = str;
        if (file == null || !file.isDirectory() || !file.canRead()) {
            throw new IllegalArgumentException("Root directory must be readable");
        }
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public void addObserver(Observer observer) {
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized boolean containsKey(Job job) {
        return findFile(job) != null;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized void destroy() {
    }

    protected File findFile(Job job) {
        Logger logger;
        StringBuilder sb;
        String str;
        File file = new File(this.rootDirectory, Byte.toString(job.tile.zoomLevel));
        String str2 = "Failed to find directory ";
        if (file.isDirectory() && file.canRead()) {
            File file2 = new File(file, Long.toString(job.tile.tileX));
            if (!file2.isDirectory() || !file2.canRead()) {
                logger = LOGGER;
                str = "Failed to find directory " + file2.getAbsolutePath();
                logger.info(str);
                return null;
            }
            file = new File(file2, Long.toString(job.tile.tileY) + this.suffix);
            if (file.isFile() && file.canRead()) {
                LOGGER.info("Found file " + file.getAbsolutePath());
                return file;
            }
            logger = LOGGER;
            sb = new StringBuilder();
            str2 = "Failed to find file ";
        } else {
            logger = LOGGER;
            sb = new StringBuilder();
        }
        sb.append(str2);
        sb.append(file.getAbsolutePath());
        str = sb.toString();
        logger.info(str);
        return null;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized TileBitmap get(Job job) {
        FileInputStream fileInputStream;
        File findFile = findFile(job);
        FileInputStream fileInputStream2 = null;
        if (findFile == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(findFile);
            try {
                TileBitmap createTileBitmap = this.graphicFactory.createTileBitmap(fileInputStream, job.tile.tileSize, job.hasAlpha);
                if (createTileBitmap.getWidth() != job.tile.tileSize || createTileBitmap.getHeight() != job.tile.tileSize) {
                    int i3 = job.tile.tileSize;
                    createTileBitmap.scaleTo(i3, i3);
                }
                IOUtils.closeQuietly(fileInputStream);
                return createTileBitmap;
            } catch (IOException unused) {
                IOUtils.closeQuietly(fileInputStream);
                return null;
            } catch (CorruptedInputStreamException unused2) {
                IOUtils.closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (IOException unused3) {
            fileInputStream = null;
        } catch (CorruptedInputStreamException unused4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized int getCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized int getCapacityFirstLevel() {
        return getCapacity();
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public TileBitmap getImmediately(Job job) {
        return get(job);
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized void purge() {
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public synchronized void put(Job job, TileBitmap tileBitmap) {
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public void removeObserver(Observer observer) {
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public void setWorkingSet(Set<Job> set) {
    }
}
