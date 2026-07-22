package com.google.android.gms.maps.model;

/* loaded from: /root/release/classes.dex */
public final class Gap extends PatternItem {
    public final float length;

    public Gap(float f3) {
        super(2, Float.valueOf(Math.max(f3, BitmapDescriptorFactory.HUE_RED)));
        this.length = Math.max(f3, BitmapDescriptorFactory.HUE_RED);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public String toString() {
        return "[Gap: length=" + this.length + "]";
    }
}
