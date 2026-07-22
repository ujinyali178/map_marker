package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f2967b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, d> f2968a = new HashMap();

    e() {
    }

    public static e b() {
        if (f2967b == null) {
            synchronized (e.class) {
                if (f2967b == null) {
                    f2967b = new e();
                }
            }
        }
        return f2967b;
    }

    public d a(String str) {
        return this.f2968a.get(str);
    }
}
