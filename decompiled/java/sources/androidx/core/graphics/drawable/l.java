package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: /root/release/classes.dex */
class l extends k {

    /* renamed from: k, reason: collision with root package name */
    private static Method f689k;

    l(Drawable drawable) {
        super(drawable);
        f();
    }

    l(m mVar, Resources resources) {
        super(mVar, resources);
        f();
    }

    private void f() {
        if (f689k == null) {
            try {
                f689k = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e3) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e3);
            }
        }
    }

    @Override // androidx.core.graphics.drawable.k
    protected boolean a() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f688i;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f688i.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f688i.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f688i;
        if (drawable != null && (method = f689k) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e3) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e3);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        this.f688i.setHotspot(f3, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        this.f688i.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.core.graphics.drawable.k, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.k, android.graphics.drawable.Drawable
    public void setTint(int i3) {
        if (a()) {
            super.setTint(i3);
        } else {
            this.f688i.setTint(i3);
        }
    }

    @Override // androidx.core.graphics.drawable.k, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (a()) {
            super.setTintList(colorStateList);
        } else {
            this.f688i.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.k, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (a()) {
            super.setTintMode(mode);
        } else {
            this.f688i.setTintMode(mode);
        }
    }
}
