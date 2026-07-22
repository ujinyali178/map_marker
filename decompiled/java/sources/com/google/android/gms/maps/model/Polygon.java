package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class Polygon {
    private final com.google.android.gms.internal.maps.zzag zza;

    public Polygon(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.zza = (com.google.android.gms.internal.maps.zzag) Preconditions.checkNotNull(zzagVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.zza.zzB(((Polygon) obj).zza);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getFillColor() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<List<LatLng>> getHoles() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public String getId() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getStrokeJointType() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zza(this.zza.zzn());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzj());
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
            return this.zza.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isClickable() {
        try {
            return this.zza.zzC();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zza.zzD();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzE();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void remove() {
        try {
            this.zza.zzo();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setClickable(boolean z3) {
        try {
            this.zza.zzp(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setFillColor(int i3) {
        try {
            this.zza.zzq(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setGeodesic(boolean z3) {
        try {
            this.zza.zzr(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setHoles(List<? extends List<LatLng>> list) {
        try {
            this.zza.zzs(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            Preconditions.checkNotNull(list, "points must not be null.");
            this.zza.zzt(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokeColor(int i3) {
        try {
            this.zza.zzu(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokeJointType(int i3) {
        try {
            this.zza.zzv(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokePattern(List<PatternItem> list) {
        try {
            this.zza.zzw(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokeWidth(float f3) {
        try {
            this.zza.zzx(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setTag(Object obj) {
        try {
            this.zza.zzy(ObjectWrapper.wrap(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setVisible(boolean z3) {
        try {
            this.zza.zzz(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setZIndex(float f3) {
        try {
            this.zza.zzA(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
