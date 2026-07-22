package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: /root/release/classes.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3413a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3414b;

    o(Context context, a aVar) {
        this.f3413a = context;
        this.f3414b = aVar;
    }

    private int a(BitmapFactory.Options options, int i3, int i4) {
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        int i7 = 1;
        if (i5 > i4 || i6 > i3) {
            int i8 = i5 / 2;
            int i9 = i6 / 2;
            while (i8 / i7 >= i4 && i9 / i7 >= i3) {
                i7 *= 2;
            }
        }
        return i7;
    }

    private androidx.core.util.e b(double d3, double d4, Double d5, Double d6) {
        double d7 = d3 / d4;
        boolean z3 = true;
        boolean z4 = d5 != null;
        boolean z5 = d6 != null;
        double min = z4 ? Math.min(d3, Math.round(d5.doubleValue())) : d3;
        double min2 = z5 ? Math.min(d4, Math.round(d6.doubleValue())) : d4;
        boolean z6 = z4 && d5.doubleValue() < d3;
        boolean z7 = z5 && d6.doubleValue() < d4;
        if (!z6 && !z7) {
            z3 = false;
        }
        if (z3) {
            double d8 = min2 * d7;
            double d9 = min / d7;
            if (d9 > min2) {
                min = Math.round(d8);
            } else {
                min2 = Math.round(d9);
            }
        }
        return new androidx.core.util.e((float) min, (float) min2);
    }

    private void c(String str, String str2) {
        try {
            this.f3414b.a(new androidx.exifinterface.media.a(str), new androidx.exifinterface.media.a(str2));
        } catch (Exception e3) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e3);
        }
    }

    private File d(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File e(String str, Bitmap bitmap, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(hasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
        File d3 = d(this.f3413a.getCacheDir(), str);
        FileOutputStream f3 = f(d3);
        f3.write(byteArrayOutputStream.toByteArray());
        f3.close();
        return d3;
    }

    private FileOutputStream f(File file) {
        return new FileOutputStream(file);
    }

    private Bitmap g(Bitmap bitmap, int i3, int i4, boolean z3) {
        return Bitmap.createScaledBitmap(bitmap, i3, i4, z3);
    }

    private Bitmap h(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private File k(Bitmap bitmap, Double d3, Double d4, int i3, String str) {
        return e("/scaled_" + str, g(bitmap, d3.intValue(), d4.intValue(), false), i3);
    }

    androidx.core.util.e i(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        h(str, options);
        return new androidx.core.util.e(options.outWidth, options.outHeight);
    }

    String j(String str, Double d3, Double d4, int i3) {
        androidx.core.util.e i4 = i(str);
        if (i4.b() == -1.0f || i4.a() == -1.0f) {
            return str;
        }
        if (!((d3 == null && d4 == null && i3 >= 100) ? false : true)) {
            return str;
        }
        try {
            String[] split = str.split("/");
            String str2 = split[split.length - 1];
            androidx.core.util.e b4 = b(i4.b(), i4.a(), d3, d4);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = a(options, (int) b4.b(), (int) b4.a());
            Bitmap h3 = h(str, options);
            if (h3 == null) {
                return str;
            }
            File k3 = k(h3, Double.valueOf(b4.b()), Double.valueOf(b4.a()), i3, str2);
            c(str, k3.getPath());
            return k3.getPath();
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }
}
