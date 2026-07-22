package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
final class LinearWayMatcher implements ClosedMatcher {
    static final LinearWayMatcher INSTANCE = new LinearWayMatcher();

    private LinearWayMatcher() {
    }

    @Override // org.mapsforge.map.rendertheme.rule.ClosedMatcher
    public boolean isCoveredBy(ClosedMatcher closedMatcher) {
        return closedMatcher.matches(Closed.NO);
    }

    @Override // org.mapsforge.map.rendertheme.rule.ClosedMatcher
    public boolean matches(Closed closed) {
        return closed == Closed.NO;
    }
}
