package d0;

import android.content.Context;
import android.media.ExifInterface;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class b implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final Context f2445c;

    b(Context context) {
        this.f2445c = context;
    }

    private void a(String str, String str2) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            ExifInterface exifInterface2 = new ExifInterface(str2);
            Iterator it = Arrays.asList("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "Orientation").iterator();
            while (it.hasNext()) {
                try {
                    c(exifInterface, exifInterface2, (String) it.next());
                } catch (Exception e3) {
                    e = e3;
                    Log.e("FlutterNativeImagePlugin", "Error preserving Exif data on selected image: " + e);
                    return;
                }
            }
            exifInterface2.saveAttributes();
        } catch (Exception e4) {
            e = e4;
        }
    }

    private static String b(File file) {
        String name = file.getName();
        return name.indexOf(".") > 0 ? name.substring(0, name.lastIndexOf(".")) : name;
    }

    private void c(ExifInterface exifInterface, ExifInterface exifInterface2, String str) {
        if (exifInterface.getAttribute(str) != null) {
            exifInterface2.setAttribute(str, exifInterface.getAttribute(str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v8, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r18v0, types: [u1.l$d] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x020e -> B:65:0x0212). Please report as a decompilation issue!!! */
    @Override // u1.l.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(u1.k r17, u1.l.d r18) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.b.n(u1.k, u1.l$d):void");
    }
}
