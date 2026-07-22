package org.mapsforge.map.layer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public class Layers implements Iterable<Layer>, RandomAccess {
    private final DisplayModel displayModel;
    private final Map<Integer, Integer> groupIndex = new HashMap();
    private final List<Integer> groupList = new ArrayList();
    private final List<Layer> layersList = new CopyOnWriteArrayList();
    private final Redrawer redrawer;

    Layers(Redrawer redrawer, DisplayModel displayModel) {
        this.redrawer = redrawer;
        this.displayModel = displayModel;
    }

    private static void checkIsNull(Collection<Layer> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("layers must not be null");
        }
        Iterator<Layer> it = collection.iterator();
        while (it.hasNext()) {
            checkIsNull(it.next());
        }
    }

    private static void checkIsNull(Layer layer) {
        if (layer == null) {
            throw new IllegalArgumentException("layer must not be null");
        }
    }

    public synchronized void add(int i3, Layer layer) {
        add(i3, layer, true);
    }

    public synchronized void add(int i3, Layer layer, boolean z3) {
        checkIsNull(layer);
        layer.setDisplayModel(this.displayModel);
        this.layersList.add(i3, layer);
        layer.assign(this.redrawer);
        if (z3) {
            this.redrawer.redrawLayers();
        }
    }

    public synchronized void add(Layer layer) {
        add(layer, true);
    }

    public synchronized void add(Layer layer, int i3) {
        add(layer, i3, true);
    }

    public synchronized void add(Layer layer, int i3, boolean z3) {
        int indexOf = this.groupList.indexOf(Integer.valueOf(i3));
        if (indexOf < 0) {
            throw new IllegalArgumentException("unknown layer group");
        }
        int i4 = indexOf + 1;
        if (i4 == this.groupList.size()) {
            add(layer, z3);
        } else {
            add(this.groupIndex.get(this.groupList.get(i4)).intValue(), layer, z3);
            while (i4 < this.groupList.size()) {
                int intValue = this.groupList.get(i4).intValue();
                this.groupIndex.put(Integer.valueOf(intValue), Integer.valueOf(this.groupIndex.get(Integer.valueOf(intValue)).intValue() + 1));
                i4++;
            }
        }
    }

    public synchronized void add(Layer layer, boolean z3) {
        checkIsNull(layer);
        layer.setDisplayModel(this.displayModel);
        this.layersList.add(layer);
        layer.assign(this.redrawer);
        if (z3) {
            this.redrawer.redrawLayers();
        }
    }

    public synchronized boolean addAll(int i3, Collection<Layer> collection) {
        return addAll(i3, collection, true);
    }

    public synchronized boolean addAll(int i3, Collection<Layer> collection, boolean z3) {
        boolean z4;
        checkIsNull(collection);
        if (this.layersList.addAll(i3, collection)) {
            for (Layer layer : collection) {
                layer.setDisplayModel(this.displayModel);
                layer.assign(this.redrawer);
            }
            if (z3) {
                this.redrawer.redrawLayers();
            }
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    public synchronized boolean addAll(Collection<Layer> collection) {
        return addAll(collection, true);
    }

    public synchronized boolean addAll(Collection<Layer> collection, int i3) {
        return addAll(collection, i3, true);
    }

    public synchronized boolean addAll(Collection<Layer> collection, int i3, boolean z3) {
        int indexOf = this.groupList.indexOf(Integer.valueOf(i3));
        if (indexOf < 0) {
            throw new IllegalArgumentException("unknown layer group");
        }
        int i4 = indexOf + 1;
        if (i4 == this.groupList.size()) {
            return addAll(collection, z3);
        }
        if (!addAll(this.groupIndex.get(this.groupList.get(i4)).intValue(), collection, z3)) {
            return false;
        }
        while (i4 < this.groupList.size()) {
            int intValue = this.groupList.get(i4).intValue();
            this.groupIndex.put(Integer.valueOf(intValue), Integer.valueOf(this.groupIndex.get(Integer.valueOf(intValue)).intValue() + collection.size()));
            i4++;
        }
        return true;
    }

    public synchronized boolean addAll(Collection<Layer> collection, boolean z3) {
        boolean z4;
        checkIsNull(collection);
        Iterator<Layer> it = collection.iterator();
        while (it.hasNext()) {
            it.next().setDisplayModel(this.displayModel);
        }
        if (this.layersList.addAll(collection)) {
            Iterator<Layer> it2 = collection.iterator();
            while (it2.hasNext()) {
                it2.next().assign(this.redrawer);
            }
            if (z3) {
                this.redrawer.redrawLayers();
            }
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    public synchronized void addGroup(int i3) {
        if (this.groupList.contains(Integer.valueOf(i3))) {
            throw new IllegalArgumentException("group added twice");
        }
        this.groupList.add(Integer.valueOf(i3));
        this.groupIndex.put(Integer.valueOf(i3), Integer.valueOf(this.layersList.size()));
    }

    public synchronized void clear() {
        clear(true);
    }

    public synchronized void clear(boolean z3) {
        Iterator<Layer> it = this.layersList.iterator();
        while (it.hasNext()) {
            it.next().unassign();
        }
        this.layersList.clear();
        if (z3) {
            this.redrawer.redrawLayers();
        }
    }

    public synchronized boolean contains(Layer layer) {
        checkIsNull(layer);
        return this.layersList.contains(layer);
    }

    public synchronized Layer get(int i3) {
        return this.layersList.get(i3);
    }

    public synchronized int indexOf(Layer layer) {
        checkIsNull(layer);
        return this.layersList.indexOf(layer);
    }

    public synchronized boolean isEmpty() {
        return this.layersList.isEmpty();
    }

    @Override // java.lang.Iterable
    public synchronized Iterator<Layer> iterator() {
        return this.layersList.iterator();
    }

    public synchronized Layer remove(int i3) {
        return remove(i3, true);
    }

    public synchronized Layer remove(int i3, boolean z3) {
        Layer remove;
        remove = this.layersList.remove(i3);
        remove.unassign();
        for (Integer num : this.groupIndex.keySet()) {
            int intValue = this.groupIndex.get(num).intValue();
            if (intValue > i3) {
                this.groupIndex.put(num, Integer.valueOf(intValue - 1));
            }
        }
        if (z3) {
            this.redrawer.redrawLayers();
        }
        return remove;
    }

    public synchronized boolean remove(Layer layer) {
        return remove(layer, true);
    }

    public synchronized boolean remove(Layer layer, boolean z3) {
        checkIsNull(layer);
        int indexOf = this.layersList.indexOf(layer);
        if (!this.layersList.remove(layer)) {
            return false;
        }
        layer.unassign();
        for (Integer num : this.groupIndex.keySet()) {
            int intValue = this.groupIndex.get(num).intValue();
            if (intValue > indexOf) {
                this.groupIndex.put(num, Integer.valueOf(intValue - 1));
            }
        }
        if (z3) {
            this.redrawer.redrawLayers();
        }
        return true;
    }

    public synchronized boolean removeAll(Collection<Layer> collection) {
        return removeAll(collection, true);
    }

    public synchronized boolean removeAll(Collection<Layer> collection, boolean z3) {
        checkIsNull(collection);
        int size = collection.size();
        int[] iArr = new int[size];
        Iterator<Layer> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = this.layersList.indexOf(it.next());
            i3++;
        }
        if (!this.layersList.removeAll(collection)) {
            return false;
        }
        Iterator<Layer> it2 = collection.iterator();
        while (it2.hasNext()) {
            it2.next().unassign();
        }
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            for (Integer num : this.groupIndex.keySet()) {
                int intValue = this.groupIndex.get(num).intValue();
                if (intValue > i5) {
                    this.groupIndex.put(num, Integer.valueOf(intValue - 1));
                }
            }
        }
        if (z3) {
            this.redrawer.redrawLayers();
        }
        return true;
    }

    public synchronized int size() {
        return this.layersList.size();
    }
}
