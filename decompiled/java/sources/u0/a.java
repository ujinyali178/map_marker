package u0;

import android.util.Log;
import com.google.maps.android.BuildConfig;

/* loaded from: /root/release/classes.dex */
public final class a {
    public static final void a(Object obj) {
        String str;
        if (m0.a.f3950f.a()) {
            if (obj == null || (str = obj.toString()) == null) {
                str = BuildConfig.TRAVIS;
            }
            Log.i("flutter_image_compress", str);
        }
    }
}
