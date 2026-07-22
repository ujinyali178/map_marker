package org.mapsforge.map.scalebar;

import com.google.android.gms.common.util.GmsVersion;

/* loaded from: /root/release/classes2.dex */
public class MetricUnitAdapter implements DistanceUnitAdapter {
    public static final int ONE_KILOMETER = 1000;
    public static final MetricUnitAdapter INSTANCE = new MetricUnitAdapter();
    public static final int[] SCALE_BAR_VALUES = {10000000, GmsVersion.VERSION_LONGHORN, 2000000, 1000000, 500000, 200000, 100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    @Override // org.mapsforge.map.scalebar.DistanceUnitAdapter
    public double getMeterRatio() {
        return 1.0d;
    }

    @Override // org.mapsforge.map.scalebar.DistanceUnitAdapter
    public int[] getScaleBarValues() {
        return SCALE_BAR_VALUES;
    }

    @Override // org.mapsforge.map.scalebar.DistanceUnitAdapter
    public String getScaleText(int i3) {
        if (i3 < 1000) {
            return i3 + " m";
        }
        return (i3 / 1000) + " km";
    }
}
