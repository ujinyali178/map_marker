package org.mapsforge.map.reader;

import org.mapsforge.map.reader.header.SubFileParameter;

/* loaded from: /root/release/classes2.dex */
class IndexCacheEntryKey {
    private final int hashCodeValue = calculateHashCode();
    private final long indexBlockNumber;
    private final SubFileParameter subFileParameter;

    IndexCacheEntryKey(SubFileParameter subFileParameter, long j3) {
        this.subFileParameter = subFileParameter;
        this.indexBlockNumber = j3;
    }

    private int calculateHashCode() {
        SubFileParameter subFileParameter = this.subFileParameter;
        int hashCode = subFileParameter == null ? 0 : subFileParameter.hashCode();
        long j3 = this.indexBlockNumber;
        return ((217 + hashCode) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexCacheEntryKey)) {
            return false;
        }
        IndexCacheEntryKey indexCacheEntryKey = (IndexCacheEntryKey) obj;
        SubFileParameter subFileParameter = this.subFileParameter;
        if (subFileParameter != null || indexCacheEntryKey.subFileParameter == null) {
            return (subFileParameter == null || subFileParameter.equals(indexCacheEntryKey.subFileParameter)) && this.indexBlockNumber == indexCacheEntryKey.indexBlockNumber;
        }
        return false;
    }

    public int hashCode() {
        return this.hashCodeValue;
    }
}
