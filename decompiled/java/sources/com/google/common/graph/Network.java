package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

@DoNotMock("Use NetworkBuilder to create a real instance")
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e3);

    Set<N> adjacentNodes(N n3);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n3);

    @CheckForNull
    E edgeConnectingOrNull(EndpointPair<N> endpointPair);

    @CheckForNull
    E edgeConnectingOrNull(N n3, N n4);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> endpointPair);

    Set<E> edgesConnecting(N n3, N n4);

    boolean equals(@CheckForNull Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n3, N n4);

    int hashCode();

    int inDegree(N n3);

    Set<E> inEdges(N n3);

    Set<E> incidentEdges(N n3);

    EndpointPair<N> incidentNodes(E e3);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n3);

    Set<E> outEdges(N n3);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n3);

    @Override // com.google.common.graph.SuccessorsFunction
    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n3);
}
