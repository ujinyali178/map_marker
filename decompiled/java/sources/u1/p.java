package u1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import u1.o;

/* loaded from: /root/release/classes.dex */
public final class p implements m {

    /* renamed from: b, reason: collision with root package name */
    public static final p f4387b = new p(o.f4384a);

    /* renamed from: a, reason: collision with root package name */
    private final o f4388a;

    public p(o oVar) {
        this.f4388a = oVar;
    }

    @Override // u1.m
    public k a(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f3 = this.f4388a.f(byteBuffer);
        Object f4 = this.f4388a.f(byteBuffer);
        if (!(f3 instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new k((String) f3, f4);
    }

    @Override // u1.m
    public ByteBuffer b(k kVar) {
        o.a aVar = new o.a();
        this.f4388a.p(aVar, kVar.f4372a);
        this.f4388a.p(aVar, kVar.f4373b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // u1.m
    public ByteBuffer c(Object obj) {
        o.a aVar = new o.a();
        aVar.write(0);
        this.f4388a.p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // u1.m
    public ByteBuffer d(String str, String str2, Object obj, String str3) {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f4388a.p(aVar, str);
        this.f4388a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f4388a.p(aVar, g1.b.d((Throwable) obj));
        } else {
            this.f4388a.p(aVar, obj);
        }
        this.f4388a.p(aVar, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // u1.m
    public ByteBuffer e(String str, String str2, Object obj) {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f4388a.p(aVar, str);
        this.f4388a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f4388a.p(aVar, g1.b.d((Throwable) obj));
        } else {
            this.f4388a.p(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 == 1) goto L10;
     */
    @Override // u1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            u1.o r0 = r4.f4388a
            java.lang.Object r0 = r0.f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            u1.o r0 = r4.f4388a
            java.lang.Object r0 = r0.f(r5)
            u1.o r1 = r4.f4388a
            java.lang.Object r1 = r1.f(r5)
            u1.o r2 = r4.f4388a
            java.lang.Object r2 = r2.f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            u1.f r5 = new u1.f
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.p.f(java.nio.ByteBuffer):java.lang.Object");
    }
}
