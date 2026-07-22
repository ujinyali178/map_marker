package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class AtomicLongMap<K> implements Serializable {

    @CheckForNull
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>(this) { // from class: com.google.common.util.concurrent.AtomicLongMap.1
            @Override // com.google.common.base.Function
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    public long addAndGet(K k3, long j3) {
        AtomicLong atomicLong;
        long j4;
        long j5;
        do {
            atomicLong = this.map.get(k3);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k3, new AtomicLong(j3))) == null) {
                return j3;
            }
            do {
                j4 = atomicLong.get();
                if (j4 != 0) {
                    j5 = j4 + j3;
                }
            } while (!atomicLong.compareAndSet(j4, j5));
            return j5;
        } while (!this.map.replace(k3, atomicLong, new AtomicLong(j3)));
        return j3;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Long> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public long decrementAndGet(K k3) {
        return addAndGet(k3, -1L);
    }

    public long get(K k3) {
        AtomicLong atomicLong = this.map.get(k3);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    public long getAndAdd(K k3, long j3) {
        AtomicLong atomicLong;
        long j4;
        do {
            atomicLong = this.map.get(k3);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k3, new AtomicLong(j3))) == null) {
                return 0L;
            }
            do {
                j4 = atomicLong.get();
                if (j4 == 0) {
                }
            } while (!atomicLong.compareAndSet(j4, j4 + j3));
            return j4;
        } while (!this.map.replace(k3, atomicLong, new AtomicLong(j3)));
        return 0L;
    }

    public long getAndDecrement(K k3) {
        return getAndAdd(k3, -1L);
    }

    public long getAndIncrement(K k3) {
        return getAndAdd(k3, 1L);
    }

    public long incrementAndGet(K k3) {
        return addAndGet(k3, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public long put(K k3, long j3) {
        AtomicLong atomicLong;
        long j4;
        do {
            atomicLong = this.map.get(k3);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k3, new AtomicLong(j3))) == null) {
                return 0L;
            }
            do {
                j4 = atomicLong.get();
                if (j4 == 0) {
                }
            } while (!atomicLong.compareAndSet(j4, j3));
            return j4;
        } while (!this.map.replace(k3, atomicLong, new AtomicLong(j3)));
        return 0L;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    long putIfAbsent(K k3, long j3) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k3);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k3, new AtomicLong(j3))) == null) {
                return 0L;
            }
            long j4 = atomicLong.get();
            if (j4 != 0) {
                return j4;
            }
        } while (!this.map.replace(k3, atomicLong, new AtomicLong(j3)));
        return 0L;
    }

    public long remove(K k3) {
        long j3;
        AtomicLong atomicLong = this.map.get(k3);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j3 = atomicLong.get();
            if (j3 == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j3, 0L));
        this.map.remove(k3, atomicLong);
        return j3;
    }

    boolean remove(K k3, long j3) {
        AtomicLong atomicLong = this.map.get(k3);
        if (atomicLong == null) {
            return false;
        }
        long j4 = atomicLong.get();
        if (j4 != j3) {
            return false;
        }
        if (j4 != 0 && !atomicLong.compareAndSet(j4, 0L)) {
            return false;
        }
        this.map.remove(k3, atomicLong);
        return true;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong value = it.next().getValue();
            if (value != null && value.get() == 0) {
                it.remove();
            }
        }
    }

    public boolean removeIfZero(K k3) {
        return remove(k3, 0L);
    }

    boolean replace(K k3, long j3, long j4) {
        if (j3 == 0) {
            return putIfAbsent(k3, j4) == 0;
        }
        AtomicLong atomicLong = this.map.get(k3);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(j3, j4);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> it = this.map.values().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().get();
        }
        return j3;
    }

    public String toString() {
        return this.map.toString();
    }
}
