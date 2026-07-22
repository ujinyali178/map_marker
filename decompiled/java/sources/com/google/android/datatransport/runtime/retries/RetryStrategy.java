package com.google.android.datatransport.runtime.retries;

/* loaded from: /root/release/classes.dex */
public interface RetryStrategy<TInput, TResult> {
    TInput shouldRetry(TInput tinput, TResult tresult);
}
