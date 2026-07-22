package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsService;
import androidx.collection.g;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
public abstract class CustomTabsService extends Service {

    /* renamed from: c, reason: collision with root package name */
    final g<IBinder, IBinder.DeathRecipient> f338c = new g<>();

    /* renamed from: d, reason: collision with root package name */
    private ICustomTabsService.Stub f339d = new a();

    class a extends ICustomTabsService.Stub {
        a() {
        }

        private PendingIntent c(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(f fVar) {
            CustomTabsService.this.a(fVar);
        }

        private boolean e(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
            final f fVar = new f(iCustomTabsCallback, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.e
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        CustomTabsService.a.this.d(fVar);
                    }
                };
                synchronized (CustomTabsService.this.f338c) {
                    iCustomTabsCallback.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f338c.put(iCustomTabsCallback.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.d(fVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.c(new f(iCustomTabsCallback, c(bundle)), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            return e(iCustomTabsCallback, null);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return e(iCustomTabsCallback, c(bundle));
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return CustomTabsService.this.e(new f(iCustomTabsCallback, c(bundle)), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle) {
            return CustomTabsService.this.f(new f(iCustomTabsCallback, c(bundle)), uri, i3, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.g(new f(iCustomTabsCallback, null), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return CustomTabsService.this.g(new f(iCustomTabsCallback, c(bundle)), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.h(new f(iCustomTabsCallback, c(bundle)), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
            return CustomTabsService.this.i(new f(iCustomTabsCallback, c(bundle)), i3, uri, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j3) {
            return CustomTabsService.this.j(j3);
        }
    }

    protected boolean a(f fVar) {
        try {
            synchronized (this.f338c) {
                IBinder a4 = fVar.a();
                if (a4 == null) {
                    return false;
                }
                a4.unlinkToDeath(this.f338c.get(a4), 0);
                this.f338c.remove(a4);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    protected abstract Bundle b(String str, Bundle bundle);

    protected abstract boolean c(f fVar, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean d(f fVar);

    protected abstract int e(f fVar, String str, Bundle bundle);

    protected abstract boolean f(f fVar, Uri uri, int i3, Bundle bundle);

    protected abstract boolean g(f fVar, Uri uri);

    protected abstract boolean h(f fVar, Bundle bundle);

    protected abstract boolean i(f fVar, int i3, Uri uri, Bundle bundle);

    protected abstract boolean j(long j3);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f339d;
    }
}
