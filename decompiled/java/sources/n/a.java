package n;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f3963f;

    /* renamed from: g, reason: collision with root package name */
    private static final FloatBuffer f3964g;

    /* renamed from: a, reason: collision with root package name */
    private final float[] f3965a;

    /* renamed from: b, reason: collision with root package name */
    private final FloatBuffer f3966b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3967c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3968d;

    /* renamed from: e, reason: collision with root package name */
    private g f3969e;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f3963f = fArr;
        f3964g = b(fArr);
    }

    public a(g gVar, int i3, int i4) {
        float[] fArr = new float[8];
        this.f3965a = fArr;
        this.f3966b = b(fArr);
        this.f3969e = gVar;
        this.f3967c = i3;
        this.f3968d = i4;
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public void a(int i3, float[] fArr, Rect rect) {
        f(rect);
        this.f3969e.e(g.f4044h, f3964g, 0, 4, 2, 8, fArr, this.f3966b, i3, 8);
    }

    public int c() {
        return this.f3969e.d();
    }

    public void d(int i3, Bitmap bitmap) {
        this.f3969e.g(i3, bitmap);
    }

    public void e(boolean z3) {
        g gVar = this.f3969e;
        if (gVar != null) {
            if (z3) {
                gVar.h();
            }
            this.f3969e = null;
        }
    }

    void f(Rect rect) {
        float[] fArr = this.f3965a;
        int i3 = rect.left;
        int i4 = this.f3967c;
        fArr[0] = i3 / i4;
        int i5 = rect.bottom;
        int i6 = this.f3968d;
        fArr[1] = 1.0f - (i5 / i6);
        int i7 = rect.right;
        fArr[2] = i7 / i4;
        fArr[3] = 1.0f - (i5 / i6);
        fArr[4] = i3 / i4;
        int i8 = rect.top;
        fArr[5] = 1.0f - (i8 / i6);
        fArr[6] = i7 / i4;
        fArr[7] = 1.0f - (i8 / i6);
        this.f3966b.put(fArr);
        this.f3966b.position(0);
    }
}
