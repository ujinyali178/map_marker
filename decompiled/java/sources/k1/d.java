package k1;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import k1.d;

/* loaded from: /root/release/classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3730a;

    /* renamed from: b, reason: collision with root package name */
    private c f3731b;

    /* renamed from: c, reason: collision with root package name */
    private long f3732c;

    /* renamed from: d, reason: collision with root package name */
    private k1.b f3733d;

    /* renamed from: e, reason: collision with root package name */
    private FlutterJNI f3734e;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f3735f;

    /* renamed from: g, reason: collision with root package name */
    Future<b> f3736g;

    class a implements Callable<b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3737a;

        a(Context context) {
            this.f3737a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.f3734e.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b call() {
            e2.e f3 = e2.e.f("FlutterLoader initTask");
            try {
                d.a(d.this, this.f3737a);
                try {
                    d.this.f3734e.loadLibrary();
                    d.this.f3734e.updateRefreshRate();
                    d.this.f3735f.execute(new Runnable() { // from class: k1.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.a.this.c();
                        }
                    });
                    b bVar = new b(e2.b.d(this.f3737a), e2.b.a(this.f3737a), e2.b.c(this.f3737a), null);
                    if (f3 != null) {
                        f3.close();
                    }
                    return bVar;
                } catch (UnsatisfiedLinkError e3) {
                    if (!e3.toString().contains("couldn't find \"libflutter.so\"") && !e3.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                        throw e3;
                    }
                    String property = System.getProperty("os.arch");
                    File file = new File(d.this.f3733d.f3727f);
                    throw new UnsupportedOperationException("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: " + property + ", and the native libraries directory (with path " + file.getAbsolutePath() + ") contains the following files: " + Arrays.toString(file.list()), e3);
                }
            } catch (Throwable th) {
                if (f3 != null) {
                    try {
                        f3.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final String f3739a;

        /* renamed from: b, reason: collision with root package name */
        final String f3740b;

        /* renamed from: c, reason: collision with root package name */
        final String f3741c;

        private b(String str, String str2, String str3) {
            this.f3739a = str;
            this.f3740b = str2;
            this.f3741c = str3;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f3742a;

        public String a() {
            return this.f3742a;
        }
    }

    public d() {
        this(g1.a.e().d().a());
    }

    public d(FlutterJNI flutterJNI) {
        this(flutterJNI, g1.a.e().b());
    }

    public d(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f3730a = false;
        this.f3734e = flutterJNI;
        this.f3735f = executorService;
    }

    static /* synthetic */ e a(d dVar, Context context) {
        dVar.k(context);
        return null;
    }

    private String h(String str) {
        return this.f3733d.f3725d + File.separator + str;
    }

    private e k(Context context) {
        return null;
    }

    private static boolean m(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    public boolean e() {
        return this.f3733d.f3728g;
    }

    public void f(Context context, String[] strArr) {
        if (this.f3730a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f3731b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            e2.e f3 = e2.e.f("FlutterLoader#ensureInitializationComplete");
            try {
                b bVar = this.f3736g.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                StringBuilder sb = new StringBuilder();
                sb.append("--icu-native-lib-path=");
                sb.append(this.f3733d.f3727f);
                String str = File.separator;
                sb.append(str);
                sb.append("libflutter.so");
                arrayList.add(sb.toString());
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=" + this.f3733d.f3722a);
                arrayList.add("--aot-shared-library-name=" + this.f3733d.f3727f + str + this.f3733d.f3722a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--cache-dir-path=");
                sb2.append(bVar.f3740b);
                arrayList.add(sb2.toString());
                if (this.f3733d.f3726e != null) {
                    arrayList.add("--domain-network-policy=" + this.f3733d.f3726e);
                }
                if (this.f3731b.a() != null) {
                    arrayList.add("--log-tag=" + this.f3731b.a());
                }
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i3 = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i3 == 0) {
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                    i3 = (int) ((r6.totalMem / 1000000.0d) / 2.0d);
                }
                arrayList.add("--old-gen-heap-size=" + i3);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 12 * 4));
                arrayList.add("--prefetched-default-font-manager");
                if (bundle != null) {
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller", false)) {
                        arrayList.add("--enable-impeller");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                        arrayList.add("--enable-vulkan-validation");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                        arrayList.add("--enable-opengl-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                        arrayList.add("--enable-vulkan-gpu-tracing");
                    }
                    String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                    if (string != null) {
                        arrayList.add("--impeller-backend=" + string);
                    }
                }
                arrayList.add("--leak-vm=" + (m(bundle) ? "true" : "false"));
                this.f3734e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f3739a, bVar.f3740b, SystemClock.uptimeMillis() - this.f3732c);
                this.f3730a = true;
                if (f3 != null) {
                    f3.close();
                }
            } finally {
            }
        } catch (Exception e3) {
            g1.b.c("FlutterLoader", "Flutter initialization failed.", e3);
            throw new RuntimeException(e3);
        }
    }

    public String g() {
        return this.f3733d.f3725d;
    }

    public String i(String str) {
        return h(str);
    }

    public String j(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("packages");
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(str);
        return i(sb.toString());
    }

    public boolean l() {
        return this.f3730a;
    }

    public void n(Context context) {
        o(context, new c());
    }

    public void o(Context context, c cVar) {
        if (this.f3731b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        e2.e f3 = e2.e.f("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f3731b = cVar;
            this.f3732c = SystemClock.uptimeMillis();
            this.f3733d = k1.a.e(applicationContext);
            x.f((DisplayManager) applicationContext.getSystemService("display"), this.f3734e).g();
            this.f3736g = this.f3735f.submit(new a(applicationContext));
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
