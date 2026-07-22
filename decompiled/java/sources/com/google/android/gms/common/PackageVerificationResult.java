package com.google.android.gms.common;

import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i3, boolean z3, @Nullable String str2, @Nullable Throwable th) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = str2;
        this.zzd = th;
    }

    public static PackageVerificationResult zza(String str, String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    public static PackageVerificationResult zzd(String str, int i3) {
        return new PackageVerificationResult(str, i3, true, null, null);
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        String valueOf = String.valueOf(this.zzc);
        Throwable th = this.zzd;
        String concat = "PackageVerificationRslt: ".concat(valueOf);
        if (th == null) {
            throw new SecurityException(concat);
        }
        throw new SecurityException(concat, th);
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
