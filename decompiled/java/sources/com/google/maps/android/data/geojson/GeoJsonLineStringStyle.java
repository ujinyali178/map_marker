package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class GeoJsonLineStringStyle extends Style implements GeoJsonStyle {
    private static final String[] GEOMETRY_TYPE = {"LineString", "MultiLineString", "GeometryCollection"};

    public GeoJsonLineStringStyle() {
        PolylineOptions polylineOptions = new PolylineOptions();
        this.mPolylineOptions = polylineOptions;
        polylineOptions.clickable(true);
    }

    private void styleChanged() {
        setChanged();
        notifyObservers();
    }

    public int getColor() {
        return this.mPolylineOptions.getColor();
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public String[] getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public List<PatternItem> getPattern() {
        return this.mPolylineOptions.getPattern();
    }

    public float getWidth() {
        return this.mPolylineOptions.getWidth();
    }

    public float getZIndex() {
        return this.mPolylineOptions.getZIndex();
    }

    public boolean isClickable() {
        return this.mPolylineOptions.isClickable();
    }

    public boolean isGeodesic() {
        return this.mPolylineOptions.isGeodesic();
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public boolean isVisible() {
        return this.mPolylineOptions.isVisible();
    }

    public void setClickable(boolean z3) {
        this.mPolylineOptions.clickable(z3);
        styleChanged();
    }

    public void setColor(int i3) {
        this.mPolylineOptions.color(i3);
        styleChanged();
    }

    public void setGeodesic(boolean z3) {
        this.mPolylineOptions.geodesic(z3);
        styleChanged();
    }

    public void setPattern(List<PatternItem> list) {
        this.mPolylineOptions.pattern(list);
        styleChanged();
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public void setVisible(boolean z3) {
        this.mPolylineOptions.visible(z3);
        styleChanged();
    }

    public void setWidth(float f3) {
        setLineStringWidth(f3);
        styleChanged();
    }

    public void setZIndex(float f3) {
        this.mPolylineOptions.zIndex(f3);
        styleChanged();
    }

    public PolylineOptions toPolylineOptions() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(this.mPolylineOptions.getColor());
        polylineOptions.clickable(this.mPolylineOptions.isClickable());
        polylineOptions.geodesic(this.mPolylineOptions.isGeodesic());
        polylineOptions.visible(this.mPolylineOptions.isVisible());
        polylineOptions.width(this.mPolylineOptions.getWidth());
        polylineOptions.zIndex(this.mPolylineOptions.getZIndex());
        polylineOptions.pattern(getPattern());
        return polylineOptions;
    }

    public String toString() {
        return "LineStringStyle{\n geometry type=" + Arrays.toString(GEOMETRY_TYPE) + ",\n color=" + getColor() + ",\n clickable=" + isClickable() + ",\n geodesic=" + isGeodesic() + ",\n visible=" + isVisible() + ",\n width=" + getWidth() + ",\n z index=" + getZIndex() + ",\n pattern=" + getPattern() + "\n}\n";
    }
}
