package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: /root/release/classes.dex */
public final class StreetViewSource extends AbstractSafeParcelable {
    private final int zzb;
    private static final String zza = StreetViewSource.class.getSimpleName();
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new zzy();
    public static final StreetViewSource DEFAULT = new StreetViewSource(0);
    public static final StreetViewSource OUTDOOR = new StreetViewSource(1);

    public StreetViewSource(int i3) {
        this.zzb = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.zzb == ((StreetViewSource) obj).zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb));
    }

    public String toString() {
        int i3 = this.zzb;
        return String.format("StreetViewSource:%s", i3 != 0 ? i3 != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i3)) : "OUTDOOR" : "DEFAULT");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i4);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
