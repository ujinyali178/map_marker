package com.google.android.gms.internal.auth;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.n;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
final class zzco implements zzcl {
    private static zzco zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    private zzco() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzco(Context context) {
        this.zzb = context;
        zzcn zzcnVar = new zzcn(this, null);
        this.zzc = zzcnVar;
        context.getContentResolver().registerContentObserver(zzcb.zza, true, zzcnVar);
    }

    static zzco zza(Context context) {
        zzco zzcoVar;
        synchronized (zzco.class) {
            if (zza == null) {
                zza = n.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzco(context) : new zzco();
            }
            zzcoVar = zza;
        }
        return zzcoVar;
    }

    static synchronized void zze() {
        Context context;
        synchronized (zzco.class) {
            zzco zzcoVar = zza;
            if (zzcoVar != null && (context = zzcoVar.zzb) != null && zzcoVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Override // com.google.android.gms.internal.auth.zzcl
    @Nullable
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.zzb;
        if (context != null && !zzcc.zza(context)) {
            try {
                return (String) zzcj.zza(new zzck() { // from class: com.google.android.gms.internal.auth.zzcm
                    @Override // com.google.android.gms.internal.auth.zzck
                    public final Object zza() {
                        return zzco.this.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e3) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e3);
            }
        }
        return null;
    }

    final /* synthetic */ String zzd(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, null);
    }
}
