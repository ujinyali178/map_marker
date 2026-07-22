package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.b;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
public class a {
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    private static final e[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final e[] f846a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final e[] f847b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final e[] f848c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final e[] f849d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final e f850e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final e[] f851f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final e[] f852g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final e[] f853h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final e[] f854i0;

    /* renamed from: j0, reason: collision with root package name */
    static final e[][] f855j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final e[] f856k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final HashMap<Integer, e>[] f857l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final HashMap<String, e>[] f858m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final HashSet<String> f859n0;

    /* renamed from: o0, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f860o0;

    /* renamed from: p0, reason: collision with root package name */
    static final Charset f861p0;

    /* renamed from: q0, reason: collision with root package name */
    static final byte[] f862q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final byte[] f863r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final Pattern f864s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final Pattern f865t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final Pattern f866u0;

    /* renamed from: v0, reason: collision with root package name */
    private static final Pattern f868v0;

    /* renamed from: a, reason: collision with root package name */
    private String f873a;

    /* renamed from: b, reason: collision with root package name */
    private FileDescriptor f874b;

    /* renamed from: c, reason: collision with root package name */
    private AssetManager.AssetInputStream f875c;

    /* renamed from: d, reason: collision with root package name */
    private int f876d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f877e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, d>[] f878f;

    /* renamed from: g, reason: collision with root package name */
    private Set<Integer> f879g;

    /* renamed from: h, reason: collision with root package name */
    private ByteOrder f880h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f881i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f882j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f883k;

    /* renamed from: l, reason: collision with root package name */
    private int f884l;

    /* renamed from: m, reason: collision with root package name */
    private int f885m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f886n;

    /* renamed from: o, reason: collision with root package name */
    private int f887o;

    /* renamed from: p, reason: collision with root package name */
    private int f888p;

    /* renamed from: q, reason: collision with root package name */
    private int f889q;

    /* renamed from: r, reason: collision with root package name */
    private int f890r;

    /* renamed from: s, reason: collision with root package name */
    private int f891s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f892t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f893u;

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f867v = Log.isLoggable("ExifInterface", 3);

    /* renamed from: w, reason: collision with root package name */
    private static final List<Integer> f869w = Arrays.asList(1, 6, 3, 8);

    /* renamed from: x, reason: collision with root package name */
    private static final List<Integer> f870x = Arrays.asList(2, 7, 4, 5);

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f871y = {8, 8, 8};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f872z = {4};
    public static final int[] A = {8};
    static final byte[] B = {-1, -40, -1};
    private static final byte[] C = {102, 116, 121, 112};
    private static final byte[] D = {109, 105, 102, 49};
    private static final byte[] E = {104, 101, 105, 99};
    private static final byte[] F = {79, 76, 89, 77, 80, 0};
    private static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] H = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    private static final byte[] I = {101, 88, 73, 102};
    private static final byte[] J = {73, 72, 68, 82};
    private static final byte[] K = {73, 69, 78, 68};
    private static final byte[] L = {82, 73, 70, 70};
    private static final byte[] M = {87, 69, 66, 80};
    private static final byte[] N = {69, 88, 73, 70};
    private static final byte[] O = {-99, 1, 42};
    private static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: androidx.exifinterface.media.a$a, reason: collision with other inner class name */
    class C0018a extends MediaDataSource {

        /* renamed from: c, reason: collision with root package name */
        long f894c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f895d;

        C0018a(g gVar) {
            this.f895d = gVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public long getSize() {
            return -1L;
        }

        public int readAt(long j3, byte[] bArr, int i3, int i4) {
            if (i4 == 0) {
                return 0;
            }
            if (j3 < 0) {
                return -1;
            }
            try {
                long j4 = this.f894c;
                if (j4 != j3) {
                    if (j4 >= 0 && j3 >= j4 + this.f895d.available()) {
                        return -1;
                    }
                    this.f895d.e(j3);
                    this.f894c = j3;
                }
                if (i4 > this.f895d.available()) {
                    i4 = this.f895d.available();
                }
                int read = this.f895d.read(bArr, i3, i4);
                if (read >= 0) {
                    this.f894c += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f894c = -1L;
            return -1;
        }
    }

    private static class b extends InputStream implements DataInput {

        /* renamed from: h, reason: collision with root package name */
        private static final ByteOrder f897h = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: i, reason: collision with root package name */
        private static final ByteOrder f898i = ByteOrder.BIG_ENDIAN;

        /* renamed from: c, reason: collision with root package name */
        final DataInputStream f899c;

        /* renamed from: d, reason: collision with root package name */
        private ByteOrder f900d;

        /* renamed from: f, reason: collision with root package name */
        int f901f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f902g;

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f900d = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f899c = dataInputStream;
            dataInputStream.mark(0);
            this.f901f = 0;
            this.f900d = byteOrder;
        }

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f901f;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f899c.available();
        }

        public long b() {
            return readInt() & 4294967295L;
        }

        public void c(ByteOrder byteOrder) {
            this.f900d = byteOrder;
        }

        public void d(int i3) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i3 - i4;
                int skip = (int) this.f899c.skip(i5);
                if (skip <= 0) {
                    if (this.f902g == null) {
                        this.f902g = new byte[8192];
                    }
                    skip = this.f899c.read(this.f902g, 0, Math.min(8192, i5));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i3 + " bytes.");
                    }
                }
                i4 += skip;
            }
            this.f901f += i4;
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f901f++;
            return this.f899c.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            int read = this.f899c.read(bArr, i3, i4);
            this.f901f += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f901f++;
            return this.f899c.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f901f++;
            int read = this.f899c.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f901f += 2;
            return this.f899c.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f901f += bArr.length;
            this.f899c.readFully(bArr);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i3, int i4) {
            this.f901f += i4;
            this.f899c.readFully(bArr, i3, i4);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f901f += 4;
            int read = this.f899c.read();
            int read2 = this.f899c.read();
            int read3 = this.f899c.read();
            int read4 = this.f899c.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f900d;
            if (byteOrder == f897h) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f898i) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f900d);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f901f += 8;
            int read = this.f899c.read();
            int read2 = this.f899c.read();
            int read3 = this.f899c.read();
            int read4 = this.f899c.read();
            int read5 = this.f899c.read();
            int read6 = this.f899c.read();
            int read7 = this.f899c.read();
            int read8 = this.f899c.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f900d;
            if (byteOrder == f897h) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f898i) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.f900d);
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f901f += 2;
            int read = this.f899c.read();
            int read2 = this.f899c.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f900d;
            if (byteOrder == f897h) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f898i) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f900d);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f901f += 2;
            return this.f899c.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f901f++;
            return this.f899c.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f901f += 2;
            int read = this.f899c.read();
            int read2 = this.f899c.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f900d;
            if (byteOrder == f897h) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f898i) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f900d);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i3) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }

    private static class c extends FilterOutputStream {

        /* renamed from: c, reason: collision with root package name */
        final OutputStream f903c;

        /* renamed from: d, reason: collision with root package name */
        private ByteOrder f904d;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f903c = outputStream;
            this.f904d = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f904d = byteOrder;
        }

        public void b(int i3) {
            this.f903c.write(i3);
        }

        public void c(int i3) {
            OutputStream outputStream;
            int i4;
            ByteOrder byteOrder = this.f904d;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f903c.write((i3 >>> 0) & 255);
                this.f903c.write((i3 >>> 8) & 255);
                this.f903c.write((i3 >>> 16) & 255);
                outputStream = this.f903c;
                i4 = i3 >>> 24;
            } else {
                if (byteOrder != ByteOrder.BIG_ENDIAN) {
                    return;
                }
                this.f903c.write((i3 >>> 24) & 255);
                this.f903c.write((i3 >>> 16) & 255);
                this.f903c.write((i3 >>> 8) & 255);
                outputStream = this.f903c;
                i4 = i3 >>> 0;
            }
            outputStream.write(i4 & 255);
        }

        public void d(short s3) {
            OutputStream outputStream;
            int i3;
            ByteOrder byteOrder = this.f904d;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f903c.write((s3 >>> 0) & 255);
                outputStream = this.f903c;
                i3 = s3 >>> 8;
            } else {
                if (byteOrder != ByteOrder.BIG_ENDIAN) {
                    return;
                }
                this.f903c.write((s3 >>> 8) & 255);
                outputStream = this.f903c;
                i3 = s3 >>> 0;
            }
            outputStream.write(i3 & 255);
        }

        public void e(long j3) {
            c((int) j3);
        }

        public void f(int i3) {
            d((short) i3);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) {
            this.f903c.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) {
            this.f903c.write(bArr, i3, i4);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f905a;

        /* renamed from: b, reason: collision with root package name */
        public final int f906b;

        /* renamed from: c, reason: collision with root package name */
        public final long f907c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f908d;

        d(int i3, int i4, long j3, byte[] bArr) {
            this.f905a = i3;
            this.f906b = i4;
            this.f907c = j3;
            this.f908d = bArr;
        }

        d(int i3, int i4, byte[] bArr) {
            this(i3, i4, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(a.f861p0);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d3 : dArr) {
                wrap.putDouble(d3);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i3 : iArr) {
                wrap.putInt(i3);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[10] * fVarArr.length]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f913a);
                wrap.putInt((int) fVar.f914b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f861p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j3, ByteOrder byteOrder) {
            return g(new long[]{j3}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j3 : jArr) {
                wrap.putInt((int) j3);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[5] * fVarArr.length]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f913a);
                wrap.putInt((int) fVar.f914b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i3, ByteOrder byteOrder) {
            return k(new int[]{i3}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i3 : iArr) {
                wrap.putShort((short) i3);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o3 = o(byteOrder);
            if (o3 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (o3 instanceof String) {
                return Double.parseDouble((String) o3);
            }
            if (o3 instanceof long[]) {
                if (((long[]) o3).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (o3 instanceof int[]) {
                if (((int[]) o3).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (o3 instanceof double[]) {
                double[] dArr = (double[]) o3;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(o3 instanceof f[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            f[] fVarArr = (f[]) o3;
            if (fVarArr.length == 1) {
                return fVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int m(ByteOrder byteOrder) {
            Object o3 = o(byteOrder);
            if (o3 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (o3 instanceof String) {
                return Integer.parseInt((String) o3);
            }
            if (o3 instanceof long[]) {
                long[] jArr = (long[]) o3;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(o3 instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) o3;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String n(ByteOrder byteOrder) {
            Object o3 = o(byteOrder);
            if (o3 == null) {
                return null;
            }
            if (o3 instanceof String) {
                return (String) o3;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            if (o3 instanceof long[]) {
                long[] jArr = (long[]) o3;
                while (i3 < jArr.length) {
                    sb.append(jArr[i3]);
                    i3++;
                    if (i3 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o3 instanceof int[]) {
                int[] iArr = (int[]) o3;
                while (i3 < iArr.length) {
                    sb.append(iArr[i3]);
                    i3++;
                    if (i3 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o3 instanceof double[]) {
                double[] dArr = (double[]) o3;
                while (i3 < dArr.length) {
                    sb.append(dArr[i3]);
                    i3++;
                    if (i3 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(o3 instanceof f[])) {
                return null;
            }
            f[] fVarArr = (f[]) o3;
            while (i3 < fVarArr.length) {
                sb.append(fVarArr[i3].f913a);
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append(fVarArr[i3].f914b);
                i3++;
                if (i3 != fVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0199: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:168:0x0199 */
        /* JADX WARN: Removed duplicated region for block: B:171:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.lang.Object o(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 450
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return a.X[this.f905a] * this.f906b;
        }

        public String toString() {
            return "(" + a.W[this.f905a] + ", data length:" + this.f908d.length + ")";
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f909a;

        /* renamed from: b, reason: collision with root package name */
        public final String f910b;

        /* renamed from: c, reason: collision with root package name */
        public final int f911c;

        /* renamed from: d, reason: collision with root package name */
        public final int f912d;

        e(String str, int i3, int i4) {
            this.f910b = str;
            this.f909a = i3;
            this.f911c = i4;
            this.f912d = -1;
        }

        e(String str, int i3, int i4, int i5) {
            this.f910b = str;
            this.f909a = i3;
            this.f911c = i4;
            this.f912d = i5;
        }

        boolean a(int i3) {
            int i4;
            int i5 = this.f911c;
            if (i5 == 7 || i3 == 7 || i5 == i3 || (i4 = this.f912d) == i3) {
                return true;
            }
            if ((i5 == 4 || i4 == 4) && i3 == 3) {
                return true;
            }
            if ((i5 == 9 || i4 == 9) && i3 == 8) {
                return true;
            }
            return (i5 == 12 || i4 == 12) && i3 == 11;
        }
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f913a;

        /* renamed from: b, reason: collision with root package name */
        public final long f914b;

        f(double d3) {
            this((long) (d3 * 10000.0d), 10000L);
        }

        f(long j3, long j4) {
            if (j4 == 0) {
                this.f913a = 0L;
                this.f914b = 1L;
            } else {
                this.f913a = j3;
                this.f914b = j4;
            }
        }

        public double a() {
            return this.f913a / this.f914b;
        }

        public String toString() {
            return this.f913a + "/" + this.f914b;
        }
    }

    private static class g extends b {
        g(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f899c.mark(Integer.MAX_VALUE);
        }

        g(byte[] bArr) {
            super(bArr);
            this.f899c.mark(Integer.MAX_VALUE);
        }

        public void e(long j3) {
            int i3 = this.f901f;
            if (i3 > j3) {
                this.f901f = 0;
                this.f899c.reset();
            } else {
                j3 -= i3;
            }
            d((int) j3);
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", UserVerificationMethods.USER_VERIFY_HANDPRINT, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f846a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f847b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f848c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", UserVerificationMethods.USER_VERIFY_HANDPRINT, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f849d0 = eVarArr5;
        f850e0 = new e("StripOffsets", 273, 3);
        e[] eVarArr6 = {new e("ThumbnailImage", UserVerificationMethods.USER_VERIFY_HANDPRINT, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f851f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f852g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f853h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f854i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f855j0 = eVarArr10;
        f856k0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f857l0 = new HashMap[eVarArr10.length];
        f858m0 = new HashMap[eVarArr10.length];
        f859n0 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f860o0 = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f861p0 = forName;
        f862q0 = "Exif\u0000\u0000".getBytes(forName);
        f863r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i3 = 0;
        while (true) {
            e[][] eVarArr11 = f855j0;
            if (i3 >= eVarArr11.length) {
                HashMap<Integer, Integer> hashMap = f860o0;
                e[] eVarArr12 = f856k0;
                hashMap.put(Integer.valueOf(eVarArr12[0].f909a), 5);
                hashMap.put(Integer.valueOf(eVarArr12[1].f909a), 1);
                hashMap.put(Integer.valueOf(eVarArr12[2].f909a), 2);
                hashMap.put(Integer.valueOf(eVarArr12[3].f909a), 3);
                hashMap.put(Integer.valueOf(eVarArr12[4].f909a), 7);
                hashMap.put(Integer.valueOf(eVarArr12[5].f909a), 8);
                f864s0 = Pattern.compile(".*[1-9].*");
                f865t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f866u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f868v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f857l0[i3] = new HashMap<>();
            f858m0[i3] = new HashMap<>();
            for (e eVar : eVarArr11[i3]) {
                f857l0[i3].put(Integer.valueOf(eVar.f909a), eVar);
                f858m0[i3].put(eVar.f910b, eVar);
            }
            i3++;
        }
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i3) {
        e[][] eVarArr = f855j0;
        this.f878f = new HashMap[eVarArr.length];
        this.f879g = new HashSet(eVarArr.length);
        this.f880h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.f873a = null;
        if (i3 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f862q0.length);
            if (!x(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f877e = true;
            this.f875c = null;
            this.f874b = null;
            inputStream = bufferedInputStream;
        } else {
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f875c = (AssetManager.AssetInputStream) inputStream;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (E(fileInputStream.getFD())) {
                        this.f875c = null;
                        this.f874b = fileInputStream.getFD();
                    }
                }
                this.f875c = null;
            }
            this.f874b = null;
        }
        J(inputStream);
    }

    public a(String str) {
        e[][] eVarArr = f855j0;
        this.f878f = new HashMap[eVarArr.length];
        this.f879g = new HashSet(eVarArr.length);
        this.f880h = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        w(str);
    }

    private boolean A(byte[] bArr) {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder M2 = M(bVar2);
                this.f880h = M2;
                bVar2.c(M2);
                short readShort = bVar2.readShort();
                boolean z3 = readShort == 20306 || readShort == 21330;
                bVar2.close();
                return z3;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean B(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private boolean C(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i3 = 0; i3 < bytes.length; i3++) {
            if (bArr[i3] != bytes[i3]) {
                return false;
            }
        }
        return true;
    }

    private boolean D(byte[] bArr) {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder M2 = M(bVar2);
                this.f880h = M2;
                bVar2.c(M2);
                boolean z3 = bVar2.readShort() == 85;
                bVar2.close();
                return z3;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean E(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f867v) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean F(HashMap hashMap) {
        d dVar;
        int m3;
        d dVar2 = (d) hashMap.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.f880h);
            int[] iArr2 = f871y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f876d == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((m3 = dVar.m(this.f880h)) == 1 && Arrays.equals(iArr, A)) || (m3 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f867v) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private static boolean G(int i3) {
        return i3 == 4 || i3 == 13 || i3 == 14;
    }

    private boolean H(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.f880h) <= 512 && dVar2.m(this.f880h) <= 512;
    }

    private boolean I(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i3 >= bArr2.length) {
                int i4 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i4 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[L.length + i4 + 4] != bArr3[i4]) {
                        return false;
                    }
                    i4++;
                }
            } else {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            }
        }
    }

    private void J(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i3 = 0; i3 < f855j0.length; i3++) {
            try {
                try {
                    this.f878f[i3] = new HashMap<>();
                } finally {
                    a();
                    if (f867v) {
                        L();
                    }
                }
            } catch (IOException | UnsupportedOperationException e3) {
                boolean z3 = f867v;
                if (z3) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e3);
                }
                a();
                if (!z3) {
                    return;
                }
            }
        }
        if (!this.f877e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f876d = i(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (Y(this.f876d)) {
            g gVar = new g(inputStream);
            if (this.f877e) {
                p(gVar);
            } else {
                int i4 = this.f876d;
                if (i4 == 12) {
                    g(gVar);
                } else if (i4 == 7) {
                    j(gVar);
                } else if (i4 == 10) {
                    o(gVar);
                } else {
                    m(gVar);
                }
            }
            gVar.e(this.f888p);
            X(gVar);
        } else {
            b bVar = new b(inputStream);
            int i5 = this.f876d;
            if (i5 == 4) {
                h(bVar, 0, 0);
            } else if (i5 == 13) {
                k(bVar);
            } else if (i5 == 9) {
                l(bVar);
            } else if (i5 == 14) {
                s(bVar);
            }
        }
    }

    private void K(b bVar) {
        ByteOrder M2 = M(bVar);
        this.f880h = M2;
        bVar.c(M2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i3 = this.f876d;
        if (i3 != 7 && i3 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = bVar.readInt();
        if (readInt < 8) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i4 = readInt - 8;
        if (i4 > 0) {
            bVar.d(i4);
        }
    }

    private void L() {
        for (int i3 = 0; i3 < this.f878f.length; i3++) {
            Log.d("ExifInterface", "The size of tag group[" + i3 + "]: " + this.f878f[i3].size());
            for (Map.Entry<String, d> entry : this.f878f[i3].entrySet()) {
                d value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.n(this.f880h) + "'");
            }
        }
    }

    private ByteOrder M(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (f867v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            if (f867v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void N(byte[] bArr, int i3) {
        g gVar = new g(bArr);
        K(gVar);
        O(gVar, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0279  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void O(androidx.exifinterface.media.a.g r30, int r31) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.O(androidx.exifinterface.media.a$g, int):void");
    }

    private void P(String str) {
        for (int i3 = 0; i3 < f855j0.length; i3++) {
            this.f878f[i3].remove(str);
        }
    }

    private void Q(int i3, String str, String str2) {
        if (this.f878f[i3].isEmpty() || this.f878f[i3].get(str) == null) {
            return;
        }
        HashMap<String, d> hashMap = this.f878f[i3];
        hashMap.put(str2, hashMap.get(str));
        this.f878f[i3].remove(str);
    }

    private void R(g gVar, int i3) {
        d dVar = this.f878f[i3].get("ImageLength");
        d dVar2 = this.f878f[i3].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f878f[i3].get("JPEGInterchangeFormat");
            d dVar4 = this.f878f[i3].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int m3 = dVar3.m(this.f880h);
            int m4 = dVar3.m(this.f880h);
            gVar.e(m3);
            byte[] bArr = new byte[m4];
            gVar.read(bArr);
            h(new b(bArr), m3, i3);
        }
    }

    private void T(InputStream inputStream, OutputStream outputStream) {
        if (f867v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.b(-1);
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.b(-40);
        d dVar = null;
        if (d("Xmp") != null && this.f893u) {
            dVar = this.f878f[0].remove("Xmp");
        }
        cVar.b(-1);
        cVar.b(-31);
        c0(cVar);
        if (dVar != null) {
            this.f878f[0].put("Xmp", dVar);
        }
        byte[] bArr = new byte[4096];
        while (bVar.readByte() == -1) {
            byte readByte = bVar.readByte();
            if (readByte == -39 || readByte == -38) {
                cVar.b(-1);
                cVar.b(readByte);
                androidx.exifinterface.media.b.e(bVar, cVar);
                return;
            }
            if (readByte != -31) {
                cVar.b(-1);
                cVar.b(readByte);
                int readUnsignedShort = bVar.readUnsignedShort();
                cVar.f(readUnsignedShort);
                int i3 = readUnsignedShort - 2;
                if (i3 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i3 > 0) {
                    int read = bVar.read(bArr, 0, Math.min(i3, 4096));
                    if (read >= 0) {
                        cVar.write(bArr, 0, read);
                        i3 -= read;
                    }
                }
            } else {
                int readUnsignedShort2 = bVar.readUnsignedShort() - 2;
                if (readUnsignedShort2 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (readUnsignedShort2 >= 6) {
                    if (bVar.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, f862q0)) {
                        bVar.d(readUnsignedShort2 - 6);
                    }
                }
                cVar.b(-1);
                cVar.b(readByte);
                cVar.f(readUnsignedShort2 + 2);
                if (readUnsignedShort2 >= 6) {
                    readUnsignedShort2 -= 6;
                    cVar.write(bArr2);
                }
                while (readUnsignedShort2 > 0) {
                    int read2 = bVar.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                    if (read2 >= 0) {
                        cVar.write(bArr, 0, read2);
                        readUnsignedShort2 -= read2;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    private void U(InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (f867v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = H;
        androidx.exifinterface.media.b.f(bVar, cVar, bArr.length);
        int i3 = this.f888p;
        if (i3 == 0) {
            int readInt = bVar.readInt();
            cVar.c(readInt);
            androidx.exifinterface.media.b.f(bVar, cVar, readInt + 4 + 4);
        } else {
            androidx.exifinterface.media.b.f(bVar, cVar, ((i3 - bArr.length) - 4) - 4);
            bVar.d(bVar.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            c0(cVar2);
            byte[] byteArray = ((ByteArrayOutputStream) cVar2.f903c).toByteArray();
            cVar.write(byteArray);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArray, 4, byteArray.length - 4);
            cVar.c((int) crc32.getValue());
            androidx.exifinterface.media.b.c(byteArrayOutputStream);
            androidx.exifinterface.media.b.e(bVar, cVar);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            androidx.exifinterface.media.b.c(byteArrayOutputStream2);
            throw th;
        }
    }

    private void V(InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        int i3;
        int i4;
        int i5;
        if (f867v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream, byteOrder);
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = L;
        androidx.exifinterface.media.b.f(bVar, cVar, bArr.length);
        byte[] bArr2 = M;
        bVar.d(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            int i6 = this.f888p;
            if (i6 != 0) {
                androidx.exifinterface.media.b.f(bVar, cVar2, ((i6 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                bVar.d(4);
                int readInt = bVar.readInt();
                if (readInt % 2 != 0) {
                    readInt++;
                }
                bVar.d(readInt);
            } else {
                byte[] bArr3 = new byte[4];
                if (bVar.read(bArr3) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunk type");
                }
                byte[] bArr4 = P;
                boolean z3 = true;
                if (!Arrays.equals(bArr3, bArr4)) {
                    byte[] bArr5 = R;
                    if (Arrays.equals(bArr3, bArr5) || Arrays.equals(bArr3, Q)) {
                        int readInt2 = bVar.readInt();
                        int i7 = readInt2 % 2 == 1 ? readInt2 + 1 : readInt2;
                        byte[] bArr6 = new byte[3];
                        if (Arrays.equals(bArr3, bArr5)) {
                            bVar.read(bArr6);
                            byte[] bArr7 = new byte[3];
                            if (bVar.read(bArr7) != 3 || !Arrays.equals(O, bArr7)) {
                                throw new IOException("Encountered error while checking VP8 signature");
                            }
                            i3 = bVar.readInt();
                            i7 -= 10;
                            i5 = (i3 << 2) >> 18;
                            i4 = (i3 << 18) >> 18;
                            z3 = false;
                        } else if (!Arrays.equals(bArr3, Q)) {
                            i3 = 0;
                            z3 = false;
                            i4 = 0;
                            i5 = 0;
                        } else {
                            if (bVar.readByte() != 47) {
                                throw new IOException("Encountered error while checking VP8L signature");
                            }
                            i3 = bVar.readInt();
                            i4 = (i3 & 16383) + 1;
                            i5 = ((i3 & 268419072) >>> 14) + 1;
                            if ((i3 & 268435456) == 0) {
                                z3 = false;
                            }
                            i7 -= 5;
                        }
                        cVar2.write(bArr4);
                        cVar2.c(10);
                        byte[] bArr8 = new byte[10];
                        if (z3) {
                            bArr8[0] = (byte) (bArr8[0] | Ascii.DLE);
                        }
                        bArr8[0] = (byte) (bArr8[0] | 8);
                        int i8 = i4 - 1;
                        int i9 = i5 - 1;
                        bArr8[4] = (byte) i8;
                        bArr8[5] = (byte) (i8 >> 8);
                        bArr8[6] = (byte) (i8 >> 16);
                        bArr8[7] = (byte) i9;
                        bArr8[8] = (byte) (i9 >> 8);
                        bArr8[9] = (byte) (i9 >> 16);
                        cVar2.write(bArr8);
                        cVar2.write(bArr3);
                        cVar2.c(readInt2);
                        if (Arrays.equals(bArr3, bArr5)) {
                            cVar2.write(bArr6);
                            cVar2.write(O);
                        } else {
                            if (Arrays.equals(bArr3, Q)) {
                                cVar2.write(47);
                            }
                            androidx.exifinterface.media.b.f(bVar, cVar2, i7);
                        }
                        cVar2.c(i3);
                        androidx.exifinterface.media.b.f(bVar, cVar2, i7);
                    }
                    androidx.exifinterface.media.b.e(bVar, cVar2);
                    int size = byteArrayOutputStream.size();
                    byte[] bArr9 = M;
                    cVar.c(size + bArr9.length);
                    cVar.write(bArr9);
                    byteArrayOutputStream.writeTo(cVar);
                    androidx.exifinterface.media.b.c(byteArrayOutputStream);
                }
                int readInt3 = bVar.readInt();
                byte[] bArr10 = new byte[readInt3 % 2 == 1 ? readInt3 + 1 : readInt3];
                bVar.read(bArr10);
                byte b4 = (byte) (8 | bArr10[0]);
                bArr10[0] = b4;
                boolean z4 = ((b4 >> 1) & 1) == 1;
                cVar2.write(bArr4);
                cVar2.c(readInt3);
                cVar2.write(bArr10);
                if (z4) {
                    b(bVar, cVar2, S, null);
                    while (true) {
                        byte[] bArr11 = new byte[4];
                        inputStream.read(bArr11);
                        if (!Arrays.equals(bArr11, T)) {
                            break;
                        } else {
                            c(bVar, cVar2, bArr11);
                        }
                    }
                } else {
                    b(bVar, cVar2, R, Q);
                }
            }
            c0(cVar2);
            androidx.exifinterface.media.b.e(bVar, cVar2);
            int size2 = byteArrayOutputStream.size();
            byte[] bArr92 = M;
            cVar.c(size2 + bArr92.length);
            cVar.write(bArr92);
            byteArrayOutputStream.writeTo(cVar);
            androidx.exifinterface.media.b.c(byteArrayOutputStream);
        } catch (Exception e4) {
            e = e4;
            throw new IOException("Failed to save WebP file", e);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            androidx.exifinterface.media.b.c(byteArrayOutputStream2);
            throw th;
        }
    }

    private void X(b bVar) {
        HashMap<String, d> hashMap = this.f878f[4];
        d dVar = hashMap.get("Compression");
        if (dVar != null) {
            int m3 = dVar.m(this.f880h);
            this.f887o = m3;
            if (m3 != 1) {
                if (m3 != 6) {
                    if (m3 != 7) {
                        return;
                    }
                }
            }
            if (F(hashMap)) {
                v(bVar, hashMap);
                return;
            }
            return;
        }
        this.f887o = 6;
        u(bVar, hashMap);
    }

    private static boolean Y(int i3) {
        return (i3 == 4 || i3 == 9 || i3 == 13 || i3 == 14) ? false : true;
    }

    private void Z(int i3, int i4) {
        String str;
        if (this.f878f[i3].isEmpty() || this.f878f[i4].isEmpty()) {
            if (f867v) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = this.f878f[i3].get("ImageLength");
        d dVar2 = this.f878f[i3].get("ImageWidth");
        d dVar3 = this.f878f[i4].get("ImageLength");
        d dVar4 = this.f878f[i4].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (!f867v) {
                return;
            } else {
                str = "First image does not contain valid size information";
            }
        } else {
            if (dVar3 != null && dVar4 != null) {
                int m3 = dVar.m(this.f880h);
                int m4 = dVar2.m(this.f880h);
                int m5 = dVar3.m(this.f880h);
                int m6 = dVar4.m(this.f880h);
                if (m3 >= m5 || m4 >= m6) {
                    return;
                }
                HashMap<String, d>[] hashMapArr = this.f878f;
                HashMap<String, d> hashMap = hashMapArr[i3];
                hashMapArr[i3] = hashMapArr[i4];
                hashMapArr[i4] = hashMap;
                return;
            }
            if (!f867v) {
                return;
            } else {
                str = "Second image does not contain valid size information";
            }
        }
        Log.d("ExifInterface", str);
    }

    private void a() {
        String d3 = d("DateTimeOriginal");
        if (d3 != null && d("DateTime") == null) {
            this.f878f[0].put("DateTime", d.e(d3));
        }
        if (d("ImageWidth") == null) {
            this.f878f[0].put("ImageWidth", d.f(0L, this.f880h));
        }
        if (d("ImageLength") == null) {
            this.f878f[0].put("ImageLength", d.f(0L, this.f880h));
        }
        if (d("Orientation") == null) {
            this.f878f[0].put("Orientation", d.f(0L, this.f880h));
        }
        if (d("LightSource") == null) {
            this.f878f[1].put("LightSource", d.f(0L, this.f880h));
        }
    }

    private void a0(g gVar, int i3) {
        StringBuilder sb;
        String arrays;
        d j3;
        d j4;
        d dVar = this.f878f[i3].get("DefaultCropSize");
        d dVar2 = this.f878f[i3].get("SensorTopBorder");
        d dVar3 = this.f878f[i3].get("SensorLeftBorder");
        d dVar4 = this.f878f[i3].get("SensorBottomBorder");
        d dVar5 = this.f878f[i3].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                R(gVar, i3);
                return;
            }
            int m3 = dVar2.m(this.f880h);
            int m4 = dVar4.m(this.f880h);
            int m5 = dVar5.m(this.f880h);
            int m6 = dVar3.m(this.f880h);
            if (m4 <= m3 || m5 <= m6) {
                return;
            }
            d j5 = d.j(m4 - m3, this.f880h);
            d j6 = d.j(m5 - m6, this.f880h);
            this.f878f[i3].put("ImageLength", j5);
            this.f878f[i3].put("ImageWidth", j6);
            return;
        }
        if (dVar.f905a == 5) {
            f[] fVarArr = (f[]) dVar.o(this.f880h);
            if (fVarArr != null && fVarArr.length == 2) {
                j3 = d.h(fVarArr[0], this.f880h);
                j4 = d.h(fVarArr[1], this.f880h);
                this.f878f[i3].put("ImageWidth", j3);
                this.f878f[i3].put("ImageLength", j4);
                return;
            }
            sb = new StringBuilder();
            sb.append("Invalid crop size values. cropSize=");
            arrays = Arrays.toString(fVarArr);
            sb.append(arrays);
            Log.w("ExifInterface", sb.toString());
        }
        int[] iArr = (int[]) dVar.o(this.f880h);
        if (iArr != null && iArr.length == 2) {
            j3 = d.j(iArr[0], this.f880h);
            j4 = d.j(iArr[1], this.f880h);
            this.f878f[i3].put("ImageWidth", j3);
            this.f878f[i3].put("ImageLength", j4);
            return;
        }
        sb = new StringBuilder();
        sb.append("Invalid crop size values. cropSize=");
        arrays = Arrays.toString(iArr);
        sb.append(arrays);
        Log.w("ExifInterface", sb.toString());
    }

    private void b(b bVar, c cVar, byte[] bArr, byte[] bArr2) {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f861p0;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            c(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void b0() {
        Z(0, 5);
        Z(0, 4);
        Z(5, 4);
        d dVar = this.f878f[1].get("PixelXDimension");
        d dVar2 = this.f878f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f878f[0].put("ImageWidth", dVar);
            this.f878f[0].put("ImageLength", dVar2);
        }
        if (this.f878f[4].isEmpty() && H(this.f878f[5])) {
            HashMap<String, d>[] hashMapArr = this.f878f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!H(this.f878f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        Q(0, "ThumbnailOrientation", "Orientation");
        Q(0, "ThumbnailImageLength", "ImageLength");
        Q(0, "ThumbnailImageWidth", "ImageWidth");
        Q(5, "ThumbnailOrientation", "Orientation");
        Q(5, "ThumbnailImageLength", "ImageLength");
        Q(5, "ThumbnailImageWidth", "ImageWidth");
        Q(4, "Orientation", "ThumbnailOrientation");
        Q(4, "ImageLength", "ThumbnailImageLength");
        Q(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void c(b bVar, c cVar, byte[] bArr) {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.c(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        androidx.exifinterface.media.b.f(bVar, cVar, readInt);
    }

    private int c0(c cVar) {
        e[][] eVarArr = f855j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f856k0) {
            P(eVar.f910b);
        }
        if (this.f881i) {
            if (this.f882j) {
                P("StripOffsets");
                P("StripByteCounts");
            } else {
                P("JPEGInterchangeFormat");
                P("JPEGInterchangeFormatLength");
            }
        }
        for (int i3 = 0; i3 < f855j0.length; i3++) {
            for (Object obj : this.f878f[i3].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f878f[i3].remove(entry.getKey());
                }
            }
        }
        if (!this.f878f[1].isEmpty()) {
            this.f878f[0].put(f856k0[1].f910b, d.f(0L, this.f880h));
        }
        if (!this.f878f[2].isEmpty()) {
            this.f878f[0].put(f856k0[2].f910b, d.f(0L, this.f880h));
        }
        if (!this.f878f[3].isEmpty()) {
            this.f878f[1].put(f856k0[3].f910b, d.f(0L, this.f880h));
        }
        if (this.f881i) {
            if (this.f882j) {
                this.f878f[4].put("StripOffsets", d.j(0, this.f880h));
                this.f878f[4].put("StripByteCounts", d.j(this.f885m, this.f880h));
            } else {
                this.f878f[4].put("JPEGInterchangeFormat", d.f(0L, this.f880h));
                this.f878f[4].put("JPEGInterchangeFormatLength", d.f(this.f885m, this.f880h));
            }
        }
        for (int i4 = 0; i4 < f855j0.length; i4++) {
            Iterator<Map.Entry<String, d>> it = this.f878f[i4].entrySet().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                int p3 = it.next().getValue().p();
                if (p3 > 4) {
                    i5 += p3;
                }
            }
            iArr2[i4] = iArr2[i4] + i5;
        }
        int i6 = 8;
        for (int i7 = 0; i7 < f855j0.length; i7++) {
            if (!this.f878f[i7].isEmpty()) {
                iArr[i7] = i6;
                i6 += (this.f878f[i7].size() * 12) + 2 + 4 + iArr2[i7];
            }
        }
        if (this.f881i) {
            if (this.f882j) {
                this.f878f[4].put("StripOffsets", d.j(i6, this.f880h));
            } else {
                this.f878f[4].put("JPEGInterchangeFormat", d.f(i6, this.f880h));
            }
            this.f884l = i6;
            i6 += this.f885m;
        }
        if (this.f876d == 4) {
            i6 += 8;
        }
        if (f867v) {
            for (int i8 = 0; i8 < f855j0.length; i8++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i8), Integer.valueOf(iArr[i8]), Integer.valueOf(this.f878f[i8].size()), Integer.valueOf(iArr2[i8]), Integer.valueOf(i6)));
            }
        }
        if (!this.f878f[1].isEmpty()) {
            this.f878f[0].put(f856k0[1].f910b, d.f(iArr[1], this.f880h));
        }
        if (!this.f878f[2].isEmpty()) {
            this.f878f[0].put(f856k0[2].f910b, d.f(iArr[2], this.f880h));
        }
        if (!this.f878f[3].isEmpty()) {
            this.f878f[1].put(f856k0[3].f910b, d.f(iArr[3], this.f880h));
        }
        int i9 = this.f876d;
        if (i9 == 4) {
            cVar.f(i6);
            cVar.write(f862q0);
        } else if (i9 == 13) {
            cVar.c(i6);
            cVar.write(I);
        } else if (i9 == 14) {
            cVar.write(N);
            cVar.c(i6);
        }
        cVar.d(this.f880h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.a(this.f880h);
        cVar.f(42);
        cVar.e(8L);
        for (int i10 = 0; i10 < f855j0.length; i10++) {
            if (!this.f878f[i10].isEmpty()) {
                cVar.f(this.f878f[i10].size());
                int size = iArr[i10] + 2 + (this.f878f[i10].size() * 12) + 4;
                for (Map.Entry<String, d> entry2 : this.f878f[i10].entrySet()) {
                    int i11 = f858m0[i10].get(entry2.getKey()).f909a;
                    d value = entry2.getValue();
                    int p4 = value.p();
                    cVar.f(i11);
                    cVar.f(value.f905a);
                    cVar.c(value.f906b);
                    if (p4 > 4) {
                        cVar.e(size);
                        size += p4;
                    } else {
                        cVar.write(value.f908d);
                        if (p4 < 4) {
                            while (p4 < 4) {
                                cVar.b(0);
                                p4++;
                            }
                        }
                    }
                }
                if (i10 != 0 || this.f878f[4].isEmpty()) {
                    cVar.e(0L);
                } else {
                    cVar.e(iArr[4]);
                }
                Iterator<Map.Entry<String, d>> it2 = this.f878f[i10].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = it2.next().getValue().f908d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f881i) {
            cVar.write(r());
        }
        if (this.f876d == 14 && i6 % 2 == 1) {
            cVar.b(0);
        }
        cVar.a(ByteOrder.BIG_ENDIAN);
        return i6;
    }

    private d f(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f867v) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i3 = 0; i3 < f855j0.length; i3++) {
            d dVar = this.f878f[i3].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    private void g(g gVar) {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                b.C0019b.a(mediaMetadataRetriever, new C0018a(gVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                String str3 = null;
                if ("yes".equals(extractMetadata3)) {
                    str3 = mediaMetadataRetriever.extractMetadata(29);
                    str = mediaMetadataRetriever.extractMetadata(30);
                    str2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str3 = mediaMetadataRetriever.extractMetadata(18);
                    str = mediaMetadataRetriever.extractMetadata(19);
                    str2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                }
                if (str3 != null) {
                    this.f878f[0].put("ImageWidth", d.j(Integer.parseInt(str3), this.f880h));
                }
                if (str != null) {
                    this.f878f[0].put("ImageLength", d.j(Integer.parseInt(str), this.f880h));
                }
                if (str2 != null) {
                    int i3 = 1;
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt == 90) {
                        i3 = 6;
                    } else if (parseInt == 180) {
                        i3 = 3;
                    } else if (parseInt == 270) {
                        i3 = 8;
                    }
                    this.f878f[0].put("Orientation", d.j(i3, this.f880h));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    gVar.e(parseInt2);
                    byte[] bArr = new byte[6];
                    if (gVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i4 = parseInt2 + 6;
                    int i5 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, f862q0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i5];
                    if (gVar.read(bArr2) != i5) {
                        throw new IOException("Can't read exif");
                    }
                    this.f888p = i4;
                    N(bArr2, 0);
                }
                if (f867v) {
                    Log.d("ExifInterface", "Heif meta: " + str3 + "x" + str + ", rotation " + str2);
                }
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x019a, code lost:
    
        r22.c(r21.f880h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0184 A[LOOP:0: B:9:0x0038->B:33:0x0184, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void h(androidx.exifinterface.media.a.b r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.h(androidx.exifinterface.media.a$b, int, int):void");
    }

    private int i(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (z(bArr)) {
            return 4;
        }
        if (C(bArr)) {
            return 9;
        }
        if (y(bArr)) {
            return 12;
        }
        if (A(bArr)) {
            return 7;
        }
        if (D(bArr)) {
            return 10;
        }
        if (B(bArr)) {
            return 13;
        }
        return I(bArr) ? 14 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j(androidx.exifinterface.media.a.g r6) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.j(androidx.exifinterface.media.a$g):void");
    }

    private void k(b bVar) {
        if (f867v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        bVar.d(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i3 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i4 = i3 + 4;
                if (i4 == 16 && !Arrays.equals(bArr2, J)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, K)) {
                    return;
                }
                if (Arrays.equals(bArr2, I)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f888p = i4;
                        N(bArr3, 0);
                        b0();
                        X(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i5 = readInt + 4;
                bVar.d(i5);
                length = i4 + i5;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void l(b bVar) {
        boolean z3 = f867v;
        if (z3) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.d(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i3 = ByteBuffer.wrap(bArr).getInt();
        int i4 = ByteBuffer.wrap(bArr2).getInt();
        int i5 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i4];
        bVar.d(i3 - bVar.a());
        bVar.read(bArr4);
        h(new b(bArr4), i3, 5);
        bVar.d(i5 - bVar.a());
        bVar.c(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z3) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i6 = 0; i6 < readInt; i6++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f850e0.f909a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j3 = d.j(readShort, this.f880h);
                d j4 = d.j(readShort2, this.f880h);
                this.f878f[0].put("ImageLength", j3);
                this.f878f[0].put("ImageWidth", j4);
                if (f867v) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.d(readUnsignedShort2);
        }
    }

    private void m(g gVar) {
        d dVar;
        K(gVar);
        O(gVar, 0);
        a0(gVar, 0);
        a0(gVar, 5);
        a0(gVar, 4);
        b0();
        if (this.f876d != 8 || (dVar = this.f878f[1].get("MakerNote")) == null) {
            return;
        }
        g gVar2 = new g(dVar.f908d);
        gVar2.c(this.f880h);
        gVar2.d(6);
        O(gVar2, 9);
        d dVar2 = this.f878f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f878f[1].put("ColorSpace", dVar2);
        }
    }

    private void o(g gVar) {
        if (f867v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        m(gVar);
        d dVar = this.f878f[0].get("JpgFromRaw");
        if (dVar != null) {
            h(new b(dVar.f908d), (int) dVar.f907c, 5);
        }
        d dVar2 = this.f878f[0].get("ISO");
        d dVar3 = this.f878f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f878f[1].put("PhotographicSensitivity", dVar2);
    }

    private void p(g gVar) {
        byte[] bArr = f862q0;
        gVar.d(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f888p = bArr.length;
        N(bArr2, 0);
    }

    private void s(b bVar) {
        if (f867v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.c(ByteOrder.LITTLE_ENDIAN);
        bVar.d(L.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = M;
        bVar.d(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i3 = length + 4 + 4;
                if (Arrays.equals(N, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (bVar.read(bArr3) == readInt2) {
                        this.f888p = i3;
                        N(bArr3, 0);
                        X(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i3 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.d(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair<Integer, Integer> t(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> t3 = t(split[0]);
            if (((Integer) t3.first).intValue() == 2) {
                return t3;
            }
            for (int i3 = 1; i3 < split.length; i3++) {
                Pair<Integer, Integer> t4 = t(split[i3]);
                int intValue = (((Integer) t4.first).equals(t3.first) || ((Integer) t4.second).equals(t3.first)) ? ((Integer) t3.first).intValue() : -1;
                int intValue2 = (((Integer) t3.second).intValue() == -1 || !(((Integer) t4.first).equals(t3.second) || ((Integer) t4.second).equals(t3.second))) ? -1 : ((Integer) t3.second).intValue();
                if (intValue == -1 && intValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (intValue == -1) {
                    t3 = new Pair<>(Integer.valueOf(intValue2), -1);
                } else if (intValue2 == -1) {
                    t3 = new Pair<>(Integer.valueOf(intValue), -1);
                }
            }
            return t3;
        }
        if (!str.contains("/")) {
            try {
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(str));
                    return (valueOf.longValue() < 0 || valueOf.longValue() > 65535) ? valueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair<>(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair<>(12, -1);
            }
        }
        String[] split2 = str.split("/", -1);
        if (split2.length == 2) {
            try {
                long parseDouble = (long) Double.parseDouble(split2[0]);
                long parseDouble2 = (long) Double.parseDouble(split2[1]);
                if (parseDouble >= 0 && parseDouble2 >= 0) {
                    if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                        return new Pair<>(10, 5);
                    }
                    return new Pair<>(5, -1);
                }
                return new Pair<>(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair<>(2, -1);
    }

    private void u(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int m3 = dVar.m(this.f880h);
        int m4 = dVar2.m(this.f880h);
        if (this.f876d == 7) {
            m3 += this.f889q;
        }
        if (m3 > 0 && m4 > 0) {
            this.f881i = true;
            if (this.f873a == null && this.f875c == null && this.f874b == null) {
                byte[] bArr = new byte[m4];
                bVar.skip(m3);
                bVar.read(bArr);
                this.f886n = bArr;
            }
            this.f884l = m3;
            this.f885m = m4;
        }
        if (f867v) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m3 + ", length: " + m4);
        }
    }

    private void v(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("StripOffsets");
        d dVar2 = (d) hashMap.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] d3 = androidx.exifinterface.media.b.d(dVar.o(this.f880h));
        long[] d4 = androidx.exifinterface.media.b.d(dVar2.o(this.f880h));
        if (d3 == null || d3.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (d4 == null || d4.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (d3.length != d4.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j3 = 0;
        for (long j4 : d4) {
            j3 += j4;
        }
        int i3 = (int) j3;
        byte[] bArr = new byte[i3];
        int i4 = 1;
        this.f883k = true;
        this.f882j = true;
        this.f881i = true;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < d3.length) {
            int i8 = (int) d3[i5];
            int i9 = (int) d4[i5];
            if (i5 < d3.length - i4 && i8 + i9 != d3[i5 + 1]) {
                this.f883k = false;
            }
            int i10 = i8 - i6;
            if (i10 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j5 = i10;
            if (bVar.skip(j5) != j5) {
                Log.d("ExifInterface", "Failed to skip " + i10 + " bytes.");
                return;
            }
            int i11 = i6 + i10;
            byte[] bArr2 = new byte[i9];
            if (bVar.read(bArr2) != i9) {
                Log.d("ExifInterface", "Failed to read " + i9 + " bytes.");
                return;
            }
            i6 = i11 + i9;
            System.arraycopy(bArr2, 0, bArr, i7, i9);
            i7 += i9;
            i5++;
            i4 = 1;
        }
        this.f886n = bArr;
        if (this.f883k) {
            this.f884l = (int) d3[0];
            this.f885m = i3;
        }
    }

    private void w(String str) {
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream = null;
        this.f875c = null;
        this.f873a = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (E(fileInputStream2.getFD())) {
                    this.f874b = fileInputStream2.getFD();
                } else {
                    this.f874b = null;
                }
                J(fileInputStream2);
                androidx.exifinterface.media.b.c(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                androidx.exifinterface.media.b.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean x(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f862q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i3 = 0;
        while (true) {
            byte[] bArr3 = f862q0;
            if (i3 >= bArr3.length) {
                return true;
            }
            if (bArr2[i3] != bArr3[i3]) {
                return false;
            }
            i3++;
        }
    }

    private boolean y(byte[] bArr) {
        b bVar;
        long readInt;
        byte[] bArr2;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            readInt = bVar.readInt();
            bArr2 = new byte[4];
            bVar.read(bArr2);
        } catch (Exception e4) {
            e = e4;
            bVar2 = bVar;
            if (f867v) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, C)) {
            bVar.close();
            return false;
        }
        long j3 = 16;
        if (readInt == 1) {
            readInt = bVar.readLong();
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j3 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j4 = readInt - j3;
        if (j4 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z3 = false;
        boolean z4 = false;
        for (long j5 = 0; j5 < j4 / 4; j5++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j5 != 1) {
                if (Arrays.equals(bArr3, D)) {
                    z3 = true;
                } else if (Arrays.equals(bArr3, E)) {
                    z4 = true;
                }
                if (z3 && z4) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    private static boolean z(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = B;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e4 A[Catch: all -> 0x010c, Exception -> 0x010f, TryCatch #20 {Exception -> 0x010f, all -> 0x010c, blocks: (B:57:0x00e0, B:59:0x00e4, B:60:0x00fa, B:64:0x00f3), top: B:56:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f3 A[Catch: all -> 0x010c, Exception -> 0x010f, TryCatch #20 {Exception -> 0x010f, all -> 0x010c, blocks: (B:57:0x00e0, B:59:0x00e4, B:60:0x00fa, B:64:0x00f3), top: B:56:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.S():void");
    }

    public void W(String str, String str2) {
        StringBuilder sb;
        e eVar;
        int i3;
        HashMap<String, d> hashMap;
        d a4;
        HashMap<String, d> hashMap2;
        d c3;
        String str3 = str;
        String str4 = str2;
        if (str3 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && str4 != null) {
            boolean find = f866u0.matcher(str4).find();
            boolean find2 = f868v0.matcher(str4).find();
            if (str2.length() != 19 || (!find && !find2)) {
                sb = new StringBuilder();
                sb.append("Invalid value for ");
                sb.append(str3);
                sb.append(" : ");
                sb.append(str4);
                Log.w("ExifInterface", sb.toString());
                return;
            }
            if (find2) {
                str4 = str4.replaceAll("-", ":");
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            if (f867v) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = "PhotographicSensitivity";
        }
        int i4 = 2;
        int i5 = 1;
        if (str4 != null && f859n0.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = f865t0.matcher(str4);
                if (!matcher.find()) {
                    sb = new StringBuilder();
                    sb.append("Invalid value for ");
                    sb.append(str3);
                    sb.append(" : ");
                    sb.append(str4);
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                str4 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str4 = new f(Double.parseDouble(str4)).toString();
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                }
            }
        }
        char c4 = 0;
        int i6 = 0;
        while (i6 < f855j0.length) {
            if ((i6 != 4 || this.f881i) && (eVar = f858m0[i6].get(str3)) != null) {
                if (str4 == null) {
                    this.f878f[i6].remove(str3);
                } else {
                    Pair<Integer, Integer> t3 = t(str4);
                    int i7 = -1;
                    if (eVar.f911c == ((Integer) t3.first).intValue() || eVar.f911c == ((Integer) t3.second).intValue()) {
                        i3 = eVar.f911c;
                    } else {
                        int i8 = eVar.f912d;
                        if (i8 == -1 || !(i8 == ((Integer) t3.first).intValue() || eVar.f912d == ((Integer) t3.second).intValue())) {
                            int i9 = eVar.f911c;
                            if (i9 == i5 || i9 == 7 || i9 == i4) {
                                i3 = i9;
                            } else if (f867v) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Given tag (");
                                sb2.append(str3);
                                sb2.append(") value didn't match with one of expected formats: ");
                                String[] strArr = W;
                                sb2.append(strArr[eVar.f911c]);
                                sb2.append(eVar.f912d == -1 ? "" : ", " + strArr[eVar.f912d]);
                                sb2.append(" (guess: ");
                                sb2.append(strArr[((Integer) t3.first).intValue()]);
                                sb2.append(((Integer) t3.second).intValue() != -1 ? ", " + strArr[((Integer) t3.second).intValue()] : "");
                                sb2.append(")");
                                Log.d("ExifInterface", sb2.toString());
                            }
                        } else {
                            i3 = eVar.f912d;
                        }
                    }
                    switch (i3) {
                        case 1:
                            hashMap = this.f878f[i6];
                            a4 = d.a(str4);
                            hashMap.put(str3, a4);
                            break;
                        case 2:
                        case 7:
                            hashMap = this.f878f[i6];
                            a4 = d.e(str4);
                            hashMap.put(str3, a4);
                            break;
                        case 3:
                            String[] split = str4.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i10 = 0; i10 < split.length; i10++) {
                                iArr[i10] = Integer.parseInt(split[i10]);
                            }
                            hashMap = this.f878f[i6];
                            a4 = d.k(iArr, this.f880h);
                            hashMap.put(str3, a4);
                            break;
                        case 4:
                            String[] split2 = str4.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i11 = 0; i11 < split2.length; i11++) {
                                jArr[i11] = Long.parseLong(split2[i11]);
                            }
                            hashMap = this.f878f[i6];
                            a4 = d.g(jArr, this.f880h);
                            hashMap.put(str3, a4);
                            break;
                        case 5:
                            String[] split3 = str4.split(",", -1);
                            f[] fVarArr = new f[split3.length];
                            int i12 = 0;
                            while (i12 < split3.length) {
                                String[] split4 = split3[i12].split("/", i7);
                                fVarArr[i12] = new f((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                i12++;
                                i7 = -1;
                            }
                            hashMap = this.f878f[i6];
                            a4 = d.i(fVarArr, this.f880h);
                            hashMap.put(str3, a4);
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (f867v) {
                                Log.d("ExifInterface", "Data format isn't one of expected formats: " + i3);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            String[] split5 = str4.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i13 = 0; i13 < split5.length; i13++) {
                                iArr2[i13] = Integer.parseInt(split5[i13]);
                            }
                            hashMap2 = this.f878f[i6];
                            c3 = d.c(iArr2, this.f880h);
                            hashMap2.put(str3, c3);
                            break;
                        case 10:
                            String[] split6 = str4.split(",", -1);
                            f[] fVarArr2 = new f[split6.length];
                            int i14 = 0;
                            while (i14 < split6.length) {
                                String[] split7 = split6[i14].split("/", -1);
                                fVarArr2[i14] = new f((long) Double.parseDouble(split7[c4]), (long) Double.parseDouble(split7[i5]));
                                i14++;
                                split6 = split6;
                                c4 = 0;
                                i5 = 1;
                            }
                            hashMap2 = this.f878f[i6];
                            c3 = d.d(fVarArr2, this.f880h);
                            hashMap2.put(str3, c3);
                            break;
                        case 12:
                            String[] split8 = str4.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i15 = 0; i15 < split8.length; i15++) {
                                dArr[i15] = Double.parseDouble(split8[i15]);
                            }
                            this.f878f[i6].put(str3, d.b(dArr, this.f880h));
                            break;
                    }
                    i6++;
                    i4 = 2;
                    c4 = 0;
                    i5 = 1;
                }
            }
            i6++;
            i4 = 2;
            c4 = 0;
            i5 = 1;
        }
    }

    public String d(String str) {
        String str2;
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d f3 = f(str);
        if (f3 != null) {
            if (!f859n0.contains(str)) {
                return f3.n(this.f880h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i3 = f3.f905a;
                if (i3 == 5 || i3 == 10) {
                    f[] fVarArr = (f[]) f3.o(this.f880h);
                    if (fVarArr != null && fVarArr.length == 3) {
                        f fVar = fVarArr[0];
                        f fVar2 = fVarArr[1];
                        f fVar3 = fVarArr[2];
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (fVar.f913a / fVar.f914b)), Integer.valueOf((int) (fVar2.f913a / fVar2.f914b)), Integer.valueOf((int) (fVar3.f913a / fVar3.f914b)));
                    }
                    str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr);
                } else {
                    str2 = "GPS Timestamp format is not rational. format=" + f3.f905a;
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(f3.l(this.f880h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int e(String str, int i3) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d f3 = f(str);
        if (f3 == null) {
            return i3;
        }
        try {
            return f3.m(this.f880h);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public int n() {
        switch (e("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public byte[] q() {
        int i3 = this.f887o;
        if (i3 == 6 || i3 == 7) {
            return r();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[Catch: Exception -> 0x0088, all -> 0x00a7, TRY_ENTER, TryCatch #3 {all -> 0x00a7, blocks: (B:17:0x004f, B:20:0x0065, B:22:0x0071, B:27:0x007c, B:28:0x0081, B:29:0x0082, B:30:0x0087, B:32:0x0099), top: B:6:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[Catch: Exception -> 0x0088, all -> 0x00a7, TryCatch #3 {all -> 0x00a7, blocks: (B:17:0x004f, B:20:0x0065, B:22:0x0071, B:27:0x007c, B:28:0x0081, B:29:0x0082, B:30:0x0087, B:32:0x0099), top: B:6:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] r() {
        /*
            r11 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r11.f881i
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            byte[] r1 = r11.f886n
            if (r1 == 0) goto Ld
            return r1
        Ld:
            android.content.res.AssetManager$AssetInputStream r1 = r11.f875c     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r1 == 0) goto L2e
            boolean r3 = r1.markSupported()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L29
            if (r3 == 0) goto L1c
            r1.reset()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L29
        L1a:
            r3 = r2
            goto L4f
        L1c:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L29
            androidx.exifinterface.media.b.c(r1)
            return r2
        L25:
            r0 = move-exception
            r3 = r2
            goto La8
        L29:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L99
        L2e:
            java.lang.String r1 = r11.f873a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r1 == 0) goto L3a
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r3 = r11.f873a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L1a
        L3a:
            java.io.FileDescriptor r1 = r11.f874b     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.io.FileDescriptor r1 = androidx.exifinterface.media.b.a.b(r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3 = 0
            int r5 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            androidx.exifinterface.media.b.a.c(r1, r3, r5)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8d
            r10 = r3
            r3 = r1
            r1 = r10
        L4f:
            int r4 = r11.f884l     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r5 = r11.f888p     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            long r4 = r1.skip(r4)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r6 = r11.f884l     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r7 = r11.f888p     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r6 = r6 + r7
            long r6 = (long) r6
            java.lang.String r8 = "Corrupted image"
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L82
            int r4 = r11.f885m     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            byte[] r4 = new byte[r4]     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r5 = r1.read(r4)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            int r6 = r11.f885m     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            if (r5 != r6) goto L7c
            r11.f886n = r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            androidx.exifinterface.media.b.c(r1)
            if (r3 == 0) goto L7b
            androidx.exifinterface.media.b.b(r3)
        L7b:
            return r4
        L7c:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            r4.<init>(r8)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            throw r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
        L82:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            r4.<init>(r8)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
            throw r4     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> La7
        L88:
            r4 = move-exception
            goto L99
        L8a:
            r0 = move-exception
            r3 = r1
            goto La9
        L8d:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
            goto L99
        L92:
            r0 = move-exception
            r3 = r2
            goto La9
        L95:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
        L99:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> La7
            androidx.exifinterface.media.b.c(r1)
            if (r3 == 0) goto La6
            androidx.exifinterface.media.b.b(r3)
        La6:
            return r2
        La7:
            r0 = move-exception
        La8:
            r2 = r1
        La9:
            androidx.exifinterface.media.b.c(r2)
            if (r3 == 0) goto Lb1
            androidx.exifinterface.media.b.b(r3)
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.r():byte[]");
    }
}
