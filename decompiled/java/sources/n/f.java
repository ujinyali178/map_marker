package n;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import n.e;

/* loaded from: /root/release/classes.dex */
public final class f implements AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    private final int f4013c;

    /* renamed from: d, reason: collision with root package name */
    private final HandlerThread f4014d;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f4015f;

    /* renamed from: g, reason: collision with root package name */
    int f4016g;

    /* renamed from: h, reason: collision with root package name */
    final int f4017h;

    /* renamed from: i, reason: collision with root package name */
    final int f4018i;

    /* renamed from: j, reason: collision with root package name */
    final int f4019j;

    /* renamed from: l, reason: collision with root package name */
    MediaMuxer f4021l;

    /* renamed from: m, reason: collision with root package name */
    private e f4022m;

    /* renamed from: o, reason: collision with root package name */
    int[] f4024o;

    /* renamed from: p, reason: collision with root package name */
    int f4025p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4026q;

    /* renamed from: k, reason: collision with root package name */
    final d f4020k = new d();

    /* renamed from: n, reason: collision with root package name */
    final AtomicBoolean f4023n = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private final List<Pair<Integer, ByteBuffer>> f4027r = new ArrayList();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.e();
            } catch (Exception unused) {
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f4029a;

        /* renamed from: b, reason: collision with root package name */
        private final FileDescriptor f4030b;

        /* renamed from: c, reason: collision with root package name */
        private final int f4031c;

        /* renamed from: d, reason: collision with root package name */
        private final int f4032d;

        /* renamed from: e, reason: collision with root package name */
        private final int f4033e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f4034f;

        /* renamed from: g, reason: collision with root package name */
        private int f4035g;

        /* renamed from: h, reason: collision with root package name */
        private int f4036h;

        /* renamed from: i, reason: collision with root package name */
        private int f4037i;

        /* renamed from: j, reason: collision with root package name */
        private int f4038j;

        /* renamed from: k, reason: collision with root package name */
        private Handler f4039k;

        public b(String str, int i3, int i4, int i5) {
            this(str, null, i3, i4, i5);
        }

        private b(String str, FileDescriptor fileDescriptor, int i3, int i4, int i5) {
            this.f4034f = true;
            this.f4035g = 100;
            this.f4036h = 1;
            this.f4037i = 0;
            this.f4038j = 0;
            if (i3 <= 0 || i4 <= 0) {
                throw new IllegalArgumentException("Invalid image size: " + i3 + "x" + i4);
            }
            this.f4029a = str;
            this.f4030b = fileDescriptor;
            this.f4031c = i3;
            this.f4032d = i4;
            this.f4033e = i5;
        }

        public f a() {
            return new f(this.f4029a, this.f4030b, this.f4031c, this.f4032d, this.f4038j, this.f4034f, this.f4035g, this.f4036h, this.f4037i, this.f4033e, this.f4039k);
        }

        public b b(int i3) {
            if (i3 > 0) {
                this.f4036h = i3;
                return this;
            }
            throw new IllegalArgumentException("Invalid maxImage: " + i3);
        }

        public b c(int i3) {
            if (i3 >= 0 && i3 <= 100) {
                this.f4035g = i3;
                return this;
            }
            throw new IllegalArgumentException("Invalid quality: " + i3);
        }
    }

    class c extends e.c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4040a;

        c() {
        }

        private void e(Exception exc) {
            if (this.f4040a) {
                return;
            }
            this.f4040a = true;
            f.this.f4020k.a(exc);
        }

        @Override // n.e.c
        public void a(e eVar) {
            e(null);
        }

        @Override // n.e.c
        public void b(e eVar, ByteBuffer byteBuffer) {
            if (this.f4040a) {
                return;
            }
            f fVar = f.this;
            if (fVar.f4024o == null) {
                e(new IllegalStateException("Output buffer received before format info"));
                return;
            }
            if (fVar.f4025p < fVar.f4018i * fVar.f4016g) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0L, 0);
                f fVar2 = f.this;
                fVar2.f4021l.writeSampleData(fVar2.f4024o[fVar2.f4025p / fVar2.f4016g], byteBuffer, bufferInfo);
            }
            f fVar3 = f.this;
            int i3 = fVar3.f4025p + 1;
            fVar3.f4025p = i3;
            if (i3 == fVar3.f4018i * fVar3.f4016g) {
                e(null);
            }
        }

        @Override // n.e.c
        public void c(e eVar, MediaCodec.CodecException codecException) {
            e(codecException);
        }

        @Override // n.e.c
        public void d(e eVar, MediaFormat mediaFormat) {
            if (this.f4040a) {
                return;
            }
            if (f.this.f4024o != null) {
                e(new IllegalStateException("Output format changed after muxer started"));
                return;
            }
            try {
                f.this.f4016g = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
            } catch (ClassCastException | NullPointerException unused) {
                f.this.f4016g = 1;
            }
            f fVar = f.this;
            fVar.f4024o = new int[fVar.f4018i];
            if (fVar.f4017h > 0) {
                Log.d("HeifWriter", "setting rotation: " + f.this.f4017h);
                f fVar2 = f.this;
                fVar2.f4021l.setOrientationHint(fVar2.f4017h);
            }
            int i3 = 0;
            while (true) {
                f fVar3 = f.this;
                if (i3 >= fVar3.f4024o.length) {
                    fVar3.f4021l.start();
                    f.this.f4023n.set(true);
                    f.this.f();
                    return;
                } else {
                    mediaFormat.setInteger("is-default", i3 == fVar3.f4019j ? 1 : 0);
                    f fVar4 = f.this;
                    fVar4.f4024o[i3] = fVar4.f4021l.addTrack(mediaFormat);
                    i3++;
                }
            }
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4042a;

        /* renamed from: b, reason: collision with root package name */
        private Exception f4043b;

        d() {
        }

        synchronized void a(Exception exc) {
            if (!this.f4042a) {
                this.f4042a = true;
                this.f4043b = exc;
                notifyAll();
            }
        }

        synchronized void b(long j3) {
            if (j3 < 0) {
                throw new IllegalArgumentException("timeoutMs is negative");
            }
            if (j3 == 0) {
                while (!this.f4042a) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                while (!this.f4042a && j3 > 0) {
                    try {
                        wait(j3);
                    } catch (InterruptedException unused2) {
                    }
                    j3 -= System.currentTimeMillis() - currentTimeMillis;
                }
            }
            if (!this.f4042a) {
                this.f4042a = true;
                this.f4043b = new TimeoutException("timed out waiting for result");
            }
            Exception exc = this.f4043b;
            if (exc != null) {
                throw exc;
            }
        }
    }

    f(String str, FileDescriptor fileDescriptor, int i3, int i4, int i5, boolean z3, int i6, int i7, int i8, int i9, Handler handler) {
        if (i8 >= i7) {
            throw new IllegalArgumentException("Invalid maxImages (" + i7 + ") or primaryIndex (" + i8 + ")");
        }
        MediaFormat.createVideoFormat("image/vnd.android.heic", i3, i4);
        this.f4016g = 1;
        this.f4017h = i5;
        this.f4013c = i9;
        this.f4018i = i7;
        this.f4019j = i8;
        Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
            this.f4014d = handlerThread;
            handlerThread.start();
            looper = handlerThread.getLooper();
        } else {
            this.f4014d = null;
        }
        Handler handler2 = new Handler(looper);
        this.f4015f = handler2;
        this.f4021l = str != null ? new MediaMuxer(str, 3) : new MediaMuxer(fileDescriptor, 3);
        this.f4022m = new e(i3, i4, z3, i6, i9, handler2, new c());
    }

    private void b(int i3) {
        if (this.f4013c == i3) {
            return;
        }
        throw new IllegalStateException("Not valid in input mode " + this.f4013c);
    }

    private void c(boolean z3) {
        if (this.f4026q != z3) {
            throw new IllegalStateException("Already started");
        }
    }

    private void d(int i3) {
        c(true);
        b(i3);
    }

    public void a(Bitmap bitmap) {
        d(2);
        synchronized (this) {
            e eVar = this.f4022m;
            if (eVar != null) {
                eVar.b(bitmap);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f4015f.postAtFrontOfQueue(new a());
    }

    void e() {
        MediaMuxer mediaMuxer = this.f4021l;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f4021l.release();
            this.f4021l = null;
        }
        e eVar = this.f4022m;
        if (eVar != null) {
            eVar.close();
            synchronized (this) {
                this.f4022m = null;
            }
        }
    }

    void f() {
        Pair<Integer, ByteBuffer> remove;
        if (!this.f4023n.get()) {
            return;
        }
        while (true) {
            synchronized (this.f4027r) {
                if (this.f4027r.isEmpty()) {
                    return;
                } else {
                    remove = this.f4027r.remove(0);
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(((ByteBuffer) remove.second).position(), ((ByteBuffer) remove.second).remaining(), 0L, 16);
            this.f4021l.writeSampleData(this.f4024o[((Integer) remove.first).intValue()], (ByteBuffer) remove.second, bufferInfo);
        }
    }

    public void g() {
        c(false);
        this.f4026q = true;
        this.f4022m.j();
    }

    public void h(long j3) {
        c(true);
        synchronized (this) {
            e eVar = this.f4022m;
            if (eVar != null) {
                eVar.k();
            }
        }
        this.f4020k.b(j3);
        f();
        e();
    }
}
