package com.android.billingclient.api;

import org.json.JSONObject;

/* loaded from: /root/release/classes.dex */
public final class BillingConfig {
    private final String zza;
    private final JSONObject zzb;
    private final String zzc;

    BillingConfig(String str) {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        this.zzc = jSONObject.optString("countryCode");
    }

    public String getCountryCode() {
        return this.zzc;
    }
}
