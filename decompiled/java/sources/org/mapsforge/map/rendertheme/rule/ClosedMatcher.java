package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
interface ClosedMatcher {
    boolean isCoveredBy(ClosedMatcher closedMatcher);

    boolean matches(Closed closed);
}
