package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzdf;
import com.google.android.gms.internal.play_billing.zzdg;
import java.io.IOException;

/* loaded from: /root/release/classes.dex */
public abstract class zzdg<MessageType extends zzdg<MessageType, BuilderType>, BuilderType extends zzdf<MessageType, BuilderType>> implements zzgc {
    protected int zza = 0;

    int zza(zzgm zzgmVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final zzdw zzb() {
        try {
            int zze = zze();
            zzdw zzdwVar = zzdw.zzb;
            byte[] bArr = new byte[zze];
            zzee zzz = zzee.zzz(bArr, 0, zze);
            zzr(zzz);
            zzz.zzA();
            return new zzdt(bArr);
        } catch (IOException e3) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e3);
        }
    }

    public final byte[] zzc() {
        try {
            int zze = zze();
            byte[] bArr = new byte[zze];
            zzee zzz = zzee.zzz(bArr, 0, zze);
            zzr(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e3) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e3);
        }
    }
}
