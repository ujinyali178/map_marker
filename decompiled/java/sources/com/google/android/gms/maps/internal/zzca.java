package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public final class zzca extends com.google.android.gms.internal.maps.zza implements IUiSettingsDelegate {
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isCompassEnabled() {
        Parcel zzJ = zzJ(10, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isIndoorLevelPickerEnabled() {
        Parcel zzJ = zzJ(17, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isMapToolbarEnabled() {
        Parcel zzJ = zzJ(19, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isMyLocationButtonEnabled() {
        Parcel zzJ = zzJ(11, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isRotateGesturesEnabled() {
        Parcel zzJ = zzJ(15, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isScrollGesturesEnabled() {
        Parcel zzJ = zzJ(12, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isTiltGesturesEnabled() {
        Parcel zzJ = zzJ(14, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isZoomControlsEnabled() {
        Parcel zzJ = zzJ(9, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isZoomGesturesEnabled() {
        Parcel zzJ = zzJ(13, zza());
        boolean zzf = com.google.android.gms.internal.maps.zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setAllGesturesEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(8, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setCompassEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setIndoorLevelPickerEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setMapToolbarEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setMyLocationButtonEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setRotateGesturesEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setScrollGesturesEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setTiltGesturesEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setZoomControlsEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setZoomGesturesEnabled(boolean z3) {
        Parcel zza = zza();
        int i3 = com.google.android.gms.internal.maps.zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(5, zza);
    }
}
