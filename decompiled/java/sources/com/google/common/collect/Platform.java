package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Platform {
    private Platform() {
    }

    static void checkGwtRpcEnabled() {
    }

    static <T> T[] copy(Object[] objArr, int i3, int i4, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i3, i4, tArr.getClass());
    }

    static <E extends Enum<E>> Class<E> getDeclaringClassOrObjectForJ2cl(E e3) {
        return e3.getDeclaringClass();
    }

    static <T> T[] newArray(T[] tArr, int i3) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i3);
    }

    static <K, V> Map<K, V> newHashMapWithExpectedSize(int i3) {
        return CompactHashMap.createWithExpectedSize(i3);
    }

    static <E> Set<E> newHashSetWithExpectedSize(int i3) {
        return CompactHashSet.createWithExpectedSize(i3);
    }

    static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i3) {
        return CompactLinkedHashMap.createWithExpectedSize(i3);
    }

    static <E> Set<E> newLinkedHashSetWithExpectedSize(int i3) {
        return CompactLinkedHashSet.createWithExpectedSize(i3);
    }

    static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    static int reduceExponentIfGwt(int i3) {
        return i3;
    }

    static int reduceIterationsIfGwt(int i3) {
        return i3;
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
