package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    abstract class Itr<T> implements Iterator<T> {
        int index = 0;
        int toRemove = -1;

        Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.index < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i3 = this.index;
                if (iArr[i3] > 0) {
                    return true;
                }
                this.index = i3 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T output = output(this.index);
            int i3 = this.index;
            this.toRemove = i3;
            this.index = i3 + 1;
            return output;
        }

        abstract T output(int i3);

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove >= 0);
            if (EnumMultiset.this.counts[this.toRemove] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.access$322(EnumMultiset.this, r0.counts[this.toRemove]);
                EnumMultiset.this.counts[this.toRemove] = 0;
            }
            this.toRemove = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i3 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i3 - 1;
        return i3;
    }

    static /* synthetic */ long access$322(EnumMultiset enumMultiset, long j3) {
        long j4 = enumMultiset.size - j3;
        enumMultiset.size = j4;
        return j4;
    }

    private void checkIsE(Object obj) {
        Preconditions.checkNotNull(obj);
        if (isActuallyE(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.type + " but got " + obj);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }

    private boolean isActuallyE(@CheckForNull Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        int ordinal = r5.ordinal();
        E[] eArr = this.enumConstants;
        return ordinal < eArr.length && eArr[ordinal] == r5;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        Serialization.populateMultiset(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int add(E e3, int i3) {
        checkIsE(e3);
        CollectPreconditions.checkNonnegative(i3, "occurrences");
        if (i3 == 0) {
            return count(e3);
        }
        int ordinal = e3.ordinal();
        int i4 = this.counts[ordinal];
        long j3 = i3;
        long j4 = i4 + j3;
        Preconditions.checkArgument(j4 <= 2147483647L, "too many occurrences: %s", j4);
        this.counts[ordinal] = (int) j4;
        if (i4 == 0) {
            this.distinctElements++;
        }
        this.size += j3;
        return i4;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        return new EnumMultiset<E>.Itr<E>() { // from class: com.google.common.collect.EnumMultiset.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.EnumMultiset.Itr
            public E output(int i3) {
                return (E) EnumMultiset.this.enumConstants[i3];
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.EnumMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.EnumMultiset.Itr
            public Multiset.Entry<E> output(final int i3) {
                return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.EnumMultiset.2.1
                    @Override // com.google.common.collect.Multiset.Entry
                    public int getCount() {
                        return EnumMultiset.this.counts[i3];
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    public E getElement() {
                        return (E) EnumMultiset.this.enumConstants[i3];
                    }
                };
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@CheckForNull Object obj, int i3) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r12 = (Enum) obj;
        CollectPreconditions.checkNonnegative(i3, "occurrences");
        if (i3 == 0) {
            return count(obj);
        }
        int ordinal = r12.ordinal();
        int[] iArr = this.counts;
        int i4 = iArr[ordinal];
        if (i4 == 0) {
            return 0;
        }
        if (i4 <= i3) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i4;
        } else {
            iArr[ordinal] = i4 - i3;
            this.size -= i3;
        }
        return i4;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int setCount(E e3, int i3) {
        int i4;
        checkIsE(e3);
        CollectPreconditions.checkNonnegative(i3, "count");
        int ordinal = e3.ordinal();
        int[] iArr = this.counts;
        int i5 = iArr[ordinal];
        iArr[ordinal] = i3;
        this.size += i3 - i5;
        if (i5 != 0 || i3 <= 0) {
            if (i5 > 0 && i3 == 0) {
                i4 = this.distinctElements - 1;
            }
            return i5;
        }
        i4 = this.distinctElements + 1;
        this.distinctElements = i4;
        return i5;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean setCount(@ParametricNullness Object obj, int i3, int i4) {
        return super.setCount(obj, i3, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }
}
