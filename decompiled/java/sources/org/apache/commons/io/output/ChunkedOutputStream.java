package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public class ChunkedOutputStream extends FilterOutputStream {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final int chunkSize;

    public ChunkedOutputStream(OutputStream outputStream) {
        this(outputStream, 4096);
    }

    public ChunkedOutputStream(OutputStream outputStream, int i3) {
        super(outputStream);
        if (i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.chunkSize = i3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        while (i4 > 0) {
            int min = Math.min(i4, this.chunkSize);
            ((FilterOutputStream) this).out.write(bArr, i3, min);
            i4 -= min;
            i3 += min;
        }
    }
}
