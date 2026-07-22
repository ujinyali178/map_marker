package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes2.dex */
public class ReversedLinesFileReader implements Closeable {
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private final Charset encoding;
    private final byte[][] newLineSequences;
    private final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    private class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;
        private final long no;

        private FilePart(long j3, int i3, byte[] bArr) {
            this.no = j3;
            byte[] bArr2 = new byte[(bArr != null ? bArr.length : 0) + i3];
            this.data = bArr2;
            long j4 = (j3 - 1) * ReversedLinesFileReader.this.blockSize;
            if (j3 > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(j4);
                if (ReversedLinesFileReader.this.randomAccessFile.read(bArr2, 0, i3) != i3) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
            }
            this.currentLastBytePos = bArr2.length - 1;
            this.leftOver = null;
        }

        private void createLeftOver() {
            int i3 = this.currentLastBytePos + 1;
            if (i3 > 0) {
                byte[] bArr = new byte[i3];
                this.leftOver = bArr;
                System.arraycopy(this.data, 0, bArr, 0, i3);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i3) {
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z3 = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i3 + length) - (bArr2.length - 1);
                    z3 &= length2 >= 0 && bArr[length2] == bArr2[length];
                }
                if (z3) {
                    return bArr2.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() {
            String str;
            byte[] bArr;
            boolean z3 = this.no == 1;
            int i3 = this.currentLastBytePos;
            while (i3 > -1) {
                if (z3 || i3 >= ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i3);
                    if (newLineMatchByteCount > 0) {
                        int i4 = i3 + 1;
                        int i5 = (this.currentLastBytePos - i4) + 1;
                        if (i5 < 0) {
                            throw new IllegalStateException("Unexpected negative line length=" + i5);
                        }
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(this.data, i4, bArr2, 0, i5);
                        str = new String(bArr2, ReversedLinesFileReader.this.encoding);
                        this.currentLastBytePos = i3 - newLineMatchByteCount;
                        if (!z3 && (bArr = this.leftOver) != null) {
                            String str2 = new String(bArr, ReversedLinesFileReader.this.encoding);
                            this.leftOver = null;
                            return str2;
                        }
                    }
                    i3 -= ReversedLinesFileReader.this.byteDecrement;
                    if (i3 < 0) {
                    }
                }
                createLeftOver();
            }
            str = null;
            return !z3 ? str : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() {
            if (this.currentLastBytePos > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
            long j3 = this.no;
            if (j3 > 1) {
                ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                return reversedLinesFileReader.new FilePart(j3 - 1, reversedLinesFileReader.blockSize, this.leftOver);
            }
            if (this.leftOver == null) {
                return null;
            }
            throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) {
        this(file, 4096, Charset.defaultCharset());
    }

    public ReversedLinesFileReader(File file, int i3, String str) {
        this(file, i3, Charsets.toCharset(str));
    }

    public ReversedLinesFileReader(File file, int i3, Charset charset) {
        int i4;
        this.trailingNewlineOfFileSkipped = false;
        this.blockSize = i3;
        this.encoding = charset;
        Charset charset2 = Charsets.toCharset(charset);
        if (charset2.newEncoder().maxBytesPerChar() == 1.0f || charset2 == StandardCharsets.UTF_8 || charset2 == Charset.forName("Shift_JIS") || charset2 == Charset.forName("windows-31j") || charset2 == Charset.forName("x-windows-949") || charset2 == Charset.forName("gbk") || charset2 == Charset.forName("x-windows-950")) {
            this.byteDecrement = 1;
        } else {
            if (charset2 != StandardCharsets.UTF_16BE && charset2 != StandardCharsets.UTF_16LE) {
                if (charset2 == StandardCharsets.UTF_16) {
                    throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
                }
                throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
            }
            this.byteDecrement = 2;
        }
        byte[][] bArr = {IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(charset), IOUtils.LINE_SEPARATOR_UNIX.getBytes(charset), "\r".getBytes(charset)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.randomAccessFile = randomAccessFile;
        long length = randomAccessFile.length();
        this.totalByteLength = length;
        long j3 = i3;
        int i5 = (int) (length % j3);
        if (i5 > 0) {
            this.totalBlockCount = (length / j3) + 1;
        } else {
            this.totalBlockCount = length / j3;
            if (length > 0) {
                i4 = i3;
                this.currentFilePart = new FilePart(this.totalBlockCount, i4, null);
            }
        }
        i4 = i5;
        this.currentFilePart = new FilePart(this.totalBlockCount, i4, null);
    }

    public ReversedLinesFileReader(File file, Charset charset) {
        this(file, 4096, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.randomAccessFile.close();
    }

    public String readLine() {
        String readLine = this.currentFilePart.readLine();
        while (readLine == null) {
            FilePart rollOver = this.currentFilePart.rollOver();
            this.currentFilePart = rollOver;
            if (rollOver == null) {
                break;
            }
            readLine = rollOver.readLine();
        }
        if (!"".equals(readLine) || this.trailingNewlineOfFileSkipped) {
            return readLine;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }
}
