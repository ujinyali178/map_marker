package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class FileBackedOutputStream extends OutputStream {

    @CheckForNull
    private File file;
    private final int fileThreshold;

    @CheckForNull
    private MemoryOutput memory;
    private OutputStream out;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    public FileBackedOutputStream(int i3) {
        this(i3, false);
    }

    public FileBackedOutputStream(int i3, boolean z3) {
        Preconditions.checkArgument(i3 >= 0, "fileThreshold must be non-negative, but was %s", i3);
        this.fileThreshold = i3;
        this.resetOnFinalize = z3;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        this.source = z3 ? new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.1
            protected void finalize() {
                try {
                    FileBackedOutputStream.this.reset();
                } catch (Throwable th) {
                    th.printStackTrace(System.err);
                }
            }

            @Override // com.google.common.io.ByteSource
            public InputStream openStream() {
                return FileBackedOutputStream.this.openInputStream();
            }
        } : new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() {
                return FileBackedOutputStream.this.openInputStream();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized InputStream openInputStream() {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        Objects.requireNonNull(this.memory);
        return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
    }

    private void update(int i3) {
        MemoryOutput memoryOutput = this.memory;
        if (memoryOutput == null || memoryOutput.getCount() + i3 <= this.fileThreshold) {
            return;
        }
        File createTempFile = TempFileCreator.INSTANCE.createTempFile("FileBackedOutputStream");
        if (this.resetOnFinalize) {
            createTempFile.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
            fileOutputStream.flush();
            this.out = fileOutputStream;
            this.file = createTempFile;
            this.memory = null;
        } catch (IOException e3) {
            createTempFile.delete();
            throw e3;
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        this.out.flush();
    }

    @CheckForNull
    synchronized File getFile() {
        return this.file;
    }

    public synchronized void reset() {
        try {
            close();
            MemoryOutput memoryOutput = this.memory;
            if (memoryOutput == null) {
                this.memory = new MemoryOutput();
            } else {
                memoryOutput.reset();
            }
            this.out = this.memory;
            File file = this.file;
            if (file != null) {
                this.file = null;
                if (!file.delete()) {
                    throw new IOException("Could not delete: " + file);
                }
            }
        } catch (Throwable th) {
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            File file2 = this.file;
            if (file2 != null) {
                this.file = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i3) {
        update(1);
        this.out.write(i3);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i4) {
        update(i4);
        this.out.write(bArr, i3, i4);
    }
}
