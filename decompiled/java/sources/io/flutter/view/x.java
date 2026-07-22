package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* loaded from: /root/release/classes.dex */
public class x {

    /* renamed from: e, reason: collision with root package name */
    private static x f3673e;

    /* renamed from: f, reason: collision with root package name */
    private static b f3674f;

    /* renamed from: b, reason: collision with root package name */
    private FlutterJNI f3676b;

    /* renamed from: a, reason: collision with root package name */
    private long f3675a = -1;

    /* renamed from: c, reason: collision with root package name */
    private c f3677c = new c(0);

    /* renamed from: d, reason: collision with root package name */
    private final FlutterJNI.b f3678d = new a();

    class a implements FlutterJNI.b {
        a() {
        }

        private Choreographer.FrameCallback b(long j3) {
            if (x.this.f3677c == null) {
                return x.this.new c(j3);
            }
            x.this.f3677c.f3682a = j3;
            c cVar = x.this.f3677c;
            x.this.f3677c = null;
            return cVar;
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j3) {
            Choreographer.getInstance().postFrameCallback(b(j3));
        }
    }

    class b implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        private DisplayManager f3680a;

        b(DisplayManager displayManager) {
            this.f3680a = displayManager;
        }

        void a() {
            this.f3680a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            if (i3 == 0) {
                float refreshRate = this.f3680a.getDisplay(0).getRefreshRate();
                x.this.f3675a = (long) (1.0E9d / refreshRate);
                x.this.f3676b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    }

    private class c implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        private long f3682a;

        c(long j3) {
            this.f3682a = j3;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            long nanoTime = System.nanoTime() - j3;
            x.this.f3676b.onVsync(nanoTime < 0 ? 0L : nanoTime, x.this.f3675a, this.f3682a);
            x.this.f3677c = this;
        }
    }

    private x(FlutterJNI flutterJNI) {
        this.f3676b = flutterJNI;
    }

    public static x f(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f3673e == null) {
            f3673e = new x(flutterJNI);
        }
        if (f3674f == null) {
            x xVar = f3673e;
            Objects.requireNonNull(xVar);
            b bVar = xVar.new b(displayManager);
            f3674f = bVar;
            bVar.a();
        }
        if (f3673e.f3675a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f3673e.f3675a = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f3673e;
    }

    public void g() {
        this.f3676b.setAsyncWaitForVsyncDelegate(this.f3678d);
    }
}
