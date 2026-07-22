package org.mapsforge.map.reader.header;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.mapsforge.map.reader.ReadBuffer;

/* loaded from: /root/release/classes2.dex */
public class MapFileHeader {
    private static final int BASE_ZOOM_LEVEL_MAX = 20;
    private static final int HEADER_SIZE_MIN = 70;
    private static final byte SIGNATURE_LENGTH_INDEX = 16;
    private static final char SPACE = ' ';
    private MapFileInfo mapFileInfo;
    private SubFileParameter[] subFileParameters;
    private byte zoomLevelMaximum;
    private byte zoomLevelMinimum;

    /* JADX WARN: Multi-variable type inference failed */
    private void readSubFileParameters(ReadBuffer readBuffer, long j3, MapFileInfoBuilder mapFileInfoBuilder) {
        int readByte = readBuffer.readByte();
        if (readByte < 1) {
            throw new MapFileException("invalid number of sub-files: " + readByte);
        }
        mapFileInfoBuilder.numberOfSubFiles = readByte;
        SubFileParameter[] subFileParameterArr = new SubFileParameter[readByte];
        this.zoomLevelMinimum = Ascii.DEL;
        this.zoomLevelMaximum = UnsignedBytes.MAX_POWER_OF_TWO;
        for (byte b4 = 0; b4 < readByte; b4 = (byte) (b4 + 1)) {
            SubFileParameterBuilder subFileParameterBuilder = new SubFileParameterBuilder();
            byte readByte2 = readBuffer.readByte();
            if (readByte2 < 0 || readByte2 > 20) {
                throw new MapFileException("invalid base zoom level: " + ((int) readByte2));
            }
            subFileParameterBuilder.baseZoomLevel = readByte2;
            byte readByte3 = readBuffer.readByte();
            if (readByte3 < 0 || readByte3 > 22) {
                throw new MapFileException("invalid minimum zoom level: " + ((int) readByte3));
            }
            subFileParameterBuilder.zoomLevelMin = readByte3;
            byte readByte4 = readBuffer.readByte();
            if (readByte4 < 0 || readByte4 > 22) {
                throw new MapFileException("invalid maximum zoom level: " + ((int) readByte4));
            }
            subFileParameterBuilder.zoomLevelMax = readByte4;
            if (readByte3 > readByte4) {
                throw new MapFileException("invalid zoom level range: " + ((int) readByte3) + SPACE + ((int) readByte4));
            }
            long readLong = readBuffer.readLong();
            if (readLong < 70 || readLong >= j3) {
                throw new MapFileException("invalid start address: " + readLong);
            }
            subFileParameterBuilder.startAddress = readLong;
            if (mapFileInfoBuilder.optionalFields.isDebugFile) {
                readLong += 16;
            }
            subFileParameterBuilder.indexStartAddress = readLong;
            long readLong2 = readBuffer.readLong();
            if (readLong2 < 1) {
                throw new MapFileException("invalid sub-file size: " + readLong2);
            }
            subFileParameterBuilder.subFileSize = readLong2;
            subFileParameterBuilder.boundingBox = mapFileInfoBuilder.boundingBox;
            SubFileParameter build = subFileParameterBuilder.build();
            subFileParameterArr[b4] = build;
            byte b5 = this.zoomLevelMinimum;
            byte b6 = build.zoomLevelMin;
            if (b5 > b6) {
                this.zoomLevelMinimum = b6;
                mapFileInfoBuilder.zoomLevelMin = b6;
            }
            byte b7 = this.zoomLevelMaximum;
            byte b8 = build.zoomLevelMax;
            if (b7 < b8) {
                this.zoomLevelMaximum = b8;
                mapFileInfoBuilder.zoomLevelMax = b8;
            }
        }
        this.subFileParameters = new SubFileParameter[this.zoomLevelMaximum + 1];
        for (int i3 = 0; i3 < readByte; i3++) {
            SubFileParameter subFileParameter = subFileParameterArr[i3];
            for (byte b9 = subFileParameter.zoomLevelMin; b9 <= subFileParameter.zoomLevelMax; b9 = (byte) (b9 + 1)) {
                this.subFileParameters[b9] = subFileParameter;
            }
        }
    }

    public MapFileInfo getMapFileInfo() {
        return this.mapFileInfo;
    }

    public byte getQueryZoomLevel(byte b4) {
        byte b5 = this.zoomLevelMaximum;
        if (b4 > b5) {
            return b5;
        }
        byte b6 = this.zoomLevelMinimum;
        return b4 < b6 ? b6 : b4;
    }

    public SubFileParameter getSubFileParameter(int i3) {
        return this.subFileParameters[i3];
    }

    public void readHeader(ReadBuffer readBuffer, long j3) {
        RequiredFields.readMagicByte(readBuffer);
        RequiredFields.readRemainingHeader(readBuffer);
        MapFileInfoBuilder mapFileInfoBuilder = new MapFileInfoBuilder();
        RequiredFields.readFileVersion(readBuffer, mapFileInfoBuilder);
        RequiredFields.readFileSize(readBuffer, j3, mapFileInfoBuilder);
        RequiredFields.readMapDate(readBuffer, mapFileInfoBuilder);
        RequiredFields.readBoundingBox(readBuffer, mapFileInfoBuilder);
        RequiredFields.readTilePixelSize(readBuffer, mapFileInfoBuilder);
        RequiredFields.readProjectionName(readBuffer, mapFileInfoBuilder);
        OptionalFields.readOptionalFields(readBuffer, mapFileInfoBuilder);
        RequiredFields.readPoiTags(readBuffer, mapFileInfoBuilder);
        RequiredFields.readWayTags(readBuffer, mapFileInfoBuilder);
        readSubFileParameters(readBuffer, j3, mapFileInfoBuilder);
        this.mapFileInfo = mapFileInfoBuilder.build();
    }
}
