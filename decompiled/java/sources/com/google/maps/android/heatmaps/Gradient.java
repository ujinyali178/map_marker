package com.google.maps.android.heatmaps;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;

/* loaded from: /root/release/classes.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    private class ColorInterval {
        private final int color1;
        private final int color2;
        private final float duration;

        private ColorInterval(int i3, int i4, float f3) {
            this.color1 = i3;
            this.color2 = i4;
            this.duration = f3;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i3) {
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i4 = 1; i4 < fArr.length; i4++) {
            if (fArr[i4] <= fArr[i4 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.mColorMapSize = i3;
        int[] iArr2 = new int[iArr.length];
        this.mColors = iArr2;
        this.mStartPoints = new float[fArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
    }

    private HashMap<Integer, ColorInterval> generateColorIntervals() {
        HashMap<Integer, ColorInterval> hashMap = new HashMap<>();
        if (this.mStartPoints[0] != BitmapDescriptorFactory.HUE_RED) {
            hashMap.put(0, new ColorInterval(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0]));
        }
        for (int i3 = 1; i3 < this.mColors.length; i3++) {
            int i4 = i3 - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i4]));
            int[] iArr = this.mColors;
            int i5 = iArr[i4];
            int i6 = iArr[i3];
            float f3 = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new ColorInterval(i5, i6, (fArr[i3] - fArr[i4]) * f3));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int i7 = this.mColors[length];
            hashMap.put(valueOf2, new ColorInterval(i7, i7, this.mColorMapSize * (1.0f - this.mStartPoints[length])));
        }
        return hashMap;
    }

    static int interpolateColor(int i3, int i4, float f3) {
        int alpha = (int) (((Color.alpha(i4) - Color.alpha(i3)) * f3) + Color.alpha(i3));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i4), Color.green(i4), Color.blue(i4), fArr2);
        float f4 = fArr[0];
        float f5 = fArr2[0];
        if (f4 - f5 > 180.0f) {
            fArr2[0] = f5 + 360.0f;
        } else if (f5 - f4 > 180.0f) {
            fArr[0] = f4 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i5 = 0; i5 < 3; i5++) {
            float f6 = fArr2[i5];
            float f7 = fArr[i5];
            fArr3[i5] = ((f6 - f7) * f3) + f7;
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    int[] generateColorMap(double d3) {
        HashMap<Integer, ColorInterval> generateColorIntervals = generateColorIntervals();
        int[] iArr = new int[this.mColorMapSize];
        ColorInterval colorInterval = generateColorIntervals.get(0);
        int i3 = 0;
        for (int i4 = 0; i4 < this.mColorMapSize; i4++) {
            if (generateColorIntervals.containsKey(Integer.valueOf(i4))) {
                colorInterval = generateColorIntervals.get(Integer.valueOf(i4));
                i3 = i4;
            }
            iArr[i4] = interpolateColor(colorInterval.color1, colorInterval.color2, (i4 - i3) / colorInterval.duration);
        }
        if (d3 != 1.0d) {
            for (int i5 = 0; i5 < this.mColorMapSize; i5++) {
                int i6 = iArr[i5];
                iArr[i5] = Color.argb((int) (Color.alpha(i6) * d3), Color.red(i6), Color.green(i6), Color.blue(i6));
            }
        }
        return iArr;
    }
}
