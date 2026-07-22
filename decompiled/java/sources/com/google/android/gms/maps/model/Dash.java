package com.google.android.gms.maps.model;

/* loaded from: /root/release/classes.dex */
public final class Dash extends PatternItem {
    public final float length;

    public Dash(float f3) {
        super(0, Float.valueOf(Math.max(f3, BitmapDescriptorFactory.HUE_RED)));
        this.length = Math.max(f3, BitmapDescriptorFactory.HUE_RED);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public String toString() {
        return "[Dash: length=" + this.length + "]";
    }
}
