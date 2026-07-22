package com.google.android.gms.tasks;

/* loaded from: /root/release/classes.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task);
}
