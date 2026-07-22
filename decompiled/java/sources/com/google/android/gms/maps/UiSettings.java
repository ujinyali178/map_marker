package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: /root/release/classes.dex */
public final class UiSettings {
    private final IUiSettingsDelegate zza;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.zza = iUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            return this.zza.isCompassEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            return this.zza.isIndoorLevelPickerEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isMapToolbarEnabled() {
        try {
            return this.zza.isMapToolbarEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.zza.isMyLocationButtonEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.zza.isRotateGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.zza.isScrollGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        try {
            return this.zza.isScrollGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.zza.isTiltGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.zza.isZoomControlsEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zza.isZoomGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setAllGesturesEnabled(boolean z3) {
        try {
            this.zza.setAllGesturesEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setCompassEnabled(boolean z3) {
        try {
            this.zza.setCompassEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean z3) {
        try {
            this.zza.setIndoorLevelPickerEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setMapToolbarEnabled(boolean z3) {
        try {
            this.zza.setMapToolbarEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setMyLocationButtonEnabled(boolean z3) {
        try {
            this.zza.setMyLocationButtonEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setRotateGesturesEnabled(boolean z3) {
        try {
            this.zza.setRotateGesturesEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setScrollGesturesEnabled(boolean z3) {
        try {
            this.zza.setScrollGesturesEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z3) {
        try {
            this.zza.setScrollGesturesEnabledDuringRotateOrZoom(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setTiltGesturesEnabled(boolean z3) {
        try {
            this.zza.setTiltGesturesEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setZoomControlsEnabled(boolean z3) {
        try {
            this.zza.setZoomControlsEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setZoomGesturesEnabled(boolean z3) {
        try {
            this.zza.setZoomGesturesEnabled(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
