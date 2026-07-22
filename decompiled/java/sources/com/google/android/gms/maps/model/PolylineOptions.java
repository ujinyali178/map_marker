package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.StrokeStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzr();
    private final List zza;
    private float zzb;
    private int zzc;
    private float zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private Cap zzh;
    private Cap zzi;
    private int zzj;
    private List zzk;
    private List zzl;

    public PolylineOptions() {
        this.zzb = 10.0f;
        this.zzc = -16777216;
        this.zzd = BitmapDescriptorFactory.HUE_RED;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = new ArrayList();
    }

    PolylineOptions(List list, float f3, int i3, float f4, boolean z3, boolean z4, boolean z5, Cap cap, Cap cap2, int i4, List list2, List list3) {
        this.zzb = 10.0f;
        this.zzc = -16777216;
        this.zzd = BitmapDescriptorFactory.HUE_RED;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = list;
        this.zzb = f3;
        this.zzc = i3;
        this.zzd = f4;
        this.zze = z3;
        this.zzf = z4;
        this.zzg = z5;
        if (cap != null) {
            this.zzh = cap;
        }
        if (cap2 != null) {
            this.zzi = cap2;
        }
        this.zzj = i4;
        this.zzk = list2;
        if (list3 != null) {
            this.zzl = list3;
        }
    }

    public PolylineOptions add(LatLng latLng) {
        Preconditions.checkNotNull(this.zza, "point must not be null.");
        this.zza.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        Preconditions.checkNotNull(latLngArr, "points must not be null.");
        Collections.addAll(this.zza, latLngArr);
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zza.add(it.next());
        }
        return this;
    }

    public PolylineOptions addAllSpans(Iterable<StyleSpan> iterable) {
        Iterator<StyleSpan> it = iterable.iterator();
        while (it.hasNext()) {
            addSpan(it.next());
        }
        return this;
    }

    public PolylineOptions addSpan(StyleSpan styleSpan) {
        this.zzl.add(styleSpan);
        return this;
    }

    public PolylineOptions addSpan(StyleSpan... styleSpanArr) {
        for (StyleSpan styleSpan : styleSpanArr) {
            addSpan(styleSpan);
        }
        return this;
    }

    public PolylineOptions clickable(boolean z3) {
        this.zzg = z3;
        return this;
    }

    public PolylineOptions color(int i3) {
        this.zzc = i3;
        return this;
    }

    public PolylineOptions endCap(Cap cap) {
        this.zzi = (Cap) Preconditions.checkNotNull(cap, "endCap must not be null");
        return this;
    }

    public PolylineOptions geodesic(boolean z3) {
        this.zzf = z3;
        return this;
    }

    public int getColor() {
        return this.zzc;
    }

    public Cap getEndCap() {
        return this.zzi.zza();
    }

    public int getJointType() {
        return this.zzj;
    }

    public List<PatternItem> getPattern() {
        return this.zzk;
    }

    public List<LatLng> getPoints() {
        return this.zza;
    }

    public Cap getStartCap() {
        return this.zzh.zza();
    }

    public float getWidth() {
        return this.zzb;
    }

    public float getZIndex() {
        return this.zzd;
    }

    public boolean isClickable() {
        return this.zzg;
    }

    public boolean isGeodesic() {
        return this.zzf;
    }

    public boolean isVisible() {
        return this.zze;
    }

    public PolylineOptions jointType(int i3) {
        this.zzj = i3;
        return this;
    }

    public PolylineOptions pattern(List<PatternItem> list) {
        this.zzk = list;
        return this;
    }

    public PolylineOptions startCap(Cap cap) {
        this.zzh = (Cap) Preconditions.checkNotNull(cap, "startCap must not be null");
        return this;
    }

    public PolylineOptions visible(boolean z3) {
        this.zze = z3;
        return this;
    }

    public PolylineOptions width(float f3) {
        this.zzb = f3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeFloat(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getColor());
        SafeParcelWriter.writeFloat(parcel, 5, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 6, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 7, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 8, isClickable());
        SafeParcelWriter.writeParcelable(parcel, 9, getStartCap(), i3, false);
        SafeParcelWriter.writeParcelable(parcel, 10, getEndCap(), i3, false);
        SafeParcelWriter.writeInt(parcel, 11, getJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getPattern(), false);
        ArrayList arrayList = new ArrayList(this.zzl.size());
        for (StyleSpan styleSpan : this.zzl) {
            StrokeStyle.Builder builder = new StrokeStyle.Builder(styleSpan.getStyle());
            builder.zzd(this.zzb);
            builder.zzc(this.zze);
            arrayList.add(new StyleSpan(builder.build(), styleSpan.getSegments()));
        }
        SafeParcelWriter.writeTypedList(parcel, 13, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public PolylineOptions zIndex(float f3) {
        this.zzd = f3;
        return this;
    }
}
