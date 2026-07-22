package c1;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import u1.d;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class c implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final b f2074c;

    /* renamed from: d, reason: collision with root package name */
    private l f2075d;

    c(b bVar) {
        this.f2074c = bVar;
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "action_location_source_settings":
                return "android.settings.LOCATION_SOURCE_SETTINGS";
            case "action_application_details_settings":
                return "android.settings.APPLICATION_DETAILS_SETTINGS";
            case "settings":
                return "android.settings.SETTINGS";
            case "action_view":
                return "android.intent.action.VIEW";
            case "action_voice":
                return "android.intent.action.VOICE_COMMAND";
            default:
                return str;
        }
    }

    private static Bundle b(Map<String, ?> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (e(obj, Integer.class)) {
                bundle.putIntegerArrayList(str, (ArrayList) obj);
            } else if (e(obj, String.class)) {
                bundle.putStringArrayList(str, (ArrayList) obj);
            } else {
                if (!d(obj)) {
                    throw new UnsupportedOperationException("Unsupported type " + obj);
                }
                bundle.putBundle(str, b((Map) obj));
            }
        }
        return bundle;
    }

    private static Bundle c(Map<String, ?> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            int i3 = 0;
            if (e(obj, Boolean.class)) {
                ArrayList arrayList = (ArrayList) obj;
                boolean[] zArr = new boolean[arrayList.size()];
                while (i3 < arrayList.size()) {
                    zArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue();
                    i3++;
                }
                bundle.putBooleanArray(str, zArr);
            } else if (e(obj, Integer.class)) {
                ArrayList arrayList2 = (ArrayList) obj;
                int[] iArr = new int[arrayList2.size()];
                while (i3 < arrayList2.size()) {
                    iArr[i3] = ((Integer) arrayList2.get(i3)).intValue();
                    i3++;
                }
                bundle.putIntArray(str, iArr);
            } else if (e(obj, Long.class)) {
                ArrayList arrayList3 = (ArrayList) obj;
                long[] jArr = new long[arrayList3.size()];
                while (i3 < arrayList3.size()) {
                    jArr[i3] = ((Long) arrayList3.get(i3)).longValue();
                    i3++;
                }
                bundle.putLongArray(str, jArr);
            } else if (e(obj, Double.class)) {
                ArrayList arrayList4 = (ArrayList) obj;
                double[] dArr = new double[arrayList4.size()];
                while (i3 < arrayList4.size()) {
                    dArr[i3] = ((Double) arrayList4.get(i3)).doubleValue();
                    i3++;
                }
                bundle.putDoubleArray(str, dArr);
            } else {
                if (!e(obj, String.class)) {
                    throw new UnsupportedOperationException("Unsupported type " + obj);
                }
                ArrayList arrayList5 = (ArrayList) obj;
                bundle.putStringArray(str, (String[]) arrayList5.toArray(new String[arrayList5.size()]));
            }
        }
        return bundle;
    }

    private static boolean d(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        for (Object obj2 : ((Map) obj).keySet()) {
            if (obj2 != null && !(obj2 instanceof String)) {
                return false;
            }
        }
        return true;
    }

    private static boolean e(Object obj, Class<?> cls) {
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        Iterator it = ((ArrayList) obj).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null && !cls.isInstance(next)) {
                return false;
            }
        }
        return true;
    }

    void f(d dVar) {
        if (this.f2075d != null) {
            Log.wtf("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            g();
        }
        l lVar = new l(dVar, "dev.fluttercommunity.plus/android_intent");
        this.f2075d = lVar;
        lVar.e(this);
    }

    void g() {
        l lVar = this.f2075d;
        if (lVar == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no methodChannel had been initialized.");
        } else {
            lVar.e(null);
            this.f2075d = null;
        }
    }

    @Override // u1.l.c
    public void n(k kVar, l.d dVar) {
        String a4 = a((String) kVar.a("action"));
        Integer num = (Integer) kVar.a("flags");
        String str = (String) kVar.a("category");
        Uri parse = kVar.a("data") != null ? Uri.parse((String) kVar.a("data")) : null;
        Bundle b4 = b((Map) kVar.a("arguments"));
        b4.putAll(c((Map) kVar.a("arrayArguments")));
        String str2 = (String) kVar.a("package");
        Intent a5 = this.f2074c.a(a4, num, str, parse, b4, str2, (TextUtils.isEmpty(str2) || TextUtils.isEmpty((String) kVar.a("componentName"))) ? null : new ComponentName(str2, (String) kVar.a("componentName")), (String) kVar.a("type"));
        if ("launch".equalsIgnoreCase(kVar.f4372a)) {
            if (a5 != null && !this.f2074c.b(a5)) {
                Log.i("MethodCallHandlerImpl", "Cannot resolve explicit intent, falling back to implicit");
                a5.setPackage(null);
            }
            this.f2074c.d(a5);
        } else if ("launchChooser".equalsIgnoreCase(kVar.f4372a)) {
            this.f2074c.c(a5, (String) kVar.a("chooserTitle"));
        } else {
            if (!"sendBroadcast".equalsIgnoreCase(kVar.f4372a)) {
                if ("canResolveActivity".equalsIgnoreCase(kVar.f4372a)) {
                    dVar.a(Boolean.valueOf(this.f2074c.b(a5)));
                    return;
                } else {
                    dVar.c();
                    return;
                }
            }
            this.f2074c.e(a5);
        }
        dVar.a(null);
    }
}
