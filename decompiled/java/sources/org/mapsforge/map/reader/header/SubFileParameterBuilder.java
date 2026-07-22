package org.mapsforge.map.reader.header;

import org.mapsforge.core.model.BoundingBox;

/* loaded from: /root/release/classes2.dex */
class SubFileParameterBuilder {
    byte baseZoomLevel;
    BoundingBox boundingBox;
    long indexStartAddress;
    long startAddress;
    long subFileSize;
    byte zoomLevelMax;
    byte zoomLevelMin;

    SubFileParameterBuilder() {
    }

    SubFileParameter build() {
        return new SubFileParameter(this);
    }
}
