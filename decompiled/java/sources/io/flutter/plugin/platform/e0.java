package io.flutter.plugin.platform;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* loaded from: /root/release/classes.dex */
abstract class e0 implements WindowManager {

    /* renamed from: c, reason: collision with root package name */
    final WindowManager f3136c;

    /* renamed from: d, reason: collision with root package name */
    z f3137d;

    e0(WindowManager windowManager, z zVar) {
        this.f3136c = windowManager;
        this.f3137d = zVar;
    }

    @Override // android.view.WindowManager
    public void addCrossWindowBlurEnabledListener(Executor executor, Consumer<Boolean> consumer) {
        this.f3136c.addCrossWindowBlurEnabledListener(executor, consumer);
    }

    @Override // android.view.WindowManager
    public void addCrossWindowBlurEnabledListener(Consumer<Boolean> consumer) {
        this.f3136c.addCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        z zVar = this.f3137d;
        if (zVar == null) {
            g1.b.g("PlatformViewsController", "Embedded view called addView while detached from presentation");
        } else {
            zVar.addView(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public WindowMetrics getCurrentWindowMetrics() {
        WindowMetrics currentWindowMetrics;
        currentWindowMetrics = this.f3136c.getCurrentWindowMetrics();
        return currentWindowMetrics;
    }

    @Override // android.view.WindowManager
    @Deprecated
    public Display getDefaultDisplay() {
        return this.f3136c.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public WindowMetrics getMaximumWindowMetrics() {
        WindowMetrics maximumWindowMetrics;
        maximumWindowMetrics = this.f3136c.getMaximumWindowMetrics();
        return maximumWindowMetrics;
    }

    @Override // android.view.WindowManager
    public boolean isCrossWindowBlurEnabled() {
        boolean isCrossWindowBlurEnabled;
        isCrossWindowBlurEnabled = this.f3136c.isCrossWindowBlurEnabled();
        return isCrossWindowBlurEnabled;
    }

    @Override // android.view.WindowManager
    public void removeCrossWindowBlurEnabledListener(Consumer<Boolean> consumer) {
        this.f3136c.removeCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        z zVar = this.f3137d;
        if (zVar == null) {
            g1.b.g("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        } else {
            zVar.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public void removeViewImmediate(View view) {
        if (this.f3137d == null) {
            g1.b.g("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        } else {
            view.clearAnimation();
            this.f3137d.removeView(view);
        }
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        z zVar = this.f3137d;
        if (zVar == null) {
            g1.b.g("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        } else {
            zVar.updateViewLayout(view, layoutParams);
        }
    }
}
