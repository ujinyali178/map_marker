package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new AnonymousClass1();

    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractService {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$doStart$0() {
            return AbstractExecutionThreadService.this.serviceName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doStart$1() {
            try {
                AbstractExecutionThreadService.this.startUp();
                notifyStarted();
                if (isRunning()) {
                    try {
                        AbstractExecutionThreadService.this.run();
                    } catch (Throwable th) {
                        Platform.restoreInterruptIfIsInterruptedException(th);
                        try {
                            AbstractExecutionThreadService.this.shutDown();
                        } catch (Exception e3) {
                            Platform.restoreInterruptIfIsInterruptedException(e3);
                            AbstractExecutionThreadService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e3);
                        }
                        notifyFailed(th);
                        return;
                    }
                }
                AbstractExecutionThreadService.this.shutDown();
                notifyStopped();
            } catch (Throwable th2) {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                notifyFailed(th2);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), (Supplier<String>) new Supplier() { // from class: com.google.common.util.concurrent.b
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    String lambda$doStart$0;
                    lambda$doStart$0 = AbstractExecutionThreadService.AnonymousClass1.this.lambda$doStart$0();
                    return lambda$doStart$0;
                }
            }).execute(new Runnable() { // from class: com.google.common.util.concurrent.c
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractExecutionThreadService.AnonymousClass1.this.lambda$doStart$1();
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    }

    protected AbstractExecutionThreadService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executor$0(Runnable runnable) {
        MoreExecutors.newThread(serviceName(), runnable).start();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j3, TimeUnit timeUnit) {
        this.delegate.awaitRunning(j3, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j3, TimeUnit timeUnit) {
        this.delegate.awaitTerminated(j3, timeUnit);
    }

    protected Executor executor() {
        return new Executor() { // from class: com.google.common.util.concurrent.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                AbstractExecutionThreadService.this.lambda$executor$0(runnable);
            }
        };
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    protected abstract void run();

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    protected void shutDown() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    protected void startUp() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    protected void triggerShutdown() {
    }
}
