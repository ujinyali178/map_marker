package com.google.android.gms.internal.auth;

/* loaded from: /root/release/classes.dex */
final class zzfo implements zzfv {
    private final zzfv[] zza;

    zzfo(zzfv... zzfvVarArr) {
        this.zza = zzfvVarArr;
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final zzfu zzb(Class cls) {
        zzfv[] zzfvVarArr = this.zza;
        for (int i3 = 0; i3 < 2; i3++) {
            zzfv zzfvVar = zzfvVarArr[i3];
            if (zzfvVar.zzc(cls)) {
                return zzfvVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final boolean zzc(Class cls) {
        zzfv[] zzfvVarArr = this.zza;
        for (int i3 = 0; i3 < 2; i3++) {
            if (zzfvVarArr[i3].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
