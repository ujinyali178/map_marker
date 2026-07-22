package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.e;
import androidx.core.app.a1;
import androidx.core.app.b1;
import androidx.core.app.d1;
import androidx.fragment.app.f0;
import androidx.lifecycle.e;
import com.google.maps.android.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import m.d;

/* loaded from: /root/release/classes.dex */
public abstract class w {
    private static boolean S;
    private androidx.activity.result.c<Intent> D;
    private androidx.activity.result.c<androidx.activity.result.e> E;
    private androidx.activity.result.c<String[]> F;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList<androidx.fragment.app.a> M;
    private ArrayList<Boolean> N;
    private ArrayList<Fragment> O;
    private z P;
    private d.c Q;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1178b;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1180d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f1181e;

    /* renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f1183g;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<l> f1189m;

    /* renamed from: v, reason: collision with root package name */
    private o<?> f1198v;

    /* renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.k f1199w;

    /* renamed from: x, reason: collision with root package name */
    private Fragment f1200x;

    /* renamed from: y, reason: collision with root package name */
    Fragment f1201y;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<m> f1177a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final e0 f1179c = new e0();

    /* renamed from: f, reason: collision with root package name */
    private final p f1182f = new p(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.l f1184h = new b(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f1185i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, androidx.fragment.app.c> f1186j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Bundle> f1187k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, Object> f1188l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final q f1190n = new q(this);

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList<a0> f1191o = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    private final androidx.core.util.a<Configuration> f1192p = new androidx.core.util.a() { // from class: androidx.fragment.app.r
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            w.this.R0((Configuration) obj);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private final androidx.core.util.a<Integer> f1193q = new androidx.core.util.a() { // from class: androidx.fragment.app.s
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            w.this.S0((Integer) obj);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private final androidx.core.util.a<androidx.core.app.q> f1194r = new androidx.core.util.a() { // from class: androidx.fragment.app.t
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            w.this.T0((androidx.core.app.q) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private final androidx.core.util.a<d1> f1195s = new androidx.core.util.a() { // from class: androidx.fragment.app.u
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            w.this.U0((d1) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final androidx.core.view.h f1196t = new c();

    /* renamed from: u, reason: collision with root package name */
    int f1197u = -1;

    /* renamed from: z, reason: collision with root package name */
    private androidx.fragment.app.n f1202z = null;
    private androidx.fragment.app.n A = new d();
    private m0 B = null;
    private m0 C = new e();
    ArrayDeque<k> G = new ArrayDeque<>();
    private Runnable R = new f();

    class a implements androidx.activity.result.b<Map<String, Boolean>> {
        a() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Map<String, Boolean> map) {
            StringBuilder sb;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
            }
            k pollFirst = w.this.G.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
            } else {
                String str = pollFirst.f1213c;
                int i4 = pollFirst.f1214d;
                Fragment i5 = w.this.f1179c.i(str);
                if (i5 != null) {
                    i5.onRequestPermissionsResult(i4, strArr, iArr);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Permission request result delivered for unknown Fragment ");
                    sb.append(str);
                }
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    class b extends androidx.activity.l {
        b(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.l
        public void b() {
            w.this.E0();
        }
    }

    class c implements androidx.core.view.h {
        c() {
        }

        @Override // androidx.core.view.h
        public boolean a(MenuItem menuItem) {
            return w.this.L(menuItem);
        }

        @Override // androidx.core.view.h
        public void b(Menu menu) {
            w.this.M(menu);
        }

        @Override // androidx.core.view.h
        public void c(Menu menu, MenuInflater menuInflater) {
            w.this.E(menu, menuInflater);
        }

        @Override // androidx.core.view.h
        public void d(Menu menu) {
            w.this.Q(menu);
        }
    }

    class d extends androidx.fragment.app.n {
        d() {
        }

        @Override // androidx.fragment.app.n
        public Fragment a(ClassLoader classLoader, String str) {
            return w.this.v0().b(w.this.v0().f(), str, null);
        }
    }

    class e implements m0 {
        e() {
        }

        @Override // androidx.fragment.app.m0
        public l0 a(ViewGroup viewGroup) {
            return new androidx.fragment.app.d(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.c0(true);
        }
    }

    class g implements a0 {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1209c;

        g(Fragment fragment) {
            this.f1209c = fragment;
        }

        @Override // androidx.fragment.app.a0
        public void a(w wVar, Fragment fragment) {
            this.f1209c.onAttachFragment(fragment);
        }
    }

    class h implements androidx.activity.result.b<androidx.activity.result.a> {
        h() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(androidx.activity.result.a aVar) {
            k pollFirst = w.this.G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f1213c;
            int i3 = pollFirst.f1214d;
            Fragment i4 = w.this.f1179c.i(str);
            if (i4 != null) {
                i4.onActivityResult(i3, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    class i implements androidx.activity.result.b<androidx.activity.result.a> {
        i() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(androidx.activity.result.a aVar) {
            k pollFirst = w.this.G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f1213c;
            int i3 = pollFirst.f1214d;
            Fragment i4 = w.this.f1179c.i(str);
            if (i4 != null) {
                i4.onActivityResult(i3, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    static class j extends b.a<androidx.activity.result.e, androidx.activity.result.a> {
        j() {
        }

        @Override // b.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, androidx.activity.result.e eVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a4 = eVar.a();
            if (a4 != null && (bundleExtra = a4.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a4.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a4.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.a(eVar.d()).b(null).c(eVar.c(), eVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (w.I0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // b.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.activity.result.a c(int i3, Intent intent) {
            return new androidx.activity.result.a(i3, intent);
        }
    }

    static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        String f1213c;

        /* renamed from: d, reason: collision with root package name */
        int f1214d;

        class a implements Parcelable.Creator<k> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i3) {
                return new k[i3];
            }
        }

        k(Parcel parcel) {
            this.f1213c = parcel.readString();
            this.f1214d = parcel.readInt();
        }

        k(String str, int i3) {
            this.f1213c = str;
            this.f1214d = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f1213c);
            parcel.writeInt(this.f1214d);
        }
    }

    public interface l {
        void onBackStackChanged();
    }

    interface m {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class n implements m {

        /* renamed from: a, reason: collision with root package name */
        final String f1215a;

        /* renamed from: b, reason: collision with root package name */
        final int f1216b;

        /* renamed from: c, reason: collision with root package name */
        final int f1217c;

        n(String str, int i3, int i4) {
            this.f1215a = str;
            this.f1216b = i3;
            this.f1217c = i4;
        }

        @Override // androidx.fragment.app.w.m
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = w.this.f1201y;
            if (fragment == null || this.f1216b >= 0 || this.f1215a != null || !fragment.getChildFragmentManager().d1()) {
                return w.this.g1(arrayList, arrayList2, this.f1215a, this.f1216b, this.f1217c);
            }
            return false;
        }
    }

    static Fragment C0(View view) {
        Object tag = view.getTag(l.b.f3896a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean I0(int i3) {
        return S || Log.isLoggable("FragmentManager", i3);
    }

    private boolean J0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q();
    }

    private boolean K0() {
        Fragment fragment = this.f1200x;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f1200x.getParentFragmentManager().K0();
    }

    private void N(Fragment fragment) {
        if (fragment == null || !fragment.equals(g0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Configuration configuration) {
        if (K0()) {
            B(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(Integer num) {
        if (K0() && num.intValue() == 80) {
            H(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(androidx.core.app.q qVar) {
        if (K0()) {
            I(qVar.a(), false);
        }
    }

    private void U(int i3) {
        try {
            this.f1178b = true;
            this.f1179c.d(i3);
            Y0(i3, false);
            Iterator<l0> it = v().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
            this.f1178b = false;
            c0(true);
        } catch (Throwable th) {
            this.f1178b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(d1 d1Var) {
        if (K0()) {
            P(d1Var.a(), false);
        }
    }

    private void X() {
        if (this.L) {
            this.L = false;
            u1();
        }
    }

    private void Z() {
        Iterator<l0> it = v().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    private void b0(boolean z3) {
        if (this.f1178b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1198v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f1198v.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z3) {
            r();
        }
        if (this.M == null) {
            this.M = new ArrayList<>();
            this.N = new ArrayList<>();
        }
    }

    private static void e0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        while (i3 < i4) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                aVar.n(-1);
                aVar.s();
            } else {
                aVar.n(1);
                aVar.r();
            }
            i3++;
        }
    }

    private void f0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        boolean z3 = arrayList.get(i3).f1074r;
        ArrayList<Fragment> arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.f1179c.o());
        Fragment z02 = z0();
        boolean z4 = false;
        for (int i5 = i3; i5 < i4; i5++) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            z02 = !arrayList2.get(i5).booleanValue() ? aVar.t(this.O, z02) : aVar.w(this.O, z02);
            z4 = z4 || aVar.f1065i;
        }
        this.O.clear();
        if (!z3 && this.f1197u >= 1) {
            for (int i6 = i3; i6 < i4; i6++) {
                Iterator<f0.a> it = arrayList.get(i6).f1059c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f1077b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f1179c.r(x(fragment));
                    }
                }
            }
        }
        e0(arrayList, arrayList2, i3, i4);
        boolean booleanValue = arrayList2.get(i4 - 1).booleanValue();
        for (int i7 = i3; i7 < i4; i7++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i7);
            if (booleanValue) {
                for (int size = aVar2.f1059c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.f1059c.get(size).f1077b;
                    if (fragment2 != null) {
                        x(fragment2).m();
                    }
                }
            } else {
                Iterator<f0.a> it2 = aVar2.f1059c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f1077b;
                    if (fragment3 != null) {
                        x(fragment3).m();
                    }
                }
            }
        }
        Y0(this.f1197u, true);
        for (l0 l0Var : w(arrayList, i3, i4)) {
            l0Var.r(booleanValue);
            l0Var.p();
            l0Var.g();
        }
        while (i3 < i4) {
            androidx.fragment.app.a aVar3 = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue() && aVar3.f961v >= 0) {
                aVar3.f961v = -1;
            }
            aVar3.v();
            i3++;
        }
        if (z4) {
            k1();
        }
    }

    private boolean f1(String str, int i3, int i4) {
        c0(false);
        b0(true);
        Fragment fragment = this.f1201y;
        if (fragment != null && i3 < 0 && str == null && fragment.getChildFragmentManager().d1()) {
            return true;
        }
        boolean g12 = g1(this.M, this.N, str, i3, i4);
        if (g12) {
            this.f1178b = true;
            try {
                i1(this.M, this.N);
            } finally {
                s();
            }
        }
        w1();
        X();
        this.f1179c.b();
        return g12;
    }

    private int h0(String str, int i3, boolean z3) {
        ArrayList<androidx.fragment.app.a> arrayList = this.f1180d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i3 < 0) {
            if (z3) {
                return 0;
            }
            return this.f1180d.size() - 1;
        }
        int size = this.f1180d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = this.f1180d.get(size);
            if ((str != null && str.equals(aVar.u())) || (i3 >= 0 && i3 == aVar.f961v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z3) {
            if (size == this.f1180d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = this.f1180d.get(size - 1);
            if ((str == null || !str.equals(aVar2.u())) && (i3 < 0 || i3 != aVar2.f961v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private void i1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!arrayList.get(i3).f1074r) {
                if (i4 != i3) {
                    f0(arrayList, arrayList2, i4, i3);
                }
                i4 = i3 + 1;
                if (arrayList2.get(i3).booleanValue()) {
                    while (i4 < size && arrayList2.get(i4).booleanValue() && !arrayList.get(i4).f1074r) {
                        i4++;
                    }
                }
                f0(arrayList, arrayList2, i3, i4);
                i3 = i4 - 1;
            }
            i3++;
        }
        if (i4 != size) {
            f0(arrayList, arrayList2, i4, size);
        }
    }

    private void k1() {
        if (this.f1189m != null) {
            for (int i3 = 0; i3 < this.f1189m.size(); i3++) {
                this.f1189m.get(i3).onBackStackChanged();
            }
        }
    }

    static w l0(View view) {
        Fragment m02 = m0(view);
        if (m02 != null) {
            if (m02.isAdded()) {
                return m02.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + m02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        FragmentActivity fragmentActivity = null;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment m0(View view) {
        while (view != null) {
            Fragment C0 = C0(view);
            if (C0 != null) {
                return C0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    static int m1(int i3) {
        if (i3 == 4097) {
            return 8194;
        }
        if (i3 == 8194) {
            return 4097;
        }
        if (i3 == 8197) {
            return 4100;
        }
        if (i3 != 4099) {
            return i3 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    private void n0() {
        Iterator<l0> it = v().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    private boolean o0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f1177a) {
            if (this.f1177a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f1177a.size();
                boolean z3 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    z3 |= this.f1177a.get(i3).a(arrayList, arrayList2);
                }
                return z3;
            } finally {
                this.f1177a.clear();
                this.f1198v.g().removeCallbacks(this.R);
            }
        }
    }

    private z q0(Fragment fragment) {
        return this.P.k(fragment);
    }

    private void r() {
        if (P0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void s() {
        this.f1178b = false;
        this.N.clear();
        this.M.clear();
    }

    private ViewGroup s0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f1199w.d()) {
            View c3 = this.f1199w.c(fragment.mContainerId);
            if (c3 instanceof ViewGroup) {
                return (ViewGroup) c3;
            }
        }
        return null;
    }

    private void s1(Fragment fragment) {
        ViewGroup s02 = s0(fragment);
        if (s02 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i3 = l.b.f3898c;
        if (s02.getTag(i3) == null) {
            s02.setTag(i3, fragment);
        }
        ((Fragment) s02.getTag(i3)).setPopDirection(fragment.getPopDirection());
    }

    private void t() {
        o<?> oVar = this.f1198v;
        boolean z3 = true;
        if (oVar instanceof androidx.lifecycle.e0) {
            z3 = this.f1179c.p().o();
        } else if (oVar.f() instanceof Activity) {
            z3 = true ^ ((Activity) this.f1198v.f()).isChangingConfigurations();
        }
        if (z3) {
            Iterator<androidx.fragment.app.c> it = this.f1186j.values().iterator();
            while (it.hasNext()) {
                Iterator<String> it2 = it.next().f977c.iterator();
                while (it2.hasNext()) {
                    this.f1179c.p().h(it2.next());
                }
            }
        }
    }

    private void u1() {
        Iterator<d0> it = this.f1179c.k().iterator();
        while (it.hasNext()) {
            b1(it.next());
        }
    }

    private Set<l0> v() {
        HashSet hashSet = new HashSet();
        Iterator<d0> it = this.f1179c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(l0.o(viewGroup, A0()));
            }
        }
        return hashSet;
    }

    private void v1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new k0("FragmentManager"));
        o<?> oVar = this.f1198v;
        try {
            if (oVar != null) {
                oVar.h("  ", null, printWriter, new String[0]);
            } else {
                Y("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private Set<l0> w(ArrayList<androidx.fragment.app.a> arrayList, int i3, int i4) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i3 < i4) {
            Iterator<f0.a> it = arrayList.get(i3).f1059c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f1077b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(l0.n(viewGroup, this));
                }
            }
            i3++;
        }
        return hashSet;
    }

    private void w1() {
        synchronized (this.f1177a) {
            if (this.f1177a.isEmpty()) {
                this.f1184h.f(p0() > 0 && N0(this.f1200x));
            } else {
                this.f1184h.f(true);
            }
        }
    }

    void A() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(0);
    }

    m0 A0() {
        m0 m0Var = this.B;
        if (m0Var != null) {
            return m0Var;
        }
        Fragment fragment = this.f1200x;
        return fragment != null ? fragment.mFragmentManager.A0() : this.C;
    }

    void B(Configuration configuration, boolean z3) {
        if (z3 && (this.f1198v instanceof androidx.core.content.l)) {
            v1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z3) {
                    fragment.mChildFragmentManager.B(configuration, true);
                }
            }
        }
    }

    public d.c B0() {
        return this.Q;
    }

    boolean C(MenuItem menuItem) {
        if (this.f1197u < 1) {
            return false;
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void D() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(1);
    }

    androidx.lifecycle.d0 D0(Fragment fragment) {
        return this.P.n(fragment);
    }

    boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.f1197u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z3 = false;
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null && M0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z3 = true;
            }
        }
        if (this.f1181e != null) {
            for (int i3 = 0; i3 < this.f1181e.size(); i3++) {
                Fragment fragment2 = this.f1181e.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1181e = arrayList;
        return z3;
    }

    void E0() {
        c0(true);
        if (this.f1184h.c()) {
            d1();
        } else {
            this.f1183g.e();
        }
    }

    void F() {
        this.K = true;
        c0(true);
        Z();
        t();
        U(-1);
        Object obj = this.f1198v;
        if (obj instanceof androidx.core.content.m) {
            ((androidx.core.content.m) obj).removeOnTrimMemoryListener(this.f1193q);
        }
        Object obj2 = this.f1198v;
        if (obj2 instanceof androidx.core.content.l) {
            ((androidx.core.content.l) obj2).removeOnConfigurationChangedListener(this.f1192p);
        }
        Object obj3 = this.f1198v;
        if (obj3 instanceof a1) {
            ((a1) obj3).removeOnMultiWindowModeChangedListener(this.f1194r);
        }
        Object obj4 = this.f1198v;
        if (obj4 instanceof b1) {
            ((b1) obj4).removeOnPictureInPictureModeChangedListener(this.f1195s);
        }
        Object obj5 = this.f1198v;
        if ((obj5 instanceof androidx.core.view.d) && this.f1200x == null) {
            ((androidx.core.view.d) obj5).removeMenuProvider(this.f1196t);
        }
        this.f1198v = null;
        this.f1199w = null;
        this.f1200x = null;
        if (this.f1183g != null) {
            this.f1184h.d();
            this.f1183g = null;
        }
        androidx.activity.result.c<Intent> cVar = this.D;
        if (cVar != null) {
            cVar.c();
            this.E.c();
            this.F.c();
        }
    }

    void F0(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        s1(fragment);
    }

    void G() {
        U(1);
    }

    void G0(Fragment fragment) {
        if (fragment.mAdded && J0(fragment)) {
            this.H = true;
        }
    }

    void H(boolean z3) {
        if (z3 && (this.f1198v instanceof androidx.core.content.m)) {
            v1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z3) {
                    fragment.mChildFragmentManager.H(true);
                }
            }
        }
    }

    public boolean H0() {
        return this.K;
    }

    void I(boolean z3, boolean z4) {
        if (z4 && (this.f1198v instanceof a1)) {
            v1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z3);
                if (z4) {
                    fragment.mChildFragmentManager.I(z3, true);
                }
            }
        }
    }

    void J(Fragment fragment) {
        Iterator<a0> it = this.f1191o.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    void K() {
        for (Fragment fragment : this.f1179c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.K();
            }
        }
    }

    boolean L(MenuItem menuItem) {
        if (this.f1197u < 1) {
            return false;
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean L0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    void M(Menu menu) {
        if (this.f1197u < 1) {
            return;
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    boolean M0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    boolean N0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        w wVar = fragment.mFragmentManager;
        return fragment.equals(wVar.z0()) && N0(wVar.f1200x);
    }

    void O() {
        U(5);
    }

    boolean O0(int i3) {
        return this.f1197u >= i3;
    }

    void P(boolean z3, boolean z4) {
        if (z4 && (this.f1198v instanceof b1)) {
            v1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z3);
                if (z4) {
                    fragment.mChildFragmentManager.P(z3, true);
                }
            }
        }
    }

    public boolean P0() {
        return this.I || this.J;
    }

    boolean Q(Menu menu) {
        boolean z3 = false;
        if (this.f1197u < 1) {
            return false;
        }
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null && M0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z3 = true;
            }
        }
        return z3;
    }

    void R() {
        w1();
        N(this.f1201y);
    }

    void S() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(7);
    }

    void T() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(5);
    }

    void V() {
        this.J = true;
        this.P.q(true);
        U(4);
    }

    void V0(Fragment fragment, String[] strArr, int i3) {
        if (this.F == null) {
            this.f1198v.k(fragment, strArr, i3);
            return;
        }
        this.G.addLast(new k(fragment.mWho, i3));
        this.F.a(strArr);
    }

    void W() {
        U(2);
    }

    void W0(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (this.D == null) {
            this.f1198v.m(fragment, intent, i3, bundle);
            return;
        }
        this.G.addLast(new k(fragment.mWho, i3));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.a(intent);
    }

    void X0(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        Intent intent2;
        if (this.E == null) {
            this.f1198v.n(fragment, intentSender, i3, intent, i4, i5, i6, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (I0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        androidx.activity.result.e a4 = new e.a(intentSender).b(intent2).c(i5, i4).a();
        this.G.addLast(new k(fragment.mWho, i3));
        if (I0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.E.a(a4);
    }

    public void Y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f1179c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f1181e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                Fragment fragment = this.f1181e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f1180d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                androidx.fragment.app.a aVar = this.f1180d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.p(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1185i.get());
        synchronized (this.f1177a) {
            int size3 = this.f1177a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size3; i5++) {
                    m mVar = this.f1177a.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(mVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1198v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1199w);
        if (this.f1200x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1200x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1197u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    void Y0(int i3, boolean z3) {
        o<?> oVar;
        if (this.f1198v == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z3 || i3 != this.f1197u) {
            this.f1197u = i3;
            this.f1179c.t();
            u1();
            if (this.H && (oVar = this.f1198v) != null && this.f1197u == 7) {
                oVar.o();
                this.H = false;
            }
        }
    }

    void Z0() {
        if (this.f1198v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.q(false);
        for (Fragment fragment : this.f1179c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void a0(m mVar, boolean z3) {
        if (!z3) {
            if (this.f1198v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.f1177a) {
            if (this.f1198v == null) {
                if (!z3) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f1177a.add(mVar);
                o1();
            }
        }
    }

    void a1(androidx.fragment.app.l lVar) {
        View view;
        for (d0 d0Var : this.f1179c.k()) {
            Fragment k3 = d0Var.k();
            if (k3.mContainerId == lVar.getId() && (view = k3.mView) != null && view.getParent() == null) {
                k3.mContainer = lVar;
                d0Var.b();
            }
        }
    }

    void b1(d0 d0Var) {
        Fragment k3 = d0Var.k();
        if (k3.mDeferStart) {
            if (this.f1178b) {
                this.L = true;
            } else {
                k3.mDeferStart = false;
                d0Var.m();
            }
        }
    }

    boolean c0(boolean z3) {
        b0(z3);
        boolean z4 = false;
        while (o0(this.M, this.N)) {
            this.f1178b = true;
            try {
                i1(this.M, this.N);
                s();
                z4 = true;
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        w1();
        X();
        this.f1179c.b();
        return z4;
    }

    void c1(int i3, int i4, boolean z3) {
        if (i3 >= 0) {
            a0(new n(null, i3, i4), z3);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    void d0(m mVar, boolean z3) {
        if (z3 && (this.f1198v == null || this.K)) {
            return;
        }
        b0(z3);
        if (mVar.a(this.M, this.N)) {
            this.f1178b = true;
            try {
                i1(this.M, this.N);
            } finally {
                s();
            }
        }
        w1();
        X();
        this.f1179c.b();
    }

    public boolean d1() {
        return f1(null, -1, 0);
    }

    public boolean e1(int i3, int i4) {
        if (i3 >= 0) {
            return f1(null, i3, i4);
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    Fragment g0(String str) {
        return this.f1179c.f(str);
    }

    boolean g1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i3, int i4) {
        int h02 = h0(str, i3, (i4 & 1) != 0);
        if (h02 < 0) {
            return false;
        }
        for (int size = this.f1180d.size() - 1; size >= h02; size--) {
            arrayList.add(this.f1180d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    void h1(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z3 = !fragment.isInBackStack();
        if (!fragment.mDetached || z3) {
            this.f1179c.u(fragment);
            if (J0(fragment)) {
                this.H = true;
            }
            fragment.mRemoving = true;
            s1(fragment);
        }
    }

    void i(androidx.fragment.app.a aVar) {
        if (this.f1180d == null) {
            this.f1180d = new ArrayList<>();
        }
        this.f1180d.add(aVar);
    }

    public Fragment i0(int i3) {
        return this.f1179c.g(i3);
    }

    d0 j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            m.d.h(fragment, str);
        }
        if (I0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        d0 x3 = x(fragment);
        fragment.mFragmentManager = this;
        this.f1179c.r(x3);
        if (!fragment.mDetached) {
            this.f1179c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (J0(fragment)) {
                this.H = true;
            }
        }
        return x3;
    }

    public Fragment j0(String str) {
        return this.f1179c.h(str);
    }

    void j1(Fragment fragment) {
        this.P.p(fragment);
    }

    public void k(a0 a0Var) {
        this.f1191o.add(a0Var);
    }

    Fragment k0(String str) {
        return this.f1179c.i(str);
    }

    void l(Fragment fragment) {
        this.P.f(fragment);
    }

    void l1(Parcelable parcelable) {
        d0 d0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f1198v.f().getClassLoader());
                this.f1187k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<c0> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f1198v.f().getClassLoader());
                arrayList.add((c0) bundle.getParcelable("state"));
            }
        }
        this.f1179c.x(arrayList);
        y yVar = (y) bundle3.getParcelable("state");
        if (yVar == null) {
            return;
        }
        this.f1179c.v();
        Iterator<String> it = yVar.f1219c.iterator();
        while (it.hasNext()) {
            c0 B = this.f1179c.B(it.next(), null);
            if (B != null) {
                Fragment j3 = this.P.j(B.f980d);
                if (j3 != null) {
                    if (I0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + j3);
                    }
                    d0Var = new d0(this.f1190n, this.f1179c, j3, B);
                } else {
                    d0Var = new d0(this.f1190n, this.f1179c, this.f1198v.f().getClassLoader(), t0(), B);
                }
                Fragment k3 = d0Var.k();
                k3.mFragmentManager = this;
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k3.mWho + "): " + k3);
                }
                d0Var.o(this.f1198v.f().getClassLoader());
                this.f1179c.r(d0Var);
                d0Var.t(this.f1197u);
            }
        }
        for (Fragment fragment : this.P.m()) {
            if (!this.f1179c.c(fragment.mWho)) {
                if (I0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + yVar.f1219c);
                }
                this.P.p(fragment);
                fragment.mFragmentManager = this;
                d0 d0Var2 = new d0(this.f1190n, this.f1179c, fragment);
                d0Var2.t(1);
                d0Var2.m();
                fragment.mRemoving = true;
                d0Var2.m();
            }
        }
        this.f1179c.w(yVar.f1220d);
        if (yVar.f1221f != null) {
            this.f1180d = new ArrayList<>(yVar.f1221f.length);
            int i3 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = yVar.f1221f;
                if (i3 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a b4 = bVarArr[i3].b(this);
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + b4.f961v + "): " + b4);
                    PrintWriter printWriter = new PrintWriter(new k0("FragmentManager"));
                    b4.q("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1180d.add(b4);
                i3++;
            }
        } else {
            this.f1180d = null;
        }
        this.f1185i.set(yVar.f1222g);
        String str3 = yVar.f1223h;
        if (str3 != null) {
            Fragment g02 = g0(str3);
            this.f1201y = g02;
            N(g02);
        }
        ArrayList<String> arrayList2 = yVar.f1224i;
        if (arrayList2 != null) {
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                this.f1186j.put(arrayList2.get(i4), yVar.f1225j.get(i4));
            }
        }
        this.G = new ArrayDeque<>(yVar.f1226k);
    }

    int m() {
        return this.f1185i.getAndIncrement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void n(androidx.fragment.app.o<?> r4, androidx.fragment.app.k r5, androidx.fragment.app.Fragment r6) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w.n(androidx.fragment.app.o, androidx.fragment.app.k, androidx.fragment.app.Fragment):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public Bundle Q0() {
        int size;
        Bundle bundle = new Bundle();
        n0();
        Z();
        c0(true);
        this.I = true;
        this.P.q(true);
        ArrayList<String> y3 = this.f1179c.y();
        ArrayList<c0> m3 = this.f1179c.m();
        if (!m3.isEmpty()) {
            ArrayList<String> z3 = this.f1179c.z();
            androidx.fragment.app.b[] bVarArr = null;
            ArrayList<androidx.fragment.app.a> arrayList = this.f1180d;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                bVarArr = new androidx.fragment.app.b[size];
                for (int i3 = 0; i3 < size; i3++) {
                    bVarArr[i3] = new androidx.fragment.app.b(this.f1180d.get(i3));
                    if (I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f1180d.get(i3));
                    }
                }
            }
            y yVar = new y();
            yVar.f1219c = y3;
            yVar.f1220d = z3;
            yVar.f1221f = bVarArr;
            yVar.f1222g = this.f1185i.get();
            Fragment fragment = this.f1201y;
            if (fragment != null) {
                yVar.f1223h = fragment.mWho;
            }
            yVar.f1224i.addAll(this.f1186j.keySet());
            yVar.f1225j.addAll(this.f1186j.values());
            yVar.f1226k = new ArrayList<>(this.G);
            bundle.putParcelable("state", yVar);
            for (String str : this.f1187k.keySet()) {
                bundle.putBundle("result_" + str, this.f1187k.get(str));
            }
            Iterator<c0> it = m3.iterator();
            while (it.hasNext()) {
                c0 next = it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", next);
                bundle.putBundle("fragment_" + next.f980d, bundle2);
            }
        } else if (I0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    void o(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f1179c.a(fragment);
            if (I0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (J0(fragment)) {
                this.H = true;
            }
        }
    }

    void o1() {
        synchronized (this.f1177a) {
            boolean z3 = true;
            if (this.f1177a.size() != 1) {
                z3 = false;
            }
            if (z3) {
                this.f1198v.g().removeCallbacks(this.R);
                this.f1198v.g().post(this.R);
                w1();
            }
        }
    }

    public f0 p() {
        return new androidx.fragment.app.a(this);
    }

    public int p0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f1180d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void p1(Fragment fragment, boolean z3) {
        ViewGroup s02 = s0(fragment);
        if (s02 == null || !(s02 instanceof androidx.fragment.app.l)) {
            return;
        }
        ((androidx.fragment.app.l) s02).setDrawDisappearingViewsLast(!z3);
    }

    boolean q() {
        boolean z3 = false;
        for (Fragment fragment : this.f1179c.l()) {
            if (fragment != null) {
                z3 = J0(fragment);
            }
            if (z3) {
                return true;
            }
        }
        return false;
    }

    void q1(Fragment fragment, e.b bVar) {
        if (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    androidx.fragment.app.k r0() {
        return this.f1199w;
    }

    void r1(Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f1201y;
            this.f1201y = fragment;
            N(fragment2);
            N(this.f1201y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public androidx.fragment.app.n t0() {
        androidx.fragment.app.n nVar = this.f1202z;
        if (nVar != null) {
            return nVar;
        }
        Fragment fragment = this.f1200x;
        return fragment != null ? fragment.mFragmentManager.t0() : this.A;
    }

    void t1(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f1200x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.f1200x;
        } else {
            o<?> oVar = this.f1198v;
            if (oVar == null) {
                sb.append(BuildConfig.TRAVIS);
                sb.append("}}");
                return sb.toString();
            }
            sb.append(oVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.f1198v;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str) {
        this.f1187k.remove(str);
        if (I0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public List<Fragment> u0() {
        return this.f1179c.o();
    }

    public o<?> v0() {
        return this.f1198v;
    }

    LayoutInflater.Factory2 w0() {
        return this.f1182f;
    }

    d0 x(Fragment fragment) {
        d0 n3 = this.f1179c.n(fragment.mWho);
        if (n3 != null) {
            return n3;
        }
        d0 d0Var = new d0(this.f1190n, this.f1179c, fragment);
        d0Var.o(this.f1198v.f().getClassLoader());
        d0Var.t(this.f1197u);
        return d0Var;
    }

    q x0() {
        return this.f1190n;
    }

    void y(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (I0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f1179c.u(fragment);
            if (J0(fragment)) {
                this.H = true;
            }
            s1(fragment);
        }
    }

    Fragment y0() {
        return this.f1200x;
    }

    void z() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(4);
    }

    public Fragment z0() {
        return this.f1201y;
    }
}
