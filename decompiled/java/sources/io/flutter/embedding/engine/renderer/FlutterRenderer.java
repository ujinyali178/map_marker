package io.flutter.embedding.engine.renderer;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /root/release/classes.dex */
public class FlutterRenderer implements TextureRegistry {

    /* renamed from: k, reason: collision with root package name */
    public static boolean f2982k;

    /* renamed from: c, reason: collision with root package name */
    private final FlutterJNI f2983c;

    /* renamed from: f, reason: collision with root package name */
    private Surface f2985f;

    /* renamed from: j, reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f2989j;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicLong f2984d = new AtomicLong(0);

    /* renamed from: g, reason: collision with root package name */
    private boolean f2986g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f2987h = new Handler();

    /* renamed from: i, reason: collision with root package name */
    private final Set<WeakReference<TextureRegistry.b>> f2988i = new HashSet();

    final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.b {
        private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
        private static final int MAX_IMAGES = 5;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private static final boolean VERBOSE_LOGS = false;
        private final long id;
        private boolean released;
        private boolean ignoringFence = false;
        private boolean trimOnMemoryPressure = true;
        private int requestedWidth = 1;
        private int requestedHeight = 1;
        private boolean createNewReader = true;
        private long lastDequeueTime = 0;
        private long lastQueueTime = 0;
        private long lastScheduleTime = 0;
        private int numTrims = 0;
        private Object lock = new Object();
        private final ArrayDeque<b> imageReaderQueue = new ArrayDeque<>();
        private final HashMap<ImageReader, b> perImageReaders = new HashMap<>();
        private a lastDequeuedImage = null;
        private b lastReaderDequeuedFrom = null;

        private class a {

            /* renamed from: a, reason: collision with root package name */
            public final Image f2990a;

            /* renamed from: b, reason: collision with root package name */
            public final long f2991b;

            public a(Image image, long j3) {
                this.f2990a = image;
                this.f2991b = j3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        class b {

            /* renamed from: a, reason: collision with root package name */
            public final ImageReader f2993a;

            /* renamed from: b, reason: collision with root package name */
            private final ArrayDeque<a> f2994b = new ArrayDeque<>();

            /* renamed from: c, reason: collision with root package name */
            private boolean f2995c = false;

            /* renamed from: d, reason: collision with root package name */
            private final ImageReader.OnImageAvailableListener f2996d;

            public b(ImageReader imageReader) {
                ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.a
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader2) {
                        FlutterRenderer.ImageReaderSurfaceProducer.b.this.f(imageReader2);
                    }
                };
                this.f2996d = onImageAvailableListener;
                this.f2993a = imageReader;
                imageReader.setOnImageAvailableListener(onImageAvailableListener, new Handler(Looper.getMainLooper()));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(ImageReader imageReader) {
                Image image;
                try {
                    image = imageReader.acquireLatestImage();
                } catch (IllegalStateException e3) {
                    g1.b.b(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e3);
                    image = null;
                }
                if (image == null) {
                    return;
                }
                if (ImageReaderSurfaceProducer.this.released || this.f2995c) {
                    image.close();
                } else {
                    ImageReaderSurfaceProducer.this.onImage(imageReader, image);
                }
            }

            boolean c() {
                return this.f2994b.size() == 0 && ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom != this;
            }

            void d() {
                this.f2995c = true;
                this.f2993a.close();
                this.f2994b.clear();
            }

            a e() {
                if (this.f2994b.size() == 0) {
                    return null;
                }
                return this.f2994b.removeFirst();
            }

            a g(Image image) {
                if (this.f2995c) {
                    return null;
                }
                a aVar = ImageReaderSurfaceProducer.this.new a(image, System.nanoTime());
                this.f2994b.add(aVar);
                while (this.f2994b.size() > 2) {
                    this.f2994b.removeFirst().f2990a.close();
                }
                return aVar;
            }
        }

        ImageReaderSurfaceProducer(long j3) {
            this.id = j3;
        }

        private void cleanup() {
            synchronized (this.lock) {
                for (b bVar : this.perImageReaders.values()) {
                    if (this.lastReaderDequeuedFrom == bVar) {
                        this.lastReaderDequeuedFrom = null;
                    }
                    bVar.d();
                }
                this.perImageReaders.clear();
                a aVar = this.lastDequeuedImage;
                if (aVar != null) {
                    aVar.f2990a.close();
                    this.lastDequeuedImage = null;
                }
                b bVar2 = this.lastReaderDequeuedFrom;
                if (bVar2 != null) {
                    bVar2.d();
                    this.lastReaderDequeuedFrom = null;
                }
                this.imageReaderQueue.clear();
            }
        }

        private ImageReader createImageReader() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 33) {
                return createImageReader33();
            }
            if (i3 >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        private ImageReader createImageReader29() {
            ImageReader newInstance;
            newInstance = ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 5, 256L);
            return newInstance;
        }

        private ImageReader createImageReader33() {
            ImageReader.Builder builder = new ImageReader.Builder(this.requestedWidth, this.requestedHeight);
            builder.setMaxImages(5);
            builder.setImageFormat(34);
            builder.setUsage(256L);
            return builder.build();
        }

        private b getActiveReader() {
            synchronized (this.lock) {
                if (!this.createNewReader) {
                    return this.imageReaderQueue.peekLast();
                }
                this.createNewReader = false;
                return getOrCreatePerImageReader(createImageReader());
            }
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
                g1.b.g(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void releaseInternal() {
            cleanup();
            this.released = true;
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            a dequeueImage = dequeueImage();
            if (dequeueImage == null) {
                return null;
            }
            maybeWaitOnFence(dequeueImage.f2990a);
            return dequeueImage.f2990a;
        }

        double deltaMillis(long j3) {
            return j3 / 1000000.0d;
        }

        a dequeueImage() {
            a aVar;
            synchronized (this.lock) {
                Iterator<b> it = this.imageReaderQueue.iterator();
                aVar = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    a e3 = next.e();
                    if (e3 == null) {
                        aVar = e3;
                    } else {
                        a aVar2 = this.lastDequeuedImage;
                        if (aVar2 != null) {
                            aVar2.f2990a.close();
                            this.lastDequeuedImage = null;
                        }
                        this.lastDequeuedImage = e3;
                        this.lastReaderDequeuedFrom = next;
                        aVar = e3;
                    }
                }
                pruneImageReaderQueue();
            }
            return aVar;
        }

        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        protected void finalize() {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer.this.f2987h.post(new f(this.id, FlutterRenderer.this.f2983c));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        b getOrCreatePerImageReader(ImageReader imageReader) {
            b bVar = this.perImageReaders.get(imageReader);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b(imageReader);
            this.perImageReaders.put(imageReader, bVar2);
            this.imageReaderQueue.add(bVar2);
            return bVar2;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            return getActiveReader().f2993a.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public long id() {
            return this.id;
        }

        public int numImageReaders() {
            int size;
            synchronized (this.lock) {
                size = this.imageReaderQueue.size();
            }
            return size;
        }

        public int numImages() {
            int i3;
            synchronized (this.lock) {
                Iterator<b> it = this.imageReaderQueue.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    i3 += it.next().f2994b.size();
                }
            }
            return i3;
        }

        public int numTrims() {
            int i3;
            synchronized (this.lock) {
                i3 = this.numTrims;
            }
            return i3;
        }

        void onImage(ImageReader imageReader, Image image) {
            a g3;
            synchronized (this.lock) {
                g3 = getOrCreatePerImageReader(imageReader).g(image);
            }
            if (g3 == null) {
                return;
            }
            FlutterRenderer.this.v();
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i3) {
            if (this.trimOnMemoryPressure && i3 >= 40) {
                synchronized (this.lock) {
                    this.numTrims++;
                }
                cleanup();
                this.createNewReader = true;
            }
        }

        void pruneImageReaderQueue() {
            while (this.imageReaderQueue.size() > 1) {
                b peekFirst = this.imageReaderQueue.peekFirst();
                if (!peekFirst.c()) {
                    return;
                }
                this.imageReaderQueue.removeFirst();
                this.perImageReaders.remove(peekFirst.f2993a);
                peekFirst.d();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer.this.C(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void scheduleFrame() {
            FlutterRenderer.this.v();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int i3, int i4) {
            int max = Math.max(1, i3);
            int max2 = Math.max(1, i4);
            if (this.requestedWidth == max && this.requestedHeight == max2) {
                return;
            }
            this.createNewReader = true;
            this.requestedHeight = max2;
            this.requestedWidth = max;
        }
    }

    final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        ImageTextureRegistryEntry(long j3) {
            this.id = j3;
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
                g1.b.g(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image);
            return image;
        }

        protected void finalize() {
            try {
                if (this.released) {
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.f2987h.post(new f(this.id, FlutterRenderer.this.f2983c));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image image2;
            if (this.released) {
                return;
            }
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                g1.b.b(TAG, "Dropping PlatformView Frame");
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.v();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer.this.C(this.id);
        }
    }

    class a implements io.flutter.embedding.engine.renderer.d {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void b() {
            FlutterRenderer.this.f2986g = false;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            FlutterRenderer.this.f2986g = true;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f2999a;

        /* renamed from: b, reason: collision with root package name */
        public final d f3000b;

        /* renamed from: c, reason: collision with root package name */
        public final c f3001c;

        public b(Rect rect, d dVar) {
            this.f2999a = rect;
            this.f3000b = dVar;
            this.f3001c = c.UNKNOWN;
        }

        public b(Rect rect, d dVar, c cVar) {
            this.f2999a = rect;
            this.f3000b = dVar;
            this.f3001c = cVar;
        }
    }

    public enum c {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);


        /* renamed from: c, reason: collision with root package name */
        public final int f3006c;

        c(int i3) {
            this.f3006c = i3;
        }
    }

    public enum d {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);


        /* renamed from: c, reason: collision with root package name */
        public final int f3012c;

        d(int i3) {
            this.f3012c = i3;
        }
    }

    final class e implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.b {

        /* renamed from: a, reason: collision with root package name */
        private final long f3013a;

        /* renamed from: b, reason: collision with root package name */
        private final SurfaceTextureWrapper f3014b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3015c;

        /* renamed from: d, reason: collision with root package name */
        private TextureRegistry.b f3016d;

        /* renamed from: e, reason: collision with root package name */
        private TextureRegistry.a f3017e;

        e(long j3, SurfaceTexture surfaceTexture) {
            this.f3013a = j3;
            this.f3014b = new SurfaceTextureWrapper(surfaceTexture, new Runnable() { // from class: io.flutter.embedding.engine.renderer.b
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterRenderer.e.this.c();
                }
            });
            surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.c
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    FlutterRenderer.e.this.d(surfaceTexture2);
                }
            }, new Handler());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            TextureRegistry.a aVar = this.f3017e;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(SurfaceTexture surfaceTexture) {
            if (this.f3015c || !FlutterRenderer.this.f2983c.isAttached()) {
                return;
            }
            this.f3014b.markDirty();
            FlutterRenderer.this.v();
        }

        private void e() {
            FlutterRenderer.this.u(this);
        }

        public SurfaceTextureWrapper f() {
            return this.f3014b;
        }

        protected void finalize() {
            try {
                if (this.f3015c) {
                    return;
                }
                FlutterRenderer.this.f2987h.post(new f(this.f3013a, FlutterRenderer.this.f2983c));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.f3013a;
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i3) {
            TextureRegistry.b bVar = this.f3016d;
            if (bVar != null) {
                bVar.onTrimMemory(i3);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.f3015c) {
                return;
            }
            g1.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f3013a + ").");
            this.f3014b.release();
            FlutterRenderer.this.C(this.f3013a);
            e();
            this.f3015c = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(TextureRegistry.a aVar) {
            this.f3017e = aVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnTrimMemoryListener(TextureRegistry.b bVar) {
            this.f3016d = bVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            return this.f3014b.surfaceTexture();
        }
    }

    static final class f implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        private final long f3019c;

        /* renamed from: d, reason: collision with root package name */
        private final FlutterJNI f3020d;

        f(long j3, FlutterJNI flutterJNI) {
            this.f3019c = j3;
            this.f3020d = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3020d.isAttached()) {
                g1.b.f("FlutterRenderer", "Releasing a Texture (" + this.f3019c + ").");
                this.f3020d.unregisterTexture(this.f3019c);
            }
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public float f3021a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f3022b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f3023c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f3024d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f3025e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f3026f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f3027g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f3028h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f3029i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f3030j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f3031k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f3032l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f3033m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f3034n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f3035o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f3036p = -1;

        /* renamed from: q, reason: collision with root package name */
        public List<b> f3037q = new ArrayList();

        boolean a() {
            return this.f3022b > 0 && this.f3023c > 0 && this.f3021a > BitmapDescriptorFactory.HUE_RED;
        }
    }

    public FlutterRenderer(FlutterJNI flutterJNI) {
        a aVar = new a();
        this.f2989j = aVar;
        this.f2983c = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(long j3) {
        this.f2983c.unregisterTexture(j3);
    }

    private void i() {
        Iterator<WeakReference<TextureRegistry.b>> it = this.f2988i.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
    }

    private void p(long j3, TextureRegistry.ImageConsumer imageConsumer) {
        this.f2983c.registerImageTexture(j3, imageConsumer);
    }

    private TextureRegistry.SurfaceTextureEntry q(long j3, SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        e eVar = new e(j3, surfaceTexture);
        g1.b.f("FlutterRenderer", "New SurfaceTexture ID: " + eVar.id());
        s(eVar.id(), eVar.f());
        g(eVar);
        return eVar;
    }

    private void s(long j3, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f2983c.registerTexture(j3, surfaceTextureWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f2983c.scheduleFrame();
    }

    public void A(int i3, int i4) {
        this.f2983c.onSurfaceChanged(i3, i4);
    }

    public void B(Surface surface) {
        this.f2985f = surface;
        this.f2983c.onSurfaceWindowChanged(surface);
    }

    public void f(io.flutter.embedding.engine.renderer.d dVar) {
        this.f2983c.addIsDisplayingFlutterUiListener(dVar);
        if (this.f2986g) {
            dVar.e();
        }
    }

    void g(TextureRegistry.b bVar) {
        i();
        this.f2988i.add(new WeakReference<>(bVar));
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry h() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.f2984d.getAndIncrement());
        g1.b.f("FlutterRenderer", "New ImageTextureEntry ID: " + imageTextureRegistryEntry.id());
        p(imageTextureRegistryEntry.id(), imageTextureRegistryEntry);
        return imageTextureRegistryEntry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer j() {
        if (f2982k || Build.VERSION.SDK_INT < 29) {
            TextureRegistry.SurfaceTextureEntry k3 = k();
            io.flutter.embedding.engine.renderer.f fVar = new io.flutter.embedding.engine.renderer.f(k3.id(), this.f2987h, this.f2983c, k3);
            g1.b.f("FlutterRenderer", "New SurfaceTextureSurfaceProducer ID: " + k3.id());
            return fVar;
        }
        long andIncrement = this.f2984d.getAndIncrement();
        ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(andIncrement);
        p(andIncrement, imageReaderSurfaceProducer);
        g(imageReaderSurfaceProducer);
        g1.b.f("FlutterRenderer", "New ImageReaderSurfaceProducer ID: " + andIncrement);
        return imageReaderSurfaceProducer;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry k() {
        g1.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return r(new SurfaceTexture(0));
    }

    public void l(ByteBuffer byteBuffer, int i3) {
        this.f2983c.dispatchPointerDataPacket(byteBuffer, i3);
    }

    public boolean m() {
        return this.f2986g;
    }

    public boolean n() {
        return this.f2983c.getIsSoftwareRenderingEnabled();
    }

    public void o(int i3) {
        Iterator<WeakReference<TextureRegistry.b>> it = this.f2988i.iterator();
        while (it.hasNext()) {
            TextureRegistry.b bVar = it.next().get();
            if (bVar != null) {
                bVar.onTrimMemory(i3);
            } else {
                it.remove();
            }
        }
    }

    public TextureRegistry.SurfaceTextureEntry r(SurfaceTexture surfaceTexture) {
        return q(this.f2984d.getAndIncrement(), surfaceTexture);
    }

    public void t(io.flutter.embedding.engine.renderer.d dVar) {
        this.f2983c.removeIsDisplayingFlutterUiListener(dVar);
    }

    void u(TextureRegistry.b bVar) {
        for (WeakReference<TextureRegistry.b> weakReference : this.f2988i) {
            if (weakReference.get() == bVar) {
                this.f2988i.remove(weakReference);
                return;
            }
        }
    }

    public void w(boolean z3) {
        this.f2983c.setSemanticsEnabled(z3);
    }

    public void x(g gVar) {
        if (gVar.a()) {
            g1.b.f("FlutterRenderer", "Setting viewport metrics\nSize: " + gVar.f3022b + " x " + gVar.f3023c + "\nPadding - L: " + gVar.f3027g + ", T: " + gVar.f3024d + ", R: " + gVar.f3025e + ", B: " + gVar.f3026f + "\nInsets - L: " + gVar.f3031k + ", T: " + gVar.f3028h + ", R: " + gVar.f3029i + ", B: " + gVar.f3030j + "\nSystem Gesture Insets - L: " + gVar.f3035o + ", T: " + gVar.f3032l + ", R: " + gVar.f3033m + ", B: " + gVar.f3033m + "\nDisplay Features: " + gVar.f3037q.size());
            int[] iArr = new int[gVar.f3037q.size() * 4];
            int[] iArr2 = new int[gVar.f3037q.size()];
            int[] iArr3 = new int[gVar.f3037q.size()];
            for (int i3 = 0; i3 < gVar.f3037q.size(); i3++) {
                b bVar = gVar.f3037q.get(i3);
                int i4 = i3 * 4;
                Rect rect = bVar.f2999a;
                iArr[i4] = rect.left;
                iArr[i4 + 1] = rect.top;
                iArr[i4 + 2] = rect.right;
                iArr[i4 + 3] = rect.bottom;
                iArr2[i3] = bVar.f3000b.f3012c;
                iArr3[i3] = bVar.f3001c.f3006c;
            }
            this.f2983c.setViewportMetrics(gVar.f3021a, gVar.f3022b, gVar.f3023c, gVar.f3024d, gVar.f3025e, gVar.f3026f, gVar.f3027g, gVar.f3028h, gVar.f3029i, gVar.f3030j, gVar.f3031k, gVar.f3032l, gVar.f3033m, gVar.f3034n, gVar.f3035o, gVar.f3036p, iArr, iArr2, iArr3);
        }
    }

    public void y(Surface surface, boolean z3) {
        if (!z3) {
            z();
        }
        this.f2985f = surface;
        if (z3) {
            this.f2983c.onSurfaceWindowChanged(surface);
        } else {
            this.f2983c.onSurfaceCreated(surface);
        }
    }

    public void z() {
        if (this.f2985f != null) {
            this.f2983c.onSurfaceDestroyed();
            if (this.f2986g) {
                this.f2989j.b();
            }
            this.f2986g = false;
            this.f2985f = null;
        }
    }
}
