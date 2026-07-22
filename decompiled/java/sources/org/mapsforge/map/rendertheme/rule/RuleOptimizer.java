package org.mapsforge.map.rendertheme.rule;

import java.util.Stack;
import java.util.logging.Logger;

/* loaded from: /root/release/classes2.dex */
final class RuleOptimizer {
    private static final Logger LOGGER = Logger.getLogger(RuleOptimizer.class.getName());

    private RuleOptimizer() {
        throw new IllegalStateException();
    }

    static AttributeMatcher optimize(AttributeMatcher attributeMatcher, Stack<Rule> stack) {
        if ((attributeMatcher instanceof AnyMatcher) || (attributeMatcher instanceof NegativeMatcher)) {
            return attributeMatcher;
        }
        if (attributeMatcher instanceof KeyMatcher) {
            return optimizeKeyMatcher(attributeMatcher, stack);
        }
        if (attributeMatcher instanceof ValueMatcher) {
            return optimizeValueMatcher(attributeMatcher, stack);
        }
        throw new IllegalArgumentException("unknown AttributeMatcher: " + attributeMatcher);
    }

    static ClosedMatcher optimize(ClosedMatcher closedMatcher, Stack<Rule> stack) {
        if (closedMatcher instanceof AnyMatcher) {
            return closedMatcher;
        }
        int size = stack.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (stack.get(i3).closedMatcher.isCoveredBy(closedMatcher)) {
                return AnyMatcher.INSTANCE;
            }
            if (!closedMatcher.isCoveredBy(stack.get(i3).closedMatcher)) {
                LOGGER.warning("unreachable rule (closed)");
            }
        }
        return closedMatcher;
    }

    static ElementMatcher optimize(ElementMatcher elementMatcher, Stack<Rule> stack) {
        if (elementMatcher instanceof AnyMatcher) {
            return elementMatcher;
        }
        int size = stack.size();
        for (int i3 = 0; i3 < size; i3++) {
            Rule rule = stack.get(i3);
            if (rule.elementMatcher.isCoveredBy(elementMatcher)) {
                return AnyMatcher.INSTANCE;
            }
            if (!elementMatcher.isCoveredBy(rule.elementMatcher)) {
                LOGGER.warning("unreachable rule (e)");
            }
        }
        return elementMatcher;
    }

    private static AttributeMatcher optimizeKeyMatcher(AttributeMatcher attributeMatcher, Stack<Rule> stack) {
        int size = stack.size();
        for (int i3 = 0; i3 < size; i3++) {
            if ((stack.get(i3) instanceof PositiveRule) && ((PositiveRule) stack.get(i3)).keyMatcher.isCoveredBy(attributeMatcher)) {
                return AnyMatcher.INSTANCE;
            }
        }
        return attributeMatcher;
    }

    private static AttributeMatcher optimizeValueMatcher(AttributeMatcher attributeMatcher, Stack<Rule> stack) {
        int size = stack.size();
        for (int i3 = 0; i3 < size; i3++) {
            if ((stack.get(i3) instanceof PositiveRule) && ((PositiveRule) stack.get(i3)).valueMatcher.isCoveredBy(attributeMatcher)) {
                return AnyMatcher.INSTANCE;
            }
        }
        return attributeMatcher;
    }
}
