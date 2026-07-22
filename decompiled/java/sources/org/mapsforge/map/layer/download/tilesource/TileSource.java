package org.mapsforge.map.layer.download.tilesource;

import java.net.URL;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public interface TileSource {
    String getAuthorization();

    long getDefaultTimeToLive();

    int getParallelRequestsLimit();

    String getReferer();

    URL getTileUrl(Tile tile);

    int getTimeoutConnect();

    int getTimeoutRead();

    String getUserAgent();

    byte getZoomLevelMax();

    byte getZoomLevelMin();

    boolean hasAlpha();

    boolean isFollowRedirects();
}
