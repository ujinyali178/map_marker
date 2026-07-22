package io.flutter.plugins.imagepicker;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.kxml2.wap.Wbxml;

/* loaded from: /root/release/classes.dex */
public class p {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f3415a;

        /* renamed from: b, reason: collision with root package name */
        private String f3416b;

        /* renamed from: io.flutter.plugins.imagepicker.p$a$a, reason: collision with other inner class name */
        public static final class C0088a {

            /* renamed from: a, reason: collision with root package name */
            private String f3417a;

            /* renamed from: b, reason: collision with root package name */
            private String f3418b;

            public a a() {
                a aVar = new a();
                aVar.b(this.f3417a);
                aVar.c(this.f3418b);
                return aVar;
            }

            public C0088a b(String str) {
                this.f3417a = str;
                return this;
            }

            public C0088a c(String str) {
                this.f3418b = str;
                return this;
            }
        }

        a() {
        }

        static a a(ArrayList<Object> arrayList) {
            a aVar = new a();
            aVar.b((String) arrayList.get(0));
            aVar.c((String) arrayList.get(1));
            return aVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"code\" is null.");
            }
            this.f3415a = str;
        }

        public void c(String str) {
            this.f3416b = str;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f3415a);
            arrayList.add(this.f3416b);
            return arrayList;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private c f3419a;

        /* renamed from: b, reason: collision with root package name */
        private a f3420b;

        /* renamed from: c, reason: collision with root package name */
        private List<String> f3421c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private c f3422a;

            /* renamed from: b, reason: collision with root package name */
            private a f3423b;

            /* renamed from: c, reason: collision with root package name */
            private List<String> f3424c;

            public b a() {
                b bVar = new b();
                bVar.d(this.f3422a);
                bVar.b(this.f3423b);
                bVar.c(this.f3424c);
                return bVar;
            }

            public a b(a aVar) {
                this.f3423b = aVar;
                return this;
            }

            public a c(List<String> list) {
                this.f3424c = list;
                return this;
            }

            public a d(c cVar) {
                this.f3422a = cVar;
                return this;
            }
        }

        b() {
        }

        static b a(ArrayList<Object> arrayList) {
            b bVar = new b();
            Object obj = arrayList.get(0);
            bVar.d(obj == null ? null : c.values()[((Integer) obj).intValue()]);
            Object obj2 = arrayList.get(1);
            bVar.b(obj2 != null ? a.a((ArrayList) obj2) : null);
            bVar.c((List) arrayList.get(2));
            return bVar;
        }

        public void b(a aVar) {
            this.f3420b = aVar;
        }

        public void c(List<String> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"paths\" is null.");
            }
            this.f3421c = list;
        }

        public void d(c cVar) {
            if (cVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f3419a = cVar;
        }

        ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            c cVar = this.f3419a;
            arrayList.add(cVar == null ? null : Integer.valueOf(cVar.f3428c));
            a aVar = this.f3420b;
            arrayList.add(aVar != null ? aVar.d() : null);
            arrayList.add(this.f3421c);
            return arrayList;
        }
    }

    public enum c {
        IMAGE(0),
        VIDEO(1);


        /* renamed from: c, reason: collision with root package name */
        final int f3428c;

        c(int i3) {
            this.f3428c = i3;
        }
    }

    public static class d extends RuntimeException {

        /* renamed from: c, reason: collision with root package name */
        public final String f3429c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f3430d;

        public d(String str, String str2, Object obj) {
            super(str2);
            this.f3429c = str;
            this.f3430d = obj;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f3431a;

        /* renamed from: b, reason: collision with root package name */
        private Boolean f3432b;

        e() {
        }

        static e a(ArrayList<Object> arrayList) {
            e eVar = new e();
            eVar.d((Boolean) arrayList.get(0));
            eVar.e((Boolean) arrayList.get(1));
            return eVar;
        }

        public Boolean b() {
            return this.f3431a;
        }

        public Boolean c() {
            return this.f3432b;
        }

        public void d(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
            }
            this.f3431a = bool;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
            }
            this.f3432b = bool;
        }

        ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f3431a);
            arrayList.add(this.f3432b);
            return arrayList;
        }
    }

    public interface f {
        void a(i iVar, e eVar, j<List<String>> jVar);

        void c(l lVar, h hVar, e eVar, j<List<String>> jVar);

        void f(l lVar, n nVar, e eVar, j<List<String>> jVar);

        b g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class g extends u1.o {

        /* renamed from: d, reason: collision with root package name */
        public static final g f3433d = new g();

        private g() {
        }

        @Override // u1.o
        protected Object g(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case Byte.MIN_VALUE:
                    return a.a((ArrayList) f(byteBuffer));
                case -127:
                    return b.a((ArrayList) f(byteBuffer));
                case -126:
                    return e.a((ArrayList) f(byteBuffer));
                case -125:
                    return h.a((ArrayList) f(byteBuffer));
                case -124:
                    return i.a((ArrayList) f(byteBuffer));
                case -123:
                    return l.a((ArrayList) f(byteBuffer));
                case -122:
                    return n.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b4, byteBuffer);
            }
        }

        @Override // u1.o
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> f3;
            if (obj instanceof a) {
                byteArrayOutputStream.write(128);
                f3 = ((a) obj).d();
            } else if (obj instanceof b) {
                byteArrayOutputStream.write(Wbxml.EXT_T_1);
                f3 = ((b) obj).e();
            } else if (obj instanceof e) {
                byteArrayOutputStream.write(Wbxml.EXT_T_2);
                f3 = ((e) obj).f();
            } else if (obj instanceof h) {
                byteArrayOutputStream.write(Wbxml.STR_T);
                f3 = ((h) obj).h();
            } else if (obj instanceof i) {
                byteArrayOutputStream.write(Wbxml.LITERAL_A);
                f3 = ((i) obj).d();
            } else {
                if (!(obj instanceof l)) {
                    if (!(obj instanceof n)) {
                        super.p(byteArrayOutputStream, obj);
                        return;
                    } else {
                        byteArrayOutputStream.write(134);
                        p(byteArrayOutputStream, ((n) obj).d());
                        return;
                    }
                }
                byteArrayOutputStream.write(133);
                f3 = ((l) obj).f();
            }
            p(byteArrayOutputStream, f3);
        }
    }

    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        private Double f3434a;

        /* renamed from: b, reason: collision with root package name */
        private Double f3435b;

        /* renamed from: c, reason: collision with root package name */
        private Long f3436c;

        h() {
        }

        static h a(ArrayList<Object> arrayList) {
            Long valueOf;
            h hVar = new h();
            hVar.f((Double) arrayList.get(0));
            hVar.e((Double) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            hVar.g(valueOf);
            return hVar;
        }

        public Double b() {
            return this.f3435b;
        }

        public Double c() {
            return this.f3434a;
        }

        public Long d() {
            return this.f3436c;
        }

        public void e(Double d3) {
            this.f3435b = d3;
        }

        public void f(Double d3) {
            this.f3434a = d3;
        }

        public void g(Long l3) {
            if (l3 == null) {
                throw new IllegalStateException("Nonnull field \"quality\" is null.");
            }
            this.f3436c = l3;
        }

        ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f3434a);
            arrayList.add(this.f3435b);
            arrayList.add(this.f3436c);
            return arrayList;
        }
    }

    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        private h f3437a;

        i() {
        }

        static i a(ArrayList<Object> arrayList) {
            i iVar = new i();
            Object obj = arrayList.get(0);
            iVar.c(obj == null ? null : h.a((ArrayList) obj));
            return iVar;
        }

        public h b() {
            return this.f3437a;
        }

        public void c(h hVar) {
            if (hVar == null) {
                throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
            }
            this.f3437a = hVar;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            h hVar = this.f3437a;
            arrayList.add(hVar == null ? null : hVar.h());
            return arrayList;
        }
    }

    public interface j<T> {
        void a(T t3);

        void b(Throwable th);
    }

    public enum k {
        REAR(0),
        FRONT(1);


        /* renamed from: c, reason: collision with root package name */
        final int f3441c;

        k(int i3) {
            this.f3441c = i3;
        }
    }

    public static final class l {

        /* renamed from: a, reason: collision with root package name */
        private m f3442a;

        /* renamed from: b, reason: collision with root package name */
        private k f3443b;

        l() {
        }

        static l a(ArrayList<Object> arrayList) {
            l lVar = new l();
            Object obj = arrayList.get(0);
            lVar.e(obj == null ? null : m.values()[((Integer) obj).intValue()]);
            Object obj2 = arrayList.get(1);
            lVar.d(obj2 != null ? k.values()[((Integer) obj2).intValue()] : null);
            return lVar;
        }

        public k b() {
            return this.f3443b;
        }

        public m c() {
            return this.f3442a;
        }

        public void d(k kVar) {
            this.f3443b = kVar;
        }

        public void e(m mVar) {
            if (mVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f3442a = mVar;
        }

        ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            m mVar = this.f3442a;
            arrayList.add(mVar == null ? null : Integer.valueOf(mVar.f3447c));
            k kVar = this.f3443b;
            arrayList.add(kVar != null ? Integer.valueOf(kVar.f3441c) : null);
            return arrayList;
        }
    }

    public enum m {
        CAMERA(0),
        GALLERY(1);


        /* renamed from: c, reason: collision with root package name */
        final int f3447c;

        m(int i3) {
            this.f3447c = i3;
        }
    }

    public static final class n {

        /* renamed from: a, reason: collision with root package name */
        private Long f3448a;

        static n a(ArrayList<Object> arrayList) {
            Long valueOf;
            n nVar = new n();
            Object obj = arrayList.get(0);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            nVar.c(valueOf);
            return nVar;
        }

        public Long b() {
            return this.f3448a;
        }

        public void c(Long l3) {
            this.f3448a = l3;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.f3448a);
            return arrayList;
        }
    }

    protected static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof d) {
            d dVar = (d) th;
            arrayList.add(dVar.f3429c);
            arrayList.add(dVar.getMessage());
            obj = dVar.f3430d;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
