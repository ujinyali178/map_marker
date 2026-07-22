package n;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: /root/release/classes.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    public static final float[] f4044h;

    /* renamed from: i, reason: collision with root package name */
    public static final float[] f4045i;

    /* renamed from: a, reason: collision with root package name */
    private int f4046a;

    /* renamed from: b, reason: collision with root package name */
    private int f4047b;

    /* renamed from: c, reason: collision with root package name */
    private int f4048c;

    /* renamed from: d, reason: collision with root package name */
    private int f4049d;

    /* renamed from: e, reason: collision with root package name */
    private int f4050e;

    /* renamed from: f, reason: collision with root package name */
    private int f4051f;

    /* renamed from: g, reason: collision with root package name */
    private int f4052g;

    static {
        float[] fArr = new float[16];
        f4044h = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        f4045i = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.translateM(fArr2, 0, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED);
        Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
    }

    public g(int i3) {
        String str;
        this.f4046a = i3;
        if (i3 == 0) {
            this.f4052g = 3553;
            str = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        } else {
            if (i3 != 1) {
                throw new RuntimeException("Unhandled type " + i3);
            }
            this.f4052g = 36197;
            str = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        }
        this.f4047b = c("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", str);
        int i4 = this.f4047b;
        if (i4 == 0) {
            throw new RuntimeException("Unable to create program");
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(i4, "aPosition");
        this.f4050e = glGetAttribLocation;
        b(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f4047b, "aTextureCoord");
        this.f4051f = glGetAttribLocation2;
        b(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f4047b, "uMVPMatrix");
        this.f4048c = glGetUniformLocation;
        b(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f4047b, "uTexMatrix");
        this.f4049d = glGetUniformLocation2;
        b(glGetUniformLocation2, "uTexMatrix");
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
        Log.e("Texture2dProgram", str2);
        throw new RuntimeException(str2);
    }

    public static void b(int i3, String str) {
        if (i3 >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + str + "' in program");
    }

    public static int c(String str, String str2) {
        int f3;
        int f4 = f(35633, str);
        if (f4 == 0 || (f3 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("Texture2dProgram", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, f4);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f3);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("Texture2dProgram", "Could not link program: ");
        Log.e("Texture2dProgram", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static int f(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        a("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("Texture2dProgram", "Could not compile shader " + i3 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("Texture2dProgram", sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        int i3 = iArr[0];
        GLES20.glBindTexture(this.f4052g, i3);
        a("glBindTexture " + i3);
        GLES20.glTexParameterf(this.f4052g, 10241, 9728.0f);
        int i4 = this.f4052g;
        GLES20.glTexParameterf(i4, 10240, i4 != 3553 ? 9729.0f : 9728.0f);
        GLES20.glTexParameteri(this.f4052g, 10242, 33071);
        GLES20.glTexParameteri(this.f4052g, 10243, 33071);
        a("glTexParameter");
        return i3;
    }

    public void e(float[] fArr, FloatBuffer floatBuffer, int i3, int i4, int i5, int i6, float[] fArr2, FloatBuffer floatBuffer2, int i7, int i8) {
        a("draw start");
        GLES20.glUseProgram(this.f4047b);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f4052g, i7);
        GLES20.glUniformMatrix4fv(this.f4048c, 1, false, fArr, 0);
        a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f4049d, 1, false, fArr2, 0);
        a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f4050e);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f4050e, i5, 5126, false, i6, (Buffer) floatBuffer);
        a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f4051f);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f4051f, 2, 5126, false, i8, (Buffer) floatBuffer2);
        a("glVertexAttribPointer");
        GLES20.glDrawArrays(5, i3, i4);
        a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f4050e);
        GLES20.glDisableVertexAttribArray(this.f4051f);
        GLES20.glBindTexture(this.f4052g, 0);
        GLES20.glUseProgram(0);
    }

    public void g(int i3, Bitmap bitmap) {
        GLES20.glBindTexture(this.f4052g, i3);
        GLUtils.texImage2D(this.f4052g, 0, bitmap, 0);
    }

    public void h() {
        Log.d("Texture2dProgram", "deleting program " + this.f4047b);
        GLES20.glDeleteProgram(this.f4047b);
        this.f4047b = -1;
    }
}
