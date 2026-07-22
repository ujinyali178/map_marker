package org.mapsforge.map.layer.hills;

import java.io.File;
import org.mapsforge.core.graphics.HillshadingBitmap;

/* loaded from: /root/release/classes2.dex */
public interface ShadeTileSource {
    void applyConfiguration(boolean z3);

    HillshadingBitmap getHillshadingBitmap(int i3, int i4, double d3, double d4);

    void prepareOnThread();

    void setDemFolder(File file);

    void setShadingAlgorithm(ShadingAlgorithm shadingAlgorithm);
}
