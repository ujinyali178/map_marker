package org.mapsforge.map.layer.hills;

import com.google.android.gms.common.api.internal.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /root/release/classes2.dex */
public abstract class LatchedLazyFuture<X> implements Future<X> {
    private volatile X result;
    private volatile Thread thread;
    private static final ExecutionException STARTED = new DummyExecutionException("started");
    private static final ExecutionException CANCELLED = new DummyExecutionException("cancelled");
    private static final ExecutionException DONE = new DummyExecutionException("done");
    private final AtomicReference<ExecutionException> state = new AtomicReference<>(null);
    private final CountDownLatch latch = new CountDownLatch(1);

    private static class DummyExecutionException extends ExecutionException {
        DummyExecutionException(String str) {
            super(str, null);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return null;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "[state marker " + getMessage() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public void internalCalc() {
        this.thread = Thread.currentThread();
        ?? r02 = 0;
        r02 = 0;
        try {
            try {
                this.result = calculate();
                a.a(this.state, STARTED, DONE);
            } catch (RuntimeException e3) {
                a.a(this.state, STARTED, new ExecutionException(e3));
            } catch (ExecutionException e4) {
                a.a(this.state, STARTED, e4);
            }
        } finally {
            this.thread = r02;
            this.latch.countDown();
        }
    }

    private void throwIfException() {
        ExecutionException executionException = this.state.get();
        if (executionException != null && !(executionException instanceof DummyExecutionException)) {
            throw executionException;
        }
    }

    protected abstract X calculate();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z3) {
        Thread thread;
        ExecutionException executionException = this.state.get();
        ExecutionException executionException2 = CANCELLED;
        if (executionException == executionException2) {
            return true;
        }
        if (this.state.get() == DONE) {
            return false;
        }
        if (!z3 || (thread = this.thread) == null || !a.a(this.state, STARTED, executionException2)) {
            return a.a(this.state, null, executionException2);
        }
        thread.interrupt();
        return true;
    }

    @Override // java.util.concurrent.Future
    public X get() {
        if (a.a(this.state, null, STARTED)) {
            internalCalc();
        } else {
            this.latch.await();
        }
        throwIfException();
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public X get(long j3, TimeUnit timeUnit) {
        if (a.a(this.state, null, STARTED)) {
            internalCalc();
        } else {
            this.latch.await(j3, timeUnit);
        }
        throwIfException();
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.state.get() == CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        ExecutionException executionException = this.state.get();
        return (executionException == null || executionException == STARTED) ? false : true;
    }

    public LatchedLazyFuture<X> withRunningThread() {
        if (this.state.get() != DONE && a.a(this.state, null, STARTED)) {
            new Thread(getClass().getName() + ".withRunningThread") { // from class: org.mapsforge.map.layer.hills.LatchedLazyFuture.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        LatchedLazyFuture.this.internalCalc();
                    } catch (InterruptedException | ExecutionException e3) {
                        e3.printStackTrace();
                    }
                }
            }.start();
        }
        return this;
    }
}
