package androidx.window.embedding;

import h2.v;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPairRule(Set<SplitPairFilter> filters, boolean z3, boolean z4, boolean z5, int i3, int i4, float f3, int i5) {
        super(i3, i4, f3, i5);
        Set<SplitPairFilter> z6;
        k.e(filters, "filters");
        this.finishPrimaryWithSecondary = z3;
        this.finishSecondaryWithPrimary = z4;
        this.clearTop = z5;
        z6 = v.z(filters);
        this.filters = z6;
    }

    public /* synthetic */ SplitPairRule(Set set, boolean z3, boolean z4, boolean z5, int i3, int i4, float f3, int i5, int i6, kotlin.jvm.internal.g gVar) {
        this(set, (i6 & 2) != 0 ? false : z3, (i6 & 4) != 0 ? true : z4, (i6 & 8) != 0 ? false : z5, (i6 & 16) != 0 ? 0 : i3, (i6 & 32) == 0 ? i4 : 0, (i6 & 64) != 0 ? 0.5f : f3, (i6 & 128) != 0 ? 3 : i5);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return k.a(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + a.a(this.finishPrimaryWithSecondary)) * 31) + a.a(this.finishSecondaryWithPrimary)) * 31) + a.a(this.clearTop);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter filter) {
        Set z3;
        k.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        z3 = v.z(linkedHashSet);
        return new SplitPairRule(z3, this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
