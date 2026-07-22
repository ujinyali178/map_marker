package kotlinx.coroutines.internal;

/* loaded from: /root/release/classes2.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f3771a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    private int f3772b;

    /* renamed from: c, reason: collision with root package name */
    private int f3773c;

    private final void b() {
        Object[] objArr = this.f3771a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        h2.i.e(objArr, objArr2, 0, this.f3772b, 0, 10, null);
        Object[] objArr3 = this.f3771a;
        int length2 = objArr3.length;
        int i3 = this.f3772b;
        h2.i.e(objArr3, objArr2, length2 - i3, 0, i3, 4, null);
        this.f3771a = objArr2;
        this.f3772b = 0;
        this.f3773c = length;
    }

    public final void a(T t3) {
        Object[] objArr = this.f3771a;
        int i3 = this.f3773c;
        objArr[i3] = t3;
        int length = (objArr.length - 1) & (i3 + 1);
        this.f3773c = length;
        if (length == this.f3772b) {
            b();
        }
    }

    public final boolean c() {
        return this.f3772b == this.f3773c;
    }

    public final T d() {
        int i3 = this.f3772b;
        if (i3 == this.f3773c) {
            return null;
        }
        Object[] objArr = this.f3771a;
        T t3 = (T) objArr[i3];
        objArr[i3] = null;
        this.f3772b = (i3 + 1) & (objArr.length - 1);
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
