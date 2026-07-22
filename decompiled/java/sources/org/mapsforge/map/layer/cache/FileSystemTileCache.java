package org.mapsforge.map.layer.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.CorruptedInputStreamException;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.util.IOUtils;
import org.mapsforge.map.layer.queue.Job;
import org.mapsforge.map.model.common.Observable;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public class FileSystemTileCache implements TileCache {
    static final String FILE_EXTENSION = ".tile";
    private static final Logger LOGGER = Logger.getLogger(FileSystemTileCache.class.getName());
    private final File cacheDirectory;
    private final GraphicFactory graphicFactory;
    private final ReentrantReadWriteLock lock;
    private FileWorkingSetCache<String> lruCache;
    private final Observable observable;
    private final boolean persistent;

    private class CacheDirectoryReader implements Runnable {
        private CacheDirectoryReader() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            int i3;
            File[] listFiles = FileSystemTileCache.this.cacheDirectory.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i4 = 0;
                while (i4 < length) {
                    File file = listFiles[i4];
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 != null) {
                        int length2 = listFiles2.length;
                        int i5 = 0;
                        while (i5 < length2) {
                            File file2 = listFiles2[i5];
                            File[] listFiles3 = file2.listFiles();
                            if (listFiles3 != null) {
                                int length3 = listFiles3.length;
                                int i6 = 0;
                                while (i6 < length3) {
                                    File file3 = listFiles3[i6];
                                    if (FileSystemTileCache.isValidFile(file3) && file3.getName().endsWith(FileSystemTileCache.FILE_EXTENSION)) {
                                        fileArr = listFiles;
                                        i3 = length;
                                        String composeKey = Job.composeKey(file.getName(), file2.getName(), file3.getName().substring(0, file3.getName().lastIndexOf(FileSystemTileCache.FILE_EXTENSION)));
                                        try {
                                            FileSystemTileCache.this.lock.writeLock().lock();
                                            if (FileSystemTileCache.this.lruCache.put(composeKey, file3) != null) {
                                                FileSystemTileCache.LOGGER.warning("overwriting cached entry: " + composeKey);
                                            }
                                        } finally {
                                            FileSystemTileCache.this.lock.writeLock().unlock();
                                        }
                                    } else {
                                        fileArr = listFiles;
                                        i3 = length;
                                    }
                                    i6++;
                                    listFiles = fileArr;
                                    length = i3;
                                }
                            }
                            i5++;
                            listFiles = listFiles;
                            length = length;
                        }
                    }
                    i4++;
                    listFiles = listFiles;
                    length = length;
                }
            }
        }
    }

    public FileSystemTileCache(int i3, File file, GraphicFactory graphicFactory) {
        this(i3, file, graphicFactory, false);
    }

    public FileSystemTileCache(int i3, File file, GraphicFactory graphicFactory, boolean z3) {
        this.observable = new Observable();
        this.persistent = z3;
        this.lruCache = new FileWorkingSetCache<>(i3);
        this.lock = new ReentrantReadWriteLock();
        if (isValidCacheDirectory(file)) {
            this.cacheDirectory = file;
            if (z3) {
                new Thread(new CacheDirectoryReader()).start();
            }
        } else {
            this.cacheDirectory = null;
        }
        this.graphicFactory = graphicFactory;
    }

    private static boolean deleteDirectory(File file) {
        String[] list;
        if (file == null) {
            return false;
        }
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!deleteDirectory(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private File getOutputFile(Job job) {
        String str = this.cacheDirectory + File.separator + job.getKey();
        if (!isValidCacheDirectory(new File(str.substring(0, str.lastIndexOf(File.separatorChar))))) {
            return null;
        }
        return new File(str + FILE_EXTENSION);
    }

    private static boolean isValidCacheDirectory(File file) {
        return file != null && (file.exists() || file.mkdirs()) && file.isDirectory() && file.canRead() && file.canWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidFile(File file) {
        return file != null && file.isFile() && file.canRead();
    }

    private void remove(Job job) {
        try {
            this.lock.writeLock().lock();
            this.lruCache.remove(job.getKey());
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    private void storeData(Job job, TileBitmap tileBitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File outputFile = getOutputFile(job);
                if (outputFile == null) {
                    IOUtils.closeQuietly(null);
                    return;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(outputFile);
                try {
                    tileBitmap.compress(fileOutputStream2);
                    try {
                        this.lock.writeLock().lock();
                        if (this.lruCache.put(job.getKey(), outputFile) != null) {
                            LOGGER.warning("overwriting cached entry: " + job.getKey());
                        }
                        IOUtils.closeQuietly(fileOutputStream2);
                    } finally {
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    LOGGER.log(Level.SEVERE, "Disabling filesystem cache", (Throwable) e);
                    destroy();
                    try {
                        this.lock.writeLock().lock();
                        this.lruCache = new FileWorkingSetCache<>(0);
                        IOUtils.closeQuietly(fileOutputStream);
                    } finally {
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public void addObserver(Observer observer) {
        this.observable.addObserver(observer);
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public boolean containsKey(Job job) {
        try {
            this.lock.readLock().lock();
            return this.lruCache.containsKey(job.getKey());
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public void destroy() {
        if (this.persistent) {
            return;
        }
        purge();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x008a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x008a */
    @Override // org.mapsforge.map.layer.cache.TileCache
    public TileBitmap get(Job job) {
        Closeable closeable;
        FileInputStream fileInputStream;
        try {
            this.lock.readLock().lock();
            File file = this.lruCache.get(job.getKey());
            this.lock.readLock().unlock();
            Closeable closeable2 = null;
            try {
                if (file == null) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        TileBitmap createTileBitmap = this.graphicFactory.createTileBitmap(fileInputStream, job.tile.tileSize, job.hasAlpha);
                        createTileBitmap.setTimestamp(file.lastModified());
                        IOUtils.closeQuietly(fileInputStream);
                        return createTileBitmap;
                    } catch (IOException e3) {
                        e = e3;
                        remove(job);
                        LOGGER.log(Level.SEVERE, e.getMessage(), (Throwable) e);
                        IOUtils.closeQuietly(fileInputStream);
                        return null;
                    } catch (CorruptedInputStreamException e4) {
                        e = e4;
                        remove(job);
                        LOGGER.log(Level.WARNING, "input stream from file system cache invalid " + job.getKey() + " " + file.length(), (Throwable) e);
                        IOUtils.closeQuietly(fileInputStream);
                        return null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = null;
                } catch (CorruptedInputStreamException e6) {
                    e = e6;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(closeable2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
            }
        } catch (Throwable th3) {
            this.lock.readLock().unlock();
            throw th3;
        }
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public int getCapacity() {
        try {
            this.lock.readLock().lock();
            return this.lruCache.capacity;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public int getCapacityFirstLevel() {
        return getCapacity();
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public TileBitmap getImmediately(Job job) {
        return get(job);
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public void purge() {
        try {
            this.lock.writeLock().lock();
            this.lruCache.clear();
            this.lock.writeLock().unlock();
            deleteDirectory(this.cacheDirectory);
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            throw th;
        }
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public void put(Job job, TileBitmap tileBitmap) {
        if (job == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (tileBitmap == null) {
            throw new IllegalArgumentException("bitmap must not be null");
        }
        if (getCapacity() == 0) {
            return;
        }
        storeData(job, tileBitmap);
        this.observable.notifyObservers();
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public void removeObserver(Observer observer) {
        this.observable.removeObserver(observer);
    }

    @Override // org.mapsforge.map.layer.cache.TileCache
    public void setWorkingSet(Set<Job> set) {
        HashSet hashSet = new HashSet();
        synchronized (set) {
            Iterator<Job> it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getKey());
            }
        }
        this.lruCache.setWorkingSet(hashSet);
    }
}
