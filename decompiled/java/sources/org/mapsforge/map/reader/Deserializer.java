package org.mapsforge.map.reader;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: /root/release/classes2.dex */
final class Deserializer {
    private Deserializer() {
        throw new IllegalStateException();
    }

    static long getFiveBytesLong(byte[] bArr, int i3) {
        return (bArr[i3 + 4] & 255) | ((bArr[i3] & 255) << 32) | ((bArr[i3 + 1] & 255) << 24) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 8);
    }

    static int getInt(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) | (bArr[i3] << Ascii.CAN) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    static long getLong(byte[] bArr, int i3) {
        return (bArr[i3 + 7] & 255) | ((bArr[i3] & 255) << 56) | ((bArr[i3 + 1] & 255) << 48) | ((bArr[i3 + 2] & 255) << 40) | ((bArr[i3 + 3] & 255) << 32) | ((bArr[i3 + 4] & 255) << 24) | ((bArr[i3 + 5] & 255) << 16) | ((bArr[i3 + 6] & 255) << 8);
    }

    static int getShort(byte[] bArr, int i3) {
        return (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) | (bArr[i3] << 8);
    }
}
