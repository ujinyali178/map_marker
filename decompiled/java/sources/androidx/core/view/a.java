package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCutout f765a;

    /* renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static class C0017a {
        static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    private a(DisplayCutout displayCutout) {
        this.f765a = displayCutout;
    }

    static a e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new a(displayCutout);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0017a.c(this.f765a);
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0017a.d(this.f765a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0017a.e(this.f765a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0017a.f(this.f765a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return androidx.core.util.b.a(this.f765a, ((a) obj).f765a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f765a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f765a + "}";
    }
}
