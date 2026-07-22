package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
final class ElementNodeMatcher implements ElementMatcher {
    static final ElementNodeMatcher INSTANCE = new ElementNodeMatcher();

    private ElementNodeMatcher() {
    }

    @Override // org.mapsforge.map.rendertheme.rule.ElementMatcher
    public boolean isCoveredBy(ElementMatcher elementMatcher) {
        return elementMatcher.matches(Element.NODE);
    }

    @Override // org.mapsforge.map.rendertheme.rule.ElementMatcher
    public boolean matches(Element element) {
        return element == Element.NODE;
    }
}
