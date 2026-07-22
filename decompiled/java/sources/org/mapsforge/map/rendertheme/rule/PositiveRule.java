package org.mapsforge.map.rendertheme.rule;

import java.util.List;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
class PositiveRule extends Rule {
    final AttributeMatcher keyMatcher;
    final AttributeMatcher valueMatcher;

    PositiveRule(RuleBuilder ruleBuilder, AttributeMatcher attributeMatcher, AttributeMatcher attributeMatcher2) {
        super(ruleBuilder);
        this.keyMatcher = attributeMatcher;
        this.valueMatcher = attributeMatcher2;
    }

    @Override // org.mapsforge.map.rendertheme.rule.Rule
    boolean matchesNode(List<Tag> list, byte b4) {
        return this.zoomMin <= b4 && this.zoomMax >= b4 && this.elementMatcher.matches(Element.NODE) && this.keyMatcher.matches(list) && this.valueMatcher.matches(list);
    }

    @Override // org.mapsforge.map.rendertheme.rule.Rule
    boolean matchesWay(List<Tag> list, byte b4, Closed closed) {
        return this.zoomMin <= b4 && this.zoomMax >= b4 && this.elementMatcher.matches(Element.WAY) && this.closedMatcher.matches(closed) && this.keyMatcher.matches(list) && this.valueMatcher.matches(list);
    }
}
