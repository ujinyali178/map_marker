package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.graph.Graphs;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Graphs {

    private enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class TransposedGraph<N> extends ForwardingGraph<N> {
        private final Graph<N> graph;

        /* renamed from: com.google.common.graph.Graphs$TransposedGraph$1, reason: invalid class name */
        class AnonymousClass1 extends IncidentEdgeSet<N> {
            AnonymousClass1(BaseGraph baseGraph, Object obj) {
                super(baseGraph, obj);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$0(EndpointPair endpointPair) {
                return EndpointPair.of((Graph<?>) TransposedGraph.this.delegate(), endpointPair.nodeV(), endpointPair.nodeU());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(TransposedGraph.this.delegate().incidentEdges(this.node).iterator(), new Function() { // from class: com.google.common.graph.l
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        EndpointPair lambda$iterator$0;
                        lambda$iterator$0 = Graphs.TransposedGraph.AnonymousClass1.this.lambda$iterator$0((EndpointPair) obj);
                        return lambda$iterator$0;
                    }
                });
            }
        }

        TransposedGraph(Graph<N> graph) {
            this.graph = graph;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.graph.ForwardingGraph
        public Graph<N> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n3, N n4) {
            return delegate().hasEdgeConnecting(n4, n3);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n3) {
            return delegate().outDegree(n3);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> incidentEdges(N n3) {
            return new AnonymousClass1(this, n3);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n3) {
            return delegate().inDegree(n3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedGraph<N>) obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n3) {
            return delegate().successors((Graph<N>) n3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedGraph<N>) obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n3) {
            return delegate().predecessors((Graph<N>) n3);
        }
    }

    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        private final Network<N, E> network;

        TransposedNetwork(Network<N, E> network) {
            this.network = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        Network<N, E> delegate() {
            return this.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E edgeConnectingOrNull(N n3, N n4) {
            return delegate().edgeConnectingOrNull(n4, n3);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
            return delegate().edgesConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N n3, N n4) {
            return delegate().edgesConnecting(n4, n3);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N n3, N n4) {
            return delegate().hasEdgeConnecting(n4, n3);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N n3) {
            return delegate().outDegree(n3);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N n3) {
            return delegate().outEdges(n3);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E e3) {
            EndpointPair<N> incidentNodes = delegate().incidentNodes(e3);
            return EndpointPair.of((Network<?, ?>) this.network, (Object) incidentNodes.nodeV(), (Object) incidentNodes.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N n3) {
            return delegate().inDegree(n3);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N n3) {
            return delegate().inEdges(n3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedNetwork<N, E>) obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n3) {
            return delegate().successors((Network<N, E>) n3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedNetwork<N, E>) obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n3) {
            return delegate().predecessors((Network<N, E>) n3);
        }
    }

    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        private final ValueGraph<N, V> graph;

        TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.graph = valueGraph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        ValueGraph<N, V> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v3) {
            return delegate().edgeValueOrDefault(Graphs.transpose(endpointPair), v3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V edgeValueOrDefault(N n3, N n4, @CheckForNull V v3) {
            return delegate().edgeValueOrDefault(n4, n3, v3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n3, N n4) {
            return delegate().hasEdgeConnecting(n4, n3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n3) {
            return delegate().outDegree(n3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n3) {
            return delegate().inDegree(n3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n3) {
            return delegate().successors((ValueGraph<N, V>) n3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n3) {
            return delegate().predecessors((ValueGraph<N, V>) n3);
        }
    }

    private Graphs() {
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object obj, @CheckForNull Object obj2) {
        return graph.isDirected() || !Objects.equal(obj2, obj);
    }

    static int checkNonNegative(int i3) {
        Preconditions.checkArgument(i3 >= 0, "Not true that %s is non-negative.", i3);
        return i3;
    }

    static long checkNonNegative(long j3) {
        Preconditions.checkArgument(j3 >= 0, "Not true that %s is non-negative.", j3);
        return j3;
    }

    static int checkPositive(int i3) {
        Preconditions.checkArgument(i3 > 0, "Not true that %s is positive.", i3);
        return i3;
    }

    static long checkPositive(long j3) {
        Preconditions.checkArgument(j3 > 0, "Not true that %s is positive.", j3);
        return j3;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            mutableGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        Iterator<N> it = network.nodes().iterator();
        while (it.hasNext()) {
            mutableNetwork.addNode(it.next());
        }
        for (E e3 : network.edges()) {
            EndpointPair<N> incidentNodes = network.incidentNodes(e3);
            mutableNetwork.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), e3);
        }
        return mutableNetwork;
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        Iterator<N> it = valueGraph.nodes().iterator();
        while (it.hasNext()) {
            mutableValueGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            N nodeU = endpointPair.nodeU();
            N nodeV = endpointPair.nodeV();
            V edgeValueOrDefault = valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            java.util.Objects.requireNonNull(edgeValueOrDefault);
            mutableValueGraph.putEdgeValue(nodeU, nodeV, edgeValueOrDefault);
        }
        return mutableValueGraph;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            if (subgraphHasCycle(graph, newHashMapWithExpectedSize, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        StandardMutableGraph standardMutableGraph = (MutableGraph<N>) (iterable instanceof Collection ? GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()) : GraphBuilder.from(graph)).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            standardMutableGraph.addNode(it.next());
        }
        for (Object obj : standardMutableGraph.nodes()) {
            for (Object obj2 : graph.successors((Graph<N>) obj)) {
                if (standardMutableGraph.nodes().contains(obj2)) {
                    standardMutableGraph.putEdge(obj, obj2);
                }
            }
        }
        return standardMutableGraph;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        StandardMutableNetwork standardMutableNetwork = (MutableNetwork<N, E>) (iterable instanceof Collection ? NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()) : NetworkBuilder.from(network)).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            standardMutableNetwork.addNode(it.next());
        }
        for (E e3 : standardMutableNetwork.nodes()) {
            for (E e4 : network.outEdges(e3)) {
                N adjacentNode = network.incidentNodes(e4).adjacentNode(e3);
                if (standardMutableNetwork.nodes().contains(adjacentNode)) {
                    standardMutableNetwork.addEdge(e3, adjacentNode, e4);
                }
            }
        }
        return standardMutableNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        StandardMutableValueGraph standardMutableValueGraph = (MutableValueGraph<N, V>) (iterable instanceof Collection ? ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()) : ValueGraphBuilder.from(valueGraph)).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            standardMutableValueGraph.addNode(it.next());
        }
        for (Object obj : standardMutableValueGraph.nodes()) {
            for (Object obj2 : valueGraph.successors((ValueGraph<N, V>) obj)) {
                if (standardMutableValueGraph.nodes().contains(obj2)) {
                    Object edgeValueOrDefault = valueGraph.edgeValueOrDefault(obj, obj2, null);
                    java.util.Objects.requireNonNull(edgeValueOrDefault);
                    standardMutableValueGraph.putEdgeValue(obj, obj2, edgeValueOrDefault);
                }
            }
        }
        return standardMutableValueGraph;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n3) {
        Preconditions.checkArgument(graph.nodes().contains(n3), "Node %s is not an element of this graph.", n3);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst((Traverser) n3));
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, NodeVisitState> map, N n3, @CheckForNull N n4) {
        NodeVisitState nodeVisitState = map.get(n3);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n3, nodeVisitState2);
        for (N n5 : graph.successors((Graph<N>) n3)) {
            if (canTraverseWithoutReusingEdge(graph, n5, n4) && subgraphHasCycle(graph, map, n5, n3)) {
                return true;
            }
        }
        map.put(n3, NodeVisitState.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        StandardMutableGraph build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n3 : graph.nodes()) {
                Iterator it = reachableNodes(graph, n3).iterator();
                while (it.hasNext()) {
                    build.putEdge(n3, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n4 : graph.nodes()) {
                if (!hashSet.contains(n4)) {
                    Set reachableNodes = reachableNodes(graph, n4);
                    hashSet.addAll(reachableNodes);
                    int i3 = 1;
                    for (Object obj : reachableNodes) {
                        int i4 = i3 + 1;
                        Iterator it2 = Iterables.limit(reachableNodes, i3).iterator();
                        while (it2.hasNext()) {
                            build.putEdge(obj, it2.next());
                        }
                        i3 = i4;
                    }
                }
            }
        }
        return build;
    }

    static <N> EndpointPair<N> transpose(EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        return !graph.isDirected() ? graph : graph instanceof TransposedGraph ? ((TransposedGraph) graph).graph : new TransposedGraph(graph);
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        return !network.isDirected() ? network : network instanceof TransposedNetwork ? ((TransposedNetwork) network).network : new TransposedNetwork(network);
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        return !valueGraph.isDirected() ? valueGraph : valueGraph instanceof TransposedValueGraph ? ((TransposedValueGraph) valueGraph).graph : new TransposedValueGraph(valueGraph);
    }
}
