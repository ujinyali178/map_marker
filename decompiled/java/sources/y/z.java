package y;

import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private final l f4651a;

    /* renamed from: b, reason: collision with root package name */
    private final long f4652b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4653c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f4654d;

    private z(l lVar, long j3, long j4, boolean z3) {
        this.f4651a = lVar;
        this.f4652b = j3;
        this.f4653c = j4;
        this.f4654d = z3;
    }

    public static z e(Map<String, Object> map) {
        if (map == null) {
            return new z(l.best, 0L, 5000L, false);
        }
        Integer num = (Integer) map.get("accuracy");
        Integer num2 = (Integer) map.get("distanceFilter");
        Integer num3 = (Integer) map.get("timeInterval");
        Boolean bool = (Boolean) map.get("useMSLAltitude");
        l lVar = l.best;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                lVar = l.lowest;
            } else if (intValue == 1) {
                lVar = l.low;
            } else if (intValue == 2) {
                lVar = l.medium;
            } else if (intValue == 3) {
                lVar = l.high;
            } else if (intValue == 5) {
                lVar = l.bestForNavigation;
            }
        }
        return new z(lVar, num2 != null ? num2.intValue() : 0L, num3 != null ? num3.intValue() : 5000L, bool != null && bool.booleanValue());
    }

    public l a() {
        return this.f4651a;
    }

    public long b() {
        return this.f4652b;
    }

    public long c() {
        return this.f4653c;
    }

    public boolean d() {
        return this.f4654d;
    }
}
