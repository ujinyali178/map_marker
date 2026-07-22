package w2;

import i2.g;
import java.io.Closeable;

/* loaded from: /root/release/classes2.dex */
public abstract class c1 extends c0 implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f4450f = new a(null);

    public static final class a extends i2.b<c0, c1> {

        /* renamed from: w2.c1$a$a, reason: collision with other inner class name */
        static final class C0112a extends kotlin.jvm.internal.l implements p2.l<g.b, c1> {

            /* renamed from: c, reason: collision with root package name */
            public static final C0112a f4451c = new C0112a();

            C0112a() {
                super(1);
            }

            @Override // p2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c1 invoke(g.b bVar) {
                if (bVar instanceof c1) {
                    return (c1) bVar;
                }
                return null;
            }
        }

        private a() {
            super(c0.f4448d, C0112a.f4451c);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }
}
