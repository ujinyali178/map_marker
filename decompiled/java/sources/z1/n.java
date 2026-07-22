package z1;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.kxml2.wap.Wbxml;

/* loaded from: /root/release/classes.dex */
public class n {

    public static class a extends RuntimeException {

        /* renamed from: c, reason: collision with root package name */
        public final String f4863c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f4864d;

        public a(String str, String str2, Object obj) {
            super(str2);
            this.f4863c = str;
            this.f4864d = obj;
        }
    }

    public interface b {
        void b(List<String> list, e<Boolean> eVar);

        void c(String str, e<Void> eVar);

        void d(e<Void> eVar);

        Boolean e();

        void f(e<g> eVar);

        void g(String str, Boolean bool, e<String> eVar);

        void h(e<Void> eVar);

        void i(e<g> eVar);

        void j(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends u1.o {

        /* renamed from: d, reason: collision with root package name */
        public static final c f4865d = new c();

        private c() {
        }

        @Override // u1.o
        protected Object g(byte b4, ByteBuffer byteBuffer) {
            return b4 != Byte.MIN_VALUE ? b4 != -127 ? super.g(b4, byteBuffer) : g.a((ArrayList) f(byteBuffer)) : d.a((ArrayList) f(byteBuffer));
        }

        @Override // u1.o
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> h3;
            if (obj instanceof d) {
                byteArrayOutputStream.write(128);
                h3 = ((d) obj).n();
            } else if (!(obj instanceof g)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(Wbxml.EXT_T_1);
                h3 = ((g) obj).h();
            }
            p(byteArrayOutputStream, h3);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private List<String> f4866a;

        /* renamed from: b, reason: collision with root package name */
        private f f4867b;

        /* renamed from: c, reason: collision with root package name */
        private String f4868c;

        /* renamed from: d, reason: collision with root package name */
        private String f4869d;

        /* renamed from: e, reason: collision with root package name */
        private String f4870e;

        /* renamed from: f, reason: collision with root package name */
        private Boolean f4871f;

        d() {
        }

        static d a(ArrayList<Object> arrayList) {
            d dVar = new d();
            dVar.k((List) arrayList.get(0));
            Object obj = arrayList.get(1);
            dVar.m(obj == null ? null : f.values()[((Integer) obj).intValue()]);
            dVar.j((String) arrayList.get(2));
            dVar.h((String) arrayList.get(3));
            dVar.l((String) arrayList.get(4));
            dVar.i((Boolean) arrayList.get(5));
            return dVar;
        }

        public String b() {
            return this.f4869d;
        }

        public Boolean c() {
            return this.f4871f;
        }

        public String d() {
            return this.f4868c;
        }

        public List<String> e() {
            return this.f4866a;
        }

        public String f() {
            return this.f4870e;
        }

        public f g() {
            return this.f4867b;
        }

        public void h(String str) {
            this.f4869d = str;
        }

        public void i(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"forceCodeForRefreshToken\" is null.");
            }
            this.f4871f = bool;
        }

        public void j(String str) {
            this.f4868c = str;
        }

        public void k(List<String> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"scopes\" is null.");
            }
            this.f4866a = list;
        }

        public void l(String str) {
            this.f4870e = str;
        }

        public void m(f fVar) {
            if (fVar == null) {
                throw new IllegalStateException("Nonnull field \"signInType\" is null.");
            }
            this.f4867b = fVar;
        }

        ArrayList<Object> n() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.f4866a);
            f fVar = this.f4867b;
            arrayList.add(fVar == null ? null : Integer.valueOf(fVar.f4875c));
            arrayList.add(this.f4868c);
            arrayList.add(this.f4869d);
            arrayList.add(this.f4870e);
            arrayList.add(this.f4871f);
            return arrayList;
        }
    }

    public interface e<T> {
        void a(T t3);

        void b(Throwable th);
    }

    public enum f {
        STANDARD(0),
        GAMES(1);


        /* renamed from: c, reason: collision with root package name */
        final int f4875c;

        f(int i3) {
            this.f4875c = i3;
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        private String f4876a;

        /* renamed from: b, reason: collision with root package name */
        private String f4877b;

        /* renamed from: c, reason: collision with root package name */
        private String f4878c;

        /* renamed from: d, reason: collision with root package name */
        private String f4879d;

        /* renamed from: e, reason: collision with root package name */
        private String f4880e;

        /* renamed from: f, reason: collision with root package name */
        private String f4881f;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private String f4882a;

            /* renamed from: b, reason: collision with root package name */
            private String f4883b;

            /* renamed from: c, reason: collision with root package name */
            private String f4884c;

            /* renamed from: d, reason: collision with root package name */
            private String f4885d;

            /* renamed from: e, reason: collision with root package name */
            private String f4886e;

            /* renamed from: f, reason: collision with root package name */
            private String f4887f;

            public g a() {
                g gVar = new g();
                gVar.b(this.f4882a);
                gVar.c(this.f4883b);
                gVar.d(this.f4884c);
                gVar.f(this.f4885d);
                gVar.e(this.f4886e);
                gVar.g(this.f4887f);
                return gVar;
            }

            public a b(String str) {
                this.f4882a = str;
                return this;
            }

            public a c(String str) {
                this.f4883b = str;
                return this;
            }

            public a d(String str) {
                this.f4884c = str;
                return this;
            }

            public a e(String str) {
                this.f4886e = str;
                return this;
            }

            public a f(String str) {
                this.f4885d = str;
                return this;
            }

            public a g(String str) {
                this.f4887f = str;
                return this;
            }
        }

        g() {
        }

        static g a(ArrayList<Object> arrayList) {
            g gVar = new g();
            gVar.b((String) arrayList.get(0));
            gVar.c((String) arrayList.get(1));
            gVar.d((String) arrayList.get(2));
            gVar.f((String) arrayList.get(3));
            gVar.e((String) arrayList.get(4));
            gVar.g((String) arrayList.get(5));
            return gVar;
        }

        public void b(String str) {
            this.f4876a = str;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"email\" is null.");
            }
            this.f4877b = str;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.f4878c = str;
        }

        public void e(String str) {
            this.f4880e = str;
        }

        public void f(String str) {
            this.f4879d = str;
        }

        public void g(String str) {
            this.f4881f = str;
        }

        ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.f4876a);
            arrayList.add(this.f4877b);
            arrayList.add(this.f4878c);
            arrayList.add(this.f4879d);
            arrayList.add(this.f4880e);
            arrayList.add(this.f4881f);
            return arrayList;
        }
    }

    protected static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof a) {
            a aVar = (a) th;
            arrayList.add(aVar.f4863c);
            arrayList.add(aVar.getMessage());
            obj = aVar.f4864d;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
