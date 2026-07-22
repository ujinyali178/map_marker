package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.m;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzii;
import com.google.android.gms.internal.play_billing.zzin;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* loaded from: /root/release/classes.dex */
class BillingClientImpl extends BillingClient {
    private ExecutorService zzA;
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzh zzd;
    private Context zze;
    private zzbi zzf;
    private volatile com.google.android.gms.internal.play_billing.zzm zzg;
    private volatile zzao zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private zzbx zzy;
    private boolean zzz;

    private BillingClientImpl(Activity activity, zzbx zzbxVar, String str) {
        this(activity.getApplicationContext(), zzbxVar, new zzba(), str, null, null, null, null);
    }

    private BillingClientImpl(Context context, zzbx zzbxVar, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbiVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, zzbxVar, userChoiceBillingListener, str, (zzbi) null);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
    }

    BillingClientImpl(String str, Context context, zzbi zzbiVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        String zzab = zzab();
        this.zzb = zzab;
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(zzab);
        zzv.zzi(this.zze.getPackageName());
        this.zzf = new zzbn(this.zze, (zzio) zzv.zzc());
        this.zze.getPackageName();
    }

    BillingClientImpl(String str, zzbx zzbxVar, Context context, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbi zzbiVar, ExecutorService executorService) {
        String zzab = zzab();
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzab;
        initialize(context, purchasesUpdatedListener, zzbxVar, alternativeBillingListener, zzab, (zzbi) null);
    }

    BillingClientImpl(String str, zzbx zzbxVar, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbiVar, ExecutorService executorService) {
        this(context, zzbxVar, purchasesUpdatedListener, zzab(), null, userChoiceBillingListener, null, null);
    }

    BillingClientImpl(String str, zzbx zzbxVar, Context context, zzbq zzbqVar, zzbi zzbiVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzab();
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(zzab());
        zzv.zzi(this.zze.getPackageName());
        this.zzf = new zzbn(this.zze, (zzio) zzv.zzc());
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzh(this.zze, null, this.zzf);
        this.zzy = zzbxVar;
        this.zze.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbx zzbxVar, AlternativeBillingListener alternativeBillingListener, String str, zzbi zzbiVar) {
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(str);
        zzv.zzi(this.zze.getPackageName());
        if (zzbiVar == null) {
            zzbiVar = new zzbn(this.zze, (zzio) zzv.zzc());
        }
        this.zzf = zzbiVar;
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, alternativeBillingListener, this.zzf);
        this.zzy = zzbxVar;
        this.zzz = alternativeBillingListener != null;
        this.zze.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbx zzbxVar, UserChoiceBillingListener userChoiceBillingListener, String str, zzbi zzbiVar) {
        this.zze = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(str);
        zzv.zzi(this.zze.getPackageName());
        if (zzbiVar == null) {
            zzbiVar = new zzbn(this.zze, (zzio) zzv.zzc());
        }
        this.zzf = zzbiVar;
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, userChoiceBillingListener, this.zzf);
        this.zzy = zzbxVar;
        this.zzz = userChoiceBillingListener != null;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j3) {
        zzba zzbaVar = new zzba(j3);
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbh.zzb(6));
            zzbaVar.onBillingSetupFinished(zzbk.zzl);
            return;
        }
        int i3 = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzd;
            zzbiVar.zza(zzbh.zza(37, 6, billingResult));
            zzbaVar.onBillingSetupFinished(billingResult);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            zzbi zzbiVar2 = this.zzf;
            BillingResult billingResult2 = zzbk.zzm;
            zzbiVar2.zza(zzbh.zza(38, 6, billingResult2));
            zzbaVar.onBillingSetupFinished(billingResult2);
            return;
        }
        this.zza = 1;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzao(this, zzbaVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i3 = 41;
        } else {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i3 = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i3 = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service unavailable on device.");
        zzbi zzbiVar3 = this.zzf;
        BillingResult billingResult3 = zzbk.zzc;
        zzbiVar3.zza(zzbh.zza(i3, 6, billingResult3));
        zzbaVar.onBillingSetupFinished(billingResult3);
    }

    static /* synthetic */ zzce zzX(BillingClientImpl billingClientImpl, String str, int i3) {
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        Bundle zzd = com.google.android.gms.internal.play_billing.zzb.zzd(billingClientImpl.zzn, billingClientImpl.zzv, true, false, billingClientImpl.zzb);
        List list = null;
        String str2 = null;
        while (true) {
            try {
                Bundle zzj = billingClientImpl.zzn ? billingClientImpl.zzg.zzj(z3 != billingClientImpl.zzv ? 9 : 19, billingClientImpl.zze.getPackageName(), str, str2, zzd) : billingClientImpl.zzg.zzi(3, billingClientImpl.zze.getPackageName(), str, str2);
                zzcf zza = zzcg.zza(zzj, "BillingClient", "getPurchase()");
                BillingResult zza2 = zza.zza();
                if (zza2 != zzbk.zzl) {
                    billingClientImpl.zzf.zza(zzbh.zza(zza.zzb(), 9, zza2));
                    return new zzce(zza2, list);
                }
                ArrayList<String> stringArrayList = zzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z4 = false;
                for (int i4 = 0; i4 < stringArrayList2.size(); i4++) {
                    String str3 = stringArrayList2.get(i4);
                    String str4 = stringArrayList3.get(i4);
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z4 = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e3) {
                        com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e3);
                        zzbi zzbiVar = billingClientImpl.zzf;
                        BillingResult billingResult = zzbk.zzj;
                        zzbiVar.zza(zzbh.zza(51, 9, billingResult));
                        return new zzce(billingResult, null);
                    }
                }
                if (z4) {
                    billingClientImpl.zzf.zza(zzbh.zza(26, 9, zzbk.zzj));
                }
                str2 = zzj.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzce(zzbk.zzl, arrayList);
                }
                list = null;
                z3 = true;
            } catch (Exception e4) {
                zzbi zzbiVar2 = billingClientImpl.zzf;
                BillingResult billingResult2 = zzbk.zzm;
                zzbiVar2.zza(zzbh.zza(52, 9, billingResult2));
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e4);
                return new zzce(billingResult2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzY() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzZ(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzj
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzN(billingResult);
            }
        });
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaa() {
        return (this.zza == 0 || this.zza == 3) ? zzbk.zzm : zzbk.zzj;
    }

    private static String zzab() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future zzac(Callable callable, long j3, final Runnable runnable, Handler handler) {
        if (this.zzA == null) {
            this.zzA = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza, new zzag(this));
        }
        try {
            final Future submit = this.zzA.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzn
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j3 * 0.95d));
            return submit;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Async task throws exception!", e3);
            return null;
        }
    }

    private final void zzad(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 11, billingResult));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResult, null);
            return;
        }
        if (zzac(new zzai(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzy
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzT(purchaseHistoryResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 11, zzaa));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzaa, null);
        }
    }

    private final void zzae(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 9, billingResult));
            purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzaf.zzk());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please provide a valid product type.");
            zzbi zzbiVar2 = this.zzf;
            BillingResult billingResult2 = zzbk.zzg;
            zzbiVar2.zza(zzbh.zza(50, 9, billingResult2));
            purchasesResponseListener.onQueryPurchasesResponse(billingResult2, com.google.android.gms.internal.play_billing.zzaf.zzk());
            return;
        }
        if (zzac(new zzah(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzU(purchasesResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 9, zzaa));
            purchasesResponseListener.onQueryPurchasesResponse(zzaa, com.google.android.gms.internal.play_billing.zzaf.zzk());
        }
    }

    private final void zzaf(BillingResult billingResult, int i3, int i4) {
        zzic zzicVar = null;
        zzhy zzhyVar = null;
        if (billingResult.getResponseCode() == 0) {
            zzbi zzbiVar = this.zzf;
            try {
                zzib zzv = zzic.zzv();
                zzv.zzj(5);
                zziq zzv2 = zzis.zzv();
                zzv2.zzi(i4);
                zzv.zzi((zzis) zzv2.zzc());
                zzicVar = (zzic) zzv.zzc();
            } catch (Exception e3) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e3);
            }
            zzbiVar.zzb(zzicVar);
            return;
        }
        zzbi zzbiVar2 = this.zzf;
        try {
            zzhx zzv3 = zzhy.zzv();
            zzie zzv4 = zzii.zzv();
            zzv4.zzk(billingResult.getResponseCode());
            zzv4.zzj(billingResult.getDebugMessage());
            zzv4.zzl(i3);
            zzv3.zzi(zzv4);
            zzv3.zzk(5);
            zziq zzv5 = zzis.zzv();
            zzv5.zzi(i4);
            zzv3.zzj((zzis) zzv5.zzc());
            zzhyVar = (zzhy) zzv3.zzc();
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e4);
        }
        zzbiVar2.zza(zzhyVar);
    }

    static /* synthetic */ zzaz zzg(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzd = com.google.android.gms.internal.play_billing.zzb.zzd(billingClientImpl.zzn, billingClientImpl.zzv, true, false, billingClientImpl.zzb);
        String str2 = null;
        while (billingClientImpl.zzl) {
            try {
                Bundle zzh = billingClientImpl.zzg.zzh(6, billingClientImpl.zze.getPackageName(), str, str2, zzd);
                zzcf zza = zzcg.zza(zzh, "BillingClient", "getPurchaseHistory()");
                BillingResult zza2 = zza.zza();
                if (zza2 != zzbk.zzl) {
                    billingClientImpl.zzf.zza(zzbh.zza(zza.zzb(), 11, zza2));
                    return new zzaz(zza2, null);
                }
                ArrayList<String> stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z3 = false;
                for (int i3 = 0; i3 < stringArrayList2.size(); i3++) {
                    String str3 = stringArrayList2.get(i3);
                    String str4 = stringArrayList3.get(i3);
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i3))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z3 = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e3) {
                        com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e3);
                        zzbi zzbiVar = billingClientImpl.zzf;
                        BillingResult billingResult = zzbk.zzj;
                        zzbiVar.zza(zzbh.zza(51, 11, billingResult));
                        return new zzaz(billingResult, null);
                    }
                }
                if (z3) {
                    billingClientImpl.zzf.zza(zzbh.zza(26, 11, zzbk.zzj));
                }
                str2 = zzh.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzaz(zzbk.zzl, arrayList);
                }
            } catch (RemoteException e4) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", e4);
                zzbi zzbiVar2 = billingClientImpl.zzf;
                BillingResult billingResult2 = zzbk.zzm;
                zzbiVar2.zza(zzbh.zza(59, 11, billingResult2));
                return new zzaz(billingResult2, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzaz(zzbk.zzq, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 3, billingResult));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            zzbi zzbiVar2 = this.zzf;
            BillingResult billingResult2 = zzbk.zzi;
            zzbiVar2.zza(zzbh.zza(26, 3, billingResult2));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            return;
        }
        if (!this.zzn) {
            zzbi zzbiVar3 = this.zzf;
            BillingResult billingResult3 = zzbk.zzb;
            zzbiVar3.zza(zzbh.zza(27, 3, billingResult3));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            return;
        }
        if (zzac(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzk(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzk
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzM(acknowledgePurchaseResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 3, zzaa));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzaa);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 4, billingResult));
            consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
            return;
        }
        if (zzac(new Callable() { // from class: com.android.billingclient.api.zzw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzl(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzx
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzO(consumeResponseListener, consumeParams);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 4, zzaa));
            consumeResponseListener.onConsumeResponse(zzaa, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 15, billingResult));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
            return;
        }
        if (this.zzx) {
            if (zzac(new Callable() { // from class: com.android.billingclient.api.zzo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzq(alternativeBillingOnlyReportingDetailsListener);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzp
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzP(alternativeBillingOnlyReportingDetailsListener);
                }
            }, zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 15, zzaa));
                alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzaa, null);
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
        zzbi zzbiVar2 = this.zzf;
        BillingResult billingResult2 = zzbk.zzD;
        zzbiVar2.zza(zzbh.zza(66, 15, billingResult2));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult2, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        this.zzf.zzb(zzbh.zzb(12));
        try {
            try {
                if (this.zzd != null) {
                    this.zzd.zze();
                }
                if (this.zzh != null) {
                    this.zzh.zzc();
                }
                if (this.zzh != null && this.zzg != null) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unbinding from service.");
                    this.zze.unbindService(this.zzh);
                    this.zzh = null;
                }
                this.zzg = null;
                ExecutorService executorService = this.zzA;
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.zzA = null;
                }
            } catch (Exception e3) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "There was an exception while ending connection!", e3);
            }
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Service disconnected.");
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 13, billingResult));
            billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            return;
        }
        if (!this.zzu) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support get billing config.");
            zzbi zzbiVar2 = this.zzf;
            BillingResult billingResult2 = zzbk.zzz;
            zzbiVar2.zza(zzbh.zza(32, 13, billingResult2));
            billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            return;
        }
        String str = this.zzb;
        final Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (zzac(new Callable() { // from class: com.android.billingclient.api.zzl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzm(bundle, billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzm
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzQ(billingConfigResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 13, zzaa));
            billingConfigResponseListener.onBillingConfigResponse(zzaa, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 14, billingResult));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
            return;
        }
        if (this.zzx) {
            if (zzac(new Callable() { // from class: com.android.billingclient.api.zzt
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzr(alternativeBillingOnlyAvailabilityListener);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzv
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzR(alternativeBillingOnlyAvailabilityListener);
                }
            }, zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 14, zzaa));
                alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzaa);
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
        zzbi zzbiVar2 = this.zzf;
        BillingResult billingResult2 = zzbk.zzD;
        zzbiVar2.zza(zzbh.zza(66, 14, billingResult2));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c3;
        if (!isReady()) {
            BillingResult billingResult = zzbk.zzm;
            if (billingResult.getResponseCode() != 0) {
                this.zzf.zza(zzbh.zza(2, 5, billingResult));
            } else {
                this.zzf.zzb(zzbh.zzb(5));
            }
            return billingResult;
        }
        int i3 = zzbk.zzF;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c3 = 1;
                    break;
                }
                c3 = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c3 = 4;
                    break;
                }
                c3 = 65535;
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    c3 = 3;
                    break;
                }
                c3 = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c3 = 6;
                    break;
                }
                c3 = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c3 = 5;
                    break;
                }
                c3 = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c3 = 7;
                    break;
                }
                c3 = 65535;
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    c3 = '\b';
                    break;
                }
                c3 = 65535;
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    c3 = '\t';
                    break;
                }
                c3 = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c3 = '\n';
                    break;
                }
                c3 = 65535;
                break;
            case 104265:
                if (str.equals("iii")) {
                    c3 = 11;
                    break;
                }
                c3 = 65535;
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    c3 = '\f';
                    break;
                }
                c3 = 65535;
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c3 = 2;
                    break;
                }
                c3 = 65535;
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c3 = 0;
                    break;
                }
                c3 = 65535;
                break;
            default:
                c3 = 65535;
                break;
        }
        switch (c3) {
            case 0:
                BillingResult billingResult2 = this.zzi ? zzbk.zzl : zzbk.zzo;
                zzaf(billingResult2, 9, 2);
                return billingResult2;
            case 1:
                BillingResult billingResult3 = this.zzj ? zzbk.zzl : zzbk.zzp;
                zzaf(billingResult3, 10, 3);
                return billingResult3;
            case 2:
                BillingResult billingResult4 = this.zzm ? zzbk.zzl : zzbk.zzr;
                zzaf(billingResult4, 35, 4);
                return billingResult4;
            case 3:
                BillingResult billingResult5 = this.zzp ? zzbk.zzl : zzbk.zzw;
                zzaf(billingResult5, 30, 5);
                return billingResult5;
            case 4:
                BillingResult billingResult6 = this.zzr ? zzbk.zzl : zzbk.zzs;
                zzaf(billingResult6, 31, 6);
                return billingResult6;
            case 5:
                BillingResult billingResult7 = this.zzq ? zzbk.zzl : zzbk.zzu;
                zzaf(billingResult7, 21, 7);
                return billingResult7;
            case 6:
                BillingResult billingResult8 = this.zzs ? zzbk.zzl : zzbk.zzt;
                zzaf(billingResult8, 19, 8);
                return billingResult8;
            case 7:
                BillingResult billingResult9 = this.zzs ? zzbk.zzl : zzbk.zzt;
                zzaf(billingResult9, 61, 9);
                return billingResult9;
            case '\b':
                BillingResult billingResult10 = this.zzt ? zzbk.zzl : zzbk.zzv;
                zzaf(billingResult10, 20, 10);
                return billingResult10;
            case '\t':
                BillingResult billingResult11 = this.zzu ? zzbk.zzl : zzbk.zzz;
                zzaf(billingResult11, 32, 11);
                return billingResult11;
            case '\n':
                BillingResult billingResult12 = this.zzu ? zzbk.zzl : zzbk.zzA;
                zzaf(billingResult12, 33, 12);
                return billingResult12;
            case 11:
                BillingResult billingResult13 = this.zzw ? zzbk.zzl : zzbk.zzC;
                zzaf(billingResult13, 60, 13);
                return billingResult13;
            case '\f':
                BillingResult billingResult14 = this.zzx ? zzbk.zzl : zzbk.zzD;
                zzaf(billingResult14, 66, 14);
                return billingResult14;
            default:
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Unsupported feature: ".concat(str));
                BillingResult billingResult15 = zzbk.zzy;
                zzaf(billingResult15, 34, 1);
                return billingResult15;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x046a A[Catch: Exception -> 0x04d4, CancellationException -> 0x04eb, TimeoutException -> 0x04ed, TRY_ENTER, TryCatch #4 {CancellationException -> 0x04eb, TimeoutException -> 0x04ed, Exception -> 0x04d4, blocks: (B:134:0x046a, B:136:0x047c, B:138:0x0490, B:141:0x04ae, B:143:0x04ba), top: B:132:0x0468 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x047c A[Catch: Exception -> 0x04d4, CancellationException -> 0x04eb, TimeoutException -> 0x04ed, TryCatch #4 {CancellationException -> 0x04eb, TimeoutException -> 0x04ed, Exception -> 0x04d4, blocks: (B:134:0x046a, B:136:0x047c, B:138:0x0490, B:141:0x04ae, B:143:0x04ba), top: B:132:0x0468 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0425 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ba  */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r32, final com.android.billingclient.api.BillingFlowParams r33) {
        /*
            Method dump skipped, instructions count: 1299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 7, billingResult));
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new ArrayList());
            return;
        }
        if (this.zzt) {
            if (zzac(new Callable() { // from class: com.android.billingclient.api.zzu
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzn(queryProductDetailsParams, productDetailsResponseListener);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzS(productDetailsResponseListener);
                }
            }, zzY()) == null) {
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 7, zzaa));
                productDetailsResponseListener.onProductDetailsResponse(zzaa, new ArrayList());
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Querying product details is not supported.");
        zzbi zzbiVar2 = this.zzf;
        BillingResult billingResult2 = zzbk.zzv;
        zzbiVar2.zza(zzbh.zza(20, 7, billingResult2));
        productDetailsResponseListener.onProductDetailsResponse(billingResult2, new ArrayList());
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzad(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzad(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzae(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzae(str, purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(2, 8, billingResult));
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please fix the input params. SKU type can't be empty.");
            zzbi zzbiVar2 = this.zzf;
            BillingResult billingResult2 = zzbk.zzf;
            zzbiVar2.zza(zzbh.zza(49, 8, billingResult2));
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult2, null);
            return;
        }
        if (skusList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            zzbi zzbiVar3 = this.zzf;
            BillingResult billingResult3 = zzbk.zze;
            zzbiVar3.zza(zzbh.zza(48, 8, billingResult3));
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult3, null);
            return;
        }
        final String str = null;
        if (zzac(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzq
            public final /* synthetic */ String zzb;
            public final /* synthetic */ List zzc;
            public final /* synthetic */ SkuDetailsResponseListener zzd;

            {
                this.zzd = skuDetailsResponseListener;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzo(this.zzb, this.zzc, null, this.zzd);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzr
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzV(skuDetailsResponseListener);
            }
        }, zzY()) == null) {
            BillingResult zzaa = zzaa();
            this.zzf.zza(zzbh.zza(25, 8, zzaa));
            skuDetailsResponseListener.onSkuDetailsResponse(zzaa, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        zzbi zzbiVar;
        int i3;
        BillingResult billingResult;
        if (!isReady()) {
            zzbiVar = this.zzf;
            i3 = 2;
            billingResult = zzbk.zzm;
        } else {
            if (this.zzx) {
                final zzak zzakVar = new zzak(this, this.zzc, alternativeBillingOnlyInformationDialogListener);
                if (zzac(new Callable() { // from class: com.android.billingclient.api.zzad
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        BillingClientImpl.this.zzs(activity, zzakVar, alternativeBillingOnlyInformationDialogListener);
                        return null;
                    }
                }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
                    @Override // java.lang.Runnable
                    public final void run() {
                        BillingClientImpl.this.zzW(alternativeBillingOnlyInformationDialogListener);
                    }
                }, this.zzc) != null) {
                    return zzbk.zzl;
                }
                BillingResult zzaa = zzaa();
                this.zzf.zza(zzbh.zza(25, 16, zzaa));
                return zzaa;
            }
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzbiVar = this.zzf;
            i3 = 66;
            billingResult = zzbk.zzD;
        }
        zzbiVar.zza(zzbh.zza(i3, 16, billingResult));
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Service disconnected.");
            return zzbk.zzm;
        }
        if (!this.zzp) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzbk.zzw;
        }
        View findViewById = activity.findViewById(R.id.content);
        IBinder windowToken = findViewById.getWindowToken();
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        m.a(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzb);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        final zzaj zzajVar = new zzaj(this, this.zzc, inAppMessageResponseListener);
        zzac(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzp(bundle, activity, zzajVar);
                return null;
            }
        }, 5000L, null, this.zzc);
        return zzbk.zzl;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzbh.zzb(6));
            billingClientStateListener.onBillingSetupFinished(zzbk.zzl);
            return;
        }
        int i3 = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzd;
            zzbiVar.zza(zzbh.zza(37, 6, billingResult));
            billingClientStateListener.onBillingSetupFinished(billingResult);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            zzbi zzbiVar2 = this.zzf;
            BillingResult billingResult2 = zzbk.zzm;
            zzbiVar2.zza(zzbh.zza(38, 6, billingResult2));
            billingClientStateListener.onBillingSetupFinished(billingResult2);
            return;
        }
        this.zza = 1;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzao(this, billingClientStateListener, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i3 = 41;
        } else {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i3 = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i3 = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service unavailable on device.");
        zzbi zzbiVar3 = this.zzf;
        BillingResult billingResult3 = zzbk.zzc;
        zzbiVar3.zza(zzbh.zza(i3, 6, billingResult3));
        billingClientStateListener.onBillingSetupFinished(billingResult3);
    }

    final /* synthetic */ void zzM(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 3, billingResult));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    final /* synthetic */ void zzN(BillingResult billingResult) {
        if (this.zzd.zzd() != null) {
            this.zzd.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            this.zzd.zzc();
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ void zzO(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 4, billingResult));
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    final /* synthetic */ void zzP(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 15, billingResult));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    final /* synthetic */ void zzQ(BillingConfigResponseListener billingConfigResponseListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 13, billingResult));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    final /* synthetic */ void zzR(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 14, billingResult));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    final /* synthetic */ void zzS(ProductDetailsResponseListener productDetailsResponseListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 7, billingResult));
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new ArrayList());
    }

    final /* synthetic */ void zzT(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 11, billingResult));
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResult, null);
    }

    final /* synthetic */ void zzU(PurchasesResponseListener purchasesResponseListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 9, billingResult));
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzaf.zzk());
    }

    final /* synthetic */ void zzV(SkuDetailsResponseListener skuDetailsResponseListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 8, billingResult));
        skuDetailsResponseListener.onSkuDetailsResponse(billingResult, null);
    }

    final /* synthetic */ void zzW(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        zzbi zzbiVar = this.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 16, billingResult));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    final /* synthetic */ Bundle zzc(int i3, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) {
        return this.zzg.zzg(i3, this.zze.getPackageName(), str, str2, null, bundle);
    }

    final /* synthetic */ Bundle zzd(String str, String str2) {
        return this.zzg.zzf(3, this.zze.getPackageName(), str, str2, null);
    }

    final /* synthetic */ Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        try {
            com.google.android.gms.internal.play_billing.zzm zzmVar = this.zzg;
            String packageName = this.zze.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd = zzmVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbk.zza(com.google.android.gms.internal.play_billing.zzb.zzb(zzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzb.zzg(zzd, "BillingClient")));
            return null;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error acknowledge purchase!", e3);
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(28, 3, billingResult));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            return null;
        }
    }

    final /* synthetic */ Object zzl(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        int zza;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzn) {
                com.google.android.gms.internal.play_billing.zzm zzmVar = this.zzg;
                String packageName = this.zze.getPackageName();
                boolean z3 = this.zzn;
                String str2 = this.zzb;
                Bundle bundle = new Bundle();
                if (z3) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze = zzmVar.zze(9, packageName, purchaseToken, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zzb.zzg(zze, "BillingClient");
            } else {
                zza = this.zzg.zza(3, this.zze.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult zza2 = zzbk.zza(zza, str);
            if (zza == 0) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Successfully consumed purchase.");
            } else {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + zza);
                this.zzf.zza(zzbh.zza(23, 4, zza2));
            }
            consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
            return null;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error consuming purchase!", e3);
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(29, 4, billingResult));
            consumeResponseListener.onConsumeResponse(billingResult, purchaseToken);
            return null;
        }
    }

    final /* synthetic */ Object zzm(Bundle bundle, BillingConfigResponseListener billingConfigResponseListener) {
        zzbi zzbiVar;
        BillingResult billingResult;
        try {
            this.zzg.zzo(18, this.zze.getPackageName(), bundle, new zzau(billingConfigResponseListener, this.zzf, null));
        } catch (DeadObjectException e3) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", e3);
            zzbiVar = this.zzf;
            billingResult = zzbk.zzm;
            zzbiVar.zza(zzbh.zza(62, 13, billingResult));
            billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            return null;
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "getBillingConfig got an exception.", e4);
            zzbiVar = this.zzf;
            billingResult = zzbk.zzj;
            zzbiVar.zza(zzbh.zza(62, 13, billingResult));
            billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0128, code lost:
    
        r0.zza(r2);
        r13 = "Item is unavailable for purchase.";
        r14 = 4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ java.lang.Object zzn(com.android.billingclient.api.QueryProductDetailsParams r28, com.android.billingclient.api.ProductDetailsResponseListener r29) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzn(com.android.billingclient.api.QueryProductDetailsParams, com.android.billingclient.api.ProductDetailsResponseListener):java.lang.Object");
    }

    final /* synthetic */ Object zzo(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) {
        String str3;
        int i3;
        Bundle zzk;
        zzbi zzbiVar;
        int i4;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i5 = 0;
        while (true) {
            str3 = "Error trying to decode SkuDetails.";
            if (i5 >= size) {
                str3 = "";
                i3 = 0;
                break;
            }
            int i6 = i5 + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i5, i6 > size ? size : i6));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzo) {
                    com.google.android.gms.internal.play_billing.zzm zzmVar = this.zzg;
                    String packageName = this.zze.getPackageName();
                    int i7 = this.zzk;
                    String str4 = this.zzb;
                    Bundle bundle2 = new Bundle();
                    if (i7 >= 9) {
                        bundle2.putString("playBillingLibraryVersion", str4);
                    }
                    if (i7 >= 9) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    zzk = zzmVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    zzk = this.zzg.zzk(3, this.zze.getPackageName(), str, bundle);
                }
                if (zzk == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                    zzbiVar = this.zzf;
                    i4 = 44;
                    break;
                }
                if (zzk.containsKey("DETAILS_LIST")) {
                    ArrayList<String> stringArrayList = zzk.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got null response list");
                        zzbiVar = this.zzf;
                        i4 = 46;
                        break;
                    }
                    for (int i8 = 0; i8 < stringArrayList.size(); i8++) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i8));
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                            arrayList.add(skuDetails);
                        } catch (JSONException e3) {
                            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e3);
                            this.zzf.zza(zzbh.zza(47, 8, zzbk.zza(6, "Error trying to decode SkuDetails.")));
                            arrayList = null;
                            i3 = 6;
                            skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zza(i3, str3), arrayList);
                            return null;
                        }
                    }
                    i5 = i6;
                } else {
                    int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(zzk, "BillingClient");
                    str3 = com.google.android.gms.internal.play_billing.zzb.zzg(zzk, "BillingClient");
                    if (zzb != 0) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + zzb);
                        this.zzf.zza(zzbh.zza(23, 8, zzbk.zza(zzb, str3)));
                        i3 = zzb;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        this.zzf.zza(zzbh.zza(45, 8, zzbk.zza(6, str3)));
                    }
                }
            } catch (Exception e4) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e4);
                this.zzf.zza(zzbh.zza(43, 8, zzbk.zzm));
                i3 = -1;
                str3 = "Service connection is disconnected.";
                arrayList = null;
            }
        }
        zzbiVar.zza(zzbh.zza(i4, 8, zzbk.zzB));
        str3 = "Item is unavailable for purchase.";
        arrayList = null;
        i3 = 4;
        skuDetailsResponseListener.onSkuDetailsResponse(zzbk.zza(i3, str3), arrayList);
        return null;
    }

    final /* synthetic */ Object zzp(Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        this.zzg.zzq(12, this.zze.getPackageName(), bundle, new zzay(new WeakReference(activity), resultReceiver, null));
        return null;
    }

    final /* synthetic */ Void zzq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        try {
            this.zzg.zzm(21, this.zze.getPackageName(), new Bundle(), new zzaq(alternativeBillingOnlyReportingDetailsListener, this.zzf, null));
        } catch (Exception unused) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzj;
            zzbiVar.zza(zzbh.zza(70, 15, billingResult));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
        }
        return null;
    }

    final /* synthetic */ Void zzr(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        try {
            this.zzg.zzp(21, this.zze.getPackageName(), new Bundle(), new zzaw(alternativeBillingOnlyAvailabilityListener, this.zzf, null));
        } catch (Exception unused) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzj;
            zzbiVar.zza(zzbh.zza(69, 14, billingResult));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
        }
        return null;
    }

    final /* synthetic */ Void zzs(Activity activity, ResultReceiver resultReceiver, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        try {
            this.zzg.zzn(21, this.zze.getPackageName(), new Bundle(), new zzas(new WeakReference(activity), resultReceiver, this.zzf, null));
        } catch (Exception unused) {
            zzbi zzbiVar = this.zzf;
            BillingResult billingResult = zzbk.zzj;
            zzbiVar.zza(zzbh.zza(74, 16, billingResult));
            alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
        }
        return null;
    }
}
