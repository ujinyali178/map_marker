package d2;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.kxml2.wap.Wbxml;
import u1.o;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: d2.a$a, reason: collision with other inner class name */
    public static final class C0071a {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f2449a;

        C0071a() {
        }

        static C0071a a(ArrayList<Object> arrayList) {
            C0071a c0071a = new C0071a();
            c0071a.c((Boolean) arrayList.get(0));
            return c0071a;
        }

        public Boolean b() {
            return this.f2449a;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"showTitle\" is null.");
            }
            this.f2449a = bool;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.f2449a);
            return arrayList;
        }
    }

    public static class b extends RuntimeException {

        /* renamed from: c, reason: collision with root package name */
        public final String f2450c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f2451d;

        public b(String str, String str2, Object obj) {
            super(str2);
            this.f2450c = str;
            this.f2451d = obj;
        }
    }

    public interface c {
        Boolean a(String str);

        Boolean b(String str, Boolean bool, e eVar, C0071a c0071a);

        Boolean c();

        void d();

        Boolean e(String str, Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends o {

        /* renamed from: d, reason: collision with root package name */
        public static final d f2452d = new d();

        private d() {
        }

        @Override // u1.o
        protected Object g(byte b4, ByteBuffer byteBuffer) {
            return b4 != Byte.MIN_VALUE ? b4 != -127 ? super.g(b4, byteBuffer) : e.a((ArrayList) f(byteBuffer)) : C0071a.a((ArrayList) f(byteBuffer));
        }

        @Override // u1.o
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> h3;
            if (obj instanceof C0071a) {
                byteArrayOutputStream.write(128);
                h3 = ((C0071a) obj).d();
            } else if (!(obj instanceof e)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(Wbxml.EXT_T_1);
                h3 = ((e) obj).h();
            }
            p(byteArrayOutputStream, h3);
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f2453a;

        /* renamed from: b, reason: collision with root package name */
        private Boolean f2454b;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, String> f2455c;

        e() {
        }

        static e a(ArrayList<Object> arrayList) {
            e eVar = new e();
            eVar.f((Boolean) arrayList.get(0));
            eVar.e((Boolean) arrayList.get(1));
            eVar.g((Map) arrayList.get(2));
            return eVar;
        }

        public Boolean b() {
            return this.f2454b;
        }

        public Boolean c() {
            return this.f2453a;
        }

        public Map<String, String> d() {
            return this.f2455c;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
            }
            this.f2454b = bool;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
            }
            this.f2453a = bool;
        }

        public void g(Map<String, String> map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"headers\" is null.");
            }
            this.f2455c = map;
        }

        ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2453a);
            arrayList.add(this.f2454b);
            arrayList.add(this.f2455c);
            return arrayList;
        }
    }

    protected static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof b) {
            b bVar = (b) th;
            arrayList.add(bVar.f2450c);
            arrayList.add(bVar.getMessage());
            obj = bVar.f2451d;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
