package n;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
public final class e implements AutoCloseable, SurfaceTexture.OnFrameAvailableListener {
    private Surface A;
    private Surface B;
    private n.b C;
    private n.a D;
    private int E;

    /* renamed from: c, reason: collision with root package name */
    MediaCodec f3977c;

    /* renamed from: d, reason: collision with root package name */
    final c f3978d;

    /* renamed from: f, reason: collision with root package name */
    private final HandlerThread f3979f;

    /* renamed from: g, reason: collision with root package name */
    final Handler f3980g;

    /* renamed from: h, reason: collision with root package name */
    private final int f3981h;

    /* renamed from: i, reason: collision with root package name */
    final int f3982i;

    /* renamed from: j, reason: collision with root package name */
    final int f3983j;

    /* renamed from: k, reason: collision with root package name */
    final int f3984k;

    /* renamed from: l, reason: collision with root package name */
    final int f3985l;

    /* renamed from: m, reason: collision with root package name */
    final int f3986m;

    /* renamed from: n, reason: collision with root package name */
    final int f3987n;

    /* renamed from: o, reason: collision with root package name */
    private final int f3988o;

    /* renamed from: p, reason: collision with root package name */
    final boolean f3989p;

    /* renamed from: q, reason: collision with root package name */
    private int f3990q;

    /* renamed from: r, reason: collision with root package name */
    boolean f3991r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f3992s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f3993t;

    /* renamed from: u, reason: collision with root package name */
    private ByteBuffer f3994u;

    /* renamed from: y, reason: collision with root package name */
    C0100e f3998y;

    /* renamed from: z, reason: collision with root package name */
    private SurfaceTexture f3999z;

    /* renamed from: v, reason: collision with root package name */
    private final ArrayList<ByteBuffer> f3995v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private final ArrayList<ByteBuffer> f3996w = new ArrayList<>();

    /* renamed from: x, reason: collision with root package name */
    final ArrayList<Integer> f3997x = new ArrayList<>();
    private final float[] F = new float[16];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.h();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.l();
        }
    }

    public static abstract class c {
        public abstract void a(e eVar);

        public abstract void b(e eVar, ByteBuffer byteBuffer);

        public abstract void c(e eVar, MediaCodec.CodecException codecException);

        public abstract void d(e eVar, MediaFormat mediaFormat);
    }

    class d extends MediaCodec.Callback {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4002a;

        d() {
        }

        private void a(MediaCodec.CodecException codecException) {
            e.this.l();
            if (codecException == null) {
                e eVar = e.this;
                eVar.f3978d.a(eVar);
            } else {
                e eVar2 = e.this;
                eVar2.f3978d.c(eVar2, codecException);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            if (mediaCodec != e.this.f3977c) {
                return;
            }
            Log.e("HeifEncoder", "onError: " + codecException);
            a(codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i3) {
            e eVar = e.this;
            if (mediaCodec != eVar.f3977c || eVar.f3991r) {
                return;
            }
            eVar.f3997x.add(Integer.valueOf(i3));
            e.this.h();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec != e.this.f3977c || this.f4002a) {
                return;
            }
            if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i3);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                C0100e c0100e = e.this.f3998y;
                if (c0100e != null) {
                    c0100e.e(bufferInfo.presentationTimeUs);
                }
                e eVar = e.this;
                eVar.f3978d.b(eVar, outputBuffer);
            }
            this.f4002a = ((bufferInfo.flags & 4) != 0) | this.f4002a;
            mediaCodec.releaseOutputBuffer(i3, false);
            if (this.f4002a) {
                a(null);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            if (mediaCodec != e.this.f3977c) {
                return;
            }
            if (!"image/vnd.android.heic".equals(mediaFormat.getString("mime"))) {
                mediaFormat.setString("mime", "image/vnd.android.heic");
                mediaFormat.setInteger("width", e.this.f3982i);
                mediaFormat.setInteger("height", e.this.f3983j);
                e eVar = e.this;
                if (eVar.f3989p) {
                    mediaFormat.setInteger("tile-width", eVar.f3984k);
                    mediaFormat.setInteger("tile-height", e.this.f3985l);
                    mediaFormat.setInteger("grid-rows", e.this.f3986m);
                    mediaFormat.setInteger("grid-cols", e.this.f3987n);
                }
            }
            e eVar2 = e.this;
            eVar2.f3978d.d(eVar2, mediaFormat);
        }
    }

    /* renamed from: n.e$e, reason: collision with other inner class name */
    private class C0100e {

        /* renamed from: a, reason: collision with root package name */
        final boolean f4004a;

        /* renamed from: b, reason: collision with root package name */
        long f4005b = -1;

        /* renamed from: c, reason: collision with root package name */
        long f4006c = -1;

        /* renamed from: d, reason: collision with root package name */
        long f4007d = -1;

        /* renamed from: e, reason: collision with root package name */
        long f4008e = -1;

        /* renamed from: f, reason: collision with root package name */
        long f4009f = -1;

        /* renamed from: g, reason: collision with root package name */
        boolean f4010g;

        /* renamed from: n.e$e$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaCodec mediaCodec = e.this.f3977c;
                if (mediaCodec != null) {
                    mediaCodec.signalEndOfInputStream();
                }
            }
        }

        C0100e(boolean z3) {
            this.f4004a = z3;
        }

        private void a() {
            e.this.f3980g.post(new a());
            this.f4010g = true;
        }

        private void b() {
            if (this.f4010g) {
                return;
            }
            if (this.f4007d < 0) {
                long j3 = this.f4005b;
                if (j3 >= 0 && this.f4006c >= j3) {
                    long j4 = this.f4008e;
                    if (j4 < 0) {
                        a();
                        return;
                    }
                    this.f4007d = j4;
                }
            }
            long j5 = this.f4007d;
            if (j5 < 0 || j5 > this.f4009f) {
                return;
            }
            a();
        }

        synchronized void c(long j3) {
            if (this.f4004a) {
                if (this.f4005b < 0) {
                    this.f4005b = j3;
                }
            } else if (this.f4007d < 0) {
                this.f4007d = j3 / 1000;
            }
            b();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0013 A[Catch: all -> 0x001c, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x0013, B:11:0x0015), top: B:2:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        synchronized boolean d(long r6, long r8) {
            /*
                r5 = this;
                monitor-enter(r5)
                long r0 = r5.f4005b     // Catch: java.lang.Throwable -> L1c
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 < 0) goto L10
                int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r2 > 0) goto Le
                goto L10
            Le:
                r0 = 0
                goto L11
            L10:
                r0 = 1
            L11:
                if (r0 == 0) goto L15
                r5.f4008e = r8     // Catch: java.lang.Throwable -> L1c
            L15:
                r5.f4006c = r6     // Catch: java.lang.Throwable -> L1c
                r5.b()     // Catch: java.lang.Throwable -> L1c
                monitor-exit(r5)
                return r0
            L1c:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: n.e.C0100e.d(long, long):boolean");
        }

        synchronized void e(long j3) {
            this.f4009f = j3;
            b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(int r20, int r21, boolean r22, int r23, int r24, android.os.Handler r25, n.e.c r26) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.e.<init>(int, int, boolean, int, int, android.os.Handler, n.e$c):void");
    }

    private ByteBuffer a() {
        ByteBuffer remove;
        synchronized (this.f3995v) {
            while (!this.f3991r && this.f3995v.isEmpty()) {
                try {
                    this.f3995v.wait();
                } catch (InterruptedException unused) {
                }
            }
            remove = this.f3991r ? null : this.f3995v.remove(0);
        }
        return remove;
    }

    private void c(byte[] bArr) {
        ByteBuffer a4 = a();
        if (a4 == null) {
            return;
        }
        a4.clear();
        if (bArr != null) {
            a4.put(bArr);
        }
        a4.flip();
        synchronized (this.f3996w) {
            this.f3996w.add(a4);
        }
        this.f3980g.post(new a());
    }

    private long d(int i3) {
        return ((i3 * 1000000) / this.f3988o) + 132;
    }

    private static void e(ByteBuffer byteBuffer, Image image, int i3, int i4, Rect rect, Rect rect2) {
        int i5;
        int i6;
        if (rect.width() != rect2.width() || rect.height() != rect2.height()) {
            throw new IllegalArgumentException("src and dst rect size are different!");
        }
        if (i3 % 2 != 0 || i4 % 2 != 0 || rect.left % 2 != 0 || rect.top % 2 != 0 || rect.right % 2 != 0 || rect.bottom % 2 != 0 || rect2.left % 2 != 0 || rect2.top % 2 != 0 || rect2.right % 2 != 0 || rect2.bottom % 2 != 0) {
            throw new IllegalArgumentException("src or dst are not aligned!");
        }
        Image.Plane[] planes = image.getPlanes();
        for (int i7 = 0; i7 < planes.length; i7++) {
            ByteBuffer buffer = planes[i7].getBuffer();
            int pixelStride = planes[i7].getPixelStride();
            int min = Math.min(rect.width(), i3 - rect.left);
            int min2 = Math.min(rect.height(), i4 - rect.top);
            if (i7 > 0) {
                i5 = ((i3 * i4) * (i7 + 3)) / 4;
                i6 = 2;
            } else {
                i5 = 0;
                i6 = 1;
            }
            for (int i8 = 0; i8 < min2 / i6; i8++) {
                byteBuffer.position(((((rect.top / i6) + i8) * i3) / i6) + i5 + (rect.left / i6));
                buffer.position((((rect2.top / i6) + i8) * planes[i7].getRowStride()) + ((rect2.left * pixelStride) / i6));
                int i9 = 0;
                while (true) {
                    int i10 = min / i6;
                    if (i9 < i10) {
                        buffer.put(byteBuffer.get());
                        if (pixelStride > 1 && i9 != i10 - 1) {
                            buffer.position((buffer.position() + pixelStride) - 1);
                        }
                        i9++;
                    }
                }
            }
        }
    }

    private void f() {
        GLES20.glViewport(0, 0, this.f3984k, this.f3985l);
        for (int i3 = 0; i3 < this.f3986m; i3++) {
            for (int i4 = 0; i4 < this.f3987n; i4++) {
                int i5 = this.f3984k;
                int i6 = i4 * i5;
                int i7 = this.f3985l;
                int i8 = i3 * i7;
                this.f3992s.set(i6, i8, i5 + i6, i7 + i8);
                this.D.a(this.E, g.f4045i, this.f3992s);
                n.b bVar = this.C;
                int i9 = this.f3990q;
                this.f3990q = i9 + 1;
                bVar.i(d(i9) * 1000);
                this.C.j();
            }
        }
    }

    private ByteBuffer g() {
        if (!this.f3991r && this.f3994u == null) {
            synchronized (this.f3996w) {
                this.f3994u = this.f3996w.isEmpty() ? null : this.f3996w.remove(0);
            }
        }
        if (this.f3991r) {
            return null;
        }
        return this.f3994u;
    }

    private void i(boolean z3) {
        synchronized (this.f3995v) {
            this.f3991r = z3 | this.f3991r;
            this.f3995v.add(this.f3994u);
            this.f3995v.notifyAll();
        }
        this.f3994u = null;
    }

    public void b(Bitmap bitmap) {
        if (this.f3981h != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        }
        if (this.f3998y.d(d(this.f3990q) * 1000, d((this.f3990q + this.f3988o) - 1))) {
            synchronized (this) {
                n.b bVar = this.C;
                if (bVar == null) {
                    return;
                }
                bVar.f();
                this.D.d(this.E, bitmap);
                f();
                this.C.g();
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3995v) {
            this.f3991r = true;
            this.f3995v.notifyAll();
        }
        this.f3980g.postAtFrontOfQueue(new b());
    }

    void h() {
        while (true) {
            ByteBuffer g3 = g();
            if (g3 == null || this.f3997x.isEmpty()) {
                return;
            }
            int intValue = this.f3997x.remove(0).intValue();
            boolean z3 = this.f3990q % this.f3988o == 0 && g3.remaining() == 0;
            if (!z3) {
                Image inputImage = this.f3977c.getInputImage(intValue);
                int i3 = this.f3984k;
                int i4 = this.f3990q;
                int i5 = this.f3987n;
                int i6 = (i4 % i5) * i3;
                int i7 = this.f3985l;
                int i8 = ((i4 / i5) % this.f3986m) * i7;
                this.f3992s.set(i6, i8, i3 + i6, i7 + i8);
                e(g3, inputImage, this.f3982i, this.f3983j, this.f3992s, this.f3993t);
            }
            MediaCodec mediaCodec = this.f3977c;
            int capacity = z3 ? 0 : mediaCodec.getInputBuffer(intValue).capacity();
            int i9 = this.f3990q;
            this.f3990q = i9 + 1;
            mediaCodec.queueInputBuffer(intValue, 0, capacity, d(i9), z3 ? 4 : 0);
            if (z3 || this.f3990q % this.f3988o == 0) {
                i(z3);
            }
        }
    }

    public void j() {
        this.f3977c.start();
    }

    public void k() {
        int i3 = this.f3981h;
        if (i3 == 2) {
            this.f3998y.c(0L);
        } else if (i3 == 0) {
            c(null);
        }
    }

    void l() {
        MediaCodec mediaCodec = this.f3977c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f3977c.release();
            this.f3977c = null;
        }
        synchronized (this.f3995v) {
            this.f3991r = true;
            this.f3995v.notifyAll();
        }
        synchronized (this) {
            n.a aVar = this.D;
            if (aVar != null) {
                aVar.e(false);
                this.D = null;
            }
            n.b bVar = this.C;
            if (bVar != null) {
                bVar.h();
                this.C = null;
            }
            SurfaceTexture surfaceTexture = this.f3999z;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f3999z = null;
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            n.b bVar = this.C;
            if (bVar == null) {
                return;
            }
            bVar.f();
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.F);
            if (this.f3998y.d(surfaceTexture.getTimestamp(), d((this.f3990q + this.f3988o) - 1))) {
                f();
            }
            surfaceTexture.releaseTexImage();
            this.C.g();
        }
    }
}
