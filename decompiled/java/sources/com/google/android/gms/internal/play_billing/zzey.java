package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class zzey extends zzdh implements RandomAccess, zzgj {
    private static final zzey zza = new zzey(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    zzey() {
        this(new int[10], 0, true);
    }

    private zzey(int[] iArr, int i3, boolean z3) {
        super(z3);
        this.zzb = iArr;
        this.zzc = i3;
    }

    private final String zzg(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzh(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i3));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i3));
        }
        int i5 = i3 + 1;
        int[] iArr = this.zzb;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i5, i4 - i3);
        } else {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.zzb, i3, iArr2, i5, this.zzc - i3);
            this.zzb = iArr2;
        }
        this.zzb[i3] = intValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Integer) obj).intValue());
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzfd.zzd;
        collection.getClass();
        if (!(collection instanceof zzey)) {
            return super.addAll(collection);
        }
        zzey zzeyVar = (zzey) collection;
        int i3 = zzeyVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.zzb;
        if (i5 > iArr.length) {
            this.zzb = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(zzeyVar.zzb, 0, this.zzb, this.zzc, zzeyVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzey)) {
            return super.equals(obj);
        }
        zzey zzeyVar = (zzey) obj;
        if (this.zzc != zzeyVar.zzc) {
            return false;
        }
        int[] iArr = zzeyVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (this.zzb[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzh(i3);
        return Integer.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            i3 = (i3 * 31) + this.zzb[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i3 = this.zzc;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzb[i4] == intValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzh(i3);
        int[] iArr = this.zzb;
        int i4 = iArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i4, iArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        zzh(i3);
        int[] iArr = this.zzb;
        int i4 = iArr[i3];
        iArr[i3] = intValue;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final /* bridge */ /* synthetic */ zzfc zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzey(Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zze(int i3) {
        zzh(i3);
        return this.zzb[i3];
    }

    public final void zzf(int i3) {
        zza();
        int i4 = this.zzc;
        int[] iArr = this.zzb;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        iArr3[i5] = i3;
    }
}
