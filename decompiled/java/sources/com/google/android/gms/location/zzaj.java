package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: /root/release/classes.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;

    public zzaj(int i3, int i4, int i5, int i6) {
        Preconditions.checkState(i3 >= 0 && i3 <= 23, "Start hour must be in range [0, 23].");
        Preconditions.checkState(i4 >= 0 && i4 <= 59, "Start minute must be in range [0, 59].");
        Preconditions.checkState(i5 >= 0 && i5 <= 23, "End hour must be in range [0, 23].");
        Preconditions.checkState(i6 >= 0 && i6 <= 59, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i3 + i4) + i5) + i6 > 0, "Parameters can't be all 0.");
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzajVar = (zzaj) obj;
        return this.zza == zzajVar.zza && this.zzb == zzajVar.zzb && this.zzc == zzajVar.zzc && this.zzd == zzajVar.zzd;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        return "UserPreferredSleepWindow [startHour=" + this.zza + ", startMinute=" + this.zzb + ", endHour=" + this.zzc + ", endMinute=" + this.zzd + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
