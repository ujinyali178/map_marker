package org.mapsforge.core.mapelements;

import java.util.List;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.Filter;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.GraphicUtils;
import org.mapsforge.core.graphics.Matrix;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Path;
import org.mapsforge.core.model.LineSegment;
import org.mapsforge.core.model.LineString;
import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
public class WayTextContainer extends MapElementContainer {
    private final GraphicFactory graphicFactory;
    private final LineString lineString;
    private final Paint paintBack;
    private final Paint paintFront;
    private final String text;

    public WayTextContainer(GraphicFactory graphicFactory, LineString lineString, Display display, int i3, String str, Paint paint, Paint paint2, double d3) {
        super(lineString.segments.get(0).start, display, i3);
        this.graphicFactory = graphicFactory;
        this.lineString = lineString;
        this.text = str;
        this.paintFront = paint;
        this.paintBack = paint2;
        this.boundary = null;
        double d4 = d3 / 2.0d;
        this.boundaryAbsolute = lineString.getBounds().enlarge(d4, d4, d4, d4);
    }

    private Path generatePath(Point point) {
        LineSegment lineSegment = this.lineString.segments.get(0);
        boolean z3 = lineSegment.end.f4076x <= lineSegment.start.f4076x;
        Path createPath = this.graphicFactory.createPath();
        if (z3) {
            List<LineSegment> list = this.lineString.segments;
            Point offset = list.get(list.size() - 1).end.offset(-point.f4076x, -point.f4077y);
            createPath.moveTo((float) offset.f4076x, (float) offset.f4077y);
            for (int size = this.lineString.segments.size() - 1; size >= 0; size--) {
                Point offset2 = this.lineString.segments.get(size).start.offset(-point.f4076x, -point.f4077y);
                createPath.lineTo((float) offset2.f4076x, (float) offset2.f4077y);
            }
        } else {
            Point offset3 = lineSegment.start.offset(-point.f4076x, -point.f4077y);
            createPath.moveTo((float) offset3.f4076x, (float) offset3.f4077y);
            for (int i3 = 0; i3 < this.lineString.segments.size(); i3++) {
                Point offset4 = this.lineString.segments.get(i3).end.offset(-point.f4076x, -point.f4077y);
                createPath.lineTo((float) offset4.f4076x, (float) offset4.f4077y);
            }
        }
        return createPath;
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public void draw(Canvas canvas, Point point, Matrix matrix, Filter filter) {
        Path generatePath = generatePath(point);
        Paint paint = this.paintBack;
        if (paint != null) {
            int color = paint.getColor();
            Filter filter2 = Filter.NONE;
            if (filter != filter2) {
                this.paintBack.setColor(GraphicUtils.filterColor(color, filter));
            }
            canvas.drawPathText(this.text, generatePath, this.paintBack);
            if (filter != filter2) {
                this.paintBack.setColor(color);
            }
        }
        int color2 = this.paintFront.getColor();
        Filter filter3 = Filter.NONE;
        if (filter != filter3) {
            this.paintFront.setColor(GraphicUtils.filterColor(color2, filter));
        }
        canvas.drawPathText(this.text, generatePath, this.paintFront);
        if (filter != filter3) {
            this.paintFront.setColor(color2);
        }
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public String toString() {
        return super.toString() + ", text=" + this.text;
    }
}
