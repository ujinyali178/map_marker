package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {
    private final ElementOrder<N> incidentEdgeOrder;

    StandardMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.incidentEdgeOrder = (ElementOrder<N>) abstractGraphBuilder.incidentEdgeOrder.cast();
    }

    private GraphConnections<N, V> addNodeInternal(N n3) {
        GraphConnections<N, V> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n3, newConnections) == null);
        return newConnections;
    }

    private GraphConnections<N, V> newConnections() {
        return isDirected() ? DirectedGraphConnections.of(this.incidentEdgeOrder) : UndirectedGraphConnections.of(this.incidentEdgeOrder);
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean addNode(N n3) {
        Preconditions.checkNotNull(n3, "node");
        if (containsNode(n3)) {
            return false;
        }
        addNodeInternal(n3);
        return true;
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return this.incidentEdgeOrder;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V putEdgeValue(EndpointPair<N> endpointPair, V v3) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v3);
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V putEdgeValue(N n3, N n4, V v3) {
        Preconditions.checkNotNull(n3, "nodeU");
        Preconditions.checkNotNull(n4, "nodeV");
        Preconditions.checkNotNull(v3, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n3.equals(n4), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n3);
        }
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n3);
        if (graphConnections == null) {
            graphConnections = addNodeInternal(n3);
        }
        V addSuccessor = graphConnections.addSuccessor(n4, v3);
        GraphConnections<N, V> graphConnections2 = this.nodeConnections.get(n4);
        if (graphConnections2 == null) {
            graphConnections2 = addNodeInternal(n4);
        }
        graphConnections2.addPredecessor(n3, v3);
        if (addSuccessor == null) {
            long j3 = this.edgeCount + 1;
            this.edgeCount = j3;
            Graphs.checkPositive(j3);
        }
        return addSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CheckForNull
    public V removeEdge(N n3, N n4) {
        Preconditions.checkNotNull(n3, "nodeU");
        Preconditions.checkNotNull(n4, "nodeV");
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n3);
        GraphConnections<N, V> graphConnections2 = this.nodeConnections.get(n4);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n4);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n3);
            long j3 = this.edgeCount - 1;
            this.edgeCount = j3;
            Graphs.checkNonNegative(j3);
        }
        return removeSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean removeNode(N n3) {
        Preconditions.checkNotNull(n3, "node");
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n3);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n3) != null) {
            graphConnections.removePredecessor(n3);
            this.edgeCount--;
        }
        Iterator<N> it = graphConnections.successors().iterator();
        while (it.hasNext()) {
            GraphConnections<N, V> withoutCaching = this.nodeConnections.getWithoutCaching(it.next());
            Objects.requireNonNull(withoutCaching);
            withoutCaching.removePredecessor(n3);
            this.edgeCount--;
        }
        if (isDirected()) {
            Iterator<N> it2 = graphConnections.predecessors().iterator();
            while (it2.hasNext()) {
                GraphConnections<N, V> withoutCaching2 = this.nodeConnections.getWithoutCaching(it2.next());
                Objects.requireNonNull(withoutCaching2);
                Preconditions.checkState(withoutCaching2.removeSuccessor(n3) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n3);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }
}
