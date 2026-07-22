package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    /* renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1, reason: invalid class name */
    class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ Set val$interruptibleMethods;
        final /* synthetic */ Object val$target;
        final /* synthetic */ long val$timeoutDuration;
        final /* synthetic */ TimeUnit val$timeoutUnit;

        AnonymousClass1(Object obj, long j3, TimeUnit timeUnit, Set set) {
            this.val$target = obj;
            this.val$timeoutDuration = j3;
            this.val$timeoutUnit = timeUnit;
            this.val$interruptibleMethods = set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$invoke$0(Method method, Object obj, Object[] objArr) {
            try {
                return method.invoke(obj, objArr);
            } catch (InvocationTargetException e3) {
                throw SimpleTimeLimiter.throwCause(e3, false);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, final Method method, @CheckForNull final Object[] objArr) {
            final Object obj2 = this.val$target;
            return SimpleTimeLimiter.this.callWithTimeout(new Callable() { // from class: com.google.common.util.concurrent.z
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object lambda$invoke$0;
                    lambda$invoke$0 = SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(method, obj2, objArr);
                    return lambda$invoke$0;
                }
            }, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(method));
        }
    }

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit, boolean z3) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j3);
        Future<T> submit = this.executor.submit(callable);
        try {
            if (!z3) {
                return (T) Uninterruptibles.getUninterruptibly(submit, j3, timeUnit);
            }
            try {
                return submit.get(j3, timeUnit);
            } catch (InterruptedException e3) {
                submit.cancel(true);
                throw e3;
            }
        } catch (ExecutionException e4) {
            throw throwCause(e4, true);
        } catch (TimeoutException e5) {
            submit.cancel(true);
            throw new UncheckedTimeoutException(e5);
        }
    }

    private static void checkPositiveTimeout(long j3) {
        Preconditions.checkArgument(j3 > 0, "timeout must be positive: %s", j3);
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    private static boolean declaresInterruptedEx(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> cls) {
        HashSet newHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            if (declaresInterruptedEx(method)) {
                newHashSet.add(method);
            }
        }
        return newHashSet;
    }

    private static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception throwCause(Exception exc, boolean z3) {
        Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z3) {
            cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw exc;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw new ExecutionException(th);
        }
        throw new UncheckedExecutionException(th);
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable th) {
        if (!(th instanceof Error)) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j3);
        Future<T> submit = this.executor.submit(callable);
        try {
            return (T) Uninterruptibles.getUninterruptibly(submit, j3, timeUnit);
        } catch (ExecutionException e3) {
            wrapAndThrowExecutionExceptionOrError(e3.getCause());
            throw new AssertionError();
        } catch (TimeoutException e4) {
            submit.cancel(true);
            throw e4;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j3);
        Future<T> submit = this.executor.submit(callable);
        try {
            return submit.get(j3, timeUnit);
        } catch (InterruptedException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e4) {
            wrapAndThrowExecutionExceptionOrError(e4.getCause());
            throw new AssertionError();
        } catch (TimeoutException e5) {
            e = e5;
            submit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t3, Class<T> cls, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t3);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j3);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        return (T) newProxy(cls, new AnonymousClass1(t3, j3, timeUnit, findInterruptibleMethods(cls)));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j3);
        Future<?> submit = this.executor.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j3, timeUnit);
        } catch (ExecutionException e3) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e3.getCause());
            throw new AssertionError();
        } catch (TimeoutException e4) {
            submit.cancel(true);
            throw e4;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j3);
        Future<?> submit = this.executor.submit(runnable);
        try {
            submit.get(j3, timeUnit);
        } catch (InterruptedException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e4) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e4.getCause());
            throw new AssertionError();
        } catch (TimeoutException e5) {
            e = e5;
            submit.cancel(true);
            throw e;
        }
    }
}
