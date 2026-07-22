package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: /root/release/classes.dex */
public final class StyleSpan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StyleSpan> CREATOR = new zzab();
    private final StrokeStyle zza;
    private final double zzb;

    public StyleSpan(int i3) {
        this.zza = StrokeStyle.colorBuilder(i3).build();
        this.zzb = 1.0d;
    }

    public StyleSpan(int i3, double d3) {
        if (d3 <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.zza = StrokeStyle.colorBuilder(i3).build();
        this.zzb = d3;
    }

    public StyleSpan(StrokeStyle strokeStyle) {
        this.zza = strokeStyle;
        this.zzb = 1.0d;
    }

    public StyleSpan(StrokeStyle strokeStyle, double d3) {
        if (d3 <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.zza = strokeStyle;
        this.zzb = d3;
    }

    public double getSegments() {
        return this.zzb;
    }

    public StrokeStyle getStyle() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStyle(), i3, false);
        SafeParcelWriter.writeDouble(parcel, 3, getSegments());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
