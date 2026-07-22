package org.mapsforge.map.rendertheme.rule;

import java.util.List;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
final class AnyMatcher implements ElementMatcher, AttributeMatcher, ClosedMatcher {
    static final AnyMatcher INSTANCE = new AnyMatcher();

    private AnyMatcher() {
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean isCoveredBy(AttributeMatcher attributeMatcher) {
        return attributeMatcher == this;
    }

    @Override // org.mapsforge.map.rendertheme.rule.ClosedMatcher
    public boolean isCoveredBy(ClosedMatcher closedMatcher) {
        return closedMatcher == this;
    }

    @Override // org.mapsforge.map.rendertheme.rule.ElementMatcher
    public boolean isCoveredBy(ElementMatcher elementMatcher) {
        return elementMatcher == this;
    }

    @Override // org.mapsforge.map.rendertheme.rule.AttributeMatcher
    public boolean matches(List<Tag> list) {
        return true;
    }

    @Override // org.mapsforge.map.rendertheme.rule.ClosedMatcher
    public boolean matches(Closed closed) {
        return true;
    }

    @Override // org.mapsforge.map.rendertheme.rule.ElementMatcher
    public boolean matches(Element element) {
        return true;
    }
}
