package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zziz;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: /root/release/classes.dex */
final class zzao implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final Object zzb = new Object();
    private boolean zzc = false;
    private BillingClientStateListener zzd;

    /* synthetic */ zzao(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzan zzanVar) {
        this.zza = billingClientImpl;
        this.zzd = billingClientStateListener;
    }

    private final void zzd(BillingResult billingResult) {
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingSetupFinished(billingResult);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler zzY;
        Future zzac;
        BillingResult zzaa;
        zzbi zzbiVar;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service connected.");
        this.zza.zzg = com.google.android.gms.internal.play_billing.zzl.zzr(iBinder);
        Callable callable = new Callable() { // from class: com.android.billingclient.api.zzal
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzao.this.zza();
                return null;
            }
        };
        Runnable runnable = new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                zzao.this.zzb();
            }
        };
        BillingClientImpl billingClientImpl = this.zza;
        zzY = billingClientImpl.zzY();
        zzac = billingClientImpl.zzac(callable, 30000L, runnable, zzY);
        if (zzac == null) {
            BillingClientImpl billingClientImpl2 = this.zza;
            zzaa = billingClientImpl2.zzaa();
            zzbiVar = billingClientImpl2.zzf;
            zzbiVar.zza(zzbh.zza(25, 6, zzaa));
            zzd(zzaa);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbi zzbiVar;
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing service disconnected.");
        zzbiVar = this.zza.zzf;
        zzbiVar.zzc(zziz.zzw());
        this.zza.zzg = null;
        this.zza.zza = 0;
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingServiceDisconnected();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ java.lang.Object zza() {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzao.zza():java.lang.Object");
    }

    final /* synthetic */ void zzb() {
        zzbi zzbiVar;
        this.zza.zza = 0;
        this.zza.zzg = null;
        zzbiVar = this.zza.zzf;
        BillingResult billingResult = zzbk.zzn;
        zzbiVar.zza(zzbh.zza(24, 6, billingResult));
        zzd(billingResult);
    }

    final void zzc() {
        synchronized (this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }
}
