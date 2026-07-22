package com.google.android.gms.internal.fido;

import com.google.common.primitives.UnsignedBytes;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes.dex */
class zzbe extends zzbf {
    final zzbb zzb;

    @CheckForNull
    final Character zzc;

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    zzbe(com.google.android.gms.internal.fido.zzbb r4, @javax.annotation.CheckForNull java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L17
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzb(r2)
            if (r4 != 0) goto L15
            goto L17
        L15:
            r4 = 0
            goto L18
        L17:
            r4 = 1
        L18:
            if (r4 == 0) goto L1d
            r3.zzc = r5
            return
        L1d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Padding character %s was already in alphabet"
            java.lang.String r5 = com.google.android.gms.internal.fido.zzan.zza(r5, r1)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbe.<init>(com.google.android.gms.internal.fido.zzbb, java.lang.Character):void");
    }

    zzbe(String str, String str2, @CheckForNull Character ch) {
        this(new zzbb(str, str2.toCharArray()), ch);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (this.zzb.equals(zzbeVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzbeVar.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        return hashCode ^ (ch == null ? 0 : ch.hashCode());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                str = ".omitPadding()";
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                str = "')";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    void zza(Appendable appendable, byte[] bArr, int i3, int i4) {
        int i5 = 0;
        zzam.zze(0, i4, bArr.length);
        while (i5 < i4) {
            zzc(appendable, bArr, i5, Math.min(this.zzb.zzd, i4 - i5));
            i5 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    final int zzb(int i3) {
        zzbb zzbbVar = this.zzb;
        return zzbbVar.zzc * zzbh.zza(i3, zzbbVar.zzd, RoundingMode.CEILING);
    }

    final void zzc(Appendable appendable, byte[] bArr, int i3, int i4) {
        zzam.zze(i3, i3 + i4, bArr.length);
        int i5 = 0;
        zzam.zzc(i4 <= this.zzb.zzd);
        long j3 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            j3 = (j3 | (bArr[i3 + i6] & UnsignedBytes.MAX_VALUE)) << 8;
        }
        int i7 = ((i4 + 1) * 8) - this.zzb.zzb;
        while (i5 < i4 * 8) {
            zzbb zzbbVar = this.zzb;
            appendable.append(zzbbVar.zza(zzbbVar.zza & ((int) (j3 >>> (i7 - i5)))));
            i5 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i5 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append(Tag.KEY_VALUE_SEPARATOR);
                i5 += this.zzb.zzb;
            }
        }
    }
}
