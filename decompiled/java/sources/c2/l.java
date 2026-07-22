package c2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import c2.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m1.a;

/* loaded from: /root/release/classes.dex */
public class l implements m1.a, a.b {

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f2086c;

    /* renamed from: d, reason: collision with root package name */
    private k f2087d;

    static class a implements k {
        a() {
        }

        @Override // c2.k
        public String a(List<String> list) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(list);
                objectOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // c2.k
        public List<String> b(String str) {
            try {
                return (List) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
            } catch (IOException | ClassNotFoundException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public l() {
        this(new a());
    }

    l(k kVar) {
        this.f2087d = kVar;
    }

    private Map<String, Object> j(String str, Set<String> set) {
        Map<String, ?> all = this.f2086c.getAll();
        HashMap hashMap = new HashMap();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (set == null || set.contains(str2))) {
                hashMap.put(str2, l(str2, all.get(str2)));
            }
        }
        return hashMap;
    }

    private void k(u1.d dVar, Context context) {
        this.f2086c = context.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            j.j(dVar, this);
        } catch (Exception e3) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e3);
        }
    }

    private Object l(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                return this.f2087d.b(str2.substring(40));
            }
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                return new BigInteger(str2.substring(44), 36);
            }
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                return Double.valueOf(str2.substring(40));
            }
        } else if (obj instanceof Set) {
            ArrayList arrayList = new ArrayList((Set) obj);
            this.f2086c.edit().remove(str).putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.f2087d.a(arrayList)).apply();
            return arrayList;
        }
        return obj;
    }

    @Override // c2.a.b
    public Map<String, Object> a(String str, List<String> list) {
        return j(str, list == null ? null : new HashSet(list));
    }

    @Override // m1.a
    public void b(a.b bVar) {
        k(bVar.b(), bVar.a());
    }

    @Override // c2.a.b
    public Boolean c(String str, List<String> list) {
        SharedPreferences.Editor edit = this.f2086c.edit();
        Map<String, ?> all = this.f2086c.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (list == null || list.contains(str2))) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        return Boolean.valueOf(edit.commit());
    }

    @Override // c2.a.b
    public Boolean d(String str, List<String> list) {
        return Boolean.valueOf(this.f2086c.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.f2087d.a(list)).commit());
    }

    @Override // m1.a
    public void e(a.b bVar) {
        j.j(bVar.b(), null);
    }

    @Override // c2.a.b
    public Boolean f(String str, Long l3) {
        return Boolean.valueOf(this.f2086c.edit().putLong(str, l3.longValue()).commit());
    }

    @Override // c2.a.b
    public Boolean g(String str, String str2) {
        if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
        }
        return Boolean.valueOf(this.f2086c.edit().putString(str, str2).commit());
    }

    @Override // c2.a.b
    public Boolean h(String str, Boolean bool) {
        return Boolean.valueOf(this.f2086c.edit().putBoolean(str, bool.booleanValue()).commit());
    }

    @Override // c2.a.b
    public Boolean i(String str, Double d3) {
        String d4 = Double.toString(d3.doubleValue());
        return Boolean.valueOf(this.f2086c.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d4).commit());
    }

    @Override // c2.a.b
    public Boolean remove(String str) {
        return Boolean.valueOf(this.f2086c.edit().remove(str).commit());
    }
}
