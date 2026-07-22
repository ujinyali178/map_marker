package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
final class zacz extends com.google.android.gms.internal.base.zau {
    final /* synthetic */ zada zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacz(zada zadaVar, Looper looper) {
        super(looper);
        this.zaa = zadaVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        zada zadaVar;
        Status zaa;
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i3);
            return;
        }
        PendingResult pendingResult = (PendingResult) message.obj;
        obj = this.zaa.zae;
        synchronized (obj) {
            zadaVar = this.zaa.zab;
            zada zadaVar2 = (zada) Preconditions.checkNotNull(zadaVar);
            if (pendingResult == null) {
                zaa = new Status(13, "Transform returned null");
            } else if (pendingResult instanceof zacp) {
                zaa = ((zacp) pendingResult).zaa();
            } else {
                zadaVar2.zai(pendingResult);
            }
            zadaVar2.zaj(zaa);
        }
    }
}
