package io.flutter.embedding.android;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static final Matrix f2725f = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    private final FlutterRenderer f2726a;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2728c;

    /* renamed from: e, reason: collision with root package name */
    private int f2730e;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, float[]> f2729d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final f0 f2727b = f0.a();

    public c(FlutterRenderer flutterRenderer, boolean z3) {
        this.f2726a = flutterRenderer;
        this.f2728c = z3;
    }

    private void a(MotionEvent motionEvent, int i3, int i4, int i5, Matrix matrix, ByteBuffer byteBuffer) {
        b(motionEvent, i3, i4, i5, matrix, byteBuffer, null);
    }

    private void b(MotionEvent motionEvent, int i3, int i4, int i5, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        long j3;
        long j4;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        InputDevice.MotionRange motionRange;
        int i6 = -1;
        if (i4 == -1) {
            return;
        }
        int pointerId = motionEvent.getPointerId(i3);
        int f3 = f(motionEvent.getToolType(i3));
        float[] fArr = {motionEvent.getX(i3), motionEvent.getY(i3)};
        matrix.mapPoints(fArr);
        if (f3 == 1) {
            j3 = motionEvent.getButtonState() & 31;
            if (j3 == 0 && motionEvent.getSource() == 8194 && i4 == 4) {
                this.f2729d.put(Integer.valueOf(pointerId), fArr);
            }
        } else {
            j3 = f3 == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.f2729d.containsKey(Integer.valueOf(pointerId));
        if (containsKey) {
            int e3 = e(i4);
            if (e3 == -1) {
                return;
            } else {
                i6 = e3;
            }
        }
        long d9 = this.f2728c ? this.f2727b.c(motionEvent).d() : 0L;
        int i7 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        int i8 = i6;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(d9);
        byteBuffer.putLong(eventTime);
        if (containsKey) {
            byteBuffer.putLong(i8);
            j4 = 4;
        } else {
            byteBuffer.putLong(i4);
            j4 = f3;
        }
        byteBuffer.putLong(j4);
        byteBuffer.putLong(i7);
        byteBuffer.putLong(pointerId);
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr2 = this.f2729d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr2[0]);
            d3 = fArr2[1];
        } else {
            byteBuffer.putDouble(fArr[0]);
            d3 = fArr[1];
        }
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(j3);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i3));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d4 = 1.0d;
            d5 = 0.0d;
        } else {
            d5 = motionRange.getMin();
            d4 = motionRange.getMax();
        }
        byteBuffer.putDouble(d5);
        byteBuffer.putDouble(d4);
        if (f3 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i3));
            d6 = 0.0d;
        } else {
            d6 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d6);
        byteBuffer.putDouble(motionEvent.getSize(i3));
        byteBuffer.putDouble(motionEvent.getToolMajor(i3));
        byteBuffer.putDouble(motionEvent.getToolMinor(i3));
        byteBuffer.putDouble(d6);
        byteBuffer.putDouble(d6);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i3));
        if (f3 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i3));
        } else {
            byteBuffer.putDouble(d6);
        }
        byteBuffer.putLong(i5);
        if (i7 == 1) {
            double d10 = 48.0d;
            if (context != null) {
                d10 = c(context);
                d8 = g(context);
            } else {
                d8 = 48.0d;
            }
            byteBuffer.putDouble(d10 * (-motionEvent.getAxisValue(10, i3)));
            byteBuffer.putDouble(d8 * (-motionEvent.getAxisValue(9, i3)));
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        if (containsKey) {
            float[] fArr3 = this.f2729d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d7 = 0.0d;
        } else {
            d7 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d7);
        byteBuffer.putDouble(d7);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d7);
        byteBuffer.putLong(0L);
        if (containsKey && i8 == 9) {
            this.f2729d.remove(Integer.valueOf(pointerId));
        }
    }

    private float c(Context context) {
        float scaledHorizontalScrollFactor;
        if (Build.VERSION.SDK_INT < 26) {
            return i(context);
        }
        scaledHorizontalScrollFactor = ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
        return scaledHorizontalScrollFactor;
    }

    private int d(int i3) {
        if (i3 == 0) {
            return 4;
        }
        if (i3 == 1) {
            return 6;
        }
        if (i3 == 5) {
            return 4;
        }
        if (i3 == 6) {
            return 6;
        }
        if (i3 == 2) {
            return 5;
        }
        if (i3 == 7) {
            return 3;
        }
        if (i3 == 3) {
            return 0;
        }
        return i3 == 8 ? 3 : -1;
    }

    private int e(int i3) {
        if (i3 == 4) {
            return 7;
        }
        if (i3 == 5) {
            return 8;
        }
        return (i3 == 6 || i3 == 0) ? 9 : -1;
    }

    private int f(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return i3 != 4 ? 5 : 3;
        }
        return 1;
    }

    private float g(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? h(context) : i(context);
    }

    private float h(Context context) {
        float scaledVerticalScrollFactor;
        scaledVerticalScrollFactor = ViewConfiguration.get(context).getScaledVerticalScrollFactor();
        return scaledVerticalScrollFactor;
    }

    private int i(Context context) {
        if (this.f2730e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.f2730e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f2730e;
    }

    public boolean j(MotionEvent motionEvent, Context context) {
        boolean isFromSource = motionEvent.isFromSource(2);
        boolean z3 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!isFromSource || !z3) {
            return false;
        }
        int d3 = d(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 36 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        b(motionEvent, motionEvent.getActionIndex(), d3, 0, f2725f, allocateDirect, context);
        if (allocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f2726a.l(allocateDirect, allocateDirect.position());
        return true;
    }

    public boolean k(MotionEvent motionEvent) {
        return l(motionEvent, f2725f);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 36
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.d(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L27
            r4 = 5
            if (r2 != r4) goto L25
            goto L27
        L25:
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 != 0) goto L31
            if (r2 == r10) goto L2f
            r5 = 6
            if (r2 != r5) goto L31
        L2f:
            r2 = 1
            goto L32
        L31:
            r2 = 0
        L32:
            if (r4 == 0) goto L42
        L34:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L6f
        L42:
            r11 = 0
            if (r2 == 0) goto L60
        L45:
            if (r11 >= r0) goto L34
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L5d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L5d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
        L5d:
            int r11 = r11 + 1
            goto L45
        L60:
            if (r11 >= r0) goto L6f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L60
        L6f:
            int r13 = r1.position()
            int r13 = r13 % 288
            if (r13 != 0) goto L81
            io.flutter.embedding.engine.renderer.FlutterRenderer r13 = r12.f2726a
            int r14 = r1.position()
            r13.l(r1, r14)
            return r10
        L81:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.c.l(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}
