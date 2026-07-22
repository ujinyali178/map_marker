package org.mapsforge.map.layer.debug;

import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public class TileGridLayer extends Layer {
    private final DisplayModel displayModel;
    private final Paint paintBack;
    private final Paint paintFront;

    public TileGridLayer(GraphicFactory graphicFactory, DisplayModel displayModel) {
        this.displayModel = displayModel;
        this.paintBack = createPaintBack(graphicFactory, displayModel);
        this.paintFront = createPaintFront(graphicFactory, displayModel);
    }

    public TileGridLayer(DisplayModel displayModel, Paint paint, Paint paint2) {
        this.displayModel = displayModel;
        this.paintBack = paint;
        this.paintFront = paint2;
    }

    private static Paint createPaintBack(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.WHITE);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 4.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    private static Paint createPaintFront(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.RED);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 2.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    @Override // org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        int i3;
        int i4;
        long longitudeToTileX = MercatorProjection.longitudeToTileX(boundingBox.minLongitude, b4);
        long latitudeToTileY = MercatorProjection.latitudeToTileY(boundingBox.maxLatitude, b4);
        long longitudeToTileX2 = MercatorProjection.longitudeToTileX(boundingBox.maxLongitude, b4);
        long latitudeToTileY2 = MercatorProjection.latitudeToTileY(boundingBox.minLatitude, b4);
        int tileSize = this.displayModel.getTileSize();
        int tileToPixel = (int) (MercatorProjection.tileToPixel(longitudeToTileX, tileSize) - point.f4076x);
        int tileToPixel2 = (int) (MercatorProjection.tileToPixel(latitudeToTileY, tileSize) - point.f4077y);
        double tileToPixel3 = MercatorProjection.tileToPixel(longitudeToTileX2, tileSize) - point.f4076x;
        double d3 = tileSize;
        int i5 = (int) (tileToPixel3 + d3);
        int tileToPixel4 = (int) ((MercatorProjection.tileToPixel(latitudeToTileY2, tileSize) - point.f4077y) + d3);
        int i6 = tileToPixel;
        while (true) {
            i3 = i5 + 1;
            if (i6 > i3) {
                break;
            }
            canvas.drawLine(i6, tileToPixel2, i6, tileToPixel4, this.paintBack);
            i6 += tileSize;
        }
        int i7 = tileToPixel2;
        while (true) {
            i4 = tileToPixel4 + 1;
            if (i7 > i4) {
                break;
            }
            canvas.drawLine(tileToPixel, i7, i5, i7, this.paintBack);
            i7 += tileSize;
        }
        for (int i8 = tileToPixel; i8 <= i3; i8 += tileSize) {
            canvas.drawLine(i8, tileToPixel2, i8, tileToPixel4, this.paintFront);
        }
        while (tileToPixel2 <= i4) {
            canvas.drawLine(tileToPixel, tileToPixel2, i5, tileToPixel2, this.paintFront);
            tileToPixel2 += tileSize;
        }
    }
}
