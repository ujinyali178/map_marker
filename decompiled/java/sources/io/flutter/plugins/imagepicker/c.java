package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import io.flutter.plugins.imagepicker.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3366a;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3367a;

        static {
            int[] iArr = new int[b.values().length];
            f3367a = iArr;
            try {
                iArr[b.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3367a[b.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        IMAGE,
        VIDEO
    }

    c(Context context) {
        this.f3366a = context;
    }

    private void h(String str) {
        this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_type", str).apply();
    }

    void a() {
        this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().clear().apply();
    }

    Map<String, Object> b() {
        Set<String> stringSet;
        HashMap hashMap = new HashMap();
        boolean z3 = false;
        SharedPreferences sharedPreferences = this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0);
        boolean z4 = true;
        if (sharedPreferences.contains("flutter_image_picker_image_path") && (stringSet = sharedPreferences.getStringSet("flutter_image_picker_image_path", null)) != null) {
            hashMap.put("pathList", new ArrayList(stringSet));
            z3 = true;
        }
        if (sharedPreferences.contains("flutter_image_picker_error_code")) {
            p.a.C0088a c0088a = new p.a.C0088a();
            c0088a.b(sharedPreferences.getString("flutter_image_picker_error_code", ""));
            if (sharedPreferences.contains("flutter_image_picker_error_message")) {
                c0088a.c(sharedPreferences.getString("flutter_image_picker_error_message", ""));
            }
            hashMap.put("error", c0088a.a());
        } else {
            z4 = z3;
        }
        if (z4) {
            if (sharedPreferences.contains("flutter_image_picker_type")) {
                hashMap.put("type", sharedPreferences.getString("flutter_image_picker_type", "").equals("video") ? p.c.VIDEO : p.c.IMAGE);
            }
            if (sharedPreferences.contains("flutter_image_picker_max_width")) {
                hashMap.put("maxWidth", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_width", 0L))));
            }
            if (sharedPreferences.contains("flutter_image_picker_max_height")) {
                hashMap.put("maxHeight", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_height", 0L))));
            }
            hashMap.put("imageQuality", Integer.valueOf(sharedPreferences.getInt("flutter_image_picker_image_quality", 100)));
        }
        return hashMap;
    }

    String c() {
        return this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", "");
    }

    void d(p.h hVar) {
        SharedPreferences.Editor edit = this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (hVar.c() != null) {
            edit.putLong("flutter_image_picker_max_width", Double.doubleToRawLongBits(hVar.c().doubleValue()));
        }
        if (hVar.b() != null) {
            edit.putLong("flutter_image_picker_max_height", Double.doubleToRawLongBits(hVar.b().doubleValue()));
        }
        edit.putInt("flutter_image_picker_image_quality", hVar.d().intValue());
        edit.apply();
    }

    void e(Uri uri) {
        this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().putString("flutter_image_picker_pending_image_uri", uri.getPath()).apply();
    }

    void f(ArrayList<String> arrayList, String str, String str2) {
        SharedPreferences.Editor edit = this.f3366a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (arrayList != null) {
            edit.putStringSet("flutter_image_picker_image_path", new HashSet(arrayList));
        }
        if (str != null) {
            edit.putString("flutter_image_picker_error_code", str);
        }
        if (str2 != null) {
            edit.putString("flutter_image_picker_error_message", str2);
        }
        edit.apply();
    }

    void g(b bVar) {
        String str;
        int i3 = a.f3367a[bVar.ordinal()];
        if (i3 == 1) {
            str = "image";
        } else if (i3 != 2) {
            return;
        } else {
            str = "video";
        }
        h(str);
    }
}
