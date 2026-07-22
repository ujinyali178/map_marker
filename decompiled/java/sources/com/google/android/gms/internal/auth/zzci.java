package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.g;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class zzci {
    private final g zza;

    zzci(g gVar) {
        this.zza = gVar;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        g gVar;
        if (uri != null) {
            gVar = (g) this.zza.get(uri.toString());
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(str3));
    }
}
