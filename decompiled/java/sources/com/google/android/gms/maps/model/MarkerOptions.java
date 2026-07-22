package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;

/* loaded from: /root/release/classes.dex */
public class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzl();
    private LatLng zza;
    private String zzb;
    private String zzc;
    private BitmapDescriptor zzd;
    private float zze;
    private float zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private float zzn;

    @AdvancedMarkerOptions.CollisionBehavior
    private int zzo;
    private View zzp;
    private int zzq;
    private String zzr;
    private float zzs;

    public MarkerOptions() {
        this.zze = 0.5f;
        this.zzf = 1.0f;
        this.zzh = true;
        this.zzi = false;
        this.zzj = BitmapDescriptorFactory.HUE_RED;
        this.zzk = 0.5f;
        this.zzl = BitmapDescriptorFactory.HUE_RED;
        this.zzm = 1.0f;
        this.zzo = 0;
    }

    MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f3, float f4, boolean z3, boolean z4, boolean z5, float f5, float f6, float f7, float f8, float f9, int i3, IBinder iBinder2, int i4, String str3, float f10) {
        this.zze = 0.5f;
        this.zzf = 1.0f;
        this.zzh = true;
        this.zzi = false;
        this.zzj = BitmapDescriptorFactory.HUE_RED;
        this.zzk = 0.5f;
        this.zzl = BitmapDescriptorFactory.HUE_RED;
        this.zzm = 1.0f;
        this.zzo = 0;
        this.zza = latLng;
        this.zzb = str;
        this.zzc = str2;
        if (iBinder == null) {
            this.zzd = null;
        } else {
            this.zzd = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        }
        this.zze = f3;
        this.zzf = f4;
        this.zzg = z3;
        this.zzh = z4;
        this.zzi = z5;
        this.zzj = f5;
        this.zzk = f6;
        this.zzl = f7;
        this.zzm = f8;
        this.zzn = f9;
        this.zzq = i4;
        this.zzo = i3;
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(iBinder2);
        this.zzp = asInterface != null ? (View) ObjectWrapper.unwrap(asInterface) : null;
        this.zzr = str3;
        this.zzs = f10;
    }

    public MarkerOptions alpha(float f3) {
        this.zzm = f3;
        return this;
    }

    public MarkerOptions anchor(float f3, float f4) {
        this.zze = f3;
        this.zzf = f4;
        return this;
    }

    public MarkerOptions contentDescription(String str) {
        this.zzr = str;
        return this;
    }

    public MarkerOptions draggable(boolean z3) {
        this.zzg = z3;
        return this;
    }

    public MarkerOptions flat(boolean z3) {
        this.zzi = z3;
        return this;
    }

    public float getAlpha() {
        return this.zzm;
    }

    public float getAnchorU() {
        return this.zze;
    }

    public float getAnchorV() {
        return this.zzf;
    }

    public BitmapDescriptor getIcon() {
        return this.zzd;
    }

    public float getInfoWindowAnchorU() {
        return this.zzk;
    }

    public float getInfoWindowAnchorV() {
        return this.zzl;
    }

    public LatLng getPosition() {
        return this.zza;
    }

    public float getRotation() {
        return this.zzj;
    }

    public String getSnippet() {
        return this.zzc;
    }

    public String getTitle() {
        return this.zzb;
    }

    public float getZIndex() {
        return this.zzn;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.zzd = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f3, float f4) {
        this.zzk = f3;
        this.zzl = f4;
        return this;
    }

    public boolean isDraggable() {
        return this.zzg;
    }

    public boolean isFlat() {
        return this.zzi;
    }

    public boolean isVisible() {
        return this.zzh;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.zza = latLng;
        return this;
    }

    public MarkerOptions rotation(float f3) {
        this.zzj = f3;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.zzc = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.zzb = str;
        return this;
    }

    public MarkerOptions visible(boolean z3) {
        this.zzh = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getPosition(), i3, false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeString(parcel, 4, getSnippet(), false);
        BitmapDescriptor bitmapDescriptor = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 5, bitmapDescriptor == null ? null : bitmapDescriptor.zza().asBinder(), false);
        SafeParcelWriter.writeFloat(parcel, 6, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 7, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 8, isDraggable());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 10, isFlat());
        SafeParcelWriter.writeFloat(parcel, 11, getRotation());
        SafeParcelWriter.writeFloat(parcel, 12, getInfoWindowAnchorU());
        SafeParcelWriter.writeFloat(parcel, 13, getInfoWindowAnchorV());
        SafeParcelWriter.writeFloat(parcel, 14, getAlpha());
        SafeParcelWriter.writeFloat(parcel, 15, getZIndex());
        SafeParcelWriter.writeInt(parcel, 17, this.zzo);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 19, this.zzq);
        SafeParcelWriter.writeString(parcel, 20, this.zzr, false);
        SafeParcelWriter.writeFloat(parcel, 21, this.zzs);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public MarkerOptions zIndex(float f3) {
        this.zzn = f3;
        return this;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzq;
    }

    public final View zzc() {
        return this.zzp;
    }

    public final MarkerOptions zzd(@AdvancedMarkerOptions.CollisionBehavior int i3) {
        this.zzo = i3;
        return this;
    }

    public final MarkerOptions zze(View view) {
        this.zzp = view;
        return this;
    }

    public final MarkerOptions zzf(int i3) {
        this.zzq = 1;
        return this;
    }
}
