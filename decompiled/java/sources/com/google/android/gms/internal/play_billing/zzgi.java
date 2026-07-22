package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzgi {
    private static final zzgh zza;
    private static final zzgh zzb;

    static {
        zzgh zzghVar;
        try {
            zzghVar = (zzgh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzghVar = null;
        }
        zza = zzghVar;
        zzb = new zzgh();
    }

    static zzgh zza() {
        return zza;
    }

    static zzgh zzb() {
        return zzb;
    }
}
