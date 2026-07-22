package org.mapsforge.map.reader;

import org.mapsforge.core.model.Tile;
import org.mapsforge.map.reader.header.SubFileParameter;

/* loaded from: /root/release/classes2.dex */
class QueryParameters {
    long fromBaseTileX;
    long fromBaseTileY;
    long fromBlockX;
    long fromBlockY;
    int queryTileBitmask;
    int queryZoomLevel;
    long toBaseTileX;
    long toBaseTileY;
    long toBlockX;
    long toBlockY;
    boolean useTileBitmask;

    QueryParameters() {
    }

    public void calculateBaseTiles(Tile tile, Tile tile2, SubFileParameter subFileParameter) {
        int i3;
        byte b4 = tile.zoomLevel;
        byte b5 = subFileParameter.baseZoomLevel;
        if (b4 < b5) {
            int i4 = b5 - b4;
            this.fromBaseTileX = tile.tileX << i4;
            this.fromBaseTileY = tile.tileY << i4;
            this.toBaseTileX = ((tile2.tileX << i4) + r0) - 1;
            i3 = ((tile2.tileY << i4) + (1 << i4)) - 1;
        } else {
            if (b4 > b5) {
                this.fromBaseTileX = tile.tileX >>> r0;
                this.fromBaseTileY = tile.tileY >>> r0;
                this.toBaseTileX = tile2.tileX >>> r0;
                this.toBaseTileY = tile2.tileY >>> r0;
                this.useTileBitmask = true;
                this.queryTileBitmask = QueryCalculations.calculateTileBitmask(tile, tile2, b4 - b5);
                return;
            }
            this.fromBaseTileX = tile.tileX;
            this.fromBaseTileY = tile.tileY;
            this.toBaseTileX = tile2.tileX;
            i3 = tile2.tileY;
        }
        this.toBaseTileY = i3;
        this.useTileBitmask = false;
    }

    public void calculateBaseTiles(Tile tile, SubFileParameter subFileParameter) {
        byte b4 = tile.zoomLevel;
        byte b5 = subFileParameter.baseZoomLevel;
        if (b4 < b5) {
            int i3 = b5 - b4;
            long j3 = tile.tileX << i3;
            this.fromBaseTileX = j3;
            long j4 = tile.tileY << i3;
            this.fromBaseTileY = j4;
            long j5 = 1 << i3;
            this.toBaseTileX = (j3 + j5) - 1;
            this.toBaseTileY = (j4 + j5) - 1;
        } else {
            if (b4 > b5) {
                int i4 = b4 - b5;
                long j6 = tile.tileX >>> i4;
                this.fromBaseTileX = j6;
                long j7 = tile.tileY >>> i4;
                this.fromBaseTileY = j7;
                this.toBaseTileX = j6;
                this.toBaseTileY = j7;
                this.useTileBitmask = true;
                this.queryTileBitmask = QueryCalculations.calculateTileBitmask(tile, i4);
                return;
            }
            long j8 = tile.tileX;
            this.fromBaseTileX = j8;
            long j9 = tile.tileY;
            this.fromBaseTileY = j9;
            this.toBaseTileX = j8;
            this.toBaseTileY = j9;
        }
        this.useTileBitmask = false;
    }

    public void calculateBlocks(SubFileParameter subFileParameter) {
        this.fromBlockX = Math.max(this.fromBaseTileX - subFileParameter.boundaryTileLeft, 0L);
        this.fromBlockY = Math.max(this.fromBaseTileY - subFileParameter.boundaryTileTop, 0L);
        this.toBlockX = Math.min(this.toBaseTileX - subFileParameter.boundaryTileLeft, subFileParameter.blocksWidth - 1);
        this.toBlockY = Math.min(this.toBaseTileY - subFileParameter.boundaryTileTop, subFileParameter.blocksHeight - 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryParameters)) {
            return false;
        }
        QueryParameters queryParameters = (QueryParameters) obj;
        return this.fromBaseTileX == queryParameters.fromBaseTileX && this.fromBlockX == queryParameters.fromBlockX && this.fromBaseTileY == queryParameters.fromBaseTileY && this.fromBlockY == queryParameters.fromBlockY && this.queryTileBitmask == queryParameters.queryTileBitmask && this.queryZoomLevel == queryParameters.queryZoomLevel && this.toBaseTileX == queryParameters.toBaseTileX && this.toBaseTileY == queryParameters.toBaseTileY && this.toBlockX == queryParameters.toBlockX && this.toBlockY == queryParameters.toBlockY && this.useTileBitmask == queryParameters.useTileBitmask;
    }

    public int hashCode() {
        long j3 = this.fromBaseTileX;
        long j4 = this.fromBaseTileY;
        int i3 = (((217 + ((int) (j3 ^ (j3 >>> 16)))) * 31) + ((int) (j4 ^ (j4 >>> 16)))) * 31;
        long j5 = this.toBaseTileX;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 16)))) * 31;
        long j6 = this.toBaseTileY;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 16)))) * 31;
        long j7 = this.fromBlockX;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 16)))) * 31;
        long j8 = this.fromBlockY;
        int i7 = (i6 + ((int) (j8 ^ (j8 >>> 16)))) * 31;
        long j9 = this.toBlockX;
        int i8 = (i7 + ((int) (j9 ^ (j9 >>> 16)))) * 31;
        long j10 = this.toBlockY;
        return ((((i8 + ((int) ((j10 >>> 16) ^ j10))) * 31) + this.queryZoomLevel) * 31) + this.queryTileBitmask;
    }
}
