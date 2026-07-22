package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    DirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i3) {
        super(map, map2, i3);
    }

    static <N, E> DirectedNetworkConnections<N, E> of() {
        return new DirectedNetworkConnections<>(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    static <N, E> DirectedNetworkConnections<N, E> ofImmutable(Map<E, N> map, Map<E, N> map2, int i3) {
        return new DirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) map), ImmutableBiMap.copyOf((Map) map2), i3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(N n3) {
        return new EdgesConnecting(((BiMap) this.outEdgeMap).inverse(), n3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return Collections.unmodifiableSet(((BiMap) this.inEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return Collections.unmodifiableSet(((BiMap) this.outEdgeMap).values());
    }
}
