package h0;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import io.flutter.embedding.android.FlutterActivity;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l0.d;
import org.apache.commons.io.IOUtils;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterActivity f2607a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Uri> f2608b = new HashMap();

    /* renamed from: h0.a$a, reason: collision with other inner class name */
    class C0077a implements l.c {
        C0077a() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            Object obj;
            if (kVar.f4372a.equals("getInboxItemId")) {
                obj = a.this.i();
            } else {
                if (!kVar.f4372a.equals("discardInboxItemId")) {
                    if (!kVar.f4372a.equals("getCopiedInboxItemFilePath")) {
                        dVar.c();
                        return;
                    }
                    try {
                        dVar.a(a.this.f((String) kVar.a("inboxItemId")));
                        return;
                    } catch (Throwable th) {
                        dVar.b("InboxFileCopyFailed", "Copying the inbox file failed: " + th.getMessage(), th);
                        return;
                    }
                }
                a.this.e((String) kVar.a("inboxItemId"));
                obj = null;
            }
            dVar.a(obj);
        }
    }

    public a(FlutterActivity flutterActivity) {
        this.f2607a = flutterActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f2608b) {
            this.f2608b.remove(str);
            File file = new File(g(this.f2607a, str));
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        if (str == null) {
            return null;
        }
        String g3 = g(this.f2607a, str);
        if (new File(g3).isFile()) {
            return g3;
        }
        Uri uri = this.f2608b.get(str);
        if (uri == null) {
            return null;
        }
        InputStream openInputStream = this.f2607a.getContentResolver().openInputStream(uri);
        try {
            d.c(openInputStream, g3);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return g3;
        } catch (Throwable th) {
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String g(Context context, String str) {
        return h(context) + File.separator + str;
    }

    public static String h(Context context) {
        String str = context.getCacheDir().getAbsolutePath() + IOUtils.DIR_SEPARATOR_UNIX + "FilesInbox";
        File file = new File(str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        synchronized (this.f2608b) {
            Iterator<String> it = this.f2608b.keySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            return it.next();
        }
    }

    private static Uri j(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            return data;
        }
        ClipData clipData = intent.getClipData();
        if (clipData == null || clipData.getItemCount() < 1) {
            return null;
        }
        return clipData.getItemAt(0).getUri();
    }

    private void k() {
        File[] listFiles = new File(h(this.f2607a)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    synchronized (this.f2608b) {
                        this.f2608b.put(file.getName(), null);
                    }
                }
            }
        }
    }

    public void d(io.flutter.embedding.engine.a aVar) {
        new l(aVar.k(), "com.exlyo.mapmarker/inbox_api").e(new C0077a());
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(android.content.Intent r6) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.a.l(android.content.Intent):void");
    }
}
