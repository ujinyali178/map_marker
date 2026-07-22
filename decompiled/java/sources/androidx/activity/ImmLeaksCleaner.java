package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.e;
import java.lang.reflect.Field;

/* loaded from: /root/release/classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.g {

    /* renamed from: d, reason: collision with root package name */
    private static int f256d;

    /* renamed from: f, reason: collision with root package name */
    private static Field f257f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f258g;

    /* renamed from: h, reason: collision with root package name */
    private static Field f259h;

    /* renamed from: c, reason: collision with root package name */
    private Activity f260c;

    ImmLeaksCleaner(Activity activity) {
        this.f260c = activity;
    }

    private static void a() {
        try {
            f256d = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f258g = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f259h = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f257f = declaredField3;
            declaredField3.setAccessible(true);
            f256d = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.g
    public void e(androidx.lifecycle.i iVar, e.a aVar) {
        if (aVar != e.a.ON_DESTROY) {
            return;
        }
        if (f256d == 0) {
            a();
        }
        if (f256d == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f260c.getSystemService("input_method");
            try {
                Object obj = f257f.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f258g.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f259h.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
