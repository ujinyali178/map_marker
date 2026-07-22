package f0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.core.content.FileProvider;
import io.flutter.embedding.android.FlutterActivity;
import java.io.File;
import java.io.OutputStream;
import l0.d;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final int f2488e = Math.abs(-640835476);

    /* renamed from: a, reason: collision with root package name */
    private final FlutterActivity f2489a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f2490b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2491c = false;

    /* renamed from: d, reason: collision with root package name */
    private final d.a<Uri> f2492d = new C0073a();

    /* renamed from: f0.a$a, reason: collision with other inner class name */
    class C0073a implements d.a<Uri> {
        C0073a() {
        }
    }

    class b implements l.c {
        b() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            if (kVar.f4372a.equals("canSaveFileToSystemStorage")) {
                dVar.a(Boolean.valueOf(a.g()));
                return;
            }
            if (kVar.f4372a.equals("saveFileToSystemStorage")) {
                a.this.m((String) kVar.a("filePath"), (String) kVar.a("mimeType"), dVar);
            } else {
                if (!kVar.f4372a.equals("shareFileWithSystemApps")) {
                    dVar.c();
                    return;
                }
                a.this.p((String) kVar.a("filePath"), (String) kVar.a("mimeType"), dVar);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2495c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f2496d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l.d f2497f;

        c(String str, String str2, l.d dVar) {
            this.f2495c = str;
            this.f2496d = str2;
            this.f2497f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n(this.f2495c, this.f2496d, this.f2497f);
        }
    }

    class d implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f2499c;

        d(Intent intent) {
            this.f2499c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f2489a.startActivityForResult(this.f2499c, a.f2488e);
        }
    }

    class e implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l.d f2501c;

        e(l.d dVar) {
            this.f2501c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2501c.a(Boolean.FALSE);
        }
    }

    class f implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l.d f2503c;

        f(l.d dVar) {
            this.f2503c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2503c.a(Boolean.TRUE);
        }
    }

    class g implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l.d f2505c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Throwable f2506d;

        g(l.d dVar, Throwable th) {
            this.f2505c = dVar;
            this.f2506d = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2505c.b("SFTSSF", "FilesApi.saveFileToSystemStorage failed", this.f2506d);
        }
    }

    public a(FlutterActivity flutterActivity) {
        this.f2489a = flutterActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g() {
        return true;
    }

    private Uri i(int i3, int i4, Intent intent) {
        if (i4 == -1 && intent != null && i3 == f2488e) {
            return intent.getData();
        }
        return null;
    }

    private Uri j() {
        Uri uri;
        synchronized (this.f2492d) {
            while (this.f2491c) {
                l0.d.g(this.f2492d);
            }
            uri = this.f2490b;
        }
        return uri;
    }

    private static String k(Context context) {
        return context.getCacheDir().getAbsolutePath() + File.separator + "share_plus";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, l.d dVar) {
        AsyncTask.execute(new c(str, str2, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, l.d dVar) {
        if (!g() || str == null || str2 == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile()) {
            synchronized (this.f2492d) {
                this.f2491c = true;
                this.f2490b = null;
            }
            try {
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(str2);
                intent.putExtra("android.intent.extra.TITLE", file.getName());
                this.f2489a.runOnUiThread(new d(intent));
                Uri j3 = j();
                if (j3 == null) {
                    this.f2489a.runOnUiThread(new e(dVar));
                    return;
                }
                OutputStream b4 = l0.a.b(this.f2489a, j3);
                l0.d.b(file, b4);
                b4.close();
                this.f2489a.runOnUiThread(new f(dVar));
            } catch (Throwable th) {
                synchronized (this.f2492d) {
                    this.f2491c = false;
                    this.f2490b = null;
                    this.f2489a.runOnUiThread(new g(dVar, th));
                }
            }
        }
    }

    private static Uri o(Context context, File file) {
        String k3 = k(context);
        if (!k3.equals(file.getParent())) {
            File file2 = new File(k3 + File.separator + file.getName());
            File file3 = new File(k3);
            if (!file3.isDirectory() && !file3.mkdirs()) {
                throw new RuntimeException("Could not create folder: " + k3);
            }
            l0.d.a(file.getAbsolutePath(), file2.getAbsolutePath());
            file = file2;
        }
        return FileProvider.g(context, context.getPackageName() + ".flutter.share_provider", file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, l.d dVar) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(str2);
            intent.putExtra("android.intent.extra.STREAM", o(this.f2489a, new File(str)));
            this.f2489a.startActivity(Intent.createChooser(intent, ""));
            dVar.a(null);
        } catch (Throwable th) {
            dVar.b("SFWSA", "FilesApi.shareFileWithSystemApps failed", th);
        }
    }

    public void h(io.flutter.embedding.engine.a aVar) {
        new l(aVar.k(), "com.exlyo.mapmarker/files_api").e(new b());
    }

    public void l(int i3, int i4, Intent intent) {
        Uri i5 = i(i3, i4, intent);
        synchronized (this.f2492d) {
            this.f2490b = i5;
            this.f2491c = false;
            this.f2492d.notifyAll();
        }
    }
}
