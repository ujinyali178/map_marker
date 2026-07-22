package com.google.android.gms.internal.fido;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: /root/release/classes.dex */
public abstract class zzau extends zzaq implements Set {

    @CheckForNull
    private transient zzat zza;

    zzau() {
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

    public static zzau zzi(Object obj, Object obj2) {
        return zzk(2, obj, obj2);
    }

    private static zzau zzk(int i3, Object... objArr) {
        if (i3 == 0) {
            return zzax.zza;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzay(obj);
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
            int zza = zzap.zza(hashCode);
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
            return new zzay(obj4);
        }
        if (zzf(i6) < zzf / 2) {
            return zzk(i6, objArr);
        }
        if (i6 <= 0) {
            objArr = Arrays.copyOf(objArr, i6);
        }
        return new zzax(objArr, i5, objArr2, i4, i6);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzau) && zzj() && ((zzau) obj).zzj() && hashCode() != obj.hashCode()) {
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

    @Override // com.google.android.gms.internal.fido.zzaq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzaz iterator();

    public final zzat zzg() {
        zzat zzatVar = this.zza;
        if (zzatVar != null) {
            return zzatVar;
        }
        zzat zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    zzat zzh() {
        Object[] array = toArray();
        int i3 = zzat.zzd;
        return zzat.zzg(array, array.length);
    }

    boolean zzj() {
        return false;
    }
}
