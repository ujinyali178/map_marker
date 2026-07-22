package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* loaded from: /root/release/classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p3) {
        return p3 instanceof Lazy ? (Lazy) p3 : new DoubleCheck((Provider) Preconditions.checkNotNull(p3));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p3) {
        Preconditions.checkNotNull(p3);
        return p3 instanceof DoubleCheck ? p3 : new DoubleCheck(p3);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!((obj == UNINITIALIZED || (obj instanceof MemoizedSentinel)) ? false : true) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t3 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t3 == obj) {
            synchronized (this) {
                t3 = (T) this.instance;
                if (t3 == obj) {
                    t3 = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t3);
                    this.provider = null;
                }
            }
        }
        return t3;
    }
}
