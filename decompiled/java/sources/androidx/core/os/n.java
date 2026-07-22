package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
final class n implements m {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f757a;

    n(Object obj) {
        this.f757a = (LocaleList) obj;
    }

    @Override // androidx.core.os.m
    public Object a() {
        return this.f757a;
    }

    public boolean equals(Object obj) {
        return this.f757a.equals(((m) obj).a());
    }

    @Override // androidx.core.os.m
    public Locale get(int i3) {
        return this.f757a.get(i3);
    }

    public int hashCode() {
        return this.f757a.hashCode();
    }

    @Override // androidx.core.os.m
    public boolean isEmpty() {
        return this.f757a.isEmpty();
    }

    public String toString() {
        return this.f757a.toString();
    }
}
