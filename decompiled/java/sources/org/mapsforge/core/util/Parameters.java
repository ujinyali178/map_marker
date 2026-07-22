package org.mapsforge.core.util;

/* loaded from: /root/release/classes2.dex */
public final class Parameters {
    public static boolean ANTI_ALIASING = true;
    public static int MAXIMUM_BUFFER_SIZE = 8000000;
    public static int NUMBER_OF_THREADS = 1;
    public static ParentTilesRendering PARENT_TILES_RENDERING = ParentTilesRendering.QUALITY;
    public static boolean SQUARE_FRAME_BUFFER = true;

    public enum ParentTilesRendering {
        QUALITY,
        SPEED,
        OFF
    }

    private Parameters() {
        throw new IllegalStateException();
    }
}
