package androidx.core.location;

import android.annotation.NonNull;
import android.location.LocationRequest;
import android.os.Build;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /root/release/classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    final int f715a;

    /* renamed from: b, reason: collision with root package name */
    final long f716b;

    /* renamed from: c, reason: collision with root package name */
    final long f717c;

    /* renamed from: d, reason: collision with root package name */
    final long f718d;

    /* renamed from: e, reason: collision with root package name */
    final int f719e;

    /* renamed from: f, reason: collision with root package name */
    final float f720f;

    /* renamed from: g, reason: collision with root package name */
    final long f721g;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Class<?> f722a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f723b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f724c;

        /* renamed from: d, reason: collision with root package name */
        private static Method f725d;

        /* renamed from: e, reason: collision with root package name */
        private static Method f726e;

        /* renamed from: f, reason: collision with root package name */
        private static Method f727f;

        public static Object a(m mVar, String str) {
            try {
                if (f722a == null) {
                    f722a = Class.forName("android.location.LocationRequest");
                }
                if (f723b == null) {
                    Method declaredMethod = f722a.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                    f723b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = f723b.invoke(null, str, Long.valueOf(mVar.b()), Float.valueOf(mVar.e()), Boolean.FALSE);
                if (invoke == null) {
                    return null;
                }
                if (f724c == null) {
                    Method declaredMethod2 = f722a.getDeclaredMethod("setQuality", Integer.TYPE);
                    f724c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f724c.invoke(invoke, Integer.valueOf(mVar.g()));
                if (f725d == null) {
                    Method declaredMethod3 = f722a.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    f725d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f725d.invoke(invoke, Long.valueOf(mVar.f()));
                if (mVar.d() < Integer.MAX_VALUE) {
                    if (f726e == null) {
                        Method declaredMethod4 = f722a.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                        f726e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f726e.invoke(invoke, Integer.valueOf(mVar.d()));
                }
                if (mVar.a() < Long.MAX_VALUE) {
                    if (f727f == null) {
                        Method declaredMethod5 = f722a.getDeclaredMethod("setExpireIn", Long.TYPE);
                        f727f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f727f.invoke(invoke, Long.valueOf(mVar.a()));
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    private static class b {
        public static LocationRequest a(m mVar) {
            return new Object(mVar.b()) { // from class: android.location.LocationRequest.Builder
                static {
                    throw new NoClassDefFoundError();
                }

                public /* synthetic */ Builder(long j3) {
                }

                @NonNull
                public native /* synthetic */ LocationRequest build();

                @NonNull
                public native /* synthetic */ Builder setDurationMillis(long j3);

                @NonNull
                public native /* synthetic */ Builder setMaxUpdateDelayMillis(long j3);

                @NonNull
                public native /* synthetic */ Builder setMaxUpdates(int i3);

                @NonNull
                public native /* synthetic */ Builder setMinUpdateDistanceMeters(float f3);

                @NonNull
                public native /* synthetic */ Builder setMinUpdateIntervalMillis(long j3);

                @NonNull
                public native /* synthetic */ Builder setQuality(int i3);
            }.setQuality(mVar.g()).setMinUpdateIntervalMillis(mVar.f()).setDurationMillis(mVar.a()).setMaxUpdates(mVar.d()).setMinUpdateDistanceMeters(mVar.e()).setMaxUpdateDelayMillis(mVar.c()).build();
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private long f728a;

        /* renamed from: b, reason: collision with root package name */
        private int f729b;

        /* renamed from: c, reason: collision with root package name */
        private long f730c;

        /* renamed from: d, reason: collision with root package name */
        private int f731d;

        /* renamed from: e, reason: collision with root package name */
        private long f732e;

        /* renamed from: f, reason: collision with root package name */
        private float f733f;

        /* renamed from: g, reason: collision with root package name */
        private long f734g;

        public c(long j3) {
            b(j3);
            this.f729b = 102;
            this.f730c = Long.MAX_VALUE;
            this.f731d = Integer.MAX_VALUE;
            this.f732e = -1L;
            this.f733f = BitmapDescriptorFactory.HUE_RED;
            this.f734g = 0L;
        }

        public m a() {
            androidx.core.util.d.g((this.f728a == Long.MAX_VALUE && this.f732e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j3 = this.f728a;
            return new m(j3, this.f729b, this.f730c, this.f731d, Math.min(this.f732e, j3), this.f733f, this.f734g);
        }

        public c b(long j3) {
            this.f728a = androidx.core.util.d.d(j3, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public c c(float f3) {
            this.f733f = f3;
            this.f733f = androidx.core.util.d.c(f3, BitmapDescriptorFactory.HUE_RED, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public c d(long j3) {
            this.f732e = androidx.core.util.d.d(j3, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public c e(int i3) {
            androidx.core.util.d.a(i3 == 104 || i3 == 102 || i3 == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i3));
            this.f729b = i3;
            return this;
        }
    }

    m(long j3, int i3, long j4, int i4, long j5, float f3, long j6) {
        this.f716b = j3;
        this.f715a = i3;
        this.f717c = j5;
        this.f718d = j4;
        this.f719e = i4;
        this.f720f = f3;
        this.f721g = j6;
    }

    public long a() {
        return this.f718d;
    }

    public long b() {
        return this.f716b;
    }

    public long c() {
        return this.f721g;
    }

    public int d() {
        return this.f719e;
    }

    public float e() {
        return this.f720f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f715a == mVar.f715a && this.f716b == mVar.f716b && this.f717c == mVar.f717c && this.f718d == mVar.f718d && this.f719e == mVar.f719e && Float.compare(mVar.f720f, this.f720f) == 0 && this.f721g == mVar.f721g;
    }

    public long f() {
        long j3 = this.f717c;
        return j3 == -1 ? this.f716b : j3;
    }

    public int g() {
        return this.f715a;
    }

    public LocationRequest h() {
        return b.a(this);
    }

    public int hashCode() {
        int i3 = this.f715a * 31;
        long j3 = this.f716b;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f717c;
        return i4 + ((int) (j4 ^ (j4 >>> 32)));
    }

    public LocationRequest i(String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : (LocationRequest) a.a(this, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Request["
            r0.append(r1)
            long r1 = r6.f716b
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L37
            java.lang.String r1 = "@"
            r0.append(r1)
            long r1 = r6.f716b
            androidx.core.util.f.b(r1, r0)
            int r1 = r6.f715a
            r2 = 100
            if (r1 == r2) goto L34
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L31
            r2 = 104(0x68, float:1.46E-43)
            if (r1 == r2) goto L2e
            goto L3c
        L2e:
            java.lang.String r1 = " LOW_POWER"
            goto L39
        L31:
            java.lang.String r1 = " BALANCED"
            goto L39
        L34:
            java.lang.String r1 = " HIGH_ACCURACY"
            goto L39
        L37:
            java.lang.String r1 = "PASSIVE"
        L39:
            r0.append(r1)
        L3c:
            long r1 = r6.f718d
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L4c
            java.lang.String r1 = ", duration="
            r0.append(r1)
            long r1 = r6.f718d
            androidx.core.util.f.b(r1, r0)
        L4c:
            int r1 = r6.f719e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r2) goto L5d
            java.lang.String r1 = ", maxUpdates="
            r0.append(r1)
            int r1 = r6.f719e
            r0.append(r1)
        L5d:
            long r1 = r6.f717c
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L75
            long r3 = r6.f716b
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L75
            java.lang.String r1 = ", minUpdateInterval="
            r0.append(r1)
            long r1 = r6.f717c
            androidx.core.util.f.b(r1, r0)
        L75:
            float r1 = r6.f720f
            double r1 = (double) r1
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L88
            java.lang.String r1 = ", minUpdateDistance="
            r0.append(r1)
            float r1 = r6.f720f
            r0.append(r1)
        L88:
            long r1 = r6.f721g
            r3 = 2
            long r1 = r1 / r3
            long r3 = r6.f716b
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L9d
            java.lang.String r1 = ", maxUpdateDelay="
            r0.append(r1)
            long r1 = r6.f721g
            androidx.core.util.f.b(r1, r0)
        L9d:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.m.toString():java.lang.String");
    }
}
