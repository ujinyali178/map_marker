package org.mapsforge.map.layer.renderer;

import java.util.List;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.model.Tile;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.datastore.Way;

/* loaded from: /root/release/classes2.dex */
public class PolylineContainer implements ShapeContainer {
    private Point center;
    private Point[][] coordinatesAbsolute;
    private Point[][] coordinatesRelativeToTile;
    private final boolean isClosedWay;
    private final byte layer;
    private final Tile lowerRight;
    private final List<Tag> tags;
    private final Tile upperLeft;
    private Way way;

    public PolylineContainer(Way way, Tile tile, Tile tile2) {
        this.coordinatesAbsolute = null;
        this.coordinatesRelativeToTile = null;
        this.tags = way.tags;
        this.upperLeft = tile;
        this.lowerRight = tile2;
        this.layer = way.layer;
        this.way = way;
        this.isClosedWay = LatLongUtils.isClosedWay(way.latLongs[0]);
        LatLong latLong = this.way.labelPosition;
        if (latLong != null) {
            this.center = MercatorProjection.getPixelAbsolute(latLong, tile.mapSize);
        }
    }

    public PolylineContainer(Point[] pointArr, Tile tile, Tile tile2, List<Tag> list) {
        this.coordinatesAbsolute = new Point[][]{r2};
        this.coordinatesRelativeToTile = null;
        Point[] pointArr2 = new Point[pointArr.length];
        System.arraycopy(pointArr, 0, pointArr2, 0, pointArr.length);
        this.tags = list;
        this.upperLeft = tile;
        this.lowerRight = tile2;
        this.layer = (byte) 0;
        this.isClosedWay = pointArr[0].equals(pointArr[pointArr.length - 1]);
    }

    public Point getCenterAbsolute() {
        if (this.center == null) {
            this.center = GeometryUtils.calculateCenterOfBoundingBox(getCoordinatesAbsolute()[0]);
        }
        return this.center;
    }

    public Point[][] getCoordinatesAbsolute() {
        if (this.coordinatesAbsolute == null) {
            this.coordinatesAbsolute = new Point[this.way.latLongs.length][];
            int i3 = 0;
            while (true) {
                LatLong[][] latLongArr = this.way.latLongs;
                if (i3 >= latLongArr.length) {
                    break;
                }
                this.coordinatesAbsolute[i3] = new Point[latLongArr[i3].length];
                int i4 = 0;
                while (true) {
                    LatLong[] latLongArr2 = this.way.latLongs[i3];
                    if (i4 < latLongArr2.length) {
                        this.coordinatesAbsolute[i3][i4] = MercatorProjection.getPixelAbsolute(latLongArr2[i4], this.upperLeft.mapSize);
                        i4++;
                    }
                }
                i3++;
            }
            this.way = null;
        }
        return this.coordinatesAbsolute;
    }

    public Point[][] getCoordinatesRelativeToOrigin() {
        if (this.coordinatesRelativeToTile == null) {
            Point origin = this.upperLeft.getOrigin();
            this.coordinatesRelativeToTile = new Point[getCoordinatesAbsolute().length][];
            int i3 = 0;
            while (true) {
                Point[][] pointArr = this.coordinatesRelativeToTile;
                if (i3 >= pointArr.length) {
                    break;
                }
                pointArr[i3] = new Point[this.coordinatesAbsolute[i3].length];
                int i4 = 0;
                while (true) {
                    Point[] pointArr2 = this.coordinatesRelativeToTile[i3];
                    if (i4 < pointArr2.length) {
                        pointArr2[i4] = this.coordinatesAbsolute[i3][i4].offset(-origin.f4076x, -origin.f4077y);
                        i4++;
                    }
                }
                i3++;
            }
        }
        return this.coordinatesRelativeToTile;
    }

    public byte getLayer() {
        return this.layer;
    }

    public Tile getLowerRight() {
        return this.lowerRight;
    }

    @Override // org.mapsforge.map.layer.renderer.ShapeContainer
    public ShapeType getShapeType() {
        return ShapeType.POLYLINE;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public Tile getUpperLeft() {
        return this.upperLeft;
    }

    public boolean isClosedWay() {
        return this.isClosedWay;
    }
}
