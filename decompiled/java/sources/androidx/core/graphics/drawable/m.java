package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: /root/release/classes.dex */
final class m extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f690a;

    /* renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f691b;

    /* renamed from: c, reason: collision with root package name */
    ColorStateList f692c;

    /* renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f693d;

    m(m mVar) {
        this.f692c = null;
        this.f693d = k.f682j;
        if (mVar != null) {
            this.f690a = mVar.f690a;
            this.f691b = mVar.f691b;
            this.f692c = mVar.f692c;
            this.f693d = mVar.f693d;
        }
    }

    boolean a() {
        return this.f691b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i3 = this.f690a;
        Drawable.ConstantState constantState = this.f691b;
        return i3 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new l(this, resources);
    }
}
