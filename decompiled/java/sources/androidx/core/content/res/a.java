package androidx.core.content.res;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final float f628a;

    /* renamed from: b, reason: collision with root package name */
    private final float f629b;

    /* renamed from: c, reason: collision with root package name */
    private final float f630c;

    /* renamed from: d, reason: collision with root package name */
    private final float f631d;

    /* renamed from: e, reason: collision with root package name */
    private final float f632e;

    /* renamed from: f, reason: collision with root package name */
    private final float f633f;

    /* renamed from: g, reason: collision with root package name */
    private final float f634g;

    /* renamed from: h, reason: collision with root package name */
    private final float f635h;

    /* renamed from: i, reason: collision with root package name */
    private final float f636i;

    a(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.f628a = f3;
        this.f629b = f4;
        this.f630c = f5;
        this.f631d = f6;
        this.f632e = f7;
        this.f633f = f8;
        this.f634g = f9;
        this.f635h = f10;
        this.f636i = f11;
    }

    private static a b(float f3, float f4, float f5) {
        float f6 = 1000.0f;
        a aVar = null;
        float f7 = 1000.0f;
        float f8 = 100.0f;
        float f9 = BitmapDescriptorFactory.HUE_RED;
        while (Math.abs(f9 - f8) > 0.01f) {
            float f10 = ((f8 - f9) / 2.0f) + f9;
            int p3 = e(f10, f4, f3).p();
            float b4 = b.b(p3);
            float abs = Math.abs(f5 - b4);
            if (abs < 0.2f) {
                a c3 = c(p3);
                float a4 = c3.a(e(c3.k(), c3.i(), f3));
                if (a4 <= 1.0f) {
                    aVar = c3;
                    f6 = abs;
                    f7 = a4;
                }
            }
            if (f6 == BitmapDescriptorFactory.HUE_RED && f7 == BitmapDescriptorFactory.HUE_RED) {
                break;
            }
            if (b4 < f5) {
                f9 = f10;
            } else {
                f8 = f10;
            }
        }
        return aVar;
    }

    static a c(int i3) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i3, h.f650k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i3, h hVar, float[] fArr, float[] fArr2) {
        b.f(i3, fArr2);
        float[][] fArr3 = b.f637a;
        float f3 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f4 = fArr4[0] * f3;
        float f5 = fArr2[1];
        float f6 = f4 + (fArr4[1] * f5);
        float f7 = fArr2[2];
        float f8 = f6 + (fArr4[2] * f7);
        float[] fArr5 = fArr3[1];
        float f9 = (fArr5[0] * f3) + (fArr5[1] * f5) + (fArr5[2] * f7);
        float[] fArr6 = fArr3[2];
        float f10 = (f3 * fArr6[0]) + (f5 * fArr6[1]) + (f7 * fArr6[2]);
        float f11 = hVar.i()[0] * f8;
        float f12 = hVar.i()[1] * f9;
        float f13 = hVar.i()[2] * f10;
        float pow = (float) Math.pow((hVar.c() * Math.abs(f11)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((hVar.c() * Math.abs(f12)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((hVar.c() * Math.abs(f13)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f11) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f12) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f13) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d3 = signum3;
        float f14 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d3)) / 11.0f;
        float f15 = ((float) ((signum + signum2) - (d3 * 2.0d))) / 9.0f;
        float f16 = signum2 * 20.0f;
        float f17 = (((signum * 20.0f) + f16) + (21.0f * signum3)) / 20.0f;
        float f18 = (((signum * 40.0f) + f16) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f15, f14)) * 180.0f) / 3.1415927f;
        if (atan2 < BitmapDescriptorFactory.HUE_RED) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f19 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f18 * hVar.f()) / hVar.a(), hVar.b() * hVar.j())) * 100.0f;
        float b4 = (4.0f / hVar.b()) * ((float) Math.sqrt(pow4 / 100.0f)) * (hVar.a() + 4.0f) * hVar.d();
        float f20 = atan2;
        float sqrt = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, hVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * hVar.g()) * hVar.h()) * ((float) Math.sqrt((f14 * f14) + (f15 * f15)))) / (f17 + 0.305f), 0.9d));
        float d4 = hVar.d() * sqrt;
        float sqrt2 = ((float) Math.sqrt((r2 * hVar.b()) / (hVar.a() + 4.0f))) * 50.0f;
        float f21 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * d4) + 1.0f)) * 43.85965f;
        double d5 = f19;
        float cos = ((float) Math.cos(d5)) * log;
        float sin = log * ((float) Math.sin(d5));
        fArr2[0] = f20;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = b4;
            fArr[2] = d4;
            fArr[3] = sqrt2;
            fArr[4] = f21;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    private static a e(float f3, float f4, float f5) {
        return f(f3, f4, f5, h.f650k);
    }

    private static a f(float f3, float f4, float f5, h hVar) {
        float b4 = (4.0f / hVar.b()) * ((float) Math.sqrt(f3 / 100.0d)) * (hVar.a() + 4.0f) * hVar.d();
        float d3 = f4 * hVar.d();
        float sqrt = ((float) Math.sqrt(((f4 / ((float) Math.sqrt(r4))) * hVar.b()) / (hVar.a() + 4.0f))) * 50.0f;
        float f6 = (1.7f * f3) / ((0.007f * f3) + 1.0f);
        float log = ((float) Math.log((d3 * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (3.1415927f * f5) / 180.0f;
        return new a(f5, f4, f3, b4, d3, sqrt, f6, log * ((float) Math.cos(d4)), log * ((float) Math.sin(d4)));
    }

    public static int m(float f3, float f4, float f5) {
        return n(f3, f4, f5, h.f650k);
    }

    static int n(float f3, float f4, float f5, h hVar) {
        if (f4 < 1.0d || Math.round(f5) <= 0.0d || Math.round(f5) >= 100.0d) {
            return b.a(f5);
        }
        float min = f3 < BitmapDescriptorFactory.HUE_RED ? BitmapDescriptorFactory.HUE_RED : Math.min(360.0f, f3);
        float f6 = f4;
        a aVar = null;
        float f7 = BitmapDescriptorFactory.HUE_RED;
        boolean z3 = true;
        while (Math.abs(f7 - f4) >= 0.4f) {
            a b4 = b(min, f6, f5);
            if (z3) {
                if (b4 != null) {
                    return b4.o(hVar);
                }
                z3 = false;
            } else if (b4 == null) {
                f4 = f6;
            } else {
                f7 = f6;
                aVar = b4;
            }
            f6 = ((f4 - f7) / 2.0f) + f7;
        }
        return aVar == null ? b.a(f5) : aVar.o(hVar);
    }

    float a(a aVar) {
        float l3 = l() - aVar.l();
        float g3 = g() - aVar.g();
        float h3 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((l3 * l3) + (g3 * g3) + (h3 * h3)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f635h;
    }

    float h() {
        return this.f636i;
    }

    float i() {
        return this.f629b;
    }

    float j() {
        return this.f628a;
    }

    float k() {
        return this.f630c;
    }

    float l() {
        return this.f634g;
    }

    int o(h hVar) {
        float pow = (float) Math.pow(((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? BitmapDescriptorFactory.HUE_RED : i() / ((float) Math.sqrt(k() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, hVar.e()), 0.73d), 1.1111111111111112d);
        double j3 = (j() * 3.1415927f) / 180.0f;
        float cos = ((float) (Math.cos(2.0d + j3) + 3.8d)) * 0.25f;
        float a4 = hVar.a() * ((float) Math.pow(k() / 100.0d, (1.0d / hVar.b()) / hVar.j()));
        float g3 = cos * 3846.1538f * hVar.g() * hVar.h();
        float f3 = a4 / hVar.f();
        float sin = (float) Math.sin(j3);
        float cos2 = (float) Math.cos(j3);
        float f4 = (((0.305f + f3) * 23.0f) * pow) / (((g3 * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f5 = cos2 * f4;
        float f6 = f4 * sin;
        float f7 = f3 * 460.0f;
        float f8 = (((451.0f * f5) + f7) + (288.0f * f6)) / 1403.0f;
        float f9 = ((f7 - (891.0f * f5)) - (261.0f * f6)) / 1403.0f;
        float signum = Math.signum(f8) * (100.0f / hVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f8) * 27.13d) / (400.0d - Math.abs(f8))), 2.380952380952381d));
        float signum2 = Math.signum(f9) * (100.0f / hVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f9) * 27.13d) / (400.0d - Math.abs(f9))), 2.380952380952381d));
        float signum3 = Math.signum(((f7 - (f5 * 220.0f)) - (f6 * 6300.0f)) / 1403.0f) * (100.0f / hVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r6) * 27.13d) / (400.0d - Math.abs(r6))), 2.380952380952381d));
        float f10 = signum / hVar.i()[0];
        float f11 = signum2 / hVar.i()[1];
        float f12 = signum3 / hVar.i()[2];
        float[][] fArr = b.f638b;
        float[] fArr2 = fArr[0];
        float f13 = (fArr2[0] * f10) + (fArr2[1] * f11) + (fArr2[2] * f12);
        float[] fArr3 = fArr[1];
        float f14 = (fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12);
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.a(f13, f14, (f10 * fArr4[0]) + (f11 * fArr4[1]) + (f12 * fArr4[2]));
    }

    int p() {
        return o(h.f650k);
    }
}
