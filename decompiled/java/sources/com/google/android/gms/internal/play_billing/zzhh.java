package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class zzhh implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzhi zzb;

    zzhh(zzhi zzhiVar) {
        zzfk zzfkVar;
        this.zzb = zzhiVar;
        zzfkVar = zzhiVar.zza;
        this.zza = zzfkVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
