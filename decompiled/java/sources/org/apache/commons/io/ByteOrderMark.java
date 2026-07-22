package org.apache.commons.io;

import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class ByteOrderMark implements Serializable {
    public static final char UTF_BOM = 65279;
    private static final long serialVersionUID = 1;
    private final int[] bytes;
    private final String charsetName;
    public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", 239, 187, 191);
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", 254, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark("UTF-16LE", 255, 254);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0, 0, 254, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 255, 254, 0, 0);

    public ByteOrderMark(String str, int... iArr) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("No charsetName specified");
        }
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        }
        this.charsetName = str;
        int[] iArr2 = new int[iArr.length];
        this.bytes = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.bytes.length != byteOrderMark.length()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i3 >= iArr.length) {
                return true;
            }
            if (iArr[i3] != byteOrderMark.get(i3)) {
                return false;
            }
            i3++;
        }
    }

    public int get(int i3) {
        return this.bytes[i3];
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[this.bytes.length];
        int i3 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i3 >= iArr.length) {
                return bArr;
            }
            bArr[i3] = (byte) iArr[i3];
            i3++;
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (int i3 : this.bytes) {
            hashCode += i3;
        }
        return hashCode;
    }

    public int length() {
        return this.bytes.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append(this.charsetName);
        sb.append(": ");
        for (int i3 = 0; i3 < this.bytes.length; i3++) {
            if (i3 > 0) {
                sb.append(",");
            }
            sb.append("0x");
            sb.append(Integer.toHexString(this.bytes[i3] & 255).toUpperCase());
        }
        sb.append(']');
        return sb.toString();
    }
}
