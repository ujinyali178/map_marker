package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
interface ElementMatcher {
    boolean isCoveredBy(ElementMatcher elementMatcher);

    boolean matches(Element element);
}
