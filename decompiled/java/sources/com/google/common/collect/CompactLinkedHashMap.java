package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @CheckForNull
    transient long[] links;

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int i3) {
        this(i3, false);
    }

    CompactLinkedHashMap(int i3, boolean z3) {
        super(i3);
        this.accessOrder = z3;
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i3) {
        return new CompactLinkedHashMap<>(i3);
    }

    private int getPredecessor(int i3) {
        return ((int) (link(i3) >>> 32)) - 1;
    }

    private long link(int i3) {
        return requireLinks()[i3];
    }

    private long[] requireLinks() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void setLink(int i3, long j3) {
        requireLinks()[i3] = j3;
    }

    private void setPredecessor(int i3, int i4) {
        setLink(i3, (link(i3) & 4294967295L) | ((i4 + 1) << 32));
    }

    private void setSucceeds(int i3, int i4) {
        if (i3 == -2) {
            this.firstEntry = i4;
        } else {
            setSuccessor(i3, i4);
        }
        if (i4 == -2) {
            this.lastEntry = i3;
        } else {
            setPredecessor(i4, i3);
        }
    }

    private void setSuccessor(int i3, int i4) {
        setLink(i3, (link(i3) & (-4294967296L)) | ((i4 + 1) & 4294967295L));
    }

    @Override // com.google.common.collect.CompactHashMap
    void accessEntry(int i3) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i3), getSuccessor(i3));
            setSucceeds(this.lastEntry, i3);
            setSucceeds(i3, -2);
            incrementModCount();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    int adjustAfterRemove(int i3, int i4) {
        return i3 >= size() ? i4 : i3;
    }

    @Override // com.google.common.collect.CompactHashMap
    int allocArrays() {
        int allocArrays = super.allocArrays();
        this.links = new long[allocArrays];
        return allocArrays;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return convertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> createHashFloodingResistantDelegate(int i3) {
        return new LinkedHashMap(i3, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    int getSuccessor(int i3) {
        return ((int) link(i3)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    void init(int i3) {
        super.init(i3);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    void insertEntry(int i3, @ParametricNullness K k3, @ParametricNullness V v3, int i4, int i5) {
        super.insertEntry(i3, k3, v3, i4, i5);
        setSucceeds(this.lastEntry, i3);
        setSucceeds(i3, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    void moveLastEntry(int i3, int i4) {
        int size = size() - 1;
        super.moveLastEntry(i3, i4);
        setSucceeds(getPredecessor(i3), getSuccessor(i3));
        if (i3 < size) {
            setSucceeds(getPredecessor(size), i3);
            setSucceeds(i3, getSuccessor(size));
        }
        setLink(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    void resizeEntries(int i3) {
        super.resizeEntries(i3);
        this.links = Arrays.copyOf(requireLinks(), i3);
    }
}
