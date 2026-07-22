package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class ActivityCompatHelperApi30 {
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    public final Rect currentWindowBounds(Activity activity) {
        android.view.WindowMetrics currentWindowMetrics;
        k.e(activity, "activity");
        currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
        Rect bounds = currentWindowMetrics.getBounds();
        k.d(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }

    public final Rect maximumWindowBounds(Activity activity) {
        android.view.WindowMetrics maximumWindowMetrics;
        k.e(activity, "activity");
        maximumWindowMetrics = activity.getWindowManager().getMaximumWindowMetrics();
        Rect bounds = maximumWindowMetrics.getBounds();
        k.d(bounds, "activity.windowManager.maximumWindowMetrics.bounds");
        return bounds;
    }
}
