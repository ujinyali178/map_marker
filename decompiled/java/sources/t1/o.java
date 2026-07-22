package t1;

import java.util.HashMap;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4253a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f4254b;

    /* renamed from: c, reason: collision with root package name */
    private u1.l f4255c;

    /* renamed from: d, reason: collision with root package name */
    private l.d f4256d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4257e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4258f;

    /* renamed from: g, reason: collision with root package name */
    private final l.c f4259g;

    class a implements l.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f4260a;

        a(byte[] bArr) {
            this.f4260a = bArr;
        }

        @Override // u1.l.d
        public void a(Object obj) {
            o.this.f4254b = this.f4260a;
        }

        @Override // u1.l.d
        public void b(String str, String str2, Object obj) {
            g1.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // u1.l.d
        public void c() {
        }
    }

    class b implements l.c {
        b() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            Map i3;
            String str = kVar.f4372a;
            Object obj = kVar.f4373b;
            str.hashCode();
            if (str.equals("get")) {
                o.this.f4258f = true;
                if (!o.this.f4257e) {
                    o oVar = o.this;
                    if (oVar.f4253a) {
                        oVar.f4256d = dVar;
                        return;
                    }
                }
                o oVar2 = o.this;
                i3 = oVar2.i(oVar2.f4254b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                o.this.f4254b = (byte[]) obj;
                i3 = null;
            }
            dVar.a(i3);
        }
    }

    public o(i1.a aVar, boolean z3) {
        this(new u1.l(aVar, "flutter/restoration", u1.p.f4387b), z3);
    }

    o(u1.l lVar, boolean z3) {
        this.f4257e = false;
        this.f4258f = false;
        b bVar = new b();
        this.f4259g = bVar;
        this.f4255c = lVar;
        this.f4253a = z3;
        lVar.e(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void g() {
        this.f4254b = null;
    }

    public byte[] h() {
        return this.f4254b;
    }

    public void j(byte[] bArr) {
        this.f4257e = true;
        l.d dVar = this.f4256d;
        if (dVar != null) {
            dVar.a(i(bArr));
            this.f4256d = null;
        } else if (this.f4258f) {
            this.f4255c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f4254b = bArr;
    }
}
