package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 22;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 512;
    static final double WORLD_WIDTH = 1.0d;
    private Bounds mBounds;
    private int[] mColorMap;
    private double mCustomMaxIntensity;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private PointQuadTree<WeightedLatLng> mTree;

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 20;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.7d;
        private double intensity = 0.0d;

        public HeatmapTileProvider build() {
            if (this.data != null) {
                return new HeatmapTileProvider(this);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.wrapData(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder maxIntensity(double d3) {
            this.intensity = d3;
            return this;
        }

        public Builder opacity(double d3) {
            this.opacity = d3;
            if (d3 < 0.0d || d3 > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder radius(int i3) {
            this.radius = i3;
            if (i3 < 10 || i3 > HeatmapTileProvider.MAX_RADIUS) {
                throw new IllegalArgumentException("Radius not within bounds.");
            }
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        this.mGradient = builder.gradient;
        this.mOpacity = builder.opacity;
        this.mCustomMaxIntensity = builder.intensity;
        int i3 = this.mRadius;
        this.mKernel = generateKernel(i3, i3 / 3.0d);
        setGradient(this.mGradient);
        setWeightedData(this.mData);
    }

    static Bitmap colorize(double[][] dArr, int[] iArr, double d3) {
        int i3 = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d3;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i4 = 0; i4 < length2; i4++) {
            for (int i5 = 0; i5 < length2; i5++) {
                double d4 = dArr[i5][i4];
                int i6 = (i4 * length2) + i5;
                int i7 = (int) (d4 * length);
                if (d4 == 0.0d) {
                    iArr2[i6] = 0;
                } else if (i7 < iArr.length) {
                    iArr2[i6] = iArr[i7];
                } else {
                    iArr2[i6] = i3;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static Tile convertBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(512, 512, byteArrayOutputStream.toByteArray());
    }

    static double[][] convolve(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i3 = length - (floor * 2);
        int i4 = 1;
        int i5 = (floor + i3) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
        int i6 = 0;
        while (true) {
            double d3 = 0.0d;
            if (i6 >= length) {
                break;
            }
            int i7 = 0;
            while (i7 < length) {
                double d4 = dArr[i6][i7];
                if (d4 != d3) {
                    int i8 = i6 + floor;
                    if (i5 < i8) {
                        i8 = i5;
                    }
                    int i9 = i8 + 1;
                    int i10 = i6 - floor;
                    for (int i11 = floor > i10 ? floor : i10; i11 < i9; i11++) {
                        double[] dArr4 = dArr3[i11];
                        dArr4[i7] = dArr4[i7] + (dArr2[i11 - i10] * d4);
                    }
                }
                i7++;
                d3 = 0.0d;
            }
            i6++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i3);
        int i12 = floor;
        while (i12 < i5 + 1) {
            int i13 = 0;
            while (i13 < length) {
                double d5 = dArr3[i12][i13];
                if (d5 != 0.0d) {
                    int i14 = i13 + floor;
                    if (i5 < i14) {
                        i14 = i5;
                    }
                    int i15 = i14 + i4;
                    int i16 = i13 - floor;
                    for (int i17 = floor > i16 ? floor : i16; i17 < i15; i17++) {
                        double[] dArr6 = dArr5[i12 - floor];
                        int i18 = i17 - floor;
                        dArr6[i18] = dArr6[i18] + (dArr2[i17 - i16] * d5);
                    }
                }
                i13++;
                i4 = 1;
            }
            i12++;
            i4 = 1;
        }
        return dArr5;
    }

    static double[] generateKernel(int i3, double d3) {
        double[] dArr = new double[(i3 * 2) + 1];
        for (int i4 = -i3; i4 <= i3; i4++) {
            dArr[i4 + i3] = Math.exp(((-i4) * i4) / ((2.0d * d3) * d3));
        }
        return dArr;
    }

    static Bounds getBounds(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d3 = next.getPoint().f2375x;
        double d4 = next.getPoint().f2375x;
        double d5 = d3;
        double d6 = d4;
        double d7 = next.getPoint().f2376y;
        double d8 = next.getPoint().f2376y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d9 = next2.getPoint().f2375x;
            double d10 = next2.getPoint().f2376y;
            if (d9 < d5) {
                d5 = d9;
            }
            if (d9 > d6) {
                d6 = d9;
            }
            if (d10 < d7) {
                d7 = d10;
            }
            if (d10 > d8) {
                d8 = d10;
            }
        }
        return new Bounds(d5, d6, d7, d8);
    }

    private double[] getMaxIntensities(int i3) {
        int i4;
        double[] dArr = new double[22];
        if (this.mCustomMaxIntensity != 0.0d) {
            for (int i5 = 0; i5 < 22; i5++) {
                dArr[i5] = this.mCustomMaxIntensity;
            }
            return dArr;
        }
        int i6 = 5;
        while (true) {
            if (i6 >= 11) {
                break;
            }
            dArr[i6] = getMaxValue(this.mData, this.mBounds, i3, (int) (Math.pow(2.0d, i6 - 3) * 1280.0d));
            if (i6 == 5) {
                for (int i7 = 0; i7 < i6; i7++) {
                    dArr[i7] = dArr[i6];
                }
            }
            i6++;
        }
        for (i4 = 11; i4 < 22; i4++) {
            dArr[i4] = dArr[10];
        }
        return dArr;
    }

    static double getMaxValue(Collection<WeightedLatLng> collection, Bounds bounds, int i3, int i4) {
        double d3 = bounds.minX;
        double d4 = bounds.maxX;
        double d5 = bounds.minY;
        double d6 = d4 - d3;
        double d7 = bounds.maxY - d5;
        if (d6 <= d7) {
            d6 = d7;
        }
        double d8 = ((int) ((i4 / (i3 * 2)) + 0.5d)) / d6;
        d dVar = new d();
        double d9 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d10 = weightedLatLng.getPoint().f2375x;
            int i5 = (int) ((weightedLatLng.getPoint().f2376y - d5) * d8);
            long j3 = (int) ((d10 - d3) * d8);
            d dVar2 = (d) dVar.c(j3);
            if (dVar2 == null) {
                dVar2 = new d();
                dVar.f(j3, dVar2);
            }
            long j4 = i5;
            Double d11 = (Double) dVar2.c(j4);
            if (d11 == null) {
                d11 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(d11.doubleValue() + weightedLatLng.getIntensity());
            dVar2.f(j4, valueOf);
            if (valueOf.doubleValue() > d9) {
                d9 = valueOf.doubleValue();
            }
        }
        return d9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00a5  */
    @Override // com.google.android.gms.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.maps.model.Tile getTile(int r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.heatmaps.HeatmapTileProvider.getTile(int, int, int):com.google.android.gms.maps.model.Tile");
    }

    public void setData(Collection<LatLng> collection) {
        setWeightedData(wrapData(collection));
    }

    public void setGradient(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    public void setMaxIntensity(double d3) {
        this.mCustomMaxIntensity = d3;
        setWeightedData(this.mData);
    }

    public void setOpacity(double d3) {
        this.mOpacity = d3;
        setGradient(this.mGradient);
    }

    public void setRadius(int i3) {
        this.mRadius = i3;
        this.mKernel = generateKernel(i3, i3 / 3.0d);
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setWeightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        Bounds bounds = getBounds(this.mData);
        this.mBounds = bounds;
        this.mTree = new PointQuadTree<>(bounds);
        Iterator<WeightedLatLng> it = this.mData.iterator();
        while (it.hasNext()) {
            this.mTree.add(it.next());
        }
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }
}
