package com.google.android.gms.internal.play_billing;

import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.PinConfig;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.kxml2.wap.Wbxml;
import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
final class zzgf<T> implements zzgm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgc zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfq zzl;
    private final zzhd zzm;
    private final zzek zzn;
    private final zzgh zzo;
    private final zzfx zzp;

    private zzgf(int[] iArr, Object[] objArr, int i3, int i4, zzgc zzgcVar, int i5, boolean z3, int[] iArr2, int i6, int i7, zzgh zzghVar, zzfq zzfqVar, zzhd zzhdVar, zzek zzekVar, zzfx zzfxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i3;
        this.zzf = i4;
        boolean z4 = false;
        if (zzekVar != null && zzekVar.zzc(zzgcVar)) {
            z4 = true;
        }
        this.zzh = z4;
        this.zzi = iArr2;
        this.zzj = i6;
        this.zzk = i7;
        this.zzo = zzghVar;
        this.zzl = zzfqVar;
        this.zzm = zzhdVar;
        this.zzn = zzekVar;
        this.zzg = zzgcVar;
        this.zzp = zzfxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i3) {
        if (zzI(obj2, i3)) {
            int zzs = zzs(i3) & 1048575;
            Unsafe unsafe = zzb;
            long j3 = zzs;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i3] + " is present but null: " + obj2.toString());
            }
            zzgm zzv = zzv(i3);
            if (!zzI(obj, i3)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j3, zze);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                zzD(obj, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j3, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i3) {
        int i4 = this.zzc[i3];
        if (zzM(obj2, i4, i3)) {
            int zzs = zzs(i3) & 1048575;
            Unsafe unsafe = zzb;
            long j3 = zzs;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i3] + " is present but null: " + obj2.toString());
            }
            zzgm zzv = zzv(i3);
            if (!zzM(obj, i4, i3)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j3, zze);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                zzE(obj, i4, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j3, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i3) {
        int zzp = zzp(i3);
        long j3 = 1048575 & zzp;
        if (j3 == 1048575) {
            return;
        }
        zzhn.zzq(obj, j3, (1 << (zzp >>> 20)) | zzhn.zzc(obj, j3));
    }

    private final void zzE(Object obj, int i3, int i4) {
        zzhn.zzq(obj, zzp(i4) & 1048575, i3);
    }

    private final void zzF(Object obj, int i3, Object obj2) {
        zzb.putObject(obj, zzs(i3) & 1048575, obj2);
        zzD(obj, i3);
    }

    private final void zzG(Object obj, int i3, int i4, Object obj2) {
        zzb.putObject(obj, zzs(i4) & 1048575, obj2);
        zzE(obj, i3, i4);
    }

    private final boolean zzH(Object obj, Object obj2, int i3) {
        return zzI(obj, i3) == zzI(obj2, i3);
    }

    private final boolean zzI(Object obj, int i3) {
        int zzp = zzp(i3);
        long j3 = zzp & 1048575;
        if (j3 != 1048575) {
            return (zzhn.zzc(obj, j3) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i3);
        long j4 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzhn.zza(obj, j4)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhn.zzb(obj, j4)) != 0;
            case 2:
                return zzhn.zzd(obj, j4) != 0;
            case 3:
                return zzhn.zzd(obj, j4) != 0;
            case 4:
                return zzhn.zzc(obj, j4) != 0;
            case 5:
                return zzhn.zzd(obj, j4) != 0;
            case 6:
                return zzhn.zzc(obj, j4) != 0;
            case 7:
                return zzhn.zzw(obj, j4);
            case 8:
                Object zzf = zzhn.zzf(obj, j4);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzdw) {
                    return !zzdw.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhn.zzf(obj, j4) != null;
            case 10:
                return !zzdw.zzb.equals(zzhn.zzf(obj, j4));
            case 11:
                return zzhn.zzc(obj, j4) != 0;
            case 12:
                return zzhn.zzc(obj, j4) != 0;
            case 13:
                return zzhn.zzc(obj, j4) != 0;
            case 14:
                return zzhn.zzd(obj, j4) != 0;
            case 15:
                return zzhn.zzc(obj, j4) != 0;
            case 16:
                return zzhn.zzd(obj, j4) != 0;
            case 17:
                return zzhn.zzf(obj, j4) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i3, int i4, int i5, int i6) {
        return i4 == 1048575 ? zzI(obj, i3) : (i5 & i6) != 0;
    }

    private static boolean zzK(Object obj, int i3, zzgm zzgmVar) {
        return zzgmVar.zzk(zzhn.zzf(obj, i3 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzex) {
            return ((zzex) obj).zzt();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i3, int i4) {
        return zzhn.zzc(obj, (long) (zzp(i4) & 1048575)) == i3;
    }

    private static boolean zzN(Object obj, long j3) {
        return ((Boolean) zzhn.zzf(obj, j3)).booleanValue();
    }

    private static final void zzO(int i3, Object obj, zzhv zzhvVar) {
        if (obj instanceof String) {
            zzhvVar.zzF(i3, (String) obj);
        } else {
            zzhvVar.zzd(i3, (zzdw) obj);
        }
    }

    static zzhe zzd(Object obj) {
        zzex zzexVar = (zzex) obj;
        zzhe zzheVar = zzexVar.zzc;
        if (zzheVar != zzhe.zzc()) {
            return zzheVar;
        }
        zzhe zzf = zzhe.zzf();
        zzexVar.zzc = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0267  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.play_billing.zzgf zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzfz r34, com.google.android.gms.internal.play_billing.zzgh r35, com.google.android.gms.internal.play_billing.zzfq r36, com.google.android.gms.internal.play_billing.zzhd r37, com.google.android.gms.internal.play_billing.zzek r38, com.google.android.gms.internal.play_billing.zzfx r39) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzfz, com.google.android.gms.internal.play_billing.zzgh, com.google.android.gms.internal.play_billing.zzfq, com.google.android.gms.internal.play_billing.zzhd, com.google.android.gms.internal.play_billing.zzek, com.google.android.gms.internal.play_billing.zzfx):com.google.android.gms.internal.play_billing.zzgf");
    }

    private static double zzm(Object obj, long j3) {
        return ((Double) zzhn.zzf(obj, j3)).doubleValue();
    }

    private static float zzn(Object obj, long j3) {
        return ((Float) zzhn.zzf(obj, j3)).floatValue();
    }

    private static int zzo(Object obj, long j3) {
        return ((Integer) zzhn.zzf(obj, j3)).intValue();
    }

    private final int zzp(int i3) {
        return this.zzc[i3 + 2];
    }

    private final int zzq(int i3, int i4) {
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

    private static int zzr(int i3) {
        return (i3 >>> 20) & 255;
    }

    private final int zzs(int i3) {
        return this.zzc[i3 + 1];
    }

    private static long zzt(Object obj, long j3) {
        return ((Long) zzhn.zzf(obj, j3)).longValue();
    }

    private final zzfb zzu(int i3) {
        int i4 = i3 / 3;
        return (zzfb) this.zzd[i4 + i4 + 1];
    }

    private final zzgm zzv(int i3) {
        Object[] objArr = this.zzd;
        int i4 = i3 / 3;
        int i5 = i4 + i4;
        zzgm zzgmVar = (zzgm) objArr[i5];
        if (zzgmVar != null) {
            return zzgmVar;
        }
        zzgm zzb2 = zzgk.zza().zzb((Class) objArr[i5 + 1]);
        this.zzd[i5] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i3) {
        int i4 = i3 / 3;
        return this.zzd[i4 + i4];
    }

    private final Object zzx(Object obj, int i3) {
        zzgm zzv = zzv(i3);
        int zzs = zzs(i3) & 1048575;
        if (!zzI(obj, i3)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i3, int i4) {
        zzgm zzv = zzv(i4);
        if (!zzM(obj, i3, i4)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i4) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Code restructure failed: missing block: B:277:0x0507, code lost:
    
        if ((r1 instanceof com.google.android.gms.internal.play_billing.zzdw) != false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d1, code lost:
    
        if ((r1 instanceof com.google.android.gms.internal.play_billing.zzdw) != false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x050a, code lost:
    
        r1 = com.google.android.gms.internal.play_billing.zzee.zzw((java.lang.String) r1);
     */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zza(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00cc, code lost:
    
        if (r2 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:
    
        r1 = r1 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e2, code lost:
    
        r6 = r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e0, code lost:
    
        if (r2 != null) goto L68;
     */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzb(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:278:0x0622, code lost:
    
        if (r1 == 0) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0624, code lost:
    
        r13.add(com.google.android.gms.internal.play_billing.zzdw.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0632, code lost:
    
        if (r0 >= r8) goto L696;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0634, code lost:
    
        r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r37, r0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x063a, code lost:
    
        if (r14 != r10.zza) goto L698;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x063c, code lost:
    
        r0 = com.google.android.gms.internal.play_billing.zzdk.zzh(r37, r1, r10);
        r1 = r10.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0642, code lost:
    
        if (r1 < 0) goto L603;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0646, code lost:
    
        if (r1 > (r37.length - r0)) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0648, code lost:
    
        if (r1 != 0) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x062a, code lost:
    
        r13.add(com.google.android.gms.internal.play_billing.zzdw.zzl(r37, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x064f, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzff.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0654, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzff.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0655, code lost:
    
        r1 = r0;
        r7 = r14;
        r0 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0632, code lost:
    
        r13.add(com.google.android.gms.internal.play_billing.zzdw.zzl(r37, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x07a0, code lost:
    
        if (r3.zzb != 0) goto L349;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x07a2, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x07a5, code lost:
    
        r13.zze(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x07a8, code lost:
    
        if (r2 >= r6) goto L712;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x07aa, code lost:
    
        r8 = com.google.android.gms.internal.play_billing.zzdk.zzh(r37, r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x07b0, code lost:
    
        if (r7 != r3.zza) goto L711;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x07b2, code lost:
    
        r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r37, r8, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x07ba, code lost:
    
        if (r3.zzb == 0) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x07a4, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x07a5, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0c3e, code lost:
    
        if (r6 == 1048575) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0c40, code lost:
    
        r33.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0c46, code lost:
    
        r2 = r0.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0c4a, code lost:
    
        if (r2 >= r0.zzk) goto L677;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0c4c, code lost:
    
        r3 = r0.zzi;
        r5 = r0.zzc;
        r3 = r3[r2];
        r5 = r5[r3];
        r5 = com.google.android.gms.internal.play_billing.zzhn.zzf(r7, r0.zzs(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0c5e, code lost:
    
        if (r5 != null) goto L565;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0c65, code lost:
    
        if (r0.zzu(r3) != null) goto L676;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0c6a, code lost:
    
        r5 = (com.google.android.gms.internal.play_billing.zzfw) r5;
        r1 = (com.google.android.gms.internal.play_billing.zzfv) r0.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0c72, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0c67, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0c75, code lost:
    
        if (r8 != 0) goto L576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0c77, code lost:
    
        if (r1 != r39) goto L574;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0c7e, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzff.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0c83, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0c7f, code lost:
    
        if (r1 > r39) goto L579;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0c81, code lost:
    
        if (r4 != r8) goto L579;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0c88, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzff.zze();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x09aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x09bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0bc5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0bd7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:715:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:302:0x0648 -> B:294:0x0624). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:331:0x06e6 -> B:325:0x06c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:349:0x0730 -> B:343:0x0707). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:387:0x07ba -> B:381:0x07a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.play_billing.zzdj r41) {
        /*
            Method dump skipped, instructions count: 3354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdj):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final Object zze() {
        return ((zzex) this.zzg).zzi();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzf(Object obj) {
        int i3;
        if (zzL(obj)) {
            if (obj instanceof zzex) {
                zzex zzexVar = (zzex) obj;
                zzexVar.zzq(Integer.MAX_VALUE);
                zzexVar.zza = 0;
                zzexVar.zzo();
            }
            int[] iArr = this.zzc;
            while (i3 < iArr.length) {
                int zzs = zzs(i3);
                int i4 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j3 = i4;
                if (zzr != 9) {
                    if (zzr == 60 || zzr == 68) {
                        if (!zzM(obj, this.zzc[i3], i3)) {
                        }
                        zzv(i3).zzf(zzb.getObject(obj, j3));
                    } else {
                        switch (zzr) {
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
                                this.zzl.zza(obj, j3);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j3);
                                if (object != null) {
                                    ((zzfw) object).zzc();
                                    unsafe.putObject(obj, j3, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        zzv(i3).zzf(zzb.getObject(obj, j3));
                    }
                }
                i3 = zzI(obj, i3) ? 0 : i3 + 3;
                zzv(i3).zzf(zzb.getObject(obj, j3));
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int zzs = zzs(i3);
            int i4 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i5 = iArr[i3];
            long j3 = i4;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i3)) {
                        zzhn.zzo(obj, j3, zzhn.zza(obj2, j3));
                        zzD(obj, i3);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i3)) {
                        zzhn.zzp(obj, j3, zzhn.zzb(obj2, j3));
                        zzD(obj, i3);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzr(obj, j3, zzhn.zzd(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 3:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzr(obj, j3, zzhn.zzd(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 4:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzq(obj, j3, zzhn.zzc(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 5:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzr(obj, j3, zzhn.zzd(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 6:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzq(obj, j3, zzhn.zzc(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 7:
                    if (zzI(obj2, i3)) {
                        zzhn.zzm(obj, j3, zzhn.zzw(obj2, j3));
                        zzD(obj, i3);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzs(obj, j3, zzhn.zzf(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 9:
                case 17:
                    zzB(obj, obj2, i3);
                    break;
                case 10:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzs(obj, j3, zzhn.zzf(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 11:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzq(obj, j3, zzhn.zzc(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 12:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzq(obj, j3, zzhn.zzc(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 13:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzq(obj, j3, zzhn.zzc(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 14:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzr(obj, j3, zzhn.zzd(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 15:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzq(obj, j3, zzhn.zzc(obj2, j3));
                    zzD(obj, i3);
                    break;
                case 16:
                    if (!zzI(obj2, i3)) {
                        break;
                    }
                    zzhn.zzr(obj, j3, zzhn.zzd(obj2, j3));
                    zzD(obj, i3);
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
                    this.zzl.zzb(obj, obj2, j3);
                    break;
                case 50:
                    int i6 = zzgo.zza;
                    zzhn.zzs(obj, j3, zzfx.zza(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3)));
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
                    if (!zzM(obj2, i5, i3)) {
                        break;
                    }
                    zzhn.zzs(obj, j3, zzhn.zzf(obj2, j3));
                    zzE(obj, i5, i3);
                    break;
                case 60:
                case Wbxml.LITERAL_C /* 68 */:
                    zzC(obj, obj2, i3);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case Wbxml.EXT_I_2 /* 66 */:
                case Wbxml.PI /* 67 */:
                    if (!zzM(obj2, i5, i3)) {
                        break;
                    }
                    zzhn.zzs(obj, j3, zzhn.zzf(obj2, j3));
                    zzE(obj, i5, i3);
                    break;
            }
        }
        zzgo.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzh(Object obj, byte[] bArr, int i3, int i4, zzdj zzdjVar) {
        zzc(obj, bArr, i3, i4, 0, zzdjVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzi(Object obj, zzhv zzhvVar) {
        int i3;
        int i4;
        int i5;
        double zza2;
        float zzb2;
        long j3;
        long j4;
        int i6;
        long j5;
        int i7;
        boolean zzw;
        Object object;
        Object object2;
        Object object3;
        int i8;
        int i9;
        int i10;
        long j6;
        int i11;
        long j7;
        Object object4;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        List list;
        if (this.zzh) {
            this.zzn.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i20 = 1048575;
        int i21 = 1048575;
        int i22 = 0;
        int i23 = 0;
        while (i23 < iArr.length) {
            int zzs = zzs(i23);
            int[] iArr2 = this.zzc;
            int zzr = zzr(zzs);
            int i24 = iArr2[i23];
            boolean z3 = true;
            if (zzr <= 17) {
                int i25 = iArr2[i23 + 2];
                int i26 = i25 & i20;
                if (i26 != i21) {
                    i22 = i26 == i20 ? 0 : unsafe.getInt(obj, i26);
                    i21 = i26;
                }
                i3 = i21;
                i4 = i22;
                i5 = 1 << (i25 >>> 20);
            } else {
                i3 = i21;
                i4 = i22;
                i5 = 0;
            }
            long j8 = zzs & i20;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        zza2 = zzhn.zza(obj, j8);
                        zzhvVar.zzf(i24, zza2);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 1:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        zzb2 = zzhn.zzb(obj, j8);
                        zzhvVar.zzo(i24, zzb2);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 2:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        j3 = unsafe.getLong(obj, j8);
                        zzhvVar.zzt(i24, j3);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 3:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        j4 = unsafe.getLong(obj, j8);
                        zzhvVar.zzJ(i24, j4);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 4:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        i6 = unsafe.getInt(obj, j8);
                        zzhvVar.zzr(i24, i6);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 5:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        j5 = unsafe.getLong(obj, j8);
                        zzhvVar.zzm(i24, j5);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 6:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        i7 = unsafe.getInt(obj, j8);
                        zzhvVar.zzk(i24, i7);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 7:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        zzw = zzhn.zzw(obj, j8);
                        zzhvVar.zzb(i24, zzw);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 8:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        object = unsafe.getObject(obj, j8);
                        zzO(i24, object, zzhvVar);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 9:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        object2 = unsafe.getObject(obj, j8);
                        zzhvVar.zzv(i24, object2, zzv(i23));
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 10:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        object3 = unsafe.getObject(obj, j8);
                        zzhvVar.zzd(i24, (zzdw) object3);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 11:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        i8 = unsafe.getInt(obj, j8);
                        zzhvVar.zzH(i24, i8);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 12:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        i9 = unsafe.getInt(obj, j8);
                        zzhvVar.zzi(i24, i9);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 13:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        i10 = unsafe.getInt(obj, j8);
                        zzhvVar.zzw(i24, i10);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 14:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        j6 = unsafe.getLong(obj, j8);
                        zzhvVar.zzy(i24, j6);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 15:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        i11 = unsafe.getInt(obj, j8);
                        zzhvVar.zzA(i24, i11);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 16:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        j7 = unsafe.getLong(obj, j8);
                        zzhvVar.zzC(i24, j7);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 17:
                    if (zzJ(obj, i23, i3, i4, i5)) {
                        object4 = unsafe.getObject(obj, j8);
                        zzhvVar.zzq(i24, object4, zzv(i23));
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 18:
                    z3 = false;
                    i12 = this.zzc[i23];
                    zzgo.zzs(i12, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 19:
                    z3 = false;
                    i13 = this.zzc[i23];
                    zzgo.zzw(i13, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 20:
                    z3 = false;
                    i14 = this.zzc[i23];
                    zzgo.zzy(i14, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 21:
                    z3 = false;
                    i15 = this.zzc[i23];
                    zzgo.zzE(i15, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 22:
                    z3 = false;
                    i16 = this.zzc[i23];
                    zzgo.zzx(i16, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 23:
                    z3 = false;
                    i17 = this.zzc[i23];
                    zzgo.zzv(i17, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 24:
                    z3 = false;
                    i18 = this.zzc[i23];
                    zzgo.zzu(i18, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                    i19 = this.zzc[i23];
                    list = (List) unsafe.getObject(obj, j8);
                    z3 = false;
                    zzgo.zzr(i19, list, zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                    int i27 = this.zzc[i23];
                    List list2 = (List) unsafe.getObject(obj, j8);
                    int i28 = zzgo.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        zzhvVar.zzG(i27, list2);
                    }
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                    break;
                case 27:
                    int i29 = this.zzc[i23];
                    List list3 = (List) unsafe.getObject(obj, j8);
                    zzgm zzv = zzv(i23);
                    int i30 = zzgo.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i31 = 0; i31 < list3.size(); i31++) {
                            ((zzef) zzhvVar).zzv(i29, list3.get(i31), zzv);
                        }
                    }
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                    break;
                case 28:
                    int i32 = this.zzc[i23];
                    List list4 = (List) unsafe.getObject(obj, j8);
                    int i33 = zzgo.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        zzhvVar.zze(i32, list4);
                    }
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                    break;
                case 29:
                    zzgo.zzD(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, false);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 30:
                    zzgo.zzt(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, false);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 31:
                    zzgo.zzz(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, false);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 32:
                    zzgo.zzA(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, false);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 33:
                    zzgo.zzB(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, false);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 34:
                    zzgo.zzC(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, false);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 35:
                    i12 = this.zzc[i23];
                    zzgo.zzs(i12, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 36:
                    i13 = this.zzc[i23];
                    zzgo.zzw(i13, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                    i14 = this.zzc[i23];
                    zzgo.zzy(i14, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 38:
                    i15 = this.zzc[i23];
                    zzgo.zzE(i15, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 39:
                    i16 = this.zzc[i23];
                    zzgo.zzx(i16, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 40:
                    i17 = this.zzc[i23];
                    zzgo.zzv(i17, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 41:
                    i18 = this.zzc[i23];
                    zzgo.zzu(i18, (List) unsafe.getObject(obj, j8), zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 42:
                    i19 = this.zzc[i23];
                    list = (List) unsafe.getObject(obj, j8);
                    zzgo.zzr(i19, list, zzhvVar, z3);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 43:
                    zzgo.zzD(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, true);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 44:
                    zzgo.zzt(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, true);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 45:
                    zzgo.zzz(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, true);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 46:
                    zzgo.zzA(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, true);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 47:
                    zzgo.zzB(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, true);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 48:
                    zzgo.zzC(this.zzc[i23], (List) unsafe.getObject(obj, j8), zzhvVar, true);
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 49:
                    int i34 = this.zzc[i23];
                    List list5 = (List) unsafe.getObject(obj, j8);
                    zzgm zzv2 = zzv(i23);
                    int i35 = zzgo.zza;
                    if (list5 != null && !list5.isEmpty()) {
                        for (int i36 = 0; i36 < list5.size(); i36++) {
                            ((zzef) zzhvVar).zzq(i34, list5.get(i36), zzv2);
                        }
                    }
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j8) != null) {
                        throw null;
                    }
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
                case 51:
                    if (zzM(obj, i24, i23)) {
                        zza2 = zzm(obj, j8);
                        zzhvVar.zzf(i24, zza2);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 52:
                    if (zzM(obj, i24, i23)) {
                        zzb2 = zzn(obj, j8);
                        zzhvVar.zzo(i24, zzb2);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 53:
                    if (zzM(obj, i24, i23)) {
                        j3 = zzt(obj, j8);
                        zzhvVar.zzt(i24, j3);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 54:
                    if (zzM(obj, i24, i23)) {
                        j4 = zzt(obj, j8);
                        zzhvVar.zzJ(i24, j4);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 55:
                    if (zzM(obj, i24, i23)) {
                        i6 = zzo(obj, j8);
                        zzhvVar.zzr(i24, i6);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 56:
                    if (zzM(obj, i24, i23)) {
                        j5 = zzt(obj, j8);
                        zzhvVar.zzm(i24, j5);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 57:
                    if (zzM(obj, i24, i23)) {
                        i7 = zzo(obj, j8);
                        zzhvVar.zzk(i24, i7);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 58:
                    if (zzM(obj, i24, i23)) {
                        zzw = zzN(obj, j8);
                        zzhvVar.zzb(i24, zzw);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 59:
                    if (zzM(obj, i24, i23)) {
                        object = unsafe.getObject(obj, j8);
                        zzO(i24, object, zzhvVar);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 60:
                    if (zzM(obj, i24, i23)) {
                        object2 = unsafe.getObject(obj, j8);
                        zzhvVar.zzv(i24, object2, zzv(i23));
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 61:
                    if (zzM(obj, i24, i23)) {
                        object3 = unsafe.getObject(obj, j8);
                        zzhvVar.zzd(i24, (zzdw) object3);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 62:
                    if (zzM(obj, i24, i23)) {
                        i8 = zzo(obj, j8);
                        zzhvVar.zzH(i24, i8);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 63:
                    if (zzM(obj, i24, i23)) {
                        i9 = zzo(obj, j8);
                        zzhvVar.zzi(i24, i9);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 64:
                    if (zzM(obj, i24, i23)) {
                        i10 = zzo(obj, j8);
                        zzhvVar.zzw(i24, i10);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case 65:
                    if (zzM(obj, i24, i23)) {
                        j6 = zzt(obj, j8);
                        zzhvVar.zzy(i24, j6);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case Wbxml.EXT_I_2 /* 66 */:
                    if (zzM(obj, i24, i23)) {
                        i11 = zzo(obj, j8);
                        zzhvVar.zzA(i24, i11);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case Wbxml.PI /* 67 */:
                    if (zzM(obj, i24, i23)) {
                        j7 = zzt(obj, j8);
                        zzhvVar.zzC(i24, j7);
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                case Wbxml.LITERAL_C /* 68 */:
                    if (zzM(obj, i24, i23)) {
                        object4 = unsafe.getObject(obj, j8);
                        zzhvVar.zzq(i24, object4, zzv(i23));
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    } else {
                        i23 += 3;
                        i21 = i3;
                        i22 = i4;
                        i20 = 1048575;
                    }
                default:
                    i23 += 3;
                    i21 = i3;
                    i22 = i4;
                    i20 = 1048575;
            }
        }
        zzhd zzhdVar = this.zzm;
        zzhdVar.zzi(zzhdVar.zzd(obj), zzhvVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzj(Object obj, Object obj2) {
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int zzs = zzs(i3);
            long j3 = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i3) && Double.doubleToLongBits(zzhn.zza(obj, j3)) == Double.doubleToLongBits(zzhn.zza(obj2, j3))) {
                        break;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i3) && Float.floatToIntBits(zzhn.zzb(obj, j3)) == Float.floatToIntBits(zzhn.zzb(obj2, j3))) {
                        break;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i3) && zzhn.zzd(obj, j3) == zzhn.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i3) && zzhn.zzd(obj, j3) == zzhn.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i3) && zzhn.zzc(obj, j3) == zzhn.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i3) && zzhn.zzd(obj, j3) == zzhn.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i3) && zzhn.zzc(obj, j3) == zzhn.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i3) && zzhn.zzw(obj, j3) == zzhn.zzw(obj2, j3)) {
                        break;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i3) && zzgo.zzF(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i3) && zzgo.zzF(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i3) && zzgo.zzF(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i3) && zzhn.zzc(obj, j3) == zzhn.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i3) && zzhn.zzc(obj, j3) == zzhn.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i3) && zzhn.zzc(obj, j3) == zzhn.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i3) && zzhn.zzd(obj, j3) == zzhn.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i3) && zzhn.zzc(obj, j3) == zzhn.zzc(obj2, j3)) {
                        break;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i3) && zzhn.zzd(obj, j3) == zzhn.zzd(obj2, j3)) {
                        break;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i3) && zzgo.zzF(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3))) {
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
                    if (!zzgo.zzF(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3))) {
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
                    long zzp = zzp(i3) & 1048575;
                    if (zzhn.zzc(obj, zzp) == zzhn.zzc(obj2, zzp) && zzgo.zzF(zzhn.zzf(obj, j3), zzhn.zzf(obj2, j3))) {
                        break;
                    }
                    return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        this.zzn.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzk(Object obj) {
        int i3;
        int i4;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i8 = iArr[i7];
            int i9 = iArr2[i8];
            int zzs = zzs(i8);
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
            if ((268435456 & zzs) != 0 && !zzJ(obj, i8, i3, i4, i12)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i9, i8) && !zzK(obj, zzs, zzv(i8))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzfw) zzhn.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhn.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgm zzv = zzv(i8);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zzv.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i8, i3, i4, i12) && !zzK(obj, zzs, zzv(i8))) {
                return false;
            }
            i7++;
            i5 = i3;
            i6 = i4;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        throw null;
    }
}
