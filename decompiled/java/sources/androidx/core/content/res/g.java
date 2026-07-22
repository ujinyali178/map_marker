package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* loaded from: /root/release/classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f642a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<c, SparseArray<b>> f643b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f644c = new Object();

    static class a {
        static int a(Resources resources, int i3, Resources.Theme theme) {
            int color;
            color = resources.getColor(i3, theme);
            return color;
        }

        static ColorStateList b(Resources resources, int i3, Resources.Theme theme) {
            ColorStateList colorStateList;
            colorStateList = resources.getColorStateList(i3, theme);
            return colorStateList;
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final ColorStateList f645a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f646b;

        /* renamed from: c, reason: collision with root package name */
        final int f647c;

        b(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f645a = colorStateList;
            this.f646b = configuration;
            this.f647c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        final Resources f648a;

        /* renamed from: b, reason: collision with root package name */
        final Resources.Theme f649b;

        c(Resources resources, Resources.Theme theme) {
            this.f648a = resources;
            this.f649b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f648a.equals(cVar.f648a) && androidx.core.util.b.a(this.f649b, cVar.f649b);
        }

        public int hashCode() {
            return androidx.core.util.b.b(this.f648a, this.f649b);
        }
    }

    private static void a(c cVar, int i3, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f644c) {
            WeakHashMap<c, SparseArray<b>> weakHashMap = f643b;
            SparseArray<b> sparseArray = weakHashMap.get(cVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(cVar, sparseArray);
            }
            sparseArray.append(i3, new b(colorStateList, cVar.f648a.getConfiguration(), theme));
        }
    }

    private static ColorStateList b(c cVar, int i3) {
        b bVar;
        Resources.Theme theme;
        synchronized (f644c) {
            SparseArray<b> sparseArray = f643b.get(cVar);
            if (sparseArray != null && sparseArray.size() > 0 && (bVar = sparseArray.get(i3)) != null) {
                if (bVar.f646b.equals(cVar.f648a.getConfiguration()) && (((theme = cVar.f649b) == null && bVar.f647c == 0) || (theme != null && bVar.f647c == theme.hashCode()))) {
                    return bVar.f645a;
                }
                sparseArray.remove(i3);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i3, Resources.Theme theme) {
        c cVar = new c(resources, theme);
        ColorStateList b4 = b(cVar, i3);
        if (b4 != null) {
            return b4;
        }
        ColorStateList e3 = e(resources, i3, theme);
        if (e3 == null) {
            return Build.VERSION.SDK_INT >= 23 ? a.b(resources, i3, theme) : resources.getColorStateList(i3);
        }
        a(cVar, i3, e3, theme);
        return e3;
    }

    private static TypedValue d() {
        ThreadLocal<TypedValue> threadLocal = f642a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList e(Resources resources, int i3, Resources.Theme theme) {
        if (f(resources, i3)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i3), theme);
        } catch (Exception e3) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e3);
            return null;
        }
    }

    private static boolean f(Resources resources, int i3) {
        TypedValue d3 = d();
        resources.getValue(i3, d3, true);
        int i4 = d3.type;
        return i4 >= 28 && i4 <= 31;
    }
}
