package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        static {
            int[] iArr = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(AvlNode<?> avlNode) {
                return ((AvlNode) avlNode).elemCount;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).totalCount;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(AvlNode<?> avlNode) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).distinctElements;
            }
        };

        abstract int nodeAggregate(AvlNode<?> avlNode);

        abstract long treeAggregate(@CheckForNull AvlNode<?> avlNode);
    }

    private static final class AvlNode<E> {
        private int distinctElements;

        @CheckForNull
        private final E elem;
        private int elemCount;
        private int height;

        @CheckForNull
        private AvlNode<E> left;

        @CheckForNull
        private AvlNode<E> pred;

        @CheckForNull
        private AvlNode<E> right;

        @CheckForNull
        private AvlNode<E> succ;
        private long totalCount;

        AvlNode() {
            this.elem = null;
            this.elemCount = 1;
        }

        AvlNode(@ParametricNullness E e3, int i3) {
            Preconditions.checkArgument(i3 > 0);
            this.elem = e3;
            this.elemCount = i3;
            this.totalCount = i3;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        private AvlNode<E> addLeftChild(@ParametricNullness E e3, int i3) {
            this.left = new AvlNode<>(e3, i3);
            TreeMultiset.successor(pred(), this.left, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += i3;
            return this;
        }

        private AvlNode<E> addRightChild(@ParametricNullness E e3, int i3) {
            AvlNode<E> avlNode = new AvlNode<>(e3, i3);
            this.right = avlNode;
            TreeMultiset.successor(this, avlNode, succ());
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += i3;
            return this;
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public AvlNode<E> ceiling(Comparator<? super E> comparator, @ParametricNullness E e3) {
            int compare = comparator.compare(e3, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                return avlNode == null ? this : (AvlNode) MoreObjects.firstNonNull(avlNode.ceiling(comparator, e3), this);
            }
            if (compare == 0) {
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return null;
            }
            return avlNode2.ceiling(comparator, e3);
        }

        @CheckForNull
        private AvlNode<E> deleteMe() {
            AvlNode<E> succ;
            int i3 = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(pred(), succ());
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.height >= avlNode2.height) {
                succ = pred();
                succ.left = this.left.removeMax(succ);
                succ.right = this.right;
            } else {
                succ = succ();
                succ.right = this.right.removeMin(succ);
                succ.left = this.left;
            }
            succ.distinctElements = this.distinctElements - 1;
            succ.totalCount = this.totalCount - i3;
            return succ.rebalance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public AvlNode<E> floor(Comparator<? super E> comparator, @ParametricNullness E e3) {
            int compare = comparator.compare(e3, getElement());
            if (compare > 0) {
                AvlNode<E> avlNode = this.right;
                return avlNode == null ? this : (AvlNode) MoreObjects.firstNonNull(avlNode.floor(comparator, e3), this);
            }
            if (compare == 0) {
                return this;
            }
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return null;
            }
            return avlNode2.floor(comparator, e3);
        }

        private static int height(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return ((AvlNode) avlNode).height;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode<E> pred() {
            AvlNode<E> avlNode = this.pred;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private AvlNode<E> rebalance() {
            int balanceFactor = balanceFactor();
            if (balanceFactor == -2) {
                Objects.requireNonNull(this.right);
                if (this.right.balanceFactor() > 0) {
                    this.right = this.right.rotateRight();
                }
                return rotateLeft();
            }
            if (balanceFactor != 2) {
                recomputeHeight();
                return this;
            }
            Objects.requireNonNull(this.left);
            if (this.left.balanceFactor() < 0) {
                this.left = this.left.rotateLeft();
            }
            return rotateRight();
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
        }

        @CheckForNull
        private AvlNode<E> removeMax(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return this.left;
            }
            this.right = avlNode2.removeMax(avlNode);
            this.distinctElements--;
            this.totalCount -= avlNode.elemCount;
            return rebalance();
        }

        @CheckForNull
        private AvlNode<E> removeMin(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return this.right;
            }
            this.left = avlNode2.removeMin(avlNode);
            this.distinctElements--;
            this.totalCount -= avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            AvlNode<E> avlNode = this.right;
            this.right = avlNode.left;
            avlNode.left = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            AvlNode<E> avlNode = this.left;
            this.left = avlNode.right;
            avlNode.right = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode<E> succ() {
            AvlNode<E> avlNode = this.succ;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private static long totalCount(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return ((AvlNode) avlNode).totalCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> add(Comparator<? super E> comparator, @ParametricNullness E e3, int i3, int[] iArr) {
            int compare = comparator.compare(e3, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return addLeftChild(e3, i3);
                }
                int i4 = avlNode.height;
                AvlNode<E> add = avlNode.add(comparator, e3, i3, iArr);
                this.left = add;
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += i3;
                return add.height == i4 ? this : rebalance();
            }
            if (compare <= 0) {
                int i5 = this.elemCount;
                iArr[0] = i5;
                long j3 = i3;
                Preconditions.checkArgument(((long) i5) + j3 <= 2147483647L);
                this.elemCount += i3;
                this.totalCount += j3;
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return addRightChild(e3, i3);
            }
            int i6 = avlNode2.height;
            AvlNode<E> add2 = avlNode2.add(comparator, e3, i3, iArr);
            this.right = add2;
            if (iArr[0] == 0) {
                this.distinctElements++;
            }
            this.totalCount += i3;
            return add2.height == i6 ? this : rebalance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        int count(Comparator<? super E> comparator, @ParametricNullness E e3) {
            int compare = comparator.compare(e3, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.count(comparator, e3);
            }
            if (compare <= 0) {
                return this.elemCount;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return 0;
            }
            return avlNode2.count(comparator, e3);
        }

        int getCount() {
            return this.elemCount;
        }

        @ParametricNullness
        E getElement() {
            return (E) NullnessCasts.uncheckedCastNullableTToT(this.elem);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> remove(Comparator<? super E> comparator, @ParametricNullness E e3, int i3, int[] iArr) {
            int compare = comparator.compare(e3, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.left = avlNode.remove(comparator, e3, i3, iArr);
                int i4 = iArr[0];
                if (i4 > 0) {
                    if (i3 >= i4) {
                        this.distinctElements--;
                        this.totalCount -= i4;
                    } else {
                        this.totalCount -= i3;
                    }
                }
                return i4 == 0 ? this : rebalance();
            }
            if (compare <= 0) {
                int i5 = this.elemCount;
                iArr[0] = i5;
                if (i3 >= i5) {
                    return deleteMe();
                }
                this.elemCount = i5 - i3;
                this.totalCount -= i3;
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.right = avlNode2.remove(comparator, e3, i3, iArr);
            int i6 = iArr[0];
            if (i6 > 0) {
                if (i3 >= i6) {
                    this.distinctElements--;
                    this.totalCount -= i6;
                } else {
                    this.totalCount -= i3;
                }
            }
            return rebalance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e3, int i3, int i4, int[] iArr) {
            int i5;
            int i6;
            int compare = comparator.compare(e3, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return (i3 != 0 || i4 <= 0) ? this : addLeftChild(e3, i4);
                }
                this.left = avlNode.setCount(comparator, e3, i3, i4, iArr);
                int i7 = iArr[0];
                if (i7 == i3) {
                    if (i4 != 0 || i7 == 0) {
                        if (i4 > 0 && i7 == 0) {
                            i6 = this.distinctElements + 1;
                        }
                        this.totalCount += i4 - i7;
                    } else {
                        i6 = this.distinctElements - 1;
                    }
                    this.distinctElements = i6;
                    this.totalCount += i4 - i7;
                }
                return rebalance();
            }
            if (compare <= 0) {
                int i8 = this.elemCount;
                iArr[0] = i8;
                if (i3 == i8) {
                    if (i4 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += i4 - i8;
                    this.elemCount = i4;
                }
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return (i3 != 0 || i4 <= 0) ? this : addRightChild(e3, i4);
            }
            this.right = avlNode2.setCount(comparator, e3, i3, i4, iArr);
            int i9 = iArr[0];
            if (i9 == i3) {
                if (i4 != 0 || i9 == 0) {
                    if (i4 > 0 && i9 == 0) {
                        i5 = this.distinctElements + 1;
                    }
                    this.totalCount += i4 - i9;
                } else {
                    i5 = this.distinctElements - 1;
                }
                this.distinctElements = i5;
                this.totalCount += i4 - i9;
            }
            return rebalance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e3, int i3, int[] iArr) {
            int i4;
            long j3;
            int i5;
            int i6;
            int compare = comparator.compare(e3, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i3 > 0 ? addLeftChild(e3, i3) : this;
                }
                this.left = avlNode.setCount(comparator, e3, i3, iArr);
                if (i3 != 0 || iArr[0] == 0) {
                    if (i3 > 0 && iArr[0] == 0) {
                        i6 = this.distinctElements + 1;
                    }
                    j3 = this.totalCount;
                    i5 = iArr[0];
                } else {
                    i6 = this.distinctElements - 1;
                }
                this.distinctElements = i6;
                j3 = this.totalCount;
                i5 = iArr[0];
            } else {
                if (compare <= 0) {
                    iArr[0] = this.elemCount;
                    if (i3 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += i3 - r3;
                    this.elemCount = i3;
                    return this;
                }
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return i3 > 0 ? addRightChild(e3, i3) : this;
                }
                this.right = avlNode2.setCount(comparator, e3, i3, iArr);
                if (i3 != 0 || iArr[0] == 0) {
                    if (i3 > 0 && iArr[0] == 0) {
                        i4 = this.distinctElements + 1;
                    }
                    j3 = this.totalCount;
                    i5 = iArr[0];
                } else {
                    i4 = this.distinctElements - 1;
                }
                this.distinctElements = i4;
                j3 = this.totalCount;
                i5 = iArr[0];
            }
            this.totalCount = j3 + (i3 - i5);
            return rebalance();
        }

        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }
    }

    private static final class Reference<T> {

        @CheckForNull
        private T value;

        private Reference() {
        }

        public void checkAndSet(@CheckForNull T t3, @CheckForNull T t4) {
            if (this.value != t3) {
                throw new ConcurrentModificationException();
            }
            this.value = t4;
        }

        void clear() {
            this.value = null;
        }

        @CheckForNull
        public T get() {
            return this.value;
        }
    }

    TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.comparator());
        this.rootReference = reference;
        this.range = generalRange;
        this.header = avlNode;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        AvlNode<E> avlNode = new AvlNode<>();
        this.header = avlNode;
        successor(avlNode, avlNode);
        this.rootReference = new Reference<>();
    }

    private long aggregateAboveRange(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateAboveRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint()), avlNode.getElement());
        if (compare > 0) {
            return aggregateAboveRange(aggregate, ((AvlNode) avlNode).right);
        }
        if (compare == 0) {
            int i3 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return aggregate.treeAggregate(((AvlNode) avlNode).right);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(avlNode);
            aggregateAboveRange = aggregate.treeAggregate(((AvlNode) avlNode).right);
        } else {
            treeAggregate = aggregate.treeAggregate(((AvlNode) avlNode).right) + aggregate.nodeAggregate(avlNode);
            aggregateAboveRange = aggregateAboveRange(aggregate, ((AvlNode) avlNode).left);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateBelowRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint()), avlNode.getElement());
        if (compare < 0) {
            return aggregateBelowRange(aggregate, ((AvlNode) avlNode).left);
        }
        if (compare == 0) {
            int i3 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return aggregate.treeAggregate(((AvlNode) avlNode).left);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(avlNode);
            aggregateBelowRange = aggregate.treeAggregate(((AvlNode) avlNode).left);
        } else {
            treeAggregate = aggregate.treeAggregate(((AvlNode) avlNode).left) + aggregate.nodeAggregate(avlNode);
            aggregateBelowRange = aggregateBelowRange(aggregate, ((AvlNode) avlNode).right);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        AvlNode<E> avlNode = this.rootReference.get();
        long treeAggregate = aggregate.treeAggregate(avlNode);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, avlNode);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, avlNode) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    static int distinctElements(@CheckForNull AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return ((AvlNode) avlNode).distinctElements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (comparator().compare(r2, r0.getElement()) == 0) goto L16;
     */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.common.collect.TreeMultiset.AvlNode<E> firstNode() {
        /*
            r5 = this;
            com.google.common.collect.TreeMultiset$Reference<com.google.common.collect.TreeMultiset$AvlNode<E>> r0 = r5.rootReference
            java.lang.Object r0 = r0.get()
            com.google.common.collect.TreeMultiset$AvlNode r0 = (com.google.common.collect.TreeMultiset.AvlNode) r0
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            com.google.common.collect.GeneralRange<E> r2 = r5.range
            boolean r2 = r2.hasLowerBound()
            if (r2 == 0) goto L42
            com.google.common.collect.GeneralRange<E> r2 = r5.range
            java.lang.Object r2 = r2.getLowerEndpoint()
            java.lang.Object r2 = com.google.common.collect.NullnessCasts.uncheckedCastNullableTToT(r2)
            java.util.Comparator r3 = r5.comparator()
            com.google.common.collect.TreeMultiset$AvlNode r0 = com.google.common.collect.TreeMultiset.AvlNode.access$1000(r0, r3, r2)
            if (r0 != 0) goto L29
            return r1
        L29:
            com.google.common.collect.GeneralRange<E> r3 = r5.range
            com.google.common.collect.BoundType r3 = r3.getLowerBoundType()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L48
            java.util.Comparator r3 = r5.comparator()
            java.lang.Object r4 = r0.getElement()
            int r2 = r3.compare(r2, r4)
            if (r2 != 0) goto L48
            goto L44
        L42:
            com.google.common.collect.TreeMultiset$AvlNode<E> r0 = r5.header
        L44:
            com.google.common.collect.TreeMultiset$AvlNode r0 = com.google.common.collect.TreeMultiset.AvlNode.access$700(r0)
        L48:
            com.google.common.collect.TreeMultiset$AvlNode<E> r2 = r5.header
            if (r0 == r2) goto L5a
            com.google.common.collect.GeneralRange<E> r2 = r5.range
            java.lang.Object r3 = r0.getElement()
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L59
            goto L5a
        L59:
            r1 = r0
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.firstNode():com.google.common.collect.TreeMultiset$AvlNode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (comparator().compare(r2, r0.getElement()) == 0) goto L16;
     */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.common.collect.TreeMultiset.AvlNode<E> lastNode() {
        /*
            r5 = this;
            com.google.common.collect.TreeMultiset$Reference<com.google.common.collect.TreeMultiset$AvlNode<E>> r0 = r5.rootReference
            java.lang.Object r0 = r0.get()
            com.google.common.collect.TreeMultiset$AvlNode r0 = (com.google.common.collect.TreeMultiset.AvlNode) r0
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            com.google.common.collect.GeneralRange<E> r2 = r5.range
            boolean r2 = r2.hasUpperBound()
            if (r2 == 0) goto L42
            com.google.common.collect.GeneralRange<E> r2 = r5.range
            java.lang.Object r2 = r2.getUpperEndpoint()
            java.lang.Object r2 = com.google.common.collect.NullnessCasts.uncheckedCastNullableTToT(r2)
            java.util.Comparator r3 = r5.comparator()
            com.google.common.collect.TreeMultiset$AvlNode r0 = com.google.common.collect.TreeMultiset.AvlNode.access$1100(r0, r3, r2)
            if (r0 != 0) goto L29
            return r1
        L29:
            com.google.common.collect.GeneralRange<E> r3 = r5.range
            com.google.common.collect.BoundType r3 = r3.getUpperBoundType()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L48
            java.util.Comparator r3 = r5.comparator()
            java.lang.Object r4 = r0.getElement()
            int r2 = r3.compare(r2, r4)
            if (r2 != 0) goto L48
            goto L44
        L42:
            com.google.common.collect.TreeMultiset$AvlNode<E> r0 = r5.header
        L44:
            com.google.common.collect.TreeMultiset$AvlNode r0 = com.google.common.collect.TreeMultiset.AvlNode.access$1200(r0)
        L48:
            com.google.common.collect.TreeMultiset$AvlNode<E> r2 = r5.header
            if (r0 == r2) goto L5a
            com.google.common.collect.GeneralRange<E> r2 = r5.range
            java.lang.Object r3 = r0.getElement()
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L59
            goto L5a
        L59:
            r1 = r0
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.lastNode():com.google.common.collect.TreeMultiset$AvlNode");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set((Serialization.FieldSetter) this, (Object) comparator);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set((Serialization.FieldSetter) this, (Object) GeneralRange.all(comparator));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set((Serialization.FieldSetter) this, (Object) new Reference());
        AvlNode avlNode = new AvlNode();
        Serialization.getFieldSetter(TreeMultiset.class, "header").set((Serialization.FieldSetter) this, (Object) avlNode);
        successor(avlNode, avlNode);
        Serialization.populateMultiset(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        ((AvlNode) avlNode).succ = avlNode2;
        ((AvlNode) avlNode2).pred = avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.TreeMultiset.1
            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                int count = avlNode.getCount();
                return count == 0 ? TreeMultiset.this.count(getElement()) : count;
            }

            @Override // com.google.common.collect.Multiset.Entry
            @ParametricNullness
            public E getElement() {
                return (E) avlNode.getElement();
            }
        };
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int add(@ParametricNullness E e3, int i3) {
        CollectPreconditions.checkNonnegative(i3, "occurrences");
        if (i3 == 0) {
            return count(e3);
        }
        Preconditions.checkArgument(this.range.contains(e3));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.add(comparator(), e3, i3, iArr));
            return iArr[0];
        }
        comparator().compare(e3, e3);
        AvlNode<E> avlNode2 = new AvlNode<>(e3, i3);
        AvlNode<E> avlNode3 = this.header;
        successor(avlNode3, avlNode2, avlNode3);
        this.rootReference.checkAndSet(avlNode, avlNode2);
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.clear(entryIterator());
            return;
        }
        AvlNode<E> succ = this.header.succ();
        while (true) {
            AvlNode<E> avlNode = this.header;
            if (succ == avlNode) {
                successor(avlNode, avlNode);
                this.rootReference.clear();
                return;
            }
            AvlNode<E> succ2 = succ.succ();
            ((AvlNode) succ).elemCount = 0;
            ((AvlNode) succ).left = null;
            ((AvlNode) succ).right = null;
            ((AvlNode) succ).pred = null;
            ((AvlNode) succ).succ = null;
            succ = succ2;
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        try {
            AvlNode<E> avlNode = this.rootReference.get();
            if (this.range.contains(obj) && avlNode != null) {
                return avlNode.count(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.3

            @CheckForNull
            AvlNode<E> current;

            @CheckForNull
            Multiset.Entry<E> prevEntry = null;

            {
                this.current = TreeMultiset.this.lastNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Objects.requireNonNull(this.current);
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.current);
                this.prevEntry = wrapEntry;
                this.current = this.current.pred() == TreeMultiset.this.header ? null : this.current.pred();
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.prevEntry != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.2

            @CheckForNull
            AvlNode<E> current;

            @CheckForNull
            Multiset.Entry<E> prevEntry;

            {
                this.current = TreeMultiset.this.firstNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                TreeMultiset treeMultiset = TreeMultiset.this;
                AvlNode<E> avlNode = this.current;
                Objects.requireNonNull(avlNode);
                Multiset.Entry<E> wrapEntry = treeMultiset.wrapEntry(avlNode);
                this.prevEntry = wrapEntry;
                this.current = this.current.succ() == TreeMultiset.this.header ? null : this.current.succ();
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.prevEntry != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@ParametricNullness E e3, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e3, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@CheckForNull Object obj, int i3) {
        CollectPreconditions.checkNonnegative(i3, "occurrences");
        if (i3 == 0) {
            return count(obj);
        }
        AvlNode<E> avlNode = this.rootReference.get();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && avlNode != null) {
                this.rootReference.checkAndSet(avlNode, avlNode.remove(comparator(), obj, i3, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int setCount(@ParametricNullness E e3, int i3) {
        CollectPreconditions.checkNonnegative(i3, "count");
        if (!this.range.contains(e3)) {
            Preconditions.checkArgument(i3 == 0);
            return 0;
        }
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            if (i3 > 0) {
                add(e3, i3);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e3, i3, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public boolean setCount(@ParametricNullness E e3, int i3, int i4) {
        CollectPreconditions.checkNonnegative(i4, "newCount");
        CollectPreconditions.checkNonnegative(i3, "oldCount");
        Preconditions.checkArgument(this.range.contains(e3));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e3, i3, i4, iArr));
            return iArr[0] == i3;
        }
        if (i3 != 0) {
            return false;
        }
        if (i4 > 0) {
            add(e3, i4);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@ParametricNullness Object obj, BoundType boundType, @ParametricNullness Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@ParametricNullness E e3, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e3, boundType)), this.header);
    }
}
