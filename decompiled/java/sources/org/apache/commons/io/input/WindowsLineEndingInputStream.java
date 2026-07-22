package org.apache.commons.io.input;

import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class WindowsLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashRSeen = false;
    private boolean slashNSeen = false;
    private boolean injectSlashN = false;
    private boolean eofSeen = false;

    public WindowsLineEndingInputStream(InputStream inputStream, boolean z3) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z3;
    }

    private int eofGame() {
        if (!this.ensureLineFeedAtEndOfFile) {
            return -1;
        }
        boolean z3 = this.slashNSeen;
        if (!z3 && !this.slashRSeen) {
            this.slashRSeen = true;
            return 13;
        }
        if (z3) {
            return -1;
        }
        this.slashRSeen = false;
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
        this.slashRSeen = read == 13;
        this.slashNSeen = read == 10;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        throw new UnsupportedOperationException("Mark not supported");
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.eofSeen) {
            return eofGame();
        }
        if (this.injectSlashN) {
            this.injectSlashN = false;
            return 10;
        }
        boolean z3 = this.slashRSeen;
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame();
        }
        if (readWithUpdate != 10 || z3) {
            return readWithUpdate;
        }
        this.injectSlashN = true;
        return 13;
    }
}
