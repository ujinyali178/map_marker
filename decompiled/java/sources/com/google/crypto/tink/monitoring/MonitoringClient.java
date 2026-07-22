package com.google.crypto.tink.monitoring;

/* loaded from: /root/release/classes.dex */
public interface MonitoringClient {

    public interface Logger {
        void log(int i3, long j3);

        void logFailure();
    }

    Logger createLogger(MonitoringKeysetInfo monitoringKeysetInfo, String str, String str2);
}
