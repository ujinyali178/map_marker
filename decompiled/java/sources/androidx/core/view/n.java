package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import androidx.core.view.e0;
import androidx.core.view.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /root/release/classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f828a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static WeakHashMap<View, Object> f829b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f830c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f831d = {h.d.f2563a, h.d.f2564b, h.d.f2575m, h.d.f2586x, h.d.A, h.d.B, h.d.C, h.d.D, h.d.E, h.d.F, h.d.f2565c, h.d.f2566d, h.d.f2567e, h.d.f2568f, h.d.f2569g, h.d.f2570h, h.d.f2571i, h.d.f2572j, h.d.f2573k, h.d.f2574l, h.d.f2576n, h.d.f2577o, h.d.f2578p, h.d.f2579q, h.d.f2580r, h.d.f2581s, h.d.f2582t, h.d.f2583u, h.d.f2584v, h.d.f2585w, h.d.f2587y, h.d.f2588z};

    /* renamed from: e, reason: collision with root package name */
    private static final androidx.core.view.j f832e = new androidx.core.view.j() { // from class: androidx.core.view.m
    };

    /* renamed from: f, reason: collision with root package name */
    private static final b f833f = new b();

    class a extends c<CharSequence> {
        a(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n.c
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return i.b(view);
        }
    }

    static class b implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: c, reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f834c = new WeakHashMap<>();

        b() {
        }

        private void a(View view, boolean z3) {
            boolean z4 = view.isShown() && view.getWindowVisibility() == 0;
            if (z3 != z4) {
                n.k(view, z4 ? 16 : 32);
                this.f834c.put(view, Boolean.valueOf(z4));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f834c.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class c<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f835a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f836b;

        /* renamed from: c, reason: collision with root package name */
        private final int f837c;

        /* renamed from: d, reason: collision with root package name */
        private final int f838d;

        c(int i3, Class<T> cls, int i4, int i5) {
            this.f835a = i3;
            this.f836b = cls;
            this.f838d = i4;
            this.f837c = i5;
        }

        private boolean a() {
            return true;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f837c;
        }

        abstract T c(View view);

        T d(View view) {
            if (b()) {
                return c(view);
            }
            if (!a()) {
                return null;
            }
            T t3 = (T) view.getTag(this.f835a);
            if (this.f836b.isInstance(t3)) {
                return t3;
            }
            return null;
        }
    }

    static class d {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i3, Bundle bundle) {
            return view.performAccessibilityAction(i3, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i3, int i4, int i5, int i6) {
            view.postInvalidateOnAnimation(i3, i4, i5, i6);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j3) {
            view.postOnAnimationDelayed(runnable, j3);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z3) {
            view.setHasTransientState(z3);
        }

        static void s(View view, int i3) {
            view.setImportantForAccessibility(i3);
        }
    }

    static class e {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(View view) {
            return view.isLaidOut();
        }

        static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i3) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
        }

        static void f(View view, int i3) {
            view.setAccessibilityLiveRegion(i3);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i3) {
            accessibilityEvent.setContentChangeTypes(i3);
        }
    }

    static class f {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class g {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            e0 f839a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f840b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ androidx.core.view.i f841c;

            a(View view, androidx.core.view.i iVar) {
                this.f840b = view;
                this.f841c = iVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                e0 o3 = e0.o(windowInsets, view);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 30) {
                    g.a(windowInsets, this.f840b);
                    if (o3.equals(this.f839a)) {
                        return this.f841c.a(view, o3).m();
                    }
                }
                this.f839a = o3;
                e0 a4 = this.f841c.a(view, o3);
                if (i3 >= 30) {
                    return a4.m();
                }
                n.n(view);
                return a4.m();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(h.d.K);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static e0 b(View view, e0 e0Var, Rect rect) {
            WindowInsets m3 = e0Var.m();
            if (m3 != null) {
                return e0.o(view.computeSystemWindowInsets(m3, rect), view);
            }
            rect.setEmpty();
            return e0Var;
        }

        static boolean c(View view, float f3, float f4, boolean z3) {
            return view.dispatchNestedFling(f3, f4, z3);
        }

        static boolean d(View view, float f3, float f4) {
            return view.dispatchNestedPreFling(f3, f4);
        }

        static boolean e(View view, int i3, int i4, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i3, i4, iArr, iArr2);
        }

        static boolean f(View view, int i3, int i4, int i5, int i6, int[] iArr) {
            return view.dispatchNestedScroll(i3, i4, i5, i6, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static e0 j(View view) {
            return e0.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f3) {
            view.setElevation(f3);
        }

        static void t(View view, boolean z3) {
            view.setNestedScrollingEnabled(z3);
        }

        static void u(View view, androidx.core.view.i iVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(h.d.H, iVar);
            }
            if (iVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(h.d.K));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, iVar));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f3) {
            view.setTranslationZ(f3);
        }

        static void x(View view, float f3) {
            view.setZ(f3);
        }

        static boolean y(View view, int i3) {
            return view.startNestedScroll(i3);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class h {
        public static e0 a(View view) {
            WindowInsets rootWindowInsets;
            rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            e0 n3 = e0.n(rootWindowInsets);
            n3.k(n3);
            n3.d(view.getRootView());
            return n3;
        }

        static int b(View view) {
            int scrollIndicators;
            scrollIndicators = view.getScrollIndicators();
            return scrollIndicators;
        }

        static void c(View view, int i3) {
            view.setScrollIndicators(i3);
        }

        static void d(View view, int i3, int i4) {
            view.setScrollIndicators(i3, i4);
        }
    }

    static class i {
        static void a(View view, final j jVar) {
            int i3 = h.d.J;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(i3);
            if (gVar == null) {
                gVar = new androidx.collection.g();
                view.setTag(i3, gVar);
            }
            Objects.requireNonNull(jVar);
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener = new View$OnUnhandledKeyEventListener() { // from class: androidx.core.view.c0
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return n.j.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            gVar.put(jVar, view$OnUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            CharSequence accessibilityPaneTitle;
            accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            return accessibilityPaneTitle;
        }

        static boolean c(View view) {
            boolean isAccessibilityHeading;
            isAccessibilityHeading = view.isAccessibilityHeading();
            return isAccessibilityHeading;
        }

        static boolean d(View view) {
            boolean isScreenReaderFocusable;
            isScreenReaderFocusable = view.isScreenReaderFocusable();
            return isScreenReaderFocusable;
        }

        static void e(View view, j jVar) {
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(h.d.J);
            if (gVar == null || (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) gVar.get(jVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i3) {
            KeyEvent.Callback requireViewById;
            requireViewById = view.requireViewById(i3);
            return (T) requireViewById;
        }

        static void g(View view, boolean z3) {
            view.setAccessibilityHeading(z3);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AutofillId autofillId) {
            view.setAutofillId(autofillId);
        }

        static void j(View view, boolean z3) {
            view.setScreenReaderFocusable(z3);
        }
    }

    public interface j {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    static class k {

        /* renamed from: d, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f842d = new ArrayList<>();

        /* renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f843a = null;

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f844b = null;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<KeyEvent> f845c = null;

        k() {
        }

        static k a(View view) {
            int i3 = h.d.I;
            k kVar = (k) view.getTag(i3);
            if (kVar != null) {
                return kVar;
            }
            k kVar2 = new k();
            view.setTag(i3, kVar2);
            return kVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f843a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c3 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c3 != null) {
                            return c3;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f844b == null) {
                this.f844b = new SparseArray<>();
            }
            return this.f844b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(h.d.J);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((j) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f843a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f842d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f843a == null) {
                    this.f843a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f842d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f843a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f843a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c3 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c3 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c3));
                }
            }
            return c3 != null;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f845c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f845c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> d3 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d3.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d3.valueAt(indexOfKey);
                d3.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d3.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && n.i(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static e0 a(View view, e0 e0Var) {
        WindowInsets m3 = e0Var.m();
        if (m3 != null) {
            WindowInsets a4 = f.a(view, m3);
            if (!a4.equals(m3)) {
                return e0.o(a4, view);
            }
        }
        return e0Var;
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).b(view, keyEvent);
    }

    static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return k.a(view).f(keyEvent);
    }

    public static int d(View view) {
        return e.a(view);
    }

    public static CharSequence e(View view) {
        return m().d(view);
    }

    public static int f(View view) {
        return d.c(view);
    }

    public static e0 g(View view) {
        return Build.VERSION.SDK_INT >= 23 ? h.a(view) : g.j(view);
    }

    public static String h(View view) {
        return g.k(view);
    }

    public static boolean i(View view) {
        return e.b(view);
    }

    public static boolean j(View view) {
        return e.c(view);
    }

    static void k(View view, int i3) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z3 = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (d(view) != 0 || z3) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z3 ? 32 : 2048);
                e.g(obtain, i3);
                if (z3) {
                    obtain.getText().add(e(view));
                    p(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i3 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                e.g(obtain2, i3);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(e(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    e.e(view.getParent(), view, view, i3);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e3);
                }
            }
        }
    }

    public static e0 l(View view, e0 e0Var) {
        WindowInsets m3 = e0Var.m();
        if (m3 != null) {
            WindowInsets b4 = f.b(view, m3);
            if (!b4.equals(m3)) {
                return e0.o(b4, view);
            }
        }
        return e0Var;
    }

    private static c<CharSequence> m() {
        return new a(h.d.G, CharSequence.class, 8, 28);
    }

    public static void n(View view) {
        f.c(view);
    }

    public static void o(View view, int i3) {
        d.s(view, i3);
    }

    private static void p(View view) {
        if (f(view) == 0) {
            o(view, 1);
        }
    }

    public static void q(View view, String str) {
        g.v(view, str);
    }
}
