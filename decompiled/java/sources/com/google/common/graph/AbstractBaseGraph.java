package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    /* renamed from: com.google.common.graph.AbstractBaseGraph$2, reason: invalid class name */
    class AnonymousClass2 extends IncidentEdgeSet<N> {
        AnonymousClass2(AbstractBaseGraph abstractBaseGraph, BaseGraph baseGraph, Object obj) {
            super(baseGraph, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ EndpointPair lambda$iterator$0(Object obj) {
            return EndpointPair.ordered(obj, this.node);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ EndpointPair lambda$iterator$1(Object obj) {
            return EndpointPair.ordered(this.node, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ EndpointPair lambda$iterator$2(Object obj) {
            return EndpointPair.unordered(this.node, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<EndpointPair<N>> iterator() {
            return Iterators.unmodifiableIterator(this.graph.isDirected() ? Iterators.concat(Iterators.transform(this.graph.predecessors((BaseGraph<N>) this.node).iterator(), new Function() { // from class: com.google.common.graph.a
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair lambda$iterator$0;
                    lambda$iterator$0 = AbstractBaseGraph.AnonymousClass2.this.lambda$iterator$0(obj);
                    return lambda$iterator$0;
                }
            }), Iterators.transform(Sets.difference(this.graph.successors((BaseGraph<N>) this.node), ImmutableSet.of(this.node)).iterator(), new Function() { // from class: com.google.common.graph.b
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair lambda$iterator$1;
                    lambda$iterator$1 = AbstractBaseGraph.AnonymousClass2.this.lambda$iterator$1(obj);
                    return lambda$iterator$1;
                }
            })) : Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function() { // from class: com.google.common.graph.c
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair lambda$iterator$2;
                    lambda$iterator$2 = AbstractBaseGraph.AnonymousClass2.this.lambda$iterator$2(obj);
                    return lambda$iterator$2;
                }
            }));
        }
    }

    AbstractBaseGraph() {
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n3) {
        int i3;
        int size;
        if (isDirected()) {
            size = predecessors((AbstractBaseGraph<N>) n3).size();
            i3 = successors((AbstractBaseGraph<N>) n3).size();
        } else {
            Set<N> adjacentNodes = adjacentNodes(n3);
            i3 = (allowsSelfLoops() && adjacentNodes.contains(n3)) ? 1 : 0;
            size = adjacentNodes.size();
        }
        return IntMath.saturatedAdd(size, i3);
    }

    protected long edgeCount() {
        long j3 = 0;
        while (nodes().iterator().hasNext()) {
            j3 += degree(r0.next());
        }
        Preconditions.checkState((1 & j3) == 0);
        return j3 >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors((AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        return nodes().contains(nodeU) && successors((AbstractBaseGraph<N>) nodeU).contains(endpointPair.nodeV());
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n3, N n4) {
        Preconditions.checkNotNull(n3);
        Preconditions.checkNotNull(n4);
        return nodes().contains(n3) && successors((AbstractBaseGraph<N>) n3).contains(n4);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n3) {
        return isDirected() ? predecessors((AbstractBaseGraph<N>) n3).size() : degree(n3);
    }

    @Override // com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n3) {
        Preconditions.checkNotNull(n3);
        Preconditions.checkArgument(nodes().contains(n3), "Node %s is not an element of this graph.", n3);
        return new AnonymousClass2(this, this, n3);
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() == isDirected();
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n3) {
        return isDirected() ? successors((AbstractBaseGraph<N>) n3).size() : degree(n3);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        Iterable predecessors;
        predecessors = predecessors((AbstractBaseGraph<N>) ((BaseGraph) obj));
        return predecessors;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        Iterable successors;
        successors = successors((AbstractBaseGraph<N>) ((BaseGraph) obj));
        return successors;
    }

    protected final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }
}
