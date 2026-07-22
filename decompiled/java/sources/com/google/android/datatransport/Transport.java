package com.google.android.datatransport;

/* loaded from: /root/release/classes.dex */
public interface Transport<T> {
    void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback);

    void send(Event<T> event);
}
