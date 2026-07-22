package org.mapsforge.map.android.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.CorruptedInputStreamException;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.util.IOUtils;

/* loaded from: /root/release/classes2.dex */
public class AndroidTileBitmap extends AndroidBitmap implements TileBitmap {
    private static final Logger LOGGER = Logger.getLogger(AndroidTileBitmap.class.getName());
    private static Map<Integer, Set<SoftReference<Bitmap>>> reusableTileBitmaps = new HashMap();
    private static AtomicInteger tileInstances;
    private long expiration = 0;
    private long timestamp = System.currentTimeMillis();

    AndroidTileBitmap(int i3, boolean z3) {
        Bitmap tileBitmapFromReusableSet = getTileBitmapFromReusableSet(i3, z3);
        this.bitmap = tileBitmapFromReusableSet;
        if (tileBitmapFromReusableSet == null) {
            this.bitmap = AndroidBitmap.createAndroidBitmap(i3, i3, z3 ? AndroidGraphicFactory.TRANSPARENT_BITMAP : AndroidGraphicFactory.NON_TRANSPARENT_BITMAP);
        }
    }

    AndroidTileBitmap(InputStream inputStream, int i3, boolean z3) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, createTileBitmapFactoryOptions(i3, z3));
            this.bitmap = decodeStream;
            decodeStream.getWidth();
        } catch (Exception e3) {
            LOGGER.info("TILEBITMAP ERROR " + e3.toString());
            this.bitmap = null;
            IOUtils.closeQuietly(inputStream);
            destroy();
            throw new CorruptedInputStreamException("Corrupted bitmap input stream", e3);
        }
    }

    private static int composeHash(int i3, boolean z3) {
        return z3 ? i3 + 268435456 : i3;
    }

    private BitmapFactory.Options createTileBitmapFactoryOptions(int i3, boolean z3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = z3 ? AndroidGraphicFactory.TRANSPARENT_BITMAP : AndroidGraphicFactory.NON_TRANSPARENT_BITMAP;
        if (getTileBitmapFromReusableSet(i3, z3) != null) {
            options.inMutable = true;
            options.inSampleSize = 1;
            options.inBitmap = getTileBitmapFromReusableSet(i3, z3);
        }
        return options;
    }

    private static Bitmap getTileBitmapFromReusableSet(int i3, boolean z3) {
        int composeHash = composeHash(i3, z3);
        synchronized (reusableTileBitmaps) {
            Set<SoftReference<Bitmap>> set = reusableTileBitmaps.get(Integer.valueOf(composeHash));
            Bitmap bitmap = null;
            if (set == null) {
                return null;
            }
            Iterator<SoftReference<Bitmap>> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Bitmap bitmap2 = it.next().get();
                if (bitmap2 == null || !bitmap2.isMutable()) {
                    it.remove();
                } else {
                    if (z3) {
                        bitmap2.eraseColor(0);
                    }
                    it.remove();
                    bitmap = bitmap2;
                }
            }
            return bitmap;
        }
    }

    @Override // org.mapsforge.map.android.graphics.AndroidBitmap
    protected void destroy() {
        super.destroy();
    }

    @Override // org.mapsforge.map.android.graphics.AndroidBitmap
    protected void destroyBitmap() {
        if (this.bitmap != null) {
            int height = getHeight();
            synchronized (reusableTileBitmaps) {
                int composeHash = composeHash(height, this.bitmap.hasAlpha());
                if (!reusableTileBitmaps.containsKey(Integer.valueOf(composeHash))) {
                    reusableTileBitmaps.put(Integer.valueOf(composeHash), new HashSet());
                }
                reusableTileBitmaps.get(Integer.valueOf(composeHash)).add(new SoftReference<>(this.bitmap));
            }
            this.bitmap = null;
        }
    }

    @Override // org.mapsforge.core.graphics.TileBitmap
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // org.mapsforge.core.graphics.TileBitmap
    public boolean isExpired() {
        long j3 = this.expiration;
        return j3 != 0 && j3 <= System.currentTimeMillis();
    }

    @Override // org.mapsforge.core.graphics.TileBitmap
    public void setExpiration(long j3) {
        this.expiration = j3;
    }

    @Override // org.mapsforge.core.graphics.TileBitmap
    public void setTimestamp(long j3) {
        this.timestamp = j3;
    }
}
