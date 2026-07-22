package a2;

import a2.e;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.kxml2.wap.Wbxml;
import u1.b;

/* loaded from: /root/release/classes.dex */
public class e {

    public static class a extends RuntimeException {

        /* renamed from: c, reason: collision with root package name */
        public final String f14c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f15d;

        public a(String str, String str2, Object obj) {
            super(str2);
            this.f14c = str;
            this.f15d = obj;
        }
    }

    public interface a0<T> {
        void a(T t3);

        void b(Throwable th);
    }

    public interface b {
        void a(p pVar, a0<s> a0Var);

        void b(List<v> list, a0<o> a0Var);

        Boolean c(String str);

        void d(Long l3, h hVar, a0<k> a0Var);

        void e(p pVar, a0<u> a0Var);

        void f(a0<k> a0Var);

        void g(String str, a0<k> a0Var);

        void h(a0<i> a0Var);

        k i(j jVar);

        Boolean isReady();

        void j(a0<g> a0Var);

        void k(String str, a0<k> a0Var);

        void l(a0<k> a0Var);

        void m();
    }

    public interface b0 {
        void a();

        void b(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends u1.o {

        /* renamed from: d, reason: collision with root package name */
        public static final c f16d = new c();

        private c() {
        }

        @Override // u1.o
        protected Object g(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case Byte.MIN_VALUE:
                    return f.a((ArrayList) f(byteBuffer));
                case -127:
                    return g.a((ArrayList) f(byteBuffer));
                case -126:
                    return i.a((ArrayList) f(byteBuffer));
                case -125:
                    return j.a((ArrayList) f(byteBuffer));
                case -124:
                    return k.a((ArrayList) f(byteBuffer));
                case -123:
                    return l.a((ArrayList) f(byteBuffer));
                case -122:
                    return m.a((ArrayList) f(byteBuffer));
                case -121:
                    return n.a((ArrayList) f(byteBuffer));
                case -120:
                    return o.a((ArrayList) f(byteBuffer));
                case -119:
                    return q.a((ArrayList) f(byteBuffer));
                case -118:
                    return r.a((ArrayList) f(byteBuffer));
                case -117:
                    return s.a((ArrayList) f(byteBuffer));
                case -116:
                    return u.a((ArrayList) f(byteBuffer));
                case -115:
                    return v.a((ArrayList) f(byteBuffer));
                case -114:
                    return x.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b4, byteBuffer);
            }
        }

        @Override // u1.o
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> f3;
            if (obj instanceof f) {
                byteArrayOutputStream.write(128);
                f3 = ((f) obj).d();
            } else if (obj instanceof g) {
                byteArrayOutputStream.write(Wbxml.EXT_T_1);
                f3 = ((g) obj).d();
            } else if (obj instanceof i) {
                byteArrayOutputStream.write(Wbxml.EXT_T_2);
                f3 = ((i) obj).d();
            } else if (obj instanceof j) {
                byteArrayOutputStream.write(Wbxml.STR_T);
                f3 = ((j) obj).p();
            } else if (obj instanceof k) {
                byteArrayOutputStream.write(Wbxml.LITERAL_A);
                f3 = ((k) obj).d();
            } else if (obj instanceof l) {
                byteArrayOutputStream.write(133);
                f3 = ((l) obj).e();
            } else if (obj instanceof m) {
                byteArrayOutputStream.write(134);
                f3 = ((m) obj).h();
            } else if (obj instanceof n) {
                byteArrayOutputStream.write(135);
                f3 = ((n) obj).i();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(136);
                f3 = ((o) obj).d();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(137);
                f3 = ((q) obj).o();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(138);
                f3 = ((r) obj).i();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(139);
                f3 = ((s) obj).d();
            } else if (obj instanceof u) {
                byteArrayOutputStream.write(140);
                f3 = ((u) obj).d();
            } else {
                if (!(obj instanceof v)) {
                    if (!(obj instanceof x)) {
                        super.p(byteArrayOutputStream, obj);
                        return;
                    } else {
                        byteArrayOutputStream.write(142);
                        p(byteArrayOutputStream, ((x) obj).g());
                        return;
                    }
                }
                byteArrayOutputStream.write(141);
                f3 = ((v) obj).f();
            }
            p(byteArrayOutputStream, f3);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final u1.d f17a;

        public d(u1.d dVar) {
            this.f17a = dVar;
        }

        static u1.j<Object> d() {
            return C0000e.f18d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(b0 b0Var, Object obj) {
            if (!(obj instanceof List)) {
                b0Var.b(e.a("dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onBillingServiceDisconnected"));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                b0Var.b(new a((String) list.get(0), (String) list.get(1), (String) list.get(2)));
            } else {
                b0Var.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(b0 b0Var, Object obj) {
            if (!(obj instanceof List)) {
                b0Var.b(e.a("dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onPurchasesUpdated"));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                b0Var.b(new a((String) list.get(0), (String) list.get(1), (String) list.get(2)));
            } else {
                b0Var.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g(b0 b0Var, Object obj) {
            if (!(obj instanceof List)) {
                b0Var.b(e.a("dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.userSelectedalternativeBilling"));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                b0Var.b(new a((String) list.get(0), (String) list.get(1), (String) list.get(2)));
            } else {
                b0Var.a();
            }
        }

        public void h(Long l3, final b0 b0Var) {
            new u1.b(this.f17a, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onBillingServiceDisconnected", d()).d(new ArrayList(Collections.singletonList(l3)), new b.e() { // from class: a2.v
                @Override // u1.b.e
                public final void a(Object obj) {
                    e.d.e(e.b0.this, obj);
                }
            });
        }

        public void i(u uVar, final b0 b0Var) {
            new u1.b(this.f17a, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.onPurchasesUpdated", d()).d(new ArrayList(Collections.singletonList(uVar)), new b.e() { // from class: a2.u
                @Override // u1.b.e
                public final void a(Object obj) {
                    e.d.f(e.b0.this, obj);
                }
            });
        }

        public void j(y yVar, final b0 b0Var) {
            new u1.b(this.f17a, "dev.flutter.pigeon.in_app_purchase_android.InAppPurchaseCallbackApi.userSelectedalternativeBilling", d()).d(new ArrayList(Collections.singletonList(yVar)), new b.e() { // from class: a2.w
                @Override // u1.b.e
                public final void a(Object obj) {
                    e.d.g(e.b0.this, obj);
                }
            });
        }
    }

    /* renamed from: a2.e$e, reason: collision with other inner class name */
    private static class C0000e extends u1.o {

        /* renamed from: d, reason: collision with root package name */
        public static final C0000e f18d = new C0000e();

        private C0000e() {
        }

        @Override // u1.o
        protected Object g(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case Byte.MIN_VALUE:
                    return f.a((ArrayList) f(byteBuffer));
                case -127:
                    return k.a((ArrayList) f(byteBuffer));
                case -126:
                    return q.a((ArrayList) f(byteBuffer));
                case -125:
                    return u.a((ArrayList) f(byteBuffer));
                case -124:
                    return y.a((ArrayList) f(byteBuffer));
                case -123:
                    return z.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b4, byteBuffer);
            }
        }

        @Override // u1.o
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> e3;
            if (obj instanceof f) {
                byteArrayOutputStream.write(128);
                e3 = ((f) obj).d();
            } else if (obj instanceof k) {
                byteArrayOutputStream.write(Wbxml.EXT_T_1);
                e3 = ((k) obj).d();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(Wbxml.EXT_T_2);
                e3 = ((q) obj).o();
            } else if (obj instanceof u) {
                byteArrayOutputStream.write(Wbxml.STR_T);
                e3 = ((u) obj).d();
            } else {
                if (!(obj instanceof y)) {
                    if (!(obj instanceof z)) {
                        super.p(byteArrayOutputStream, obj);
                        return;
                    } else {
                        byteArrayOutputStream.write(133);
                        p(byteArrayOutputStream, ((z) obj).e());
                        return;
                    }
                }
                byteArrayOutputStream.write(Wbxml.LITERAL_A);
                e3 = ((y) obj).e();
            }
            p(byteArrayOutputStream, e3);
        }
    }

    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private String f19a;

        /* renamed from: b, reason: collision with root package name */
        private String f20b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f21a;

            /* renamed from: b, reason: collision with root package name */
            private String f22b;

            public f a() {
                f fVar = new f();
                fVar.b(this.f21a);
                fVar.c(this.f22b);
                return fVar;
            }

            public a b(String str) {
                this.f21a = str;
                return this;
            }

            public a c(String str) {
                this.f22b = str;
                return this;
            }
        }

        static f a(ArrayList<Object> arrayList) {
            f fVar = new f();
            fVar.b((String) arrayList.get(0));
            fVar.c((String) arrayList.get(1));
            return fVar;
        }

        public void b(String str) {
            this.f19a = str;
        }

        public void c(String str) {
            this.f20b = str;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f19a);
            arrayList.add(this.f20b);
            return arrayList;
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        private k f23a;

        /* renamed from: b, reason: collision with root package name */
        private String f24b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private k f25a;

            /* renamed from: b, reason: collision with root package name */
            private String f26b;

            public g a() {
                g gVar = new g();
                gVar.b(this.f25a);
                gVar.c(this.f26b);
                return gVar;
            }

            public a b(k kVar) {
                this.f25a = kVar;
                return this;
            }

            public a c(String str) {
                this.f26b = str;
                return this;
            }
        }

        g() {
        }

        static g a(ArrayList<Object> arrayList) {
            g gVar = new g();
            Object obj = arrayList.get(0);
            gVar.b(obj == null ? null : k.a((ArrayList) obj));
            gVar.c((String) arrayList.get(1));
            return gVar;
        }

        public void b(k kVar) {
            if (kVar == null) {
                throw new IllegalStateException("Nonnull field \"billingResult\" is null.");
            }
            this.f23a = kVar;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"externalTransactionToken\" is null.");
            }
            this.f24b = str;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            k kVar = this.f23a;
            arrayList.add(kVar == null ? null : kVar.d());
            arrayList.add(this.f24b);
            return arrayList;
        }
    }

    public enum h {
        PLAY_BILLING_ONLY(0),
        ALTERNATIVE_BILLING_ONLY(1),
        USER_CHOICE_BILLING(2);


        /* renamed from: c, reason: collision with root package name */
        final int f31c;

        h(int i3) {
            this.f31c = i3;
        }
    }

    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        private k f32a;

        /* renamed from: b, reason: collision with root package name */
        private String f33b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private k f34a;

            /* renamed from: b, reason: collision with root package name */
            private String f35b;

            public i a() {
                i iVar = new i();
                iVar.b(this.f34a);
                iVar.c(this.f35b);
                return iVar;
            }

            public a b(k kVar) {
                this.f34a = kVar;
                return this;
            }

            public a c(String str) {
                this.f35b = str;
                return this;
            }
        }

        i() {
        }

        static i a(ArrayList<Object> arrayList) {
            i iVar = new i();
            Object obj = arrayList.get(0);
            iVar.b(obj == null ? null : k.a((ArrayList) obj));
            iVar.c((String) arrayList.get(1));
            return iVar;
        }

        public void b(k kVar) {
            if (kVar == null) {
                throw new IllegalStateException("Nonnull field \"billingResult\" is null.");
            }
            this.f32a = kVar;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"countryCode\" is null.");
            }
            this.f33b = str;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            k kVar = this.f32a;
            arrayList.add(kVar == null ? null : kVar.d());
            arrayList.add(this.f33b);
            return arrayList;
        }
    }

    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        private String f36a;

        /* renamed from: b, reason: collision with root package name */
        private Long f37b;

        /* renamed from: c, reason: collision with root package name */
        private String f38c;

        /* renamed from: d, reason: collision with root package name */
        private String f39d;

        /* renamed from: e, reason: collision with root package name */
        private String f40e;

        /* renamed from: f, reason: collision with root package name */
        private String f41f;

        /* renamed from: g, reason: collision with root package name */
        private String f42g;

        j() {
        }

        static j a(ArrayList<Object> arrayList) {
            Long valueOf;
            j jVar = new j();
            jVar.m((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            jVar.n(valueOf);
            jVar.k((String) arrayList.get(2));
            jVar.i((String) arrayList.get(3));
            jVar.j((String) arrayList.get(4));
            jVar.l((String) arrayList.get(5));
            jVar.o((String) arrayList.get(6));
            return jVar;
        }

        public String b() {
            return this.f39d;
        }

        public String c() {
            return this.f40e;
        }

        public String d() {
            return this.f38c;
        }

        public String e() {
            return this.f41f;
        }

        public String f() {
            return this.f36a;
        }

        public Long g() {
            return this.f37b;
        }

        public String h() {
            return this.f42g;
        }

        public void i(String str) {
            this.f39d = str;
        }

        public void j(String str) {
            this.f40e = str;
        }

        public void k(String str) {
            this.f38c = str;
        }

        public void l(String str) {
            this.f41f = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"product\" is null.");
            }
            this.f36a = str;
        }

        public void n(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"prorationMode\" is null.");
            }
            this.f37b = l3;
        }

        public void o(String str) {
            this.f42g = str;
        }

        ArrayList<Object> p() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.f36a);
            arrayList.add(this.f37b);
            arrayList.add(this.f38c);
            arrayList.add(this.f39d);
            arrayList.add(this.f40e);
            arrayList.add(this.f41f);
            arrayList.add(this.f42g);
            return arrayList;
        }
    }

    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        private Long f43a;

        /* renamed from: b, reason: collision with root package name */
        private String f44b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Long f45a;

            /* renamed from: b, reason: collision with root package name */
            private String f46b;

            public k a() {
                k kVar = new k();
                kVar.c(this.f45a);
                kVar.b(this.f46b);
                return kVar;
            }

            public a b(String str) {
                this.f46b = str;
                return this;
            }

            public a c(Long l3) {
                this.f45a = l3;
                return this;
            }
        }

        k() {
        }

        static k a(ArrayList<Object> arrayList) {
            Long valueOf;
            k kVar = new k();
            Object obj = arrayList.get(0);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            kVar.c(valueOf);
            kVar.b((String) arrayList.get(1));
            return kVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"debugMessage\" is null.");
            }
            this.f44b = str;
        }

        public void c(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"responseCode\" is null.");
            }
            this.f43a = l3;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f43a);
            arrayList.add(this.f44b);
            return arrayList;
        }
    }

    public static final class l {

        /* renamed from: a, reason: collision with root package name */
        private Long f47a;

        /* renamed from: b, reason: collision with root package name */
        private String f48b;

        /* renamed from: c, reason: collision with root package name */
        private String f49c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Long f50a;

            /* renamed from: b, reason: collision with root package name */
            private String f51b;

            /* renamed from: c, reason: collision with root package name */
            private String f52c;

            public l a() {
                l lVar = new l();
                lVar.c(this.f50a);
                lVar.b(this.f51b);
                lVar.d(this.f52c);
                return lVar;
            }

            public a b(String str) {
                this.f51b = str;
                return this;
            }

            public a c(Long l3) {
                this.f50a = l3;
                return this;
            }

            public a d(String str) {
                this.f52c = str;
                return this;
            }
        }

        l() {
        }

        static l a(ArrayList<Object> arrayList) {
            Long valueOf;
            l lVar = new l();
            Object obj = arrayList.get(0);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            lVar.c(valueOf);
            lVar.b((String) arrayList.get(1));
            lVar.d((String) arrayList.get(2));
            return lVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"formattedPrice\" is null.");
            }
            this.f48b = str;
        }

        public void c(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"priceAmountMicros\" is null.");
            }
            this.f47a = l3;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"priceCurrencyCode\" is null.");
            }
            this.f49c = str;
        }

        ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f47a);
            arrayList.add(this.f48b);
            arrayList.add(this.f49c);
            return arrayList;
        }
    }

    public static final class m {

        /* renamed from: a, reason: collision with root package name */
        private Long f53a;

        /* renamed from: b, reason: collision with root package name */
        private w f54b;

        /* renamed from: c, reason: collision with root package name */
        private Long f55c;

        /* renamed from: d, reason: collision with root package name */
        private String f56d;

        /* renamed from: e, reason: collision with root package name */
        private String f57e;

        /* renamed from: f, reason: collision with root package name */
        private String f58f;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Long f59a;

            /* renamed from: b, reason: collision with root package name */
            private w f60b;

            /* renamed from: c, reason: collision with root package name */
            private Long f61c;

            /* renamed from: d, reason: collision with root package name */
            private String f62d;

            /* renamed from: e, reason: collision with root package name */
            private String f63e;

            /* renamed from: f, reason: collision with root package name */
            private String f64f;

            public m a() {
                m mVar = new m();
                mVar.b(this.f59a);
                mVar.g(this.f60b);
                mVar.e(this.f61c);
                mVar.c(this.f62d);
                mVar.d(this.f63e);
                mVar.f(this.f64f);
                return mVar;
            }

            public a b(Long l3) {
                this.f59a = l3;
                return this;
            }

            public a c(String str) {
                this.f62d = str;
                return this;
            }

            public a d(String str) {
                this.f63e = str;
                return this;
            }

            public a e(Long l3) {
                this.f61c = l3;
                return this;
            }

            public a f(String str) {
                this.f64f = str;
                return this;
            }

            public a g(w wVar) {
                this.f60b = wVar;
                return this;
            }
        }

        m() {
        }

        static m a(ArrayList<Object> arrayList) {
            Long valueOf;
            m mVar = new m();
            Object obj = arrayList.get(0);
            Long l3 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            mVar.b(valueOf);
            mVar.g(w.values()[((Integer) arrayList.get(1)).intValue()]);
            Object obj2 = arrayList.get(2);
            if (obj2 != null) {
                l3 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            mVar.e(l3);
            mVar.c((String) arrayList.get(3));
            mVar.d((String) arrayList.get(4));
            mVar.f((String) arrayList.get(5));
            return mVar;
        }

        public void b(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"billingCycleCount\" is null.");
            }
            this.f53a = l3;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"billingPeriod\" is null.");
            }
            this.f56d = str;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"formattedPrice\" is null.");
            }
            this.f57e = str;
        }

        public void e(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"priceAmountMicros\" is null.");
            }
            this.f55c = l3;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"priceCurrencyCode\" is null.");
            }
            this.f58f = str;
        }

        public void g(w wVar) {
            if (wVar == null) {
                throw new IllegalStateException("Nonnull field \"recurrenceMode\" is null.");
            }
            this.f54b = wVar;
        }

        ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.f53a);
            w wVar = this.f54b;
            arrayList.add(wVar == null ? null : Integer.valueOf(wVar.f146c));
            arrayList.add(this.f55c);
            arrayList.add(this.f56d);
            arrayList.add(this.f57e);
            arrayList.add(this.f58f);
            return arrayList;
        }
    }

    public static final class n {

        /* renamed from: a, reason: collision with root package name */
        private String f65a;

        /* renamed from: b, reason: collision with root package name */
        private String f66b;

        /* renamed from: c, reason: collision with root package name */
        private String f67c;

        /* renamed from: d, reason: collision with root package name */
        private p f68d;

        /* renamed from: e, reason: collision with root package name */
        private String f69e;

        /* renamed from: f, reason: collision with root package name */
        private l f70f;

        /* renamed from: g, reason: collision with root package name */
        private List<x> f71g;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f72a;

            /* renamed from: b, reason: collision with root package name */
            private String f73b;

            /* renamed from: c, reason: collision with root package name */
            private String f74c;

            /* renamed from: d, reason: collision with root package name */
            private p f75d;

            /* renamed from: e, reason: collision with root package name */
            private String f76e;

            /* renamed from: f, reason: collision with root package name */
            private l f77f;

            /* renamed from: g, reason: collision with root package name */
            private List<x> f78g;

            public n a() {
                n nVar = new n();
                nVar.b(this.f72a);
                nVar.c(this.f73b);
                nVar.e(this.f74c);
                nVar.f(this.f75d);
                nVar.h(this.f76e);
                nVar.d(this.f77f);
                nVar.g(this.f78g);
                return nVar;
            }

            public a b(String str) {
                this.f72a = str;
                return this;
            }

            public a c(String str) {
                this.f73b = str;
                return this;
            }

            public a d(l lVar) {
                this.f77f = lVar;
                return this;
            }

            public a e(String str) {
                this.f74c = str;
                return this;
            }

            public a f(p pVar) {
                this.f75d = pVar;
                return this;
            }

            public a g(List<x> list) {
                this.f78g = list;
                return this;
            }

            public a h(String str) {
                this.f76e = str;
                return this;
            }
        }

        n() {
        }

        static n a(ArrayList<Object> arrayList) {
            n nVar = new n();
            nVar.b((String) arrayList.get(0));
            nVar.c((String) arrayList.get(1));
            nVar.e((String) arrayList.get(2));
            nVar.f(p.values()[((Integer) arrayList.get(3)).intValue()]);
            nVar.h((String) arrayList.get(4));
            Object obj = arrayList.get(5);
            nVar.d(obj == null ? null : l.a((ArrayList) obj));
            nVar.g((List) arrayList.get(6));
            return nVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"description\" is null.");
            }
            this.f65a = str;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.f66b = str;
        }

        public void d(l lVar) {
            this.f70f = lVar;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"productId\" is null.");
            }
            this.f67c = str;
        }

        public void f(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"productType\" is null.");
            }
            this.f68d = pVar;
        }

        public void g(List<x> list) {
            this.f71g = list;
        }

        public void h(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"title\" is null.");
            }
            this.f69e = str;
        }

        ArrayList<Object> i() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.f65a);
            arrayList.add(this.f66b);
            arrayList.add(this.f67c);
            p pVar = this.f68d;
            arrayList.add(pVar == null ? null : Integer.valueOf(pVar.f86c));
            arrayList.add(this.f69e);
            l lVar = this.f70f;
            arrayList.add(lVar != null ? lVar.e() : null);
            arrayList.add(this.f71g);
            return arrayList;
        }
    }

    public static final class o {

        /* renamed from: a, reason: collision with root package name */
        private k f79a;

        /* renamed from: b, reason: collision with root package name */
        private List<n> f80b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private k f81a;

            /* renamed from: b, reason: collision with root package name */
            private List<n> f82b;

            public o a() {
                o oVar = new o();
                oVar.b(this.f81a);
                oVar.c(this.f82b);
                return oVar;
            }

            public a b(k kVar) {
                this.f81a = kVar;
                return this;
            }

            public a c(List<n> list) {
                this.f82b = list;
                return this;
            }
        }

        o() {
        }

        static o a(ArrayList<Object> arrayList) {
            o oVar = new o();
            Object obj = arrayList.get(0);
            oVar.b(obj == null ? null : k.a((ArrayList) obj));
            oVar.c((List) arrayList.get(1));
            return oVar;
        }

        public void b(k kVar) {
            if (kVar == null) {
                throw new IllegalStateException("Nonnull field \"billingResult\" is null.");
            }
            this.f79a = kVar;
        }

        public void c(List<n> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"productDetails\" is null.");
            }
            this.f80b = list;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            k kVar = this.f79a;
            arrayList.add(kVar == null ? null : kVar.d());
            arrayList.add(this.f80b);
            return arrayList;
        }
    }

    public enum p {
        INAPP(0),
        SUBS(1);


        /* renamed from: c, reason: collision with root package name */
        final int f86c;

        p(int i3) {
            this.f86c = i3;
        }
    }

    public static final class q {

        /* renamed from: a, reason: collision with root package name */
        private String f87a;

        /* renamed from: b, reason: collision with root package name */
        private String f88b;

        /* renamed from: c, reason: collision with root package name */
        private Long f89c;

        /* renamed from: d, reason: collision with root package name */
        private String f90d;

        /* renamed from: e, reason: collision with root package name */
        private String f91e;

        /* renamed from: f, reason: collision with root package name */
        private List<String> f92f;

        /* renamed from: g, reason: collision with root package name */
        private Boolean f93g;

        /* renamed from: h, reason: collision with root package name */
        private String f94h;

        /* renamed from: i, reason: collision with root package name */
        private String f95i;

        /* renamed from: j, reason: collision with root package name */
        private Boolean f96j;

        /* renamed from: k, reason: collision with root package name */
        private Long f97k;

        /* renamed from: l, reason: collision with root package name */
        private t f98l;

        /* renamed from: m, reason: collision with root package name */
        private f f99m;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f100a;

            /* renamed from: b, reason: collision with root package name */
            private String f101b;

            /* renamed from: c, reason: collision with root package name */
            private Long f102c;

            /* renamed from: d, reason: collision with root package name */
            private String f103d;

            /* renamed from: e, reason: collision with root package name */
            private String f104e;

            /* renamed from: f, reason: collision with root package name */
            private List<String> f105f;

            /* renamed from: g, reason: collision with root package name */
            private Boolean f106g;

            /* renamed from: h, reason: collision with root package name */
            private String f107h;

            /* renamed from: i, reason: collision with root package name */
            private String f108i;

            /* renamed from: j, reason: collision with root package name */
            private Boolean f109j;

            /* renamed from: k, reason: collision with root package name */
            private Long f110k;

            /* renamed from: l, reason: collision with root package name */
            private t f111l;

            /* renamed from: m, reason: collision with root package name */
            private f f112m;

            public q a() {
                q qVar = new q();
                qVar.f(this.f100a);
                qVar.h(this.f101b);
                qVar.k(this.f102c);
                qVar.l(this.f103d);
                qVar.n(this.f104e);
                qVar.i(this.f105f);
                qVar.e(this.f106g);
                qVar.g(this.f107h);
                qVar.c(this.f108i);
                qVar.d(this.f109j);
                qVar.m(this.f110k);
                qVar.j(this.f111l);
                qVar.b(this.f112m);
                return qVar;
            }

            public a b(f fVar) {
                this.f112m = fVar;
                return this;
            }

            public a c(String str) {
                this.f108i = str;
                return this;
            }

            public a d(Boolean bool) {
                this.f109j = bool;
                return this;
            }

            public a e(Boolean bool) {
                this.f106g = bool;
                return this;
            }

            public a f(String str) {
                this.f100a = str;
                return this;
            }

            public a g(String str) {
                this.f107h = str;
                return this;
            }

            public a h(String str) {
                this.f101b = str;
                return this;
            }

            public a i(List<String> list) {
                this.f105f = list;
                return this;
            }

            public a j(t tVar) {
                this.f111l = tVar;
                return this;
            }

            public a k(Long l3) {
                this.f102c = l3;
                return this;
            }

            public a l(String str) {
                this.f103d = str;
                return this;
            }

            public a m(Long l3) {
                this.f110k = l3;
                return this;
            }

            public a n(String str) {
                this.f104e = str;
                return this;
            }
        }

        q() {
        }

        static q a(ArrayList<Object> arrayList) {
            Long valueOf;
            Long valueOf2;
            q qVar = new q();
            qVar.f((String) arrayList.get(0));
            qVar.h((String) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            qVar.k(valueOf);
            qVar.l((String) arrayList.get(3));
            qVar.n((String) arrayList.get(4));
            qVar.i((List) arrayList.get(5));
            qVar.e((Boolean) arrayList.get(6));
            qVar.g((String) arrayList.get(7));
            qVar.c((String) arrayList.get(8));
            qVar.d((Boolean) arrayList.get(9));
            Object obj2 = arrayList.get(10);
            if (obj2 == null) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            qVar.m(valueOf2);
            qVar.j(t.values()[((Integer) arrayList.get(11)).intValue()]);
            Object obj3 = arrayList.get(12);
            qVar.b(obj3 != null ? f.a((ArrayList) obj3) : null);
            return qVar;
        }

        public void b(f fVar) {
            this.f99m = fVar;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"developerPayload\" is null.");
            }
            this.f95i = str;
        }

        public void d(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isAcknowledged\" is null.");
            }
            this.f96j = bool;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isAutoRenewing\" is null.");
            }
            this.f93g = bool;
        }

        public void f(String str) {
            this.f87a = str;
        }

        public void g(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"originalJson\" is null.");
            }
            this.f94h = str;
        }

        public void h(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"packageName\" is null.");
            }
            this.f88b = str;
        }

        public void i(List<String> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"products\" is null.");
            }
            this.f92f = list;
        }

        public void j(t tVar) {
            if (tVar == null) {
                throw new IllegalStateException("Nonnull field \"purchaseState\" is null.");
            }
            this.f98l = tVar;
        }

        public void k(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"purchaseTime\" is null.");
            }
            this.f89c = l3;
        }

        public void l(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"purchaseToken\" is null.");
            }
            this.f90d = str;
        }

        public void m(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"quantity\" is null.");
            }
            this.f97k = l3;
        }

        public void n(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"signature\" is null.");
            }
            this.f91e = str;
        }

        ArrayList<Object> o() {
            ArrayList<Object> arrayList = new ArrayList<>(13);
            arrayList.add(this.f87a);
            arrayList.add(this.f88b);
            arrayList.add(this.f89c);
            arrayList.add(this.f90d);
            arrayList.add(this.f91e);
            arrayList.add(this.f92f);
            arrayList.add(this.f93g);
            arrayList.add(this.f94h);
            arrayList.add(this.f95i);
            arrayList.add(this.f96j);
            arrayList.add(this.f97k);
            t tVar = this.f98l;
            arrayList.add(tVar == null ? null : Integer.valueOf(tVar.f135c));
            f fVar = this.f99m;
            arrayList.add(fVar != null ? fVar.d() : null);
            return arrayList;
        }
    }

    public static final class r {

        /* renamed from: a, reason: collision with root package name */
        private Long f113a;

        /* renamed from: b, reason: collision with root package name */
        private Long f114b;

        /* renamed from: c, reason: collision with root package name */
        private String f115c;

        /* renamed from: d, reason: collision with root package name */
        private String f116d;

        /* renamed from: e, reason: collision with root package name */
        private String f117e;

        /* renamed from: f, reason: collision with root package name */
        private String f118f;

        /* renamed from: g, reason: collision with root package name */
        private List<String> f119g;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Long f120a;

            /* renamed from: b, reason: collision with root package name */
            private Long f121b;

            /* renamed from: c, reason: collision with root package name */
            private String f122c;

            /* renamed from: d, reason: collision with root package name */
            private String f123d;

            /* renamed from: e, reason: collision with root package name */
            private String f124e;

            /* renamed from: f, reason: collision with root package name */
            private String f125f;

            /* renamed from: g, reason: collision with root package name */
            private List<String> f126g;

            public r a() {
                r rVar = new r();
                rVar.g(this.f120a);
                rVar.e(this.f121b);
                rVar.b(this.f122c);
                rVar.c(this.f123d);
                rVar.f(this.f124e);
                rVar.h(this.f125f);
                rVar.d(this.f126g);
                return rVar;
            }

            public a b(String str) {
                this.f122c = str;
                return this;
            }

            public a c(String str) {
                this.f123d = str;
                return this;
            }

            public a d(List<String> list) {
                this.f126g = list;
                return this;
            }

            public a e(Long l3) {
                this.f121b = l3;
                return this;
            }

            public a f(String str) {
                this.f124e = str;
                return this;
            }

            public a g(Long l3) {
                this.f120a = l3;
                return this;
            }

            public a h(String str) {
                this.f125f = str;
                return this;
            }
        }

        r() {
        }

        static r a(ArrayList<Object> arrayList) {
            Long valueOf;
            r rVar = new r();
            Object obj = arrayList.get(0);
            Long l3 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            rVar.g(valueOf);
            Object obj2 = arrayList.get(1);
            if (obj2 != null) {
                l3 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            rVar.e(l3);
            rVar.b((String) arrayList.get(2));
            rVar.c((String) arrayList.get(3));
            rVar.f((String) arrayList.get(4));
            rVar.h((String) arrayList.get(5));
            rVar.d((List) arrayList.get(6));
            return rVar;
        }

        public void b(String str) {
            this.f115c = str;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"originalJson\" is null.");
            }
            this.f116d = str;
        }

        public void d(List<String> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"products\" is null.");
            }
            this.f119g = list;
        }

        public void e(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"purchaseTime\" is null.");
            }
            this.f114b = l3;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"purchaseToken\" is null.");
            }
            this.f117e = str;
        }

        public void g(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"quantity\" is null.");
            }
            this.f113a = l3;
        }

        public void h(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"signature\" is null.");
            }
            this.f118f = str;
        }

        ArrayList<Object> i() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.f113a);
            arrayList.add(this.f114b);
            arrayList.add(this.f115c);
            arrayList.add(this.f116d);
            arrayList.add(this.f117e);
            arrayList.add(this.f118f);
            arrayList.add(this.f119g);
            return arrayList;
        }
    }

    public static final class s {

        /* renamed from: a, reason: collision with root package name */
        private k f127a;

        /* renamed from: b, reason: collision with root package name */
        private List<r> f128b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private k f129a;

            /* renamed from: b, reason: collision with root package name */
            private List<r> f130b;

            public s a() {
                s sVar = new s();
                sVar.b(this.f129a);
                sVar.c(this.f130b);
                return sVar;
            }

            public a b(k kVar) {
                this.f129a = kVar;
                return this;
            }

            public a c(List<r> list) {
                this.f130b = list;
                return this;
            }
        }

        s() {
        }

        static s a(ArrayList<Object> arrayList) {
            s sVar = new s();
            Object obj = arrayList.get(0);
            sVar.b(obj == null ? null : k.a((ArrayList) obj));
            sVar.c((List) arrayList.get(1));
            return sVar;
        }

        public void b(k kVar) {
            if (kVar == null) {
                throw new IllegalStateException("Nonnull field \"billingResult\" is null.");
            }
            this.f127a = kVar;
        }

        public void c(List<r> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"purchases\" is null.");
            }
            this.f128b = list;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            k kVar = this.f127a;
            arrayList.add(kVar == null ? null : kVar.d());
            arrayList.add(this.f128b);
            return arrayList;
        }
    }

    public enum t {
        UNSPECIFIED(0),
        PURCHASED(1),
        PENDING(2);


        /* renamed from: c, reason: collision with root package name */
        final int f135c;

        t(int i3) {
            this.f135c = i3;
        }
    }

    public static final class u {

        /* renamed from: a, reason: collision with root package name */
        private k f136a;

        /* renamed from: b, reason: collision with root package name */
        private List<q> f137b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private k f138a;

            /* renamed from: b, reason: collision with root package name */
            private List<q> f139b;

            public u a() {
                u uVar = new u();
                uVar.b(this.f138a);
                uVar.c(this.f139b);
                return uVar;
            }

            public a b(k kVar) {
                this.f138a = kVar;
                return this;
            }

            public a c(List<q> list) {
                this.f139b = list;
                return this;
            }
        }

        u() {
        }

        static u a(ArrayList<Object> arrayList) {
            u uVar = new u();
            Object obj = arrayList.get(0);
            uVar.b(obj == null ? null : k.a((ArrayList) obj));
            uVar.c((List) arrayList.get(1));
            return uVar;
        }

        public void b(k kVar) {
            if (kVar == null) {
                throw new IllegalStateException("Nonnull field \"billingResult\" is null.");
            }
            this.f136a = kVar;
        }

        public void c(List<q> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"purchases\" is null.");
            }
            this.f137b = list;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            k kVar = this.f136a;
            arrayList.add(kVar == null ? null : kVar.d());
            arrayList.add(this.f137b);
            return arrayList;
        }
    }

    public static final class v {

        /* renamed from: a, reason: collision with root package name */
        private String f140a;

        /* renamed from: b, reason: collision with root package name */
        private p f141b;

        v() {
        }

        static v a(ArrayList<Object> arrayList) {
            v vVar = new v();
            vVar.d((String) arrayList.get(0));
            vVar.e(p.values()[((Integer) arrayList.get(1)).intValue()]);
            return vVar;
        }

        public String b() {
            return this.f140a;
        }

        public p c() {
            return this.f141b;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"productId\" is null.");
            }
            this.f140a = str;
        }

        public void e(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"productType\" is null.");
            }
            this.f141b = pVar;
        }

        ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f140a);
            p pVar = this.f141b;
            arrayList.add(pVar == null ? null : Integer.valueOf(pVar.f86c));
            return arrayList;
        }
    }

    public enum w {
        FINITE_RECURRING(0),
        INFINITE_RECURRING(1),
        NON_RECURRING(2);


        /* renamed from: c, reason: collision with root package name */
        final int f146c;

        w(int i3) {
            this.f146c = i3;
        }
    }

    public static final class x {

        /* renamed from: a, reason: collision with root package name */
        private String f147a;

        /* renamed from: b, reason: collision with root package name */
        private String f148b;

        /* renamed from: c, reason: collision with root package name */
        private String f149c;

        /* renamed from: d, reason: collision with root package name */
        private List<String> f150d;

        /* renamed from: e, reason: collision with root package name */
        private List<m> f151e;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f152a;

            /* renamed from: b, reason: collision with root package name */
            private String f153b;

            /* renamed from: c, reason: collision with root package name */
            private String f154c;

            /* renamed from: d, reason: collision with root package name */
            private List<String> f155d;

            /* renamed from: e, reason: collision with root package name */
            private List<m> f156e;

            public x a() {
                x xVar = new x();
                xVar.b(this.f152a);
                xVar.c(this.f153b);
                xVar.e(this.f154c);
                xVar.d(this.f155d);
                xVar.f(this.f156e);
                return xVar;
            }

            public a b(String str) {
                this.f152a = str;
                return this;
            }

            public a c(String str) {
                this.f153b = str;
                return this;
            }

            public a d(List<String> list) {
                this.f155d = list;
                return this;
            }

            public a e(String str) {
                this.f154c = str;
                return this;
            }

            public a f(List<m> list) {
                this.f156e = list;
                return this;
            }
        }

        x() {
        }

        static x a(ArrayList<Object> arrayList) {
            x xVar = new x();
            xVar.b((String) arrayList.get(0));
            xVar.c((String) arrayList.get(1));
            xVar.e((String) arrayList.get(2));
            xVar.d((List) arrayList.get(3));
            xVar.f((List) arrayList.get(4));
            return xVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"basePlanId\" is null.");
            }
            this.f147a = str;
        }

        public void c(String str) {
            this.f148b = str;
        }

        public void d(List<String> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"offerTags\" is null.");
            }
            this.f150d = list;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"offerToken\" is null.");
            }
            this.f149c = str;
        }

        public void f(List<m> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"pricingPhases\" is null.");
            }
            this.f151e = list;
        }

        ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f147a);
            arrayList.add(this.f148b);
            arrayList.add(this.f149c);
            arrayList.add(this.f150d);
            arrayList.add(this.f151e);
            return arrayList;
        }
    }

    public static final class y {

        /* renamed from: a, reason: collision with root package name */
        private String f157a;

        /* renamed from: b, reason: collision with root package name */
        private String f158b;

        /* renamed from: c, reason: collision with root package name */
        private List<z> f159c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f160a;

            /* renamed from: b, reason: collision with root package name */
            private String f161b;

            /* renamed from: c, reason: collision with root package name */
            private List<z> f162c;

            public y a() {
                y yVar = new y();
                yVar.c(this.f160a);
                yVar.b(this.f161b);
                yVar.d(this.f162c);
                return yVar;
            }

            public a b(String str) {
                this.f161b = str;
                return this;
            }

            public a c(String str) {
                this.f160a = str;
                return this;
            }

            public a d(List<z> list) {
                this.f162c = list;
                return this;
            }
        }

        y() {
        }

        static y a(ArrayList<Object> arrayList) {
            y yVar = new y();
            yVar.c((String) arrayList.get(0));
            yVar.b((String) arrayList.get(1));
            yVar.d((List) arrayList.get(2));
            return yVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"externalTransactionToken\" is null.");
            }
            this.f158b = str;
        }

        public void c(String str) {
            this.f157a = str;
        }

        public void d(List<z> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"products\" is null.");
            }
            this.f159c = list;
        }

        ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f157a);
            arrayList.add(this.f158b);
            arrayList.add(this.f159c);
            return arrayList;
        }
    }

    public static final class z {

        /* renamed from: a, reason: collision with root package name */
        private String f163a;

        /* renamed from: b, reason: collision with root package name */
        private String f164b;

        /* renamed from: c, reason: collision with root package name */
        private p f165c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f166a;

            /* renamed from: b, reason: collision with root package name */
            private String f167b;

            /* renamed from: c, reason: collision with root package name */
            private p f168c;

            public z a() {
                z zVar = new z();
                zVar.b(this.f166a);
                zVar.c(this.f167b);
                zVar.d(this.f168c);
                return zVar;
            }

            public a b(String str) {
                this.f166a = str;
                return this;
            }

            public a c(String str) {
                this.f167b = str;
                return this;
            }

            public a d(p pVar) {
                this.f168c = pVar;
                return this;
            }
        }

        z() {
        }

        static z a(ArrayList<Object> arrayList) {
            z zVar = new z();
            zVar.b((String) arrayList.get(0));
            zVar.c((String) arrayList.get(1));
            zVar.d(p.values()[((Integer) arrayList.get(2)).intValue()]);
            return zVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.f163a = str;
        }

        public void c(String str) {
            this.f164b = str;
        }

        public void d(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f165c = pVar;
        }

        ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f163a);
            arrayList.add(this.f164b);
            p pVar = this.f165c;
            arrayList.add(pVar == null ? null : Integer.valueOf(pVar.f86c));
            return arrayList;
        }
    }

    protected static a a(String str) {
        return new a("channel-error", "Unable to establish connection on channel: " + str + ".", "");
    }

    protected static ArrayList<Object> b(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof a) {
            a aVar = (a) th;
            arrayList.add(aVar.f14c);
            arrayList.add(aVar.getMessage());
            obj = aVar.f15d;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
