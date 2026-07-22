package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: /root/release/classes.dex */
public final class StrokeStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new zzaa();
    private final float zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final StampStyle zze;

    public static final class Builder {
        private float zza;
        private int zzb;
        private int zzc;
        private boolean zzd;
        private StampStyle zze;

        private Builder() {
        }

        public Builder(StrokeStyle strokeStyle) {
            this.zza = strokeStyle.zza();
            Pair zzb = strokeStyle.zzb();
            this.zzb = ((Integer) zzb.first).intValue();
            this.zzc = ((Integer) zzb.second).intValue();
            this.zzd = strokeStyle.isVisible();
            this.zze = strokeStyle.getStamp();
        }

        /* synthetic */ Builder(zzz zzzVar) {
        }

        public StrokeStyle build() {
            return new StrokeStyle(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder stamp(StampStyle stampStyle) {
            this.zze = stampStyle;
            return this;
        }

        public final Builder zza(int i3) {
            this.zzb = i3;
            this.zzc = i3;
            return this;
        }

        public final Builder zzb(int i3, int i4) {
            this.zzb = i3;
            this.zzc = i4;
            return this;
        }

        public final Builder zzc(boolean z3) {
            this.zzd = z3;
            return this;
        }

        public final Builder zzd(float f3) {
            this.zza = f3;
            return this;
        }
    }

    StrokeStyle(float f3, int i3, int i4, boolean z3, StampStyle stampStyle) {
        this.zza = f3;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = z3;
        this.zze = stampStyle;
    }

    public static Builder colorBuilder(int i3) {
        Builder builder = new Builder((zzz) null);
        builder.zza(i3);
        return builder;
    }

    public static Builder gradientBuilder(int i3, int i4) {
        Builder builder = new Builder((zzz) null);
        builder.zzb(i3, i4);
        return builder;
    }

    public static Builder transparentColorBuilder() {
        Builder builder = new Builder((zzz) null);
        builder.zza(0);
        return builder;
    }

    public StampStyle getStamp() {
        return this.zze;
    }

    public boolean isVisible() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.zza);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, isVisible());
        SafeParcelWriter.writeParcelable(parcel, 6, getStamp(), i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        return this.zza;
    }

    public final Pair zzb() {
        return new Pair(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }
}
