package org.mapsforge.map.layer.queue;

import java.io.File;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public class Job {
    public final boolean hasAlpha;
    private final String key;
    public final Tile tile;

    public Job(Tile tile, boolean z3) {
        if (tile == null) {
            throw new IllegalArgumentException("tile must not be null");
        }
        this.tile = tile;
        this.hasAlpha = z3;
        this.key = composeKey(tile.zoomLevel, tile.tileX, tile.tileY);
    }

    private static String composeKey(byte b4, long j3, long j4) {
        return String.valueOf((int) b4) + File.separatorChar + j3 + File.separatorChar + j4;
    }

    public static String composeKey(String str, String str2, String str3) {
        return str + File.separatorChar + str2 + File.separatorChar + str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Job)) {
            return false;
        }
        Job job = (Job) obj;
        return this.hasAlpha == job.hasAlpha && this.tile.equals(job.tile);
    }

    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.tile.hashCode();
    }
}
