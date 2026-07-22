package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback$OnSharedElementsReadyListener;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: /root/release/classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: a, reason: collision with root package name */
    private static h f491a;

    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    class RunnableC0009a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f492c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f493d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f494f;

        RunnableC0009a(String[] strArr, Activity activity, int i3) {
            this.f492c = strArr;
            this.f493d = activity;
            this.f494f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f492c.length];
            PackageManager packageManager = this.f493d.getPackageManager();
            String packageName = this.f493d.getPackageName();
            int length = this.f492c.length;
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = packageManager.checkPermission(this.f492c[i3], packageName);
            }
            ((g) this.f493d).onRequestPermissionsResult(this.f494f, this.f492c, iArr);
        }
    }

    static class b {
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        static void b(Activity activity, Intent intent, int i3, Bundle bundle) {
            activity.startActivityForResult(intent, i3, bundle);
        }

        static void c(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
            activity.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
        }
    }

    static class c {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class d {
        static void a(Object obj) {
            ((SharedElementCallback$OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i3) {
            activity.requestPermissions(strArr, i3);
        }

        static boolean c(Activity activity, String str) {
            boolean shouldShowRequestPermissionRationale;
            shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
            return shouldShowRequestPermissionRationale;
        }
    }

    static class e {
        static boolean a(Activity activity) {
            boolean isLaunchedFromBubble;
            isLaunchedFromBubble = activity.isLaunchedFromBubble();
            return isLaunchedFromBubble;
        }

        static boolean b(Activity activity, String str) {
            boolean shouldShowRequestPermissionRationale;
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
                return shouldShowRequestPermissionRationale;
            }
        }
    }

    static class f {
        static boolean a(Activity activity, String str) {
            boolean shouldShowRequestPermissionRationale;
            shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
            return shouldShowRequestPermissionRationale;
        }
    }

    public interface g {
        void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);
    }

    public interface h {
        boolean a(Activity activity, String[] strArr, int i3);
    }

    public interface i {
        void validateRequestPermissionsRequestCode(int i3);
    }

    public static void a(Activity activity) {
        c.a(activity);
    }

    public static void b(Activity activity) {
        c.b(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Activity activity, String[] strArr, int i3) {
        h hVar = f491a;
        if (hVar == null || !hVar.a(activity, strArr, i3)) {
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (TextUtils.isEmpty(strArr[i4])) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i4], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i4));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (!hashSet.contains(Integer.valueOf(i6))) {
                        strArr2[i5] = strArr[i6];
                        i5++;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof i) {
                    ((i) activity).validateRequestPermissionsRequestCode(i3);
                }
                d.b(activity, strArr, i3);
            } else if (activity instanceof g) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0009a(strArr2, activity, i3));
            }
        }
    }

    public static void d(Activity activity, l1 l1Var) {
        c.c(activity, null);
    }

    public static void e(Activity activity, l1 l1Var) {
        c.d(activity, null);
    }

    public static boolean f(Activity activity, String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i3 >= 32) {
            return f.a(activity, str);
        }
        if (i3 == 31) {
            return e.b(activity, str);
        }
        if (i3 >= 23) {
            return d.c(activity, str);
        }
        return false;
    }

    public static void g(Activity activity, Intent intent, int i3, Bundle bundle) {
        b.b(activity, intent, i3, bundle);
    }

    public static void h(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        b.c(activity, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public static void i(Activity activity) {
        c.e(activity);
    }
}
