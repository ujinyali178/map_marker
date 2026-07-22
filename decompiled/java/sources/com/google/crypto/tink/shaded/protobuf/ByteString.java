package com.google.crypto.tink.shaded.protobuf;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final ByteArrayCopier byteArrayCopier;
    private int hash = 0;

    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i3, int i4) {
            return Arrays.copyOfRange(bArr, i3, i4 + i3);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i3, int i4) {
            super(bArr);
            ByteString.checkRange(i3, i3 + i4, bArr.length);
            this.bytesOffset = i3;
            this.bytesLength = i4;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int i3) {
            ByteString.checkIndex(i3, size());
            return this.bytes[this.bytesOffset + i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i3, int i4, int i5) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i3, bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        byte internalByteAt(int i3) {
            return this.bytes[this.bytesOffset + i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    private interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i3, int i4);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        private CodedBuilder(int i3) {
            byte[] bArr = new byte[i3];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }
    }

    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }

        abstract boolean equalsRange(ByteString byteString, int i3, int i4);

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final boolean isBalanced() {
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        void writeToReverse(ByteOutput byteOutput) {
            writeTo(byteOutput);
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int i3) {
            return this.bytes[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i3, int i4, int i5) {
            System.arraycopy(this.bytes, i3, bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
        final boolean equalsRange(ByteString byteString, int i3, int i4) {
            if (i4 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i4 + size());
            }
            int i5 = i3 + i4;
            if (i5 > byteString.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i3 + ", " + i4 + ", " + byteString.size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.substring(i3, i5).equals(substring(0, i4));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.bytes;
            byte[] bArr2 = literalByteString.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i4;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i3;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }

        protected int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        byte internalByteAt(int i3) {
            return this.bytes[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int partialHash(int i3, int i4, int i5) {
            return Internal.partialHash(i3, this.bytes, getOffsetIntoBytes() + i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int partialIsValidUtf8(int i3, int i4, int i5) {
            int offsetIntoBytes = getOffsetIntoBytes() + i4;
            return Utf8.partialIsValidUtf8(i3, this.bytes, offsetIntoBytes, i5 + offsetIntoBytes);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteString substring(int i3, int i4) {
            int checkRange = ByteString.checkRange(i3, i4, size());
            return checkRange == 0 ? ByteString.EMPTY : new BoundedByteString(this.bytes, getOffsetIntoBytes() + i3, checkRange);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void writeTo(ByteOutput byteOutput) {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) {
            outputStream.write(toByteArray());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void writeToInternal(OutputStream outputStream, int i3, int i4) {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i3, i4);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        Output(int i3) {
            if (i3 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.initialCapacity = i3;
            this.flushedBuffers = new ArrayList<>();
            this.buffer = new byte[i3];
        }

        private byte[] copyArray(byte[] bArr, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i3));
            return bArr2;
        }

        private void flushFullBuffer(int i3) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i3, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i3 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i3 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i3 > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i3)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i3) {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i4 = this.bufferPos;
            this.bufferPos = i4 + 1;
            bArr[i4] = (byte) i3;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i3, int i4) {
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i5 = this.bufferPos;
            if (i4 <= length - i5) {
                System.arraycopy(bArr, i3, bArr2, i5, i4);
                this.bufferPos += i4;
            } else {
                int length2 = bArr2.length - i5;
                System.arraycopy(bArr, i3, bArr2, i5, length2);
                int i6 = i4 - length2;
                flushFullBuffer(i6);
                System.arraycopy(bArr, i3 + length2, this.buffer, 0, i6);
                this.bufferPos = i6;
            }
        }

        public void writeTo(OutputStream outputStream) {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i3;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.flushedBuffers;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.buffer;
                i3 = this.bufferPos;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.writeTo(outputStream);
            }
            outputStream.write(copyArray(bArr, i3));
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i3, int i4) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            return bArr2;
        }
    }

    static {
        byteArrayCopier = Android.isOnAndroidDevice() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.shaded.protobuf.ByteString$ByteIterator, java.util.Iterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [com.google.crypto.tink.shaded.protobuf.ByteString$ByteIterator, java.util.Iterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? iterator2 = byteString.iterator2();
                ?? iterator22 = byteString2.iterator2();
                while (iterator2.hasNext() && iterator22.hasNext()) {
                    int compareTo = Integer.valueOf(ByteString.toInt(iterator2.nextByte())).compareTo(Integer.valueOf(ByteString.toInt(iterator22.nextByte())));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    ByteString() {
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i3)));
        }
        if (i3 == 1) {
            return it.next();
        }
        int i4 = i3 >>> 1;
        return balancedConcat(it, i4).concat(balancedConcat(it, i3 - i4));
    }

    static void checkIndex(int i3, int i4) {
        if (((i4 - (i3 + 1)) | i3) < 0) {
            if (i3 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
        }
    }

    static int checkRange(int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if ((i3 | i4 | i6 | (i5 - i4)) >= 0) {
            return i6;
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i3 + " < 0");
        }
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i3 + ", " + i4);
        }
        throw new IndexOutOfBoundsException("End index: " + i4 + " >= " + i5);
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            size = 0;
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? EMPTY : balancedConcat(iterable.iterator(), size);
    }

    public static ByteString copyFrom(String str, String str2) {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i3) {
        checkRange(0, i3, byteBuffer.remaining());
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(byte[] bArr, int i3, int i4) {
        checkRange(i3, i3 + i4, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i3, i4));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.UTF_8));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String str, int i3) {
        int hexDigit = hexDigit(str.charAt(i3));
        if (hexDigit != -1) {
            return hexDigit;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i3) + " at index " + i3);
    }

    public static ByteString fromHex(String str) {
        if (str.length() % 2 != 0) {
            throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            bArr[i3] = (byte) (extractHexDigit(str, i4 + 1) | (extractHexDigit(str, i4) << 4));
        }
        return new LiteralByteString(bArr);
    }

    private static int hexDigit(char c3) {
        if (c3 >= '0' && c3 <= '9') {
            return c3 - '0';
        }
        char c4 = 'A';
        if (c3 < 'A' || c3 > 'F') {
            c4 = 'a';
            if (c3 < 'a' || c3 > 'f') {
                return -1;
            }
        }
        return (c3 - c4) + 10;
    }

    static CodedBuilder newCodedBuilder(int i3) {
        return new CodedBuilder(i3);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public static Output newOutput(int i3) {
        return new Output(i3);
    }

    private static ByteString readChunk(InputStream inputStream, int i3) {
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            int read = inputStream.read(bArr, i4, i3 - i4);
            if (read == -1) {
                break;
            }
            i4 += read;
        }
        if (i4 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i4);
    }

    public static ByteString readFrom(InputStream inputStream) {
        return readFrom(inputStream, 256, MAX_READ_FROM_CHUNK_SIZE);
    }

    public static ByteString readFrom(InputStream inputStream, int i3) {
        return readFrom(inputStream, i3, i3);
    }

    public static ByteString readFrom(InputStream inputStream, int i3, int i4) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i3);
            if (readChunk == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(readChunk);
            i3 = Math.min(i3 * 2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int toInt(byte b4) {
        return b4 & UnsignedBytes.MAX_VALUE;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return TextFormatEscaper.escapeBytes(this);
        }
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    static ByteString wrap(byte[] bArr, int i3, int i4) {
        return new BoundedByteString(bArr, i3, i4);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i3);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i3) {
        copyTo(bArr, 0, i3, size());
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i3, int i4, int i5) {
        checkRange(i3, i3 + i5, size());
        checkRange(i4, i4 + i5, bArr.length);
        if (i5 > 0) {
            copyToInternal(bArr, i3, i4, i5);
        }
    }

    protected abstract void copyToInternal(byte[] bArr, int i3, int i4, int i5);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    protected abstract int getTreeDepth();

    public final int hashCode() {
        int i3 = this.hash;
        if (i3 == 0) {
            int size = size();
            i3 = partialHash(size, 0, size);
            if (i3 == 0) {
                i3 = 1;
            }
            this.hash = i3;
        }
        return i3;
    }

    abstract byte internalByteAt(int i3);

    protected abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new AbstractByteIterator() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.1
            private final int limit;
            private int position = 0;

            {
                this.limit = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < this.limit;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i3 = this.position;
                if (i3 >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.position = i3 + 1;
                return ByteString.this.internalByteAt(i3);
            }
        };
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    protected abstract int partialHash(int i3, int i4, int i5);

    protected abstract int partialIsValidUtf8(int i3, int i4, int i5);

    protected final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i3) {
        return substring(i3, size());
    }

    public abstract ByteString substring(int i3, int i4);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay());
    }

    public final String toString(String str) {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e3) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e3);
            throw unsupportedEncodingException;
        }
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    protected abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    abstract void writeTo(ByteOutput byteOutput);

    public abstract void writeTo(OutputStream outputStream);

    final void writeTo(OutputStream outputStream, int i3, int i4) {
        checkRange(i3, i3 + i4, size());
        if (i4 > 0) {
            writeToInternal(outputStream, i3, i4);
        }
    }

    abstract void writeToInternal(OutputStream outputStream, int i3, int i4);

    abstract void writeToReverse(ByteOutput byteOutput);
}
