package org.mapsforge.map.reader.header;

import org.mapsforge.core.util.MercatorProjection;

/* loaded from: /root/release/classes2.dex */
public class SubFileParameter {
    public static final byte BYTES_PER_INDEX_ENTRY = 5;
    public final byte baseZoomLevel;
    public final long blocksHeight;
    public final long blocksWidth;
    public final long boundaryTileBottom;
    public final long boundaryTileLeft;
    public final long boundaryTileRight;
    public final long boundaryTileTop;
    private final int hashCodeValue;
    public final long indexEndAddress;
    public final long indexStartAddress;
    public final long numberOfBlocks;
    public final long startAddress;
    public final long subFileSize;
    public final byte zoomLevelMax;
    public final byte zoomLevelMin;

    SubFileParameter(SubFileParameterBuilder subFileParameterBuilder) {
        this.startAddress = subFileParameterBuilder.startAddress;
        long j3 = subFileParameterBuilder.indexStartAddress;
        this.indexStartAddress = j3;
        this.subFileSize = subFileParameterBuilder.subFileSize;
        byte b4 = subFileParameterBuilder.baseZoomLevel;
        this.baseZoomLevel = b4;
        this.zoomLevelMin = subFileParameterBuilder.zoomLevelMin;
        this.zoomLevelMax = subFileParameterBuilder.zoomLevelMax;
        this.hashCodeValue = calculateHashCode();
        long latitudeToTileY = MercatorProjection.latitudeToTileY(subFileParameterBuilder.boundingBox.minLatitude, b4);
        this.boundaryTileBottom = latitudeToTileY;
        long longitudeToTileX = MercatorProjection.longitudeToTileX(subFileParameterBuilder.boundingBox.minLongitude, b4);
        this.boundaryTileLeft = longitudeToTileX;
        long latitudeToTileY2 = MercatorProjection.latitudeToTileY(subFileParameterBuilder.boundingBox.maxLatitude, b4);
        this.boundaryTileTop = latitudeToTileY2;
        long longitudeToTileX2 = MercatorProjection.longitudeToTileX(subFileParameterBuilder.boundingBox.maxLongitude, b4);
        this.boundaryTileRight = longitudeToTileX2;
        long j4 = (longitudeToTileX2 - longitudeToTileX) + 1;
        this.blocksWidth = j4;
        long j5 = (latitudeToTileY - latitudeToTileY2) + 1;
        this.blocksHeight = j5;
        long j6 = j4 * j5;
        this.numberOfBlocks = j6;
        this.indexEndAddress = j3 + (j6 * 5);
    }

    private int calculateHashCode() {
        long j3 = this.startAddress;
        int i3 = (217 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.subFileSize;
        return ((i3 + ((int) ((j4 >>> 32) ^ j4))) * 31) + this.baseZoomLevel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubFileParameter)) {
            return false;
        }
        SubFileParameter subFileParameter = (SubFileParameter) obj;
        return this.startAddress == subFileParameter.startAddress && this.subFileSize == subFileParameter.subFileSize && this.baseZoomLevel == subFileParameter.baseZoomLevel;
    }

    public int hashCode() {
        return this.hashCodeValue;
    }
}
