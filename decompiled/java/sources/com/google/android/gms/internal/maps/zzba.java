package com.google.android.gms.internal.maps;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: /root/release/classes.dex */
public abstract class zzba extends zzaw implements Set {

    @CheckForNull
    private transient zzaz zza;

    zzba() {
    }

    static int zzf(int i3) {
        int max = Math.max(i3, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return Ints.MAX_POWER_OF_TWO;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
        } while (highestOneBit * 0.7d < max);
        return highestOneBit;
    }

    @SafeVarargs
    public static zzba zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = {"ADMINISTRATIVE_AREA_LEVEL_1", "ADMINISTRATIVE_AREA_LEVEL_2", "COUNTRY", "LOCALITY", "POSTAL_CODE", "SCHOOL_DISTRICT"};
        System.arraycopy(objArr, 0, objArr2, 6, 0);
        return zzk(6, objArr2);
    }

    private static zzba zzk(int i3, Object... objArr) {
        if (i3 == 0) {
            return zzbd.zza;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzbe(obj);
        }
        int zzf = zzf(i3);
        Object[] objArr2 = new Object[zzf];
        int i4 = zzf - 1;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            Object obj2 = objArr[i7];
            if (obj2 == null) {
                throw new NullPointerException("at index " + i7);
            }
            int hashCode = obj2.hashCode();
            int zza = zzav.zza(hashCode);
            while (true) {
                int i8 = zza & i4;
                Object obj3 = objArr2[i8];
                if (obj3 == null) {
                    objArr[i6] = obj2;
                    objArr2[i8] = obj2;
                    i5 += hashCode;
                    i6++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    zza++;
                }
            }
        }
        Arrays.fill(objArr, i6, i3, (Object) null);
        if (i6 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzbe(obj4);
        }
        if (zzf(i6) < zzf / 2) {
            return zzk(i6, objArr);
        }
        if (i6 < 4) {
            objArr = Arrays.copyOf(objArr, i6);
        }
        return new zzbd(objArr, i5, objArr2, i4, i6);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzba) && zzj() && ((zzba) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 += next != null ? next.hashCode() : 0;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzbf iterator();

    public final zzaz zzg() {
        zzaz zzazVar = this.zza;
        if (zzazVar != null) {
            return zzazVar;
        }
        zzaz zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    zzaz zzh() {
        Object[] array = toArray();
        int i3 = zzaz.zzd;
        return zzaz.zzg(array, array.length);
    }

    boolean zzj() {
        return false;
    }
}
