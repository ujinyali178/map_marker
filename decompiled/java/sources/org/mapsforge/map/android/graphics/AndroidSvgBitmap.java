package org.mapsforge.map.android.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Pair;
import c0.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.mapsforge.core.graphics.GraphicUtils;

/* loaded from: /root/release/classes2.dex */
public class AndroidSvgBitmap extends AndroidResourceBitmap {
    public static float DEFAULT_SIZE = 400.0f;

    public AndroidSvgBitmap(InputStream inputStream, int i3, float f3, int i4, int i5, int i6) {
        super(i3);
        this.bitmap = getResourceBitmapImpl(inputStream, i3, f3, i4, i5, i6);
    }

    public static Bitmap getResourceBitmap(InputStream inputStream, float f3, float f4, int i3, int i4, int i5) {
        try {
            Picture k3 = g.h(inputStream).k();
            float[] imageSize = GraphicUtils.imageSize(k3.getWidth(), k3.getHeight(), (float) (f3 / Math.sqrt((k3.getHeight() * k3.getWidth()) / f4)), i3, i4, i5);
            Bitmap createBitmap = Bitmap.createBitmap((int) Math.ceil(imageSize[0]), (int) Math.ceil(imageSize[1]), AndroidGraphicFactory.TRANSPARENT_BITMAP);
            new Canvas(createBitmap).drawPicture(k3, new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, imageSize[0], imageSize[1]));
            return createBitmap;
        } catch (Exception e3) {
            throw new IOException(e3);
        }
    }

    private static Bitmap getResourceBitmapImpl(InputStream inputStream, int i3, float f3, int i4, int i5, int i6) {
        Map<Integer, Pair<Bitmap, Integer>> map = AndroidResourceBitmap.RESOURCE_BITMAPS;
        synchronized (map) {
            Pair<Bitmap, Integer> pair = map.get(Integer.valueOf(i3));
            if (pair != null) {
                map.put(Integer.valueOf(i3), new Pair<>(pair.first, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
                return (Bitmap) pair.first;
            }
            Bitmap bitmap = AndroidSvgBitmapStore.get(i3);
            if (bitmap == null) {
                bitmap = getResourceBitmap(inputStream, f3, DEFAULT_SIZE, i4, i5, i6);
                AndroidSvgBitmapStore.put(i3, bitmap);
            }
            map.put(Integer.valueOf(i3), new Pair<>(bitmap, 1));
            return bitmap;
        }
    }
}
