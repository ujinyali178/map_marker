package org.mapsforge.map.android.graphics;

import org.mapsforge.core.graphics.HillshadingBitmap;
import org.mapsforge.core.model.BoundingBox;

/* loaded from: /root/release/classes2.dex */
public class AndroidHillshadingBitmap extends AndroidBitmap implements HillshadingBitmap {
    private final BoundingBox areaRect;
    private final int padding;

    public AndroidHillshadingBitmap(int i3, int i4, int i5, BoundingBox boundingBox) {
        super(i3, i4, AndroidGraphicFactory.MONO_ALPHA_BITMAP);
        this.padding = i5;
        this.areaRect = boundingBox;
    }

    @Override // org.mapsforge.core.graphics.HillshadingBitmap
    public BoundingBox getAreaRect() {
        return this.areaRect;
    }

    @Override // org.mapsforge.core.graphics.HillshadingBitmap
    public int getPadding() {
        return this.padding;
    }
}
