package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: /root/release/classes.dex */
public final class zzac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        CameraPosition cameraPosition = null;
        Float f3 = null;
        Float f4 = null;
        LatLngBounds latLngBounds = null;
        Integer num = null;
        String str = null;
        byte b4 = -1;
        byte b5 = -1;
        int i3 = 0;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        byte b13 = -1;
        byte b14 = -1;
        byte b15 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    b4 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 3:
                    b5 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.createParcelable(parcel, readHeader, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 7:
                    b7 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 8:
                    b8 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 9:
                    b9 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 10:
                    b10 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 11:
                    b11 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 12:
                    b12 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 13:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 14:
                    b13 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 15:
                    b14 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 16:
                    f3 = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 17:
                    f4 = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, readHeader, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b15 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 20:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 21:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleMapOptions(b4, b5, i3, cameraPosition, b6, b7, b8, b9, b10, b11, b12, b13, b14, f3, f4, latLngBounds, b15, num, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GoogleMapOptions[i3];
    }
}
