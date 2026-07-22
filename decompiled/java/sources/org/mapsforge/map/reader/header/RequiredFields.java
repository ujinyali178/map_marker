package org.mapsforge.map.reader.header;

import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.map.reader.ReadBuffer;

/* loaded from: /root/release/classes2.dex */
final class RequiredFields {
    private static final String BINARY_OSM_MAGIC_BYTE = "mapsforge binary OSM";
    private static final int HEADER_SIZE_MAX = 1000000;
    private static final int HEADER_SIZE_MIN = 70;
    private static final String MERCATOR = "Mercator";
    private static final int SUPPORTED_FILE_VERSION_MAX = 5;
    private static final int SUPPORTED_FILE_VERSION_MIN = 3;

    private RequiredFields() {
        throw new IllegalStateException();
    }

    static void readBoundingBox(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        try {
            mapFileInfoBuilder.boundingBox = new BoundingBox(LatLongUtils.microdegreesToDegrees(readBuffer.readInt()), LatLongUtils.microdegreesToDegrees(readBuffer.readInt()), LatLongUtils.microdegreesToDegrees(readBuffer.readInt()), LatLongUtils.microdegreesToDegrees(readBuffer.readInt()));
        } catch (IllegalArgumentException e3) {
            throw new MapFileException(e3.getMessage());
        }
    }

    static void readFileSize(ReadBuffer readBuffer, long j3, MapFileInfoBuilder mapFileInfoBuilder) {
        long readLong = readBuffer.readLong();
        if (readLong == j3) {
            mapFileInfoBuilder.fileSize = j3;
            return;
        }
        throw new MapFileException("invalid file size: " + readLong);
    }

    static void readFileVersion(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        int readInt = readBuffer.readInt();
        if (readInt >= 3 && readInt <= 5) {
            mapFileInfoBuilder.fileVersion = readInt;
            return;
        }
        throw new MapFileException("unsupported file version: " + readInt);
    }

    static void readMagicByte(ReadBuffer readBuffer) {
        if (!readBuffer.readFromFile(24)) {
            throw new MapFileException("reading magic byte has failed");
        }
        String readUTF8EncodedString = readBuffer.readUTF8EncodedString(20);
        if (BINARY_OSM_MAGIC_BYTE.equals(readUTF8EncodedString)) {
            return;
        }
        throw new MapFileException("invalid magic byte: " + readUTF8EncodedString);
    }

    static void readMapDate(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        long readLong = readBuffer.readLong();
        if (readLong >= 1200000000000L) {
            mapFileInfoBuilder.mapDate = readLong;
            return;
        }
        throw new MapFileException("invalid map date: " + readLong);
    }

    static void readPoiTags(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        int readShort = readBuffer.readShort();
        if (readShort < 0) {
            throw new MapFileException("invalid number of POI tags: " + readShort);
        }
        Tag[] tagArr = new Tag[readShort];
        for (int i3 = 0; i3 < readShort; i3++) {
            String readUTF8EncodedString = readBuffer.readUTF8EncodedString();
            if (readUTF8EncodedString == null) {
                throw new MapFileException("POI tag must not be null: " + i3);
            }
            tagArr[i3] = new Tag(readUTF8EncodedString);
        }
        mapFileInfoBuilder.poiTags = tagArr;
    }

    static void readProjectionName(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        String readUTF8EncodedString = readBuffer.readUTF8EncodedString();
        if (MERCATOR.equals(readUTF8EncodedString)) {
            mapFileInfoBuilder.projectionName = readUTF8EncodedString;
            return;
        }
        throw new MapFileException("unsupported projection: " + readUTF8EncodedString);
    }

    static void readRemainingHeader(ReadBuffer readBuffer) {
        int readInt = readBuffer.readInt();
        if (readInt < HEADER_SIZE_MIN || readInt > HEADER_SIZE_MAX) {
            throw new MapFileException("invalid remaining header size: " + readInt);
        }
        if (readBuffer.readFromFile(readInt)) {
            return;
        }
        throw new MapFileException("reading header data has failed: " + readInt);
    }

    static void readTilePixelSize(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        mapFileInfoBuilder.tilePixelSize = readBuffer.readShort();
    }

    static void readWayTags(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        int readShort = readBuffer.readShort();
        if (readShort < 0) {
            throw new MapFileException("invalid number of way tags: " + readShort);
        }
        Tag[] tagArr = new Tag[readShort];
        for (int i3 = 0; i3 < readShort; i3++) {
            String readUTF8EncodedString = readBuffer.readUTF8EncodedString();
            if (readUTF8EncodedString == null) {
                throw new MapFileException("way tag must not be null: " + i3);
            }
            tagArr[i3] = new Tag(readUTF8EncodedString);
        }
        mapFileInfoBuilder.wayTags = tagArr;
    }
}
