package org.mapsforge.map.rendertheme.renderinstruction;

import java.io.IOException;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /root/release/classes2.dex */
public class Symbol extends RenderInstruction {
    private Bitmap bitmap;
    private boolean bitmapInvalid;
    private Display display;
    private String id;
    private int priority;
    private final String relativePathPrefix;
    private String src;

    public Symbol(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser, String str2) {
        super(graphicFactory, displayModel);
        this.relativePathPrefix = str2;
        this.display = Display.IFSPACE;
        extractValues(str, xmlPullParser);
    }

    private void extractValues(String str, XmlPullParser xmlPullParser) {
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if ("src".equals(attributeName)) {
                this.src = attributeValue;
            } else if ("cat".equals(attributeName)) {
                this.category = attributeValue;
            } else if ("display".equals(attributeName)) {
                this.display = Display.fromString(attributeValue);
            } else if ("id".equals(attributeName)) {
                this.id = attributeValue;
            } else if ("priority".equals(attributeName)) {
                this.priority = Integer.parseInt(attributeValue);
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

    public Bitmap getBitmap() {
        if (this.bitmap == null && !this.bitmapInvalid) {
            try {
                this.bitmap = createBitmap(this.relativePathPrefix, this.src);
            } catch (IOException unused) {
                this.bitmapInvalid = true;
            }
        }
        return this.bitmap;
    }

    public String getId() {
        return this.id;
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderNode(RenderCallback renderCallback, RenderContext renderContext, PointOfInterest pointOfInterest) {
        if (Display.NEVER == this.display || getBitmap() == null) {
            return;
        }
        renderCallback.renderPointOfInterestSymbol(renderContext, this.display, this.priority, this.bitmap, pointOfInterest);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        if (Display.NEVER == this.display || getBitmap() == null) {
            return;
        }
        renderCallback.renderAreaSymbol(renderContext, this.display, this.priority, this.bitmap, polylineContainer);
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleStrokeWidth(float f3, byte b4) {
    }

    @Override // org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction
    public void scaleTextSize(float f3, byte b4) {
    }
}
