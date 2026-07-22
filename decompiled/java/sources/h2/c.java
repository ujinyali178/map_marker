package h2;

import java.util.AbstractList;

/* loaded from: /root/release/classes.dex */
public abstract class c<E> extends AbstractList<E> {
    protected c() {
    }

    public abstract int a();

    public abstract E b(int i3);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i3) {
        return b(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
