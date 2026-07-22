package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = new Object();

    @CheckForNull
    transient int[] entries;

    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;

    @CheckForNull
    private transient Set<K> keySetView;

    @CheckForNull
    transient Object[] keys;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    @CheckForNull
    transient Object[] values;

    @CheckForNull
    private transient Collection<V> valuesView;

    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            return indexOf != -1 && Objects.equal(CompactHashMap.this.value(indexOf), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int hashTableMask = CompactHashMap.this.hashTableMask();
            int remove = CompactHashing.remove(entry.getKey(), entry.getValue(), hashTableMask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (remove == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(remove, hashTableMask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;

        private Itr() {
            this.expectedMetadata = CompactHashMap.this.metadata;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.metadata != this.expectedMetadata) {
                throw new ConcurrentModificationException();
            }
        }

        @ParametricNullness
        abstract T getOutput(int i3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i3 = this.currentIndex;
            this.indexToRemove = i3;
            T output = getOutput(i3);
            this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
            return output;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            incrementExpectedModCount();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.indexToRemove));
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            return delegateOrNull != null ? delegateOrNull.keySet().remove(obj) : CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    final class MapEntry extends AbstractMapEntry<K, V> {

        @ParametricNullness
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i3) {
            this.key = (K) CompactHashMap.this.key(i3);
            this.lastKnownIndex = i3;
        }

        private void updateLastKnownIndex() {
            int i3 = this.lastKnownIndex;
            if (i3 == -1 || i3 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.key(this.lastKnownIndex))) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(delegateOrNull.get(this.key));
            }
            updateLastKnownIndex();
            int i3 = this.lastKnownIndex;
            return i3 == -1 ? (V) NullnessCasts.unsafeNull() : (V) CompactHashMap.this.value(i3);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v3) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(delegateOrNull.put(this.key, v3));
            }
            updateLastKnownIndex();
            int i3 = this.lastKnownIndex;
            if (i3 == -1) {
                CompactHashMap.this.put(this.key, v3);
                return (V) NullnessCasts.unsafeNull();
            }
            V v4 = (V) CompactHashMap.this.value(i3);
            CompactHashMap.this.setValue(this.lastKnownIndex, v3);
            return v4;
        }
    }

    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int i3) {
        init(i3);
    }

    static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i3 = compactHashMap.size;
        compactHashMap.size = i3 - 1;
        return i3;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i3) {
        return new CompactHashMap<>(i3);
    }

    private int entry(int i3) {
        return requireEntries()[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(requireTable(), smearedHash & hashTableMask);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i3 = tableGet - 1;
            int entry = entry(i3);
            if (CompactHashing.getHashPrefix(entry, hashTableMask) == hashPrefix && Objects.equal(obj, key(i3))) {
                return i3;
            }
            tableGet = CompactHashing.getNext(entry, hashTableMask);
        } while (tableGet != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K key(int i3) {
        return (K) requireKeys()[i3];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid size: " + readInt);
        }
        init(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object removeHelper(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, null, hashTableMask, requireTable(), requireEntries(), requireKeys(), null);
        if (remove == -1) {
            return NOT_FOUND;
        }
        V value = value(remove);
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] requireEntries() {
        int[] iArr = this.entries;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object requireTable() {
        Object obj = this.table;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireValues() {
        Object[] objArr = this.values;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void resizeMeMaybe(int i3) {
        int min;
        int length = requireEntries().length;
        if (i3 <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int resizeTable(int i3, int i4, int i5, int i6) {
        Object createTable = CompactHashing.createTable(i4);
        int i7 = i4 - 1;
        if (i6 != 0) {
            CompactHashing.tableSet(createTable, i5 & i7, i6 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i8 = 0; i8 <= i3; i8++) {
            int tableGet = CompactHashing.tableGet(requireTable, i8);
            while (tableGet != 0) {
                int i9 = tableGet - 1;
                int i10 = requireEntries[i9];
                int hashPrefix = CompactHashing.getHashPrefix(i10, i3) | i8;
                int i11 = hashPrefix & i7;
                int tableGet2 = CompactHashing.tableGet(createTable, i11);
                CompactHashing.tableSet(createTable, i11, tableGet);
                requireEntries[i9] = CompactHashing.maskCombine(hashPrefix, tableGet2, i7);
                tableGet = CompactHashing.getNext(i10, i3);
            }
        }
        this.table = createTable;
        setHashTableMask(i7);
        return i7;
    }

    private void setEntry(int i3, int i4) {
        requireEntries()[i3] = i4;
    }

    private void setHashTableMask(int i3) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i3), 31);
    }

    private void setKey(int i3, K k3) {
        requireKeys()[i3] = k3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i3, V v3) {
        requireValues()[i3] = v3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V value(int i3) {
        return (V) requireValues()[i3];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<K, V> next = entrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    void accessEntry(int i3) {
    }

    int adjustAfterRemove(int i3, int i4) {
        return i3 - 1;
    }

    int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i3 = this.metadata;
        int tableSize = CompactHashing.tableSize(i3);
        this.table = CompactHashing.createTable(tableSize);
        setHashTableMask(tableSize - 1);
        this.entries = new int[i3];
        this.keys = new Object[i3];
        this.values = new Object[i3];
        return i3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.metadata = Ints.constrainToRange(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.table = null;
        } else {
            Arrays.fill(requireKeys(), 0, this.size, (Object) null);
            Arrays.fill(requireValues(), 0, this.size, (Object) null);
            CompactHashing.tableClear(requireTable());
            Arrays.fill(requireEntries(), 0, this.size, 0);
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.containsKey(obj) : indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i3 = 0; i3 < this.size; i3++) {
            if (Objects.equal(obj, value(i3))) {
                return true;
            }
        }
        return false;
    }

    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(key(firstEntryIndex), value(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    Map<K, V> createHashFloodingResistantDelegate(int i3) {
        return new LinkedHashMap(i3, 1.0f);
    }

    Set<K> createKeySet() {
        return new KeySetView();
    }

    Collection<V> createValues() {
        return new ValuesView();
    }

    @CheckForNull
    Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.entrySet().iterator() : new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> getOutput(int i3) {
                return new MapEntry(i3);
            }
        };
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        accessEntry(indexOf);
        return value(indexOf);
    }

    int getSuccessor(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.size) {
            return i4;
        }
        return -1;
    }

    void incrementModCount() {
        this.metadata += 32;
    }

    void init(int i3) {
        Preconditions.checkArgument(i3 >= 0, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(i3, 1, 1073741823);
    }

    void insertEntry(int i3, @ParametricNullness K k3, @ParametricNullness V v3, int i4, int i5) {
        setEntry(i3, CompactHashing.maskCombine(i4, 0, i5));
        setKey(i3, k3);
        setValue(i3, v3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    Iterator<K> keySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.keySet().iterator() : new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            @ParametricNullness
            K getOutput(int i3) {
                return (K) CompactHashMap.this.key(i3);
            }
        };
    }

    void moveLastEntry(int i3, int i4) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int size = size() - 1;
        if (i3 >= size) {
            requireKeys[i3] = null;
            requireValues[i3] = null;
            requireEntries[i3] = 0;
            return;
        }
        Object obj = requireKeys[size];
        requireKeys[i3] = obj;
        requireValues[i3] = requireValues[size];
        requireKeys[size] = null;
        requireValues[size] = null;
        requireEntries[i3] = requireEntries[size];
        requireEntries[size] = 0;
        int smearedHash = Hashing.smearedHash(obj) & i4;
        int tableGet = CompactHashing.tableGet(requireTable, smearedHash);
        int i5 = size + 1;
        if (tableGet == i5) {
            CompactHashing.tableSet(requireTable, smearedHash, i3 + 1);
            return;
        }
        while (true) {
            int i6 = tableGet - 1;
            int i7 = requireEntries[i6];
            int next = CompactHashing.getNext(i7, i4);
            if (next == i5) {
                requireEntries[i6] = CompactHashing.maskCombine(i7, i3 + 1, i4);
                return;
            }
            tableGet = next;
        }
    }

    boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V put(@ParametricNullness K k3, @ParametricNullness V v3) {
        int i3;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k3, v3);
        }
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int i4 = this.size;
        int i5 = i4 + 1;
        int smearedHash = Hashing.smearedHash(k3);
        int hashTableMask = hashTableMask();
        int i6 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(requireTable(), i6);
        if (tableGet == 0) {
            if (i5 <= hashTableMask) {
                CompactHashing.tableSet(requireTable(), i6, i5);
                i3 = hashTableMask;
            }
            i3 = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i4);
        } else {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            int i7 = 0;
            while (true) {
                int i8 = tableGet - 1;
                int i9 = requireEntries[i8];
                if (CompactHashing.getHashPrefix(i9, hashTableMask) == hashPrefix && Objects.equal(k3, requireKeys[i8])) {
                    V v4 = (V) requireValues[i8];
                    requireValues[i8] = v3;
                    accessEntry(i8);
                    return v4;
                }
                int next = CompactHashing.getNext(i9, hashTableMask);
                i7++;
                if (next != 0) {
                    tableGet = next;
                } else {
                    if (i7 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k3, v3);
                    }
                    if (i5 <= hashTableMask) {
                        requireEntries[i8] = CompactHashing.maskCombine(i9, i5, hashTableMask);
                    }
                }
            }
        }
        resizeMeMaybe(i5);
        insertEntry(i4, k3, v3, smearedHash, i3);
        this.size = i5;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v3 = (V) removeHelper(obj);
        if (v3 == NOT_FOUND) {
            return null;
        }
        return v3;
    }

    void resizeEntries(int i3) {
        this.entries = Arrays.copyOf(requireEntries(), i3);
        this.keys = Arrays.copyOf(requireKeys(), i3);
        this.values = Arrays.copyOf(requireValues(), i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.putAll(delegateOrNull);
            this.table = createHashFloodingResistantDelegate;
            return;
        }
        int i3 = this.size;
        if (i3 < requireEntries().length) {
            resizeEntries(i3);
        }
        int tableSize = CompactHashing.tableSize(i3);
        int hashTableMask = hashTableMask();
        if (tableSize < hashTableMask) {
            resizeTable(hashTableMask, tableSize, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    Iterator<V> valuesIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.values().iterator() : new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            @ParametricNullness
            V getOutput(int i3) {
                return (V) CompactHashMap.this.value(i3);
            }
        };
    }
}
