package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /root/release/classes.dex */
class p implements LayoutInflater.Factory2 {

    /* renamed from: c, reason: collision with root package name */
    final w f1166c;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d0 f1167c;

        a(d0 d0Var) {
            this.f1167c = d0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k3 = this.f1167c.k();
            this.f1167c.m();
            l0.n((ViewGroup) k3.mView.getParent(), p.this.f1166c).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    p(w wVar) {
        this.f1166c = wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016d  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
