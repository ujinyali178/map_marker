package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    ExplicitOrdering(List<T> list) {
        this(Maps.indexMap(list));
    }

    private int rank(T t3) {
        Integer num = this.rankMap.get(t3);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t3);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t3, T t4) {
        return rank(t3) - rank(t4);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
