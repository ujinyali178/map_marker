package t1;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t1.m;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final u1.l f4210a;

    /* renamed from: b, reason: collision with root package name */
    private g f4211b;

    /* renamed from: c, reason: collision with root package name */
    private final l.c f4212c;

    class a implements l.c {
        a() {
        }

        private void b(u1.k kVar, l.d dVar) {
            try {
                m.this.f4211b.h(((Integer) kVar.b()).intValue());
                dVar.a(null);
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        private void c(u1.k kVar, l.d dVar) {
            Map map = (Map) kVar.b();
            boolean z3 = true;
            boolean z4 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z4) {
                    m.this.f4211b.c(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), d.a.HYBRID_ONLY, wrap));
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z3 = false;
                    }
                    long f3 = m.this.f4211b.f(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z3 ? d.a.TEXTURE_WITH_HYBRID_FALLBACK : d.a.TEXTURE_WITH_VIRTUAL_FALLBACK, wrap));
                    if (f3 != -2) {
                        dVar.a(Long.valueOf(f3));
                        return;
                    } else if (!z3) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                dVar.a(null);
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        private void d(u1.k kVar, l.d dVar) {
            try {
                m.this.f4211b.i(((Integer) ((Map) kVar.b()).get("id")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(l.d dVar, c cVar) {
            if (cVar == null) {
                dVar.b("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(cVar.f4214a));
            hashMap.put("height", Double.valueOf(cVar.f4215b));
            dVar.a(hashMap);
        }

        private void f(u1.k kVar, l.d dVar) {
            Map map = (Map) kVar.b();
            try {
                m.this.f4211b.g(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.a(null);
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        private void g(u1.k kVar, final l.d dVar) {
            Map map = (Map) kVar.b();
            try {
                m.this.f4211b.e(new e(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: t1.l
                    @Override // t1.m.b
                    public final void a(m.c cVar) {
                        m.a.e(l.d.this, cVar);
                    }
                });
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        private void h(u1.k kVar, l.d dVar) {
            Map map = (Map) kVar.b();
            try {
                m.this.f4211b.d(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        private void i(u1.k kVar, l.d dVar) {
            try {
                m.this.f4211b.b(((Boolean) kVar.b()).booleanValue());
                dVar.a(null);
            } catch (IllegalStateException e3) {
                dVar.b("error", m.c(e3), null);
            }
        }

        private void j(u1.k kVar, l.d dVar) {
            l.d dVar2;
            List list = (List) kVar.b();
            try {
                m.this.f4211b.a(new f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e3) {
                e = e3;
                dVar2 = dVar;
            }
            try {
                dVar2.a(null);
            } catch (IllegalStateException e4) {
                e = e4;
                dVar2.b("error", m.c(e), null);
            }
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            if (m.this.f4211b == null) {
            }
            g1.b.f("PlatformViewsChannel", "Received '" + kVar.f4372a + "' message.");
            String str = kVar.f4372a;
            str.hashCode();
            switch (str) {
                case "create":
                    c(kVar, dVar);
                    break;
                case "offset":
                    f(kVar, dVar);
                    break;
                case "resize":
                    g(kVar, dVar);
                    break;
                case "clearFocus":
                    b(kVar, dVar);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    i(kVar, dVar);
                    break;
                case "touch":
                    j(kVar, dVar);
                    break;
                case "setDirection":
                    h(kVar, dVar);
                    break;
                case "dispose":
                    d(kVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f4214a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4215b;

        public c(int i3, int i4) {
            this.f4214a = i3;
            this.f4215b = i4;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f4216a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4217b;

        /* renamed from: c, reason: collision with root package name */
        public final double f4218c;

        /* renamed from: d, reason: collision with root package name */
        public final double f4219d;

        /* renamed from: e, reason: collision with root package name */
        public final double f4220e;

        /* renamed from: f, reason: collision with root package name */
        public final double f4221f;

        /* renamed from: g, reason: collision with root package name */
        public final int f4222g;

        /* renamed from: h, reason: collision with root package name */
        public final a f4223h;

        /* renamed from: i, reason: collision with root package name */
        public final ByteBuffer f4224i;

        public enum a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public d(int i3, String str, double d3, double d4, double d5, double d6, int i4, a aVar, ByteBuffer byteBuffer) {
            this.f4216a = i3;
            this.f4217b = str;
            this.f4220e = d3;
            this.f4221f = d4;
            this.f4218c = d5;
            this.f4219d = d6;
            this.f4222g = i4;
            this.f4223h = aVar;
            this.f4224i = byteBuffer;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f4229a;

        /* renamed from: b, reason: collision with root package name */
        public final double f4230b;

        /* renamed from: c, reason: collision with root package name */
        public final double f4231c;

        public e(int i3, double d3, double d4) {
            this.f4229a = i3;
            this.f4230b = d3;
            this.f4231c = d4;
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f4232a;

        /* renamed from: b, reason: collision with root package name */
        public final Number f4233b;

        /* renamed from: c, reason: collision with root package name */
        public final Number f4234c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4235d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4236e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f4237f;

        /* renamed from: g, reason: collision with root package name */
        public final Object f4238g;

        /* renamed from: h, reason: collision with root package name */
        public final int f4239h;

        /* renamed from: i, reason: collision with root package name */
        public final int f4240i;

        /* renamed from: j, reason: collision with root package name */
        public final float f4241j;

        /* renamed from: k, reason: collision with root package name */
        public final float f4242k;

        /* renamed from: l, reason: collision with root package name */
        public final int f4243l;

        /* renamed from: m, reason: collision with root package name */
        public final int f4244m;

        /* renamed from: n, reason: collision with root package name */
        public final int f4245n;

        /* renamed from: o, reason: collision with root package name */
        public final int f4246o;

        /* renamed from: p, reason: collision with root package name */
        public final long f4247p;

        public f(int i3, Number number, Number number2, int i4, int i5, Object obj, Object obj2, int i6, int i7, float f3, float f4, int i8, int i9, int i10, int i11, long j3) {
            this.f4232a = i3;
            this.f4233b = number;
            this.f4234c = number2;
            this.f4235d = i4;
            this.f4236e = i5;
            this.f4237f = obj;
            this.f4238g = obj2;
            this.f4239h = i6;
            this.f4240i = i7;
            this.f4241j = f3;
            this.f4242k = f4;
            this.f4243l = i8;
            this.f4244m = i9;
            this.f4245n = i10;
            this.f4246o = i11;
            this.f4247p = j3;
        }
    }

    public interface g {
        void a(f fVar);

        void b(boolean z3);

        void c(d dVar);

        void d(int i3, int i4);

        void e(e eVar, b bVar);

        long f(d dVar);

        void g(int i3, double d3, double d4);

        void h(int i3);

        void i(int i3);
    }

    public m(i1.a aVar) {
        a aVar2 = new a();
        this.f4212c = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/platform_views", u1.p.f4387b);
        this.f4210a = lVar;
        lVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Exception exc) {
        return g1.b.d(exc);
    }

    public void d(int i3) {
        u1.l lVar = this.f4210a;
        if (lVar == null) {
            return;
        }
        lVar.c("viewFocused", Integer.valueOf(i3));
    }

    public void e(g gVar) {
        this.f4211b = gVar;
    }
}
