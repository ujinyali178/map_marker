package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /root/release/classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder zaa;
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this(listenerHolder, null, false, 0);
    }

    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z3) {
        this(listenerHolder, featureArr, z3, 0);
    }

    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z3, int i3) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z3;
        this.zad = i3;
    }

    public void clearListener() {
        this.zaa.clear();
    }

    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    protected abstract void registerListener(A a4, TaskCompletionSource<Void> taskCompletionSource);

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }
}
