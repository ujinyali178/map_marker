package org.apache.commons.io.output;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes2.dex */
public class DeferredFileOutputStream extends ThresholdingOutputStream {
    private boolean closed;
    private OutputStream currentOutputStream;
    private final File directory;
    private ByteArrayOutputStream memoryOutputStream;
    private File outputFile;
    private final String prefix;
    private final String suffix;

    public DeferredFileOutputStream(int i3, int i4, File file) {
        this(i3, file, null, null, null, i4);
        if (i4 < 0) {
            throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
        }
    }

    public DeferredFileOutputStream(int i3, int i4, String str, String str2, File file) {
        this(i3, null, str, str2, file, i4);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
        }
    }

    public DeferredFileOutputStream(int i3, File file) {
        this(i3, file, null, null, null, UserVerificationMethods.USER_VERIFY_ALL);
    }

    private DeferredFileOutputStream(int i3, File file, String str, String str2, File file2, int i4) {
        super(i3);
        this.closed = false;
        this.outputFile = file;
        this.prefix = str;
        this.suffix = str2;
        this.directory = file2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i4);
        this.memoryOutputStream = byteArrayOutputStream;
        this.currentOutputStream = byteArrayOutputStream;
    }

    public DeferredFileOutputStream(int i3, String str, String str2, File file) {
        this(i3, null, str, str2, file, UserVerificationMethods.USER_VERIFY_ALL);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.closed = true;
    }

    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.memoryOutputStream;
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.outputFile;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected OutputStream getStream() {
        return this.currentOutputStream;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected void thresholdReached() {
        String str = this.prefix;
        if (str != null) {
            this.outputFile = File.createTempFile(str, this.suffix, this.directory);
        }
        FileUtils.forceMkdirParent(this.outputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
        try {
            this.memoryOutputStream.writeTo(fileOutputStream);
            this.currentOutputStream = fileOutputStream;
            this.memoryOutputStream = null;
        } catch (IOException e3) {
            fileOutputStream.close();
            throw e3;
        }
    }

    public void writeTo(OutputStream outputStream) {
        if (!this.closed) {
            throw new IOException("Stream not closed");
        }
        if (isInMemory()) {
            this.memoryOutputStream.writeTo(outputStream);
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(this.outputFile);
        try {
            IOUtils.copy(fileInputStream, outputStream);
            fileInputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
