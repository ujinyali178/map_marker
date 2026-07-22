package org.mapsforge.map.layer.debug;

import java.util.List;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.layer.TilePosition;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.util.LayerUtil;

/* loaded from: /root/release/classes2.dex */
public class TileCoordinatesLayer extends Layer {
    private final DisplayModel displayModel;
    private boolean drawSimple;
    private final Paint paintBack;
    private final Paint paintFront;
    private final StringBuilder stringBuilder = new StringBuilder();

    public TileCoordinatesLayer(GraphicFactory graphicFactory, DisplayModel displayModel) {
        this.displayModel = displayModel;
        this.paintBack = createPaintBack(graphicFactory, displayModel);
        this.paintFront = createPaintFront(graphicFactory, displayModel);
    }

    public TileCoordinatesLayer(DisplayModel displayModel, Paint paint, Paint paint2) {
        this.displayModel = displayModel;
        this.paintBack = paint;
        this.paintFront = paint2;
    }

    private static Paint createPaintBack(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.WHITE);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(displayModel.getScaleFactor() * 12.0f);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 2.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    private static Paint createPaintFront(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.RED);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(displayModel.getScaleFactor() * 12.0f);
        return createPaint;
    }

    private void drawTileCoordinates(TilePosition tilePosition, Canvas canvas) {
        Tile tile = tilePosition.tile;
        if (this.drawSimple) {
            this.stringBuilder.setLength(0);
            StringBuilder sb = this.stringBuilder;
            sb.append((int) tile.zoomLevel);
            sb.append(" / ");
            sb.append(tile.tileX);
            sb.append(" / ");
            sb.append(tile.tileY);
            String sb2 = this.stringBuilder.toString();
            int textWidth = (int) (tilePosition.point.f4076x + ((tile.tileSize - this.paintBack.getTextWidth(sb2)) / 2));
            int textHeight = (int) (tilePosition.point.f4077y + ((tile.tileSize + this.paintBack.getTextHeight(sb2)) / 2));
            canvas.drawText(sb2, textWidth, textHeight, this.paintBack);
            canvas.drawText(sb2, textWidth, textHeight, this.paintFront);
            return;
        }
        int scaleFactor = (int) (tilePosition.point.f4076x + (this.displayModel.getScaleFactor() * 8.0f));
        int scaleFactor2 = (int) (tilePosition.point.f4077y + (this.displayModel.getScaleFactor() * 24.0f));
        this.stringBuilder.setLength(0);
        this.stringBuilder.append("X: ");
        this.stringBuilder.append(tile.tileX);
        String sb3 = this.stringBuilder.toString();
        canvas.drawText(sb3, scaleFactor, scaleFactor2, this.paintBack);
        canvas.drawText(sb3, scaleFactor, scaleFactor2, this.paintFront);
        this.stringBuilder.setLength(0);
        this.stringBuilder.append("Y: ");
        this.stringBuilder.append(tile.tileY);
        String sb4 = this.stringBuilder.toString();
        float f3 = scaleFactor2;
        canvas.drawText(sb4, scaleFactor, (int) ((this.displayModel.getScaleFactor() * 24.0f) + f3), this.paintBack);
        canvas.drawText(sb4, scaleFactor, (int) ((this.displayModel.getScaleFactor() * 24.0f) + f3), this.paintFront);
        this.stringBuilder.setLength(0);
        this.stringBuilder.append("Z: ");
        this.stringBuilder.append((int) tile.zoomLevel);
        String sb5 = this.stringBuilder.toString();
        canvas.drawText(sb5, scaleFactor, (int) ((this.displayModel.getScaleFactor() * 48.0f) + f3), this.paintBack);
        canvas.drawText(sb5, scaleFactor, (int) (f3 + (this.displayModel.getScaleFactor() * 48.0f)), this.paintFront);
    }

    @Override // org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        List<TilePosition> tilePositions = LayerUtil.getTilePositions(boundingBox, b4, point, this.displayModel.getTileSize());
        for (int size = tilePositions.size() - 1; size >= 0; size--) {
            drawTileCoordinates(tilePositions.get(size), canvas);
        }
    }

    public boolean isDrawSimple() {
        return this.drawSimple;
    }

    public void setDrawSimple(boolean z3) {
        this.drawSimple = z3;
    }
}
