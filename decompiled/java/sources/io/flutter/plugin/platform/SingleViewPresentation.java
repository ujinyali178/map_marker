package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

/* loaded from: /root/release/classes.dex */
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final io.flutter.plugin.platform.a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final d state;
    private int viewId;

    private static class a extends FrameLayout {

        /* renamed from: c, reason: collision with root package name */
        private final io.flutter.plugin.platform.a f3118c;

        /* renamed from: d, reason: collision with root package name */
        private final View f3119d;

        public a(Context context, io.flutter.plugin.platform.a aVar, View view) {
            super(context);
            this.f3118c = aVar;
            this.f3119d = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f3118c.b(this.f3119d, view, accessibilityEvent);
        }
    }

    private static class b extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final InputMethodManager f3120a;

        b(Context context) {
            this(context, null);
        }

        private b(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f3120a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new b(super.createDisplayContext(display), this.f3120a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f3120a : super.getSystemService(str);
        }
    }

    private static class c extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final j0 f3121a;

        /* renamed from: b, reason: collision with root package name */
        private WindowManager f3122b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f3123c;

        c(Context context, j0 j0Var, Context context2) {
            super(context);
            this.f3121a = j0Var;
            this.f3123c = context2;
        }

        private WindowManager a() {
            if (this.f3122b == null) {
                this.f3122b = this.f3121a;
            }
            return this.f3122b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i3 = 0; i3 < stackTrace.length && i3 < 11; i3++) {
                if (stackTrace[i3].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i3].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f3123c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        private k f3124a;

        /* renamed from: b, reason: collision with root package name */
        private j0 f3125b;

        /* renamed from: c, reason: collision with root package name */
        private z f3126c;

        d() {
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.a aVar, d dVar, View.OnFocusChangeListener onFocusChangeListener, boolean z3) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.state = dVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z3;
    }

    public SingleViewPresentation(Context context, Display display, k kVar, io.flutter.plugin.platform.a aVar, int i3, View.OnFocusChangeListener onFocusChangeListener) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.viewId = i3;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        d dVar = new d();
        this.state = dVar;
        dVar.f3124a = kVar;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public d detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        a aVar = this.rootView;
        if (aVar != null) {
            aVar.removeAllViews();
        }
        return this.state;
    }

    public k getView() {
        return this.state.f3124a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f3126c == null) {
            this.state.f3126c = new z(getContext());
        }
        if (this.state.f3125b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            d dVar = this.state;
            dVar.f3125b = new j0(windowManager, dVar.f3126c);
        }
        this.container = new FrameLayout(getContext());
        c cVar = new c(getContext(), this.state.f3125b, this.outerContext);
        View view = this.state.f3124a.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) view.getContext()).setBaseContext(cVar);
        } else {
            g1.b.g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(view);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f3126c);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
