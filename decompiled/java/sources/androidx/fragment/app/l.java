package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class l extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    private final List<View> f1125c;

    /* renamed from: d, reason: collision with root package name */
    private final List<View> f1126d;

    /* renamed from: f, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f1127f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1128g;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f1129a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v3, WindowInsets insets) {
            kotlin.jvm.internal.k.e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.k.e(v3, "v");
            kotlin.jvm.internal.k.e(insets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v3, insets);
            kotlin.jvm.internal.k.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, AttributeSet attrs, w fm) {
        super(context, attrs);
        String str;
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(attrs, "attrs");
        kotlin.jvm.internal.k.e(fm, "fm");
        this.f1125c = new ArrayList();
        this.f1126d = new ArrayList();
        this.f1128g = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = l.c.f3903e;
        kotlin.jvm.internal.k.d(FragmentContainerView, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(l.c.f3904f) : classAttribute;
        String string = obtainStyledAttributes.getString(l.c.f3905g);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment i02 = fm.i0(id);
        if (classAttribute != null && i02 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a4 = fm.t0().a(context.getClassLoader(), classAttribute);
            kotlin.jvm.internal.k.d(a4, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a4.onInflate(context, attrs, (Bundle) null);
            fm.p().m(true).c(this, a4, string).i();
        }
        fm.a1(this);
    }

    private final void a(View view) {
        if (this.f1126d.contains(view)) {
            this.f1125c.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i3, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.k.e(child, "child");
        if (w.C0(child) != null) {
            super.addView(child, i3, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        androidx.core.view.e0 l3;
        kotlin.jvm.internal.k.e(insets, "insets");
        androidx.core.view.e0 n3 = androidx.core.view.e0.n(insets);
        kotlin.jvm.internal.k.d(n3, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1127f;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f1129a;
            kotlin.jvm.internal.k.b(onApplyWindowInsetsListener);
            l3 = androidx.core.view.e0.n(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            l3 = androidx.core.view.n.l(this, n3);
        }
        kotlin.jvm.internal.k.d(l3, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!l3.h()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                androidx.core.view.n.a(getChildAt(i3), l3);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.k.e(canvas, "canvas");
        if (this.f1128g) {
            Iterator<T> it = this.f1125c.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long j3) {
        kotlin.jvm.internal.k.e(canvas, "canvas");
        kotlin.jvm.internal.k.e(child, "child");
        if (this.f1128g && (!this.f1125c.isEmpty()) && this.f1125c.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j3);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        this.f1126d.remove(view);
        if (this.f1125c.remove(view)) {
            this.f1128g = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) w.l0(this).i0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.k.e(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.k.d(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        View view = getChildAt(i3);
        kotlin.jvm.internal.k.d(view, "view");
        a(view);
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i4) {
        int i5 = i3 + i4;
        for (int i6 = i3; i6 < i5; i6++) {
            View view = getChildAt(i6);
            kotlin.jvm.internal.k.d(view, "view");
            a(view);
        }
        super.removeViews(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i4) {
        int i5 = i3 + i4;
        for (int i6 = i3; i6 < i5; i6++) {
            View view = getChildAt(i6);
            kotlin.jvm.internal.k.d(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i3, i4);
    }

    public final void setDrawDisappearingViewsLast(boolean z3) {
        this.f1128g = z3;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f1127f = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        if (view.getParent() == this) {
            this.f1126d.add(view);
        }
        super.startViewTransition(view);
    }
}
