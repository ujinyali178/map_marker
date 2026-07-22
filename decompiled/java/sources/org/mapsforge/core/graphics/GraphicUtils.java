package org.mapsforge.core.graphics;

/* loaded from: /root/release/classes2.dex */
public final class GraphicUtils {

    /* renamed from: org.mapsforge.core.graphics.GraphicUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Filter;

        static {
            int[] iArr = new int[Filter.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Filter = iArr;
            try {
                iArr[Filter.GRAYSCALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Filter[Filter.GRAYSCALE_INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Filter[Filter.INVERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private GraphicUtils() {
    }

    public static int filterColor(int i3, Filter filter) {
        if (filter == Filter.NONE) {
            return i3;
        }
        int i4 = i3 >>> 24;
        int i5 = (i3 >> 16) & 255;
        int i6 = (i3 >> 8) & 255;
        int i7 = i3 & 255;
        int i8 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Filter[filter.ordinal()];
        if (i8 == 1) {
            i5 = (int) ((i5 * 0.213f) + (i6 * 0.715f) + (i7 * 0.072f));
        } else {
            if (i8 != 2) {
                if (i8 == 3) {
                    i5 = 255 - i5;
                    i6 = 255 - i6;
                    i7 = 255 - i7;
                }
                return i7 | (i4 << 24) | (i5 << 16) | (i6 << 8);
            }
            i5 = 255 - ((int) (((i5 * 0.213f) + (i6 * 0.715f)) + (i7 * 0.072f)));
        }
        i7 = i5;
        i6 = i7;
        return i7 | (i4 << 24) | (i5 << 16) | (i6 << 8);
    }

    public static int getAlpha(int i3) {
        return (i3 >> 24) & 255;
    }

    public static float[] imageSize(float f3, float f4, float f5, int i3, int i4, int i5) {
        float f6 = f3 * f5;
        float f7 = f5 * f4;
        float f8 = f3 / f4;
        if (i3 != 0 && i4 != 0) {
            f6 = i3;
            f7 = i4;
        } else if (i3 == 0 && i4 != 0) {
            f7 = i4;
            f6 = f7 * f8;
        } else if (i3 != 0 && i4 == 0) {
            f6 = i3;
            f7 = f6 / f8;
        }
        if (i5 != 100) {
            float f9 = i5 / 100.0f;
            f6 *= f9;
            f7 *= f9;
        }
        return new float[]{f6, f7};
    }
}
