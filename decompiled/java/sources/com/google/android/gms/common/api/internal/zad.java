package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /root/release/classes.dex */
abstract class zad extends zac {
    protected final TaskCompletionSource zaa;

    public zad(int i3, TaskCompletionSource taskCompletionSource) {
        super(i3);
        this.zaa = taskCompletionSource;
    }

    protected abstract void zac(zabq zabqVar);

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        this.zaa.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) {
        try {
            zac(zabqVar);
        } catch (DeadObjectException e3) {
            zad(zai.zah(e3));
            throw e3;
        } catch (RemoteException e4) {
            zad(zai.zah(e4));
        } catch (RuntimeException e5) {
            this.zaa.trySetException(e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public void zag(zaad zaadVar, boolean z3) {
    }
}
