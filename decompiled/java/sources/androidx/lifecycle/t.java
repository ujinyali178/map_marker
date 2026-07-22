package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public final class t {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1317f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Class<? extends Object>[] f1318g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f1319a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, a.c> f1320b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f1321c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, z2.f<Object>> f1322d;

    /* renamed from: e, reason: collision with root package name */
    private final a.c f1323e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final t a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new t();
                }
                HashMap hashMap = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.k.d(key, "key");
                    hashMap.put(key, bundle2.get(key));
                }
                return new t(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (!((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true)) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = parcelableArrayList.get(i3);
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i3));
            }
            return new t(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : t.f1318g) {
                kotlin.jvm.internal.k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public t() {
        this.f1319a = new LinkedHashMap();
        this.f1320b = new LinkedHashMap();
        this.f1321c = new LinkedHashMap();
        this.f1322d = new LinkedHashMap();
        this.f1323e = new a.c() { // from class: androidx.lifecycle.s
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                Bundle d3;
                d3 = t.d(t.this);
                return d3;
            }
        };
    }

    public t(Map<String, ? extends Object> initialState) {
        kotlin.jvm.internal.k.e(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1319a = linkedHashMap;
        this.f1320b = new LinkedHashMap();
        this.f1321c = new LinkedHashMap();
        this.f1322d = new LinkedHashMap();
        this.f1323e = new a.c() { // from class: androidx.lifecycle.s
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                Bundle d3;
                d3 = t.d(t.this);
                return d3;
            }
        };
        linkedHashMap.putAll(initialState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(t this$0) {
        Map i3;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        i3 = h2.e0.i(this$0.f1320b);
        for (Map.Entry entry : i3.entrySet()) {
            this$0.e((String) entry.getKey(), ((a.c) entry.getValue()).a());
        }
        Set<String> keySet = this$0.f1319a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f1319a.get(str));
        }
        return androidx.core.os.e.a(g2.n.a("keys", arrayList), g2.n.a("values", arrayList2));
    }

    public final a.c c() {
        return this.f1323e;
    }

    public final <T> void e(String key, T t3) {
        kotlin.jvm.internal.k.e(key, "key");
        if (!f1317f.b(t3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            kotlin.jvm.internal.k.b(t3);
            sb.append(t3.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj = this.f1321c.get(key);
        n nVar = obj instanceof n ? (n) obj : null;
        if (nVar != null) {
            nVar.n(t3);
        } else {
            this.f1319a.put(key, t3);
        }
        z2.f<Object> fVar = this.f1322d.get(key);
        if (fVar == null) {
            return;
        }
        fVar.setValue(t3);
    }
}
