package b0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public class w {
    private static String a(Context context, String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31 && e(context, null, str)) {
            return str;
        }
        if (i3 >= 29) {
            if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
                return "android.permission.ACCESS_FINE_LOCATION";
            }
            return null;
        }
        if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        if (e(context, null, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "android.permission.ACCESS_COARSE_LOCATION";
        }
        return null;
    }

    static int b(Activity activity, String str) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        boolean l3 = l(activity, str);
        boolean z3 = true;
        boolean z4 = !f(activity, str);
        if (!l3) {
            z3 = z4;
        } else if (z4) {
            z3 = false;
        }
        if (!l3 && z3) {
            h(activity, str);
        }
        return (l3 && z3) ? 4 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0179, code lost:
    
        if (e(r7, r0, "android.permission.BODY_SENSORS") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0187, code lost:
    
        if (e(r7, r0, "android.permission.READ_MEDIA_IMAGES") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (e(r7, r0, "android.permission.SCHEDULE_EXACT_ALARM") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01fe, code lost:
    
        if (e(r7, r0, "android.permission.RECORD_AUDIO") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0256, code lost:
    
        r0.add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0254, code lost:
    
        if (e(r7, r0, "android.permission.CAMERA") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0269, code lost:
    
        if (e(r7, r0, "android.permission.READ_CALENDAR") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        if (r7 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        if (r7 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
    
        if (r7 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        if (e(r7, r0, "android.permission.SYSTEM_ALERT_WINDOW") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d1, code lost:
    
        if (e(r7, r0, "android.permission.BLUETOOTH") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0112, code lost:
    
        if (e(r7, r0, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x012b, code lost:
    
        if (r8 != false) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.util.List<java.lang.String> c(android.content.Context r7, int r8) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.w.c(android.content.Context, int):java.util.List");
    }

    private static PackageInfo d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i3 = Build.VERSION.SDK_INT;
        String packageName = context.getPackageName();
        return i3 >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096L)) : packageManager.getPackageInfo(packageName, 4096);
    }

    private static boolean e(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return true;
                    }
                }
            } catch (Exception e3) {
                Log.d("permissions_handler", "Unable to check manifest for permission: ", e3);
            }
        }
        if (context == null) {
            Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo d3 = d(context);
        if (d3 == null) {
            Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(d3.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean f(Activity activity, String str) {
        return !androidx.core.app.a.f(activity, str);
    }

    static int g(String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.READ_SMS":
            case "android.permission.RECEIVE_WAP_PUSH":
            case "android.permission.RECEIVE_MMS":
            case "android.permission.RECEIVE_SMS":
            case "android.permission.SEND_SMS":
                return 13;
            case "android.permission.READ_CALENDAR":
            case "android.permission.WRITE_CALENDAR":
                return 0;
            case "android.permission.POST_NOTIFICATIONS":
                return 17;
            case "android.permission.READ_CALL_LOG":
            case "android.permission.READ_PHONE_NUMBERS":
            case "android.permission.READ_PHONE_STATE":
            case "android.permission.CALL_PHONE":
            case "android.permission.WRITE_CALL_LOG":
            case "android.permission.USE_SIP":
            case "com.android.voicemail.permission.ADD_VOICEMAIL":
                return 8;
            case "android.permission.ACCESS_FINE_LOCATION":
            case "android.permission.ACCESS_COARSE_LOCATION":
                return 3;
            case "android.permission.MANAGE_EXTERNAL_STORAGE":
                return 22;
            case "android.permission.ACCESS_NOTIFICATION_POLICY":
                return 27;
            case "android.permission.SYSTEM_ALERT_WINDOW":
                return 23;
            case "android.permission.BODY_SENSORS":
                return 12;
            case "android.permission.NEARBY_WIFI_DEVICES":
                return 31;
            case "android.permission.BLUETOOTH_CONNECT":
                return 30;
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return 15;
            case "android.permission.READ_MEDIA_IMAGES":
                return 9;
            case "android.permission.WRITE_CONTACTS":
            case "android.permission.GET_ACCOUNTS":
            case "android.permission.READ_CONTACTS":
                return 2;
            case "android.permission.BODY_SENSORS_BACKGROUND":
                return 35;
            case "android.permission.CAMERA":
                return 1;
            case "android.permission.READ_MEDIA_AUDIO":
                return 33;
            case "android.permission.READ_MEDIA_VIDEO":
                return 32;
            case "android.permission.SCHEDULE_EXACT_ALARM":
                return 34;
            case "android.permission.BLUETOOTH_ADVERTISE":
                return 29;
            case "android.permission.REQUEST_INSTALL_PACKAGES":
                return 24;
            case "android.permission.ACTIVITY_RECOGNITION":
                return 19;
            case "android.permission.RECORD_AUDIO":
                return 7;
            case "android.permission.ACCESS_BACKGROUND_LOCATION":
                return 4;
            case "android.permission.BLUETOOTH_SCAN":
                return 28;
            case "android.permission.ACCESS_MEDIA_LOCATION":
                return 18;
            default:
                return 20;
        }
    }

    private static void h(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().putBoolean("sp_permission_handler_permission_was_denied_before", true).apply();
    }

    static Integer i(Integer num, Integer num2) {
        HashSet hashSet = new HashSet();
        hashSet.add(num);
        hashSet.add(num2);
        return j(hashSet);
    }

    static Integer j(Collection<Integer> collection) {
        if (collection.contains(4)) {
            return 4;
        }
        if (collection.contains(2)) {
            return 2;
        }
        if (collection.contains(0)) {
            return 0;
        }
        return collection.contains(3) ? 3 : 1;
    }

    static int k(Activity activity, String str, int i3) {
        if (i3 == -1) {
            return b(activity, str);
        }
        return 1;
    }

    private static boolean l(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean("sp_permission_handler_permission_was_denied_before", false);
    }
}
