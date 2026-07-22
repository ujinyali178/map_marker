package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* loaded from: /root/release/classes.dex */
public abstract class PersistedEvent {
    public static PersistedEvent create(long j3, TransportContext transportContext, EventInternal eventInternal) {
        return new AutoValue_PersistedEvent(j3, transportContext, eventInternal);
    }

    public abstract EventInternal getEvent();

    public abstract long getId();

    public abstract TransportContext getTransportContext();
}
