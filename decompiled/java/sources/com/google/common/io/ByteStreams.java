package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i3) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkPositionIndexes(i3, i4 + i3, bArr.length);
        }
    };
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    private static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e3) {
                throw new IllegalStateException(e3);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.input.readFully(bArr);
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr, int i3, int i4) {
            try {
                this.input.readFully(bArr, i3, i4);
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        @CheckForNull
        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int i3) {
            try {
                return this.input.skipBytes(i3);
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputStream;
        final DataOutput output;

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputStream = byteArrayOutputStream;
            this.output = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputStream.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int i3) {
            try {
                this.output.write(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.output.write(bArr);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr, int i3, int i4) {
            try {
                this.output.write(bArr, i3, i4);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean z3) {
            try {
                this.output.writeBoolean(z3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int i3) {
            try {
                this.output.writeByte(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.output.writeBytes(str);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int i3) {
            try {
                this.output.writeChar(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.output.writeChars(str);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double d3) {
            try {
                this.output.writeDouble(d3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float f3) {
            try {
                this.output.writeFloat(f3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int i3) {
            try {
                this.output.writeInt(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long j3) {
            try {
                this.output.writeLong(j3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int i3) {
            try {
                this.output.writeShort(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.output.writeUTF(str);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    private static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        LimitedInputStream(InputStream inputStream, long j3) {
            super(inputStream);
            this.mark = -1L;
            Preconditions.checkNotNull(inputStream);
            Preconditions.checkArgument(j3 >= 0, "limit must be non-negative");
            this.left = j3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i3) {
            ((FilterInputStream) this).in.mark(i3);
            this.mark = this.left;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            if (this.left == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            long j3 = this.left;
            if (j3 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i3, (int) Math.min(i4, j3));
            if (read != -1) {
                this.left -= read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.left = this.mark;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j3) {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j3, this.left));
            this.left -= skip;
            return skip;
        }
    }

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Queue<byte[]> queue, int i3) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i3) {
            return remove;
        }
        int length = i3 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i3);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i3 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] createBuffer = createBuffer();
        long j3 = 0;
        while (true) {
            int read = inputStream.read(createBuffer);
            if (read == -1) {
                return j3;
            }
            outputStream.write(createBuffer, 0, read);
            j3 += read;
        }
    }

    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j3 = 0;
        if (!(readableByteChannel instanceof FileChannel)) {
            ByteBuffer wrap = ByteBuffer.wrap(createBuffer());
            while (readableByteChannel.read(wrap) != -1) {
                Java8Compatibility.flip(wrap);
                while (wrap.hasRemaining()) {
                    j3 += writableByteChannel.write(wrap);
                }
                Java8Compatibility.clear(wrap);
            }
            return j3;
        }
        FileChannel fileChannel = (FileChannel) readableByteChannel;
        long position = fileChannel.position();
        long j4 = position;
        while (true) {
            long transferTo = fileChannel.transferTo(j4, 524288L, writableByteChannel);
            j4 += transferTo;
            fileChannel.position(j4);
            if (transferTo <= 0 && j4 >= fileChannel.size()) {
                return j4 - position;
            }
        }
    }

    static byte[] createBuffer() {
        return new byte[BUFFER_SIZE];
    }

    public static long exhaust(InputStream inputStream) {
        byte[] createBuffer = createBuffer();
        long j3 = 0;
        while (true) {
            long read = inputStream.read(createBuffer);
            if (read == -1) {
                return j3;
            }
            j3 += read;
        }
    }

    public static InputStream limit(InputStream inputStream, long j3) {
        return new LimitedInputStream(inputStream, j3);
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    public static ByteArrayDataInput newDataInput(byte[] bArr, int i3) {
        Preconditions.checkPositionIndex(i3, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i3, bArr.length - i3));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    public static ByteArrayDataOutput newDataOutput(int i3) {
        if (i3 >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i3));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i3)));
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static int read(InputStream inputStream, byte[] bArr, int i3, int i4) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        int i5 = 0;
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i4)));
        }
        Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
        while (i5 < i4) {
            int read = inputStream.read(bArr, i3 + i5, i4 - i5);
            if (read == -1) {
                break;
            }
            i5 += read;
        }
        return i5;
    }

    @ParametricNullness
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] createBuffer = createBuffer();
        do {
            read = inputStream.read(createBuffer);
            if (read == -1) {
                break;
            }
        } while (byteProcessor.processBytes(createBuffer, 0, read));
        return byteProcessor.getResult();
    }

    public static void readFully(InputStream inputStream, byte[] bArr) {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i3, int i4) {
        int read = read(inputStream, bArr, i3, i4);
        if (read == i4) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + read + " bytes; " + i4 + " bytes expected");
    }

    public static void skipFully(InputStream inputStream, long j3) {
        long skipUpTo = skipUpTo(inputStream, j3);
        if (skipUpTo >= j3) {
            return;
        }
        throw new EOFException("reached end of stream after skipping " + skipUpTo + " bytes; " + j3 + " bytes expected");
    }

    private static long skipSafely(InputStream inputStream, long j3) {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(available, j3));
    }

    static long skipUpTo(InputStream inputStream, long j3) {
        byte[] bArr = null;
        long j4 = 0;
        while (j4 < j3) {
            long j5 = j3 - j4;
            long skipSafely = skipSafely(inputStream, j5);
            if (skipSafely == 0) {
                int min = (int) Math.min(j5, 8192L);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                skipSafely = inputStream.read(bArr, 0, min);
                if (skipSafely == -1) {
                    break;
                }
            }
            j4 += skipSafely;
        }
        return j4;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    static byte[] toByteArray(InputStream inputStream, long j3) {
        Preconditions.checkArgument(j3 >= 0, "expectedSize (%s) must be non-negative", j3);
        if (j3 > 2147483639) {
            throw new OutOfMemoryError(j3 + " bytes is too large to fit in a byte array");
        }
        int i3 = (int) j3;
        byte[] bArr = new byte[i3];
        int i4 = i3;
        while (i4 > 0) {
            int i5 = i3 - i4;
            int read = inputStream.read(bArr, i5, i4);
            if (read == -1) {
                return Arrays.copyOf(bArr, i5);
            }
            i4 -= read;
        }
        int read2 = inputStream.read();
        if (read2 == -1) {
            return bArr;
        }
        ArrayDeque arrayDeque = new ArrayDeque(22);
        arrayDeque.add(bArr);
        arrayDeque.add(new byte[]{(byte) read2});
        return toByteArrayInternal(inputStream, arrayDeque, i3 + 1);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Queue<byte[]> queue, int i3) {
        int min = Math.min(BUFFER_SIZE, Math.max(128, Integer.highestOneBit(i3) * 2));
        while (i3 < MAX_ARRAY_LEN) {
            int min2 = Math.min(min, MAX_ARRAY_LEN - i3);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i4 = 0;
            while (i4 < min2) {
                int read = inputStream.read(bArr, i4, min2 - i4);
                if (read == -1) {
                    return combineBuffers(queue, i3);
                }
                i4 += read;
                i3 += read;
            }
            min = IntMath.saturatedMultiply(min, min < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
