package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzg();
    public static final float NO_DIMENSION = -1.0f;
    private BitmapDescriptor zza;
    private LatLng zzb;
    private float zzc;
    private float zzd;
    private LatLngBounds zze;
    private float zzf;
    private float zzg;
    private boolean zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;

    public GroundOverlayOptions() {
        this.zzh = true;
        this.zzi = BitmapDescriptorFactory.HUE_RED;
        this.zzj = 0.5f;
        this.zzk = 0.5f;
        this.zzl = false;
    }

    GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f3, float f4, LatLngBounds latLngBounds, float f5, float f6, boolean z3, float f7, float f8, float f9, boolean z4) {
        this.zzh = true;
        this.zzi = BitmapDescriptorFactory.HUE_RED;
        this.zzj = 0.5f;
        this.zzk = 0.5f;
        this.zzl = false;
        this.zza = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzb = latLng;
        this.zzc = f3;
        this.zzd = f4;
        this.zze = latLngBounds;
        this.zzf = f5;
        this.zzg = f6;
        this.zzh = z3;
        this.zzi = f7;
        this.zzj = f8;
        this.zzk = f9;
        this.zzl = z4;
    }

    private final GroundOverlayOptions zza(LatLng latLng, float f3, float f4) {
        this.zzb = latLng;
        this.zzc = f3;
        this.zzd = f4;
        return this;
    }

    public GroundOverlayOptions anchor(float f3, float f4) {
        this.zzj = f3;
        this.zzk = f4;
        return this;
    }

    public GroundOverlayOptions bearing(float f3) {
        this.zzf = ((f3 % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public GroundOverlayOptions clickable(boolean z3) {
        this.zzl = z3;
        return this;
    }

    public float getAnchorU() {
        return this.zzj;
    }

    public float getAnchorV() {
        return this.zzk;
    }

    public float getBearing() {
        return this.zzf;
    }

    public LatLngBounds getBounds() {
        return this.zze;
    }

    public float getHeight() {
        return this.zzd;
    }

    public BitmapDescriptor getImage() {
        return this.zza;
    }

    public LatLng getLocation() {
        return this.zzb;
    }

    public float getTransparency() {
        return this.zzi;
    }

    public float getWidth() {
        return this.zzc;
    }

    public float getZIndex() {
        return this.zzg;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        this.zza = bitmapDescriptor;
        return this;
    }

    public boolean isClickable() {
        return this.zzl;
    }

    public boolean isVisible() {
        return this.zzh;
    }

    public GroundOverlayOptions position(LatLng latLng, float f3) {
        Preconditions.checkState(this.zze == null, "Position has already been set using positionFromBounds");
        Preconditions.checkArgument(latLng != null, "Location must be specified");
        Preconditions.checkArgument(f3 >= BitmapDescriptorFactory.HUE_RED, "Width must be non-negative");
        zza(latLng, f3, -1.0f);
        return this;
    }

    public GroundOverlayOptions position(LatLng latLng, float f3, float f4) {
        Preconditions.checkState(this.zze == null, "Position has already been set using positionFromBounds");
        Preconditions.checkArgument(latLng != null, "Location must be specified");
        Preconditions.checkArgument(f3 >= BitmapDescriptorFactory.HUE_RED, "Width must be non-negative");
        Preconditions.checkArgument(f4 >= BitmapDescriptorFactory.HUE_RED, "Height must be non-negative");
        zza(latLng, f3, f4);
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        LatLng latLng = this.zzb;
        Preconditions.checkState(latLng == null, "Position has already been set using position: ".concat(String.valueOf(latLng)));
        this.zze = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f3) {
        boolean z3 = false;
        if (f3 >= BitmapDescriptorFactory.HUE_RED && f3 <= 1.0f) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Transparency must be in the range [0..1]");
        this.zzi = f3;
        return this;
    }

    public GroundOverlayOptions visible(boolean z3) {
        this.zzh = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.zza().asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getLocation(), i3, false);
        SafeParcelWriter.writeFloat(parcel, 4, getWidth());
        SafeParcelWriter.writeFloat(parcel, 5, getHeight());
        SafeParcelWriter.writeParcelable(parcel, 6, getBounds(), i3, false);
        SafeParcelWriter.writeFloat(parcel, 7, getBearing());
        SafeParcelWriter.writeFloat(parcel, 8, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeFloat(parcel, 10, getTransparency());
        SafeParcelWriter.writeFloat(parcel, 11, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 12, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 13, isClickable());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public GroundOverlayOptions zIndex(float f3) {
        this.zzg = f3;
        return this;
    }
}
