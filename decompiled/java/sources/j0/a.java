package j0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import io.flutter.embedding.android.FlutterActivity;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import l0.d;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterActivity f3684a;

    /* renamed from: j0.a$a, reason: collision with other inner class name */
    class C0090a implements l.c {
        C0090a() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            if (kVar.f4372a.equals("getGeoIntentOptions")) {
                a.f(a.this.f3684a, dVar);
            } else {
                dVar.c();
            }
        }
    }

    class b implements Comparator<c> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return d.d(cVar.f3688c).compareTo(d.d(cVar2.f3688c));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f3686a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f3687b;

        /* renamed from: c, reason: collision with root package name */
        public final String f3688c;

        c(String str, byte[] bArr, String str2) {
            this.f3686a = str;
            this.f3687b = bArr;
            this.f3688c = str2;
        }
    }

    public a(FlutterActivity flutterActivity) {
        this.f3684a = flutterActivity;
    }

    private static c d(Context context, String str) {
        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(str);
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        String charSequence = context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        int max = Math.max(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight());
        Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        applicationIcon.draw(canvas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        createBitmap.recycle();
        return new c(applicationInfo.packageName, byteArray, charSequence);
    }

    private static List<c> e(Context context) {
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0.0,0.0?q=0.0,0.0")), 0)) {
            if (!packageName.equals(resolveInfo.activityInfo.packageName)) {
                arrayList.add(d(context, resolveInfo.activityInfo.packageName));
            }
        }
        Collections.sort(arrayList, new b());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, l.d dVar) {
        try {
            ArrayList arrayList = new ArrayList();
            for (c cVar : e(context)) {
                HashMap hashMap = new HashMap();
                hashMap.put("appId", cVar.f3686a);
                hashMap.put("appIconBytes", cVar.f3687b);
                hashMap.put("appName", cVar.f3688c);
                arrayList.add(hashMap);
            }
            dVar.a(arrayList);
        } catch (Throwable th) {
            dVar.b("NLAPIGGIL", "NavigationLauncherApi.handleGetGeoIntentsList failed", th);
        }
    }

    public void c(io.flutter.embedding.engine.a aVar) {
        new l(aVar.k(), "com.exlyo.mapmarker/navigation_launcher_api").e(new C0090a());
    }
}
