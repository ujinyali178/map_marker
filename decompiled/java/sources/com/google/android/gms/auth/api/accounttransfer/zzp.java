package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: /root/release/classes.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = null;
        zzs zzsVar = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            int i5 = 1;
            if (fieldId != 1) {
                i5 = 2;
                if (fieldId != 2) {
                    i5 = 3;
                    if (fieldId != 3) {
                        i5 = 4;
                        if (fieldId != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readHeader);
                        } else {
                            zzsVar = (zzs) SafeParcelReader.createParcelable(parcel, readHeader, zzs.CREATOR);
                        }
                    } else {
                        i4 = SafeParcelReader.readInt(parcel, readHeader);
                    }
                } else {
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzu.CREATOR);
                }
            } else {
                i3 = SafeParcelReader.readInt(parcel, readHeader);
            }
            hashSet.add(Integer.valueOf(i5));
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzo(hashSet, i3, arrayList, i4, zzsVar);
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzo[i3];
    }
}
