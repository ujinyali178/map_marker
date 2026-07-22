package y;

import android.content.Context;

/* loaded from: /root/release/classes.dex */
public class m {
    public n a(Context context, x.a aVar) {
        if (androidx.core.content.a.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return n.precise;
        }
        if (androidx.core.content.a.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return n.reduced;
        }
        aVar.a(x.b.permissionDenied);
        return null;
    }
}
