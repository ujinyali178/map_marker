package org.mapsforge.map.view;

import java.util.concurrent.TimeUnit;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.GraphicContext;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public class FpsCounter {
    private static final long ONE_SECOND = TimeUnit.SECONDS.toNanos(1);
    private final DisplayModel displayModel;
    private String fps;
    private int frameCounter;
    private long lastTime;
    private final Paint paintBack;
    private final Paint paintFront;
    private boolean visible;

    public FpsCounter(GraphicFactory graphicFactory, DisplayModel displayModel) {
        this.displayModel = displayModel;
        this.paintBack = createPaintBack(graphicFactory, displayModel);
        this.paintFront = createPaintFront(graphicFactory, displayModel);
    }

    public FpsCounter(DisplayModel displayModel, Paint paint, Paint paint2) {
        this.displayModel = displayModel;
        this.paintBack = paint;
        this.paintFront = paint2;
    }

    private static Paint createPaintBack(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.WHITE);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(displayModel.getScaleFactor() * 25.0f);
        createPaint.setStrokeWidth(displayModel.getScaleFactor() * 2.0f);
        createPaint.setStyle(Style.STROKE);
        return createPaint;
    }

    private static Paint createPaintFront(GraphicFactory graphicFactory, DisplayModel displayModel) {
        Paint createPaint = graphicFactory.createPaint();
        createPaint.setColor(Color.RED);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(displayModel.getScaleFactor() * 25.0f);
        return createPaint;
    }

    public void draw(GraphicContext graphicContext) {
        if (this.visible) {
            long nanoTime = System.nanoTime();
            long j3 = nanoTime - this.lastTime;
            if (j3 > ONE_SECOND) {
                this.fps = String.valueOf(Math.round((this.frameCounter * r4) / j3));
                this.lastTime = nanoTime;
                this.frameCounter = 0;
            }
            int scaleFactor = (int) (this.displayModel.getScaleFactor() * 20.0f);
            int scaleFactor2 = (int) (this.displayModel.getScaleFactor() * 40.0f);
            graphicContext.drawText(this.fps, scaleFactor, scaleFactor2, this.paintBack);
            graphicContext.drawText(this.fps, scaleFactor, scaleFactor2, this.paintFront);
            this.frameCounter++;
        }
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean z3) {
        this.visible = z3;
    }
}
