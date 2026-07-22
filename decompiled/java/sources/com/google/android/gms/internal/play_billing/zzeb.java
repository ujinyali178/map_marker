package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzeb extends zzee {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    zzeb(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzb(byte b4) {
        try {
            byte[] bArr = this.zzc;
            int i3 = this.zze;
            this.zze = i3 + 1;
            bArr[i3] = b4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e3);
        }
    }

    public final void zzc(byte[] bArr, int i3, int i4) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i4);
            this.zze += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i4)), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzd(int i3, boolean z3) {
        zzq(i3 << 3);
        zzb(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zze(int i3, zzdw zzdwVar) {
        zzq((i3 << 3) | 2);
        zzq(zzdwVar.zzd());
        zzdwVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzf(int i3, int i4) {
        zzq((i3 << 3) | 5);
        zzg(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzg(int i3) {
        try {
            byte[] bArr = this.zzc;
            int i4 = this.zze;
            int i5 = i4 + 1;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.zze = i7 + 1;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzh(int i3, long j3) {
        zzq((i3 << 3) | 1);
        zzi(j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzi(long j3) {
        try {
            byte[] bArr = this.zzc;
            int i3 = this.zze;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((int) j3) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.zze = i10 + 1;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzj(int i3, int i4) {
        zzq(i3 << 3);
        zzk(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzk(int i3) {
        if (i3 >= 0) {
            zzq(i3);
        } else {
            zzs(i3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzl(byte[] bArr, int i3, int i4) {
        zzc(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzm(int i3, String str) {
        zzq((i3 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) {
        int i3 = this.zze;
        try {
            int zzx = zzee.zzx(str.length() * 3);
            int zzx2 = zzee.zzx(str.length());
            if (zzx2 != zzx) {
                zzq(zzhs.zzc(str));
                byte[] bArr = this.zzc;
                int i4 = this.zze;
                this.zze = zzhs.zzb(str, bArr, i4, this.zzd - i4);
                return;
            }
            int i5 = i3 + zzx2;
            this.zze = i5;
            int zzb = zzhs.zzb(str, this.zzc, i5, this.zzd - i5);
            this.zze = i3;
            zzq((zzb - i3) - zzx2);
            this.zze = zzb;
        } catch (zzhr e3) {
            this.zze = i3;
            zzB(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzec(e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzo(int i3, int i4) {
        zzq((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzp(int i3, int i4) {
        zzq(i3 << 3);
        zzq(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzq(int i3) {
        while ((i3 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzc;
                int i4 = this.zze;
                this.zze = i4 + 1;
                bArr[i4] = (byte) ((i3 & 127) | 128);
                i3 >>>= 7;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzec(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e3);
            }
        }
        byte[] bArr2 = this.zzc;
        int i5 = this.zze;
        this.zze = i5 + 1;
        bArr2[i5] = (byte) i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzr(int i3, long j3) {
        zzq(i3 << 3);
        zzs(j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzee
    public final void zzs(long j3) {
        boolean z3;
        z3 = zzee.zzd;
        if (!z3 || this.zzd - this.zze < 10) {
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzc;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) & 127) | 128);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new zzec(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e3);
                }
            }
            byte[] bArr2 = this.zzc;
            int i4 = this.zze;
            this.zze = i4 + 1;
            bArr2[i4] = (byte) j3;
            return;
        }
        while (true) {
            int i5 = (int) j3;
            if ((j3 & (-128)) == 0) {
                byte[] bArr3 = this.zzc;
                int i6 = this.zze;
                this.zze = i6 + 1;
                zzhn.zzn(bArr3, i6, (byte) i5);
                return;
            }
            byte[] bArr4 = this.zzc;
            int i7 = this.zze;
            this.zze = i7 + 1;
            zzhn.zzn(bArr4, i7, (byte) ((i5 & 127) | 128));
            j3 >>>= 7;
        }
    }
}
