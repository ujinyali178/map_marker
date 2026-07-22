package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzdj;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: /root/release/classes.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new zzj();
    private final long zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final boolean zze;
    private final int zzf;
    private final String zzg;
    private final WorkSource zzh;
    private final com.google.android.gms.internal.location.zzd zzi;

    public static final class Builder {
        private long zza;
        private int zzb;
        private int zzc;
        private long zzd;
        private boolean zze;
        private int zzf;
        private String zzg;
        private WorkSource zzh;
        private com.google.android.gms.internal.location.zzd zzi;

        public Builder() {
            this.zza = 60000L;
            this.zzb = 0;
            this.zzc = 102;
            this.zzd = Long.MAX_VALUE;
            this.zze = false;
            this.zzf = 0;
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
        }

        public Builder(CurrentLocationRequest currentLocationRequest) {
            this.zza = currentLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = currentLocationRequest.getGranularity();
            this.zzc = currentLocationRequest.getPriority();
            this.zzd = currentLocationRequest.getDurationMillis();
            this.zze = currentLocationRequest.zze();
            this.zzf = currentLocationRequest.zza();
            this.zzg = currentLocationRequest.zzd();
            this.zzh = new WorkSource(currentLocationRequest.zzb());
            this.zzi = currentLocationRequest.zzc();
        }

        public CurrentLocationRequest build() {
            return new CurrentLocationRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, new WorkSource(this.zzh), this.zzi);
        }

        public Builder setDurationMillis(long j3) {
            Preconditions.checkArgument(j3 > 0, "durationMillis must be greater than 0");
            this.zzd = j3;
            return this;
        }

        public Builder setGranularity(int i3) {
            zzo.zza(i3);
            this.zzb = i3;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j3) {
            Preconditions.checkArgument(j3 >= 0, "maxUpdateAgeMillis must be greater than or equal to 0");
            this.zza = j3;
            return this;
        }

        public Builder setPriority(int i3) {
            zzae.zza(i3);
            this.zzc = i3;
            return this;
        }
    }

    CurrentLocationRequest(long j3, int i3, int i4, long j4, boolean z3, int i5, String str, WorkSource workSource, com.google.android.gms.internal.location.zzd zzdVar) {
        boolean z4 = true;
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        this.zza = j3;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = j4;
        this.zze = z3;
        this.zzf = i5;
        this.zzg = str;
        this.zzh = workSource;
        this.zzi = zzdVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        return this.zza == currentLocationRequest.zza && this.zzb == currentLocationRequest.zzb && this.zzc == currentLocationRequest.zzc && this.zzd == currentLocationRequest.zzd && this.zze == currentLocationRequest.zze && this.zzf == currentLocationRequest.zzf && Objects.equal(this.zzg, currentLocationRequest.zzg) && Objects.equal(this.zzh, currentLocationRequest.zzh) && Objects.equal(this.zzi, currentLocationRequest.zzi);
    }

    @Pure
    public long getDurationMillis() {
        return this.zzd;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    @Pure
    public int getPriority() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentLocationRequest[");
        sb.append(zzae.zzb(this.zzc));
        if (this.zza != Long.MAX_VALUE) {
            sb.append(", maxAge=");
            zzdj.zzb(this.zza, sb);
        }
        if (this.zzd != Long.MAX_VALUE) {
            sb.append(", duration=");
            sb.append(this.zzd);
            sb.append("ms");
        }
        if (this.zzb != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.zzb));
        }
        if (this.zze) {
            sb.append(", bypass");
        }
        if (this.zzf != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.zzf));
        }
        if (this.zzg != null) {
            sb.append(", moduleId=");
            sb.append(this.zzg);
        }
        if (!WorkSourceUtil.isEmpty(this.zzh)) {
            sb.append(", workSource=");
            sb.append(this.zzh);
        }
        if (this.zzi != null) {
            sb.append(", impersonation=");
            sb.append(this.zzi);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeInt(parcel, 3, getPriority());
        SafeParcelWriter.writeLong(parcel, 4, getDurationMillis());
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzh, i3, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzf;
    }

    @Pure
    public final WorkSource zzb() {
        return this.zzh;
    }

    @Pure
    public final com.google.android.gms.internal.location.zzd zzc() {
        return this.zzi;
    }

    @Deprecated
    @Pure
    public final String zzd() {
        return this.zzg;
    }

    @Pure
    public final boolean zze() {
        return this.zze;
    }
}
