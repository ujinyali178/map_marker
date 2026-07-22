package org.apache.commons.io.input;

import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class UnixLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashNSeen = false;
    private boolean slashRSeen = false;
    private boolean eofSeen = false;

    public UnixLineEndingInputStream(InputStream inputStream, boolean z3) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z3;
    }

    private int eofGame(boolean z3) {
        if (z3 || !this.ensureLineFeedAtEndOfFile || this.slashNSeen) {
            return -1;
        }
        this.slashNSeen = true;
        return 10;
    }

    private int readWithUpdate() {
        int read = this.target.read();
        boolean z3 = read == -1;
        this.eofSeen = z3;
        if (z3) {
            return read;
        }
        this.slashNSeen = read == 10;
        this.slashRSeen = read == 13;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        throw new UnsupportedOperationException("Mark notsupported");
    }

    @Override // java.io.InputStream
    public int read() {
        boolean z3 = this.slashRSeen;
        if (this.eofSeen) {
            return eofGame(z3);
        }
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame(z3);
        }
        if (this.slashRSeen) {
            return 10;
        }
        return (z3 && this.slashNSeen) ? read() : readWithUpdate;
    }
}
