package org.mapsforge.map.layer.download.tilesource;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.base.Ascii;
import java.net.URL;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public class OnlineTileSource extends AbstractTileSource {
    private boolean alpha;
    private String baseUrl;
    private String extension;
    private String name;
    private int parallelRequestsLimit;
    private String protocol;
    private int tileSize;
    private byte zoomLevelMax;
    private byte zoomLevelMin;

    public OnlineTileSource(String[] strArr, int i3) {
        super(strArr, i3);
        this.alpha = false;
        this.baseUrl = "/";
        this.extension = "png";
        this.parallelRequestsLimit = 8;
        this.protocol = "http";
        this.tileSize = UserVerificationMethods.USER_VERIFY_HANDPRINT;
        this.zoomLevelMax = Ascii.DC2;
        this.zoomLevelMin = (byte) 0;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.AbstractTileSource
    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof OnlineTileSource) && this.baseUrl.equals(((OnlineTileSource) obj).baseUrl);
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getName() {
        return this.name;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public int getParallelRequestsLimit() {
        return this.parallelRequestsLimit;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public int getTileSize() {
        return this.tileSize;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public URL getTileUrl(Tile tile) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.baseUrl);
        sb.append((int) tile.zoomLevel);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(tile.tileX);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(tile.tileY);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.extension);
        if (this.apiKey != null) {
            sb.append('?');
            sb.append(this.keyName);
            sb.append("=");
            sb.append(this.apiKey);
        }
        return new URL(this.protocol, getHostName(), this.port, sb.toString());
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public byte getZoomLevelMax() {
        return this.zoomLevelMax;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public byte getZoomLevelMin() {
        return this.zoomLevelMin;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public boolean hasAlpha() {
        return this.alpha;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.AbstractTileSource
    public int hashCode() {
        return (super.hashCode() * 31) + this.baseUrl.hashCode();
    }

    public OnlineTileSource setAlpha(boolean z3) {
        this.alpha = z3;
        return this;
    }

    public OnlineTileSource setBaseUrl(String str) {
        this.baseUrl = str;
        return this;
    }

    public OnlineTileSource setExtension(String str) {
        this.extension = str;
        return this;
    }

    public OnlineTileSource setName(String str) {
        this.name = str;
        return this;
    }

    public OnlineTileSource setParallelRequestsLimit(int i3) {
        this.parallelRequestsLimit = i3;
        return this;
    }

    public OnlineTileSource setProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public OnlineTileSource setTileSize(int i3) {
        this.tileSize = i3;
        return this;
    }

    public OnlineTileSource setZoomLevelMax(byte b4) {
        this.zoomLevelMax = b4;
        return this;
    }

    public OnlineTileSource setZoomLevelMin(byte b4) {
        this.zoomLevelMin = b4;
        return this;
    }
}
