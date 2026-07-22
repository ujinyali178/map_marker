package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class n implements m {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, l> f3178a = new HashMap();

    n() {
    }

    @Override // io.flutter.plugin.platform.m
    public boolean a(String str, l lVar) {
        if (this.f3178a.containsKey(str)) {
            return false;
        }
        this.f3178a.put(str, lVar);
        return true;
    }

    l b(String str) {
        return this.f3178a.get(str);
    }
}
