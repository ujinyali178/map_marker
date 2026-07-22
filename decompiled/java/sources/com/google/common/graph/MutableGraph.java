package com.google.common.graph;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface MutableGraph<N> extends Graph<N> {
    boolean addNode(N n3);

    boolean putEdge(EndpointPair<N> endpointPair);

    boolean putEdge(N n3, N n4);

    boolean removeEdge(EndpointPair<N> endpointPair);

    boolean removeEdge(N n3, N n4);

    boolean removeNode(N n3);
}
