package com.google.android.gms.common.util;

import androidx.collection.b;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> listOf(T t3) {
        return Collections.singletonList(t3);
    }

    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : Collections.singletonList(tArr[0]) : Collections.emptyList();
    }

    public static <K, V> Map<K, V> mapOf(K k3, V v3, K k4, V v4, K k5, V v5) {
        Map zza = zza(3, false);
        zza.put(k3, v3);
        zza.put(k4, v4);
        zza.put(k5, v5);
        return Collections.unmodifiableMap(zza);
    }

    public static <K, V> Map<K, V> mapOf(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        Map zza = zza(6, false);
        zza.put(k3, v3);
        zza.put(k4, v4);
        zza.put(k5, v5);
        zza.put(k6, v6);
        zza.put(k7, v7);
        zza.put(k8, v8);
        return Collections.unmodifiableMap(zza);
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map zza = zza(length, false);
        for (int i3 = 0; i3 < kArr.length; i3++) {
            zza.put(kArr[i3], vArr[i3]);
        }
        return Collections.unmodifiableMap(zza);
    }

    public static <T> Set<T> mutableSetOfWithSize(int i3) {
        return i3 == 0 ? new b() : zzb(i3, true);
    }

    @Deprecated
    public static <T> Set<T> setOf(T t3, T t4, T t5) {
        Set zzb = zzb(3, false);
        zzb.add(t3);
        zzb.add(t4);
        zzb.add(t5);
        return Collections.unmodifiableSet(zzb);
    }

    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t3 = tArr[0];
            T t4 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t3);
            zzb.add(t4);
            return Collections.unmodifiableSet(zzb);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set zzb2 = zzb(length, false);
            Collections.addAll(zzb2, tArr);
            return Collections.unmodifiableSet(zzb2);
        }
        T t5 = tArr[0];
        T t6 = tArr[1];
        T t7 = tArr[2];
        T t8 = tArr[3];
        Set zzb3 = zzb(4, false);
        zzb3.add(t5);
        zzb3.add(t6);
        zzb3.add(t7);
        zzb3.add(t8);
        return Collections.unmodifiableSet(zzb3);
    }

    private static Map zza(int i3, boolean z3) {
        return i3 <= 256 ? new androidx.collection.a(i3) : new HashMap(i3, 1.0f);
    }

    private static Set zzb(int i3, boolean z3) {
        if (i3 <= (true != z3 ? UserVerificationMethods.USER_VERIFY_HANDPRINT : 128)) {
            return new b(i3);
        }
        return new HashSet(i3, true != z3 ? 1.0f : 0.75f);
    }
}
