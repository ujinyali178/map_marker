package com.google.maps.android.data;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Observable;

/* loaded from: /root/release/classes.dex */
public abstract class Style extends Observable {
    protected MarkerOptions mMarkerOptions = new MarkerOptions();
    protected PolygonOptions mPolygonOptions;
    protected PolylineOptions mPolylineOptions;

    public Style() {
        PolylineOptions polylineOptions = new PolylineOptions();
        this.mPolylineOptions = polylineOptions;
        polylineOptions.clickable(true);
        PolygonOptions polygonOptions = new PolygonOptions();
        this.mPolygonOptions = polygonOptions;
        polygonOptions.clickable(true);
    }

    public float getRotation() {
        return this.mMarkerOptions.getRotation();
    }

    public void setLineStringWidth(float f3) {
        this.mPolylineOptions.width(f3);
    }

    public void setMarkerHotSpot(float f3, float f4, String str, String str2) {
        if (!str.equals("fraction")) {
            f3 = 0.5f;
        }
        if (!str2.equals("fraction")) {
            f4 = 1.0f;
        }
        this.mMarkerOptions.anchor(f3, f4);
    }

    public void setMarkerRotation(float f3) {
        this.mMarkerOptions.rotation(f3);
    }

    public void setPolygonFillColor(int i3) {
        this.mPolygonOptions.fillColor(i3);
    }

    public void setPolygonStrokeWidth(float f3) {
        this.mPolygonOptions.strokeWidth(f3);
    }
}
