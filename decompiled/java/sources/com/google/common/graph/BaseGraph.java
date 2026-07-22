package com.google.common.graph;

import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n3);

    boolean allowsSelfLoops();

    int degree(N n3);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n3, N n4);

    int inDegree(N n3);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N n3);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n3);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n3);

    @Override // com.google.common.graph.SuccessorsFunction
    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n3);
}
