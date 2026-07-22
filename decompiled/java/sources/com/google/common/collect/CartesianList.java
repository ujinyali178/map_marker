package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    private final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    CartesianList(ImmutableList<List<E>> immutableList) {
        this.axes = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = IntMath.checkedMultiply(iArr[size + 1], immutableList.get(size).size());
            }
            this.axesSizeProduct = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    static <E> List<List<E>> create(List<? extends List<? extends E>> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        Iterator<? extends List<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableList copyOf = ImmutableList.copyOf((Collection) it.next());
            if (copyOf.isEmpty()) {
                return ImmutableList.of();
            }
            builder.add((ImmutableList.Builder) copyOf);
        }
        return new CartesianList(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAxisIndexForProductIndex(int i3, int i4) {
        return (i3 / this.axesSizeProduct[i4 + 1]) % this.axes.get(i4).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != this.axes.size()) {
            return false;
        }
        Iterator<E> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!this.axes.get(i3).contains(it.next())) {
                return false;
            }
            i3++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public ImmutableList<E> get(final int i3) {
        Preconditions.checkElementIndex(i3, size());
        return new ImmutableList<E>() { // from class: com.google.common.collect.CartesianList.1
            @Override // java.util.List
            public E get(int i4) {
                Preconditions.checkElementIndex(i4, size());
                return (E) ((List) CartesianList.this.axes.get(i4)).get(CartesianList.this.getAxisIndexForProductIndex(i3, i4));
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return CartesianList.this.axes.size();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.axes.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i3 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int indexOf = this.axes.get(nextIndex).indexOf(listIterator.next());
            if (indexOf == -1) {
                return -1;
            }
            i3 += indexOf * this.axesSizeProduct[nextIndex + 1];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.axes.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i3 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int lastIndexOf = this.axes.get(nextIndex).lastIndexOf(listIterator.next());
            if (lastIndexOf == -1) {
                return -1;
            }
            i3 += lastIndexOf * this.axesSizeProduct[nextIndex + 1];
        }
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.axesSizeProduct[0];
    }
}
