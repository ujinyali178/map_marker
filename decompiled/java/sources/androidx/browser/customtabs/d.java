package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.browser.customtabs.a;
import androidx.core.app.m;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f351a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f352b;

    private static class a {
        static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<Bundle> f355c;

        /* renamed from: d, reason: collision with root package name */
        private Bundle f356d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<Bundle> f357e;

        /* renamed from: f, reason: collision with root package name */
        private SparseArray<Bundle> f358f;

        /* renamed from: g, reason: collision with root package name */
        private Bundle f359g;

        /* renamed from: a, reason: collision with root package name */
        private final Intent f353a = new Intent("android.intent.action.VIEW");

        /* renamed from: b, reason: collision with root package name */
        private final a.C0004a f354b = new a.C0004a();

        /* renamed from: h, reason: collision with root package name */
        private int f360h = 0;

        /* renamed from: i, reason: collision with root package name */
        private boolean f361i = true;

        private void b() {
            String a4 = a.a();
            if (TextUtils.isEmpty(a4)) {
                return;
            }
            Bundle bundleExtra = this.f353a.hasExtra("com.android.browser.headers") ? this.f353a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey(HttpHeaders.ACCEPT_LANGUAGE)) {
                return;
            }
            bundleExtra.putString(HttpHeaders.ACCEPT_LANGUAGE, a4);
            this.f353a.putExtra("com.android.browser.headers", bundleExtra);
        }

        private void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            m.a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f353a.putExtras(bundle);
        }

        public d a() {
            if (!this.f353a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList<Bundle> arrayList = this.f355c;
            if (arrayList != null) {
                this.f353a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f357e;
            if (arrayList2 != null) {
                this.f353a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f353a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f361i);
            this.f353a.putExtras(this.f354b.a().a());
            Bundle bundle = this.f359g;
            if (bundle != null) {
                this.f353a.putExtras(bundle);
            }
            if (this.f358f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f358f);
                this.f353a.putExtras(bundle2);
            }
            this.f353a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f360h);
            if (Build.VERSION.SDK_INT >= 24) {
                b();
            }
            return new d(this.f353a, this.f356d);
        }

        public b d(boolean z3) {
            this.f353a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z3 ? 1 : 0);
            return this;
        }
    }

    d(Intent intent, Bundle bundle) {
        this.f351a = intent;
        this.f352b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f351a.setData(uri);
        androidx.core.content.a.startActivity(context, this.f351a, this.f352b);
    }
}
