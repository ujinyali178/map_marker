package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zziv;

/* loaded from: /root/release/classes.dex */
final class zzbp {
    private boolean zza;
    private Transport zzb;

    zzbp(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.zzb = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zziv.class, Encoding.of("proto"), new Transformer() { // from class: com.android.billingclient.api.zzbo
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((zziv) obj).zzc();
                }
            });
        } catch (Throwable unused) {
            this.zza = true;
        }
    }

    public final void zza(zziv zzivVar) {
        String str;
        if (this.zza) {
            str = "Skipping logging since initialization failed.";
        } else {
            try {
                this.zzb.send(Event.ofData(zzivVar));
                return;
            } catch (Throwable unused) {
                str = "logging failed.";
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingLogger", str);
    }
}
