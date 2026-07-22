package org.apache.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

/* loaded from: /root/release/classes2.dex */
public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final int EOF = -1;
    public static final String LINE_SEPARATOR;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte[] SKIP_BYTE_BUFFER;
    private static char[] SKIP_CHAR_BUFFER;

    static {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        try {
            PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
            try {
                printWriter.println();
                LINE_SEPARATOR = stringBuilderWriter.toString();
                printWriter.close();
                stringBuilderWriter.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static BufferedInputStream buffer(InputStream inputStream) {
        inputStream.getClass();
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static BufferedInputStream buffer(InputStream inputStream, int i3) {
        inputStream.getClass();
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i3);
    }

    public static BufferedOutputStream buffer(OutputStream outputStream) {
        outputStream.getClass();
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static BufferedOutputStream buffer(OutputStream outputStream, int i3) {
        outputStream.getClass();
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i3);
    }

    public static BufferedReader buffer(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedReader buffer(Reader reader, int i3) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i3);
    }

    public static BufferedWriter buffer(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static BufferedWriter buffer(Writer writer, int i3) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i3);
    }

    public static void close(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    @Deprecated
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Deprecated
    public static void closeQuietly(InputStream inputStream) {
        closeQuietly((Closeable) inputStream);
    }

    @Deprecated
    public static void closeQuietly(OutputStream outputStream) {
        closeQuietly((Closeable) outputStream);
    }

    @Deprecated
    public static void closeQuietly(Reader reader) {
        closeQuietly((Closeable) reader);
    }

    @Deprecated
    public static void closeQuietly(Writer writer) {
        closeQuietly((Closeable) writer);
    }

    @Deprecated
    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException unused) {
            }
        }
    }

    @Deprecated
    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    @Deprecated
    public static void closeQuietly(Selector selector) {
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
    }

    @Deprecated
    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            closeQuietly(closeable);
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) {
        int read;
        if (inputStream == inputStream2) {
            return true;
        }
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        do {
            read = inputStream.read();
            if (-1 == read) {
                return inputStream2.read() == -1;
            }
        } while (read == inputStream2.read());
        return false;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) {
        int read;
        if (reader == reader2) {
            return true;
        }
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        do {
            read = bufferedReader.read();
            if (-1 == read) {
                return bufferedReader2.read() == -1;
            }
        } while (read == bufferedReader2.read());
        return false;
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) {
        String readLine;
        String readLine2;
        if (reader == reader2) {
            return true;
        }
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        do {
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
            if (readLine == null || readLine2 == null) {
                break;
            }
        } while (readLine.equals(readLine2));
        return readLine == null ? readLine2 == null : readLine.equals(readLine2);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static int copy(Reader reader, Writer writer) {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i3) {
        return copyLarge(inputStream, outputStream, new byte[i3]);
    }

    @Deprecated
    public static void copy(InputStream inputStream, Writer writer) {
        copy(inputStream, writer, Charset.defaultCharset());
    }

    public static void copy(InputStream inputStream, Writer writer, String str) {
        copy(inputStream, writer, Charsets.toCharset(str));
    }

    public static void copy(InputStream inputStream, Writer writer, Charset charset) {
        copy(new InputStreamReader(inputStream, Charsets.toCharset(charset)), writer);
    }

    @Deprecated
    public static void copy(Reader reader, OutputStream outputStream) {
        copy(reader, outputStream, Charset.defaultCharset());
    }

    public static void copy(Reader reader, OutputStream outputStream, String str) {
        copy(reader, outputStream, Charsets.toCharset(str));
    }

    public static void copy(Reader reader, OutputStream outputStream, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.toCharset(charset));
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream, 4096);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j3, long j4) {
        return copyLarge(inputStream, outputStream, j3, j4, new byte[4096]);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j3, long j4, byte[] bArr) {
        long j5 = 0;
        if (j3 > 0) {
            skipFully(inputStream, j3);
        }
        if (j4 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int i3 = (j4 <= 0 || j4 >= ((long) length)) ? length : (int) j4;
        while (i3 > 0) {
            int read = inputStream.read(bArr, 0, i3);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j5 += read;
            if (j4 > 0) {
                i3 = (int) Math.min(j4 - j5, length);
            }
        }
        return j5;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }

    public static long copyLarge(Reader reader, Writer writer) {
        return copyLarge(reader, writer, new char[4096]);
    }

    public static long copyLarge(Reader reader, Writer writer, long j3, long j4) {
        return copyLarge(reader, writer, j3, j4, new char[4096]);
    }

    public static long copyLarge(Reader reader, Writer writer, long j3, long j4, char[] cArr) {
        long j5 = 0;
        if (j3 > 0) {
            skipFully(reader, j3);
        }
        if (j4 == 0) {
            return 0L;
        }
        int length = cArr.length;
        if (j4 > 0 && j4 < cArr.length) {
            length = (int) j4;
        }
        while (length > 0) {
            int read = reader.read(cArr, 0, length);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j5 += read;
            if (j4 > 0) {
                length = (int) Math.min(j4 - j5, cArr.length);
            }
        }
        return j5;
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArr) {
        long j3 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j3;
            }
            writer.write(cArr, 0, read);
            j3 += read;
        }
    }

    public static LineIterator lineIterator(InputStream inputStream, String str) {
        return lineIterator(inputStream, Charsets.toCharset(str));
    }

    public static LineIterator lineIterator(InputStream inputStream, Charset charset) {
        return new LineIterator(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static LineIterator lineIterator(Reader reader) {
        return new LineIterator(reader);
    }

    public static int read(InputStream inputStream, byte[] bArr) {
        return read(inputStream, bArr, 0, bArr.length);
    }

    public static int read(InputStream inputStream, byte[] bArr, int i3, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + i4);
        }
        int i5 = i4;
        while (i5 > 0) {
            int read = inputStream.read(bArr, (i4 - i5) + i3, i5);
            if (-1 == read) {
                break;
            }
            i5 -= read;
        }
        return i4 - i5;
    }

    public static int read(Reader reader, char[] cArr) {
        return read(reader, cArr, 0, cArr.length);
    }

    public static int read(Reader reader, char[] cArr, int i3, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + i4);
        }
        int i5 = i4;
        while (i5 > 0) {
            int read = reader.read(cArr, (i4 - i5) + i3, i5);
            if (-1 == read) {
                break;
            }
            i5 -= read;
        }
        return i4 - i5;
    }

    public static int read(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        while (byteBuffer.remaining() > 0 && -1 != readableByteChannel.read(byteBuffer)) {
        }
        return remaining - byteBuffer.remaining();
    }

    public static void readFully(InputStream inputStream, byte[] bArr) {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i3, int i4) {
        int read = read(inputStream, bArr, i3, i4);
        if (read == i4) {
            return;
        }
        throw new EOFException("Length to read: " + i4 + " actual: " + read);
    }

    public static void readFully(Reader reader, char[] cArr) {
        readFully(reader, cArr, 0, cArr.length);
    }

    public static void readFully(Reader reader, char[] cArr, int i3, int i4) {
        int read = read(reader, cArr, i3, i4);
        if (read == i4) {
            return;
        }
        throw new EOFException("Length to read: " + i4 + " actual: " + read);
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int read = read(readableByteChannel, byteBuffer);
        if (read == remaining) {
            return;
        }
        throw new EOFException("Length to read: " + remaining + " actual: " + read);
    }

    public static byte[] readFully(InputStream inputStream, int i3) {
        byte[] bArr = new byte[i3];
        readFully(inputStream, bArr, 0, i3);
        return bArr;
    }

    @Deprecated
    public static List<String> readLines(InputStream inputStream) {
        return readLines(inputStream, Charset.defaultCharset());
    }

    public static List<String> readLines(InputStream inputStream, String str) {
        return readLines(inputStream, Charsets.toCharset(str));
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) {
        return readLines(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static List<String> readLines(Reader reader) {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static byte[] resourceToByteArray(String str) {
        return resourceToByteArray(str, null);
    }

    public static byte[] resourceToByteArray(String str, ClassLoader classLoader) {
        return toByteArray(resourceToURL(str, classLoader));
    }

    public static String resourceToString(String str, Charset charset) {
        return resourceToString(str, charset, null);
    }

    public static String resourceToString(String str, Charset charset, ClassLoader classLoader) {
        return toString(resourceToURL(str, classLoader), charset);
    }

    public static URL resourceToURL(String str) {
        return resourceToURL(str, null);
    }

    public static URL resourceToURL(String str, ClassLoader classLoader) {
        URL resource = classLoader == null ? IOUtils.class.getResource(str) : classLoader.getResource(str);
        if (resource != null) {
            return resource;
        }
        throw new IOException("Resource not found: " + str);
    }

    public static long skip(InputStream inputStream, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j3);
        }
        if (SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[SKIP_BUFFER_SIZE];
        }
        long j4 = j3;
        while (j4 > 0) {
            long read = inputStream.read(SKIP_BYTE_BUFFER, 0, (int) Math.min(j4, 2048L));
            if (read < 0) {
                break;
            }
            j4 -= read;
        }
        return j3 - j4;
    }

    public static long skip(Reader reader, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j3);
        }
        if (SKIP_CHAR_BUFFER == null) {
            SKIP_CHAR_BUFFER = new char[SKIP_BUFFER_SIZE];
        }
        long j4 = j3;
        while (j4 > 0) {
            long read = reader.read(SKIP_CHAR_BUFFER, 0, (int) Math.min(j4, 2048L));
            if (read < 0) {
                break;
            }
            j4 -= read;
        }
        return j3 - j4;
    }

    public static long skip(ReadableByteChannel readableByteChannel, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j3);
        }
        ByteBuffer allocate = ByteBuffer.allocate((int) Math.min(j3, 2048L));
        long j4 = j3;
        while (j4 > 0) {
            allocate.position(0);
            allocate.limit((int) Math.min(j4, 2048L));
            int read = readableByteChannel.read(allocate);
            if (read == -1) {
                break;
            }
            j4 -= read;
        }
        return j3 - j4;
    }

    public static void skipFully(InputStream inputStream, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Bytes to skip must not be negative: " + j3);
        }
        long skip = skip(inputStream, j3);
        if (skip == j3) {
            return;
        }
        throw new EOFException("Bytes to skip: " + j3 + " actual: " + skip);
    }

    public static void skipFully(Reader reader, long j3) {
        long skip = skip(reader, j3);
        if (skip == j3) {
            return;
        }
        throw new EOFException("Chars to skip: " + j3 + " actual: " + skip);
    }

    public static void skipFully(ReadableByteChannel readableByteChannel, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Bytes to skip must not be negative: " + j3);
        }
        long skip = skip(readableByteChannel, j3);
        if (skip == j3) {
            return;
        }
        throw new EOFException("Bytes to skip: " + j3 + " actual: " + skip);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i3) {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream, i3);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedReader toBufferedReader(Reader reader, int i3) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i3);
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
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

    public static byte[] toByteArray(InputStream inputStream, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i3);
        }
        int i4 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i3];
        while (i4 < i3) {
            int read = inputStream.read(bArr, i4, i3 - i4);
            if (read == -1) {
                break;
            }
            i4 += read;
        }
        if (i4 == i3) {
            return bArr;
        }
        throw new IOException("Unexpected read size. current: " + i4 + ", expected: " + i3);
    }

    public static byte[] toByteArray(InputStream inputStream, long j3) {
        if (j3 <= 2147483647L) {
            return toByteArray(inputStream, (int) j3);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j3);
    }

    @Deprecated
    public static byte[] toByteArray(Reader reader) {
        return toByteArray(reader, Charset.defaultCharset());
    }

    public static byte[] toByteArray(Reader reader, String str) {
        return toByteArray(reader, Charsets.toCharset(str));
    }

    public static byte[] toByteArray(Reader reader, Charset charset) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(reader, byteArrayOutputStream, charset);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
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

    @Deprecated
    public static byte[] toByteArray(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static byte[] toByteArray(URI uri) {
        return toByteArray(uri.toURL());
    }

    public static byte[] toByteArray(URL url) {
        URLConnection openConnection = url.openConnection();
        try {
            return toByteArray(openConnection);
        } finally {
            close(openConnection);
        }
    }

    public static byte[] toByteArray(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            byte[] byteArray = toByteArray(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static char[] toCharArray(InputStream inputStream) {
        return toCharArray(inputStream, Charset.defaultCharset());
    }

    public static char[] toCharArray(InputStream inputStream, String str) {
        return toCharArray(inputStream, Charsets.toCharset(str));
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(Reader reader) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    @Deprecated
    public static InputStream toInputStream(CharSequence charSequence) {
        return toInputStream(charSequence, Charset.defaultCharset());
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return toInputStream(charSequence, Charsets.toCharset(str));
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return toInputStream(charSequence.toString(), charset);
    }

    @Deprecated
    public static InputStream toInputStream(String str) {
        return toInputStream(str, Charset.defaultCharset());
    }

    public static InputStream toInputStream(String str, String str2) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(str2)));
    }

    public static InputStream toInputStream(String str, Charset charset) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(charset)));
    }

    @Deprecated
    public static String toString(InputStream inputStream) {
        return toString(inputStream, Charset.defaultCharset());
    }

    public static String toString(InputStream inputStream, String str) {
        return toString(inputStream, Charsets.toCharset(str));
    }

    public static String toString(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            copy(inputStream, stringBuilderWriter, charset);
            String stringBuilderWriter2 = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return stringBuilderWriter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static String toString(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            copy(reader, stringBuilderWriter);
            String stringBuilderWriter2 = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return stringBuilderWriter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static String toString(URI uri) {
        return toString(uri, Charset.defaultCharset());
    }

    public static String toString(URI uri, String str) {
        return toString(uri, Charsets.toCharset(str));
    }

    public static String toString(URI uri, Charset charset) {
        return toString(uri.toURL(), Charsets.toCharset(charset));
    }

    @Deprecated
    public static String toString(URL url) {
        return toString(url, Charset.defaultCharset());
    }

    public static String toString(URL url, String str) {
        return toString(url, Charsets.toCharset(str));
    }

    public static String toString(URL url, Charset charset) {
        InputStream openStream = url.openStream();
        try {
            String iOUtils = toString(openStream, charset);
            if (openStream != null) {
                openStream.close();
            }
            return iOUtils;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openStream != null) {
                    try {
                        openStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static String toString(byte[] bArr) {
        return new String(bArr, Charset.defaultCharset());
    }

    public static String toString(byte[] bArr, String str) {
        return new String(bArr, Charsets.toCharset(str));
    }

    @Deprecated
    public static void write(CharSequence charSequence, OutputStream outputStream) {
        write(charSequence, outputStream, Charset.defaultCharset());
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, String str) {
        write(charSequence, outputStream, Charsets.toCharset(str));
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, Charset charset) {
        if (charSequence != null) {
            write(charSequence.toString(), outputStream, charset);
        }
    }

    public static void write(CharSequence charSequence, Writer writer) {
        if (charSequence != null) {
            write(charSequence.toString(), writer);
        }
    }

    @Deprecated
    public static void write(String str, OutputStream outputStream) {
        write(str, outputStream, Charset.defaultCharset());
    }

    public static void write(String str, OutputStream outputStream, String str2) {
        write(str, outputStream, Charsets.toCharset(str2));
    }

    public static void write(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void write(String str, Writer writer) {
        if (str != null) {
            writer.write(str);
        }
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream) {
        write(stringBuffer, outputStream, (String) null);
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream, String str) {
        if (stringBuffer != null) {
            outputStream.write(stringBuffer.toString().getBytes(Charsets.toCharset(str)));
        }
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, Writer writer) {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    public static void write(byte[] bArr, OutputStream outputStream) {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    @Deprecated
    public static void write(byte[] bArr, Writer writer) {
        write(bArr, writer, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, Writer writer, String str) {
        write(bArr, writer, Charsets.toCharset(str));
    }

    public static void write(byte[] bArr, Writer writer, Charset charset) {
        if (bArr != null) {
            writer.write(new String(bArr, Charsets.toCharset(charset)));
        }
    }

    @Deprecated
    public static void write(char[] cArr, OutputStream outputStream) {
        write(cArr, outputStream, Charset.defaultCharset());
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) {
        write(cArr, outputStream, Charsets.toCharset(str));
    }

    public static void write(char[] cArr, OutputStream outputStream, Charset charset) {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void write(char[] cArr, Writer writer) {
        if (cArr != null) {
            writer.write(cArr);
        }
    }

    public static void writeChunked(byte[] bArr, OutputStream outputStream) {
        if (bArr != null) {
            int length = bArr.length;
            int i3 = 0;
            while (length > 0) {
                int min = Math.min(length, 4096);
                outputStream.write(bArr, i3, min);
                length -= min;
                i3 += min;
            }
        }
    }

    public static void writeChunked(char[] cArr, Writer writer) {
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (length > 0) {
                int min = Math.min(length, 4096);
                writer.write(cArr, i3, min);
                length -= min;
                i3 += min;
            }
        }
    }

    @Deprecated
    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream) {
        writeLines(collection, str, outputStream, Charset.defaultCharset());
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, String str2) {
        writeLines(collection, str, outputStream, Charsets.toCharset(str2));
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, Charset charset) {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        Charset charset2 = Charsets.toCharset(charset);
        for (Object obj : collection) {
            if (obj != null) {
                outputStream.write(obj.toString().getBytes(charset2));
            }
            outputStream.write(str.getBytes(charset2));
        }
    }

    public static void writeLines(Collection<?> collection, String str, Writer writer) {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        for (Object obj : collection) {
            if (obj != null) {
                writer.write(obj.toString());
            }
            writer.write(str);
        }
    }
}
