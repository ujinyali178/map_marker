package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f678a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f679b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f680c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f681d;

    /* renamed from: androidx.core.graphics.drawable.a$a, reason: collision with other inner class name */
    static class C0013a {
        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i3) {
            return drawableContainerState.getChild(i3);
        }

        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static void e(Drawable drawable, boolean z3) {
            drawable.setAutoMirrored(z3);
        }
    }

    static class b {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f3, float f4) {
            drawable.setHotspot(f3, f4);
        }

        static void f(Drawable drawable, int i3, int i4, int i5, int i6) {
            drawable.setHotspotBounds(i3, i4, i5, i6);
        }

        static void g(Drawable drawable, int i3) {
            drawable.setTint(i3);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class c {
        static int a(Drawable drawable) {
            int layoutDirection;
            layoutDirection = drawable.getLayoutDirection();
            return layoutDirection;
        }

        static boolean b(Drawable drawable, int i3) {
            boolean layoutDirection;
            layoutDirection = drawable.setLayoutDirection(i3);
            return layoutDirection;
        }
    }

    public static int a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.a(drawable);
        }
        if (!f681d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f680c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e3) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e3);
            }
            f681d = true;
        }
        Method method = f680c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e4) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e4);
                f680c = null;
            }
        }
        return 0;
    }

    public static boolean b(Drawable drawable) {
        return C0013a.d(drawable);
    }

    public static void c(Drawable drawable, boolean z3) {
        C0013a.e(drawable, z3);
    }

    public static boolean d(Drawable drawable, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.b(drawable, i3);
        }
        if (!f679b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f678a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e3) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e3);
            }
            f679b = true;
        }
        Method method = f678a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i3));
                return true;
            } catch (Exception e4) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e4);
                f678a = null;
            }
        }
        return false;
    }

    public static void e(Drawable drawable, ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void f(Drawable drawable, PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    public static Drawable g(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof j)) ? new l(drawable) : drawable;
    }
}
