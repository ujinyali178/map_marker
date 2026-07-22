package org.mapsforge.map.rendertheme.rule;

import java.util.List;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
class NegativeMatcher implements AttributeMatcher {
    private final List<String> keyList;
    private final List<String> valueList;

    NegativeMatcher(List<String> list, List<String> list2) {
        this.keyList = list;
        this.valueList = list2;
    }

    private boolean keyListDoesNotContainKeys(List<Tag> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.keyList.contains(list.get(i3).key)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean isCoveredBy(AttributeMatcher attributeMatcher) {
        return false;
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean matches(List<Tag> list) {
        if (keyListDoesNotContainKeys(list)) {
            return true;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.valueList.contains(list.get(i3).value)) {
                return true;
            }
        }
        return false;
    }
}
