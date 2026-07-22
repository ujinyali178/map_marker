package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.a;
import androidx.activity.result.b;
import androidx.activity.result.c;
import androidx.activity.result.e;
import b.g;

/* loaded from: /root/release/classes.dex */
public class ProxyBillingActivity extends ComponentActivity {
    static final String KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER = "alternative_billing_only_dialog_result_receiver";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    static final String KEY_PRICE_CHANGE_RESULT_RECEIVER = "result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final String TAG = "ProxyBillingActivity";
    private c<e> alternativeBillingOnlyDialogLauncher;
    private ResultReceiver alternativeBillingOnlyDialogResultReceiver;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private ResultReceiver priceChangeResultReceiver;
    private boolean sendCancelledBroadcastIfFinished;

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent makePurchasesUpdatedIntent() {
        getApplicationContext().getPackageName();
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            r8 = this;
            super.onActivityResult(r9, r10, r11)
            r0 = 0
            r1 = 0
            r2 = 110(0x6e, float:1.54E-43)
            java.lang.String r3 = "ProxyBillingActivity"
            r4 = 100
            if (r9 == r4) goto L43
            if (r9 != r2) goto L10
            goto L43
        L10:
            r10 = 101(0x65, float:1.42E-43)
            if (r9 != r10) goto L28
            int r9 = com.google.android.gms.internal.play_billing.zzb.zza(r11, r3)
            android.os.ResultReceiver r10 = r8.inAppMessageResultReceiver
            if (r10 == 0) goto Leb
            if (r11 != 0) goto L1f
            goto L23
        L1f:
            android.os.Bundle r0 = r11.getExtras()
        L23:
            r10.send(r9, r0)
            goto Leb
        L28:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Got onActivityResult with wrong requestCode: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = "; skipping..."
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r3, r9)
            goto Leb
        L43:
            int r4 = com.google.android.gms.internal.play_billing.zzb.zzc(r11, r3)
            r5 = -1
            if (r10 != r5) goto L50
            if (r4 == 0) goto L4e
            r10 = -1
            goto L50
        L4e:
            r4 = 0
            goto L6c
        L50:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Activity finished with resultCode "
            r5.append(r6)
            r5.append(r10)
            java.lang.String r10 = " and billing's responseCode: "
            r5.append(r10)
            r5.append(r4)
            java.lang.String r10 = r5.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r3, r10)
        L6c:
            android.os.ResultReceiver r10 = r8.priceChangeResultReceiver
            if (r10 == 0) goto L7b
            if (r11 != 0) goto L73
            goto L77
        L73:
            android.os.Bundle r0 = r11.getExtras()
        L77:
            r10.send(r4, r0)
            goto Leb
        L7b:
            if (r11 == 0) goto Ldc
            android.os.Bundle r10 = r11.getExtras()
            java.lang.String r0 = "LAUNCH_BILLING_FLOW"
            java.lang.String r4 = "INTENT_SOURCE"
            if (r10 == 0) goto La4
            android.os.Bundle r10 = r11.getExtras()
            java.lang.String r3 = "ALTERNATIVE_BILLING_USER_CHOICE_DATA"
            java.lang.String r10 = r10.getString(r3)
            if (r10 == 0) goto L98
            android.content.Intent r10 = r8.makeAlternativeBillingIntent(r10)
            goto Ld8
        L98:
            android.content.Intent r10 = r8.makePurchasesUpdatedIntent()
            android.os.Bundle r11 = r11.getExtras()
            r10.putExtras(r11)
            goto Ld8
        La4:
            android.content.Intent r10 = r8.makePurchasesUpdatedIntent()
            java.lang.String r11 = "Got null bundle!"
            com.google.android.gms.internal.play_billing.zzb.zzk(r3, r11)
            java.lang.String r11 = "RESPONSE_CODE"
            r3 = 6
            r10.putExtra(r11, r3)
            java.lang.String r11 = "DEBUG_MESSAGE"
            java.lang.String r5 = "An internal error occurred."
            r10.putExtra(r11, r5)
            r11 = 22
            r6 = 2
            com.android.billingclient.api.BillingResult$Builder r7 = com.android.billingclient.api.BillingResult.newBuilder()
            r7.setResponseCode(r3)
            r7.setDebugMessage(r5)
            com.android.billingclient.api.BillingResult r3 = r7.build()
            com.google.android.gms.internal.play_billing.zzhy r11 = com.android.billingclient.api.zzbh.zza(r11, r6, r3)
            byte[] r11 = r11.zzc()
            java.lang.String r3 = "FAILURE_LOGGING_PAYLOAD"
            r10.putExtra(r3, r11)
        Ld8:
            r10.putExtra(r4, r0)
            goto Le0
        Ldc:
            android.content.Intent r10 = r8.makePurchasesUpdatedIntent()
        Le0:
            if (r9 != r2) goto Le8
            r9 = 1
            java.lang.String r11 = "IS_FIRST_PARTY_PURCHASE"
            r10.putExtra(r11, r9)
        Le8:
            r8.sendBroadcast(r10)
        Leb:
            r8.sendCancelledBroadcastIfFinished = r1
            r8.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    void onAlternativeBillingOnlyDialogResult(a aVar) {
        Intent a4 = aVar.a();
        int zzc = com.google.android.gms.internal.play_billing.zzb.zzc(a4, TAG);
        ResultReceiver resultReceiver = this.alternativeBillingOnlyDialogResultReceiver;
        if (resultReceiver != null) {
            resultReceiver.send(zzc, a4 == null ? null : a4.getExtras());
        }
        if (aVar.b() != -1 || zzc != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk(TAG, "Alternative billing only dialog finished with resultCode " + aVar.b() + " and billing's responseCode: " + zzc);
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        int i3;
        super.onCreate(bundle);
        this.alternativeBillingOnlyDialogLauncher = registerForActivityResult(new g(), new b() { // from class: com.android.billingclient.api.zzcd
            @Override // androidx.activity.result.b
            public final void onActivityResult(Object obj) {
                ProxyBillingActivity.this.onAlternativeBillingOnlyDialogResult((a) obj);
            }
        });
        if (bundle != null) {
            com.google.android.gms.internal.play_billing.zzb.zzj(TAG, "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
            if (bundle.containsKey(KEY_PRICE_CHANGE_RESULT_RECEIVER)) {
                this.priceChangeResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_PRICE_CHANGE_RESULT_RECEIVER);
            } else if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            } else if (bundle.containsKey(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER)) {
                this.alternativeBillingOnlyDialogResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER);
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        com.google.android.gms.internal.play_billing.zzb.zzj(TAG, "Launching Play Store billing flow");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.alternativeBillingOnlyDialogResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER);
            this.alternativeBillingOnlyDialogLauncher.a(new e.a(pendingIntent2).a());
            return;
        }
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.isFlowFromFirstPartyClient = true;
                i3 = REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW;
            }
            i3 = 100;
        } else {
            if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.priceChangeResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_PRICE_CHANGE_RESULT_RECEIVER);
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
                i3 = REQUEST_CODE_IN_APP_MESSAGE_FLOW;
            } else {
                pendingIntent = null;
            }
            i3 = 100;
        }
        try {
            this.sendCancelledBroadcastIfFinished = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i3, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl(TAG, "Got exception while trying to start a purchase flow.", e3);
            ResultReceiver resultReceiver = this.priceChangeResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    if (this.isFlowFromFirstPartyClient) {
                        makePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
                    makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(makePurchasesUpdatedIntent);
                }
            }
            this.sendCancelledBroadcastIfFinished = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.priceChangeResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(KEY_PRICE_CHANGE_RESULT_RECEIVER, resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
        if (resultReceiver2 != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.alternativeBillingOnlyDialogResultReceiver;
        if (resultReceiver3 != null) {
            bundle.putParcelable(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER, resultReceiver3);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
    }
}
