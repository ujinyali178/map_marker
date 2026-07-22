package com.android.billingclient.api;

/* loaded from: /root/release/classes.dex */
public final class QueryPurchaseHistoryParams {
    private final String zza;

    public static class Builder {
        private String zza;

        private Builder() {
        }

        /* synthetic */ Builder(zzcl zzclVar) {
        }

        public QueryPurchaseHistoryParams build() {
            if (this.zza != null) {
                return new QueryPurchaseHistoryParams(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public Builder setProductType(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ QueryPurchaseHistoryParams(Builder builder, zzcm zzcmVar) {
        this.zza = builder.zza;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final String zza() {
        return this.zza;
    }
}
