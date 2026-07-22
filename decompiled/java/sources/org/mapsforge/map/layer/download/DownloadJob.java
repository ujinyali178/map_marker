package org.mapsforge.map.layer.download;

import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.download.tilesource.TileSource;
import org.mapsforge.map.layer.queue.Job;

/* loaded from: /root/release/classes2.dex */
public class DownloadJob extends Job {
    public final TileSource tileSource;

    public DownloadJob(Tile tile, TileSource tileSource) {
        super(tile, tileSource.hasAlpha());
        this.tileSource = tileSource;
    }

    @Override // org.mapsforge.map.layer.queue.Job
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof DownloadJob)) {
            return this.tileSource.equals(((DownloadJob) obj).tileSource);
        }
        return false;
    }

    @Override // org.mapsforge.map.layer.queue.Job
    public int hashCode() {
        return (super.hashCode() * 31) + this.tileSource.hashCode();
    }
}
