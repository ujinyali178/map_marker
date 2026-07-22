package n2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class i extends h {
    public static byte[] a(File file) {
        kotlin.jvm.internal.k.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i3 = (int) length;
            byte[] bArr = new byte[i3];
            int i4 = i3;
            int i5 = 0;
            while (i4 > 0) {
                int read = fileInputStream.read(bArr, i5, i4);
                if (read < 0) {
                    break;
                }
                i4 -= read;
                i5 += read;
            }
            if (i4 > 0) {
                bArr = Arrays.copyOf(bArr, i5);
                kotlin.jvm.internal.k.d(bArr, "copyOf(this, newSize)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    d dVar = new d(8193);
                    dVar.write(read2);
                    a.b(fileInputStream, dVar, 0, 2, null);
                    int size = dVar.size() + i3;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] a4 = dVar.a();
                    byte[] copyOf = Arrays.copyOf(bArr, size);
                    kotlin.jvm.internal.k.d(copyOf, "copyOf(this, newSize)");
                    bArr = h2.i.c(a4, copyOf, i3, 0, dVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }
}
