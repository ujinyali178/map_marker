package org.mapsforge.map.layer.hills;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.HillshadingBitmap;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.map.layer.hills.ShadingAlgorithm;

/* loaded from: /root/release/classes2.dex */
class HgtCache {
    final ShadingAlgorithm algorithm;
    final File demFolder;
    private final GraphicFactory graphicsFactory;
    private LazyFuture<Map<TileKey, HgtFileInfo>> hgtFiles;
    final boolean interpolatorOverlap;
    final int mainCacheSize;
    private final Lru mainLru;
    final int neighborCacheSize;
    private List<String> problems = new ArrayList();
    private final Lru secondaryLru;

    /* renamed from: org.mapsforge.map.layer.hills.HgtCache$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border;

        static {
            int[] iArr = new int[HillshadingBitmap.Border.values().length];
            $SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border = iArr;
            try {
                iArr[HillshadingBitmap.Border.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border[HillshadingBitmap.Border.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border[HillshadingBitmap.Border.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border[HillshadingBitmap.Border.WEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class HgtFileInfo extends BoundingBox implements ShadingAlgorithm.RawHillTileSource {
        final File file;
        final long size;
        WeakReference<Future<HillshadingBitmap>> weakRef;

        HgtFileInfo(File file, double d3, double d4, double d5, double d6) {
            super(d3, d4, d5, d6);
            this.weakRef = null;
            this.file = file;
            this.size = file.length();
        }

        private MergeOverlapFuture getForHires() {
            MergeOverlapFuture mergeOverlapFuture;
            WeakReference<Future<HillshadingBitmap>> weakReference = this.weakRef;
            Future<HillshadingBitmap> future = weakReference == null ? null : weakReference.get();
            if (future instanceof MergeOverlapFuture) {
                mergeOverlapFuture = (MergeOverlapFuture) future;
            } else if (future instanceof LoadUnmergedFuture) {
                LoadUnmergedFuture loadUnmergedFuture = (LoadUnmergedFuture) future;
                MergeOverlapFuture mergeOverlapFuture2 = HgtCache.this.new MergeOverlapFuture(this, loadUnmergedFuture);
                this.weakRef = new WeakReference<>(mergeOverlapFuture2);
                HgtCache.this.secondaryLru.evict(loadUnmergedFuture);
                mergeOverlapFuture = mergeOverlapFuture2;
            } else {
                mergeOverlapFuture = new MergeOverlapFuture(HgtCache.this, this);
                this.weakRef = new WeakReference<>(mergeOverlapFuture);
            }
            HgtCache.this.mainLru.markUsed(mergeOverlapFuture);
            return mergeOverlapFuture;
        }

        private Future<HillshadingBitmap> getForLores() {
            WeakReference<Future<HillshadingBitmap>> weakReference = this.weakRef;
            Future<HillshadingBitmap> future = weakReference == null ? null : weakReference.get();
            if (future == null) {
                future = HgtCache.this.new LoadUnmergedFuture(this);
                this.weakRef = new WeakReference<>(future);
            }
            Future<HillshadingBitmap> markUsed = HgtCache.this.mainLru.markUsed(future);
            if (HgtCache.this.secondaryLru != null) {
                HgtCache.this.secondaryLru.markUsed(markUsed);
            }
            return future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public HgtFileInfo getNeighbor(HillshadingBitmap.Border border) {
            TileKey tileKey;
            Map map = (Map) HgtCache.this.hgtFiles.get();
            int i3 = AnonymousClass2.$SwitchMap$org$mapsforge$core$graphics$HillshadingBitmap$Border[border.ordinal()];
            if (i3 == 1) {
                tileKey = new TileKey(((int) this.maxLatitude) + 1, (int) this.minLongitude);
            } else if (i3 == 2) {
                tileKey = new TileKey(((int) this.maxLatitude) - 1, (int) this.minLongitude);
            } else if (i3 == 3) {
                tileKey = new TileKey((int) this.maxLatitude, ((int) this.minLongitude) + 1);
            } else {
                if (i3 != 4) {
                    return null;
                }
                tileKey = new TileKey((int) this.maxLatitude, ((int) this.minLongitude) - 1);
            }
            return (HgtFileInfo) map.get(tileKey);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public LoadUnmergedFuture getUnmergedAsMergePartner() {
            WeakReference<Future<HillshadingBitmap>> weakReference = this.weakRef;
            Future<HillshadingBitmap> future = weakReference == null ? null : weakReference.get();
            if (future instanceof LoadUnmergedFuture) {
                HgtCache.this.secondaryLru.markUsed(future);
                return (LoadUnmergedFuture) future;
            }
            if (future instanceof MergeOverlapFuture) {
                HgtCache.this.mainLru.markUsed(future);
                return ((MergeOverlapFuture) future).loadFuture;
            }
            LoadUnmergedFuture loadUnmergedFuture = HgtCache.this.new LoadUnmergedFuture(this);
            this.weakRef = new WeakReference<>(loadUnmergedFuture);
            HgtCache.this.secondaryLru.markUsed(loadUnmergedFuture);
            return loadUnmergedFuture;
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public double eastLng() {
            return this.maxLongitude;
        }

        Future<HillshadingBitmap> getBitmapFuture(double d3, double d4) {
            HgtCache hgtCache = HgtCache.this;
            if (!hgtCache.interpolatorOverlap) {
                return getForLores();
            }
            double axisLenght = hgtCache.algorithm.getAxisLenght(this);
            return (d3 > axisLenght || d4 > axisLenght) ? getForHires() : getForLores();
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public File getFile() {
            return this.file;
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public HillshadingBitmap getFinishedConverted() {
            Future<HillshadingBitmap> future;
            WeakReference<Future<HillshadingBitmap>> weakReference = this.weakRef;
            if (weakReference == null || (future = weakReference.get()) == null || !future.isDone()) {
                return null;
            }
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public long getSize() {
            return this.size;
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public double northLat() {
            return this.maxLatitude;
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public double southLat() {
            return this.minLatitude;
        }

        @Override // org.mapsforge.core.model.BoundingBox
        public String toString() {
            WeakReference<Future<HillshadingBitmap>> weakReference = this.weakRef;
            Future<HillshadingBitmap> future = weakReference == null ? null : weakReference.get();
            StringBuilder sb = new StringBuilder();
            sb.append("[lt:");
            sb.append(this.minLatitude);
            sb.append("-");
            sb.append(this.maxLatitude);
            sb.append(" ln:");
            sb.append(this.minLongitude);
            sb.append("-");
            sb.append(this.maxLongitude);
            sb.append(future == null ? "" : future.isDone() ? "done" : "wip");
            sb.append("]");
            return sb.toString();
        }

        @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm.RawHillTileSource
        public double westLng() {
            return this.minLongitude;
        }
    }

    class LoadUnmergedFuture extends LazyFuture<HillshadingBitmap> {
        private final HgtFileInfo hgtFileInfo;

        LoadUnmergedFuture(HgtFileInfo hgtFileInfo) {
            this.hgtFileInfo = hgtFileInfo;
        }

        @Override // org.mapsforge.map.layer.hills.LatchedLazyFuture
        public HillshadingBitmap calculate() {
            HgtCache hgtCache = HgtCache.this;
            ShadingAlgorithm.RawShadingResult transformToByteBuffer = hgtCache.algorithm.transformToByteBuffer(this.hgtFileInfo, hgtCache.interpolatorOverlap ? 1 : 0);
            transformToByteBuffer.fillPadding();
            return HgtCache.this.graphicsFactory.createMonoBitmap(transformToByteBuffer.width, transformToByteBuffer.height, transformToByteBuffer.bytes, transformToByteBuffer.padding, this.hgtFileInfo);
        }
    }

    private static class Lru {
        private final LinkedHashSet<Future<HillshadingBitmap>> lru;
        private int size;

        Lru(int i3) {
            this.size = i3;
            this.lru = i3 > 0 ? new LinkedHashSet<>() : null;
        }

        void evict(Future<HillshadingBitmap> future) {
            if (this.size > 0) {
                synchronized (this.lru) {
                    this.lru.add(future);
                }
            }
        }

        public int getSize() {
            return this.size;
        }

        Future<HillshadingBitmap> markUsed(Future<HillshadingBitmap> future) {
            if (this.size <= 0 || future == null) {
                return future;
            }
            synchronized (this.lru) {
                this.lru.remove(future);
                this.lru.add(future);
                if (this.lru.size() <= this.size) {
                    return null;
                }
                Iterator<Future<HillshadingBitmap>> it = this.lru.iterator();
                Future<HillshadingBitmap> next = it.next();
                it.remove();
                return next;
            }
        }

        public void setSize(int i3) {
            this.size = Math.max(0, i3);
            if (i3 < this.lru.size()) {
                synchronized (this.lru) {
                    Iterator<Future<HillshadingBitmap>> it = this.lru.iterator();
                    while (this.lru.size() > i3) {
                        it.remove();
                    }
                }
            }
        }
    }

    class MergeOverlapFuture extends LazyFuture<HillshadingBitmap> {
        private HgtFileInfo hgtFileInfo;
        final LoadUnmergedFuture loadFuture;

        MergeOverlapFuture(HgtCache hgtCache, HgtFileInfo hgtFileInfo) {
            this(hgtFileInfo, hgtCache.new LoadUnmergedFuture(hgtFileInfo));
        }

        MergeOverlapFuture(HgtFileInfo hgtFileInfo, LoadUnmergedFuture loadUnmergedFuture) {
            this.hgtFileInfo = hgtFileInfo;
            this.loadFuture = loadUnmergedFuture;
        }

        private void mergePaddingOnBitmap(HillshadingBitmap hillshadingBitmap, HgtFileInfo hgtFileInfo, HillshadingBitmap.Border border) {
            LoadUnmergedFuture unmergedAsMergePartner;
            int padding = hillshadingBitmap.getPadding();
            if (padding < 1 || hgtFileInfo == null || (unmergedAsMergePartner = hgtFileInfo.getUnmergedAsMergePartner()) == null) {
                return;
            }
            try {
                HgtCache.mergeSameSized(hillshadingBitmap, unmergedAsMergePartner.get(), border, padding, HgtCache.this.graphicsFactory.createCanvas());
            } catch (InterruptedException | ExecutionException e3) {
                e3.printStackTrace();
            }
        }

        @Override // org.mapsforge.map.layer.hills.LatchedLazyFuture
        public HillshadingBitmap calculate() {
            HillshadingBitmap hillshadingBitmap = this.loadFuture.get();
            for (HillshadingBitmap.Border border : HillshadingBitmap.Border.values()) {
                mergePaddingOnBitmap(hillshadingBitmap, this.hgtFileInfo.getNeighbor(border), border);
            }
            return hillshadingBitmap;
        }
    }

    protected static final class TileKey {
        final int east;
        final int north;

        TileKey(int i3, int i4) {
            this.east = i4;
            this.north = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TileKey.class != obj.getClass()) {
                return false;
            }
            TileKey tileKey = (TileKey) obj;
            return this.north == tileKey.north && this.east == tileKey.east;
        }

        public int hashCode() {
            return (this.north * 31) + this.east;
        }
    }

    HgtCache(File file, boolean z3, GraphicFactory graphicFactory, ShadingAlgorithm shadingAlgorithm, int i3, int i4) {
        this.demFolder = file;
        this.interpolatorOverlap = z3;
        this.graphicsFactory = graphicFactory;
        this.algorithm = shadingAlgorithm;
        this.mainCacheSize = i3;
        this.neighborCacheSize = i4;
        this.mainLru = new Lru(i3);
        this.secondaryLru = z3 ? new Lru(i4) : null;
        this.hgtFiles = new LazyFuture<Map<TileKey, HgtFileInfo>>() { // from class: org.mapsforge.map.layer.hills.HgtCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.mapsforge.map.layer.hills.LatchedLazyFuture
            public Map<TileKey, HgtFileInfo> calculate() {
                HashMap hashMap = new HashMap();
                Matcher matcher = Pattern.compile("([ns])(\\d{1,2})([ew])(\\d{1,3})\\.hgt", 2).matcher("");
                HgtCache hgtCache = HgtCache.this;
                crawl(hgtCache.demFolder, matcher, hashMap, hgtCache.problems);
                return hashMap;
            }

            void crawl(File file2, Matcher matcher, Map<TileKey, HgtFileInfo> map, List<String> list) {
                File[] listFiles;
                if (file2.exists()) {
                    if (!file2.isFile()) {
                        if (!file2.isDirectory() || (listFiles = file2.listFiles()) == null) {
                            return;
                        }
                        for (File file3 : listFiles) {
                            crawl(file3, matcher, map, list);
                        }
                        return;
                    }
                    if (matcher.reset(file2.getName()).matches()) {
                        int parseInt = Integer.parseInt(matcher.group(2));
                        int parseInt2 = Integer.parseInt(matcher.group(4));
                        if (!"n".equals(matcher.group(1).toLowerCase())) {
                            parseInt = -parseInt;
                        }
                        if (!"e".equals(matcher.group(3).toLowerCase())) {
                            parseInt2 = -parseInt2;
                        }
                        long length = file2.length();
                        long j3 = length / 2;
                        long sqrt = (long) Math.sqrt(j3);
                        if (sqrt * sqrt == j3) {
                            TileKey tileKey = new TileKey(parseInt, parseInt2);
                            HgtFileInfo hgtFileInfo = map.get(tileKey);
                            if (hgtFileInfo == null || hgtFileInfo.size < length) {
                                map.put(tileKey, HgtCache.this.new HgtFileInfo(file2, parseInt - 1, parseInt2, parseInt, parseInt2 + 1));
                                return;
                            }
                            return;
                        }
                        if (list != null) {
                            list.add(file2 + " length in shorts (" + j3 + ") is not a square number");
                        }
                    }
                }
            }
        };
    }

    static void mergeSameSized(HillshadingBitmap hillshadingBitmap, HillshadingBitmap hillshadingBitmap2, HillshadingBitmap.Border border, int i3, Canvas canvas) {
        if (border == HillshadingBitmap.Border.EAST) {
            canvas.setBitmap(hillshadingBitmap);
            int i4 = i3 * 2;
            canvas.setClip(hillshadingBitmap.getWidth() - i3, i3, i3, hillshadingBitmap.getHeight() - i4, true);
            canvas.drawBitmap(hillshadingBitmap2, hillshadingBitmap2.getWidth() - i4, 0);
            return;
        }
        if (border == HillshadingBitmap.Border.WEST) {
            canvas.setBitmap(hillshadingBitmap);
            int i5 = i3 * 2;
            canvas.setClip(0, i3, i3, hillshadingBitmap.getHeight() - i5, true);
            canvas.drawBitmap(hillshadingBitmap2, i5 - hillshadingBitmap2.getWidth(), 0);
            return;
        }
        if (border == HillshadingBitmap.Border.NORTH) {
            canvas.setBitmap(hillshadingBitmap);
            int i6 = i3 * 2;
            canvas.setClip(i3, 0, hillshadingBitmap.getWidth() - i6, i3, true);
            canvas.drawBitmap(hillshadingBitmap2, 0, i6 - hillshadingBitmap2.getHeight());
            return;
        }
        if (border == HillshadingBitmap.Border.SOUTH) {
            canvas.setBitmap(hillshadingBitmap);
            int i7 = i3 * 2;
            canvas.setClip(i3, hillshadingBitmap.getHeight() - i3, hillshadingBitmap.getWidth() - i7, i3, true);
            canvas.drawBitmap(hillshadingBitmap2, 0, hillshadingBitmap2.getHeight() - i7);
        }
    }

    HillshadingBitmap getHillshadingBitmap(int i3, int i4, double d3, double d4) {
        HgtFileInfo hgtFileInfo = this.hgtFiles.get().get(new TileKey(i3, i4));
        if (hgtFileInfo == null) {
            return null;
        }
        return hgtFileInfo.getBitmapFuture(d3, d4).get();
    }

    void indexOnThread() {
        this.hgtFiles.withRunningThread();
    }
}
