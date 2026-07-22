package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.e;
import androidx.lifecycle.f0;

/* loaded from: /root/release/classes.dex */
public class h extends Dialog implements androidx.lifecycle.i, n, q.d {

    /* renamed from: c, reason: collision with root package name */
    private androidx.lifecycle.j f282c;

    /* renamed from: d, reason: collision with root package name */
    private final q.c f283d;

    /* renamed from: f, reason: collision with root package name */
    private final OnBackPressedDispatcher f284f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, int i3) {
        super(context, i3);
        kotlin.jvm.internal.k.e(context, "context");
        this.f283d = q.c.f4088d.a(this);
        this.f284f = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                h.d(h.this);
            }
        });
    }

    private final androidx.lifecycle.j b() {
        androidx.lifecycle.j jVar = this.f282c;
        if (jVar != null) {
            return jVar;
        }
        androidx.lifecycle.j jVar2 = new androidx.lifecycle.j(this);
        this.f282c = jVar2;
        return jVar2;
    }

    private final void c() {
        Window window = getWindow();
        kotlin.jvm.internal.k.b(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.k.d(decorView, "window!!.decorView");
        f0.a(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.k.b(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.k.d(decorView2, "window!!.decorView");
        q.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.k.b(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.k.d(decorView3, "window!!.decorView");
        q.e.a(decorView3, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(h this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.k.e(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.e getLifecycle() {
        return b();
    }

    @Override // androidx.activity.n
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f284f;
    }

    @Override // q.d
    public androidx.savedstate.a getSavedStateRegistry() {
        return this.f283d.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f284f.e();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f284f;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.k.d(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.f(onBackInvokedDispatcher);
        }
        this.f283d.d(bundle);
        b().h(e.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.k.d(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f283d.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().h(e.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().h(e.a.ON_DESTROY);
        this.f282c = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        c();
        super.setContentView(i3);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.k.e(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
