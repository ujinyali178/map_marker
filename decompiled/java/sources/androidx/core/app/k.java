package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* loaded from: /root/release/classes.dex */
public final class k {

    static class a {
        static <T> T a(Context context, Class<T> cls) {
            Object systemService;
            systemService = context.getSystemService(cls);
            return (T) systemService;
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            int noteProxyOp;
            noteProxyOp = appOpsManager.noteProxyOp(str, str2);
            return noteProxyOp;
        }

        static int c(AppOpsManager appOpsManager, String str, String str2) {
            int noteProxyOpNoThrow;
            noteProxyOpNoThrow = appOpsManager.noteProxyOpNoThrow(str, str2);
            return noteProxyOpNoThrow;
        }

        static String d(String str) {
            String permissionToOp;
            permissionToOp = AppOpsManager.permissionToOp(str);
            return permissionToOp;
        }
    }

    static class b {
        static int a(AppOpsManager appOpsManager, String str, int i3, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i3, str2);
        }

        static String b(Context context) {
            String opPackageName;
            opPackageName = context.getOpPackageName();
            return opPackageName;
        }

        static AppOpsManager c(Context context) {
            Object systemService;
            systemService = context.getSystemService((Class<Object>) AppOpsManager.class);
            return (AppOpsManager) systemService;
        }
    }

    public static int a(Context context, int i3, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return b(context, str, str2);
        }
        AppOpsManager c3 = b.c(context);
        int a4 = b.a(c3, str, Binder.getCallingUid(), str2);
        return a4 != 0 ? a4 : b.a(c3, str, i3, b.b(context));
    }

    public static int b(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.c((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static String c(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.d(str);
        }
        return null;
    }
}
