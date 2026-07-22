package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

/* loaded from: /root/release/classes.dex */
public class r extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    private int f3179c;

    /* renamed from: d, reason: collision with root package name */
    private int f3180d;

    /* renamed from: f, reason: collision with root package name */
    private int f3181f;

    /* renamed from: g, reason: collision with root package name */
    private int f3182g;

    /* renamed from: h, reason: collision with root package name */
    private io.flutter.embedding.android.c f3183h;

    /* renamed from: i, reason: collision with root package name */
    private p f3184i;

    /* renamed from: j, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalFocusChangeListener f3185j;

    class a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f3186c;

        a(View.OnFocusChangeListener onFocusChangeListener) {
            this.f3186c = onFocusChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f3186c;
            r rVar = r.this;
            onFocusChangeListener.onFocusChange(rVar, e2.h.d(rVar));
        }
    }

    public r(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public r(Context context, p pVar) {
        this(context);
        this.f3184i = pVar;
    }

    public void a() {
        p pVar = this.f3184i;
        if (pVar != null) {
            pVar.release();
            this.f3184i = null;
        }
    }

    public void b(int i3, int i4) {
        p pVar = this.f3184i;
        if (pVar != null) {
            pVar.a(i3, i4);
        }
    }

    public void c() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f3185j) == null) {
            return;
        }
        this.f3185j = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Canvas lockHardwareCanvas;
        p pVar = this.f3184i;
        if (pVar == null) {
            super.draw(canvas);
            g1.b.b("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Surface surface = pVar.getSurface();
        lockHardwareCanvas = surface.lockHardwareCanvas();
        if (lockHardwareCanvas == null) {
            invalidate();
            return;
        }
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockHardwareCanvas);
        } finally {
            this.f3184i.scheduleFrame();
            surface.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.f3185j;
    }

    public int getRenderTargetHeight() {
        p pVar = this.f3184i;
        if (pVar != null) {
            return pVar.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        p pVar = this.f3184i;
        if (pVar != null) {
            return pVar.getWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        float f3;
        if (this.f3183h == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i4 = this.f3181f;
            this.f3179c = i4;
            i3 = this.f3182g;
            this.f3180d = i3;
            f3 = i4;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.f3179c, this.f3180d);
                this.f3179c = this.f3181f;
                this.f3180d = this.f3182g;
                return this.f3183h.l(motionEvent, matrix);
            }
            f3 = this.f3181f;
            i3 = this.f3182g;
        }
        matrix.postTranslate(f3, i3);
        return this.f3183h.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.f3181f = layoutParams.leftMargin;
        this.f3182g = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f3185j == null) {
            a aVar = new a(onFocusChangeListener);
            this.f3185j = aVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(aVar);
        }
    }

    public void setTouchProcessor(io.flutter.embedding.android.c cVar) {
        this.f3183h = cVar;
    }
}
