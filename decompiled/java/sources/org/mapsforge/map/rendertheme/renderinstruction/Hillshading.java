package org.mapsforge.map.rendertheme.renderinstruction;

import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicFactory;

/* loaded from: /root/release/classes2.dex */
public class Hillshading {
    private static final Logger LOGGER = Logger.getLogger(Hillshading.class.getName());
    private boolean always;
    private final byte layer;
    private final int level;
    private final float magnitude;
    private final byte maxZoom;
    private final byte minZoom;

    public Hillshading(byte b4, byte b5, short s3, byte b6, boolean z3, int i3, GraphicFactory graphicFactory) {
        this.always = z3;
        this.level = i3;
        this.layer = b6;
        this.minZoom = b4;
        this.maxZoom = b5;
        this.magnitude = s3;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void render(org.mapsforge.map.rendertheme.RenderContext r62, org.mapsforge.map.layer.hills.HillsRenderConfig r63) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.rendertheme.renderinstruction.Hillshading.render(org.mapsforge.map.rendertheme.RenderContext, org.mapsforge.map.layer.hills.HillsRenderConfig):void");
    }
}
