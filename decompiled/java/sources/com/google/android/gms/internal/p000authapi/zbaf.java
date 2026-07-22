package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /root/release/classes.dex */
final class zbaf extends zbu {
    final /* synthetic */ TaskCompletionSource zba;

    zbaf(zbag zbagVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbv
    public final void zbb(Status status, SavePasswordResult savePasswordResult) {
        TaskUtil.setResultOrApiException(status, savePasswordResult, this.zba);
    }
}
