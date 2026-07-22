package w0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import m1.a;
import org.kxml2.wap.Wbxml;
import u1.e;

/* loaded from: /root/release/classes.dex */
public final class a implements m1.a, e.d {

    /* renamed from: c, reason: collision with root package name */
    private SensorEventListener f4419c;

    /* renamed from: d, reason: collision with root package name */
    private Display f4420d;

    /* renamed from: f, reason: collision with root package name */
    private SensorManager f4421f;

    /* renamed from: g, reason: collision with root package name */
    private Sensor f4422g;

    /* renamed from: h, reason: collision with root package name */
    private Sensor f4423h;

    /* renamed from: i, reason: collision with root package name */
    private Sensor f4424i;

    /* renamed from: l, reason: collision with root package name */
    private float[] f4427l;

    /* renamed from: m, reason: collision with root package name */
    private float f4428m;

    /* renamed from: n, reason: collision with root package name */
    private int f4429n;

    /* renamed from: o, reason: collision with root package name */
    private long f4430o;

    /* renamed from: r, reason: collision with root package name */
    private e f4433r;

    /* renamed from: j, reason: collision with root package name */
    private float[] f4425j = new float[4];

    /* renamed from: k, reason: collision with root package name */
    private float[] f4426k = new float[9];

    /* renamed from: p, reason: collision with root package name */
    private float[] f4431p = new float[3];

    /* renamed from: q, reason: collision with root package name */
    private float[] f4432q = new float[3];

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    class C0109a implements SensorEventListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.b f4434a;

        C0109a(e.b bVar) {
            this.f4434a = bVar;
        }

        private double a() {
            if (a.this.f4429n == 3) {
                return 15.0d;
            }
            if (a.this.f4429n == 2) {
                return 30.0d;
            }
            return a.this.f4429n == 1 ? 45.0d : -1.0d;
        }

        private float[] b(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            if (fArr.length <= 4) {
                return fArr;
            }
            System.arraycopy(fArr, 0, a.this.f4425j, 0, 4);
            return a.this.f4425j;
        }

        private float[] c(float[] fArr, float[] fArr2) {
            if (fArr2 == null) {
                return fArr;
            }
            for (int i3 = 0; i3 < fArr.length; i3++) {
                float f3 = fArr2[i3];
                fArr2[i3] = f3 + ((fArr[i3] - f3) * 0.45f);
            }
            return fArr2;
        }

        private void d(double[] dArr) {
            this.f4434a.a(dArr);
            a.this.f4428m = (float) dArr[0];
        }

        private void e() {
            int i3;
            int i4;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < a.this.f4430o) {
                return;
            }
            if (a.this.f4427l != null) {
                SensorManager.getRotationMatrixFromVector(a.this.f4426k, a.this.f4427l);
            } else {
                SensorManager.getRotationMatrix(a.this.f4426k, null, a.this.f4431p, a.this.f4432q);
            }
            int rotation = a.this.f4420d.getRotation();
            int i5 = Wbxml.EXT_T_2;
            int i6 = Wbxml.EXT_T_1;
            if (rotation == 1) {
                i3 = 2;
                i4 = Wbxml.EXT_T_1;
            } else if (rotation == 2) {
                i3 = Wbxml.EXT_T_1;
                i4 = Wbxml.EXT_T_2;
            } else if (rotation != 3) {
                i3 = 1;
                i4 = 2;
            } else {
                i3 = Wbxml.EXT_T_2;
                i4 = 1;
            }
            float[] fArr = new float[9];
            SensorManager.remapCoordinateSystem(a.this.f4426k, i3, i4, fArr);
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            float f3 = fArr2[1];
            if (f3 < -0.7853981633974483d) {
                int rotation2 = a.this.f4420d.getRotation();
                if (rotation2 == 1) {
                    i5 = 3;
                } else if (rotation2 == 2) {
                    i5 = Wbxml.EXT_T_1;
                    i6 = Wbxml.STR_T;
                } else if (rotation2 != 3) {
                    i5 = 1;
                    i6 = 3;
                } else {
                    i5 = Wbxml.STR_T;
                    i6 = 1;
                }
            } else if (f3 > 0.7853981633974483d) {
                int rotation3 = a.this.f4420d.getRotation();
                if (rotation3 == 1) {
                    i5 = Wbxml.STR_T;
                } else if (rotation3 == 2) {
                    i5 = Wbxml.EXT_T_1;
                    i6 = 3;
                } else if (rotation3 != 3) {
                    i5 = 1;
                    i6 = Wbxml.STR_T;
                } else {
                    i5 = 3;
                    i6 = 1;
                }
            } else if (Math.abs(fArr2[2]) > 1.5707963267948966d) {
                int rotation4 = a.this.f4420d.getRotation();
                if (rotation4 != 1) {
                    if (rotation4 == 2) {
                        i5 = Wbxml.EXT_T_1;
                        i6 = 2;
                    } else if (rotation4 != 3) {
                        i5 = 1;
                        i6 = Wbxml.EXT_T_2;
                    } else {
                        i5 = 2;
                        i6 = 1;
                    }
                }
            } else {
                i5 = i3;
                i6 = i4;
            }
            SensorManager.remapCoordinateSystem(a.this.f4426k, i5, i6, fArr);
            SensorManager.getOrientation(fArr, fArr2);
            d(new double[]{Math.toDegrees(fArr2[0]), 0.0d, a()});
            a.this.f4430o = elapsedRealtime + 32;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            if (a.this.f4429n != i3) {
                a.this.f4429n = i3;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (a.this.f4429n == 0) {
                Log.d("FlutterCompass", "Compass sensor is unreliable, device calibration is needed.");
            }
            if (sensorEvent.sensor.getType() == 11) {
                a.this.f4427l = b(sensorEvent);
            } else if (sensorEvent.sensor.getType() == 1 && !a.this.w()) {
                a.this.f4431p = c(b(sensorEvent), a.this.f4431p);
            } else {
                if (sensorEvent.sensor.getType() != 2 || a.this.w()) {
                    return;
                }
                a.this.f4432q = c(b(sensorEvent), a.this.f4432q);
            }
            e();
        }
    }

    private void t() {
        this.f4421f = null;
        this.f4420d = null;
        this.f4422g = null;
        this.f4423h = null;
        this.f4424i = null;
    }

    private void v(Context context) {
        this.f4420d = ((DisplayManager) context.getSystemService("display")).getDisplay(0);
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f4421f = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        this.f4422g = defaultSensor;
        if (defaultSensor == null) {
            Log.d("FlutterCompass", "Rotation vector sensor not supported on device, falling back to accelerometer and magnetic field.");
        }
        this.f4423h = this.f4421f.getDefaultSensor(1);
        this.f4424i = this.f4421f.getDefaultSensor(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return this.f4422g != null;
    }

    private void x() {
        if (this.f4421f == null) {
            return;
        }
        if (w()) {
            this.f4421f.registerListener(this.f4419c, this.f4422g, 30000);
        }
        this.f4421f.registerListener(this.f4419c, this.f4423h, 30000);
        this.f4421f.registerListener(this.f4419c, this.f4424i, 30000);
    }

    private void y() {
        if (this.f4421f == null) {
            return;
        }
        if (w()) {
            this.f4421f.unregisterListener(this.f4419c, this.f4422g);
        }
        this.f4421f.unregisterListener(this.f4419c, this.f4423h);
        this.f4421f.unregisterListener(this.f4419c, this.f4424i);
    }

    @Override // u1.e.d
    public void a(Object obj) {
        y();
    }

    @Override // m1.a
    public void b(a.b bVar) {
        this.f4433r = new e(bVar.b(), "hemanthraj/flutter_compass");
        v(bVar.a());
        this.f4433r.d(this);
    }

    @Override // u1.e.d
    public void c(Object obj, e.b bVar) {
        this.f4419c = u(bVar);
        x();
    }

    @Override // m1.a
    public void e(a.b bVar) {
        y();
        t();
        e eVar = this.f4433r;
        if (eVar != null) {
            eVar.d(null);
        }
    }

    SensorEventListener u(e.b bVar) {
        return new C0109a(bVar);
    }
}
