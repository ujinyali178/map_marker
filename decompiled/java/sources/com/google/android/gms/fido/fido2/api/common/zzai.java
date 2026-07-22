package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    private final byte[][] zza;

    public zzai(byte[][] bArr) {
        Preconditions.checkArgument(bArr != null);
        Preconditions.checkArgument(1 == ((bArr.length & 1) ^ 1));
        int i3 = 0;
        while (i3 < bArr.length) {
            Preconditions.checkArgument(i3 == 0 || bArr[i3] != null);
            int i4 = i3 + 1;
            Preconditions.checkArgument(bArr[i4] != null);
            int length = bArr[i4].length;
            Preconditions.checkArgument(length == 32 || length == 64);
            i3 += 2;
        }
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzai) {
            return Arrays.deepEquals(this.zza, ((zzai) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        int i3 = 0;
        for (byte[] bArr : this.zza) {
            i3 ^= Objects.hashCode(bArr);
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
