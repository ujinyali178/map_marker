package org.mapsforge.map.reader.header;

import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
public class MapFileInfo {
    public final BoundingBox boundingBox;
    public final String comment;
    public final String createdBy;
    public final boolean debugFile;
    public final long fileSize;
    public final int fileVersion;
    public final String languagesPreference;
    public final long mapDate;
    public final byte numberOfSubFiles;
    public final Tag[] poiTags;
    public final String projectionName;
    public final LatLong startPosition;
    public final Byte startZoomLevel;
    public final int tilePixelSize;
    public final Tag[] wayTags;
    public final byte zoomLevelMax;
    public final byte zoomLevelMin;

    MapFileInfo(MapFileInfoBuilder mapFileInfoBuilder) {
        OptionalFields optionalFields = mapFileInfoBuilder.optionalFields;
        this.comment = optionalFields.comment;
        this.createdBy = optionalFields.createdBy;
        this.debugFile = optionalFields.isDebugFile;
        this.fileSize = mapFileInfoBuilder.fileSize;
        this.fileVersion = mapFileInfoBuilder.fileVersion;
        this.languagesPreference = optionalFields.languagesPreference;
        this.boundingBox = mapFileInfoBuilder.boundingBox;
        this.mapDate = mapFileInfoBuilder.mapDate;
        this.numberOfSubFiles = mapFileInfoBuilder.numberOfSubFiles;
        this.poiTags = mapFileInfoBuilder.poiTags;
        this.projectionName = mapFileInfoBuilder.projectionName;
        this.startPosition = optionalFields.startPosition;
        this.startZoomLevel = optionalFields.startZoomLevel;
        this.tilePixelSize = mapFileInfoBuilder.tilePixelSize;
        this.wayTags = mapFileInfoBuilder.wayTags;
        this.zoomLevelMax = mapFileInfoBuilder.zoomLevelMax;
        this.zoomLevelMin = mapFileInfoBuilder.zoomLevelMin;
    }
}
