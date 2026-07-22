package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzet;
import com.google.android.gms.internal.play_billing.zzex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /root/release/classes.dex */
public abstract class zzex<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdg<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzhe zzc = zzhe.zzc();

    static zzex zzh(Class cls) {
        Map map = zzb;
        zzex zzexVar = (zzex) map.get(cls);
        if (zzexVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzexVar = (zzex) map.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (zzexVar == null) {
            zzexVar = (zzex) ((zzex) zzhn.zze(cls)).zzu(6, null, null);
            if (zzexVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzexVar);
        }
        return zzexVar;
    }

    protected static zzex zzj(zzex zzexVar, byte[] bArr, zzej zzejVar) {
        zzex zzw = zzw(zzexVar, bArr, 0, bArr.length, zzejVar);
        if (zzw == null || zzw.zzs()) {
            return zzw;
        }
        zzff zza = new zzhc(zzw).zza();
        zza.zzf(zzw);
        throw zza;
    }

    static Object zzl(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzm(zzgc zzgcVar, String str, Object[] objArr) {
        return new zzgl(zzgcVar, str, objArr);
    }

    protected static void zzp(Class cls, zzex zzexVar) {
        zzexVar.zzo();
        zzb.put(cls, zzexVar);
    }

    private final int zzv(zzgm zzgmVar) {
        return zzgk.zza().zzb(getClass()).zza(this);
    }

    private static zzex zzw(zzex zzexVar, byte[] bArr, int i3, int i4, zzej zzejVar) {
        zzex zzi = zzexVar.zzi();
        try {
            zzgm zzb2 = zzgk.zza().zzb(zzi.getClass());
            zzb2.zzh(zzi, bArr, 0, i4, new zzdj(zzejVar));
            zzb2.zzf(zzi);
            return zzi;
        } catch (zzff e3) {
            e3.zzf(zzi);
            throw e3;
        } catch (zzhc e4) {
            zzff zza = e4.zza();
            zza.zzf(zzi);
            throw zza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzff) {
                throw ((zzff) e5.getCause());
            }
            zzff zzffVar = new zzff(e5);
            zzffVar.zzf(zzi);
            throw zzffVar;
        } catch (IndexOutOfBoundsException unused) {
            zzff zzg = zzff.zzg();
            zzg.zzf(zzi);
            throw zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgk.zza().zzb(getClass()).zzj(this, (zzex) obj);
    }

    public final int hashCode() {
        if (zzt()) {
            return zzd();
        }
        int i3 = this.zza;
        if (i3 != 0) {
            return i3;
        }
        int zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    public final String toString() {
        return zzge.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    final int zza(zzgm zzgmVar) {
        if (zzt()) {
            int zza = zzgmVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i3 = this.zzd & Integer.MAX_VALUE;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int zza2 = zzgmVar.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    final int zzd() {
        return zzgk.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final int zze() {
        int i3;
        if (zzt()) {
            i3 = zzv(null);
            if (i3 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i3);
            }
        } else {
            i3 = this.zzd & Integer.MAX_VALUE;
            if (i3 == Integer.MAX_VALUE) {
                i3 = zzv(null);
                if (i3 < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i3);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i3;
            }
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgd
    public final /* synthetic */ zzgc zzf() {
        return (zzex) zzu(6, null, null);
    }

    protected final zzet zzg() {
        return (zzet) zzu(5, null, null);
    }

    final zzex zzi() {
        return (zzex) zzu(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final /* synthetic */ zzgb zzk() {
        return (zzet) zzu(5, null, null);
    }

    protected final void zzn() {
        zzgk.zza().zzb(getClass()).zzf(this);
        zzo();
    }

    final void zzo() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzq(int i3) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgc
    public final void zzr(zzee zzeeVar) {
        zzgk.zza().zzb(getClass()).zzi(this, zzef.zza(zzeeVar));
    }

    public final boolean zzs() {
        byte byteValue = ((Byte) zzu(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgk.zza().zzb(getClass()).zzk(this);
        zzu(2, true != zzk ? null : this, null);
        return zzk;
    }

    final boolean zzt() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected abstract Object zzu(int i3, Object obj, Object obj2);
}
