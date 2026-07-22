package com.android.billingclient.api;

import java.util.List;

@Deprecated
/* loaded from: /root/release/classes.dex */
public interface SkuDetailsResponseListener {
    void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list);
}
