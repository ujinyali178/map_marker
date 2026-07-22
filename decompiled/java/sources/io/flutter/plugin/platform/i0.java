package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;

/* loaded from: /root/release/classes.dex */
class i0 {

    /* renamed from: i, reason: collision with root package name */
    private static VirtualDisplay.Callback f3161i = new a();

    /* renamed from: a, reason: collision with root package name */
    SingleViewPresentation f3162a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3163b;

    /* renamed from: c, reason: collision with root package name */
    private final io.flutter.plugin.platform.a f3164c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3165d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3166e;

    /* renamed from: f, reason: collision with root package name */
    private final p f3167f;

    /* renamed from: g, reason: collision with root package name */
    private final View.OnFocusChangeListener f3168g;

    /* renamed from: h, reason: collision with root package name */
    private VirtualDisplay f3169h;

    class a extends VirtualDisplay.Callback {
        a() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onPaused() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onResumed() {
        }
    }

    class b implements View.OnAttachStateChangeListener {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3170c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f3171d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f3170c.postDelayed(bVar.f3171d, 128L);
            }
        }

        b(View view, Runnable runnable) {
            this.f3170c = view;
            this.f3171d = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.a(this.f3170c, new a());
            this.f3170c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static class c implements ViewTreeObserver.OnDrawListener {

        /* renamed from: c, reason: collision with root package name */
        final View f3174c;

        /* renamed from: d, reason: collision with root package name */
        Runnable f3175d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f3174c.getViewTreeObserver().removeOnDrawListener(c.this);
            }
        }

        c(View view, Runnable runnable) {
            this.f3174c = view;
            this.f3175d = runnable;
        }

        static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new c(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f3175d;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f3175d = null;
            this.f3174c.post(new a());
        }
    }

    private i0(Context context, io.flutter.plugin.platform.a aVar, VirtualDisplay virtualDisplay, k kVar, p pVar, View.OnFocusChangeListener onFocusChangeListener, int i3, Object obj) {
        this.f3163b = context;
        this.f3164c = aVar;
        this.f3167f = pVar;
        this.f3168g = onFocusChangeListener;
        this.f3166e = i3;
        this.f3169h = virtualDisplay;
        this.f3165d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f3169h.getDisplay(), kVar, aVar, i3, onFocusChangeListener);
        this.f3162a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static i0 b(Context context, io.flutter.plugin.platform.a aVar, k kVar, p pVar, int i3, int i4, int i5, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i3 == 0 || i4 == 0) {
            return null;
        }
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        pVar.a(i3, i4);
        VirtualDisplay createVirtualDisplay = displayManager.createVirtualDisplay("flutter-vd#" + i5, i3, i4, displayMetrics.densityDpi, pVar.getSurface(), 0, f3161i, null);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new i0(context, aVar, createVirtualDisplay, kVar, pVar, onFocusChangeListener, i5, obj);
    }

    private void l(View view, int i3, int i4, Runnable runnable) {
        this.f3167f.a(i3, i4);
        this.f3169h.resize(i3, i4, this.f3165d);
        this.f3169h.setSurface(this.f3167f.getSurface());
        view.postDelayed(runnable, 0L);
    }

    public void a() {
        this.f3169h.setSurface(null);
    }

    public void c(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f3162a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public void d() {
        this.f3162a.cancel();
        this.f3162a.detachState();
        this.f3169h.release();
        this.f3167f.release();
    }

    public int e() {
        p pVar = this.f3167f;
        if (pVar != null) {
            return pVar.getHeight();
        }
        return 0;
    }

    public int f() {
        p pVar = this.f3167f;
        if (pVar != null) {
            return pVar.getWidth();
        }
        return 0;
    }

    public View g() {
        SingleViewPresentation singleViewPresentation = this.f3162a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    void h() {
        SingleViewPresentation singleViewPresentation = this.f3162a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f3162a.getView().j();
    }

    void i() {
        SingleViewPresentation singleViewPresentation = this.f3162a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f3162a.getView().o();
    }

    public void j() {
        int f3 = f();
        int e3 = e();
        boolean isFocused = g().isFocused();
        SingleViewPresentation.d detachState = this.f3162a.detachState();
        this.f3169h.setSurface(null);
        this.f3169h.release();
        this.f3169h = ((DisplayManager) this.f3163b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.f3166e, f3, e3, this.f3165d, this.f3167f.getSurface(), 0, f3161i, null);
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f3163b, this.f3169h.getDisplay(), this.f3164c, detachState, this.f3168g, isFocused);
        singleViewPresentation.show();
        this.f3162a.cancel();
        this.f3162a = singleViewPresentation;
    }

    public void k(int i3, int i4, Runnable runnable) {
        if (i3 == f() && i4 == e()) {
            g().postDelayed(runnable, 0L);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            l(g(), i3, i4, runnable);
            return;
        }
        boolean isFocused = g().isFocused();
        SingleViewPresentation.d detachState = this.f3162a.detachState();
        this.f3169h.setSurface(null);
        this.f3169h.release();
        DisplayManager displayManager = (DisplayManager) this.f3163b.getSystemService("display");
        this.f3167f.a(i3, i4);
        this.f3169h = displayManager.createVirtualDisplay("flutter-vd#" + this.f3166e, i3, i4, this.f3165d, this.f3167f.getSurface(), 0, f3161i, null);
        View g3 = g();
        g3.addOnAttachStateChangeListener(new b(g3, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f3163b, this.f3169h.getDisplay(), this.f3164c, detachState, this.f3168g, isFocused);
        singleViewPresentation.show();
        this.f3162a.cancel();
        this.f3162a = singleViewPresentation;
    }
}
