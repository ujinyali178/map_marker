package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public abstract class LogRequest {

    public static abstract class Builder {
        public abstract LogRequest build();

        public abstract Builder setClientInfo(ClientInfo clientInfo);

        public abstract Builder setLogEvents(List<LogEvent> list);

        abstract Builder setLogSource(Integer num);

        abstract Builder setLogSourceName(String str);

        public abstract Builder setQosTier(QosTier qosTier);

        public abstract Builder setRequestTimeMs(long j3);

        public abstract Builder setRequestUptimeMs(long j3);

        public Builder setSource(int i3) {
            return setLogSource(Integer.valueOf(i3));
        }

        public Builder setSource(String str) {
            return setLogSourceName(str);
        }
    }

    public static Builder builder() {
        return new AutoValue_LogRequest.Builder();
    }

    public abstract ClientInfo getClientInfo();

    @Encodable.Field(name = "logEvent")
    public abstract List<LogEvent> getLogEvents();

    public abstract Integer getLogSource();

    public abstract String getLogSourceName();

    public abstract QosTier getQosTier();

    public abstract long getRequestTimeMs();

    public abstract long getRequestUptimeMs();
}
