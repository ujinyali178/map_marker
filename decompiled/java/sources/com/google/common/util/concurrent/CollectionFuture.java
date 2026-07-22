package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    @CheckForNull
    private List<Present<V>> values;

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z3) {
            super(immutableCollection, z3);
            init();
        }

        @Override // com.google.common.util.concurrent.CollectionFuture
        public List<V> combine(List<Present<V>> list) {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            Iterator<Present<V>> it = list.iterator();
            while (it.hasNext()) {
                Present<V> next = it.next();
                newArrayListWithCapacity.add(next != null ? next.value : null);
            }
            return Collections.unmodifiableList(newArrayListWithCapacity);
        }
    }

    private static final class Present<V> {

        @ParametricNullness
        final V value;

        Present(@ParametricNullness V v3) {
            this.value = v3;
        }
    }

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z3) {
        super(immutableCollection, z3, true);
        List<Present<V>> emptyList = immutableCollection.isEmpty() ? Collections.emptyList() : Lists.newArrayListWithCapacity(immutableCollection.size());
        for (int i3 = 0; i3 < immutableCollection.size(); i3++) {
            emptyList.add(null);
        }
        this.values = emptyList;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void collectOneValue(int i3, @ParametricNullness V v3) {
        List<Present<V>> list = this.values;
        if (list != null) {
            list.set(i3, new Present<>(v3));
        }
    }

    abstract C combine(List<Present<V>> list);

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void handleAllCompleted() {
        List<Present<V>> list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }
}
