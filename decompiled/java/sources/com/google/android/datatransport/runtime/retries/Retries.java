package com.google.android.datatransport.runtime.retries;

/* loaded from: /root/release/classes.dex */
public final class Retries {
    private Retries() {
    }

    public static <TInput, TResult, TException extends Throwable> TResult retry(int i3, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) {
        TResult apply;
        if (i3 < 1) {
            return function.apply(tinput);
        }
        do {
            apply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, apply);
            if (tinput == null) {
                break;
            }
            i3--;
        } while (i3 >= 1);
        return apply;
    }
}
