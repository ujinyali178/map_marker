package com.google.android.gms.maps.model;

/* loaded from: /root/release/classes.dex */
public interface TileProvider {
    public static final Tile NO_TILE = new Tile(-1, -1, null);

    Tile getTile(int i3, int i4, int i5);
}
