package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* loaded from: /root/release/classes.dex */
final class zab implements PendingResult.StatusListener {
    final /* synthetic */ Batch zaa;

    zab(Batch batch) {
        this.zaa = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Object obj;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        PendingResult[] pendingResultArr;
        obj = this.zaa.zai;
        synchronized (obj) {
            if (this.zaa.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                this.zaa.zag = true;
            } else if (!status.isSuccess()) {
                this.zaa.zaf = true;
            }
            Batch batch = this.zaa;
            i3 = batch.zae;
            batch.zae = i3 - 1;
            Batch batch2 = this.zaa;
            i4 = batch2.zae;
            if (i4 == 0) {
                z3 = batch2.zag;
                if (z3) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    z4 = batch2.zaf;
                    Status status2 = z4 ? new Status(13) : Status.RESULT_SUCCESS;
                    Batch batch3 = this.zaa;
                    pendingResultArr = batch3.zah;
                    batch3.setResult(new BatchResult(status2, pendingResultArr));
                }
            }
        }
    }
}
