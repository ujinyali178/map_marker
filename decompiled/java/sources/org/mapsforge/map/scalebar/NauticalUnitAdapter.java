package org.mapsforge.map.scalebar;

/* loaded from: /root/release/classes2.dex */
public class NauticalUnitAdapter implements DistanceUnitAdapter {
    public static final NauticalUnitAdapter INSTANCE = new NauticalUnitAdapter();
    public static final int ONE_MILE = 1852;
    public static final int[] SCALE_BAR_VALUES = {9260000, 3704000, 1852000, 926000, 370400, 185200, 92600, 37040, 18520, 9260, 3704, ONE_MILE, 926, 500, 200, 100, 50, 20, 10, 5, 2, 1};

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
        StringBuilder sb;
        String str;
        if (i3 < 926) {
            sb = new StringBuilder();
            sb.append(i3);
            str = " m";
        } else {
            if (i3 == 926) {
                return "0.5 nmi";
            }
            sb = new StringBuilder();
            sb.append(i3 / ONE_MILE);
            str = " nmi";
        }
        sb.append(str);
        return sb.toString();
    }
}
