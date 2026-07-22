package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzfy {
    private static final zzfx zza;
    private static final zzfx zzb;

    static {
        zzfx zzfxVar;
        try {
            zzfxVar = (zzfx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzfxVar = null;
        }
        zza = zzfxVar;
        zzb = new zzfx();
    }

    static zzfx zza() {
        return zza;
    }

    static zzfx zzb() {
        return zzb;
    }
}
