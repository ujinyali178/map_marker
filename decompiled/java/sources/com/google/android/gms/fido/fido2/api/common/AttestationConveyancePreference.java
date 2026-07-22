package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;

/* loaded from: /root/release/classes.dex */
public enum AttestationConveyancePreference implements Parcelable {
    NONE(DevicePublicKeyStringDef.NONE),
    INDIRECT(DevicePublicKeyStringDef.INDIRECT),
    DIRECT(DevicePublicKeyStringDef.DIRECT);

    public static final Parcelable.Creator<AttestationConveyancePreference> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zzb
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return AttestationConveyancePreference.fromString(parcel.readString());
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new AttestationConveyancePreference[i3];
        }
    };
    private final String zzb;

    public static class UnsupportedAttestationConveyancePreferenceException extends Exception {
        public UnsupportedAttestationConveyancePreferenceException(String str) {
            super(String.format("Attestation conveyance preference %s not supported", str));
        }
    }

    AttestationConveyancePreference(String str) {
        this.zzb = str;
    }

    public static AttestationConveyancePreference fromString(String str) {
        for (AttestationConveyancePreference attestationConveyancePreference : values()) {
            if (str.equals(attestationConveyancePreference.zzb)) {
                return attestationConveyancePreference;
            }
        }
        throw new UnsupportedAttestationConveyancePreferenceException(str);
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
