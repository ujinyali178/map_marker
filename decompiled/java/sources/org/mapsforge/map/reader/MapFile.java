package org.mapsforge.map.reader;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.model.Tile;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.core.util.Parameters;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.datastore.MapReadResult;
import org.mapsforge.map.datastore.PoiWayBundle;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.datastore.Way;
import org.mapsforge.map.reader.header.MapFileException;
import org.mapsforge.map.reader.header.MapFileHeader;
import org.mapsforge.map.reader.header.MapFileInfo;
import org.mapsforge.map.reader.header.SubFileParameter;

/* loaded from: /root/release/classes2.dex */
public class MapFile extends MapDataStore {
    private static final long BITMASK_INDEX_OFFSET = 549755813887L;
    private static final long BITMASK_INDEX_WATER = 549755813888L;
    private static final byte DEFAULT_START_ZOOM_LEVEL = 12;
    private static final int INDEX_CACHE_SIZE = 64;
    private static final String INVALID_FIRST_WAY_OFFSET = "invalid first way offset: ";
    private static final int POI_FEATURE_ELEVATION = 32;
    private static final int POI_FEATURE_HOUSE_NUMBER = 64;
    private static final int POI_FEATURE_NAME = 128;
    private static final int POI_LAYER_BITMASK = 240;
    private static final int POI_LAYER_SHIFT = 4;
    private static final int POI_NUMBER_OF_TAGS_BITMASK = 15;
    private static final byte SIGNATURE_LENGTH_BLOCK = 32;
    private static final byte SIGNATURE_LENGTH_POI = 32;
    private static final byte SIGNATURE_LENGTH_WAY = 32;
    private static final String TAG_KEY_ELE = "ele";
    private static final String TAG_KEY_HOUSE_NUMBER = "addr:housenumber";
    private static final String TAG_KEY_NAME = "name";
    private static final String TAG_KEY_REF = "ref";
    private static final int WAY_FEATURE_DATA_BLOCKS_BYTE = 8;
    private static final int WAY_FEATURE_DOUBLE_DELTA_ENCODING = 4;
    private static final int WAY_FEATURE_HOUSE_NUMBER = 64;
    private static final int WAY_FEATURE_LABEL_POSITION = 16;
    private static final int WAY_FEATURE_NAME = 128;
    private static final int WAY_FEATURE_REF = 32;
    private static final int WAY_LAYER_BITMASK = 240;
    private static final int WAY_LAYER_SHIFT = 4;
    private static final int WAY_NUMBER_OF_TAGS_BITMASK = 15;
    private final IndexCache databaseIndexCache;
    private final long fileSize;
    private final FileChannel inputChannel;
    private final MapFileHeader mapFileHeader;
    private final long timestamp;
    private byte zoomLevelMax;
    private byte zoomLevelMin;
    private static final Logger LOGGER = Logger.getLogger(MapFile.class.getName());
    public static final MapFile TEST_MAP_FILE = new MapFile();
    public static boolean wayFilterEnabled = true;
    public static int wayFilterDistance = 20;

    private enum Selector {
        ALL,
        POIS,
        LABELS
    }

    private MapFile() {
        this.zoomLevelMin = (byte) 0;
        this.zoomLevelMax = Ascii.DEL;
        this.databaseIndexCache = null;
        this.fileSize = 0L;
        this.inputChannel = null;
        this.mapFileHeader = null;
        this.timestamp = System.currentTimeMillis();
    }

    public MapFile(File file) {
        this(file, (String) null);
    }

    public MapFile(File file, String str) {
        super(str);
        this.zoomLevelMin = (byte) 0;
        this.zoomLevelMax = Ascii.DEL;
        if (file == null) {
            throw new MapFileException("mapFile must not be null");
        }
        try {
            if (!file.exists()) {
                throw new MapFileException("file does not exist: " + file);
            }
            if (!file.isFile()) {
                throw new MapFileException("not a file: " + file);
            }
            if (!file.canRead()) {
                throw new MapFileException("cannot read file: " + file);
            }
            FileChannel channel = new FileInputStream(file).getChannel();
            this.inputChannel = channel;
            long size = channel.size();
            this.fileSize = size;
            ReadBuffer readBuffer = new ReadBuffer(channel);
            MapFileHeader mapFileHeader = new MapFileHeader();
            this.mapFileHeader = mapFileHeader;
            mapFileHeader.readHeader(readBuffer, size);
            this.databaseIndexCache = new IndexCache(channel, 64);
            this.timestamp = file.lastModified();
        } catch (Exception e3) {
            closeFileChannel();
            throw new MapFileException(e3.getMessage());
        }
    }

    public MapFile(FileInputStream fileInputStream, long j3, String str) {
        super(str);
        this.zoomLevelMin = (byte) 0;
        this.zoomLevelMax = Ascii.DEL;
        if (fileInputStream == null) {
            throw new MapFileException("mapFileInputStream must not be null");
        }
        try {
            FileChannel channel = fileInputStream.getChannel();
            this.inputChannel = channel;
            long size = channel.size();
            this.fileSize = size;
            ReadBuffer readBuffer = new ReadBuffer(channel);
            MapFileHeader mapFileHeader = new MapFileHeader();
            this.mapFileHeader = mapFileHeader;
            mapFileHeader.readHeader(readBuffer, size);
            this.databaseIndexCache = new IndexCache(channel, 64);
            this.timestamp = j3;
        } catch (Exception e3) {
            closeFileChannel();
            throw new MapFileException(e3.getMessage());
        }
    }

    public MapFile(String str) {
        this(str, (String) null);
    }

    public MapFile(String str, String str2) {
        this(new File(str), str2);
    }

    public MapFile(FileChannel fileChannel, long j3, String str) {
        super(str);
        this.zoomLevelMin = (byte) 0;
        this.zoomLevelMax = Ascii.DEL;
        if (fileChannel == null) {
            throw new MapFileException("mapFileChannel must not be null");
        }
        try {
            this.inputChannel = fileChannel;
            long size = fileChannel.size();
            this.fileSize = size;
            ReadBuffer readBuffer = new ReadBuffer(fileChannel);
            MapFileHeader mapFileHeader = new MapFileHeader();
            this.mapFileHeader = mapFileHeader;
            mapFileHeader.readHeader(readBuffer, size);
            this.databaseIndexCache = new IndexCache(fileChannel, 64);
            this.timestamp = j3;
        } catch (Exception e3) {
            closeFileChannel();
            throw new MapFileException(e3.getMessage());
        }
    }

    private void closeFileChannel() {
        try {
            IndexCache indexCache = this.databaseIndexCache;
            if (indexCache != null) {
                indexCache.destroy();
            }
            FileChannel fileChannel = this.inputChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Exception e3) {
            LOGGER.log(Level.SEVERE, e3.getMessage(), (Throwable) e3);
        }
    }

    private void decodeWayNodesDoubleDelta(LatLong[] latLongArr, double d3, double d4, ReadBuffer readBuffer) {
        double microdegreesToDegrees = d3 + LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
        double microdegreesToDegrees2 = d4 + LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
        latLongArr[0] = new LatLong(microdegreesToDegrees, microdegreesToDegrees2);
        double d5 = 0.0d;
        double d6 = 0.0d;
        for (int i3 = 1; i3 < latLongArr.length; i3++) {
            d5 += LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
            d6 += LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
            microdegreesToDegrees += d5;
            microdegreesToDegrees2 += d6;
            if (microdegreesToDegrees2 < -180.0d && (-180.0d) - microdegreesToDegrees2 < 0.001d) {
                microdegreesToDegrees2 = -180.0d;
            } else if (microdegreesToDegrees2 > 180.0d && microdegreesToDegrees2 - 180.0d < 0.001d) {
                microdegreesToDegrees2 = 180.0d;
            }
            latLongArr[i3] = new LatLong(microdegreesToDegrees, microdegreesToDegrees2);
        }
    }

    private void decodeWayNodesSingleDelta(LatLong[] latLongArr, double d3, double d4, ReadBuffer readBuffer) {
        double microdegreesToDegrees = d3 + LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
        double microdegreesToDegrees2 = d4 + LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
        latLongArr[0] = new LatLong(microdegreesToDegrees, microdegreesToDegrees2);
        for (int i3 = 1; i3 < latLongArr.length; i3++) {
            microdegreesToDegrees += LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
            microdegreesToDegrees2 += LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
            if (microdegreesToDegrees2 < -180.0d && (-180.0d) - microdegreesToDegrees2 < 0.001d) {
                microdegreesToDegrees2 = -180.0d;
            } else if (microdegreesToDegrees2 > 180.0d && microdegreesToDegrees2 - 180.0d < 0.001d) {
                microdegreesToDegrees2 = 180.0d;
            }
            latLongArr[i3] = new LatLong(microdegreesToDegrees, microdegreesToDegrees2);
        }
    }

    private PoiWayBundle processBlock(QueryParameters queryParameters, SubFileParameter subFileParameter, BoundingBox boundingBox, double d3, double d4, Selector selector, ReadBuffer readBuffer) {
        List<PointOfInterest> list;
        List<Way> processWays;
        Logger logger;
        StringBuilder sb;
        String sb2;
        if (!processBlockSignature(readBuffer)) {
            return null;
        }
        int[] iArr = readZoomTable(subFileParameter, readBuffer)[queryParameters.queryZoomLevel - subFileParameter.zoomLevelMin];
        int i3 = iArr[0];
        int i4 = iArr[1];
        int readUnsignedInt = readBuffer.readUnsignedInt();
        if (readUnsignedInt < 0) {
            logger = LOGGER;
            sb2 = INVALID_FIRST_WAY_OFFSET + readUnsignedInt;
        } else {
            int bufferPosition = readUnsignedInt + readBuffer.getBufferPosition();
            if (bufferPosition <= readBuffer.getBufferSize()) {
                boolean z3 = queryParameters.queryZoomLevel > subFileParameter.baseZoomLevel;
                List<PointOfInterest> processPOIs = processPOIs(d3, d4, i3, boundingBox, z3, readBuffer);
                if (processPOIs == null) {
                    return null;
                }
                if (Selector.POIS == selector) {
                    processWays = Collections.emptyList();
                    list = processPOIs;
                } else if (readBuffer.getBufferPosition() > bufferPosition) {
                    logger = LOGGER;
                    sb = new StringBuilder();
                    sb.append("invalid buffer position: ");
                    sb.append(readBuffer.getBufferPosition());
                } else {
                    readBuffer.setBufferPosition(bufferPosition);
                    list = processPOIs;
                    processWays = processWays(queryParameters, i4, boundingBox, z3, d3, d4, selector, readBuffer);
                    if (processWays == null) {
                        return null;
                    }
                }
                return new PoiWayBundle(list, processWays);
            }
            logger = LOGGER;
            sb = new StringBuilder();
            sb.append(INVALID_FIRST_WAY_OFFSET);
            sb.append(bufferPosition);
            sb2 = sb.toString();
        }
        logger.warning(sb2);
        return null;
    }

    private boolean processBlockSignature(ReadBuffer readBuffer) {
        if (!this.mapFileHeader.getMapFileInfo().debugFile) {
            return true;
        }
        String readUTF8EncodedString = readBuffer.readUTF8EncodedString(32);
        if (readUTF8EncodedString.startsWith("###TileStart")) {
            return true;
        }
        LOGGER.warning("invalid block signature: " + readUTF8EncodedString);
        return false;
    }

    private MapReadResult processBlocks(QueryParameters queryParameters, SubFileParameter subFileParameter, BoundingBox boundingBox, Selector selector) {
        MapReadResult mapReadResult = new MapReadResult();
        boolean z3 = true;
        for (long j3 = queryParameters.fromBlockY; j3 <= queryParameters.toBlockY; j3++) {
            long j4 = queryParameters.fromBlockX;
            while (j4 <= queryParameters.toBlockX) {
                long j5 = (subFileParameter.blocksWidth * j3) + j4;
                long indexEntry = this.databaseIndexCache.getIndexEntry(subFileParameter, j5);
                if (z3) {
                    z3 &= (BITMASK_INDEX_WATER & indexEntry) != 0;
                }
                boolean z4 = z3;
                long j6 = indexEntry & BITMASK_INDEX_OFFSET;
                if (j6 >= 1) {
                    long j7 = subFileParameter.subFileSize;
                    if (j6 <= j7) {
                        long j8 = j5 + 1;
                        if (j8 != subFileParameter.numberOfBlocks) {
                            j7 = this.databaseIndexCache.getIndexEntry(subFileParameter, j8) & BITMASK_INDEX_OFFSET;
                            if (j7 > subFileParameter.subFileSize) {
                                Logger logger = LOGGER;
                                logger.warning("invalid next block pointer: " + j7);
                                logger.warning("sub-file size: " + subFileParameter.subFileSize);
                                return null;
                            }
                        }
                        int i3 = (int) (j7 - j6);
                        if (i3 < 0) {
                            LOGGER.warning("current block size must not be negative: " + i3);
                            return null;
                        }
                        if (i3 != 0) {
                            if (i3 > Parameters.MAXIMUM_BUFFER_SIZE) {
                                LOGGER.warning("current block size too large: " + i3);
                            } else {
                                if (i3 + j6 > this.fileSize) {
                                    LOGGER.warning("current block largher than file size: " + i3);
                                    return null;
                                }
                                ReadBuffer readBuffer = new ReadBuffer(this.inputChannel);
                                if (!readBuffer.readFromFile(subFileParameter.startAddress + j6, i3)) {
                                    LOGGER.warning("reading current block has failed: " + i3);
                                    return null;
                                }
                                try {
                                    PoiWayBundle processBlock = processBlock(queryParameters, subFileParameter, boundingBox, MercatorProjection.tileYToLatitude(subFileParameter.boundaryTileTop + j3, subFileParameter.baseZoomLevel), MercatorProjection.tileXToLongitude(subFileParameter.boundaryTileLeft + j4, subFileParameter.baseZoomLevel), selector, readBuffer);
                                    if (processBlock != null) {
                                        mapReadResult.add(processBlock);
                                    }
                                } catch (ArrayIndexOutOfBoundsException e3) {
                                    LOGGER.log(Level.SEVERE, e3.getMessage(), (Throwable) e3);
                                }
                            }
                        }
                        j4++;
                        z3 = z4;
                    }
                }
                Logger logger2 = LOGGER;
                logger2.warning("invalid current block pointer: " + j6);
                logger2.warning("subFileSize: " + subFileParameter.subFileSize);
                return null;
            }
        }
        return mapReadResult;
    }

    private List<PointOfInterest> processPOIs(double d3, double d4, int i3, BoundingBox boundingBox, boolean z3, ReadBuffer readBuffer) {
        ArrayList arrayList = new ArrayList();
        Tag[] tagArr = this.mapFileHeader.getMapFileInfo().poiTags;
        for (int i4 = i3; i4 != 0; i4--) {
            if (this.mapFileHeader.getMapFileInfo().debugFile) {
                String readUTF8EncodedString = readBuffer.readUTF8EncodedString(32);
                if (!readUTF8EncodedString.startsWith("***POIStart")) {
                    LOGGER.warning("invalid POI signature: " + readUTF8EncodedString);
                    return null;
                }
            }
            double microdegreesToDegrees = d3 + LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
            double microdegreesToDegrees2 = d4 + LatLongUtils.microdegreesToDegrees(readBuffer.readSignedInt());
            byte readByte = readBuffer.readByte();
            byte b4 = (byte) ((readByte & 240) >>> 4);
            List<Tag> readTags = readBuffer.readTags(tagArr, (byte) (readByte & Ascii.SI));
            if (readTags == null) {
                return null;
            }
            byte readByte2 = readBuffer.readByte();
            boolean z4 = (readByte2 & UnsignedBytes.MAX_POWER_OF_TWO) != 0;
            boolean z5 = (readByte2 & SignedBytes.MAX_POWER_OF_TWO) != 0;
            boolean z6 = (readByte2 & 32) != 0;
            if (z4) {
                readTags.add(new Tag(TAG_KEY_NAME, extractLocalized(readBuffer.readUTF8EncodedString())));
            }
            if (z5) {
                readTags.add(new Tag(TAG_KEY_HOUSE_NUMBER, readBuffer.readUTF8EncodedString()));
            }
            if (z6) {
                readTags.add(new Tag(TAG_KEY_ELE, Integer.toString(readBuffer.readSignedInt())));
            }
            LatLong latLong = new LatLong(microdegreesToDegrees, microdegreesToDegrees2);
            if (!z3 || boundingBox.contains(latLong)) {
                arrayList.add(new PointOfInterest(b4, readTags, latLong));
            }
        }
        return arrayList;
    }

    private LatLong[][] processWayDataBlock(double d3, double d4, boolean z3, ReadBuffer readBuffer) {
        int readUnsignedInt = readBuffer.readUnsignedInt();
        if (readUnsignedInt < 1 || readUnsignedInt > 32767) {
            LOGGER.warning("invalid number of way coordinate blocks: " + readUnsignedInt);
            return null;
        }
        LatLong[][] latLongArr = new LatLong[readUnsignedInt][];
        for (int i3 = 0; i3 < readUnsignedInt; i3++) {
            int readUnsignedInt2 = readBuffer.readUnsignedInt();
            if (readUnsignedInt2 < 2 || readUnsignedInt2 > 32767) {
                LOGGER.warning("invalid number of way nodes: " + readUnsignedInt2);
                return null;
            }
            LatLong[] latLongArr2 = new LatLong[readUnsignedInt2];
            if (z3) {
                decodeWayNodesDoubleDelta(latLongArr2, d3, d4, readBuffer);
            } else {
                decodeWayNodesSingleDelta(latLongArr2, d3, d4, readBuffer);
            }
            latLongArr[i3] = latLongArr2;
        }
        return latLongArr;
    }

    private List<Way> processWays(QueryParameters queryParameters, int i3, BoundingBox boundingBox, boolean z3, double d3, double d4, Selector selector, ReadBuffer readBuffer) {
        ArrayList arrayList = new ArrayList();
        Tag[] tagArr = this.mapFileHeader.getMapFileInfo().wayTags;
        BoundingBox extendMeters = boundingBox.extendMeters(wayFilterDistance);
        for (int i4 = i3; i4 != 0; i4--) {
            if (this.mapFileHeader.getMapFileInfo().debugFile) {
                String readUTF8EncodedString = readBuffer.readUTF8EncodedString(32);
                if (!readUTF8EncodedString.startsWith("---WayStart")) {
                    LOGGER.warning("invalid way signature: " + readUTF8EncodedString);
                    return null;
                }
            }
            int readUnsignedInt = readBuffer.readUnsignedInt();
            if (readUnsignedInt < 0) {
                LOGGER.warning("invalid way data size: " + readUnsignedInt);
                return null;
            }
            if (!queryParameters.useTileBitmask) {
                readBuffer.skipBytes(2);
            } else if ((readBuffer.readShort() & queryParameters.queryTileBitmask) == 0) {
                readBuffer.skipBytes(readUnsignedInt - 2);
            }
            byte readByte = readBuffer.readByte();
            byte b4 = (byte) ((readByte & 240) >>> 4);
            List<Tag> readTags = readBuffer.readTags(tagArr, (byte) (readByte & Ascii.SI));
            if (readTags == null) {
                return null;
            }
            byte readByte2 = readBuffer.readByte();
            boolean z4 = (readByte2 & UnsignedBytes.MAX_POWER_OF_TWO) != 0;
            boolean z5 = (readByte2 & SignedBytes.MAX_POWER_OF_TWO) != 0;
            boolean z6 = (readByte2 & 32) != 0;
            boolean z7 = (readByte2 & Ascii.DLE) != 0;
            boolean z8 = (readByte2 & 8) != 0;
            boolean z9 = (readByte2 & 4) != 0;
            if (z4) {
                readTags.add(new Tag(TAG_KEY_NAME, extractLocalized(readBuffer.readUTF8EncodedString())));
            }
            if (z5) {
                readTags.add(new Tag(TAG_KEY_HOUSE_NUMBER, readBuffer.readUTF8EncodedString()));
            }
            if (z6) {
                readTags.add(new Tag(TAG_KEY_REF, readBuffer.readUTF8EncodedString()));
            }
            int[] readOptionalLabelPosition = z7 ? readOptionalLabelPosition(readBuffer) : null;
            int readOptionalWayDataBlocksByte = readOptionalWayDataBlocksByte(z8, readBuffer);
            if (readOptionalWayDataBlocksByte < 1) {
                LOGGER.warning("invalid number of way data blocks: " + readOptionalWayDataBlocksByte);
                return null;
            }
            int i5 = 0;
            while (i5 < readOptionalWayDataBlocksByte) {
                int i6 = readOptionalWayDataBlocksByte;
                int i7 = i5;
                List<Tag> list = readTags;
                LatLong[][] processWayDataBlock = processWayDataBlock(d3, d4, z9, readBuffer);
                if (processWayDataBlock != null && (!z3 || !wayFilterEnabled || extendMeters.intersectsArea(processWayDataBlock))) {
                    if (Selector.ALL == selector || z4 || z5 || z6 || wayAsLabelTagFilter(list)) {
                        arrayList.add(new Way(b4, list, processWayDataBlock, readOptionalLabelPosition != null ? new LatLong(processWayDataBlock[0][0].latitude + LatLongUtils.microdegreesToDegrees(readOptionalLabelPosition[1]), processWayDataBlock[0][0].longitude + LatLongUtils.microdegreesToDegrees(readOptionalLabelPosition[0])) : null));
                    }
                }
                i5 = i7 + 1;
                readTags = list;
                readOptionalWayDataBlocksByte = i6;
            }
        }
        return arrayList;
    }

    private MapReadResult readMapData(Tile tile, Tile tile2, Selector selector) {
        if (tile.tileX > tile2.tileX || tile.tileY > tile2.tileY) {
            new IllegalArgumentException("upperLeft tile must be above and left of lowerRight tile");
        }
        try {
            QueryParameters queryParameters = new QueryParameters();
            byte queryZoomLevel = this.mapFileHeader.getQueryZoomLevel(tile.zoomLevel);
            queryParameters.queryZoomLevel = queryZoomLevel;
            SubFileParameter subFileParameter = this.mapFileHeader.getSubFileParameter(queryZoomLevel);
            if (subFileParameter != null) {
                queryParameters.calculateBaseTiles(tile, tile2, subFileParameter);
                queryParameters.calculateBlocks(subFileParameter);
                return processBlocks(queryParameters, subFileParameter, Tile.getBoundingBox(tile, tile2), selector);
            }
            LOGGER.warning("no sub-file for zoom level: " + queryParameters.queryZoomLevel);
            return null;
        } catch (IOException e3) {
            LOGGER.log(Level.SEVERE, e3.getMessage(), (Throwable) e3);
            return null;
        }
    }

    private int[] readOptionalLabelPosition(ReadBuffer readBuffer) {
        return new int[]{readBuffer.readSignedInt(), readBuffer.readSignedInt()};
    }

    private int readOptionalWayDataBlocksByte(boolean z3, ReadBuffer readBuffer) {
        if (z3) {
            return readBuffer.readUnsignedInt();
        }
        return 1;
    }

    private int[][] readZoomTable(SubFileParameter subFileParameter, ReadBuffer readBuffer) {
        int i3 = (subFileParameter.zoomLevelMax - subFileParameter.zoomLevelMin) + 1;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i3, 2);
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            i4 += readBuffer.readUnsignedInt();
            i5 += readBuffer.readUnsignedInt();
            int[] iArr2 = iArr[i6];
            iArr2[0] = i4;
            iArr2[1] = i5;
        }
        return iArr;
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public BoundingBox boundingBox() {
        return getMapFileInfo().boundingBox;
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public void close() {
        closeFileChannel();
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public long getDataTimestamp(Tile tile) {
        return this.timestamp;
    }

    public MapFileHeader getMapFileHeader() {
        return this.mapFileHeader;
    }

    public MapFileInfo getMapFileInfo() {
        return this.mapFileHeader.getMapFileInfo();
    }

    public String[] getMapLanguages() {
        String str = getMapFileInfo().languagesPreference;
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        return str.split(",");
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public MapReadResult readLabels(Tile tile) {
        return readMapData(tile, tile, Selector.LABELS);
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public MapReadResult readLabels(Tile tile, Tile tile2) {
        return readMapData(tile, tile2, Selector.LABELS);
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public MapReadResult readMapData(Tile tile) {
        return readMapData(tile, tile, Selector.ALL);
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public MapReadResult readMapData(Tile tile, Tile tile2) {
        return readMapData(tile, tile2, Selector.ALL);
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public MapReadResult readPoiData(Tile tile) {
        return readMapData(tile, tile, Selector.POIS);
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public MapReadResult readPoiData(Tile tile, Tile tile2) {
        return readMapData(tile, tile2, Selector.POIS);
    }

    public void restrictToZoomRange(byte b4, byte b5) {
        this.zoomLevelMax = b5;
        this.zoomLevelMin = b4;
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public LatLong startPosition() {
        return getMapFileInfo().startPosition != null ? getMapFileInfo().startPosition : getMapFileInfo().boundingBox.getCenterPoint();
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public Byte startZoomLevel() {
        if (getMapFileInfo().startZoomLevel != null) {
            return getMapFileInfo().startZoomLevel;
        }
        return (byte) 12;
    }

    @Override // org.mapsforge.map.datastore.MapDataStore
    public boolean supportsTile(Tile tile) {
        byte b4;
        return tile.getBoundingBox().intersects(getMapFileInfo().boundingBox) && (b4 = tile.zoomLevel) >= this.zoomLevelMin && b4 <= this.zoomLevelMax;
    }
}
