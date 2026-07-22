package org.mapsforge.map.rendertheme.rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
class MatchingCacheKey {
    private final Closed closed;
    private final List<Tag> tags;
    private final Set<Tag> tagsWithoutName = new HashSet();
    private final byte zoomLevel;

    MatchingCacheKey(List<Tag> list, byte b4, Closed closed) {
        this.tags = list;
        this.zoomLevel = b4;
        this.closed = closed;
        if (list != null) {
            for (Tag tag : list) {
                if (!"name".equals(tag.key)) {
                    this.tagsWithoutName.add(tag);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchingCacheKey)) {
            return false;
        }
        MatchingCacheKey matchingCacheKey = (MatchingCacheKey) obj;
        if (this.closed != matchingCacheKey.closed) {
            return false;
        }
        Set<Tag> set = this.tagsWithoutName;
        return (set != null || matchingCacheKey.tagsWithoutName == null) && set.equals(matchingCacheKey.tagsWithoutName) && this.zoomLevel == matchingCacheKey.zoomLevel;
    }

    public int hashCode() {
        Closed closed = this.closed;
        return (((((closed == null ? 0 : closed.hashCode()) + 31) * 31) + this.tagsWithoutName.hashCode()) * 31) + this.zoomLevel;
    }
}
