package u2;

import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class f extends e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f4392a;

        public a(Iterator it) {
            this.f4392a = it;
        }

        @Override // u2.b
        public Iterator<T> iterator() {
            return this.f4392a;
        }
    }

    public static <T> b<T> a(Iterator<? extends T> it) {
        k.e(it, "<this>");
        return b(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> b(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return bVar instanceof u2.a ? bVar : new u2.a(bVar);
    }
}
