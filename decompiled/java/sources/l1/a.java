package l1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import e2.h;
import io.flutter.embedding.android.c;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public class a extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    private FlutterMutatorsStack f3910c;

    /* renamed from: d, reason: collision with root package name */
    private float f3911d;

    /* renamed from: f, reason: collision with root package name */
    private int f3912f;

    /* renamed from: g, reason: collision with root package name */
    private int f3913g;

    /* renamed from: h, reason: collision with root package name */
    private int f3914h;

    /* renamed from: i, reason: collision with root package name */
    private int f3915i;

    /* renamed from: j, reason: collision with root package name */
    private final c f3916j;

    /* renamed from: k, reason: collision with root package name */
    ViewTreeObserver.OnGlobalFocusChangeListener f3917k;

    /* renamed from: l1.a$a, reason: collision with other inner class name */
    class ViewTreeObserverOnGlobalFocusChangeListenerC0095a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f3918c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f3919d;

        ViewTreeObserverOnGlobalFocusChangeListenerC0095a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f3918c = onFocusChangeListener;
            this.f3919d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f3918c;
            View view3 = this.f3919d;
            onFocusChangeListener.onFocusChange(view3, h.d(view3));
        }
    }

    public a(Context context, float f3, c cVar) {
        super(context, null);
        this.f3911d = f3;
        this.f3916j = cVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f3910c.getFinalMatrix());
        float f3 = this.f3911d;
        matrix.preScale(1.0f / f3, 1.0f / f3);
        matrix.postTranslate(-this.f3912f, -this.f3913g);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i3, int i4, int i5, int i6) {
        this.f3910c = flutterMutatorsStack;
        this.f3912f = i3;
        this.f3913g = i4;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f3917k) == null) {
            return;
        }
        this.f3917k = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f3910c.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f3912f, -this.f3913g);
            canvas.clipPath(path);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        float f3;
        if (this.f3916j == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i4 = this.f3912f;
            this.f3914h = i4;
            i3 = this.f3913g;
            this.f3915i = i3;
            f3 = i4;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.f3914h, this.f3915i);
                this.f3914h = this.f3912f;
                this.f3915i = this.f3913g;
                return this.f3916j.l(motionEvent, matrix);
            }
            f3 = this.f3912f;
            i3 = this.f3913g;
        }
        matrix.postTranslate(f3, i3);
        return this.f3916j.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f3917k == null) {
            ViewTreeObserverOnGlobalFocusChangeListenerC0095a viewTreeObserverOnGlobalFocusChangeListenerC0095a = new ViewTreeObserverOnGlobalFocusChangeListenerC0095a(onFocusChangeListener, this);
            this.f3917k = viewTreeObserverOnGlobalFocusChangeListenerC0095a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC0095a);
        }
    }
}
