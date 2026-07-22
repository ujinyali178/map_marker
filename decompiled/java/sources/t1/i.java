package t1;

import u1.l;

/* loaded from: /root/release/classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4152a;

    /* renamed from: b, reason: collision with root package name */
    private b f4153b;

    /* renamed from: c, reason: collision with root package name */
    private final l.c f4154c;

    class a implements l.c {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        
            return;
         */
        @Override // u1.l.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void n(u1.k r7, u1.l.d r8) {
            /*
                r6 = this;
                java.lang.String r0 = "error"
                t1.i r1 = t1.i.this
                t1.i$b r1 = t1.i.a(r1)
                if (r1 != 0) goto Lb
                return
            Lb:
                java.lang.String r1 = r7.f4372a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Received '"
                r2.append(r3)
                r2.append(r1)
                java.lang.String r3 = "' message."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "MouseCursorChannel"
                g1.b.f(r3, r2)
                r2 = -1
                r3 = 0
                int r4 = r1.hashCode()     // Catch: java.lang.Exception -> L75
                r5 = -1307105544(0xffffffffb21726f8, float:-8.798217E-9)
                if (r4 == r5) goto L34
                goto L3d
            L34:
                java.lang.String r4 = "activateSystemCursor"
                boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> L75
                if (r1 == 0) goto L3d
                r2 = 0
            L3d:
                if (r2 == 0) goto L40
                goto L8e
            L40:
                java.lang.Object r7 = r7.f4373b     // Catch: java.lang.Exception -> L75
                java.util.HashMap r7 = (java.util.HashMap) r7     // Catch: java.lang.Exception -> L75
                java.lang.String r1 = "kind"
                java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L75
                t1.i r1 = t1.i.this     // Catch: java.lang.Exception -> L5b
                t1.i$b r1 = t1.i.a(r1)     // Catch: java.lang.Exception -> L5b
                r1.a(r7)     // Catch: java.lang.Exception -> L5b
                java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L75
                r8.a(r7)     // Catch: java.lang.Exception -> L75
                goto L8e
            L5b:
                r7 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L75
                r1.<init>()     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "Error when setting cursors: "
                r1.append(r2)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Exception -> L75
                r1.append(r7)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L75
                r8.b(r0, r7, r3)     // Catch: java.lang.Exception -> L75
                goto L8e
            L75:
                r7 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unhandled error: "
                r1.append(r2)
                java.lang.String r7 = r7.getMessage()
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r8.b(r0, r7, r3)
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t1.i.a.n(u1.k, u1.l$d):void");
        }
    }

    public interface b {
        void a(String str);
    }

    public i(i1.a aVar) {
        a aVar2 = new a();
        this.f4154c = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/mousecursor", u1.p.f4387b);
        this.f4152a = lVar;
        lVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f4153b = bVar;
    }
}
