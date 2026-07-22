package com.google.common.eventbus;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface SubscriberExceptionHandler {
    void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext);
}
