package b1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class c extends b1.a {

    /* renamed from: a, reason: collision with root package name */
    final Map<String, Object> f1551a;

    /* renamed from: b, reason: collision with root package name */
    final a f1552b = new a();

    /* renamed from: c, reason: collision with root package name */
    final boolean f1553c;

    public class a implements f {

        /* renamed from: a, reason: collision with root package name */
        Object f1554a;

        /* renamed from: b, reason: collision with root package name */
        String f1555b;

        /* renamed from: c, reason: collision with root package name */
        String f1556c;

        /* renamed from: d, reason: collision with root package name */
        Object f1557d;

        public a() {
        }

        @Override // b1.f
        public void a(Object obj) {
            this.f1554a = obj;
        }

        @Override // b1.f
        public void b(String str, String str2, Object obj) {
            this.f1555b = str;
            this.f1556c = str2;
            this.f1557d = obj;
        }
    }

    public c(Map<String, Object> map, boolean z3) {
        this.f1551a = map;
        this.f1553c = z3;
    }

    @Override // b1.e
    public <T> T c(String str) {
        return (T) this.f1551a.get(str);
    }

    @Override // b1.b, b1.e
    public boolean e() {
        return this.f1553c;
    }

    @Override // b1.e
    public String getMethod() {
        return (String) this.f1551a.get("method");
    }

    @Override // b1.e
    public boolean h(String str) {
        return this.f1551a.containsKey(str);
    }

    @Override // b1.a
    public f n() {
        return this.f1552b;
    }

    public Map<String, Object> o() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.f1552b.f1555b);
        hashMap2.put("message", this.f1552b.f1556c);
        hashMap2.put("data", this.f1552b.f1557d);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public Map<String, Object> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f1552b.f1554a);
        return hashMap;
    }

    public void q(l.d dVar) {
        a aVar = this.f1552b;
        dVar.b(aVar.f1555b, aVar.f1556c, aVar.f1557d);
    }

    public void r(List<Map<String, Object>> list) {
        if (e()) {
            return;
        }
        list.add(o());
    }

    public void s(List<Map<String, Object>> list) {
        if (e()) {
            return;
        }
        list.add(p());
    }
}
