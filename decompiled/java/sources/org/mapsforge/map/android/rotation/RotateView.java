package org.mapsforge.map.android.rotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.primitives.Ints;

/* loaded from: /root/release/classes2.dex */
public class RotateView extends ViewGroup {
    private float heading;
    private final Matrix matrix;
    private final float[] points;
    private int saveCount;
    private final SmoothCanvas smoothCanvas;

    public RotateView(Context context) {
        this(context, null);
    }

    public RotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heading = BitmapDescriptorFactory.HUE_RED;
        this.matrix = new Matrix();
        this.points = new float[2];
        this.saveCount = -1;
        this.smoothCanvas = new SmoothCanvas();
        setLayerType(1, null);
    }

    private MotionEvent rotateEvent(MotionEvent motionEvent, float f3, float f4, float f5) {
        if (f3 == BitmapDescriptorFactory.HUE_RED) {
            return motionEvent;
        }
        this.matrix.setRotate(f3, f4, f5);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.transform(this.matrix);
        return obtain;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.heading == BitmapDescriptorFactory.HUE_RED) {
            super.dispatchDraw(canvas);
            return;
        }
        this.saveCount = canvas.save();
        canvas.rotate(-this.heading, getWidth() * 0.5f, getHeight() * 0.5f);
        SmoothCanvas smoothCanvas = this.smoothCanvas;
        smoothCanvas.delegate = canvas;
        super.dispatchDraw(smoothCanvas);
        int i3 = this.saveCount;
        if (i3 != -1) {
            canvas.restoreToCount(i3);
            this.saveCount = -1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float f3 = this.heading;
        if (f3 == BitmapDescriptorFactory.HUE_RED) {
            return super.dispatchTouchEvent(motionEvent);
        }
        MotionEvent rotateEvent = rotateEvent(motionEvent, f3, getWidth() * 0.5f, getHeight() * 0.5f);
        try {
            return super.dispatchTouchEvent(rotateEvent);
        } finally {
            if (rotateEvent != motionEvent) {
                rotateEvent.recycle();
            }
        }
    }

    public float getHeading() {
        return this.heading;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int width = getWidth();
        int height = getHeight();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i8 = (width - measuredWidth) / 2;
            int i9 = (height - measuredHeight) / 2;
            childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) Math.hypot(View.getDefaultSize(getSuggestedMinimumWidth(), i3), View.getDefaultSize(getSuggestedMinimumHeight(), i4)), Ints.MAX_POWER_OF_TWO);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).measure(makeMeasureSpec, makeMeasureSpec);
        }
        super.onMeasure(i3, i4);
    }

    public void setHeading(float f3) {
        this.heading = f3;
    }
}
