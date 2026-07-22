package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
final class zzgr implements Iterator {
    final /* synthetic */ zzgv zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzgr(zzgv zzgvVar, zzgq zzgqVar) {
        this.zza = zzgvVar;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i3 = this.zzb + 1;
        list = this.zza.zzb;
        if (i3 < list.size()) {
            return true;
        }
        map = this.zza.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        List list;
        Object next;
        List list2;
        this.zzc = true;
        int i3 = this.zzb + 1;
        this.zzb = i3;
        list = this.zza.zzb;
        if (i3 < list.size()) {
            list2 = this.zza.zzb;
            next = list2.get(this.zzb);
        } else {
            next = zza().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        int i3 = this.zzb;
        list = this.zza.zzb;
        if (i3 >= list.size()) {
            zza().remove();
            return;
        }
        zzgv zzgvVar = this.zza;
        int i4 = this.zzb;
        this.zzb = i4 - 1;
        zzgvVar.zzl(i4);
    }
}
