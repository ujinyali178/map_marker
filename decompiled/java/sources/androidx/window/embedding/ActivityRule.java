package androidx.window.embedding;

import h2.v;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> filters, boolean z3) {
        Set<ActivityFilter> z4;
        k.e(filters, "filters");
        this.alwaysExpand = z3;
        z4 = v.z(filters);
        this.filters = z4;
    }

    public /* synthetic */ ActivityRule(Set set, boolean z3, int i3, kotlin.jvm.internal.g gVar) {
        this(set, (i3 & 2) != 0 ? false : z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return k.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + a.a(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter filter) {
        Set z3;
        k.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        z3 = v.z(linkedHashSet);
        return new ActivityRule(z3, this.alwaysExpand);
    }
}
