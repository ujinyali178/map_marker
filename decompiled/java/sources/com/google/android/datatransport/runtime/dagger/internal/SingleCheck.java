package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: /root/release/classes.dex */
public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p3) {
        return ((p3 instanceof SingleCheck) || (p3 instanceof DoubleCheck)) ? p3 : new SingleCheck((Provider) Preconditions.checkNotNull(p3));
    }

    @Override // javax.inject.Provider
    public T get() {
        T t3 = (T) this.instance;
        if (t3 != UNINITIALIZED) {
            return t3;
        }
        Provider<T> provider = this.provider;
        if (provider == null) {
            return (T) this.instance;
        }
        T t4 = provider.get();
        this.instance = t4;
        this.provider = null;
        return t4;
    }
}
