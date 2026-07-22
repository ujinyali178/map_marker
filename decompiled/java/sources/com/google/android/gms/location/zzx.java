package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
public final class zzx implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        String str = null;
        com.google.android.gms.internal.location.zzd zzdVar = null;
        long j3 = Long.MAX_VALUE;
        long j4 = Long.MAX_VALUE;
        long j5 = 3600000;
        long j6 = 600000;
        long j7 = 0;
        long j8 = -1;
        int i3 = 102;
        int i4 = Integer.MAX_VALUE;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        boolean z3 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z4 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 5:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    f3 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    j7 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 9:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 11:
                    j8 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 15:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, readHeader, WorkSource.CREATOR);
                    break;
                case 17:
                    zzdVar = (com.google.android.gms.internal.location.zzd) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.internal.location.zzd.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationRequest(i3, j5, j6, j7, j3, j4, i4, f3, z3, j8, i5, i6, str, z4, workSource, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new LocationRequest[i3];
    }
}
