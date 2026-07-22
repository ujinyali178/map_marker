package d2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.d;
import d2.a;
import io.flutter.plugins.urllauncher.WebViewActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
final class i implements a.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2462a;

    /* renamed from: b, reason: collision with root package name */
    private final a f2463b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f2464c;

    interface a {
        String a(Intent intent);
    }

    i(final Context context) {
        this(context, new a() { // from class: d2.h
            @Override // d2.i.a
            public final String a(Intent intent) {
                String j3;
                j3 = i.j(context, intent);
                return j3;
            }
        });
    }

    i(Context context, a aVar) {
        this.f2462a = context;
        this.f2463b = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean g(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            char c3 = 0;
            if (!it.hasNext()) {
                return false;
            }
            String lowerCase = it.next().toLowerCase(Locale.US);
            lowerCase.hashCode();
            switch (lowerCase.hashCode()) {
                case -1423461112:
                    if (lowerCase.equals("accept")) {
                        break;
                    }
                    c3 = 65535;
                    break;
                case -1229727188:
                    if (lowerCase.equals("content-language")) {
                        c3 = 1;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 785670158:
                    if (lowerCase.equals("content-type")) {
                        c3 = 2;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 802785917:
                    if (lowerCase.equals("accept-language")) {
                        c3 = 3;
                        break;
                    }
                    c3 = 65535;
                    break;
                default:
                    c3 = 65535;
                    break;
            }
            switch (c3) {
                case 0:
                case 1:
                case 2:
                case 3:
                default:
                    return true;
            }
        }
    }

    private void h() {
        if (this.f2464c == null) {
            throw new a.b("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        }
    }

    private static Bundle i(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String j(Context context, Intent intent) {
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity == null) {
            return null;
        }
        return resolveActivity.toShortString();
    }

    private static boolean k(Context context, Uri uri, Bundle bundle, a.C0071a c0071a) {
        androidx.browser.customtabs.d a4 = new d.b().d(c0071a.b().booleanValue()).a();
        a4.f351a.putExtra("com.android.browser.headers", bundle);
        try {
            a4.a(context, uri);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // d2.a.c
    public Boolean a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return this.f2463b.a(intent) == null ? Boolean.FALSE : Boolean.valueOf(!"{com.android.fallback/com.android.fallback.Fallback}".equals(r3));
    }

    @Override // d2.a.c
    public Boolean b(String str, Boolean bool, a.e eVar, a.C0071a c0071a) {
        h();
        Bundle i3 = i(eVar.d());
        if (bool.booleanValue() && !g(eVar.d())) {
            if (k(this.f2464c, Uri.parse(str), i3, c0071a)) {
                return Boolean.TRUE;
            }
        }
        try {
            this.f2464c.startActivity(WebViewActivity.a(this.f2464c, str, eVar.c().booleanValue(), eVar.b().booleanValue(), i3));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    @Override // d2.a.c
    public Boolean c() {
        return Boolean.valueOf(androidx.browser.customtabs.c.a(this.f2462a, Collections.emptyList()) != null);
    }

    @Override // d2.a.c
    public void d() {
        this.f2462a.sendBroadcast(new Intent("close action"));
    }

    @Override // d2.a.c
    public Boolean e(String str, Map<String, String> map) {
        h();
        try {
            this.f2464c.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", i(map)));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    void l(Activity activity) {
        this.f2464c = activity;
    }
}
