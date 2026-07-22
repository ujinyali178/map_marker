package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
final class ElementWayMatcher implements ElementMatcher {
    static final ElementWayMatcher INSTANCE = new ElementWayMatcher();

    private ElementWayMatcher() {
    }

    @Override // org.mapsforge.map.rendertheme.rule.ElementMatcher
    public boolean isCoveredBy(ElementMatcher elementMatcher) {
        return elementMatcher.matches(Element.WAY);
    }

    @Override // org.mapsforge.map.rendertheme.rule.ElementMatcher
    public boolean matches(Element element) {
        return element == Element.WAY;
    }
}
