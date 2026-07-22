package s0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.k;
import o0.b;

/* loaded from: /root/release/classes.dex */
public final class a implements r0.a {

    /* renamed from: a, reason: collision with root package name */
    private final int f4102a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4103b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap.CompressFormat f4104c;

    public a(int i3) {
        this.f4102a = i3;
        int a4 = a();
        this.f4103b = a4 != 1 ? a4 != 3 ? "jpeg" : "webp" : "png";
        int a5 = a();
        this.f4104c = a5 != 1 ? a5 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    private final byte[] d(byte[] bArr, int i3, int i4, int i5, int i6, int i7) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i7;
        if (Build.VERSION.SDK_INT < 23) {
            options.inDither = true;
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        u0.a.a("src width = " + width);
        u0.a.a("src height = " + height);
        k.d(bitmap, "bitmap");
        float a4 = p0.a.a(bitmap, i3, i4);
        u0.a.a("scale = " + a4);
        float f3 = width / a4;
        float f4 = height / a4;
        u0.a.a("dst width = " + f3);
        u0.a.a("dst height = " + f4);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f3, (int) f4, true);
        k.d(createScaledBitmap, "createScaledBitmap(\n    …           true\n        )");
        p0.a.f(createScaledBitmap, i6).compress(this.f4104c, i5, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        k.d(byteArray, "outputStream.toByteArray()");
        return byteArray;
    }

    @Override // r0.a
    public int a() {
        return this.f4102a;
    }

    @Override // r0.a
    public void b(Context context, byte[] byteArray, OutputStream outputStream, int i3, int i4, int i5, int i6, boolean z3, int i7) {
        k.e(context, "context");
        k.e(byteArray, "byteArray");
        k.e(outputStream, "outputStream");
        byte[] d3 = d(byteArray, i3, i4, i5, i6, i7);
        if (!z3 || this.f4104c != Bitmap.CompressFormat.JPEG) {
            outputStream.write(d3);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(d3);
        outputStream.write(new b(byteArray).c(context, byteArrayOutputStream).toByteArray());
    }

    @Override // r0.a
    public void c(Context context, String path, OutputStream outputStream, int i3, int i4, int i5, int i6, boolean z3, int i7, int i8) {
        k.e(context, "context");
        k.e(path, "path");
        k.e(outputStream, "outputStream");
        if (i8 <= 0) {
            return;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = i7;
            if (Build.VERSION.SDK_INT < 23) {
                options.inDither = true;
            }
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            k.d(bitmap, "bitmap");
            byte[] c3 = p0.a.c(bitmap, i3, i4, i5, i6, a());
            if (z3) {
                try {
                    if (this.f4104c == Bitmap.CompressFormat.JPEG) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(c3);
                        outputStream.write(new b(path).c(context, byteArrayOutputStream).toByteArray());
                    }
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    c(context, path, outputStream, i3, i4, i5, i6, z3, i7 * 2, i8 - 1);
                    return;
                }
            }
            outputStream.write(c3);
        } catch (OutOfMemoryError unused2) {
        }
    }
}
