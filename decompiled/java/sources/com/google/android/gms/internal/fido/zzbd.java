package com.google.android.gms.internal.fido;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: /root/release/classes.dex */
final class zzbd extends zzbe {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    zzbd(java.lang.String r2, java.lang.String r3, @javax.annotation.CheckForNull java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.gms.internal.fido.zzbb r0 = new com.google.android.gms.internal.fido.zzbb
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = com.google.android.gms.internal.fido.zzbb.zzc(r0)
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            com.google.android.gms.internal.fido.zzam.zzc(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbd.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    @Override // com.google.android.gms.internal.fido.zzbe, com.google.android.gms.internal.fido.zzbf
    final void zza(Appendable appendable, byte[] bArr, int i3, int i4) {
        int i5 = 0;
        zzam.zze(0, i4, bArr.length);
        for (int i6 = i4; i6 >= 3; i6 -= 3) {
            int i7 = i5 + 1;
            int i8 = bArr[i5] & UnsignedBytes.MAX_VALUE;
            int i9 = bArr[i7] & UnsignedBytes.MAX_VALUE;
            int i10 = i7 + 1;
            int i11 = (i8 << 16) | (i9 << 8) | (bArr[i10] & UnsignedBytes.MAX_VALUE);
            appendable.append(this.zzb.zza(i11 >>> 18));
            appendable.append(this.zzb.zza((i11 >>> 12) & 63));
            appendable.append(this.zzb.zza((i11 >>> 6) & 63));
            appendable.append(this.zzb.zza(i11 & 63));
            i5 = i10 + 1;
        }
        if (i5 < i4) {
            zzc(appendable, bArr, i5, i4 - i5);
        }
    }
}
