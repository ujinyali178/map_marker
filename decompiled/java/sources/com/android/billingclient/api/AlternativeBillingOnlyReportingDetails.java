package com.android.billingclient.api;

import org.json.JSONObject;

/* loaded from: /root/release/classes.dex */
public final class AlternativeBillingOnlyReportingDetails {
    private final String zza;

    AlternativeBillingOnlyReportingDetails(String str) {
        this.zza = new JSONObject(str).optString("externalTransactionToken");
    }

    public String getExternalTransactionToken() {
        return this.zza;
    }
}
