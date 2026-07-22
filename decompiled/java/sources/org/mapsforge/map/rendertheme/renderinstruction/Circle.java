package org.mapsforge.map.rendertheme.renderinstruction;

import java.util.HashMap;
import java.util.Map;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /root/release/classes2.dex */
public class Circle extends RenderInstruction {
    private final Paint fill;
    private final Map<Byte, Paint> fills;
    private final int level;
    private float radius;
    private float renderRadius;
    private final Map<Byte, Float> renderRadiusScaled;
    private boolean scaleRadius;
    private final Paint stroke;
    private float strokeWidth;
    private final Map<Byte, Paint> strokes;

    public Circle(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser, int i3) {
        super(graphicFactory, displayModel);
        this.level = i3;
        Paint createPaint = graphicFactory.createPaint();
        this.fill = createPaint;
        Color color = Color.TRANSPARENT;
        createPaint.setColor(color);
        createPaint.setStyle(Style.FILL);
        this.fills = new HashMap();
        Paint createPaint2 = graphicFactory.createPaint();
        this.stroke = createPaint2;
        createPaint2.setColor(color);
        createPaint2.setStyle(Style.STROKE);
        this.strokes = new HashMap();
        this.renderRadiusScaled = new HashMap();
        extractValues(graphicFactory, displayModel, str, xmlPullParser);
        if (this.scaleRadius) {
            return;
        }
        this.renderRadius = this.radius;
        createPaint2.setStrokeWidth(this.strokeWidth);
    }

    private void extractValues(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser) {
        Paint paint;
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if ("radius".equals(attributeName) || "r".equals(attributeName)) {
                this.radius = XmlUtils.parseNonNegativeFloat(attributeName, attributeValue) * displayModel.getScaleFactor();
            } else if ("cat".equals(attributeName)) {
                this.category = attributeValue;
            } else {
                if ("fill".equals(attributeName)) {
                    paint = this.fill;
                } else if ("scale-radius".equals(attributeName)) {
                    this.scaleRadius = Boolean.parseBoolean(attributeValue);
                } else if ("stroke".equals(attributeName)) {
                    paint = this.stroke;
                } else {
                    if (!"stroke-width".equals(attributeName)) {
                        throw XmlUtils.createXmlPullParserException(str, attributeName, attributeValue, i3);
                    }
                    this.strokeWidth = XmlUtils.parseNonNegativeFloat(attributeName, attributeValue) * displayModel.getScaleFactor();
                }
                paint.setColor(XmlUtils.getColor(graphicFactory, attributeValue, displayModel.getThemeCallback(), this));
            }
        }
        XmlUtils.checkMandatoryAttribute(str, "radius", Float.valueOf(this.radius));
    }

    private Paint getFillPaint(byte b4) {
        Paint paint = this.fills.get(Byte.valueOf(b4));
        return paint == null ? this.fill : paint;
    }

    private float getRenderRadius(byte b4) {
        Float f3 = this.renderRadiusScaled.get(Byte.valueOf(b4));
        if (f3 == null) {
            f3 = Float.valueOf(this.renderRadius);
        }
        return f3.floatValue();
    }

    private Paint getStrokePaint(byte b4) {
        Paint paint = this.strokes.get(Byte.valueOf(b4));
        return paint == null ? this.stroke : paint;
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void destroy() {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderNode(RenderCallback renderCallback, RenderContext renderContext, PointOfInterest pointOfInterest) {
        renderCallback.renderPointOfInterestCircle(renderContext, getRenderRadius(renderContext.rendererJob.tile.zoomLevel), getFillPaint(renderContext.rendererJob.tile.zoomLevel), getStrokePaint(renderContext.rendererJob.tile.zoomLevel), this.level, pointOfInterest);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleStrokeWidth(float f3, byte b4) {
        if (this.scaleRadius) {
            this.renderRadiusScaled.put(Byte.valueOf(b4), Float.valueOf(this.radius * f3));
            Paint paint = this.stroke;
            if (paint != null) {
                Paint createPaint = this.graphicFactory.createPaint(paint);
                createPaint.setStrokeWidth(this.strokeWidth * f3);
                this.strokes.put(Byte.valueOf(b4), createPaint);
            }
        }
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleTextSize(float f3, byte b4) {
    }
}
