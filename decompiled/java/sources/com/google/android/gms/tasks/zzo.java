package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
final class zzo implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzp zzb;

    zzo(zzp zzpVar, Task task) {
        this.zzb = zzpVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.zzb.zzb;
            Task then = successContinuation.then(this.zza.getResult());
            if (then == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zza;
            then.addOnSuccessListener(executor, this.zzb);
            then.addOnFailureListener(executor, this.zzb);
            then.addOnCanceledListener(executor, this.zzb);
        } catch (RuntimeExecutionException e3) {
            if (e3.getCause() instanceof Exception) {
                this.zzb.onFailure((Exception) e3.getCause());
            } else {
                this.zzb.onFailure(e3);
            }
        } catch (CancellationException unused) {
            this.zzb.onCanceled();
        } catch (Exception e4) {
            this.zzb.onFailure(e4);
        }
    }
}
