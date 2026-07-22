package org.mapsforge.map.rendertheme.rule;

import java.util.List;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
class NegativeRule extends Rule {
    private final AttributeMatcher attributeMatcher;

    NegativeRule(RuleBuilder ruleBuilder, AttributeMatcher attributeMatcher) {
        super(ruleBuilder);
        this.attributeMatcher = attributeMatcher;
    }

    @Override // org.mapsforge.map.rendertheme.rule.Rule
    boolean matchesNode(List<Tag> list, byte b4) {
        return this.zoomMin <= b4 && this.zoomMax >= b4 && this.elementMatcher.matches(Element.NODE) && this.attributeMatcher.matches(list);
    }

    @Override // org.mapsforge.map.rendertheme.rule.Rule
    boolean matchesWay(List<Tag> list, byte b4, Closed closed) {
        return this.zoomMin <= b4 && this.zoomMax >= b4 && this.elementMatcher.matches(Element.WAY) && this.closedMatcher.matches(closed) && this.attributeMatcher.matches(list);
    }
}
