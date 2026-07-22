package y;

import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f4582a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4583b;

    private a(String str, String str2) {
        this.f4582a = str;
        this.f4583b = str2;
    }

    public static a c(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new a((String) map.get("name"), (String) map.get("defType"));
    }

    public String a() {
        return this.f4583b;
    }

    public String b() {
        return this.f4582a;
    }
}
