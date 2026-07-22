package com.google.android.gms.internal.play_billing;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

/* loaded from: /root/release/classes.dex */
final class zzdo implements Comparator {
    zzdo() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdw zzdwVar = (zzdw) obj;
        zzdw zzdwVar2 = (zzdw) obj2;
        zzdn zzdnVar = new zzdn(zzdwVar);
        zzdn zzdnVar2 = new zzdn(zzdwVar2);
        while (zzdnVar.hasNext() && zzdnVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzdnVar.zza() & UnsignedBytes.MAX_VALUE).compareTo(Integer.valueOf(zzdnVar2.zza() & UnsignedBytes.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzdwVar.zzd()).compareTo(Integer.valueOf(zzdwVar2.zzd()));
    }
}
