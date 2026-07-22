package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
public final class zzfj extends zzdh implements RandomAccess, zzfk {

    @Deprecated
    public static final zzfk zza;
    private static final zzfj zzb;
    private final List zzc;

    static {
        zzfj zzfjVar = new zzfj(false);
        zzb = zzfjVar;
        zza = zzfjVar;
    }

    public zzfj() {
        this(10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfj(int i3) {
        super(true);
        ArrayList arrayList = new ArrayList(i3);
        this.zzc = arrayList;
    }

    private zzfj(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzfj(boolean z3) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    private static String zzi(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzdw ? ((zzdw) obj).zzm(zzfd.zzb) : zzfd.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i3, Object obj) {
        zza();
        this.zzc.add(i3, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final boolean addAll(int i3, Collection collection) {
        zza();
        if (collection instanceof zzfk) {
            collection = ((zzfk) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i3, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        Object remove = this.zzc.remove(i3);
        ((AbstractList) this).modCount++;
        return zzi(remove);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        zza();
        return zzi(this.zzc.set(i3, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final /* bridge */ /* synthetic */ zzfc zzd(int i3) {
        if (i3 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i3);
        arrayList.addAll(this.zzc);
        return new zzfj(arrayList);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfk
    public final zzfk zze() {
        return zzc() ? new zzhi(this) : this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfk
    public final Object zzf(int i3) {
        return this.zzc.get(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i3) {
        Object obj = this.zzc.get(i3);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdw) {
            zzdw zzdwVar = (zzdw) obj;
            String zzm = zzdwVar.zzm(zzfd.zzb);
            if (zzdwVar.zzi()) {
                this.zzc.set(i3, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzfd.zzd(bArr);
        if (zzhs.zzd(bArr)) {
            this.zzc.set(i3, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfk
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }
}
