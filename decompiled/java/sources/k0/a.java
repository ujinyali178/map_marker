package k0;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/* loaded from: /root/release/classes.dex */
public class a {
    public static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void b(byte[] bArr, String str) {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        fileOutputStream.write(bArr, 0, bArr.length);
        fileOutputStream.close();
    }
}
