package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* loaded from: /root/release/classes.dex */
final class zaz implements zabz {
    final /* synthetic */ zaaa zaa;

    /* synthetic */ zaz(zaaa zaaaVar, zay zayVar) {
        this.zaa = zaaaVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.zaa.zam;
        lock.lock();
        try {
            this.zaa.zak = connectionResult;
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
            this.zaa.zak = ConnectionResult.RESULT_SUCCESS;
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
        zabi zabiVar;
        lock = this.zaa.zam;
        lock.lock();
        try {
            zaaa zaaaVar = this.zaa;
            z4 = zaaaVar.zal;
            if (z4) {
                zaaaVar.zal = false;
                zaaa.zan(this.zaa, i3, z3);
            } else {
                zaaaVar.zal = true;
                zabiVar = this.zaa.zad;
                zabiVar.onConnectionSuspended(i3);
            }
        } finally {
            lock2 = this.zaa.zam;
            lock2.unlock();
        }
    }
}
