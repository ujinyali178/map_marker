package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* loaded from: /root/release/classes.dex */
public final class zzv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i3 = 0;
        zzw zzwVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            int i4 = 1;
            if (fieldId != 1) {
                i4 = 2;
                if (fieldId != 2) {
                    i4 = 3;
                    if (fieldId != 3) {
                        i4 = 4;
                        if (fieldId != 4) {
                            i4 = 5;
                            if (fieldId != 5) {
                                SafeParcelReader.skipUnknownField(parcel, readHeader);
                            } else {
                                str3 = SafeParcelReader.createString(parcel, readHeader);
                            }
                        } else {
                            str2 = SafeParcelReader.createString(parcel, readHeader);
                        }
                    } else {
                        str = SafeParcelReader.createString(parcel, readHeader);
                    }
                } else {
                    zzwVar = (zzw) SafeParcelReader.createParcelable(parcel, readHeader, zzw.CREATOR);
                }
            } else {
                i3 = SafeParcelReader.readInt(parcel, readHeader);
            }
            hashSet.add(Integer.valueOf(i4));
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzu(hashSet, i3, zzwVar, str, str2, str3);
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzu[i3];
    }
}
