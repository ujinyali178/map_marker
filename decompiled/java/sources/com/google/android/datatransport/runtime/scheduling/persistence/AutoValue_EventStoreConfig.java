package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

/* loaded from: /root/release/classes.dex */
final class AutoValue_EventStoreConfig extends EventStoreConfig {
    private final int criticalSectionEnterTimeoutMs;
    private final long eventCleanUpAge;
    private final int loadBatchSize;
    private final int maxBlobByteSizePerRow;
    private final long maxStorageSizeInBytes;

    static final class Builder extends EventStoreConfig.Builder {
        private Integer criticalSectionEnterTimeoutMs;
        private Long eventCleanUpAge;
        private Integer loadBatchSize;
        private Integer maxBlobByteSizePerRow;
        private Long maxStorageSizeInBytes;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig build() {
            String str = "";
            if (this.maxStorageSizeInBytes == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.loadBatchSize == null) {
                str = str + " loadBatchSize";
            }
            if (this.criticalSectionEnterTimeoutMs == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.eventCleanUpAge == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.maxBlobByteSizePerRow == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.maxStorageSizeInBytes.longValue(), this.loadBatchSize.intValue(), this.criticalSectionEnterTimeoutMs.intValue(), this.eventCleanUpAge.longValue(), this.maxBlobByteSizePerRow.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder setCriticalSectionEnterTimeoutMs(int i3) {
            this.criticalSectionEnterTimeoutMs = Integer.valueOf(i3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder setEventCleanUpAge(long j3) {
            this.eventCleanUpAge = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder setLoadBatchSize(int i3) {
            this.loadBatchSize = Integer.valueOf(i3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder setMaxBlobByteSizePerRow(int i3) {
            this.maxBlobByteSizePerRow = Integer.valueOf(i3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder setMaxStorageSizeInBytes(long j3) {
            this.maxStorageSizeInBytes = Long.valueOf(j3);
            return this;
        }
    }

    private AutoValue_EventStoreConfig(long j3, int i3, int i4, long j4, int i5) {
        this.maxStorageSizeInBytes = j3;
        this.loadBatchSize = i3;
        this.criticalSectionEnterTimeoutMs = i4;
        this.eventCleanUpAge = j4;
        this.maxBlobByteSizePerRow = i5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        return this.maxStorageSizeInBytes == eventStoreConfig.getMaxStorageSizeInBytes() && this.loadBatchSize == eventStoreConfig.getLoadBatchSize() && this.criticalSectionEnterTimeoutMs == eventStoreConfig.getCriticalSectionEnterTimeoutMs() && this.eventCleanUpAge == eventStoreConfig.getEventCleanUpAge() && this.maxBlobByteSizePerRow == eventStoreConfig.getMaxBlobByteSizePerRow();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int getCriticalSectionEnterTimeoutMs() {
        return this.criticalSectionEnterTimeoutMs;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long getEventCleanUpAge() {
        return this.eventCleanUpAge;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int getLoadBatchSize() {
        return this.loadBatchSize;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int getMaxBlobByteSizePerRow() {
        return this.maxBlobByteSizePerRow;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long getMaxStorageSizeInBytes() {
        return this.maxStorageSizeInBytes;
    }

    public int hashCode() {
        long j3 = this.maxStorageSizeInBytes;
        int i3 = (((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003;
        long j4 = this.eventCleanUpAge;
        return this.maxBlobByteSizePerRow ^ ((i3 ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.maxStorageSizeInBytes + ", loadBatchSize=" + this.loadBatchSize + ", criticalSectionEnterTimeoutMs=" + this.criticalSectionEnterTimeoutMs + ", eventCleanUpAge=" + this.eventCleanUpAge + ", maxBlobByteSizePerRow=" + this.maxBlobByteSizePerRow + "}";
    }
}
