package b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import b.a;
import b.d;
import h2.n;
import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public class c extends b.a<androidx.activity.result.f, List<Uri>> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1518b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f1519a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a() {
            if (d.f1520a.f()) {
                return MediaStore.getPickImagesMaxLimit();
            }
            return Integer.MAX_VALUE;
        }
    }

    public c() {
        this(0, 1, null);
    }

    public c(int i3) {
        this.f1519a = i3;
        if (!(i3 > 1)) {
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }
    }

    public /* synthetic */ c(int i3, int i4, kotlin.jvm.internal.g gVar) {
        this((i4 & 1) != 0 ? f1518b.a() : i3);
    }

    @Override // b.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, androidx.activity.result.f input) {
        k.e(context, "context");
        k.e(input, "input");
        d.a aVar = d.f1520a;
        if (aVar.f()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.c(input.a()));
            if (!(this.f1519a <= MediaStore.getPickImagesMaxLimit())) {
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f1519a);
            return intent;
        }
        if (aVar.e(context)) {
            ResolveInfo b4 = aVar.b(context);
            if (b4 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ActivityInfo activityInfo = b4.activityInfo;
            Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent2.setType(aVar.c(input.a()));
            intent2.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f1519a);
            return intent2;
        }
        if (aVar.d(context)) {
            ResolveInfo a4 = aVar.a(context);
            if (a4 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ActivityInfo activityInfo2 = a4.activityInfo;
            Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f1519a);
            return intent3;
        }
        Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent4.setType(aVar.c(input.a()));
        intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if (intent4.getType() != null) {
            return intent4;
        }
        intent4.setType("*/*");
        intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        return intent4;
    }

    @Override // b.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a.C0038a<List<Uri>> b(Context context, androidx.activity.result.f input) {
        k.e(context, "context");
        k.e(input, "input");
        return null;
    }

    @Override // b.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List<Uri> c(int i3, Intent intent) {
        List<Uri> a4;
        if (!(i3 == -1)) {
            intent = null;
        }
        return (intent == null || (a4 = b.f1517a.a(intent)) == null) ? n.d() : a4;
    }
}
