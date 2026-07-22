package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
public final class zzdi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d3 = 0.0d;
        double d4 = 0.0d;
        String str = null;
        long j3 = 0;
        int i3 = 0;
        short s3 = 0;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        int i4 = 0;
        int i5 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    s3 = SafeParcelReader.readShort(parcel, readHeader);
                    break;
                case 4:
                    d3 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 5:
                    d4 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 6:
                    f3 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzdh(str, i3, s3, d3, d4, f3, j3, i4, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzdh[i3];
    }
}
