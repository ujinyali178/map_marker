package org.mapsforge.map.layer.queue;

import org.mapsforge.map.layer.queue.Job;

/* loaded from: /root/release/classes2.dex */
class QueueItem<T extends Job> {
    final T object;
    private double priority;

    QueueItem(T t3) {
        this.object = t3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QueueItem) {
            return this.object.equals(((QueueItem) obj).object);
        }
        return false;
    }

    double getPriority() {
        return this.priority;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    void setPriority(double d3) {
        if (d3 >= 0.0d && !Double.isNaN(d3)) {
            this.priority = d3;
            return;
        }
        throw new IllegalArgumentException("invalid priority: " + d3);
    }
}
