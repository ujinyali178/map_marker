package com.google.android.gms.internal.play_billing;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.io.FilenameUtils;

/* loaded from: /root/release/classes.dex */
final class zzce extends zzby {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicLong zzb = new AtomicLong();
    private static final ConcurrentLinkedQueue zzc = new ConcurrentLinkedQueue();
    private volatile zzbf zzd;

    private zzce(String str) {
        super(str);
        String str2 = Build.FINGERPRINT;
        boolean z3 = true;
        boolean z4 = str2 == null || "robolectric".equals(str2);
        String str3 = Build.HARDWARE;
        boolean z5 = "goldfish".equals(str3) || "ranchu".equals(str3);
        String str4 = Build.TYPE;
        if (!"eng".equals(str4) && !"userdebug".equals(str4)) {
            z3 = false;
        }
        this.zzd = (z4 || z5) ? new zzbz().zza(zza()) : z3 ? zzck.zzc().zzb(false).zza(zza()) : null;
    }

    public static zzbf zzb(String str) {
        AtomicReference atomicReference = zza;
        if (atomicReference.get() != null) {
            return ((zzca) atomicReference.get()).zza(str);
        }
        zzce zzceVar = new zzce(str.replace('$', FilenameUtils.EXTENSION_SEPARATOR));
        zzcc.zza.offer(zzceVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzce zzceVar2 = (zzce) zzcc.zza.poll();
                if (zzceVar2 == null) {
                    break;
                }
                zzceVar2.zzd = ((zzca) zza.get()).zza(zzceVar2.zza());
            }
            if (((zzcd) zzc.poll()) != null) {
                zzb.getAndDecrement();
                throw null;
            }
        }
        return zzceVar;
    }
}
