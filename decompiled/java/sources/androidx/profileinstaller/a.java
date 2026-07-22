package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: /root/release/classes.dex */
class a {

    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    private static class C0033a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class b {
        static File a(Context context) {
            Context createDeviceProtectedStorageContext;
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            return createDeviceProtectedStorageContext.getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z3 = true;
        for (File file2 : listFiles) {
            z3 = a(file2) && z3;
        }
        return z3;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        int i3 = Build.VERSION.SDK_INT;
        aVar.b(a(i3 >= 24 ? b.a(context) : i3 >= 23 ? C0033a.a(context) : context.getCacheDir()) ? 14 : 15, null);
    }
}
