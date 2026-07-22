package com.android.billingclient.api;

import java.util.List;

/* loaded from: /root/release/classes.dex */
final class zzaz {
    private final List zza;
    private final BillingResult zzb;

    zzaz(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    final BillingResult zza() {
        return this.zzb;
    }

    final List zzb() {
        return this.zza;
    }
}
