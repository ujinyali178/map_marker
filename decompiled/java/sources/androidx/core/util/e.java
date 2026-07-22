package androidx.core.util;

/* loaded from: /root/release/classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final float f761a;

    /* renamed from: b, reason: collision with root package name */
    private final float f762b;

    public e(float f3, float f4) {
        this.f761a = d.b(f3, "width");
        this.f762b = d.b(f4, "height");
    }

    public float a() {
        return this.f762b;
    }

    public float b() {
        return this.f761a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.f761a == this.f761a && eVar.f762b == this.f762b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f761a) ^ Float.floatToIntBits(this.f762b);
    }

    public String toString() {
        return this.f761a + "x" + this.f762b;
    }
}
