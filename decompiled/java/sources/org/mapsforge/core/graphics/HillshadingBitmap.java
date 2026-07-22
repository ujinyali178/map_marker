package org.mapsforge.core.graphics;

import org.mapsforge.core.model.BoundingBox;

/* loaded from: /root/release/classes2.dex */
public interface HillshadingBitmap extends Bitmap {

    public enum Border {
        WEST(true),
        NORTH(false),
        EAST(true),
        SOUTH(false);

        public final boolean vertical;

        Border(boolean z3) {
            this.vertical = z3;
        }
    }

    BoundingBox getAreaRect();

    int getPadding();
}
