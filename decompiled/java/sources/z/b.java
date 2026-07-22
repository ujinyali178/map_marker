package z;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class b implements n.d {

    /* renamed from: c, reason: collision with root package name */
    private Activity f4718c;

    /* renamed from: d, reason: collision with root package name */
    private x.a f4719d;

    /* renamed from: f, reason: collision with root package name */
    private c f4720f;

    private static List<String> b(Context context) {
        boolean b4 = d.b(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean b5 = d.b(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (!b4 && !b5) {
            throw new x.c();
        }
        ArrayList arrayList = new ArrayList();
        if (b4) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (b5) {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        return arrayList;
    }

    private boolean c(String[] strArr, int[] iArr) {
        int e3 = e(strArr, "android.permission.ACCESS_BACKGROUND_LOCATION");
        return e3 >= 0 && iArr[e3] == 0;
    }

    private static <T> int e(T[] tArr, T t3) {
        return Arrays.asList(tArr).indexOf(t3);
    }

    public a a(Context context) {
        char c3;
        List<String> b4 = b(context);
        if (Build.VERSION.SDK_INT < 23) {
            return a.always;
        }
        Iterator<String> it = b4.iterator();
        while (true) {
            if (!it.hasNext()) {
                c3 = 65535;
                break;
            }
            if (androidx.core.content.a.checkSelfPermission(context, it.next()) == 0) {
                c3 = 0;
                break;
            }
        }
        if (c3 == 65535) {
            return a.denied;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return a.always;
        }
        if (d.b(context, "android.permission.ACCESS_BACKGROUND_LOCATION") && androidx.core.content.a.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return a.always;
        }
        return a.whileInUse;
    }

    public boolean d(Context context) {
        a a4 = a(context);
        return a4 == a.whileInUse || a4 == a.always;
    }

    public void f(Activity activity, c cVar, x.a aVar) {
        if (activity == null) {
            aVar.a(x.b.activityMissing);
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            cVar.a(a.always);
            return;
        }
        List<String> b4 = b(activity);
        if (i3 >= 29 && d.b(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") && a(activity) == a.whileInUse) {
            b4.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        this.f4719d = aVar;
        this.f4720f = cVar;
        this.f4718c = activity;
        androidx.core.app.a.c(activity, (String[]) b4.toArray(new String[0]), 109);
    }

    @Override // u1.n.d
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (i3 != 109) {
            return false;
        }
        Activity activity = this.f4718c;
        if (activity == null) {
            Log.e("Geolocator", "Trying to process permission result without an valid Activity instance");
            x.a aVar = this.f4719d;
            if (aVar != null) {
                aVar.a(x.b.activityMissing);
            }
            return false;
        }
        try {
            List<String> b4 = b(activity);
            if (iArr.length == 0) {
                Log.i("Geolocator", "The grantResults array is empty. This can happen when the user cancels the permission request");
                return false;
            }
            a aVar2 = a.denied;
            char c3 = 65535;
            boolean z3 = false;
            boolean z4 = false;
            for (String str : b4) {
                int e3 = e(strArr, str);
                if (e3 >= 0) {
                    z3 = true;
                }
                if (iArr[e3] == 0) {
                    c3 = 0;
                }
                if (androidx.core.app.a.f(this.f4718c, str)) {
                    z4 = true;
                }
            }
            if (!z3) {
                Log.w("Geolocator", "Location permissions not part of permissions send to onRequestPermissionsResult method.");
                return false;
            }
            if (c3 == 0) {
                aVar2 = (Build.VERSION.SDK_INT < 29 || c(strArr, iArr)) ? a.always : a.whileInUse;
            } else if (!z4) {
                aVar2 = a.deniedForever;
            }
            c cVar = this.f4720f;
            if (cVar != null) {
                cVar.a(aVar2);
            }
            return true;
        } catch (x.c unused) {
            x.a aVar3 = this.f4719d;
            if (aVar3 != null) {
                aVar3.a(x.b.permissionDefinitionsNotFound);
            }
            return false;
        }
    }
}
