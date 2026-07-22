package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> inEdgeMap;
    final Map<E, N> outEdgeMap;
    private int selfLoopCount;

    AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i3) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i3);
        Preconditions.checkState(i3 <= map.size() && i3 <= map2.size());
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E e3, N n3, boolean z3) {
        Preconditions.checkNotNull(e3);
        Preconditions.checkNotNull(n3);
        if (z3) {
            int i3 = this.selfLoopCount + 1;
            this.selfLoopCount = i3;
            Graphs.checkPositive(i3);
        }
        Preconditions.checkState(this.inEdgeMap.put(e3, n3) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E e3, N n3) {
        Preconditions.checkNotNull(e3);
        Preconditions.checkNotNull(n3);
        Preconditions.checkState(this.outEdgeMap.put(e3, n3) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E e3) {
        N n3 = this.outEdgeMap.get(e3);
        Objects.requireNonNull(n3);
        return n3;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return new AbstractSet<E>() { // from class: com.google.common.graph.AbstractDirectedNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<E> iterator() {
                return Iterators.unmodifiableIterator((AbstractDirectedNetworkConnections.this.selfLoopCount == 0 ? Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet()) : Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet())).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }
        };
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E e3, boolean z3) {
        if (z3) {
            int i3 = this.selfLoopCount - 1;
            this.selfLoopCount = i3;
            Graphs.checkNonNegative(i3);
        }
        N remove = this.inEdgeMap.remove(e3);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e3) {
        N remove = this.outEdgeMap.remove(e3);
        Objects.requireNonNull(remove);
        return remove;
    }
}
