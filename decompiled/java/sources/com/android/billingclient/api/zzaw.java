package com.android.billingclient.api;

import android.os.Bundle;

/* loaded from: /root/release/classes.dex */
final class zzaw extends com.google.android.gms.internal.play_billing.zzi {
    final AlternativeBillingOnlyAvailabilityListener zza;
    final zzbi zzb;

    /* synthetic */ zzaw(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, zzbi zzbiVar, zzav zzavVar) {
        this.zza = alternativeBillingOnlyAvailabilityListener;
        this.zzb = zzbiVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzj
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            zzbi zzbiVar = this.zzb;
            BillingResult billingResult = zzbk.zzj;
            zzbiVar.zza(zzbh.zza(67, 14, billingResult));
            this.zza.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        BillingResult zza = zzbk.zza(zzb, com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + zzb);
            this.zzb.zza(zzbh.zza(23, 14, zza));
        }
        this.zza.onAlternativeBillingOnlyAvailabilityResponse(zza);
    }
}
