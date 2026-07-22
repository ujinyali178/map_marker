package com.google.common.collect;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class ObjectCountHashMap<K> {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    transient long[] entries;
    transient Object[] keys;
    private transient float loadFactor;
    transient int modCount;
    transient int size;
    private transient int[] table;
    private transient int threshold;
    transient int[] values;

    class MapEntry extends Multisets.AbstractEntry<K> {

        @ParametricNullness
        final K key;
        int lastKnownIndex;

        MapEntry(int i3) {
            this.key = (K) ObjectCountHashMap.this.keys[i3];
            this.lastKnownIndex = i3;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            updateLastKnownIndex();
            int i3 = this.lastKnownIndex;
            if (i3 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.values[i3];
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public K getElement() {
            return this.key;
        }

        public int setCount(int i3) {
            updateLastKnownIndex();
            int i4 = this.lastKnownIndex;
            if (i4 == -1) {
                ObjectCountHashMap.this.put(this.key, i3);
                return 0;
            }
            int[] iArr = ObjectCountHashMap.this.values;
            int i5 = iArr[i4];
            iArr[i4] = i3;
            return i5;
        }

        void updateLastKnownIndex() {
            int i3 = this.lastKnownIndex;
            if (i3 == -1 || i3 >= ObjectCountHashMap.this.size() || !Objects.equal(this.key, ObjectCountHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = ObjectCountHashMap.this.indexOf(this.key);
            }
        }
    }

    ObjectCountHashMap() {
        init(3, DEFAULT_LOAD_FACTOR);
    }

    ObjectCountHashMap(int i3) {
        this(i3, DEFAULT_LOAD_FACTOR);
    }

    ObjectCountHashMap(int i3, float f3) {
        init(i3, f3);
    }

    ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        init(objectCountHashMap.size(), DEFAULT_LOAD_FACTOR);
        int firstIndex = objectCountHashMap.firstIndex();
        while (firstIndex != -1) {
            put(objectCountHashMap.getKey(firstIndex), objectCountHashMap.getValue(firstIndex));
            firstIndex = objectCountHashMap.nextIndex(firstIndex);
        }
    }

    static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap<>();
    }

    static <K> ObjectCountHashMap<K> createWithExpectedSize(int i3) {
        return new ObjectCountHashMap<>(i3);
    }

    private static int getHash(long j3) {
        return (int) (j3 >>> 32);
    }

    private static int getNext(long j3) {
        return (int) j3;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i3) {
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int remove(@CheckForNull Object obj, int i3) {
        int hashTableMask = hashTableMask() & i3;
        int i4 = this.table[hashTableMask];
        if (i4 == -1) {
            return 0;
        }
        int i5 = -1;
        while (true) {
            if (getHash(this.entries[i4]) == i3 && Objects.equal(obj, this.keys[i4])) {
                int i6 = this.values[i4];
                if (i5 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i4]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i5] = swapNext(jArr[i5], getNext(jArr[i4]));
                }
                moveLastEntry(i4);
                this.size--;
                this.modCount++;
                return i6;
            }
            int next = getNext(this.entries[i4]);
            if (next == -1) {
                return 0;
            }
            i5 = i4;
            i4 = next;
        }
    }

    private void resizeMeMaybe(int i3) {
        int length = this.entries.length;
        if (i3 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i3) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i4 = ((int) (i3 * this.loadFactor)) + 1;
        int[] newTable = newTable(i3);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            int hash = getHash(jArr[i5]);
            int i6 = hash & length;
            int i7 = newTable[i6];
            newTable[i6] = i5;
            jArr[i5] = (hash << 32) | (i7 & NEXT_MASK);
        }
        this.threshold = i4;
        this.table = newTable;
    }

    private static long swapNext(long j3, int i3) {
        return (j3 & HASH_MASK) | (i3 & NEXT_MASK);
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return indexOf(obj) != -1;
    }

    void ensureCapacity(int i3) {
        if (i3 > this.entries.length) {
            resizeEntries(i3);
        }
        if (i3 >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i3 - 1) << 1));
        }
    }

    int firstIndex() {
        return this.size == 0 ? -1 : 0;
    }

    public int get(@CheckForNull Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.values[indexOf];
    }

    Multiset.Entry<K> getEntry(int i3) {
        Preconditions.checkElementIndex(i3, this.size);
        return new MapEntry(i3);
    }

    @ParametricNullness
    K getKey(int i3) {
        Preconditions.checkElementIndex(i3, this.size);
        return (K) this.keys[i3];
    }

    int getValue(int i3) {
        Preconditions.checkElementIndex(i3, this.size);
        return this.values[i3];
    }

    int indexOf(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int i3 = this.table[hashTableMask() & smearedHash];
        while (i3 != -1) {
            long j3 = this.entries[i3];
            if (getHash(j3) == smearedHash && Objects.equal(obj, this.keys[i3])) {
                return i3;
            }
            i3 = getNext(j3);
        }
        return -1;
    }

    void init(int i3, float f3) {
        Preconditions.checkArgument(i3 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f3 > BitmapDescriptorFactory.HUE_RED, "Illegal load factor");
        int closedTableSize = Hashing.closedTableSize(i3, f3);
        this.table = newTable(closedTableSize);
        this.loadFactor = f3;
        this.keys = new Object[i3];
        this.values = new int[i3];
        this.entries = newEntries(i3);
        this.threshold = Math.max(1, (int) (closedTableSize * f3));
    }

    void insertEntry(int i3, @ParametricNullness K k3, int i4, int i5) {
        this.entries[i3] = (i5 << 32) | NEXT_MASK;
        this.keys[i3] = k3;
        this.values[i3] = i4;
    }

    void moveLastEntry(int i3) {
        int size = size() - 1;
        if (i3 >= size) {
            this.keys[i3] = null;
            this.values[i3] = 0;
            this.entries[i3] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i3] = objArr[size];
        int[] iArr = this.values;
        iArr[i3] = iArr[size];
        objArr[size] = null;
        iArr[size] = 0;
        long[] jArr = this.entries;
        long j3 = jArr[size];
        jArr[i3] = j3;
        jArr[size] = -1;
        int hash = getHash(j3) & hashTableMask();
        int[] iArr2 = this.table;
        int i4 = iArr2[hash];
        if (i4 == size) {
            iArr2[hash] = i3;
            return;
        }
        while (true) {
            long j4 = this.entries[i4];
            int next = getNext(j4);
            if (next == size) {
                this.entries[i4] = swapNext(j4, i3);
                return;
            }
            i4 = next;
        }
    }

    int nextIndex(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.size) {
            return i4;
        }
        return -1;
    }

    int nextIndexAfterRemove(int i3, int i4) {
        return i3 - 1;
    }

    public int put(@ParametricNullness K k3, int i3) {
        CollectPreconditions.checkPositive(i3, "count");
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int smearedHash = Hashing.smearedHash(k3);
        int hashTableMask = hashTableMask() & smearedHash;
        int i4 = this.size;
        int[] iArr2 = this.table;
        int i5 = iArr2[hashTableMask];
        if (i5 == -1) {
            iArr2[hashTableMask] = i4;
        } else {
            while (true) {
                long j3 = jArr[i5];
                if (getHash(j3) == smearedHash && Objects.equal(k3, objArr[i5])) {
                    int i6 = iArr[i5];
                    iArr[i5] = i3;
                    return i6;
                }
                int next = getNext(j3);
                if (next == -1) {
                    jArr[i5] = swapNext(j3, i4);
                    break;
                }
                i5 = next;
            }
        }
        if (i4 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i7 = i4 + 1;
        resizeMeMaybe(i7);
        insertEntry(i4, k3, i3, smearedHash);
        this.size = i7;
        if (i4 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return 0;
    }

    public int remove(@CheckForNull Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    int removeEntry(int i3) {
        return remove(this.keys[i3], getHash(this.entries[i3]));
    }

    void resizeEntries(int i3) {
        this.keys = Arrays.copyOf(this.keys, i3);
        this.values = Arrays.copyOf(this.values, i3);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.entries = copyOf;
    }

    void setValue(int i3, int i4) {
        Preconditions.checkElementIndex(i3, this.size);
        this.values[i3] = i4;
    }

    int size() {
        return this.size;
    }
}
