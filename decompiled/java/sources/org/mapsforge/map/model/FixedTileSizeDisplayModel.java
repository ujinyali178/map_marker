package org.mapsforge.map.model;

/* loaded from: /root/release/classes2.dex */
public class FixedTileSizeDisplayModel extends DisplayModel {
    private final int tileSize;

    public FixedTileSizeDisplayModel(int i3) {
        this.tileSize = i3;
    }

    @Override // org.mapsforge.map.model.DisplayModel
    public int getTileSize() {
        return this.tileSize;
    }
}
