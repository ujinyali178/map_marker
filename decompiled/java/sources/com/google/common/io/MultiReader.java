package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class MultiReader extends Reader {

    @CheckForNull
    private Reader current;
    private final Iterator<? extends CharSource> it;

    MultiReader(Iterator<? extends CharSource> it) {
        this.it = it;
        advance();
    }

    private void advance() {
        close();
        if (this.it.hasNext()) {
            this.current = this.it.next().openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) {
        Preconditions.checkNotNull(cArr);
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i3, i4);
        if (read != -1) {
            return read;
        }
        advance();
        return read(cArr, i3, i4);
    }

    @Override // java.io.Reader
    public boolean ready() {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j3) {
        Preconditions.checkArgument(j3 >= 0, "n is negative");
        if (j3 > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j3);
                if (skip > 0) {
                    return skip;
                }
                advance();
            }
        }
        return 0L;
    }
}
