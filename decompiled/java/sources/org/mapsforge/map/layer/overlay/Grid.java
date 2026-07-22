package org.mapsforge.map.layer.overlay;

import java.text.DecimalFormat;
import java.util.Map;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public class Grid extends Layer {
    private final Paint lineBack;
    private final Paint lineFront;
    private final Map<Byte, Double> spacingConfig;
    private final Paint textBack;
    private final Paint textFront;

    public Grid(GraphicFactory graphicFactory, DisplayModel displayModel, Map<Byte, Double> map) {
        this.displayModel = displayModel;
        this.spacingConfig = map;
        this.lineBack = createLineBack(graphicFactory, displayModel);
        this.lineFront = createLineFront(graphicFactory, displayModel);
        this.textBack = createTextBack(graphicFactory, displayModel);
        this.textFront = createTextFront(graphicFactory, displayModel);
    }

    public Grid(DisplayModel displayModel, Map<Byte, Double> map, Paint paint, Paint paint2, Paint paint3, Paint paint4) {
        this.displayModel = displayModel;
        this.spacingConfig = map;
        this.lineBack = paint;
        this.lineFront = paint2;
        this.textBack = paint3;
        this.textFront = paint4;
    }

    private static String convertCoordinate(double d3) {
        StringBuilder sb = new StringBuilder();
        if (d3 < 0.0d) {
            sb.append('-');
            d3 = -d3;
        }
        DecimalFormat decimalFormat = new DecimalFormat("00");
        int floor = (int) Math.floor(d3);
        sb.append(decimalFormat.format(floor));
        sb.append((char) 176);
        double d4 = (d3 - floor) * 60.0d;
        int floor2 = (int) Math.floor(d4);
        sb.append(decimalFormat.format(floor2));
        sb.append((char) 8242);
        sb.append(decimalFormat.format((d4 - floor2) * 60.0d));
        sb.append((char) 8243);
        return sb.toString();
    }

    private static Paint createLineBack(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.WHITE);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 4.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    private static Paint createLineFront(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.BLUE);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 2.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    private static Paint createTextBack(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.WHITE);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(displayModel.getScaleFactor() * 12.0f);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 4.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    private static Paint createTextFront(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.BLUE);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(displayModel.getScaleFactor() * 12.0f);
        return createPaint;
    }

    @Override // org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        Point point2 = point;
        if (this.spacingConfig.containsKey(Byte.valueOf(b4))) {
            double doubleValue = this.spacingConfig.get(Byte.valueOf(b4)).doubleValue();
            double floor = doubleValue * Math.floor(boundingBox.minLongitude / doubleValue);
            double ceil = doubleValue * Math.ceil(boundingBox.maxLongitude / doubleValue);
            double floor2 = doubleValue * Math.floor(boundingBox.minLatitude / doubleValue);
            double ceil2 = doubleValue * Math.ceil(boundingBox.maxLatitude / doubleValue);
            long mapSize = MercatorProjection.getMapSize(b4, this.displayModel.getTileSize());
            int latitudeToPixelY = (int) (MercatorProjection.latitudeToPixelY(floor2, mapSize) - point2.f4077y);
            int latitudeToPixelY2 = (int) (MercatorProjection.latitudeToPixelY(ceil2, mapSize) - point2.f4077y);
            int longitudeToPixelX = (int) (MercatorProjection.longitudeToPixelX(floor, mapSize) - point2.f4076x);
            int longitudeToPixelX2 = (int) (MercatorProjection.longitudeToPixelX(ceil, mapSize) - point2.f4076x);
            double d3 = floor2;
            while (d3 <= ceil2) {
                int latitudeToPixelY3 = (int) (MercatorProjection.latitudeToPixelY(d3, mapSize) - point2.f4077y);
                canvas.drawLine(longitudeToPixelX, latitudeToPixelY3, longitudeToPixelX2, latitudeToPixelY3, this.lineBack);
                d3 += doubleValue;
                mapSize = mapSize;
                ceil2 = ceil2;
                point2 = point;
            }
            long j3 = mapSize;
            double d4 = ceil2;
            double d5 = floor;
            while (d5 <= ceil) {
                int longitudeToPixelX3 = (int) (MercatorProjection.longitudeToPixelX(d5, j3) - point.f4076x);
                canvas.drawLine(longitudeToPixelX3, latitudeToPixelY, longitudeToPixelX3, latitudeToPixelY2, this.lineBack);
                d5 += doubleValue;
                j3 = j3;
                ceil = ceil;
            }
            double d6 = ceil;
            long j4 = j3;
            for (double d7 = floor2; d7 <= d4; d7 += doubleValue) {
                int latitudeToPixelY4 = (int) (MercatorProjection.latitudeToPixelY(d7, j4) - point.f4077y);
                canvas.drawLine(longitudeToPixelX, latitudeToPixelY4, longitudeToPixelX2, latitudeToPixelY4, this.lineFront);
            }
            for (double d8 = floor; d8 <= d6; d8 += doubleValue) {
                int longitudeToPixelX4 = (int) (MercatorProjection.longitudeToPixelX(d8, j4) - point.f4076x);
                canvas.drawLine(longitudeToPixelX4, latitudeToPixelY, longitudeToPixelX4, latitudeToPixelY2, this.lineFront);
            }
            for (double d9 = floor2; d9 <= d4; d9 += doubleValue) {
                String convertCoordinate = convertCoordinate(d9);
                int width = (canvas.getWidth() - this.textFront.getTextWidth(convertCoordinate)) / 2;
                int latitudeToPixelY5 = ((int) (MercatorProjection.latitudeToPixelY(d9, j4) - point.f4077y)) + (this.textFront.getTextHeight(convertCoordinate) / 2);
                canvas.drawText(convertCoordinate, width, latitudeToPixelY5, this.textBack);
                canvas.drawText(convertCoordinate, width, latitudeToPixelY5, this.textFront);
            }
            for (double d10 = floor; d10 <= d6; d10 += doubleValue) {
                String convertCoordinate2 = convertCoordinate(d10);
                int longitudeToPixelX5 = ((int) (MercatorProjection.longitudeToPixelX(d10, j4) - point.f4076x)) - (this.textFront.getTextWidth(convertCoordinate2) / 2);
                int height = (canvas.getHeight() + this.textFront.getTextHeight(convertCoordinate2)) / 2;
                canvas.drawText(convertCoordinate2, longitudeToPixelX5, height, this.textBack);
                canvas.drawText(convertCoordinate2, longitudeToPixelX5, height, this.textFront);
            }
        }
    }
}
