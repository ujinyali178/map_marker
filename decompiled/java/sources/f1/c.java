package f1;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import g2.g;
import h2.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import v2.m;
import v2.n;

/* loaded from: /root/release/classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2510a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f2511b;

    /* renamed from: c, reason: collision with root package name */
    private final e f2512c;

    /* renamed from: d, reason: collision with root package name */
    private final g2.e f2513d;

    /* renamed from: e, reason: collision with root package name */
    private final g2.e f2514e;

    static final class a extends l implements p2.a<Integer> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f2515c = new a();

        a() {
            super(0);
        }

        @Override // p2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT >= 23 ? 33554432 : 0);
        }
    }

    static final class b extends l implements p2.a<String> {
        b() {
            super(0);
        }

        @Override // p2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return c.this.e().getPackageName() + ".flutter.share_provider";
        }
    }

    public c(Context context, Activity activity, e manager) {
        g2.e a4;
        g2.e a5;
        k.e(context, "context");
        k.e(manager, "manager");
        this.f2510a = context;
        this.f2511b = activity;
        this.f2512c = manager;
        a4 = g.a(new b());
        this.f2513d = a4;
        a5 = g.a(a.f2515c);
        this.f2514e = a5;
    }

    private final void b() {
        File i3 = i();
        File[] files = i3.listFiles();
        if (i3.exists()) {
            boolean z3 = true;
            if (files != null) {
                if (!(files.length == 0)) {
                    z3 = false;
                }
            }
            if (z3) {
                return;
            }
            k.d(files, "files");
            for (File file : files) {
                file.delete();
            }
            i3.delete();
        }
    }

    private final File c(File file) {
        File i3 = i();
        if (!i3.exists()) {
            i3.mkdirs();
        }
        File file2 = new File(i3, file.getName());
        n2.k.c(file, file2, true, 0, 4, null);
        return file2;
    }

    private final boolean d(File file) {
        boolean o3;
        try {
            String filePath = file.getCanonicalPath();
            k.d(filePath, "filePath");
            String canonicalPath = i().getCanonicalPath();
            k.d(canonicalPath, "shareCacheFolder.canonicalPath");
            o3 = m.o(filePath, canonicalPath, false, 2, null);
            return o3;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context e() {
        Activity activity = this.f2511b;
        if (activity == null) {
            return this.f2510a;
        }
        k.b(activity);
        return activity;
    }

    private final int f() {
        return ((Number) this.f2514e.getValue()).intValue();
    }

    private final String g(String str) {
        boolean r3;
        if (str != null) {
            r3 = n.r(str, "/", false, 2, null);
            if (r3) {
                String substring = str.substring(0, n.A(str, "/", 0, false, 6, null));
                k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "*";
    }

    private final String h() {
        return (String) this.f2513d.getValue();
    }

    private final File i() {
        return new File(e().getCacheDir(), "share_plus");
    }

    private final ArrayList<Uri> j(List<String> list) {
        ArrayList<Uri> arrayList = new ArrayList<>(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (d(file)) {
                throw new IOException("Shared file can not be located in '" + i().getCanonicalPath() + "'");
            }
            arrayList.add(FileProvider.g(e(), h(), c(file)));
        }
        return arrayList;
    }

    private final String k(List<String> list) {
        Object l3;
        int e3;
        Object l4;
        boolean z3 = false;
        int i3 = 1;
        if (list != null && !list.isEmpty()) {
            z3 = true;
        }
        if (!z3) {
            return "*/*";
        }
        if (list.size() == 1) {
            l4 = v.l(list);
            return (String) l4;
        }
        l3 = v.l(list);
        String str = (String) l3;
        e3 = h2.n.e(list);
        if (1 <= e3) {
            while (true) {
                if (!k.a(str, list.get(i3))) {
                    if (!k.a(g(str), g(list.get(i3)))) {
                        return "*/*";
                    }
                    str = g(list.get(i3)) + "/*";
                }
                if (i3 == e3) {
                    break;
                }
                i3++;
            }
        }
        return str;
    }

    private final void o(Intent intent, boolean z3) {
        Activity activity = this.f2511b;
        if (activity == null) {
            intent.addFlags(268435456);
            if (z3) {
                this.f2512c.e();
            }
            this.f2510a.startActivity(intent);
            return;
        }
        k.b(activity);
        if (z3) {
            activity.startActivityForResult(intent, 22643);
        } else {
            activity.startActivity(intent);
        }
    }

    public final void l(Activity activity) {
        this.f2511b = activity;
    }

    public final void m(String text, String str, boolean z3) {
        k.e(text, "text");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", text);
        if (str != null) {
            intent.putExtra("android.intent.extra.SUBJECT", str);
        }
        Intent chooserIntent = (!z3 || Build.VERSION.SDK_INT < 22) ? Intent.createChooser(intent, null) : Intent.createChooser(intent, null, PendingIntent.getBroadcast(this.f2510a, 0, new Intent(this.f2510a, (Class<?>) SharePlusPendingIntent.class), 134217728 | f()).getIntentSender());
        k.d(chooserIntent, "chooserIntent");
        o(chooserIntent, z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.util.List<java.lang.String> r6, java.util.List<java.lang.String> r7, java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r5 = this;
            java.lang.String r0 = "paths"
            kotlin.jvm.internal.k.e(r6, r0)
            r5.b()
            java.util.ArrayList r6 = r5.j(r6)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r1 = r6.isEmpty()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2b
            if (r8 == 0) goto L24
            boolean r1 = v2.d.j(r8)
            if (r1 == 0) goto L22
            goto L24
        L22:
            r1 = 0
            goto L25
        L24:
            r1 = 1
        L25:
            if (r1 != 0) goto L2b
            r5.m(r8, r9, r10)
            return
        L2b:
            int r1 = r6.size()
            java.lang.String r4 = "android.intent.extra.STREAM"
            if (r1 != r3) goto L5c
            if (r7 == 0) goto L3e
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L3c
            goto L3e
        L3c:
            r1 = 0
            goto L3f
        L3e:
            r1 = 1
        L3f:
            if (r1 != 0) goto L48
            java.lang.Object r7 = h2.l.l(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L4a
        L48:
        */
        //  java.lang.String r7 = "*/*"
        /*
        L4a:
            java.lang.String r1 = "android.intent.action.SEND"
            r0.setAction(r1)
            r0.setType(r7)
            java.lang.Object r7 = h2.l.l(r6)
            android.os.Parcelable r7 = (android.os.Parcelable) r7
            r0.putExtra(r4, r7)
            goto L6b
        L5c:
            java.lang.String r1 = "android.intent.action.SEND_MULTIPLE"
            r0.setAction(r1)
            java.lang.String r7 = r5.k(r7)
            r0.setType(r7)
            r0.putParcelableArrayListExtra(r4, r6)
        L6b:
            if (r8 == 0) goto L72
            java.lang.String r7 = "android.intent.extra.TEXT"
            r0.putExtra(r7, r8)
        L72:
            if (r9 == 0) goto L79
            java.lang.String r7 = "android.intent.extra.SUBJECT"
            r0.putExtra(r7, r9)
        L79:
            r0.addFlags(r3)
            r7 = 0
            if (r10 == 0) goto La4
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 22
            if (r8 < r9) goto La4
            android.content.Context r8 = r5.f2510a
            android.content.Intent r9 = new android.content.Intent
            android.content.Context r1 = r5.f2510a
            java.lang.Class<dev.fluttercommunity.plus.share.SharePlusPendingIntent> r3 = dev.fluttercommunity.plus.share.SharePlusPendingIntent.class
            r9.<init>(r1, r3)
            r1 = 134217728(0x8000000, float:3.85186E-34)
            int r3 = r5.f()
            r1 = r1 | r3
            android.app.PendingIntent r8 = android.app.PendingIntent.getBroadcast(r8, r2, r9, r1)
            android.content.IntentSender r8 = r8.getIntentSender()
            android.content.Intent r7 = f1.b.a(r0, r7, r8)
            goto La8
        La4:
            android.content.Intent r7 = android.content.Intent.createChooser(r0, r7)
        La8:
            android.content.Context r8 = r5.e()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            r9 = 65536(0x10000, float:9.1835E-41)
            java.util.List r8 = r8.queryIntentActivities(r7, r9)
            java.lang.String r9 = "getContext().packageMana…CH_DEFAULT_ONLY\n        )"
            kotlin.jvm.internal.k.d(r8, r9)
            java.util.Iterator r8 = r8.iterator()
        Lbf:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto Le8
            java.lang.Object r9 = r8.next()
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            java.lang.String r9 = r9.packageName
            java.util.Iterator r0 = r6.iterator()
        Ld3:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lbf
            java.lang.Object r1 = r0.next()
            android.net.Uri r1 = (android.net.Uri) r1
            android.content.Context r2 = r5.e()
            r3 = 3
            r2.grantUriPermission(r9, r1, r3)
            goto Ld3
        Le8:
            java.lang.String r6 = "chooserIntent"
            kotlin.jvm.internal.k.d(r7, r6)
            r5.o(r7, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.c.n(java.util.List, java.util.List, java.lang.String, java.lang.String, boolean):void");
    }
}
