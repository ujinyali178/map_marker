package org.apache.commons.io;

/* loaded from: /root/release/classes2.dex */
class ThreadMonitor implements Runnable {
    private final Thread thread;
    private final long timeout;

    private ThreadMonitor(Thread thread, long j3) {
        this.thread = thread;
        this.timeout = j3;
    }

    private static void sleep(long j3) {
        long currentTimeMillis = System.currentTimeMillis() + j3;
        do {
            Thread.sleep(j3);
            j3 = currentTimeMillis - System.currentTimeMillis();
        } while (j3 > 0);
    }

    public static Thread start(long j3) {
        return start(Thread.currentThread(), j3);
    }

    public static Thread start(Thread thread, long j3) {
        if (j3 <= 0) {
            return null;
        }
        Thread thread2 = new Thread(new ThreadMonitor(thread, j3), ThreadMonitor.class.getSimpleName());
        thread2.setDaemon(true);
        thread2.start();
        return thread2;
    }

    public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            sleep(this.timeout);
            this.thread.interrupt();
        } catch (InterruptedException unused) {
        }
    }
}
