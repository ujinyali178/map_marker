package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.browser.trusted.d;
import androidx.core.app.s0;
import g.g;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public abstract class TrustedWebActivityService extends Service {

    /* renamed from: c, reason: collision with root package name */
    private NotificationManager f368c;

    /* renamed from: d, reason: collision with root package name */
    int f369d = -1;

    /* renamed from: f, reason: collision with root package name */
    private final ITrustedWebActivityService.Stub f370f = new a();

    class a extends ITrustedWebActivityService.Stub {
        a() {
        }

        private void b() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.f369d == -1) {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                TrustedWebActivityService.this.c().a();
                TrustedWebActivityService.this.getPackageManager();
            }
            if (TrustedWebActivityService.this.f369d != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle areNotificationsEnabled(Bundle bundle) {
            b();
            return new d.e(TrustedWebActivityService.this.d(d.c.a(bundle).f376a)).a();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public void cancelNotification(Bundle bundle) {
            b();
            d.b a4 = d.b.a(bundle);
            TrustedWebActivityService.this.e(a4.f374a, a4.f375b);
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
            b();
            return TrustedWebActivityService.this.f(str, bundle, c.a(iBinder));
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getActiveNotifications() {
            b();
            return new d.a(TrustedWebActivityService.this.g()).a();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getSmallIconBitmap() {
            b();
            return TrustedWebActivityService.this.h();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public int getSmallIconId() {
            b();
            return TrustedWebActivityService.this.i();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            b();
            d.C0005d a4 = d.C0005d.a(bundle);
            return new d.e(TrustedWebActivityService.this.j(a4.f377a, a4.f378b, a4.f379c, a4.f380d)).a();
        }
    }

    private static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    private void b() {
        if (this.f368c == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract g c();

    public boolean d(String str) {
        b();
        if (!s0.c(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return b.b(this.f368c, a(str));
    }

    public void e(String str, int i3) {
        b();
        this.f368c.cancel(str, i3);
    }

    public Bundle f(String str, Bundle bundle, c cVar) {
        return null;
    }

    public Parcelable[] g() {
        b();
        if (Build.VERSION.SDK_INT >= 23) {
            return androidx.browser.trusted.a.a(this.f368c);
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    public Bundle h() {
        int i3 = i();
        Bundle bundle = new Bundle();
        if (i3 == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i3));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean j(String str, int i3, Notification notification, String str2) {
        b();
        if (!s0.c(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String a4 = a(str2);
            notification = b.a(this, this.f368c, notification, a4, str2);
            if (!b.b(this.f368c, a4)) {
                return false;
            }
        }
        this.f368c.notify(str, i3, notification);
        return true;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f370f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f368c = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.f369d = -1;
        return super.onUnbind(intent);
    }
}
