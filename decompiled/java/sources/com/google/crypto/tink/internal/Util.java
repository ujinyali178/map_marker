package com.google.crypto.tink.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.util.Bytes;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util() {
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        if (isAndroid()) {
            return BuildDispatchedCode.getApiLevel();
        }
        return null;
    }

    public static boolean isAndroid() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    public static int randKeyId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i3 = 0;
        while (i3 == 0) {
            secureRandom.nextBytes(bArr);
            i3 = ((bArr[0] & Ascii.DEL) << 24) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[3] & UnsignedBytes.MAX_VALUE);
        }
        return i3;
    }

    private static final byte toByteFromPrintableAscii(char c3) {
        if (c3 >= '!' && c3 <= '~') {
            return (byte) c3;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c3);
    }

    public static final Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < str.length(); i3++) {
            bArr[i3] = toByteFromPrintableAscii(str.charAt(i3));
        }
        return Bytes.copyFrom(bArr);
    }
}
