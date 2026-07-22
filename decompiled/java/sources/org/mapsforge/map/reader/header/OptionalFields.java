package org.mapsforge.map.reader.header;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.map.reader.ReadBuffer;

/* loaded from: /root/release/classes2.dex */
final class OptionalFields {
    private static final int HEADER_BITMASK_COMMENT = 8;
    private static final int HEADER_BITMASK_CREATED_BY = 4;
    private static final int HEADER_BITMASK_DEBUG = 128;
    private static final int HEADER_BITMASK_LANGUAGES_PREFERENCE = 16;
    private static final int HEADER_BITMASK_START_POSITION = 64;
    private static final int HEADER_BITMASK_START_ZOOM_LEVEL = 32;
    private static final int START_ZOOM_LEVEL_MAX = 22;
    String comment;
    String createdBy;
    final boolean hasComment;
    final boolean hasCreatedBy;
    final boolean hasLanguagesPreference;
    final boolean hasStartPosition;
    final boolean hasStartZoomLevel;
    final boolean isDebugFile;
    String languagesPreference;
    LatLong startPosition;
    Byte startZoomLevel;

    private OptionalFields(byte b4) {
        this.isDebugFile = (b4 & UnsignedBytes.MAX_POWER_OF_TWO) != 0;
        this.hasStartPosition = (b4 & SignedBytes.MAX_POWER_OF_TWO) != 0;
        this.hasStartZoomLevel = (b4 & 32) != 0;
        this.hasLanguagesPreference = (b4 & Ascii.DLE) != 0;
        this.hasComment = (b4 & 8) != 0;
        this.hasCreatedBy = (b4 & 4) != 0;
    }

    private void readLanguagesPreference(ReadBuffer readBuffer) {
        if (this.hasLanguagesPreference) {
            this.languagesPreference = readBuffer.readUTF8EncodedString();
        }
    }

    private void readMapStartPosition(ReadBuffer readBuffer) {
        if (this.hasStartPosition) {
            try {
                this.startPosition = new LatLong(LatLongUtils.microdegreesToDegrees(readBuffer.readInt()), LatLongUtils.microdegreesToDegrees(readBuffer.readInt()));
            } catch (IllegalArgumentException e3) {
                throw new MapFileException(e3.getMessage());
            }
        }
    }

    private void readMapStartZoomLevel(ReadBuffer readBuffer) {
        if (this.hasStartZoomLevel) {
            byte readByte = readBuffer.readByte();
            if (readByte >= 0 && readByte <= 22) {
                this.startZoomLevel = Byte.valueOf(readByte);
                return;
            }
            throw new MapFileException("invalid map start zoom level: " + ((int) readByte));
        }
    }

    private void readOptionalFields(ReadBuffer readBuffer) {
        readMapStartPosition(readBuffer);
        readMapStartZoomLevel(readBuffer);
        readLanguagesPreference(readBuffer);
        if (this.hasComment) {
            this.comment = readBuffer.readUTF8EncodedString();
        }
        if (this.hasCreatedBy) {
            this.createdBy = readBuffer.readUTF8EncodedString();
        }
    }

    static void readOptionalFields(ReadBuffer readBuffer, MapFileInfoBuilder mapFileInfoBuilder) {
        OptionalFields optionalFields = new OptionalFields(readBuffer.readByte());
        mapFileInfoBuilder.optionalFields = optionalFields;
        optionalFields.readOptionalFields(readBuffer);
    }
}
