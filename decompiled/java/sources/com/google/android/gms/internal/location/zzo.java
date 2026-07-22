package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;

/* loaded from: /root/release/classes.dex */
public interface zzo extends IInterface {
    @Deprecated
    Location zzd();

    @Deprecated
    ICancelToken zze(CurrentLocationRequest currentLocationRequest, zzq zzqVar);

    @Deprecated
    LocationAvailability zzf(String str);

    void zzg(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzm zzmVar);

    void zzh(LocationSettingsRequest locationSettingsRequest, zzs zzsVar, String str);

    void zzi(zzk zzkVar);

    @Deprecated
    void zzj(LastLocationRequest lastLocationRequest, zzq zzqVar);

    void zzk(zzdb zzdbVar, LocationRequest locationRequest, IStatusCallback iStatusCallback);

    void zzl(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzm(PendingIntent pendingIntent);

    void zzn(PendingIntent pendingIntent, zzm zzmVar, String str);

    void zzo(String[] strArr, zzm zzmVar, String str);

    void zzp(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzq(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzr(long j3, boolean z3, PendingIntent pendingIntent);

    void zzs(com.google.android.gms.location.zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzt(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback);

    @Deprecated
    void zzu(Location location);

    void zzv(Location location, IStatusCallback iStatusCallback);

    @Deprecated
    void zzw(boolean z3);

    void zzx(boolean z3, IStatusCallback iStatusCallback);

    void zzy(zzdb zzdbVar, IStatusCallback iStatusCallback);

    @Deprecated
    void zzz(zzdf zzdfVar);
}
