package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f1130a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<e> f1131b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<e> f1132c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f1133d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f1134e = false;

    class a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f1135c;

        a(d dVar) {
            this.f1135c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l0.this.f1131b.contains(this.f1135c)) {
                this.f1135c.e().a(this.f1135c.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f1137c;

        b(d dVar) {
            this.f1137c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.f1131b.remove(this.f1137c);
            l0.this.f1132c.remove(this.f1137c);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1139a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1140b;

        static {
            int[] iArr = new int[e.b.values().length];
            f1140b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1140b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1140b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f1139a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1139a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1139a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1139a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        private final d0 f1141h;

        d(e.c cVar, e.b bVar, d0 d0Var, androidx.core.os.f fVar) {
            super(cVar, bVar, d0Var.k(), fVar);
            this.f1141h = d0Var;
        }

        @Override // androidx.fragment.app.l0.e
        public void c() {
            super.c();
            this.f1141h.m();
        }

        @Override // androidx.fragment.app.l0.e
        void l() {
            if (g() != e.b.ADDING) {
                if (g() == e.b.REMOVING) {
                    Fragment k3 = this.f1141h.k();
                    View requireView = k3.requireView();
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + requireView.findFocus() + " on view " + requireView + " for Fragment " + k3);
                    }
                    requireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment k4 = this.f1141h.k();
            View findFocus = k4.mView.findFocus();
            if (findFocus != null) {
                k4.setFocusedView(findFocus);
                if (w.I0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k4);
                }
            }
            View requireView2 = f().requireView();
            if (requireView2.getParent() == null) {
                this.f1141h.b();
                requireView2.setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
            if (requireView2.getAlpha() == BitmapDescriptorFactory.HUE_RED && requireView2.getVisibility() == 0) {
                requireView2.setVisibility(4);
            }
            requireView2.setAlpha(k4.getPostOnViewCreatedAlpha());
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private c f1142a;

        /* renamed from: b, reason: collision with root package name */
        private b f1143b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f1144c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Runnable> f1145d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet<androidx.core.os.f> f1146e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f1147f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f1148g = false;

        class a implements f.b {
            a() {
            }

            @Override // androidx.core.os.f.b
            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i3) {
                if (i3 == 0) {
                    return VISIBLE;
                }
                if (i3 == 4) {
                    return INVISIBLE;
                }
                if (i3 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i3);
            }

            static c c(View view) {
                return (view.getAlpha() == BitmapDescriptorFactory.HUE_RED && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            void a(View view) {
                int i3;
                int i4 = c.f1139a[ordinal()];
                if (i4 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (w.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i4 == 2) {
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    i3 = 0;
                } else {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        if (w.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    }
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.f fVar) {
            this.f1142a = cVar;
            this.f1143b = bVar;
            this.f1144c = fragment;
            fVar.b(new a());
        }

        final void a(Runnable runnable) {
            this.f1145d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f1147f = true;
            if (this.f1146e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f1146e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.f) it.next()).a();
            }
        }

        public void c() {
            if (this.f1148g) {
                return;
            }
            if (w.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1148g = true;
            Iterator<Runnable> it = this.f1145d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(androidx.core.os.f fVar) {
            if (this.f1146e.remove(fVar) && this.f1146e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f1142a;
        }

        public final Fragment f() {
            return this.f1144c;
        }

        b g() {
            return this.f1143b;
        }

        final boolean h() {
            return this.f1147f;
        }

        final boolean i() {
            return this.f1148g;
        }

        public final void j(androidx.core.os.f fVar) {
            l();
            this.f1146e.add(fVar);
        }

        final void k(c cVar, b bVar) {
            b bVar2;
            int i3 = c.f1140b[bVar.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && this.f1142a != c.REMOVED) {
                        if (w.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1144c + " mFinalState = " + this.f1142a + " -> " + cVar + ". ");
                        }
                        this.f1142a = cVar;
                        return;
                    }
                    return;
                }
                if (w.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1144c + " mFinalState = " + this.f1142a + " -> REMOVED. mLifecycleImpact  = " + this.f1143b + " to REMOVING.");
                }
                this.f1142a = c.REMOVED;
                bVar2 = b.REMOVING;
            } else {
                if (this.f1142a != c.REMOVED) {
                    return;
                }
                if (w.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1144c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1143b + " to ADDING.");
                }
                this.f1142a = c.VISIBLE;
                bVar2 = b.ADDING;
            }
            this.f1143b = bVar2;
        }

        void l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f1142a + "} {mLifecycleImpact = " + this.f1143b + "} {mFragment = " + this.f1144c + "}";
        }
    }

    l0(ViewGroup viewGroup) {
        this.f1130a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, d0 d0Var) {
        synchronized (this.f1131b) {
            androidx.core.os.f fVar = new androidx.core.os.f();
            e h3 = h(d0Var.k());
            if (h3 != null) {
                h3.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, d0Var, fVar);
            this.f1131b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        Iterator<e> it = this.f1131b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator<e> it = this.f1132c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    static l0 n(ViewGroup viewGroup, w wVar) {
        return o(viewGroup, wVar.A0());
    }

    static l0 o(ViewGroup viewGroup, m0 m0Var) {
        int i3 = l.b.f3897b;
        Object tag = viewGroup.getTag(i3);
        if (tag instanceof l0) {
            return (l0) tag;
        }
        l0 a4 = m0Var.a(viewGroup);
        viewGroup.setTag(i3, a4);
        return a4;
    }

    private void q() {
        Iterator<e> it = this.f1131b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.g() == e.b.ADDING) {
                next.k(e.c.b(next.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, d0 d0Var) {
        if (w.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + d0Var.k());
        }
        a(cVar, e.b.ADDING, d0Var);
    }

    void c(d0 d0Var) {
        if (w.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + d0Var.k());
        }
        a(e.c.GONE, e.b.NONE, d0Var);
    }

    void d(d0 d0Var) {
        if (w.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + d0Var.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, d0Var);
    }

    void e(d0 d0Var) {
        if (w.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + d0Var.k());
        }
        a(e.c.VISIBLE, e.b.NONE, d0Var);
    }

    abstract void f(List<e> list, boolean z3);

    void g() {
        if (this.f1134e) {
            return;
        }
        if (!androidx.core.view.n.i(this.f1130a)) {
            j();
            this.f1133d = false;
            return;
        }
        synchronized (this.f1131b) {
            if (!this.f1131b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f1132c);
                this.f1132c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                    }
                    eVar.b();
                    if (!eVar.i()) {
                        this.f1132c.add(eVar);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f1131b);
                this.f1131b.clear();
                this.f1132c.addAll(arrayList2);
                if (w.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).l();
                }
                f(arrayList2, this.f1133d);
                this.f1133d = false;
                if (w.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
        }
    }

    void j() {
        String str;
        String str2;
        if (w.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean i3 = androidx.core.view.n.i(this.f1130a);
        synchronized (this.f1131b) {
            q();
            Iterator<e> it = this.f1131b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f1132c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (w.I0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (i3) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f1130a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                    Log.v("FragmentManager", sb.toString());
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f1131b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (w.I0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (i3) {
                        str = "";
                    } else {
                        str = "Container " + this.f1130a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar2.b();
            }
        }
    }

    void k() {
        if (this.f1134e) {
            if (w.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f1134e = false;
            g();
        }
    }

    e.b l(d0 d0Var) {
        e h3 = h(d0Var.k());
        e.b g3 = h3 != null ? h3.g() : null;
        e i3 = i(d0Var.k());
        return (i3 == null || !(g3 == null || g3 == e.b.NONE)) ? g3 : i3.g();
    }

    public ViewGroup m() {
        return this.f1130a;
    }

    void p() {
        synchronized (this.f1131b) {
            q();
            this.f1134e = false;
            int size = this.f1131b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f1131b.get(size);
                e.c c3 = e.c.c(eVar.f().mView);
                e.c e3 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e3 == cVar && c3 != cVar) {
                    this.f1134e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    void r(boolean z3) {
        this.f1133d = z3;
    }
}
