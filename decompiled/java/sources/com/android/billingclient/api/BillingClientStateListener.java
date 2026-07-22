package com.android.billingclient.api;

/* loaded from: /root/release/classes.dex */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(BillingResult billingResult);
}
