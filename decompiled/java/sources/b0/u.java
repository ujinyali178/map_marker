package b0;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u1.n;

/* loaded from: /root/release/classes.dex */
final class u implements n.a, n.d {

    /* renamed from: c, reason: collision with root package name */
    private final Context f1546c;

    /* renamed from: d, reason: collision with root package name */
    private b f1547d;

    /* renamed from: f, reason: collision with root package name */
    private Activity f1548f;

    /* renamed from: g, reason: collision with root package name */
    private int f1549g;

    /* renamed from: h, reason: collision with root package name */
    private Map<Integer, Integer> f1550h;

    @FunctionalInterface
    interface a {
        void a(int i3);
    }

    @FunctionalInterface
    interface b {
        void a(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    interface c {
        void a(boolean z3);
    }

    public u(Context context) {
        this.f1546c = context;
    }

    private int b() {
        List<String> c3 = w.c(this.f1546c, 21);
        if (!(c3 == null || c3.isEmpty())) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    private int c() {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 33) {
            return s0.c(this.f1546c).a() ? 1 : 0;
        }
        checkSelfPermission = this.f1546c.checkSelfPermission("android.permission.POST_NOTIFICATIONS");
        if (checkSelfPermission == 0) {
            return 1;
        }
        return w.b(this.f1548f, "android.permission.POST_NOTIFICATIONS");
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00cc, code lost:
    
        if (r6 != false) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int e(int r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.u.e(int):int");
    }

    private boolean f() {
        List<String> c3 = w.c(this.f1546c, 37);
        boolean z3 = c3 != null && c3.contains("android.permission.WRITE_CALENDAR");
        boolean z4 = c3 != null && c3.contains("android.permission.READ_CALENDAR");
        if (z3 && z4) {
            return true;
        }
        if (!z3) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z4) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    private void g(String str, int i3) {
        if (this.f1548f == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f1548f.getPackageName()));
        }
        this.f1548f.startActivityForResult(intent, i3);
        this.f1549g++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        int i5;
        boolean canScheduleExactAlarms;
        boolean isNotificationPolicyAccessGranted;
        boolean canRequestPackageInstalls;
        boolean canDrawOverlays;
        boolean isExternalStorageManager;
        boolean isIgnoringBatteryOptimizations;
        Activity activity = this.f1548f;
        int i6 = 0;
        i6 = 0;
        if (activity == null) {
            return false;
        }
        int i7 = 23;
        if (i3 == 209) {
            if (Build.VERSION.SDK_INT >= 23) {
                String packageName = this.f1546c.getPackageName();
                PowerManager powerManager = (PowerManager) this.f1546c.getSystemService("power");
                if (powerManager != null) {
                    isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(packageName);
                    if (isIgnoringBatteryOptimizations) {
                        i6 = 1;
                    }
                }
            } else {
                i6 = 2;
            }
            i7 = 16;
            i5 = i6;
        } else if (i3 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            isExternalStorageManager = Environment.isExternalStorageManager();
            i7 = 22;
            i5 = isExternalStorageManager;
        } else if (i3 == 211) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            canDrawOverlays = Settings.canDrawOverlays(activity);
            i5 = canDrawOverlays;
        } else if (i3 == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            canRequestPackageInstalls = activity.getPackageManager().canRequestPackageInstalls();
            i7 = 24;
            i5 = canRequestPackageInstalls;
        } else if (i3 == 213) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            isNotificationPolicyAccessGranted = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
            i7 = 27;
            i5 = isNotificationPolicyAccessGranted;
        } else {
            if (i3 != 214) {
                return false;
            }
            i7 = 34;
            AlarmManager alarmManager = (AlarmManager) activity.getSystemService("alarm");
            if (Build.VERSION.SDK_INT >= 31) {
                canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
                i5 = canScheduleExactAlarms;
            } else {
                i5 = 1;
            }
        }
        this.f1550h.put(Integer.valueOf(i7), Integer.valueOf(i5));
        int i8 = this.f1549g - 1;
        this.f1549g = i8;
        b bVar = this.f1547d;
        if (bVar != null && i8 == 0) {
            bVar.a(this.f1550h);
        }
        return true;
    }

    void d(int i3, a aVar) {
        aVar.a(e(i3));
    }

    void h(List<Integer> list, b bVar, b0.b bVar2) {
        Map<Integer, Integer> map;
        int i3;
        Map<Integer, Integer> map2;
        int i4;
        int i5;
        int i6;
        String str;
        String str2;
        if (this.f1549g > 0) {
            str2 = "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).";
        } else {
            if (this.f1548f != null) {
                this.f1547d = bVar;
                this.f1550h = new HashMap();
                this.f1549g = 0;
                ArrayList arrayList = new ArrayList();
                for (Integer num : list) {
                    if (e(num.intValue()) != 1) {
                        List<String> c3 = w.c(this.f1548f, num.intValue());
                        if (c3 != null && !c3.isEmpty()) {
                            int i7 = Build.VERSION.SDK_INT;
                            if (i7 >= 23 && num.intValue() == 16) {
                                i6 = 209;
                                str = "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
                            } else if (i7 >= 30 && num.intValue() == 22) {
                                i6 = 210;
                                str = "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION";
                            } else if (i7 >= 23 && num.intValue() == 23) {
                                i6 = 211;
                                str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
                            } else if (i7 >= 26 && num.intValue() == 24) {
                                i6 = 212;
                                str = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";
                            } else if (i7 >= 23 && num.intValue() == 27) {
                                i6 = 213;
                                str = "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS";
                            } else if (i7 < 31 || num.intValue() != 34) {
                                if (num.intValue() != 37 && num.intValue() != 0) {
                                    arrayList.addAll(c3);
                                    i5 = this.f1549g + c3.size();
                                } else if (f()) {
                                    arrayList.add("android.permission.WRITE_CALENDAR");
                                    arrayList.add("android.permission.READ_CALENDAR");
                                    i5 = this.f1549g + 2;
                                } else {
                                    map = this.f1550h;
                                    i3 = 0;
                                }
                                this.f1549g = i5;
                            } else {
                                i6 = 214;
                                str = "android.settings.REQUEST_SCHEDULE_EXACT_ALARM";
                            }
                            g(str, i6);
                        } else if (!this.f1550h.containsKey(num)) {
                            if (num.intValue() != 16 || Build.VERSION.SDK_INT >= 23) {
                                map2 = this.f1550h;
                                i4 = 0;
                            } else {
                                map2 = this.f1550h;
                                i4 = 2;
                            }
                            map2.put(num, i4);
                            if (num.intValue() == 22 && Build.VERSION.SDK_INT < 30) {
                                map = this.f1550h;
                                i3 = 2;
                            }
                            map = this.f1550h;
                            i3 = 0;
                        }
                        map.put(num, i3);
                    } else if (!this.f1550h.containsKey(num)) {
                        map = this.f1550h;
                        i3 = 1;
                        map.put(num, i3);
                    }
                }
                if (arrayList.size() > 0) {
                    androidx.core.app.a.c(this.f1548f, (String[]) arrayList.toArray(new String[0]), 24);
                }
                b bVar3 = this.f1547d;
                if (bVar3 == null || this.f1549g != 0) {
                    return;
                }
                bVar3.a(this.f1550h);
                return;
            }
            Log.d("permissions_handler", "Unable to detect current Activity.");
            str2 = "Unable to detect current Android Activity.";
        }
        bVar2.a("PermissionHandler.PermissionManager", str2);
    }

    public void i(Activity activity) {
        this.f1548f = activity;
    }

    void j(int i3, c cVar, b0.b bVar) {
        Activity activity = this.f1548f;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> c3 = w.c(activity, i3);
        if (c3 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i3);
            cVar.a(false);
            return;
        }
        if (!c3.isEmpty()) {
            cVar.a(androidx.core.app.a.f(this.f1548f, c3.get(0)));
            return;
        }
        Log.d("permissions_handler", "No permissions found in manifest for: " + i3 + " no need to show request rationale");
        cVar.a(false);
    }

    @Override // u1.n.d
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        int g3;
        Map<Integer, Integer> map;
        int i4;
        Integer valueOf;
        if (i3 != 24) {
            this.f1549g = 0;
            return false;
        }
        if (this.f1550h == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
            return false;
        }
        List asList = Arrays.asList(strArr);
        int indexOf = asList.indexOf("android.permission.WRITE_CALENDAR");
        if (indexOf >= 0) {
            int k3 = w.k(this.f1548f, "android.permission.WRITE_CALENDAR", iArr[indexOf]);
            this.f1550h.put(36, Integer.valueOf(k3));
            int indexOf2 = asList.indexOf("android.permission.READ_CALENDAR");
            if (indexOf2 >= 0) {
                int intValue = w.i(Integer.valueOf(k3), Integer.valueOf(w.k(this.f1548f, "android.permission.READ_CALENDAR", iArr[indexOf2]))).intValue();
                this.f1550h.put(37, Integer.valueOf(intValue));
                this.f1550h.put(0, Integer.valueOf(intValue));
            }
        }
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String str = strArr[i5];
            if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (g3 = w.g(str)) != 20) {
                int i6 = iArr[i5];
                if (g3 == 8) {
                    valueOf = w.i(this.f1550h.get(8), Integer.valueOf(w.k(this.f1548f, str, i6)));
                    map = this.f1550h;
                    i4 = 8;
                } else if (g3 == 7) {
                    if (!this.f1550h.containsKey(7)) {
                        this.f1550h.put(7, Integer.valueOf(w.k(this.f1548f, str, i6)));
                    }
                    if (!this.f1550h.containsKey(14)) {
                        this.f1550h.put(14, Integer.valueOf(w.k(this.f1548f, str, i6)));
                    }
                } else if (g3 == 4) {
                    int k4 = w.k(this.f1548f, str, i6);
                    if (!this.f1550h.containsKey(4)) {
                        map = this.f1550h;
                        i4 = 4;
                        valueOf = Integer.valueOf(k4);
                    }
                } else if (g3 == 3) {
                    int k5 = w.k(this.f1548f, str, i6);
                    if (Build.VERSION.SDK_INT < 29 && !this.f1550h.containsKey(4)) {
                        this.f1550h.put(4, Integer.valueOf(k5));
                    }
                    if (!this.f1550h.containsKey(5)) {
                        this.f1550h.put(5, Integer.valueOf(k5));
                    }
                    this.f1550h.put(Integer.valueOf(g3), Integer.valueOf(k5));
                } else if (!this.f1550h.containsKey(Integer.valueOf(g3))) {
                    this.f1550h.put(Integer.valueOf(g3), Integer.valueOf(w.k(this.f1548f, str, i6)));
                }
                map.put(i4, valueOf);
            }
        }
        int length = this.f1549g - iArr.length;
        this.f1549g = length;
        b bVar = this.f1547d;
        if (bVar == null || length != 0) {
            return true;
        }
        bVar.a(this.f1550h);
        return true;
    }
}
