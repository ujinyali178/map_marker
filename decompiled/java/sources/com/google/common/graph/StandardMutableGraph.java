package com.google.common.graph;

import com.google.common.graph.GraphConstants;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    StandardMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new StandardMutableValueGraph(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n3) {
        return this.backingValueGraph.addNode(n3);
    }

    @Override // com.google.common.graph.ForwardingGraph
    BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n3, N n4) {
        return this.backingValueGraph.putEdgeValue(n3, n4, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n3, N n4) {
        return this.backingValueGraph.removeEdge(n3, n4) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n3) {
        return this.backingValueGraph.removeNode(n3);
    }
}
