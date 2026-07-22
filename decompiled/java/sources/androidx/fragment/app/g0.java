package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    static final i0 f1086a = new h0();

    /* renamed from: b, reason: collision with root package name */
    static final i0 f1087b = b();

    static void a(Fragment fragment, Fragment fragment2, boolean z3, androidx.collection.a<String, View> aVar, boolean z4) {
        if (z3) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static i0 b() {
        try {
            return (i0) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void c(androidx.collection.a<String, String> aVar, androidx.collection.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.l(size))) {
                aVar.j(size);
            }
        }
    }

    static void d(ArrayList<View> arrayList, int i3) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i3);
        }
    }
}
