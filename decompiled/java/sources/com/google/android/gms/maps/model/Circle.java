package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class Circle {
    private final com.google.android.gms.internal.maps.zzl zza;

    public Circle(com.google.android.gms.internal.maps.zzl zzlVar) {
        this.zza = (com.google.android.gms.internal.maps.zzl) Preconditions.checkNotNull(zzlVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.zza.zzy(((Circle) obj).zza);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public LatLng getCenter() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getFillColor() {
        try {
            return this.zza.zzg();
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

    public double getRadius() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zza(this.zza.zzm());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zza.zze();
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
            return this.zza.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final int hashCode() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isClickable() {
        try {
            return this.zza.zzz();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzA();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void remove() {
        try {
            this.zza.zzn();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setCenter(LatLng latLng) {
        try {
            Preconditions.checkNotNull(latLng, "center must not be null.");
            this.zza.zzo(latLng);
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

    public void setRadius(double d3) {
        try {
            this.zza.zzr(d3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokeColor(int i3) {
        try {
            this.zza.zzs(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokePattern(List<PatternItem> list) {
        try {
            this.zza.zzt(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStrokeWidth(float f3) {
        try {
            this.zza.zzu(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setTag(Object obj) {
        try {
            this.zza.zzv(ObjectWrapper.wrap(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setVisible(boolean z3) {
        try {
            this.zza.zzw(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setZIndex(float f3) {
        try {
            this.zza.zzx(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
