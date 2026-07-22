package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@DoNotMock("Use ImmutableList.of or another implementation")
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] contents;
        boolean forceCopy;
        int size;

        ArrayBasedBuilder(int i3) {
            CollectPreconditions.checkNonnegative(i3, "initialCapacity");
            this.contents = new Object[i3];
            this.size = 0;
        }

        private void getReadyToExpandTo(int i3) {
            Object[] objArr = this.contents;
            if (objArr.length < i3) {
                this.contents = Arrays.copyOf(objArr, Builder.expandedCapacity(objArr.length, i3));
            } else if (!this.forceCopy) {
                return;
            } else {
                this.contents = (Object[]) objArr.clone();
            }
            this.forceCopy = false;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ArrayBasedBuilder<E> add(E e3) {
            Preconditions.checkNotNull(e3);
            getReadyToExpandTo(this.size + 1);
            Object[] objArr = this.contents;
            int i3 = this.size;
            this.size = i3 + 1;
            objArr[i3] = e3;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ Builder add(Object obj) {
            return add((ArrayBasedBuilder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... eArr) {
            addAll(eArr, eArr.length);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                getReadyToExpandTo(this.size + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.size = ((ImmutableCollection) collection).copyIntoArray(this.contents, this.size);
                    return this;
                }
            }
            super.addAll(iterable);
            return this;
        }

        final void addAll(Object[] objArr, int i3) {
            ObjectArrays.checkElementsNotNull(objArr, i3);
            getReadyToExpandTo(this.size + i3);
            System.arraycopy(objArr, 0, this.contents, this.size, i3);
            this.size += i3;
        }
    }

    @DoNotMock
    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        Builder() {
        }

        static int expandedCapacity(int i3, int i4) {
            if (i4 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i5 = i3 + (i3 >> 1) + 1;
            if (i5 < i4) {
                i5 = Integer.highestOneBit(i4 - 1) << 1;
            }
            if (i5 < 0) {
                return Integer.MAX_VALUE;
            }
            return i5;
        }

        public abstract Builder<E> add(E e3);

        public Builder<E> add(E... eArr) {
            for (E e3 : eArr) {
                add((Builder<E>) e3);
            }
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        public abstract ImmutableCollection<E> build();
    }

    ImmutableCollection() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@CheckForNull Object obj);

    int copyIntoArray(Object[] objArr, int i3) {
        UnmodifiableIterator<E> it = iterator();
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return i3;
    }

    @CheckForNull
    Object[] internalArray() {
        return null;
    }

    int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) Platform.copy(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }
}
