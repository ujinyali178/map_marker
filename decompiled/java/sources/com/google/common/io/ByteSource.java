package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ByteSource {

    class AsCharSource extends CharSource {
        final Charset charset;

        AsCharSource(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource asByteSource(Charset charset) {
            return charset.equals(this.charset) ? ByteSource.this : super.asByteSource(charset);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        @Override // com.google.common.io.CharSource
        public String read() {
            return new String(ByteSource.this.read(), this.charset);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
        }
    }

    private static class ByteArrayByteSource extends ByteSource {
        final byte[] bytes;
        final int length;
        final int offset;

        ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        ByteArrayByteSource(byte[] bArr, int i3, int i4) {
            this.bytes = bArr;
            this.offset = i3;
            this.length = i4;
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream outputStream) {
            outputStream.write(this.bytes, this.offset, this.length);
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction hashFunction) {
            return hashFunction.hashBytes(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            return this.length == 0;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        @ParametricNullness
        public <T> T read(ByteProcessor<T> byteProcessor) {
            byteProcessor.processBytes(this.bytes, this.offset, this.length);
            return byteProcessor.getResult();
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] bArr = this.bytes;
            int i3 = this.offset;
            return Arrays.copyOfRange(bArr, i3, this.length + i3);
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf(this.length));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j3, long j4) {
            Preconditions.checkArgument(j3 >= 0, "offset (%s) may not be negative", j3);
            Preconditions.checkArgument(j4 >= 0, "length (%s) may not be negative", j4);
            long min = Math.min(j3, this.length);
            return new ByteArrayByteSource(this.bytes, this.offset + ((int) min), (int) Math.min(j4, this.length - min));
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...") + ")";
        }
    }

    private static final class ConcatenatedByteSource extends ByteSource {
        final Iterable<? extends ByteSource> sources;

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            Iterator<? extends ByteSource> it = this.sources.iterator();
            while (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new MultiInputStream(this.sources.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            Iterator<? extends ByteSource> it = this.sources.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                j3 += it.next().size();
                if (j3 < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j3;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            long valueOf;
            Iterable<? extends ByteSource> iterable = this.sources;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            Iterator<? extends ByteSource> it = iterable.iterator();
            long j3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    valueOf = Long.valueOf(j3);
                    break;
                }
                Optional<Long> sizeIfKnown = it.next().sizeIfKnown();
                if (!sizeIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j3 += sizeIfKnown.get().longValue();
                if (j3 < 0) {
                    valueOf = Long.MAX_VALUE;
                    break;
                }
            }
            return Optional.of(valueOf);
        }

        public String toString() {
            return "ByteSource.concat(" + this.sources + ")";
        }
    }

    private static final class EmptyByteSource extends ByteArrayByteSource {
        static final EmptyByteSource INSTANCE = new EmptyByteSource();

        EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.bytes;
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    private final class SlicedByteSource extends ByteSource {
        final long length;
        final long offset;

        SlicedByteSource(long j3, long j4) {
            Preconditions.checkArgument(j3 >= 0, "offset (%s) may not be negative", j3);
            Preconditions.checkArgument(j4 >= 0, "length (%s) may not be negative", j4);
            this.offset = j3;
            this.length = j4;
        }

        private InputStream sliceStream(InputStream inputStream) {
            long j3 = this.offset;
            if (j3 > 0) {
                try {
                    if (ByteStreams.skipUpTo(inputStream, j3) < this.offset) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } finally {
                }
            }
            return ByteStreams.limit(inputStream, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            return this.length == 0 || super.isEmpty();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() {
            return sliceStream(ByteSource.this.openBufferedStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return sliceStream(ByteSource.this.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Optional<Long> sizeIfKnown = ByteSource.this.sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return Optional.absent();
            }
            long longValue = sizeIfKnown.get().longValue();
            return Optional.of(Long.valueOf(Math.min(this.length, longValue - Math.min(this.offset, longValue))));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j3, long j4) {
            Preconditions.checkArgument(j3 >= 0, "offset (%s) may not be negative", j3);
            Preconditions.checkArgument(j4 >= 0, "length (%s) may not be negative", j4);
            long j5 = this.length - j3;
            return j5 <= 0 ? ByteSource.empty() : ByteSource.this.slice(this.offset + j3, Math.min(j4, j5));
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    protected ByteSource() {
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat(ImmutableList.copyOf(byteSourceArr));
    }

    private long countBySkipping(InputStream inputStream) {
        long j3 = 0;
        while (true) {
            long skipUpTo = ByteStreams.skipUpTo(inputStream, 2147483647L);
            if (skipUpTo <= 0) {
                return j3;
            }
            j3 += skipUpTo;
        }
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }

    public static ByteSource wrap(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public boolean contentEquals(ByteSource byteSource) {
        int read;
        Preconditions.checkNotNull(byteSource);
        byte[] createBuffer = ByteStreams.createBuffer();
        byte[] createBuffer2 = ByteStreams.createBuffer();
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, createBuffer, 0, createBuffer.length);
                if (read == ByteStreams.read(inputStream2, createBuffer2, 0, createBuffer2.length) && Arrays.equals(createBuffer, createBuffer2)) {
                }
                return false;
            } while (read == createBuffer.length);
            return true;
        } finally {
        }
    }

    public long copyTo(ByteSink byteSink) {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            return ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
        } finally {
        }
    }

    public long copyTo(OutputStream outputStream) {
        Preconditions.checkNotNull(outputStream);
        try {
            return ByteStreams.copy((InputStream) Closer.create().register(openStream()), outputStream);
        } finally {
        }
    }

    public HashCode hash(HashFunction hashFunction) {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean isEmpty() {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue() == 0;
        }
        Closer create = Closer.create();
        try {
            return ((InputStream) create.register(openStream())).read() == -1;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public InputStream openBufferedStream() {
        InputStream openStream = openStream();
        return openStream instanceof BufferedInputStream ? (BufferedInputStream) openStream : new BufferedInputStream(openStream);
    }

    public abstract InputStream openStream();

    @ParametricNullness
    public <T> T read(ByteProcessor<T> byteProcessor) {
        Preconditions.checkNotNull(byteProcessor);
        try {
            return (T) ByteStreams.readBytes((InputStream) Closer.create().register(openStream()), byteProcessor);
        } finally {
        }
    }

    public byte[] read() {
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            Optional<Long> sizeIfKnown = sizeIfKnown();
            return sizeIfKnown.isPresent() ? ByteStreams.toByteArray(inputStream, sizeIfKnown.get().longValue()) : ByteStreams.toByteArray(inputStream);
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public long size() {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue();
        }
        Closer create = Closer.create();
        try {
            return countBySkipping((InputStream) create.register(openStream()));
        } catch (IOException unused) {
            create.close();
            try {
                return ByteStreams.exhaust((InputStream) Closer.create().register(openStream()));
            } finally {
            }
        } finally {
        }
    }

    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public ByteSource slice(long j3, long j4) {
        return new SlicedByteSource(j3, j4);
    }
}
