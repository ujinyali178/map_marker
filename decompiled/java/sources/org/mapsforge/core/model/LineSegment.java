package org.mapsforge.core.model;

/* loaded from: /root/release/classes2.dex */
public final class LineSegment {
    private static int BOTTOM = 4;
    private static int INSIDE = 0;
    private static int LEFT = 1;
    private static int RIGHT = 2;
    private static int TOP = 8;
    public final Point end;
    public final Point start;

    public LineSegment(Point point, Point point2) {
        this.start = point;
        this.end = point2;
    }

    public LineSegment(Point point, Point point2, double d3) {
        this.start = point;
        this.end = new LineSegment(point, point2).pointAlongLineSegment(d3);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int code(org.mapsforge.core.model.Rectangle r6, org.mapsforge.core.model.Point r7) {
        /*
            int r0 = org.mapsforge.core.model.LineSegment.INSIDE
            double r1 = r7.f4076x
            double r3 = r6.left
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto Le
            int r1 = org.mapsforge.core.model.LineSegment.LEFT
        Lc:
            r0 = r0 | r1
            goto L17
        Le:
            double r3 = r6.right
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L17
            int r1 = org.mapsforge.core.model.LineSegment.RIGHT
            goto Lc
        L17:
            double r1 = r7.f4077y
            double r3 = r6.bottom
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L23
            int r6 = org.mapsforge.core.model.LineSegment.BOTTOM
        L21:
            r0 = r0 | r6
            goto L2c
        L23:
            double r6 = r6.top
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L2c
            int r6 = org.mapsforge.core.model.LineSegment.TOP
            goto L21
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.core.model.LineSegment.code(org.mapsforge.core.model.Rectangle, org.mapsforge.core.model.Point):int");
    }

    public double angleTo(LineSegment lineSegment) {
        Point point = this.start;
        double d3 = point.f4077y;
        Point point2 = this.end;
        double atan2 = Math.atan2(d3 - point2.f4077y, point.f4076x - point2.f4076x);
        Point point3 = lineSegment.start;
        double d4 = point3.f4077y;
        Point point4 = lineSegment.end;
        double degrees = Math.toDegrees(atan2 - Math.atan2(d4 - point4.f4077y, point3.f4076x - point4.f4076x));
        if (degrees <= -180.0d) {
            degrees += 360.0d;
        }
        return degrees >= 180.0d ? degrees - 360.0d : degrees;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0076 A[LOOP:1: B:3:0x0010->B:14:0x0076, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mapsforge.core.model.LineSegment clipToRectangle(org.mapsforge.core.model.Rectangle r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            org.mapsforge.core.model.Point r2 = r0.start
            org.mapsforge.core.model.Point r3 = r0.end
            int r4 = code(r1, r2)
        Lc:
            int r5 = code(r1, r3)
        L10:
            r6 = r4 | r5
            if (r6 != 0) goto L1a
            org.mapsforge.core.model.LineSegment r1 = new org.mapsforge.core.model.LineSegment
            r1.<init>(r2, r3)
            return r1
        L1a:
            r6 = r4 & r5
            if (r6 == 0) goto L20
            r1 = 0
            return r1
        L20:
            if (r4 == 0) goto L24
            r6 = r4
            goto L25
        L24:
            r6 = r5
        L25:
            int r7 = org.mapsforge.core.model.LineSegment.TOP
            r7 = r7 & r6
            if (r7 == 0) goto L3f
            double r7 = r2.f4076x
            double r9 = r3.f4076x
            double r9 = r9 - r7
            double r11 = r1.top
        L31:
            double r13 = r2.f4077y
            double r15 = r11 - r13
            double r9 = r9 * r15
            r15 = r11
            double r11 = r3.f4077y
            double r11 = r11 - r13
            double r9 = r9 / r11
            double r7 = r7 + r9
            r11 = r15
            goto L74
        L3f:
            int r7 = org.mapsforge.core.model.LineSegment.BOTTOM
            r7 = r7 & r6
            if (r7 == 0) goto L4c
            double r7 = r2.f4076x
            double r9 = r3.f4076x
            double r9 = r9 - r7
            double r11 = r1.bottom
            goto L31
        L4c:
            int r7 = org.mapsforge.core.model.LineSegment.RIGHT
            r7 = r7 & r6
            if (r7 == 0) goto L67
            double r7 = r2.f4077y
            double r9 = r3.f4077y
            double r9 = r9 - r7
            double r11 = r1.right
        L58:
            double r13 = r2.f4076x
            double r15 = r11 - r13
            double r9 = r9 * r15
            r15 = r11
            double r11 = r3.f4076x
            double r11 = r11 - r13
            double r9 = r9 / r11
            double r11 = r7 + r9
            r7 = r15
            goto L74
        L67:
            int r7 = org.mapsforge.core.model.LineSegment.LEFT
            r7 = r7 & r6
            if (r7 == 0) goto L86
            double r7 = r2.f4077y
            double r9 = r3.f4077y
            double r9 = r9 - r7
            double r11 = r1.left
            goto L58
        L74:
            if (r6 != r4) goto L80
            org.mapsforge.core.model.Point r2 = new org.mapsforge.core.model.Point
            r2.<init>(r7, r11)
            int r4 = code(r1, r2)
            goto L10
        L80:
            org.mapsforge.core.model.Point r3 = new org.mapsforge.core.model.Point
            r3.<init>(r7, r11)
            goto Lc
        L86:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Should not get here"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.core.model.LineSegment.clipToRectangle(org.mapsforge.core.model.Rectangle):org.mapsforge.core.model.LineSegment");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineSegment)) {
            return false;
        }
        LineSegment lineSegment = (LineSegment) obj;
        return lineSegment.start.equals(this.start) && lineSegment.end.equals(this.end);
    }

    public int hashCode() {
        return ((this.start.hashCode() + 31) * 31) + this.end.hashCode();
    }

    public boolean intersectsRectangle(Rectangle rectangle, boolean z3) {
        int code = code(rectangle, this.start);
        int code2 = code(rectangle, this.end);
        if ((code | code2) == 0) {
            return true;
        }
        if ((code2 & code) != 0) {
            return false;
        }
        return z3;
    }

    public double length() {
        return this.start.distance(this.end);
    }

    public Point pointAlongLineSegment(double d3) {
        Point point = this.start;
        double d4 = point.f4076x;
        Point point2 = this.end;
        double d5 = point2.f4076x;
        if (d4 == d5) {
            double d6 = point.f4077y;
            double d7 = point2.f4077y;
            return d6 > d7 ? new Point(d5, d7 + d3) : new Point(d4, d6 + d3);
        }
        double d8 = (point2.f4077y - point.f4077y) / (d5 - d4);
        double sqrt = Math.sqrt((d3 * d3) / ((d8 * d8) + 1.0d));
        double d9 = this.end.f4076x;
        Point point3 = this.start;
        double d10 = point3.f4076x;
        if (d9 < d10) {
            sqrt *= -1.0d;
        }
        return new Point(d10 + sqrt, point3.f4077y + (d8 * sqrt));
    }

    public LineSegment reverse() {
        return new LineSegment(this.end, this.start);
    }

    public LineSegment subSegment(double d3, double d4) {
        return new LineSegment(pointAlongLineSegment(d3), pointAlongLineSegment(d3 + d4));
    }

    public String toString() {
        return this.start + " " + this.end;
    }
}
