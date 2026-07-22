package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzet;
import com.google.android.gms.internal.play_billing.zzex;

/* loaded from: /root/release/classes.dex */
public class zzet<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdf<MessageType, BuilderType> {
    protected zzex zza;
    private final zzex zzb;

    protected zzet(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzt()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzi();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzet clone() {
        zzet zzetVar = (zzet) this.zzb.zzu(5, null, null);
        zzetVar.zza = zze();
        return zzetVar;
    }

    public final MessageType zzc() {
        MessageType zze = zze();
        if (zze.zzs()) {
            return zze;
        }
        throw new zzhc(zze);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgb
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public MessageType zze() {
        if (!this.zza.zzt()) {
            return (MessageType) this.zza;
        }
        this.zza.zzn();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgd
    public final /* bridge */ /* synthetic */ zzgc zzf() {
        throw null;
    }

    protected final void zzg() {
        if (this.zza.zzt()) {
            return;
        }
        zzh();
    }

    protected void zzh() {
        zzex zzi = this.zzb.zzi();
        zzgk.zza().zzb(zzi.getClass()).zzg(zzi, this.zza);
        this.zza = zzi;
    }
}
