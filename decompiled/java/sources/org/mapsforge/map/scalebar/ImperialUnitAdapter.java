package org.mapsforge.map.scalebar;

/* loaded from: /root/release/classes2.dex */
public class ImperialUnitAdapter implements DistanceUnitAdapter {
    public static final double METER_FOOT_RATIO = 0.3048d;
    public static final ImperialUnitAdapter INSTANCE = new ImperialUnitAdapter();
    public static final int ONE_MILE = 5280;
    public static final int[] SCALE_BAR_VALUES = {26400000, 10560000, 5280000, 2640000, 1056000, 528000, 264000, 105600, 52800, 26400, 10560, ONE_MILE, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    @Override // org.mapsforge.map.scalebar.DistanceUnitAdapter
    public double getMeterRatio() {
        return 0.3048d;
    }

    @Override // org.mapsforge.map.scalebar.DistanceUnitAdapter
    public int[] getScaleBarValues() {
        return SCALE_BAR_VALUES;
    }

    @Override // org.mapsforge.map.scalebar.DistanceUnitAdapter
    public String getScaleText(int i3) {
        if (i3 < 5280) {
            return i3 + " ft";
        }
        return (i3 / ONE_MILE) + " mi";
    }
}
