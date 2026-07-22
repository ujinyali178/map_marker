package com.android.billingclient.api;

import java.util.List;

/* loaded from: /root/release/classes.dex */
public interface PurchasesUpdatedListener {
    void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list);
}
