package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* loaded from: /root/release/classes.dex */
final class zza extends AsyncTask {
    final /* synthetic */ Context zza;
    final /* synthetic */ ProviderInstaller.ProviderInstallListener zzb;

    zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.zza = context;
        this.zzb = providerInstallListener;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        int connectionStatusCode;
        try {
            ProviderInstaller.installIfNeeded(this.zza);
            connectionStatusCode = 0;
        } catch (GooglePlayServicesNotAvailableException e3) {
            connectionStatusCode = e3.errorCode;
        } catch (GooglePlayServicesRepairableException e4) {
            connectionStatusCode = e4.getConnectionStatusCode();
        }
        return Integer.valueOf(connectionStatusCode);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzb.onProviderInstalled();
            return;
        }
        googleApiAvailabilityLight = ProviderInstaller.zza;
        this.zzb.onProviderInstallFailed(num.intValue(), googleApiAvailabilityLight.getErrorResolutionIntent(this.zza, num.intValue(), "pi"));
    }
}
