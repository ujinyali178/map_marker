package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.s;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
class p0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f517a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f518b = new Object();

    static Bundle a(s.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat d3 = aVar.d();
        bundle.putInt("icon", d3 != null ? d3.j() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(e1 e1Var) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", e1Var.i());
        bundle.putCharSequence("label", e1Var.h());
        bundle.putCharSequenceArray("choices", e1Var.e());
        bundle.putBoolean("allowFreeFormInput", e1Var.c());
        bundle.putBundle("extras", e1Var.g());
        Set<String> d3 = e1Var.d();
        if (d3 != null && !d3.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d3.size());
            Iterator<String> it = d3.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] c(e1[] e1VarArr) {
        if (e1VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[e1VarArr.length];
        for (int i3 = 0; i3 < e1VarArr.length; i3++) {
            bundleArr[i3] = b(e1VarArr[i3]);
        }
        return bundleArr;
    }
}
