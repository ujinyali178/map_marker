package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
final class zzcx extends zzdc {
    zzcx(zzcz zzczVar, String str, Double d3, boolean z3) {
        super(zzczVar, str, d3, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid double value for " + this.zzc + ": " + ((String) obj));
            return null;
        }
    }
}
