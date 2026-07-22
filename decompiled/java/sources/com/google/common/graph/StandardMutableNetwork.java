package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    StandardMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    private NetworkConnections<N, E> addNodeInternal(N n3) {
        NetworkConnections<N, E> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n3, newConnections) == null);
        return newConnections;
    }

    private NetworkConnections<N, E> newConnections() {
        return isDirected() ? allowsParallelEdges() ? DirectedMultiNetworkConnections.of() : DirectedNetworkConnections.of() : allowsParallelEdges() ? UndirectedMultiNetworkConnections.of() : UndirectedNetworkConnections.of();
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(EndpointPair<N> endpointPair, E e3) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e3);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(N n3, N n4, E e3) {
        Preconditions.checkNotNull(n3, "nodeU");
        Preconditions.checkNotNull(n4, "nodeV");
        Preconditions.checkNotNull(e3, "edge");
        if (containsEdge(e3)) {
            EndpointPair<N> incidentNodes = incidentNodes(e3);
            EndpointPair of = EndpointPair.of(this, n3, n4);
            Preconditions.checkArgument(incidentNodes.equals(of), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e3, incidentNodes, of);
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n3);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument(networkConnections == null || !networkConnections.successors().contains(n4), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n3, n4);
        }
        boolean equals = n3.equals(n4);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n3);
        }
        if (networkConnections == null) {
            networkConnections = addNodeInternal(n3);
        }
        networkConnections.addOutEdge(e3, n4);
        NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(n4);
        if (networkConnections2 == null) {
            networkConnections2 = addNodeInternal(n4);
        }
        networkConnections2.addInEdge(e3, n3, equals);
        this.edgeToReferenceNode.put(e3, n3);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addNode(N n3) {
        Preconditions.checkNotNull(n3, "node");
        if (containsNode(n3)) {
            return false;
        }
        addNodeInternal(n3);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeEdge(E e3) {
        Preconditions.checkNotNull(e3, "edge");
        N n3 = this.edgeToReferenceNode.get(e3);
        boolean z3 = false;
        if (n3 == null) {
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n3);
        Objects.requireNonNull(networkConnections);
        NetworkConnections<N, E> networkConnections2 = networkConnections;
        N adjacentNode = networkConnections2.adjacentNode(e3);
        NetworkConnections<N, E> networkConnections3 = this.nodeConnections.get(adjacentNode);
        Objects.requireNonNull(networkConnections3);
        NetworkConnections<N, E> networkConnections4 = networkConnections3;
        networkConnections2.removeOutEdge(e3);
        if (allowsSelfLoops() && n3.equals(adjacentNode)) {
            z3 = true;
        }
        networkConnections4.removeInEdge(e3, z3);
        this.edgeToReferenceNode.remove(e3);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeNode(N n3) {
        Preconditions.checkNotNull(n3, "node");
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n3);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator<E> it = ImmutableList.copyOf((Collection) networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n3);
        return true;
    }
}
