package com.google.android.datatransport;

/* loaded from: /root/release/classes.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i3, T t3) {
        return new AutoValue_Event(Integer.valueOf(i3), t3, Priority.DEFAULT);
    }

    public static <T> Event<T> ofData(T t3) {
        return new AutoValue_Event(null, t3, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i3, T t3) {
        return new AutoValue_Event(Integer.valueOf(i3), t3, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofTelemetry(T t3) {
        return new AutoValue_Event(null, t3, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i3, T t3) {
        return new AutoValue_Event(Integer.valueOf(i3), t3, Priority.HIGHEST);
    }

    public static <T> Event<T> ofUrgent(T t3) {
        return new AutoValue_Event(null, t3, Priority.HIGHEST);
    }

    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();
}
