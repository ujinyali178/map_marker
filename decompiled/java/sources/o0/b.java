package o0;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f4073b = Arrays.asList("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model");

    /* renamed from: a, reason: collision with root package name */
    private final androidx.exifinterface.media.a f4074a;

    public b(String str) {
        this.f4074a = new androidx.exifinterface.media.a(str);
    }

    public b(byte[] bArr) {
        this.f4074a = new androidx.exifinterface.media.a(new ByteArrayInputStream(bArr));
    }

    private static void a(androidx.exifinterface.media.a aVar, androidx.exifinterface.media.a aVar2) {
        Iterator<String> it = f4073b.iterator();
        while (it.hasNext()) {
            b(aVar, aVar2, it.next());
        }
        try {
            aVar2.S();
        } catch (IOException unused) {
        }
    }

    private static void b(androidx.exifinterface.media.a aVar, androidx.exifinterface.media.a aVar2, String str) {
        if (aVar.d(str) != null) {
            aVar2.W(str, aVar.d(str));
        }
    }

    public ByteArrayOutputStream c(Context context, ByteArrayOutputStream byteArrayOutputStream) {
        FileInputStream fileInputStream;
        Exception e3;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            String uuid = UUID.randomUUID().toString();
            File file = new File(context.getCacheDir(), uuid + ".jpg");
            fileOutputStream = new FileOutputStream(file);
            try {
                IOUtils.write(byteArrayOutputStream.toByteArray(), fileOutputStream);
                fileOutputStream.close();
                androidx.exifinterface.media.a aVar = new androidx.exifinterface.media.a(file.getAbsolutePath());
                a(this.f4074a, aVar);
                aVar.S();
                fileOutputStream.close();
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                fileInputStream = new FileInputStream(file);
            } catch (Exception e4) {
                fileInputStream = null;
                e3 = e4;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            e3 = e5;
            fileOutputStream = null;
        }
        try {
            IOUtils.copy(fileInputStream, byteArrayOutputStream2);
            fileInputStream.close();
            return byteArrayOutputStream2;
        } catch (Exception e6) {
            e3 = e6;
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e3);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            return byteArrayOutputStream;
        }
    }
}
