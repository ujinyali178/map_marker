package androidx.core.graphics;

import android.graphics.Color;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f661a = new ThreadLocal<>();

    public static int a(double d3, double d4, double d5) {
        double d6 = (((3.2406d * d3) + ((-1.5372d) * d4)) + ((-0.4986d) * d5)) / 100.0d;
        double d7 = ((((-0.9689d) * d3) + (1.8758d * d4)) + (0.0415d * d5)) / 100.0d;
        double d8 = (((0.0557d * d3) + ((-0.204d) * d4)) + (1.057d * d5)) / 100.0d;
        return Color.rgb(b((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), b((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255), b((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255));
    }

    private static int b(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : Math.min(i3, i5);
    }
}
