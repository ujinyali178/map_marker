package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f2933b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f2934a = new HashMap();

    b() {
    }

    public static b b() {
        if (f2933b == null) {
            f2933b = new b();
        }
        return f2933b;
    }

    public a a(String str) {
        return this.f2934a.get(str);
    }

    public void c(String str, a aVar) {
        if (aVar != null) {
            this.f2934a.put(str, aVar);
        } else {
            this.f2934a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
