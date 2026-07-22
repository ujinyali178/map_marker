package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzq();
    private final List zza;
    private final List zzb;
    private float zzc;
    private int zzd;
    private int zze;
    private float zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private List zzk;

    public PolygonOptions() {
        this.zzc = 10.0f;
        this.zzd = -16777216;
        this.zze = 0;
        this.zzf = BitmapDescriptorFactory.HUE_RED;
        this.zzg = true;
        this.zzh = false;
        this.zzi = false;
        this.zzj = 0;
        this.zzk = null;
        this.zza = new ArrayList();
        this.zzb = new ArrayList();
    }

    PolygonOptions(List list, List list2, float f3, int i3, int i4, float f4, boolean z3, boolean z4, boolean z5, int i5, List list3) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = f3;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = f4;
        this.zzg = z3;
        this.zzh = z4;
        this.zzi = z5;
        this.zzj = i5;
        this.zzk = list3;
    }

    public PolygonOptions add(LatLng latLng) {
        Preconditions.checkNotNull(latLng, "point must not be null.");
        this.zza.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        Preconditions.checkNotNull(latLngArr, "points must not be null.");
        this.zza.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zza.add(it.next());
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.zzb.add(arrayList);
        return this;
    }

    public PolygonOptions clickable(boolean z3) {
        this.zzi = z3;
        return this;
    }

    public PolygonOptions fillColor(int i3) {
        this.zze = i3;
        return this;
    }

    public PolygonOptions geodesic(boolean z3) {
        this.zzh = z3;
        return this;
    }

    public int getFillColor() {
        return this.zze;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzb;
    }

    public List<LatLng> getPoints() {
        return this.zza;
    }

    public int getStrokeColor() {
        return this.zzd;
    }

    public int getStrokeJointType() {
        return this.zzj;
    }

    public List<PatternItem> getStrokePattern() {
        return this.zzk;
    }

    public float getStrokeWidth() {
        return this.zzc;
    }

    public float getZIndex() {
        return this.zzf;
    }

    public boolean isClickable() {
        return this.zzi;
    }

    public boolean isGeodesic() {
        return this.zzh;
    }

    public boolean isVisible() {
        return this.zzg;
    }

    public PolygonOptions strokeColor(int i3) {
        this.zzd = i3;
        return this;
    }

    public PolygonOptions strokeJointType(int i3) {
        this.zzj = i3;
        return this;
    }

    public PolygonOptions strokePattern(List<PatternItem> list) {
        this.zzk = list;
        return this;
    }

    public PolygonOptions strokeWidth(float f3) {
        this.zzc = f3;
        return this;
    }

    public PolygonOptions visible(boolean z3) {
        this.zzg = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeList(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 10, isClickable());
        SafeParcelWriter.writeInt(parcel, 11, getStrokeJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public PolygonOptions zIndex(float f3) {
        this.zzf = f3;
        return this;
    }
}
