package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: /root/release/classes.dex */
class k extends Drawable implements Drawable.Callback, j {

    /* renamed from: j, reason: collision with root package name */
    static final PorterDuff.Mode f682j = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private int f683c;

    /* renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f684d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f685f;

    /* renamed from: g, reason: collision with root package name */
    m f686g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f687h;

    /* renamed from: i, reason: collision with root package name */
    Drawable f688i;

    k(Drawable drawable) {
        this.f686g = b();
        c(drawable);
    }

    k(m mVar, Resources resources) {
        this.f686g = mVar;
        d(resources);
    }

    private m b() {
        return new m(this.f686g);
    }

    private void d(Resources resources) {
        Drawable.ConstantState constantState;
        m mVar = this.f686g;
        if (mVar == null || (constantState = mVar.f691b) == null) {
            return;
        }
        c(constantState.newDrawable(resources));
    }

    private boolean e(int[] iArr) {
        if (!a()) {
            return false;
        }
        m mVar = this.f686g;
        ColorStateList colorStateList = mVar.f692c;
        PorterDuff.Mode mode = mVar.f693d;
        if (colorStateList == null || mode == null) {
            this.f685f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f685f || colorForState != this.f683c || mode != this.f684d) {
                setColorFilter(colorForState, mode);
                this.f683c = colorForState;
                this.f684d = mode;
                this.f685f = true;
                return true;
            }
        }
        return false;
    }

    protected boolean a() {
        throw null;
    }

    public final void c(Drawable drawable) {
        Drawable drawable2 = this.f688i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f688i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            m mVar = this.f686g;
            if (mVar != null) {
                mVar.f691b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f688i.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        m mVar = this.f686g;
        return changingConfigurations | (mVar != null ? mVar.getChangingConfigurations() : 0) | this.f688i.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        m mVar = this.f686g;
        if (mVar == null || !mVar.a()) {
            return null;
        }
        this.f686g.f690a = getChangingConfigurations();
        return this.f686g;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f688i.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f688i.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f688i.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.a(this.f688i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f688i.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f688i.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f688i.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f688i.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f688i.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f688i.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.b(this.f688i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        m mVar;
        ColorStateList colorStateList = (!a() || (mVar = this.f686g) == null) ? null : mVar.f692c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f688i.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f688i.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f687h && super.mutate() == this) {
            this.f686g = b();
            Drawable drawable = this.f688i;
            if (drawable != null) {
                drawable.mutate();
            }
            m mVar = this.f686g;
            if (mVar != null) {
                Drawable drawable2 = this.f688i;
                mVar.f691b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f687h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f688i;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return a.d(this.f688i, i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        return this.f688i.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f688i.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z3) {
        a.c(this.f688i, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        this.f688i.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f688i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z3) {
        this.f688i.setDither(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f688i.setFilterBitmap(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return e(iArr) || this.f688i.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f686g.f692c = colorStateList;
        e(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f686g.f693d = mode;
        e(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        return super.setVisible(z3, z4) || this.f688i.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
