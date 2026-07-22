package e0;

import android.content.Intent;
import android.database.CursorWindow;
import android.net.Uri;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import io.flutter.embedding.android.FlutterActivity;
import java.lang.reflect.Field;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterActivity f2479a;

    /* renamed from: b, reason: collision with root package name */
    private String f2480b;

    /* renamed from: e0.a$a, reason: collision with other inner class name */
    class C0072a implements l.c {
        C0072a() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            if (kVar.f4372a.equals("getLastDeepLinkingUrl")) {
                dVar.a(a.this.f2480b);
            } else {
                dVar.c();
            }
        }
    }

    public a(FlutterActivity flutterActivity) {
        this.f2479a = flutterActivity;
    }

    private void e(int i3) {
        Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
        declaredField.setAccessible(true);
        declaredField.set(null, Integer.valueOf(i3 * UserVerificationMethods.USER_VERIFY_ALL * UserVerificationMethods.USER_VERIFY_ALL));
        l0.a.a(this.f2479a, "sCursorWindowSize => " + i3 + "MB");
    }

    public void b(io.flutter.embedding.engine.a aVar) {
        new l(aVar.k(), "com.exlyo.mapmarker/deep_linking_api").e(new C0072a());
    }

    public boolean c(Intent intent) {
        Uri data;
        int indexOf;
        if (intent == null || (data = intent.getData()) == null) {
            return false;
        }
        String uri = data.toString();
        if (!uri.startsWith("https://") || (indexOf = uri.indexOf("/", 8)) < 0) {
            return false;
        }
        String substring = uri.substring(indexOf);
        if (!substring.startsWith("/dl?")) {
            return false;
        }
        if (substring.startsWith("/dl?dbCursorWindowSizeOverride=")) {
            try {
                e(Integer.parseInt(substring.split("=")[1]));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }

    public void d() {
        this.f2480b = null;
    }
}
