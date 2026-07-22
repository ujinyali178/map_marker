package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj;

    /* JADX WARN: Can't wrap try/catch for region: R(27:0|1|2|3|4|(22:54|55|7|8|9|10|11|12|13|(13:46|47|16|(10:41|42|19|(7:36|37|22|(6:28|29|30|31|25|26)|24|25|26)|21|22|(0)|24|25|26)|18|19|(0)|21|22|(0)|24|25|26)|15|16|(0)|18|19|(0)|21|22|(0)|24|25|26)|6|7|8|9|10|11|12|13|(0)|15|16|(0)|18|19|(0)|21|22|(0)|24|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0054, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0042, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            int r2 = android.os.Process.myUid()
            com.google.android.gms.common.util.WorkSourceUtil.zza = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L1a
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L1a
            r6[r3] = r7     // Catch: java.lang.Exception -> L1a
            java.lang.reflect.Method r5 = r5.getMethod(r1, r6)     // Catch: java.lang.Exception -> L1a
            goto L1c
        L1a:
            r5 = r4
        L1c:
            com.google.android.gms.common.util.WorkSourceUtil.zzb = r5
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r6 = 2
            if (r5 == 0) goto L34
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L34
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L34
            r7[r3] = r8     // Catch: java.lang.Exception -> L34
            r7[r2] = r0     // Catch: java.lang.Exception -> L34
            java.lang.reflect.Method r1 = r5.getMethod(r1, r7)     // Catch: java.lang.Exception -> L34
            goto L35
        L34:
            r1 = r4
        L35:
            com.google.android.gms.common.util.WorkSourceUtil.zzc = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L42
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch: java.lang.Exception -> L42
            goto L43
        L42:
            r1 = r4
        L43:
            com.google.android.gms.common.util.WorkSourceUtil.zzd = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "get"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L54
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L54
            r7[r3] = r8     // Catch: java.lang.Exception -> L54
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch: java.lang.Exception -> L54
            goto L56
        L54:
            r1 = r4
        L56:
            com.google.android.gms.common.util.WorkSourceUtil.zze = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r1 == 0) goto L6e
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "getName"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L6d
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L6d
            r7[r3] = r8     // Catch: java.lang.Exception -> L6d
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch: java.lang.Exception -> L6d
            goto L6f
        L6d:
        L6e:
            r1 = r4
        L6f:
            com.google.android.gms.common.util.WorkSourceUtil.zzf = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r5 = "WorkSourceUtil"
            if (r1 == 0) goto L8a
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r7 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L84
            java.lang.reflect.Method r1 = r1.getMethod(r7, r8)     // Catch: java.lang.Exception -> L84
            goto L8b
        L84:
            r1 = move-exception
            java.lang.String r7 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r7, r1)
        L8a:
            r1 = r4
        L8b:
            com.google.android.gms.common.util.WorkSourceUtil.zzg = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto Lae
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> La8
            java.lang.String r7 = "addNode"
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> La8
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> La8
            r6[r3] = r8     // Catch: java.lang.Exception -> La8
            r6[r2] = r0     // Catch: java.lang.Exception -> La8
            java.lang.reflect.Method r0 = r1.getMethod(r7, r6)     // Catch: java.lang.Exception -> La8
            goto Laf
        La8:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r5, r1, r0)
        Lae:
            r0 = r4
        Laf:
            com.google.android.gms.common.util.WorkSourceUtil.zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto Lc5
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> Lc5
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch: java.lang.Exception -> Lc5
            r0.setAccessible(r2)     // Catch: java.lang.Exception -> Lc6
            goto Lc6
        Lc5:
            r0 = r4
        Lc6:
            com.google.android.gms.common.util.WorkSourceUtil.zzi = r0
            com.google.android.gms.common.util.WorkSourceUtil.zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int i3, String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i3), str);
                return;
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                return;
            }
        }
        Method method2 = zzb;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i3));
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
            }
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        String str2;
        ApplicationInfo applicationInfo;
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "Could not find package: ";
        }
        if (applicationInfo == null) {
            str2 = "Could not get applicationInfo from package: ";
            Log.e("WorkSourceUtil", str2.concat(str));
            return null;
        }
        int i3 = applicationInfo.uid;
        WorkSource workSource = new WorkSource();
        add(workSource, i3, str);
        return workSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.WorkSource fromPackageAndModuleExperimentalPi(android.content.Context r9, java.lang.String r10, java.lang.String r11) {
        /*
            r0 = 0
            java.lang.String r1 = "WorkSourceUtil"
            if (r9 == 0) goto L6e
            android.content.pm.PackageManager r2 = r9.getPackageManager()
            if (r2 == 0) goto L6e
            if (r11 == 0) goto L6e
            if (r10 != 0) goto L10
            goto L6e
        L10:
            r2 = -1
            r3 = 0
            com.google.android.gms.common.wrappers.PackageManagerWrapper r9 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L22
            android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo(r10, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L22
            if (r9 != 0) goto L1f
            java.lang.String r9 = "Could not get applicationInfo from package: "
            goto L24
        L1f:
            int r2 = r9.uid
            goto L2b
        L22:
            java.lang.String r9 = "Could not find package: "
        L24:
            java.lang.String r9 = r9.concat(r10)
            android.util.Log.e(r1, r9)
        L2b:
            if (r2 >= 0) goto L2e
            return r0
        L2e:
            android.os.WorkSource r9 = new android.os.WorkSource
            r9.<init>()
            java.lang.reflect.Method r0 = com.google.android.gms.common.util.WorkSourceUtil.zzg
            if (r0 == 0) goto L6a
            java.lang.reflect.Method r4 = com.google.android.gms.common.util.WorkSourceUtil.zzh
            if (r4 != 0) goto L3c
            goto L6a
        L3c:
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L63
            java.lang.Object r0 = r0.invoke(r9, r5)     // Catch: java.lang.Exception -> L63
            int r5 = com.google.android.gms.common.util.WorkSourceUtil.zza     // Catch: java.lang.Exception -> L63
            r6 = 1
            r7 = 2
            if (r2 == r5) goto L55
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L63
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L63
            r8[r3] = r2     // Catch: java.lang.Exception -> L63
            r8[r6] = r10     // Catch: java.lang.Exception -> L63
            r4.invoke(r0, r8)     // Catch: java.lang.Exception -> L63
        L55:
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L63
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L63
            r10[r3] = r2     // Catch: java.lang.Exception -> L63
            r10[r6] = r11     // Catch: java.lang.Exception -> L63
            r4.invoke(r0, r10)     // Catch: java.lang.Exception -> L63
            goto L6d
        L63:
            r10 = move-exception
            java.lang.String r11 = "Unable to assign chained blame through WorkSource"
            android.util.Log.w(r1, r11, r10)
            goto L6d
        L6a:
            add(r9, r2, r10)
        L6d:
            return r9
        L6e:
            java.lang.String r9 = "Unexpected null arguments"
            android.util.Log.w(r1, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.fromPackageAndModuleExperimentalPi(android.content.Context, java.lang.String, java.lang.String):android.os.WorkSource");
    }

    public static int get(WorkSource workSource, int i3) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, Integer.valueOf(i3));
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
        return 0;
    }

    public static String getName(WorkSource workSource, int i3) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i3));
        } catch (Exception e3) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            return null;
        }
    }

    public static List<String> getNames(WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int size = workSource == null ? 0 : size(workSource);
        if (size != 0) {
            for (int i3 = 0; i3 < size; i3++) {
                String name = getName(workSource, i3);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public static synchronized boolean hasWorkSourcePermission(Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                return false;
            }
            Boolean valueOf = Boolean.valueOf(androidx.core.content.a.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0);
            zzj = valueOf;
            return valueOf.booleanValue();
        }
    }

    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e3) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e3);
            }
        }
        return size(workSource) == 0;
    }

    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
        return 0;
    }
}
