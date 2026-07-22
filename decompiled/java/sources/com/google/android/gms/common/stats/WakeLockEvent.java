package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    final int zza;
    private final long zzb;
    private final int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;

    @Nullable
    private final List zzh;
    private final String zzi;
    private final long zzj;
    private final int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;

    WakeLockEvent(int i3, long j3, int i4, String str, int i5, @Nullable List list, String str2, long j4, int i6, String str3, String str4, float f3, long j5, String str5, boolean z3) {
        this.zza = i3;
        this.zzb = j3;
        this.zzc = i4;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i5;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j4;
        this.zzk = i6;
        this.zzl = str4;
        this.zzm = f3;
        this.zzn = j5;
        this.zzo = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzc() {
        List list = this.zzh;
        String str = this.zzd;
        int i3 = this.zzg;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i4 = this.zzk;
        String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f3 = this.zzm;
        String str4 = this.zzf;
        return "\t" + str + "\t" + i3 + "\t" + join + "\t" + i4 + "\t" + str2 + "\t" + str3 + "\t" + f3 + "\t" + (str4 != null ? str4 : "") + "\t" + this.zzo;
    }
}
