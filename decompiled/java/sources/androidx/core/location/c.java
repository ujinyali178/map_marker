package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.location.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static final WeakHashMap<C0014c, WeakReference<d>> f694a = new WeakHashMap<>();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Class<?> f695a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f696b;

        static boolean a(LocationManager locationManager, String str, m mVar, androidx.core.location.b bVar, Looper looper) {
            try {
                if (f695a == null) {
                    f695a = Class.forName("android.location.LocationRequest");
                }
                if (f696b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f695a, LocationListener.class, Looper.class);
                    f696b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i3 = mVar.i(str);
                if (i3 != null) {
                    f696b.invoke(locationManager, i3, bVar, looper);
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        static boolean b(LocationManager locationManager, String str, m mVar, d dVar) {
            try {
                if (f695a == null) {
                    f695a = Class.forName("android.location.LocationRequest");
                }
                if (f696b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f695a, LocationListener.class, Looper.class);
                    f696b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i3 = mVar.i(str);
                if (i3 != null) {
                    synchronized (c.f694a) {
                        f696b.invoke(locationManager, i3, dVar, Looper.getMainLooper());
                        c.a(locationManager, dVar);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    private static class b {
        static boolean a(LocationManager locationManager, String str) {
            boolean hasProvider;
            hasProvider = locationManager.hasProvider(str);
            return hasProvider;
        }

        static boolean b(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback) {
            boolean registerGnssMeasurementsCallback;
            registerGnssMeasurementsCallback = locationManager.registerGnssMeasurementsCallback(executor, callback);
            return registerGnssMeasurementsCallback;
        }

        static void c(LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    /* renamed from: androidx.core.location.c$c, reason: collision with other inner class name */
    private static class C0014c {

        /* renamed from: a, reason: collision with root package name */
        final String f697a;

        /* renamed from: b, reason: collision with root package name */
        final androidx.core.location.b f698b;

        public boolean equals(Object obj) {
            if (!(obj instanceof C0014c)) {
                return false;
            }
            C0014c c0014c = (C0014c) obj;
            return this.f697a.equals(c0014c.f697a) && this.f698b.equals(c0014c.f698b);
        }

        public int hashCode() {
            return androidx.core.util.b.b(this.f697a, this.f698b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        volatile C0014c f699a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f700b;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(int i3) {
            C0014c c0014c = this.f699a;
            if (c0014c == null) {
                return;
            }
            c0014c.f698b.onFlushComplete(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(Location location) {
            C0014c c0014c = this.f699a;
            if (c0014c == null) {
                return;
            }
            c0014c.f698b.onLocationChanged(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            C0014c c0014c = this.f699a;
            if (c0014c == null) {
                return;
            }
            c0014c.f698b.onLocationChanged((List<Location>) list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(String str) {
            C0014c c0014c = this.f699a;
            if (c0014c == null) {
                return;
            }
            c0014c.f698b.onProviderDisabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(String str) {
            C0014c c0014c = this.f699a;
            if (c0014c == null) {
                return;
            }
            c0014c.f698b.onProviderEnabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i3, Bundle bundle) {
            C0014c c0014c = this.f699a;
            if (c0014c == null) {
                return;
            }
            c0014c.f698b.onStatusChanged(str, i3, bundle);
        }

        public C0014c g() {
            return (C0014c) androidx.core.util.b.c(this.f699a);
        }

        public void n() {
            this.f699a = null;
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i3) {
            if (this.f699a == null) {
                return;
            }
            this.f700b.execute(new Runnable() { // from class: androidx.core.location.h
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.h(i3);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            if (this.f699a == null) {
                return;
            }
            this.f700b.execute(new Runnable() { // from class: androidx.core.location.k
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.i(location);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final List<Location> list) {
            if (this.f699a == null) {
                return;
            }
            this.f700b.execute(new Runnable() { // from class: androidx.core.location.i
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.j(list);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String str) {
            if (this.f699a == null) {
                return;
            }
            this.f700b.execute(new Runnable() { // from class: androidx.core.location.j
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.k(str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String str) {
            if (this.f699a == null) {
                return;
            }
            this.f700b.execute(new Runnable() { // from class: androidx.core.location.g
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.l(str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i3, final Bundle bundle) {
            if (this.f699a == null) {
                return;
            }
            this.f700b.execute(new Runnable() { // from class: androidx.core.location.l
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.m(str, i3, bundle);
                }
            });
        }
    }

    static void a(LocationManager locationManager, d dVar) {
        WeakReference<d> put = f694a.put(dVar.g(), new WeakReference<>(dVar));
        d dVar2 = put != null ? put.get() : null;
        if (dVar2 != null) {
            dVar2.n();
            locationManager.removeUpdates(dVar2);
        }
    }

    public static void b(LocationManager locationManager, String str, m mVar, androidx.core.location.b bVar, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            b.c(locationManager, str, mVar.h(), androidx.core.os.j.a(new Handler(looper)), bVar);
        } else {
            if (a.a(locationManager, str, mVar, bVar, looper)) {
                return;
            }
            locationManager.requestLocationUpdates(str, mVar.b(), mVar.e(), bVar, looper);
        }
    }
}
