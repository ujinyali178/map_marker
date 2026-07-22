package com.android.billingclient.api;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class BillingFlowParams {
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private com.google.android.gms.internal.play_billing.zzaf zze;
    private ArrayList zzf;
    private boolean zzg;

    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private SubscriptionUpdateParams.Builder zzf;

        private Builder() {
            SubscriptionUpdateParams.Builder newBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(newBuilder);
            this.zzf = newBuilder;
        }

        /* synthetic */ Builder(zzbb zzbbVar) {
            SubscriptionUpdateParams.Builder newBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(newBuilder);
            this.zzf = newBuilder;
        }

        public BillingFlowParams build() {
            ArrayList arrayList = this.zzd;
            boolean z3 = true;
            boolean z4 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.zzc;
            boolean z5 = (list == null || list.isEmpty()) ? false : true;
            if (!z4 && !z5) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z4 && z5) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            zzbg zzbgVar = null;
            if (!z4) {
                ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.zzc.get(0);
                for (int i3 = 0; i3 < this.zzc.size(); i3++) {
                    ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.zzc.get(i3);
                    if (productDetailsParams2 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if (i3 != 0 && !productDetailsParams2.zza().getProductType().equals(productDetailsParams.zza().getProductType()) && !productDetailsParams2.zza().getProductType().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                String zza = productDetailsParams.zza().zza();
                for (ProductDetailsParams productDetailsParams3 : this.zzc) {
                    if (!productDetailsParams.zza().getProductType().equals("play_pass_subs") && !productDetailsParams3.zza().getProductType().equals("play_pass_subs") && !zza.equals(productDetailsParams3.zza().zza())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                }
            } else {
                if (this.zzd.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.zzd.size() > 1) {
                    SkuDetails skuDetails = (SkuDetails) this.zzd.get(0);
                    String type = skuDetails.getType();
                    ArrayList arrayList2 = this.zzd;
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i4);
                        if (!type.equals("play_pass_subs") && !skuDetails2.getType().equals("play_pass_subs") && !type.equals(skuDetails2.getType())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String zzd = skuDetails.zzd();
                    ArrayList arrayList3 = this.zzd;
                    int size2 = arrayList3.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i5);
                        if (!type.equals("play_pass_subs") && !skuDetails3.getType().equals("play_pass_subs") && !zzd.equals(skuDetails3.zzd())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams(zzbgVar);
            if ((!z4 || ((SkuDetails) this.zzd.get(0)).zzd().isEmpty()) && (!z5 || ((ProductDetailsParams) this.zzc.get(0)).zza().zza().isEmpty())) {
                z3 = false;
            }
            billingFlowParams.zza = z3;
            billingFlowParams.zzb = this.zza;
            billingFlowParams.zzc = this.zzb;
            billingFlowParams.zzd = this.zzf.build();
            ArrayList arrayList4 = this.zzd;
            billingFlowParams.zzf = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
            billingFlowParams.zzg = this.zze;
            List list2 = this.zzc;
            billingFlowParams.zze = list2 != null ? com.google.android.gms.internal.play_billing.zzaf.zzj(list2) : com.google.android.gms.internal.play_billing.zzaf.zzk();
            return billingFlowParams;
        }

        public Builder setIsOfferPersonalized(boolean z3) {
            this.zze = z3;
            return this;
        }

        public Builder setObfuscatedAccountId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setObfuscatedProfileId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setProductDetailsParamsList(List<ProductDetailsParams> list) {
            this.zzc = new ArrayList(list);
            return this;
        }

        @Deprecated
        public Builder setSkuDetails(SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.zzd = arrayList;
            return this;
        }

        public Builder setSubscriptionUpdateParams(SubscriptionUpdateParams subscriptionUpdateParams) {
            this.zzf = SubscriptionUpdateParams.zzc(subscriptionUpdateParams);
            return this;
        }
    }

    public static final class ProductDetailsParams {
        private final ProductDetails zza;
        private final String zzb;

        public static class Builder {
            private ProductDetails zza;
            private String zzb;

            private Builder() {
            }

            /* synthetic */ Builder(zzbc zzbcVar) {
            }

            public ProductDetailsParams build() {
                com.google.android.gms.internal.play_billing.zzx.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
                com.google.android.gms.internal.play_billing.zzx.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams.");
                return new ProductDetailsParams(this, null);
            }

            public Builder setOfferToken(String str) {
                this.zzb = str;
                return this;
            }

            public Builder setProductDetails(ProductDetails productDetails) {
                this.zza = productDetails;
                if (productDetails.getOneTimePurchaseOfferDetails() != null) {
                    productDetails.getOneTimePurchaseOfferDetails().getClass();
                    this.zzb = productDetails.getOneTimePurchaseOfferDetails().zza();
                }
                return this;
            }
        }

        /* synthetic */ ProductDetailsParams(Builder builder, zzbd zzbdVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public final ProductDetails zza() {
            return this.zza;
        }

        public final String zzb() {
            return this.zzb;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    public @interface ProrationMode {
        public static final int DEFERRED = 4;
        public static final int IMMEDIATE_AND_CHARGE_FULL_PRICE = 5;
        public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
        public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
        public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
        public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;
    }

    public static class SubscriptionUpdateParams {
        private String zza;
        private String zzb;
        private int zzc = 0;
        private int zzd = 0;

        public static class Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd = 0;
            private int zze = 0;

            private Builder() {
            }

            /* synthetic */ Builder(zzbe zzbeVar) {
            }

            static /* synthetic */ Builder zza(Builder builder) {
                builder.zzc = true;
                return builder;
            }

            public SubscriptionUpdateParams build() {
                zzbf zzbfVar = null;
                boolean z3 = (TextUtils.isEmpty(this.zza) && TextUtils.isEmpty(null)) ? false : true;
                boolean isEmpty = true ^ TextUtils.isEmpty(this.zzb);
                if (z3 && isEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.zzc && !z3 && !isEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(zzbfVar);
                subscriptionUpdateParams.zza = this.zza;
                subscriptionUpdateParams.zzc = this.zzd;
                subscriptionUpdateParams.zzd = this.zze;
                subscriptionUpdateParams.zzb = this.zzb;
                return subscriptionUpdateParams;
            }

            public Builder setOldPurchaseToken(String str) {
                this.zza = str;
                return this;
            }

            @Deprecated
            public Builder setOldSkuPurchaseToken(String str) {
                this.zza = str;
                return this;
            }

            public Builder setOriginalExternalTransactionId(String str) {
                this.zzb = str;
                return this;
            }

            @Deprecated
            public Builder setReplaceProrationMode(int i3) {
                this.zzd = i3;
                return this;
            }

            @Deprecated
            public Builder setReplaceSkusProrationMode(int i3) {
                this.zzd = i3;
                return this;
            }

            public Builder setSubscriptionReplacementMode(int i3) {
                this.zze = i3;
                return this;
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;
        }

        private SubscriptionUpdateParams() {
        }

        /* synthetic */ SubscriptionUpdateParams(zzbf zzbfVar) {
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        static /* bridge */ /* synthetic */ Builder zzc(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder newBuilder = newBuilder();
            newBuilder.setOldSkuPurchaseToken(subscriptionUpdateParams.zza);
            newBuilder.setReplaceSkusProrationMode(subscriptionUpdateParams.zzc);
            newBuilder.setSubscriptionReplacementMode(subscriptionUpdateParams.zzd);
            newBuilder.setOriginalExternalTransactionId(subscriptionUpdateParams.zzb);
            return newBuilder;
        }

        @Deprecated
        final int zza() {
            return this.zzc;
        }

        final int zzb() {
            return this.zzd;
        }

        final String zzd() {
            return this.zza;
        }

        final String zze() {
            return this.zzb;
        }
    }

    private BillingFlowParams() {
    }

    /* synthetic */ BillingFlowParams(zzbg zzbgVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Deprecated
    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        return this.zzd.zzb();
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd.zzd();
    }

    public final String zzf() {
        return this.zzd.zze();
    }

    public final ArrayList zzg() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzf);
        return arrayList;
    }

    public final List zzh() {
        return this.zze;
    }

    public final boolean zzp() {
        return this.zzg;
    }

    final boolean zzq() {
        return (this.zzb == null && this.zzc == null && this.zzd.zze() == null && this.zzd.zza() == 0 && this.zzd.zzb() == 0 && !this.zza && !this.zzg) ? false : true;
    }
}
