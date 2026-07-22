package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public final class s0 {

    /* renamed from: d, reason: collision with root package name */
    private static String f585d;

    /* renamed from: g, reason: collision with root package name */
    private static e f588g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f589a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f590b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f584c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static Set<String> f586e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f587f = new Object();

    static class a {
        static boolean a(NotificationManager notificationManager) {
            boolean areNotificationsEnabled;
            areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            return areNotificationsEnabled;
        }

        static int b(NotificationManager notificationManager) {
            int importance;
            importance = notificationManager.getImportance();
            return importance;
        }
    }

    static class b {
        static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        static NotificationChannel i(NotificationManager notificationManager, String str) {
            NotificationChannel notificationChannel;
            notificationChannel = notificationManager.getNotificationChannel(str);
            return notificationChannel;
        }

        static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            List<NotificationChannelGroup> notificationChannelGroups;
            notificationChannelGroups = notificationManager.getNotificationChannelGroups();
            return notificationChannelGroups;
        }

        static List<NotificationChannel> k(NotificationManager notificationManager) {
            List<NotificationChannel> notificationChannels;
            notificationChannels = notificationManager.getNotificationChannels();
            return notificationChannels;
        }
    }

    private static class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final String f591a;

        /* renamed from: b, reason: collision with root package name */
        final int f592b;

        /* renamed from: c, reason: collision with root package name */
        final String f593c;

        /* renamed from: d, reason: collision with root package name */
        final Notification f594d;

        c(String str, int i3, String str2, Notification notification) {
            this.f591a = str;
            this.f592b = i3;
            this.f593c = str2;
            this.f594d = notification;
        }

        @Override // androidx.core.app.s0.f
        public void a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.notify(this.f591a, this.f592b, this.f593c, this.f594d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f591a + ", id:" + this.f592b + ", tag:" + this.f593c + "]";
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f595a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f596b;

        d(ComponentName componentName, IBinder iBinder) {
            this.f595a = componentName;
            this.f596b = iBinder;
        }
    }

    private static class e implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final Context f597a;

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f598b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f599c;

        /* renamed from: d, reason: collision with root package name */
        private final Map<ComponentName, a> f600d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private Set<String> f601e = new HashSet();

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            final ComponentName f602a;

            /* renamed from: c, reason: collision with root package name */
            INotificationSideChannel f604c;

            /* renamed from: b, reason: collision with root package name */
            boolean f603b = false;

            /* renamed from: d, reason: collision with root package name */
            ArrayDeque<f> f605d = new ArrayDeque<>();

            /* renamed from: e, reason: collision with root package name */
            int f606e = 0;

            a(ComponentName componentName) {
                this.f602a = componentName;
            }
        }

        e(Context context) {
            this.f597a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f598b = handlerThread;
            handlerThread.start();
            this.f599c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f603b) {
                return true;
            }
            boolean bindService = this.f597a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f602a), this, 33);
            aVar.f603b = bindService;
            if (bindService) {
                aVar.f606e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f602a);
                this.f597a.unbindService(this);
            }
            return aVar.f603b;
        }

        private void b(a aVar) {
            if (aVar.f603b) {
                this.f597a.unbindService(this);
                aVar.f603b = false;
            }
            aVar.f604c = null;
        }

        private void c(f fVar) {
            j();
            for (a aVar : this.f600d.values()) {
                aVar.f605d.add(fVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f600d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f600d.get(componentName);
            if (aVar != null) {
                aVar.f604c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f606e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f600d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f602a + ", " + aVar.f605d.size() + " queued tasks");
            }
            if (aVar.f605d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f604c == null) {
                i(aVar);
                return;
            }
            while (true) {
                f peek = aVar.f605d.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + peek);
                    }
                    peek.a(aVar.f604c);
                    aVar.f605d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f602a);
                    }
                } catch (RemoteException e3) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f602a, e3);
                }
            }
            if (aVar.f605d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f599c.hasMessages(3, aVar.f602a)) {
                return;
            }
            int i3 = aVar.f606e + 1;
            aVar.f606e = i3;
            if (i3 <= 6) {
                int i4 = (1 << (i3 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i4 + " ms");
                }
                this.f599c.sendMessageDelayed(this.f599c.obtainMessage(3, aVar.f602a), i4);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f605d.size() + " tasks to " + aVar.f602a + " after " + aVar.f606e + " retries");
            aVar.f605d.clear();
        }

        private void j() {
            Set<String> d3 = s0.d(this.f597a);
            if (d3.equals(this.f601e)) {
                return;
            }
            this.f601e = d3;
            List<ResolveInfo> queryIntentServices = this.f597a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (d3.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f600d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f600d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f600d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public void h(f fVar) {
            this.f599c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                c((f) message.obj);
                return true;
            }
            if (i3 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f595a, dVar.f596b);
                return true;
            }
            if (i3 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i3 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f599c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f599c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface f {
        void a(INotificationSideChannel iNotificationSideChannel);
    }

    private s0(Context context) {
        this.f589a = context;
        this.f590b = (NotificationManager) context.getSystemService("notification");
    }

    public static s0 c(Context context) {
        return new s0(context);
    }

    public static Set<String> d(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f584c) {
            if (string != null) {
                if (!string.equals(f585d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f586e = hashSet;
                    f585d = string;
                }
            }
            set = f586e;
        }
        return set;
    }

    private void g(f fVar) {
        synchronized (f587f) {
            if (f588g == null) {
                f588g = new e(this.f589a.getApplicationContext());
            }
            f588g.h(fVar);
        }
    }

    private static boolean h(Notification notification) {
        Bundle a4 = s.a(notification);
        return a4 != null && a4.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f590b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f589a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f589a.getApplicationInfo();
        String packageName = this.f589a.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(this.f590b, notificationChannel);
        }
    }

    public void e(int i3, Notification notification) {
        f(null, i3, notification);
    }

    public void f(String str, int i3, Notification notification) {
        if (!h(notification)) {
            this.f590b.notify(str, i3, notification);
        } else {
            g(new c(this.f589a.getPackageName(), i3, str, notification));
            this.f590b.cancel(str, i3);
        }
    }
}
