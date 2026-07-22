package org.mapsforge.core.model;

/* loaded from: /root/release/classes2.dex */
public class MapPosition {
    public final LatLong latLong;
    public final byte zoomLevel;

    public MapPosition(LatLong latLong, byte b4) {
        if (latLong == null) {
            throw new IllegalArgumentException("latLong must not be null");
        }
        if (b4 >= 0) {
            this.latLong = latLong;
            this.zoomLevel = b4;
        } else {
            throw new IllegalArgumentException("zoomLevel must not be negative: " + ((int) b4));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapPosition)) {
            return false;
        }
        MapPosition mapPosition = (MapPosition) obj;
        return this.latLong.equals(mapPosition.latLong) && this.zoomLevel == mapPosition.zoomLevel;
    }

    public int hashCode() {
        return ((this.latLong.hashCode() + 31) * 31) + this.zoomLevel;
    }

    public String toString() {
        return "latLong=" + this.latLong + ", zoomLevel=" + ((int) this.zoomLevel);
    }
}
