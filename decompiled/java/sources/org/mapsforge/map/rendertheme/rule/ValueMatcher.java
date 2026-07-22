package org.mapsforge.map.rendertheme.rule;

import java.util.ArrayList;
import java.util.List;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
class ValueMatcher implements AttributeMatcher {
    private final List<String> values;

    ValueMatcher(List<String> list) {
        this.values = list;
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean isCoveredBy(AttributeMatcher attributeMatcher) {
        if (attributeMatcher == this) {
            return true;
        }
        ArrayList arrayList = new ArrayList(this.values.size());
        int size = this.values.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new Tag((String) null, this.values.get(i3)));
        }
        return attributeMatcher.matches(arrayList);
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean matches(List<Tag> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.values.contains(list.get(i3).value)) {
                return true;
            }
        }
        return false;
    }
}
