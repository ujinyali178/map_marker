package p0;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.google.maps.android.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class a {
    public static final float a(Bitmap bitmap, int i3, int i4) {
        k.e(bitmap, "<this>");
        float width = bitmap.getWidth() / i3;
        float height = bitmap.getHeight() / i4;
        e("width scale = " + width);
        e("height scale = " + height);
        return Math.max(1.0f, Math.min(width, height));
    }

    public static final void b(Bitmap bitmap, int i3, int i4, int i5, int i6, OutputStream outputStream, int i7) {
        k.e(bitmap, "<this>");
        k.e(outputStream, "outputStream");
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        e("src width = " + width);
        e("src height = " + height);
        float a4 = a(bitmap, i3, i4);
        e("scale = " + a4);
        float f3 = width / a4;
        float f4 = height / a4;
        e("dst width = " + f3);
        e("dst height = " + f4);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f3, (int) f4, true);
        k.d(createScaledBitmap, "createScaledBitmap(\n    …destH.toInt(), true\n    )");
        f(createScaledBitmap, i6).compress(d(i7), i5, outputStream);
    }

    public static final byte[] c(Bitmap bitmap, int i3, int i4, int i5, int i6, int i7) {
        k.e(bitmap, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(bitmap, i3, i4, i5, i6, byteArrayOutputStream, i7);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        k.d(byteArray, "outputStream.toByteArray()");
        return byteArray;
    }

    public static final Bitmap.CompressFormat d(int i3) {
        return i3 != 1 ? i3 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    private static final void e(Object obj) {
        if (m0.a.f3950f.a()) {
            if (obj == null) {
                obj = BuildConfig.TRAVIS;
            }
            System.out.println(obj);
        }
    }

    public static final Bitmap f(Bitmap bitmap, int i3) {
        k.e(bitmap, "<this>");
        if (i3 % 360 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        k.d(createBitmap, "{\n        val matrix = M…ght, matrix, false)\n    }");
        return createBitmap;
    }
}
