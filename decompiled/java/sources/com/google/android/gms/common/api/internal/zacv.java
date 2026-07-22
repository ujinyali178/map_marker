package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /root/release/classes.dex */
final class zacv extends TaskApiCall {
    final /* synthetic */ TaskApiCall.Builder zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zacv(TaskApiCall.Builder builder, Feature[] featureArr, boolean z3, int i3) {
        super(featureArr, z3, i3);
        this.zaa = builder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        RemoteCall remoteCall;
        remoteCall = this.zaa.zaa;
        remoteCall.accept(anyClient, taskCompletionSource);
    }
}
