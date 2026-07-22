package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;

/* loaded from: /root/release/classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    final ICustomTabsCallback f364a;

    /* renamed from: b, reason: collision with root package name */
    private final PendingIntent f365b;

    /* renamed from: c, reason: collision with root package name */
    private final b f366c;

    class a extends b {
        a() {
        }
    }

    f(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f364a = iCustomTabsCallback;
        this.f365b = pendingIntent;
        this.f366c = iCustomTabsCallback == null ? null : new a();
    }

    private IBinder b() {
        ICustomTabsCallback iCustomTabsCallback = this.f364a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.f364a;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    PendingIntent c() {
        return this.f365b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        PendingIntent c3 = fVar.c();
        PendingIntent pendingIntent = this.f365b;
        if ((pendingIntent == null) != (c3 == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(c3) : b().equals(fVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f365b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
