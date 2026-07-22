package org.mapsforge.map.rendertheme.renderinstruction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /root/release/classes2.dex */
public class LineSymbol extends RenderInstruction {
    private static final float REPEAT_GAP_DEFAULT = 200.0f;
    private static final float REPEAT_START_DEFAULT = 30.0f;
    private boolean alignCenter;
    private Bitmap bitmap;
    private boolean bitmapInvalid;
    private Display display;
    private float dy;
    private final Map<Byte, Float> dyScaled;
    private int priority;
    private final String relativePathPrefix;
    private boolean repeat;
    private float repeatGap;
    private float repeatStart;
    private boolean rotate;
    private RenderInstruction.Scale scale;
    private String src;

    public LineSymbol(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser, String str2) {
        super(graphicFactory, displayModel);
        this.scale = RenderInstruction.Scale.STROKE;
        this.display = Display.IFSPACE;
        this.rotate = true;
        this.relativePathPrefix = str2;
        this.dyScaled = new HashMap();
        extractValues(str, xmlPullParser);
    }

    private void extractValues(String str, XmlPullParser xmlPullParser) {
        this.repeatGap = this.displayModel.getScaleFactor() * REPEAT_GAP_DEFAULT;
        this.repeatStart = this.displayModel.getScaleFactor() * 30.0f;
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if ("src".equals(attributeName)) {
                this.src = attributeValue;
            } else if ("align-center".equals(attributeName)) {
                this.alignCenter = Boolean.parseBoolean(attributeValue);
            } else if ("cat".equals(attributeName)) {
                this.category = attributeValue;
            } else if ("display".equals(attributeName)) {
                this.display = Display.fromString(attributeValue);
            } else if ("dy".equals(attributeName)) {
                this.dy = Float.parseFloat(attributeValue) * this.displayModel.getScaleFactor();
            } else if ("priority".equals(attributeName)) {
                this.priority = Integer.parseInt(attributeValue);
            } else if ("repeat".equals(attributeName)) {
                this.repeat = Boolean.parseBoolean(attributeValue);
            } else if ("repeat-gap".equals(attributeName)) {
                this.repeatGap = Float.parseFloat(attributeValue) * this.displayModel.getScaleFactor();
            } else if ("repeat-start".equals(attributeName)) {
                this.repeatStart = Float.parseFloat(attributeValue) * this.displayModel.getScaleFactor();
            } else if ("rotate".equals(attributeName)) {
                this.rotate = Boolean.parseBoolean(attributeValue);
            } else if ("scale".equals(attributeName)) {
                this.scale = scaleFromValue(attributeValue);
            } else if ("symbol-height".equals(attributeName)) {
                this.height = XmlUtils.parseNonNegativeInteger(attributeName, attributeValue) * this.displayModel.getScaleFactor();
            } else if ("symbol-percent".equals(attributeName)) {
                this.percent = XmlUtils.parseNonNegativeInteger(attributeName, attributeValue);
            } else if ("symbol-scaling".equals(attributeName)) {
                continue;
            } else {
                if (!"symbol-width".equals(attributeName)) {
                    throw XmlUtils.createXmlPullParserException(str, attributeName, attributeValue, i3);
                }
                this.width = XmlUtils.parseNonNegativeInteger(attributeName, attributeValue) * this.displayModel.getScaleFactor();
            }
        }
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void destroy() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.decrementRefCount();
        }
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderNode(RenderCallback renderCallback, RenderContext renderContext, PointOfInterest pointOfInterest) {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        if (Display.NEVER == this.display) {
            return;
        }
        if (this.bitmap == null && !this.bitmapInvalid) {
            try {
                this.bitmap = createBitmap(this.relativePathPrefix, this.src);
            } catch (IOException unused) {
                this.bitmapInvalid = true;
            }
        }
        Float f3 = this.dyScaled.get(Byte.valueOf(renderContext.rendererJob.tile.zoomLevel));
        if (f3 == null) {
            f3 = Float.valueOf(this.dy);
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            renderCallback.renderWaySymbol(renderContext, this.display, this.priority, bitmap, f3.floatValue(), this.alignCenter, this.repeat, this.repeatGap, this.repeatStart, this.rotate, polylineContainer);
        }
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
    }
}
