package com.google.android.gms.tasks;

/* loaded from: /root/release/classes.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult);
}
