package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.e0;

/* loaded from: /root/release/classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final long f3877a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f3878b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f3879c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f3880d;

    /* renamed from: e, reason: collision with root package name */
    public static g f3881e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f3882f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f3883g;

    static {
        long e3;
        int a4;
        int d3;
        int d4;
        long e4;
        e3 = e0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f3877a = e3;
        a4 = s2.f.a(c0.a(), 2);
        d3 = e0.d("kotlinx.coroutines.scheduler.core.pool.size", a4, 1, 0, 8, null);
        f3878b = d3;
        d4 = e0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f3879c = d4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e4 = e0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f3880d = timeUnit.toNanos(e4);
        f3881e = e.f3867a;
        f3882f = new j(0);
        f3883g = new j(1);
    }
}
