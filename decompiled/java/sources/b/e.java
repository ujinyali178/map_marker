package b;

import android.content.Context;
import android.content.Intent;
import b.a;
import g2.j;
import g2.n;
import h2.d0;
import h2.e0;
import h2.v;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class e extends b.a<String[], Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1525a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Intent a(String[] input) {
            k.e(input, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            k.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    @Override // b.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        k.e(context, "context");
        k.e(input, "input");
        return f1525a.a(input);
    }

    @Override // b.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0038a<Map<String, Boolean>> b(Context context, String[] input) {
        int a4;
        int a5;
        Map d3;
        k.e(context, "context");
        k.e(input, "input");
        boolean z3 = true;
        if (input.length == 0) {
            d3 = e0.d();
            return new a.C0038a<>(d3);
        }
        int length = input.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (!(androidx.core.content.a.checkSelfPermission(context, input[i3]) == 0)) {
                z3 = false;
                break;
            }
            i3++;
        }
        if (!z3) {
            return null;
        }
        a4 = d0.a(input.length);
        a5 = s2.f.a(a4, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a5);
        for (String str : input) {
            j a6 = n.a(str, Boolean.TRUE);
            linkedHashMap.put(a6.c(), a6.d());
        }
        return new a.C0038a<>(linkedHashMap);
    }

    @Override // b.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int i3, Intent intent) {
        Map<String, Boolean> d3;
        List i4;
        List A;
        Map<String, Boolean> g3;
        Map<String, Boolean> d4;
        Map<String, Boolean> d5;
        if (i3 != -1) {
            d5 = e0.d();
            return d5;
        }
        if (intent == null) {
            d4 = e0.d();
            return d4;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            d3 = e0.d();
            return d3;
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i5 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i5 == 0));
        }
        i4 = h2.j.i(stringArrayExtra);
        A = v.A(i4, arrayList);
        g3 = e0.g(A);
        return g3;
    }
}
