package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: /root/release/classes.dex */
public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate zza;

    private CameraUpdateFactory() {
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        Preconditions.checkNotNull(cameraPosition, "cameraPosition must not be null");
        try {
            return new CameraUpdate(zzb().newCameraPosition(cameraPosition));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        Preconditions.checkNotNull(latLng, "latLng must not be null");
        try {
            return new CameraUpdate(zzb().newLatLng(latLng));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i3) {
        Preconditions.checkNotNull(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(zzb().newLatLngBounds(latLngBounds, i3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i3, int i4, int i5) {
        Preconditions.checkNotNull(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(zzb().newLatLngBoundsWithSize(latLngBounds, i3, i4, i5));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f3) {
        Preconditions.checkNotNull(latLng, "latLng must not be null");
        try {
            return new CameraUpdate(zzb().newLatLngZoom(latLng, f3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate scrollBy(float f3, float f4) {
        try {
            return new CameraUpdate(zzb().scrollBy(f3, f4));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate zoomBy(float f3) {
        try {
            return new CameraUpdate(zzb().zoomBy(f3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate zoomBy(float f3, Point point) {
        Preconditions.checkNotNull(point, "focus must not be null");
        try {
            return new CameraUpdate(zzb().zoomByWithFocus(f3, point.x, point.y));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(zzb().zoomIn());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(zzb().zoomOut());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate zoomTo(float f3) {
        try {
            return new CameraUpdate(zzb().zoomTo(f3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static void zza(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        zza = (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(iCameraUpdateFactoryDelegate);
    }

    private static ICameraUpdateFactoryDelegate zzb() {
        return (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(zza, "CameraUpdateFactory is not initialized");
    }
}
