package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
interface NetworkConnections<N, E> {
    void addInEdge(E e3, N n3, boolean z3);

    void addOutEdge(E e3, N n3);

    N adjacentNode(E e3);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N n3);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    @CheckForNull
    N removeInEdge(E e3, boolean z3);

    N removeOutEdge(E e3);

    Set<N> successors();
}
