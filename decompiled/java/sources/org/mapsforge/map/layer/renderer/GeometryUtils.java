package org.mapsforge.map.layer.renderer;

import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
final class GeometryUtils {
    private GeometryUtils() {
        throw new IllegalStateException();
    }

    static Point calculateCenterOfBoundingBox(Point[] pointArr) {
        Point point = pointArr[0];
        double d3 = point.f4076x;
        double d4 = point.f4077y;
        double d5 = d4;
        double d6 = d3;
        for (Point point2 : pointArr) {
            double d7 = point2.f4076x;
            if (d7 < d3) {
                d3 = d7;
            } else if (d7 > d6) {
                d6 = d7;
            }
            double d8 = point2.f4077y;
            if (d8 < d5) {
                d5 = d8;
            } else if (d8 > d4) {
                d4 = d8;
            }
        }
        return new Point((d3 + d6) / 2.0d, (d4 + d5) / 2.0d);
    }
}
