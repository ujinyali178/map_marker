package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"N"})
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    private static final class Ordered<N> extends EndpointPair<N> {
        private Ordered(N n3, N n4) {
            super(n3, n4);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        public String toString() {
            return "<" + source() + " -> " + target() + ">";
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        private Unordered(N n3, N n4) {
            super(n3, n4);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            return nodeU().equals(endpointPair.nodeU()) ? nodeV().equals(endpointPair.nodeV()) : nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }
    }

    private EndpointPair(N n3, N n4) {
        this.nodeU = (N) Preconditions.checkNotNull(n3);
        this.nodeV = (N) Preconditions.checkNotNull(n4);
    }

    static <N> EndpointPair<N> of(Graph<?> graph, N n3, N n4) {
        return graph.isDirected() ? ordered(n3, n4) : unordered(n3, n4);
    }

    static <N> EndpointPair<N> of(Network<?, ?> network, N n3, N n4) {
        return network.isDirected() ? ordered(n3, n4) : unordered(n3, n4);
    }

    public static <N> EndpointPair<N> ordered(N n3, N n4) {
        return new Ordered(n3, n4);
    }

    public static <N> EndpointPair<N> unordered(N n3, N n4) {
        return new Unordered(n4, n3);
    }

    public final N adjacentNode(N n3) {
        if (n3.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (n3.equals(this.nodeV)) {
            return this.nodeU;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + n3);
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public abstract N source();

    public abstract N target();
}
