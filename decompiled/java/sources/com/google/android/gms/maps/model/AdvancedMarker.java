package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: /root/release/classes.dex */
public class AdvancedMarker extends Marker {
    public AdvancedMarker(com.google.android.gms.internal.maps.zzad zzadVar) {
        super(zzadVar);
    }

    public View getIconView() {
        try {
            return (View) ObjectWrapper.unwrap(this.zza.zzh());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setIconView(View view) {
        if (view != null && view.getParent() != null) {
            throw new IllegalArgumentException("View already has a parent, can not be used as Marker");
        }
        try {
            this.zza.zzu(ObjectWrapper.wrap(view));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
