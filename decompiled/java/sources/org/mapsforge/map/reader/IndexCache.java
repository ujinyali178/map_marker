package org.mapsforge.map.reader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import org.mapsforge.core.util.LRUCache;
import org.mapsforge.map.reader.header.SubFileParameter;

/* loaded from: /root/release/classes2.dex */
class IndexCache {
    private static final int INDEX_ENTRIES_PER_BLOCK = 128;
    private static final int SIZE_OF_INDEX_BLOCK = 640;
    private final FileChannel fileChannel;
    private final Map<IndexCacheEntryKey, byte[]> map;

    IndexCache(FileChannel fileChannel, int i3) {
        this.fileChannel = fileChannel;
        this.map = new LRUCache(i3);
    }

    void destroy() {
        this.map.clear();
    }

    long getIndexEntry(SubFileParameter subFileParameter, long j3) {
        if (j3 >= subFileParameter.numberOfBlocks) {
            throw new IOException("invalid block number: " + j3);
        }
        long j4 = j3 / 128;
        IndexCacheEntryKey indexCacheEntryKey = new IndexCacheEntryKey(subFileParameter, j4);
        byte[] bArr = this.map.get(indexCacheEntryKey);
        if (bArr == null) {
            long j5 = subFileParameter.indexStartAddress + (j4 * 640);
            int min = Math.min(SIZE_OF_INDEX_BLOCK, (int) (subFileParameter.indexEndAddress - j5));
            byte[] bArr2 = new byte[min];
            ByteBuffer wrap = ByteBuffer.wrap(bArr2, 0, min);
            synchronized (this.fileChannel) {
                this.fileChannel.position(j5);
                if (this.fileChannel.read(wrap) != min) {
                    throw new IOException("could not read index block with size: " + min);
                }
            }
            this.map.put(indexCacheEntryKey, bArr2);
            bArr = bArr2;
        }
        return Deserializer.getFiveBytesLong(bArr, (int) ((j3 % 128) * 5));
    }
}
