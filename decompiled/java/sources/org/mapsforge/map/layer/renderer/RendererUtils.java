package org.mapsforge.map.layer.renderer;

import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
class RendererUtils {
    private RendererUtils() {
        throw new IllegalStateException();
    }

    static Point[] parallelPath(Point[] pointArr, double d3) {
        Point[] pointArr2 = pointArr;
        int length = pointArr2.length - 1;
        Point[] pointArr3 = new Point[length];
        Point[] pointArr4 = new Point[pointArr2.length];
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            Point point = pointArr2[i4];
            double d4 = point.f4076x;
            Point point2 = pointArr2[i3];
            double d5 = d4 - point2.f4076x;
            double d6 = point.f4077y - point2.f4077y;
            double sqrt = Math.sqrt((d5 * d5) + (d6 * d6));
            Point[] pointArr5 = pointArr3;
            if (sqrt == 0.0d) {
                pointArr5[i3] = new Point(0.0d, 0.0d);
            } else {
                pointArr5[i3] = new Point(d5 / sqrt, d6 / sqrt);
            }
            i3 = i4;
            pointArr3 = pointArr5;
        }
        Point[] pointArr6 = pointArr3;
        Point point3 = pointArr2[0];
        double d7 = point3.f4076x;
        Point point4 = pointArr6[0];
        pointArr4[0] = new Point(d7 - (point4.f4077y * d3), point3.f4077y + (point4.f4076x * d3));
        int i5 = 1;
        while (i5 < length) {
            Point point5 = pointArr6[i5];
            double d8 = point5.f4076x;
            Point point6 = pointArr6[i5 - 1];
            double d9 = point6.f4076x;
            double d10 = point5.f4077y;
            double d11 = point6.f4077y;
            double d12 = d3 / (((d8 * d9) + 1.0d) + (d10 * d11));
            Point[] pointArr7 = pointArr6;
            Point point7 = pointArr2[i5];
            pointArr4[i5] = new Point(point7.f4076x - ((d10 + d11) * d12), point7.f4077y + (d12 * (d8 + d9)));
            i5++;
            pointArr2 = pointArr;
            pointArr6 = pointArr7;
            length = length;
        }
        int i6 = length;
        Point point8 = pointArr[i6];
        double d13 = point8.f4076x;
        Point point9 = pointArr6[i6 - 1];
        pointArr4[i6] = new Point(d13 - (point9.f4077y * d3), point8.f4077y + (point9.f4076x * d3));
        return pointArr4;
    }
}
