package l0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: /root/release/classes.dex */
public class d {

    public interface a<T> {
    }

    public static boolean a(String str, String str2) {
        File file = new File(str2 + ".tmp");
        File file2 = new File(str);
        File file3 = new File(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            b(file2, fileOutputStream);
            fileOutputStream.close();
            return f(file, file3);
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public static void b(File file, OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                fileInputStream.close();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void c(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                fileOutputStream.write(bArr, 0, read);
            }
        }
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(Normalizer.normalize(str.toLowerCase(Locale.getDefault()), Normalizer.Form.NFD)).replaceAll("");
    }

    public static boolean e(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }

    public static boolean f(File file, File file2) {
        return file != null && file2 != null && file.exists() && (!file2.exists() || file2.delete()) && file.renameTo(file2);
    }

    public static void g(Object obj) {
        try {
            obj.wait();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
