package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static com.google.android.gms.internal.maps.zzi zza;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(zzb().zzd());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor defaultMarker(float f3) {
        try {
            return new BitmapDescriptor(zzb().zze(f3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        Preconditions.checkNotNull(str, "assetName must not be null");
        try {
            return new BitmapDescriptor(zzb().zzf(str));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap, "image must not be null");
        try {
            return new BitmapDescriptor(zzb().zzg(bitmap));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        Preconditions.checkNotNull(str, "fileName must not be null");
        try {
            return new BitmapDescriptor(zzb().zzh(str));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        Preconditions.checkNotNull(str, "absolutePath must not be null");
        try {
            return new BitmapDescriptor(zzb().zzi(str));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor fromPinConfig(PinConfig pinConfig) {
        try {
            return new BitmapDescriptor(zzb().zzj(pinConfig));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static BitmapDescriptor fromResource(int i3) {
        try {
            return new BitmapDescriptor(zzb().zzk(i3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static void zza(com.google.android.gms.internal.maps.zzi zziVar) {
        if (zza != null) {
            return;
        }
        zza = (com.google.android.gms.internal.maps.zzi) Preconditions.checkNotNull(zziVar, "delegate must not be null");
    }

    private static com.google.android.gms.internal.maps.zzi zzb() {
        return (com.google.android.gms.internal.maps.zzi) Preconditions.checkNotNull(zza, "IBitmapDescriptorFactory is not initialized");
    }
}
