package c1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: /root/release/classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private Activity f2072a;

    /* renamed from: b, reason: collision with root package name */
    private Context f2073b;

    public b(Activity activity, Context context) {
        this.f2072a = activity;
        this.f2073b = context;
    }

    Intent a(String str, Integer num, String str2, Uri uri, Bundle bundle, String str3, ComponentName componentName, String str4) {
        if (this.f2073b == null) {
            Log.wtf("IntentSender", "Trying to build an intent before the applicationContext was initialized.");
            return null;
        }
        Intent intent = new Intent();
        if (str != null) {
            intent.setAction(str);
        }
        if (num != null) {
            intent.addFlags(num.intValue());
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.addCategory(str2);
        }
        if (uri != null && str4 == null) {
            intent.setData(uri);
        }
        if (str4 != null && uri == null) {
            intent.setType(str4);
        }
        if (str4 != null && uri != null) {
            intent.setDataAndType(uri, str4);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.setPackage(str3);
            if (componentName != null) {
                intent.setComponent(componentName);
            }
        }
        return intent;
    }

    boolean b(Intent intent) {
        Context context = this.f2073b;
        if (context != null) {
            return context.getPackageManager().resolveActivity(intent, 65536) != null;
        }
        Log.wtf("IntentSender", "Trying to resolve an activity before the applicationContext was initialized.");
        return false;
    }

    public void c(Intent intent, String str) {
        d(Intent.createChooser(intent, str));
    }

    void d(Intent intent) {
        if (this.f2073b == null) {
            Log.wtf("IntentSender", "Trying to send an intent before the applicationContext was initialized.");
            return;
        }
        Log.v("IntentSender", "Sending intent " + intent);
        Activity activity = this.f2072a;
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            this.f2073b.startActivity(intent);
        }
    }

    public void e(Intent intent) {
        if (this.f2073b == null) {
            Log.wtf("IntentSender", "Trying to send broadcast before the applicationContext was initialized.");
            return;
        }
        Log.v("IntentSender", "Sending broadcast " + intent);
        this.f2073b.sendBroadcast(intent);
    }

    void f(Activity activity) {
        this.f2072a = activity;
    }

    void g(Context context) {
        this.f2073b = context;
    }
}
