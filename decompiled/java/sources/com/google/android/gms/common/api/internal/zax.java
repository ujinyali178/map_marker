package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* loaded from: /root/release/classes.dex */
final class zax implements zabz {
    final /* synthetic */ zaaa zaa;

    /* synthetic */ zax(zaaa zaaaVar, zaw zawVar) {
        this.zaa = zaaaVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.zaa.zam;
        lock.lock();
        try {
            this.zaa.zaj = connectionResult;
            zaaa.zap(this.zaa);
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.zaa.zam;
        lock.lock();
        try {
            zaaa.zao(this.zaa, bundle);
            this.zaa.zaj = ConnectionResult.RESULT_SUCCESS;
            zaaa.zap(this.zaa);
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i3, boolean z3) {
        Lock lock;
        Lock lock2;
        boolean z4;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        zabi zabiVar;
        lock = this.zaa.zam;
        lock.lock();
        try {
            zaaa zaaaVar = this.zaa;
            z4 = zaaaVar.zal;
            if (!z4) {
                connectionResult = zaaaVar.zak;
                if (connectionResult != null) {
                    connectionResult2 = zaaaVar.zak;
                    if (connectionResult2.isSuccess()) {
                        this.zaa.zal = true;
                        zabiVar = this.zaa.zae;
                        zabiVar.onConnectionSuspended(i3);
                    }
                }
            }
            this.zaa.zal = false;
            zaaa.zan(this.zaa, i3, z3);
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }
}
