package org.mapsforge.map.rendertheme.renderinstruction;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;
import java.util.Map;
import org.mapsforge.core.graphics.Align;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Position;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /root/release/classes2.dex */
public class Caption extends RenderInstruction {
    public static final float DEFAULT_GAP = 5.0f;
    private Bitmap bitmap;
    private Display display;
    private float dy;
    private final Map<Byte, Float> dyScaled;
    private final Paint fill;
    private final Map<Byte, Paint> fills;
    private float fontSize;
    private final float gap;
    private final int maxTextWidth;
    private Position position;
    private int priority;
    private final Paint stroke;
    private final Map<Byte, Paint> strokes;
    private String symbolId;
    private TextKey textKey;

    /* renamed from: org.mapsforge.map.rendertheme.renderinstruction.Caption$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Position = iArr;
            try {
                iArr[Position.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.BELOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.ABOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.BELOW_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.ABOVE_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.BELOW_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.ABOVE_RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Caption(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser, Map<String, Symbol> map) {
        super(graphicFactory, displayModel);
        Align align;
        Symbol symbol;
        Paint createPaint = graphicFactory.createPaint();
        this.fill = createPaint;
        Color color = Color.BLACK;
        createPaint.setColor(color);
        createPaint.setStyle(Style.FILL);
        this.fills = new HashMap();
        Paint createPaint2 = graphicFactory.createPaint();
        this.stroke = createPaint2;
        createPaint2.setColor(color);
        createPaint2.setStyle(Style.STROKE);
        this.strokes = new HashMap();
        this.dyScaled = new HashMap();
        this.display = Display.IFSPACE;
        this.gap = displayModel.getScaleFactor() * 5.0f;
        extractValues(graphicFactory, displayModel, str, xmlPullParser);
        String str2 = this.symbolId;
        if (str2 != null && (symbol = map.get(str2)) != null) {
            this.bitmap = symbol.getBitmap();
        }
        if (this.position == null) {
            this.position = this.bitmap == null ? Position.CENTER : Position.BELOW;
        }
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Position[this.position.ordinal()]) {
            case 1:
            case 2:
            case 3:
                align = Align.CENTER;
                break;
            case 4:
            case 5:
            case 6:
                align = Align.RIGHT;
                break;
            case 7:
            case 8:
            case 9:
                align = Align.LEFT;
                break;
            default:
                throw new IllegalArgumentException("Position invalid");
        }
        createPaint2.setTextAlign(align);
        createPaint.setTextAlign(align);
        this.maxTextWidth = displayModel.getMaxTextWidth();
    }

    private float computeHorizontalOffset() {
        Position position = Position.RIGHT;
        Position position2 = this.position;
        if (position != position2 && Position.LEFT != position2 && Position.BELOW_RIGHT != position2 && Position.BELOW_LEFT != position2 && Position.ABOVE_RIGHT != position2 && Position.ABOVE_LEFT != position2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float width = (this.bitmap.getWidth() / 2.0f) + this.gap;
        Position position3 = Position.LEFT;
        Position position4 = this.position;
        return (position3 == position4 || Position.BELOW_LEFT == position4 || Position.ABOVE_LEFT == position4) ? width * (-1.0f) : width;
    }

    private float computeVerticalOffset(byte b4) {
        float floatValue = this.dyScaled.get(Byte.valueOf(b4)).floatValue();
        Position position = Position.ABOVE;
        Position position2 = this.position;
        return (position == position2 || Position.ABOVE_LEFT == position2 || Position.ABOVE_RIGHT == position2) ? floatValue - ((this.bitmap.getHeight() / 2.0f) + this.gap) : (Position.BELOW == position2 || Position.BELOW_LEFT == position2 || Position.BELOW_RIGHT == position2) ? floatValue + (this.bitmap.getHeight() / 2.0f) + this.gap : floatValue;
    }

    private void extractValues(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser) {
        Paint paint;
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
                } else if ("position".equals(attributeName)) {
                    this.position = Position.fromString(attributeValue);
                } else if ("priority".equals(attributeName)) {
                    this.priority = Integer.parseInt(attributeValue);
                } else if ("stroke".equals(attributeName)) {
                    paint = this.stroke;
                } else if ("stroke-width".equals(attributeName)) {
                    this.stroke.setStrokeWidth(XmlUtils.parseNonNegativeFloat(attributeName, attributeValue) * displayModel.getScaleFactor());
                } else {
                    if (!"symbol-id".equals(attributeName)) {
                        throw XmlUtils.createXmlPullParserException(str, attributeName, attributeValue, i3);
                    }
                    this.symbolId = attributeValue;
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
        String value;
        float f3;
        if (Display.NEVER == this.display || (value = this.textKey.getValue(pointOfInterest.tags)) == null) {
            return;
        }
        Float f4 = this.dyScaled.get(Byte.valueOf(renderContext.rendererJob.tile.zoomLevel));
        if (f4 == null) {
            f4 = Float.valueOf(this.dy);
        }
        if (this.bitmap != null) {
            float computeHorizontalOffset = computeHorizontalOffset();
            f4 = Float.valueOf(computeVerticalOffset(renderContext.rendererJob.tile.zoomLevel));
            f3 = computeHorizontalOffset;
        } else {
            f3 = BitmapDescriptorFactory.HUE_RED;
        }
        renderCallback.renderPointOfInterestCaption(renderContext, this.display, this.priority, value, f3, f4.floatValue(), getFillPaint(renderContext.rendererJob.tile.zoomLevel), getStrokePaint(renderContext.rendererJob.tile.zoomLevel), this.position, this.maxTextWidth, pointOfInterest);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        String value;
        float f3;
        if (Display.NEVER == this.display || (value = this.textKey.getValue(polylineContainer.getTags())) == null) {
            return;
        }
        Float f4 = this.dyScaled.get(Byte.valueOf(renderContext.rendererJob.tile.zoomLevel));
        if (f4 == null) {
            f4 = Float.valueOf(this.dy);
        }
        if (this.bitmap != null) {
            float computeHorizontalOffset = computeHorizontalOffset();
            f4 = Float.valueOf(computeVerticalOffset(renderContext.rendererJob.tile.zoomLevel));
            f3 = computeHorizontalOffset;
        } else {
            f3 = BitmapDescriptorFactory.HUE_RED;
        }
        renderCallback.renderAreaCaption(renderContext, this.display, this.priority, value, f3, f4.floatValue(), getFillPaint(renderContext.rendererJob.tile.zoomLevel), getStrokePaint(renderContext.rendererJob.tile.zoomLevel), this.position, this.maxTextWidth, polylineContainer);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleStrokeWidth(float f3, byte b4) {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleTextSize(float f3, byte b4) {
        Paint createPaint = this.graphicFactory.createPaint(this.fill);
        createPaint.setTextSize(this.fontSize * f3);
        this.fills.put(Byte.valueOf(b4), createPaint);
        Paint createPaint2 = this.graphicFactory.createPaint(this.stroke);
        createPaint2.setTextSize(this.fontSize * f3);
        this.strokes.put(Byte.valueOf(b4), createPaint2);
        this.dyScaled.put(Byte.valueOf(b4), Float.valueOf(this.dy * f3));
    }
}
