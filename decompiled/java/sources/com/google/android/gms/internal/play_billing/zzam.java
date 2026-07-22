package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;

/* loaded from: /root/release/classes.dex */
final class zzam extends zzaf {
    final /* synthetic */ zzan zza;

    zzam(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        int i4;
        Object[] objArr;
        Object[] objArr2;
        i4 = this.zza.zzc;
        zzx.zza(i3, i4, "index");
        zzan zzanVar = this.zza;
        objArr = zzanVar.zzb;
        int i5 = i3 + i3;
        Object obj = objArr[i5];
        obj.getClass();
        objArr2 = zzanVar.zzb;
        Object obj2 = objArr2[i5 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i3;
        i3 = this.zza.zzc;
        return i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public final boolean zzf() {
        return true;
    }
}
