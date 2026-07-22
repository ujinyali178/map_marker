package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class IndoorBuilding {
    private final com.google.android.gms.internal.maps.zzu zza;
    private final zzh zzb;

    public IndoorBuilding(com.google.android.gms.internal.maps.zzu zzuVar) {
        zzh zzhVar = zzh.zza;
        this.zza = (com.google.android.gms.internal.maps.zzu) Preconditions.checkNotNull(zzuVar, "delegate");
        this.zzb = (zzh) Preconditions.checkNotNull(zzhVar, "shim");
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zza.zzh(((IndoorBuilding) obj).zza);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List zzg = this.zza.zzg();
            ArrayList arrayList = new ArrayList(zzg.size());
            Iterator it = zzg.iterator();
            while (it.hasNext()) {
                arrayList.add(new IndoorLevel(com.google.android.gms.internal.maps.zzw.zzb((IBinder) it.next())));
            }
            return arrayList;
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
