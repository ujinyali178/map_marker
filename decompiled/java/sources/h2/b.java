package h2;

import java.util.List;

/* loaded from: /root/release/classes.dex */
public abstract class b<E> extends h2.a<E> implements List<E> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f2622c = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(int i3, int i4) {
            if (i3 < 0 || i3 >= i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void b(int i3, int i4) {
            if (i3 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }
    }
}
