package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
public class RotationLayout extends FrameLayout {
    private int mRotation;

    public RotationLayout(Context context) {
        super(context);
    }

    public RotationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotationLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float height;
        int i3;
        int i4 = this.mRotation;
        if (i4 == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        if (i4 == 1) {
            canvas.translate(getWidth(), BitmapDescriptorFactory.HUE_RED);
            canvas.rotate(90.0f, getWidth() / 2, BitmapDescriptorFactory.HUE_RED);
            height = getHeight() / 2;
            i3 = getWidth();
        } else if (i4 == 2) {
            canvas.rotate(180.0f, getWidth() / 2, getHeight() / 2);
            super.dispatchDraw(canvas);
        } else {
            canvas.translate(BitmapDescriptorFactory.HUE_RED, getHeight());
            canvas.rotate(270.0f, getWidth() / 2, BitmapDescriptorFactory.HUE_RED);
            height = getHeight() / 2;
            i3 = -getWidth();
        }
        canvas.translate(height, i3 / 2);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5 = this.mRotation;
        if (i5 != 1 && i5 != 3) {
            super.onMeasure(i3, i4);
        } else {
            super.onMeasure(i3, i4);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void setViewRotation(int i3) {
        this.mRotation = ((i3 + 360) % 360) / 90;
    }
}
