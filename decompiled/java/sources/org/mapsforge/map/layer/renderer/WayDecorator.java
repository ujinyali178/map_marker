package org.mapsforge.map.layer.renderer;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.mapelements.WayTextContainer;
import org.mapsforge.core.model.LineSegment;
import org.mapsforge.core.model.LineString;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
final class WayDecorator {
    private static final double MAX_LABEL_CORNER_ANGLE = 45.0d;

    private WayDecorator() {
        throw new IllegalStateException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008a, code lost:
    
        r30 = r3;
        r36 = r10;
        r2 = (int) (r9 - r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
    
        if (r2 >= r34) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
    
        r9 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
    
        r4 = r4 + 1;
        r3 = r30;
        r2 = r36;
        r5 = r11;
        r7 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009a, code lost:
    
        r9 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void renderSymbol(org.mapsforge.core.graphics.Bitmap r27, org.mapsforge.core.graphics.Display r28, int r29, float r30, boolean r31, boolean r32, float r33, float r34, boolean r35, org.mapsforge.core.model.Point[][] r36, java.util.List<org.mapsforge.core.mapelements.MapElementContainer> r37) {
        /*
            r0 = r30
            r1 = r34
            int r2 = (int) r1
            r3 = 0
            r4 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto Le
            r0 = r36[r4]
            goto L15
        Le:
            r5 = r36[r4]
            double r6 = (double) r0
            org.mapsforge.core.model.Point[] r0 = org.mapsforge.map.layer.renderer.RendererUtils.parallelPath(r5, r6)
        L15:
            r4 = r0[r4]
            double r5 = r4.f4076x
            double r7 = r4.f4077y
            r4 = 1
            r9 = r2
        L1d:
            int r10 = r0.length
            if (r4 >= r10) goto La5
            r10 = r0[r4]
            double r11 = r10.f4076x
            double r13 = r10.f4077y
            double r15 = r11 - r5
            double r17 = r13 - r7
            double r19 = r15 * r15
            double r21 = r17 * r17
            double r19 = r19 + r21
            r10 = r2
            r30 = r3
            double r2 = java.lang.Math.sqrt(r19)
            float r2 = (float) r2
            r3 = r30
        L3a:
            float r9 = (float) r9
            float r19 = r2 - r9
            int r20 = (r19 > r1 ? 1 : (r19 == r1 ? 0 : -1))
            if (r20 <= 0) goto L8a
            float r9 = r9 / r2
            r30 = r3
            double r2 = (double) r9
            double r15 = r15 * r2
            double r5 = r5 + r15
            double r17 = r17 * r2
            double r7 = r7 + r17
            if (r35 == 0) goto L5a
            double r2 = r13 - r7
            r36 = r10
            double r9 = r11 - r5
            double r2 = java.lang.Math.atan2(r2, r9)
            float r3 = (float) r2
            goto L5e
        L5a:
            r36 = r10
            r3 = r30
        L5e:
            org.mapsforge.core.model.Point r2 = new org.mapsforge.core.model.Point
            r2.<init>(r5, r7)
            org.mapsforge.core.mapelements.SymbolContainer r9 = new org.mapsforge.core.mapelements.SymbolContainer
            r20 = r9
            r21 = r2
            r22 = r28
            r23 = r29
            r24 = r27
            r25 = r3
            r26 = r31
            r20.<init>(r21, r22, r23, r24, r25, r26)
            r10 = r37
            r10.add(r9)
            if (r32 != 0) goto L7e
            return
        L7e:
            double r15 = r11 - r5
            double r17 = r13 - r7
            r2 = r33
            int r9 = (int) r2
            r10 = r36
            r2 = r19
            goto L3a
        L8a:
            r30 = r3
            r36 = r10
            r10 = r37
            float r9 = r9 - r2
            int r2 = (int) r9
            float r3 = (float) r2
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 >= 0) goto L9a
            r9 = r36
            goto L9b
        L9a:
            r9 = r2
        L9b:
            int r4 = r4 + 1
            r3 = r30
            r2 = r36
            r5 = r11
            r7 = r13
            goto L1d
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.layer.renderer.WayDecorator.renderSymbol(org.mapsforge.core.graphics.Bitmap, org.mapsforge.core.graphics.Display, int, float, boolean, boolean, float, float, boolean, org.mapsforge.core.model.Point[][], java.util.List):void");
    }

    static void renderText(GraphicFactory graphicFactory, Tile tile, Tile tile2, String str, Display display, int i3, float f3, Paint paint, Paint paint2, boolean z3, float f4, float f5, boolean z4, Point[][] pointArr, List<MapElementContainer> list) {
        boolean z5;
        float f6;
        float f7;
        int i4;
        int i5;
        if (pointArr.length == 0) {
            return;
        }
        Point[] parallelPath = f3 == BitmapDescriptorFactory.HUE_RED ? pointArr[0] : RendererUtils.parallelPath(pointArr[0], f3);
        if (parallelPath.length < 2) {
            return;
        }
        LineString lineString = new LineString();
        for (int i6 = 1; i6 < parallelPath.length; i6++) {
            lineString.segments.add(new LineSegment(parallelPath[i6 - 1], parallelPath[i6]));
        }
        int textWidth = paint2 == null ? paint.getTextWidth(str) : paint2.getTextWidth(str);
        int textHeight = paint2 == null ? paint.getTextHeight(str) : paint2.getTextHeight(str);
        double length = lineString.length();
        float f8 = f5;
        while (true) {
            float f9 = textWidth;
            double d3 = f8 + f9;
            if (d3 >= length) {
                return;
            }
            LineString extractPart = lineString.extractPart(f8, d3);
            int i7 = 1;
            while (true) {
                if (i7 >= extractPart.segments.size()) {
                    z5 = false;
                    break;
                } else {
                    if (Math.abs(extractPart.segments.get(i7 - 1).angleTo(extractPart.segments.get(i7))) > MAX_LABEL_CORNER_ANGLE) {
                        z5 = true;
                        break;
                    }
                    i7++;
                }
            }
            if (z5) {
                f6 = f9;
                f7 = f8;
                i4 = textWidth;
                i5 = textHeight;
            } else {
                f6 = f9;
                f7 = f8;
                i4 = textWidth;
                i5 = textHeight;
                list.add(new WayTextContainer(graphicFactory, extractPart, display, i3, str, paint, paint2, textHeight));
            }
            f8 = f7 + f4 + f6;
            textWidth = i4;
            textHeight = i5;
        }
    }
}
