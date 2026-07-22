package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(networkBuilder.expectedNodeCount.or((Optional<Integer>) 10).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or((Optional<Integer>) 20).intValue()));
    }

    StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) networkBuilder.nodeOrder.cast();
        this.edgeOrder = (ElementOrder<E>) networkBuilder.edgeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeToReferenceNode = new MapIteratorCache<>(map2);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n3) {
        return checkedConnections(n3).adjacentNodes();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    final NetworkConnections<N, E> checkedConnections(N n3) {
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n3);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n3);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", n3));
    }

    final N checkedReferenceNode(E e3) {
        N n3 = this.edgeToReferenceNode.get(e3);
        if (n3 != null) {
            return n3;
        }
        Preconditions.checkNotNull(e3);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", e3));
    }

    final boolean containsEdge(E e3) {
        return this.edgeToReferenceNode.containsKey(e3);
    }

    final boolean containsNode(N n3) {
        return this.nodeConnections.containsKey(n3);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n3, N n4) {
        NetworkConnections<N, E> checkedConnections = checkedConnections(n3);
        if (!this.allowsSelfLoops && n3 == n4) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n4), "Node %s is not an element of this graph.", n4);
        return checkedConnections.edgesConnecting(n4);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n3) {
        return checkedConnections(n3).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n3) {
        return checkedConnections(n3).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e3) {
        N checkedReferenceNode = checkedReferenceNode(e3);
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(checkedReferenceNode);
        Objects.requireNonNull(networkConnections);
        return EndpointPair.of(this, checkedReferenceNode, networkConnections.adjacentNode(e3));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n3) {
        return checkedConnections(n3).outEdges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((StandardNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n3) {
        return checkedConnections(n3).predecessors();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((StandardNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n3) {
        return checkedConnections(n3).successors();
    }
}
