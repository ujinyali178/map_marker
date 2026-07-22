package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@DoNotMock("Create an AbstractIdleService")
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Service {

    public static abstract class Listener {
        public void failed(State state, Throwable th) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(State state) {
        }

        public void terminated(State state) {
        }
    }

    public enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    void addListener(Listener listener, Executor executor);

    void awaitRunning();

    void awaitRunning(long j3, TimeUnit timeUnit);

    void awaitTerminated();

    void awaitTerminated(long j3, TimeUnit timeUnit);

    Throwable failureCause();

    boolean isRunning();

    Service startAsync();

    State state();

    Service stopAsync();
}
