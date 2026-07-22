package e1;

import android.app.ActivityManager;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import h2.n;
import h2.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class c implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final PackageManager f2483c;

    /* renamed from: d, reason: collision with root package name */
    private final ActivityManager f2484d;

    public c(PackageManager packageManager, ActivityManager activityManager) {
        k.e(packageManager, "packageManager");
        k.e(activityManager, "activityManager");
        this.f2483c = packageManager;
        this.f2484d = activityManager;
    }

    private final List<String> a() {
        FeatureInfo[] systemAvailableFeatures = this.f2483c.getSystemAvailableFeatures();
        k.d(systemAvailableFeatures, "packageManager.systemAvailableFeatures");
        ArrayList arrayList = new ArrayList();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (!(featureInfo.name == null)) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.i(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FeatureInfo) it.next()).name);
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001d, code lost:
    
        if (r0 == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean b() {
        /*
            r6 = this;
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "BRAND"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "generic"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = v2.d.o(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L1f
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r5 = "DEVICE"
            kotlin.jvm.internal.k.d(r0, r5)
            boolean r0 = v2.d.o(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
        L1f:
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r5 = "FINGERPRINT"
            kotlin.jvm.internal.k.d(r0, r5)
            boolean r1 = v2.d.o(r0, r1, r2, r3, r4)
            if (r1 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r5)
            java.lang.String r1 = "unknown"
            boolean r0 = v2.d.o(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "HARDWARE"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "goldfish"
            boolean r5 = v2.d.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "ranchu"
            boolean r0 = v2.d.r(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "MODEL"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "google_sdk"
            boolean r5 = v2.d.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "Emulator"
            boolean r5 = v2.d.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "Android SDK built for x86"
            boolean r0 = v2.d.r(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "Genymotion"
            boolean r0 = v2.d.r(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.PRODUCT
            java.lang.String r1 = "PRODUCT"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "sdk"
            boolean r5 = v2.d.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "vbox86p"
            boolean r5 = v2.d.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r5 = "emulator"
            boolean r5 = v2.d.r(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "simulator"
            boolean r0 = v2.d.r(r0, r1, r2, r3, r4)
            if (r0 == 0) goto Lb6
        Lb5:
            r2 = 1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.c.b():boolean");
    }

    @Override // u1.l.c
    public void n(u1.k call, l.d result) {
        List f3;
        List f4;
        List f5;
        String str;
        String str2;
        k.e(call, "call");
        k.e(result, "result");
        if (!call.f4372a.equals("getDeviceInfo")) {
            result.c();
            return;
        }
        HashMap hashMap = new HashMap();
        String BOARD = Build.BOARD;
        k.d(BOARD, "BOARD");
        hashMap.put("board", BOARD);
        String BOOTLOADER = Build.BOOTLOADER;
        k.d(BOOTLOADER, "BOOTLOADER");
        hashMap.put("bootloader", BOOTLOADER);
        String BRAND = Build.BRAND;
        k.d(BRAND, "BRAND");
        hashMap.put("brand", BRAND);
        String DEVICE = Build.DEVICE;
        k.d(DEVICE, "DEVICE");
        hashMap.put("device", DEVICE);
        String DISPLAY = Build.DISPLAY;
        k.d(DISPLAY, "DISPLAY");
        hashMap.put("display", DISPLAY);
        String FINGERPRINT = Build.FINGERPRINT;
        k.d(FINGERPRINT, "FINGERPRINT");
        hashMap.put("fingerprint", FINGERPRINT);
        String HARDWARE = Build.HARDWARE;
        k.d(HARDWARE, "HARDWARE");
        hashMap.put("hardware", HARDWARE);
        String HOST = Build.HOST;
        k.d(HOST, "HOST");
        hashMap.put("host", HOST);
        String ID = Build.ID;
        k.d(ID, "ID");
        hashMap.put("id", ID);
        String MANUFACTURER = Build.MANUFACTURER;
        k.d(MANUFACTURER, "MANUFACTURER");
        hashMap.put("manufacturer", MANUFACTURER);
        String MODEL = Build.MODEL;
        k.d(MODEL, "MODEL");
        hashMap.put("model", MODEL);
        String PRODUCT = Build.PRODUCT;
        k.d(PRODUCT, "PRODUCT");
        hashMap.put("product", PRODUCT);
        int i3 = Build.VERSION.SDK_INT;
        String[] SUPPORTED_32_BIT_ABIS = Build.SUPPORTED_32_BIT_ABIS;
        k.d(SUPPORTED_32_BIT_ABIS, "SUPPORTED_32_BIT_ABIS");
        f3 = n.f(Arrays.copyOf(SUPPORTED_32_BIT_ABIS, SUPPORTED_32_BIT_ABIS.length));
        hashMap.put("supported32BitAbis", f3);
        String[] SUPPORTED_64_BIT_ABIS = Build.SUPPORTED_64_BIT_ABIS;
        k.d(SUPPORTED_64_BIT_ABIS, "SUPPORTED_64_BIT_ABIS");
        f4 = n.f(Arrays.copyOf(SUPPORTED_64_BIT_ABIS, SUPPORTED_64_BIT_ABIS.length));
        hashMap.put("supported64BitAbis", f4);
        String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
        k.d(SUPPORTED_ABIS, "SUPPORTED_ABIS");
        f5 = n.f(Arrays.copyOf(SUPPORTED_ABIS, SUPPORTED_ABIS.length));
        hashMap.put("supportedAbis", f5);
        String TAGS = Build.TAGS;
        k.d(TAGS, "TAGS");
        hashMap.put("tags", TAGS);
        String TYPE = Build.TYPE;
        k.d(TYPE, "TYPE");
        hashMap.put("type", TYPE);
        hashMap.put("isPhysicalDevice", Boolean.valueOf(!b()));
        hashMap.put("systemFeatures", a());
        HashMap hashMap2 = new HashMap();
        if (i3 >= 23) {
            String BASE_OS = Build.VERSION.BASE_OS;
            k.d(BASE_OS, "BASE_OS");
            hashMap2.put("baseOS", BASE_OS);
            hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
            String SECURITY_PATCH = Build.VERSION.SECURITY_PATCH;
            k.d(SECURITY_PATCH, "SECURITY_PATCH");
            hashMap2.put("securityPatch", SECURITY_PATCH);
        }
        String CODENAME = Build.VERSION.CODENAME;
        k.d(CODENAME, "CODENAME");
        hashMap2.put("codename", CODENAME);
        String INCREMENTAL = Build.VERSION.INCREMENTAL;
        k.d(INCREMENTAL, "INCREMENTAL");
        hashMap2.put("incremental", INCREMENTAL);
        String RELEASE = Build.VERSION.RELEASE;
        k.d(RELEASE, "RELEASE");
        hashMap2.put("release", RELEASE);
        hashMap2.put("sdkInt", Integer.valueOf(i3));
        hashMap.put("version", hashMap2);
        hashMap.put("isLowRamDevice", Boolean.valueOf(this.f2484d.isLowRamDevice()));
        if (i3 >= 26) {
            try {
                str = Build.getSerial();
            } catch (SecurityException unused) {
                str = "unknown";
            }
            str2 = "try {\n                  …UNKNOWN\n                }";
        } else {
            str = Build.SERIAL;
            str2 = "SERIAL";
        }
        k.d(str, str2);
        hashMap.put("serialNumber", str);
        result.a(hashMap);
    }
}
