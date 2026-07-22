package y;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.s;
import androidx.core.app.s0;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4584a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f4585b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4586c;

    /* renamed from: d, reason: collision with root package name */
    private s.d f4587d;

    public b(Context context, String str, Integer num, d dVar) {
        this.f4584a = context;
        this.f4585b = num;
        this.f4586c = str;
        this.f4587d = new s.d(context, str).n(1);
        e(dVar, false);
    }

    private PendingIntent b() {
        Intent launchIntentForPackage = this.f4584a.getPackageManager().getLaunchIntentForPackage(this.f4584a.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.setFlags(270532608);
        return PendingIntent.getActivity(this.f4584a, 0, launchIntentForPackage, Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
    }

    private int c(String str, String str2) {
        return this.f4584a.getResources().getIdentifier(str, str2, this.f4584a.getPackageName());
    }

    private void e(d dVar, boolean z3) {
        int c3 = c(dVar.c().b(), dVar.c().a());
        if (c3 == 0) {
            c("ic_launcher.png", "mipmap");
        }
        this.f4587d = this.f4587d.j(dVar.e()).o(c3).i(dVar.d()).h(b()).m(dVar.h());
        Integer a4 = dVar.a();
        if (a4 != null) {
            this.f4587d = this.f4587d.g(a4.intValue());
        }
        if (z3) {
            s0.c(this.f4584a).e(this.f4585b.intValue(), this.f4587d.b());
        }
    }

    public Notification a() {
        return this.f4587d.b();
    }

    public void d(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            s0 c3 = s0.c(this.f4584a);
            NotificationChannel notificationChannel = new NotificationChannel(this.f4586c, str, 0);
            notificationChannel.setLockscreenVisibility(0);
            c3.b(notificationChannel);
        }
    }

    public void f(d dVar, boolean z3) {
        e(dVar, z3);
    }
}
