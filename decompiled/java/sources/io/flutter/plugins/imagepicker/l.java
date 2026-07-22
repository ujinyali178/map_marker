package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.f;
import androidx.core.content.FileProvider;
import b.d;
import io.flutter.plugins.imagepicker.c;
import io.flutter.plugins.imagepicker.l;
import io.flutter.plugins.imagepicker.p;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class l implements n.a, n.d {

    /* renamed from: c, reason: collision with root package name */
    final String f3389c;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f3390d;

    /* renamed from: f, reason: collision with root package name */
    private final o f3391f;

    /* renamed from: g, reason: collision with root package name */
    private final io.flutter.plugins.imagepicker.c f3392g;

    /* renamed from: h, reason: collision with root package name */
    private final h f3393h;

    /* renamed from: i, reason: collision with root package name */
    private final d f3394i;

    /* renamed from: j, reason: collision with root package name */
    private final io.flutter.plugins.imagepicker.b f3395j;

    /* renamed from: k, reason: collision with root package name */
    private final ExecutorService f3396k;

    /* renamed from: l, reason: collision with root package name */
    private c f3397l;

    /* renamed from: m, reason: collision with root package name */
    private Uri f3398m;

    /* renamed from: n, reason: collision with root package name */
    private g f3399n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f3400o;

    class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3401a;

        a(Activity activity) {
            this.f3401a = activity;
        }

        @Override // io.flutter.plugins.imagepicker.l.h
        public void a(String str, int i3) {
            androidx.core.app.a.c(this.f3401a, new String[]{str}, i3);
        }

        @Override // io.flutter.plugins.imagepicker.l.h
        public boolean b(String str) {
            return androidx.core.content.a.checkSelfPermission(this.f3401a, str) == 0;
        }

        @Override // io.flutter.plugins.imagepicker.l.h
        public boolean c() {
            return n.b(this.f3401a);
        }
    }

    class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3402a;

        b(Activity activity) {
            this.f3402a = activity;
        }

        @Override // io.flutter.plugins.imagepicker.l.d
        public Uri a(String str, File file) {
            return FileProvider.g(this.f3402a, str, file);
        }

        @Override // io.flutter.plugins.imagepicker.l.d
        public void b(Uri uri, final f fVar) {
            Activity activity = this.f3402a;
            String[] strArr = new String[1];
            strArr[0] = uri != null ? uri.getPath() : "";
            MediaScannerConnection.scanFile(activity, strArr, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: io.flutter.plugins.imagepicker.m
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri2) {
                    l.f.this.a(str);
                }
            });
        }
    }

    public enum c {
        REAR,
        FRONT
    }

    interface d {
        Uri a(String str, File file);

        void b(Uri uri, f fVar);
    }

    public class e {

        /* renamed from: a, reason: collision with root package name */
        final String f3406a;

        /* renamed from: b, reason: collision with root package name */
        final String f3407b;

        public e(String str, String str2) {
            this.f3406a = str;
            this.f3407b = str2;
        }
    }

    interface f {
        void a(String str);
    }

    private static class g {

        /* renamed from: a, reason: collision with root package name */
        public final p.h f3409a;

        /* renamed from: b, reason: collision with root package name */
        public final p.n f3410b;

        /* renamed from: c, reason: collision with root package name */
        public final p.j<List<String>> f3411c;

        g(p.h hVar, p.n nVar, p.j<List<String>> jVar) {
            this.f3409a = hVar;
            this.f3410b = nVar;
            this.f3411c = jVar;
        }
    }

    interface h {
        void a(String str, int i3);

        boolean b(String str);

        boolean c();
    }

    public l(Activity activity, o oVar, io.flutter.plugins.imagepicker.c cVar) {
        this(activity, oVar, null, null, null, cVar, new a(activity), new b(activity), new io.flutter.plugins.imagepicker.b(), Executors.newSingleThreadExecutor());
    }

    l(Activity activity, o oVar, p.h hVar, p.n nVar, p.j<List<String>> jVar, io.flutter.plugins.imagepicker.c cVar, h hVar2, d dVar, io.flutter.plugins.imagepicker.b bVar, ExecutorService executorService) {
        this.f3400o = new Object();
        this.f3390d = activity;
        this.f3391f = oVar;
        this.f3389c = activity.getPackageName() + ".flutter.image_provider";
        if (jVar != null) {
            this.f3399n = new g(hVar, nVar, jVar);
        }
        this.f3393h = hVar2;
        this.f3394i = dVar;
        this.f3395j = bVar;
        this.f3392g = cVar;
        this.f3396k = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void I(int i3, Intent intent) {
        if (i3 != -1 || intent == null) {
            t(null);
            return;
        }
        ArrayList<e> arrayList = new ArrayList<>();
        if (intent.getClipData() != null) {
            for (int i4 = 0; i4 < intent.getClipData().getItemCount(); i4++) {
                arrayList.add(new e(this.f3395j.e(this.f3390d, intent.getClipData().getItemAt(i4).getUri()), null));
            }
        } else {
            arrayList.add(new e(this.f3395j.e(this.f3390d, intent.getData()), null));
        }
        E(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void L(int i3, Intent intent) {
        ClipData clipData;
        if (i3 != -1 || intent == null) {
            t(null);
            return;
        }
        Uri data = intent.getData();
        if (data == null && (clipData = intent.getClipData()) != null && clipData.getItemCount() == 1) {
            data = clipData.getItemAt(0).getUri();
        }
        if (data == null) {
            r("no_valid_video_uri", "Cannot find the selected video.");
        } else {
            F(this.f3395j.e(this.f3390d, data));
        }
    }

    private void E(ArrayList<e> arrayList) {
        p.h hVar;
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            hVar = gVar != null ? gVar.f3409a : null;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i3 = 0;
        if (hVar != null) {
            while (i3 < arrayList.size()) {
                e eVar = arrayList.get(i3);
                String str = eVar.f3406a;
                String str2 = eVar.f3407b;
                if (str2 == null || !str2.startsWith("video/")) {
                    str = u(eVar.f3406a, hVar);
                }
                arrayList2.add(str);
                i3++;
            }
        } else {
            while (i3 < arrayList.size()) {
                arrayList2.add(arrayList.get(i3).f3406a);
                i3++;
            }
        }
        s(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str) {
        t(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(String str) {
        D(str, true);
    }

    private void N(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new b.c().a(this.f3390d, new f.a().b(d.c.f1522a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        this.f3390d.startActivityForResult(intent, 2346);
    }

    private void O(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new b.d().a(this.f3390d, new f.a().b(d.c.f1522a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
        }
        this.f3390d.startActivityForResult(intent, 2342);
    }

    private void P(p.e eVar) {
        Intent intent;
        if (eVar.c().booleanValue()) {
            intent = eVar.b().booleanValue() ? new b.c().a(this.f3390d, new f.a().b(d.b.f1521a).a()) : new b.d().a(this.f3390d, new f.a().b(d.b.f1521a).a());
        } else {
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.setType("*/*");
            intent2.putExtra("CONTENT_TYPE", new String[]{"video/*", "image/*"});
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", eVar.b());
            intent = intent2;
        }
        this.f3390d.startActivityForResult(intent, 2347);
    }

    private void Q(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new b.d().a(this.f3390d, new f.a().b(d.e.f1524a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("video/*");
        }
        this.f3390d.startActivityForResult(intent, 2352);
    }

    private void R() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.f3397l == c.FRONT) {
            a0(intent);
        }
        File o3 = o();
        this.f3398m = Uri.parse("file:" + o3.getAbsolutePath());
        Uri a4 = this.f3394i.a(this.f3389c, o3);
        intent.putExtra("output", a4);
        v(intent, a4);
        try {
            try {
                this.f3390d.startActivityForResult(intent, 2343);
            } catch (ActivityNotFoundException unused) {
                o3.delete();
                r("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (SecurityException e3) {
            e3.printStackTrace();
            r("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private void S() {
        p.n nVar;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            nVar = gVar != null ? gVar.f3410b : null;
        }
        if (nVar != null && nVar.b() != null) {
            intent.putExtra("android.intent.extra.durationLimit", nVar.b().intValue());
        }
        if (this.f3397l == c.FRONT) {
            a0(intent);
        }
        File p3 = p();
        this.f3398m = Uri.parse("file:" + p3.getAbsolutePath());
        Uri a4 = this.f3394i.a(this.f3389c, p3);
        intent.putExtra("output", a4);
        v(intent, a4);
        try {
            try {
                this.f3390d.startActivityForResult(intent, 2353);
            } catch (ActivityNotFoundException unused) {
                p3.delete();
                r("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (SecurityException e3) {
            e3.printStackTrace();
            r("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private boolean T() {
        h hVar = this.f3393h;
        if (hVar == null) {
            return false;
        }
        return hVar.c();
    }

    private boolean X(p.h hVar, p.n nVar, p.j<List<String>> jVar) {
        synchronized (this.f3400o) {
            if (this.f3399n != null) {
                return false;
            }
            this.f3399n = new g(hVar, nVar, jVar);
            this.f3392g.a();
            return true;
        }
    }

    private void a0(Intent intent) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            return;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (i3 >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    private File n(String str) {
        String uuid = UUID.randomUUID().toString();
        File cacheDir = this.f3390d.getCacheDir();
        try {
            cacheDir.mkdirs();
            return File.createTempFile(uuid, str, cacheDir);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    private File o() {
        return n(".jpg");
    }

    private File p() {
        return n(".mp4");
    }

    private void q(p.j<List<String>> jVar) {
        jVar.b(new p.d("already_active", "Image picker is already active", null));
    }

    private void r(String str, String str2) {
        p.j<List<String>> jVar;
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            jVar = gVar != null ? gVar.f3411c : null;
            this.f3399n = null;
        }
        if (jVar == null) {
            this.f3392g.f(null, str, str2);
        } else {
            jVar.b(new p.d(str, str2, null));
        }
    }

    private void s(ArrayList<String> arrayList) {
        p.j<List<String>> jVar;
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            jVar = gVar != null ? gVar.f3411c : null;
            this.f3399n = null;
        }
        if (jVar == null) {
            this.f3392g.f(arrayList, null, null);
        } else {
            jVar.a(arrayList);
        }
    }

    private void t(String str) {
        p.j<List<String>> jVar;
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            arrayList.add(str);
        }
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            jVar = gVar != null ? gVar.f3411c : null;
            this.f3399n = null;
        }
        if (jVar != null) {
            jVar.a(arrayList);
        } else {
            if (arrayList.isEmpty()) {
                return;
            }
            this.f3392g.f(arrayList, null, null);
        }
    }

    private String u(String str, p.h hVar) {
        return this.f3391f.j(str, hVar.c(), hVar.b(), hVar.d().intValue());
    }

    private void v(Intent intent, Uri uri) {
        Iterator<ResolveInfo> it = this.f3390d.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            this.f3390d.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void J(int i3) {
        if (i3 != -1) {
            t(null);
            return;
        }
        Uri uri = this.f3398m;
        d dVar = this.f3394i;
        if (uri == null) {
            uri = Uri.parse(this.f3392g.c());
        }
        dVar.b(uri, new f() { // from class: io.flutter.plugins.imagepicker.j
            @Override // io.flutter.plugins.imagepicker.l.f
            public final void a(String str) {
                l.this.G(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void M(int i3) {
        if (i3 != -1) {
            t(null);
            return;
        }
        Uri uri = this.f3398m;
        d dVar = this.f3394i;
        if (uri == null) {
            uri = Uri.parse(this.f3392g.c());
        }
        dVar.b(uri, new f() { // from class: io.flutter.plugins.imagepicker.k
            @Override // io.flutter.plugins.imagepicker.l.f
            public final void a(String str) {
                l.this.F(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void H(int i3, Intent intent) {
        ClipData clipData;
        if (i3 != -1 || intent == null) {
            t(null);
            return;
        }
        Uri data = intent.getData();
        if (data == null && (clipData = intent.getClipData()) != null && clipData.getItemCount() == 1) {
            data = clipData.getItemAt(0).getUri();
        }
        if (data == null) {
            r("no_valid_image_uri", "Cannot find the selected image.");
        } else {
            D(this.f3395j.e(this.f3390d, data), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void K(int i3, Intent intent) {
        if (i3 != -1 || intent == null) {
            t(null);
            return;
        }
        ArrayList<e> arrayList = new ArrayList<>();
        if (intent.getClipData() != null) {
            for (int i4 = 0; i4 < intent.getClipData().getItemCount(); i4++) {
                Uri uri = intent.getClipData().getItemAt(i4).getUri();
                arrayList.add(new e(this.f3395j.e(this.f3390d, uri), this.f3390d.getContentResolver().getType(uri)));
            }
        } else {
            arrayList.add(new e(this.f3395j.e(this.f3390d, intent.getData()), null));
        }
        E(arrayList);
    }

    void D(String str, boolean z3) {
        p.h hVar;
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            hVar = gVar != null ? gVar.f3409a : null;
        }
        if (hVar == null) {
            t(str);
            return;
        }
        String u3 = u(str, hVar);
        if (u3 != null && !u3.equals(str) && z3) {
            new File(str).delete();
        }
        t(u3);
    }

    p.b U() {
        Map<String, Object> b4 = this.f3392g.b();
        if (b4.isEmpty()) {
            return null;
        }
        p.b.a aVar = new p.b.a();
        p.c cVar = (p.c) b4.get("type");
        if (cVar != null) {
            aVar.d(cVar);
        }
        aVar.b((p.a) b4.get("error"));
        ArrayList arrayList = (ArrayList) b4.get("pathList");
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Double d3 = (Double) b4.get("maxWidth");
                Double d4 = (Double) b4.get("maxHeight");
                Integer num = (Integer) b4.get("imageQuality");
                arrayList2.add(this.f3391f.j(str, d3, d4, num == null ? 100 : num.intValue()));
            }
            aVar.c(arrayList2);
        }
        this.f3392g.a();
        return aVar.a();
    }

    void V() {
        synchronized (this.f3400o) {
            g gVar = this.f3399n;
            if (gVar == null) {
                return;
            }
            p.h hVar = gVar.f3409a;
            this.f3392g.g(hVar != null ? c.b.IMAGE : c.b.VIDEO);
            if (hVar != null) {
                this.f3392g.d(hVar);
            }
            Uri uri = this.f3398m;
            if (uri != null) {
                this.f3392g.e(uri);
            }
        }
    }

    void W(c cVar) {
        this.f3397l = cVar;
    }

    public void Y(p.h hVar, p.j<List<String>> jVar) {
        if (!X(hVar, null, jVar)) {
            q(jVar);
        } else if (!T() || this.f3393h.b("android.permission.CAMERA")) {
            R();
        } else {
            this.f3393h.a("android.permission.CAMERA", 2345);
        }
    }

    public void Z(p.n nVar, p.j<List<String>> jVar) {
        if (!X(null, nVar, jVar)) {
            q(jVar);
        } else if (!T() || this.f3393h.b("android.permission.CAMERA")) {
            S();
        } else {
            this.f3393h.a("android.permission.CAMERA", 2355);
        }
    }

    @Override // u1.n.a
    public boolean a(int i3, final int i4, final Intent intent) {
        Runnable runnable;
        if (i3 == 2342) {
            runnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.d
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.H(i4, intent);
                }
            };
        } else if (i3 == 2343) {
            runnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.f
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.J(i4);
                }
            };
        } else if (i3 == 2346) {
            runnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.e
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.I(i4, intent);
                }
            };
        } else if (i3 == 2347) {
            runnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.K(i4, intent);
                }
            };
        } else if (i3 == 2352) {
            runnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.h
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.L(i4, intent);
                }
            };
        } else {
            if (i3 != 2353) {
                return false;
            }
            runnable = new Runnable() { // from class: io.flutter.plugins.imagepicker.i
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.M(i4);
                }
            };
        }
        this.f3396k.execute(runnable);
        return true;
    }

    public void j(p.h hVar, boolean z3, p.j<List<String>> jVar) {
        if (X(hVar, null, jVar)) {
            O(Boolean.valueOf(z3));
        } else {
            q(jVar);
        }
    }

    public void k(p.i iVar, p.e eVar, p.j<List<String>> jVar) {
        if (X(iVar.b(), null, jVar)) {
            P(eVar);
        } else {
            q(jVar);
        }
    }

    public void l(p.h hVar, boolean z3, p.j<List<String>> jVar) {
        if (X(hVar, null, jVar)) {
            N(Boolean.valueOf(z3));
        } else {
            q(jVar);
        }
    }

    public void m(p.n nVar, boolean z3, p.j<List<String>> jVar) {
        if (X(null, nVar, jVar)) {
            Q(Boolean.valueOf(z3));
        } else {
            q(jVar);
        }
    }

    @Override // u1.n.d
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        boolean z3 = iArr.length > 0 && iArr[0] == 0;
        if (i3 != 2345) {
            if (i3 != 2355) {
                return false;
            }
            if (z3) {
                S();
            }
        } else if (z3) {
            R();
        }
        if (!z3 && (i3 == 2345 || i3 == 2355)) {
            r("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }
}
