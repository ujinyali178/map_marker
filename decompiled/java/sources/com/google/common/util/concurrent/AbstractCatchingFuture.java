package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {

    @CheckForNull
    Class<X> exceptionType;

    @CheckForNull
    F fallback;

    @CheckForNull
    ListenableFuture<? extends V> inputFuture;

    private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x3) {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x3);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) {
            return doFallback((AsyncFunction<? super AsyncFunction<? super X, ? extends V>, ? extends V>) obj, (AsyncFunction<? super X, ? extends V>) th);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @ParametricNullness
        V doFallback(Function<? super X, ? extends V> function, X x3) {
            return function.apply(x3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @ParametricNullness
        /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) {
            return doFallback((Function<? super Function<? super X, ? extends V>, ? extends V>) obj, (Function<? super X, ? extends V>) th);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void setResult(@ParametricNullness V v3) {
            set(v3);
        }
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f3) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = (F) Preconditions.checkNotNull(f3);
    }

    static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @ParametricNullness
    abstract T doFallback(F f3, X x3);

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f3 = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls == null || f3 == null) {
            if (pendingToString == null) {
                return null;
            }
            return str + pendingToString;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f3 + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Type inference failed for: r3v4, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r8 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r8.inputFuture
            java.lang.Class<X extends java.lang.Throwable> r1 = r8.exceptionType
            F r2 = r8.fallback
            r3 = 1
            r4 = 0
            if (r0 != 0) goto Ld
            r5 = 1
            r5 = 1
            goto Le
        Ld:
            r5 = 0
        Le:
            if (r1 != 0) goto L12
            r6 = 1
            goto L13
        L12:
            r6 = 0
        L13:
            r5 = r5 | r6
            if (r2 != 0) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            r3 = r3 | r5
            if (r3 != 0) goto La5
            boolean r3 = r8.isCancelled()
            if (r3 == 0) goto L23
            goto La5
        L23:
            r3 = 0
            r8.inputFuture = r3
            boolean r4 = r0 instanceof com.google.common.util.concurrent.internal.InternalFutureFailureAccess     // Catch: java.lang.Error -> L3a java.lang.RuntimeException -> L3c java.util.concurrent.ExecutionException -> L3f
            if (r4 == 0) goto L32
            r4 = r0
            com.google.common.util.concurrent.internal.InternalFutureFailureAccess r4 = (com.google.common.util.concurrent.internal.InternalFutureFailureAccess) r4     // Catch: java.lang.Error -> L3a java.lang.RuntimeException -> L3c java.util.concurrent.ExecutionException -> L3f
            java.lang.Throwable r4 = com.google.common.util.concurrent.internal.InternalFutures.tryInternalFastPathGetFailure(r4)     // Catch: java.lang.Error -> L3a java.lang.RuntimeException -> L3c java.util.concurrent.ExecutionException -> L3f
            goto L33
        L32:
            r4 = r3
        L33:
            if (r4 != 0) goto L3d
            java.lang.Object r5 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch: java.lang.Error -> L3a java.lang.RuntimeException -> L3c java.util.concurrent.ExecutionException -> L3f
            goto L73
        L3a:
            r4 = move-exception
            goto L3d
        L3c:
            r4 = move-exception
        L3d:
            r5 = r3
            goto L73
        L3f:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L71
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Future type "
            r6.append(r7)
            java.lang.Class r7 = r0.getClass()
            r6.append(r7)
            java.lang.String r7 = " threw "
            r6.append(r7)
            java.lang.Class r4 = r4.getClass()
            r6.append(r4)
            java.lang.String r4 = " without a cause"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
        L71:
            r4 = r5
            goto L3d
        L73:
            if (r4 != 0) goto L7d
            java.lang.Object r0 = com.google.common.util.concurrent.NullnessCasts.uncheckedCastNullableTToT(r5)
            r8.set(r0)
            return
        L7d:
            boolean r1 = com.google.common.util.concurrent.Platform.isInstanceOfThrowableClass(r4, r1)
            if (r1 != 0) goto L87
            r8.setFuture(r0)
            return
        L87:
            java.lang.Object r0 = r8.doFallback(r2, r4)     // Catch: java.lang.Throwable -> L93
            r8.exceptionType = r3
            r8.fallback = r3
            r8.setResult(r0)
            return
        L93:
            r0 = move-exception
            com.google.common.util.concurrent.Platform.restoreInterruptIfIsInterruptedException(r0)     // Catch: java.lang.Throwable -> L9f
            r8.setException(r0)     // Catch: java.lang.Throwable -> L9f
            r8.exceptionType = r3
            r8.fallback = r3
            return
        L9f:
            r0 = move-exception
            r8.exceptionType = r3
            r8.fallback = r3
            throw r0
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    abstract void setResult(@ParametricNullness T t3);
}
