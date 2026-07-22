package q2;

import java.util.Random;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class b extends q2.a {

    /* renamed from: f, reason: collision with root package name */
    private final a f4094f = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // q2.a
    public Random c() {
        Random random = this.f4094f.get();
        k.d(random, "implStorage.get()");
        return random;
    }
}
