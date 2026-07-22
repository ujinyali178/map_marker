package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
final class zzcv extends zzdc {
    zzcv(zzcz zzczVar, String str, Long l3, boolean z3) {
        super(zzczVar, str, l3, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid long value for " + this.zzc + ": " + ((String) obj));
            return null;
        }
    }
}
