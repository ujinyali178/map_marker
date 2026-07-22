package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;
import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.PinConfig;

/* loaded from: /root/release/classes.dex */
public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
            IInterface zzg;
            int i5;
            int i6;
            int i7;
            switch (i3) {
                case 2:
                    zzg = zzg();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, zzg);
                    return true;
                case 3:
                    Bundle zzd = zzd();
                    parcel2.writeNoException();
                    zzc.zzd(parcel2, zzd);
                    return true;
                case 4:
                    i5 = zzb();
                    parcel2.writeNoException();
                    i6 = i5;
                    parcel2.writeInt(i6);
                    return true;
                case 5:
                    zzg = zze();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, zzg);
                    return true;
                case 6:
                    zzg = zzh();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, zzg);
                    return true;
                case 7:
                    i7 = zzs();
                    parcel2.writeNoException();
                    int i8 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 8:
                    String zzj = zzj();
                    parcel2.writeNoException();
                    parcel2.writeString(zzj);
                    return true;
                case 9:
                    zzg = zzf();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, zzg);
                    return true;
                case 10:
                    i5 = zzc();
                    parcel2.writeNoException();
                    i6 = i5;
                    parcel2.writeInt(i6);
                    return true;
                case 11:
                    i7 = zzt();
                    parcel2.writeNoException();
                    int i82 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 12:
                    zzg = zzi();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, zzg);
                    return true;
                case 13:
                    i7 = zzu();
                    parcel2.writeNoException();
                    int i822 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 14:
                    i7 = zzv();
                    parcel2.writeNoException();
                    int i8222 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 15:
                    i7 = zzw();
                    parcel2.writeNoException();
                    int i82222 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 16:
                    i7 = zzx();
                    parcel2.writeNoException();
                    int i822222 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 17:
                    i7 = zzy();
                    parcel2.writeNoException();
                    int i8222222 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 18:
                    i7 = zzz();
                    parcel2.writeNoException();
                    int i82222222 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 19:
                    i7 = zzA();
                    parcel2.writeNoException();
                    int i822222222 = zzc.zza;
                    i6 = i7;
                    parcel2.writeInt(i6);
                    return true;
                case 20:
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzc.zzb(parcel);
                    zzk(asInterface);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean zzf = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzl(zzf);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean zzf2 = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzm(zzf2);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean zzf3 = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzn(zzf3);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zzf4 = zzc.zzf(parcel);
                    zzc.zzb(parcel);
                    zzo(zzf4);
                    parcel2.writeNoException();
                    return true;
                case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                    Intent intent = (Intent) zzc.zza(parcel, Intent.CREATOR);
                    zzc.zzb(parcel);
                    zzp(intent);
                    parcel2.writeNoException();
                    return true;
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                    Intent intent2 = (Intent) zzc.zza(parcel, Intent.CREATOR);
                    int readInt = parcel.readInt();
                    zzc.zzb(parcel);
                    zzq(intent2, readInt);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzc.zzb(parcel);
                    zzr(asInterface2);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    boolean zzA();

    int zzb();

    int zzc();

    Bundle zzd();

    IFragmentWrapper zze();

    IFragmentWrapper zzf();

    IObjectWrapper zzg();

    IObjectWrapper zzh();

    IObjectWrapper zzi();

    String zzj();

    void zzk(IObjectWrapper iObjectWrapper);

    void zzl(boolean z3);

    void zzm(boolean z3);

    void zzn(boolean z3);

    void zzo(boolean z3);

    void zzp(Intent intent);

    void zzq(Intent intent, int i3);

    void zzr(IObjectWrapper iObjectWrapper);

    boolean zzs();

    boolean zzt();

    boolean zzu();

    boolean zzv();

    boolean zzw();

    boolean zzx();

    boolean zzy();

    boolean zzz();
}
