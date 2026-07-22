package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

/* loaded from: /root/release/classes2.dex */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file, Charset charset, TailerListener tailerListener, long j3, boolean z3, boolean z4, int i3) {
        this.run = true;
        this.file = file;
        this.delayMillis = j3;
        this.end = z3;
        this.inbuf = new byte[i3];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z4;
        this.cset = charset;
    }

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000L);
    }

    public Tailer(File file, TailerListener tailerListener, long j3) {
        this(file, tailerListener, j3, false);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z3) {
        this(file, tailerListener, j3, z3, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z3, int i3) {
        this(file, tailerListener, j3, z3, false, i3);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z3, boolean z4) {
        this(file, tailerListener, j3, z3, z4, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z3, boolean z4, int i3) {
        this(file, DEFAULT_CHARSET, tailerListener, j3, z3, z4, i3);
    }

    public static Tailer create(File file, Charset charset, TailerListener tailerListener, long j3, boolean z3, boolean z4, int i3) {
        Tailer tailer = new Tailer(file, charset, tailerListener, j3, z3, z4, i3);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return create(file, tailerListener, 1000L, false);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3) {
        return create(file, tailerListener, j3, false);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z3) {
        return create(file, tailerListener, j3, z3, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z3, int i3) {
        return create(file, tailerListener, j3, z3, false, i3);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z3, boolean z4) {
        return create(file, tailerListener, j3, z3, z4, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z3, boolean z4, int i3) {
        return create(file, DEFAULT_CHARSET, tailerListener, j3, z3, z4, i3);
    }

    private long readLines(RandomAccessFile randomAccessFile) {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        try {
            long filePointer = randomAccessFile.getFilePointer();
            long j3 = filePointer;
            boolean z3 = false;
            while (getRun() && (read = randomAccessFile.read(this.inbuf)) != -1) {
                for (int i3 = 0; i3 < read; i3++) {
                    byte b4 = this.inbuf[i3];
                    if (b4 == 10) {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        filePointer = i3 + j3 + 1;
                        z3 = false;
                    } else if (b4 != 13) {
                        if (z3) {
                            this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                            byteArrayOutputStream.reset();
                            filePointer = i3 + j3 + 1;
                            z3 = false;
                        }
                        byteArrayOutputStream.write(b4);
                    } else {
                        if (z3) {
                            byteArrayOutputStream.write(13);
                        }
                        z3 = true;
                    }
                }
                j3 = randomAccessFile.getFilePointer();
            }
            randomAccessFile.seek(filePointer);
            TailerListener tailerListener = this.listener;
            if (tailerListener instanceof TailerListenerAdapter) {
                ((TailerListenerAdapter) tailerListener).endOfFileReached();
            }
            byteArrayOutputStream.close();
            return filePointer;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    protected boolean getRun() {
        return this.run;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        long readLines;
        File file;
        RandomAccessFile randomAccessFile2 = null;
        long j3 = 0;
        long j4 = 0;
        while (getRun() && randomAccessFile2 == null) {
            try {
                try {
                    try {
                        randomAccessFile2 = new RandomAccessFile(this.file, RAF_MODE);
                    } catch (FileNotFoundException unused) {
                        this.listener.fileNotFound();
                    }
                    if (randomAccessFile2 == null) {
                        Thread.sleep(this.delayMillis);
                    } else {
                        j4 = this.end ? this.file.length() : 0L;
                        j3 = this.file.lastModified();
                        randomAccessFile2.seek(j4);
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (InterruptedException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
        }
        while (getRun()) {
            boolean isFileNewer = FileUtils.isFileNewer(this.file, j3);
            long length = this.file.length();
            if (length < j4) {
                this.listener.fileRotated();
                try {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                    try {
                        try {
                            readLines(randomAccessFile2);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable th4) {
                                        try {
                                            th.addSuppressed(th4);
                                        } catch (FileNotFoundException unused2) {
                                            randomAccessFile2 = randomAccessFile;
                                            this.listener.fileNotFound();
                                            Thread.sleep(this.delayMillis);
                                        }
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (IOException e5) {
                        this.listener.handle(e5);
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            try {
                                randomAccessFile2.close();
                            } catch (FileNotFoundException unused3) {
                                j4 = 0;
                                randomAccessFile2 = randomAccessFile;
                                this.listener.fileNotFound();
                                Thread.sleep(this.delayMillis);
                            }
                        } catch (InterruptedException e6) {
                            e = e6;
                            randomAccessFile2 = randomAccessFile;
                            Thread.currentThread().interrupt();
                            this.listener.handle(e);
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e7) {
                                    e = e7;
                                    this.listener.handle(e);
                                    stop();
                                }
                            }
                            stop();
                        } catch (Exception e8) {
                            e = e8;
                            randomAccessFile2 = randomAccessFile;
                            this.listener.handle(e);
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e9) {
                                    e = e9;
                                    this.listener.handle(e);
                                    stop();
                                }
                            }
                            stop();
                        } catch (Throwable th5) {
                            th = th5;
                            randomAccessFile2 = randomAccessFile;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e10) {
                                    this.listener.handle(e10);
                                }
                            }
                            stop();
                            throw th;
                        }
                    }
                    j4 = 0;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th6) {
                    th = th6;
                    randomAccessFile = randomAccessFile2;
                }
            } else {
                if (length > j4) {
                    readLines = readLines(randomAccessFile2);
                    file = this.file;
                } else {
                    if (isFileNewer) {
                        randomAccessFile2.seek(0L);
                        readLines = readLines(randomAccessFile2);
                        file = this.file;
                    }
                    if (this.reOpen && randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    Thread.sleep(this.delayMillis);
                    if (getRun() && this.reOpen) {
                        randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                        randomAccessFile.seek(j4);
                        randomAccessFile2 = randomAccessFile;
                    }
                }
                long j5 = readLines;
                j3 = file.lastModified();
                j4 = j5;
                if (this.reOpen) {
                    randomAccessFile2.close();
                }
                Thread.sleep(this.delayMillis);
                if (getRun()) {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                    randomAccessFile.seek(j4);
                    randomAccessFile2 = randomAccessFile;
                }
            }
        }
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e11) {
                e = e11;
                this.listener.handle(e);
                stop();
            }
        }
        stop();
    }

    public void stop() {
        this.run = false;
    }
}
