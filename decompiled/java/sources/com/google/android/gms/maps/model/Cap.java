package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public class Cap extends AbstractSafeParcelable {
    private final int zzb;
    private final BitmapDescriptor zzc;
    private final Float zzd;
    private static final String zza = Cap.class.getSimpleName();
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();

    protected Cap(int i3) {
        this(i3, (BitmapDescriptor) null, (Float) null);
    }

    Cap(int i3, IBinder iBinder, Float f3) {
        this(i3, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder)), f3);
    }

    private Cap(int i3, BitmapDescriptor bitmapDescriptor, Float f3) {
        boolean z3;
        boolean z4 = f3 != null && f3.floatValue() > BitmapDescriptorFactory.HUE_RED;
        if (i3 == 3) {
            if (bitmapDescriptor == null || !z4) {
                i3 = 3;
                z3 = false;
                Preconditions.checkArgument(z3, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i3), bitmapDescriptor, f3));
                this.zzb = i3;
                this.zzc = bitmapDescriptor;
                this.zzd = f3;
            }
            i3 = 3;
        }
        z3 = true;
        Preconditions.checkArgument(z3, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i3), bitmapDescriptor, f3));
        this.zzb = i3;
        this.zzc = bitmapDescriptor;
        this.zzd = f3;
    }

    protected Cap(BitmapDescriptor bitmapDescriptor, float f3) {
        this(3, bitmapDescriptor, Float.valueOf(f3));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.zzb == cap.zzb && Objects.equal(this.zzc, cap.zzc) && Objects.equal(this.zzd, cap.zzd);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public String toString() {
        return "[Cap: type=" + this.zzb + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i4);
        BitmapDescriptor bitmapDescriptor = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.zza().asBinder(), false);
        SafeParcelWriter.writeFloatObject(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    final Cap zza() {
        int i3 = this.zzb;
        if (i3 == 0) {
            return new ButtCap();
        }
        if (i3 == 1) {
            return new SquareCap();
        }
        if (i3 == 2) {
            return new RoundCap();
        }
        if (i3 == 3) {
            Preconditions.checkState(this.zzc != null, "bitmapDescriptor must not be null");
            Preconditions.checkState(this.zzd != null, "bitmapRefWidth must not be null");
            return new CustomCap(this.zzc, this.zzd.floatValue());
        }
        Log.w(zza, "Unknown Cap type: " + i3);
        return this;
    }
}
