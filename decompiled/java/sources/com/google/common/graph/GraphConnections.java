package com.google.common.graph;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
interface GraphConnections<N, V> {
    void addPredecessor(N n3, V v3);

    @CheckForNull
    V addSuccessor(N n3, V v3);

    Set<N> adjacentNodes();

    Iterator<EndpointPair<N>> incidentEdgeIterator(N n3);

    Set<N> predecessors();

    void removePredecessor(N n3);

    @CheckForNull
    V removeSuccessor(N n3);

    Set<N> successors();

    @CheckForNull
    V value(N n3);
}
