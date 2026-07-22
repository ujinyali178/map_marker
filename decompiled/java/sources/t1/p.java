package t1;

import android.os.Build;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import u1.b;

/* loaded from: /root/release/classes.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    private static final a f4263b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final u1.b<Object> f4264a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ConcurrentLinkedQueue<b> f4265a = new ConcurrentLinkedQueue<>();

        /* renamed from: b, reason: collision with root package name */
        private b f4266b;

        /* renamed from: c, reason: collision with root package name */
        private b f4267c;

        /* renamed from: t1.p$a$a, reason: collision with other inner class name */
        class C0105a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f4268a;

            C0105a(b bVar) {
                this.f4268a = bVar;
            }

            @Override // u1.b.e
            public void a(Object obj) {
                a.this.f4265a.remove(this.f4268a);
                if (a.this.f4265a.isEmpty()) {
                    return;
                }
                g1.b.b("SettingsChannel", "The queue becomes empty after removing config generation " + String.valueOf(this.f4268a.f4271a));
            }
        }

        public static class b {

            /* renamed from: c, reason: collision with root package name */
            private static int f4270c = Integer.MIN_VALUE;

            /* renamed from: a, reason: collision with root package name */
            public final int f4271a;

            /* renamed from: b, reason: collision with root package name */
            private final DisplayMetrics f4272b;

            public b(DisplayMetrics displayMetrics) {
                int i3 = f4270c;
                f4270c = i3 + 1;
                this.f4271a = i3;
                this.f4272b = displayMetrics;
            }
        }

        public b.e b(b bVar) {
            this.f4265a.add(bVar);
            b bVar2 = this.f4267c;
            this.f4267c = bVar;
            if (bVar2 == null) {
                return null;
            }
            return new C0105a(bVar2);
        }

        public b c(int i3) {
            b bVar;
            StringBuilder sb;
            String valueOf;
            if (this.f4266b == null) {
                this.f4266b = this.f4265a.poll();
            }
            while (true) {
                bVar = this.f4266b;
                if (bVar == null || bVar.f4271a >= i3) {
                    break;
                }
                this.f4266b = this.f4265a.poll();
            }
            if (bVar == null) {
                sb = new StringBuilder();
                sb.append("Cannot find config with generation: ");
                sb.append(String.valueOf(i3));
                valueOf = ", after exhausting the queue.";
            } else {
                if (bVar.f4271a == i3) {
                    return bVar;
                }
                sb = new StringBuilder();
                sb.append("Cannot find config with generation: ");
                sb.append(String.valueOf(i3));
                sb.append(", the oldest config is now: ");
                valueOf = String.valueOf(this.f4266b.f4271a);
            }
            sb.append(valueOf);
            g1.b.b("SettingsChannel", sb.toString());
            return null;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final u1.b<Object> f4273a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f4274b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private DisplayMetrics f4275c;

        b(u1.b<Object> bVar) {
            this.f4273a = bVar;
        }

        public void a() {
            g1.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f4274b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f4274b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f4274b.get("platformBrightness"));
            DisplayMetrics displayMetrics = this.f4275c;
            if (!p.c() || displayMetrics == null) {
                this.f4273a.c(this.f4274b);
                return;
            }
            a.b bVar = new a.b(displayMetrics);
            b.e<Object> b4 = p.f4263b.b(bVar);
            this.f4274b.put("configurationId", Integer.valueOf(bVar.f4271a));
            this.f4273a.d(this.f4274b, b4);
        }

        public b b(boolean z3) {
            this.f4274b.put("brieflyShowPassword", Boolean.valueOf(z3));
            return this;
        }

        public b c(DisplayMetrics displayMetrics) {
            this.f4275c = displayMetrics;
            return this;
        }

        public b d(boolean z3) {
            this.f4274b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z3));
            return this;
        }

        public b e(c cVar) {
            this.f4274b.put("platformBrightness", cVar.f4279c);
            return this;
        }

        public b f(float f3) {
            this.f4274b.put("textScaleFactor", Float.valueOf(f3));
            return this;
        }

        public b g(boolean z3) {
            this.f4274b.put("alwaysUse24HourFormat", Boolean.valueOf(z3));
            return this;
        }
    }

    public enum c {
        light("light"),
        dark("dark");


        /* renamed from: c, reason: collision with root package name */
        public String f4279c;

        c(String str) {
            this.f4279c = str;
        }
    }

    public p(i1.a aVar) {
        this.f4264a = new u1.b<>(aVar, "flutter/settings", u1.g.f4370a);
    }

    public static DisplayMetrics b(int i3) {
        a.b c3 = f4263b.c(i3);
        if (c3 == null) {
            return null;
        }
        return c3.f4272b;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public b d() {
        return new b(this.f4264a);
    }
}
