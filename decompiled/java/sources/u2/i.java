package u2;

import java.util.Iterator;
import kotlin.jvm.internal.k;
import p2.l;

/* loaded from: /root/release/classes.dex */
public final class i<T, R> implements b<R> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f4393a;

    /* renamed from: b, reason: collision with root package name */
    private final l<T, R> f4394b;

    public static final class a implements Iterator<R> {

        /* renamed from: c, reason: collision with root package name */
        private final Iterator<T> f4395c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i<T, R> f4396d;

        a(i<T, R> iVar) {
            this.f4396d = iVar;
            this.f4395c = ((i) iVar).f4393a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4395c.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((i) this.f4396d).f4394b.invoke(this.f4395c.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(b<? extends T> sequence, l<? super T, ? extends R> transformer) {
        k.e(sequence, "sequence");
        k.e(transformer, "transformer");
        this.f4393a = sequence;
        this.f4394b = transformer;
    }

    @Override // u2.b
    public Iterator<R> iterator() {
        return new a(this);
    }
}
