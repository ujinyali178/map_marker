package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;

/* loaded from: /root/release/classes2.dex */
public class BOMInputStream extends ProxyInputStream {
    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() { // from class: org.apache.commons.io.input.BOMInputStream.1
        @Override // java.util.Comparator
        public int compare(ByteOrderMark byteOrderMark, ByteOrderMark byteOrderMark2) {
            int length = byteOrderMark.length();
            int length2 = byteOrderMark2.length();
            if (length > length2) {
                return -1;
            }
            return length2 > length ? 1 : 0;
        }
    };
    private final List<ByteOrderMark> boms;
    private ByteOrderMark byteOrderMark;
    private int fbIndex;
    private int fbLength;
    private int[] firstBytes;
    private final boolean include;
    private int markFbIndex;
    private boolean markedAtStart;

    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z3) {
        this(inputStream, z3, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z3, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (byteOrderMarkArr == null || byteOrderMarkArr.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = z3;
        List<ByteOrderMark> asList = Arrays.asList(byteOrderMarkArr);
        Collections.sort(asList, ByteOrderMarkLengthComparator);
        this.boms = asList;
    }

    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    private ByteOrderMark find() {
        for (ByteOrderMark byteOrderMark : this.boms) {
            if (matches(byteOrderMark)) {
                return byteOrderMark;
            }
        }
        return null;
    }

    private boolean matches(ByteOrderMark byteOrderMark) {
        for (int i3 = 0; i3 < byteOrderMark.length(); i3++) {
            if (byteOrderMark.get(i3) != this.firstBytes[i3]) {
                return false;
            }
        }
        return true;
    }

    private int readFirstBytes() {
        getBOM();
        int i3 = this.fbIndex;
        if (i3 >= this.fbLength) {
            return -1;
        }
        int[] iArr = this.firstBytes;
        this.fbIndex = i3 + 1;
        return iArr[i3];
    }

    public ByteOrderMark getBOM() {
        if (this.firstBytes == null) {
            this.fbLength = 0;
            this.firstBytes = new int[this.boms.get(0).length()];
            int i3 = 0;
            while (true) {
                int[] iArr = this.firstBytes;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = ((FilterInputStream) this).in.read();
                this.fbLength++;
                if (this.firstBytes[i3] < 0) {
                    break;
                }
                i3++;
            }
            ByteOrderMark find = find();
            this.byteOrderMark = find;
            if (find != null && !this.include) {
                if (find.length() < this.firstBytes.length) {
                    this.fbIndex = this.byteOrderMark.length();
                } else {
                    this.fbLength = 0;
                }
            }
        }
        return this.byteOrderMark;
    }

    public String getBOMCharsetName() {
        getBOM();
        ByteOrderMark byteOrderMark = this.byteOrderMark;
        if (byteOrderMark == null) {
            return null;
        }
        return byteOrderMark.getCharsetName();
    }

    public boolean hasBOM() {
        return getBOM() != null;
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark) {
        if (this.boms.contains(byteOrderMark)) {
            getBOM();
            ByteOrderMark byteOrderMark2 = this.byteOrderMark;
            return byteOrderMark2 != null && byteOrderMark2.equals(byteOrderMark);
        }
        throw new IllegalArgumentException("Stream not configure to detect " + byteOrderMark);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        this.markFbIndex = this.fbIndex;
        this.markedAtStart = this.firstBytes == null;
        ((FilterInputStream) this).in.mark(i3);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int readFirstBytes = readFirstBytes();
        return readFirstBytes >= 0 ? readFirstBytes : ((FilterInputStream) this).in.read();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        while (i4 > 0 && i5 >= 0) {
            i5 = readFirstBytes();
            if (i5 >= 0) {
                bArr[i3] = (byte) (i5 & 255);
                i4--;
                i6++;
                i3++;
            }
        }
        int read = ((FilterInputStream) this).in.read(bArr, i3, i4);
        if (read >= 0) {
            return i6 + read;
        }
        if (i6 > 0) {
            return i6;
        }
        return -1;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        this.fbIndex = this.markFbIndex;
        if (this.markedAtStart) {
            this.firstBytes = null;
        }
        ((FilterInputStream) this).in.reset();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) {
        long j4;
        int i3 = 0;
        while (true) {
            j4 = i3;
            if (j3 <= j4 || readFirstBytes() < 0) {
                break;
            }
            i3++;
        }
        return ((FilterInputStream) this).in.skip(j3 - j4) + j4;
    }
}
