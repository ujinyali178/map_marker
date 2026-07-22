package com.android.billingclient.api;

/* loaded from: /root/release/classes.dex */
public final class BillingResult {
    private int zza;
    private String zzb;

    public static class Builder {
        private int zza;
        private String zzb = "";

        private Builder() {
        }

        /* synthetic */ Builder(zzbj zzbjVar) {
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            return billingResult;
        }

        public Builder setDebugMessage(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setResponseCode(int i3) {
            this.zza = i3;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getDebugMessage() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }

    public String toString() {
        return "Response Code: " + com.google.android.gms.internal.play_billing.zzb.zzh(this.zza) + ", Debug Message: " + this.zzb;
    }
}
