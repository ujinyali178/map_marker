package org.mapsforge.map.layer.download.tilesource;

import java.util.Arrays;
import java.util.Random;

/* loaded from: /root/release/classes2.dex */
public abstract class AbstractTileSource implements TileSource {
    private static final int TIMEOUT_CONNECT = 5000;
    private static final int TIMEOUT_READ = 10000;
    protected String apiKey;
    protected String authorization;
    protected final String[] hostNames;
    protected final int port;
    protected String referer;
    protected String userAgent;
    protected long defaultTimeToLive = 86400000;
    protected boolean followRedirects = true;
    protected String keyName = "key";
    protected final Random random = new Random();
    protected int timeoutConnect = TIMEOUT_CONNECT;
    protected int timeoutRead = TIMEOUT_READ;

    protected AbstractTileSource(String[] strArr, int i3) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("no host names specified");
        }
        if (i3 < 0 || i3 > 65535) {
            throw new IllegalArgumentException("invalid port number: " + i3);
        }
        for (String str : strArr) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("empty host name in host name list");
            }
        }
        this.hostNames = strArr;
        this.port = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractTileSource)) {
            return false;
        }
        AbstractTileSource abstractTileSource = (AbstractTileSource) obj;
        return Arrays.equals(this.hostNames, abstractTileSource.hostNames) && this.port == abstractTileSource.port;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public String getAuthorization() {
        return this.authorization;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public long getDefaultTimeToLive() {
        return this.defaultTimeToLive;
    }

    protected String getHostName() {
        String[] strArr = this.hostNames;
        return strArr[this.random.nextInt(strArr.length)];
    }

    public String getKeyName() {
        return this.keyName;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public String getReferer() {
        return this.referer;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public int getTimeoutConnect() {
        return this.timeoutConnect;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public int getTimeoutRead() {
        return this.timeoutRead;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.hostNames) + 31) * 31) + this.port;
    }

    @Override // org.mapsforge.map.layer.download.tilesource.TileSource
    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setAuthorization(String str) {
        this.authorization = str;
    }

    public void setFollowRedirects(boolean z3) {
        this.followRedirects = z3;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }

    public void setReferer(String str) {
        this.referer = str;
    }

    public void setTimeoutConnect(int i3) {
        this.timeoutConnect = i3;
    }

    public void setTimeoutRead(int i3) {
        this.timeoutRead = i3;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}
