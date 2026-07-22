package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.util.Log;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /root/release/classes.dex */
class b {

    static class a {
        static void a(FileDescriptor fileDescriptor) {
            Os.close(fileDescriptor);
        }

        static FileDescriptor b(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        static long c(FileDescriptor fileDescriptor, long j3, int i3) {
            return Os.lseek(fileDescriptor, j3, i3);
        }
    }

    /* renamed from: androidx.exifinterface.media.b$b, reason: collision with other inner class name */
    static class C0019b {
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b4)));
        }
        return sb.toString();
    }

    static void b(FileDescriptor fileDescriptor) {
        try {
            a.a(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterfaceUtils", "Error closing fd.");
        }
    }

    static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    static long[] d(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            jArr[i3] = iArr[i3];
        }
        return jArr;
    }

    static int e(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i3;
            }
            i3 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    static void f(InputStream inputStream, OutputStream outputStream, int i3) {
        byte[] bArr = new byte[8192];
        while (i3 > 0) {
            int min = Math.min(i3, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read != min) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i3 -= read;
            outputStream.write(bArr, 0, read);
        }
    }

    static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
