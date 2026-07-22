package org.mapsforge.map.util;

/* loaded from: /root/release/classes2.dex */
public abstract class PausableThread extends Thread {
    private boolean pausing;
    private boolean shouldPause;
    private boolean shouldStop;
    protected boolean waitForWork;

    /* JADX INFO: Access modifiers changed from: protected */
    public enum ThreadPriority {
        ABOVE_NORMAL(7),
        BELOW_NORMAL(3),
        HIGHEST(10),
        LOWEST(1),
        NORMAL(5);

        final int priority;

        ThreadPriority(int i3) {
            if (i3 >= 1 && i3 <= 10) {
                this.priority = i3;
                return;
            }
            throw new IllegalArgumentException("invalid priority: " + i3);
        }
    }

    protected void afterRun() {
    }

    public final void awaitPausing() {
        synchronized (this) {
            while (!isInterrupted() && !isPausing()) {
                try {
                    wait(100L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    protected abstract void doWork();

    public final synchronized void finish() {
        this.shouldStop = true;
        interrupt();
    }

    protected abstract ThreadPriority getThreadPriority();

    protected abstract boolean hasWork();

    @Override // java.lang.Thread
    public void interrupt() {
        synchronized (this) {
            super.interrupt();
        }
    }

    public final synchronized boolean isPausing() {
        return this.pausing;
    }

    public final synchronized void pause() {
        if (!this.shouldPause) {
            this.shouldPause = true;
            notify();
        }
    }

    public final synchronized void proceed() {
        if (this.shouldPause) {
            this.shouldPause = false;
            this.pausing = false;
            notify();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName(getClass().getSimpleName());
        setPriority(getThreadPriority().priority);
        while (true) {
            if ((this.shouldStop || isInterrupted()) && (!this.waitForWork || !hasWork())) {
                break;
            }
            synchronized (this) {
                while (!this.shouldStop && !isInterrupted() && (this.shouldPause || !hasWork())) {
                    try {
                        if (this.shouldPause) {
                            this.pausing = true;
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        interrupt();
                    }
                }
            }
            if ((this.shouldStop || isInterrupted()) && (!this.waitForWork || !hasWork())) {
                break;
            }
            try {
                doWork();
            } catch (InterruptedException unused2) {
                interrupt();
            }
        }
        afterRun();
    }
}
