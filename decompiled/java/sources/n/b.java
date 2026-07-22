package n;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private EGLDisplay f3970a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b, reason: collision with root package name */
    private EGLContext f3971b = EGL14.EGL_NO_CONTEXT;

    /* renamed from: c, reason: collision with root package name */
    private EGLSurface f3972c = EGL14.EGL_NO_SURFACE;

    /* renamed from: d, reason: collision with root package name */
    private EGLConfig[] f3973d = new EGLConfig[1];

    /* renamed from: e, reason: collision with root package name */
    private Surface f3974e;

    /* renamed from: f, reason: collision with root package name */
    private int f3975f;

    /* renamed from: g, reason: collision with root package name */
    private int f3976g;

    public b(Surface surface) {
        surface.getClass();
        this.f3974e = surface;
        c();
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private void b() {
        this.f3972c = EGL14.eglCreateWindowSurface(this.f3970a, this.f3973d[0], this.f3974e, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.f3972c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    private void c() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f3970a = eglGetDisplay;
        if (Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f3970a, iArr, 0, iArr, 1)) {
            this.f3970a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLDisplay eGLDisplay = this.f3970a;
        EGLConfig[] eGLConfigArr = this.f3973d;
        if (!EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f3971b = EGL14.eglCreateContext(this.f3970a, this.f3973d[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        a("eglCreateContext");
        if (this.f3971b == null) {
            throw new RuntimeException("null context");
        }
        b();
        this.f3975f = e();
        this.f3976g = d();
    }

    public int d() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f3970a, this.f3972c, 12374, iArr, 0);
        return iArr[0];
    }

    public int e() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f3970a, this.f3972c, 12375, iArr, 0);
        return iArr[0];
    }

    public void f() {
        EGLDisplay eGLDisplay = this.f3970a;
        EGLSurface eGLSurface = this.f3972c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f3971b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void g() {
        EGLDisplay eGLDisplay = this.f3970a;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void h() {
        if (!Objects.equals(this.f3970a, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglDestroySurface(this.f3970a, this.f3972c);
            EGL14.eglDestroyContext(this.f3970a, this.f3971b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f3970a);
        }
        this.f3974e.release();
        this.f3970a = EGL14.EGL_NO_DISPLAY;
        this.f3971b = EGL14.EGL_NO_CONTEXT;
        this.f3972c = EGL14.EGL_NO_SURFACE;
        this.f3974e = null;
    }

    public void i(long j3) {
        EGLExt.eglPresentationTimeANDROID(this.f3970a, this.f3972c, j3);
    }

    public boolean j() {
        return EGL14.eglSwapBuffers(this.f3970a, this.f3972c);
    }
}
