package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E e3, N n3, boolean z3) {
        if (z3) {
            return;
        }
        addOutEdge(e3, n3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E e3, N n3) {
        Preconditions.checkState(this.incidentEdgeMap.put(e3, n3) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E e3) {
        N n3 = this.incidentEdgeMap.get(e3);
        Objects.requireNonNull(n3);
        return n3;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    @CheckForNull
    public N removeInEdge(E e3, boolean z3) {
        if (z3) {
            return null;
        }
        return removeOutEdge(e3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e3) {
        N remove = this.incidentEdgeMap.remove(e3);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return adjacentNodes();
    }
}
