package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: /root/release/classes.dex */
public final class zan implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        long j3 = 0;
        long j4 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MethodInvocation(i3, i4, i5, j3, j4, str, str2, i6, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new MethodInvocation[i3];
    }
}
