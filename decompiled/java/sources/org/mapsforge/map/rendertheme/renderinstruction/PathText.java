package org.mapsforge.map.rendertheme.renderinstruction;

import java.util.HashMap;
import java.util.Map;
import org.mapsforge.core.graphics.Align;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /root/release/classes2.dex */
public class PathText extends RenderInstruction {
    private static final float REPEAT_GAP_DEFAULT = 100.0f;
    private static final float REPEAT_START_DEFAULT = 10.0f;
    private Display display;
    private float dy;
    private final Map<Byte, Float> dyScaled;
    private final Paint fill;
    private final Map<Byte, Paint> fills;
    private float fontSize;
    private int priority;
    private boolean repeat;
    private float repeatGap;
    private float repeatStart;
    private boolean rotate;
    private RenderInstruction.Scale scale;
    private final Paint stroke;
    private final Map<Byte, Paint> strokes;
    private TextKey textKey;

    public PathText(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser) {
        super(graphicFactory, displayModel);
        this.scale = RenderInstruction.Scale.STROKE;
        Paint createPaint = graphicFactory.createPaint();
        this.fill = createPaint;
        Color color = Color.BLACK;
        createPaint.setColor(color);
        createPaint.setStyle(Style.FILL);
        Align align = Align.CENTER;
        createPaint.setTextAlign(align);
        this.fills = new HashMap();
        this.rotate = true;
        this.repeat = true;
        Paint createPaint2 = graphicFactory.createPaint();
        this.stroke = createPaint2;
        createPaint2.setColor(color);
        createPaint2.setStyle(Style.STROKE);
        createPaint2.setTextAlign(align);
        this.strokes = new HashMap();
        this.dyScaled = new HashMap();
        this.display = Display.IFSPACE;
        extractValues(graphicFactory, displayModel, str, xmlPullParser);
    }

    private void extractValues(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser) {
        Paint paint;
        this.repeatGap = displayModel.getScaleFactor() * REPEAT_GAP_DEFAULT;
        this.repeatStart = displayModel.getScaleFactor() * REPEAT_START_DEFAULT;
        FontFamily fontFamily = FontFamily.DEFAULT;
        FontStyle fontStyle = FontStyle.NORMAL;
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if ("k".equals(attributeName)) {
                this.textKey = TextKey.getInstance(attributeValue);
            } else if ("cat".equals(attributeName)) {
                this.category = attributeValue;
            } else if ("display".equals(attributeName)) {
                this.display = Display.fromString(attributeValue);
            } else if ("dy".equals(attributeName)) {
                this.dy = Float.parseFloat(attributeValue) * displayModel.getScaleFactor();
            } else {
                if ("fill".equals(attributeName)) {
                    paint = this.fill;
                } else if ("font-family".equals(attributeName)) {
                    fontFamily = FontFamily.fromString(attributeValue);
                } else if ("font-size".equals(attributeName)) {
                    this.fontSize = XmlUtils.parseNonNegativeFloat(attributeName, attributeValue) * displayModel.getScaleFactor();
                } else if ("font-style".equals(attributeName)) {
                    fontStyle = FontStyle.fromString(attributeValue);
                } else if ("repeat".equals(attributeName)) {
                    this.repeat = Boolean.parseBoolean(attributeValue);
                } else if ("repeat-gap".equals(attributeName)) {
                    this.repeatGap = Float.parseFloat(attributeValue) * displayModel.getScaleFactor();
                } else if ("repeat-start".equals(attributeName)) {
                    this.repeatStart = Float.parseFloat(attributeValue) * displayModel.getScaleFactor();
                } else if ("rotate".equals(attributeName)) {
                    this.rotate = Boolean.parseBoolean(attributeValue);
                } else if ("priority".equals(attributeName)) {
                    this.priority = Integer.parseInt(attributeValue);
                } else if ("scale".equals(attributeName)) {
                    this.scale = scaleFromValue(attributeValue);
                } else if ("stroke".equals(attributeName)) {
                    paint = this.stroke;
                } else {
                    if (!"stroke-width".equals(attributeName)) {
                        throw XmlUtils.createXmlPullParserException(str, attributeName, attributeValue, i3);
                    }
                    this.stroke.setStrokeWidth(XmlUtils.parseNonNegativeFloat(attributeName, attributeValue) * displayModel.getScaleFactor());
                }
                paint.setColor(XmlUtils.getColor(graphicFactory, attributeValue, displayModel.getThemeCallback(), this));
            }
        }
        this.fill.setTypeface(fontFamily, fontStyle);
        this.stroke.setTypeface(fontFamily, fontStyle);
        XmlUtils.checkMandatoryAttribute(str, "k", this.textKey);
    }

    private Paint getFillPaint(byte b4) {
        Paint paint = this.fills.get(Byte.valueOf(b4));
        return paint == null ? this.fill : paint;
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
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        String value;
        if (Display.NEVER == this.display || (value = this.textKey.getValue(polylineContainer.getTags())) == null) {
            return;
        }
        Float f3 = this.dyScaled.get(Byte.valueOf(renderContext.rendererJob.tile.zoomLevel));
        if (f3 == null) {
            f3 = Float.valueOf(this.dy);
        }
        renderCallback.renderWayText(renderContext, this.display, this.priority, value, f3.floatValue(), getFillPaint(renderContext.rendererJob.tile.zoomLevel), getStrokePaint(renderContext.rendererJob.tile.zoomLevel), this.repeat, this.repeatGap, this.repeatStart, this.rotate, polylineContainer);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleStrokeWidth(float f3, byte b4) {
        if (this.scale == RenderInstruction.Scale.NONE) {
            f3 = 1.0f;
        }
        this.dyScaled.put(Byte.valueOf(b4), Float.valueOf(this.dy * f3));
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleTextSize(float f3, byte b4) {
        Paint createPaint = this.graphicFactory.createPaint(this.fill);
        createPaint.setTextSize(this.fontSize * f3);
        this.fills.put(Byte.valueOf(b4), createPaint);
        Paint createPaint2 = this.graphicFactory.createPaint(this.stroke);
        createPaint2.setTextSize(this.fontSize * f3);
        this.strokes.put(Byte.valueOf(b4), createPaint2);
    }
}
