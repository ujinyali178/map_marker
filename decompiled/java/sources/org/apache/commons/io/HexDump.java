package org.apache.commons.io;

import java.io.OutputStream;
import java.nio.charset.Charset;

/* loaded from: /root/release/classes2.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    private static StringBuilder dump(StringBuilder sb, byte b4) {
        for (int i3 = 0; i3 < 2; i3++) {
            sb.append(_hexcodes[(b4 >> _shifts[i3 + 6]) & 15]);
        }
        return sb;
    }

    private static StringBuilder dump(StringBuilder sb, long j3) {
        for (int i3 = 0; i3 < 8; i3++) {
            sb.append(_hexcodes[((int) (j3 >> _shifts[i3])) & 15]);
        }
        return sb;
    }

    public static void dump(byte[] bArr, long j3, OutputStream outputStream, int i3) {
        if (i3 < 0 || i3 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i3 + " into array of length " + bArr.length);
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long j4 = j3 + i3;
        StringBuilder sb = new StringBuilder(74);
        while (i3 < bArr.length) {
            int length = bArr.length - i3;
            if (length > 16) {
                length = 16;
            }
            dump(sb, j4).append(' ');
            for (int i4 = 0; i4 < 16; i4++) {
                if (i4 < length) {
                    dump(sb, bArr[i4 + i3]);
                } else {
                    sb.append("  ");
                }
                sb.append(' ');
            }
            for (int i5 = 0; i5 < length; i5++) {
                byte b4 = bArr[i5 + i3];
                sb.append((b4 < 32 || b4 >= Byte.MAX_VALUE) ? FilenameUtils.EXTENSION_SEPARATOR : (char) b4);
            }
            sb.append(EOL);
            outputStream.write(sb.toString().getBytes(Charset.defaultCharset()));
            outputStream.flush();
            sb.setLength(0);
            j4 += length;
            i3 += 16;
        }
    }
}
