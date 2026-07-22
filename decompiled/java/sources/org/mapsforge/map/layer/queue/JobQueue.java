package org.mapsforge.map.layer.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.mapsforge.map.layer.queue.Job;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.IMapViewPosition;

/* loaded from: /root/release/classes2.dex */
public class JobQueue<T extends Job> {
    private static final int QUEUE_CAPACITY = 128;
    private final DisplayModel displayModel;
    private boolean isInterrupted;
    private final IMapViewPosition mapViewPosition;
    private boolean scheduleNeeded;
    private final List<T> assignedJobs = new LinkedList();
    private final List<QueueItem<T>> queueItems = new LinkedList();

    public JobQueue(IMapViewPosition iMapViewPosition, DisplayModel displayModel) {
        this.mapViewPosition = iMapViewPosition;
        this.displayModel = displayModel;
    }

    private void schedule(int i3) {
        QueueItemScheduler.schedule(this.queueItems, this.mapViewPosition.getMapPosition(), i3);
        Collections.sort(this.queueItems, QueueItemComparator.INSTANCE);
        trimToSize();
    }

    private void trimToSize() {
        int size = this.queueItems.size();
        while (size > 128) {
            size--;
            this.queueItems.remove(size);
        }
    }

    public synchronized void add(T t3) {
        if (!this.assignedJobs.contains(t3)) {
            QueueItem<T> queueItem = new QueueItem<>(t3);
            if (!this.queueItems.contains(queueItem)) {
                this.queueItems.add(queueItem);
                this.scheduleNeeded = true;
                notifyWorkers();
            }
        }
    }

    public synchronized T get() {
        return get(Integer.MAX_VALUE);
    }

    public synchronized T get(int i3) {
        do {
            if (!this.queueItems.isEmpty() && this.assignedJobs.size() < i3) {
                if (this.scheduleNeeded) {
                    this.scheduleNeeded = false;
                    schedule(this.displayModel.getTileSize());
                }
                T t3 = this.queueItems.remove(0).object;
                this.assignedJobs.add(t3);
                return t3;
            }
            wait(200L);
        } while (!this.isInterrupted);
        this.isInterrupted = false;
        return null;
    }

    public synchronized void interrupt() {
        this.isInterrupted = true;
        notifyWorkers();
    }

    public synchronized void notifyWorkers() {
        notifyAll();
    }

    public synchronized void remove(T t3) {
        this.assignedJobs.remove(t3);
        notifyWorkers();
    }

    public synchronized int size() {
        return this.queueItems.size();
    }
}
