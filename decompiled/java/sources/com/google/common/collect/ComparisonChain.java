package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = new ComparisonChain() { // from class: com.google.common.collect.ComparisonChain.1
        ComparisonChain classify(int i3) {
            return i3 < 0 ? ComparisonChain.LESS : i3 > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d3, double d4) {
            return classify(Double.compare(d3, d4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f3, float f4) {
            return classify(Float.compare(f3, f4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i3, int i4) {
            return classify(Ints.compare(i3, i4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j3, long j4) {
            return classify(Longs.compare(j3, j4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator) {
            return classify(comparator.compare(t3, t4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z3, boolean z4) {
            return classify(Booleans.compare(z3, z4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z3, boolean z4) {
            return classify(Booleans.compare(z4, z3));
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }
    };
    private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
    private static final ComparisonChain GREATER = new InactiveComparisonChain(1);

    private static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        InactiveComparisonChain(int i3) {
            super();
            this.result = i3;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d3, double d4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f3, float f4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i3, int i4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j3, long j4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z3, boolean z4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z3, boolean z4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }
    }

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double d3, double d4);

    public abstract ComparisonChain compare(float f3, float f4);

    public abstract ComparisonChain compare(int i3, int i4);

    public abstract ComparisonChain compare(long j3, long j4);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z3, boolean z4);

    public abstract ComparisonChain compareTrueFirst(boolean z3, boolean z4);

    public abstract int result();
}
