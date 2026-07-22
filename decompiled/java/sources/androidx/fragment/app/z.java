package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class z extends androidx.lifecycle.z {

    /* renamed from: k, reason: collision with root package name */
    private static final a0.b f1227k = new a();

    /* renamed from: g, reason: collision with root package name */
    private final boolean f1231g;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Fragment> f1228d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, z> f1229e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.d0> f1230f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f1232h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1233i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1234j = false;

    class a implements a0.b {
        a() {
        }

        @Override // androidx.lifecycle.a0.b
        public <T extends androidx.lifecycle.z> T a(Class<T> cls) {
            return new z(true);
        }

        @Override // androidx.lifecycle.a0.b
        public /* synthetic */ androidx.lifecycle.z b(Class cls, p.a aVar) {
            return androidx.lifecycle.b0.b(this, cls, aVar);
        }
    }

    z(boolean z3) {
        this.f1231g = z3;
    }

    private void i(String str) {
        z zVar = this.f1229e.get(str);
        if (zVar != null) {
            zVar.d();
            this.f1229e.remove(str);
        }
        androidx.lifecycle.d0 d0Var = this.f1230f.get(str);
        if (d0Var != null) {
            d0Var.a();
            this.f1230f.remove(str);
        }
    }

    static z l(androidx.lifecycle.d0 d0Var) {
        return (z) new androidx.lifecycle.a0(d0Var, f1227k).a(z.class);
    }

    @Override // androidx.lifecycle.z
    protected void d() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1232h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f1228d.equals(zVar.f1228d) && this.f1229e.equals(zVar.f1229e) && this.f1230f.equals(zVar.f1230f);
    }

    void f(Fragment fragment) {
        if (this.f1234j) {
            if (w.I0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f1228d.containsKey(fragment.mWho)) {
                return;
            }
            this.f1228d.put(fragment.mWho, fragment);
            if (w.I0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void g(Fragment fragment) {
        if (w.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        i(fragment.mWho);
    }

    void h(String str) {
        if (w.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        i(str);
    }

    public int hashCode() {
        return (((this.f1228d.hashCode() * 31) + this.f1229e.hashCode()) * 31) + this.f1230f.hashCode();
    }

    Fragment j(String str) {
        return this.f1228d.get(str);
    }

    z k(Fragment fragment) {
        z zVar = this.f1229e.get(fragment.mWho);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this.f1231g);
        this.f1229e.put(fragment.mWho, zVar2);
        return zVar2;
    }

    Collection<Fragment> m() {
        return new ArrayList(this.f1228d.values());
    }

    androidx.lifecycle.d0 n(Fragment fragment) {
        androidx.lifecycle.d0 d0Var = this.f1230f.get(fragment.mWho);
        if (d0Var != null) {
            return d0Var;
        }
        androidx.lifecycle.d0 d0Var2 = new androidx.lifecycle.d0();
        this.f1230f.put(fragment.mWho, d0Var2);
        return d0Var2;
    }

    boolean o() {
        return this.f1232h;
    }

    void p(Fragment fragment) {
        if (this.f1234j) {
            if (w.I0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f1228d.remove(fragment.mWho) != null) && w.I0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void q(boolean z3) {
        this.f1234j = z3;
    }

    boolean r(Fragment fragment) {
        if (this.f1228d.containsKey(fragment.mWho)) {
            return this.f1231g ? this.f1232h : !this.f1233i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1228d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1229e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1230f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
