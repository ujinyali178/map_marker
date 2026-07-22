package org.mapsforge.map.rendertheme.rule;

import java.util.ArrayList;
import java.util.List;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
class KeyMatcher implements AttributeMatcher {
    private final List<String> keys;

    KeyMatcher(List<String> list) {
        this.keys = list;
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean isCoveredBy(AttributeMatcher attributeMatcher) {
        if (attributeMatcher == this) {
            return true;
        }
        ArrayList arrayList = new ArrayList(this.keys.size());
        int size = this.keys.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new Tag(this.keys.get(i3), (String) null));
        }
        return attributeMatcher.matches(arrayList);
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean matches(List<Tag> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.keys.contains(list.get(i3).key)) {
                return true;
            }
        }
        return false;
    }
}
