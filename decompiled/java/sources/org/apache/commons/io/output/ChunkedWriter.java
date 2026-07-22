package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.Writer;

/* loaded from: /root/release/classes2.dex */
public class ChunkedWriter extends FilterWriter {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final int chunkSize;

    public ChunkedWriter(Writer writer) {
        this(writer, 4096);
    }

    public ChunkedWriter(Writer writer, int i3) {
        super(writer);
        if (i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.chunkSize = i3;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        while (i4 > 0) {
            int min = Math.min(i4, this.chunkSize);
            ((FilterWriter) this).out.write(cArr, i3, min);
            i4 -= min;
            i3 += min;
        }
    }
}
