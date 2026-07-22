package z0;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import m1.a;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class c0 implements m1.a, l.c {

    /* renamed from: k, reason: collision with root package name */
    static String f4737k;

    /* renamed from: o, reason: collision with root package name */
    private static o f4741o;

    /* renamed from: c, reason: collision with root package name */
    private Context f4742c;

    /* renamed from: d, reason: collision with root package name */
    private u1.l f4743d;

    /* renamed from: f, reason: collision with root package name */
    static final Map<String, Integer> f4732f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    static final Map<Integer, i> f4733g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f4734h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final Object f4735i = new Object();

    /* renamed from: j, reason: collision with root package name */
    static int f4736j = 0;

    /* renamed from: l, reason: collision with root package name */
    private static int f4738l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static int f4739m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static int f4740n = 0;

    class a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f4744c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.d f4745d;

        a(i iVar, l.d dVar) {
            this.f4744c = iVar;
            this.f4745d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c0.f4735i) {
                c0.this.o(this.f4744c);
            }
            this.f4745d.a(null);
        }
    }

    class b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f4747c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4748d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l.d f4749f;

        b(i iVar, String str, l.d dVar) {
            this.f4747c = iVar;
            this.f4748d = str;
            this.f4749f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c0.f4735i) {
                i iVar = this.f4747c;
                if (iVar != null) {
                    c0.this.o(iVar);
                }
                try {
                    if (r.c(c0.f4736j)) {
                        Log.d("Sqflite", "delete database " + this.f4748d);
                    }
                    i.o(this.f4748d);
                } catch (Exception e3) {
                    Log.e("Sqflite", "error " + e3 + " while closing database " + c0.f4740n);
                }
            }
            this.f4749f.a(null);
        }
    }

    static Map A(int i3, boolean z3, boolean z4) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i3));
        if (z3) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z4) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    private void B(Context context, u1.d dVar) {
        this.f4742c = context;
        u1.l lVar = new u1.l(dVar, "com.tekartik.sqflite", u1.p.f4387b, dVar.b());
        this.f4743d = lVar;
        lVar.e(this);
    }

    private void C(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.b0
            @Override // java.lang.Runnable
            public final void run() {
                i.this.h(kVar, dVar);
            }
        });
    }

    private void D(u1.k kVar, l.d dVar) {
        int intValue = ((Integer) kVar.a("id")).intValue();
        i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        if (r.b(q3.f4765d)) {
            Log.d("Sqflite", q3.A() + "closing " + intValue + " " + q3.f4763b);
        }
        String str = q3.f4763b;
        synchronized (f4734h) {
            f4733g.remove(Integer.valueOf(intValue));
            if (q3.f4762a) {
                f4732f.remove(str);
            }
        }
        f4741o.b(q3, new a(q3, dVar));
    }

    private void E(u1.k kVar, l.d dVar) {
        dVar.a(Boolean.valueOf(i.x((String) kVar.a("path"))));
    }

    private void F(u1.k kVar, l.d dVar) {
        String str = (String) kVar.a("cmd");
        HashMap hashMap = new HashMap();
        if ("get".equals(str)) {
            int i3 = f4736j;
            if (i3 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i3));
            }
            Map<Integer, i> map = f4733g;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry<Integer, i> entry : map.entrySet()) {
                    i value = entry.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", value.f4763b);
                    hashMap3.put("singleInstance", Boolean.valueOf(value.f4762a));
                    int i4 = value.f4765d;
                    if (i4 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i4));
                    }
                    hashMap2.put(entry.getKey().toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        dVar.a(hashMap);
    }

    private void G(u1.k kVar, l.d dVar) {
        a1.a.f2a = Boolean.TRUE.equals(kVar.b());
        a1.a.f4c = a1.a.f3b && a1.a.f2a;
        if (!a1.a.f2a) {
            f4736j = 0;
        } else if (a1.a.f4c) {
            f4736j = 2;
        } else if (a1.a.f2a) {
            f4736j = 1;
        }
        dVar.a(null);
    }

    private void H(u1.k kVar, l.d dVar) {
        i iVar;
        Map<Integer, i> map;
        String str = (String) kVar.a("path");
        synchronized (f4734h) {
            if (r.c(f4736j)) {
                Log.d("Sqflite", "Look for " + str + " in " + f4732f.keySet());
            }
            Map<String, Integer> map2 = f4732f;
            Integer num = map2.get(str);
            if (num == null || (iVar = (map = f4733g).get(num)) == null || !iVar.f4770i.isOpen()) {
                iVar = null;
            } else {
                if (r.c(f4736j)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(iVar.A());
                    sb.append("found single instance ");
                    sb.append(iVar.F() ? "(in transaction) " : "");
                    sb.append(num);
                    sb.append(" ");
                    sb.append(str);
                    Log.d("Sqflite", sb.toString());
                }
                map.remove(num);
                map2.remove(str);
            }
        }
        b bVar = new b(iVar, str, dVar);
        o oVar = f4741o;
        if (oVar != null) {
            oVar.b(iVar, bVar);
        } else {
            bVar.run();
        }
    }

    private void I(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.x
            @Override // java.lang.Runnable
            public final void run() {
                c0.t(u1.k.this, dVar, q3);
            }
        });
    }

    private void K(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.u
            @Override // java.lang.Runnable
            public final void run() {
                c0.u(u1.k.this, dVar, q3);
            }
        });
    }

    private void L(final u1.k kVar, final l.d dVar) {
        final int i3;
        i iVar;
        final String str = (String) kVar.a("path");
        final Boolean bool = (Boolean) kVar.a("readOnly");
        final boolean r3 = r(str);
        boolean z3 = (Boolean.FALSE.equals(kVar.a("singleInstance")) || r3) ? false : true;
        if (z3) {
            synchronized (f4734h) {
                if (r.c(f4736j)) {
                    Log.d("Sqflite", "Look for " + str + " in " + f4732f.keySet());
                }
                Integer num = f4732f.get(str);
                if (num != null && (iVar = f4733g.get(num)) != null) {
                    if (iVar.f4770i.isOpen()) {
                        if (r.c(f4736j)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(iVar.A());
                            sb.append("re-opened single instance ");
                            sb.append(iVar.F() ? "(in transaction) " : "");
                            sb.append(num);
                            sb.append(" ");
                            sb.append(str);
                            Log.d("Sqflite", sb.toString());
                        }
                        dVar.a(A(num.intValue(), true, iVar.F()));
                        return;
                    }
                    if (r.c(f4736j)) {
                        Log.d("Sqflite", iVar.A() + "single instance database of " + str + " not opened");
                    }
                }
            }
        }
        Object obj = f4734h;
        synchronized (obj) {
            i3 = f4740n + 1;
            f4740n = i3;
        }
        final i iVar2 = new i(this.f4742c, str, i3, z3, f4736j);
        synchronized (obj) {
            if (f4741o == null) {
                o b4 = n.b("Sqflite", f4739m, f4738l);
                f4741o = b4;
                b4.start();
                if (r.b(iVar2.f4765d)) {
                    Log.d("Sqflite", iVar2.A() + "starting worker pool with priority " + f4738l);
                }
            }
            iVar2.f4769h = f4741o;
            if (r.b(iVar2.f4765d)) {
                Log.d("Sqflite", iVar2.A() + "opened " + i3 + " " + str);
            }
            final boolean z4 = z3;
            f4741o.b(iVar2, new Runnable() { // from class: z0.z
                @Override // java.lang.Runnable
                public final void run() {
                    c0.v(r3, str, dVar, bool, iVar2, kVar, z4, i3);
                }
            });
        }
    }

    private void N(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.y
            @Override // java.lang.Runnable
            public final void run() {
                c0.w(u1.k.this, dVar, q3);
            }
        });
    }

    private void O(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.v
            @Override // java.lang.Runnable
            public final void run() {
                c0.x(u1.k.this, dVar, q3);
            }
        });
    }

    private void P(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.a0
            @Override // java.lang.Runnable
            public final void run() {
                c0.y(u1.k.this, q3, dVar);
            }
        });
    }

    private void Q(final u1.k kVar, final l.d dVar) {
        final i q3 = q(kVar, dVar);
        if (q3 == null) {
            return;
        }
        f4741o.b(q3, new Runnable() { // from class: z0.w
            @Override // java.lang.Runnable
            public final void run() {
                c0.z(u1.k.this, dVar, q3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(i iVar) {
        try {
            if (r.b(iVar.f4765d)) {
                Log.d("Sqflite", iVar.A() + "closing database ");
            }
            iVar.k();
        } catch (Exception e3) {
            Log.e("Sqflite", "error " + e3 + " while closing database " + f4740n);
        }
        synchronized (f4734h) {
            if (f4733g.isEmpty() && f4741o != null) {
                if (r.b(iVar.f4765d)) {
                    Log.d("Sqflite", iVar.A() + "stopping thread");
                }
                f4741o.a();
                f4741o = null;
            }
        }
    }

    private i p(int i3) {
        return f4733g.get(Integer.valueOf(i3));
    }

    private i q(u1.k kVar, l.d dVar) {
        int intValue = ((Integer) kVar.a("id")).intValue();
        i p3 = p(intValue);
        if (p3 != null) {
            return p3;
        }
        dVar.b("sqlite_error", "database_closed " + intValue, null);
        return null;
    }

    static boolean r(String str) {
        return str == null || str.equals(":memory:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(u1.k kVar, l.d dVar, i iVar) {
        iVar.v(new b1.d(kVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(u1.k kVar, l.d dVar, i iVar) {
        iVar.E(new b1.d(kVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(boolean z3, String str, l.d dVar, Boolean bool, i iVar, u1.k kVar, boolean z4, int i3) {
        synchronized (f4735i) {
            if (!z3) {
                try {
                    File file = new File(new File(str).getParent());
                    if (!file.exists() && !file.mkdirs() && !file.exists()) {
                        dVar.b("sqlite_error", "open_failed " + str, null);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                if (Boolean.TRUE.equals(bool)) {
                    iVar.N();
                } else {
                    iVar.M();
                }
                synchronized (f4734h) {
                    if (z4) {
                        f4732f.put(str, Integer.valueOf(i3));
                    }
                    f4733g.put(Integer.valueOf(i3), iVar);
                }
                if (r.b(iVar.f4765d)) {
                    Log.d("Sqflite", iVar.A() + "opened " + i3 + " " + str);
                }
                dVar.a(A(i3, false, false));
            } catch (Exception e3) {
                iVar.D(e3, new b1.d(kVar, dVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(u1.k kVar, l.d dVar, i iVar) {
        iVar.O(new b1.d(kVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(u1.k kVar, l.d dVar, i iVar) {
        iVar.P(new b1.d(kVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(u1.k kVar, i iVar, l.d dVar) {
        try {
            iVar.f4770i.setLocale(e0.d((String) kVar.a("locale")));
            dVar.a(null);
        } catch (Exception e3) {
            dVar.b("sqlite_error", "Error calling setLocale: " + e3.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(u1.k kVar, l.d dVar, i iVar) {
        iVar.R(new b1.d(kVar, dVar));
    }

    void J(u1.k kVar, l.d dVar) {
        if (f4737k == null) {
            f4737k = this.f4742c.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        dVar.a(f4737k);
    }

    void M(u1.k kVar, l.d dVar) {
        Object a4 = kVar.a("androidThreadPriority");
        if (a4 != null) {
            f4738l = ((Integer) a4).intValue();
        }
        Object a5 = kVar.a("androidThreadCount");
        if (a5 != null && !a5.equals(Integer.valueOf(f4739m))) {
            f4739m = ((Integer) a5).intValue();
            o oVar = f4741o;
            if (oVar != null) {
                oVar.a();
                f4741o = null;
            }
        }
        Integer a6 = r.a(kVar);
        if (a6 != null) {
            f4736j = a6.intValue();
        }
        dVar.a(null);
    }

    @Override // m1.a
    public void b(a.b bVar) {
        B(bVar.a(), bVar.b());
    }

    @Override // m1.a
    public void e(a.b bVar) {
        this.f4742c = null;
        this.f4743d.e(null);
        this.f4743d = null;
    }

    @Override // u1.l.c
    public void n(u1.k kVar, l.d dVar) {
        String str = kVar.f4372a;
        str.hashCode();
        switch (str) {
            case "execute":
                I(kVar, dVar);
                break;
            case "closeDatabase":
                D(kVar, dVar);
                break;
            case "options":
                M(kVar, dVar);
                break;
            case "insert":
                K(kVar, dVar);
                break;
            case "update":
                Q(kVar, dVar);
                break;
            case "androidSetLocale":
                P(kVar, dVar);
                break;
            case "deleteDatabase":
                H(kVar, dVar);
                break;
            case "debugMode":
                G(kVar, dVar);
                break;
            case "openDatabase":
                L(kVar, dVar);
                break;
            case "batch":
                C(kVar, dVar);
                break;
            case "debug":
                F(kVar, dVar);
                break;
            case "query":
                N(kVar, dVar);
                break;
            case "databaseExists":
                E(kVar, dVar);
                break;
            case "queryCursorNext":
                O(kVar, dVar);
                break;
            case "getPlatformVersion":
                dVar.a("Android " + Build.VERSION.RELEASE);
                break;
            case "getDatabasesPath":
                J(kVar, dVar);
                break;
            default:
                dVar.c();
                break;
        }
    }
}
