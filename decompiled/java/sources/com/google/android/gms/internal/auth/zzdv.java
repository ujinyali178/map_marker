package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class zzdv extends zzdr implements RandomAccess, zzge {
    private static final zzdv zza = new zzdv(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    zzdv() {
        this(new boolean[10], 0, true);
    }

    private zzdv(boolean[] zArr, int i3, boolean z3) {
        super(z3);
        this.zzb = zArr;
        this.zzc = i3;
    }

    private final String zzf(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzg(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
        boolean[] zArr = this.zzb;
        if (i4 < zArr.length) {
            System.arraycopy(zArr, i3, zArr, i3 + 1, i4 - i3);
        } else {
            boolean[] zArr2 = new boolean[((i4 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            System.arraycopy(this.zzb, i3, zArr2, i3 + 1, this.zzc - i3);
            this.zzb = zArr2;
        }
        this.zzb[i3] = booleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzfa.zzd;
        collection.getClass();
        if (!(collection instanceof zzdv)) {
            return super.addAll(collection);
        }
        zzdv zzdvVar = (zzdv) collection;
        int i3 = zzdvVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        boolean[] zArr = this.zzb;
        if (i5 > zArr.length) {
            this.zzb = Arrays.copyOf(zArr, i5);
        }
        System.arraycopy(zzdvVar.zzb, 0, this.zzb, this.zzc, zzdvVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdv)) {
            return super.equals(obj);
        }
        zzdv zzdvVar = (zzdv) obj;
        if (this.zzc != zzdvVar.zzc) {
            return false;
        }
        boolean[] zArr = zzdvVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (this.zzb[i3] != zArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzg(i3);
        return Boolean.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            i3 = (i3 * 31) + zzfa.zza(this.zzb[i4]);
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i3 = this.zzc;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzb[i4] == booleanValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzg(i3);
        boolean[] zArr = this.zzb;
        boolean z3 = zArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(zArr, i3 + 1, zArr, i3, (r2 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i4, zArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzg(i3);
        boolean[] zArr = this.zzb;
        boolean z3 = zArr[i3];
        zArr[i3] = booleanValue;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final /* bridge */ /* synthetic */ zzez zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzdv(Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z3) {
        zza();
        int i3 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i3 == zArr.length) {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        zArr3[i4] = z3;
    }
}
