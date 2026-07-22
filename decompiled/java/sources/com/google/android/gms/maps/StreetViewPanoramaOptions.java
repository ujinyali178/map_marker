package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: /root/release/classes.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzaq();
    private StreetViewPanoramaCamera zza;
    private String zzb;
    private LatLng zzc;
    private Integer zzd;
    private Boolean zze;
    private Boolean zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private StreetViewSource zzj;

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.zze = bool;
        this.zzf = bool;
        this.zzg = bool;
        this.zzh = bool;
        this.zzj = StreetViewSource.DEFAULT;
    }

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b4, byte b5, byte b6, byte b7, byte b8, StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.zze = bool;
        this.zzf = bool;
        this.zzg = bool;
        this.zzh = bool;
        this.zzj = StreetViewSource.DEFAULT;
        this.zza = streetViewPanoramaCamera;
        this.zzc = latLng;
        this.zzd = num;
        this.zzb = str;
        this.zze = com.google.android.gms.maps.internal.zza.zzb(b4);
        this.zzf = com.google.android.gms.maps.internal.zza.zzb(b5);
        this.zzg = com.google.android.gms.maps.internal.zza.zzb(b6);
        this.zzh = com.google.android.gms.maps.internal.zza.zzb(b7);
        this.zzi = com.google.android.gms.maps.internal.zza.zzb(b8);
        this.zzj = streetViewSource;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzg;
    }

    public String getPanoramaId() {
        return this.zzb;
    }

    public LatLng getPosition() {
        return this.zzc;
    }

    public Integer getRadius() {
        return this.zzd;
    }

    public StreetViewSource getSource() {
        return this.zzj;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzh;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zza;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzi;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zze;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzf;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z3) {
        this.zzg = Boolean.valueOf(z3);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zza = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.zzb = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.zzc = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, StreetViewSource streetViewSource) {
        this.zzc = latLng;
        this.zzj = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.zzc = latLng;
        this.zzd = num;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num, StreetViewSource streetViewSource) {
        this.zzc = latLng;
        this.zzd = num;
        this.zzj = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z3) {
        this.zzh = Boolean.valueOf(z3);
        return this;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("PanoramaId", this.zzb).add("Position", this.zzc).add("Radius", this.zzd).add("Source", this.zzj).add("StreetViewPanoramaCamera", this.zza).add("UserNavigationEnabled", this.zze).add("ZoomGesturesEnabled", this.zzf).add("PanningGesturesEnabled", this.zzg).add("StreetNamesEnabled", this.zzh).add("UseViewLifecycleInFragment", this.zzi).toString();
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z3) {
        this.zzi = Boolean.valueOf(z3);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z3) {
        this.zze = Boolean.valueOf(z3);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStreetViewPanoramaCamera(), i3, false);
        SafeParcelWriter.writeString(parcel, 3, getPanoramaId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getPosition(), i3, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, getRadius(), false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.zza(this.zze));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.zza(this.zzf));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.zza(this.zzg));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.zza(this.zzh));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.zza(this.zzi));
        SafeParcelWriter.writeParcelable(parcel, 11, getSource(), i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z3) {
        this.zzf = Boolean.valueOf(z3);
        return this;
    }
}
