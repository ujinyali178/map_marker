package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f343a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f344b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f345c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f346d;

    /* renamed from: androidx.browser.customtabs.a$a, reason: collision with other inner class name */
    public static final class C0004a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f347a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f348b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f349c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f350d;

        public a a() {
            return new a(this.f347a, this.f348b, this.f349c, this.f350d);
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f343a = num;
        this.f344b = num2;
        this.f345c = num3;
        this.f346d = num4;
    }

    Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f343a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f344b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f345c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f346d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
