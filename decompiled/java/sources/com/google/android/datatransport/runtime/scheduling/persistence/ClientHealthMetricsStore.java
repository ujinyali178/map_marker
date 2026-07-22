package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

/* loaded from: /root/release/classes.dex */
public interface ClientHealthMetricsStore {
    ClientMetrics loadClientMetrics();

    void recordLogEventDropped(long j3, LogEventDropped.Reason reason, String str);

    void resetClientMetrics();
}
