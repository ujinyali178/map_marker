package y;

import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f4589a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4590b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4591c;

    /* renamed from: d, reason: collision with root package name */
    private final a f4592d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f4593e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f4594f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4595g;

    /* renamed from: h, reason: collision with root package name */
    private final Integer f4596h;

    private d(String str, String str2, String str3, a aVar, boolean z3, boolean z4, boolean z5, Integer num) {
        this.f4589a = str;
        this.f4590b = str2;
        this.f4591c = str3;
        this.f4592d = aVar;
        this.f4593e = z3;
        this.f4594f = z4;
        this.f4595g = z5;
        this.f4596h = num;
    }

    public static d i(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        a c3 = a.c((Map) map.get("notificationIcon"));
        String str = (String) map.get("notificationTitle");
        String str2 = (String) map.get("notificationChannelName");
        String str3 = (String) map.get("notificationText");
        Boolean bool = (Boolean) map.get("enableWifiLock");
        Boolean bool2 = (Boolean) map.get("enableWakeLock");
        Boolean bool3 = (Boolean) map.get("setOngoing");
        Object obj = map.get("color");
        return new d(str, str3, str2, c3, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), obj != null ? Integer.valueOf(((Number) obj).intValue()) : null);
    }

    public Integer a() {
        return this.f4596h;
    }

    public String b() {
        return this.f4591c;
    }

    public a c() {
        return this.f4592d;
    }

    public String d() {
        return this.f4590b;
    }

    public String e() {
        return this.f4589a;
    }

    public boolean f() {
        return this.f4594f;
    }

    public boolean g() {
        return this.f4593e;
    }

    public boolean h() {
        return this.f4595g;
    }
}
