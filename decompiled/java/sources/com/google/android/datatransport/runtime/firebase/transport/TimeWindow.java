package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: /root/release/classes.dex */
public final class TimeWindow {
    private static final TimeWindow DEFAULT_INSTANCE = new Builder().build();
    private final long end_ms_;
    private final long start_ms_;

    public static final class Builder {
        private long start_ms_ = 0;
        private long end_ms_ = 0;

        Builder() {
        }

        public TimeWindow build() {
            return new TimeWindow(this.start_ms_, this.end_ms_);
        }

        public Builder setEndMs(long j3) {
            this.end_ms_ = j3;
            return this;
        }

        public Builder setStartMs(long j3) {
            this.start_ms_ = j3;
            return this;
        }
    }

    TimeWindow(long j3, long j4) {
        this.start_ms_ = j3;
        this.end_ms_ = j4;
    }

    public static TimeWindow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public long getEndMs() {
        return this.end_ms_;
    }

    public long getStartMs() {
        return this.start_ms_;
    }
}
