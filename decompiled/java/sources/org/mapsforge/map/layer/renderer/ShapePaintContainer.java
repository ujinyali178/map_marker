package org.mapsforge.map.layer.renderer;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Paint;

/* loaded from: /root/release/classes2.dex */
public class ShapePaintContainer {
    final float dy;
    final Paint paint;
    final ShapeContainer shapeContainer;

    public ShapePaintContainer(ShapeContainer shapeContainer, Paint paint) {
        this(shapeContainer, paint, BitmapDescriptorFactory.HUE_RED);
    }

    public ShapePaintContainer(ShapeContainer shapeContainer, Paint paint, float f3) {
        this.shapeContainer = shapeContainer;
        this.paint = paint;
        this.dy = f3;
    }
}
