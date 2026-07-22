package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    LocationRequest zza;

    zzdd(LocationRequest locationRequest, List list, boolean z3, boolean z4, String str, boolean z5, boolean z6, String str2, long j3) {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    WorkSourceUtil.add(workSource, clientIdentity.uid, clientIdentity.packageName);
                }
            }
            builder.zzd(workSource);
        }
        if (z3) {
            builder.setGranularity(1);
        }
        if (z4) {
            builder.zzc(2);
        }
        if (str != null) {
            builder.zzb(str);
        } else if (str2 != null) {
            builder.zzb(str2);
        }
        if (z5) {
            builder.zza(true);
        }
        if (z6) {
            builder.setWaitForAccurateLocation(true);
        }
        if (j3 != Long.MAX_VALUE) {
            builder.setMaxUpdateAgeMillis(j3);
        }
        this.zza = builder.build();
    }

    @Deprecated
    public static zzdd zza(String str, LocationRequest locationRequest) {
        return new zzdd(locationRequest, null, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return Objects.equal(this.zza, ((zzdd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
