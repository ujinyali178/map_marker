package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.maps.android.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f1052a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, d0> f1053b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, c0> f1054c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private z f1055d;

    e0() {
    }

    void A(z zVar) {
        this.f1055d = zVar;
    }

    c0 B(String str, c0 c0Var) {
        return c0Var != null ? this.f1054c.put(str, c0Var) : this.f1054c.remove(str);
    }

    void a(Fragment fragment) {
        if (this.f1052a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f1052a) {
            this.f1052a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f1053b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f1053b.get(str) != null;
    }

    void d(int i3) {
        for (d0 d0Var : this.f1053b.values()) {
            if (d0Var != null) {
                d0Var.t(i3);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f1053b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (d0 d0Var : this.f1053b.values()) {
                printWriter.print(str);
                if (d0Var != null) {
                    Fragment k3 = d0Var.k();
                    printWriter.println(k3);
                    k3.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(BuildConfig.TRAVIS);
                }
            }
        }
        int size = this.f1052a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.f1052a.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        d0 d0Var = this.f1053b.get(str);
        if (d0Var != null) {
            return d0Var.k();
        }
        return null;
    }

    Fragment g(int i3) {
        for (int size = this.f1052a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1052a.get(size);
            if (fragment != null && fragment.mFragmentId == i3) {
                return fragment;
            }
        }
        for (d0 d0Var : this.f1053b.values()) {
            if (d0Var != null) {
                Fragment k3 = d0Var.k();
                if (k3.mFragmentId == i3) {
                    return k3;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.f1052a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1052a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (d0 d0Var : this.f1053b.values()) {
            if (d0Var != null) {
                Fragment k3 = d0Var.k();
                if (str.equals(k3.mTag)) {
                    return k3;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment findFragmentByWho;
        for (d0 d0Var : this.f1053b.values()) {
            if (d0Var != null && (findFragmentByWho = d0Var.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f1052a.indexOf(fragment);
        for (int i3 = indexOf - 1; i3 >= 0; i3--) {
            Fragment fragment2 = this.f1052a.get(i3);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f1052a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f1052a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List<d0> k() {
        ArrayList arrayList = new ArrayList();
        for (d0 d0Var : this.f1053b.values()) {
            if (d0Var != null) {
                arrayList.add(d0Var);
            }
        }
        return arrayList;
    }

    List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<d0> it = this.f1053b.values().iterator();
        while (it.hasNext()) {
            d0 next = it.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    ArrayList<c0> m() {
        return new ArrayList<>(this.f1054c.values());
    }

    d0 n(String str) {
        return this.f1053b.get(str);
    }

    List<Fragment> o() {
        ArrayList arrayList;
        if (this.f1052a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1052a) {
            arrayList = new ArrayList(this.f1052a);
        }
        return arrayList;
    }

    z p() {
        return this.f1055d;
    }

    c0 q(String str) {
        return this.f1054c.get(str);
    }

    void r(d0 d0Var) {
        Fragment k3 = d0Var.k();
        if (c(k3.mWho)) {
            return;
        }
        this.f1053b.put(k3.mWho, d0Var);
        if (k3.mRetainInstanceChangedWhileDetached) {
            if (k3.mRetainInstance) {
                this.f1055d.f(k3);
            } else {
                this.f1055d.p(k3);
            }
            k3.mRetainInstanceChangedWhileDetached = false;
        }
        if (w.I0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k3);
        }
    }

    void s(d0 d0Var) {
        Fragment k3 = d0Var.k();
        if (k3.mRetainInstance) {
            this.f1055d.p(k3);
        }
        if (this.f1053b.put(k3.mWho, null) != null && w.I0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k3);
        }
    }

    void t() {
        Iterator<Fragment> it = this.f1052a.iterator();
        while (it.hasNext()) {
            d0 d0Var = this.f1053b.get(it.next().mWho);
            if (d0Var != null) {
                d0Var.m();
            }
        }
        for (d0 d0Var2 : this.f1053b.values()) {
            if (d0Var2 != null) {
                d0Var2.m();
                Fragment k3 = d0Var2.k();
                if (k3.mRemoving && !k3.isInBackStack()) {
                    if (k3.mBeingSaved && !this.f1054c.containsKey(k3.mWho)) {
                        d0Var2.r();
                    }
                    s(d0Var2);
                }
            }
        }
    }

    void u(Fragment fragment) {
        synchronized (this.f1052a) {
            this.f1052a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void v() {
        this.f1053b.clear();
    }

    void w(List<String> list) {
        this.f1052a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f3 = f(str);
                if (f3 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (w.I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f3);
                }
                a(f3);
            }
        }
    }

    void x(ArrayList<c0> arrayList) {
        this.f1054c.clear();
        Iterator<c0> it = arrayList.iterator();
        while (it.hasNext()) {
            c0 next = it.next();
            this.f1054c.put(next.f980d, next);
        }
    }

    ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f1053b.size());
        for (d0 d0Var : this.f1053b.values()) {
            if (d0Var != null) {
                Fragment k3 = d0Var.k();
                d0Var.r();
                arrayList.add(k3.mWho);
                if (w.I0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k3 + ": " + k3.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> z() {
        synchronized (this.f1052a) {
            if (this.f1052a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f1052a.size());
            Iterator<Fragment> it = this.f1052a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (w.I0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }
}
