package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: /root/release/classes.dex */
public enum ErrorCode implements Parcelable {
    OK(0),
    OTHER_ERROR(1),
    BAD_REQUEST(2),
    CONFIGURATION_UNSUPPORTED(3),
    DEVICE_INELIGIBLE(4),
    TIMEOUT(5);

    private final int zzc;
    private static final String zza = ErrorCode.class.getSimpleName();
    public static final Parcelable.Creator<ErrorCode> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.u2f.api.common.zzc
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ErrorCode.toErrorCode(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new ErrorCode[i3];
        }
    };

    ErrorCode(int i3) {
        this.zzc = i3;
    }

    public static ErrorCode toErrorCode(int i3) {
        for (ErrorCode errorCode : values()) {
            if (i3 == errorCode.zzc) {
                return errorCode;
            }
        }
        return OTHER_ERROR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.zzc);
    }
}
