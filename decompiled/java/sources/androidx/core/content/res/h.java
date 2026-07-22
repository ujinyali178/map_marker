package androidx.core.content.res;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
final class h {

    /* renamed from: k, reason: collision with root package name */
    static final h f650k = k(b.f639c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f651a;

    /* renamed from: b, reason: collision with root package name */
    private final float f652b;

    /* renamed from: c, reason: collision with root package name */
    private final float f653c;

    /* renamed from: d, reason: collision with root package name */
    private final float f654d;

    /* renamed from: e, reason: collision with root package name */
    private final float f655e;

    /* renamed from: f, reason: collision with root package name */
    private final float f656f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f657g;

    /* renamed from: h, reason: collision with root package name */
    private final float f658h;

    /* renamed from: i, reason: collision with root package name */
    private final float f659i;

    /* renamed from: j, reason: collision with root package name */
    private final float f660j;

    private h(float f3, float f4, float f5, float f6, float f7, float f8, float[] fArr, float f9, float f10, float f11) {
        this.f656f = f3;
        this.f651a = f4;
        this.f652b = f5;
        this.f653c = f6;
        this.f654d = f7;
        this.f655e = f8;
        this.f657g = fArr;
        this.f658h = f9;
        this.f659i = f10;
        this.f660j = f11;
    }

    static h k(float[] fArr, float f3, float f4, float f5, boolean z3) {
        float[][] fArr2 = b.f637a;
        float f6 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f7 = fArr3[0] * f6;
        float f8 = fArr[1];
        float f9 = f7 + (fArr3[1] * f8);
        float f10 = fArr[2];
        float f11 = f9 + (fArr3[2] * f10);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[0] * f6) + (fArr4[1] * f8) + (fArr4[2] * f10);
        float[] fArr5 = fArr2[2];
        float f13 = (f6 * fArr5[0]) + (f8 * fArr5[1]) + (f10 * fArr5[2]);
        float f14 = (f5 / 10.0f) + 0.8f;
        float d3 = ((double) f14) >= 0.9d ? b.d(0.59f, 0.69f, (f14 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f14 - 0.8f) * 10.0f);
        float exp = z3 ? 1.0f : (1.0f - (((float) Math.exp(((-f3) - 42.0f) / 92.0f)) * 0.2777778f)) * f14;
        double d4 = exp;
        if (d4 > 1.0d) {
            exp = 1.0f;
        } else if (d4 < 0.0d) {
            exp = BitmapDescriptorFactory.HUE_RED;
        }
        float[] fArr6 = {(((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp, (((100.0f / f13) * exp) + 1.0f) - exp};
        float f15 = 1.0f / ((5.0f * f3) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float cbrt = (f16 * f3) + (0.1f * f17 * f17 * ((float) Math.cbrt(f3 * 5.0d)));
        float h3 = b.h(f4) / fArr[1];
        double d5 = h3;
        float sqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d5, 0.2d));
        float pow2 = (float) Math.pow(((fArr6[2] * cbrt) * f13) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f12) / 100.0d, 0.42d), pow2};
        float f18 = fArr7[0];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[1];
        return new h(h3, ((f19 * 2.0f) + ((f20 * 400.0f) / (f20 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, d3, f14, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    float a() {
        return this.f651a;
    }

    float b() {
        return this.f654d;
    }

    float c() {
        return this.f658h;
    }

    float d() {
        return this.f659i;
    }

    float e() {
        return this.f656f;
    }

    float f() {
        return this.f652b;
    }

    float g() {
        return this.f655e;
    }

    float h() {
        return this.f653c;
    }

    float[] i() {
        return this.f657g;
    }

    float j() {
        return this.f660j;
    }
}
