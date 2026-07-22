package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: /root/release/classes.dex */
public final class k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    private final View f814c;

    /* renamed from: d, reason: collision with root package name */
    private ViewTreeObserver f815d;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f816f;

    private k(View view, Runnable runnable) {
        this.f814c = view;
        this.f815d = view.getViewTreeObserver();
        this.f816f = runnable;
    }

    public static k a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        k kVar = new k(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(kVar);
        view.addOnAttachStateChangeListener(kVar);
        return kVar;
    }

    public void b() {
        (this.f815d.isAlive() ? this.f815d : this.f814c.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f814c.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f816f.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f815d = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
