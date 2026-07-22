package b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import b.a;
import g2.i;
import h2.v;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public class d extends b.a<androidx.activity.result.f, Uri> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1520a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final ResolveInfo a(Context context) {
            k.e(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
        }

        public final ResolveInfo b(Context context) {
            k.e(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String c(f input) {
            k.e(input, "input");
            if (input instanceof c) {
                return "image/*";
            }
            if (input instanceof e) {
                return "video/*";
            }
            if (input instanceof C0039d) {
                return ((C0039d) input).a();
            }
            if (input instanceof b) {
                return null;
            }
            throw new i();
        }

        public final boolean d(Context context) {
            k.e(context, "context");
            return a(context) != null;
        }

        public final boolean e(Context context) {
            k.e(context, "context");
            return b(context) != null;
        }

        public final boolean f() {
            int i3 = Build.VERSION.SDK_INT;
            return i3 >= 33 || (i3 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2);
        }
    }

    public static final class b implements f {

        /* renamed from: a, reason: collision with root package name */
        public static final b f1521a = new b();

        private b() {
        }
    }

    public static final class c implements f {

        /* renamed from: a, reason: collision with root package name */
        public static final c f1522a = new c();

        private c() {
        }
    }

    /* renamed from: b.d$d, reason: collision with other inner class name */
    public static final class C0039d implements f {

        /* renamed from: a, reason: collision with root package name */
        private final String f1523a;

        public final String a() {
            return this.f1523a;
        }
    }

    public static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        public static final e f1524a = new e();

        private e() {
        }
    }

    public interface f {
    }

    @Override // b.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, androidx.activity.result.f input) {
        ActivityInfo activityInfo;
        Intent intent;
        k.e(context, "context");
        k.e(input, "input");
        a aVar = f1520a;
        if (aVar.f()) {
            Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
            intent2.setType(aVar.c(input.a()));
            return intent2;
        }
        if (aVar.e(context)) {
            ResolveInfo b4 = aVar.b(context);
            if (b4 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            activityInfo = b4.activityInfo;
            intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
        } else {
            if (!aVar.d(context)) {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(aVar.c(input.a()));
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
            ResolveInfo a4 = aVar.a(context);
            if (a4 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            activityInfo = a4.activityInfo;
            intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
        }
        intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
        intent.setType(aVar.c(input.a()));
        return intent;
    }

    @Override // b.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a.C0038a<Uri> b(Context context, androidx.activity.result.f input) {
        k.e(context, "context");
        k.e(input, "input");
        return null;
    }

    @Override // b.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i3, Intent intent) {
        Object m3;
        if (!(i3 == -1)) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data == null) {
            m3 = v.m(b.b.f1517a.a(intent));
            data = (Uri) m3;
        }
        return data;
    }
}
