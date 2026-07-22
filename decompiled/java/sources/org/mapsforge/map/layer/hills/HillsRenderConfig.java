package org.mapsforge.map.layer.hills;

import java.io.File;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.HillshadingBitmap;

/* loaded from: /root/release/classes2.dex */
public class HillsRenderConfig {
    private float maginuteScaleFactor = 1.0f;
    private ShadeTileSource tileSource;

    public HillsRenderConfig(File file, GraphicFactory graphicFactory, ShadeTileSource shadeTileSource, ShadingAlgorithm shadingAlgorithm) {
        shadeTileSource = shadeTileSource == null ? new MemoryCachingHgtReaderTileSource(file, shadingAlgorithm, graphicFactory) : shadeTileSource;
        this.tileSource = shadeTileSource;
        shadeTileSource.setDemFolder(file);
        this.tileSource.setShadingAlgorithm(shadingAlgorithm);
    }

    public HillsRenderConfig(ShadeTileSource shadeTileSource) {
        this.tileSource = shadeTileSource;
    }

    public float getMaginuteScaleFactor() {
        return this.maginuteScaleFactor;
    }

    public HillshadingBitmap getShadingTile(int i3, int i4, double d3, double d4) {
        ShadeTileSource shadeTileSource = this.tileSource;
        if (shadeTileSource == null) {
            return null;
        }
        HillshadingBitmap hillshadingBitmap = shadeTileSource.getHillshadingBitmap(i3, i4, d3, d4);
        if (hillshadingBitmap != null || Math.abs(i4) <= 178) {
            return hillshadingBitmap;
        }
        return shadeTileSource.getHillshadingBitmap(i3, i4 > 0 ? i4 - 180 : i4 + 180, d3, d4);
    }

    public ShadeTileSource getTileSource() {
        return this.tileSource;
    }

    public HillsRenderConfig indexOnThread() {
        ShadeTileSource shadeTileSource = this.tileSource;
        if (shadeTileSource != null) {
            shadeTileSource.applyConfiguration(true);
        }
        return this;
    }

    public void setMaginuteScaleFactor(float f3) {
        this.maginuteScaleFactor = f3;
    }

    public void setTileSource(ShadeTileSource shadeTileSource) {
        this.tileSource = shadeTileSource;
    }
}
