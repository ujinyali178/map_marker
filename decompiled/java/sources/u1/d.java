package u1;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public interface d {

    public interface a {
        void a(ByteBuffer byteBuffer, b bVar);
    }

    public interface b {
        void a(ByteBuffer byteBuffer);
    }

    public interface c {
    }

    /* renamed from: u1.d$d, reason: collision with other inner class name */
    public static class C0107d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4358a = true;

        public boolean a() {
            return this.f4358a;
        }
    }

    c a(C0107d c0107d);

    c b();

    void d(String str, a aVar);

    void e(String str, a aVar, c cVar);

    void f(String str, ByteBuffer byteBuffer);

    void i(String str, ByteBuffer byteBuffer, b bVar);
}
