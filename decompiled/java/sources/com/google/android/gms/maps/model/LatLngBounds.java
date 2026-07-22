package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.GoogleMapOptions;

/* loaded from: /root/release/classes.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzi();
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zza = Double.POSITIVE_INFINITY;
        private double zzb = Double.NEGATIVE_INFINITY;
        private double zzc = Double.NaN;
        private double zzd = Double.NaN;

        public LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.zzc), "no included points");
            return new LatLngBounds(new LatLng(this.zza, this.zzc), new LatLng(this.zzb, this.zzd));
        }

        public Builder include(LatLng latLng) {
            Preconditions.checkNotNull(latLng, "point must not be null");
            this.zza = Math.min(this.zza, latLng.latitude);
            this.zzb = Math.max(this.zzb, latLng.latitude);
            double d3 = latLng.longitude;
            if (!Double.isNaN(this.zzc)) {
                double d4 = this.zzc;
                double d5 = this.zzd;
                if (d4 > d5 ? !(d4 <= d3 || d3 <= d5) : !(d4 <= d3 && d3 <= d5)) {
                    Parcelable.Creator<LatLngBounds> creator = LatLngBounds.CREATOR;
                    if (((d4 - d3) + 360.0d) % 360.0d < ((d3 - d5) + 360.0d) % 360.0d) {
                        this.zzc = d3;
                    }
                }
                return this;
            }
            this.zzc = d3;
            this.zzd = d3;
            return this;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Preconditions.checkNotNull(latLng, "southwest must not be null.");
        Preconditions.checkNotNull(latLng2, "northeast must not be null.");
        double d3 = latLng2.latitude;
        double d4 = latLng.latitude;
        Preconditions.checkArgument(d3 >= d4, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d4), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zzb(context, attributeSet);
    }

    private final boolean zza(double d3) {
        LatLng latLng = this.northeast;
        double d4 = this.southwest.longitude;
        double d5 = latLng.longitude;
        return d4 <= d5 ? d4 <= d3 && d3 <= d5 : d4 <= d3 || d3 <= d5;
    }

    public boolean contains(LatLng latLng) {
        LatLng latLng2 = (LatLng) Preconditions.checkNotNull(latLng, "point must not be null.");
        double d3 = latLng2.latitude;
        return this.southwest.latitude <= d3 && d3 <= this.northeast.latitude && zza(latLng2.longitude);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        LatLng latLng = this.northeast;
        LatLng latLng2 = this.southwest;
        double d3 = latLng2.latitude + latLng.latitude;
        double d4 = latLng.longitude;
        double d5 = latLng2.longitude;
        if (d5 > d4) {
            d4 += 360.0d;
        }
        return new LatLng(d3 / 2.0d, (d4 + d5) / 2.0d);
    }

    public int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        LatLng latLng2 = (LatLng) Preconditions.checkNotNull(latLng, "point must not be null.");
        double min = Math.min(this.southwest.latitude, latLng2.latitude);
        double max = Math.max(this.northeast.latitude, latLng2.latitude);
        double d3 = this.northeast.longitude;
        double d4 = this.southwest.longitude;
        double d5 = latLng2.longitude;
        if (!zza(d5)) {
            if (((d4 - d5) + 360.0d) % 360.0d < ((d5 - d3) + 360.0d) % 360.0d) {
                d4 = d5;
            } else {
                d3 = d5;
            }
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d3));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        LatLng latLng = this.southwest;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, latLng, i3, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.northeast, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
