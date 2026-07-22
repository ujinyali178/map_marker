package n2;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /root/release/classes.dex */
public final class a {
    public static final long a(InputStream inputStream, OutputStream out, int i3) {
        kotlin.jvm.internal.k.e(inputStream, "<this>");
        kotlin.jvm.internal.k.e(out, "out");
        byte[] bArr = new byte[i3];
        int read = inputStream.read(bArr);
        long j3 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j3 += read;
            read = inputStream.read(bArr);
        }
        return j3;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 8192;
        }
        return a(inputStream, outputStream, i3);
    }
}
