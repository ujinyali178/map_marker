package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.f0;
import androidx.fragment.app.w;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
final class a extends f0 implements w.m {

    /* renamed from: t, reason: collision with root package name */
    final w f959t;

    /* renamed from: u, reason: collision with root package name */
    boolean f960u;

    /* renamed from: v, reason: collision with root package name */
    int f961v;

    /* renamed from: w, reason: collision with root package name */
    boolean f962w;

    a(w wVar) {
        super(wVar.t0(), wVar.v0() != null ? wVar.v0().f().getClassLoader() : null);
        this.f961v = -1;
        this.f962w = false;
        this.f959t = wVar;
    }

    @Override // androidx.fragment.app.w.m
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (w.I0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1065i) {
            return true;
        }
        this.f959t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.f0
    public int f() {
        return o(false);
    }

    @Override // androidx.fragment.app.f0
    public int g() {
        return o(true);
    }

    @Override // androidx.fragment.app.f0
    public void h() {
        j();
        this.f959t.d0(this, false);
    }

    @Override // androidx.fragment.app.f0
    public void i() {
        j();
        this.f959t.d0(this, true);
    }

    @Override // androidx.fragment.app.f0
    void k(int i3, Fragment fragment, String str, int i4) {
        super.k(i3, fragment, str, i4);
        fragment.mFragmentManager = this.f959t;
    }

    @Override // androidx.fragment.app.f0
    public f0 l(Fragment fragment) {
        w wVar = fragment.mFragmentManager;
        if (wVar == null || wVar == this.f959t) {
            return super.l(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void n(int i3) {
        if (this.f1065i) {
            if (w.I0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            int size = this.f1059c.size();
            for (int i4 = 0; i4 < size; i4++) {
                f0.a aVar = this.f1059c.get(i4);
                Fragment fragment = aVar.f1077b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i3;
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1077b + " to " + aVar.f1077b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int o(boolean z3) {
        if (this.f960u) {
            throw new IllegalStateException("commit already called");
        }
        if (w.I0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new k0("FragmentManager"));
            p("  ", printWriter);
            printWriter.close();
        }
        this.f960u = true;
        this.f961v = this.f1065i ? this.f959t.m() : -1;
        this.f959t.a0(this, z3);
        return this.f961v;
    }

    public void p(String str, PrintWriter printWriter) {
        q(str, printWriter, true);
    }

    public void q(String str, PrintWriter printWriter, boolean z3) {
        String str2;
        if (z3) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1067k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f961v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f960u);
            if (this.f1064h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1064h));
            }
            if (this.f1060d != 0 || this.f1061e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1060d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1061e));
            }
            if (this.f1062f != 0 || this.f1063g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1062f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1063g));
            }
            if (this.f1068l != 0 || this.f1069m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1068l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1069m);
            }
            if (this.f1070n != 0 || this.f1071o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1070n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1071o);
            }
        }
        if (this.f1059c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1059c.size();
        for (int i3 = 0; i3 < size; i3++) {
            f0.a aVar = this.f1059c.get(i3);
            switch (aVar.f1076a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1076a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1077b);
            if (z3) {
                if (aVar.f1079d != 0 || aVar.f1080e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1079d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1080e));
                }
                if (aVar.f1081f != 0 || aVar.f1082g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1081f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1082g));
                }
            }
        }
    }

    void r() {
        w wVar;
        int size = this.f1059c.size();
        for (int i3 = 0; i3 < size; i3++) {
            f0.a aVar = this.f1059c.get(i3);
            Fragment fragment = aVar.f1077b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f962w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f1064h);
                fragment.setSharedElementNames(this.f1072p, this.f1073q);
            }
            switch (aVar.f1076a) {
                case 1:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.p1(fragment, false);
                    this.f959t.j(fragment);
                    continue;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1076a);
                case 3:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.h1(fragment);
                    continue;
                case 4:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.F0(fragment);
                    continue;
                case 5:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.p1(fragment, false);
                    this.f959t.t1(fragment);
                    continue;
                case 6:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.y(fragment);
                    continue;
                case 7:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.p1(fragment, false);
                    this.f959t.o(fragment);
                    continue;
                case 8:
                    wVar = this.f959t;
                    break;
                case 9:
                    wVar = this.f959t;
                    fragment = null;
                    break;
                case 10:
                    this.f959t.q1(fragment, aVar.f1084i);
                    continue;
            }
            wVar.r1(fragment);
        }
    }

    void s() {
        w wVar;
        for (int size = this.f1059c.size() - 1; size >= 0; size--) {
            f0.a aVar = this.f1059c.get(size);
            Fragment fragment = aVar.f1077b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f962w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(w.m1(this.f1064h));
                fragment.setSharedElementNames(this.f1073q, this.f1072p);
            }
            switch (aVar.f1076a) {
                case 1:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.p1(fragment, true);
                    this.f959t.h1(fragment);
                    continue;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1076a);
                case 3:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.j(fragment);
                    continue;
                case 4:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.t1(fragment);
                    continue;
                case 5:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.p1(fragment, true);
                    this.f959t.F0(fragment);
                    continue;
                case 6:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.o(fragment);
                    continue;
                case 7:
                    fragment.setAnimations(aVar.f1079d, aVar.f1080e, aVar.f1081f, aVar.f1082g);
                    this.f959t.p1(fragment, true);
                    this.f959t.y(fragment);
                    continue;
                case 8:
                    wVar = this.f959t;
                    fragment = null;
                    break;
                case 9:
                    wVar = this.f959t;
                    break;
                case 10:
                    this.f959t.q1(fragment, aVar.f1083h);
                    continue;
            }
            wVar.r1(fragment);
        }
    }

    Fragment t(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i3 = 0;
        while (i3 < this.f1059c.size()) {
            f0.a aVar = this.f1059c.get(i3);
            int i4 = aVar.f1076a;
            if (i4 != 1) {
                if (i4 == 2) {
                    Fragment fragment3 = aVar.f1077b;
                    int i5 = fragment3.mContainerId;
                    boolean z3 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId == i5) {
                            if (fragment4 == fragment3) {
                                z3 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f1059c.add(i3, new f0.a(9, fragment4, true));
                                    i3++;
                                    fragment2 = null;
                                }
                                f0.a aVar2 = new f0.a(3, fragment4, true);
                                aVar2.f1079d = aVar.f1079d;
                                aVar2.f1081f = aVar.f1081f;
                                aVar2.f1080e = aVar.f1080e;
                                aVar2.f1082g = aVar.f1082g;
                                this.f1059c.add(i3, aVar2);
                                arrayList.remove(fragment4);
                                i3++;
                            }
                        }
                    }
                    if (z3) {
                        this.f1059c.remove(i3);
                        i3--;
                    } else {
                        aVar.f1076a = 1;
                        aVar.f1078c = true;
                        arrayList.add(fragment3);
                    }
                } else if (i4 == 3 || i4 == 6) {
                    arrayList.remove(aVar.f1077b);
                    Fragment fragment5 = aVar.f1077b;
                    if (fragment5 == fragment2) {
                        this.f1059c.add(i3, new f0.a(9, fragment5));
                        i3++;
                        fragment2 = null;
                    }
                } else if (i4 != 7) {
                    if (i4 == 8) {
                        this.f1059c.add(i3, new f0.a(9, fragment2, true));
                        aVar.f1078c = true;
                        i3++;
                        fragment2 = aVar.f1077b;
                    }
                }
                i3++;
            }
            arrayList.add(aVar.f1077b);
            i3++;
        }
        return fragment2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f961v >= 0) {
            sb.append(" #");
            sb.append(this.f961v);
        }
        if (this.f1067k != null) {
            sb.append(" ");
            sb.append(this.f1067k);
        }
        sb.append("}");
        return sb.toString();
    }

    public String u() {
        return this.f1067k;
    }

    public void v() {
        if (this.f1075s != null) {
            for (int i3 = 0; i3 < this.f1075s.size(); i3++) {
                this.f1075s.get(i3).run();
            }
            this.f1075s = null;
        }
    }

    Fragment w(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1059c.size() - 1; size >= 0; size--) {
            f0.a aVar = this.f1059c.get(size);
            int i3 = aVar.f1076a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1077b;
                            break;
                        case 10:
                            aVar.f1084i = aVar.f1083h;
                            break;
                    }
                }
                arrayList.add(aVar.f1077b);
            }
            arrayList.remove(aVar.f1077b);
        }
        return fragment;
    }
}
