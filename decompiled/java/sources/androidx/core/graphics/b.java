package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: /root/release/classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f662e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f663a;

    /* renamed from: b, reason: collision with root package name */
    public final int f664b;

    /* renamed from: c, reason: collision with root package name */
    public final int f665c;

    /* renamed from: d, reason: collision with root package name */
    public final int f666d;

    static class a {
        static Insets a(int i3, int i4, int i5, int i6) {
            return Insets.of(i3, i4, i5, i6);
        }
    }

    private b(int i3, int i4, int i5, int i6) {
        this.f663a = i3;
        this.f664b = i4;
        this.f665c = i5;
        this.f666d = i6;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f663a, bVar2.f663a), Math.max(bVar.f664b, bVar2.f664b), Math.max(bVar.f665c, bVar2.f665c), Math.max(bVar.f666d, bVar2.f666d));
    }

    public static b b(int i3, int i4, int i5, int i6) {
        return (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f662e : new b(i3, i4, i5, i6);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f663a, this.f664b, this.f665c, this.f666d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f666d == bVar.f666d && this.f663a == bVar.f663a && this.f665c == bVar.f665c && this.f664b == bVar.f664b;
    }

    public int hashCode() {
        return (((((this.f663a * 31) + this.f664b) * 31) + this.f665c) * 31) + this.f666d;
    }

    public String toString() {
        return "Insets{left=" + this.f663a + ", top=" + this.f664b + ", right=" + this.f665c + ", bottom=" + this.f666d + '}';
    }
}
