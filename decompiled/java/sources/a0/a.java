package a0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.common.primitives.Ints;

/* loaded from: /root/release/classes.dex */
public class a {
    public static boolean a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            intent.addFlags(Ints.MAX_POWER_OF_TWO);
            intent.addFlags(8388608);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.addFlags(Ints.MAX_POWER_OF_TWO);
            intent.addFlags(8388608);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
