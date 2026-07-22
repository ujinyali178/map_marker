package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzaj;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class Polyline {
    private final zzaj zza;

    public Polyline(zzaj zzajVar) {
        this.zza = (zzaj) Preconditions.checkNotNull(zzajVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.zza.zzD(((Polyline) obj).zza);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getColor() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public Cap getEndCap() {
        try {
            return this.zza.zzj().zza();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public String getId() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getJointType() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<PatternItem> getPattern() {
        try {
            return PatternItem.zza(this.zza.zzm());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<StyleSpan> getSpans() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public Cap getStartCap() {
        try {
            return this.zza.zzk().zza();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzi());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public float getWidth() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isClickable() {
        try {
            return this.zza.zzE();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zza.zzF();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void remove() {
        try {
            this.zza.zzp();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setClickable(boolean z3) {
        try {
            this.zza.zzq(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setColor(int i3) {
        try {
            this.zza.zzr(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setEndCap(Cap cap) {
        Preconditions.checkNotNull(cap, "endCap must not be null");
        try {
            this.zza.zzs(cap);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setGeodesic(boolean z3) {
        try {
            this.zza.zzt(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setJointType(int i3) {
        try {
            this.zza.zzu(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPattern(List<PatternItem> list) {
        try {
            this.zza.zzv(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPoints(List<LatLng> list) {
        Preconditions.checkNotNull(list, "points must not be null");
        try {
            this.zza.zzw(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setSpans(List<StyleSpan> list) {
        try {
            this.zza.zzx(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStartCap(Cap cap) {
        Preconditions.checkNotNull(cap, "startCap must not be null");
        try {
            this.zza.zzy(cap);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setTag(Object obj) {
        try {
            this.zza.zzz(ObjectWrapper.wrap(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setVisible(boolean z3) {
        try {
            this.zza.zzA(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setWidth(float f3) {
        try {
            this.zza.zzB(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setZIndex(float f3) {
        try {
            this.zza.zzC(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
