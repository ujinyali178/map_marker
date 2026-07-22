package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.google.common.primitives.Ints;
import f.a;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    private final int f335c;

    /* renamed from: d, reason: collision with root package name */
    private final int f336d;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f335c = getResources().getDimensionPixelOffset(a.f2487b);
        this.f336d = getResources().getDimensionPixelOffset(a.f2486a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f335c * 2), this.f336d), Ints.MAX_POWER_OF_TWO), i4);
    }
}
