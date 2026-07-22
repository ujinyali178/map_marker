package com.google.common.graph;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface MutableNetwork<N, E> extends Network<N, E> {
    boolean addEdge(EndpointPair<N> endpointPair, E e3);

    boolean addEdge(N n3, N n4, E e3);

    boolean addNode(N n3);

    boolean removeEdge(E e3);

    boolean removeNode(N n3);
}
