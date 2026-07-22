package org.mapsforge.map.rendertheme.rule;

/* loaded from: /root/release/classes2.dex */
final class ClosedWayMatcher implements ClosedMatcher {
    static final ClosedWayMatcher INSTANCE = new ClosedWayMatcher();

    private ClosedWayMatcher() {
    }

    @Override // org.mapsforge.map.rendertheme.rule.ClosedMatcher
    public boolean isCoveredBy(ClosedMatcher closedMatcher) {
        return closedMatcher.matches(Closed.YES);
    }

    @Override // org.mapsforge.map.rendertheme.rule.ClosedMatcher
    public boolean matches(Closed closed) {
        return closed == Closed.YES;
    }
}
