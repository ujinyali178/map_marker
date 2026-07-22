package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.f;
import androidx.fragment.app.j;
import androidx.fragment.app.l0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class d extends l0 {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f992a;

        static {
            int[] iArr = new int[l0.e.c.values().length];
            f992a = iArr;
            try {
                iArr[l0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f992a[l0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f992a[l0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f992a[l0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f993c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f994d;

        b(List list, l0.e eVar) {
            this.f993c = list;
            this.f994d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f993c.contains(this.f994d)) {
                this.f993c.remove(this.f994d);
                d.this.s(this.f994d);
            }
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f996a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f997b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f998c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f999d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f1000e;

        c(ViewGroup viewGroup, View view, boolean z3, l0.e eVar, k kVar) {
            this.f996a = viewGroup;
            this.f997b = view;
            this.f998c = z3;
            this.f999d = eVar;
            this.f1000e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f996a.endViewTransition(this.f997b);
            if (this.f998c) {
                this.f999d.e().a(this.f997b);
            }
            this.f1000e.a();
            if (w.I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f999d + " has ended.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    class C0020d implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f1002a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l0.e f1003b;

        C0020d(Animator animator, l0.e eVar) {
            this.f1002a = animator;
            this.f1003b = eVar;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f1002a.end();
            if (w.I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f1003b + " has been canceled.");
            }
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l0.e f1005a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1006b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1007c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f1008d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f1006b.endViewTransition(eVar.f1007c);
                e.this.f1008d.a();
            }
        }

        e(l0.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f1005a = eVar;
            this.f1006b = viewGroup;
            this.f1007c = view;
            this.f1008d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1006b.post(new a());
            if (w.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f1005a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (w.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f1005a + " has reached onAnimationStart.");
            }
        }
    }

    class f implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1011a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1012b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f1013c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f1014d;

        f(View view, ViewGroup viewGroup, k kVar, l0.e eVar) {
            this.f1011a = view;
            this.f1012b = viewGroup;
            this.f1013c = kVar;
            this.f1014d = eVar;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f1011a.clearAnimation();
            this.f1012b.endViewTransition(this.f1011a);
            this.f1013c.a();
            if (w.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f1014d + " has been cancelled.");
            }
        }
    }

    class g implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l0.e f1016c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f1017d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f1018f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f1019g;

        g(l0.e eVar, l0.e eVar2, boolean z3, androidx.collection.a aVar) {
            this.f1016c = eVar;
            this.f1017d = eVar2;
            this.f1018f = z3;
            this.f1019g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.a(this.f1016c.f(), this.f1017d.f(), this.f1018f, this.f1019g, false);
        }
    }

    class h implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i0 f1021c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f1022d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Rect f1023f;

        h(i0 i0Var, View view, Rect rect) {
            this.f1021c = i0Var;
            this.f1022d = view;
            this.f1023f = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1021c.h(this.f1022d, this.f1023f);
        }
    }

    class i implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f1025c;

        i(ArrayList arrayList) {
            this.f1025c = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.d(this.f1025c, 4);
        }
    }

    class j implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f1027c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f1028d;

        j(m mVar, l0.e eVar) {
            this.f1027c = mVar;
            this.f1028d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1027c.a();
            if (w.I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.f1028d + "has completed");
            }
        }
    }

    private static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f1030c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1031d;

        /* renamed from: e, reason: collision with root package name */
        private j.a f1032e;

        k(l0.e eVar, androidx.core.os.f fVar, boolean z3) {
            super(eVar, fVar);
            this.f1031d = false;
            this.f1030c = z3;
        }

        j.a e(Context context) {
            if (this.f1031d) {
                return this.f1032e;
            }
            j.a b4 = androidx.fragment.app.j.b(context, b().f(), b().e() == l0.e.c.VISIBLE, this.f1030c);
            this.f1032e = b4;
            this.f1031d = true;
            return b4;
        }
    }

    private static class l {

        /* renamed from: a, reason: collision with root package name */
        private final l0.e f1033a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.f f1034b;

        l(l0.e eVar, androidx.core.os.f fVar) {
            this.f1033a = eVar;
            this.f1034b = fVar;
        }

        void a() {
            this.f1033a.d(this.f1034b);
        }

        l0.e b() {
            return this.f1033a;
        }

        androidx.core.os.f c() {
            return this.f1034b;
        }

        boolean d() {
            l0.e.c cVar;
            l0.e.c c3 = l0.e.c.c(this.f1033a.f().mView);
            l0.e.c e3 = this.f1033a.e();
            return c3 == e3 || !(c3 == (cVar = l0.e.c.VISIBLE) || e3 == cVar);
        }
    }

    private static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final Object f1035c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f1036d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f1037e;

        m(l0.e eVar, androidx.core.os.f fVar, boolean z3, boolean z4) {
            super(eVar, fVar);
            boolean z5;
            Object obj;
            if (eVar.e() == l0.e.c.VISIBLE) {
                Fragment f3 = eVar.f();
                this.f1035c = z3 ? f3.getReenterTransition() : f3.getEnterTransition();
                Fragment f4 = eVar.f();
                z5 = z3 ? f4.getAllowReturnTransitionOverlap() : f4.getAllowEnterTransitionOverlap();
            } else {
                Fragment f5 = eVar.f();
                this.f1035c = z3 ? f5.getReturnTransition() : f5.getExitTransition();
                z5 = true;
            }
            this.f1036d = z5;
            if (z4) {
                Fragment f6 = eVar.f();
                obj = z3 ? f6.getSharedElementReturnTransition() : f6.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.f1037e = obj;
        }

        private i0 f(Object obj) {
            if (obj == null) {
                return null;
            }
            i0 i0Var = g0.f1086a;
            if (i0Var != null && i0Var.e(obj)) {
                return i0Var;
            }
            i0 i0Var2 = g0.f1087b;
            if (i0Var2 != null && i0Var2.e(obj)) {
                return i0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        i0 e() {
            i0 f3 = f(this.f1035c);
            i0 f4 = f(this.f1037e);
            if (f3 == null || f4 == null || f3 == f4) {
                return f3 != null ? f3 : f4;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f1035c + " which uses a different Transition  type than its shared element transition " + this.f1037e);
        }

        public Object g() {
            return this.f1037e;
        }

        Object h() {
            return this.f1035c;
        }

        public boolean i() {
            return this.f1037e != null;
        }

        boolean j() {
            return this.f1036d;
        }
    }

    d(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<l0.e> list2, boolean z3, Map<l0.e, Boolean> map) {
        int i3;
        StringBuilder sb;
        String str;
        boolean z4;
        j.a e3;
        l0.e eVar;
        ViewGroup m3 = m();
        Context context = m3.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = list.iterator();
        boolean z5 = false;
        while (true) {
            i3 = 2;
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next.d() || (e3 = next.e(context)) == null) {
                next.a();
            } else {
                Animator animator = e3.f1113b;
                if (animator == null) {
                    arrayList.add(next);
                } else {
                    l0.e b4 = next.b();
                    Fragment f3 = b4.f();
                    if (Boolean.TRUE.equals(map.get(b4))) {
                        if (w.I0(2)) {
                            Log.v("FragmentManager", "Ignoring Animator set on " + f3 + " as this Fragment was involved in a Transition.");
                        }
                        next.a();
                    } else {
                        boolean z6 = b4.e() == l0.e.c.GONE;
                        if (z6) {
                            list2.remove(b4);
                        }
                        View view = f3.mView;
                        m3.startViewTransition(view);
                        animator.addListener(new c(m3, view, z6, b4, next));
                        animator.setTarget(view);
                        animator.start();
                        if (w.I0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Animator from operation ");
                            eVar = b4;
                            sb2.append(eVar);
                            sb2.append(" has started.");
                            Log.v("FragmentManager", sb2.toString());
                        } else {
                            eVar = b4;
                        }
                        next.c().b(new C0020d(animator, eVar));
                        z5 = true;
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar = (k) it2.next();
            l0.e b5 = kVar.b();
            Fragment f4 = b5.f();
            if (z3) {
                if (w.I0(i3)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f4);
                    str = " as Animations cannot run alongside Transitions.";
                    sb.append(str);
                    Log.v("FragmentManager", sb.toString());
                }
                kVar.a();
            } else if (z5) {
                if (w.I0(i3)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f4);
                    str = " as Animations cannot run alongside Animators.";
                    sb.append(str);
                    Log.v("FragmentManager", sb.toString());
                }
                kVar.a();
            } else {
                View view2 = f4.mView;
                Animation animation = (Animation) androidx.core.util.d.e(((j.a) androidx.core.util.d.e(kVar.e(context))).f1112a);
                if (b5.e() != l0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar.a();
                    z4 = z5;
                } else {
                    m3.startViewTransition(view2);
                    j.b bVar = new j.b(animation, m3, view2);
                    z4 = z5;
                    bVar.setAnimationListener(new e(b5, m3, view2, kVar));
                    view2.startAnimation(bVar);
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + b5 + " has started.");
                    }
                }
                kVar.c().b(new f(view2, m3, kVar, b5));
                i3 = 2;
                z5 = z4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<l0.e, Boolean> x(List<m> list, List<l0.e> list2, boolean z3, l0.e eVar, l0.e eVar2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap hashMap;
        View view2;
        Object k3;
        androidx.collection.a aVar;
        ArrayList<View> arrayList3;
        l0.e eVar3;
        ArrayList<View> arrayList4;
        Rect rect;
        i0 i0Var;
        HashMap hashMap2;
        l0.e eVar4;
        View view3;
        View view4;
        View view5;
        boolean z4 = z3;
        l0.e eVar5 = eVar;
        l0.e eVar6 = eVar2;
        HashMap hashMap3 = new HashMap();
        i0 i0Var2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                i0 e3 = mVar.e();
                if (i0Var2 == null) {
                    i0Var2 = e3;
                } else if (e3 != null && i0Var2 != e3) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (i0Var2 == null) {
            for (m mVar2 : list) {
                hashMap3.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap3;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Iterator<m> it = list.iterator();
        Object obj3 = null;
        View view7 = null;
        boolean z5 = false;
        while (true) {
            str = "FragmentManager";
            if (!it.hasNext()) {
                break;
            }
            m next = it.next();
            if (!next.i() || eVar5 == null || eVar6 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                eVar3 = eVar5;
                arrayList4 = arrayList5;
                rect = rect2;
                i0Var = i0Var2;
                hashMap2 = hashMap3;
                View view8 = view6;
                eVar4 = eVar6;
                view3 = view8;
                view7 = view7;
            } else {
                Object u3 = i0Var2.u(i0Var2.f(next.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view9 = view7;
                int i3 = 0;
                while (i3 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                Fragment f3 = eVar.f();
                if (z4) {
                    f3.getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                } else {
                    f3.getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                }
                int i4 = 0;
                for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i4++;
                }
                if (w.I0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v("FragmentManager", "Name: " + it2.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v("FragmentManager", "Name: " + it3.next());
                    }
                }
                androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                u(aVar3, eVar.f().mView);
                aVar3.n(sharedElementSourceNames);
                aVar2.n(aVar3.keySet());
                androidx.collection.a<String, View> aVar4 = new androidx.collection.a<>();
                u(aVar4, eVar2.f().mView);
                aVar4.n(sharedElementTargetNames2);
                aVar4.n(aVar2.values());
                g0.c(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList6;
                    eVar3 = eVar5;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view6;
                    i0Var = i0Var2;
                    view7 = view9;
                    obj3 = null;
                    eVar4 = eVar2;
                    hashMap2 = hashMap3;
                } else {
                    g0.a(eVar2.f(), eVar.f(), z4, aVar3, true);
                    HashMap hashMap4 = hashMap3;
                    View view10 = view6;
                    aVar = aVar2;
                    ArrayList<View> arrayList8 = arrayList6;
                    androidx.core.view.k.a(m(), new g(eVar2, eVar, z3, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view7 = view9;
                    } else {
                        View view11 = (View) aVar3.get(sharedElementSourceNames.get(0));
                        i0Var2.p(u3, view11);
                        view7 = view11;
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = (View) aVar4.get(sharedElementTargetNames2.get(0))) == null) {
                        view4 = view10;
                    } else {
                        androidx.core.view.k.a(m(), new h(i0Var2, view5, rect2));
                        view4 = view10;
                        z5 = true;
                    }
                    i0Var2.s(u3, view4, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    i0Var = i0Var2;
                    i0Var2.n(u3, null, null, null, null, u3, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar3 = eVar;
                    hashMap2 = hashMap4;
                    hashMap2.put(eVar3, bool);
                    eVar4 = eVar2;
                    hashMap2.put(eVar4, bool);
                    obj3 = u3;
                }
            }
            eVar5 = eVar3;
            arrayList5 = arrayList4;
            rect2 = rect;
            hashMap3 = hashMap2;
            aVar2 = aVar;
            z4 = z3;
            arrayList6 = arrayList3;
            i0Var2 = i0Var;
            l0.e eVar7 = eVar4;
            view6 = view3;
            eVar6 = eVar7;
        }
        View view12 = view7;
        androidx.collection.a aVar5 = aVar2;
        ArrayList<View> arrayList9 = arrayList6;
        l0.e eVar8 = eVar5;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect3 = rect2;
        i0 i0Var3 = i0Var2;
        HashMap hashMap5 = hashMap3;
        View view13 = view6;
        l0.e eVar9 = eVar6;
        View view14 = view13;
        ArrayList arrayList11 = new ArrayList();
        Object obj4 = null;
        Object obj5 = null;
        for (m mVar3 : list) {
            if (mVar3.d()) {
                hashMap5.put(mVar3.b(), Boolean.FALSE);
                mVar3.a();
            } else {
                Object f4 = i0Var3.f(mVar3.h());
                l0.e b4 = mVar3.b();
                boolean z6 = obj3 != null && (b4 == eVar8 || b4 == eVar9);
                if (f4 == null) {
                    if (!z6) {
                        hashMap5.put(b4, Boolean.FALSE);
                        mVar3.a();
                    }
                    arrayList2 = arrayList9;
                    str3 = str;
                    arrayList = arrayList10;
                    view = view14;
                    k3 = obj4;
                    hashMap = hashMap5;
                    view2 = view12;
                } else {
                    str3 = str;
                    ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj6 = obj4;
                    t(arrayList12, b4.f().mView);
                    if (z6) {
                        if (b4 == eVar8) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        i0Var3.a(f4, view14);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view14;
                        obj2 = obj5;
                        hashMap = hashMap5;
                        obj = obj6;
                    } else {
                        i0Var3.b(f4, arrayList12);
                        view = view14;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        hashMap = hashMap5;
                        i0Var3.n(f4, f4, arrayList12, null, null, null, null);
                        if (b4.e() == l0.e.c.GONE) {
                            list2.remove(b4);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(b4.f().mView);
                            i0Var3.m(f4, b4.f().mView, arrayList13);
                            androidx.core.view.k.a(m(), new i(arrayList12));
                        }
                    }
                    if (b4.e() == l0.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z5) {
                            i0Var3.o(f4, rect3);
                        }
                        view2 = view12;
                    } else {
                        view2 = view12;
                        i0Var3.p(f4, view2);
                    }
                    hashMap.put(b4, Boolean.TRUE);
                    if (mVar3.j()) {
                        obj5 = i0Var3.k(obj2, f4, null);
                        k3 = obj;
                    } else {
                        k3 = i0Var3.k(obj, f4, null);
                        obj5 = obj2;
                    }
                }
                eVar9 = eVar2;
                hashMap5 = hashMap;
                obj4 = k3;
                view12 = view2;
                str = str3;
                view14 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        String str4 = str;
        ArrayList<View> arrayList15 = arrayList10;
        HashMap hashMap6 = hashMap5;
        Object j3 = i0Var3.j(obj5, obj4, obj3);
        if (j3 == null) {
            return hashMap6;
        }
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object h3 = mVar4.h();
                l0.e b5 = mVar4.b();
                HashMap hashMap7 = hashMap6;
                boolean z7 = obj3 != null && (b5 == eVar8 || b5 == eVar2);
                if (h3 == null && !z7) {
                    str2 = str4;
                } else if (androidx.core.view.n.j(m())) {
                    str2 = str4;
                    i0Var3.q(mVar4.b().f(), j3, mVar4.c(), new j(mVar4, b5));
                } else {
                    if (w.I0(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b5);
                    } else {
                        str2 = str4;
                    }
                    mVar4.a();
                }
                hashMap6 = hashMap7;
                str4 = str2;
            }
        }
        HashMap hashMap8 = hashMap6;
        String str5 = str4;
        if (!androidx.core.view.n.j(m())) {
            return hashMap8;
        }
        g0.d(arrayList11, 4);
        ArrayList<String> l3 = i0Var3.l(arrayList14);
        if (w.I0(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it4 = arrayList15.iterator();
            while (it4.hasNext()) {
                View next2 = it4.next();
                Log.v(str5, "View: " + next2 + " Name: " + androidx.core.view.n.h(next2));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it5 = arrayList14.iterator();
            while (it5.hasNext()) {
                View next3 = it5.next();
                Log.v(str5, "View: " + next3 + " Name: " + androidx.core.view.n.h(next3));
            }
        }
        i0Var3.c(m(), j3);
        i0Var3.r(m(), arrayList15, arrayList14, l3, aVar5);
        g0.d(arrayList11, 0);
        i0Var3.t(obj3, arrayList15, arrayList14);
        return hashMap8;
    }

    private void y(List<l0.e> list) {
        Fragment f3 = list.get(list.size() - 1).f();
        for (l0.e eVar : list) {
            eVar.f().mAnimationInfo.f935c = f3.mAnimationInfo.f935c;
            eVar.f().mAnimationInfo.f936d = f3.mAnimationInfo.f936d;
            eVar.f().mAnimationInfo.f937e = f3.mAnimationInfo.f937e;
            eVar.f().mAnimationInfo.f938f = f3.mAnimationInfo.f938f;
        }
    }

    @Override // androidx.fragment.app.l0
    void f(List<l0.e> list, boolean z3) {
        l0.e eVar = null;
        l0.e eVar2 = null;
        for (l0.e eVar3 : list) {
            l0.e.c c3 = l0.e.c.c(eVar3.f().mView);
            int i3 = a.f992a[eVar3.e().ordinal()];
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                if (c3 == l0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i3 == 4 && c3 != l0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        if (w.I0(2)) {
            Log.v("FragmentManager", "Executing operations from " + eVar + " to " + eVar2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        y(list);
        for (l0.e eVar4 : list) {
            androidx.core.os.f fVar = new androidx.core.os.f();
            eVar4.j(fVar);
            arrayList.add(new k(eVar4, fVar, z3));
            androidx.core.os.f fVar2 = new androidx.core.os.f();
            eVar4.j(fVar2);
            boolean z4 = false;
            if (z3) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, fVar2, z3, z4));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z4 = true;
                arrayList2.add(new m(eVar4, fVar2, z3, z4));
                eVar4.a(new b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, fVar2, z3, z4));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z4 = true;
                arrayList2.add(new m(eVar4, fVar2, z3, z4));
                eVar4.a(new b(arrayList3, eVar4));
            }
        }
        Map<l0.e, Boolean> x3 = x(arrayList2, arrayList3, z3, eVar, eVar2);
        w(arrayList, arrayList3, x3.containsValue(Boolean.TRUE), x3);
        Iterator<l0.e> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
        if (w.I0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + eVar + " to " + eVar2);
        }
    }

    void s(l0.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (androidx.core.view.d0.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, View view) {
        String h3 = androidx.core.view.n.h(view);
        if (h3 != null) {
            map.put(h3, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(androidx.collection.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.n.h(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
