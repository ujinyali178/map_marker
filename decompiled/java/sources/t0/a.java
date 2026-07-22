package t0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.File;
import java.io.OutputStream;
import kotlin.jvm.internal.k;
import n.f;
import n2.i;

/* loaded from: /root/release/classes.dex */
public final class a implements r0.a {
    private final void d(String str, int i3, int i4, int i5, int i6, int i7, String str2) {
        Bitmap bitmap = BitmapFactory.decodeFile(str, g(i7));
        k.d(bitmap, "bitmap");
        f(bitmap, i3, i4, i6, str2, i5);
    }

    private final void e(byte[] bArr, int i3, int i4, int i5, int i6, int i7, String str) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, g(i7));
        k.d(bitmap, "bitmap");
        f(bitmap, i3, i4, i6, str, i5);
    }

    private final void f(Bitmap bitmap, int i3, int i4, int i5, String str, int i6) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        u0.a.a("src width = " + width);
        u0.a.a("src height = " + height);
        float a4 = p0.a.a(bitmap, i3, i4);
        u0.a.a("scale = " + a4);
        float f3 = width / a4;
        float f4 = height / a4;
        u0.a.a("dst width = " + f3);
        u0.a.a("dst height = " + f4);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f3, (int) f4, true);
        k.d(createScaledBitmap, "createScaledBitmap(\n    …           true\n        )");
        Bitmap f5 = p0.a.f(createScaledBitmap, i5);
        f a5 = new f.b(str, f5.getWidth(), f5.getHeight(), 2).c(i6).b(1).a();
        a5.g();
        a5.a(f5);
        a5.h(5000L);
        a5.close();
    }

    private final BitmapFactory.Options g(int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i3;
        if (Build.VERSION.SDK_INT < 23) {
            options.inDither = true;
        }
        return options;
    }

    @Override // r0.a
    public int a() {
        return 2;
    }

    @Override // r0.a
    public void b(Context context, byte[] byteArray, OutputStream outputStream, int i3, int i4, int i5, int i6, boolean z3, int i7) {
        byte[] a4;
        k.e(context, "context");
        k.e(byteArray, "byteArray");
        k.e(outputStream, "outputStream");
        File a5 = v0.a.f4397a.a(context);
        String absolutePath = a5.getAbsolutePath();
        k.d(absolutePath, "tmpFile.absolutePath");
        e(byteArray, i3, i4, i5, i6, i7, absolutePath);
        a4 = i.a(a5);
        outputStream.write(a4);
    }

    @Override // r0.a
    public void c(Context context, String path, OutputStream outputStream, int i3, int i4, int i5, int i6, boolean z3, int i7, int i8) {
        byte[] a4;
        k.e(context, "context");
        k.e(path, "path");
        k.e(outputStream, "outputStream");
        File a5 = v0.a.f4397a.a(context);
        String absolutePath = a5.getAbsolutePath();
        k.d(absolutePath, "tmpFile.absolutePath");
        d(path, i3, i4, i5, i6, i7, absolutePath);
        a4 = i.a(a5);
        outputStream.write(a4);
    }
}
