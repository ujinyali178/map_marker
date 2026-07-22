package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;

    @CheckForNull
    private final transient Object hashTable;
    private final transient int size;

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i3, int i4) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i3;
            this.size = i4;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.map.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i3) {
            return asList().copyIntoArray(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public Map.Entry<K, V> get(int i3) {
                    Preconditions.checkElementIndex(i3, EntrySet.this.size);
                    int i4 = i3 * 2;
                    Object obj = EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i4];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.alternatingKeysAndValues[i4 + (EntrySet.this.keyOffset ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.size;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.map.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i3) {
            return asList().copyIntoArray(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] objArr, int i3, int i4) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i3;
            this.size = i4;
        }

        @Override // java.util.List
        public Object get(int i3) {
            Preconditions.checkElementIndex(i3, this.size);
            Object obj = this.alternatingKeysAndValues[(i3 * 2) + this.offset];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    private RegularImmutableMap(@CheckForNull Object obj, Object[] objArr, int i3) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i3;
    }

    static <K, V> RegularImmutableMap<K, V> create(int i3, Object[] objArr) {
        return create(i3, objArr, null);
    }

    static <K, V> RegularImmutableMap<K, V> create(int i3, Object[] objArr, ImmutableMap.Builder<K, V> builder) {
        if (i3 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i3, objArr.length >> 1);
        Object createHashTable = createHashTable(objArr, i3, ImmutableSet.chooseTableSize(i3), 0);
        if (createHashTable instanceof Object[]) {
            Object[] objArr2 = (Object[]) createHashTable;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder == null) {
                throw duplicateKey.exception();
            }
            builder.duplicateKey = duplicateKey;
            Object obj3 = objArr2[0];
            int intValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, intValue * 2);
            createHashTable = obj3;
            i3 = intValue;
        }
        return new RegularImmutableMap<>(createHashTable, objArr, i3);
    }

    @CheckForNull
    private static Object createHashTable(Object[] objArr, int i3, int i4, int i5) {
        ImmutableMap.Builder.DuplicateKey duplicateKey = null;
        if (i3 == 1) {
            Object obj = objArr[i5];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i5 ^ 1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            return null;
        }
        int i6 = i4 - 1;
        int i7 = -1;
        if (i4 <= 128) {
            byte[] bArr = new byte[i4];
            Arrays.fill(bArr, (byte) -1);
            int i8 = 0;
            for (int i9 = 0; i9 < i3; i9++) {
                int i10 = (i9 * 2) + i5;
                int i11 = (i8 * 2) + i5;
                Object obj3 = objArr[i10];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i10 ^ 1];
                Objects.requireNonNull(obj4);
                CollectPreconditions.checkEntryNotNull(obj3, obj4);
                int smear = Hashing.smear(obj3.hashCode());
                while (true) {
                    int i12 = smear & i6;
                    int i13 = bArr[i12] & BYTE_MASK;
                    if (i13 == BYTE_MASK) {
                        bArr[i12] = (byte) i11;
                        if (i8 < i9) {
                            objArr[i11] = obj3;
                            objArr[i11 ^ 1] = obj4;
                        }
                        i8++;
                    } else {
                        if (obj3.equals(objArr[i13])) {
                            int i14 = i13 ^ 1;
                            Object obj5 = objArr[i14];
                            Objects.requireNonNull(obj5);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj3, obj4, obj5);
                            objArr[i14] = obj4;
                            break;
                        }
                        smear = i12 + 1;
                    }
                }
            }
            return i8 == i3 ? bArr : new Object[]{bArr, Integer.valueOf(i8), duplicateKey};
        }
        if (i4 <= SHORT_MAX_SIZE) {
            short[] sArr = new short[i4];
            Arrays.fill(sArr, (short) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i3; i16++) {
                int i17 = (i16 * 2) + i5;
                int i18 = (i15 * 2) + i5;
                Object obj6 = objArr[i17];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj7);
                CollectPreconditions.checkEntryNotNull(obj6, obj7);
                int smear2 = Hashing.smear(obj6.hashCode());
                while (true) {
                    int i19 = smear2 & i6;
                    int i20 = sArr[i19] & SHORT_MASK;
                    if (i20 == SHORT_MASK) {
                        sArr[i19] = (short) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj6;
                            objArr[i18 ^ 1] = obj7;
                        }
                        i15++;
                    } else {
                        if (obj6.equals(objArr[i20])) {
                            int i21 = i20 ^ 1;
                            Object obj8 = objArr[i21];
                            Objects.requireNonNull(obj8);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj6, obj7, obj8);
                            objArr[i21] = obj7;
                            break;
                        }
                        smear2 = i19 + 1;
                    }
                }
            }
            return i15 == i3 ? sArr : new Object[]{sArr, Integer.valueOf(i15), duplicateKey};
        }
        int[] iArr = new int[i4];
        Arrays.fill(iArr, -1);
        int i22 = 0;
        int i23 = 0;
        while (i22 < i3) {
            int i24 = (i22 * 2) + i5;
            int i25 = (i23 * 2) + i5;
            Object obj9 = objArr[i24];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i24 ^ 1];
            Objects.requireNonNull(obj10);
            CollectPreconditions.checkEntryNotNull(obj9, obj10);
            int smear3 = Hashing.smear(obj9.hashCode());
            while (true) {
                int i26 = smear3 & i6;
                int i27 = iArr[i26];
                if (i27 == i7) {
                    iArr[i26] = i25;
                    if (i23 < i22) {
                        objArr[i25] = obj9;
                        objArr[i25 ^ 1] = obj10;
                    }
                    i23++;
                } else {
                    if (obj9.equals(objArr[i27])) {
                        int i28 = i27 ^ 1;
                        Object obj11 = objArr[i28];
                        Objects.requireNonNull(obj11);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj9, obj10, obj11);
                        objArr[i28] = obj10;
                        break;
                    }
                    smear3 = i26 + 1;
                    i7 = -1;
                }
            }
            i22++;
            i7 = -1;
        }
        return i23 == i3 ? iArr : new Object[]{iArr, Integer.valueOf(i23), duplicateKey};
    }

    @CheckForNull
    static Object createHashTableOrThrow(Object[] objArr, int i3, int i4, int i5) {
        Object createHashTable = createHashTable(objArr, i3, i4, i5);
        if (createHashTable instanceof Object[]) {
            throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) createHashTable)[2]).exception();
        }
        return createHashTable;
    }

    @CheckForNull
    static Object get(@CheckForNull Object obj, Object[] objArr, int i3, int i4, @CheckForNull Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i3 == 1) {
            Object obj3 = objArr[i4];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i4 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int smear = Hashing.smear(obj2.hashCode());
            while (true) {
                int i5 = smear & length;
                int i6 = bArr[i5] & BYTE_MASK;
                if (i6 == BYTE_MASK) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                smear = i5 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int smear2 = Hashing.smear(obj2.hashCode());
            while (true) {
                int i7 = smear2 & length2;
                int i8 = sArr[i7] & SHORT_MASK;
                if (i8 == SHORT_MASK) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                smear2 = i7 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int smear3 = Hashing.smear(obj2.hashCode());
            while (true) {
                int i9 = smear3 & length3;
                int i10 = iArr[i9];
                if (i10 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i10])) {
                    return objArr[i10 ^ 1];
                }
                smear3 = i9 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V v3 = (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
        if (v3 == null) {
            return null;
        }
        return v3;
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }
}
