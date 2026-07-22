package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;

/* loaded from: /root/release/classes.dex */
public enum PublicKeyCredentialType implements Parcelable {
    PUBLIC_KEY("public-key");

    public static final Parcelable.Creator<PublicKeyCredentialType> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zzaq
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return PublicKeyCredentialType.fromString(parcel.readString());
            } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new PublicKeyCredentialType[i3];
        }
    };
    private final String zzb = "public-key";

    public static class UnsupportedPublicKeyCredTypeException extends Exception {
        public UnsupportedPublicKeyCredTypeException(String str) {
            super(str);
        }
    }

    PublicKeyCredentialType(String str) {
    }

    public static PublicKeyCredentialType fromString(String str) {
        for (PublicKeyCredentialType publicKeyCredentialType : values()) {
            if (str.equals(publicKeyCredentialType.zzb)) {
                return publicKeyCredentialType;
            }
        }
        throw new UnsupportedPublicKeyCredTypeException(String.format("PublicKeyCredentialType %s not supported", str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.zzb);
    }
}
