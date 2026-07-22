package androidx.window.layout;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import p2.l;

/* loaded from: /root/release/classes.dex */
/* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends j implements l<WindowMetricsCalculator, WindowMetricsCalculator> {
    WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    @Override // p2.l
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator p02) {
        k.e(p02, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(p02);
    }
}
