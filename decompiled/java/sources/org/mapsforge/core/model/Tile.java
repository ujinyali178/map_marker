package org.mapsforge.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.mapsforge.core.util.MercatorProjection;

/* loaded from: /root/release/classes2.dex */
public class Tile implements Serializable {
    private static final long serialVersionUID = 1;
    private BoundingBox boundingBox;
    public final long mapSize;
    private Point origin;
    public final int tileSize;
    public final int tileX;
    public final int tileY;
    public final byte zoomLevel;

    public Tile(int i3, int i4, byte b4, int i5) {
        if (i3 < 0) {
            throw new IllegalArgumentException("tileX must not be negative: " + i3);
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("tileY must not be negative: " + i4);
        }
        if (b4 < 0) {
            throw new IllegalArgumentException("zoomLevel must not be negative: " + ((int) b4));
        }
        long maxTileNumber = getMaxTileNumber(b4);
        if (i3 > maxTileNumber) {
            throw new IllegalArgumentException("invalid tileX number on zoom level " + ((int) b4) + ": " + i3);
        }
        if (i4 <= maxTileNumber) {
            this.tileSize = i5;
            this.tileX = i3;
            this.tileY = i4;
            this.zoomLevel = b4;
            this.mapSize = MercatorProjection.getMapSize(b4, i5);
            return;
        }
        throw new IllegalArgumentException("invalid tileY number on zoom level " + ((int) b4) + ": " + i4);
    }

    public static Rectangle getBoundaryAbsolute(Tile tile, Tile tile2) {
        return new Rectangle(tile.getOrigin().f4076x, tile.getOrigin().f4077y, tile2.getOrigin().f4076x + tile.tileSize, tile2.getOrigin().f4077y + tile.tileSize);
    }

    public static BoundingBox getBoundingBox(Tile tile, Tile tile2) {
        return tile.getBoundingBox().extendBoundingBox(tile2.getBoundingBox());
    }

    public static int getMaxTileNumber(byte b4) {
        if (b4 >= 0) {
            if (b4 == 0) {
                return 0;
            }
            return (2 << (b4 - 1)) - 1;
        }
        throw new IllegalArgumentException("zoomLevel must not be negative: " + ((int) b4));
    }

    public static boolean tileAreasOverlap(Tile tile, Tile tile2, Tile tile3, Tile tile4) {
        if (tile.zoomLevel != tile3.zoomLevel) {
            return false;
        }
        if (tile.equals(tile3) && tile2.equals(tile4)) {
            return true;
        }
        return getBoundaryAbsolute(tile, tile2).intersects(getBoundaryAbsolute(tile3, tile4));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) obj;
        return this.tileX == tile.tileX && this.tileY == tile.tileY && this.zoomLevel == tile.zoomLevel && this.tileSize == tile.tileSize;
    }

    public Tile getAbove() {
        int i3 = this.tileY - 1;
        if (i3 < 0) {
            i3 = getMaxTileNumber(this.zoomLevel);
        }
        return new Tile(this.tileX, i3, this.zoomLevel, this.tileSize);
    }

    public Tile getAboveLeft() {
        int i3 = this.tileY - 1;
        int i4 = this.tileX - 1;
        if (i3 < 0) {
            i3 = getMaxTileNumber(this.zoomLevel);
        }
        if (i4 < 0) {
            i4 = getMaxTileNumber(this.zoomLevel);
        }
        return new Tile(i4, i3, this.zoomLevel, this.tileSize);
    }

    public Tile getAboveRight() {
        int i3 = this.tileY - 1;
        int i4 = this.tileX + 1;
        if (i3 < 0) {
            i3 = getMaxTileNumber(this.zoomLevel);
        }
        if (i4 > getMaxTileNumber(this.zoomLevel)) {
            i4 = 0;
        }
        return new Tile(i4, i3, this.zoomLevel, this.tileSize);
    }

    public Tile getBelow() {
        int i3 = this.tileY + 1;
        if (i3 > getMaxTileNumber(this.zoomLevel)) {
            i3 = 0;
        }
        return new Tile(this.tileX, i3, this.zoomLevel, this.tileSize);
    }

    public Tile getBelowLeft() {
        int i3 = this.tileY + 1;
        int i4 = this.tileX - 1;
        if (i3 > getMaxTileNumber(this.zoomLevel)) {
            i3 = 0;
        }
        if (i4 < 0) {
            i4 = getMaxTileNumber(this.zoomLevel);
        }
        return new Tile(i4, i3, this.zoomLevel, this.tileSize);
    }

    public Tile getBelowRight() {
        int i3 = this.tileY + 1;
        int i4 = this.tileX + 1;
        if (i3 > getMaxTileNumber(this.zoomLevel)) {
            i3 = 0;
        }
        if (i4 > getMaxTileNumber(this.zoomLevel)) {
            i4 = 0;
        }
        return new Tile(i4, i3, this.zoomLevel, this.tileSize);
    }

    public Rectangle getBoundaryAbsolute() {
        return new Rectangle(getOrigin().f4076x, getOrigin().f4077y, getOrigin().f4076x + this.tileSize, getOrigin().f4077y + this.tileSize);
    }

    public Rectangle getBoundaryRelative() {
        int i3 = this.tileSize;
        return new Rectangle(0.0d, 0.0d, i3, i3);
    }

    public BoundingBox getBoundingBox() {
        if (this.boundingBox == null) {
            double max = Math.max(-85.05112877980659d, MercatorProjection.tileYToLatitude(this.tileY + 1, this.zoomLevel));
            double max2 = Math.max(-180.0d, MercatorProjection.tileXToLongitude(this.tileX, this.zoomLevel));
            double min = Math.min(85.05112877980659d, MercatorProjection.tileYToLatitude(this.tileY, this.zoomLevel));
            double min2 = Math.min(180.0d, MercatorProjection.tileXToLongitude(this.tileX + 1, this.zoomLevel));
            this.boundingBox = new BoundingBox(max, max2, min, min2 != -180.0d ? min2 : 180.0d);
        }
        return this.boundingBox;
    }

    public Tile getLeft() {
        int i3 = this.tileX - 1;
        if (i3 < 0) {
            i3 = getMaxTileNumber(this.zoomLevel);
        }
        return new Tile(i3, this.tileY, this.zoomLevel, this.tileSize);
    }

    public Set<Tile> getNeighbours() {
        HashSet hashSet = new HashSet(8);
        hashSet.add(getLeft());
        hashSet.add(getAboveLeft());
        hashSet.add(getAbove());
        hashSet.add(getAboveRight());
        hashSet.add(getRight());
        hashSet.add(getBelowRight());
        hashSet.add(getBelow());
        hashSet.add(getBelowLeft());
        return hashSet;
    }

    public Point getOrigin() {
        if (this.origin == null) {
            this.origin = new Point(MercatorProjection.tileToPixel(this.tileX, this.tileSize), MercatorProjection.tileToPixel(this.tileY, this.tileSize));
        }
        return this.origin;
    }

    public Tile getParent() {
        byte b4 = this.zoomLevel;
        if (b4 == 0) {
            return null;
        }
        return new Tile(this.tileX / 2, this.tileY / 2, (byte) (b4 - 1), this.tileSize);
    }

    public Tile getRight() {
        int i3 = this.tileX + 1;
        if (i3 > getMaxTileNumber(this.zoomLevel)) {
            i3 = 0;
        }
        return new Tile(i3, this.tileY, this.zoomLevel, this.tileSize);
    }

    public int getShiftX(Tile tile) {
        if (equals(tile)) {
            return 0;
        }
        return (this.tileX % 2) + (getParent().getShiftX(tile) * 2);
    }

    public int getShiftY(Tile tile) {
        if (equals(tile)) {
            return 0;
        }
        return (this.tileY % 2) + (getParent().getShiftY(tile) * 2);
    }

    public int hashCode() {
        int i3 = this.tileX;
        int i4 = (217 + (i3 ^ (i3 >>> 16))) * 31;
        int i5 = this.tileY;
        return ((((i4 + (i5 ^ (i5 >>> 16))) * 31) + this.zoomLevel) * 31) + this.tileSize;
    }

    public String toString() {
        return "x=" + this.tileX + ", y=" + this.tileY + ", z=" + ((int) this.zoomLevel);
    }
}
