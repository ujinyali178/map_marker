package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: /root/release/classes.dex */
public class SquareTextView extends TextView {
    private int mOffsetLeft;
    private int mOffsetTop;

    public SquareTextView(Context context) {
        super(context);
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
    }

    public SquareTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
    }

    public SquareTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.translate(this.mOffsetLeft / 2, this.mOffsetTop / 2);
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.mOffsetTop = measuredWidth - measuredHeight;
            this.mOffsetLeft = 0;
        } else {
            this.mOffsetTop = 0;
            this.mOffsetLeft = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(max, max);
    }
}
