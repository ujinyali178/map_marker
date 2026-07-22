package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;

/* loaded from: /root/release/classes.dex */
final class zzfh extends zzfl {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfh() {
        super(null);
    }

    /* synthetic */ zzfh(zzfg zzfgVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zza(Object obj, long j3) {
        Object unmodifiableList;
        List list = (List) zzhj.zzf(obj, j3);
        if (list instanceof zzff) {
            unmodifiableList = ((zzff) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzge) && (list instanceof zzez)) {
                zzez zzezVar = (zzez) list;
                if (zzezVar.zzc()) {
                    zzezVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzhj.zzp(obj, j3, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0094 A[ADDED_TO_REGION] */
    @Override // com.google.android.gms.internal.auth.zzfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzb(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = com.google.android.gms.internal.auth.zzhj.zzf(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzhj.zzf(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L39
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzff
            if (r2 == 0) goto L20
            com.google.android.gms.internal.auth.zzfe r1 = new com.google.android.gms.internal.auth.zzfe
            r1.<init>(r0)
            goto L35
        L20:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzge
            if (r2 == 0) goto L30
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzez
            if (r2 == 0) goto L30
            com.google.android.gms.internal.auth.zzez r1 = (com.google.android.gms.internal.auth.zzez) r1
            com.google.android.gms.internal.auth.zzez r0 = r1.zzd(r0)
            r1 = r0
            goto L35
        L30:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L35:
            com.google.android.gms.internal.auth.zzhj.zzp(r5, r7, r1)
            goto L8a
        L39:
            java.lang.Class r2 = com.google.android.gms.internal.auth.zzfh.zza
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L57
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
        L52:
            com.google.android.gms.internal.auth.zzhj.zzp(r5, r7, r2)
            r1 = r2
            goto L8a
        L57:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzhe
            if (r2 == 0) goto L6f
            com.google.android.gms.internal.auth.zzfe r2 = new com.google.android.gms.internal.auth.zzfe
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            com.google.android.gms.internal.auth.zzhe r1 = (com.google.android.gms.internal.auth.zzhe) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
            goto L52
        L6f:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzge
            if (r2 == 0) goto L8a
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzez
            if (r2 == 0) goto L8a
            r2 = r1
            com.google.android.gms.internal.auth.zzez r2 = (com.google.android.gms.internal.auth.zzez) r2
            boolean r3 = r2.zzc()
            if (r3 != 0) goto L8a
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.auth.zzez r1 = r2.zzd(r1)
            goto L35
        L8a:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L99
            if (r2 <= 0) goto L99
            r1.addAll(r6)
        L99:
            if (r0 > 0) goto L9c
            goto L9d
        L9c:
            r6 = r1
        L9d:
            com.google.android.gms.internal.auth.zzhj.zzp(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfh.zzb(java.lang.Object, java.lang.Object, long):void");
    }
}
