package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public final class IndoorLevel {
    private final com.google.android.gms.internal.maps.zzx zza;

    public IndoorLevel(com.google.android.gms.internal.maps.zzx zzxVar) {
        this.zza = (com.google.android.gms.internal.maps.zzx) Preconditions.checkNotNull(zzxVar);
    }

    public void activate() {
        try {
            this.zza.zzg();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zza.zzh(((IndoorLevel) obj).zza);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public String getName() {
        try {
            return this.zza.zze();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public String getShortName() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
