package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    abstract class Itr<T> implements Iterator<T> {
        int entryIndex;
        int expectedModCount;
        int toRemove = -1;

        Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.entryIndex >= 0;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = result(this.entryIndex);
            int i3 = this.entryIndex;
            this.toRemove = i3;
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i3);
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != -1);
            AbstractMapBasedMultiset.this.size -= r0.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        @ParametricNullness
        abstract T result(int i3);
    }

    AbstractMapBasedMultiset(int i3) {
        this.backingMap = newBackingMap(i3);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        this.backingMap = newBackingMap(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int add(@ParametricNullness E e3, int i3) {
        if (i3 == 0) {
            return count(e3);
        }
        Preconditions.checkArgument(i3 > 0, "occurrences cannot be negative: %s", i3);
        int indexOf = this.backingMap.indexOf(e3);
        if (indexOf == -1) {
            this.backingMap.put(e3, i3);
            this.size += i3;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j3 = i3;
        long j4 = value + j3;
        Preconditions.checkArgument(j4 <= 2147483647L, "too many occurrences: %s", j4);
        this.backingMap.setValue(indexOf, (int) j4);
        this.size += j3;
        return value;
    }

    void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.clear();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@CheckForNull Object obj) {
        return this.backingMap.get(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    final int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            @ParametricNullness
            E result(int i3) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i3);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public Multiset.Entry<E> result(int i3) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i3);
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    abstract ObjectCountHashMap<E> newBackingMap(int i3);

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int remove(@CheckForNull Object obj, int i3) {
        if (i3 == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i3 > 0, "occurrences cannot be negative: %s", i3);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i3) {
            this.backingMap.setValue(indexOf, value - i3);
        } else {
            this.backingMap.removeEntry(indexOf);
            i3 = value;
        }
        this.size -= i3;
        return value;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int setCount(@ParametricNullness E e3, int i3) {
        CollectPreconditions.checkNonnegative(i3, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i3 == 0 ? objectCountHashMap.remove(e3) : objectCountHashMap.put(e3, i3);
        this.size += i3 - remove;
        return remove;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@ParametricNullness E e3, int i3, int i4) {
        long j3;
        CollectPreconditions.checkNonnegative(i3, "oldCount");
        CollectPreconditions.checkNonnegative(i4, "newCount");
        int indexOf = this.backingMap.indexOf(e3);
        if (indexOf == -1) {
            if (i3 != 0) {
                return false;
            }
            if (i4 > 0) {
                this.backingMap.put(e3, i4);
                this.size += i4;
            }
            return true;
        }
        if (this.backingMap.getValue(indexOf) != i3) {
            return false;
        }
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        if (i4 == 0) {
            objectCountHashMap.removeEntry(indexOf);
            j3 = this.size - i3;
        } else {
            objectCountHashMap.setValue(indexOf, i4);
            j3 = this.size + (i4 - i3);
        }
        this.size = j3;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.size);
    }
}
