package org.mapsforge.map.rendertheme.renderinstruction;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.XmlUtils;

/* loaded from: /root/release/classes2.dex */
public abstract class RenderInstruction {
    static final String ALIGN_CENTER = "align-center";
    static final String ALL = "all";
    static final String CAT = "cat";
    static final String DISPLAY = "display";
    static final String DY = "dy";
    static final String FILL = "fill";
    static final String FONT_FAMILY = "font-family";
    static final String FONT_SIZE = "font-size";
    static final String FONT_STYLE = "font-style";
    static final String ID = "id";
    static final String K = "k";
    static final String NONE = "none";
    static final String POSITION = "position";
    static final String PRIORITY = "priority";
    static final String R = "r";
    static final String RADIUS = "radius";
    static final String REPEAT = "repeat";
    static final String REPEAT_GAP = "repeat-gap";
    static final String REPEAT_START = "repeat-start";
    static final String ROTATE = "rotate";
    static final String SCALE = "scale";
    static final String SCALE_RADIUS = "scale-radius";
    static final String SRC = "src";
    static final String STROKE = "stroke";
    static final String STROKE_DASHARRAY = "stroke-dasharray";
    static final String STROKE_LINECAP = "stroke-linecap";
    static final String STROKE_LINEJOIN = "stroke-linejoin";
    static final String STROKE_WIDTH = "stroke-width";
    static final String SYMBOL_HEIGHT = "symbol-height";
    static final String SYMBOL_ID = "symbol-id";
    static final String SYMBOL_PERCENT = "symbol-percent";
    static final String SYMBOL_SCALING = "symbol-scaling";
    static final String SYMBOL_WIDTH = "symbol-width";
    protected String category;
    public final DisplayModel displayModel;
    public final GraphicFactory graphicFactory;
    protected float height;
    protected int percent = 100;
    protected float width;

    enum Scale {
        ALL,
        NONE,
        STROKE
    }

    protected RenderInstruction(GraphicFactory graphicFactory, DisplayModel displayModel) {
        this.displayModel = displayModel;
        this.graphicFactory = graphicFactory;
    }

    protected Bitmap createBitmap(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        return XmlUtils.createBitmap(this.graphicFactory, this.displayModel, str, str2, (int) this.width, (int) this.height, this.percent);
    }

    public abstract void destroy();

    public String getCategory() {
        return this.category;
    }

    public abstract void renderNode(RenderCallback renderCallback, RenderContext renderContext, PointOfInterest pointOfInterest);

    public abstract void renderWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer);

    protected Scale scaleFromValue(String str) {
        return str.equals(ALL) ? Scale.ALL : str.equals("none") ? Scale.NONE : Scale.STROKE;
    }

    public abstract void scaleStrokeWidth(float f3, byte b4);

    public abstract void scaleTextSize(float f3, byte b4);
}
