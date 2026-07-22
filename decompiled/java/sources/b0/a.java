package b0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.common.primitives.Ints;

/* loaded from: /root/release/classes.dex */
final class a {

    @FunctionalInterface
    /* renamed from: b0.a$a, reason: collision with other inner class name */
    interface InterfaceC0040a {
        void a(boolean z3);
    }

    a() {
    }

    void a(Context context, InterfaceC0040a interfaceC0040a, b bVar) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            bVar.a("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            intent.addFlags(Ints.MAX_POWER_OF_TWO);
            intent.addFlags(8388608);
            context.startActivity(intent);
            interfaceC0040a.a(true);
        } catch (Exception unused) {
            interfaceC0040a.a(false);
        }
    }
}
