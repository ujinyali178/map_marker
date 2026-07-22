package org.mapsforge.map.layer.renderer;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.HillshadingBitmap;
import org.mapsforge.core.model.Rectangle;

/* loaded from: /root/release/classes2.dex */
public class HillshadingContainer implements ShapeContainer {
    public final Bitmap bitmap;
    public final Rectangle hillsRect;
    public final float magnitude;
    public final Rectangle tileRect;

    public HillshadingContainer(HillshadingBitmap hillshadingBitmap, float f3, Rectangle rectangle, Rectangle rectangle2) {
        this.magnitude = f3;
        this.bitmap = hillshadingBitmap;
        this.hillsRect = rectangle;
        this.tileRect = rectangle2;
    }

    @Override // org.mapsforge.map.layer.renderer.ShapeContainer
    public ShapeType getShapeType() {
        return ShapeType.HILLSHADING;
    }

    public String toString() {
        return "[Hillshading:" + this.magnitude + "#" + System.identityHashCode(this.bitmap) + "\n @# " + this.hillsRect + "\n -> " + this.tileRect + "\n]";
    }
}
