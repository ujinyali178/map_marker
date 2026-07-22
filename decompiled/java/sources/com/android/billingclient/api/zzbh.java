package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzii;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class zzbh {
    public static zzhy zza(int i3, int i4, BillingResult billingResult) {
        try {
            zzhx zzv = zzhy.zzv();
            zzie zzv2 = zzii.zzv();
            zzv2.zzk(billingResult.getResponseCode());
            zzv2.zzj(billingResult.getDebugMessage());
            zzv2.zzl(i3);
            zzv.zzi(zzv2);
            zzv.zzk(i4);
            return (zzhy) zzv.zzc();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e3);
            return null;
        }
    }

    public static zzic zzb(int i3) {
        try {
            zzib zzv = zzic.zzv();
            zzv.zzj(i3);
            return (zzic) zzv.zzc();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e3);
            return null;
        }
    }
}
