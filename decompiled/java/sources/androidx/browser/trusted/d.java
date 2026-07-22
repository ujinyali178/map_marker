package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: /root/release/classes.dex */
public final class d {

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Parcelable[] f373a;

        a(Parcelable[] parcelableArr) {
            this.f373a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f373a);
            return bundle;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f374a;

        /* renamed from: b, reason: collision with root package name */
        public final int f375b;

        b(String str, int i3) {
            this.f374a = str;
            this.f375b = i3;
        }

        public static b a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f376a;

        c(String str) {
            this.f376a = str;
        }

        public static c a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* renamed from: androidx.browser.trusted.d$d, reason: collision with other inner class name */
    static class C0005d {

        /* renamed from: a, reason: collision with root package name */
        public final String f377a;

        /* renamed from: b, reason: collision with root package name */
        public final int f378b;

        /* renamed from: c, reason: collision with root package name */
        public final Notification f379c;

        /* renamed from: d, reason: collision with root package name */
        public final String f380d;

        C0005d(String str, int i3, Notification notification, String str2) {
            this.f377a = str;
            this.f378b = i3;
            this.f379c = notification;
            this.f380d = str2;
        }

        public static C0005d a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            d.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new C0005d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f381a;

        e(boolean z3) {
            this.f381a = z3;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f381a);
            return bundle;
        }
    }

    static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}
