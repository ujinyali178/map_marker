package org.mapsforge.map.model.common;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /root/release/classes2.dex */
public class Observable implements ObservableInterface {
    private static final String OBSERVER_MUST_NOT_BE_NULL = "observer must not be null";
    private final List<Observer> observers = new CopyOnWriteArrayList();

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public final void addObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException(OBSERVER_MUST_NOT_BE_NULL);
        }
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
            return;
        }
        throw new IllegalArgumentException("observer is already registered: " + observer);
    }

    public final void notifyObservers() {
        Iterator<Observer> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onChange();
        }
    }

    @Override // org.mapsforge.map.model.common.ObservableInterface
    public final void removeObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException(OBSERVER_MUST_NOT_BE_NULL);
        }
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
            return;
        }
        throw new IllegalArgumentException("observer is not registered: " + observer);
    }
}
