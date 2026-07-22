package com.google.maps.android.data.geojson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class BiMultiMap<K> extends HashMap<K, Object> {
    private final Map<Object, K> mValuesToKeys = new HashMap();

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.mValuesToKeys.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public BiMultiMap<K> clone() {
        BiMultiMap<K> biMultiMap = new BiMultiMap<>();
        biMultiMap.putAll((Map) super.clone());
        return biMultiMap;
    }

    public K getKey(Object obj) {
        return this.mValuesToKeys.get(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(K k3, Object obj) {
        if (obj instanceof Collection) {
            return put((BiMultiMap<K>) k3, (Collection) obj);
        }
        this.mValuesToKeys.put(obj, k3);
        return super.put((BiMultiMap<K>) k3, (K) obj);
    }

    public Object put(K k3, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.mValuesToKeys.put(it.next(), k3);
        }
        return super.put((BiMultiMap<K>) k3, (K) collection);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ?> map) {
        for (Map.Entry<? extends K, ?> entry : map.entrySet()) {
            put((BiMultiMap<K>) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object remove = super.remove(obj);
        if (remove instanceof Collection) {
            Iterator it = ((Collection) remove).iterator();
            while (it.hasNext()) {
                this.mValuesToKeys.remove(it.next());
            }
        } else {
            this.mValuesToKeys.remove(remove);
        }
        return remove;
    }
}
