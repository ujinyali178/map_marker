package androidx.profileinstaller;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: /root/release/classes.dex */
class e {
    static int a(int i3) {
        return (((i3 + 8) - 1) & (-8)) / 8;
    }

    static byte[] b(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    static RuntimeException c(String str) {
        return new IllegalStateException(str);
    }

    static byte[] d(InputStream inputStream, int i3) {
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            int read = inputStream.read(bArr, i4, i3 - i4);
            if (read < 0) {
                throw c("Not enough bytes to read: " + i3);
            }
            i4 += read;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        if (r0.finished() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        throw c("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static byte[] e(java.io.InputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L84
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L84
            r3 = 0
            r4 = 0
            r5 = 0
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L84
            if (r6 != 0) goto L53
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L84
            if (r6 != 0) goto L53
            if (r4 >= r9) goto L53
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L84
            if (r6 < 0) goto L38
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L84
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.util.zip.DataFormatException -> L2e java.lang.Throwable -> L84
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L84
            java.lang.RuntimeException r8 = c(r8)     // Catch: java.lang.Throwable -> L84
            throw r8     // Catch: java.lang.Throwable -> L84
        L38:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r8.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L84
            r8.append(r9)     // Catch: java.lang.Throwable -> L84
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L84
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L84
            java.lang.RuntimeException r8 = c(r8)     // Catch: java.lang.Throwable -> L84
            throw r8     // Catch: java.lang.Throwable -> L84
        L53:
            if (r4 != r9) goto L66
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L84
            if (r8 == 0) goto L5f
            r0.end()
            return r1
        L5f:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.RuntimeException r8 = c(r8)     // Catch: java.lang.Throwable -> L84
            throw r8     // Catch: java.lang.Throwable -> L84
        L66:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r8.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L84
            r8.append(r9)     // Catch: java.lang.Throwable -> L84
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L84
            r8.append(r4)     // Catch: java.lang.Throwable -> L84
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L84
            java.lang.RuntimeException r8 = c(r8)     // Catch: java.lang.Throwable -> L84
            throw r8     // Catch: java.lang.Throwable -> L84
        L84:
            r8 = move-exception
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.e.e(java.io.InputStream, int, int):byte[]");
    }

    static String f(InputStream inputStream, int i3) {
        return new String(d(inputStream, i3), StandardCharsets.UTF_8);
    }

    static long g(InputStream inputStream, int i3) {
        byte[] d3 = d(inputStream, i3);
        long j3 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j3 += (d3[i4] & UnsignedBytes.MAX_VALUE) << (i4 * 8);
        }
        return j3;
    }

    static int h(InputStream inputStream) {
        return (int) g(inputStream, 2);
    }

    static long i(InputStream inputStream) {
        return g(inputStream, 4);
    }

    static int j(InputStream inputStream) {
        return (int) g(inputStream, 1);
    }

    static int k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    static void l(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[UserVerificationMethods.USER_VERIFY_NONE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    static void m(OutputStream outputStream, byte[] bArr) {
        q(outputStream, bArr.length);
        byte[] b4 = b(bArr);
        q(outputStream, b4.length);
        outputStream.write(b4);
    }

    static void n(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void o(OutputStream outputStream, long j3, int i3) {
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4] = (byte) ((j3 >> (i4 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    static void p(OutputStream outputStream, int i3) {
        o(outputStream, i3, 2);
    }

    static void q(OutputStream outputStream, long j3) {
        o(outputStream, j3, 4);
    }

    static void r(OutputStream outputStream, int i3) {
        o(outputStream, i3, 1);
    }
}
