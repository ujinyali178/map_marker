package m1;

import android.content.Context;
import io.flutter.plugin.platform.m;
import io.flutter.view.TextureRegistry;
import u1.d;

/* loaded from: /root/release/classes.dex */
public interface a {

    /* renamed from: m1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0098a {
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f3954a;

        /* renamed from: b, reason: collision with root package name */
        private final io.flutter.embedding.engine.a f3955b;

        /* renamed from: c, reason: collision with root package name */
        private final d f3956c;

        /* renamed from: d, reason: collision with root package name */
        private final TextureRegistry f3957d;

        /* renamed from: e, reason: collision with root package name */
        private final m f3958e;

        /* renamed from: f, reason: collision with root package name */
        private final InterfaceC0098a f3959f;

        /* renamed from: g, reason: collision with root package name */
        private final io.flutter.embedding.engine.d f3960g;

        public b(Context context, io.flutter.embedding.engine.a aVar, d dVar, TextureRegistry textureRegistry, m mVar, InterfaceC0098a interfaceC0098a, io.flutter.embedding.engine.d dVar2) {
            this.f3954a = context;
            this.f3955b = aVar;
            this.f3956c = dVar;
            this.f3957d = textureRegistry;
            this.f3958e = mVar;
            this.f3959f = interfaceC0098a;
            this.f3960g = dVar2;
        }

        public Context a() {
            return this.f3954a;
        }

        public d b() {
            return this.f3956c;
        }

        @Deprecated
        public io.flutter.embedding.engine.a c() {
            return this.f3955b;
        }

        public m d() {
            return this.f3958e;
        }
    }

    void b(b bVar);

    void e(b bVar);
}
