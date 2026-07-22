package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: /root/release/classes.dex */
public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    protected Response(T t3) {
        this.zza = t3;
    }

    protected T getResult() {
        return (T) this.zza;
    }

    public void setResult(T t3) {
        this.zza = t3;
    }
}
