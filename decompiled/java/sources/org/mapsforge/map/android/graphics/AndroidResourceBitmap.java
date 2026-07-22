package org.mapsforge.map.android.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicUtils;
import org.mapsforge.core.graphics.ResourceBitmap;

/* loaded from: /root/release/classes2.dex */
public class AndroidResourceBitmap extends AndroidBitmap implements ResourceBitmap {
    protected static final Logger LOGGER = Logger.getLogger(AndroidResourceBitmap.class.getName());
    protected static final Map<Integer, Pair<Bitmap, Integer>> RESOURCE_BITMAPS = new HashMap();
    protected static Set<Integer> rBitmaps;
    protected static AtomicInteger rInstances;
    private final int hash;

    protected AndroidResourceBitmap(int i3) {
        this.hash = i3;
    }

    AndroidResourceBitmap(InputStream inputStream, float f3, int i3, int i4, int i5, int i6) {
        this(i6);
        this.bitmap = getResourceBitmap(inputStream, f3, i3, i4, i5, i6);
    }

    public static void clearResourceBitmaps() {
        Map<Integer, Pair<Bitmap, Integer>> map = RESOURCE_BITMAPS;
        synchronized (map) {
            Iterator<Pair<Bitmap, Integer>> it = map.values().iterator();
            while (it.hasNext()) {
                ((Bitmap) it.next().first).recycle();
            }
            RESOURCE_BITMAPS.clear();
        }
    }

    private static Bitmap getResourceBitmap(InputStream inputStream, float f3, int i3, int i4, int i5, int i6) {
        Map<Integer, Pair<Bitmap, Integer>> map = RESOURCE_BITMAPS;
        synchronized (map) {
            Pair<Bitmap, Integer> pair = map.get(Integer.valueOf(i6));
            if (pair != null) {
                map.put(Integer.valueOf(i6), new Pair<>(pair.first, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
                return (Bitmap) pair.first;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, AndroidBitmap.createBitmapFactoryOptions(AndroidGraphicFactory.TRANSPARENT_BITMAP));
            if (decodeStream == null) {
                throw new IOException("BitmapFactory failed to decodeStream");
            }
            float[] imageSize = GraphicUtils.imageSize(decodeStream.getWidth(), decodeStream.getHeight(), f3, i3, i4, i5);
            if (((int) imageSize[0]) != decodeStream.getWidth() || ((int) imageSize[1]) != decodeStream.getHeight()) {
                decodeStream = Bitmap.createScaledBitmap(decodeStream, (int) imageSize[0], (int) imageSize[1], true);
            }
            map.put(Integer.valueOf(i6), new Pair<>(decodeStream, 1));
            return decodeStream;
        }
    }

    private static boolean removeBitmap(int i3) {
        return false;
    }

    @Override // org.mapsforge.map.android.graphics.AndroidBitmap
    protected void destroyBitmap() {
        if (this.bitmap != null) {
            if (removeBitmap(this.hash)) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
        }
    }
}
