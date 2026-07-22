package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
final class n {
    private static boolean a(Context context, String str) {
        try {
            return Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    static boolean b(Context context) {
        return (Build.VERSION.SDK_INT >= 23) && a(context, "android.permission.CAMERA");
    }
}
