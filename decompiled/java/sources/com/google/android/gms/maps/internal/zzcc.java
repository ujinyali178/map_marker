package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: /root/release/classes.dex */
public final class zzcc {
    private static final String zza = "zzcc";
    private static Context zzb;
    private static zzf zzc;

    public static zzf zza(Context context, MapsInitializer.Renderer renderer) {
        Preconditions.checkNotNull(context);
        Log.d(zza, "preferredRenderer: ".concat(String.valueOf(renderer)));
        zzf zzfVar = zzc;
        if (zzfVar != null) {
            return zzfVar;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        zzf zzd = zzd(context, renderer);
        zzc = zzd;
        try {
            if (zzd.zzd() == 2) {
                try {
                    zzc.zzm(ObjectWrapper.wrap(zzc(context, renderer)));
                } catch (RemoteException e3) {
                    throw new RuntimeRemoteException(e3);
                } catch (UnsatisfiedLinkError unused) {
                    Log.w(zza, "Caught UnsatisfiedLinkError attempting to load the LATEST renderer's native library. Attempting to use the LEGACY renderer instead.");
                    zzb = null;
                    zzc = zzd(context, MapsInitializer.Renderer.LEGACY);
                }
            }
            try {
                zzf zzfVar2 = zzc;
                Context zzc2 = zzc(context, renderer);
                zzc2.getClass();
                zzfVar2.zzk(ObjectWrapper.wrap(zzc2.getResources()), 18020000);
                return zzc;
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        } catch (RemoteException e5) {
            throw new RuntimeRemoteException(e5);
        }
    }

    private static Context zzb(Exception exc, Context context) {
        Log.e(zza, "Failed to load maps module, use pre-Chimera", exc);
        return GooglePlayServicesUtil.getRemoteContext(context);
    }

    private static Context zzc(Context context, MapsInitializer.Renderer renderer) {
        Context zzb2;
        Context context2 = zzb;
        if (context2 != null) {
            return context2;
        }
        String str = renderer == MapsInitializer.Renderer.LEGACY ? "com.google.android.gms.maps_legacy_dynamite" : "com.google.android.gms.maps_core_dynamite";
        try {
            zzb2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str).getModuleContext();
        } catch (Exception e3) {
            if (str.equals("com.google.android.gms.maps_dynamite")) {
                zzb2 = zzb(e3, context);
            } else {
                try {
                    Log.d(zza, "Attempting to load maps_dynamite again.");
                    zzb2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
                } catch (Exception e4) {
                    zzb2 = zzb(e4, context);
                }
            }
        }
        zzb = zzb2;
        return zzb2;
    }

    private static zzf zzd(Context context, MapsInitializer.Renderer renderer) {
        Log.i(zza, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) zze(((ClassLoader) Preconditions.checkNotNull(zzc(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return queryLocalInterface instanceof zzf ? (zzf) queryLocalInterface : new zze(iBinder);
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl", e3);
        }
    }

    private static Object zze(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(cls.getName()), e3);
        } catch (InstantiationException e4) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(cls.getName()), e4);
        }
    }
}
