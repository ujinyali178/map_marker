package com.android.billingclient.api;

import java.util.List;

/* loaded from: /root/release/classes.dex */
public interface ProductDetailsResponseListener {
    void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list);
}
