package com.google.maps.android.data.kml;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/* loaded from: /root/release/classes.dex */
public class KmlStyle extends Style {
    private static final int HSV_VALUES = 3;
    private static final int HUE_VALUE = 0;
    private static final int INITIAL_SCALE = 1;
    private String mIconUrl;
    private boolean mFill = true;
    private boolean mOutline = true;
    private String mStyleId = null;
    private final HashMap<String, String> mBalloonOptions = new HashMap<>();
    private final HashSet<String> mStylesSet = new HashSet<>();
    private double mScale = 1.0d;
    float mMarkerColor = BitmapDescriptorFactory.HUE_RED;
    private boolean mIconRandomColorMode = false;
    private boolean mLineRandomColorMode = false;
    private boolean mPolyRandomColorMode = false;

    KmlStyle() {
    }

    public static int computeRandomColor(int i3) {
        Random random = new Random();
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    private static String convertColor(String str) {
        StringBuilder sb;
        String substring;
        String trim = str.trim();
        if (trim.length() > 6) {
            sb = new StringBuilder();
            sb.append(trim.substring(0, 2));
            sb.append(trim.substring(6, 8));
            sb.append(trim.substring(4, 6));
            substring = trim.substring(2, 4);
        } else {
            sb = new StringBuilder();
            sb.append(trim.substring(4, 6));
            sb.append(trim.substring(2, 4));
            substring = trim.substring(0, 2);
        }
        sb.append(substring);
        return sb.toString();
    }

    private static MarkerOptions createMarkerOptions(MarkerOptions markerOptions, boolean z3, float f3) {
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.rotation(markerOptions.getRotation());
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        if (z3) {
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(getHueValue(computeRandomColor((int) f3))));
        }
        markerOptions2.icon(markerOptions.getIcon());
        return markerOptions2;
    }

    private static PolygonOptions createPolygonOptions(PolygonOptions polygonOptions, boolean z3, boolean z4) {
        float f3;
        PolygonOptions polygonOptions2 = new PolygonOptions();
        if (z3) {
            polygonOptions2.fillColor(polygonOptions.getFillColor());
        }
        if (z4) {
            polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
            f3 = polygonOptions.getStrokeWidth();
        } else {
            f3 = BitmapDescriptorFactory.HUE_RED;
        }
        polygonOptions2.strokeWidth(f3);
        polygonOptions2.clickable(polygonOptions.isClickable());
        return polygonOptions2;
    }

    private static PolylineOptions createPolylineOptions(PolylineOptions polylineOptions) {
        PolylineOptions polylineOptions2 = new PolylineOptions();
        polylineOptions2.color(polylineOptions.getColor());
        polylineOptions2.width(polylineOptions.getWidth());
        polylineOptions2.clickable(polylineOptions.isClickable());
        return polylineOptions2;
    }

    private static float getHueValue(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        return fArr[0];
    }

    public HashMap<String, String> getBalloonOptions() {
        return this.mBalloonOptions;
    }

    public double getIconScale() {
        return this.mScale;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public MarkerOptions getMarkerOptions() {
        return createMarkerOptions(this.mMarkerOptions, isIconRandomColorMode(), this.mMarkerColor);
    }

    public PolygonOptions getPolygonOptions() {
        return createPolygonOptions(this.mPolygonOptions, this.mFill, this.mOutline);
    }

    public PolylineOptions getPolylineOptions() {
        return createPolylineOptions(this.mPolylineOptions);
    }

    String getStyleId() {
        return this.mStyleId;
    }

    public boolean hasBalloonStyle() {
        return this.mBalloonOptions.size() > 0;
    }

    public boolean hasFill() {
        return this.mFill;
    }

    public boolean hasOutline() {
        return this.mOutline;
    }

    boolean isIconRandomColorMode() {
        return this.mIconRandomColorMode;
    }

    public boolean isLineRandomColorMode() {
        return this.mLineRandomColorMode;
    }

    public boolean isPolyRandomColorMode() {
        return this.mPolyRandomColorMode;
    }

    public boolean isStyleSet(String str) {
        return this.mStylesSet.contains(str);
    }

    public void setFill(boolean z3) {
        this.mFill = z3;
    }

    void setFillColor(String str) {
        setPolygonFillColor(Color.parseColor("#" + convertColor(str)));
        this.mStylesSet.add("fillColor");
    }

    void setHeading(float f3) {
        setMarkerRotation(f3);
        this.mStylesSet.add("heading");
    }

    void setHotSpot(float f3, float f4, String str, String str2) {
        setMarkerHotSpot(f3, f4, str, str2);
        this.mStylesSet.add("hotSpot");
    }

    void setIconColorMode(String str) {
        this.mIconRandomColorMode = str.equals("random");
        this.mStylesSet.add("iconColorMode");
    }

    void setIconScale(double d3) {
        this.mScale = d3;
        this.mStylesSet.add("iconScale");
    }

    void setIconUrl(String str) {
        this.mIconUrl = str;
        this.mStylesSet.add("iconUrl");
    }

    void setInfoWindowText(String str) {
        this.mBalloonOptions.put("text", str);
    }

    void setLineColorMode(String str) {
        this.mLineRandomColorMode = str.equals("random");
        this.mStylesSet.add("lineColorMode");
    }

    void setMarkerColor(String str) {
        float hueValue = getHueValue(Color.parseColor("#" + convertColor(str)));
        this.mMarkerColor = hueValue;
        this.mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(hueValue));
        this.mStylesSet.add("markerColor");
    }

    void setOutline(boolean z3) {
        this.mOutline = z3;
        this.mStylesSet.add("outline");
    }

    void setOutlineColor(String str) {
        this.mPolylineOptions.color(Color.parseColor("#" + convertColor(str)));
        this.mPolygonOptions.strokeColor(Color.parseColor("#" + convertColor(str)));
        this.mStylesSet.add("outlineColor");
    }

    void setPolyColorMode(String str) {
        this.mPolyRandomColorMode = str.equals("random");
        this.mStylesSet.add("polyColorMode");
    }

    void setStyleId(String str) {
        this.mStyleId = str;
    }

    void setWidth(Float f3) {
        setLineStringWidth(f3.floatValue());
        setPolygonStrokeWidth(f3.floatValue());
        this.mStylesSet.add("width");
    }

    public String toString() {
        return "Style{\n balloon options=" + this.mBalloonOptions + ",\n fill=" + this.mFill + ",\n outline=" + this.mOutline + ",\n icon url=" + this.mIconUrl + ",\n scale=" + this.mScale + ",\n style id=" + this.mStyleId + "\n}\n";
    }
}
