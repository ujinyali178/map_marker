package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;

    @LazyInit
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @CheckForNull
    @LazyInit
    private transient BiMap<V, K> inverse;

    @LazyInit
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;

    @LazyInit
    private transient Set<V> valueSet;
    transient V[] values;

    final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;

        @ParametricNullness
        final K key;

        EntryForKey(int i3) {
            this.key = (K) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i3]);
            this.index = i3;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            updateIndex();
            int i3 = this.index;
            return i3 == -1 ? (V) NullnessCasts.unsafeNull() : (V) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i3]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v3) {
            updateIndex();
            int i3 = this.index;
            if (i3 == -1) {
                HashBiMap.this.put(this.key, v3);
                return (V) NullnessCasts.unsafeNull();
            }
            V v4 = (V) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i3]);
            if (Objects.equal(v4, v3)) {
                return v3;
            }
            HashBiMap.this.replaceValueInEntry(this.index, v3, false);
            return v4;
        }

        void updateIndex() {
            int i3 = this.index;
            if (i3 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i3 <= hashBiMap.size && Objects.equal(hashBiMap.keys[i3], this.key)) {
                    return;
                }
            }
            this.index = HashBiMap.this.findEntryByKey(this.key);
        }
    }

    static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;

        @ParametricNullness
        final V value;

        EntryForValue(HashBiMap<K, V> hashBiMap, int i3) {
            this.biMap = hashBiMap;
            this.value = (V) NullnessCasts.uncheckedCastNullableTToT(hashBiMap.values[i3]);
            this.index = i3;
        }

        private void updateIndex() {
            int i3 = this.index;
            if (i3 != -1) {
                HashBiMap<K, V> hashBiMap = this.biMap;
                if (i3 <= hashBiMap.size && Objects.equal(this.value, hashBiMap.values[i3])) {
                    return;
                }
            }
            this.index = this.biMap.findEntryByValue(this.value);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getKey() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getValue() {
            updateIndex();
            int i3 = this.index;
            return i3 == -1 ? (K) NullnessCasts.unsafeNull() : (K) NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i3]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K setValue(@ParametricNullness K k3) {
            updateIndex();
            int i3 = this.index;
            if (i3 == -1) {
                this.biMap.putInverse(this.value, k3, false);
                return (K) NullnessCasts.unsafeNull();
            }
            K k4 = (K) NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i3]);
            if (Objects.equal(k4, k3)) {
                return k3;
            }
            this.biMap.replaceKeyInEntry(this.index, k3, false);
            return k4;
        }
    }

    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && Objects.equal(value, HashBiMap.this.values[findEntryByKey]);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<K, V> forEntry(int i3) {
            return new EntryForKey(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, smearedHash);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@CheckForNull Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // com.google.common.collect.BiMap
        @CheckForNull
        public K forcePut(@ParametricNullness V v3, @ParametricNullness K k3) {
            return this.forward.putInverse(v3, k3, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K get(@CheckForNull Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CheckForNull
        public K put(@ParametricNullness V v3, @ParametricNullness K k3) {
            return this.forward.putInverse(v3, k3, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K remove(@CheckForNull Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.biMap.findEntryByValue(key);
            return findEntryByValue != -1 && Objects.equal(this.biMap.keys[findEntryByValue], value);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<V, K> forEntry(int i3) {
            return new EntryForValue(this.biMap, i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByValue = this.biMap.findEntryByValue(key, smearedHash);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }
    }

    final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.HashBiMap.View
        @ParametricNullness
        K forEntry(int i3) {
            return (K) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i3]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, smearedHash);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // com.google.common.collect.HashBiMap.View
        @ParametricNullness
        V forEntry(int i3) {
            return (V) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i3]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, smearedHash);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }
    }

    static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.biMap.clear();
        }

        @ParametricNullness
        abstract T forEntry(int i3);

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = ((HashBiMap) View.this.biMap).firstInInsertionOrder;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    this.expectedModCount = hashBiMap.modCount;
                    this.remaining = hashBiMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    checkForComodification();
                    return this.index != -2 && this.remaining > 0;
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    T t3 = (T) View.this.forEntry(this.index);
                    this.indexToRemove = this.index;
                    this.index = ((HashBiMap) View.this.biMap).nextInInsertionOrder[this.index];
                    this.remaining--;
                    return t3;
                }

                @Override // java.util.Iterator
                public void remove() {
                    checkForComodification();
                    CollectPreconditions.checkRemove(this.indexToRemove != -1);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    int i3 = this.index;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    if (i3 == hashBiMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = hashBiMap.modCount;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.biMap.size;
        }
    }

    private HashBiMap(int i3) {
        init(i3);
    }

    private int bucket(int i3) {
        return i3 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i3) {
        return new HashBiMap<>(i3);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private static int[] createFilledWithAbsent(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i3, int i4) {
        Preconditions.checkArgument(i3 != -1);
        int bucket = bucket(i4);
        int[] iArr = this.hashTableKToV;
        int i5 = iArr[bucket];
        if (i5 == i3) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i3];
            iArr2[i3] = -1;
            return;
        }
        int i6 = this.nextInBucketKToV[i5];
        while (true) {
            int i7 = i5;
            i5 = i6;
            if (i5 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i3]);
            }
            if (i5 == i3) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i7] = iArr3[i3];
                iArr3[i3] = -1;
                return;
            }
            i6 = this.nextInBucketKToV[i5];
        }
    }

    private void deleteFromTableVToK(int i3, int i4) {
        Preconditions.checkArgument(i3 != -1);
        int bucket = bucket(i4);
        int[] iArr = this.hashTableVToK;
        int i5 = iArr[bucket];
        if (i5 == i3) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i3];
            iArr2[i3] = -1;
            return;
        }
        int i6 = this.nextInBucketVToK[i5];
        while (true) {
            int i7 = i5;
            i5 = i6;
            if (i5 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i3]);
            }
            if (i5 == i3) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i7] = iArr3[i3];
                iArr3[i3] = -1;
                return;
            }
            i6 = this.nextInBucketVToK[i5];
        }
    }

    private void ensureCapacity(int i3) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i3) {
            int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i3);
            this.keys = (K[]) Arrays.copyOf(this.keys, expandedCapacity);
            this.values = (V[]) Arrays.copyOf(this.values, expandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, expandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, expandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, expandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, expandedCapacity);
        }
        if (this.hashTableKToV.length < i3) {
            int closedTableSize = Hashing.closedTableSize(i3, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(closedTableSize);
            this.hashTableVToK = createFilledWithAbsent(closedTableSize);
            for (int i4 = 0; i4 < this.size; i4++) {
                int bucket = bucket(Hashing.smearedHash(this.keys[i4]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i4] = iArr3[bucket];
                iArr3[bucket] = i4;
                int bucket2 = bucket(Hashing.smearedHash(this.values[i4]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i4] = iArr5[bucket2];
                iArr5[bucket2] = i4;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i3) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i3);
        Arrays.fill(copyOf, length, i3, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i3, int i4) {
        Preconditions.checkArgument(i3 != -1);
        int bucket = bucket(i4);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i3] = iArr2[bucket];
        iArr2[bucket] = i3;
    }

    private void insertIntoTableVToK(int i3, int i4) {
        Preconditions.checkArgument(i3 != -1);
        int bucket = bucket(i4);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i3] = iArr2[bucket];
        iArr2[bucket] = i3;
    }

    private void moveEntryToIndex(int i3, int i4) {
        int i5;
        int i6;
        if (i3 == i4) {
            return;
        }
        int i7 = this.prevInInsertionOrder[i3];
        int i8 = this.nextInInsertionOrder[i3];
        setSucceeds(i7, i4);
        setSucceeds(i4, i8);
        K[] kArr = this.keys;
        K k3 = kArr[i3];
        V[] vArr = this.values;
        V v3 = vArr[i3];
        kArr[i4] = k3;
        vArr[i4] = v3;
        int bucket = bucket(Hashing.smearedHash(k3));
        int[] iArr = this.hashTableKToV;
        int i9 = iArr[bucket];
        if (i9 == i3) {
            iArr[bucket] = i4;
        } else {
            int i10 = this.nextInBucketKToV[i9];
            while (true) {
                i5 = i9;
                i9 = i10;
                if (i9 == i3) {
                    break;
                } else {
                    i10 = this.nextInBucketKToV[i9];
                }
            }
            this.nextInBucketKToV[i5] = i4;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i4] = iArr2[i3];
        iArr2[i3] = -1;
        int bucket2 = bucket(Hashing.smearedHash(v3));
        int[] iArr3 = this.hashTableVToK;
        int i11 = iArr3[bucket2];
        if (i11 == i3) {
            iArr3[bucket2] = i4;
        } else {
            int i12 = this.nextInBucketVToK[i11];
            while (true) {
                i6 = i11;
                i11 = i12;
                if (i11 == i3) {
                    break;
                } else {
                    i12 = this.nextInBucketVToK[i11];
                }
            }
            this.nextInBucketVToK[i6] = i4;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i4] = iArr4[i3];
        iArr4[i3] = -1;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }

    private void removeEntry(int i3, int i4, int i5) {
        Preconditions.checkArgument(i3 != -1);
        deleteFromTableKToV(i3, i4);
        deleteFromTableVToK(i3, i5);
        setSucceeds(this.prevInInsertionOrder[i3], this.nextInInsertionOrder[i3]);
        moveEntryToIndex(this.size - 1, i3);
        K[] kArr = this.keys;
        int i6 = this.size;
        kArr[i6 - 1] = null;
        this.values[i6 - 1] = null;
        this.size = i6 - 1;
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i3, @ParametricNullness K k3, boolean z3) {
        Preconditions.checkArgument(i3 != -1);
        int smearedHash = Hashing.smearedHash(k3);
        int findEntryByKey = findEntryByKey(k3, smearedHash);
        int i4 = this.lastInInsertionOrder;
        int i5 = -2;
        if (findEntryByKey != -1) {
            if (!z3) {
                throw new IllegalArgumentException("Key already present in map: " + k3);
            }
            i4 = this.prevInInsertionOrder[findEntryByKey];
            i5 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            if (i3 == this.size) {
                i3 = findEntryByKey;
            }
        }
        if (i4 == i3) {
            i4 = this.prevInInsertionOrder[i3];
        } else if (i4 == this.size) {
            i4 = findEntryByKey;
        }
        if (i5 == i3) {
            findEntryByKey = this.nextInInsertionOrder[i3];
        } else if (i5 != this.size) {
            findEntryByKey = i5;
        }
        setSucceeds(this.prevInInsertionOrder[i3], this.nextInInsertionOrder[i3]);
        deleteFromTableKToV(i3, Hashing.smearedHash(this.keys[i3]));
        this.keys[i3] = k3;
        insertIntoTableKToV(i3, Hashing.smearedHash(k3));
        setSucceeds(i4, i3);
        setSucceeds(i3, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i3, @ParametricNullness V v3, boolean z3) {
        Preconditions.checkArgument(i3 != -1);
        int smearedHash = Hashing.smearedHash(v3);
        int findEntryByValue = findEntryByValue(v3, smearedHash);
        if (findEntryByValue != -1) {
            if (!z3) {
                throw new IllegalArgumentException("Value already present in map: " + v3);
            }
            removeEntryValueHashKnown(findEntryByValue, smearedHash);
            if (i3 == this.size) {
                i3 = findEntryByValue;
            }
        }
        deleteFromTableVToK(i3, Hashing.smearedHash(this.values[i3]));
        this.values[i3] = v3;
        insertIntoTableVToK(i3, smearedHash);
    }

    private void setSucceeds(int i3, int i4) {
        if (i3 == -2) {
            this.firstInInsertionOrder = i4;
        } else {
            this.nextInInsertionOrder[i3] = i4;
        }
        if (i4 == -2) {
            this.lastInInsertionOrder = i3;
        } else {
            this.prevInInsertionOrder[i4] = i3;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    int findEntry(@CheckForNull Object obj, int i3, int[] iArr, int[] iArr2, Object[] objArr) {
        int i4 = iArr[bucket(i3)];
        while (i4 != -1) {
            if (Objects.equal(objArr[i4], obj)) {
                return i4;
            }
            i4 = iArr2[i4];
        }
        return -1;
    }

    int findEntryByKey(@CheckForNull Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    int findEntryByKey(@CheckForNull Object obj, int i3) {
        return findEntry(obj, i3, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    int findEntryByValue(@CheckForNull Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    int findEntryByValue(@CheckForNull Object obj, int i3) {
        return findEntry(obj, i3, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    public V forcePut(@ParametricNullness K k3, @ParametricNullness V v3) {
        return put(k3, v3, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @CheckForNull
    K getInverse(@CheckForNull Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    void init(int i3) {
        CollectPreconditions.checkNonnegative(i3, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i3, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i3];
        this.values = (V[]) new Object[i3];
        this.hashTableKToV = createFilledWithAbsent(closedTableSize);
        this.hashTableVToK = createFilledWithAbsent(closedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i3);
        this.nextInBucketVToK = createFilledWithAbsent(i3);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i3);
        this.nextInInsertionOrder = createFilledWithAbsent(i3);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CheckForNull
    public V put(@ParametricNullness K k3, @ParametricNullness V v3) {
        return put(k3, v3, false);
    }

    @CheckForNull
    V put(@ParametricNullness K k3, @ParametricNullness V v3, boolean z3) {
        int smearedHash = Hashing.smearedHash(k3);
        int findEntryByKey = findEntryByKey(k3, smearedHash);
        if (findEntryByKey != -1) {
            V v4 = this.values[findEntryByKey];
            if (Objects.equal(v4, v3)) {
                return v3;
            }
            replaceValueInEntry(findEntryByKey, v3, z3);
            return v4;
        }
        int smearedHash2 = Hashing.smearedHash(v3);
        int findEntryByValue = findEntryByValue(v3, smearedHash2);
        if (!z3) {
            Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", v3);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i3 = this.size;
        kArr[i3] = k3;
        this.values[i3] = v3;
        insertIntoTableKToV(i3, smearedHash);
        insertIntoTableVToK(this.size, smearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @CheckForNull
    K putInverse(@ParametricNullness V v3, @ParametricNullness K k3, boolean z3) {
        int smearedHash = Hashing.smearedHash(v3);
        int findEntryByValue = findEntryByValue(v3, smearedHash);
        if (findEntryByValue != -1) {
            K k4 = this.keys[findEntryByValue];
            if (Objects.equal(k4, k3)) {
                return k3;
            }
            replaceKeyInEntry(findEntryByValue, k3, z3);
            return k4;
        }
        int i3 = this.lastInInsertionOrder;
        int smearedHash2 = Hashing.smearedHash(k3);
        int findEntryByKey = findEntryByKey(k3, smearedHash2);
        if (!z3) {
            Preconditions.checkArgument(findEntryByKey == -1, "Key already present: %s", k3);
        } else if (findEntryByKey != -1) {
            i3 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i4 = this.size;
        kArr[i4] = k3;
        this.values[i4] = v3;
        insertIntoTableKToV(i4, smearedHash2);
        insertIntoTableVToK(this.size, smearedHash);
        int i5 = i3 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i3];
        setSucceeds(i3, this.size);
        setSucceeds(this.size, i5);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByKey = findEntryByKey(obj, smearedHash);
        if (findEntryByKey == -1) {
            return null;
        }
        V v3 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, smearedHash);
        return v3;
    }

    void removeEntry(int i3) {
        removeEntryKeyHashKnown(i3, Hashing.smearedHash(this.keys[i3]));
    }

    void removeEntryKeyHashKnown(int i3, int i4) {
        removeEntry(i3, i4, Hashing.smearedHash(this.values[i3]));
    }

    void removeEntryValueHashKnown(int i3, int i4) {
        removeEntry(i3, Hashing.smearedHash(this.keys[i3]), i4);
    }

    @CheckForNull
    K removeInverse(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByValue = findEntryByValue(obj, smearedHash);
        if (findEntryByValue == -1) {
            return null;
        }
        K k3 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, smearedHash);
        return k3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.valueSet = valueSet;
        return valueSet;
    }
}
