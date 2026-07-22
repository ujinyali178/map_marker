package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/* loaded from: /root/release/classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int zab(int i3, int i4, int i5, int i6) {
        if (i3 == 0) {
            return i4;
        }
        if (i3 == 1) {
            return i5;
        }
        if (i3 == 2) {
            return i6;
        }
        throw new IllegalStateException("Unknown color scheme: " + i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zaa(android.content.res.Resources r6, int r7, int r8) {
        /*
            r5 = this;
            android.graphics.Typeface r0 = android.graphics.Typeface.DEFAULT_BOLD
            r5.setTypeface(r0)
            r0 = 1096810496(0x41600000, float:14.0)
            r5.setTextSize(r0)
            android.util.DisplayMetrics r0 = r6.getDisplayMetrics()
            float r0 = r0.density
            r1 = 1111490560(0x42400000, float:48.0)
            float r0 = r0 * r1
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            r5.setMinHeight(r0)
            r5.setMinWidth(r0)
            int r0 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark
            int r1 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light
            int r0 = zab(r8, r0, r1, r1)
            int r1 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_dark
            int r2 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_light
            int r1 = zab(r8, r1, r2, r2)
            java.lang.String r2 = "Unknown button size: "
            r3 = 2
            r4 = 1
            if (r7 == 0) goto L4e
            if (r7 == r4) goto L4e
            if (r7 != r3) goto L39
            goto L4f
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L4e:
            r0 = r1
        L4f:
            android.graphics.drawable.Drawable r0 = r6.getDrawable(r0)
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.g(r0)
            int r1 = com.google.android.gms.base.R.color.common_google_signin_btn_tint
            android.content.res.ColorStateList r1 = r6.getColorStateList(r1)
            androidx.core.graphics.drawable.a.e(r0, r1)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_ATOP
            androidx.core.graphics.drawable.a.f(r0, r1)
            r5.setBackgroundDrawable(r0)
            int r0 = com.google.android.gms.base.R.color.common_google_signin_btn_text_dark
            int r1 = com.google.android.gms.base.R.color.common_google_signin_btn_text_light
            int r8 = zab(r8, r0, r1, r1)
            android.content.res.ColorStateList r8 = r6.getColorStateList(r8)
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            android.content.res.ColorStateList r8 = (android.content.res.ColorStateList) r8
            r5.setTextColor(r8)
            r8 = 0
            if (r7 == 0) goto La0
            if (r7 == r4) goto L9d
            if (r7 != r3) goto L88
            r5.setText(r8)
            goto La9
        L88:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L9d:
            int r7 = com.google.android.gms.base.R.string.common_signin_button_text_long
            goto La2
        La0:
            int r7 = com.google.android.gms.base.R.string.common_signin_button_text
        La2:
            java.lang.String r6 = r6.getString(r7)
            r5.setText(r6)
        La9:
            r5.setTransformationMethod(r8)
            android.content.Context r6 = r5.getContext()
            boolean r6 = com.google.android.gms.common.util.DeviceProperties.isWearable(r6)
            if (r6 == 0) goto Lbb
            r6 = 19
            r5.setGravity(r6)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zaaa.zaa(android.content.res.Resources, int, int):void");
    }
}
