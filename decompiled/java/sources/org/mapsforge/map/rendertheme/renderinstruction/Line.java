package org.mapsforge.map.rendertheme.renderinstruction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Cap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Join;
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
public class Line extends RenderInstruction {
    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");
    private boolean bitmapCreated;
    private float dy;
    private final Map<Byte, Float> dyScaled;
    private final int level;
    private final String relativePathPrefix;
    private RenderInstruction.Scale scale;
    private Bitmap shaderBitmap;
    private String src;
    private final Paint stroke;
    private float[] strokeDasharray;
    private float strokeWidth;
    private final Map<Byte, Paint> strokes;

    public Line(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser, int i3, String str2) {
        super(graphicFactory, displayModel);
        this.scale = RenderInstruction.Scale.STROKE;
        this.level = i3;
        this.relativePathPrefix = str2;
        Paint createPaint = graphicFactory.createPaint();
        this.stroke = createPaint;
        createPaint.setColor(Color.BLACK);
        createPaint.setStyle(Style.STROKE);
        createPaint.setStrokeCap(Cap.ROUND);
        createPaint.setStrokeJoin(Join.ROUND);
        this.strokes = new HashMap();
        this.dyScaled = new HashMap();
        extractValues(graphicFactory, displayModel, str, xmlPullParser);
    }

    private void extractValues(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser) {
        float[] fArr;
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if ("src".equals(attributeName)) {
                this.src = attributeValue;
            } else if ("cat".equals(attributeName)) {
                this.category = attributeValue;
            } else if ("dy".equals(attributeName)) {
                this.dy = Float.parseFloat(attributeValue) * displayModel.getScaleFactor();
            } else if ("scale".equals(attributeName)) {
                this.scale = scaleFromValue(attributeValue);
            } else if ("stroke".equals(attributeName)) {
                this.stroke.setColor(XmlUtils.getColor(graphicFactory, attributeValue, displayModel.getThemeCallback(), this));
            } else if ("stroke-dasharray".equals(attributeName)) {
                this.strokeDasharray = parseFloatArray(attributeName, attributeValue);
                int i4 = 0;
                while (true) {
                    fArr = this.strokeDasharray;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    fArr[i4] = fArr[i4] * displayModel.getScaleFactor();
                    i4++;
                }
                this.stroke.setDashPathEffect(fArr);
            } else if ("stroke-linecap".equals(attributeName)) {
                this.stroke.setStrokeCap(Cap.fromString(attributeValue));
            } else if ("stroke-linejoin".equals(attributeName)) {
                this.stroke.setStrokeJoin(Join.fromString(attributeValue));
            } else if ("stroke-width".equals(attributeName)) {
                this.strokeWidth = XmlUtils.parseNonNegativeFloat(attributeName, attributeValue) * displayModel.getScaleFactor();
            } else if ("symbol-height".equals(attributeName)) {
                this.height = XmlUtils.parseNonNegativeInteger(attributeName, attributeValue) * displayModel.getScaleFactor();
            } else if ("symbol-percent".equals(attributeName)) {
                this.percent = XmlUtils.parseNonNegativeInteger(attributeName, attributeValue);
            } else if ("symbol-scaling".equals(attributeName)) {
                continue;
            } else {
                if (!"symbol-width".equals(attributeName)) {
                    throw XmlUtils.createXmlPullParserException(str, attributeName, attributeValue, i3);
                }
                this.width = XmlUtils.parseNonNegativeInteger(attributeName, attributeValue) * displayModel.getScaleFactor();
            }
        }
    }

    private Paint getStrokePaint(byte b4) {
        Paint paint = this.strokes.get(Byte.valueOf(b4));
        return paint == null ? this.stroke : paint;
    }

    private static float[] parseFloatArray(String str, String str2) {
        String[] split = SPLIT_PATTERN.split(str2);
        float[] fArr = new float[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            fArr[i3] = XmlUtils.parseNonNegativeFloat(str, split[i3]);
        }
        return fArr;
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void destroy() {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderNode(RenderCallback renderCallback, RenderContext renderContext, PointOfInterest pointOfInterest) {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public synchronized void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        if (!this.bitmapCreated) {
            try {
                this.shaderBitmap = createBitmap(this.relativePathPrefix, this.src);
            } catch (IOException unused) {
            }
            this.bitmapCreated = true;
        }
        Paint strokePaint = getStrokePaint(renderContext.rendererJob.tile.zoomLevel);
        Bitmap bitmap = this.shaderBitmap;
        if (bitmap != null) {
            strokePaint.setBitmapShader(bitmap);
            strokePaint.setBitmapShaderShift(polylineContainer.getUpperLeft().getOrigin());
        }
        Float f3 = this.dyScaled.get(Byte.valueOf(renderContext.rendererJob.tile.zoomLevel));
        if (f3 == null) {
            f3 = Float.valueOf(this.dy);
        }
        renderCallback.renderWay(renderContext, strokePaint, f3.floatValue(), this.level, polylineContainer);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleStrokeWidth(float f3, byte b4) {
        if (this.scale == RenderInstruction.Scale.NONE) {
            f3 = 1.0f;
        }
        Paint paint = this.stroke;
        if (paint != null) {
            Paint createPaint = this.graphicFactory.createPaint(paint);
            createPaint.setStrokeWidth(this.strokeWidth * f3);
            if (this.scale == RenderInstruction.Scale.ALL) {
                float[] fArr = new float[this.strokeDasharray.length];
                int i3 = 0;
                while (true) {
                    float[] fArr2 = this.strokeDasharray;
                    if (i3 >= fArr2.length) {
                        break;
                    }
                    fArr[i3] = fArr2[i3] * f3;
                    i3++;
                }
                createPaint.setDashPathEffect(fArr);
            }
            this.strokes.put(Byte.valueOf(b4), createPaint);
        }
        this.dyScaled.put(Byte.valueOf(b4), Float.valueOf(this.dy * f3));
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleTextSize(float f3, byte b4) {
    }
}
