package w2;

/* loaded from: /root/release/classes2.dex */
public interface k<T> extends i2.d<T> {

    public static final class a {
        public static /* synthetic */ Object a(k kVar, Object obj, Object obj2, int i3, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i3 & 2) != 0) {
                obj2 = null;
            }
            return kVar.b(obj, obj2);
        }
    }

    Object b(T t3, Object obj);

    Object e(T t3, Object obj, p2.l<? super Throwable, g2.q> lVar);

    void g(T t3, p2.l<? super Throwable, g2.q> lVar);

    Object m(Throwable th);

    void n(p2.l<? super Throwable, g2.q> lVar);

    void w(Object obj);
}
