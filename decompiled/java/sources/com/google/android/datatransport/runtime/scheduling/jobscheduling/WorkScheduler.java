package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* loaded from: /root/release/classes.dex */
public interface WorkScheduler {
    void schedule(TransportContext transportContext, int i3);

    void schedule(TransportContext transportContext, int i3, boolean z3);
}
