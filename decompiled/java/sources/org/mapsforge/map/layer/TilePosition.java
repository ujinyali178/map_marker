package org.mapsforge.map.layer;

import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public class TilePosition {
    public final Point point;
    public final Tile tile;

    public TilePosition(Tile tile, Point point) {
        this.tile = tile;
        this.point = point;
    }
}
