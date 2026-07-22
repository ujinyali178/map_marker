package p;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<b<?>, Object> f4079a = new LinkedHashMap();

    /* renamed from: p.a$a, reason: collision with other inner class name */
    public static final class C0101a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0101a f4080b = new C0101a();

        private C0101a() {
        }

        @Override // p.a
        public <T> T a(b<T> key) {
            k.e(key, "key");
            return null;
        }
    }

    public interface b<T> {
    }

    public abstract <T> T a(b<T> bVar);

    public final Map<b<?>, Object> b() {
        return this.f4079a;
    }
}
