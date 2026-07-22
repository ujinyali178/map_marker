package t1;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.h;
import java.util.HashMap;
import u1.b;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final u1.b<Object> f4115a;

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f4116b;

    /* renamed from: c, reason: collision with root package name */
    private b f4117c;

    /* renamed from: d, reason: collision with root package name */
    public final b.d<Object> f4118d;

    /* renamed from: t1.a$a, reason: collision with other inner class name */
    class C0103a implements b.d<Object> {
        C0103a() {
        }

        @Override // u1.b.d
        public void a(Object obj, b.e<Object> eVar) {
            HashMap hashMap;
            HashMap hashMap2;
            if (a.this.f4117c == null) {
                eVar.a(null);
                return;
            }
            hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            hashMap2 = (HashMap) hashMap.get("data");
            g1.b.f("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            switch (str) {
                case "tooltip":
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        a.this.f4117c.e(str2);
                        break;
                    }
                    break;
                case "announce":
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        a.this.f4117c.d(str3);
                        break;
                    }
                    break;
                case "tap":
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        a.this.f4117c.c(num.intValue());
                        break;
                    }
                    break;
                case "focus":
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        a.this.f4117c.f(num2.intValue());
                        break;
                    }
                    break;
                case "longPress":
                    Integer num3 = (Integer) hashMap.get("nodeId");
                    if (num3 != null) {
                        a.this.f4117c.g(num3.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    public interface b extends FlutterJNI.a {
        void c(int i3);

        void d(String str);

        void e(String str);

        void f(int i3);

        void g(int i3);
    }

    public a(i1.a aVar, FlutterJNI flutterJNI) {
        C0103a c0103a = new C0103a();
        this.f4118d = c0103a;
        u1.b<Object> bVar = new u1.b<>(aVar, "flutter/accessibility", u1.o.f4384a);
        this.f4115a = bVar;
        bVar.e(c0103a);
        this.f4116b = flutterJNI;
    }

    public void b(int i3, h.g gVar) {
        this.f4116b.dispatchSemanticsAction(i3, gVar);
    }

    public void c(int i3, h.g gVar, Object obj) {
        this.f4116b.dispatchSemanticsAction(i3, gVar, obj);
    }

    public void d() {
        this.f4116b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f4116b.setSemanticsEnabled(true);
    }

    public void f(int i3) {
        this.f4116b.setAccessibilityFeatures(i3);
    }

    public void g(b bVar) {
        this.f4117c = bVar;
        this.f4116b.setAccessibilityDelegate(bVar);
    }
}
