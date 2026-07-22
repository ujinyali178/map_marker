package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class CacheLoader<K, V> {

    /* renamed from: com.google.common.cache.CacheLoader$1, reason: invalid class name */
    class AnonymousClass1 extends CacheLoader<K, V> {
        final /* synthetic */ Executor val$executor;

        AnonymousClass1(Executor executor) {
            this.val$executor = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$reload$0(CacheLoader cacheLoader, Object obj, Object obj2) {
            return cacheLoader.reload(obj, obj2).get();
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k3) {
            return (V) CacheLoader.this.load(k3);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture<V> reload(final K k3, final V v3) {
            final CacheLoader cacheLoader = CacheLoader.this;
            ListenableFutureTask create = ListenableFutureTask.create(new Callable() { // from class: com.google.common.cache.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object lambda$reload$0;
                    lambda$reload$0 = CacheLoader.AnonymousClass1.lambda$reload$0(CacheLoader.this, k3, v3);
                    return lambda$reload$0;
                }
            });
            this.val$executor.execute(create);
            return create;
        }
    }

    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k3) {
            return (V) this.computingFunction.apply(Preconditions.checkNotNull(k3));
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.computingSupplier = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            Preconditions.checkNotNull(obj);
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    protected CacheLoader() {
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return cacheLoader.new AnonymousClass1(executor);
    }

    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader(function);
    }

    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new SupplierToCacheLoader(supplier);
    }

    public abstract V load(K k3);

    public Map<K, V> loadAll(Iterable<? extends K> iterable) {
        throw new UnsupportedLoadingOperationException();
    }

    public ListenableFuture<V> reload(K k3, V v3) {
        Preconditions.checkNotNull(k3);
        Preconditions.checkNotNull(v3);
        return Futures.immediateFuture(load(k3));
    }
}
