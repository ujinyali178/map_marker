package org.mapsforge.core.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes2.dex */
public class LineString {
    public final List<LineSegment> segments = new ArrayList();

    public void LineString() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineString)) {
            return false;
        }
        LineString lineString = (LineString) obj;
        if (lineString.segments.size() != this.segments.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.segments.size(); i3++) {
            if (!this.segments.get(i3).equals(lineString.segments.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008c A[EDGE_INSN: B:17:0x008c->B:18:0x008c BREAK  A[LOOP:0: B:2:0x0006->B:21:0x006e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mapsforge.core.model.LineString extractPart(double r10, double r12) {
        /*
            r9 = this;
            org.mapsforge.core.model.LineString r0 = new org.mapsforge.core.model.LineString
            r0.<init>()
            r1 = 0
        L6:
            java.util.List<org.mapsforge.core.model.LineSegment> r2 = r9.segments
            int r2 = r2.size()
            if (r1 >= r2) goto L8c
            java.util.List<org.mapsforge.core.model.LineSegment> r2 = r9.segments
            java.lang.Object r2 = r2.get(r1)
            org.mapsforge.core.model.LineSegment r2 = (org.mapsforge.core.model.LineSegment) r2
            double r3 = r2.length()
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 >= 0) goto L1f
            goto L6e
        L1f:
            r5 = 0
            r7 = 0
            int r8 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r8 < 0) goto L2b
            org.mapsforge.core.model.Point r5 = r2.pointAlongLineSegment(r10)
            goto L2c
        L2b:
            r5 = r7
        L2c:
            int r6 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r6 >= 0) goto L34
            org.mapsforge.core.model.Point r7 = r2.pointAlongLineSegment(r12)
        L34:
            if (r5 == 0) goto L45
            if (r7 != 0) goto L45
            java.util.List<org.mapsforge.core.model.LineSegment> r3 = r0.segments
            org.mapsforge.core.model.LineSegment r4 = new org.mapsforge.core.model.LineSegment
            org.mapsforge.core.model.Point r2 = r2.end
            r4.<init>(r5, r2)
        L41:
            r3.add(r4)
            goto L6b
        L45:
            if (r5 != 0) goto L4f
            if (r7 != 0) goto L4f
            java.util.List<org.mapsforge.core.model.LineSegment> r3 = r0.segments
            r3.add(r2)
            goto L6b
        L4f:
            if (r5 != 0) goto L5d
            if (r7 == 0) goto L5d
            java.util.List<org.mapsforge.core.model.LineSegment> r3 = r0.segments
            org.mapsforge.core.model.LineSegment r4 = new org.mapsforge.core.model.LineSegment
            org.mapsforge.core.model.Point r2 = r2.start
            r4.<init>(r2, r7)
            goto L41
        L5d:
            if (r5 == 0) goto L6b
            if (r7 == 0) goto L6b
            java.util.List<org.mapsforge.core.model.LineSegment> r2 = r0.segments
            org.mapsforge.core.model.LineSegment r3 = new org.mapsforge.core.model.LineSegment
            r3.<init>(r5, r7)
            r2.add(r3)
        L6b:
            if (r7 == 0) goto L6e
            goto L8c
        L6e:
            java.util.List<org.mapsforge.core.model.LineSegment> r2 = r9.segments
            java.lang.Object r2 = r2.get(r1)
            org.mapsforge.core.model.LineSegment r2 = (org.mapsforge.core.model.LineSegment) r2
            double r2 = r2.length()
            double r10 = r10 - r2
            java.util.List<org.mapsforge.core.model.LineSegment> r2 = r9.segments
            java.lang.Object r2 = r2.get(r1)
            org.mapsforge.core.model.LineSegment r2 = (org.mapsforge.core.model.LineSegment) r2
            double r2 = r2.length()
            double r12 = r12 - r2
            int r1 = r1 + 1
            goto L6
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.core.model.LineString.extractPart(double, double):org.mapsforge.core.model.LineString");
    }

    public Rectangle getBounds() {
        double d3 = Double.MIN_VALUE;
        double d4 = Double.MIN_VALUE;
        double d5 = Double.MAX_VALUE;
        double d6 = Double.MAX_VALUE;
        for (LineSegment lineSegment : this.segments) {
            d5 = Math.min(d5, Math.min(lineSegment.start.f4076x, lineSegment.end.f4076x));
            d6 = Math.min(d6, Math.min(lineSegment.start.f4077y, lineSegment.end.f4077y));
            d3 = Math.max(d3, Math.max(lineSegment.start.f4076x, lineSegment.end.f4076x));
            d4 = Math.max(d4, Math.max(lineSegment.start.f4077y, lineSegment.end.f4077y));
        }
        return new Rectangle(d5, d6, d3, d4);
    }

    public Point interpolate(double d3) {
        if (d3 < 0.0d) {
            return null;
        }
        for (LineSegment lineSegment : this.segments) {
            double length = lineSegment.length();
            if (d3 <= length) {
                return lineSegment.pointAlongLineSegment(d3);
            }
            d3 -= length;
        }
        return null;
    }

    public double length() {
        Iterator<LineSegment> it = this.segments.iterator();
        double d3 = 0.0d;
        while (it.hasNext()) {
            d3 += it.next().length();
        }
        return d3;
    }
}
