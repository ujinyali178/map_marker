package com.google.common.graph;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    boolean addNode(N n3);

    @CheckForNull
    V putEdgeValue(EndpointPair<N> endpointPair, V v3);

    @CheckForNull
    V putEdgeValue(N n3, N n4, V v3);

    @CheckForNull
    V removeEdge(EndpointPair<N> endpointPair);

    @CheckForNull
    V removeEdge(N n3, N n4);

    boolean removeNode(N n3);
}
