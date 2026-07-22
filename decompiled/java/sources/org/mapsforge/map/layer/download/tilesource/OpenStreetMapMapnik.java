package org.mapsforge.map.layer.download.tilesource;

import com.google.common.base.Ascii;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public class OpenStreetMapMapnik extends AbstractTileSource {
    public static final OpenStreetMapMapnik INSTANCE = new OpenStreetMapMapnik(new String[]{"a.tile.openstreetmap.org", "b.tile.openstreetmap.org", "c.tile.openstreetmap.org"}, 443);
    private static final int PARALLEL_REQUESTS_LIMIT = 8;
    private static final String PROTOCOL = "https";
    private static final int ZOOM_LEVEL_MAX = 18;
    private static final int ZOOM_LEVEL_MIN = 0;

    public OpenStreetMapMapnik(String[] strArr, int i3) {
        super(strArr, i3);
        this.defaultTimeToLive = 8279000L;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public int getParallelRequestsLimit() {
        return 8;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public URL getTileUrl(Tile tile) {
        return new URL(PROTOCOL, getHostName(), this.port, "/" + ((int) tile.zoomLevel) + IOUtils.DIR_SEPARATOR_UNIX + tile.tileX + IOUtils.DIR_SEPARATOR_UNIX + tile.tileY + ".png");
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public byte getZoomLevelMax() {
        return Ascii.DC2;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public byte getZoomLevelMin() {
        return (byte) 0;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public boolean hasAlpha() {
        return false;
    }
}
