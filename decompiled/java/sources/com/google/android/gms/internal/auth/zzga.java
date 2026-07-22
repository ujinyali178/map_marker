package com.google.android.gms.internal.auth;

import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.PinConfig;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.kxml2.wap.Wbxml;
import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i3, int i4, zzfx zzfxVar, int i5, boolean z3, int[] iArr2, int i6, int i7, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i3;
        this.zzf = i4;
        this.zzh = iArr2;
        this.zzi = i6;
        this.zzj = i7;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i3, int i4) {
        zzhj.zzn(obj, zzl(i4) & 1048575, i3);
    }

    private final void zzB(Object obj, int i3, Object obj2) {
        zzb.putObject(obj, zzo(i3) & 1048575, obj2);
        zzz(obj, i3);
    }

    private final void zzC(Object obj, int i3, int i4, Object obj2) {
        zzb.putObject(obj, zzo(i4) & 1048575, obj2);
        zzA(obj, i3, i4);
    }

    private final boolean zzD(Object obj, Object obj2, int i3) {
        return zzE(obj, i3) == zzE(obj2, i3);
    }

    private final boolean zzE(Object obj, int i3) {
        int zzl = zzl(i3);
        long j3 = zzl & 1048575;
        if (j3 != 1048575) {
            return (zzhj.zzc(obj, j3) & (1 << (zzl >>> 20))) != 0;
        }
        int zzo = zzo(i3);
        long j4 = zzo & 1048575;
        switch (zzn(zzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j4)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j4)) != 0;
            case 2:
                return zzhj.zzd(obj, j4) != 0;
            case 3:
                return zzhj.zzd(obj, j4) != 0;
            case 4:
                return zzhj.zzc(obj, j4) != 0;
            case 5:
                return zzhj.zzd(obj, j4) != 0;
            case 6:
                return zzhj.zzc(obj, j4) != 0;
            case 7:
                return zzhj.zzt(obj, j4);
            case 8:
                Object zzf = zzhj.zzf(obj, j4);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzef) {
                    return !zzef.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhj.zzf(obj, j4) != null;
            case 10:
                return !zzef.zzb.equals(zzhj.zzf(obj, j4));
            case 11:
                return zzhj.zzc(obj, j4) != 0;
            case 12:
                return zzhj.zzc(obj, j4) != 0;
            case 13:
                return zzhj.zzc(obj, j4) != 0;
            case 14:
                return zzhj.zzd(obj, j4) != 0;
            case 15:
                return zzhj.zzc(obj, j4) != 0;
            case 16:
                return zzhj.zzd(obj, j4) != 0;
            case 17:
                return zzhj.zzf(obj, j4) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i3, int i4, int i5, int i6) {
        return i4 == 1048575 ? zzE(obj, i3) : (i5 & i6) != 0;
    }

    private static boolean zzG(Object obj, int i3, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i3 & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i3, int i4) {
        return zzhj.zzc(obj, (long) (zzl(i4) & 1048575)) == i3;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzd = zzha.zzd();
        zzevVar.zzc = zzd;
        return zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.auth.zzga zzj(java.lang.Class r30, com.google.android.gms.internal.auth.zzfu r31, com.google.android.gms.internal.auth.zzgc r32, com.google.android.gms.internal.auth.zzfl r33, com.google.android.gms.internal.auth.zzgz r34, com.google.android.gms.internal.auth.zzem r35, com.google.android.gms.internal.auth.zzfs r36) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzj(java.lang.Class, com.google.android.gms.internal.auth.zzfu, com.google.android.gms.internal.auth.zzgc, com.google.android.gms.internal.auth.zzfl, com.google.android.gms.internal.auth.zzgz, com.google.android.gms.internal.auth.zzem, com.google.android.gms.internal.auth.zzfs):com.google.android.gms.internal.auth.zzga");
    }

    private static int zzk(Object obj, long j3) {
        return ((Integer) zzhj.zzf(obj, j3)).intValue();
    }

    private final int zzl(int i3) {
        return this.zzc[i3 + 2];
    }

    private final int zzm(int i3, int i4) {
        int length = (this.zzc.length / 3) - 1;
        while (i4 <= length) {
            int i5 = (length + i4) >>> 1;
            int i6 = i5 * 3;
            int i7 = this.zzc[i6];
            if (i3 == i7) {
                return i6;
            }
            if (i3 < i7) {
                length = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i3) {
        return (i3 >>> 20) & 255;
    }

    private final int zzo(int i3) {
        return this.zzc[i3 + 1];
    }

    private static long zzp(Object obj, long j3) {
        return ((Long) zzhj.zzf(obj, j3)).longValue();
    }

    private final zzey zzq(int i3) {
        int i4 = i3 / 3;
        return (zzey) this.zzd[i4 + i4 + 1];
    }

    private final zzgi zzr(int i3) {
        int i4 = i3 / 3;
        int i5 = i4 + i4;
        zzgi zzgiVar = (zzgi) this.zzd[i5];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzb2 = zzgf.zza().zzb((Class) this.zzd[i5 + 1]);
        this.zzd[i5] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i3) {
        int i4 = i3 / 3;
        return this.zzd[i4 + i4];
    }

    private final Object zzt(Object obj, int i3) {
        zzgi zzr = zzr(i3);
        int zzo = zzo(i3) & 1048575;
        if (!zzE(obj, i3)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo);
        if (zzH(object)) {
            return object;
        }
        Object zzd = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd, object);
        }
        return zzd;
    }

    private final Object zzu(Object obj, int i3, int i4) {
        zzgi zzr = zzr(i4);
        if (!zzI(obj, i3, i4)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i4) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object zzd = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd, object);
        }
        return zzd;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzx(Object obj, Object obj2, int i3) {
        if (zzE(obj2, i3)) {
            int zzo = zzo(i3) & 1048575;
            Unsafe unsafe = zzb;
            long j3 = zzo;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i3] + " is present but null: " + obj2.toString());
            }
            zzgi zzr = zzr(i3);
            if (!zzE(obj, i3)) {
                if (zzH(object)) {
                    Object zzd = zzr.zzd();
                    zzr.zzf(zzd, object);
                    unsafe.putObject(obj, j3, zzd);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                zzz(obj, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!zzH(object2)) {
                Object zzd2 = zzr.zzd();
                zzr.zzf(zzd2, object2);
                unsafe.putObject(obj, j3, zzd2);
                object2 = zzd2;
            }
            zzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i3) {
        int i4 = this.zzc[i3];
        if (zzI(obj2, i4, i3)) {
            int zzo = zzo(i3) & 1048575;
            Unsafe unsafe = zzb;
            long j3 = zzo;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i3] + " is present but null: " + obj2.toString());
            }
            zzgi zzr = zzr(i3);
            if (!zzI(obj, i4, i3)) {
                if (zzH(object)) {
                    Object zzd = zzr.zzd();
                    zzr.zzf(zzd, object);
                    unsafe.putObject(obj, j3, zzd);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                zzA(obj, i4, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!zzH(object2)) {
                Object zzd2 = zzr.zzd();
                zzr.zzf(zzd2, object2);
                unsafe.putObject(obj, j3, zzd2);
                object2 = zzd2;
            }
            zzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i3) {
        int zzl = zzl(i3);
        long j3 = 1048575 & zzl;
        if (j3 == 1048575) {
            return;
        }
        zzhj.zzn(obj, j3, (1 << (zzl >>> 20)) | zzhj.zzc(obj, j3));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e1, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f9, code lost:
    
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f5, code lost:
    
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f3, code lost:
    
        if (r3 != null) goto L68;
     */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zza(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:261:0x05e4, code lost:
    
        if (r1 == 0) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x05e6, code lost:
    
        r12.add(com.google.android.gms.internal.auth.zzef.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x05f4, code lost:
    
        if (r0 >= r11) goto L685;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x05f6, code lost:
    
        r1 = com.google.android.gms.internal.auth.zzdu.zzh(r38, r0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x05fc, code lost:
    
        if (r14 != r9.zza) goto L687;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x05fe, code lost:
    
        r0 = com.google.android.gms.internal.auth.zzdu.zzh(r38, r1, r9);
        r1 = r9.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0604, code lost:
    
        if (r1 < 0) goto L596;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0608, code lost:
    
        if (r1 > (r38.length - r0)) goto L597;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x060a, code lost:
    
        if (r1 != 0) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x05ec, code lost:
    
        r12.add(com.google.android.gms.internal.auth.zzef.zzk(r38, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0611, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0616, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0617, code lost:
    
        r1 = r0;
        r12 = r5;
        r7 = r13;
        r0 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x05f4, code lost:
    
        r12.add(com.google.android.gms.internal.auth.zzef.zzk(r38, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x075b, code lost:
    
        if (r5.zzb != 0) goto L349;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x075d, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0760, code lost:
    
        r12.zze(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0763, code lost:
    
        if (r2 >= r40) goto L700;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0765, code lost:
    
        r8 = com.google.android.gms.internal.auth.zzdu.zzh(r38, r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x076b, code lost:
    
        if (r14 != r5.zza) goto L702;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x076d, code lost:
    
        r2 = com.google.android.gms.internal.auth.zzdu.zzk(r38, r8, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0775, code lost:
    
        if (r5.zzb == 0) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x075f, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0760, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0c59, code lost:
    
        if (r6 == 1048575) goto L553;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0c5b, code lost:
    
        r10.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0c5f, code lost:
    
        r3 = r0.zzi;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0c63, code lost:
    
        if (r3 >= r0.zzj) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0c65, code lost:
    
        r5 = r0.zzh[r3];
        r6 = r0.zzc[r5];
        r6 = com.google.android.gms.internal.auth.zzhj.zzf(r7, r0.zzo(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0c77, code lost:
    
        if (r6 != null) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0c7e, code lost:
    
        if (r0.zzq(r5) != null) goto L666;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0c83, code lost:
    
        r6 = (com.google.android.gms.internal.auth.zzfr) r6;
        r1 = (com.google.android.gms.internal.auth.zzfq) r0.zzs(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0c8b, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0c80, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0c8c, code lost:
    
        if (r8 != 0) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0c8e, code lost:
    
        if (r1 != r11) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0c95, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0c9a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0c96, code lost:
    
        if (r1 > r11) goto L572;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0c98, code lost:
    
        if (r4 != r8) goto L572;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0c9f, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzd();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0958  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0968  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0c06 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x06df  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0c19 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:289:0x060a -> B:281:0x05e6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:320:0x06a5 -> B:314:0x0684). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:338:0x06ef -> B:332:0x06c6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:376:0x0775 -> B:370:0x075d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzb(java.lang.Object r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.auth.zzdt r42) {
        /*
            Method dump skipped, instructions count: 3376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object obj) {
        int i3;
        if (zzH(obj)) {
            if (obj instanceof zzev) {
                zzev zzevVar = (zzev) obj;
                zzevVar.zzl(Integer.MAX_VALUE);
                zzevVar.zza = 0;
                zzevVar.zzj();
            }
            int length = this.zzc.length;
            while (i3 < length) {
                int zzo = zzo(i3);
                int i4 = 1048575 & zzo;
                int zzn = zzn(zzo);
                long j3 = i4;
                if (zzn != 9) {
                    if (zzn == 60 || zzn == 68) {
                        if (!zzI(obj, this.zzc[i3], i3)) {
                        }
                        zzr(i3).zze(zzb.getObject(obj, j3));
                    } else {
                        switch (zzn) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzk.zza(obj, j3);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j3);
                                if (object != null) {
                                    ((zzfr) object).zzc();
                                    unsafe.putObject(obj, j3, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        zzr(i3).zze(zzb.getObject(obj, j3));
                    }
                }
                i3 = zzE(obj, i3) ? 0 : i3 + 3;
                zzr(i3).zze(zzb.getObject(obj, j3));
            }
            this.zzl.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int zzo = zzo(i3);
            int i4 = this.zzc[i3];
            long j3 = 1048575 & zzo;
            switch (zzn(zzo)) {
                case 0:
                    if (zzE(obj2, i3)) {
                        zzhj.zzl(obj, j3, zzhj.zza(obj2, j3));
                        zzz(obj, i3);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzE(obj2, i3)) {
                        zzhj.zzm(obj, j3, zzhj.zzb(obj2, j3));
                        zzz(obj, i3);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzo(obj, j3, zzhj.zzd(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 3:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzo(obj, j3, zzhj.zzd(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 4:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzn(obj, j3, zzhj.zzc(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 5:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzo(obj, j3, zzhj.zzd(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 6:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzn(obj, j3, zzhj.zzc(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 7:
                    if (zzE(obj2, i3)) {
                        zzhj.zzk(obj, j3, zzhj.zzt(obj2, j3));
                        zzz(obj, i3);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzp(obj, j3, zzhj.zzf(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 9:
                case 17:
                    zzx(obj, obj2, i3);
                    break;
                case 10:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzp(obj, j3, zzhj.zzf(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 11:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzn(obj, j3, zzhj.zzc(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 12:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzn(obj, j3, zzhj.zzc(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 13:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzn(obj, j3, zzhj.zzc(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 14:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzo(obj, j3, zzhj.zzd(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 15:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzn(obj, j3, zzhj.zzc(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 16:
                    if (!zzE(obj2, i3)) {
                        break;
                    }
                    zzhj.zzo(obj, j3, zzhj.zzd(obj2, j3));
                    zzz(obj, i3);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzk.zzb(obj, obj2, j3);
                    break;
                case 50:
                    int i5 = zzgk.zza;
                    zzhj.zzp(obj, j3, zzfs.zza(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzI(obj2, i4, i3)) {
                        break;
                    }
                    zzhj.zzp(obj, j3, zzhj.zzf(obj2, j3));
                    zzA(obj, i4, i3);
                    break;
                case 60:
                case Wbxml.LITERAL_C /* 68 */:
                    zzy(obj, obj2, i3);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case Wbxml.EXT_I_2 /* 66 */:
                case Wbxml.PI /* 67 */:
                    if (!zzI(obj2, i4, i3)) {
                        break;
                    }
                    zzhj.zzp(obj, j3, zzhj.zzf(obj2, j3));
                    zzA(obj, i4, i3);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i3, int i4, zzdt zzdtVar) {
        zzb(obj, bArr, i3, i4, 0, zzdtVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        int length = this.zzc.length;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzo = zzo(i3);
            long j3 = zzo & 1048575;
            switch (zzn(zzo)) {
                case 0:
                    if (zzD(obj, obj2, i3) && Double.doubleToLongBits(zzhj.zza(obj, j3)) == Double.doubleToLongBits(zzhj.zza(obj2, j3))) {
                        break;
                    }
                    return false;
                case 1:
                    if (zzD(obj, obj2, i3) && Float.floatToIntBits(zzhj.zzb(obj, j3)) == Float.floatToIntBits(zzhj.zzb(obj2, j3))) {
                        break;
                    }
                    return false;
                case 2:
                    if (zzD(obj, obj2, i3) && zzhj.zzd(obj, j3) == zzhj.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 3:
                    if (zzD(obj, obj2, i3) && zzhj.zzd(obj, j3) == zzhj.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 4:
                    if (zzD(obj, obj2, i3) && zzhj.zzc(obj, j3) == zzhj.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 5:
                    if (zzD(obj, obj2, i3) && zzhj.zzd(obj, j3) == zzhj.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 6:
                    if (zzD(obj, obj2, i3) && zzhj.zzc(obj, j3) == zzhj.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 7:
                    if (zzD(obj, obj2, i3) && zzhj.zzt(obj, j3) == zzhj.zzt(obj2, j3)) {
                        break;
                    }
                    return false;
                case 8:
                    if (zzD(obj, obj2, i3) && zzgk.zzf(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 9:
                    if (zzD(obj, obj2, i3) && zzgk.zzf(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 10:
                    if (zzD(obj, obj2, i3) && zzgk.zzf(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 11:
                    if (zzD(obj, obj2, i3) && zzhj.zzc(obj, j3) == zzhj.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 12:
                    if (zzD(obj, obj2, i3) && zzhj.zzc(obj, j3) == zzhj.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 13:
                    if (zzD(obj, obj2, i3) && zzhj.zzc(obj, j3) == zzhj.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 14:
                    if (zzD(obj, obj2, i3) && zzhj.zzd(obj, j3) == zzhj.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 15:
                    if (zzD(obj, obj2, i3) && zzhj.zzc(obj, j3) == zzhj.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 16:
                    if (zzD(obj, obj2, i3) && zzhj.zzd(obj, j3) == zzhj.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 17:
                    if (zzD(obj, obj2, i3) && zzgk.zzf(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    if (!zzgk.zzf(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3))) {
                        return false;
                    }
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case Wbxml.EXT_I_2 /* 66 */:
                case Wbxml.PI /* 67 */:
                case Wbxml.LITERAL_C /* 68 */:
                    long zzl = zzl(i3) & 1048575;
                    if (zzhj.zzc(obj, zzl) == zzhj.zzc(obj2, zzl) && zzgk.zzf(zzhj.zzf(obj, j3), zzhj.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
            }
        }
        return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object obj) {
        int i3;
        int i4;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < this.zzi) {
            int i8 = this.zzh[i7];
            int i9 = this.zzc[i8];
            int zzo = zzo(i8);
            int i10 = this.zzc[i8 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i5) {
                if (i11 != 1048575) {
                    i6 = zzb.getInt(obj, i11);
                }
                i4 = i6;
                i3 = i11;
            } else {
                i3 = i5;
                i4 = i6;
            }
            if ((268435456 & zzo) != 0 && !zzF(obj, i8, i3, i4, i12)) {
                return false;
            }
            int zzn = zzn(zzo);
            if (zzn != 9 && zzn != 17) {
                if (zzn != 27) {
                    if (zzn == 60 || zzn == 68) {
                        if (zzI(obj, i9, i8) && !zzG(obj, zzo, zzr(i8))) {
                            return false;
                        }
                    } else if (zzn != 49) {
                        if (zzn == 50 && !((zzfr) zzhj.zzf(obj, zzo & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhj.zzf(obj, zzo & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgi zzr = zzr(i8);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zzr.zzi(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (zzF(obj, i8, i3, i4, i12) && !zzG(obj, zzo, zzr(i8))) {
                return false;
            }
            i7++;
            i5 = i3;
            i6 = i4;
        }
        return true;
    }
}
